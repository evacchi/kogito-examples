package com.myspace.demo;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.kie.api.runtime.process.WorkItemNotFoundException;
import org.kie.submarine.process.Process;
import org.kie.submarine.process.ProcessInstance;
import org.kie.submarine.process.WorkItem;
import com.myspace.demo.OrdersModel;

@Path("/orders")
@Api(description = "Deals with orders created by customer")
public class OrdersResource {

    @javax.inject.Inject()
    @javax.inject.Named("demo.orders")
    Process<OrdersModel> process;

    @POST()
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation("Creates new instance of orders")
    public OrdersModel createResource(@ApiParam(value = "orders data that should be created") OrdersModel resource) {
        if (resource == null) {
            resource = new OrdersModel();
        }
        ProcessInstance<OrdersModel> pi = process.createInstance(resource);
        pi.start();
        return pi.variables();
    }

    @GET()
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation("Returns a list of orders")
    public List<OrdersModel> getResources() {
        return process.instances().values().stream().map(ProcessInstance::variables).collect(Collectors.toList());
    }

    @GET()
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation("Returns information about specified orders")
    public OrdersModel getResource(@PathParam("id") Long id) {
        return process.instances().findById(id).map(ProcessInstance::variables).orElse(null);
    }

    @DELETE()
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation("Cancels specified orders")
    public OrdersModel deleteResource(@PathParam("id") Long id) {
        ProcessInstance<OrdersModel> pi = process.instances().findById(id).orElse(null);
        if (pi == null) {
            return null;
        } else {
            pi.abort();
            return pi.variables();
        }
    }

    @GET()
    @Path("/{id}/tasks")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation("Returns list of task ids that are currently active in given orders")
    public Map<Long, String> getTasks(@PathParam("id") Long id) {
        return process.instances().findById(id).map(ProcessInstance::workItems).map(l -> l.stream().collect(Collectors.toMap(WorkItem::getId, WorkItem::getName))).orElse(null);
    }
}

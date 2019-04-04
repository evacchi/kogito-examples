package com.myspace.demo;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
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
import org.kie.submarine.process.Process;
import org.kie.submarine.process.ProcessInstance;

@Path("/orders")
@Api("Deals with orders created by customer")
public class OrdersResource2 {

    @Inject
    Process<OrdersModel> process;
    
    @POST()
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation("Creates new instance of orders")
    public OrdersModel createResource(OrdersModel resource) {
        if (resource == null) {
            resource = new OrdersModel();
        }

        process.createInstance(resource).start();
        return resource;
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
}

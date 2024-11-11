package ch.zli.m223.controller;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/secure")
public class SecureController {

    @GET
    @Path("/admin")
    @RolesAllowed("Admin")
    public Response getSecureData() {
        return Response.ok("This is admin data.").build();
    }

    @GET
    @Path("/user")
    @RolesAllowed("User")
    public Response getUserData() {
        return Response.ok("This is user data.").build();
    }

    @GET
    @Path("/all")
    public Response getAllData() {
        return Response.ok("This is public data.").build();
    }
}
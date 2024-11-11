package ch.zli.m223.controller;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import io.smallrye.jwt.build.Jwt;
import java.util.Arrays;
import java.util.HashSet;

@Path("/auth")
public class AuthController {

    @POST
    @Path("/token")
    public Response generateToken() {
        try {
            String token = Jwt.issuer("https://example.com/issuer")
                    .upn("jdoe@quarkus.io")
                    .groups(new HashSet<>(Arrays.asList("User", "Admin")))
                    .sign();

            return Response.ok(token).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
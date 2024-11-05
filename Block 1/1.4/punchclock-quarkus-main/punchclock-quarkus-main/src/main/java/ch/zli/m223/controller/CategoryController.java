package ch.zli.m223.controller;

import ch.zli.m223.model.Category;
import ch.zli.m223.service.CategoryService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/categories")
public class CategoryController {

    @Inject
    CategoryService categoryService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Category> index() {
        return categoryService.findAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Category create(Category category) {
        return categoryService.createCategory(category);
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Category update(@PathParam("id") Long id, Category category) {
        return categoryService.updateCategory(id, category);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") Long id) {
        categoryService.deleteCategory(id);
    }
}
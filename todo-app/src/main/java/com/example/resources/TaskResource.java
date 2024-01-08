package com.example.resources;

import java.util.List;

import com.codahale.metrics.annotation.Timed;

import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.PATCH;
import jakarta.validation.Valid;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import com.example.core.Task;
import com.example.db.TaskDAO;

@Path("/tasks")
@Produces(MediaType.APPLICATION_JSON)
public class TaskResource {
    private final TaskDAO taskDAO;

    public TaskResource(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    @Path("/todo")
    @GET
    @Timed
    @UnitOfWork
    public List<Task> getAllTodoTasks() {
        return taskDAO.getAllTasks("TODO");
    }

    @Path("/wip")
    @GET
    @Timed
    @UnitOfWork
    public List<Task> getAllWIPTasks() {
        return taskDAO.getAllTasks("WIP");
    }

    @Path("/create")
    @POST
    @Timed
    @UnitOfWork
    public String createTask(@Valid Task t) {
        return taskDAO.createTask(t);
    }

    @Path("/delete/{id}")
    @DELETE
    @Timed
    @UnitOfWork
    public String deleteTask(@PathParam("id") long id) {
        return taskDAO.deleteById(id);
    }

    @Path("/{id}")
    @GET
    @Timed
    @UnitOfWork
    public Task getById(@PathParam("id") long id) {
        return taskDAO.getById(id);
    }

    @Path("/modify")
    @PATCH
    @Timed
    @UnitOfWork
    public void modifyTask(@Valid Task t) {
        if (t.getTaskId() != 0) {
            taskDAO.modifyTask(t);
        }
    }
}

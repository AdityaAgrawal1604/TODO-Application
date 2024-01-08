package com.example.db;

import org.hibernate.SessionFactory;

import io.dropwizard.hibernate.AbstractDAO;
import com.example.core.Task;
import java.util.List;

public class TaskDAO extends AbstractDAO<Task> {

    public TaskDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
        // TODO Auto-generated constructor stub
    }

    public List<Task> getAllTasks(String status) {
        return list(namedTypedQuery("com.example.core.Task.getAllTasks").setParameter("status", status));
    }

    public String createTask(Task t) {
        currentSession().persist(t);
        long id = t.getTaskId();
        String cr = "Task created successfully with Id : %s";
        return String.format(cr, id);
    }

    public Task getById(long id) {
        return get(id);
    }

    public String deleteById(long id) {
        if (get(id) == null) {
            String ret = "No task with id %s found for deletion!";
            return String.format(ret, id);
        }
        currentSession().remove(get(id));
        String cr = "Task deleted successfully with Id : %s";
        return String.format(cr, id);
    }

    public void modifyTask(Task t) {
        Task cr = get(t.getTaskId());
        if (cr != null) {
            if (t.getTitle() != null) {
                cr.setTitle(t.getTitle());
            }
            if (t.getDescription() != null) {
                cr.setDescription(t.getDescription());
            }
            if (t.getStartDate() != null) {
                cr.setStartDate(t.getStartDate());
            }
            if (t.getEndDate() != null) {
                cr.setEndDate(t.getEndDate());
            }
            if (t.getStatus() != null) {
                cr.setStatus(t.getStatus());
            }
        }
        currentSession().merge(cr);
    }
}

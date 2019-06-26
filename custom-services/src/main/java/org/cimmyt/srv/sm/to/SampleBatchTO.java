package org.cimmyt.srv.sm.to;

import java.util.Set;

public class SampleBatchTO {
    private int id;
    private String description;
    private Set<RequestTO> requests;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<RequestTO> getRequests() {
        return requests;
    }

    public void setRequests(Set<RequestTO> requests) {
        this.requests = requests;
    }
}

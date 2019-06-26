package org.cimmyt.srv.common.to;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseStatusMessage {

    @JsonProperty("REQUEST_STATUS")
    String requestStatus;

    enum code{
        SUCCESSFUL
    }

    public ResponseStatusMessage() {
        this.requestStatus = code.SUCCESSFUL.toString();
    }

    public ResponseStatusMessage(String REQUEST_STATUS) {
        this.requestStatus = REQUEST_STATUS;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }
}

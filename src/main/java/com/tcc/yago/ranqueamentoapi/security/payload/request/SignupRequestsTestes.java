package com.tcc.yago.ranqueamentoapi.security.payload.request;

import jakarta.validation.Valid;

import java.util.List;

public class SignupRequestsTestes {
    @Valid
    private List<SignupRequest> requests;

    // Getters e setters
    public List<SignupRequest> getRequests() {
        return requests;
    }

    public void setRequests(List<SignupRequest> requests) {
        this.requests = requests;
    }
}

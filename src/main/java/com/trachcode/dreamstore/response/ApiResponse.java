package com.trachcode.dreamstore.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

// will return data to the front-end

@Setter
@Getter
public class ApiResponse {
    private String message;
    private Object data;
    public ApiResponse(String message, Object data) {
        this.message = message;
        this.data = data;
    }

}

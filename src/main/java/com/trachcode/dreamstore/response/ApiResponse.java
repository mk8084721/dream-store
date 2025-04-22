package com.trachcode.dreamstore.response;

import lombok.AllArgsConstructor;
import lombok.Data;

// will return data to the front-end
@AllArgsConstructor
@Data
public class ApiResponse {
    private String message;
    private Object data;
}

package com.security.authapi.controllers;

import com.security.authapi.constants.SimpleStatus;
import com.security.authapi.services.ConstantsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("/api/constants")
@RestController
@AllArgsConstructor
public class ConstantsController {
    private ConstantsService constantsService;

    @GetMapping()
    public Map<String, List<SimpleStatus>> getOrderConstants() {
        return constantsService.getOrderConstants();

    }
}

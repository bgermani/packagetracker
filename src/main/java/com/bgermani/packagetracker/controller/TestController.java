package com.bgermani.packagetracker.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bgermani.packagetracker.concurrency.PackageFetchExecutor;

@RestController
public class TestController {
    @Autowired
    PackageFetchExecutor demoExecutor;

    /*
     * Test ShippingService calls
     */
    @GetMapping("/testing")
    String triggerMessage() throws IOException, InterruptedException {
        PackageFetchExecutor.run();
        return "test okay";
    }
}

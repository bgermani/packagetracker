package com.bgermani.packagetracker.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.bgermani.packagetracker.model.PackageStatus;

public class PackageFetchRunnable implements Runnable {
    @Autowired
    ShippingService shippingService;

    @Autowired
    InternalActionService internalActionService;

    private String name = null;

    public PackageFetchRunnable(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public void run() {
        try {
            shippingService.fetchStatus("packageNumber");
            internalActionService.perform("packageNumber", PackageStatus.PICKED_UP);
            // Update Package and PackageFetchAttempt tables
        } catch (Exception e) {
            // Update PackageFetchAttempt table
            e.printStackTrace();
        }
        System.out.println("Executing :" + name);
    }
}

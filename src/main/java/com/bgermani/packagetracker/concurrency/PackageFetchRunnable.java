package com.bgermani.packagetracker.concurrency;

import org.springframework.beans.factory.annotation.Autowired;

import com.bgermani.packagetracker.model.PackageStatus;
import com.bgermani.packagetracker.service.InternalActionService;
import com.bgermani.packagetracker.service.ShippingService;

public class PackageFetchRunnable implements Runnable {
    @Autowired
    ShippingService shippingService;

    @Autowired
    InternalActionService internalActionService;

    private String packageNumber = null;

    public PackageFetchRunnable(String packageNumber) {
        this.packageNumber = packageNumber;
    }

    @Override
    public void run() {
        try {
            PackageStatus currentStatus = shippingService.fetchStatus(packageNumber);
            internalActionService.perform(packageNumber, currentStatus);
            // Update Package and PackageFetchAttempt tables
        } catch (Exception e) {
            // Update PackageFetchAttempt table
            e.printStackTrace();
        }
    }
}

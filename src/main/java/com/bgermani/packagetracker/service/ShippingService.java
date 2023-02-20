package com.bgermani.packagetracker.service;

import java.io.IOException;

import com.bgermani.packagetracker.model.PackageStatus;

public interface ShippingService {
    /**
     * Returns the status of a shipment package
     *
     * @param packageNumber the id of the package in question
     * @throws IOException on issues with connecting to external service.
     * @return detected status
     */
    PackageStatus fetchStatus(String packageNumber) throws IOException;
}

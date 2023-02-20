package com.bgermani.packagetracker.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.bgermani.packagetracker.model.PackageStatus;

@Service
public class ShippingServiceImpl implements ShippingService {

    @Override
    public PackageStatus fetchStatus(String packageNumber) throws IOException {
        // Call external service
        System.out.println(PackageStatus.HANDED_IN);
        return PackageStatus.HANDED_IN;
    }
}

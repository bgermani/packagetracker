package com.bgermani.packagetracker.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import org.springframework.stereotype.Service;

import com.bgermani.packagetracker.model.PackageStatus;

@Service
public class InternalActionServiceImpl implements InternalActionService {

    @Override
    public Future<Boolean> perform(String packageNumber, PackageStatus status) throws Exception {
        switch (status) {
            case INITIATED:
                System.out.println("Performing hypothetical action for status INITIATED");
                return CompletableFuture.completedFuture(true);
            case HANDED_IN:
                System.out.println("Performing hypothetical action for status HANDED_IN");
                return CompletableFuture.completedFuture(true);
            case IN_TRANSIT:
                System.out.println("Performing hypothetical action for status IN_TRANSIT");
                return CompletableFuture.completedFuture(true);
            case READY_FOR_PICK_UP:
                System.out.println("Performing hypothetical action for status READY_FOR_PICK_UP");
                return CompletableFuture.completedFuture(true);
            case PICKED_UP:
                System.out.println("Performing hypothetical action for status PICKED_UP");
                return CompletableFuture.completedFuture(true);
        }
        //TODO deal with service failure
        return CompletableFuture.completedFuture(false);
    }
}

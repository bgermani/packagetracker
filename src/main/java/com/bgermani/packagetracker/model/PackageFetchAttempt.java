package com.bgermani.packagetracker.model;

import java.util.Date;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class PackageFetchAttempt {
    @Id
	@GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String packageNumber;

    private PackageStatus currentStatus;

    private Boolean successful;

    private Date checkedAt;
    

    public String getId() {
        return id;
    }

    public String getPackageNumber() {
        return packageNumber;
    }

    public void setPackageNumber(String packageNumber) {
        this.packageNumber = packageNumber;
    }

    public PackageStatus getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(PackageStatus currentStatus) {
        this.currentStatus = currentStatus;
    }

    public Boolean getSuccessful() {
        return successful;
    }

    public void setSuccessful(Boolean successful) {
        this.successful = successful;
    }

    public Date getCheckedAt() {
        return checkedAt;
    }

    public void setCheckedAt(Date checkedAt) {
        this.checkedAt = checkedAt;
    }


}

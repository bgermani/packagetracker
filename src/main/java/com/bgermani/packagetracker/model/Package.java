package com.bgermani.packagetracker.model;

import java.util.Date;

import jakarta.persistence.Id;

public class Package {
    @Id
    private String packageNumber;

    private PackageStatus currentStatus;

    private Date checkedAt;

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

    public Date getCheckedAt() {
        return checkedAt;
    }

    public void setCheckedAt(Date checkedAt) {
        this.checkedAt = checkedAt;
    }

    public Package(String packageNumber, PackageStatus currentStatus, Date checkedAt) {
        this.packageNumber = packageNumber;
        this.currentStatus = currentStatus;
        this.checkedAt = checkedAt;
    }

    @Override
    public String toString() {
        return "Package [packageNumber=" + packageNumber + ", currentStatus=" + currentStatus
                + ", checkedAt=" + checkedAt + "]";
    }
}

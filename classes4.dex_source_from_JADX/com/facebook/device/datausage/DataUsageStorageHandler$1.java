package com.facebook.device.datausage;

import com.facebook.device.resourcemonitor.DataUsageBytes;
import java.util.Date;

/* compiled from: today_unit_update */
class DataUsageStorageHandler$1 implements Runnable {
    final /* synthetic */ DataUsageBytes f928a;
    final /* synthetic */ Date f929b;
    final /* synthetic */ int f930c;
    final /* synthetic */ DataUsageStorageHandler f931d;

    DataUsageStorageHandler$1(DataUsageStorageHandler dataUsageStorageHandler, DataUsageBytes dataUsageBytes, Date date, int i) {
        this.f931d = dataUsageStorageHandler;
        this.f928a = dataUsageBytes;
        this.f929b = date;
        this.f930c = i;
    }

    public void run() {
        this.f931d.b.a(this.f928a, this.f929b, this.f930c);
    }
}

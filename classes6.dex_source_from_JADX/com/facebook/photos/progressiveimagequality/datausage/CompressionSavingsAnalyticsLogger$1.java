package com.facebook.photos.progressiveimagequality.datausage;

import com.facebook.device.datausage.DataUsageStorageHandler;
import com.facebook.device.datausage.DataUsageSyncer;
import com.facebook.device.datausage.SqlUtils;
import com.facebook.device.resourcemonitor.DataUsageBytes;
import java.util.Date;

/* compiled from: subscribed_event_take_negative_action */
class CompressionSavingsAnalyticsLogger$1 implements Runnable {
    final /* synthetic */ Date f3866a;
    final /* synthetic */ long f3867b;
    final /* synthetic */ CompressionSavingsAnalyticsLogger f3868c;

    CompressionSavingsAnalyticsLogger$1(CompressionSavingsAnalyticsLogger compressionSavingsAnalyticsLogger, Date date, long j) {
        this.f3868c = compressionSavingsAnalyticsLogger;
        this.f3866a = date;
        this.f3867b = j;
    }

    public void run() {
        DataUsageSyncer dataUsageSyncer = this.f3868c.b;
        Date date = this.f3866a;
        DataUsageStorageHandler dataUsageStorageHandler = dataUsageSyncer.a;
        String b = dataUsageStorageHandler.b(1);
        DataUsageBytes dataUsageBytes = new DataUsageBytes(0, 0);
        if (b != null && b.equals(SqlUtils.a(date))) {
            dataUsageBytes = dataUsageBytes.b(dataUsageStorageHandler.c.a(1));
        }
        if (dataUsageStorageHandler.b.a(date, 1) != null) {
            dataUsageBytes = dataUsageBytes.b(dataUsageStorageHandler.b.a(date, 1));
        }
        CompressionSavingsAnalyticsLogger.a(this.f3868c, this.f3867b, dataUsageBytes, this.f3866a);
    }
}

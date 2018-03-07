package com.facebook.bookmark.service.handler;

import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.BlueServiceHandler.Filter;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.performancelogger.PerformanceLogger;

/* compiled from: receiver_status */
public class BoomarkPerfMonitor implements Filter {
    private final PerformanceLogger f5694a;

    public BoomarkPerfMonitor(PerformanceLogger performanceLogger) {
        this.f5694a = performanceLogger;
    }

    public final OperationResult m5916a(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        this.f5694a.d(2621441, operationParams.b);
        OperationResult a = blueServiceHandler.a(operationParams);
        this.f5694a.c(2621441, operationParams.b);
        return a;
    }
}

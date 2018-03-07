package com.facebook.bugreporter.scheduler;

import com.facebook.common.init.INeedInit;
import javax.inject.Inject;

/* compiled from: ispx_codec_switch_enabled */
public class BugReportRetryInitializer implements INeedInit {
    private final BugReportRetryScheduler f9767a;

    @Inject
    public BugReportRetryInitializer(BugReportRetryScheduler bugReportRetryScheduler) {
        this.f9767a = bugReportRetryScheduler;
    }

    public void init() {
        this.f9767a.m10194a(60);
    }
}

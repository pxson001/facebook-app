package com.facebook.common.diagnostics;

/* compiled from: stored_balance_status */
class LogcatFbSdcardLogger$3 implements Runnable {
    final /* synthetic */ LogcatFbSdcardLogger f2520a;

    LogcatFbSdcardLogger$3(LogcatFbSdcardLogger logcatFbSdcardLogger) {
        this.f2520a = logcatFbSdcardLogger;
    }

    public void run() {
        try {
            LogcatFbSdcardLogger.e(this.f2520a);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}

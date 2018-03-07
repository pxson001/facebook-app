package com.facebook.common.errorreporting;

import com.facebook.acra.ErrorReporter;
import com.facebook.acra.LogBridge;
import com.facebook.debug.log.BLog;

/* compiled from: user_call_to_actions */
public class AcraBLogBridge implements LogBridge {
    public void log(String str, String str2, Throwable th) {
        BLog.b(str, str2, th);
    }

    public static void m2799a() {
        ErrorReporter.getInstance().setLogBridge(new AcraBLogBridge());
    }
}

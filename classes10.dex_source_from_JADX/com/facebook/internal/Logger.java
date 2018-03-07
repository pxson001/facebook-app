package com.facebook.internal;

import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import java.util.HashMap;
import java.util.Map.Entry;

/* compiled from: SEND_SKIPPED_DYNAMIC_PRICING_ENABLED */
public class Logger {
    private static final HashMap<String, String> f24006a = new HashMap();
    public final LoggingBehavior f24007b;
    public final String f24008c;
    private StringBuilder f24009d;
    public int f24010e = 3;

    private static synchronized void m25278a(String str, String str2) {
        synchronized (Logger.class) {
            f24006a.put(str, str2);
        }
    }

    public static synchronized void m25277a(String str) {
        synchronized (Logger.class) {
            if (!FacebookSdk.m14047a(LoggingBehavior.INCLUDE_ACCESS_TOKENS)) {
                m25278a(str, "ACCESS_TOKEN_REMOVED");
            }
        }
    }

    public static void m25275a(LoggingBehavior loggingBehavior, String str, String str2) {
        m25274a(loggingBehavior, 3, str, str2);
    }

    public static void m25276a(LoggingBehavior loggingBehavior, String str, String str2, Object... objArr) {
        if (FacebookSdk.m14047a(loggingBehavior)) {
            m25274a(loggingBehavior, 3, str, String.format(str2, objArr));
        }
    }

    public static void m25274a(LoggingBehavior loggingBehavior, int i, String str, String str2) {
        if (FacebookSdk.m14047a(loggingBehavior)) {
            String c = m25281c(str2);
            if (!str.startsWith("FacebookSDK.")) {
                str = "FacebookSDK." + str;
            }
            Log.println(i, str, c);
            if (loggingBehavior == LoggingBehavior.DEVELOPER_ERRORS) {
                new Exception().printStackTrace();
            }
        }
    }

    private static synchronized String m25281c(String str) {
        synchronized (Logger.class) {
            for (Entry entry : f24006a.entrySet()) {
                str = str.replace((CharSequence) entry.getKey(), (CharSequence) entry.getValue());
            }
        }
        return str;
    }

    public Logger(LoggingBehavior loggingBehavior, String str) {
        Validate.m25367a(str, "tag");
        this.f24007b = loggingBehavior;
        this.f24008c = "FacebookSDK." + str;
        this.f24009d = new StringBuilder();
    }

    public final void m25282a() {
        m25274a(this.f24007b, this.f24010e, this.f24008c, this.f24009d.toString());
        this.f24009d = new StringBuilder();
    }

    public final void m25284b(String str) {
        if (m25280b()) {
            this.f24009d.append(str);
        }
    }

    private void m25279a(String str, Object... objArr) {
        if (m25280b()) {
            this.f24009d.append(String.format(str, objArr));
        }
    }

    public final void m25283a(String str, Object obj) {
        m25279a("  %s:\t%s\n", str, obj);
    }

    private boolean m25280b() {
        return FacebookSdk.m14047a(this.f24007b);
    }
}

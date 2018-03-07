package com.facebook.backstage.app;

import com.facebook.backstage.nub.BackstageEventListener$EventType;
import com.facebook.backstage.nub.BackstageService.C05661;
import com.facebook.debug.log.BLog;
import java.lang.Thread.UncaughtExceptionHandler;

/* compiled from: sectionPositions */
public class BackstageUnhandledExceptionHandler implements UncaughtExceptionHandler {
    public static final String f4303a = BackstageUnhandledExceptionHandler.class.getSimpleName();
    public UncaughtExceptionHandler f4304b = Thread.getDefaultUncaughtExceptionHandler();
    public C05661 f4305c;

    public BackstageUnhandledExceptionHandler(C05661 c05661) {
        this.f4305c = c05661;
        if (this.f4304b != this) {
            Thread.setDefaultUncaughtExceptionHandler(this);
        } else {
            BLog.b(f4303a, "Default handler is already replaced");
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        if (this.f4305c != null) {
            this.f4305c.m5624a(BackstageEventListener$EventType.ACTION_HIDE);
        } else {
            BLog.b(f4303a, "Event Listener not found while handling uncaughtException.", th);
        }
        if (this.f4304b != this) {
            this.f4304b.uncaughtException(thread, th);
            Thread.setDefaultUncaughtExceptionHandler(this.f4304b);
            return;
        }
        BLog.b(f4303a, "Default handler is lost. Can't delegate uncaughtException", th);
    }
}

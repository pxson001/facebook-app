package com.facebook.strictmode;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.debug.log.BLog;
import com.facebook.strictmode.setter.Policy.All;
import java.util.Random;

/* compiled from: No zombies were found because debug info was not available */
public class StrictModeAggregator {
    public static int f12981a = 100;
    private static boolean f12982b = true;
    private static boolean f12983c = false;
    private AbstractFbErrorReporter f12984d;
    private final Random f12985e;

    /* compiled from: No zombies were found because debug info was not available */
    public class ReportableImpl {
        public final AbstractFbErrorReporter f12979a;
        public final Random f12980b;

        public ReportableImpl(AbstractFbErrorReporter abstractFbErrorReporter, Random random) {
            this.f12979a = abstractFbErrorReporter;
            this.f12980b = random;
        }
    }

    public StrictModeAggregator(AbstractFbErrorReporter abstractFbErrorReporter, Random random) {
        this.f12984d = abstractFbErrorReporter;
        this.f12985e = random;
    }

    public final boolean m13703a() {
        if (!f12982b) {
            return false;
        }
        if (f12983c) {
            return true;
        }
        StrictModeHelper.m13705a(All.DetectAll, All.PenaltyLog);
        try {
            ActivityManagerProxifier.m13702a(true, new ReportableImpl(this.f12984d, this.f12985e));
            f12983c = true;
            return true;
        } catch (StrictModeNotSupportedException e) {
            BLog.b(StrictModeAggregator.class, "Failed to start StrictModeAggregator");
            return false;
        }
    }
}

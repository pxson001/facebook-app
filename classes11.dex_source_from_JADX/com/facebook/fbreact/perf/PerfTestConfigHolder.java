package com.facebook.fbreact.perf;

import com.facebook.common.perftest.DrawFrameLogger;
import com.facebook.common.perftest.PerfTestConfig;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.ui.choreographer.NoDIPassThruChoreographerWrapper;

/* compiled from: error_phone_number_submit */
public class PerfTestConfigHolder {
    public static final PerfTestConfig f7461a = new PerfTestConfig();
    private static DrawFrameLogger f7462b;

    public static DrawFrameLogger m8639a() {
        UiThreadUtil.b();
        if (f7462b == null) {
            f7462b = new DrawFrameLogger(f7461a, new NoDIPassThruChoreographerWrapper());
        }
        return f7462b;
    }
}

package com.facebook.widget.listview;

import com.facebook.common.perftest.DrawFrameLogger;
import com.facebook.common.perftest.PerfTestConfig;
import com.facebook.common.perftest.base.PerfTestConfigBase;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: pubandwait */
public class ScrollPerfHelper {
    private final DrawFrameLogger f4046a;

    @Inject
    public ScrollPerfHelper(DrawFrameLogger drawFrameLogger, PerfTestConfig perfTestConfig) {
        Preconditions.checkArgument(PerfTestConfigBase.a());
        this.f4046a = drawFrameLogger;
    }

    public final void m4584a(int i) {
        switch (i) {
            case 0:
                this.f4046a.m4591b();
                return;
            case 1:
            case 2:
                this.f4046a.m4590a();
                return;
            default:
                return;
        }
    }
}

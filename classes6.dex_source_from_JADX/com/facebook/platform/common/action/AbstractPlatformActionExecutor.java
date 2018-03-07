package com.facebook.platform.common.action;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.platform.common.activity.PlatformIntentDemuxer;

/* compiled from: streets */
public class AbstractPlatformActionExecutor {
    private PlatformIntentDemuxer f3999a;

    public final void m5904a(PlatformIntentDemuxer platformIntentDemuxer) {
        this.f3999a = platformIntentDemuxer;
    }

    public void m5903a(Bundle bundle) {
    }

    public void m5901a() {
    }

    public void m5905b(Bundle bundle) {
    }

    public void m5902a(int i, int i2, Intent intent) {
    }

    public final void m5906c(Bundle bundle) {
        if (this.f3999a != null) {
            this.f3999a.m5959b(bundle);
        }
    }

    public final void m5907d(Bundle bundle) {
        if (this.f3999a != null) {
            this.f3999a.m5957a(bundle);
        }
    }
}

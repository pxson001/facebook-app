package com.facebook.http.blendedvip;

import android.annotation.SuppressLint;
import com.facebook.common.time.MonotonicClock;
import com.facebook.http.common.FbHttpRequest;
import com.facebook.http.common.HttpRequestFilter;
import com.facebook.http.qe.ExperimentsForHttpQeModule;
import com.facebook.qe.api.QeAccessor;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.inject.Inject;
import org.apache.http.impl.client.RequestWrapper;

/* compiled from: register_push */
public class BlendedVipHttpFilter implements HttpRequestFilter {
    public static final long f7781a = TimeUnit.HOURS.toMillis(1);
    public final MonotonicClock f7782b;
    public final QeAccessor f7783c;
    public VipRewriteConfig f7784d;

    @Inject
    public BlendedVipHttpFilter(MonotonicClock monotonicClock, QeAccessor qeAccessor) {
        this.f7782b = monotonicClock;
        this.f7783c = qeAccessor;
    }

    @SuppressLint({"DeprecatedClass"})
    public final void mo1680a(RequestWrapper requestWrapper, FbHttpRequest fbHttpRequest) {
        if (this.f7784d == null || this.f7782b.now() - this.f7784d.f11988b > f7781a) {
            ImmutableList immutableList;
            String a = this.f7783c.mo581a(ExperimentsForHttpQeModule.f2754w, null);
            boolean a2 = this.f7783c.mo596a(ExperimentsForHttpQeModule.f2753v, false);
            long now = this.f7782b.now();
            Pattern compile = Pattern.compile(this.f7783c.mo581a(ExperimentsForHttpQeModule.f2709D, "x{100}"));
            String a3 = this.f7783c.mo581a(ExperimentsForHttpQeModule.f2708C, "");
            if (a == null) {
                immutableList = RegularImmutableList.f535a;
            } else {
                immutableList = ImmutableList.copyOf(a.split(","));
            }
            this.f7784d = new VipRewriteConfig(a2, now, compile, a3, immutableList);
        }
        VipRewriter.m17683a(requestWrapper, fbHttpRequest, this.f7784d);
    }

    public final int mo1679a() {
        return 2147483646;
    }
}

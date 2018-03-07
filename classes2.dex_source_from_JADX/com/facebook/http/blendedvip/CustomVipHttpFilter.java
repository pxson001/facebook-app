package com.facebook.http.blendedvip;

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

/* compiled from: registerPush */
public class CustomVipHttpFilter implements HttpRequestFilter {
    public static final long f7785a = TimeUnit.HOURS.toMillis(1);
    public final QeAccessor f7786b;
    public final MonotonicClock f7787c;
    public VipRewriteConfig f7788d;

    @Inject
    public CustomVipHttpFilter(QeAccessor qeAccessor, MonotonicClock monotonicClock) {
        this.f7786b = qeAccessor;
        this.f7787c = monotonicClock;
    }

    public final void mo1680a(RequestWrapper requestWrapper, FbHttpRequest fbHttpRequest) {
        if (this.f7788d == null || this.f7787c.now() - this.f7788d.f11988b > f7785a) {
            ImmutableList immutableList;
            String a = this.f7786b.mo581a(ExperimentsForHttpQeModule.f2727V, null);
            boolean a2 = this.f7786b.mo596a(ExperimentsForHttpQeModule.f2726U, false);
            long now = this.f7787c.now();
            Pattern compile = Pattern.compile(this.f7786b.mo581a(ExperimentsForHttpQeModule.f2729X, "x{100}"));
            String a3 = this.f7786b.mo581a(ExperimentsForHttpQeModule.f2728W, "");
            if (a == null) {
                immutableList = RegularImmutableList.f535a;
            } else {
                immutableList = ImmutableList.copyOf(a.split(","));
            }
            this.f7788d = new VipRewriteConfig(a2, now, compile, a3, immutableList);
        }
        VipRewriter.m17683a(requestWrapper, fbHttpRequest, this.f7788d);
    }

    public final int mo1679a() {
        return Integer.MAX_VALUE;
    }
}

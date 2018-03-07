package com.facebook.video.abtest;

import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;

/* compiled from: schoolHubId */
public class Video360DashConfig {
    public final String f5274a;
    public final String f5275b;
    public final boolean f5276c;
    public final int f5277d;
    public final int f5278e;

    public Video360DashConfig(Video360PlayerConfig video360PlayerConfig, QeAccessor qeAccessor) {
        ExposureLogging exposureLogging = video360PlayerConfig.c() ? ExposureLogging.On : ExposureLogging.Off;
        this.f5274a = qeAccessor.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForVideoAbTestModule.L, "");
        this.f5275b = qeAccessor.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForVideoAbTestModule.K, "");
        this.f5276c = qeAccessor.a(Liveness.Cached, exposureLogging, ExperimentsForVideoAbTestModule.J, false);
        this.f5277d = qeAccessor.a(Liveness.Cached, exposureLogging, ExperimentsForVideoAbTestModule.M, 0);
        this.f5278e = qeAccessor.a(Liveness.Cached, exposureLogging, ExperimentsForVideoAbTestModule.N, 0);
    }
}

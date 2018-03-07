package com.facebook.video.engine.texview;

import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.video.engine.VideoLoggingUtils;
import javax.inject.Inject;

/* compiled from: previous_ */
public class VideoSurfaceProvider {
    private static boolean f9080a = false;
    private final Lazy<VideoLoggingUtils> f9081b;
    private final MonotonicClock f9082c;
    private final RmTextureViewProvider f9083d;
    private final RmSphericalTextureViewProvider f9084e;
    private final SurfaceTexturePool f9085f;
    private final Lazy<FbErrorReporter> f9086g;

    public static VideoSurfaceProvider m13976b(InjectorLike injectorLike) {
        return new VideoSurfaceProvider(IdBasedSingletonScopeProvider.m1810b(injectorLike, 3663), AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike), RmTextureViewProvider.m13979b(injectorLike), RmSphericalTextureViewProvider.m13981a(injectorLike), SurfaceTexturePool.m13985a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 494));
    }

    @Inject
    public VideoSurfaceProvider(Lazy<VideoLoggingUtils> lazy, MonotonicClock monotonicClock, RmTextureViewProvider rmTextureViewProvider, RmSphericalTextureViewProvider rmSphericalTextureViewProvider, SurfaceTexturePool surfaceTexturePool, Lazy<FbErrorReporter> lazy2) {
        this.f9081b = lazy;
        this.f9082c = monotonicClock;
        this.f9083d = rmTextureViewProvider;
        this.f9084e = rmSphericalTextureViewProvider;
        this.f9085f = surfaceTexturePool;
        this.f9086g = lazy2;
    }

    public static VideoSurfaceProvider m13975a(InjectorLike injectorLike) {
        return m13976b(injectorLike);
    }

    public final VideoSurfaceTarget m13977a(boolean z) {
        return new VideoSurfaceTarget(z ? this.f9084e : this.f9083d, this.f9085f, this.f9086g);
    }
}

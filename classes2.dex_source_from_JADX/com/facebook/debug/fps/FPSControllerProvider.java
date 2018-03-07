package com.facebook.debug.fps;

import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: old_app_version */
public class FPSControllerProvider extends AbstractAssistedProvider<FPSController> {
    public final FPSController m16576a(Boolean bool) {
        return new FPSController(bool, DefaultAndroidThreadUtil.m1646b((InjectorLike) this), FbErrorReporterImpl.m2317a((InjectorLike) this));
    }
}

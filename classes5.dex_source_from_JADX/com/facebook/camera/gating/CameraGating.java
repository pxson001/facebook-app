package com.facebook.camera.gating;

import com.facebook.common.util.TriState;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: allow_contributors */
public class CameraGating {
    public final Provider<Boolean> f10961a;
    public final Provider<TriState> f10962b;
    public final Provider<Boolean> f10963c;
    public final Provider<Boolean> f10964d;

    public static CameraGating m18983b(InjectorLike injectorLike) {
        return new CameraGating(IdBasedProvider.a(injectorLike, 3910), IdBasedProvider.a(injectorLike, 647), IdBasedProvider.a(injectorLike, 3912), IdBasedProvider.a(injectorLike, 3914));
    }

    @Inject
    public CameraGating(Provider<Boolean> provider, Provider<TriState> provider2, Provider<Boolean> provider3, Provider<Boolean> provider4) {
        this.f10961a = provider;
        this.f10962b = provider2;
        this.f10963c = provider3;
        this.f10964d = provider4;
    }

    public static CameraGating m18982a(InjectorLike injectorLike) {
        return m18983b(injectorLike);
    }
}

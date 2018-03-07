package com.facebook.http.tigon;

import com.facebook.inject.InjectorLike;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;
import com.facebook.tigon.iface.TigonServiceHolder;
import javax.inject.Inject;

@DoNotStrip
/* compiled from: last_write_success_age_ms */
public class Tigon4aHttpServiceHolder extends TigonServiceHolder {
    @DoNotStrip
    private static native HybridData initHybrid(Tigon4aHttpService tigon4aHttpService);

    public static Tigon4aHttpServiceHolder m9881b(InjectorLike injectorLike) {
        return new Tigon4aHttpServiceHolder(Tigon4aHttpService.m9888a(injectorLike));
    }

    static {
        SoLoader.a("tigon4a");
    }

    @Inject
    public Tigon4aHttpServiceHolder(Tigon4aHttpService tigon4aHttpService) {
        super(initHybrid(tigon4aHttpService));
    }

    public static Tigon4aHttpServiceHolder m9880a(InjectorLike injectorLike) {
        return m9881b(injectorLike);
    }
}

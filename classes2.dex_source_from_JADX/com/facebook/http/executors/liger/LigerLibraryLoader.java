package com.facebook.http.executors.liger;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.soloader.SoLoader;
import javax.inject.Inject;

/* compiled from: ref_params */
public class LigerLibraryLoader {
    private final AbstractFbErrorReporter f7840a;

    public static LigerLibraryLoader m12379b(InjectorLike injectorLike) {
        return new LigerLibraryLoader(FbErrorReporterImpl.m2317a(injectorLike));
    }

    @Inject
    public LigerLibraryLoader(AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f7840a = abstractFbErrorReporter;
    }

    public final boolean m12380a() {
        try {
            SoLoader.a("fb");
            SoLoader.a("liger");
            return true;
        } catch (Throwable th) {
            this.f7840a.m2343a("Liger.loadLibrary", th.getMessage(), th);
            return false;
        }
    }
}

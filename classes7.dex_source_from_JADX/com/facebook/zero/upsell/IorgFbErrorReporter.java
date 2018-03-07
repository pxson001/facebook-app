package com.facebook.zero.upsell;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: was_tapped */
public class IorgFbErrorReporter {
    private final AbstractFbErrorReporter f257a;

    public static IorgFbErrorReporter m253b(InjectorLike injectorLike) {
        return new IorgFbErrorReporter((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public IorgFbErrorReporter(AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f257a = abstractFbErrorReporter;
    }

    public final void m254a(String str, String str2) {
        this.f257a.a(str, str2);
    }
}

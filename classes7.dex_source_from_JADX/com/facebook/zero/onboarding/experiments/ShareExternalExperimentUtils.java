package com.facebook.zero.onboarding.experiments;

import android.net.Uri;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

/* compiled from: d024696e3a5d6dc4f5c1b8755524941b */
public class ShareExternalExperimentUtils {
    public final QeAccessor f16195a;
    public final Lazy<AnalyticsLogger> f16196b;

    public static ShareExternalExperimentUtils m20245b(InjectorLike injectorLike) {
        return new ShareExternalExperimentUtils((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 175));
    }

    @Inject
    public ShareExternalExperimentUtils(QeAccessor qeAccessor, Lazy<AnalyticsLogger> lazy) {
        this.f16195a = qeAccessor;
        this.f16196b = lazy;
    }

    public final boolean m20247a() {
        return this.f16195a.a(ExperimentsForAssistedOnboardingAbTestModule.f16193c, false);
    }

    public static ShareExternalExperimentUtils m20244a(InjectorLike injectorLike) {
        return m20245b(injectorLike);
    }

    public final String m20246a(String str, String str2) {
        if (m20247a()) {
            return Uri.parse(str).buildUpon().appendQueryParameter("st", Integer.toString(str2.hashCode())).appendQueryParameter("", "").build().toString();
        }
        return str;
    }
}

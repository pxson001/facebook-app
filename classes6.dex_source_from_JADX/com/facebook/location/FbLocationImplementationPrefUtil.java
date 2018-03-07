package com.facebook.location;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

/* compiled from: € */
public class FbLocationImplementationPrefUtil {
    private final GooglePlayServicesUtil f16a;
    private final AbstractFbErrorReporter f17b;

    public static FbLocationImplementationPrefUtil m9a(InjectorLike injectorLike) {
        return new FbLocationImplementationPrefUtil(GooglePlayServicesUtil.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public FbLocationImplementationPrefUtil(GooglePlayServicesUtil googlePlayServicesUtil, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f16a = googlePlayServicesUtil;
        this.f17b = abstractFbErrorReporter;
    }

    public final ImmutableList<FbLocationImplementationPref> m10a() {
        ImmutableList<FbLocationImplementationPref> copyOf;
        if (FbLocationManagerProvider.b(this.f16a, this.f17b)) {
            copyOf = ImmutableList.copyOf(FbLocationImplementationPref.values());
        } else {
            Builder builder = ImmutableList.builder();
            for (FbLocationImplementationPref fbLocationImplementationPref : FbLocationImplementationPref.values()) {
                if (fbLocationImplementationPref != FbLocationImplementationPref.GOOGLE_PLAY_PREF) {
                    builder.c(fbLocationImplementationPref);
                }
            }
            copyOf = builder.b();
        }
        return copyOf;
    }
}

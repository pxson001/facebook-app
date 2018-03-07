package com.facebook.location;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: ₫ */
public class FbLocationPassiveListenerMethodAutoProvider extends AbstractProvider<FbLocationPassiveListener> {
    private static FbLocationPassiveListener m11b(InjectorLike injectorLike) {
        return FbLocationPassiveListenerProvider.a(IdBasedProvider.a(injectorLike, 703), GooglePlayServicesUtil.a(injectorLike), IdBasedProvider.a(injectorLike, 7454), IdBasedProvider.a(injectorLike, 7450), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    public Object get() {
        return FbLocationPassiveListenerProvider.a(IdBasedProvider.a(this, 703), GooglePlayServicesUtil.a(this), IdBasedProvider.a(this, 7454), IdBasedProvider.a(this, 7450), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this));
    }
}

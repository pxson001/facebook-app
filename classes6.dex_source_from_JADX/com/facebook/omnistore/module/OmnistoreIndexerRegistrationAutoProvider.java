package com.facebook.omnistore.module;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.AbstractProvider;

/* compiled from: temp */
public class OmnistoreIndexerRegistrationAutoProvider extends AbstractProvider<OmnistoreIndexerRegistration> {
    public /* bridge */ /* synthetic */ Object get() {
        return new OmnistoreIndexerRegistration(C0178x55cda8c3.getSet(this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this));
    }
}

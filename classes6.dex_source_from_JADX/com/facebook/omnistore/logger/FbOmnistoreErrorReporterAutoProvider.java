package com.facebook.omnistore.logger;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.AbstractProvider;

/* compiled from: text_only_place_posted */
public class FbOmnistoreErrorReporterAutoProvider extends AbstractProvider<FbOmnistoreErrorReporter> {
    public /* bridge */ /* synthetic */ Object get() {
        return new FbOmnistoreErrorReporter((AbstractFbErrorReporter) FbErrorReporterImpl.a(this));
    }
}

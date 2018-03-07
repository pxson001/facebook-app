package com.facebook.omnistore.module;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.AbstractProvider;
import com.facebook.xconfig.core.XConfigReader;

/* compiled from: temporary */
public class OmnistoreExtraFileProviderAutoProvider extends AbstractProvider<OmnistoreExtraFileProvider> {
    public /* bridge */ /* synthetic */ Object get() {
        return new OmnistoreExtraFileProvider(OmnistoreSingletonProvider.m4252xb8a83167(this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), XConfigReader.a(this));
    }
}

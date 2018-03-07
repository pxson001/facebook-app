package com.facebook.omnistore.module;

import android.content.Context;
import com.facebook.auth.module.String_ViewerContextUserIdMethodAutoProvider;
import com.facebook.config.application.FbAppType;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.omnistore.OmnistoreErrorReporter;
import com.facebook.omnistore.logger.FbOmnistoreErrorReporter;
import com.facebook.omnistore.mqtt.MqttProtocolProviderMethodAutoProvider;
import com.facebook.xanalytics.provider.DefaultXAnalyticsProvider;

/* compiled from: text_assets */
public class DefaultOmnistoreOpenerAutoProvider extends AbstractProvider<DefaultOmnistoreOpener> {
    public /* bridge */ /* synthetic */ Object get() {
        return new DefaultOmnistoreOpener(MqttProtocolProviderMethodAutoProvider.getInstance__com_facebook_omnistore_MqttProtocolProvider__INJECTED_BY_TemplateInjector(this), (OmnistoreErrorReporter) FbOmnistoreErrorReporter.getInstance__com_facebook_omnistore_logger_FbOmnistoreErrorReporter__INJECTED_BY_TemplateInjector(this), DefaultXAnalyticsProvider.a(this), (Context) getInstance(Context.class), (FbAppType) getInstance(FbAppType.class), String_ViewerContextUserIdMethodAutoProvider.b(this), IdBasedProvider.a(this, 4231), IdBasedProvider.a(this, 4230), IdBasedProvider.a(this, 4229));
    }
}

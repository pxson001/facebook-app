package com.facebook.video.commercialbreak;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.rti.shared.skywalker.SkywalkerSubscriptionConnector;
import com.facebook.ui.toaster.Toaster;
import com.facebook.video.commercialbreak.logging.CommercialBreakLogger;
import com.fasterxml.jackson.databind.ObjectMapper;

/* compiled from: platform_webdialogs_manifest_fetch_URL */
public class CommercialBreakMessageSubscriberProvider extends AbstractAssistedProvider<CommercialBreakMessageSubscriber> {
    public final CommercialBreakMessageSubscriber m5038a(String str) {
        return new CommercialBreakMessageSubscriber(str, SkywalkerSubscriptionConnector.a(this), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), DefaultAndroidThreadUtil.b(this), IdBasedProvider.a(this, 4363), Toaster.b(this), CommercialBreakLogger.m5040a(this));
    }
}

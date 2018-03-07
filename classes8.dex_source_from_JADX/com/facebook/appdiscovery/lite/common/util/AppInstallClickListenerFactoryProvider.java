package com.facebook.appdiscovery.lite.common.util;

import android.content.Context;
import com.facebook.appdiscovery.lite.analytics.LiteInstallLogger;
import com.facebook.common.market.GooglePlayIntentHelper;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: is_page_like_button_shown */
public class AppInstallClickListenerFactoryProvider extends AbstractAssistedProvider<AppInstallClickListenerFactory> {
    public final AppInstallClickListenerFactory m12464a(Context context, LiteInstallLogger liteInstallLogger) {
        return new AppInstallClickListenerFactory(context, liteInstallLogger, GooglePlayIntentHelper.b(this), (SecureContextHelper) DefaultSecureContextHelper.a(this), FbUriIntentHandler.a(this));
    }
}

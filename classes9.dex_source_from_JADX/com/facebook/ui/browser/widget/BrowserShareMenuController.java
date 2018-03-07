package com.facebook.ui.browser.widget;

import android.content.Context;
import com.facebook.analytics.NavigationLogger;
import com.facebook.auth.datastore.LoggedInUserAuthDataStore;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.composer.publish.ComposerPublishServiceHelper;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.messaging.sharing.sendasmessage.SendAsMessageUtil;
import com.facebook.messaging.util.MessengerAppUtils;
import com.facebook.privacy.service.cache.PrivacyOptionsCache;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.sequencelogger.SequenceLoggerImpl;
import com.facebook.ui.browser.logging.BrowserAnalyticsLogger;
import com.facebook.ui.toaster.Toaster;
import javax.inject.Inject;

/* compiled from: timestamp_ms DESC LIMIT  */
public class BrowserShareMenuController {
    public final Context f1625a;
    private final BrowserAnalyticsLogger f1626b;
    public final SequenceLogger f1627c;
    private final LoggedInUserSessionManager f1628d;
    public final Lazy<NavigationLogger> f1629e;
    private final Lazy<PrivacyOptionsCache> f1630f;
    public final ComposerLauncher f1631g;
    private final Lazy<ComposerPublishServiceHelper> f1632h;
    private final MessengerAppUtils f1633i;
    public final Lazy<SendAsMessageUtil> f1634j;
    public final Lazy<Toaster> f1635k;

    public static BrowserShareMenuController m1665b(InjectorLike injectorLike) {
        return new BrowserShareMenuController((Context) injectorLike.getInstance(Context.class), BrowserAnalyticsLogger.m1626a(injectorLike), (SequenceLogger) SequenceLoggerImpl.a(injectorLike), LoggedInUserSessionManager.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 137), IdBasedSingletonScopeProvider.b(injectorLike, 3117), (ComposerLauncher) ComposerLauncherImpl.a(injectorLike), IdBasedLazy.a(injectorLike, 5272), MessengerAppUtils.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 8437), IdBasedLazy.a(injectorLike, 3588));
    }

    @Inject
    public BrowserShareMenuController(Context context, BrowserAnalyticsLogger browserAnalyticsLogger, SequenceLogger sequenceLogger, LoggedInUserAuthDataStore loggedInUserAuthDataStore, Lazy<NavigationLogger> lazy, Lazy<PrivacyOptionsCache> lazy2, ComposerLauncher composerLauncher, Lazy<ComposerPublishServiceHelper> lazy3, MessengerAppUtils messengerAppUtils, Lazy<SendAsMessageUtil> lazy4, Lazy<Toaster> lazy5) {
        this.f1625a = context;
        this.f1626b = browserAnalyticsLogger;
        this.f1627c = sequenceLogger;
        this.f1628d = loggedInUserAuthDataStore;
        this.f1629e = lazy;
        this.f1630f = lazy2;
        this.f1631g = composerLauncher;
        this.f1632h = lazy3;
        this.f1633i = messengerAppUtils;
        this.f1634j = lazy4;
        this.f1635k = lazy5;
    }
}

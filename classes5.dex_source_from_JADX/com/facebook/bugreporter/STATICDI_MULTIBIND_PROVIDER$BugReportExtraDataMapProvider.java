package com.facebook.bugreporter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutCompat;
import com.facebook.feed.logging.DbFeedCacheDumper;
import com.facebook.feed.logging.StoryLikeHistoryLogger;
import com.facebook.feed.logging.bugreport.NewsFeedEventLogger;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.messaging.sms.SmsTakeOverBugReportExtraDataMapProvider;
import com.facebook.notifications.bugreporter.NotificationsBugReportExtraDataMapProvider;
import com.facebook.photos.base.analytics.bugreporter.PhotosBugReportExtraDataMapProvider;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.richdocument.logging.RichDocumentBugReportExtraDataProvider;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: transaction_status_display */
public final class STATICDI_MULTIBIND_PROVIDER$BugReportExtraDataMapProvider implements MultiBindIndexedProvider<BugReportExtraDataMapProvider>, Provider<Set<BugReportExtraDataMapProvider>> {
    private final InjectorLike f10661a;

    private STATICDI_MULTIBIND_PROVIDER$BugReportExtraDataMapProvider(InjectorLike injectorLike) {
        this.f10661a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f10661a.getScopeAwareInjector(), this);
    }

    public static Set<BugReportExtraDataMapProvider> m18683a(InjectorLike injectorLike) {
        return new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$BugReportExtraDataMapProvider(injectorLike));
    }

    public final int size() {
        return 7;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return DbFeedCacheDumper.a(injector);
            case 1:
                return StoryLikeHistoryLogger.a(injector);
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                return NewsFeedEventLogger.a(injector);
            case 3:
                return new SmsTakeOverBugReportExtraDataMapProvider((Context) injector.getInstance(Context.class), (FbSharedPreferences) FbSharedPreferencesImpl.a(injector), IdBasedSingletonScopeProvider.b(injector, 2704), IdBasedLazy.a(injector, 2705), IdBasedSingletonScopeProvider.b(injector, 8439));
            case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                return NotificationsBugReportExtraDataMapProvider.b(injector);
            case 5:
                return PhotosBugReportExtraDataMapProvider.b(injector);
            case 6:
                return new RichDocumentBugReportExtraDataProvider((FbSharedPreferences) FbSharedPreferencesImpl.a(injector));
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}

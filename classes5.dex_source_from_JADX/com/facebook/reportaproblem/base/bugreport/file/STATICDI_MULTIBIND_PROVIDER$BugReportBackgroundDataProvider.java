package com.facebook.reportaproblem.base.bugreport.file;

import android.support.v7.widget.LinearLayoutCompat;
import com.facebook.common.manifest.AppBuildInfoMethodAutoProvider;
import com.facebook.config.application.SignatureTypeMethodAutoProvider;
import com.facebook.feed.logging.StoryLikeHistoryLogger;
import com.facebook.feed.logging.bugreport.NewsFeedEventLogger;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.notifications.bugreporter.NotificationsBugReportExtraDataMapProvider;
import com.facebook.photos.base.analytics.bugreporter.PhotosBugReportExtraDataMapProvider;
import com.facebook.reportaproblem.fb.dataprovider.FbBuildInfoBackgroundDataProvider;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: transaction_status_display */
public final class STATICDI_MULTIBIND_PROVIDER$BugReportBackgroundDataProvider implements MultiBindIndexedProvider<BugReportBackgroundDataProvider>, Provider<Set<BugReportBackgroundDataProvider>> {
    private final InjectorLike f5245a;

    private STATICDI_MULTIBIND_PROVIDER$BugReportBackgroundDataProvider(InjectorLike injectorLike) {
        this.f5245a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f5245a.getScopeAwareInjector(), this);
    }

    public static Provider<Set<BugReportBackgroundDataProvider>> m10148a(InjectorLike injectorLike) {
        return new STATICDI_MULTIBIND_PROVIDER$BugReportBackgroundDataProvider(injectorLike.getScopeAwareInjector());
    }

    public final int size() {
        return 5;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return StoryLikeHistoryLogger.a(injector);
            case 1:
                return NewsFeedEventLogger.a(injector);
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                return NotificationsBugReportExtraDataMapProvider.b(injector);
            case 3:
                return PhotosBugReportExtraDataMapProvider.b(injector);
            case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                return new FbBuildInfoBackgroundDataProvider(AppBuildInfoMethodAutoProvider.m3809a(injector), SignatureTypeMethodAutoProvider.b(injector));
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}

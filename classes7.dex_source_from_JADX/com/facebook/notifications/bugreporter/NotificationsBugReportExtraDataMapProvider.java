package com.facebook.notifications.bugreporter;

import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.bugreporter.BugReportExtraDataMapProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.bugreporter.foldercounts.FolderCountsDebugDataTracker;
import com.facebook.notifications.preferences.NotificationsPreferenceConstants;
import com.facebook.notifications.provider.GraphQLNotificationsContentProviderHelper;
import com.facebook.notifications.util.NotificationsUtils;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.reportaproblem.base.bugreport.file.BugReportBackgroundDataProvider;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Maps;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: no source specified */
public class NotificationsBugReportExtraDataMapProvider implements BugReportExtraDataMapProvider, BugReportBackgroundDataProvider {
    private final FbSharedPreferences f8151a;
    private final Provider<ViewerContext> f8152b;
    private final NotificationsUtils f8153c;
    private final Provider<FolderCountsDebugDataTracker> f8154d;

    public static NotificationsBugReportExtraDataMapProvider m9776b(InjectorLike injectorLike) {
        return new NotificationsBugReportExtraDataMapProvider((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), IdBasedProvider.a(injectorLike, 372), NotificationsUtils.a(injectorLike), IdBasedProvider.a(injectorLike, 2558));
    }

    @Inject
    public NotificationsBugReportExtraDataMapProvider(FbSharedPreferences fbSharedPreferences, Provider<ViewerContext> provider, NotificationsUtils notificationsUtils, Provider<FolderCountsDebugDataTracker> provider2) {
        this.f8151a = fbSharedPreferences;
        this.f8152b = provider;
        this.f8153c = notificationsUtils;
        this.f8154d = provider2;
    }

    public final Map<String, String> m9778c() {
        return ImmutableMap.builder().b();
    }

    public final Map<String, String> m9779d() {
        Builder builder = ImmutableMap.builder();
        ViewerContext viewerContext = (ViewerContext) this.f8152b.get();
        if (viewerContext != null) {
            NotificationsUtils notificationsUtils = this.f8153c;
            long parseLong = Long.parseLong(viewerContext.mUserId);
            notificationsUtils.f.b();
            builder.b("Count of Cache IDs: ", Integer.toString(((GraphQLNotificationsContentProviderHelper) notificationsUtils.c.get()).c(parseLong).size()));
        }
        builder.b(NotificationsPreferenceConstants.d.a(), Integer.toString(this.f8151a.a(NotificationsPreferenceConstants.d, -1)));
        builder.b(NotificationsPreferenceConstants.e.a(), Integer.toString(this.f8151a.a(NotificationsPreferenceConstants.e, -1)));
        builder.b(NotificationsPreferenceConstants.b.a(), Long.toString(this.f8151a.a(NotificationsPreferenceConstants.b, 0)));
        String a = this.f8151a.a(NotificationsPreferenceConstants.c, null);
        if (a != null) {
            builder.b(NotificationsPreferenceConstants.c.a(), a);
        }
        if (viewerContext != null) {
            StringBuilder stringBuilder = new StringBuilder();
            ImmutableList a2 = this.f8153c.a(Long.parseLong(viewerContext.mUserId));
            int size = a2.size();
            for (int i = 0; i < size; i++) {
                stringBuilder.append((String) a2.get(i));
                stringBuilder.append(";");
            }
            builder.b("Cache IDs", stringBuilder.toString());
        }
        builder.a(((FolderCountsDebugDataTracker) this.f8154d.get()).getDebugInfo());
        return builder.b();
    }

    public final Map<String, String> m9777b() {
        return Maps.a(m9779d());
    }
}

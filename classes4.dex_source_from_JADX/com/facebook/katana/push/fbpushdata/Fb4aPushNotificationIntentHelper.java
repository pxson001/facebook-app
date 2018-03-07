package com.facebook.katana.push.fbpushdata;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.facebook.apptab.state.TabTag;
import com.facebook.common.android.PackageManagerMethodAutoProvider;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.debug.log.BLog;
import com.facebook.friending.center.constants.FriendsCenterSource;
import com.facebook.friending.center.constants.FriendsCenterTabType;
import com.facebook.graphql.enums.GraphQLSavedDashboardSectionType;
import com.facebook.inject.ForAppContext;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.katana.findfriends.CIFlow;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.notifications.logging.NotificationType;
import com.facebook.notifications.model.SystemTrayNotification;
import com.facebook.notifications.notificationsfriending.abtest.NotificationsFriendingExperimentController;
import com.google.common.base.Optional;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: login/ */
public class Fb4aPushNotificationIntentHelper {
    private final Context f8904a;
    private final PackageManager f8905b;
    private final Fb4aUriIntentMapper f8906c;
    private final NotificationsFriendingExperimentController f8907d;

    public static Fb4aPushNotificationIntentHelper m9268b(InjectorLike injectorLike) {
        return new Fb4aPushNotificationIntentHelper((Context) injectorLike.getInstance(Context.class, ForAppContext.class), PackageManagerMethodAutoProvider.a(injectorLike), Fb4aUriIntentMapper.a(injectorLike), NotificationsFriendingExperimentController.a(injectorLike));
    }

    @Inject
    public Fb4aPushNotificationIntentHelper(@ForAppContext Context context, PackageManager packageManager, Fb4aUriIntentMapper fb4aUriIntentMapper, NotificationsFriendingExperimentController notificationsFriendingExperimentController) {
        this.f8904a = context;
        this.f8905b = packageManager;
        this.f8906c = fb4aUriIntentMapper;
        this.f8907d = notificationsFriendingExperimentController;
    }

    public static Fb4aPushNotificationIntentHelper m9267a(InjectorLike injectorLike) {
        return m9268b(injectorLike);
    }

    public final Intent m9269a(NotificationType notificationType, @Nullable String str) {
        Intent a;
        switch (1.a[notificationType.ordinal()]) {
            case 1:
                return this.f8906c.a(this.f8904a, this.f8907d.b() ? StringFormatUtil.formatStrLocaleSafe(FBLinks.gc) : FBLinks.cj);
            case 2:
                return this.f8906c.a(this.f8904a, StringFormatUtil.formatStrLocaleSafe(FBLinks.dR, CIFlow.CONTINUOUS_SYNC));
            case 3:
                String formatStrLocaleSafe;
                if (this.f8907d.b()) {
                    formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.cd, FriendsCenterSource.FRIEND_REQUEST_TRAY_NOTIFICATION.name(), FriendsCenterTabType.REQUESTS.name());
                } else {
                    formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.ch);
                }
                a = this.f8906c.a(this.f8904a, formatStrLocaleSafe);
                if (this.f8907d.b()) {
                    return a;
                }
                a.putExtra("target_tab_name", TabTag.FriendRequests.name());
                return a;
            case 4:
            case 5:
                return this.f8906c.a(this.f8904a, FBLinks.cq);
            case 6:
                return this.f8906c.a(this.f8904a, Fb4aUriIntentMapper.a(Uri.parse("/checkpoint/login_approvals")));
            case 7:
                return this.f8906c.a(this.f8904a, StringFormatUtil.formatStrLocaleSafe(FBLinks.dF, GraphQLSavedDashboardSectionType.PLACES, "42"));
            case 8:
                a = this.f8906c.a(this.f8904a, FBLinks.a("photosync"));
                a.putExtra("nux_ref", "web_notif");
                return a;
            case 9:
                if (str == null) {
                    return null;
                }
                try {
                    String formatStrLocaleSafe2 = StringFormatUtil.formatStrLocaleSafe(FBLinks.cy, Long.valueOf(Long.parseLong(str)));
                    if (formatStrLocaleSafe2 != null) {
                        return this.f8906c.a(this.f8904a, formatStrLocaleSafe2);
                    }
                    return null;
                } catch (Throwable e) {
                    BLog.b("Fb4aPushNotificationIntentHelper", e, "Object id associated with notification was not long: %s", new Object[]{str});
                    return null;
                }
            case 10:
                return this.f8906c.a(this.f8904a, StringFormatUtil.formatStrLocaleSafe(FBLinks.aX, str));
            case 11:
                return this.f8906c.a(this.f8904a, FBLinks.eI);
            case 12:
                return new Intent();
            case 13:
            case 14:
                return this.f8905b.getLaunchIntentForPackage(this.f8904a.getPackageName());
            case 15:
                return this.f8906c.a(this.f8904a, FBLinks.eJ);
            case 16:
                return this.f8906c.a(this.f8904a, FBLinks.eK);
            default:
                return null;
        }
    }

    public final String m9270a(SystemTrayNotification systemTrayNotification) {
        switch (1.a[systemTrayNotification.m12307a().ordinal()]) {
            case 3:
                return (String) systemTrayNotification.mParams.get("ppu");
            case 9:
                Optional f = systemTrayNotification.m12317f();
                if (f.isPresent()) {
                    return String.valueOf(f.get());
                }
                return null;
            case 10:
                return (String) systemTrayNotification.mParams.get("uid");
            default:
                return null;
        }
    }
}

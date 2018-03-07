package com.facebook.notifications.util;

import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels.NotifInlineActionOptionFragmentModel;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels.NotificationOptionRowModel;
import javax.annotation.Nullable;

/* compiled from: minutiae_configuration */
public class NotificationsRowWithActionHelper$RowWithActionTaken {
    public String f8902a;
    public String f8903b;
    NotificationOptionRowModel f8904c;
    NotifInlineActionOptionFragmentModel f8905d;
    public String f8906e;
    String f8907f;
    public boolean f8908g = true;

    public NotificationsRowWithActionHelper$RowWithActionTaken(String str, String str2, NotificationOptionRowModel notificationOptionRowModel) {
        this.f8902a = str;
        this.f8903b = str2;
        this.f8904c = notificationOptionRowModel;
        if (this.f8904c.m10159g() != null) {
            this.f8907f = this.f8904c.m10159g().m10149a();
        }
        if (this.f8904c.gq_() != null) {
            this.f8906e = this.f8904c.gq_();
        }
    }

    public NotificationsRowWithActionHelper$RowWithActionTaken(String str, String str2, NotifInlineActionOptionFragmentModel notifInlineActionOptionFragmentModel) {
        this.f8902a = str;
        this.f8903b = str2;
        this.f8905d = notifInlineActionOptionFragmentModel;
        if (!(this.f8905d == null || this.f8905d.m10101b() == null || this.f8905d.m10101b().m10081g() == null)) {
            this.f8907f = this.f8905d.m10101b().m10081g().a();
        }
        if (this.f8905d != null && this.f8905d.m10100a() != null && this.f8905d.m10100a().m10094d() != null) {
            this.f8906e = this.f8905d.m10100a().m10094d();
        }
    }

    public final String m10815a() {
        return this.f8902a;
    }

    @Nullable
    public final NotificationOptionRowModel m10817c() {
        return this.f8904c;
    }

    public final boolean m10818d() {
        return this.f8908g;
    }

    public final void m10816a(boolean z) {
        this.f8908g = z;
    }

    @Nullable
    public final String m10819e() {
        return this.f8907f;
    }
}

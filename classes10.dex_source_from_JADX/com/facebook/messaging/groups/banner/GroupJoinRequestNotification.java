package com.facebook.messaging.groups.banner;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.common.banner.AbstractBannerNotification;
import com.facebook.common.banner.BasicBannerNotificationView;
import com.facebook.common.banner.BasicBannerNotificationView.Params.Builder;
import com.facebook.common.util.ContextUtils;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.groups.admin.GroupAdminController;
import com.facebook.messaging.model.threads.ThreadJoinRequest;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.model.threads.ThreadSummary.GroupType;
import com.facebook.orca.threadview.ThreadViewMessagesFragmentBannerNotificationController.C11733;
import com.facebook.ultralight.Inject;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: sideloading_diode_screen_install_button_on_click */
public class GroupJoinRequestNotification extends AbstractBannerNotification {
    private final Context f2435a;
    public final GroupBannerPreferences f2436b;
    public final GroupAdminController f2437c;
    @Nullable
    public ThreadSummary f2438d;
    public boolean f2439e;
    @Nullable
    public C11733 f2440f;

    /* compiled from: sideloading_diode_screen_install_button_on_click */
    class C04081 implements OnClickListener {
        final /* synthetic */ GroupJoinRequestNotification f2434a;

        C04081(GroupJoinRequestNotification groupJoinRequestNotification) {
            this.f2434a = groupJoinRequestNotification;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -809352396);
            GroupJoinRequestNotification groupJoinRequestNotification = this.f2434a;
            if (groupJoinRequestNotification.f2438d != null) {
                GroupBannerPreferences groupBannerPreferences = groupJoinRequestNotification.f2436b;
                groupBannerPreferences.f2432a.edit().a(GroupBannerPreferences.m2351b(groupJoinRequestNotification.f2438d.a), groupBannerPreferences.f2433b.a()).commit();
            }
            groupJoinRequestNotification.f2439e = false;
            groupJoinRequestNotification.a.b(groupJoinRequestNotification);
            if (groupJoinRequestNotification.f2440f != null) {
                groupJoinRequestNotification.f2440f.m7691a();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -814147747, a);
        }
    }

    @Inject
    public GroupJoinRequestNotification(@Assisted Context context, GroupBannerPreferences groupBannerPreferences, GroupAdminController groupAdminController) {
        super("GroupJoinRequestNotification");
        this.f2435a = context;
        this.f2436b = groupBannerPreferences;
        this.f2437c = groupAdminController;
    }

    public final void m2354a(@Nullable C11733 c11733) {
        this.f2440f = c11733;
    }

    public final void m2353a(@Nullable ThreadSummary threadSummary) {
        boolean z;
        if (threadSummary != null && threadSummary.Q && !threadSummary.R.isEmpty() && threadSummary.P == GroupType.HIDDEN && this.f2437c.m2346c(threadSummary)) {
            boolean z2;
            long a = this.f2436b.f2432a.a(GroupBannerPreferences.m2351b(threadSummary.a), 0);
            ImmutableList immutableList = threadSummary.R;
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                if (((ThreadJoinRequest) immutableList.get(i)).b > a) {
                    z2 = true;
                    break;
                }
            }
            z2 = false;
            z = z2;
        } else {
            z = false;
        }
        this.f2439e = z;
        this.f2438d = threadSummary;
    }

    public final void m2355b() {
        m2357e();
    }

    public final void m2356c() {
    }

    public final View m2352a(ViewGroup viewGroup) {
        BasicBannerNotificationView basicBannerNotificationView = (BasicBannerNotificationView) LayoutInflater.from(this.f2435a).inflate(2130903387, viewGroup, false);
        CharSequence quantityString = this.f2435a.getResources().getQuantityString(2131689793, this.f2438d.R.size(), new Object[]{Integer.valueOf(this.f2438d.R.size())});
        Builder builder = new Builder();
        builder.a = quantityString;
        Builder builder2 = builder;
        builder2.c = new ColorDrawable(-1);
        builder2 = builder2;
        builder2.i = new ColorDrawable(-16777216);
        builder2 = builder2;
        builder2.d = true;
        builder2 = builder2;
        builder2.e = this.f2435a.getString(2131241297);
        builder2 = builder2;
        builder2.f = this.f2435a.getResources().getColor(2131362241);
        builder2 = builder2;
        builder2.g = ContextUtils.f(this.f2435a, 2130772019, 2130837778);
        basicBannerNotificationView.setParams(builder2.a());
        basicBannerNotificationView.setOnBannerButtonClickListener(new C04081(this));
        return basicBannerNotificationView;
    }

    public final void m2357e() {
        if (this.f2439e) {
            this.a.a(this);
        } else {
            this.a.b(this);
        }
    }
}

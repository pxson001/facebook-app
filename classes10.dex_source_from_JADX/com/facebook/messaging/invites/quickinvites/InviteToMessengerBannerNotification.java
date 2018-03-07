package com.facebook.messaging.invites.quickinvites;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.common.banner.AbstractBannerNotification;
import com.facebook.common.banner.BannerNotificationAnalyticsHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.orca.threadview.ThreadViewMessagesFragmentBannerNotificationController.C11711;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: selected_image */
public class InviteToMessengerBannerNotification extends AbstractBannerNotification {
    private final Context f3001a;
    public final BannerNotificationAnalyticsHelper f3002b;
    @Nullable
    public C11711 f3003c;
    @Nullable
    public ImmutableList<String> f3004d;

    /* compiled from: selected_image */
    class C04911 implements OnClickListener {
        final /* synthetic */ InviteToMessengerBannerNotification f2999a;

        C04911(InviteToMessengerBannerNotification inviteToMessengerBannerNotification) {
            this.f2999a = inviteToMessengerBannerNotification;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1746052716);
            if (this.f2999a.f3003c != null) {
                this.f2999a.f3003c.m7687a();
                this.f2999a.f3002b.a("click", "invite_banner", "InviteToMessengerNotification");
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1651681002, a);
        }
    }

    /* compiled from: selected_image */
    class C04922 implements OnClickListener {
        final /* synthetic */ InviteToMessengerBannerNotification f3000a;

        C04922(InviteToMessengerBannerNotification inviteToMessengerBannerNotification) {
            this.f3000a = inviteToMessengerBannerNotification;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1123807108);
            if (this.f3000a.f3003c != null) {
                this.f3000a.f3003c.m7688b();
                this.f3000a.f3002b.a("dismiss", "invite_banner", "InviteToMessengerNotification");
            }
            Logger.a(2, EntryType.UI_INPUT_END, 752254128, a);
        }
    }

    public static InviteToMessengerBannerNotification m2980a(InjectorLike injectorLike) {
        return new InviteToMessengerBannerNotification((Context) injectorLike.getInstance(Context.class), BannerNotificationAnalyticsHelper.b(injectorLike));
    }

    @Inject
    public InviteToMessengerBannerNotification(Context context, BannerNotificationAnalyticsHelper bannerNotificationAnalyticsHelper) {
        super("InviteToMessengerNotification");
        this.f3001a = context;
        this.f3002b = bannerNotificationAnalyticsHelper;
    }

    public final void m2982a(C11711 c11711) {
        this.f3003c = c11711;
    }

    public final View m2981a(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.f3001a).inflate(2130904972, viewGroup, false);
        inflate.setOnClickListener(new C04911(this));
        TextView textView = (TextView) inflate.findViewById(2131560097);
        boolean z = this.f3004d != null && this.f3004d.size() > 0;
        Preconditions.checkArgument(z);
        int size = this.f3004d.size();
        switch (size) {
            case 1:
                textView.setText(this.f3001a.getResources().getString(2131231935, new Object[]{this.f3004d.get(0)}));
                break;
            case 2:
                textView.setText(this.f3001a.getResources().getString(2131231936, new Object[]{this.f3004d.get(0), this.f3004d.get(1)}));
                break;
            case 3:
                textView.setText(this.f3001a.getResources().getString(2131231937, new Object[]{this.f3004d.get(0), this.f3004d.get(1), this.f3004d.get(2)}));
                break;
            default:
                textView.setText(this.f3001a.getResources().getQuantityString(2131689505, size, new Object[]{this.f3004d.get(0), this.f3004d.get(1), Integer.valueOf(size - 2)}));
                break;
        }
        inflate.findViewById(2131563285).setOnClickListener(new C04922(this));
        return inflate;
    }
}

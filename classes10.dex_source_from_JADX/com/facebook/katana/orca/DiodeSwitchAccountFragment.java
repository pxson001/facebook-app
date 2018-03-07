package com.facebook.katana.orca;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.auth.annotations.LoggedInUser;
import com.facebook.base.fragment.FbFragment;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messages.links.MessengerLinks;
import com.facebook.resources.ui.FbButton;
import com.facebook.user.model.User;
import com.facebook.user.tiles.UserTileView;
import com.facebook.user.tiles.UserTileViewParams;
import com.facebook.widget.tiles.TileBadge;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: unit_logging_data */
public class DiodeSwitchAccountFragment extends FbFragment {
    public static final String f1006d = (MessengerLinks.c + "accounts/triggersso");
    @Inject
    @LoggedInUser
    public Provider<User> f1007a;
    @Inject
    public AnalyticsLogger f1008b;
    @Inject
    public SecureContextHelper f1009c;
    public TextView f1010e;
    private UserTileView f1011f;
    public FbButton f1012g;
    public TextView f1013h;

    /* compiled from: unit_logging_data */
    class C01651 implements OnClickListener {
        final /* synthetic */ DiodeSwitchAccountFragment f1005a;

        C01651(DiodeSwitchAccountFragment diodeSwitchAccountFragment) {
            this.f1005a = diodeSwitchAccountFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1794201514);
            this.f1005a.f1009c.a(new Intent("android.intent.action.VIEW", Uri.parse(DiodeSwitchAccountFragment.f1006d)), this.f1005a.getContext());
            String str = "switch_messenger_account_button";
            HoneyClientEventFast a2 = this.f1005a.f1008b.a("click", false);
            if (a2.a()) {
                a2.a("diode_qp_module");
                a2.b("button");
                a2.c(str);
                a2.b();
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1338140611, a);
        }
    }

    public static void m1059a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        DiodeSwitchAccountFragment diodeSwitchAccountFragment = (DiodeSwitchAccountFragment) obj;
        Provider a = IdBasedProvider.a(fbInjector, 3595);
        AnalyticsLogger a2 = AnalyticsLoggerMethodAutoProvider.a(fbInjector);
        SecureContextHelper secureContextHelper = (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector);
        diodeSwitchAccountFragment.f1007a = a;
        diodeSwitchAccountFragment.f1008b = a2;
        diodeSwitchAccountFragment.f1009c = secureContextHelper;
    }

    public final void m1062c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = DiodeSwitchAccountFragment.class;
        m1059a((Object) this, getContext());
    }

    public final View m1060a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1700196542);
        super.a(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(2130903918, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 297498887, a);
        return inflate;
    }

    public final void m1061a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        this.f1010e = (TextView) e(2131561057);
        this.f1011f = (UserTileView) e(2131561058);
        this.f1012g = (FbButton) e(2131561059);
        this.f1013h = (TextView) e(2131561060);
        this.f1010e.setText(b(2131236604));
        this.f1012g.setText(b(2131236606));
        this.f1013h.setText(b(2131236605));
    }

    public final void m1063d(@Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 480602326);
        super.d(bundle);
        this.f1012g.setOnClickListener(new C01651(this));
        this.f1011f.setParams(UserTileViewParams.a((User) this.f1007a.get(), TileBadge.MESSENGER));
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 722432284, a);
    }
}

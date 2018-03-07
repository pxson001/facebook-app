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
import com.facebook.auth.annotations.LoggedInUserKey;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.util.FindViewUtil;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities.UIElements;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbButton;
import com.facebook.user.model.UserKey;
import com.facebook.user.tiles.UserTileView;
import com.facebook.user.tiles.UserTileViewParams;
import com.facebook.widget.tiles.TileBadge;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: unused_user_sessions */
public class DiodeEnableMessengerFragment extends FbFragment {
    @Inject
    @LoggedInUserKey
    public Provider<UserKey> f942a;
    @Inject
    public AnalyticsLogger f943b;
    public FbButton f944c;
    private UserTileView f945d;
    public TextView f946e;

    /* compiled from: unused_user_sessions */
    class C01501 implements OnClickListener {
        final /* synthetic */ DiodeEnableMessengerFragment f941a;

        C01501(DiodeEnableMessengerFragment diodeEnableMessengerFragment) {
            this.f941a = diodeEnableMessengerFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 951171552);
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:com.facebook.orca"));
            this.f941a.a(intent);
            DiodeEnableMessengerFragment diodeEnableMessengerFragment = this.f941a;
            String str = UIElements.B;
            HoneyClientEventFast a2 = diodeEnableMessengerFragment.f943b.a("click", true);
            if (a2.a()) {
                a2.a("diode_qp_module");
                a2.b("button");
                a2.c(str);
                a2.b();
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1157136860, a);
        }
    }

    public static void m995a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        DiodeEnableMessengerFragment diodeEnableMessengerFragment = (DiodeEnableMessengerFragment) obj;
        Provider a = IdBasedProvider.a(fbInjector, 3597);
        AnalyticsLogger a2 = AnalyticsLoggerMethodAutoProvider.a(fbInjector);
        diodeEnableMessengerFragment.f942a = a;
        diodeEnableMessengerFragment.f943b = a2;
    }

    public final void m997c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = DiodeEnableMessengerFragment.class;
        m995a(this, getContext());
    }

    public final View m996a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1385729073);
        super.a(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(2130903917, viewGroup, false);
        this.f945d = (UserTileView) FindViewUtil.b(inflate, 2131561048);
        this.f946e = (TextView) FindViewUtil.b(inflate, 2131561055);
        this.f944c = (FbButton) FindViewUtil.b(inflate, 2131561056);
        this.f944c.setText(2131236603);
        this.f946e.setText(2131236602);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -606119858, a);
        return inflate;
    }

    public final void m998d(@Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1549152886);
        super.d(bundle);
        this.f944c.setOnClickListener(new C01501(this));
        this.f945d.setParams(UserTileViewParams.a((UserKey) this.f942a.get(), TileBadge.MESSENGER));
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1150771860, a);
    }
}

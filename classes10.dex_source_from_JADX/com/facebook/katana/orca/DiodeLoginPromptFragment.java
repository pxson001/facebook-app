package com.facebook.katana.orca;

import android.content.Context;
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
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
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

/* compiled from: unpin-thread */
public class DiodeLoginPromptFragment extends FbFragment {
    @Inject
    public SecureContextHelper f955a;
    @Inject
    @LoggedInUserKey
    public Provider<UserKey> f956b;
    @Inject
    public AnalyticsLogger f957c;
    public FbButton f958d;
    private UserTileView f959e;
    public TextView f960f;

    /* compiled from: unpin-thread */
    class C01511 implements OnClickListener {
        final /* synthetic */ DiodeLoginPromptFragment f954a;

        C01511(DiodeLoginPromptFragment diodeLoginPromptFragment) {
            this.f954a = diodeLoginPromptFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1234248518);
            String str = "login_prompt_open_messenger_button";
            HoneyClientEventFast a2 = this.f954a.f957c.a("click", true);
            if (a2.a()) {
                a2.a("diode_qp_module");
                a2.b("button");
                a2.c(str);
                a2.b();
            }
            this.f954a.f955a.a(this.f954a.getContext().getPackageManager().getLaunchIntentForPackage("com.facebook.orca"), this.f954a.getContext());
            Logger.a(2, EntryType.UI_INPUT_END, 1294281970, a);
        }
    }

    public static void m1009a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        DiodeLoginPromptFragment diodeLoginPromptFragment = (DiodeLoginPromptFragment) obj;
        SecureContextHelper secureContextHelper = (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector);
        Provider a = IdBasedProvider.a(fbInjector, 3597);
        AnalyticsLogger a2 = AnalyticsLoggerMethodAutoProvider.a(fbInjector);
        diodeLoginPromptFragment.f955a = secureContextHelper;
        diodeLoginPromptFragment.f956b = a;
        diodeLoginPromptFragment.f957c = a2;
    }

    public final void m1012c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = DiodeLoginPromptFragment.class;
        m1009a((Object) this, getContext());
    }

    public final View m1010a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1580360204);
        super.a(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(2130903917, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -689140926, a);
        return inflate;
    }

    public final void m1011a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        this.f958d = (FbButton) e(2131561056);
        this.f959e = (UserTileView) e(2131561048);
        this.f960f = (TextView) e(2131561055);
        this.f958d.setText(2131236601);
        this.f960f.setText(2131236600);
    }

    public final void m1013d(@Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1832854159);
        super.d(bundle);
        this.f958d.setOnClickListener(new C01511(this));
        this.f959e.setParams(UserTileViewParams.a((UserKey) this.f956b.get(), TileBadge.MESSENGER));
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -137199730, a);
    }
}

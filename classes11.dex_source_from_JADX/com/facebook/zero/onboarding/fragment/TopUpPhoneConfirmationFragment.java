package com.facebook.zero.onboarding.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.auth.annotations.LoggedInUser;
import com.facebook.base.fragment.FbFragment;
import com.facebook.fig.textinput.FigEditText;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbButton;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.titlebar.Fb4aTitleBar;
import com.facebook.user.model.User;
import com.facebook.user.model.UserPhoneNumber;
import com.facebook.zero.onboarding.FbLinkIncentiveActivity;
import com.facebook.zero.onboarding.adapter.InviteLinkSharingController;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: missing layout for place id = %s */
public class TopUpPhoneConfirmationFragment extends FbFragment {
    @Inject
    public InviteLinkSharingController f5382a;
    @Inject
    public FunnelLoggerImpl f5383b;
    @Inject
    @LoggedInUser
    public Provider<User> f5384c;
    private FbButton f5385d;
    public FigEditText f5386e;

    /* compiled from: missing layout for place id = %s */
    class C07061 implements OnClickListener {
        final /* synthetic */ TopUpPhoneConfirmationFragment f5380a;

        C07061(TopUpPhoneConfirmationFragment topUpPhoneConfirmationFragment) {
            this.f5380a = topUpPhoneConfirmationFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1187665893);
            if (this.f5380a.f5382a.m6600a(this.f5380a.f5386e.getText().toString())) {
                this.f5380a.f5383b.b(FunnelRegistry.F, "valid_phone_number_submit");
                this.f5380a.o().finish();
                LogUtils.a(1656257596, a);
                return;
            }
            this.f5380a.f5386e.setError(this.f5380a.jW_().getString(2131241777));
            this.f5380a.f5383b.b(FunnelRegistry.F, "error_phone_number_submit");
            Logger.a(2, EntryType.UI_INPUT_END, 428753464, a);
        }
    }

    /* compiled from: missing layout for place id = %s */
    public class C07072 implements OnClickListener {
        final /* synthetic */ TopUpPhoneConfirmationFragment f5381a;

        public C07072(TopUpPhoneConfirmationFragment topUpPhoneConfirmationFragment) {
            this.f5381a = topUpPhoneConfirmationFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -514290982);
            this.f5381a.f5383b.b(FunnelRegistry.F, "phone_confirmation_title_bar_back");
            this.f5381a.kO_().d();
            Logger.a(2, EntryType.UI_INPUT_END, 802019679, a);
        }
    }

    public static void m6611a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        TopUpPhoneConfirmationFragment topUpPhoneConfirmationFragment = (TopUpPhoneConfirmationFragment) obj;
        InviteLinkSharingController b = InviteLinkSharingController.m6597b(fbInjector);
        FunnelLoggerImpl a = FunnelLoggerImpl.a(fbInjector);
        Provider a2 = IdBasedProvider.a(fbInjector, 3595);
        topUpPhoneConfirmationFragment.f5382a = b;
        topUpPhoneConfirmationFragment.f5383b = a;
        topUpPhoneConfirmationFragment.f5384c = a2;
    }

    public final void m6614c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = TopUpPhoneConfirmationFragment.class;
        m6611a((Object) this, getContext());
    }

    public final View m6612a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1199325777);
        View inflate = layoutInflater.inflate(2130907523, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1681070267, a);
        return inflate;
    }

    public final void m6613a(View view, @Nullable Bundle bundle) {
        this.f5386e = (FigEditText) e(2131562240);
        this.f5385d = (FbButton) e(2131568066);
        this.f5383b.b(FunnelRegistry.F, "phone_confirmation_view_loaded");
        FragmentActivity o = o();
        if (o instanceof FbLinkIncentiveActivity) {
            Fb4aTitleBar fb4aTitleBar = ((FbLinkIncentiveActivity) o).f5349q;
            fb4aTitleBar.a(new C07072(this));
            fb4aTitleBar.setPrimaryButton(null);
        }
        User user = (User) this.f5384c.get();
        if (!user.r().isEmpty()) {
            this.f5386e.setText(((UserPhoneNumber) user.r().get(0)).b);
        }
        this.f5385d.setOnClickListener(new C07061(this));
    }
}

package com.facebook.zero.onboarding.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.auth.annotations.LoggedInUser;
import com.facebook.base.fragment.FbFragment;
import com.facebook.fig.textinput.FigEditText;
import com.facebook.funnellogger.FunnelLogger;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.growth.contactinviter.FreeFbJsonParams;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbButton;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.user.model.User;
import com.facebook.user.model.UserPhoneNumber;
import com.facebook.zero.onboarding.adapter.InviteLinkSharingController;
import com.facebook.zero.onboarding.utils.AssistedOnboardingLogger;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: modal */
public class FreeFacebookConfirmationFragment extends FbFragment {
    @Inject
    Lazy<AssistedOnboardingLogger> f5365a;
    public FigEditText al;
    @Inject
    public FreeFbJsonParams f5366b;
    @Inject
    FunnelLoggerImpl f5367c;
    @Inject
    InviteLinkSharingController f5368d;
    @Inject
    @LoggedInUser
    Provider<User> f5369e;
    public FbTextView f5370f;
    public FbTextView f5371g;
    public FbTextView f5372h;
    private FbButton f5373i;

    /* compiled from: modal */
    class C07031 implements OnClickListener {
        final /* synthetic */ FreeFacebookConfirmationFragment f5364a;

        C07031(FreeFacebookConfirmationFragment freeFacebookConfirmationFragment) {
            this.f5364a = freeFacebookConfirmationFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1066383000);
            this.f5364a.f5367c.b(FunnelRegistry.E, "confirmation_close");
            if (this.f5364a.f5368d.m6600a(this.f5364a.al.getText().toString()) || !this.f5364a.f5366b.i) {
                this.f5364a.ao().finish();
                LogUtils.a(-518220524, a);
                return;
            }
            this.f5364a.al.setError(this.f5364a.jW_().getString(2131241777));
            Logger.a(2, EntryType.UI_INPUT_END, -360830419, a);
        }
    }

    public static void m6602a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((FreeFacebookConfirmationFragment) obj).m6601a(IdBasedLazy.a(fbInjector, 11831), FreeFbJsonParams.a(fbInjector), FunnelLoggerImpl.a(fbInjector), InviteLinkSharingController.m6597b(fbInjector), IdBasedProvider.a(fbInjector, 3595));
    }

    private void m6601a(Lazy<AssistedOnboardingLogger> lazy, FreeFbJsonParams freeFbJsonParams, FunnelLogger funnelLogger, InviteLinkSharingController inviteLinkSharingController, Provider<User> provider) {
        this.f5365a = lazy;
        this.f5366b = freeFbJsonParams;
        this.f5367c = funnelLogger;
        this.f5368d = inviteLinkSharingController;
        this.f5369e = provider;
    }

    public final void m6605c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = FreeFacebookConfirmationFragment.class;
        m6602a((Object) this, getContext());
    }

    public final View m6603a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 790791587);
        View inflate = layoutInflater.inflate(2130904468, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -905280453, a);
        return inflate;
    }

    public final void m6604a(View view, @Nullable Bundle bundle) {
        String string;
        super.a(view, bundle);
        this.f5367c.b(FunnelRegistry.E, "confirmation_open");
        this.f5370f = (FbTextView) e(2131559439);
        this.f5371g = (FbTextView) e(2131559370);
        this.f5372h = (FbTextView) e(2131560983);
        this.f5373i = (FbButton) e(2131559737);
        this.al = (FigEditText) e(2131562240);
        FbTextView fbTextView = (FbTextView) e(2131562239);
        if (Strings.isNullOrEmpty(this.f5366b.c)) {
            string = jW_().getString(2131241766);
        } else {
            string = this.f5366b.c;
        }
        String str = string;
        if (Strings.isNullOrEmpty(this.f5366b.e)) {
            string = jW_().getString(2131241767);
        } else {
            string = this.f5366b.e;
        }
        String str2 = string;
        if (Strings.isNullOrEmpty(this.f5366b.g)) {
            string = jW_().getString(2131241768);
        } else {
            string = this.f5366b.g;
        }
        String str3 = string;
        this.f5370f.setText(str);
        this.f5370f.setContentDescription(str);
        this.f5371g.setText(str2);
        this.f5371g.setContentDescription(str2);
        this.f5372h.setText(str3);
        this.f5372h.setContentDescription(str3);
        this.f5373i.setOnClickListener(new C07031(this));
        if (this.f5366b.i) {
            this.f5372h.setGravity(0);
            User user = (User) this.f5369e.get();
            this.al.setVisibility(0);
            fbTextView.setVisibility(0);
            if (!user.r().isEmpty()) {
                this.al.setText(((UserPhoneNumber) user.r().get(0)).b);
            }
        }
        ((AssistedOnboardingLogger) this.f5365a.get()).m6628a(new HoneyClientEvent("fb_incentive_start_confirmation_fragment"));
    }
}

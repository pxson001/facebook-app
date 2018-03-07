package com.facebook.zero.onboarding.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.fig.bottomsheet.FigBottomSheetAdapter;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.titlebar.Fb4aTitleBar;
import com.facebook.ui.titlebar.Fb4aTitleBar.OnActionButtonClickListener;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import com.facebook.zero.onboarding.FbLinkIncentiveActivity;
import com.facebook.zero.onboarding.adapter.InviteLinkSharingController;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mleType */
public class InviteLinkSharingFragment extends FbFragment {
    @Inject
    public FunnelLoggerImpl f5376a;
    @Inject
    public InviteLinkSharingController f5377b;
    private FigBottomSheetAdapter f5378c;
    private String f5379d;

    /* compiled from: mleType */
    public class C07041 implements OnClickListener {
        final /* synthetic */ InviteLinkSharingFragment f5374a;

        public C07041(InviteLinkSharingFragment inviteLinkSharingFragment) {
            this.f5374a = inviteLinkSharingFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 854768907);
            this.f5374a.f5376a.b(FunnelRegistry.F, "link_share_title_bar_back");
            this.f5374a.o().finish();
            Logger.a(2, EntryType.UI_INPUT_END, -22649834, a);
        }
    }

    /* compiled from: mleType */
    public class C07052 implements OnActionButtonClickListener {
        final /* synthetic */ InviteLinkSharingFragment f5375a;

        public C07052(InviteLinkSharingFragment inviteLinkSharingFragment) {
            this.f5375a = inviteLinkSharingFragment;
        }

        public final void m6606a(View view) {
            TopUpPhoneConfirmationFragment topUpPhoneConfirmationFragment = new TopUpPhoneConfirmationFragment();
            FragmentTransaction a = this.f5375a.kO_().a();
            a.b(2131558429, topUpPhoneConfirmationFragment);
            a.a(null);
            a.b();
        }
    }

    public static void m6607a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        InviteLinkSharingFragment inviteLinkSharingFragment = (InviteLinkSharingFragment) obj;
        FunnelLoggerImpl a = FunnelLoggerImpl.a(fbInjector);
        InviteLinkSharingController b = InviteLinkSharingController.m6597b(fbInjector);
        inviteLinkSharingFragment.f5376a = a;
        inviteLinkSharingFragment.f5377b = b;
    }

    public final void m6610c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = InviteLinkSharingFragment.class;
        m6607a((Object) this, getContext());
    }

    public final View m6608a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1237905995);
        Bundle bundle2 = this.s;
        if (this.f5379d != null) {
            this.f5379d = bundle2.getString("amount");
        } else {
            this.f5379d = "";
            this.f5376a.b(FunnelRegistry.F, "top_up_value_null");
        }
        View inflate = layoutInflater.inflate(2130904895, viewGroup, false);
        LogUtils.f(-439380752, a);
        return inflate;
    }

    public final void m6609a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        FragmentActivity o = o();
        if (o instanceof FbLinkIncentiveActivity) {
            Fb4aTitleBar fb4aTitleBar = ((FbLinkIncentiveActivity) o).f5349q;
            fb4aTitleBar.a(new C07041(this));
            Builder a = TitleBarButtonSpec.a();
            a.g = jW_().getString(2131230744);
            fb4aTitleBar.setPrimaryButton(a.a());
            fb4aTitleBar.setActionButtonOnClickListener(new C07052(this));
        }
        RecyclerView recyclerView = (RecyclerView) e(2131563123);
        recyclerView.setLayoutManager(new LinearLayoutManager(o()));
        this.f5378c = this.f5377b.m6598a(o(), this.f5379d);
        recyclerView.setAdapter(this.f5378c);
    }
}

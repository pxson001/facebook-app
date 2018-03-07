package com.facebook.katana.orca;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.forcemessenger.ClickThroughDestination;
import com.facebook.messaging.forcemessenger.ForceMessenger;
import com.facebook.messaging.forcemessenger.annotations.IsQpInDiodeDisabled;
import com.facebook.messaging.util.MessengerAppUtils;
import com.facebook.quickpromotion.controller.QuickPromotionController;
import com.facebook.quickpromotion.ui.QuickPromotionFragmentFactory;
import com.facebook.quickpromotion.ui.QuickPromotionThreadListInterstitialController;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.listview.ScrollableListContainer;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: unregister */
public class DiodeHostFragment extends FbFragment implements ScrollableListContainer {
    @Inject
    public InterstitialManager f947a;
    @Inject
    MessengerAppUtils f948b;
    @Inject
    public QuickPromotionFragmentFactory f949c;
    @IsQpInDiodeDisabled
    @Inject
    public Provider<Boolean> f950d;
    @Inject
    ForceMessenger f951e;
    public ClickThroughDestination f952f = ClickThroughDestination.THREAD_LIST;
    @Nullable
    private Fragment f953g;

    public static void m1000a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((DiodeHostFragment) obj).m999a(InterstitialManager.a(fbInjector), MessengerAppUtils.a(fbInjector), QuickPromotionFragmentFactory.a(fbInjector), IdBasedProvider.a(fbInjector, 4159), ForceMessenger.a(fbInjector));
    }

    private void m999a(InterstitialManager interstitialManager, MessengerAppUtils messengerAppUtils, QuickPromotionFragmentFactory quickPromotionFragmentFactory, Provider<Boolean> provider, ForceMessenger forceMessenger) {
        this.f947a = interstitialManager;
        this.f948b = messengerAppUtils;
        this.f949c = quickPromotionFragmentFactory;
        this.f950d = provider;
        this.f951e = forceMessenger;
    }

    private void ar() {
        this.f953g = new DiodeEnableMessengerFragment();
        m1001b();
    }

    private void aq() {
        this.f953g = new DiodeLoginPromptFragment();
        m1001b();
    }

    private void as() {
        this.f953g = new DiodeSwitchAccountFragment();
        m1001b();
    }

    public final void m1005c(Bundle bundle) {
        super.c(bundle);
        Class cls = DiodeHostFragment.class;
        m1000a(this, getContext());
    }

    public final void m1006d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 265885756);
        super.d(bundle);
        Bundle bundle2 = this.s;
        if (bundle2 != null && bundle2.containsKey("click_through")) {
            this.f952f = (ClickThroughDestination) bundle2.getSerializable("click_through");
        } else if (ao().getIntent().hasExtra("click_through")) {
            this.f952f = (ClickThroughDestination) ao().getIntent().getSerializableExtra("click_through");
        }
        LogUtils.f(505372358, a);
    }

    public final void m1004a(Fragment fragment) {
        super.a(fragment);
        this.f953g = fragment;
    }

    public final View m1003a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1992002348);
        super.a(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(2130903911, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1887887610, a);
        return inflate;
    }

    public final void m1002G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -941100598);
        super.G();
        if (this.f948b.a()) {
            if (!this.f948b.b()) {
                ar();
            } else if (this.f951e.b()) {
                aq();
            } else if (this.f951e.c()) {
                as();
            }
            LogUtils.f(-366647743, a);
            return;
        }
        if (this.f953g == null || !(this.f953g instanceof DiodeQpFragment) || ((this.f953g instanceof DiodeQpFragment) && ((DiodeQpFragment) this.f953g).am)) {
            DiodeStaticFallbackFragment diodeStaticFallbackFragment;
            if (((Boolean) this.f950d.get()).booleanValue()) {
                diodeStaticFallbackFragment = new DiodeStaticFallbackFragment();
            } else {
                QuickPromotionController quickPromotionController = (QuickPromotionController) this.f947a.a(this.f952f.getTriggerForDestination(), QuickPromotionThreadListInterstitialController.class);
                if (quickPromotionController == null) {
                    diodeStaticFallbackFragment = new DiodeStaticFallbackFragment();
                } else {
                    diodeStaticFallbackFragment = this.f949c.a(quickPromotionController.a(getContext()));
                    if (diodeStaticFallbackFragment == null) {
                        diodeStaticFallbackFragment = new DiodeStaticFallbackFragment();
                    }
                }
            }
            this.f953g = diodeStaticFallbackFragment;
            m1001b();
        }
        LogUtils.f(-1867047375, a);
    }

    public final void m1007g(boolean z) {
        super.g(z);
        if (this.f953g != null) {
            this.f953g.g(z);
        }
    }

    public final void gB_() {
        if (this.f953g instanceof ScrollableListContainer) {
            ((ScrollableListContainer) this.f953g).gB_();
        }
    }

    public final boolean gC_() {
        if (this.f953g instanceof ScrollableListContainer) {
            return ((ScrollableListContainer) this.f953g).gC_();
        }
        return true;
    }

    @Nullable
    public final ScrollingViewProxy m1008n() {
        if (this.f953g instanceof ScrollableListContainer) {
            return ((ScrollableListContainer) this.f953g).n();
        }
        return null;
    }

    private void m1001b() {
        Preconditions.checkNotNull(this.f953g);
        this.f953g.g(D());
        s().a().b(2131561032, this.f953g).b();
    }
}

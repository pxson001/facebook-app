package com.facebook.placetips.upsell;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.feedplugins.placetips.PlaceTipsFeedAdapter;
import com.facebook.feedplugins.placetips.PlaceTipsFeedAdapter$10;
import com.facebook.feedplugins.placetips.PlaceTipsFeedAdapter$9;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.placetips.settings.PlaceTipsSettingsPrefs;
import com.facebook.placetips.settings.PlaceTipsSettingsPrefs.Accessor;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: cancel audio annotation auto play failed */
public class PlaceTipsUpsellContainerFragment extends FbDialogFragment implements PlaceTipsUpsellController {
    private static final int ap = 2131566068;
    @Inject
    public Lazy<Accessor> am;
    @Inject
    public PlaceTipsUpsellAnalyticsLogger an;
    @Inject
    public Toaster ao;
    private final Supplier<UpsellFragmentParams> aq = Suppliers.memoize(new C20401(this));
    @Nullable
    public PlaceTipsFeedAdapter$10 ar;
    @Nullable
    public PlaceTipsFeedAdapter$9 as;

    /* compiled from: cancel audio annotation auto play failed */
    class C20401 implements Supplier<UpsellFragmentParams> {
        final /* synthetic */ PlaceTipsUpsellContainerFragment f18507a;

        C20401(PlaceTipsUpsellContainerFragment placeTipsUpsellContainerFragment) {
            this.f18507a = placeTipsUpsellContainerFragment;
        }

        public Object get() {
            return (UpsellFragmentParams) Preconditions.checkNotNull((UpsellFragmentParams) ((Bundle) Preconditions.checkNotNull(this.f18507a.s)).getParcelable("upsell_params"));
        }
    }

    /* compiled from: cancel audio annotation auto play failed */
    class C20412 implements OnKeyListener {
        final /* synthetic */ PlaceTipsUpsellContainerFragment f18508a;

        C20412(PlaceTipsUpsellContainerFragment placeTipsUpsellContainerFragment) {
            this.f18508a = placeTipsUpsellContainerFragment;
        }

        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            return keyEvent.getAction() == 1 && i == 4 && this.f18508a.O_();
        }
    }

    public static void m22423a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        PlaceTipsUpsellContainerFragment placeTipsUpsellContainerFragment = (PlaceTipsUpsellContainerFragment) obj;
        Lazy a = IdBasedLazy.a(fbInjector, 3022);
        PlaceTipsUpsellAnalyticsLogger a2 = PlaceTipsUpsellAnalyticsLogger.a(fbInjector);
        Toaster b = Toaster.b(fbInjector);
        placeTipsUpsellContainerFragment.am = a;
        placeTipsUpsellContainerFragment.an = a2;
        placeTipsUpsellContainerFragment.ao = b;
    }

    public final void m22430a(@Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1060811251);
        super.a(bundle);
        Class cls = PlaceTipsUpsellContainerFragment.class;
        m22423a((Object) this, getContext());
        a(1, 2131626273);
        this.an.d.a(true);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -174971717, a);
    }

    public final View m22429a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1670367372);
        View inflate = layoutInflater.inflate(2130906287, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1384136832, a);
        return inflate;
    }

    public final void m22431a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        if (s().a(ap) == null) {
            aw();
        }
    }

    public final Dialog m22432c(Bundle bundle) {
        Dialog c = super.c(bundle);
        c.setOnKeyListener(new C20412(this));
        return c;
    }

    public final boolean O_() {
        this.an.a(PlaceTipsUpsellAnalyticsEvent.LOCATION_OPT_IN_BACK_BUTTON_PRESSED);
        return super.O_();
    }

    public final void m22427G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 920687062);
        super.G();
        Bundle bundle = (Bundle) Preconditions.checkNotNull(this.s);
        if (!bundle.getBoolean("marked_as_seen", false)) {
            Accessor accessor = (Accessor) this.am.get();
            accessor.b.edit().a(PlaceTipsSettingsPrefs.c, accessor.g() + 1).a(PlaceTipsSettingsPrefs.d, accessor.d.a()).commit();
            bundle.putBoolean("marked_as_seen", true);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -645156165, a);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.an.b();
        aA();
        super.onDismiss(dialogInterface);
    }

    public final void m22428I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1020420665);
        this.an.b();
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1600341292, a);
    }

    public final void aq() {
        int ax = ax() + 1;
        if (ax >= ((UpsellFragmentParams) this.aq.get()).f18543a.length) {
            m22426h(true);
            return;
        }
        m22424b(m22425g(ax));
        ((Bundle) Preconditions.checkNotNull(this.s)).putInt("current_page", ax);
    }

    public final void ar() {
        m22426h(true);
    }

    public final void as() {
        m22426h(false);
    }

    public final void at() {
        m22424b(UpsellPage.NETWORK_ERROR.createNewFragment());
    }

    public final void au() {
        Fragment createNewFragment = ((UpsellFragmentParams) this.aq.get()).m22464a(ax()).f18545a.createNewFragment();
        if (createNewFragment instanceof PlaceTipsUpsellTurnOnNotificationsFragment) {
            ((PlaceTipsUpsellTurnOnNotificationsFragment) createNewFragment).f18538g = true;
        }
        m22424b(createNewFragment);
    }

    public final UpsellPageConfig av() {
        return ((UpsellFragmentParams) this.aq.get()).m22464a(ax());
    }

    private void aw() {
        s().a().a(ap, m22425g(0)).b();
    }

    private void m22424b(Fragment fragment) {
        s().a().b(ap, fragment).a(4099).b();
    }

    private void m22426h(boolean z) {
        if (z) {
            ((Accessor) this.am.get()).b.edit().putBoolean(PlaceTipsSettingsPrefs.e, true).commit();
            if (this.ar != null) {
                PlaceTipsFeedAdapter$10 placeTipsFeedAdapter$10 = this.ar;
                PlaceTipsFeedAdapter.a(placeTipsFeedAdapter$10.f12907c, placeTipsFeedAdapter$10.f12905a, placeTipsFeedAdapter$10.f12906b);
            }
            this.ao.a(new ToastBuilder(2131239604));
        }
        if (((Bundle) Preconditions.checkNotNull(this.s)).getBoolean("finish_activity_on_dismiss", false)) {
            aA();
            o().finish();
            return;
        }
        a();
    }

    private void aA() {
        if (this.as != null) {
            AdapterDetour.a(this.as.f12912a, 1257766775);
        }
    }

    private Fragment m22425g(int i) {
        UpsellFragmentParams upsellFragmentParams = (UpsellFragmentParams) this.aq.get();
        Fragment createNewFragment = upsellFragmentParams.m22464a(i).f18545a.createNewFragment();
        String str = upsellFragmentParams.f18544b;
        if (str != null) {
            Bundle bundle = new Bundle();
            bundle.putString("place_name", str);
            createNewFragment.g(bundle);
        }
        return createNewFragment;
    }

    private int ax() {
        return ((Bundle) Preconditions.checkNotNull(this.s)).getInt("current_page", 0);
    }
}

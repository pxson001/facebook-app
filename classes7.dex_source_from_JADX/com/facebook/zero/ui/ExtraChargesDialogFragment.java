package com.facebook.zero.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import com.facebook.dialtone.common.IsDialtoneEnabled;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.iorg.common.upsell.model.UpsellDialogViewModel;
import com.facebook.iorg.common.upsell.ui.UpsellDialogView;
import com.facebook.iorg.common.upsell.ui.handlers.UpsellDontShowAgainHandler;
import com.facebook.iorg.common.zero.ui.ZeroDialogFragment;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.zero.FbZeroFeatureVisibilityHelper;
import com.facebook.zero.upsell.ui.ZeroUpsellDontShowAgainHandler;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: weather_tap_action */
public class ExtraChargesDialogFragment extends ZeroDialogFragment {
    @Inject
    public FbSharedPreferences av;
    @Inject
    @IsDialtoneEnabled
    public Provider<Boolean> aw;
    @Inject
    public FbZeroFeatureVisibilityHelper ax;
    @Inject
    public UpsellDontShowAgainHandler ay;
    public boolean az = false;

    /* compiled from: weather_tap_action */
    class C00371 implements OnClickListener {
        final /* synthetic */ ExtraChargesDialogFragment f251a;

        C00371(ExtraChargesDialogFragment extraChargesDialogFragment) {
            this.f251a = extraChargesDialogFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1728633757);
            this.f251a.ar();
            Logger.a(2, EntryType.UI_INPUT_END, 1115818274, a);
        }
    }

    /* compiled from: weather_tap_action */
    class C00382 implements OnClickListener {
        final /* synthetic */ ExtraChargesDialogFragment f252a;

        C00382(ExtraChargesDialogFragment extraChargesDialogFragment) {
            this.f252a = extraChargesDialogFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 645650244);
            if (this.f252a.az) {
                this.f252a.ay.a(this.f252a.ar);
            }
            this.f252a.aq();
            Logger.a(2, EntryType.UI_INPUT_END, -1288728400, a);
        }
    }

    /* compiled from: weather_tap_action */
    class C00393 implements OnClickListener {
        final /* synthetic */ ExtraChargesDialogFragment f253a;

        C00393(ExtraChargesDialogFragment extraChargesDialogFragment) {
            this.f253a = extraChargesDialogFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 115318974);
            this.f253a.ar();
            Logger.a(2, EntryType.UI_INPUT_END, 809122026, a);
        }
    }

    /* compiled from: weather_tap_action */
    class C00404 implements OnCheckedChangeListener {
        final /* synthetic */ ExtraChargesDialogFragment f254a;

        C00404(ExtraChargesDialogFragment extraChargesDialogFragment) {
            this.f254a = extraChargesDialogFragment;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            this.f254a.az = z;
        }
    }

    public static void m244a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ExtraChargesDialogFragment extraChargesDialogFragment = (ExtraChargesDialogFragment) obj;
        FbSharedPreferences fbSharedPreferences = (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike);
        Provider a = IdBasedProvider.a(injectorLike, 3954);
        FbZeroFeatureVisibilityHelper a2 = FbZeroFeatureVisibilityHelper.a(injectorLike);
        UpsellDontShowAgainHandler upsellDontShowAgainHandler = (UpsellDontShowAgainHandler) ZeroUpsellDontShowAgainHandler.m343b(injectorLike);
        extraChargesDialogFragment.av = fbSharedPreferences;
        extraChargesDialogFragment.aw = a;
        extraChargesDialogFragment.ax = a2;
        extraChargesDialogFragment.ay = upsellDontShowAgainHandler;
    }

    public final void m246a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1245661339);
        super.a(bundle);
        Class cls = ExtraChargesDialogFragment.class;
        m244a(this, getContext());
        a(0, 2131624754);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -791834019, a);
    }

    public final Dialog m247c(Bundle bundle) {
        Dialog c = super.c(bundle);
        c.setCanceledOnTouchOutside(true);
        return c;
    }

    public final View m245a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1945914239);
        View linearLayout = new LinearLayout(getContext());
        linearLayout.setOnClickListener(new C00371(this));
        UpsellDialogViewModel a2 = new UpsellDialogViewModel().a(this.ap);
        a2.c = this.aq;
        a2 = a2.a(Boolean.valueOf(true)).b(b(2131230727), new C00393(this)).a(b(2131232941), new C00382(this));
        if (this.ay.b(this.ar)) {
            a2.p = new C00404(this);
        }
        UpsellDialogView upsellDialogView = new UpsellDialogView(getContext());
        upsellDialogView.a(a2);
        linearLayout.addView(upsellDialogView);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -607025387, a);
        return linearLayout;
    }

    protected final String aw() {
        return "zero_extra_charges_dialog_cancel";
    }

    protected final String av() {
        return "zero_extra_charges_dialog_confirm";
    }

    protected final String au() {
        return "zero_extra_charges_dialog_open";
    }
}

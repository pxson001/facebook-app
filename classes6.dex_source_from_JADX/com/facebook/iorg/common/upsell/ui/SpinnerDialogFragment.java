package com.facebook.iorg.common.upsell.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.facebook.iorg.common.upsell.model.UpsellDialogViewModel;
import com.facebook.iorg.common.zero.ui.ZeroDialogFragment;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: mBannerSubheader */
public class SpinnerDialogFragment extends ZeroDialogFragment {
    public static boolean av;
    public static String aw;
    public static String ax;

    /* compiled from: mBannerSubheader */
    class C07131 implements OnClickListener {
        final /* synthetic */ SpinnerDialogFragment f11352a;

        C07131(SpinnerDialogFragment spinnerDialogFragment) {
            this.f11352a = spinnerDialogFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 467673540);
            this.f11352a.ar();
            Logger.a(2, EntryType.UI_INPUT_END, -457380522, a);
        }
    }

    public final void m18145a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1671050051);
        super.a(bundle);
        a(0, 2131624754);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 333274244, a);
    }

    public final Dialog m18146c(Bundle bundle) {
        Dialog c = super.c(bundle);
        c.setCanceledOnTouchOutside(true);
        return c;
    }

    public final View m18144a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 512299323);
        View linearLayout = new LinearLayout(getContext());
        View upsellDialogView = new UpsellDialogView(getContext());
        if (av) {
            upsellDialogView.m18173a();
        } else {
            UpsellDialogViewModel a2 = new UpsellDialogViewModel().m18126a(aw);
            a2.f11255c = ax;
            upsellDialogView.m18174a(a2.m18127a(b(2131232870), new C07131(this)));
        }
        linearLayout.addView(upsellDialogView);
        LogUtils.f(-102796602, a);
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

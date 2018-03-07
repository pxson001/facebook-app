package com.facebook.payments.paymentsflow.uicomponents;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.facebook.common.util.FindViewUtil;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbButton;
import com.facebook.ui.dialogs.FbDialogFragment;

/* compiled from: iorg_optin_interstitial_shown */
public class DialogBase extends FbDialogFragment {
    public View am;
    private FrameLayout an;
    private FrameLayout ao;
    private FbButton ap;
    private FbButton aq;
    public ProgressBar ar;

    public void mo1087a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1055009366);
        super.a(bundle);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1276744797, a);
    }

    public View mo1086a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -689292028);
        View inflate = layoutInflater.inflate(2130904436, viewGroup, false);
        this.am = FindViewUtil.b(inflate, 2131561061);
        this.an = (FrameLayout) FindViewUtil.b(this.am, 2131559441);
        this.ao = (FrameLayout) FindViewUtil.b(this.am, 2131559769);
        this.aq = (FbButton) FindViewUtil.b(inflate, 2131559566);
        this.ap = (FbButton) FindViewUtil.b(inflate, 2131559565);
        this.ar = (ProgressBar) FindViewUtil.b(inflate, 2131560407);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1698896869, a);
        return inflate;
    }

    public static void m19195a(View view, boolean z) {
        if (z) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }
}

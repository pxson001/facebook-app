package com.facebook.payments.paymentsflow.uicomponents;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import javax.annotation.Nullable;

/* compiled from: io_exception */
public class LoadingDialog extends DialogBase {
    public static LoadingDialog aq() {
        return new LoadingDialog();
    }

    public final void mo1087a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 569109277);
        super.mo1087a(bundle);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1043121797, a);
    }

    public final View mo1086a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1774964155);
        View a2 = super.mo1086a(layoutInflater, viewGroup, bundle);
        this.f.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        a2.setBackgroundColor(jW_().getColor(2131361871));
        DialogBase.m19195a(this.ar, true);
        DialogBase.m19195a(this.am, 1 == null);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -421735611, a);
        return a2;
    }
}

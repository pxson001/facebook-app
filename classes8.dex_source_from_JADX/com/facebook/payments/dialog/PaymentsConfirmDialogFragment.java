package com.facebook.payments.dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.dialog.ConfirmActionDialogFragment;
import com.facebook.messaging.dialog.ConfirmActionParams;
import com.facebook.messaging.dialog.ConfirmActionParams.Builder;
import javax.annotation.Nullable;

/* compiled from: target_privacy_picker_group_selected */
public class PaymentsConfirmDialogFragment extends ConfirmActionDialogFragment {
    public Listener am;

    /* compiled from: target_privacy_picker_group_selected */
    public interface Listener {
        void mo84a();

        void mo72b();

        void mo73c();
    }

    /* compiled from: target_privacy_picker_group_selected */
    public abstract class SimpleListener implements Listener {
        public final void mo72b() {
        }

        public final void mo73c() {
        }
    }

    @Deprecated
    public static PaymentsConfirmDialogFragment m1952a(String str, String str2, String str3, @Nullable String str4, boolean z) {
        Builder builder = new Builder(str, str3);
        builder.f1496d = str2;
        builder = builder;
        builder.f1495c = str4;
        builder = builder;
        builder.f1498f = z;
        return m1953b(builder.m1678a());
    }

    public static PaymentsConfirmDialogFragment m1953b(ConfirmActionParams confirmActionParams) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("confirm_action_params", confirmActionParams);
        PaymentsConfirmDialogFragment paymentsConfirmDialogFragment = new PaymentsConfirmDialogFragment();
        paymentsConfirmDialogFragment.g(bundle);
        return paymentsConfirmDialogFragment;
    }

    public final void m1954a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1231048786);
        super.a(bundle);
        this.am = (ConfirmActionParams) this.s.getParcelable("confirm_action_params");
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 216511596, a);
    }

    protected final void as() {
        super.as();
        if (this.am != null) {
            this.am.mo73c();
        }
    }

    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        if (this.am != null) {
            this.am.mo73c();
        }
    }

    protected final void aq() {
        if (this.am != null) {
            this.am.mo84a();
        }
    }

    protected final void ar() {
        if (this.am != null) {
            this.am.mo72b();
        }
    }
}

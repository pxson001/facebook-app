package com.facebook.ui.dialogs;

import android.app.Dialog;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.dialog.ProgressDialog;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: commerce_empty_shop */
public class ProgressDialogFragment extends DialogFragment {
    private boolean al;
    private OnCancelListener am;
    private OnDismissListener an;

    public final Dialog m10334c(Bundle bundle) {
        Bundle bundle2 = this.s;
        CharSequence string = bundle2.getString("title");
        CharSequence string2 = bundle2.getString("message");
        int i = bundle2.getInt("message_res_id");
        boolean z = bundle2.getBoolean("is_indeterminate", true);
        boolean z2 = bundle2.getBoolean("is_cancelable", true);
        this.al = bundle2.getBoolean("dismiss_on_pause");
        int i2 = bundle2.getInt("window_type");
        ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.f3133d = 0;
        progressDialog.m4247a(z);
        progressDialog.setCancelable(z2);
        d_(z2);
        if (!TextUtils.isEmpty(string)) {
            progressDialog.setTitle(string);
        }
        if (i > 0) {
            progressDialog.a(a(i));
        } else if (!StringUtil.a(string2)) {
            progressDialog.a(string2);
        }
        if (this.am != null) {
            progressDialog.setOnCancelListener(this.am);
        }
        if (this.an != null) {
            progressDialog.setOnDismissListener(this.an);
        }
        if (i2 > 0) {
            progressDialog.getWindow().setType(i2);
        }
        return progressDialog;
    }

    public final void m10330H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -762476386);
        if (this.al) {
            b();
        }
        super.H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 50989784, a);
    }

    public static DialogFragment m10329a(String str, boolean z, boolean z2) {
        return m10328a(str, -1, z, z2, false);
    }

    public static DialogFragment m10326a(int i, boolean z, boolean z2) {
        return m10328a("", i, z, z2, false);
    }

    public static DialogFragment m10327a(int i, boolean z, boolean z2, boolean z3) {
        return m10328a("", i, z, z2, z3);
    }

    private static DialogFragment m10328a(String str, int i, boolean z, boolean z2, boolean z3) {
        ProgressDialogFragment progressDialogFragment = new ProgressDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString("message", str);
        bundle.putInt("message_res_id", i);
        bundle.putBoolean("is_indeterminate", z);
        bundle.putBoolean("is_cancelable", z2);
        bundle.putBoolean("dismiss_on_pause", z3);
        progressDialogFragment.g(bundle);
        return progressDialogFragment;
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1271506774);
        super.mY_();
        this.am = null;
        this.an = null;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 538144897, a);
    }

    public final void m10331a(OnCancelListener onCancelListener) {
        if (this.f != null) {
            this.f.setOnCancelListener(onCancelListener);
        } else {
            this.am = onCancelListener;
        }
    }

    public final void m10332a(OnDismissListener onDismissListener) {
        if (this.f != null) {
            this.f.setOnDismissListener(onDismissListener);
        } else {
            this.an = onDismissListener;
        }
    }

    public final void m10333a(CharSequence charSequence) {
        if (this.f != null) {
            this.f.setTitle(charSequence);
        } else {
            this.s.putString("title", charSequence.toString());
        }
    }

    public final boolean an() {
        return this.f != null && this.f.isShowing();
    }

    public final void m10335e(int i) {
        if (this.f != null) {
            this.f.getWindow().setType(i);
        } else {
            this.s.putInt("window_type", i);
        }
    }
}

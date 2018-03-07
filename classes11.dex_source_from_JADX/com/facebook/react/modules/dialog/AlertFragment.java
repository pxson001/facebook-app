package com.facebook.react.modules.dialog;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import javax.annotation.Nullable;

/* compiled from: SIZE_32 */
public class AlertFragment extends DialogFragment implements OnClickListener {
    @Nullable
    private final AlertFragmentListener f11396a;

    public AlertFragment() {
        this.f11396a = null;
    }

    public AlertFragment(@Nullable AlertFragmentListener alertFragmentListener, Bundle bundle) {
        this.f11396a = alertFragmentListener;
        setArguments(bundle);
    }

    public static Dialog m11736a(Context context, Bundle bundle, OnClickListener onClickListener) {
        Builder title = new Builder(context).setTitle(bundle.getString("title"));
        if (bundle.containsKey("button_positive")) {
            title.setPositiveButton(bundle.getString("button_positive"), onClickListener);
        }
        if (bundle.containsKey("button_negative")) {
            title.setNegativeButton(bundle.getString("button_negative"), onClickListener);
        }
        if (bundle.containsKey("button_neutral")) {
            title.setNeutralButton(bundle.getString("button_neutral"), onClickListener);
        }
        if (bundle.containsKey("message")) {
            title.setMessage(bundle.getString("message"));
        }
        if (bundle.containsKey("items")) {
            title.setItems(bundle.getCharSequenceArray("items"), onClickListener);
        }
        return title.create();
    }

    public Dialog onCreateDialog(Bundle bundle) {
        return m11736a(getActivity(), getArguments(), this);
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f11396a != null) {
            this.f11396a.onClick(dialogInterface, i);
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (this.f11396a != null) {
            this.f11396a.onDismiss(dialogInterface);
        }
    }
}

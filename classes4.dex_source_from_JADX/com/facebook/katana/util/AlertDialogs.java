package com.facebook.katana.util;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.fbui.dialog.AlertDialog.Builder;

/* compiled from: translated_body_for_viewer */
public class AlertDialogs {
    public static AlertDialog m1102a(Context context, String str, int i, String str2, String str3, OnClickListener onClickListener, String str4, OnClickListener onClickListener2, OnCancelListener onCancelListener, boolean z) {
        return m1101a(context, str, i, (Object) str2, str3, onClickListener, str4, onClickListener2, onCancelListener, z);
    }

    private static AlertDialog m1101a(Context context, String str, int i, Object obj, String str2, OnClickListener onClickListener, String str3, OnClickListener onClickListener2, OnCancelListener onCancelListener, boolean z) {
        Builder builder = new Builder(context);
        builder.m14337a((CharSequence) str);
        if (i != 0) {
            builder.m14333a(context.getResources().getDrawable(i));
        }
        if (obj instanceof String) {
            builder.m14346b((String) obj);
        } else if (obj instanceof View) {
            builder.m14345b((View) obj);
        }
        builder.mo963a((CharSequence) str2, onClickListener);
        builder.mo966b((CharSequence) str3, onClickListener2);
        builder.m14331a(onCancelListener);
        builder.m14339a(z);
        return builder.mo964a();
    }
}

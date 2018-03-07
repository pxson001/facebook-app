package com.facebook.zero;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;

/* compiled from: com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG */
public class MessageCapReachedDialogBuilder extends FbAlertDialogBuilder {
    private Resources f20248a;
    private int f20249b;
    private String f20250c;
    private OnClickListener f20251d;

    public MessageCapReachedDialogBuilder(Context context, int i, String str, OnClickListener onClickListener) {
        super(context);
        this.f20248a = context.getResources();
        this.f20249b = i;
        this.f20250c = str;
        this.f20251d = onClickListener;
    }

    public final MessageCapReachedDialogBuilder m28857f() {
        String string;
        String string2;
        CharSequence string3 = this.f20248a.getString(2131232882);
        if (this.f20249b > 0) {
            string = this.f20248a.getString(2131232877, new Object[]{Integer.valueOf(this.f20249b), this.f20250c});
            string2 = this.f20248a.getString(2131232883, new Object[]{this.f20250c});
        } else {
            string = this.f20248a.getString(2131232884, new Object[]{this.f20250c});
            string2 = this.f20248a.getString(2131232885);
        }
        CharSequence charSequence = string + "\n\n" + string2;
        Spannable spannableString = new SpannableString(this.f20248a.getString(2131230727).toUpperCase());
        spannableString.setSpan(new ForegroundColorSpan(2131362675), 0, spannableString.length(), 0);
        a(string3).b(charSequence).a(this.f20248a.getString(2131232886), this.f20251d).c(2131230727, null).a(true);
        return this;
    }
}

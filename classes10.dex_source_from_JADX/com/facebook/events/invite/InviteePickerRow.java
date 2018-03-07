package com.facebook.events.invite;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.tokenizedtypeahead.model.BaseToken;

/* compiled from: chat_colors_inline */
public class InviteePickerRow extends CustomFrameLayout {
    private static final CallerContext f17736a = CallerContext.a(InviteePickerRow.class);
    private final TextView f17737b = ((TextView) c(2131561318));
    private final TextView f17738c = ((TextView) c(2131561319));
    private final FbDraweeView f17739d = ((FbDraweeView) c(2131561317));
    private final RadioButton f17740e = ((RadioButton) c(2131561316));
    private final View f17741f = c(2131561320);

    public InviteePickerRow(Context context) {
        super(context);
        setContentView(2130904045);
    }

    public final void m18067a(BaseToken baseToken, boolean z) {
        boolean z2 = true;
        this.f17737b.setText(baseToken.b());
        this.f17738c.setText(baseToken.l());
        if (baseToken.a()) {
            this.f17741f.setVisibility(8);
            this.f17740e.setEnabled(true);
        } else {
            this.f17741f.setVisibility(0);
            this.f17740e.setEnabled(false);
        }
        if (baseToken.k()) {
            RadioButton radioButton = this.f17740e;
            if (!z && baseToken.a()) {
                z2 = false;
            }
            radioButton.setChecked(z2);
        } else {
            this.f17740e.setVisibility(8);
        }
        if (baseToken.i() != null) {
            this.f17739d.a(Uri.parse(baseToken.i()), f17736a);
        }
        this.f17739d.setVisibility(0);
    }
}

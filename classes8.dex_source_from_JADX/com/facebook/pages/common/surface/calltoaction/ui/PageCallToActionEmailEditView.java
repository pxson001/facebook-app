package com.facebook.pages.common.surface.calltoaction.ui;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.util.AttributeSet;
import android.util.Patterns;
import android.view.View;
import android.widget.TextView;
import com.facebook.common.util.StringUtil;
import com.facebook.pages.common.surface.calltoaction.ui.PageCallToActionInputFactory.CallToActionFieldLogger;
import com.facebook.pages.common.surface.calltoaction.util.PageCallToActionUtil;
import com.facebook.pages.common.surface.calltoaction.util.PageCallToActionUtil.PageCallToActionErrorState;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.text.BetterEditTextView;

/* compiled from: coverImage */
public class PageCallToActionEmailEditView extends CustomRelativeLayout implements PageCallToActionInput {
    private BetterEditTextView f16803a;
    private FbTextView f16804b;
    private int f16805c;
    private CallToActionFieldLogger f16806d;

    public PageCallToActionEmailEditView(Context context) {
        super(context);
        m20046f();
    }

    public PageCallToActionEmailEditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m20046f();
    }

    public PageCallToActionEmailEditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m20046f();
    }

    public View getView() {
        return this;
    }

    public final boolean mo1032a() {
        return true;
    }

    public String getValue() {
        return PageCallToActionUtil.m20174d(this.f16803a.getText().toString());
    }

    public final PageCallToActionErrorState mo1033b() {
        if (StringUtil.a(this.f16803a.getText().toString())) {
            return PageCallToActionErrorState.EMPTY;
        }
        boolean z;
        CharSequence value = getValue();
        if (StringUtil.a(value)) {
            z = false;
        } else {
            z = Patterns.EMAIL_ADDRESS.matcher(value).find();
        }
        return z ? PageCallToActionErrorState.NONE : PageCallToActionErrorState.INVALID;
    }

    public final void mo1034c() {
        int i;
        this.f16803a.getBackground().setColorFilter(this.f16805c, Mode.SRC_IN);
        this.f16804b.setVisibility(0);
        TextView textView = (TextView) this.f16804b.findViewById(2131565380);
        if (StringUtil.a(this.f16803a.getText().toString())) {
            i = 2131239571;
        } else {
            i = 2131239572;
        }
        textView.setText(getContext().getResources().getString(i));
        this.f16806d.mo1039a(r1);
    }

    public final void mo1035d() {
        this.f16803a.getBackground().setColorFilter(getResources().getColor(2131361918), Mode.SRC_IN);
        this.f16803a.requestFocus();
    }

    public final void mo1036e() {
        this.f16803a.getBackground().clearColorFilter();
        this.f16804b.setVisibility(8);
    }

    private void setHint(CharSequence charSequence) {
        this.f16803a.setHint(charSequence);
    }

    private void setText(CharSequence charSequence) {
        this.f16803a.setText(charSequence);
    }

    private void m20046f() {
        setContentView(2130905972);
        this.f16803a = ((PageCallToActionTextWithClearButtonEditView) a(2131565379)).f16867a;
        this.f16803a.setInputType(32);
        this.f16804b = (FbTextView) a(2131565380);
        this.f16805c = getResources().getColor(2131361918);
    }

    public final void m20047a(String str, String str2, CallToActionFieldLogger callToActionFieldLogger) {
        setHint(str);
        if (!StringUtil.a(str2)) {
            setText(str2);
        }
        this.f16806d = callToActionFieldLogger;
    }
}

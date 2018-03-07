package com.facebook.pages.common.surface.calltoaction.ui;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.pages.common.surface.calltoaction.ui.PageCallToActionInputFactory.CallToActionFieldLogger;
import com.facebook.pages.common.surface.calltoaction.util.PageCallToActionUtil;
import com.facebook.pages.common.surface.calltoaction.util.PageCallToActionUtil.PageCallToActionErrorState;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.text.BetterEditTextView;

/* compiled from: could not extract color reference from =  */
public class PageCallToActionUrlEditView extends CustomRelativeLayout implements PageCallToActionInput {
    private BetterEditTextView f16875a;
    private ImageBlockLayout f16876b;
    private int f16877c;
    private CallToActionFieldLogger f16878d;

    public PageCallToActionUrlEditView(Context context) {
        super(context);
        m20149f();
    }

    public PageCallToActionUrlEditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m20149f();
    }

    public PageCallToActionUrlEditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m20149f();
    }

    public View getView() {
        return this;
    }

    public final boolean mo1032a() {
        return true;
    }

    public String getValue() {
        return PageCallToActionUtil.m20172c(this.f16875a.getText().toString());
    }

    public final PageCallToActionErrorState mo1033b() {
        if (StringUtil.a(this.f16875a.getText().toString())) {
            return PageCallToActionErrorState.EMPTY;
        }
        return PageCallToActionUtil.m20169a(getValue()) ? PageCallToActionErrorState.NONE : PageCallToActionErrorState.INVALID;
    }

    public final void mo1034c() {
        int i;
        this.f16875a.getBackground().setColorFilter(this.f16877c, Mode.SRC_IN);
        this.f16876b.setVisibility(0);
        TextView textView = (TextView) this.f16876b.findViewById(2131565380);
        if (StringUtil.a(this.f16875a.getText().toString())) {
            i = 2131239569;
        } else {
            i = 2131239573;
        }
        textView.setText(getContext().getResources().getString(i));
        this.f16878d.mo1039a(r1);
    }

    public final void mo1035d() {
    }

    public final void mo1036e() {
        this.f16875a.getBackground().clearColorFilter();
        this.f16876b.setVisibility(8);
    }

    private void setText(CharSequence charSequence) {
        this.f16875a.setText(charSequence);
    }

    private void m20149f() {
        setContentView(2130905992);
        this.f16875a = (BetterEditTextView) a(2131565377);
        this.f16876b = (ImageBlockLayout) a(2131565378);
        this.f16877c = getResources().getColor(2131361918);
    }

    public final void m20150a(String str, CallToActionFieldLogger callToActionFieldLogger) {
        if (!StringUtil.a(str)) {
            setText(str);
        }
        this.f16878d = callToActionFieldLogger;
    }
}

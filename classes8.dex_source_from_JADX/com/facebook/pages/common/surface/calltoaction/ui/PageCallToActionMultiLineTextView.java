package com.facebook.pages.common.surface.calltoaction.ui;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.util.StringUtil;
import com.facebook.pages.common.surface.calltoaction.util.PageCallToActionUtil.PageCallToActionErrorState;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.text.BetterEditTextView;
import com.facebook.widget.text.BetterTextView;
import java.util.Observable;
import java.util.Observer;

/* compiled from: could not extract layout reference from =  */
public class PageCallToActionMultiLineTextView extends CustomRelativeLayout implements PageCallToActionInput, Observer {
    private BetterEditTextView f16845a;
    public BetterTextView f16846b;
    private int f16847c;
    private BetterTextView f16848d;
    private int f16849e;
    private final TextWatcher f16850f = new C18251(this);

    /* compiled from: could not extract layout reference from =  */
    class C18251 implements TextWatcher {
        final /* synthetic */ PageCallToActionMultiLineTextView f16844a;

        C18251(PageCallToActionMultiLineTextView pageCallToActionMultiLineTextView) {
            this.f16844a = pageCallToActionMultiLineTextView;
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            this.f16844a.f16846b.setText(this.f16844a.m20099a(editable));
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public PageCallToActionMultiLineTextView(Context context) {
        super(context);
        m20101f();
    }

    public PageCallToActionMultiLineTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m20101f();
    }

    public PageCallToActionMultiLineTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m20101f();
    }

    public View getView() {
        return this;
    }

    public final boolean mo1032a() {
        return true;
    }

    public String getValue() {
        return this.f16845a.getText().toString().trim();
    }

    public final PageCallToActionErrorState mo1033b() {
        if (getView().getVisibility() == 8) {
            return PageCallToActionErrorState.NONE;
        }
        return !StringUtil.a(getValue()) ? PageCallToActionErrorState.NONE : PageCallToActionErrorState.EMPTY;
    }

    public final void mo1034c() {
        this.f16845a.getBackground().setColorFilter(this.f16847c, Mode.SRC_IN);
        this.f16848d.setVisibility(0);
        this.f16848d.setText(getContext().getResources().getString(2131239566));
    }

    public final void mo1035d() {
        this.f16845a.getBackground().setColorFilter(getResources().getColor(2131361918), Mode.SRC_IN);
        this.f16848d.requestFocus();
    }

    public final void mo1036e() {
        this.f16845a.getBackground().clearColorFilter();
        this.f16848d.setVisibility(8);
    }

    private void m20101f() {
        setContentView(2130905981);
        this.f16849e = getResources().getInteger(2131492951);
        this.f16845a = (BetterEditTextView) a(2131565392);
        this.f16846b = (BetterTextView) a(2131565393);
        this.f16846b.setText(m20099a(this.f16845a.getText()));
        this.f16845a.addTextChangedListener(this.f16850f);
        this.f16848d = (BetterTextView) a(2131565380);
        this.f16847c = getResources().getColor(2131361918);
    }

    private String m20099a(Editable editable) {
        return Integer.toString(this.f16849e - editable.length());
    }

    public final void m20102a(String str, String str2) {
        this.f16845a.setHint(str);
        if (StringUtil.a(str2)) {
            this.f16845a.a();
        } else {
            this.f16845a.append(str2);
        }
    }

    public final void m20103a(String str, String str2, int i) {
        this.f16849e = i;
        m20102a(str, str2);
    }

    public void update(Observable observable, Object obj) {
        int i;
        int i2 = 0;
        Boolean bool = (Boolean) obj;
        if (bool == null || bool.booleanValue()) {
            i = 0;
        } else {
            i = 1;
        }
        if (i != 0) {
            i2 = 8;
        }
        getView().setVisibility(i2);
    }
}

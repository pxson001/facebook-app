package com.facebook.pages.common.surface.calltoaction.ui;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.surface.calltoaction.util.PageCallToActionUtil.PageCallToActionErrorState;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.text.BetterEditTextView;

/* compiled from: could not extract gravity from =  */
public class PageCallToActionTextWithClearButtonEditView extends CustomRelativeLayout implements PageCallToActionInput {
    public BetterEditTextView f16867a;
    private GlyphView f16868b;
    private final OnClickListener f16869c = new C18271(this);

    /* compiled from: could not extract gravity from =  */
    class C18271 implements OnClickListener {
        final /* synthetic */ PageCallToActionTextWithClearButtonEditView f16866a;

        C18271(PageCallToActionTextWithClearButtonEditView pageCallToActionTextWithClearButtonEditView) {
            this.f16866a = pageCallToActionTextWithClearButtonEditView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1457468571);
            this.f16866a.f16867a.a();
            Logger.a(2, EntryType.UI_INPUT_END, 1193891528, a);
        }
    }

    public PageCallToActionTextWithClearButtonEditView(Context context) {
        super(context);
        m20131f();
    }

    public PageCallToActionTextWithClearButtonEditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m20131f();
    }

    public PageCallToActionTextWithClearButtonEditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m20131f();
    }

    public View getView() {
        return this;
    }

    public final boolean mo1032a() {
        return true;
    }

    public String getValue() {
        return this.f16867a.getText().toString().trim();
    }

    public final PageCallToActionErrorState mo1033b() {
        return !StringUtil.a(getValue()) ? PageCallToActionErrorState.NONE : PageCallToActionErrorState.EMPTY;
    }

    public final void mo1034c() {
    }

    public final void mo1035d() {
        this.f16867a.getBackground().setColorFilter(getResources().getColor(2131361918), Mode.SRC_IN);
        this.f16867a.requestFocus();
    }

    public final void mo1036e() {
        this.f16867a.getBackground().clearColorFilter();
    }

    private void setHint(CharSequence charSequence) {
        this.f16867a.setHint(charSequence);
    }

    private void setText(CharSequence charSequence) {
        this.f16867a.setText(charSequence);
    }

    public BetterEditTextView getEditTextView() {
        return this.f16867a;
    }

    private void m20131f() {
        setContentView(2130905988);
        this.f16867a = (BetterEditTextView) a(2131565377);
        this.f16868b = (GlyphView) a(2131561099);
        this.f16868b.setOnClickListener(this.f16869c);
    }

    public final void m20132a(String str, String str2) {
        setHint(str);
        if (!StringUtil.a(str2)) {
            setText(str2);
        }
    }
}

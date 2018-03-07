package com.facebook.pages.common.surface.calltoaction.ui;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.util.AttributeSet;
import com.facebook.common.util.StringUtil;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterEditTextView;
import javax.annotation.Nullable;

/* compiled from: could not extract parseTypeface from =  */
public class PageCallToActionLinkoutGenericView extends CustomLinearLayout {
    private FbTextView f16841a;
    private FbTextView f16842b;
    private BetterEditTextView f16843c;

    public PageCallToActionLinkoutGenericView(Context context) {
        super(context);
        m20094a();
    }

    public PageCallToActionLinkoutGenericView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m20094a();
    }

    protected PageCallToActionLinkoutGenericView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m20094a();
    }

    private void m20094a() {
        setContentView(2130905980);
        this.f16841a = (FbTextView) findViewById(2131565389);
        this.f16843c = (BetterEditTextView) findViewById(2131565390);
        this.f16842b = (FbTextView) findViewById(2131565391);
    }

    public final PageCallToActionLinkoutGenericView m20095a(String str) {
        if (!StringUtil.a(str)) {
            this.f16841a.setVisibility(0);
            this.f16841a.setText(str);
        }
        return this;
    }

    public final PageCallToActionLinkoutGenericView m20096b(String str) {
        this.f16843c.setHint(str);
        return this;
    }

    public final PageCallToActionLinkoutGenericView m20097c(String str) {
        this.f16843c.setText(str);
        return this;
    }

    public String getEditText() {
        this.f16843c.getBackground().clearColorFilter();
        this.f16842b.setVisibility(8);
        return this.f16843c.getText().toString();
    }

    public void setError(String str) {
        this.f16843c.getBackground().setColorFilter(getResources().getColor(2131361918), Mode.SRC_IN);
        this.f16842b.setVisibility(0);
        this.f16842b.setText(str);
        this.f16842b.requestFocus();
    }
}

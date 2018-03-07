package com.facebook.pages.common.surface.calltoaction.ui;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.resources.ui.FbTextView;

/* compiled from: could not extract android color reference from =  */
public class PageSelectCallToActionTypeView extends ImageBlockLayout {
    private FbDraweeView f16879h;
    private FbTextView f16880i;

    public PageSelectCallToActionTypeView(Context context) {
        super(context);
        m20156a();
    }

    public PageSelectCallToActionTypeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m20156a();
    }

    public PageSelectCallToActionTypeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m20156a();
    }

    private void m20156a() {
        setContentView(2130906080);
        this.f16880i = (FbTextView) getView(2131565649);
        this.f16879h = (FbDraweeView) getView(2131565648);
    }

    public final PageSelectCallToActionTypeView m20157a(CharSequence charSequence) {
        this.f16880i.setText(charSequence);
        return this;
    }

    public final PageSelectCallToActionTypeView m20158a(String str) {
        this.f16879h.setImageURI(Uri.parse(str));
        return this;
    }
}

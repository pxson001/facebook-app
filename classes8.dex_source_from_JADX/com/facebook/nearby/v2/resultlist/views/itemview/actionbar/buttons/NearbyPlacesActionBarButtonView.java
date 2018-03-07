package com.facebook.nearby.v2.resultlist.views.itemview.actionbar.buttons;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: dafea9c3d22be5e8c367d3e87a5ff52a */
public class NearbyPlacesActionBarButtonView extends CustomLinearLayout {
    private static final Class<?> f16005f = NearbyPlacesActionBarButtonView.class;
    protected Context f16006a;
    protected final GlyphView f16007b;
    protected final TextView f16008c;
    protected final View f16009d;
    protected CallerContext f16010e;

    public NearbyPlacesActionBarButtonView(Context context) {
        this(context, null);
    }

    public NearbyPlacesActionBarButtonView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NearbyPlacesActionBarButtonView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130905400);
        this.f16006a = context;
        this.f16010e = CallerContext.a(f16005f);
        this.f16008c = (TextView) a(2131564137);
        this.f16009d = a(2131564138);
        this.f16007b = (GlyphView) a(2131564136);
        int imageResourceId = getImageResourceId();
        if (imageResourceId > 0) {
            this.f16007b.setImageDrawable(this.f16006a.getResources().getDrawable(imageResourceId));
        }
    }

    protected int getImageResourceId() {
        return 0;
    }

    public void setShowRightBorder(boolean z) {
        this.f16009d.setVisibility(z ? 0 : 8);
    }
}

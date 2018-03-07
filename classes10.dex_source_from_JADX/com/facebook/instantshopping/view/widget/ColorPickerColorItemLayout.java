package com.facebook.instantshopping.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingActionFragmentModel;
import com.facebook.instantshopping.view.block.ColorPickerItemView;

/* compiled from: SITE_ERROR */
public class ColorPickerColorItemLayout extends FrameLayout implements ColorPickerItemView {
    private PickerItemColorView f23858a;
    private PickerItemColorView f23859b;
    private PickerItemColorView f23860c;
    public InstantShoppingActionFragmentModel f23861d;
    private boolean f23862e;

    public ColorPickerColorItemLayout(Context context) {
        super(context);
    }

    public ColorPickerColorItemLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ColorPickerColorItemLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setColor(int i) {
        this.f23858a.f23934c = i;
    }

    public final void m25146a() {
        this.f23858a = (PickerItemColorView) findViewById(2131563232);
        this.f23859b = (PickerItemColorView) findViewById(2131563234);
        this.f23860c = (PickerItemColorView) findViewById(2131563233);
        this.f23859b.f23935d = 2;
        this.f23859b.m25206c();
    }

    public void setIsSelected(boolean z) {
        this.f23859b.setVisibility(z ? 0 : 8);
        this.f23858a.setIsSelected(z);
        this.f23860c.setIsSelected(z);
    }

    public void setDisabled(boolean z) {
        this.f23862e = z;
        this.f23860c.setVisibility(this.f23862e ? 0 : 8);
        this.f23860c.getTopLevelDrawable().setAlpha(220);
    }

    public InstantShoppingActionFragmentModel getAction() {
        return this.f23861d;
    }
}

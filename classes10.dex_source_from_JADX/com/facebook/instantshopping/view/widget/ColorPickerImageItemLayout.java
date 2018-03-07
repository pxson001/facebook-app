package com.facebook.instantshopping.view.widget;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingActionFragmentModel;
import com.facebook.instantshopping.view.block.ColorPickerItemView;

/* compiled from: SINGLE_SELECTION */
public class ColorPickerImageItemLayout extends FrameLayout implements ColorPickerItemView {
    private static final CallerContext f23863a = CallerContext.a(ColorPickerImageItemLayout.class, "unknown");
    private PickerItemColorView f23864b;
    private PickerItemImageView f23865c;
    public InstantShoppingActionFragmentModel f23866d;
    private boolean f23867e;
    private PickerItemColorView f23868f;

    public ColorPickerImageItemLayout(Context context) {
        super(context);
    }

    public ColorPickerImageItemLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ColorPickerImageItemLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setImageUrl(String str) {
        this.f23865c.a(Uri.parse(str), f23863a);
    }

    public final void m25147a() {
        this.f23865c = (PickerItemImageView) findViewById(2131563235);
        this.f23864b = (PickerItemColorView) findViewById(2131563236);
        this.f23868f = (PickerItemColorView) findViewById(2131563233);
        this.f23864b.f23935d = 2;
        this.f23864b.m25206c();
    }

    public void setIsSelected(boolean z) {
        this.f23864b.setVisibility(z ? 0 : 8);
        this.f23868f.setIsSelected(z);
        this.f23865c.setIsSelected(z);
    }

    public InstantShoppingActionFragmentModel getAction() {
        return this.f23866d;
    }

    public void setDisabled(boolean z) {
        this.f23867e = z;
        this.f23868f.setVisibility(this.f23867e ? 0 : 8);
        this.f23868f.getTopLevelDrawable().setAlpha(220);
    }
}

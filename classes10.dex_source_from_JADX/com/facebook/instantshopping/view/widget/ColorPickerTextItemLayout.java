package com.facebook.instantshopping.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingActionFragmentModel;
import com.facebook.instantshopping.view.block.ColorPickerItemView;
import com.facebook.richdocument.view.widget.RichTextView;
import com.facebook.richdocument.view.widget.RichTextView.InnerRichTextView;

/* compiled from: SHOW_INTERSTITIAL */
public class ColorPickerTextItemLayout extends FrameLayout implements ColorPickerItemView {
    private InnerRichTextView f23872a;
    public InstantShoppingActionFragmentModel f23873b;

    public ColorPickerTextItemLayout(Context context) {
        super(context);
    }

    public ColorPickerTextItemLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ColorPickerTextItemLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void m25150a() {
        this.f23872a = ((RichTextView) findViewById(2131563239)).d;
    }

    public void setOptionText(String str) {
        this.f23872a.setText(str);
    }

    public void setIsSelected(boolean z) {
        setBackgroundResource(2130840978);
        this.f23872a.setTextColor(getResources().getColor(2131361917));
    }

    public InstantShoppingActionFragmentModel getAction() {
        return this.f23873b;
    }

    public void setDisabled(boolean z) {
        this.f23872a.setClickable(false);
        this.f23872a.setTextColor(getResources().getColor(2131363672));
        setBackgroundResource(2130840974);
        this.f23872a.setPaintFlags(this.f23872a.getPaintFlags() | 16);
    }
}

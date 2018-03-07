package com.facebook.adinterfaces.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import com.facebook.R;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.StringUtil.StringProcessor;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;

/* compiled from: Uploading media failed */
public class AdInterfacesSelectorView extends CustomLinearLayout {
    private GlyphView f22946a;
    private BetterTextView f22947b;
    private BetterTextView f22948c;

    public AdInterfacesSelectorView(Context context) {
        super(context);
        m24918b(context, null);
    }

    public AdInterfacesSelectorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24918b(context, attributeSet);
    }

    protected AdInterfacesSelectorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m24918b(context, attributeSet);
    }

    private void m24917a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.AdInterfacesSelector, 0, 0);
            int resourceId = obtainStyledAttributes.getResourceId(0, 0);
            if (resourceId != 0) {
                this.f22948c.setText(getResources().getString(resourceId));
            }
            resourceId = obtainStyledAttributes.getResourceId(1, 0);
            if (resourceId != 0) {
                this.f22947b.setHintTextColor(this.f22947b.getTextColors());
                this.f22947b.setHint(getResources().getString(resourceId));
            }
            obtainStyledAttributes.recycle();
        }
    }

    private void m24918b(Context context, AttributeSet attributeSet) {
        setContentView(2130903143);
        setOrientation(1);
        this.f22946a = (GlyphView) a(2131559328);
        this.f22947b = (BetterTextView) a(2131559329);
        this.f22948c = (BetterTextView) a(2131559327);
        m24917a(context, attributeSet);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.f22946a.setOnClickListener(onClickListener);
        this.f22947b.setOnClickListener(onClickListener);
    }

    public void setTitle(CharSequence charSequence) {
        this.f22948c.setText(charSequence);
    }

    public void setSelectedValues(CharSequence charSequence) {
        this.f22947b.setText(charSequence);
    }

    public final void m24919a(Iterable iterable, StringProcessor stringProcessor) {
        StringBuilder stringBuilder = new StringBuilder();
        StringUtil.a(stringBuilder, ", ", stringProcessor, new Object[]{iterable});
        setSelectedValues(stringBuilder.toString());
    }

    public void setEditButtonContentDescription(CharSequence charSequence) {
        this.f22946a.setContentDescription(charSequence);
    }
}

package com.facebook.facecast.plugin.tipjar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.facebook.resources.ui.FbTextView;

/* compiled from: banned_user_id */
public class TipJarOptionView extends FbTextView {
    private String f18758a;
    private Drawable f18759b;

    public TipJarOptionView(Context context) {
        this(context, null);
    }

    public TipJarOptionView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TipJarOptionView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m22301a();
    }

    private void m22301a() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131432294);
        this.f18758a = getResources().getString(2131238304);
        this.f18759b = getResources().getDrawable(2130839815);
        if (this.f18759b != null) {
            this.f18759b.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
        }
        setText(this.f18758a);
        setCompoundDrawables(this.f18759b, null, null, null);
    }
}

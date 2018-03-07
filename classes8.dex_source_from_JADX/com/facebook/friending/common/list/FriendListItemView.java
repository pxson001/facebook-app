package com.facebook.friending.common.list;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.StyleRes;
import android.util.AttributeSet;
import com.facebook.R;
import com.facebook.fbui.widget.contentview.ContentViewWithButton;
import com.facebook.friends.ui.SmartButtonLite;
import javax.annotation.Nullable;

/* compiled from: fontFamily */
public class FriendListItemView extends ContentViewWithButton {
    SmartButtonLite f13117h;

    /* compiled from: fontFamily */
    public enum ActionButtonTheme {
        PRIMARY(2130839742, 2131624423),
        SECONDARY(2130837984, 2131624427);
        
        @DrawableRes
        public final int backgroundRes;
        @StyleRes
        public final int textAppearanceRes;

        private ActionButtonTheme(int i, int i2) {
            this.backgroundRes = i;
            this.textAppearanceRes = i2;
        }
    }

    public FriendListItemView(Context context) {
        super(context);
        m14777a(context, null, 0);
    }

    public FriendListItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m14777a(context, attributeSet, 0);
    }

    public FriendListItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m14777a(context, attributeSet, i);
    }

    private void m14777a(Context context, AttributeSet attributeSet, int i) {
        setContentView(2130904479);
        this.f13117h = (SmartButtonLite) getView(2131558479);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FriendListItemView, i, 0);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(5, this.f13117h.getLayoutParams().width);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(0, this.f13117h.getLayoutParams().height);
        this.f13117h.getLayoutParams().width = dimensionPixelSize;
        this.f13117h.getLayoutParams().height = dimensionPixelSize2;
        dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, this.f13117h.getPaddingLeft());
        dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(3, this.f13117h.getPaddingRight());
        this.f13117h.setPadding(dimensionPixelSize, obtainStyledAttributes.getDimensionPixelSize(2, this.f13117h.getPaddingTop()), dimensionPixelSize2, obtainStyledAttributes.getDimensionPixelSize(4, this.f13117h.getPaddingBottom()));
        obtainStyledAttributes.recycle();
    }

    public final void m14778a(ActionButtonTheme actionButtonTheme, @Nullable Drawable drawable) {
        this.f13117h.setImageDrawable(drawable);
        this.f13117h.a(actionButtonTheme.backgroundRes, actionButtonTheme.textAppearanceRes);
    }

    public final void m14779a(CharSequence charSequence, CharSequence charSequence2) {
        this.f13117h.a(charSequence, charSequence2);
    }
}

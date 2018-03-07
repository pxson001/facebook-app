package com.facebook.friending.common.list;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import com.facebook.R;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.friending.common.list.FriendListItemView.ActionButtonTheme;
import com.facebook.friends.ui.SmartButtonLite;
import javax.annotation.Nullable;

/* compiled from: font-size */
public class FriendRequestItemView extends ContentView {
    private SmartButtonLite f13118h;
    private SmartButtonLite f13119i;

    public FriendRequestItemView(Context context) {
        super(context);
        m14780a(context, null, 0);
    }

    public FriendRequestItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m14780a(context, attributeSet, 0);
    }

    public FriendRequestItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m14780a(context, attributeSet, i);
    }

    private void m14780a(Context context, AttributeSet attributeSet, int i) {
        setContentView(2130904482);
        this.f13118h = (SmartButtonLite) getView(2131562264);
        this.f13119i = (SmartButtonLite) getView(2131562263);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FriendRequestItemView, i, 0);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f13118h.setCompoundDrawablePadding(dimensionPixelSize);
        this.f13119i.setCompoundDrawablePadding(dimensionPixelSize);
        dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, -2);
        this.f13118h.getLayoutParams().height = dimensionPixelSize;
        this.f13119i.getLayoutParams().height = dimensionPixelSize;
        dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(2, this.f13118h.getPaddingLeft());
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(4, this.f13118h.getPaddingRight());
        this.f13118h.setPadding(dimensionPixelSize, obtainStyledAttributes.getDimensionPixelSize(3, this.f13118h.getPaddingTop()), dimensionPixelSize2, obtainStyledAttributes.getDimensionPixelSize(5, this.f13118h.getPaddingBottom()));
        dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(2, this.f13119i.getPaddingLeft());
        dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(4, this.f13119i.getPaddingRight());
        this.f13119i.setPadding(dimensionPixelSize, obtainStyledAttributes.getDimensionPixelSize(3, this.f13119i.getPaddingTop()), dimensionPixelSize2, obtainStyledAttributes.getDimensionPixelSize(5, this.f13119i.getPaddingBottom()));
        obtainStyledAttributes.recycle();
        this.f13118h.a(ActionButtonTheme.SECONDARY.backgroundRes, ActionButtonTheme.SECONDARY.textAppearanceRes);
        this.f13119i.a(ActionButtonTheme.PRIMARY.backgroundRes, ActionButtonTheme.PRIMARY.textAppearanceRes);
    }

    public void setPositiveButtonOnClickListener(OnClickListener onClickListener) {
        this.f13119i.setOnClickListener(onClickListener);
    }

    public final void m14781a(CharSequence charSequence, @Nullable CharSequence charSequence2) {
        this.f13119i.a(charSequence, charSequence2);
    }

    public void setNegativeButtonOnClickListener(OnClickListener onClickListener) {
        this.f13118h.setOnClickListener(onClickListener);
    }

    public void setNegativeButtonText(CharSequence charSequence) {
        this.f13118h.setText(charSequence);
    }

    public void setFriendRequestButtonsVisible(boolean z) {
        int i;
        int i2 = 0;
        SmartButtonLite smartButtonLite = this.f13119i;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        smartButtonLite.setVisibility(i);
        SmartButtonLite smartButtonLite2 = this.f13118h;
        if (!z) {
            i2 = 8;
        }
        smartButtonLite2.setVisibility(i2);
    }
}

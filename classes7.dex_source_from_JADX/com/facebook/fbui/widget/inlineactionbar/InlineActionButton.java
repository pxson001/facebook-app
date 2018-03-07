package com.facebook.fbui.widget.inlineactionbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.support.v7.internal.view.menu.MenuBuilder.ItemInvoker;
import android.support.v7.internal.view.menu.MenuItemImpl;
import android.support.v7.internal.view.menu.MenuView.ItemView;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import com.facebook.fbui.widget.text.ImageWithTextView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: source_header */
public class InlineActionButton extends ImageWithTextView implements ItemView, OnClickListener {
    private static final int[] f3601a = new int[]{16842911, 16842912};
    private static final int[] f3602b = new int[]{16842911};
    public ItemInvoker f3603c;
    private MenuItemImpl f3604d;
    private ColorStateList f3605e;
    private boolean f3606f = false;
    private boolean f3607g = false;

    public InlineActionButton(Context context) {
        super(context);
        m4328b();
    }

    public InlineActionButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m4328b();
    }

    public InlineActionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m4328b();
    }

    private void m4328b() {
        setGravity(17);
        setSingleLine();
        setEllipsize(TruncateAt.END);
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131429815);
        setCompoundDrawablePadding(dimensionPixelSize);
        setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        setOrientation(1);
        setOnClickListener(this);
        setFocusable(true);
        setFocusableInTouchMode(false);
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1495829253);
        if (this.f3603c != null) {
            this.f3603c.a(this.f3604d);
        }
        Logger.a(2, EntryType.UI_INPUT_END, -1916134831, a);
    }

    public void setItemInvoker(ItemInvoker itemInvoker) {
        this.f3603c = itemInvoker;
    }

    public void setGlyphColor(int i) {
        setGlyphColor(ColorStateList.valueOf(i));
    }

    public void setGlyphColor(ColorStateList colorStateList) {
        if (this.f3605e != colorStateList) {
            this.f3605e = colorStateList;
            refreshDrawableState();
            invalidate();
        }
    }

    public final void m4330a(MenuItemImpl menuItemImpl, int i) {
        this.f3604d = menuItemImpl;
        setText(menuItemImpl.getTitle());
        setIcon(menuItemImpl.getIcon());
        setEnabled(menuItemImpl.isEnabled());
        setCheckable(menuItemImpl.isCheckable());
        setChecked(menuItemImpl.isChecked());
    }

    public final void m4329a(MenuItemImpl menuItemImpl) {
        m4330a(menuItemImpl, 0);
    }

    public MenuItemImpl getItemData() {
        return this.f3604d;
    }

    public void setTitle(CharSequence charSequence) {
        setText(charSequence);
    }

    public void setCheckable(boolean z) {
        if (this.f3606f != z) {
            this.f3606f = z;
            refreshDrawableState();
            invalidate();
        }
    }

    public void setChecked(boolean z) {
        if (this.f3607g != z) {
            this.f3607g = z;
            refreshDrawableState();
            invalidate();
        }
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            drawable = drawable.mutate();
        }
        setImageDrawable(drawable);
        refreshDrawableState();
        invalidate();
    }

    public final boolean gO_() {
        return false;
    }

    protected void onMeasure(int i, int i2) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 2131165806);
        if (MeasureSpec.getMode(i) == 0) {
            i = MeasureSpec.makeMeasureSpec(getResources().getDimensionPixelSize(2131429813), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1669695340, a);
    }

    public void setBackgroundResource(int i) {
        int[] iArr = new int[]{getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom()};
        super.setBackgroundResource(i);
        setPadding(iArr[0], iArr[1], iArr[2], iArr[3]);
    }

    protected int[] onCreateDrawableState(int i) {
        if (!this.f3606f) {
            return super.onCreateDrawableState(i);
        }
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 2);
        mergeDrawableStates(onCreateDrawableState, this.f3607g ? f3601a : f3602b);
        return onCreateDrawableState;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.a;
        if (drawable != null) {
            if (this.f3605e != null) {
                drawable.setColorFilter(new PorterDuffColorFilter(this.f3605e.getColorForState(getDrawableState(), 0), Mode.SRC_IN));
            } else {
                drawable.setColorFilter(null);
            }
        }
    }

    public boolean canScrollHorizontally(int i) {
        return false;
    }

    public boolean onPreDraw() {
        super.onPreDraw();
        return true;
    }
}

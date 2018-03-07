package com.facebook.fbui.menu;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.Checkable;
import android.widget.TextView;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.fbui.widget.text.BadgeTextView;
import com.facebook.resources.ui.FbCheckedTextView;
import com.facebook.resources.ui.FbTextView;

/* compiled from: ZERO_RATING */
public class PopoverListItemView extends ImageBlockLayout implements Checkable {
    private static final int[] f12122h = new int[]{16842911, 16842912};
    private static final int[] f12123i = new int[]{16842911};
    public GlyphView f12124j;
    public BadgeTextView f12125k;
    public FbTextView f12126l;
    public FbCheckedTextView f12127m;
    private boolean f12128n;
    private boolean f12129o;
    private boolean f12130p;

    public PopoverListItemView(Context context) {
        this(context, null);
    }

    private PopoverListItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 2130772488);
    }

    private PopoverListItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12128n = false;
        this.f12129o = false;
        this.f12130p = false;
        setGravity(16);
        setContentView(2130904269);
        this.f12125k = (BadgeTextView) getView(2131561849);
        this.f12126l = (FbTextView) getView(2131561850);
        this.f12124j = (GlyphView) getView(2131561848);
        this.f12127m = (FbCheckedTextView) getView(2131561851);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!this.f12130p) {
            if ((this.f12125k.getVisibility() == 0 && this.f12125k.getLayout().getLineCount() > 1) || (this.f12127m.getVisibility() == 0 && this.f12127m.getLayout().getLineCount() > 1)) {
                this.f12126l.setVisibility(8);
                super.onMeasure(i, i2);
            }
        }
    }

    protected int[] onCreateDrawableState(int i) {
        if (!this.f12128n) {
            return super.onCreateDrawableState(i);
        }
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 2);
        View.mergeDrawableStates(onCreateDrawableState, this.f12129o ? f12122h : f12123i);
        if (this.f12127m.getVisibility() == 0) {
            this.f12127m.setChecked(this.f12129o);
        }
        return onCreateDrawableState;
    }

    final void m20152a(MenuItem menuItem) {
        if (menuItem != null) {
            m20150a(this.f12125k, menuItem.getTitle());
            if (menuItem instanceof MenuItemImpl) {
                MenuItemImpl menuItemImpl = (MenuItemImpl) menuItem;
                if (menuItemImpl.f12116j) {
                    m20150a(this.f12127m, menuItem.getTitle());
                    this.f12127m.setCheckMarkDrawable(2130840069);
                    m20150a(this.f12125k, null);
                    if (!menuItemImpl.f12117k) {
                        this.f12127m.setPadding(0, 0, 0, 0);
                    }
                } else {
                    this.f12127m.setVisibility(8);
                }
                m20150a(this.f12126l, menuItemImpl.f12110d);
                CharSequence charSequence = menuItemImpl.f12111e;
                if (!menuItemImpl.f12116j) {
                    this.f12125k.setBadgeText(charSequence);
                }
            } else {
                m20150a(this.f12126l, null);
                m20150a(this.f12127m, null);
            }
            Drawable icon = menuItem.getIcon();
            if (icon == null) {
                this.f12124j.setVisibility(8);
                this.f12124j.setImageDrawable(null);
            } else {
                this.f12124j.setVisibility(0);
                this.f12124j.setImageDrawable(icon);
            }
            this.f12128n = menuItem.isCheckable();
            setChecked(menuItem.isChecked());
            setEnabled(menuItem.isEnabled());
        }
    }

    private static void m20150a(TextView textView, CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        textView.setText(charSequence);
    }

    public final void m20153a(boolean z) {
        if (this.f12130p != z) {
            this.f12130p = z;
            this.f12126l.setSingleLine(!z);
            requestLayout();
            invalidate();
        }
    }

    public final void m20151a(ColorStateList colorStateList) {
        this.f12124j.setGlyphColor(colorStateList);
    }

    public void setChecked(boolean z) {
        this.f12129o = z;
        refreshDrawableState();
    }

    public boolean isChecked() {
        return this.f12129o;
    }

    public void toggle() {
        this.f12129o = !this.f12129o;
        refreshDrawableState();
    }
}

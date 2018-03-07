package com.facebook.apptab.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import com.facebook.apptab.state.TabTag;
import com.facebook.inject.FbInjector;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: resetPasswordPreconfirmation */
public class TabView extends BadgableGlyphView {
    @Inject
    public CaspianTabViewUtil f7155h;
    private CharSequence f7156i;

    public static void m11622a(Object obj, Context context) {
        ((TabView) obj).f7155h = CaspianTabViewUtil.m7806a(FbInjector.get(context));
    }

    public TabView(Context context) {
        this(context, null);
    }

    private TabView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    private TabView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = TabView.class;
        m11622a((Object) this, getContext());
        setBackgroundResource(2130837994);
        setBadgeOutlineColor(-1);
        if (VERSION.SDK_INT < 11) {
            setBadgeColor(-65536);
        }
    }

    public void setupTabTag(TabTag tabTag) {
        setTabIconImageResource(tabTag.drawableResourceId);
        this.d = tabTag.shouldEnforceMaximumUnreadCount;
        this.f7156i = getResources().getString(tabTag.descriptorResourceId);
    }

    public void setUnreadCount(int i) {
        super.setUnreadCount(i);
        setContentDescription(this.f7156i);
    }

    public void setContentDescription(CharSequence charSequence) {
        m11623a(charSequence, false);
    }

    public final void m11623a(CharSequence charSequence, boolean z) {
        if (z) {
            if (this.f7159c > 9) {
                charSequence = getContext().getString(2131232652, new Object[]{charSequence});
            } else if (this.f7159c > 0) {
                charSequence = getContext().getResources().getQuantityString(2131689509, this.f7159c, new Object[]{charSequence, Integer.valueOf(this.f7159c)});
            } else {
                charSequence = getContext().getString(2131232650, new Object[]{charSequence});
            }
        } else if (this.f7159c > 9) {
            charSequence = getContext().getString(2131232651, new Object[]{charSequence});
        } else if (this.f7159c > 0) {
            charSequence = getContext().getResources().getQuantityString(2131689508, this.f7159c, new Object[]{charSequence, Integer.valueOf(this.f7159c)});
        }
        super.setContentDescription(charSequence);
    }

    public void setGlyphImage(Drawable drawable) {
        drawable.setColorFilter(this.f7155h.m7809a(0.0d));
        super.setGlyphImage(drawable);
    }

    public void setTabIconImageResource(int i) {
        Drawable drawable = getResources().getDrawable(i);
        drawable.setColorFilter(this.f7155h.m7809a(0.0d));
        super.setGlyphImage(drawable);
    }
}

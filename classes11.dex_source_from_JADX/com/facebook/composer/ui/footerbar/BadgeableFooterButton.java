package com.facebook.composer.ui.footerbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.R;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import javax.annotation.Nonnull;

/* compiled from: feed_friends_locations_pulse */
public class BadgeableFooterButton extends CustomFrameLayout {
    private int f7004a;
    private GlyphView f7005b;
    @Nonnull
    private Optional<View> f7006c = Absent.INSTANCE;

    public BadgeableFooterButton(Context context) {
        super(context);
        m8293a(context, null);
    }

    public BadgeableFooterButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m8293a(context, attributeSet);
    }

    public BadgeableFooterButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m8293a(context, attributeSet);
    }

    private void m8293a(Context context, AttributeSet attributeSet) {
        setContentView(2130903662);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BadgeableFooterButton);
        this.f7004a = obtainStyledAttributes.getResourceId(1, -1);
        Preconditions.checkArgument(this.f7004a != -1);
        this.f7005b = (GlyphView) c(2131560494);
        this.f7005b.setImageResource(obtainStyledAttributes.getResourceId(0, -1));
        setActive(false);
        obtainStyledAttributes.recycle();
    }

    public View getBadgeView() {
        if (!this.f7006c.isPresent()) {
            this.f7006c = Optional.of(LayoutInflater.from(getContext()).inflate(this.f7004a, this, false));
            addView((View) this.f7006c.get());
        }
        return (View) this.f7006c.get();
    }

    public void setResourceId(int i) {
        this.f7005b.setImageResource(i);
    }

    public void setActive(boolean z) {
        if (z) {
            this.f7005b.setGlyphColor(getResources().getColor(2131362954));
        } else {
            this.f7005b.setGlyphColor(getResources().getColorStateList(2131364092));
        }
    }

    public final void m8294a() {
        if (this.f7006c.isPresent()) {
            ((View) this.f7006c.get()).setVisibility(8);
        }
    }
}

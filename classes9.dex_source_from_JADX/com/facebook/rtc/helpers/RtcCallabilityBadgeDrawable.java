package com.facebook.rtc.helpers;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;

/* compiled from: application/vnd.wap.wbxml */
public class RtcCallabilityBadgeDrawable extends Drawable {
    private final BadgeConstantState f19794a;
    private final ShapeDrawable f19795b;

    /* compiled from: application/vnd.wap.wbxml */
    final class BadgeConstantState extends ConstantState {
        final int f19790a;
        final int f19791b;
        final int f19792c;
        final int f19793d;

        public BadgeConstantState(int i, int i2, int i3, int i4) {
            this.f19790a = i;
            this.f19791b = i2;
            this.f19792c = i3;
            this.f19793d = i4;
        }

        public final Drawable newDrawable() {
            return new RtcCallabilityBadgeDrawable(this);
        }

        public final int getChangingConfigurations() {
            return 0;
        }
    }

    public RtcCallabilityBadgeDrawable(int i, int i2, int i3, int i4) {
        this(new BadgeConstantState(i, i2, i3, i4));
    }

    public RtcCallabilityBadgeDrawable(BadgeConstantState badgeConstantState) {
        this.f19794a = badgeConstantState;
        this.f19795b = new ShapeDrawable(new OvalShape());
        this.f19795b.setIntrinsicWidth(badgeConstantState.f19792c);
        this.f19795b.setIntrinsicHeight(badgeConstantState.f19792c);
        this.f19795b.getPaint().setColor(badgeConstantState.f19793d);
    }

    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        Rect bounds = getBounds();
        int i5 = ((bounds.left + bounds.right) / 2) + (this.f19794a.f19792c / 2);
        int i6 = (((bounds.bottom + bounds.top) / 2) - this.f19794a.f19792c) - (this.f19794a.f19792c / 2);
        this.f19795b.setBounds(i5, i6, this.f19794a.f19792c + i5, this.f19794a.f19792c + i6);
    }

    public void draw(Canvas canvas) {
        this.f19795b.draw(canvas);
    }

    public void setAlpha(int i) {
        this.f19795b.setAlpha(i);
    }

    @TargetApi(19)
    public int getAlpha() {
        return this.f19795b.getAlpha();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f19795b.setColorFilter(colorFilter);
    }

    public int getOpacity() {
        return this.f19795b.getOpacity();
    }

    public int getIntrinsicWidth() {
        return this.f19794a.f19790a;
    }

    public int getIntrinsicHeight() {
        return this.f19794a.f19791b;
    }

    public ConstantState getConstantState() {
        return this.f19794a;
    }
}

package com.facebook.widget.tiles;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.util.AttributeSet;
import com.facebook.R;
import com.facebook.common.build.BuildConstants;
import javax.annotation.Nullable;

/* compiled from: oxygen_map_disk_cache_init_error */
public class UserBadgeDrawable extends Drawable implements Callback {
    private final Resources f5709a;
    private final int[] f5710b = new int[14];
    private final Drawable[] f5711c = new Drawable[14];
    private TileBadge f5712d;
    private int f5713e = 255;
    private ColorFilter f5714f;
    public boolean f5715g;

    public UserBadgeDrawable(Context context, AttributeSet attributeSet, int i) {
        this.f5709a = context.getResources();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BadgedView, i, 0);
        this.f5710b[0] = obtainStyledAttributes.getResourceId(0, 0);
        this.f5710b[1] = obtainStyledAttributes.getResourceId(1, 0);
        this.f5710b[2] = obtainStyledAttributes.getResourceId(3, 0);
        this.f5710b[3] = obtainStyledAttributes.getResourceId(5, 0);
        this.f5710b[4] = obtainStyledAttributes.getResourceId(2, 0);
        this.f5710b[5] = obtainStyledAttributes.getResourceId(6, 0);
        this.f5710b[6] = obtainStyledAttributes.getResourceId(7, 0);
        this.f5710b[7] = obtainStyledAttributes.getResourceId(8, 0);
        this.f5710b[8] = obtainStyledAttributes.getResourceId(9, 0);
        this.f5710b[9] = obtainStyledAttributes.getResourceId(10, 0);
        this.f5710b[10] = obtainStyledAttributes.getResourceId(11, 0);
        this.f5710b[11] = obtainStyledAttributes.getResourceId(13, 0);
        this.f5710b[12] = obtainStyledAttributes.getResourceId(12, 0);
        this.f5710b[13] = obtainStyledAttributes.getResourceId(14, 0);
        obtainStyledAttributes.recycle();
    }

    public final void m6194a(TileBadge tileBadge) {
        if (tileBadge != this.f5712d) {
            this.f5712d = tileBadge;
            invalidateSelf();
        }
    }

    @Nullable
    private Drawable m6193b(@Nullable TileBadge tileBadge) {
        if (BuildConstants.j) {
            return null;
        }
        int i = -1;
        if (tileBadge != null) {
            if (this.f5715g) {
                switch (1.a[tileBadge.ordinal()]) {
                    case 1:
                        i = 11;
                        break;
                    case 2:
                        i = 12;
                        break;
                    case 3:
                        i = 13;
                        break;
                }
            }
            switch (1.a[tileBadge.ordinal()]) {
                case 1:
                    i = 0;
                    break;
                case 2:
                    i = 1;
                    break;
                case 3:
                    i = 4;
                    break;
                case 4:
                    i = 2;
                    break;
                case 5:
                    i = 3;
                    break;
                case 6:
                    i = 5;
                    break;
                case 7:
                    i = 6;
                    break;
                case 8:
                    i = 7;
                    break;
                case 9:
                    i = 8;
                    break;
                case 10:
                    i = 9;
                    break;
                case 11:
                    i = 10;
                    break;
                default:
                    break;
            }
        }
        int i2 = i;
        if (i2 < 0) {
            return null;
        }
        this.f5711c[i2] = m6191a(this.f5710b[i2]);
        return this.f5711c[i2];
    }

    private Drawable m6191a(int i) {
        if (i > 0) {
            Drawable drawable = this.f5709a.getDrawable(i);
            if (drawable != null) {
                drawable.mutate();
                drawable.setAlpha(this.f5713e);
                drawable.setColorFilter(this.f5714f);
                m6192a(drawable);
                return drawable;
            }
        }
        return null;
    }

    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        for (Drawable a : this.f5711c) {
            m6192a(a);
        }
    }

    private void m6192a(@Nullable Drawable drawable) {
        if (drawable != null) {
            Rect bounds = getBounds();
            drawable.setBounds(bounds.right - drawable.getIntrinsicWidth(), bounds.bottom - drawable.getIntrinsicHeight(), bounds.right, bounds.bottom);
        }
    }

    public void invalidateDrawable(Drawable drawable) {
        if (drawable == m6193b(this.f5712d)) {
            invalidateSelf();
        }
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        if (drawable == m6193b(this.f5712d)) {
            scheduleSelf(runnable, j);
        }
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable == m6193b(this.f5712d)) {
            unscheduleSelf(runnable);
        }
    }

    public void draw(Canvas canvas) {
        Drawable b = m6193b(this.f5712d);
        if (b != null) {
            b.draw(canvas);
        }
    }

    public void setAlpha(int i) {
        this.f5713e = i;
        for (Drawable drawable : this.f5711c) {
            if (drawable != null) {
                drawable.setAlpha(this.f5713e);
            }
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f5714f = colorFilter;
        for (Drawable drawable : this.f5711c) {
            if (drawable != null) {
                drawable.setColorFilter(this.f5714f);
            }
        }
    }

    public int getOpacity() {
        Drawable b = m6193b(this.f5712d);
        if (b != null) {
            return b.getOpacity();
        }
        return 0;
    }
}

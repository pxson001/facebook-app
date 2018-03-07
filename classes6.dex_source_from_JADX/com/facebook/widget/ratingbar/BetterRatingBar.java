package com.facebook.widget.ratingbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.facebook.R;
import com.facebook.common.i18n.RTLUtil;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.List;

/* compiled from: data7 */
public class BetterRatingBar extends CustomLinearLayout {
    private final Drawable f19838a;
    private final Drawable f19839b;
    private final int f19840c;
    private final boolean f19841d;
    private List<RatingChangedListener> f19842e;
    public int f19843f;
    private int f19844g;
    private boolean f19845h;
    private boolean f19846i;

    /* compiled from: data7 */
    public interface RatingChangedListener {
        void mo1342a(int i);

        void mo1343a(int i, int i2);
    }

    public BetterRatingBar(Context context) {
        this(context, null);
    }

    public BetterRatingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19842e = Lists.b();
        this.f19843f = 0;
        this.f19844g = 0;
        this.f19845h = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BetterRatingBar);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        Drawable drawable2 = obtainStyledAttributes.getDrawable(1);
        if (drawable == null) {
            drawable = context.getResources().getDrawable(2130843449);
        }
        this.f19838a = drawable;
        if (drawable2 != null) {
            drawable = drawable2;
        } else {
            drawable = context.getResources().getDrawable(2130843452);
        }
        this.f19839b = drawable;
        this.f19840c = obtainStyledAttributes.getInt(2, 5);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(3, 0);
        for (int i = 0; i < this.f19840c; i++) {
            View imageView = new ImageView(getContext());
            imageView.setImageDrawable(this.f19839b);
            imageView.setPadding(dimensionPixelOffset, 0, dimensionPixelOffset, 0);
            addView(imageView);
        }
        this.f19841d = obtainStyledAttributes.getBoolean(4, false);
        obtainStyledAttributes.recycle();
    }

    public void setAccessibilityTextForEachStar(int i) {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            childAt.setFocusable(true);
            childAt.setContentDescription(getResources().getQuantityString(i, i2 + 1, new Object[]{Integer.valueOf(i2 + 1)}));
        }
    }

    public int getRating() {
        return this.f19843f;
    }

    public void setRating(int i) {
        boolean z = i >= 0 && i <= this.f19840c;
        Preconditions.checkArgument(z);
        this.f19843f = i;
        this.f19844g = i;
        m28559b();
    }

    public int getNumStars() {
        return this.f19840c;
    }

    public final void m28565a(RatingChangedListener ratingChangedListener) {
        this.f19842e.add(ratingChangedListener);
    }

    public void mo1499a() {
        this.f19842e.clear();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -605609461);
        boolean a2;
        if (this.f19845h) {
            int action = motionEvent.getAction();
            if (this.f19841d) {
                a2 = m28558a(motionEvent, action);
                LogUtils.a(1049903714, a);
                return a2;
            }
            a2 = m28560b(motionEvent, action);
            LogUtils.a(1872680015, a);
            return a2;
        }
        a2 = super.onTouchEvent(motionEvent);
        Logger.a(2, EntryType.UI_INPUT_END, 148097638, a);
        return a2;
    }

    private boolean m28558a(MotionEvent motionEvent, int i) {
        int i2 = 0;
        switch (i) {
            case 0:
            case 2:
                this.f19846i = true;
                return true;
            case 1:
                if (this.f19846i) {
                    int a = m28557a(motionEvent.getX());
                    if (a != this.f19843f || this.f19843f == 0) {
                        i2 = a;
                    }
                    this.f19844g = i2;
                    m28559b();
                    m28561c(i2);
                    return true;
                }
                break;
            case 3:
                this.f19846i = false;
                return super.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    private boolean m28560b(MotionEvent motionEvent, int i) {
        if (i == 0) {
            requestDisallowInterceptTouchEvent(true);
        }
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
                m28562c(motionEvent, i);
                return true;
            default:
                return super.onTouchEvent(motionEvent);
        }
    }

    private void m28562c(MotionEvent motionEvent, int i) {
        int a = m28557a(motionEvent.getX());
        m28563d(a);
        if (i == 1 || i == 3) {
            m28561c(a);
        }
    }

    private int m28557a(float f) {
        int max = Math.max(1, Math.min(this.f19840c, ((int) ((((float) this.f19840c) * f) / ((float) getWidth()))) + 1));
        if (RTLUtil.a(getContext())) {
            return (this.f19840c - max) + 1;
        }
        return max;
    }

    private void m28561c(int i) {
        this.f19843f = i;
        this.f19844g = 0;
        for (RatingChangedListener a : this.f19842e) {
            a.mo1342a(i);
        }
    }

    private void m28559b() {
        int i = 0;
        while (i < this.f19844g) {
            ImageView imageView = (ImageView) getChildAt(i);
            if (imageView.getDrawable() != this.f19838a) {
                imageView.setImageDrawable(this.f19838a);
            }
            i++;
        }
        while (i < this.f19840c) {
            imageView = (ImageView) getChildAt(i);
            if (imageView.getDrawable() != this.f19839b) {
                imageView.setImageDrawable(this.f19839b);
            }
            i++;
        }
    }

    private void m28563d(int i) {
        if (i != this.f19844g) {
            int i2 = this.f19844g;
            this.f19844g = i;
            m28559b();
            for (RatingChangedListener a : this.f19842e) {
                a.mo1343a(i2, this.f19844g);
            }
        }
    }

    public boolean isEnabled() {
        return this.f19845h;
    }

    public void setEnabled(boolean z) {
        this.f19845h = z;
    }
}

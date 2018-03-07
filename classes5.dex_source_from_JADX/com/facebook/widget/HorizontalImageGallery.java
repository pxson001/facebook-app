package com.facebook.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.facebook.R;
import com.facebook.common.util.SizeUtil;

/* compiled from: com.google.android.gms.recovery.RecoveryService */
public class HorizontalImageGallery extends HorizontalScrollView {
    private int f5633a;
    public LinearLayout f5634b;
    public int f5635c;
    private int f5636d;
    private int f5637e;
    public int f5638f;
    public int f5639g;
    public float f5640h;
    public float f5641i;
    public OnTouchListener f5642j;
    private CustomOnTouchListener f5643k;
    public OnItemTouchListener f5644l;
    public int f5645m;
    public boolean f5646n;
    private boolean f5647o;
    private HorizontalImageGalleryItemIndicator f5648p = null;

    /* compiled from: com.google.android.gms.recovery.RecoveryService */
    class CustomOnTouchListener implements OnTouchListener {
        final /* synthetic */ HorizontalImageGallery f5628a;
        private boolean f5629b;
        private float f5630c;
        private int f5631d;
        private boolean f5632e;

        public CustomOnTouchListener(HorizontalImageGallery horizontalImageGallery) {
            this.f5628a = horizontalImageGallery;
            this.f5632e = true;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (((this.f5628a.f5642j == null || this.f5628a.f5646n) && (this.f5628a.f5642j == null || !this.f5629b)) || !this.f5628a.f5642j.onTouch(view, motionEvent)) {
                if (this.f5629b) {
                    this.f5629b = false;
                    return false;
                }
                switch (motionEvent.getAction()) {
                    case 0:
                        return m10425a(motionEvent);
                    case 1:
                        return m10427c(motionEvent);
                    case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                        return m10426b(motionEvent);
                    default:
                        return false;
                }
            } else if (motionEvent.getAction() != 1) {
                return true;
            } else {
                m10427c(motionEvent);
                return true;
            }
        }

        private boolean m10425a(MotionEvent motionEvent) {
            this.f5628a.f5640h = motionEvent.getX();
            this.f5628a.f5641i = motionEvent.getY();
            this.f5632e = false;
            return false;
        }

        private boolean m10426b(MotionEvent motionEvent) {
            int i;
            float x = this.f5628a.f5640h - ((float) ((int) motionEvent.getX()));
            if (x < 0.0f) {
                if (this.f5630c + 4.0f <= x) {
                    i = 1;
                } else {
                    i = 2;
                }
            } else if (this.f5630c - 4.0f <= x) {
                i = 1;
            } else {
                i = 2;
            }
            if (i == this.f5631d || this.f5632e) {
                this.f5630c = x;
            } else {
                this.f5628a.f5640h = motionEvent.getX();
                this.f5630c = this.f5628a.f5640h - motionEvent.getX();
            }
            this.f5631d = i;
            if (!this.f5628a.f5646n) {
                return false;
            }
            this.f5629b = true;
            this.f5628a.dispatchTouchEvent(MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), 0, this.f5628a.f5640h, this.f5628a.f5641i, motionEvent.getPressure(), motionEvent.getSize(), motionEvent.getMetaState(), motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags()));
            this.f5628a.f5646n = false;
            return true;
        }

        private boolean m10427c(MotionEvent motionEvent) {
            if (this.f5628a.f5638f > 0) {
                float scrollX = (float) this.f5628a.getScrollX();
                float measuredWidth = (float) (this.f5628a.f5634b.getMeasuredWidth() / this.f5628a.f5638f);
                float f = scrollX / ((float) this.f5628a.f5638f);
                if (this.f5631d == 1) {
                    if (this.f5630c > ((float) this.f5628a.f5635c)) {
                        if (((float) this.f5628a.f5639g) < measuredWidth - 1.0f) {
                            measuredWidth = (f + 1.0f) * ((float) this.f5628a.f5638f);
                        } else {
                            measuredWidth = (float) (this.f5628a.f5639g * this.f5628a.f5638f);
                        }
                    } else if (((float) Math.round(f)) == measuredWidth - 1.0f) {
                        measuredWidth = (float) (((int) (f + 1.0f)) * this.f5628a.f5638f);
                    } else {
                        measuredWidth = (float) (this.f5628a.f5639g * this.f5628a.f5638f);
                    }
                } else if (this.f5630c < ((float) (-this.f5628a.f5635c))) {
                    measuredWidth = (float) (((int) f) * this.f5628a.f5638f);
                } else if (Math.round(f) == 0) {
                    measuredWidth = (float) (((int) f) * this.f5628a.f5638f);
                } else {
                    measuredWidth = (float) (this.f5628a.f5639g * this.f5628a.f5638f);
                }
                int i = ((int) measuredWidth) / this.f5628a.f5638f;
                if (i == this.f5628a.f5639g && this.f5628a.f5644l != null) {
                    this.f5628a.f5634b.getChildAt((int) ((scrollX + motionEvent.getX()) / ((float) this.f5628a.f5638f)));
                }
                this.f5628a.m10445a(i);
                this.f5632e = true;
                this.f5630c = 0.0f;
                this.f5628a.f5645m = 0;
            }
            return true;
        }
    }

    /* compiled from: com.google.android.gms.recovery.RecoveryService */
    public interface OnItemTouchListener {
    }

    public HorizontalImageGallery(Context context) {
        super(context);
        m10432a(context, null);
    }

    public HorizontalImageGallery(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m10432a(context, attributeSet);
    }

    public HorizontalImageGallery(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10432a(context, attributeSet);
    }

    private final void m10432a(Context context, AttributeSet attributeSet) {
        int i = 5;
        boolean z = true;
        this.f5634b = new LinearLayout(context);
        this.f5634b.setOrientation(0);
        super.addView(this.f5634b, -1, new LayoutParams(-1, -2));
        setSmoothScrollingEnabled(true);
        setHorizontalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        this.f5639g = 0;
        this.f5643k = new CustomOnTouchListener(this);
        super.setOnTouchListener(this.f5643k);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.HorizontalImageGallery);
            i = obtainStyledAttributes.getInt(0, 5);
            z = obtainStyledAttributes.getBoolean(1, true);
            obtainStyledAttributes.recycle();
        }
        setLeftItemWidthPercentage(i);
        this.f5647o = z;
        this.f5635c = SizeUtil.a(getContext(), 30.0f);
        this.f5636d = SizeUtil.a(getContext(), 10.0f);
        this.f5637e = SizeUtil.a(getContext(), 20.0f);
    }

    public int getActiveItem() {
        return this.f5639g;
    }

    public void setActiveItem(int i) {
        this.f5639g = i;
    }

    public final void m10446a(View view, int i, ViewGroup.LayoutParams layoutParams) {
        requestLayout();
        invalidate();
        this.f5634b.addView(view, i, layoutParams);
    }

    public int getItemWidth() {
        return this.f5638f;
    }

    public LinearLayout getItemsContainer() {
        return this.f5634b;
    }

    public void setItemWidth(int i) {
        this.f5638f = i;
        requestLayout();
    }

    public void setLeftItemWidthPercentage(int i) {
        this.f5633a = i;
        requestLayout();
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        this.f5642j = onTouchListener;
    }

    public void setOnItemTouchListener(OnItemTouchListener onItemTouchListener) {
        this.f5644l = onItemTouchListener;
    }

    public int getItemCount() {
        return this.f5634b.getChildCount();
    }

    public final void m10445a(int i) {
        int i2;
        int i3 = this.f5639g;
        if (i >= getItemCount()) {
            i2 = i - 1;
        } else {
            i2 = i;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        smoothScrollTo(m10435b(i2), 0);
        this.f5639g = i2;
        if (this.f5648p != null && i3 != i2) {
            this.f5648p.setCurrentPage(i2);
        }
    }

    private int m10435b(int i) {
        return (this.f5638f * i) - Math.round((((float) this.f5633a) / 100.0f) * ((float) this.f5638f));
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.f5647o) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 0) {
            this.f5640h = motionEvent.getX();
            this.f5641i = motionEvent.getY();
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (!dispatchTouchEvent || motionEvent.getAction() != 2 || Math.abs(motionEvent.getX() - this.f5640h) <= Math.abs(motionEvent.getY() - this.f5641i) || Math.abs(motionEvent.getX() - this.f5640h) <= ((float) this.f5637e)) {
            return dispatchTouchEvent;
        }
        requestDisallowInterceptTouchEvent(true);
        return dispatchTouchEvent;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        if (motionEvent.getAction() == 0) {
            this.f5640h = motionEvent.getX();
            this.f5641i = motionEvent.getY();
            if (!this.f5646n) {
                this.f5645m = 0;
            }
        } else if (motionEvent.getAction() == 2) {
            m10429a(motionEvent);
        }
        if (this.f5645m == 2) {
            return false;
        }
        if (this.f5645m != 1) {
            return onInterceptTouchEvent;
        }
        this.f5646n = true;
        return true;
    }

    private int m10429a(MotionEvent motionEvent) {
        if (this.f5645m != 0) {
            return this.f5645m;
        }
        if (Math.abs(this.f5641i - motionEvent.getY()) - Math.abs(this.f5640h - motionEvent.getX()) > ((float) this.f5636d)) {
            return 2;
        }
        return 1;
    }

    public void setItemIndicator(HorizontalImageGalleryItemIndicator horizontalImageGalleryItemIndicator) {
        this.f5648p = horizontalImageGalleryItemIndicator;
        horizontalImageGalleryItemIndicator.setPageCount(getItemCount());
        horizontalImageGalleryItemIndicator.setCurrentPage(this.f5639g);
    }

    public HorizontalImageGalleryItemIndicator getItemIndicator() {
        return this.f5648p;
    }

    public final void m10444a() {
        this.f5634b.removeAllViews();
        this.f5639g = 0;
        if (this.f5648p != null) {
            this.f5648p.m10448a();
        }
    }
}

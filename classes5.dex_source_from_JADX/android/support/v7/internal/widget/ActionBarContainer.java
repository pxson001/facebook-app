package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.internal.VersionUtils;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.facebook.R;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: unittest */
public class ActionBarContainer extends FrameLayout {
    Drawable f986a;
    Drawable f987b;
    Drawable f988c;
    boolean f989d;
    boolean f990e;
    private boolean f991f;
    private View f992g;
    private View f993h;
    private View f994i;
    private int f995j;

    public ActionBarContainer(Context context) {
        this(context, null);
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        Drawable actionBarBackgroundDrawableV21;
        super(context, attributeSet);
        if (VersionUtils.m1192a()) {
            actionBarBackgroundDrawableV21 = new ActionBarBackgroundDrawableV21(this);
        } else {
            actionBarBackgroundDrawableV21 = new ActionBarBackgroundDrawable(this);
        }
        setBackgroundDrawable(actionBarBackgroundDrawableV21);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionBar);
        this.f986a = obtainStyledAttributes.getDrawable(8);
        this.f987b = obtainStyledAttributes.getDrawable(9);
        this.f995j = obtainStyledAttributes.getDimensionPixelSize(0, -1);
        if (getId() == 2131558404) {
            this.f989d = true;
            this.f988c = obtainStyledAttributes.getDrawable(10);
        }
        obtainStyledAttributes.recycle();
        boolean z = this.f989d ? this.f988c == null : this.f986a == null && this.f987b == null;
        setWillNotDraw(z);
    }

    public void onFinishInflate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 2045436805);
        super.onFinishInflate();
        this.f993h = findViewById(2131559130);
        this.f994i = findViewById(2131559131);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -289001058, a);
    }

    public void setPrimaryBackground(Drawable drawable) {
        boolean z = true;
        if (this.f986a != null) {
            this.f986a.setCallback(null);
            unscheduleDrawable(this.f986a);
        }
        this.f986a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f993h != null) {
                this.f986a.setBounds(this.f993h.getLeft(), this.f993h.getTop(), this.f993h.getRight(), this.f993h.getBottom());
            }
        }
        if (this.f989d) {
            if (this.f988c != null) {
                z = false;
            }
        } else if (!(this.f986a == null && this.f987b == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setStackedBackground(Drawable drawable) {
        boolean z = true;
        if (this.f987b != null) {
            this.f987b.setCallback(null);
            unscheduleDrawable(this.f987b);
        }
        this.f987b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f990e && this.f987b != null) {
                this.f987b.setBounds(this.f992g.getLeft(), this.f992g.getTop(), this.f992g.getRight(), this.f992g.getBottom());
            }
        }
        if (this.f989d) {
            if (this.f988c != null) {
                z = false;
            }
        } else if (!(this.f986a == null && this.f987b == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setSplitBackground(Drawable drawable) {
        boolean z = true;
        if (this.f988c != null) {
            this.f988c.setCallback(null);
            unscheduleDrawable(this.f988c);
        }
        this.f988c = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f989d && this.f988c != null) {
                this.f988c.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (this.f989d) {
            if (this.f988c != null) {
                z = false;
            }
        } else if (!(this.f986a == null && this.f987b == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setVisibility(int i) {
        boolean z;
        super.setVisibility(i);
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.f986a != null) {
            this.f986a.setVisible(z, false);
        }
        if (this.f987b != null) {
            this.f987b.setVisible(z, false);
        }
        if (this.f988c != null) {
            this.f988c.setVisible(z, false);
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f986a && !this.f989d) || ((drawable == this.f987b && this.f990e) || ((drawable == this.f988c && this.f989d) || super.verifyDrawable(drawable)));
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f986a != null && this.f986a.isStateful()) {
            this.f986a.setState(getDrawableState());
        }
        if (this.f987b != null && this.f987b.isStateful()) {
            this.f987b.setState(getDrawableState());
        }
        if (this.f988c != null && this.f988c.isStateful()) {
            this.f988c.setState(getDrawableState());
        }
    }

    public void jumpDrawablesToCurrentState() {
        if (VERSION.SDK_INT >= 11) {
            super.jumpDrawablesToCurrentState();
            if (this.f986a != null) {
                this.f986a.jumpToCurrentState();
            }
            if (this.f987b != null) {
                this.f987b.jumpToCurrentState();
            }
            if (this.f988c != null) {
                this.f988c.jumpToCurrentState();
            }
        }
    }

    public void setTransitioning(boolean z) {
        this.f991f = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f991f || super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 628319017);
        super.onTouchEvent(motionEvent);
        Logger.a(2, EntryType.UI_INPUT_END, -1752475443, a);
        return true;
    }

    public void setTabContainer(ScrollingTabContainerView scrollingTabContainerView) {
        if (this.f992g != null) {
            removeView(this.f992g);
        }
        this.f992g = scrollingTabContainerView;
        if (scrollingTabContainerView != null) {
            addView(scrollingTabContainerView);
            LayoutParams layoutParams = scrollingTabContainerView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            scrollingTabContainerView.f1143i = false;
        }
    }

    public View getTabContainer() {
        return this.f992g;
    }

    public ActionMode startActionModeForChild(View view, Callback callback) {
        return null;
    }

    private static boolean m1512a(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    private static int m1513b(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return layoutParams.bottomMargin + (view.getMeasuredHeight() + layoutParams.topMargin);
    }

    public void onMeasure(int i, int i2) {
        if (this.f993h == null && MeasureSpec.getMode(i2) == Integer.MIN_VALUE && this.f995j >= 0) {
            i2 = MeasureSpec.makeMeasureSpec(Math.min(this.f995j, MeasureSpec.getSize(i2)), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
        if (this.f993h != null) {
            int mode = MeasureSpec.getMode(i2);
            if (this.f992g != null && this.f992g.getVisibility() != 8 && mode != 1073741824) {
                int b;
                if (!m1512a(this.f993h)) {
                    b = m1513b(this.f993h);
                } else if (m1512a(this.f994i)) {
                    b = 0;
                } else {
                    b = m1513b(this.f994i);
                }
                setMeasuredDimension(getMeasuredWidth(), Math.min(b + m1513b(this.f992g), mode == Integer.MIN_VALUE ? MeasureSpec.getSize(i2) : Integer.MAX_VALUE));
            }
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = 1;
        super.onLayout(z, i, i2, i3, i4);
        View view = this.f992g;
        boolean z2 = (view == null || view.getVisibility() == 8) ? false : true;
        if (!(view == null || view.getVisibility() == 8)) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            view.layout(i, (measuredHeight - view.getMeasuredHeight()) - layoutParams.bottomMargin, i3, measuredHeight - layoutParams.bottomMargin);
        }
        if (!this.f989d) {
            int i6;
            if (this.f986a != null) {
                if (this.f993h.getVisibility() == 0) {
                    this.f986a.setBounds(this.f993h.getLeft(), this.f993h.getTop(), this.f993h.getRight(), this.f993h.getBottom());
                } else if (this.f994i == null || this.f994i.getVisibility() != 0) {
                    this.f986a.setBounds(0, 0, 0, 0);
                } else {
                    this.f986a.setBounds(this.f994i.getLeft(), this.f994i.getTop(), this.f994i.getRight(), this.f994i.getBottom());
                }
                i6 = 1;
            } else {
                i6 = 0;
            }
            this.f990e = z2;
            if (!z2 || this.f987b == null) {
                i5 = i6;
            } else {
                this.f987b.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        } else if (this.f988c != null) {
            this.f988c.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        } else {
            i5 = 0;
        }
        if (i5 != 0) {
            invalidate();
        }
    }
}

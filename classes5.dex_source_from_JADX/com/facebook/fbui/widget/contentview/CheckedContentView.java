package com.facebook.fbui.widget.contentview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import com.facebook.R;

/* compiled from: XHP */
public class CheckedContentView extends ContentView implements Checkable {
    private static final int[] f12223h = new int[]{16842911, 16842912};
    private static final int[] f12224i = new int[]{16842911};
    private boolean f12225j;
    private Drawable f12226k;
    private Position f12227l;
    public int f12228m;

    /* compiled from: XHP */
    public enum Position {
        START,
        END
    }

    public CheckedContentView(Context context) {
        this(context, null);
    }

    public CheckedContentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 2130772433);
    }

    public CheckedContentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12225j = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CheckedContentView, i, 0);
        setCheckMarkDrawable(obtainStyledAttributes.getResourceId(1, 0));
        setChecked(obtainStyledAttributes.getBoolean(0, false));
        setCheckMarkPosition(Position.values()[obtainStyledAttributes.getInteger(2, 1)]);
        setCheckMarkPadding(obtainStyledAttributes.getDimensionPixelSize(3, 0));
        obtainStyledAttributes.recycle();
    }

    public int getSpaceLeft() {
        int spaceLeft = super.getSpaceLeft();
        if (this.f12226k == null) {
            return spaceLeft;
        }
        boolean c = c();
        if ((!c || this.f12227l != Position.START) && (c || this.f12227l != Position.END)) {
            return spaceLeft;
        }
        return spaceLeft + (this.f12226k.getBounds().width() + this.f12228m);
    }

    public int getSpaceRight() {
        int spaceRight = super.getSpaceRight();
        if (this.f12226k == null) {
            return spaceRight;
        }
        boolean c = c();
        if ((!c || this.f12227l != Position.END) && (c || this.f12227l != Position.START)) {
            return spaceRight;
        }
        return spaceRight + (this.f12226k.getBounds().width() + this.f12228m);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f12226k != null) {
            int measuredWidth;
            Rect bounds = this.f12226k.getBounds();
            boolean c = c();
            if (!(c && this.f12227l == Position.START) && (c || this.f12227l != Position.END)) {
                measuredWidth = (getMeasuredWidth() - bounds.width()) - super.getSpaceRight();
            } else {
                measuredWidth = super.getSpaceLeft();
            }
            int measuredHeight = (getMeasuredHeight() - bounds.height()) / 2;
            canvas.translate((float) measuredWidth, (float) measuredHeight);
            this.f12226k.draw(canvas);
            canvas.translate((float) (-measuredWidth), (float) (-measuredHeight));
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return drawable == this.f12226k || super.verifyDrawable(drawable);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f12226k != null && this.f12226k.isStateful()) {
            this.f12226k.setState(getDrawableState());
        }
    }

    @TargetApi(11)
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.f12226k != null) {
            this.f12226k.jumpToCurrentState();
        }
    }

    protected int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 2);
        View.mergeDrawableStates(onCreateDrawableState, this.f12225j ? f12223h : f12224i);
        return onCreateDrawableState;
    }

    public void setPressed(boolean z) {
        super.setPressed(z);
        refreshDrawableState();
        invalidate();
    }

    public void setChecked(boolean z) {
        if (this.f12225j != z) {
            this.f12225j = z;
            refreshDrawableState();
            invalidate();
        }
    }

    public boolean isChecked() {
        return this.f12225j;
    }

    public void toggle() {
        setChecked(!this.f12225j);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setChecked(this.f12225j);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCheckable(true);
        accessibilityNodeInfo.setChecked(this.f12225j);
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() != 1) {
            accessibilityEvent.getText().add(getResources().getString(this.f12225j ? 2131230836 : 2131230837));
        }
        super.onPopulateAccessibilityEvent(accessibilityEvent);
    }

    public Drawable getCheckMarkDrawable() {
        return this.f12226k;
    }

    public void setCheckMarkDrawable(Drawable drawable) {
        boolean z = false;
        if (this.f12226k != drawable) {
            this.f12226k = drawable;
            if (this.f12226k != null) {
                this.f12226k.setBounds(0, 0, this.f12226k.getIntrinsicWidth(), this.f12226k.getIntrinsicHeight());
                this.f12226k.setState(getDrawableState());
            }
            invalidate();
        }
        if (this.f12226k == null) {
            z = true;
        }
        setWillNotDraw(z);
    }

    public void setCheckMarkDrawable(int i) {
        if (i > 0) {
            setCheckMarkDrawable(getResources().getDrawable(i));
        }
    }

    public Position getCheckMarkPosition() {
        return this.f12227l;
    }

    public void setCheckMarkPosition(Position position) {
        if (this.f12227l != position) {
            this.f12227l = position;
            invalidate();
            requestLayout();
        }
    }

    public void setCheckMarkPadding(int i) {
        if (this.f12228m != i) {
            this.f12228m = i;
            requestLayout();
        }
    }

    public int getCheckMarkPadding() {
        return this.f12228m;
    }
}

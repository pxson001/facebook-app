package com.facebook.orca.threadview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.TextView;
import com.facebook.R;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.facebook.messaging.lowdatamode.LowDataModePrefKeys;
import com.facebook.messaging.xma.XMAContentContainer;
import com.facebook.messaging.xma.XMAContentContainer.LayoutParams.SizingPreference;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;
import com.google.common.base.Preconditions;
import java.util.Arrays;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: method/fwcomponents.get */
public class MessageContentContainer extends CustomLinearLayout {
    @Inject
    public Lazy<ThreadViewLowDataModeUtils> f7019a;
    private final View[] f7020b;
    private int f7021c;
    private int f7022d;
    private int f7023e;
    private int f7024f;
    public boolean f7025g;

    /* compiled from: method/fwcomponents.get */
    public class LayoutParams extends android.widget.LinearLayout.LayoutParams {
        public int f7018a;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MessageContentContainer_Layout);
            this.f7018a = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    private static <T extends View> void m6601a(Class<T> cls, T t) {
        m6602a((Object) t, t.getContext());
    }

    private static void m6602a(Object obj, Context context) {
        ((MessageContentContainer) obj).f7019a = IdBasedLazy.a(FbInjector.get(context), 8863);
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return m6603b();
    }

    protected /* synthetic */ android.widget.LinearLayout.LayoutParams m25607generateDefaultLayoutParams() {
        return m6603b();
    }

    public /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m6595a(attributeSet);
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return m6596a(layoutParams);
    }

    public /* synthetic */ android.widget.LinearLayout.LayoutParams m25608generateLayoutParams(AttributeSet attributeSet) {
        return m6595a(attributeSet);
    }

    protected /* synthetic */ android.widget.LinearLayout.LayoutParams m25609generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return m6596a(layoutParams);
    }

    public MessageContentContainer(Context context) {
        super(context);
        this.f7020b = new View[6];
        this.f7021c = Integer.MAX_VALUE;
        m6597a();
    }

    public MessageContentContainer(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7020b = new View[6];
        this.f7021c = Integer.MAX_VALUE;
        m6597a();
    }

    protected MessageContentContainer(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7020b = new View[6];
        this.f7021c = Integer.MAX_VALUE;
        m6597a();
    }

    private void m6597a() {
        m6601a(MessageContentContainer.class, (View) this);
        this.f7023e = getResources().getDimensionPixelOffset(2131428588);
        this.f7024f = getResources().getDimensionPixelOffset(2131428589);
    }

    public void setDisallowForwardingTouches(boolean z) {
        this.f7025g = z;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f7025g ? true : super.onInterceptTouchEvent(motionEvent);
    }

    protected void onMeasure(int i, int i2) {
        int childCount = getChildCount();
        Arrays.fill(this.f7020b, null);
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                this.f7020b[((LayoutParams) childAt.getLayoutParams()).f7018a] = childAt;
            }
        }
        m6598a(i, i2);
        m6604b(i, i2);
        m6605c(i, i2);
        super.onMeasure(i, i2);
        Arrays.fill(this.f7020b, null);
    }

    private void m6600a(Lazy<ThreadViewLowDataModeUtils> lazy) {
        this.f7019a = lazy;
    }

    private void m6598a(int i, int i2) {
        int i3 = 0;
        View view = this.f7020b[3];
        View view2 = this.f7020b[2];
        if (!(view == null || view2 == null)) {
            m6599a(view);
            m6599a(view2);
            measureChild(view, i, i2);
            i3 = view.getMeasuredWidth();
        }
        if (view2 != null && i3 != this.f7022d) {
            this.f7022d = i3;
            view2.setMinimumWidth(i3);
        }
    }

    private void m6604b(int i, int i2) {
        int i3 = 1;
        int i4 = 0;
        TextView textView = (TextView) this.f7020b[1];
        View view = this.f7020b[2];
        XMAContentContainer xMAContentContainer = (XMAContentContainer) this.f7020b[4];
        int a = m6594a(view, i, i2);
        if (xMAContentContainer != null) {
            xMAContentContainer.a = -1;
            int max = Math.max(m6594a(xMAContentContainer, i, i2), this.f7023e);
            if (xMAContentContainer.getChildSizingPreference() != SizingPreference.MATCH_LARGEST) {
                i3 = 0;
            }
            i4 = i3;
            i3 = max;
        } else {
            i3 = -1;
        }
        i3 = Math.max(a, i3);
        if (!(view != null || textView == null || r3 == 0)) {
            setTextMaxWidth(Integer.MAX_VALUE);
            i3 = Math.min(Math.max(i3, m6594a(textView, i, i2)), this.f7024f);
        }
        if (MeasureSpec.getMode(i) == 1073741824) {
            i3 = MeasureSpec.getSize(i);
        }
        if (textView != null) {
            setTextMaxWidth(i3 > 0 ? i3 : Integer.MAX_VALUE);
        }
        if (xMAContentContainer != null) {
            xMAContentContainer.a = i3;
        }
    }

    private void setTextMaxWidth(int i) {
        TextView textView = (TextView) this.f7020b[1];
        if (textView != null && this.f7021c != i) {
            this.f7021c = i;
            textView.setMaxWidth(this.f7021c);
        }
    }

    private int m6594a(View view, int i, int i2) {
        if (view == null) {
            return -1;
        }
        m6599a(view);
        measureChild(view, i, i2);
        return view.getMeasuredWidth();
    }

    private void m6605c(int i, int i2) {
        View view = (ThreadViewLowDataModeNuxView) this.f7020b[5];
        View view2 = this.f7020b[2];
        if (view != null && view2 != null) {
            Object obj;
            m6599a(view);
            m6599a(view2);
            measureChild(view2, i, i2);
            int measuredWidth = view2.getMeasuredWidth();
            BetterTextView betterTextView = view.f7646a;
            Rect rect = new Rect();
            String charSequence = betterTextView.getText().toString();
            betterTextView.getPaint().getTextBounds(charSequence, 0, charSequence.length(), rect);
            if ((measuredWidth - betterTextView.getCompoundPaddingLeft()) - betterTextView.getCompoundPaddingRight() > rect.width()) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null) {
                view.setVisibility(8);
                ((ThreadViewLowDataModeUtils) this.f7019a.get()).f7651b.edit().a(LowDataModePrefKeys.f3022b).commit();
            }
        }
    }

    private static void m6599a(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        boolean z = layoutParams.leftMargin == 0 && layoutParams.rightMargin == 0;
        Preconditions.checkState(z);
    }

    private static LayoutParams m6603b() {
        return new LayoutParams(-1, -2);
    }

    private LayoutParams m6595a(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    private static LayoutParams m6596a(android.view.ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }
}

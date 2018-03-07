package com.facebook.video.player;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.R;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomRelativeLayout;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.Map;
import java.util.PriorityQueue;

/* compiled from: delivery_receipt_new_send_failure */
public class AnchorLayout extends CustomRelativeLayout {
    private static final Comparator<View> f14034a = new C06531();
    public int f14035b;
    public View f14036c;
    public Map<Anchor, PriorityQueue<View>> f14037d;
    public ArrayList<AnchorRow>[] f14038e;
    public int[] f14039f;
    public int f14040g;
    public int f14041h;
    public int f14042i;
    public int f14043j;
    public int f14044k;
    private int f14045l;
    private int f14046m;

    /* compiled from: delivery_receipt_new_send_failure */
    final class C06531 implements Comparator<View> {
        C06531() {
        }

        public final int compare(Object obj, Object obj2) {
            LayoutParams layoutParams = (LayoutParams) ((View) obj).getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) ((View) obj2).getLayoutParams();
            int i = layoutParams.f14106b - layoutParams2.f14106b;
            if (i != 0) {
                return i;
            }
            i = layoutParams.f14105a.compareTo(layoutParams2.f14105a);
            if (i != 0) {
                return i;
            }
            i = layoutParams.f14107c.compareTo(layoutParams2.f14107c);
            if (i != 0) {
                return i;
            }
            return layoutParams.f14108d - layoutParams2.f14108d;
        }
    }

    /* compiled from: delivery_receipt_new_send_failure */
    public class LayoutParams extends android.widget.RelativeLayout.LayoutParams {
        public Anchor f14105a;
        public int f14106b;
        public AnchorPosition f14107c;
        public int f14108d;
        public Point f14109e;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AnchorLayout_Layout);
            this.f14105a = Anchor.values()[obtainStyledAttributes.getInteger(0, 0)];
            this.f14106b = obtainStyledAttributes.getInteger(1, 0);
            this.f14107c = AnchorPosition.values()[obtainStyledAttributes.getInteger(2, AnchorPosition.CENTER.ordinal())];
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }
    }

    /* compiled from: delivery_receipt_new_send_failure */
    public enum Anchor {
        NONE(true),
        TOP(true),
        BOTTOM(true),
        START(false),
        END(false),
        INNER_TOP(true),
        INNER_BOTTOM(true),
        INNER_START(false),
        INNER_END(false),
        CENTER(true),
        INNER_CENTER(true);
        
        private boolean mIsHorizontal;

        private Anchor(boolean z) {
            this.mIsHorizontal = z;
        }

        public final boolean isHorizontal() {
            return this.mIsHorizontal;
        }
    }

    /* compiled from: delivery_receipt_new_send_failure */
    public enum AnchorPosition {
        START,
        END,
        CENTER
    }

    public AnchorLayout(Context context) {
        this(context, null);
    }

    public AnchorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AnchorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14035b = 0;
        this.f14045l = -1;
        this.f14046m = -1;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AnchorLayout);
            this.f14035b = obtainStyledAttributes.getResourceId(0, 0);
            obtainStyledAttributes.recycle();
        }
    }

    protected void onFinishInflate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1647486478);
        super.onFinishInflate();
        if (this.f14035b != 0) {
            this.f14036c = findViewById(this.f14035b);
            if (this.f14036c == null) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid inner view resourceId specified in layout.");
                Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1957372785, a);
                throw illegalArgumentException;
            }
        }
        LogUtils.g(967900277, a);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getChildCount() > 0) {
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            if (!(measuredWidth == this.f14045l && measuredHeight == this.f14046m)) {
                int i3;
                if (this.f14037d == null) {
                    this.f14037d = new EnumMap(Anchor.class);
                    int length = Anchor.values().length;
                    this.f14038e = new ArrayList[length];
                    for (i3 = 0; i3 < length; i3++) {
                        this.f14038e[i3] = new ArrayList();
                    }
                    this.f14039f = new int[length];
                }
                mo394b();
                for (ArrayList clear : this.f14038e) {
                    clear.clear();
                }
                if (this.f14036c != null) {
                    if (((LayoutParams) this.f14036c.getLayoutParams()).getRules()[10] == -1) {
                        this.f14041h = 0;
                    } else {
                        this.f14041h = (measuredHeight - this.f14036c.getMeasuredHeight()) / 2;
                    }
                    this.f14042i = this.f14041h + this.f14036c.getMeasuredHeight();
                } else {
                    this.f14041h = 0;
                    this.f14042i = measuredHeight;
                }
                this.f14043j = this.f14036c == null ? 0 : (measuredWidth - this.f14036c.getMeasuredWidth()) / 2;
                this.f14044k = this.f14036c == null ? measuredWidth : (this.f14036c.getMeasuredWidth() + measuredWidth) / 2;
                this.f14039f[Anchor.TOP.ordinal()] = 0;
                this.f14039f[Anchor.BOTTOM.ordinal()] = measuredHeight;
                this.f14039f[Anchor.START.ordinal()] = 0;
                this.f14039f[Anchor.END.ordinal()] = measuredWidth;
                this.f14039f[Anchor.INNER_TOP.ordinal()] = this.f14041h;
                this.f14039f[Anchor.INNER_BOTTOM.ordinal()] = this.f14042i;
                this.f14039f[Anchor.INNER_START.ordinal()] = this.f14043j;
                this.f14039f[Anchor.INNER_END.ordinal()] = this.f14044k;
                this.f14039f[Anchor.INNER_CENTER.ordinal()] = (this.f14041h + this.f14042i) / 2;
                this.f14039f[Anchor.CENTER.ordinal()] = measuredHeight / 2;
                this.f14040g = 0;
                mo415a(measuredWidth, measuredHeight);
            }
            this.f14046m = measuredHeight;
            this.f14045l = measuredWidth;
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8 && checkLayoutParams(childAt.getLayoutParams())) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (!(layoutParams.f14105a == null || layoutParams.f14105a == Anchor.NONE)) {
                    int i6;
                    int i7;
                    int i8;
                    if (layoutParams.f14109e != null) {
                        i6 = layoutParams.f14109e.x;
                        i7 = layoutParams.f14109e.y;
                    } else {
                        i7 = 0;
                        i6 = 0;
                    }
                    i6 = (i6 + getPaddingLeft()) + layoutParams.leftMargin;
                    i7 = (i7 + getPaddingTop()) + layoutParams.topMargin;
                    if (layoutParams.f14105a == Anchor.CENTER || layoutParams.f14105a == Anchor.INNER_CENTER) {
                        i8 = i7 - (this.f14040g / 2);
                    } else {
                        i8 = i7;
                    }
                    childAt.layout(i6, i8, childAt.getMeasuredWidth() + i6, childAt.getMeasuredHeight() + i8);
                }
            }
        }
    }

    public void invalidate() {
        super.invalidate();
        this.f14046m = -1;
        this.f14045l = -1;
    }

    public void requestLayout() {
        super.requestLayout();
        this.f14046m = -1;
        this.f14045l = -1;
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        requestLayout();
    }

    public android.widget.RelativeLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void setInnerResource(int i) {
        Preconditions.checkArgument(i != 0);
        this.f14035b = i;
        this.f14036c = findViewById(this.f14035b);
        if (this.f14036c == null) {
            throw new IllegalArgumentException("Invalid inner view resourceId specified.");
        }
    }

    private void mo394b() {
        int i = 0;
        for (PriorityQueue clear : this.f14037d.values()) {
            clear.clear();
        }
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8 && checkLayoutParams(childAt.getLayoutParams())) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (!(layoutParams.f14105a == null || layoutParams.f14105a == Anchor.NONE)) {
                    int i3 = i + 1;
                    layoutParams.f14108d = i;
                    PriorityQueue priorityQueue = (PriorityQueue) this.f14037d.get(layoutParams.f14105a);
                    if (priorityQueue == null) {
                        priorityQueue = new PriorityQueue(4, f14034a);
                        this.f14037d.put(layoutParams.f14105a, priorityQueue);
                    }
                    priorityQueue.add(childAt);
                    i = i3;
                }
            }
        }
    }

    private void mo415a(int i, int i2) {
        for (Anchor anchor : Anchor.values()) {
            PriorityQueue priorityQueue = (PriorityQueue) this.f14037d.get(anchor);
            if (priorityQueue != null) {
                Point point;
                if (anchor.isHorizontal()) {
                    point = new Point(i / 2, this.f14039f[anchor.ordinal()]);
                } else {
                    point = new Point(this.f14039f[anchor.ordinal()], i2 / 2);
                }
                AnchorRow anchorRow = new AnchorRow(anchor, m14854a(anchor, i), point);
                this.f14038e[anchor.ordinal()].add(anchorRow);
                while (!priorityQueue.isEmpty()) {
                    AnchorRow a = anchorRow.a((View) priorityQueue.poll());
                    if (a != null) {
                        m14856a(anchor, anchorRow);
                        this.f14038e[anchor.ordinal()].add(a);
                    } else {
                        a = anchorRow;
                    }
                    anchorRow = a;
                }
                m14856a(anchor, anchorRow);
            }
        }
    }

    private int m14854a(Anchor anchor, int i) {
        switch (2.a[anchor.ordinal()]) {
            case 1:
            case 2:
                return i;
            case 3:
            case 4:
                return this.f14039f[Anchor.BOTTOM.ordinal()] - this.f14039f[Anchor.TOP.ordinal()];
            case 5:
            case 6:
                return this.f14039f[Anchor.INNER_BOTTOM.ordinal()] - this.f14039f[Anchor.INNER_TOP.ordinal()];
            default:
                return this.f14039f[Anchor.INNER_END.ordinal()] - this.f14039f[Anchor.INNER_START.ordinal()];
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m14856a(com.facebook.video.player.AnchorLayout.Anchor r6, com.facebook.video.player.AnchorRow r7) {
        /*
        r5 = this;
        r7.a();
        r0 = com.facebook.video.player.AnchorLayout.2.a;
        r1 = r6.ordinal();
        r0 = r0[r1];
        switch(r0) {
            case 1: goto L_0x0017;
            case 2: goto L_0x0038;
            case 3: goto L_0x0059;
            case 4: goto L_0x007a;
            case 5: goto L_0x0066;
            case 6: goto L_0x0087;
            case 7: goto L_0x0024;
            case 8: goto L_0x0045;
            default: goto L_0x000e;
        };
    L_0x000e:
        r0 = r5.f14040g;
        r4 = r7.h;
        r1 = r4;
        r0 = r0 + r1;
        r5.f14040g = r0;
    L_0x0016:
        return;
    L_0x0017:
        r0 = r5.f14039f;
        r1 = com.facebook.video.player.AnchorLayout.Anchor.TOP;
        r1 = r1.ordinal();
        r4 = r7.k;
        r2 = r4;
        r0[r1] = r2;
    L_0x0024:
        r0 = r5.f14039f;
        r1 = com.facebook.video.player.AnchorLayout.Anchor.INNER_TOP;
        r1 = r1.ordinal();
        r4 = r7.k;
        r2 = r4;
        r3 = r5.f14041h;
        r2 = java.lang.Math.max(r2, r3);
        r0[r1] = r2;
        goto L_0x0016;
    L_0x0038:
        r0 = r5.f14039f;
        r1 = com.facebook.video.player.AnchorLayout.Anchor.BOTTOM;
        r1 = r1.ordinal();
        r4 = r7.i;
        r2 = r4;
        r0[r1] = r2;
    L_0x0045:
        r0 = r5.f14039f;
        r1 = com.facebook.video.player.AnchorLayout.Anchor.INNER_BOTTOM;
        r1 = r1.ordinal();
        r4 = r7.i;
        r2 = r4;
        r3 = r5.f14042i;
        r2 = java.lang.Math.min(r2, r3);
        r0[r1] = r2;
        goto L_0x0016;
    L_0x0059:
        r0 = r5.f14039f;
        r1 = com.facebook.video.player.AnchorLayout.Anchor.START;
        r1 = r1.ordinal();
        r4 = r7.j;
        r2 = r4;
        r0[r1] = r2;
    L_0x0066:
        r0 = r5.f14039f;
        r1 = com.facebook.video.player.AnchorLayout.Anchor.INNER_START;
        r1 = r1.ordinal();
        r4 = r7.j;
        r2 = r4;
        r3 = r5.f14043j;
        r2 = java.lang.Math.max(r2, r3);
        r0[r1] = r2;
        goto L_0x0016;
    L_0x007a:
        r0 = r5.f14039f;
        r1 = com.facebook.video.player.AnchorLayout.Anchor.END;
        r1 = r1.ordinal();
        r4 = r7.l;
        r2 = r4;
        r0[r1] = r2;
    L_0x0087:
        r0 = r5.f14039f;
        r1 = com.facebook.video.player.AnchorLayout.Anchor.INNER_END;
        r1 = r1.ordinal();
        r4 = r7.l;
        r2 = r4;
        r3 = r5.f14044k;
        r2 = java.lang.Math.min(r2, r3);
        r0[r1] = r2;
        goto L_0x0016;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.player.AnchorLayout.a(com.facebook.video.player.AnchorLayout$Anchor, com.facebook.video.player.AnchorRow):void");
    }
}

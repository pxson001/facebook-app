package it.sephiroth.android.library.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.SoundEffectConstants;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ArrayAdapter;
import android.widget.Checkable;
import android.widget.ListAdapter;
import android.widget.RemoteViews.RemoteView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import it.sephiroth.android.library.R;
import it.sephiroth.android.library.widget.AbsHListView.AdapterDataSetObserver;
import it.sephiroth.android.library.widget.AbsHListView.LayoutParams;
import it.sephiroth.android.library.widget.AbsHListView.RecycleBin;
import java.util.ArrayList;

@RemoteView
/* compiled from: viewed_event */
public class HListView extends AbsHListView {
    private ArrayList<FixedViewInfo> aA;
    private boolean aB;
    private boolean aC;
    private boolean aD;
    private boolean aE;
    private boolean aF;
    private boolean aG;
    private final Rect aH;
    private Paint aI;
    private final ArrowScrollFocusResult aJ;
    private FocusSelector aK;
    Drawable au;
    int av;
    int aw;
    Drawable ax;
    Drawable ay;
    private ArrayList<FixedViewInfo> az;

    /* compiled from: viewed_event */
    public class ArrowScrollFocusResult {
        public int f504a;
        public int f505b;

        final void m478a(int i, int i2) {
            this.f504a = i;
            this.f505b = i2;
        }

        public final int m477a() {
            return this.f504a;
        }

        public final int m479b() {
            return this.f505b;
        }
    }

    /* compiled from: viewed_event */
    public class FixedViewInfo {
        public View f506a;
        public Object f507b;
        public boolean f508c;
    }

    /* compiled from: viewed_event */
    class FocusSelector implements Runnable {
        final /* synthetic */ HListView f509a;
        private int f510b;
        private int f511c;

        public FocusSelector(HListView hListView) {
            this.f509a = hListView;
        }

        public final FocusSelector m480a(int i, int i2) {
            this.f510b = i;
            this.f511c = i2;
            return this;
        }

        public void run() {
            this.f509a.mo21b(this.f510b, this.f511c);
        }
    }

    public HListView(Context context) {
        this(context, null);
    }

    public HListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 2130773464);
    }

    public HListView(Context context, AttributeSet attributeSet, int i) {
        Object[] textArray;
        Drawable drawable;
        Drawable drawable2;
        Drawable drawable3;
        int dimensionPixelSize;
        boolean z;
        int i2 = -1;
        boolean z2 = true;
        super(context, attributeSet, i);
        this.az = new ArrayList();
        this.aA = new ArrayList();
        this.aF = true;
        this.aG = false;
        this.aH = new Rect();
        this.aJ = new ArrowScrollFocusResult();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.HListView, i, 0);
        if (obtainStyledAttributes != null) {
            textArray = obtainStyledAttributes.getTextArray(0);
            drawable = obtainStyledAttributes.getDrawable(1);
            drawable2 = obtainStyledAttributes.getDrawable(5);
            drawable3 = obtainStyledAttributes.getDrawable(6);
            dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(2, 0);
            z = obtainStyledAttributes.getBoolean(3, true);
            z2 = obtainStyledAttributes.getBoolean(4, true);
            i2 = obtainStyledAttributes.getInteger(7, -1);
            obtainStyledAttributes.recycle();
        } else {
            drawable3 = null;
            drawable2 = null;
            drawable = null;
            textArray = null;
            dimensionPixelSize = 0;
            z = true;
        }
        if (textArray != null) {
            setAdapter(new ArrayAdapter(context, 17367043, textArray));
        }
        if (drawable != null) {
            setDivider(drawable);
        }
        if (drawable2 != null) {
            setOverscrollHeader(drawable2);
        }
        if (drawable3 != null) {
            setOverscrollFooter(drawable3);
        }
        if (dimensionPixelSize != 0) {
            setDividerWidth(dimensionPixelSize);
        }
        this.aD = z;
        this.aE = z2;
        this.aw = i2;
    }

    public int getMaxScrollAmount() {
        return (int) (0.33f * ((float) (getRight() - getLeft())));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m525p() {
        /*
        r5 = this;
        r0 = 0;
        r2 = r5.getChildCount();
        if (r2 <= 0) goto L_0x0027;
    L_0x0007:
        r1 = r5.f435K;
        if (r1 != 0) goto L_0x0028;
    L_0x000b:
        r1 = r5.getChildAt(r0);
        r1 = r1.getLeft();
        r2 = r5.f464u;
        r2 = r2.left;
        r1 = r1 - r2;
        r2 = r5.f416V;
        if (r2 == 0) goto L_0x001f;
    L_0x001c:
        r2 = r5.av;
        r1 = r1 - r2;
    L_0x001f:
        if (r1 >= 0) goto L_0x0048;
    L_0x0021:
        if (r0 == 0) goto L_0x0027;
    L_0x0023:
        r0 = -r0;
        r5.m455b(r0);
    L_0x0027:
        return;
    L_0x0028:
        r1 = r2 + -1;
        r1 = r5.getChildAt(r1);
        r1 = r1.getRight();
        r3 = r5.getWidth();
        r4 = r5.f464u;
        r4 = r4.right;
        r3 = r3 - r4;
        r1 = r1 - r3;
        r3 = r5.f416V;
        r2 = r2 + r3;
        r3 = r5.ao;
        if (r2 >= r3) goto L_0x0046;
    L_0x0043:
        r2 = r5.av;
        r1 = r1 + r2;
    L_0x0046:
        if (r1 > 0) goto L_0x0021;
    L_0x0048:
        r0 = r1;
        goto L_0x0021;
        */
        throw new UnsupportedOperationException("Method not decompiled: it.sephiroth.android.library.widget.HListView.p():void");
    }

    private void m492a(View view, Object obj, boolean z) {
        if (this.f453j == null || (this.f453j instanceof HeaderViewListAdapter)) {
            FixedViewInfo fixedViewInfo = new FixedViewInfo();
            fixedViewInfo.f506a = view;
            fixedViewInfo.f507b = obj;
            fixedViewInfo.f508c = z;
            this.az.add(fixedViewInfo);
            if (this.f453j != null && this.f452i != null) {
                this.f452i.onChanged();
                return;
            }
            return;
        }
        throw new IllegalStateException("Cannot add header view to list -- setAdapter has already been called.");
    }

    private void m499b(View view) {
        m492a(view, null, true);
    }

    public int getHeaderViewsCount() {
        return this.az.size();
    }

    public int getFooterViewsCount() {
        return this.aA.size();
    }

    public ListAdapter getAdapter() {
        return this.f453j;
    }

    public void setAdapter(ListAdapter listAdapter) {
        if (!(this.f453j == null || this.f452i == null)) {
            this.f453j.unregisterDataSetObserver(this.f452i);
        }
        mo10c();
        this.f459p.m383b();
        if (this.az.size() > 0 || this.aA.size() > 0) {
            this.j = new HeaderViewListAdapter(this.az, this.aA, listAdapter);
        } else {
            this.j = listAdapter;
        }
        this.ar = -1;
        this.as = Long.MIN_VALUE;
        super.setAdapter(listAdapter);
        if (this.f453j != null) {
            int a;
            this.aF = this.f453j.areAllItemsEnabled();
            this.ap = this.ao;
            this.ao = this.f453j.getCount();
            m403l();
            this.i = new AdapterDataSetObserver(this);
            this.f453j.registerDataSetObserver(this.f452i);
            this.f459p.m380a(this.f453j.getViewTypeCount());
            if (this.f435K) {
                a = mo20a(this.ao - 1, false);
            } else {
                a = mo20a(0, true);
            }
            setSelectedPositionInt(a);
            setNextSelectedPositionInt(a);
            if (this.ao == 0) {
                m404m();
            }
        } else {
            this.aF = true;
            m403l();
            m404m();
        }
        requestLayout();
    }

    protected final void mo10c() {
        m493a(this.az);
        m493a(this.aA);
        super.mo10c();
        this.h = 0;
    }

    private static void m493a(ArrayList<FixedViewInfo> arrayList) {
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                LayoutParams layoutParams = (LayoutParams) ((FixedViewInfo) arrayList.get(i)).f506a.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.f389b = false;
                }
            }
        }
    }

    private boolean m526q() {
        int scrollX = getScrollX() + this.f464u.left;
        if (this.f416V > 0 || getChildAt(0).getLeft() > scrollX) {
            return true;
        }
        return false;
    }

    private boolean m527r() {
        int childCount = getChildCount();
        return (childCount + this.f416V) + -1 < this.ao + -1 || getChildAt(childCount - 1).getRight() < (getScrollX() + getWidth()) - this.f464u.right;
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        boolean z2;
        int i = rect.left;
        rect.offset(view.getLeft(), view.getTop());
        rect.offset(-view.getScrollX(), -view.getScrollY());
        int width = getWidth();
        int scrollX = getScrollX();
        int i2 = scrollX + width;
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        if (m526q() && (this.am > 0 || i > horizontalFadingEdgeLength)) {
            scrollX += horizontalFadingEdgeLength;
        }
        i = getChildAt(getChildCount() - 1).getRight();
        if (m527r() && (this.am < this.ao - 1 || rect.right < i - horizontalFadingEdgeLength)) {
            i2 -= horizontalFadingEdgeLength;
        }
        if (rect.right > i2 && rect.left > scrollX) {
            if (rect.width() > width) {
                scrollX = (rect.left - scrollX) + 0;
            } else {
                scrollX = (rect.right - i2) + 0;
            }
            i2 = Math.min(scrollX, i - i2);
        } else if (rect.left >= scrollX || rect.right >= i2) {
            i2 = 0;
        } else {
            if (rect.width() > width) {
                i2 = 0 - (i2 - rect.right);
            } else {
                i2 = 0 - (scrollX - rect.left);
            }
            i2 = Math.max(i2, getChildAt(0).getLeft() - scrollX);
        }
        if (i2 != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            m524o(-i2);
            m450a(-1, view);
            this.J = view.getTop();
            invalidate();
        }
        return z2;
    }

    protected final void mo7a(boolean z) {
        int i = 0;
        int childCount = getChildCount();
        if (z) {
            if (childCount > 0) {
                i = getChildAt(childCount - 1).getRight() + this.av;
            }
            m503c(childCount + this.f416V, i);
            m513f(getChildCount());
            return;
        }
        m506d(this.f416V - 1, childCount > 0 ? getChildAt(0).getLeft() - this.av : getWidth() + 0);
        m516g(getChildCount());
    }

    private View m503c(int i, int i2) {
        View view = null;
        int right = getRight() - getLeft();
        int i3 = i2;
        int i4 = i;
        while (i3 < right && i4 < this.ao) {
            boolean z = i4 == this.am;
            View a = m484a(i4, i3, true, this.f464u.top, z);
            i3 = a.getRight() + this.av;
            if (!z) {
                a = view;
            }
            i4++;
            view = a;
        }
        getChildCount();
        return view;
    }

    private View m506d(int i, int i2) {
        View view = null;
        int i3 = i2;
        int i4 = i;
        while (i3 > 0 && i4 >= 0) {
            boolean z = i4 == this.am;
            View a = m484a(i4, i3, false, this.f464u.top, z);
            i3 = a.getLeft() - this.av;
            if (!z) {
                a = view;
            }
            i4--;
            view = a;
        }
        this.V = i4 + 1;
        getChildCount();
        return view;
    }

    private View m508e(int i) {
        this.V = Math.min(this.f416V, this.am);
        this.V = Math.min(this.f416V, this.ao - 1);
        if (this.f416V < 0) {
            this.V = 0;
        }
        return m503c(this.f416V, i);
    }

    private View m509e(int i, int i2) {
        int i3 = i2 - i;
        int i4 = m464i();
        View a = m484a(i4, i, true, this.f464u.top, true);
        this.V = i4;
        int measuredWidth = a.getMeasuredWidth();
        if (measuredWidth <= i3) {
            a.offsetLeftAndRight((i3 - measuredWidth) / 2);
        }
        m488a(a, i4);
        if (this.f435K) {
            m516g(getChildCount());
        } else {
            m513f(getChildCount());
        }
        return a;
    }

    private void m488a(View view, int i) {
        int i2 = this.av;
        if (this.f435K) {
            m503c(i + 1, view.getRight() + i2);
            m525p();
            m506d(i - 1, view.getLeft() - i2);
            return;
        }
        m506d(i - 1, view.getLeft() - i2);
        m525p();
        m503c(i + 1, i2 + view.getRight());
    }

    private View m483a(int i, int i2, int i3) {
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        int i4 = this.am;
        int c = m502c(i2, horizontalFadingEdgeLength, i4);
        int b = m496b(i3, horizontalFadingEdgeLength, i4);
        View a = m484a(i4, i, true, this.f464u.top, true);
        if (a.getRight() > b) {
            a.offsetLeftAndRight(-Math.min(a.getLeft() - c, a.getRight() - b));
        } else if (a.getLeft() < c) {
            a.offsetLeftAndRight(Math.min(c - a.getLeft(), b - a.getRight()));
        }
        m488a(a, i4);
        if (this.f435K) {
            m516g(getChildCount());
        } else {
            m513f(getChildCount());
        }
        return a;
    }

    private int m496b(int i, int i2, int i3) {
        if (i3 != this.ao - 1) {
            return i - i2;
        }
        return i;
    }

    private static int m502c(int i, int i2, int i3) {
        if (i3 > 0) {
            return i + i2;
        }
        return i;
    }

    private View m485a(View view, View view2, int i, int i2, int i3) {
        View a;
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        int i4 = this.am;
        int c = m502c(i2, horizontalFadingEdgeLength, i4);
        int b = m496b(i2, horizontalFadingEdgeLength, i4);
        if (i > 0) {
            View a2 = m484a(i4 - 1, view.getLeft(), true, this.f464u.top, false);
            int i5 = this.av;
            a = m484a(i4, a2.getRight() + i5, true, this.f464u.top, true);
            if (a.getRight() > b) {
                int min = Math.min(Math.min(a.getLeft() - c, a.getRight() - b), (i3 - i2) / 2);
                a2.offsetLeftAndRight(-min);
                a.offsetLeftAndRight(-min);
            }
            if (this.f435K) {
                m503c(this.am + 1, a.getRight() + i5);
                m525p();
                m506d(this.am - 2, a.getLeft() - i5);
            } else {
                m506d(this.am - 2, a.getLeft() - i5);
                m525p();
                m503c(this.am + 1, a.getRight() + i5);
            }
        } else if (i < 0) {
            if (view2 != null) {
                a = m484a(i4, view2.getLeft(), true, this.f464u.top, true);
            } else {
                a = m484a(i4, view.getLeft(), false, this.f464u.top, true);
            }
            if (a.getLeft() < c) {
                a.offsetLeftAndRight(Math.min(Math.min(c - a.getLeft(), b - a.getRight()), (i3 - i2) / 2));
            }
            m488a(a, i4);
        } else {
            int left = view.getLeft();
            a = m484a(i4, left, true, this.f464u.top, true);
            if (left < i2 && a.getRight() < i2 + 20) {
                a.offsetLeftAndRight(i2 - a.getLeft());
            }
            m488a(a, i4);
        }
        return a;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -681277427);
        if (getChildCount() > 0) {
            View focusedChild = getFocusedChild();
            if (focusedChild != null) {
                int indexOfChild = this.f416V + indexOfChild(focusedChild);
                int left = focusedChild.getLeft() - Math.max(0, focusedChild.getRight() - (i - getPaddingLeft()));
                if (this.aK == null) {
                    this.aK = new FocusSelector(this);
                }
                post(this.aK.m480a(indexOfChild, left));
            }
        }
        super.onSizeChanged(i, i2, i3, i4);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -440297945, a);
    }

    @TargetApi(11)
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        super.onMeasure(i, i2);
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        if (this.f453j == null) {
            i3 = 0;
        } else {
            i3 = this.f453j.getCount();
        }
        this.ao = i3;
        if (this.ao <= 0 || !(mode == 0 || mode2 == 0)) {
            i4 = 0;
            i3 = 0;
            i5 = 0;
        } else {
            View a = m446a(0, this.f440P);
            m489a(a, 0, i2);
            int measuredWidth = a.getMeasuredWidth();
            int measuredHeight = a.getMeasuredHeight();
            if (VERSION.SDK_INT >= 11) {
                i4 = combineMeasuredStates(0, a.getMeasuredState());
            } else {
                i4 = 0;
            }
            if (m528s() && RecycleBin.m377b(((LayoutParams) a.getLayoutParams()).f388a)) {
                this.f459p.m382a(a, -1);
            }
            i3 = measuredHeight;
            i5 = measuredWidth;
        }
        mode2 = mode2 == 0 ? (i3 + (this.f464u.top + this.f464u.bottom)) + getHorizontalScrollbarHeight() : (mode2 != Integer.MIN_VALUE || this.ao <= 0 || this.aw < 0) ? VERSION.SDK_INT >= 11 ? size2 | (-16777216 & i4) : size2 : m501b(i2, this.aw, this.aw, size, size2)[1];
        if (mode == 0) {
            size = ((this.f464u.left + this.f464u.right) + i5) + (getHorizontalFadingEdgeLength() * 2);
        }
        if (mode == Integer.MIN_VALUE) {
            size = m481a(i2, 0, -1, size, -1);
        }
        setMeasuredDimension(size, mode2);
        this.v = i2;
    }

    private void m489a(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = (LayoutParams) generateDefaultLayoutParams();
            view.setLayoutParams(layoutParams);
        }
        layoutParams.f388a = this.f453j.getItemViewType(i);
        layoutParams.f390c = true;
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, this.f464u.top + this.f464u.bottom, layoutParams.height);
        int i3 = layoutParams.width;
        if (i3 > 0) {
            i3 = MeasureSpec.makeMeasureSpec(i3, 1073741824);
        } else {
            i3 = MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(i3, childMeasureSpec);
    }

    @ExportedProperty(category = "list")
    private static boolean m528s() {
        return true;
    }

    private int m481a(int i, int i2, int i3, int i4, int i5) {
        int i6 = 0;
        ListAdapter listAdapter = this.f453j;
        if (listAdapter == null) {
            return this.f464u.left + this.f464u.right;
        }
        int i7 = this.f464u.left + this.f464u.right;
        int i8 = (this.av <= 0 || this.au == null) ? 0 : this.av;
        if (i3 == -1) {
            i3 = listAdapter.getCount() - 1;
        }
        RecycleBin recycleBin = this.f459p;
        int i9 = 1;
        boolean[] zArr = this.f440P;
        while (i2 <= i3) {
            int i10;
            View a = m446a(i2, zArr);
            m489a(a, i2, i);
            if (i2 > 0) {
                i10 = i7 + i8;
            } else {
                i10 = i7;
            }
            if (i9 != 0 && RecycleBin.m377b(((LayoutParams) a.getLayoutParams()).f388a)) {
                recycleBin.m382a(a, -1);
            }
            i10 += a.getMeasuredWidth();
            if (i10 < i4) {
                if (i5 < 0 || i2 < i5) {
                    i7 = i6;
                } else {
                    i7 = i10;
                }
                i2++;
                i6 = i7;
                i7 = i10;
            } else if (i5 < 0 || i2 <= i5 || i6 <= 0 || i10 == i4) {
                return i4;
            } else {
                return i6;
            }
        }
        return i7;
    }

    private int[] m501b(int i, int i2, int i3, int i4, int i5) {
        ListAdapter listAdapter = this.f453j;
        if (listAdapter == null) {
            return new int[]{this.f464u.left + this.f464u.right, this.f464u.top + this.f464u.bottom};
        }
        int i6;
        int i7 = this.f464u.left + this.f464u.right;
        int i8 = this.f464u.top + this.f464u.bottom;
        if (this.av <= 0 || this.au == null) {
            i6 = 0;
        } else {
            i6 = this.av;
        }
        if (i3 == -1) {
            i3 = listAdapter.getCount() - 1;
        }
        RecycleBin recycleBin = this.f459p;
        boolean s = m528s();
        boolean[] zArr = this.f440P;
        int i9 = 0;
        int i10 = 0;
        while (i2 <= i3) {
            View a = m446a(i2, zArr);
            m489a(a, i2, i);
            if (s && RecycleBin.m377b(((LayoutParams) a.getLayoutParams()).f388a)) {
                recycleBin.m382a(a, -1);
            }
            i9 = Math.max(i9, a.getMeasuredWidth() + i6);
            i2++;
            i10 = Math.max(i10, a.getMeasuredHeight());
        }
        i10 += i8;
        return new int[]{Math.min(i9 + i7, i4), Math.min(i10, i5)};
    }

    protected final int mo22c(int i) {
        int childCount = getChildCount();
        if (childCount > 0) {
            int i2;
            if (this.f435K) {
                for (i2 = childCount - 1; i2 >= 0; i2--) {
                    if (i >= getChildAt(i2).getLeft()) {
                        return i2 + this.f416V;
                    }
                }
            } else {
                for (i2 = 0; i2 < childCount; i2++) {
                    if (i <= getChildAt(i2).getRight()) {
                        return i2 + this.f416V;
                    }
                }
            }
        }
        return -1;
    }

    private View m512f(int i, int i2) {
        View c;
        View d;
        boolean z = i == this.am;
        View a = m484a(i, i2, true, this.f464u.top, z);
        this.V = i;
        int i3 = this.av;
        if (this.f435K) {
            c = m503c(i + 1, a.getRight() + i3);
            m525p();
            d = m506d(i - 1, a.getLeft() - i3);
            i3 = getChildCount();
            if (i3 > 0) {
                m516g(i3);
            }
        } else {
            d = m506d(i - 1, a.getLeft() - i3);
            m525p();
            c = m503c(i + 1, i3 + a.getRight());
            i3 = getChildCount();
            if (i3 > 0) {
                m513f(i3);
            }
        }
        if (z) {
            return a;
        }
        if (d != null) {
            return d;
        }
        return c;
    }

    private void m513f(int i) {
        if ((this.f416V + i) - 1 == this.ao - 1 && i > 0) {
            int right = ((getRight() - getLeft()) - this.f464u.right) - getChildAt(i - 1).getRight();
            View childAt = getChildAt(0);
            int left = childAt.getLeft();
            if (right <= 0) {
                return;
            }
            if (this.f416V > 0 || left < this.f464u.top) {
                if (this.f416V == 0) {
                    right = Math.min(right, this.f464u.top - left);
                }
                m455b(right);
                if (this.f416V > 0) {
                    m506d(this.f416V - 1, childAt.getLeft() - this.av);
                    m525p();
                }
            }
        }
    }

    private void m516g(int i) {
        if (this.f416V == 0 && i > 0) {
            int right = (getRight() - getLeft()) - this.f464u.right;
            int left = getChildAt(0).getLeft() - this.f464u.left;
            View childAt = getChildAt(i - 1);
            int right2 = childAt.getRight();
            int i2 = (this.f416V + i) - 1;
            if (left <= 0) {
                return;
            }
            if (i2 < this.ao - 1 || right2 > right) {
                if (i2 == this.ao - 1) {
                    left = Math.min(left, right2 - right);
                }
                m455b(-left);
                if (i2 < this.ao - 1) {
                    m503c(i2 + 1, childAt.getRight() + this.av);
                    m525p();
                }
            } else if (i2 == this.ao - 1) {
                m525p();
            }
        }
    }

    protected final void mo11d() {
        boolean z = this.at;
        if (!z) {
            this.at = true;
            try {
                super.mo11d();
                invalidate();
                if (this.f453j == null) {
                    mo10c();
                    mo9b();
                    return;
                }
                View view;
                int i;
                View childAt;
                int i2 = this.f464u.left;
                int right = (getRight() - getLeft()) - this.f464u.right;
                int childCount = getChildCount();
                int i3 = 0;
                View view2 = null;
                View view3 = null;
                View view4 = null;
                switch (this.f451h) {
                    case 1:
                    case 3:
                    case 4:
                    case 5:
                        view = null;
                        break;
                    case 2:
                        i = this.ak - this.f416V;
                        if (i >= 0 && i < childCount) {
                            view3 = getChildAt(i);
                            view = null;
                            break;
                        }
                        view = null;
                        break;
                        break;
                    default:
                        int i4 = this.am - this.f416V;
                        if (i4 >= 0 && i4 < childCount) {
                            view2 = getChildAt(i4);
                        }
                        childAt = getChildAt(0);
                        if (this.ak >= 0) {
                            i3 = this.ak - this.am;
                        }
                        view3 = getChildAt(i4 + i3);
                        view = childAt;
                        break;
                }
                boolean z2 = this.aj;
                if (z2) {
                    mo14k();
                }
                if (this.ao == 0) {
                    mo10c();
                    mo9b();
                    if (!z) {
                        this.at = false;
                    }
                } else if (this.ao != this.f453j.getCount()) {
                    throw new IllegalStateException("The content of the adapter has changed but ListView did not receive a notification. Make sure the content of your adapter is not modified from a background thread, but only from the UI thread. [in ListView(" + getId() + ", " + getClass() + ") with Adapter(" + this.f453j.getClass() + ")]");
                } else {
                    setSelectedPositionInt(this.ak);
                    int i5 = this.f416V;
                    RecycleBin recycleBin = this.f459p;
                    childAt = null;
                    if (z2) {
                        for (i = 0; i < childCount; i++) {
                            recycleBin.m382a(getChildAt(i), i5 + i);
                        }
                    } else {
                        recycleBin.m381a(childCount, i5);
                    }
                    View focusedChild = getFocusedChild();
                    if (focusedChild != null) {
                        if (!z2 || m505c(focusedChild)) {
                            view4 = findFocus();
                            if (view4 != null) {
                                view4.onStartTemporaryDetach();
                            }
                            childAt = focusedChild;
                        }
                        requestFocus();
                        focusedChild = view4;
                        view4 = childAt;
                    } else {
                        focusedChild = null;
                        view4 = null;
                    }
                    detachAllViewsFromParent();
                    recycleBin.m385d();
                    switch (this.f451h) {
                        case 1:
                            this.V = 0;
                            childAt = m508e(i2);
                            m525p();
                            view2 = childAt;
                            break;
                        case 2:
                            if (view3 == null) {
                                view2 = m509e(i2, right);
                                break;
                            } else {
                                view2 = m483a(view3.getLeft(), i2, right);
                                break;
                            }
                        case 3:
                            childAt = m506d(this.ao - 1, right);
                            m525p();
                            view2 = childAt;
                            break;
                        case 4:
                            view2 = m512f(m464i(), this.f417W);
                            break;
                        case 5:
                            view2 = m512f(this.aa, this.f417W);
                            break;
                        case 6:
                            view2 = m485a(view2, view3, i3, i2, right);
                            break;
                        default:
                            if (childCount != 0) {
                                int i6;
                                if (this.am < 0 || this.am >= this.ao) {
                                    if (this.f416V >= this.ao) {
                                        view2 = m512f(0, i2);
                                        break;
                                    }
                                    i6 = this.f416V;
                                    if (view != null) {
                                        i2 = view.getLeft();
                                    }
                                    view2 = m512f(i6, i2);
                                    break;
                                }
                                i6 = this.am;
                                if (view2 != null) {
                                    i2 = view2.getLeft();
                                }
                                view2 = m512f(i6, i2);
                                break;
                            } else if (!this.f435K) {
                                setSelectedPositionInt(mo20a(0, true));
                                view2 = m508e(i2);
                                break;
                            } else {
                                setSelectedPositionInt(mo20a(this.ao - 1, false));
                                view2 = m506d(this.ao - 1, right);
                                break;
                            }
                    }
                    recycleBin.m386e();
                    if (view2 != null) {
                        if (this.aG && hasFocus() && !view2.hasFocus()) {
                            Object obj = ((view2 == view4 && focusedChild != null && focusedChild.requestFocus()) || view2.requestFocus()) ? 1 : null;
                            if (obj == null) {
                                childAt = getFocusedChild();
                                if (childAt != null) {
                                    childAt.clearFocus();
                                }
                                m450a(-1, view2);
                            } else {
                                view2.setSelected(false);
                                this.f458o.setEmpty();
                            }
                        } else {
                            m450a(-1, view2);
                        }
                        this.J = view2.getLeft();
                    } else {
                        if (this.f430F <= 0 || this.f430F >= 3) {
                            this.J = 0;
                            this.f458o.setEmpty();
                        } else {
                            childAt = getChildAt(this.f425A - this.f416V);
                            if (childAt != null) {
                                m450a(this.f425A, childAt);
                            }
                        }
                        if (hasFocus() && focusedChild != null) {
                            focusedChild.requestFocus();
                        }
                    }
                    if (!(focusedChild == null || focusedChild.getWindowToken() == null)) {
                        focusedChild.onFinishTemporaryDetach();
                    }
                    this.h = 0;
                    this.aj = false;
                    if (this.f439O != null) {
                        post(this.f439O);
                        this.O = null;
                    }
                    this.ad = false;
                    setNextSelectedPositionInt(this.am);
                    mo12e();
                    if (this.ao > 0) {
                        m404m();
                    }
                    mo9b();
                    if (!z) {
                        this.at = false;
                    }
                }
            } finally {
                if (!z) {
                    this.at = false;
                }
            }
        }
    }

    private boolean m505c(View view) {
        int i;
        ArrayList arrayList = this.az;
        int size = arrayList.size();
        for (i = 0; i < size; i++) {
            if (view == ((FixedViewInfo) arrayList.get(i)).f506a) {
                return true;
            }
        }
        arrayList = this.aA;
        size = arrayList.size();
        for (i = 0; i < size; i++) {
            if (view == ((FixedViewInfo) arrayList.get(i)).f506a) {
                return true;
            }
        }
        return false;
    }

    private View m484a(int i, int i2, boolean z, int i3, boolean z2) {
        View c;
        if (!this.aj) {
            c = this.f459p.m384c(i);
            if (c != null) {
                m491a(c, i, i2, z, i3, z2, true);
                return c;
            }
        }
        c = m446a(i, this.f440P);
        m491a(c, i, i2, z, i3, z2, this.f440P[0]);
        return c;
    }

    @TargetApi(11)
    private void m491a(View view, int i, int i2, boolean z, int i3, boolean z2, boolean z3) {
        Object obj;
        ViewGroup.LayoutParams layoutParams;
        int childMeasureSpec;
        boolean z4 = z2 && m461f();
        Object obj2 = z4 != view.isSelected() ? 1 : null;
        int i4 = this.f430F;
        boolean z5 = i4 > 0 && i4 < 3 && this.f425A == i;
        Object obj3 = z5 != view.isPressed() ? 1 : null;
        if (z3 && obj2 == null && !view.isLayoutRequested()) {
            obj = null;
        } else {
            obj = 1;
        }
        ViewGroup.LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams = (LayoutParams) generateDefaultLayoutParams();
        } else {
            layoutParams = layoutParams2;
        }
        layoutParams.f388a = this.f453j.getItemViewType(i);
        if ((!z3 || layoutParams.f390c) && !(layoutParams.f389b && layoutParams.f388a == -2)) {
            layoutParams.f390c = false;
            if (layoutParams.f388a == -2) {
                layoutParams.f389b = true;
            }
            addViewInLayout(view, z ? -1 : 0, layoutParams, true);
        } else {
            attachViewToParent(view, z ? -1 : 0, layoutParams);
        }
        if (obj2 != null) {
            view.setSelected(z4);
        }
        if (obj3 != null) {
            view.setPressed(z5);
        }
        if (!(this.f445b == 0 || this.f449f == null)) {
            if (view instanceof Checkable) {
                ((Checkable) view).setChecked(this.f449f.get(i, false));
            } else if (VERSION.SDK_INT >= 11) {
                view.setActivated(this.f449f.get(i, false));
            }
        }
        if (obj != null) {
            childMeasureSpec = ViewGroup.getChildMeasureSpec(this.f465v, this.f464u.top + this.f464u.bottom, layoutParams.height);
            i4 = layoutParams.width;
            if (i4 > 0) {
                i4 = MeasureSpec.makeMeasureSpec(i4, 1073741824);
            } else {
                i4 = MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(i4, childMeasureSpec);
        } else {
            cleanupLayoutState(view);
        }
        i4 = view.getMeasuredWidth();
        childMeasureSpec = view.getMeasuredHeight();
        if (!z) {
            i2 -= i4;
        }
        if (obj != null) {
            view.layout(i2, i3, i4 + i2, childMeasureSpec + i3);
        } else {
            view.offsetLeftAndRight(i2 - view.getLeft());
            view.offsetTopAndBottom(i3 - view.getTop());
        }
        if (this.f468y && !view.isDrawingCacheEnabled()) {
            view.setDrawingCacheEnabled(true);
        }
        if (VERSION.SDK_INT >= 11 && z3 && ((LayoutParams) view.getLayoutParams()).f391d != i) {
            view.jumpDrawablesToCurrentState();
        }
    }

    protected boolean canAnimate() {
        return super.canAnimate() && this.ao > 0;
    }

    public void setSelection(int i) {
        mo21b(i, 0);
    }

    public final void mo21b(int i, int i2) {
        if (this.f453j != null) {
            if (isInTouchMode()) {
                this.M = i;
            } else {
                i = mo20a(i, true);
                if (i >= 0) {
                    setNextSelectedPositionInt(i);
                }
            }
            if (i >= 0) {
                this.h = 4;
                this.W = this.f464u.left + i2;
                if (this.ad) {
                    this.aa = i;
                    this.ab = this.f453j.getItemId(i);
                }
                if (this.f433I != null) {
                    this.f433I.m376a();
                }
                requestLayout();
            }
        }
    }

    public void setSelectionInt(int i) {
        Object obj = 1;
        setNextSelectedPositionInt(i);
        int i2 = this.am;
        if (i2 < 0 || !(i == i2 - 1 || i == i2 + 1)) {
            obj = null;
        }
        if (this.f433I != null) {
            this.f433I.m376a();
        }
        mo11d();
        if (obj != null) {
            awakenScrollBars();
        }
    }

    protected final int mo20a(int i, boolean z) {
        ListAdapter listAdapter = this.f453j;
        if (listAdapter == null || isInTouchMode()) {
            return -1;
        }
        int count = listAdapter.getCount();
        if (!this.aF) {
            if (z) {
                i = Math.max(0, i);
                while (i < count && !listAdapter.isEnabled(i)) {
                    i++;
                }
            } else {
                i = Math.min(i, count - 1);
                while (i >= 0 && !listAdapter.isEnabled(i)) {
                    i--;
                }
            }
            if (i < 0 || i >= count) {
                return -1;
            }
            return i;
        } else if (i < 0 || i >= count) {
            return -1;
        } else {
            return i;
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        if (dispatchKeyEvent || getFocusedChild() == null || keyEvent.getAction() != 0) {
            return dispatchKeyEvent;
        }
        return onKeyDown(keyEvent.getKeyCode(), keyEvent);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return m494a(i, 1, keyEvent);
    }

    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        return m494a(i, i2, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return m494a(i, 1, keyEvent);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.TargetApi(11)
    private boolean m494a(int r9, int r10, android.view.KeyEvent r11) {
        /*
        r8 = this;
        r7 = 2;
        r6 = 130; // 0x82 float:1.82E-43 double:6.4E-322;
        r5 = 33;
        r1 = 0;
        r2 = 1;
        r0 = r8.f453j;
        if (r0 == 0) goto L_0x000f;
    L_0x000b:
        r0 = r8.f443S;
        if (r0 != 0) goto L_0x0010;
    L_0x000f:
        return r1;
    L_0x0010:
        r0 = r8.aj;
        if (r0 == 0) goto L_0x0017;
    L_0x0014:
        r8.mo11d();
    L_0x0017:
        r0 = android.os.Build.VERSION.SDK_INT;
        r3 = 11;
        if (r0 < r3) goto L_0x000f;
    L_0x001d:
        r4 = r11.getAction();
        if (r4 == r2) goto L_0x0026;
    L_0x0023:
        switch(r9) {
            case 19: goto L_0x002b;
            case 20: goto L_0x005b;
            case 21: goto L_0x008b;
            case 22: goto L_0x0098;
            case 23: goto L_0x00a5;
            case 62: goto L_0x00c3;
            case 66: goto L_0x00a5;
            case 92: goto L_0x00e5;
            case 93: goto L_0x0115;
            case 122: goto L_0x0145;
            case 123: goto L_0x015d;
            default: goto L_0x0026;
        };
    L_0x0026:
        r0 = r1;
    L_0x0027:
        if (r0 == 0) goto L_0x0175;
    L_0x0029:
        r1 = r2;
        goto L_0x000f;
    L_0x002b:
        r0 = r11.hasNoModifiers();
        if (r0 == 0) goto L_0x0045;
    L_0x0031:
        r0 = r8.m465j();
        if (r0 != 0) goto L_0x0027;
    L_0x0037:
        r3 = r10;
    L_0x0038:
        r10 = r3 + -1;
        if (r3 <= 0) goto L_0x0027;
    L_0x003c:
        r3 = r8.m520k(r5);
        if (r3 == 0) goto L_0x0027;
    L_0x0042:
        r0 = r2;
        r3 = r10;
        goto L_0x0038;
    L_0x0045:
        r0 = r11.hasModifiers(r7);
        if (r0 == 0) goto L_0x0026;
    L_0x004b:
        r0 = r8.m465j();
        if (r0 != 0) goto L_0x0057;
    L_0x0051:
        r0 = r8.m518i(r5);
        if (r0 == 0) goto L_0x0059;
    L_0x0057:
        r0 = r2;
        goto L_0x0027;
    L_0x0059:
        r0 = r1;
        goto L_0x0027;
    L_0x005b:
        r0 = r11.hasNoModifiers();
        if (r0 == 0) goto L_0x0075;
    L_0x0061:
        r0 = r8.m465j();
        if (r0 != 0) goto L_0x0027;
    L_0x0067:
        r3 = r10;
    L_0x0068:
        r10 = r3 + -1;
        if (r3 <= 0) goto L_0x0027;
    L_0x006c:
        r3 = r8.m520k(r6);
        if (r3 == 0) goto L_0x0027;
    L_0x0072:
        r0 = r2;
        r3 = r10;
        goto L_0x0068;
    L_0x0075:
        r0 = r11.hasModifiers(r7);
        if (r0 == 0) goto L_0x0026;
    L_0x007b:
        r0 = r8.m465j();
        if (r0 != 0) goto L_0x0087;
    L_0x0081:
        r0 = r8.m518i(r6);
        if (r0 == 0) goto L_0x0089;
    L_0x0087:
        r0 = r2;
        goto L_0x0027;
    L_0x0089:
        r0 = r1;
        goto L_0x0027;
    L_0x008b:
        r0 = r11.hasNoModifiers();
        if (r0 == 0) goto L_0x0026;
    L_0x0091:
        r0 = 17;
        r0 = r8.m519j(r0);
        goto L_0x0027;
    L_0x0098:
        r0 = r11.hasNoModifiers();
        if (r0 == 0) goto L_0x0026;
    L_0x009e:
        r0 = 66;
        r0 = r8.m519j(r0);
        goto L_0x0027;
    L_0x00a5:
        r0 = r11.hasNoModifiers();
        if (r0 == 0) goto L_0x0026;
    L_0x00ab:
        r0 = r8.m465j();
        if (r0 != 0) goto L_0x0027;
    L_0x00b1:
        r3 = r11.getRepeatCount();
        if (r3 != 0) goto L_0x0027;
    L_0x00b7:
        r3 = r8.getChildCount();
        if (r3 <= 0) goto L_0x0027;
    L_0x00bd:
        r8.m462g();
        r0 = r2;
        goto L_0x0027;
    L_0x00c3:
        r0 = r11.hasNoModifiers();
        if (r0 == 0) goto L_0x00d5;
    L_0x00c9:
        r0 = r8.m465j();
        if (r0 != 0) goto L_0x00d2;
    L_0x00cf:
        r8.m517h(r6);
    L_0x00d2:
        r0 = r2;
        goto L_0x0027;
    L_0x00d5:
        r0 = r11.hasModifiers(r2);
        if (r0 == 0) goto L_0x00d2;
    L_0x00db:
        r0 = r8.m465j();
        if (r0 != 0) goto L_0x00d2;
    L_0x00e1:
        r8.m517h(r5);
        goto L_0x00d2;
    L_0x00e5:
        r0 = r11.hasNoModifiers();
        if (r0 == 0) goto L_0x00fd;
    L_0x00eb:
        r0 = r8.m465j();
        if (r0 != 0) goto L_0x00f7;
    L_0x00f1:
        r0 = r8.m517h(r5);
        if (r0 == 0) goto L_0x00fa;
    L_0x00f7:
        r0 = r2;
        goto L_0x0027;
    L_0x00fa:
        r0 = r1;
        goto L_0x0027;
    L_0x00fd:
        r0 = r11.hasModifiers(r7);
        if (r0 == 0) goto L_0x0026;
    L_0x0103:
        r0 = r8.m465j();
        if (r0 != 0) goto L_0x010f;
    L_0x0109:
        r0 = r8.m518i(r5);
        if (r0 == 0) goto L_0x0112;
    L_0x010f:
        r0 = r2;
        goto L_0x0027;
    L_0x0112:
        r0 = r1;
        goto L_0x0027;
    L_0x0115:
        r0 = r11.hasNoModifiers();
        if (r0 == 0) goto L_0x012d;
    L_0x011b:
        r0 = r8.m465j();
        if (r0 != 0) goto L_0x0127;
    L_0x0121:
        r0 = r8.m517h(r6);
        if (r0 == 0) goto L_0x012a;
    L_0x0127:
        r0 = r2;
        goto L_0x0027;
    L_0x012a:
        r0 = r1;
        goto L_0x0027;
    L_0x012d:
        r0 = r11.hasModifiers(r7);
        if (r0 == 0) goto L_0x0026;
    L_0x0133:
        r0 = r8.m465j();
        if (r0 != 0) goto L_0x013f;
    L_0x0139:
        r0 = r8.m518i(r6);
        if (r0 == 0) goto L_0x0142;
    L_0x013f:
        r0 = r2;
        goto L_0x0027;
    L_0x0142:
        r0 = r1;
        goto L_0x0027;
    L_0x0145:
        r0 = r11.hasNoModifiers();
        if (r0 == 0) goto L_0x0026;
    L_0x014b:
        r0 = r8.m465j();
        if (r0 != 0) goto L_0x0157;
    L_0x0151:
        r0 = r8.m518i(r5);
        if (r0 == 0) goto L_0x015a;
    L_0x0157:
        r0 = r2;
        goto L_0x0027;
    L_0x015a:
        r0 = r1;
        goto L_0x0027;
    L_0x015d:
        r0 = r11.hasNoModifiers();
        if (r0 == 0) goto L_0x0026;
    L_0x0163:
        r0 = r8.m465j();
        if (r0 != 0) goto L_0x016f;
    L_0x0169:
        r0 = r8.m518i(r6);
        if (r0 == 0) goto L_0x0172;
    L_0x016f:
        r0 = r2;
        goto L_0x0027;
    L_0x0172:
        r0 = r1;
        goto L_0x0027;
    L_0x0175:
        switch(r4) {
            case 0: goto L_0x017a;
            case 1: goto L_0x0180;
            case 2: goto L_0x0186;
            default: goto L_0x0178;
        };
    L_0x0178:
        goto L_0x000f;
    L_0x017a:
        r1 = super.onKeyDown(r9, r11);
        goto L_0x000f;
    L_0x0180:
        r1 = super.onKeyUp(r9, r11);
        goto L_0x000f;
    L_0x0186:
        r1 = super.onKeyMultiple(r9, r10, r11);
        goto L_0x000f;
        */
        throw new UnsupportedOperationException("Method not decompiled: it.sephiroth.android.library.widget.HListView.a(int, int, android.view.KeyEvent):boolean");
    }

    private boolean m517h(int i) {
        int max;
        boolean z;
        if (i == 33) {
            max = Math.max(0, (this.am - getChildCount()) - 1);
            z = false;
        } else if (i == 130) {
            max = Math.min(this.ao - 1, (this.am + getChildCount()) - 1);
            z = true;
        } else {
            max = -1;
            z = false;
        }
        if (max >= 0) {
            max = mo20a(max, z);
            if (max >= 0) {
                this.h = 4;
                this.W = getPaddingLeft() + getHorizontalFadingEdgeLength();
                if (z && max > this.ao - getChildCount()) {
                    this.h = 3;
                }
                if (!z && max < getChildCount()) {
                    this.h = 1;
                }
                setSelectionInt(max);
                mo9b();
                if (awakenScrollBars()) {
                    return true;
                }
                invalidate();
                return true;
            }
        }
        return false;
    }

    private boolean m518i(int i) {
        boolean z = true;
        int a;
        if (i == 33) {
            if (this.am != 0) {
                a = mo20a(0, true);
                if (a >= 0) {
                    this.h = 1;
                    setSelectionInt(a);
                    mo9b();
                }
            }
            z = false;
        } else {
            if (i == 130 && this.am < this.ao - 1) {
                a = mo20a(this.ao - 1, true);
                if (a >= 0) {
                    this.h = 3;
                    setSelectionInt(a);
                    mo9b();
                }
            }
            z = false;
        }
        if (z && !awakenScrollBars()) {
            awakenScrollBars();
            invalidate();
        }
        return z;
    }

    private boolean m519j(int i) {
        if (i == 17 || i == 66) {
            int childCount = getChildCount();
            if (this.aG && childCount > 0 && this.am != -1) {
                View selectedView = getSelectedView();
                if (selectedView != null && selectedView.hasFocus() && (selectedView instanceof ViewGroup)) {
                    View findFocus = selectedView.findFocus();
                    selectedView = FocusFinder.getInstance().findNextFocus((ViewGroup) selectedView, findFocus, i);
                    if (selectedView != null) {
                        findFocus.getFocusedRect(this.aH);
                        offsetDescendantRectToMyCoords(findFocus, this.aH);
                        offsetRectIntoDescendantCoords(selectedView, this.aH);
                        if (selectedView.requestFocus(i, this.aH)) {
                            return true;
                        }
                    }
                    selectedView = FocusFinder.getInstance().findNextFocus((ViewGroup) getRootView(), findFocus, i);
                    if (selectedView != null) {
                        return m495a(selectedView, (View) this);
                    }
                }
            }
            return false;
        }
        throw new IllegalArgumentException("direction must be one of {View.FOCUS_LEFT, View.FOCUS_RIGHT}");
    }

    private boolean m520k(int i) {
        try {
            this.af = true;
            boolean l = m521l(i);
            if (l) {
                playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
            }
            this.af = false;
            return l;
        } catch (Throwable th) {
            this.af = false;
        }
    }

    private boolean m521l(int i) {
        if (getChildCount() <= 0) {
            return false;
        }
        boolean z;
        View selectedView;
        int i2;
        View findFocus;
        View selectedView2 = getSelectedView();
        int i3 = this.am;
        int m = m522m(i);
        int g = m514g(i, m);
        ArrowScrollFocusResult n = this.aG ? m523n(i) : null;
        if (n != null) {
            m = n.f504a;
            g = n.f505b;
        }
        if (n != null) {
            z = true;
        } else {
            z = false;
        }
        if (m != -1) {
            if (n != null) {
                z = true;
            } else {
                z = false;
            }
            m490a(selectedView2, i, m, z);
            setSelectedPositionInt(m);
            setNextSelectedPositionInt(m);
            selectedView = getSelectedView();
            if (this.aG && n == null) {
                View focusedChild = getFocusedChild();
                if (focusedChild != null) {
                    focusedChild.clearFocus();
                }
            }
            m404m();
            z = true;
            i2 = m;
        } else {
            int i4 = i3;
            selectedView = selectedView2;
            i2 = i4;
        }
        if (g > 0) {
            m524o(i == 33 ? g : -g);
            z = true;
        }
        if (this.aG && n == null && selectedView != null && selectedView.hasFocus()) {
            findFocus = selectedView.findFocus();
            if (!m495a(findFocus, (View) this) || m515g(findFocus) > 0) {
                findFocus.clearFocus();
            }
        }
        if (m != -1 || selectedView == null || m495a(selectedView, (View) this)) {
            findFocus = selectedView;
        } else {
            m463h();
            this.M = -1;
            findFocus = null;
        }
        if (!z) {
            return false;
        }
        if (findFocus != null) {
            m450a(i2, findFocus);
            this.J = findFocus.getLeft();
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        mo9b();
        return true;
    }

    private void m490a(View view, int i, int i2, boolean z) {
        boolean z2 = true;
        if (i2 == -1) {
            throw new IllegalArgumentException("newSelectedPosition needs to be valid");
        }
        View childAt;
        int i3 = this.am - this.f416V;
        int i4 = i2 - this.f416V;
        boolean z3;
        if (i == 33) {
            childAt = getChildAt(i4);
            z3 = true;
        } else {
            z3 = false;
            View view2 = view;
            view = getChildAt(i4);
            childAt = view2;
            int i5 = i3;
            i3 = i4;
            i4 = i5;
        }
        int childCount = getChildCount();
        if (childAt != null) {
            boolean z4;
            if (z || !r3) {
                z4 = false;
            } else {
                z4 = true;
            }
            childAt.setSelected(z4);
            m500b(childAt, i4, childCount);
        }
        if (view != null) {
            if (z || r3) {
                z2 = false;
            }
            view.setSelected(z2);
            m500b(view, i3, childCount);
        }
    }

    private void m500b(View view, int i, int i2) {
        int width = view.getWidth();
        m507d(view);
        if (view.getMeasuredWidth() != width) {
            m510e(view);
            int measuredWidth = view.getMeasuredWidth() - width;
            for (width = i + 1; width < i2; width++) {
                getChildAt(width).offsetLeftAndRight(measuredWidth);
            }
        }
    }

    private void m507d(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, -1);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.f465v, this.f464u.top + this.f464u.bottom, layoutParams.height);
        int i = layoutParams.width;
        if (i > 0) {
            i = MeasureSpec.makeMeasureSpec(i, 1073741824);
        } else {
            i = MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(i, childMeasureSpec);
    }

    private void m510e(View view) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i = this.f464u.top;
        measuredHeight += i;
        int left = view.getLeft();
        view.layout(left, i, measuredWidth + left, measuredHeight);
    }

    private int getArrowScrollPreviewLength() {
        return Math.max(2, getHorizontalFadingEdgeLength());
    }

    private int m514g(int i, int i2) {
        int width = getWidth() - this.f464u.right;
        int i3 = this.f464u.left;
        int childCount = getChildCount();
        int i4;
        if (i == 130) {
            i4 = childCount - 1;
            if (i2 != -1) {
                i4 = i2 - this.f416V;
            }
            i3 = this.f416V + i4;
            View childAt = getChildAt(i4);
            if (i3 < this.ao - 1) {
                i4 = width - getArrowScrollPreviewLength();
            } else {
                i4 = width;
            }
            if (childAt.getRight() <= i4) {
                return 0;
            }
            if (i2 != -1 && i4 - childAt.getLeft() >= getMaxScrollAmount()) {
                return 0;
            }
            i4 = childAt.getRight() - i4;
            if (this.f416V + childCount == this.ao) {
                i4 = Math.min(i4, getChildAt(childCount - 1).getRight() - width);
            }
            return Math.min(i4, getMaxScrollAmount());
        }
        if (i2 != -1) {
            i4 = i2 - this.f416V;
        } else {
            i4 = 0;
        }
        width = this.f416V + i4;
        View childAt2 = getChildAt(i4);
        if (width > 0) {
            i4 = getArrowScrollPreviewLength() + i3;
        } else {
            i4 = i3;
        }
        if (childAt2.getLeft() >= i4) {
            return 0;
        }
        if (i2 != -1 && childAt2.getRight() - i4 >= getMaxScrollAmount()) {
            return 0;
        }
        i4 -= childAt2.getLeft();
        if (this.f416V == 0) {
            i4 = Math.min(i4, i3 - getChildAt(0).getLeft());
        }
        return Math.min(i4, getMaxScrollAmount());
    }

    private int m522m(int i) {
        int i2 = this.f416V;
        int i3;
        int lastVisiblePosition;
        if (i == 130) {
            i3 = this.am != -1 ? this.am + 1 : i2;
            if (i3 >= this.f453j.getCount()) {
                return -1;
            }
            if (i3 < i2) {
                i3 = i2;
            }
            lastVisiblePosition = getLastVisiblePosition();
            ListAdapter listAdapter = this.f453j;
            while (i3 <= lastVisiblePosition) {
                if (listAdapter.isEnabled(i3) && getChildAt(i3 - i2).getVisibility() == 0) {
                    return i3;
                }
                i3++;
            }
        } else {
            i3 = (getChildCount() + i2) - 1;
            lastVisiblePosition = this.am != -1 ? this.am - 1 : (getChildCount() + i2) - 1;
            if (lastVisiblePosition < 0 || lastVisiblePosition >= this.f453j.getCount()) {
                return -1;
            }
            if (lastVisiblePosition <= i3) {
                i3 = lastVisiblePosition;
            }
            ListAdapter listAdapter2 = this.f453j;
            while (i3 >= i2) {
                if (listAdapter2.isEnabled(i3) && getChildAt(i3 - i2).getVisibility() == 0) {
                    return i3;
                }
                i3--;
            }
        }
        return -1;
    }

    private ArrowScrollFocusResult m523n(int i) {
        int i2;
        View findNextFocusFromRect;
        int i3 = 1;
        View selectedView = getSelectedView();
        if (selectedView == null || !selectedView.hasFocus()) {
            if (i == 130) {
                if (this.f416V <= 0) {
                    i3 = 0;
                }
                i2 = this.f464u.left;
                if (i3 != 0) {
                    i3 = getArrowScrollPreviewLength();
                } else {
                    i3 = 0;
                }
                i3 += i2;
                if (selectedView != null && selectedView.getLeft() > i3) {
                    i3 = selectedView.getLeft();
                }
                this.aH.set(i3, 0, i3, 0);
            } else {
                if ((this.f416V + getChildCount()) - 1 >= this.ao) {
                    i3 = 0;
                }
                i2 = getWidth() - this.f464u.right;
                if (i3 != 0) {
                    i3 = getArrowScrollPreviewLength();
                } else {
                    i3 = 0;
                }
                i3 = i2 - i3;
                if (selectedView != null && selectedView.getRight() < i3) {
                    i3 = selectedView.getRight();
                }
                this.aH.set(i3, 0, i3, 0);
            }
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocusFromRect(this, this.aH, i);
        } else {
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocus(this, selectedView.findFocus(), i);
        }
        if (findNextFocusFromRect != null) {
            int m;
            int f = m511f(findNextFocusFromRect);
            if (!(this.am == -1 || f == this.am)) {
                m = m522m(i);
                if (m != -1 && ((i == 130 && m < f) || (i == 33 && m > f))) {
                    return null;
                }
            }
            m = m482a(i, findNextFocusFromRect, f);
            i2 = getMaxScrollAmount();
            if (m < i2) {
                findNextFocusFromRect.requestFocus(i);
                this.aJ.m478a(f, m);
                return this.aJ;
            } else if (m515g(findNextFocusFromRect) < i2) {
                findNextFocusFromRect.requestFocus(i);
                this.aJ.m478a(f, i2);
                return this.aJ;
            }
        }
        return null;
    }

    private int m511f(View view) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (m495a(view, getChildAt(i))) {
                return i + this.f416V;
            }
        }
        throw new IllegalArgumentException("newFocus is not a child of any of the children of the list!");
    }

    private boolean m495a(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        return (parent instanceof ViewGroup) && m495a((View) parent, view2);
    }

    private int m482a(int i, View view, int i2) {
        view.getDrawingRect(this.aH);
        offsetDescendantRectToMyCoords(view, this.aH);
        int i3;
        if (i != 33) {
            int width = getWidth() - this.f464u.right;
            if (this.aH.bottom <= width) {
                return 0;
            }
            i3 = this.aH.right - width;
            if (i2 < this.ao - 1) {
                return i3 + getArrowScrollPreviewLength();
            }
            return i3;
        } else if (this.aH.left >= this.f464u.left) {
            return 0;
        } else {
            i3 = this.f464u.left - this.aH.left;
            return i2 > 0 ? i3 + getArrowScrollPreviewLength() : i3;
        }
    }

    private int m515g(View view) {
        view.getDrawingRect(this.aH);
        offsetDescendantRectToMyCoords(view, this.aH);
        int right = (getRight() - getLeft()) - this.f464u.right;
        if (this.aH.right < this.f464u.left) {
            return this.f464u.left - this.aH.right;
        }
        if (this.aH.left > right) {
            return this.aH.left - right;
        }
        return 0;
    }

    private void m524o(int i) {
        m455b(i);
        int width = getWidth() - this.f464u.right;
        int i2 = this.f464u.left;
        RecycleBin recycleBin = this.f459p;
        int childCount;
        View childAt;
        View childAt2;
        if (i < 0) {
            childCount = getChildCount();
            childAt = getChildAt(childCount - 1);
            while (childAt.getRight() < width) {
                int i3 = (this.f416V + childCount) - 1;
                if (i3 >= this.ao - 1) {
                    break;
                }
                childAt = m504c(childAt, i3);
                childCount++;
            }
            if (childAt.getBottom() < width) {
                m455b(width - childAt.getRight());
            }
            childAt2 = getChildAt(0);
            while (childAt2.getRight() < i2) {
                if (RecycleBin.m377b(((LayoutParams) childAt2.getLayoutParams()).f388a)) {
                    detachViewFromParent(childAt2);
                    recycleBin.m382a(childAt2, this.f416V);
                } else {
                    removeViewInLayout(childAt2);
                }
                childAt = getChildAt(0);
                this.V = this.f416V + 1;
                childAt2 = childAt;
            }
            return;
        }
        childAt = getChildAt(0);
        while (childAt.getLeft() > i2 && this.f416V > 0) {
            childAt = m497b(childAt, this.f416V);
            this.V = this.f416V - 1;
        }
        if (childAt.getLeft() > i2) {
            m455b(i2 - childAt.getLeft());
        }
        childCount = getChildCount() - 1;
        i2 = childCount;
        childAt2 = getChildAt(childCount);
        while (childAt2.getLeft() > width) {
            if (RecycleBin.m377b(((LayoutParams) childAt2.getLayoutParams()).f388a)) {
                detachViewFromParent(childAt2);
                recycleBin.m382a(childAt2, this.f416V + i2);
            } else {
                removeViewInLayout(childAt2);
            }
            childCount = i2 - 1;
            i2 = childCount;
            childAt2 = getChildAt(childCount);
        }
    }

    private View m497b(View view, int i) {
        int i2 = i - 1;
        View a = m446a(i2, this.f440P);
        m491a(a, i2, view.getLeft() - this.av, false, this.f464u.top, false, this.f440P[0]);
        return a;
    }

    private View m504c(View view, int i) {
        int i2 = i + 1;
        View a = m446a(i2, this.f440P);
        m491a(a, i2, this.av + view.getRight(), true, this.f464u.top, false, this.f440P[0]);
        return a;
    }

    public void setItemsCanFocus(boolean z) {
        this.aG = z;
        if (!z) {
            setDescendantFocusability(393216);
        }
    }

    public boolean getItemsCanFocus() {
        return this.aG;
    }

    public boolean isOpaque() {
        boolean z = (this.f469z && this.aB && this.aC) || super.isOpaque();
        if (z) {
            int paddingLeft = this.f464u != null ? this.f464u.left : getPaddingLeft();
            View childAt = getChildAt(0);
            if (childAt == null || childAt.getLeft() > paddingLeft) {
                return false;
            }
            paddingLeft = getWidth() - (this.f464u != null ? this.f464u.right : getPaddingRight());
            childAt = getChildAt(getChildCount() - 1);
            if (childAt == null || childAt.getRight() < paddingLeft) {
                return false;
            }
        }
        return z;
    }

    public void setCacheColorHint(int i) {
        boolean z = (i >>> 24) == 255;
        this.aB = z;
        if (z) {
            if (this.aI == null) {
                this.aI = new Paint();
            }
            this.aI.setColor(i);
        }
        super.setCacheColorHint(i);
    }

    private static void m487a(Canvas canvas, Drawable drawable, Rect rect) {
        int minimumWidth = drawable.getMinimumWidth();
        canvas.save();
        canvas.clipRect(rect);
        if (rect.right - rect.left < minimumWidth) {
            rect.left = rect.right - minimumWidth;
        }
        drawable.setBounds(rect);
        drawable.draw(canvas);
        canvas.restore();
    }

    private static void m498b(Canvas canvas, Drawable drawable, Rect rect) {
        int minimumWidth = drawable.getMinimumWidth();
        canvas.save();
        canvas.clipRect(rect);
        if (rect.right - rect.left < minimumWidth) {
            rect.right = minimumWidth + rect.left;
        }
        drawable.setBounds(rect);
        drawable.draw(canvas);
        canvas.restore();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void dispatchDraw(android.graphics.Canvas r25) {
        /*
        r24 = this;
        r0 = r24;
        r2 = r0.f468y;
        if (r2 == 0) goto L_0x000b;
    L_0x0006:
        r2 = 1;
        r0 = r24;
        r0.z = r2;
    L_0x000b:
        r0 = r24;
        r8 = r0.av;
        r0 = r24;
        r9 = r0.ax;
        r0 = r24;
        r10 = r0.ay;
        if (r9 == 0) goto L_0x013b;
    L_0x0019:
        r2 = 1;
        r7 = r2;
    L_0x001b:
        if (r10 == 0) goto L_0x013f;
    L_0x001d:
        r2 = 1;
        r6 = r2;
    L_0x001f:
        if (r8 <= 0) goto L_0x0143;
    L_0x0021:
        r0 = r24;
        r2 = r0.au;
        if (r2 == 0) goto L_0x0143;
    L_0x0027:
        r2 = 1;
        r5 = r2;
    L_0x0029:
        if (r5 != 0) goto L_0x002f;
    L_0x002b:
        if (r7 != 0) goto L_0x002f;
    L_0x002d:
        if (r6 == 0) goto L_0x0185;
    L_0x002f:
        r0 = r24;
        r11 = r0.aH;
        r2 = r24.getPaddingTop();
        r11.top = r2;
        r2 = r24.getBottom();
        r3 = r24.getTop();
        r2 = r2 - r3;
        r3 = r24.getPaddingBottom();
        r2 = r2 - r3;
        r11.bottom = r2;
        r12 = r24.getChildCount();
        r0 = r24;
        r2 = r0.az;
        r13 = r2.size();
        r0 = r24;
        r14 = r0.ao;
        r0 = r24;
        r2 = r0.aA;
        r2 = r2.size();
        r2 = r14 - r2;
        r15 = r2 + -1;
        r0 = r24;
        r0 = r0.aD;
        r16 = r0;
        r0 = r24;
        r0 = r0.aE;
        r17 = r0;
        r0 = r24;
        r0 = r0.f416V;
        r18 = r0;
        r0 = r24;
        r0 = r0.aF;
        r19 = r0;
        r0 = r24;
        r0 = r0.f453j;
        r20 = r0;
        r2 = r24.isOpaque();
        if (r2 == 0) goto L_0x0147;
    L_0x0089:
        r2 = super.isOpaque();
        if (r2 != 0) goto L_0x0147;
    L_0x008f:
        r2 = 1;
        r4 = r2;
    L_0x0091:
        if (r4 == 0) goto L_0x00b3;
    L_0x0093:
        r0 = r24;
        r2 = r0.aI;
        if (r2 != 0) goto L_0x00b3;
    L_0x0099:
        r0 = r24;
        r2 = r0.aB;
        if (r2 == 0) goto L_0x00b3;
    L_0x009f:
        r2 = new android.graphics.Paint;
        r2.<init>();
        r0 = r24;
        r0.aI = r2;
        r0 = r24;
        r2 = r0.aI;
        r3 = r24.getCacheColorHint();
        r2.setColor(r3);
    L_0x00b3:
        r0 = r24;
        r0 = r0.aI;
        r21 = r0;
        r2 = r24.getRight();
        r3 = r24.getLeft();
        r2 = r2 - r3;
        r2 = r2 + 0;
        r3 = r24.getScrollX();
        r22 = r2 + r3;
        r0 = r24;
        r2 = r0.f435K;
        if (r2 != 0) goto L_0x0189;
    L_0x00d0:
        r3 = 0;
        r2 = r24.getScrollX();
        if (r12 <= 0) goto L_0x00e5;
    L_0x00d7:
        if (r2 >= 0) goto L_0x00e5;
    L_0x00d9:
        if (r7 == 0) goto L_0x014b;
    L_0x00db:
        r7 = 0;
        r11.right = r7;
        r11.left = r2;
        r0 = r25;
        m487a(r0, r9, r11);
    L_0x00e5:
        r2 = 0;
        r23 = r2;
        r2 = r3;
        r3 = r23;
    L_0x00eb:
        if (r3 >= r12) goto L_0x016b;
    L_0x00ed:
        if (r16 != 0) goto L_0x00f3;
    L_0x00ef:
        r7 = r18 + r3;
        if (r7 < r13) goto L_0x0138;
    L_0x00f3:
        if (r17 != 0) goto L_0x00f9;
    L_0x00f5:
        r7 = r18 + r3;
        if (r7 >= r15) goto L_0x0138;
    L_0x00f9:
        r0 = r24;
        r2 = r0.getChildAt(r3);
        r2 = r2.getRight();
        if (r5 == 0) goto L_0x0138;
    L_0x0105:
        r0 = r22;
        if (r2 >= r0) goto L_0x0138;
    L_0x0109:
        if (r6 == 0) goto L_0x010f;
    L_0x010b:
        r7 = r12 + -1;
        if (r3 == r7) goto L_0x0138;
    L_0x010f:
        if (r19 != 0) goto L_0x012b;
    L_0x0111:
        r7 = r18 + r3;
        r0 = r20;
        r7 = r0.isEnabled(r7);
        if (r7 == 0) goto L_0x015b;
    L_0x011b:
        r7 = r12 + -1;
        if (r3 == r7) goto L_0x012b;
    L_0x011f:
        r7 = r18 + r3;
        r7 = r7 + 1;
        r0 = r20;
        r7 = r0.isEnabled(r7);
        if (r7 == 0) goto L_0x015b;
    L_0x012b:
        r11.left = r2;
        r7 = r2 + r8;
        r11.right = r7;
        r0 = r24;
        r1 = r25;
        r0.m486a(r1, r11);
    L_0x0138:
        r3 = r3 + 1;
        goto L_0x00eb;
    L_0x013b:
        r2 = 0;
        r7 = r2;
        goto L_0x001b;
    L_0x013f:
        r2 = 0;
        r6 = r2;
        goto L_0x001f;
    L_0x0143:
        r2 = 0;
        r5 = r2;
        goto L_0x0029;
    L_0x0147:
        r2 = 0;
        r4 = r2;
        goto L_0x0091;
    L_0x014b:
        if (r5 == 0) goto L_0x00e5;
    L_0x014d:
        r2 = 0;
        r11.right = r2;
        r2 = -r8;
        r11.left = r2;
        r0 = r24;
        r1 = r25;
        r0.m486a(r1, r11);
        goto L_0x00e5;
    L_0x015b:
        if (r4 == 0) goto L_0x0138;
    L_0x015d:
        r11.left = r2;
        r7 = r2 + r8;
        r11.right = r7;
        r0 = r25;
        r1 = r21;
        r0.drawRect(r11, r1);
        goto L_0x0138;
    L_0x016b:
        r3 = r24.getRight();
        r4 = r24.getScrollX();
        r3 = r3 + r4;
        if (r6 == 0) goto L_0x0185;
    L_0x0176:
        r4 = r18 + r12;
        if (r4 != r14) goto L_0x0185;
    L_0x017a:
        if (r3 <= r2) goto L_0x0185;
    L_0x017c:
        r11.left = r2;
        r11.right = r3;
        r0 = r25;
        m498b(r0, r10, r11);
    L_0x0185:
        super.dispatchDraw(r25);
        return;
    L_0x0189:
        r3 = r24.getScrollX();
        if (r12 <= 0) goto L_0x01a5;
    L_0x018f:
        if (r7 == 0) goto L_0x01a5;
    L_0x0191:
        r11.left = r3;
        r2 = 0;
        r0 = r24;
        r2 = r0.getChildAt(r2);
        r2 = r2.getLeft();
        r11.right = r2;
        r0 = r25;
        m487a(r0, r9, r11);
    L_0x01a5:
        if (r7 == 0) goto L_0x01ee;
    L_0x01a7:
        r2 = 1;
    L_0x01a8:
        if (r2 >= r12) goto L_0x0200;
    L_0x01aa:
        if (r16 != 0) goto L_0x01b0;
    L_0x01ac:
        r7 = r18 + r2;
        if (r7 < r13) goto L_0x01eb;
    L_0x01b0:
        if (r17 != 0) goto L_0x01b6;
    L_0x01b2:
        r7 = r18 + r2;
        if (r7 >= r15) goto L_0x01eb;
    L_0x01b6:
        r0 = r24;
        r7 = r0.getChildAt(r2);
        r7 = r7.getLeft();
        if (r7 <= 0) goto L_0x01eb;
    L_0x01c2:
        if (r19 != 0) goto L_0x01de;
    L_0x01c4:
        r9 = r18 + r2;
        r0 = r20;
        r9 = r0.isEnabled(r9);
        if (r9 == 0) goto L_0x01f0;
    L_0x01ce:
        r9 = r12 + -1;
        if (r2 == r9) goto L_0x01de;
    L_0x01d2:
        r9 = r18 + r2;
        r9 = r9 + 1;
        r0 = r20;
        r9 = r0.isEnabled(r9);
        if (r9 == 0) goto L_0x01f0;
    L_0x01de:
        r9 = r7 - r8;
        r11.left = r9;
        r11.right = r7;
        r0 = r24;
        r1 = r25;
        r0.m486a(r1, r11);
    L_0x01eb:
        r2 = r2 + 1;
        goto L_0x01a8;
    L_0x01ee:
        r2 = 0;
        goto L_0x01a8;
    L_0x01f0:
        if (r4 == 0) goto L_0x01eb;
    L_0x01f2:
        r9 = r7 - r8;
        r11.left = r9;
        r11.right = r7;
        r0 = r25;
        r1 = r21;
        r0.drawRect(r11, r1);
        goto L_0x01eb;
    L_0x0200:
        if (r12 <= 0) goto L_0x0185;
    L_0x0202:
        if (r3 <= 0) goto L_0x0185;
    L_0x0204:
        if (r6 == 0) goto L_0x0216;
    L_0x0206:
        r2 = r24.getRight();
        r11.left = r2;
        r2 = r2 + r3;
        r11.right = r2;
        r0 = r25;
        m498b(r0, r10, r11);
        goto L_0x0185;
    L_0x0216:
        if (r5 == 0) goto L_0x0185;
    L_0x0218:
        r0 = r22;
        r11.left = r0;
        r2 = r22 + r8;
        r11.right = r2;
        r0 = r24;
        r1 = r25;
        r0.m486a(r1, r11);
        goto L_0x0185;
        */
        throw new UnsupportedOperationException("Method not decompiled: it.sephiroth.android.library.widget.HListView.dispatchDraw(android.graphics.Canvas):void");
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean drawChild = super.drawChild(canvas, view, j);
        if (this.f469z) {
            this.z = false;
        }
        return drawChild;
    }

    private void m486a(Canvas canvas, Rect rect) {
        Drawable drawable = this.au;
        drawable.setBounds(rect);
        drawable.draw(canvas);
    }

    public Drawable getDivider() {
        return this.au;
    }

    public void setDivider(Drawable drawable) {
        boolean z = false;
        if (drawable != null) {
            this.av = drawable.getIntrinsicWidth();
        } else {
            this.av = 0;
        }
        this.au = drawable;
        if (drawable == null || drawable.getOpacity() == -1) {
            z = true;
        }
        this.aC = z;
        requestLayout();
        invalidate();
    }

    public int getDividerWidth() {
        return this.av;
    }

    public void setDividerWidth(int i) {
        this.av = i;
        requestLayout();
        invalidate();
    }

    public void setHeaderDividersEnabled(boolean z) {
        this.aD = z;
        invalidate();
    }

    public void setFooterDividersEnabled(boolean z) {
        this.aE = z;
        invalidate();
    }

    public void setOverscrollHeader(Drawable drawable) {
        this.ax = drawable;
        if (getScrollX() < 0) {
            invalidate();
        }
    }

    public Drawable getOverscrollHeader() {
        return this.ax;
    }

    public void setOverscrollFooter(Drawable drawable) {
        this.ay = drawable;
        invalidate();
    }

    public Drawable getOverscrollFooter() {
        return this.ay;
    }

    protected void onFocusChanged(boolean z, int i, Rect rect) {
        int i2 = 0;
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1084041650);
        super.onFocusChanged(z, i, rect);
        ListAdapter listAdapter = this.f453j;
        int i3 = -1;
        if (!(listAdapter == null || !z || rect == null)) {
            rect.offset(getScrollX(), getScrollY());
            if (listAdapter.getCount() < getChildCount() + this.f416V) {
                this.h = 0;
                mo11d();
            }
            Rect rect2 = this.aH;
            int i4 = Integer.MAX_VALUE;
            int childCount = getChildCount();
            int i5 = this.f416V;
            int i6 = 0;
            while (i6 < childCount) {
                int a2;
                if (listAdapter.isEnabled(i5 + i6)) {
                    View childAt = getChildAt(i6);
                    childAt.getDrawingRect(rect2);
                    offsetDescendantRectToMyCoords(childAt, rect2);
                    a2 = AbsHListView.m412a(rect, rect2, i);
                    if (a2 < i4) {
                        i4 = childAt.getLeft();
                        i2 = i6;
                        i6++;
                        i3 = i2;
                        i2 = i4;
                        i4 = a2;
                    }
                }
                a2 = i4;
                i4 = i2;
                i2 = i3;
                i6++;
                i3 = i2;
                i2 = i4;
                i4 = a2;
            }
        }
        if (i3 >= 0) {
            mo21b(this.f416V + i3, i2);
        } else {
            requestLayout();
        }
        LogUtils.g(1233539892, a);
    }

    protected void onFinishInflate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -2034591544);
        super.onFinishInflate();
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                m499b(getChildAt(i));
            }
            removeAllViews();
        }
        LogUtils.g(-845663811, a);
    }

    @Deprecated
    public long[] getCheckItemIds() {
        if (this.f453j != null && this.f453j.hasStableIds()) {
            return getCheckedItemIds();
        }
        if (this.f445b == 0 || this.f449f == null || this.f453j == null) {
            return new long[0];
        }
        SparseBooleanArray sparseBooleanArray = this.f449f;
        int size = sparseBooleanArray.size();
        Object obj = new long[size];
        ListAdapter listAdapter = this.f453j;
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3;
            if (sparseBooleanArray.valueAt(i)) {
                i3 = i2 + 1;
                obj[i2] = listAdapter.getItemId(sparseBooleanArray.keyAt(i));
            } else {
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        if (i2 == size) {
            return obj;
        }
        long[] jArr = new long[i2];
        System.arraycopy(obj, 0, jArr, 0, i2);
        return jArr;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(HListView.class.getName());
    }

    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(HListView.class.getName());
    }

    public void onGlobalLayout() {
    }
}

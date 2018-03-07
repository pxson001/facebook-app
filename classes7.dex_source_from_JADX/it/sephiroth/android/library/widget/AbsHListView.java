package it.sephiroth.android.library.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.util.LongSparseArray;
import android.support.v4.util.SparseArrayCompat;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewConfiguration;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewParent;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnTouchModeChangeListener;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.Checkable;
import android.widget.ListAdapter;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import it.sephiroth.android.library.R;
import it.sephiroth.android.library.util.ViewHelperFactory.ViewHelper;
import it.sephiroth.android.library.util.ViewHelperFactory.ViewHelperDefault;
import it.sephiroth.android.library.util.v11.MultiChoiceModeListener;
import it.sephiroth.android.library.util.v11.MultiChoiceModeWrapper;
import it.sephiroth.android.library.util.v14.ViewHelper14;
import it.sephiroth.android.library.util.v16.ViewHelper16;
import it.sephiroth.android.library.widget.AdapterView.AdapterContextMenuInfo;
import java.util.ArrayList;

@TargetApi(11)
/* compiled from: viewerId */
public abstract class AbsHListView extends AdapterView<ListAdapter> implements OnGlobalLayoutListener, OnTouchModeChangeListener {
    public static final Interpolator f423T = new LinearInterpolator();
    public static final int[] f424U = new int[]{0};
    protected int f425A;
    int f426B;
    int f427C;
    int f428D;
    int f429E;
    public int f430F;
    int f431G;
    int f432H;
    protected PositionScroller f433I;
    protected int f434J;
    public boolean f435K;
    boolean f436L;
    protected int f437M;
    protected int f438N;
    protected Runnable f439O;
    protected final boolean[] f440P;
    int f441Q;
    int f442R;
    protected boolean f443S;
    public ViewHelper f444a;
    private int aA;
    public CheckForLongPress aB;
    private Runnable aC;
    private CheckForKeyLongPress aD;
    private PerformClick aE;
    private Runnable aF;
    public int aG;
    private int aH;
    private boolean aI;
    private int aJ;
    private int aK;
    private Runnable aL;
    public int aM;
    public int aN;
    private float aO;
    public int aP;
    public EdgeEffect aQ;
    public EdgeEffect aR;
    private int aS;
    private int aT;
    private int aU;
    private boolean aV;
    private int aW;
    private int aX;
    private ListItemAccessibilityDelegate aY;
    private int aZ;
    public VelocityTracker au;
    private FlingRunnable av;
    private OnScrollListener aw;
    public boolean ax;
    private Rect ay;
    private ContextMenuInfo az;
    public int f445b;
    private int ba;
    private int bb;
    private SavedState bc;
    private float bd;
    public Object f446c;
    Object f447d;
    public int f448e;
    public SparseBooleanArray f449f;
    LongSparseArray<Integer> f450g;
    protected int f451h;
    protected AdapterDataSetObserver f452i;
    public ListAdapter f453j;
    boolean f454k;
    boolean f455l;
    Drawable f456m;
    int f457n;
    public Rect f458o;
    protected final RecycleBin f459p;
    public int f460q;
    public int f461r;
    public int f462s;
    public int f463t;
    protected Rect f464u;
    protected int f465v;
    View f466w;
    View f467x;
    protected boolean f468y;
    protected boolean f469z;

    /* compiled from: viewerId */
    class C00492 implements Runnable {
        final /* synthetic */ AbsHListView f374a;

        C00492(AbsHListView absHListView) {
            this.f374a = absHListView;
        }

        public void run() {
            if (this.f374a.f468y) {
                AbsHListView absHListView = this.f374a;
                this.f374a.f469z = false;
                absHListView.f468y = false;
                this.f374a.setChildrenDrawnWithCacheEnabled(false);
                if ((this.f374a.getPersistentDrawingCache() & 2) == 0) {
                    this.f374a.setChildrenDrawingCacheEnabled(false);
                }
                if (!this.f374a.isAlwaysDrawnWithCacheEnabled()) {
                    this.f374a.invalidate();
                }
            }
        }
    }

    /* compiled from: viewerId */
    public class AdapterDataSetObserver extends AdapterDataSetObserver {
        final /* synthetic */ AbsHListView f377a;

        public AdapterDataSetObserver(AbsHListView absHListView) {
            this.f377a = absHListView;
            super(absHListView);
        }
    }

    /* compiled from: viewerId */
    public class WindowRunnnable {
        private int f378a;
        final /* synthetic */ AbsHListView f379c;

        public WindowRunnnable(AbsHListView absHListView) {
            this.f379c = absHListView;
        }

        public final void m366a() {
            this.f378a = this.f379c.getWindowAttachCount();
        }

        public final boolean m367b() {
            return this.f379c.hasWindowFocus() && this.f379c.getWindowAttachCount() == this.f378a;
        }
    }

    /* compiled from: viewerId */
    class CheckForKeyLongPress extends WindowRunnnable implements Runnable {
        final /* synthetic */ AbsHListView f380a;

        public CheckForKeyLongPress(AbsHListView absHListView) {
            this.f380a = absHListView;
            super(absHListView);
        }

        public void run() {
            if (this.f380a.isPressed() && this.f380a.am >= 0) {
                View childAt = this.f380a.getChildAt(this.f380a.am - this.f380a.f416V);
                if (this.f380a.aj) {
                    this.f380a.setPressed(false);
                    if (childAt != null) {
                        childAt.setPressed(false);
                        return;
                    }
                    return;
                }
                boolean b;
                if (m367b()) {
                    b = this.f380a.m456b(childAt, this.f380a.am, this.f380a.an);
                } else {
                    b = false;
                }
                if (b) {
                    this.f380a.setPressed(false);
                    childAt.setPressed(false);
                }
            }
        }
    }

    /* compiled from: viewerId */
    class CheckForLongPress extends WindowRunnnable implements Runnable {
        final /* synthetic */ AbsHListView f381a;

        public CheckForLongPress(AbsHListView absHListView) {
            this.f381a = absHListView;
            super(absHListView);
        }

        public void run() {
            View childAt = this.f381a.getChildAt(this.f381a.f425A - this.f381a.f416V);
            if (childAt != null) {
                boolean z;
                int i = this.f381a.f425A;
                long itemId = this.f381a.f453j.getItemId(this.f381a.f425A);
                if (!m367b() || this.f381a.aj) {
                    z = false;
                } else {
                    z = this.f381a.m456b(childAt, i, itemId);
                }
                if (z) {
                    this.f381a.f430F = -1;
                    this.f381a.setPressed(false);
                    childAt.setPressed(false);
                    return;
                }
                this.f381a.f430F = 2;
            }
        }
    }

    /* compiled from: viewerId */
    final class CheckForTap implements Runnable {
        final /* synthetic */ AbsHListView f382a;

        CheckForTap(AbsHListView absHListView) {
            this.f382a = absHListView;
        }

        public final void run() {
            if (this.f382a.f430F == 0) {
                this.f382a.f430F = 1;
                View childAt = this.f382a.getChildAt(this.f382a.f425A - this.f382a.f416V);
                if (childAt != null && !childAt.hasFocusable()) {
                    this.f382a.f451h = 0;
                    if (this.f382a.aj) {
                        this.f382a.f430F = 2;
                        return;
                    }
                    childAt.setPressed(true);
                    this.f382a.setPressed(true);
                    this.f382a.mo11d();
                    this.f382a.m450a(this.f382a.f425A, childAt);
                    this.f382a.refreshDrawableState();
                    int longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    boolean isLongClickable = this.f382a.isLongClickable();
                    if (this.f382a.f456m != null) {
                        Drawable current = this.f382a.f456m.getCurrent();
                        if (current != null && (current instanceof TransitionDrawable)) {
                            if (isLongClickable) {
                                ((TransitionDrawable) current).startTransition(longPressTimeout);
                            } else {
                                ((TransitionDrawable) current).resetTransition();
                            }
                        }
                    }
                    if (isLongClickable) {
                        if (this.f382a.aB == null) {
                            this.f382a.aB = new CheckForLongPress(this.f382a);
                        }
                        this.f382a.aB.m366a();
                        this.f382a.postDelayed(this.f382a.aB, (long) longPressTimeout);
                        return;
                    }
                    this.f382a.f430F = 2;
                }
            }
        }
    }

    /* compiled from: viewerId */
    public class FlingRunnable implements Runnable {
        public final /* synthetic */ AbsHListView f384a;
        public final OverScroller f385b;
        public int f386c;
        private final Runnable f387d = new C00501(this);

        /* compiled from: viewerId */
        class C00501 implements Runnable {
            final /* synthetic */ FlingRunnable f383a;

            C00501(FlingRunnable flingRunnable) {
                this.f383a = flingRunnable;
            }

            public void run() {
                int i = this.f383a.f384a.aP;
                VelocityTracker velocityTracker = this.f383a.f384a.au;
                OverScroller overScroller = this.f383a.f385b;
                if (velocityTracker != null && i != -1) {
                    velocityTracker.computeCurrentVelocity(1000, (float) this.f383a.f384a.aN);
                    float f = -velocityTracker.getXVelocity(i);
                    if (Math.abs(f) >= ((float) this.f383a.f384a.aM)) {
                        Object obj;
                        int i2 = overScroller.f539b.f523c - overScroller.f539b.f521a;
                        int i3 = overScroller.f540c.f523c - overScroller.f540c.f521a;
                        if (!overScroller.m559a() && Math.signum(f) == Math.signum((float) i2) && Math.signum(0.0f) == Math.signum((float) i3)) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (obj != null) {
                            this.f383a.f384a.postDelayed(this, 40);
                            return;
                        }
                    }
                    this.f383a.m371b();
                    this.f383a.f384a.f430F = 3;
                    this.f383a.f384a.m448a(1);
                }
            }
        }

        FlingRunnable(AbsHListView absHListView) {
            this.f384a = absHListView;
            this.f385b = new OverScroller(absHListView.getContext());
        }

        final void m370a(int i) {
            int i2 = i < 0 ? Integer.MAX_VALUE : 0;
            this.f386c = i2;
            this.f385b.f541d = null;
            this.f385b.m557a(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
            this.f384a.f430F = 4;
            this.f384a.f444a.mo4a((Runnable) this);
        }

        final void m369a() {
            if (this.f385b.m560a(this.f384a.getScrollX(), 0, 0, 0, 0, 0)) {
                this.f384a.f430F = 6;
                this.f384a.invalidate();
                this.f384a.f444a.mo4a((Runnable) this);
                return;
            }
            this.f384a.f430F = -1;
            this.f384a.m448a(0);
        }

        final void m372b(int i) {
            this.f385b.f541d = null;
            this.f385b.m558a(this.f384a.getScrollX(), 0, i, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0, this.f384a.getWidth(), 0);
            this.f384a.f430F = 6;
            this.f384a.invalidate();
            this.f384a.f444a.mo4a((Runnable) this);
        }

        private void m368c(int i) {
            OverScroller overScroller = this.f385b;
            overScroller.f539b.m553c(this.f384a.getScrollX(), 0, this.f384a.f442R);
            int overScrollMode = this.f384a.getOverScrollMode();
            if (overScrollMode == 0 || (overScrollMode == 1 && !this.f384a.m440r())) {
                this.f384a.f430F = 6;
                overScrollMode = (int) this.f385b.m562c();
                if (i > 0) {
                    this.f384a.aQ.m471a(overScrollMode);
                } else {
                    this.f384a.aR.m471a(overScrollMode);
                }
            } else {
                this.f384a.f430F = -1;
                if (this.f384a.f433I != null) {
                    this.f384a.f433I.m376a();
                }
            }
            this.f384a.invalidate();
            this.f384a.f444a.mo4a((Runnable) this);
        }

        final void m371b() {
            this.f384a.f430F = -1;
            this.f384a.removeCallbacks(this);
            this.f384a.removeCallbacks(this.f387d);
            this.f384a.m448a(0);
            AbsHListView.m408B(this.f384a);
            this.f385b.m564e();
            this.f384a.overScrollBy(0, 0, 0, 0, 0, 0, 0, 0, false);
        }

        final void m373c() {
            this.f384a.postDelayed(this.f387d, 40);
        }

        public void run() {
            int scrollX;
            int i;
            int i2 = 1;
            int i3 = 0;
            switch (this.f384a.f430F) {
                case 3:
                    if (this.f385b.m559a()) {
                        return;
                    }
                    break;
                case 4:
                    break;
                case 6:
                    OverScroller overScroller = this.f385b;
                    if (overScroller.m563d()) {
                        scrollX = this.f384a.getScrollX();
                        int b = overScroller.m561b();
                        if (this.f384a.overScrollBy(b - scrollX, 0, scrollX, 0, 0, 0, this.f384a.f442R, 0, false)) {
                            i = (scrollX > 0 || b <= 0) ? 0 : 1;
                            if (scrollX >= 0 && b < 0) {
                                i3 = 1;
                            }
                            if (i == 0 && i3 == 0) {
                                m369a();
                                return;
                            }
                            i = (int) overScroller.m562c();
                            if (i3 != 0) {
                                i = -i;
                            }
                            overScroller.m564e();
                            m370a(i);
                            return;
                        }
                        this.f384a.invalidate();
                        this.f384a.f444a.mo4a((Runnable) this);
                        return;
                    }
                    m371b();
                    return;
                default:
                    m371b();
                    return;
            }
            if (this.f384a.aj) {
                this.f384a.mo11d();
            }
            if (this.f384a.ao == 0 || this.f384a.getChildCount() == 0) {
                m371b();
                return;
            }
            int min;
            OverScroller overScroller2 = this.f385b;
            boolean d = overScroller2.m563d();
            int b2 = overScroller2.m561b();
            i = this.f386c - b2;
            if (i > 0) {
                this.f384a.f425A = this.f384a.f416V;
                this.f384a.f426B = this.f384a.getChildAt(0).getLeft();
                min = Math.min(((this.f384a.getWidth() - this.f384a.getPaddingRight()) - this.f384a.getPaddingLeft()) - 1, i);
            } else {
                scrollX = this.f384a.getChildCount() - 1;
                this.f384a.f425A = this.f384a.f416V + scrollX;
                this.f384a.f426B = this.f384a.getChildAt(scrollX).getLeft();
                min = Math.max(-(((this.f384a.getWidth() - this.f384a.getPaddingRight()) - this.f384a.getPaddingLeft()) - 1), i);
            }
            View childAt = this.f384a.getChildAt(this.f384a.f425A - this.f384a.f416V);
            if (childAt != null) {
                i = childAt.getLeft();
            } else {
                i = 0;
            }
            boolean a = this.f384a.m452a(min, min);
            if (!a || min == 0) {
                i2 = 0;
            }
            if (i2 != 0) {
                if (childAt != null) {
                    this.f384a.overScrollBy(-(min - (childAt.getLeft() - i)), 0, this.f384a.getScrollX(), 0, 0, 0, this.f384a.f442R, 0, false);
                }
                if (d) {
                    m368c(min);
                }
            } else if (d && i2 == 0) {
                if (a) {
                    this.f384a.invalidate();
                }
                this.f386c = b2;
                this.f384a.f444a.mo4a((Runnable) this);
            } else {
                m371b();
            }
        }
    }

    /* compiled from: viewerId */
    public class LayoutParams extends android.view.ViewGroup.LayoutParams {
        public int f388a;
        public boolean f389b;
        public boolean f390c;
        public int f391d;
        public long f392e = -1;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2, int i3) {
            super(i, i2);
            this.f388a = i3;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    @TargetApi(14)
    /* compiled from: viewerId */
    class ListItemAccessibilityDelegate extends AccessibilityDelegateCompat {
        final /* synthetic */ AbsHListView f393b;

        ListItemAccessibilityDelegate(AbsHListView absHListView) {
            this.f393b = absHListView;
        }

        public final void m374a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.a(view, accessibilityNodeInfoCompat);
            int a = this.f393b.m399a(view);
            ListAdapter listAdapter = (ListAdapter) this.f393b.getAdapter();
            if (a != -1 && listAdapter != null && this.f393b.isEnabled() && listAdapter.isEnabled(a)) {
                if (a == this.f393b.ak) {
                    accessibilityNodeInfoCompat.e(true);
                    accessibilityNodeInfoCompat.a(8);
                } else {
                    accessibilityNodeInfoCompat.a(4);
                }
                if (this.f393b.isClickable()) {
                    accessibilityNodeInfoCompat.a(16);
                    accessibilityNodeInfoCompat.f(true);
                }
                if (this.f393b.isLongClickable()) {
                    accessibilityNodeInfoCompat.a(32);
                    accessibilityNodeInfoCompat.g(true);
                }
            }
        }

        public final boolean m375a(View view, int i, Bundle bundle) {
            if (super.a(view, i, bundle)) {
                return true;
            }
            int a = this.f393b.m399a(view);
            ListAdapter listAdapter = (ListAdapter) this.f393b.getAdapter();
            if (a == -1 || listAdapter == null) {
                return false;
            }
            if (!this.f393b.isEnabled() || !listAdapter.isEnabled(a)) {
                return false;
            }
            long d = this.f393b.m401d(a);
            switch (i) {
                case 4:
                    if (this.f393b.ak == a) {
                        return false;
                    }
                    this.f393b.setSelection(a);
                    return true;
                case 8:
                    if (this.f393b.ak != a) {
                        return false;
                    }
                    this.f393b.setSelection(-1);
                    return true;
                case 16:
                    return this.f393b.isClickable() ? this.f393b.mo8a(view, a, d) : false;
                case 32:
                    return this.f393b.isLongClickable() ? this.f393b.m456b(view, a, d) : false;
                default:
                    return false;
            }
        }
    }

    /* compiled from: viewerId */
    public interface OnScrollListener {
    }

    /* compiled from: viewerId */
    class PerformClick extends WindowRunnnable implements Runnable {
        int f394a;
        final /* synthetic */ AbsHListView f395b;

        public PerformClick(AbsHListView absHListView) {
            this.f395b = absHListView;
            super(absHListView);
        }

        public void run() {
            if (!this.f395b.aj) {
                ListAdapter listAdapter = this.f395b.f453j;
                int i = this.f394a;
                if (listAdapter != null && this.f395b.ao > 0 && i != -1 && i < listAdapter.getCount() && m367b()) {
                    View childAt = this.f395b.getChildAt(i - this.f395b.f416V);
                    if (childAt != null) {
                        this.f395b.mo8a(childAt, i, listAdapter.getItemId(i));
                    }
                }
            }
        }
    }

    /* compiled from: viewerId */
    public class PositionScroller implements Runnable {
        final /* synthetic */ AbsHListView f396a;

        public final void m376a() {
            this.f396a.removeCallbacks(this);
        }
    }

    /* compiled from: viewerId */
    public class RecycleBin {
        public final /* synthetic */ AbsHListView f397a;
        public RecyclerListener f398b;
        private int f399c;
        public View[] f400d = new View[0];
        public ArrayList<View>[] f401e;
        public int f402f;
        public ArrayList<View> f403g;
        private ArrayList<View> f404h;
        public SparseArrayCompat<View> f405i;

        public RecycleBin(AbsHListView absHListView) {
            this.f397a = absHListView;
        }

        public final void m380a(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("Can't have a viewTypeCount < 1");
            }
            ArrayList[] arrayListArr = new ArrayList[i];
            for (int i2 = 0; i2 < i; i2++) {
                arrayListArr[i2] = new ArrayList();
            }
            this.f402f = i;
            this.f403g = arrayListArr[0];
            this.f401e = arrayListArr;
        }

        public final void m379a() {
            int i;
            int i2 = 0;
            int size;
            if (this.f402f == 1) {
                ArrayList arrayList = this.f403g;
                size = arrayList.size();
                for (i = 0; i < size; i++) {
                    ((View) arrayList.get(i)).forceLayout();
                }
            } else {
                size = this.f402f;
                for (int i3 = 0; i3 < size; i3++) {
                    ArrayList arrayList2 = this.f401e[i3];
                    int size2 = arrayList2.size();
                    for (i = 0; i < size2; i++) {
                        ((View) arrayList2.get(i)).forceLayout();
                    }
                }
            }
            if (this.f405i != null) {
                i = this.f405i.a();
                while (i2 < i) {
                    ((View) this.f405i.f(i2)).forceLayout();
                    i2++;
                }
            }
        }

        public static boolean m377b(int i) {
            return i >= 0;
        }

        public final void m383b() {
            int size;
            int i;
            if (this.f402f == 1) {
                ArrayList arrayList = this.f403g;
                size = arrayList.size();
                for (i = 0; i < size; i++) {
                    this.f397a.removeDetachedView((View) arrayList.remove((size - 1) - i), false);
                }
            } else {
                size = this.f402f;
                for (int i2 = 0; i2 < size; i2++) {
                    ArrayList arrayList2 = this.f401e[i2];
                    int size2 = arrayList2.size();
                    for (i = 0; i < size2; i++) {
                        this.f397a.removeDetachedView((View) arrayList2.remove((size2 - 1) - i), false);
                    }
                }
            }
            if (this.f405i != null) {
                this.f405i.b();
            }
        }

        public final void m381a(int i, int i2) {
            if (this.f400d.length < i) {
                this.f400d = new View[i];
            }
            this.f399c = i2;
            View[] viewArr = this.f400d;
            for (int i3 = 0; i3 < i; i3++) {
                View childAt = this.f397a.getChildAt(i3);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (!(layoutParams == null || layoutParams.f388a == -2)) {
                    viewArr[i3] = childAt;
                }
            }
        }

        public final View m384c(int i) {
            int i2 = i - this.f399c;
            View[] viewArr = this.f400d;
            if (i2 < 0 || i2 >= viewArr.length) {
                return null;
            }
            View view = viewArr[i2];
            viewArr[i2] = null;
            return view;
        }

        @SuppressLint({"NewApi"})
        public final void m382a(View view, int i) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.f391d = i;
                int i2 = layoutParams.f388a;
                boolean hasTransientState = VERSION.SDK_INT >= 16 ? view.hasTransientState() : false;
                if (!m377b(i2) || hasTransientState) {
                    if (i2 != -2 || hasTransientState) {
                        if (this.f404h == null) {
                            this.f404h = new ArrayList();
                        }
                        this.f404h.add(view);
                    }
                    if (hasTransientState) {
                        if (this.f405i == null) {
                            this.f405i = new SparseArrayCompat();
                        }
                        view.onStartTemporaryDetach();
                        this.f405i.a(i, view);
                        return;
                    }
                    return;
                }
                view.onStartTemporaryDetach();
                if (this.f402f == 1) {
                    this.f403g.add(view);
                } else {
                    this.f401e[i2].add(view);
                }
                if (VERSION.SDK_INT >= 14) {
                    view.setAccessibilityDelegate(null);
                }
            }
        }

        public final void m385d() {
            if (this.f404h != null) {
                int size = this.f404h.size();
                for (int i = 0; i < size; i++) {
                    this.f397a.removeDetachedView((View) this.f404h.get(i), false);
                }
                this.f404h.clear();
            }
        }

        @SuppressLint({"NewApi"})
        public final void m386e() {
            boolean z;
            View[] viewArr = this.f400d;
            if (this.f402f > 1) {
                z = true;
            } else {
                z = false;
            }
            ArrayList arrayList = this.f403g;
            for (int length = viewArr.length - 1; length >= 0; length--) {
                View view = viewArr[length];
                if (view != null) {
                    LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                    int i = layoutParams.f388a;
                    viewArr[length] = null;
                    boolean hasTransientState = VERSION.SDK_INT >= 16 ? view.hasTransientState() : false;
                    if (!m377b(i) || hasTransientState) {
                        if (i != -2 || hasTransientState) {
                            this.f397a.removeDetachedView(view, false);
                        }
                        if (hasTransientState) {
                            if (this.f405i == null) {
                                this.f405i = new SparseArrayCompat();
                            }
                            this.f405i.a(this.f399c + length, view);
                        }
                    } else {
                        ArrayList arrayList2;
                        if (z) {
                            arrayList2 = this.f401e[i];
                        } else {
                            arrayList2 = arrayList;
                        }
                        view.onStartTemporaryDetach();
                        layoutParams.f391d = this.f399c + length;
                        arrayList2.add(view);
                        if (VERSION.SDK_INT >= 14) {
                            view.setAccessibilityDelegate(null);
                        }
                        arrayList = arrayList2;
                    }
                }
            }
            m378f();
        }

        @SuppressLint({"NewApi"})
        private void m378f() {
            int i = 0;
            int length = this.f400d.length;
            int i2 = this.f402f;
            ArrayList[] arrayListArr = this.f401e;
            for (int i3 = 0; i3 < i2; i3++) {
                ArrayList arrayList = arrayListArr[i3];
                int size = arrayList.size();
                int i4 = size - length;
                size--;
                int i5 = 0;
                while (i5 < i4) {
                    int i6 = size - 1;
                    this.f397a.removeDetachedView((View) arrayList.remove(size), false);
                    i5++;
                    size = i6;
                }
            }
            if (this.f405i != null) {
                while (i < this.f405i.a()) {
                    if (!((View) this.f405i.f(i)).hasTransientState()) {
                        this.f405i.d(i);
                        i--;
                    }
                    i++;
                }
            }
        }
    }

    /* compiled from: viewerId */
    public interface RecyclerListener {
    }

    /* compiled from: viewerId */
    public class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C00511();
        long f406a;
        long f407b;
        int f408c;
        int f409d;
        int f410e;
        String f411f;
        boolean f412g;
        int f413h;
        SparseBooleanArray f414i;
        LongSparseArray<Integer> f415j;

        /* compiled from: viewerId */
        final class C00511 implements Creator<SavedState> {
            C00511() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final Object[] newArray(int i) {
                return new SavedState[i];
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel) {
            SparseBooleanArray sparseBooleanArray;
            LongSparseArray longSparseArray;
            super(parcel);
            this.f406a = parcel.readLong();
            this.f407b = parcel.readLong();
            this.f408c = parcel.readInt();
            this.f409d = parcel.readInt();
            this.f410e = parcel.readInt();
            this.f411f = parcel.readString();
            this.f412g = parcel.readByte() != (byte) 0;
            this.f413h = parcel.readInt();
            int readInt = parcel.readInt();
            if (readInt < 0) {
                sparseBooleanArray = null;
            } else {
                sparseBooleanArray = new SparseBooleanArray(readInt);
                m388a(sparseBooleanArray, parcel, readInt);
            }
            this.f414i = sparseBooleanArray;
            readInt = parcel.readInt();
            if (readInt <= 0) {
                longSparseArray = null;
            } else {
                longSparseArray = new LongSparseArray(readInt);
                m387a(longSparseArray, parcel, readInt);
            }
            this.f415j = longSparseArray;
        }

        public static void m387a(LongSparseArray<Integer> longSparseArray, Parcel parcel, int i) {
            while (i > 0) {
                longSparseArray.b(parcel.readLong(), Integer.valueOf(parcel.readInt()));
                i--;
            }
        }

        public static void m388a(SparseBooleanArray sparseBooleanArray, Parcel parcel, int i) {
            while (i > 0) {
                sparseBooleanArray.append(parcel.readInt(), parcel.readByte() == (byte) 1);
                i--;
            }
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2;
            int a;
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.f406a);
            parcel.writeLong(this.f407b);
            parcel.writeInt(this.f408c);
            parcel.writeInt(this.f409d);
            parcel.writeInt(this.f410e);
            parcel.writeString(this.f411f);
            parcel.writeByte((byte) (this.f412g ? 1 : 0));
            parcel.writeInt(this.f413h);
            SparseBooleanArray sparseBooleanArray = this.f414i;
            if (sparseBooleanArray == null) {
                parcel.writeInt(-1);
            } else {
                int size = sparseBooleanArray.size();
                parcel.writeInt(size);
                for (i2 = 0; i2 < size; i2++) {
                    int i3;
                    parcel.writeInt(sparseBooleanArray.keyAt(i2));
                    if (sparseBooleanArray.valueAt(i2)) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    parcel.writeByte((byte) i3);
                }
            }
            LongSparseArray longSparseArray = this.f415j;
            i2 = 0;
            if (longSparseArray != null) {
                a = longSparseArray.a();
            } else {
                a = 0;
            }
            parcel.writeInt(a);
            while (i2 < a) {
                parcel.writeLong(longSparseArray.b(i2));
                parcel.writeInt(((Integer) longSparseArray.c(i2)).intValue());
                i2++;
            }
        }

        public String toString() {
            return "AbsListView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.f406a + " firstId=" + this.f407b + " viewLeft=" + this.f408c + " position=" + this.f409d + " width=" + this.f410e + " filter=" + this.f411f + " checkState=" + this.f414i + "}";
        }
    }

    protected abstract void mo7a(boolean z);

    protected abstract int mo22c(int i);

    public abstract void setSelectionInt(int i);

    public AbsHListView(Context context) {
        super(context);
        this.f445b = 0;
        this.f451h = 0;
        this.f455l = false;
        this.f457n = -1;
        this.f458o = new Rect();
        this.f459p = new RecycleBin(this);
        this.f460q = 0;
        this.f461r = 0;
        this.f462s = 0;
        this.f463t = 0;
        this.f464u = new Rect();
        this.f465v = 0;
        this.f430F = -1;
        this.f434J = 0;
        this.ax = true;
        this.f437M = -1;
        this.az = null;
        this.aA = -1;
        this.aJ = 0;
        this.aO = 1.0f;
        this.f440P = new boolean[1];
        this.aP = -1;
        this.aU = 0;
        m438p();
    }

    public AbsHListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 2130773465);
    }

    public AbsHListView(Context context, AttributeSet attributeSet, int i) {
        Drawable drawable;
        boolean z;
        boolean z2;
        boolean z3;
        int i2;
        int color;
        boolean z4 = true;
        int i3 = 0;
        super(context, attributeSet, i);
        this.f445b = 0;
        this.f451h = 0;
        this.f455l = false;
        this.f457n = -1;
        this.f458o = new Rect();
        this.f459p = new RecycleBin(this);
        this.f460q = 0;
        this.f461r = 0;
        this.f462s = 0;
        this.f463t = 0;
        this.f464u = new Rect();
        this.f465v = 0;
        this.f430F = -1;
        this.f434J = 0;
        this.ax = true;
        this.f437M = -1;
        this.az = null;
        this.aA = -1;
        this.aJ = 0;
        this.aO = 1.0f;
        this.f440P = new boolean[1];
        this.aP = -1;
        this.aU = 0;
        m438p();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.AbsHListView, i, 0);
        if (obtainStyledAttributes != null) {
            drawable = obtainStyledAttributes.getDrawable(0);
            z = obtainStyledAttributes.getBoolean(1, false);
            z2 = obtainStyledAttributes.getBoolean(6, false);
            z3 = obtainStyledAttributes.getBoolean(2, true);
            i2 = obtainStyledAttributes.getInt(7, 0);
            color = obtainStyledAttributes.getColor(3, 0);
            z4 = obtainStyledAttributes.getBoolean(5, true);
            i3 = obtainStyledAttributes.getInt(4, 0);
            obtainStyledAttributes.recycle();
        } else {
            i2 = 0;
            z3 = true;
            z2 = false;
            z = false;
            drawable = null;
            color = 0;
        }
        if (drawable != null) {
            setSelector(drawable);
        }
        this.f455l = z;
        if (this.f435K != z2) {
            this.f435K = z2;
            if (getChildCount() > 0) {
                mo10c();
                requestLayout();
                invalidate();
            }
        }
        setScrollingCacheEnabled(z3);
        this.aG = i2;
        setCacheColorHint(color);
        this.ax = z4;
        setChoiceMode(i3);
    }

    private void m438p() {
        ViewHelper viewHelper16;
        setClickable(true);
        setFocusableInTouchMode(true);
        setWillNotDraw(false);
        setAlwaysDrawnWithCacheEnabled(false);
        setScrollingCacheEnabled(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.aK = viewConfiguration.getScaledTouchSlop();
        this.aM = viewConfiguration.getScaledMinimumFlingVelocity();
        this.aN = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f441Q = viewConfiguration.getScaledOverscrollDistance();
        this.f442R = viewConfiguration.getScaledOverflingDistance();
        int i = VERSION.SDK_INT;
        if (i >= 16) {
            viewHelper16 = new ViewHelper16(this);
        } else if (i >= 14) {
            viewHelper16 = new ViewHelper14(this);
        } else {
            viewHelper16 = new ViewHelperDefault(this);
        }
        this.f444a = viewHelper16;
    }

    public void setOverScrollMode(int i) {
        if (i == 2) {
            this.aQ = null;
            this.aR = null;
        } else if (this.aQ == null) {
            Context context = getContext();
            this.aQ = new EdgeEffect(context, 1);
            this.aR = new EdgeEffect(context, 1);
        }
        super.setOverScrollMode(i);
    }

    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.f454k = this.f453j.hasStableIds();
            if (this.f445b != 0 && this.f454k && this.f450g == null) {
                this.f450g = new LongSparseArray();
            }
        }
        if (this.f449f != null) {
            this.f449f.clear();
        }
        if (this.f450g != null) {
            this.f450g.b();
        }
    }

    public int getCheckedItemPosition() {
        if (this.f445b == 1 && this.f449f != null && this.f449f.size() == 1) {
            return this.f449f.keyAt(0);
        }
        return -1;
    }

    public SparseBooleanArray getCheckedItemPositions() {
        if (this.f445b != 0) {
            return this.f449f;
        }
        return null;
    }

    public long[] getCheckedItemIds() {
        int i = 0;
        if (this.f445b == 0 || this.f450g == null || this.f453j == null) {
            return new long[0];
        }
        LongSparseArray longSparseArray = this.f450g;
        int a = longSparseArray.a();
        long[] jArr = new long[a];
        while (i < a) {
            jArr[i] = longSparseArray.b(i);
            i++;
        }
        return jArr;
    }

    public final void m447a() {
        if (this.f449f != null) {
            this.f449f.clear();
        }
        if (this.f450g != null) {
            this.f450g.b();
        }
        this.f448e = 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m423b(int r11, boolean r12) {
        /*
        r10 = this;
        r4 = 11;
        r3 = 3;
        r7 = 1;
        r1 = 0;
        r0 = r10.f445b;
        if (r0 != 0) goto L_0x000a;
    L_0x0009:
        return;
    L_0x000a:
        r0 = android.os.Build.VERSION.SDK_INT;
        if (r0 < r4) goto L_0x003a;
    L_0x000e:
        if (r12 == 0) goto L_0x003a;
    L_0x0010:
        r0 = r10.f445b;
        if (r0 != r3) goto L_0x003a;
    L_0x0014:
        r0 = r10.f446c;
        if (r0 != 0) goto L_0x003a;
    L_0x0018:
        r0 = r10.f447d;
        if (r0 == 0) goto L_0x0028;
    L_0x001c:
        r0 = r10.f447d;
        r0 = (it.sephiroth.android.library.util.v11.MultiChoiceModeWrapper) r0;
        r8 = r0.f369a;
        if (r8 == 0) goto L_0x0113;
    L_0x0024:
        r8 = 1;
    L_0x0025:
        r0 = r8;
        if (r0 != 0) goto L_0x0030;
    L_0x0028:
        r0 = new java.lang.IllegalStateException;
        r1 = "AbsListView: attempted to start selection mode for CHOICE_MODE_MULTIPLE_MODAL but no choice mode callback was supplied. Call setMultiChoiceModeListener to set a callback.";
        r0.<init>(r1);
        throw r0;
    L_0x0030:
        r0 = r10.f447d;
        r0 = (it.sephiroth.android.library.util.v11.MultiChoiceModeWrapper) r0;
        r0 = r10.startActionMode(r0);
        r10.f446c = r0;
    L_0x003a:
        r0 = r10.f445b;
        r2 = 2;
        if (r0 == r2) goto L_0x0047;
    L_0x003f:
        r0 = android.os.Build.VERSION.SDK_INT;
        if (r0 < r4) goto L_0x00b5;
    L_0x0043:
        r0 = r10.f445b;
        if (r0 != r3) goto L_0x00b5;
    L_0x0047:
        r0 = r10.f449f;
        r0 = r0.get(r11, r1);
        r1 = r10.f449f;
        r1.put(r11, r12);
        r1 = r10.f450g;
        if (r1 == 0) goto L_0x006f;
    L_0x0056:
        r1 = r10.f453j;
        r1 = r1.hasStableIds();
        if (r1 == 0) goto L_0x006f;
    L_0x005e:
        if (r12 == 0) goto L_0x00a2;
    L_0x0060:
        r1 = r10.f450g;
        r2 = r10.f453j;
        r2 = r2.getItemId(r11);
        r4 = java.lang.Integer.valueOf(r11);
        r1.b(r2, r4);
    L_0x006f:
        if (r0 == r12) goto L_0x0079;
    L_0x0071:
        if (r12 == 0) goto L_0x00ae;
    L_0x0073:
        r0 = r10.f448e;
        r0 = r0 + 1;
        r10.f448e = r0;
    L_0x0079:
        r0 = r10.f446c;
        if (r0 == 0) goto L_0x0090;
    L_0x007d:
        r0 = r10.f453j;
        r4 = r0.getItemId(r11);
        r1 = r10.f447d;
        r1 = (it.sephiroth.android.library.util.v11.MultiChoiceModeWrapper) r1;
        r2 = r10.f446c;
        r2 = (android.view.ActionMode) r2;
        r3 = r11;
        r6 = r12;
        r1.mo6a(r2, r3, r4, r6);
    L_0x0090:
        r0 = r10.af;
        if (r0 != 0) goto L_0x0009;
    L_0x0094:
        r0 = r10.at;
        if (r0 != 0) goto L_0x0009;
    L_0x0098:
        r10.aj = r7;
        r10.m406o();
        r10.requestLayout();
        goto L_0x0009;
    L_0x00a2:
        r1 = r10.f450g;
        r2 = r10.f453j;
        r2 = r2.getItemId(r11);
        r1.b(r2);
        goto L_0x006f;
    L_0x00ae:
        r0 = r10.f448e;
        r0 = r0 + -1;
        r10.f448e = r0;
        goto L_0x0079;
    L_0x00b5:
        r0 = r10.f450g;
        if (r0 == 0) goto L_0x00fd;
    L_0x00b9:
        r0 = r10.f453j;
        r0 = r0.hasStableIds();
        if (r0 == 0) goto L_0x00fd;
    L_0x00c1:
        r0 = r7;
    L_0x00c2:
        if (r12 != 0) goto L_0x00d6;
    L_0x00c4:
        r8 = 0;
        r9 = r10.f445b;
        if (r9 == 0) goto L_0x00d3;
    L_0x00c9:
        r9 = r10.f449f;
        if (r9 == 0) goto L_0x00d3;
    L_0x00cd:
        r9 = r10.f449f;
        r8 = r9.get(r11, r8);
    L_0x00d3:
        r2 = r8;
        if (r2 == 0) goto L_0x00e2;
    L_0x00d6:
        r2 = r10.f449f;
        r2.clear();
        if (r0 == 0) goto L_0x00e2;
    L_0x00dd:
        r2 = r10.f450g;
        r2.b();
    L_0x00e2:
        if (r12 == 0) goto L_0x00ff;
    L_0x00e4:
        r1 = r10.f449f;
        r1.put(r11, r7);
        if (r0 == 0) goto L_0x00fa;
    L_0x00eb:
        r0 = r10.f450g;
        r1 = r10.f453j;
        r2 = r1.getItemId(r11);
        r1 = java.lang.Integer.valueOf(r11);
        r0.b(r2, r1);
    L_0x00fa:
        r10.f448e = r7;
        goto L_0x0090;
    L_0x00fd:
        r0 = r1;
        goto L_0x00c2;
    L_0x00ff:
        r0 = r10.f449f;
        r0 = r0.size();
        if (r0 == 0) goto L_0x010f;
    L_0x0107:
        r0 = r10.f449f;
        r0 = r0.valueAt(r1);
        if (r0 != 0) goto L_0x0090;
    L_0x010f:
        r10.f448e = r1;
        goto L_0x0090;
    L_0x0113:
        r8 = 0;
        goto L_0x0025;
        */
        throw new UnsupportedOperationException("Method not decompiled: it.sephiroth.android.library.widget.AbsHListView.b(int, boolean):void");
    }

    public final boolean mo8a(View view, int i, long j) {
        boolean z;
        boolean z2 = true;
        boolean z3 = false;
        if (this.f445b != 0) {
            if (this.f445b == 2 || (VERSION.SDK_INT >= 11 && this.f445b == 3 && this.f446c != null)) {
                boolean z4 = !this.f449f.get(i, false);
                this.f449f.put(i, z4);
                if (this.f450g != null && this.f453j.hasStableIds()) {
                    if (z4) {
                        this.f450g.b(this.f453j.getItemId(i), Integer.valueOf(i));
                    } else {
                        this.f450g.b(this.f453j.getItemId(i));
                    }
                }
                if (z4) {
                    this.f448e++;
                } else {
                    this.f448e--;
                }
                if (this.f446c != null) {
                    ((MultiChoiceModeWrapper) this.f447d).mo6a((ActionMode) this.f446c, i, j, z4);
                } else {
                    z3 = true;
                }
                z = z3;
                z3 = true;
            } else if (this.f445b == 1) {
                if (!this.f449f.get(i, false)) {
                    this.f449f.clear();
                    this.f449f.put(i, true);
                    if (this.f450g != null && this.f453j.hasStableIds()) {
                        this.f450g.b();
                        this.f450g.b(this.f453j.getItemId(i), Integer.valueOf(i));
                    }
                    this.f448e = 1;
                } else if (this.f449f.size() == 0 || !this.f449f.valueAt(0)) {
                    this.f448e = 0;
                }
                z3 = true;
                z = true;
            } else {
                z = true;
            }
            if (z3) {
                m439q();
            }
        } else {
            z = true;
            z2 = false;
        }
        if (z) {
            return z2 | super.mo8a(view, i, j);
        }
        return z2;
    }

    private void m439q() {
        boolean z;
        int i = this.f416V;
        int childCount = getChildCount();
        if (VERSION.SDK_INT >= 11) {
            z = true;
        } else {
            z = false;
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            int i3 = i + i2;
            if (childAt instanceof Checkable) {
                ((Checkable) childAt).setChecked(this.f449f.get(i3, false));
            } else if (z) {
                childAt.setActivated(this.f449f.get(i3, false));
            }
        }
    }

    public int getChoiceMode() {
        return this.f445b;
    }

    @TargetApi(11)
    public void setChoiceMode(int i) {
        this.f445b = i;
        if (VERSION.SDK_INT >= 11 && this.f446c != null) {
            if (VERSION.SDK_INT >= 11) {
                ((ActionMode) this.f446c).finish();
            }
            this.f446c = null;
        }
        if (this.f445b != 0) {
            if (this.f449f == null) {
                this.f449f = new SparseBooleanArray();
            }
            if (this.f450g == null && this.f453j != null && this.f453j.hasStableIds()) {
                this.f450g = new LongSparseArray();
            }
            if (VERSION.SDK_INT >= 11 && this.f445b == 3) {
                m447a();
                setLongClickable(true);
            }
        }
    }

    @TargetApi(11)
    public void setMultiChoiceModeListener(MultiChoiceModeListener multiChoiceModeListener) {
        if (VERSION.SDK_INT >= 11) {
            if (this.f447d == null) {
                this.f447d = new MultiChoiceModeWrapper(this);
            }
            ((MultiChoiceModeWrapper) this.f447d).f369a = multiChoiceModeListener;
            return;
        }
        Log.e("AbsListView", "setMultiChoiceModeListener not supported for this version of Android");
    }

    private boolean m440r() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return true;
        }
        if (childCount != this.ao) {
            return false;
        }
        if (getChildAt(0).getLeft() < this.f464u.left || getChildAt(childCount - 1).getRight() > getWidth() - this.f464u.right) {
            return false;
        }
        return true;
    }

    protected int getHorizontalScrollbarHeight() {
        return super.getHorizontalScrollbarHeight();
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.aw = onScrollListener;
        mo9b();
    }

    protected final void mo9b() {
        if (this.aw != null) {
            getChildCount();
        }
        onScrollChanged(0, 0, 0, 0);
    }

    public void sendAccessibilityEvent(int i) {
        if (i == 4096) {
            int i2 = this.f416V;
            int lastVisiblePosition = getLastVisiblePosition();
            if (this.aZ != i2 || this.ba != lastVisiblePosition) {
                this.aZ = i2;
                this.ba = lastVisiblePosition;
            } else {
                return;
            }
        }
        super.sendAccessibilityEvent(i);
    }

    @TargetApi(14)
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(AbsHListView.class.getName());
    }

    @SuppressLint({"Override"})
    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(AbsHListView.class.getName());
        if (isEnabled()) {
            if (this.f416V > 0) {
                accessibilityNodeInfo.addAction(8192);
            }
            if (getLastVisiblePosition() < this.ao - 1) {
                accessibilityNodeInfo.addAction(4096);
            }
        }
    }

    @TargetApi(16)
    public boolean performAccessibilityAction(int i, Bundle bundle) {
        if (super.performAccessibilityAction(i, bundle)) {
            return true;
        }
        switch (i) {
            case 4096:
                if (!isEnabled() || getLastVisiblePosition() >= this.ao - 1) {
                    return false;
                }
                m429c((getWidth() - this.f464u.left) - this.f464u.right, 200);
                return true;
            case 8192:
                if (!isEnabled() || this.f416V <= 0) {
                    return false;
                }
                m429c(-((getWidth() - this.f464u.left) - this.f464u.right), 200);
                return true;
            default:
                return false;
        }
    }

    public void setScrollingCacheEnabled(boolean z) {
        if (this.f436L && !z) {
            m408B(this);
        }
        this.f436L = z;
    }

    public void getFocusedRect(Rect rect) {
        View selectedView = getSelectedView();
        if (selectedView == null || selectedView.getParent() != this) {
            super.getFocusedRect(rect);
            return;
        }
        selectedView.getFocusedRect(rect);
        offsetDescendantRectToMyCoords(selectedView, rect);
    }

    public Parcelable onSaveInstanceState() {
        boolean z = true;
        int i = 0;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.bc != null) {
            savedState.f406a = this.bc.f406a;
            savedState.f407b = this.bc.f407b;
            savedState.f408c = this.bc.f408c;
            savedState.f409d = this.bc.f409d;
            savedState.f410e = this.bc.f410e;
            savedState.f411f = this.bc.f411f;
            savedState.f412g = this.bc.f412g;
            savedState.f413h = this.bc.f413h;
            savedState.f414i = this.bc.f414i;
            savedState.f415j = this.bc.f415j;
            return savedState;
        }
        boolean z2 = getChildCount() > 0 && this.ao > 0;
        long selectedItemId = getSelectedItemId();
        savedState.f406a = selectedItemId;
        savedState.f410e = getWidth();
        if (selectedItemId >= 0) {
            savedState.f408c = this.f434J;
            savedState.f409d = getSelectedItemPosition();
            savedState.f407b = -1;
        } else if (!z2 || this.f416V <= 0) {
            savedState.f408c = 0;
            savedState.f407b = -1;
            savedState.f409d = 0;
        } else {
            savedState.f408c = getChildAt(0).getLeft();
            int i2 = this.f416V;
            if (i2 >= this.ao) {
                i2 = this.ao - 1;
            }
            savedState.f409d = i2;
            savedState.f407b = this.f453j.getItemId(i2);
        }
        savedState.f411f = null;
        if (VERSION.SDK_INT < 11 || this.f445b != 3 || this.f446c == null) {
            z = false;
        }
        savedState.f412g = z;
        if (this.f449f != null) {
            try {
                savedState.f414i = this.f449f.clone();
            } catch (NoSuchMethodError e) {
                e.printStackTrace();
                savedState.f414i = new SparseBooleanArray();
            }
        }
        if (this.f450g != null) {
            LongSparseArray longSparseArray = new LongSparseArray();
            int a = this.f450g.a();
            while (i < a) {
                longSparseArray.b(this.f450g.b(i), this.f450g.c(i));
                i++;
            }
            savedState.f415j = longSparseArray;
        }
        savedState.f413h = this.f448e;
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.aj = true;
        this.ac = (long) savedState.f410e;
        if (savedState.f406a >= 0) {
            this.ad = true;
            this.bc = savedState;
            this.ab = savedState.f406a;
            this.aa = savedState.f409d;
            this.W = savedState.f408c;
            this.ae = 0;
        } else if (savedState.f407b >= 0) {
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            this.f457n = -1;
            this.ad = true;
            this.bc = savedState;
            this.ab = savedState.f407b;
            this.aa = savedState.f409d;
            this.W = savedState.f408c;
            this.ae = 1;
        }
        if (savedState.f414i != null) {
            this.f449f = savedState.f414i;
        }
        if (savedState.f415j != null) {
            this.f450g = savedState.f415j;
        }
        this.f448e = savedState.f413h;
        if (VERSION.SDK_INT >= 11 && savedState.f412g && this.f445b == 3 && this.f447d != null) {
            this.f446c = startActionMode((MultiChoiceModeWrapper) this.f447d);
        }
        requestLayout();
    }

    protected void onFocusChanged(boolean z, int i, Rect rect) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -2088069113);
        super.onFocusChanged(z, i, rect);
        if (z && this.am < 0 && !isInTouchMode()) {
            if (!(this.f443S || this.f453j == null)) {
                this.aj = true;
                this.ap = this.ao;
                this.ao = this.f453j.getCount();
            }
            m409C();
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 214755458, a);
    }

    public void requestLayout() {
        if (!this.at && !this.af) {
            super.requestLayout();
        }
    }

    public void mo10c() {
        removeAllViewsInLayout();
        this.V = 0;
        this.aj = false;
        this.f439O = null;
        this.ad = false;
        this.bc = null;
        this.ar = -1;
        this.as = Long.MIN_VALUE;
        setSelectedPositionInt(-1);
        setNextSelectedPositionInt(-1);
        this.f434J = 0;
        this.f457n = -1;
        this.f458o.setEmpty();
        invalidate();
    }

    protected int computeHorizontalScrollExtent() {
        int childCount = getChildCount();
        if (childCount <= 0) {
            return 0;
        }
        if (!this.ax) {
            return 1;
        }
        int i = childCount * 100;
        View childAt = getChildAt(0);
        int left = childAt.getLeft();
        int width = childAt.getWidth();
        if (width > 0) {
            i += (left * 100) / width;
        }
        childAt = getChildAt(childCount - 1);
        childCount = childAt.getRight();
        width = childAt.getWidth();
        if (width > 0) {
            return i - (((childCount - getWidth()) * 100) / width);
        }
        return i;
    }

    protected int computeHorizontalScrollOffset() {
        int i = 0;
        int i2 = this.f416V;
        int childCount = getChildCount();
        if (i2 < 0 || childCount <= 0) {
            return 0;
        }
        int width;
        if (this.ax) {
            View childAt = getChildAt(0);
            childCount = childAt.getLeft();
            width = childAt.getWidth();
            if (width > 0) {
                return Math.max(((i2 * 100) - ((childCount * 100) / width)) + ((int) (((((float) getScrollX()) / ((float) getWidth())) * ((float) this.ao)) * 100.0f)), 0);
            }
            return 0;
        }
        width = this.ao;
        if (i2 != 0) {
            if (i2 + childCount == width) {
                i = width;
            } else {
                i = (childCount / 2) + i2;
            }
        }
        return (int) (((((float) i) / ((float) width)) * ((float) childCount)) + ((float) i2));
    }

    protected int computeHorizontalScrollRange() {
        if (!this.ax) {
            return this.ao;
        }
        int max = Math.max(this.ao * 100, 0);
        if (getScrollX() != 0) {
            return max + Math.abs((int) (((((float) getScrollX()) / ((float) getWidth())) * ((float) this.ao)) * 100.0f));
        }
        return max;
    }

    protected float getLeftFadingEdgeStrength() {
        int childCount = getChildCount();
        float leftFadingEdgeStrength = super.getLeftFadingEdgeStrength();
        if (childCount == 0) {
            return leftFadingEdgeStrength;
        }
        if (this.f416V > 0) {
            return 1.0f;
        }
        childCount = getChildAt(0).getLeft();
        return childCount < getPaddingLeft() ? ((float) (-(childCount - getPaddingLeft()))) / ((float) getHorizontalFadingEdgeLength()) : leftFadingEdgeStrength;
    }

    protected float getRightFadingEdgeStrength() {
        int childCount = getChildCount();
        float rightFadingEdgeStrength = super.getRightFadingEdgeStrength();
        if (childCount == 0) {
            return rightFadingEdgeStrength;
        }
        if ((this.f416V + childCount) - 1 < this.ao - 1) {
            return 1.0f;
        }
        childCount = getChildAt(childCount - 1).getRight();
        int width = getWidth();
        return childCount > width - getPaddingRight() ? ((float) ((childCount - width) + getPaddingRight())) / ((float) getHorizontalFadingEdgeLength()) : rightFadingEdgeStrength;
    }

    protected void onMeasure(int i, int i2) {
        if (this.f456m == null) {
            setSelector(getResources().getDrawable(17301602));
        }
        Rect rect = this.f464u;
        rect.left = this.f460q + getPaddingLeft();
        rect.top = this.f461r + getPaddingTop();
        rect.right = this.f462s + getPaddingRight();
        rect.bottom = this.f463t + getPaddingBottom();
        if (this.aG == 1) {
            int right;
            int childCount = getChildCount();
            int width = getWidth() - getPaddingRight();
            View childAt = getChildAt(childCount - 1);
            if (childAt != null) {
                right = childAt.getRight();
            } else {
                right = width;
            }
            boolean z = childCount + this.f416V >= this.bb && right <= width;
            this.aV = z;
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.af = true;
        if (z) {
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                getChildAt(i5).forceLayout();
            }
            this.f459p.m379a();
        }
        mo11d();
        this.af = false;
        this.f438N = (i3 - i) / 3;
    }

    protected void mo11d() {
    }

    protected final void mo12e() {
        int i;
        int i2 = 1;
        int i3 = 0;
        if (this.f466w != null) {
            i = this.f416V > 0 ? 1 : 0;
            if (i == 0 && getChildCount() > 0) {
                i = getChildAt(0).getLeft() < this.f464u.left ? 1 : 0;
            }
            View view = this.f466w;
            if (i != 0) {
                i = 0;
            } else {
                i = 4;
            }
            view.setVisibility(i);
        }
        if (this.f467x != null) {
            int childCount = getChildCount();
            if (this.f416V + childCount < this.ao) {
                i = 1;
            } else {
                i = 0;
            }
            if (i != 0 || childCount <= 0) {
                i2 = i;
            } else if (getChildAt(childCount - 1).getRight() <= getRight() - this.f464u.right) {
                i2 = 0;
            }
            View view2 = this.f467x;
            if (i2 == 0) {
                i3 = 4;
            }
            view2.setVisibility(i3);
        }
    }

    @ExportedProperty
    public View getSelectedView() {
        if (this.ao <= 0 || this.am < 0) {
            return null;
        }
        return getChildAt(this.am - this.f416V);
    }

    public int getListPaddingTop() {
        return this.f464u.top;
    }

    public int getListPaddingBottom() {
        return this.f464u.bottom;
    }

    public int getListPaddingLeft() {
        return this.f464u.left;
    }

    public int getListPaddingRight() {
        return this.f464u.right;
    }

    @SuppressLint({"NewApi"})
    protected final View m446a(int i, boolean[] zArr) {
        zArr[0] = false;
        RecycleBin recycleBin = this.f459p;
        View view = null;
        if (recycleBin.f405i != null) {
            int g = recycleBin.f405i.g(i);
            if (g >= 0) {
                view = (View) recycleBin.f405i.f(g);
                recycleBin.f405i.d(g);
            }
        }
        View view2 = view;
        if (view2 == null) {
            recycleBin = this.f459p;
            if (recycleBin.f402f == 1) {
                view = m414a(recycleBin.f403g, i);
            } else {
                int itemViewType = recycleBin.f397a.f453j.getItemViewType(i);
                if (itemViewType < 0 || itemViewType >= recycleBin.f401e.length) {
                    view = null;
                } else {
                    view = m414a(recycleBin.f401e[itemViewType], i);
                }
            }
            view2 = view;
            View view3;
            if (view2 != null) {
                view3 = this.f453j.getView(i, view2, this);
                if (VERSION.SDK_INT >= 16 && view3.getImportantForAccessibility() == 0) {
                    view3.setImportantForAccessibility(1);
                }
                if (view3 != view2) {
                    this.f459p.m382a(view2, i);
                    if (this.aH != 0) {
                        view3.setDrawingCacheBackgroundColor(this.aH);
                        view2 = view3;
                    }
                    view2 = view3;
                } else {
                    zArr[0] = true;
                    view3.onFinishTemporaryDetach();
                    view2 = view3;
                }
            } else {
                view3 = this.f453j.getView(i, null, this);
                if (VERSION.SDK_INT >= 16 && view3.getImportantForAccessibility() == 0) {
                    view3.setImportantForAccessibility(1);
                }
                if (this.aH != 0) {
                    view3.setDrawingCacheBackgroundColor(this.aH);
                }
                view2 = view3;
            }
            if (this.f454k) {
                android.view.ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = (LayoutParams) generateDefaultLayoutParams();
                } else if (checkLayoutParams(layoutParams)) {
                    r0 = (LayoutParams) layoutParams;
                } else {
                    r0 = (LayoutParams) generateLayoutParams(layoutParams);
                }
                layoutParams.f392e = this.f453j.getItemId(i);
                view2.setLayoutParams(layoutParams);
            }
            if (this.aq.isEnabled() && this.aY == null) {
                this.aY = new ListItemAccessibilityDelegate(this);
            }
        }
        return view2;
    }

    protected final void m450a(int i, View view) {
        if (i != -1) {
            this.f457n = i;
        }
        Rect rect = this.f458o;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        this.f458o.set(rect.left - this.f460q, rect.top - this.f461r, this.f462s + rect.right, this.f463t + rect.bottom);
        boolean z = this.aI;
        if (view.isEnabled() != z) {
            this.aI = !z;
            if (this.ak != -1) {
                refreshDrawableState();
            }
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        boolean z = this.f455l;
        if (!z) {
            m415a(canvas);
        }
        super.dispatchDraw(canvas);
        if (z) {
            m415a(canvas);
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1363832812);
        if (getChildCount() > 0) {
            this.aj = true;
            m406o();
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 100095147, a);
    }

    private boolean m441u() {
        switch (this.f430F) {
            case 1:
            case 2:
                return true;
            default:
                return false;
        }
    }

    protected final boolean m461f() {
        return (hasFocus() && !isInTouchMode()) || m441u();
    }

    private void m415a(Canvas canvas) {
        if (!this.f458o.isEmpty()) {
            Drawable drawable = this.f456m;
            drawable.setBounds(this.f458o);
            drawable.draw(canvas);
        }
    }

    public void setDrawSelectorOnTop(boolean z) {
        this.f455l = z;
    }

    public void setSelector(int i) {
        setSelector(getResources().getDrawable(i));
    }

    public void setSelector(Drawable drawable) {
        if (this.f456m != null) {
            this.f456m.setCallback(null);
            unscheduleDrawable(this.f456m);
        }
        this.f456m = drawable;
        Rect rect = new Rect();
        drawable.getPadding(rect);
        this.f460q = rect.left;
        this.f461r = rect.top;
        this.f462s = rect.right;
        this.f463t = rect.bottom;
        drawable.setCallback(this);
        m442v();
    }

    public Drawable getSelector() {
        return this.f456m;
    }

    protected final void m462g() {
        if (isEnabled() && isClickable()) {
            Drawable drawable = this.f456m;
            Rect rect = this.f458o;
            if (drawable == null) {
                return;
            }
            if ((isFocused() || m441u()) && !rect.isEmpty()) {
                View childAt = getChildAt(this.am - this.f416V);
                if (childAt != null) {
                    if (!childAt.hasFocusable()) {
                        childAt.setPressed(true);
                    } else {
                        return;
                    }
                }
                setPressed(true);
                boolean isLongClickable = isLongClickable();
                drawable = drawable.getCurrent();
                if (drawable != null && (drawable instanceof TransitionDrawable)) {
                    if (isLongClickable) {
                        ((TransitionDrawable) drawable).startTransition(ViewConfiguration.getLongPressTimeout());
                    } else {
                        ((TransitionDrawable) drawable).resetTransition();
                    }
                }
                if (isLongClickable && !this.aj) {
                    if (this.aD == null) {
                        this.aD = new CheckForKeyLongPress(this);
                    }
                    this.aD.m366a();
                    postDelayed(this.aD, (long) ViewConfiguration.getLongPressTimeout());
                }
            }
        }
    }

    private void m442v() {
        if (this.f456m == null) {
            return;
        }
        if (m461f()) {
            this.f456m.setState(getDrawableState());
        } else {
            this.f456m.setState(f424U);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        m442v();
    }

    @SuppressLint({"Override"})
    protected int[] onCreateDrawableState(int i) {
        if (this.aI) {
            return super.onCreateDrawableState(i);
        }
        int i2 = View.ENABLED_STATE_SET[0];
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        int length = onCreateDrawableState.length - 1;
        while (length >= 0) {
            if (onCreateDrawableState[length] == i2) {
                break;
            }
            length--;
        }
        length = -1;
        if (length < 0) {
            return onCreateDrawableState;
        }
        System.arraycopy(onCreateDrawableState, length + 1, onCreateDrawableState, length, (onCreateDrawableState.length - length) - 1);
        return onCreateDrawableState;
    }

    public boolean verifyDrawable(Drawable drawable) {
        return this.f456m == drawable || super.verifyDrawable(drawable);
    }

    @TargetApi(11)
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.f456m != null) {
            this.f456m.jumpToCurrentState();
        }
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1015185748);
        super.onAttachedToWindow();
        getViewTreeObserver().addOnTouchModeChangeListener(this);
        if (this.f453j != null && this.f452i == null) {
            this.f452i = new AdapterDataSetObserver(this);
            this.f453j.registerDataSetObserver(this.f452i);
            this.aj = true;
            this.ap = this.ao;
            this.ao = this.f453j.getCount();
        }
        this.f443S = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1174989744, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 143901805);
        super.onDetachedFromWindow();
        this.f459p.m383b();
        getViewTreeObserver().removeOnTouchModeChangeListener(this);
        if (!(this.f453j == null || this.f452i == null)) {
            this.f453j.unregisterDataSetObserver(this.f452i);
            this.f452i = null;
        }
        if (this.av != null) {
            removeCallbacks(this.av);
        }
        if (this.f433I != null) {
            this.f433I.m376a();
        }
        if (this.aL != null) {
            removeCallbacks(this.aL);
        }
        if (this.aE != null) {
            removeCallbacks(this.aE);
        }
        if (this.aF != null) {
            removeCallbacks(this.aF);
            this.aF = null;
        }
        this.f443S = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 439204270, a);
    }

    public void onWindowFocusChanged(boolean z) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1790584458);
        super.onWindowFocusChanged(z);
        int i = isInTouchMode() ? 0 : 1;
        if (!z) {
            setChildrenDrawingCacheEnabled(false);
            if (this.av != null) {
                removeCallbacks(this.av);
                this.av.m371b();
                if (this.f433I != null) {
                    this.f433I.m376a();
                }
                if (getScrollX() != 0) {
                    this.f444a.mo3a(0);
                    m411E();
                    invalidate();
                }
            }
            if (i == 1) {
                this.f437M = this.am;
            }
        } else if (!(i == this.aA || this.aA == -1)) {
            if (i == 1) {
                m409C();
            } else {
                m463h();
                this.f451h = 0;
                mo11d();
            }
        }
        this.aA = i;
        LogUtils.g(-1259098365, a);
    }

    private static ContextMenuInfo m428c(View view, int i, long j) {
        return new AdapterContextMenuInfo(view, i, j);
    }

    final boolean m456b(View view, int i, long j) {
        if (VERSION.SDK_INT < 11 || this.f445b != 3) {
            boolean a;
            if (this.ai != null) {
                a = this.ai.m467a();
            } else {
                a = false;
            }
            if (!a) {
                this.az = m428c(view, i, j);
                a = super.showContextMenuForChild(this);
            }
            if (!a) {
                return a;
            }
            performHapticFeedback(0);
            return a;
        }
        if (this.f446c == null) {
            ActionMode startActionMode = startActionMode((MultiChoiceModeWrapper) this.f447d);
            this.f446c = startActionMode;
            if (startActionMode != null) {
                m423b(i, true);
                performHapticFeedback(0);
            }
        }
        return true;
    }

    protected ContextMenuInfo getContextMenuInfo() {
        return this.az;
    }

    private boolean m418a(float f, float f2, int i) {
        int b = mo21b((int) f, (int) f2);
        if (b != -1) {
            long itemId = this.f453j.getItemId(b);
            View childAt = getChildAt(b - this.f416V);
            if (childAt != null) {
                this.az = m428c(childAt, b, itemId);
                return super.showContextMenuForChild(this);
            }
        }
        return m418a(f, f2, i);
    }

    public boolean showContextMenuForChild(View view) {
        boolean z = false;
        int a = m399a(view);
        if (a < 0) {
            return false;
        }
        long itemId = this.f453j.getItemId(a);
        if (this.ai != null) {
            z = this.ai.m467a();
        }
        if (z) {
            return z;
        }
        this.az = m428c(getChildAt(a - this.f416V), a, itemId);
        return super.showContextMenuForChild(view);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        switch (i) {
            case 23:
            case 66:
                if (!isEnabled()) {
                    return true;
                }
                if (isClickable() && isPressed() && this.am >= 0 && this.f453j != null && this.am < this.f453j.getCount()) {
                    View childAt = getChildAt(this.am - this.f416V);
                    if (childAt != null) {
                        mo8a(childAt, this.am, this.an);
                        childAt.setPressed(false);
                    }
                    setPressed(false);
                    return true;
                }
        }
        return super.onKeyUp(i, keyEvent);
    }

    protected void dispatchSetPressed(boolean z) {
    }

    private int mo21b(int i, int i2) {
        Rect rect = this.ay;
        if (rect == null) {
            this.ay = new Rect();
            rect = this.ay;
        }
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() == 0) {
                childAt.getHitRect(rect);
                if (rect.contains(i, i2)) {
                    return this.f416V + childCount;
                }
            }
        }
        return -1;
    }

    private boolean m434f(int i) {
        int i2 = i - this.f428D;
        int abs = Math.abs(i2);
        boolean z = getScrollX() != 0;
        if (!z && abs <= this.aK) {
            return false;
        }
        int i3;
        AbsHListView absHListView;
        m407A();
        if (z) {
            this.f430F = 5;
            i3 = 0;
            absHListView = this;
        } else {
            this.f430F = 3;
            if (i2 > 0) {
                i3 = this.aK;
                absHListView = this;
            } else {
                i3 = -this.aK;
                absHListView = this;
            }
        }
        absHListView.f432H = i3;
        Handler handler = getHandler();
        if (handler != null) {
            HandlerDetour.a(handler, this.aB);
        }
        setPressed(false);
        View childAt = getChildAt(this.f425A - this.f416V);
        if (childAt != null) {
            childAt.setPressed(false);
        }
        m448a(1);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        m435g(i);
        return true;
    }

    private void m435g(int i) {
        int i2 = 0;
        int i3 = i - this.f428D;
        int i4 = i3 - this.f432H;
        int i5 = this.f431G != Integer.MIN_VALUE ? i - this.f431G : i4;
        int i6;
        int left;
        if (this.f430F == 3) {
            if (i != this.f431G) {
                boolean a;
                if (Math.abs(i3) > this.aK) {
                    ViewParent parent = getParent();
                    if (parent != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    }
                }
                if (this.f425A >= 0) {
                    i6 = this.f425A - this.f416V;
                } else {
                    i6 = getChildCount() / 2;
                }
                View childAt = getChildAt(i6);
                if (childAt != null) {
                    left = childAt.getLeft();
                } else {
                    left = 0;
                }
                if (i5 != 0) {
                    a = m452a(i4, i5);
                } else {
                    a = false;
                }
                View childAt2 = getChildAt(i6);
                if (childAt2 != null) {
                    i6 = childAt2.getLeft();
                    if (a) {
                        i4 = (-i5) - (i6 - left);
                        overScrollBy(i4, 0, getScrollX(), 0, 0, 0, this.f441Q, 0, true);
                        if (Math.abs(this.f441Q) == Math.abs(getScrollX()) && this.au != null) {
                            this.au.clear();
                        }
                        i5 = getOverScrollMode();
                        if (i5 == 0 || (i5 == 1 && !m440r())) {
                            this.aU = 0;
                            this.f430F = 5;
                            if (i3 > 0) {
                                this.aQ.m470a(((float) i4) / ((float) getWidth()));
                                if (!this.aR.m473a()) {
                                    this.aR.m476c();
                                }
                                invalidate(this.aQ.m469a(false));
                            } else if (i3 < 0) {
                                this.aR.m470a(((float) i4) / ((float) getWidth()));
                                if (!this.aQ.m473a()) {
                                    this.aQ.m476c();
                                }
                                invalidate(this.aR.m469a(true));
                            }
                        }
                    }
                    this.f428D = i;
                }
                this.f431G = i;
            }
        } else if (this.f430F == 5 && i != this.f431G) {
            int i7;
            int i8;
            i6 = getScrollX();
            left = i6 - i5;
            if (i > this.f431G) {
                i7 = 1;
            } else {
                i7 = -1;
            }
            if (this.aU == 0) {
                this.aU = i7;
            }
            i4 = -i5;
            if ((left >= 0 || i6 < 0) && (left <= 0 || i6 > 0)) {
                i8 = 0;
            } else {
                i4 = -i6;
                i8 = i5 + i4;
            }
            if (i4 != 0) {
                overScrollBy(i4, 0, getScrollX(), 0, 0, 0, this.f441Q, 0, true);
                i5 = getOverScrollMode();
                if (i5 == 0 || (i5 == 1 && !m440r())) {
                    if (i3 > 0) {
                        this.aQ.m470a(((float) i4) / ((float) getWidth()));
                        if (!this.aR.m473a()) {
                            this.aR.m476c();
                        }
                        invalidate(this.aQ.m469a(false));
                    } else if (i3 < 0) {
                        this.aR.m470a(((float) i4) / ((float) getWidth()));
                        if (!this.aQ.m473a()) {
                            this.aQ.m476c();
                        }
                        invalidate(this.aR.m469a(true));
                    }
                }
            }
            if (i8 != 0) {
                if (getScrollX() != 0) {
                    this.f444a.mo3a(0);
                    m443w();
                }
                m452a(i8, i8);
                this.f430F = 3;
                i5 = m436h(i);
                this.f432H = 0;
                View childAt3 = getChildAt(i5 - this.f416V);
                if (childAt3 != null) {
                    i2 = childAt3.getLeft();
                }
                this.f426B = i2;
                this.f428D = i;
                this.f425A = i5;
            }
            this.f431G = i;
            this.aU = i7;
        }
    }

    @TargetApi(11)
    private void m443w() {
        if (this.f444a.mo5a() && (getParent() instanceof View)) {
            ((View) getParent()).invalidate();
        }
    }

    public void onTouchModeChanged(boolean z) {
        if (z) {
            m463h();
            if (getWidth() > 0 && getChildCount() > 0) {
                mo11d();
            }
            m442v();
            return;
        }
        int i = this.f430F;
        if (i == 5 || i == 6) {
            if (this.av != null) {
                this.av.m371b();
            }
            if (this.f433I != null) {
                this.f433I.m376a();
            }
            if (getScrollX() != 0) {
                this.f444a.mo3a(0);
                m411E();
                invalidate();
            }
        }
    }

    @TargetApi(14)
    private boolean m419a(MotionEvent motionEvent) {
        if (VERSION.SDK_INT < 14 || (motionEvent.getButtonState() & 2) == 0 || !m418a(motionEvent.getX(), motionEvent.getY(), motionEvent.getMetaState())) {
            return false;
        }
        return true;
    }

    @SuppressLint({"Override"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        int a = Logger.a(2, EntryType.UI_INPUT_START, 654271200);
        if (isEnabled()) {
            if (this.f433I != null) {
                this.f433I.m376a();
            }
            if (this.f443S) {
                int action = motionEvent.getAction();
                m444y();
                this.au.addMovement(motionEvent);
                int x;
                int y;
                int b;
                Handler handler;
                switch (action & 255) {
                    case 0:
                        switch (this.f430F) {
                            case 6:
                                this.av.m371b();
                                if (this.f433I != null) {
                                    this.f433I.m376a();
                                }
                                this.f430F = 5;
                                this.f429E = (int) motionEvent.getY();
                                action = (int) motionEvent.getX();
                                this.f431G = action;
                                this.f428D = action;
                                this.f432H = 0;
                                this.aP = motionEvent.getPointerId(0);
                                this.aU = 0;
                                break;
                            default:
                                this.aP = motionEvent.getPointerId(0);
                                x = (int) motionEvent.getX();
                                y = (int) motionEvent.getY();
                                b = mo21b(x, y);
                                if (!this.aj) {
                                    if (this.f430F == 4 || b < 0 || !((ListAdapter) getAdapter()).isEnabled(b)) {
                                        if (this.f430F == 4) {
                                            m407A();
                                            this.f430F = 3;
                                            this.f432H = 0;
                                            action = mo22c(x);
                                            this.av.m373c();
                                            if (action >= 0) {
                                                this.f426B = getChildAt(action - this.f416V).getLeft();
                                            }
                                            this.f428D = x;
                                            this.f429E = y;
                                            this.f425A = action;
                                            this.f431G = Integer.MIN_VALUE;
                                            break;
                                        }
                                    }
                                    this.f430F = 0;
                                    if (this.aC == null) {
                                        this.aC = new CheckForTap(this);
                                    }
                                    postDelayed(this.aC, (long) ViewConfiguration.getTapTimeout());
                                    action = b;
                                    if (action >= 0) {
                                        this.f426B = getChildAt(action - this.f416V).getLeft();
                                    }
                                    this.f428D = x;
                                    this.f429E = y;
                                    this.f425A = action;
                                    this.f431G = Integer.MIN_VALUE;
                                }
                                action = b;
                                if (action >= 0) {
                                    this.f426B = getChildAt(action - this.f416V).getLeft();
                                }
                                this.f428D = x;
                                this.f429E = y;
                                this.f425A = action;
                                this.f431G = Integer.MIN_VALUE;
                                break;
                        }
                        if (m419a(motionEvent) && this.f430F == 0) {
                            removeCallbacks(this.aC);
                            break;
                        }
                        break;
                    case 1:
                        switch (this.f430F) {
                            case 0:
                            case 1:
                            case 2:
                                b = this.f425A;
                                final View childAt = getChildAt(b - this.f416V);
                                float x2 = motionEvent.getX();
                                boolean z = x2 > ((float) this.f464u.left) && x2 < ((float) (getWidth() - this.f464u.right));
                                if (!(childAt == null || childAt.hasFocusable() || !z)) {
                                    if (this.f430F != 0) {
                                        childAt.setPressed(false);
                                    }
                                    if (this.aE == null) {
                                        this.aE = new PerformClick(this);
                                    }
                                    final WindowRunnnable windowRunnnable = this.aE;
                                    windowRunnnable.f394a = b;
                                    windowRunnnable.m366a();
                                    this.f437M = b;
                                    if (this.f430F == 0 || this.f430F == 1) {
                                        Handler handler2 = getHandler();
                                        if (handler2 != null) {
                                            HandlerDetour.a(handler2, this.f430F == 0 ? this.aC : this.aB);
                                        }
                                        this.f451h = 0;
                                        if (this.aj || !this.f453j.isEnabled(b)) {
                                            this.f430F = -1;
                                            m442v();
                                        } else {
                                            this.f430F = 1;
                                            setSelectedPositionInt(this.f425A);
                                            mo11d();
                                            childAt.setPressed(true);
                                            m450a(this.f425A, childAt);
                                            setPressed(true);
                                            if (this.f456m != null) {
                                                Drawable current = this.f456m.getCurrent();
                                                if (current != null && (current instanceof TransitionDrawable)) {
                                                    ((TransitionDrawable) current).resetTransition();
                                                }
                                            }
                                            if (this.aF != null) {
                                                removeCallbacks(this.aF);
                                            }
                                            this.aF = new Runnable(this) {
                                                final /* synthetic */ AbsHListView f373c;

                                                public void run() {
                                                    this.f373c.f430F = -1;
                                                    childAt.setPressed(false);
                                                    this.f373c.setPressed(false);
                                                    if (!this.f373c.aj) {
                                                        windowRunnnable.run();
                                                    }
                                                }
                                            };
                                            postDelayed(this.aF, (long) ViewConfiguration.getPressedStateDuration());
                                        }
                                        LogUtils.a(-1322114446, a);
                                        return true;
                                    } else if (!this.aj && this.f453j.isEnabled(b)) {
                                        windowRunnnable.run();
                                    }
                                }
                                this.f430F = -1;
                                m442v();
                                break;
                            case 3:
                                action = getChildCount();
                                if (action <= 0) {
                                    this.f430F = -1;
                                    m448a(0);
                                    break;
                                }
                                b = getChildAt(0).getLeft();
                                x = getChildAt(action - 1).getRight();
                                y = this.f464u.left;
                                int width = getWidth() - this.f464u.right;
                                if (this.f416V == 0 && b >= y && this.f416V + action < this.ao && x <= getWidth() - width) {
                                    this.f430F = -1;
                                    m448a(0);
                                    break;
                                }
                                VelocityTracker velocityTracker = this.au;
                                velocityTracker.computeCurrentVelocity(1000, (float) this.aN);
                                int xVelocity = (int) (velocityTracker.getXVelocity(this.aP) * this.aO);
                                if (Math.abs(xVelocity) > this.aM && ((this.f416V != 0 || b != y - this.f441Q) && (action + this.f416V != this.ao || x != this.f441Q + width))) {
                                    if (this.av == null) {
                                        this.av = new FlingRunnable(this);
                                    }
                                    m448a(2);
                                    this.av.m370a(-xVelocity);
                                    break;
                                }
                                this.f430F = -1;
                                m448a(0);
                                if (this.av != null) {
                                    this.av.m371b();
                                }
                                if (this.f433I != null) {
                                    this.f433I.m376a();
                                    break;
                                }
                                break;
                            case 5:
                                if (this.av == null) {
                                    this.av = new FlingRunnable(this);
                                }
                                VelocityTracker velocityTracker2 = this.au;
                                velocityTracker2.computeCurrentVelocity(1000, (float) this.aN);
                                action = (int) velocityTracker2.getXVelocity(this.aP);
                                m448a(2);
                                if (Math.abs(action) <= this.aM) {
                                    this.av.m369a();
                                    break;
                                }
                                this.av.m372b(-action);
                                break;
                        }
                        setPressed(false);
                        if (this.aQ != null) {
                            this.aQ.m476c();
                            this.aR.m476c();
                        }
                        invalidate();
                        handler = getHandler();
                        if (handler != null) {
                            HandlerDetour.a(handler, this.aB);
                        }
                        m445z();
                        this.aP = -1;
                        break;
                    case 2:
                        action = motionEvent.findPointerIndex(this.aP);
                        if (action == -1) {
                            this.aP = motionEvent.getPointerId(0);
                        } else {
                            i = action;
                        }
                        action = (int) motionEvent.getX(i);
                        if (this.aj) {
                            mo11d();
                        }
                        switch (this.f430F) {
                            case 0:
                            case 1:
                            case 2:
                                m434f(action);
                                break;
                            case 3:
                            case 5:
                                m435g(action);
                                break;
                            default:
                                break;
                        }
                    case 3:
                        switch (this.f430F) {
                            case 5:
                                if (this.av == null) {
                                    this.av = new FlingRunnable(this);
                                }
                                this.av.m369a();
                                break;
                            case 6:
                                break;
                            default:
                                this.f430F = -1;
                                setPressed(false);
                                View childAt2 = getChildAt(this.f425A - this.f416V);
                                if (childAt2 != null) {
                                    childAt2.setPressed(false);
                                }
                                m408B(this);
                                handler = getHandler();
                                if (handler != null) {
                                    HandlerDetour.a(handler, this.aB);
                                }
                                m445z();
                                break;
                        }
                        if (this.aQ != null) {
                            this.aQ.m476c();
                            this.aR.m476c();
                        }
                        this.aP = -1;
                        break;
                    case 5:
                        action = motionEvent.getActionIndex();
                        b = motionEvent.getPointerId(action);
                        x = (int) motionEvent.getX(action);
                        action = (int) motionEvent.getY(action);
                        this.f432H = 0;
                        this.aP = b;
                        this.f428D = x;
                        this.f429E = action;
                        action = mo21b(x, action);
                        if (action >= 0) {
                            this.f426B = getChildAt(action - this.f416V).getLeft();
                            this.f425A = action;
                        }
                        this.f431G = x;
                        break;
                    case 6:
                        m424b(motionEvent);
                        action = this.f428D;
                        i = mo21b(action, this.f429E);
                        if (i >= 0) {
                            this.f426B = getChildAt(i - this.f416V).getLeft();
                            this.f425A = i;
                        }
                        this.f431G = action;
                        break;
                }
                LogUtils.a(-729938887, a);
                return true;
            }
            LogUtils.a(468424902, a);
            return false;
        }
        if (isClickable() || isLongClickable()) {
            z = true;
        } else {
            z = false;
        }
        LogUtils.a(1734802581, a);
        return z;
    }

    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        if (getScrollX() != i) {
            onScrollChanged(i, getScrollY(), getScrollX(), getScrollY());
            this.f444a.mo3a(i);
            m443w();
            awakenScrollBars();
        }
    }

    @TargetApi(12)
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0) {
            switch (motionEvent.getAction()) {
                case 8:
                    if (this.f430F == -1) {
                        float axisValue = motionEvent.getAxisValue(10);
                        if (axisValue != 0.0f) {
                            int horizontalScrollFactor = (int) (axisValue * getHorizontalScrollFactor());
                            if (!m452a(horizontalScrollFactor, horizontalScrollFactor)) {
                                return true;
                            }
                        }
                    }
                    break;
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    protected float getHorizontalScrollFactor() {
        if (this.bd == 0.0f) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(2130773466, typedValue, true)) {
                this.bd = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define hlv_listPreferredItemWidth.");
            }
        }
        return this.bd;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.aQ != null) {
            int save;
            int i;
            int height;
            int scrollX = getScrollX();
            if (!this.aQ.m473a()) {
                save = canvas.save();
                i = this.f464u.top + this.aW;
                height = (getHeight() - i) - (this.f464u.bottom + this.aX);
                int min = Math.min(0, this.aS + scrollX);
                canvas.rotate(-90.0f);
                canvas.translate((float) ((-getHeight()) + i), (float) min);
                this.aQ.m472a(height, height);
                if (this.aQ.m474a(canvas)) {
                    EdgeEffect edgeEffect = this.aQ;
                    edgeEffect.f483f = min;
                    edgeEffect.f484g = i;
                    invalidate();
                }
                canvas.restoreToCount(save);
            }
            if (!this.aR.m473a()) {
                save = canvas.save();
                i = this.f464u.left + this.aW;
                height = (getHeight() - i) - (this.f464u.right + this.aX);
                scrollX = Math.max(getWidth(), scrollX + this.aT);
                canvas.rotate(90.0f);
                canvas.translate((float) (-i), (float) (-scrollX));
                this.aR.m472a(height, height);
                if (this.aR.m474a(canvas)) {
                    invalidate();
                }
                canvas.restoreToCount(save);
            }
        }
    }

    private void m444y() {
        if (this.au == null) {
            this.au = VelocityTracker.obtain();
        }
    }

    private void m445z() {
        if (this.au != null) {
            this.au.recycle();
            this.au = null;
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            m445z();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.f433I != null) {
            this.f433I.m376a();
        }
        if (!this.f443S) {
            return false;
        }
        switch (action & 255) {
            case 0:
                action = this.f430F;
                if (action == 6 || action == 5) {
                    this.f432H = 0;
                    return true;
                }
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                this.aP = motionEvent.getPointerId(0);
                int c = mo22c(x);
                if (action != 4 && c >= 0) {
                    this.f426B = getChildAt(c - this.f416V).getLeft();
                    this.f428D = x;
                    this.f429E = y;
                    this.f425A = c;
                    this.f430F = 0;
                    m408B(this);
                }
                this.f431G = Integer.MIN_VALUE;
                if (this.au == null) {
                    this.au = VelocityTracker.obtain();
                } else {
                    this.au.clear();
                }
                this.au.addMovement(motionEvent);
                if (action == 4) {
                    return true;
                }
                return false;
            case 1:
            case 3:
                this.f430F = -1;
                this.aP = -1;
                m445z();
                m448a(0);
                return false;
            case 2:
                switch (this.f430F) {
                    case 0:
                        action = motionEvent.findPointerIndex(this.aP);
                        if (action == -1) {
                            this.aP = motionEvent.getPointerId(0);
                            action = 0;
                        }
                        action = (int) motionEvent.getX(action);
                        m444y();
                        this.au.addMovement(motionEvent);
                        if (m434f(action)) {
                            return true;
                        }
                        return false;
                    default:
                        return false;
                }
            case 6:
                m424b(motionEvent);
                return false;
            default:
                return false;
        }
    }

    private void m424b(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & 65280) >> 8;
        if (motionEvent.getPointerId(action) == this.aP) {
            action = action == 0 ? 1 : 0;
            this.f428D = (int) motionEvent.getX(action);
            this.f429E = (int) motionEvent.getY(action);
            this.f432H = 0;
            this.aP = motionEvent.getPointerId(action);
        }
    }

    public void addTouchables(ArrayList<View> arrayList) {
        int childCount = getChildCount();
        int i = this.f416V;
        ListAdapter listAdapter = this.f453j;
        if (listAdapter != null) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (listAdapter.isEnabled(i + i2)) {
                    arrayList.add(childAt);
                }
                childAt.addTouchables(arrayList);
            }
        }
    }

    final void m448a(int i) {
        if (i != this.aJ && this.aw != null) {
            this.aJ = i;
        }
    }

    public void setFriction(float f) {
        if (this.av == null) {
            this.av = new FlingRunnable(this);
        }
        OverScroller overScroller = this.av.f385b;
        overScroller.f539b.f533m = f;
        overScroller.f540c.f533m = f;
    }

    public void setVelocityScale(float f) {
        this.aO = f;
    }

    private void m429c(int i, int i2) {
        m449a(i, i2, false);
    }

    public final void m449a(int i, int i2, boolean z) {
        if (this.av == null) {
            this.av = new FlingRunnable(this);
        }
        int i3 = this.f416V;
        int childCount = getChildCount();
        int i4 = i3 + childCount;
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        if (i == 0 || this.ao == 0 || childCount == 0 || ((i3 == 0 && getChildAt(0).getLeft() == paddingLeft && i < 0) || (i4 == this.ao && getChildAt(childCount - 1).getRight() == width && i > 0))) {
            this.av.m371b();
            if (this.f433I != null) {
                this.f433I.m376a();
                return;
            }
            return;
        }
        Interpolator interpolator;
        m448a(2);
        Runnable runnable = this.av;
        int i5 = i < 0 ? Integer.MAX_VALUE : 0;
        runnable.f386c = i5;
        OverScroller overScroller = runnable.f385b;
        if (z) {
            interpolator = f423T;
        } else {
            interpolator = null;
        }
        overScroller.f541d = interpolator;
        runnable.f385b.m556a(i5, 0, i, 0, i2);
        runnable.f384a.f430F = 4;
        runnable.f384a.f444a.mo4a(runnable);
    }

    private void m407A() {
        if (this.f436L && !this.f468y && !this.f444a.mo5a()) {
            setChildrenDrawnWithCacheEnabled(true);
            setChildrenDrawingCacheEnabled(true);
            this.f469z = true;
            this.f468y = true;
        }
    }

    public static void m408B(AbsHListView absHListView) {
        if (!absHListView.f444a.mo5a()) {
            if (absHListView.aL == null) {
                absHListView.aL = new C00492(absHListView);
            }
            absHListView.post(absHListView.aL);
        }
    }

    final boolean m452a(int i, int i2) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return true;
        }
        int max;
        int max2;
        int left = getChildAt(0).getLeft();
        int right = getChildAt(childCount - 1).getRight();
        Rect rect = this.f464u;
        int i3 = 0 - left;
        int width = right - (getWidth() + 0);
        int width2 = (getWidth() - getPaddingRight()) - getPaddingLeft();
        if (i < 0) {
            max = Math.max(-(width2 - 1), i);
        } else {
            max = Math.min(width2 - 1, i);
        }
        if (i2 < 0) {
            max2 = Math.max(-(width2 - 1), i2);
        } else {
            max2 = Math.min(width2 - 1, i2);
        }
        int i4 = this.f416V;
        if (i4 == 0) {
            this.aS = left - rect.left;
        } else {
            this.aS += max2;
        }
        if (i4 + childCount == this.ao) {
            this.aT = rect.right + right;
        } else {
            this.aT += max2;
        }
        Object obj = (i4 != 0 || left < rect.left || max2 < 0) ? null : 1;
        Object obj2 = (i4 + childCount != this.ao || right > getWidth() - rect.right || max2 > 0) ? null : 1;
        if (obj == null && obj2 == null) {
            boolean z = max2 < 0;
            boolean isInTouchMode = isInTouchMode();
            if (isInTouchMode) {
                m463h();
            }
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = this.ao - getFooterViewsCount();
            int i5 = 0;
            int width3;
            if (!z) {
                width3 = getWidth() - max2;
                right = 0;
                for (width2 = childCount - 1; width2 >= 0; width2--) {
                    View childAt = getChildAt(width2);
                    if (childAt.getLeft() <= width3) {
                        break;
                    }
                    i5 = right + 1;
                    right = i4 + width2;
                    if (right >= headerViewsCount && right < footerViewsCount) {
                        this.f459p.m382a(childAt, right);
                    }
                    right = i5;
                    i5 = width2;
                }
            } else {
                int i6 = -max2;
                right = 0;
                width2 = 0;
                while (width2 < childCount) {
                    View childAt2 = getChildAt(width2);
                    if (childAt2.getRight() >= i6) {
                        break;
                    }
                    width3 = right + 1;
                    right = i4 + width2;
                    if (right >= headerViewsCount && right < footerViewsCount) {
                        this.f459p.m382a(childAt2, right);
                    }
                    width2++;
                    right = width3;
                }
            }
            this.f427C = this.f426B + max;
            this.at = true;
            if (right > 0) {
                detachViewsFromParent(i5, right);
                this.f459p.m385d();
            }
            if (!awakenScrollBars()) {
                invalidate();
            }
            m455b(max2);
            if (z) {
                this.V = right + this.f416V;
            }
            max2 = Math.abs(max2);
            if (i3 < max2 || width < max2) {
                mo7a(z);
            }
            if (!isInTouchMode && this.am != -1) {
                max2 = this.am - this.f416V;
                if (max2 >= 0 && max2 < getChildCount()) {
                    m450a(this.am, getChildAt(max2));
                }
            } else if (this.f457n != -1) {
                max2 = this.f457n - this.f416V;
                if (max2 >= 0 && max2 < getChildCount()) {
                    m450a(-1, getChildAt(max2));
                }
            } else {
                this.f458o.setEmpty();
            }
            this.at = false;
            mo9b();
            return false;
        } else if (max2 != 0) {
            return true;
        } else {
            return false;
        }
    }

    public final void m455b(int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            getChildAt(i2).offsetLeftAndRight(i);
        }
    }

    protected int getHeaderViewsCount() {
        return 0;
    }

    protected int getFooterViewsCount() {
        return 0;
    }

    protected final void m463h() {
        if (this.am != -1) {
            if (this.f451h != 4) {
                this.f437M = this.am;
            }
            if (this.ak >= 0 && this.ak != this.am) {
                this.f437M = this.ak;
            }
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            this.f434J = 0;
        }
    }

    protected final int m464i() {
        int i = this.am;
        if (i < 0) {
            i = this.f437M;
        }
        return Math.min(Math.max(0, i), this.ao - 1);
    }

    private int m436h(int i) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return -1;
        }
        int c = mo22c(i);
        return c != -1 ? c : (this.f416V + childCount) - 1;
    }

    protected final boolean m465j() {
        if (this.am >= 0 || !m409C()) {
            return false;
        }
        m442v();
        return true;
    }

    private boolean m409C() {
        int childCount = getChildCount();
        if (childCount <= 0) {
            return false;
        }
        int left;
        int horizontalFadingEdgeLength;
        boolean z;
        boolean z2 = this.f464u.left;
        int right = (getRight() - getLeft()) - this.f464u.right;
        int i = this.f416V;
        int i2 = this.f437M;
        if (i2 >= i && i2 < i + childCount) {
            View childAt = getChildAt(i2 - this.f416V);
            left = childAt.getLeft();
            childCount = childAt.getRight();
            if (left < z2) {
                horizontalFadingEdgeLength = getHorizontalFadingEdgeLength() + z2;
                left = i2;
                z = true;
            } else {
                if (childCount > right) {
                    left = (right - childAt.getMeasuredWidth()) - getHorizontalFadingEdgeLength();
                }
                horizontalFadingEdgeLength = left;
                left = i2;
                z = true;
            }
        } else if (i2 < i) {
            right = 0;
            boolean z3 = false;
            while (right < childCount) {
                boolean z4;
                z = getChildAt(right).getLeft();
                if (right != 0) {
                    z4 = z2;
                    z2 = z3;
                    z3 = z4;
                } else if (i > 0 || z < z2) {
                    z3 = getHorizontalFadingEdgeLength() + z2;
                    z2 = z;
                } else {
                    z3 = z2;
                    z2 = z;
                }
                if (z >= z3) {
                    left = i + right;
                    z2 = z;
                    z = true;
                    break;
                }
                right++;
                z4 = z3;
                z3 = z2;
                z2 = z4;
            }
            z = true;
            z2 = z3;
            left = i;
        } else {
            int i3 = this.ao;
            left = (i + childCount) - 1;
            int i4 = childCount - 1;
            horizontalFadingEdgeLength = 0;
            while (i4 >= 0) {
                int i5;
                View childAt2 = getChildAt(i4);
                i2 = childAt2.getLeft();
                int right2 = childAt2.getRight();
                if (i4 != childCount - 1) {
                    i5 = right;
                    right = horizontalFadingEdgeLength;
                    horizontalFadingEdgeLength = i5;
                } else if (i + childCount < i3 || right2 > right) {
                    horizontalFadingEdgeLength = right - getHorizontalFadingEdgeLength();
                    right = i2;
                } else {
                    horizontalFadingEdgeLength = right;
                    right = i2;
                }
                if (right2 <= horizontalFadingEdgeLength) {
                    left = i + i4;
                    horizontalFadingEdgeLength = i2;
                    z = false;
                    break;
                }
                i4--;
                i5 = horizontalFadingEdgeLength;
                horizontalFadingEdgeLength = right;
                right = i5;
            }
            z = false;
        }
        this.f437M = -1;
        removeCallbacks(this.av);
        if (this.f433I != null) {
            this.f433I.m376a();
        }
        this.f430F = -1;
        m408B(this);
        this.W = horizontalFadingEdgeLength;
        left = mo20a(left, z);
        if (left < i || left > getLastVisiblePosition()) {
            left = -1;
        } else {
            this.f451h = 4;
            m442v();
            setSelectionInt(left);
            mo9b();
        }
        m448a(0);
        if (left >= 0) {
            return true;
        }
        return false;
    }

    private void m410D() {
        this.f449f.clear();
        int i = 0;
        boolean z = false;
        while (i < this.f450g.a()) {
            int max;
            boolean z2;
            long b = this.f450g.b(i);
            int intValue = ((Integer) this.f450g.c(i)).intValue();
            if (b != this.f453j.getItemId(intValue)) {
                boolean z3;
                int min = Math.min(intValue + 20, this.ao);
                for (max = Math.max(0, intValue - 20); max < min; max++) {
                    if (b == this.f453j.getItemId(max)) {
                        this.f449f.put(max, true);
                        this.f450g.a(i, Integer.valueOf(max));
                        z3 = true;
                        break;
                    }
                }
                z3 = false;
                if (!z3) {
                    this.f450g.b(b);
                    max = i - 1;
                    this.f448e--;
                    if (!(VERSION.SDK_INT <= 11 || this.f446c == null || this.f447d == null)) {
                        ((MultiChoiceModeWrapper) this.f447d).mo6a((ActionMode) this.f446c, intValue, b, false);
                    }
                    i = max;
                    z = true;
                }
                max = i;
                z2 = z;
            } else {
                this.f449f.put(intValue, true);
                max = i;
                z2 = z;
            }
            z = z2;
            i = max + 1;
        }
        if (z && this.f446c != null && VERSION.SDK_INT > 11) {
            ((ActionMode) this.f446c).invalidate();
        }
    }

    protected final void mo14k() {
        int i = this.ao;
        int i2 = this.bb;
        this.bb = this.ao;
        if (!(this.f445b == 0 || this.f453j == null || !this.f453j.hasStableIds())) {
            m410D();
        }
        RecycleBin recycleBin = this.f459p;
        if (recycleBin.f405i != null) {
            recycleBin.f405i.b();
        }
        if (i > 0) {
            int width;
            int bottom;
            if (this.ad) {
                this.ad = false;
                this.bc = null;
                if (this.aG == 2) {
                    this.f451h = 3;
                    return;
                }
                if (this.aG == 1) {
                    if (this.aV) {
                        this.aV = false;
                        this.f451h = 3;
                        return;
                    }
                    int childCount = getChildCount();
                    width = getWidth() - getPaddingRight();
                    View childAt = getChildAt(childCount - 1);
                    if (childAt != null) {
                        bottom = childAt.getBottom();
                    } else {
                        bottom = width;
                    }
                    if (childCount + this.f416V < i2 || r0 > width) {
                        awakenScrollBars();
                    } else {
                        this.f451h = 3;
                        return;
                    }
                }
                switch (this.ae) {
                    case 0:
                        if (isInTouchMode()) {
                            this.f451h = 5;
                            this.aa = Math.min(Math.max(0, this.aa), i - 1);
                            return;
                        }
                        bottom = m405n();
                        if (bottom >= 0 && mo20a(bottom, true) == bottom) {
                            this.aa = bottom;
                            if (this.ac == ((long) getWidth())) {
                                this.f451h = 5;
                            } else {
                                this.f451h = 2;
                            }
                            setNextSelectedPositionInt(bottom);
                            return;
                        }
                    case 1:
                        this.f451h = 5;
                        this.aa = Math.min(Math.max(0, this.aa), i - 1);
                        return;
                }
            }
            if (!isInTouchMode()) {
                bottom = this.ak;
                if (bottom >= i) {
                    bottom = i - 1;
                }
                if (bottom < 0) {
                    bottom = 0;
                }
                width = mo20a(bottom, true);
                if (width >= 0) {
                    setNextSelectedPositionInt(width);
                    return;
                }
                bottom = mo20a(bottom, false);
                if (bottom >= 0) {
                    setNextSelectedPositionInt(bottom);
                    return;
                }
            } else if (this.f437M >= 0) {
                return;
            }
        }
        this.f451h = this.f435K ? 3 : 1;
        this.am = -1;
        this.an = Long.MIN_VALUE;
        this.ak = -1;
        this.al = Long.MIN_VALUE;
        this.ad = false;
        this.bc = null;
        this.f457n = -1;
        m404m();
    }

    public static int m412a(Rect rect, Rect rect2, int i) {
        int width;
        int height;
        int width2;
        int height2;
        switch (i) {
            case 1:
            case 2:
                width = rect.right + (rect.width() / 2);
                height = rect.top + (rect.height() / 2);
                width2 = (rect2.width() / 2) + rect2.left;
                height2 = rect2.top + (rect2.height() / 2);
                break;
            case 17:
                width = rect.left;
                height = rect.top + (rect.height() / 2);
                width2 = rect2.right;
                height2 = rect2.top + (rect2.height() / 2);
                break;
            case 33:
                width = rect.left + (rect.width() / 2);
                height = rect.top;
                width2 = (rect2.width() / 2) + rect2.left;
                height2 = rect2.bottom;
                break;
            case 66:
                width = rect.right;
                height = rect.top + (rect.height() / 2);
                width2 = rect2.left;
                height2 = rect2.top + (rect2.height() / 2);
                break;
            case 130:
                width = rect.left + (rect.width() / 2);
                height = rect.bottom;
                width2 = (rect2.width() / 2) + rect2.left;
                height2 = rect2.top;
                break;
            default:
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT, FOCUS_FORWARD, FOCUS_BACKWARD}.");
        }
        width2 -= width;
        height2 -= height;
        return (height2 * height2) + (width2 * width2);
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return null;
    }

    public boolean checkInputConnectionProxy(View view) {
        return false;
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -1, 0);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public int getTranscriptMode() {
        return this.aG;
    }

    public int getSolidColor() {
        return this.aH;
    }

    public void setCacheColorHint(int i) {
        if (i != this.aH) {
            int i2;
            this.aH = i;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                getChildAt(i3).setDrawingCacheBackgroundColor(i);
            }
            RecycleBin recycleBin = this.f459p;
            int size;
            int i4;
            if (recycleBin.f402f == 1) {
                ArrayList arrayList = recycleBin.f403g;
                size = arrayList.size();
                for (i4 = 0; i4 < size; i4++) {
                    ((View) arrayList.get(i4)).setDrawingCacheBackgroundColor(i);
                }
            } else {
                size = recycleBin.f402f;
                for (i2 = 0; i2 < size; i2++) {
                    ArrayList arrayList2 = recycleBin.f401e[i2];
                    int size2 = arrayList2.size();
                    for (i4 = 0; i4 < size2; i4++) {
                        ((View) arrayList2.get(i4)).setDrawingCacheBackgroundColor(i);
                    }
                }
            }
            for (View view : recycleBin.f400d) {
                if (view != null) {
                    view.setDrawingCacheBackgroundColor(i);
                }
            }
        }
    }

    @ExportedProperty(category = "drawing")
    public int getCacheColorHint() {
        return this.aH;
    }

    private void m411E() {
        if (this.aQ != null) {
            this.aQ.m475b();
            this.aR.m475b();
        }
    }

    public void setRecyclerListener(RecyclerListener recyclerListener) {
        this.f459p.f398b = recyclerListener;
    }

    public static View m414a(ArrayList<View> arrayList, int i) {
        int size = arrayList.size();
        if (size <= 0) {
            return null;
        }
        for (int i2 = 0; i2 < size; i2++) {
            View view = (View) arrayList.get(i2);
            if (((LayoutParams) view.getLayoutParams()).f391d == i) {
                arrayList.remove(i2);
                return view;
            }
        }
        return (View) arrayList.remove(size - 1);
    }
}

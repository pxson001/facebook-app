package com.facebook.widget.dragsortgridview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.GridView;
import com.facebook.R;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.userinteraction.DefaultUserInteractionController;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringListener;
import com.facebook.springs.SpringSystem;
import com.facebook.springs.SpringUtil;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.OnDrawListenerSet;
import com.facebook.widget.OnDrawListenerSet.OnDrawListener;
import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.List;

/* compiled from: delayTillNextPingMillis */
public class DragSortGridView extends GridView {
    private static final SpringConfig f15958a = SpringConfig.a(100.0d, 3.5d);
    private static final HoverBehavior f15959b = HoverBehavior.CLONE_BITMAP;
    private int f15960A = 0;
    public DefaultUserInteractionController f15961B;
    public MonotonicClock f15962C;
    private Runnable f15963D;
    private int f15964E;
    private int f15965F;
    private int f15966G;
    private int f15967H;
    public double f15968I = 1.1d;
    public SpringSystem f15969J;
    public HoverRenderer f15970K;
    private HoverBehavior f15971L = f15959b;
    public Drawable f15972M;
    public OnScrollListener f15973N;
    public OnItemLongClickListener f15974O;
    private OnItemLongClickListener f15975P = new C12311(this);
    public OnItemClickListener f15976Q;
    private OnItemClickListener f15977R = new C12322(this);
    private final OnScrollListener f15978S = new C12388(this);
    private final OnDrawListenerSet f15979c = new OnDrawListenerSet();
    public int f15980d = 0;
    public int f15981e = 0;
    public int f15982f = -1;
    public int f15983g = -1;
    private int f15984h = -1;
    private int f15985i = -1;
    private List<Long> f15986j = Lists.a();
    public long f15987k = -1;
    public boolean f15988l = false;
    private int f15989m = -1;
    public boolean f15990n;
    private int f15991o = 0;
    public boolean f15992p = false;
    public int f15993q = 0;
    public long f15994r;
    public boolean f15995s = false;
    public OnDropListener f15996t;
    public OnAnimateListener f15997u;
    public boolean f15998v;
    public boolean f15999w;
    public Spring f16000x;
    public boolean f16001y = false;
    private SpringListener f16002z;

    /* compiled from: delayTillNextPingMillis */
    class C12311 implements OnItemLongClickListener {
        final /* synthetic */ DragSortGridView f15939a;

        C12311(DragSortGridView dragSortGridView) {
            this.f15939a = dragSortGridView;
        }

        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (!this.f15939a.isEnabled() || this.f15939a.f15995s) {
                return false;
            }
            if (this.f15939a.f15974O != null) {
                this.f15939a.f15974O.onItemLongClick(adapterView, view, i, j);
            }
            if (!this.f15939a.f15995s) {
                return true;
            }
            this.f15939a.f15980d = 0;
            this.f15939a.f15981e = 0;
            int pointToPosition = this.f15939a.pointToPosition(this.f15939a.f15982f, this.f15939a.f15983g);
            View childAt = this.f15939a.getChildAt(pointToPosition - this.f15939a.getFirstVisiblePosition());
            this.f15939a.f15987k = this.f15939a.getAdapter().getItemId(pointToPosition);
            this.f15939a.f15970K.mo1220a(childAt);
            this.f15939a.f16000x.a(0.0d).b(1.0d);
            if (DragSortGridView.m19947f(this.f15939a) && childAt != null) {
                childAt.setVisibility(4);
            }
            this.f15939a.f15988l = true;
            this.f15939a.f15987k = this.f15939a.f15987k;
            return true;
        }
    }

    /* compiled from: delayTillNextPingMillis */
    class C12322 implements OnItemClickListener {
        final /* synthetic */ DragSortGridView f15940a;

        C12322(DragSortGridView dragSortGridView) {
            this.f15940a = dragSortGridView;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (!this.f15940a.f15995s && this.f15940a.isEnabled() && this.f15940a.f15976Q != null) {
                this.f15940a.f15976Q.onItemClick(adapterView, view, i, j);
            }
        }
    }

    /* compiled from: delayTillNextPingMillis */
    class C12333 implements Runnable {
        final /* synthetic */ DragSortGridView f15941a;

        C12333(DragSortGridView dragSortGridView) {
            this.f15941a = dragSortGridView;
        }

        public void run() {
            this.f15941a.f15968I;
        }
    }

    /* compiled from: delayTillNextPingMillis */
    class C12344 extends SimpleSpringListener {
        final /* synthetic */ DragSortGridView f15942a;

        C12344(DragSortGridView dragSortGridView) {
            this.f15942a = dragSortGridView;
        }

        public final void m19893a(Spring spring) {
            if (this.f15942a.f15970K.mo1221a() && !this.f15942a.f16001y) {
                Point a = this.f15942a.f15970K.mo1217a(SpringUtil.a(spring.d(), 0.0d, 1.0d, 1.0d, this.f15942a.f15968I));
                DragSortGridView.m19931c(this.f15942a, a.x);
                DragSortGridView.m19937d(this.f15942a, a.y);
                this.f15942a.invalidate();
            } else if (this.f15942a.f16001y) {
                this.f15942a.f16001y = false;
            }
        }
    }

    /* compiled from: delayTillNextPingMillis */
    public class C12355 {
        final /* synthetic */ DragSortGridView f15943a;

        C12355(DragSortGridView dragSortGridView) {
            this.f15943a = dragSortGridView;
        }

        public final void m19895a(View view) {
            this.f15943a.m19911a(view);
        }

        public final void m19894a() {
            this.f15943a.invalidate();
        }

        public final void m19897b() {
            this.f15943a.f15998v = true;
            this.f15943a.f15987k;
        }

        public final void m19898c() {
            this.f15943a.f15998v = false;
            if (this.f15943a.f15997u != null) {
                OnAnimateListener onAnimateListener = this.f15943a.f15997u;
            }
            this.f15943a.f15987k;
        }

        public final Drawable m19899d() {
            return this.f15943a.f15972M;
        }

        public final View m19896b(View view) {
            return this.f15943a.getAdapter().getView(this.f15943a.getPositionForView(view), null, this.f15943a);
        }
    }

    /* compiled from: delayTillNextPingMillis */
    class C12377 extends AnimatorListenerAdapter {
        final /* synthetic */ DragSortGridView f15950a;

        C12377(DragSortGridView dragSortGridView) {
            this.f15950a = dragSortGridView;
        }

        public void onAnimationStart(Animator animator) {
            this.f15950a.f15999w = true;
            this.f15950a.f15987k;
        }

        public void onAnimationEnd(Animator animator) {
            this.f15950a.f15999w = false;
            this.f15950a.f15987k;
        }
    }

    /* compiled from: delayTillNextPingMillis */
    class C12388 implements OnScrollListener {
        final /* synthetic */ DragSortGridView f15951a;
        private int f15952b = -1;
        private int f15953c = -1;
        private int f15954d;
        private int f15955e;
        private int f15956f;

        C12388(DragSortGridView dragSortGridView) {
            this.f15951a = dragSortGridView;
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            this.f15951a.f15994r = this.f15951a.f15962C.now();
            this.f15954d = i;
            this.f15955e = i2;
            this.f15952b = this.f15952b == -1 ? this.f15954d : this.f15952b;
            this.f15953c = this.f15953c == -1 ? this.f15955e : this.f15953c;
            m19901b();
            m19902c();
            this.f15952b = this.f15954d;
            this.f15953c = this.f15955e;
            if (this.f15951a.f15973N != null) {
                this.f15951a.f15973N.onScroll(absListView, i, i2, i3);
            }
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            this.f15951a.f15981e = i;
            this.f15956f = i;
            this.f15951a.f15993q = i;
            m19900a();
            if (this.f15951a.f15973N != null) {
                this.f15951a.f15973N.onScrollStateChanged(absListView, i);
            }
        }

        private void m19900a() {
            if (this.f15955e > 0 && this.f15956f == 0) {
                if (this.f15951a.f15988l && this.f15951a.f15990n) {
                    this.f15951a.f16000x;
                } else if (this.f15951a.f15992p) {
                    DragSortGridView.m19947f(this.f15951a);
                }
            }
        }

        private void m19901b() {
            if (this.f15954d != this.f15952b && this.f15951a.f15988l && this.f15951a.f15987k != -1) {
                this.f15951a.f15987k = this.f15951a.f15987k;
                DragSortGridView.m19960j(this.f15951a);
            }
        }

        private void m19902c() {
            if (this.f15954d + this.f15955e != this.f15952b + this.f15953c && this.f15951a.f15988l && this.f15951a.f15987k != -1) {
                this.f15951a.f15987k = this.f15951a.f15987k;
                DragSortGridView.m19960j(this.f15951a);
            }
        }
    }

    /* compiled from: delayTillNextPingMillis */
    public enum HoverBehavior {
        CLONE_BITMAP,
        CLONE_VIEW
    }

    /* compiled from: delayTillNextPingMillis */
    public interface OnAnimateListener {
    }

    /* compiled from: delayTillNextPingMillis */
    public interface OnDropListener {
        void m19903a();
    }

    private static <T extends View> void m19915a(Class<T> cls, T t) {
        m19916a((Object) t, t.getContext());
    }

    private static void m19916a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        DragSortGridView dragSortGridView = (DragSortGridView) obj;
        DefaultUserInteractionController a = DefaultUserInteractionController.a(fbInjector);
        MonotonicClock monotonicClock = (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(fbInjector);
        SpringSystem b = SpringSystem.b(fbInjector);
        dragSortGridView.f15961B = a;
        dragSortGridView.f15962C = monotonicClock;
        dragSortGridView.f15969J = b;
    }

    static /* synthetic */ int m19931c(DragSortGridView dragSortGridView, int i) {
        int i2 = dragSortGridView.f15981e - i;
        dragSortGridView.f15981e = i2;
        return i2;
    }

    static /* synthetic */ int m19937d(DragSortGridView dragSortGridView, int i) {
        int i2 = dragSortGridView.f15980d - i;
        dragSortGridView.f15980d = i2;
        return i2;
    }

    static /* synthetic */ int m19942e(DragSortGridView dragSortGridView, int i) {
        int i2 = dragSortGridView.f15980d + i;
        dragSortGridView.f15980d = i2;
        return i2;
    }

    static /* synthetic */ int m19946f(DragSortGridView dragSortGridView, int i) {
        int i2 = dragSortGridView.f15981e + i;
        dragSortGridView.f15981e = i2;
        return i2;
    }

    public DragSortGridView(Context context) {
        super(context);
        m19910a(context, null);
    }

    public DragSortGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m19910a(context, attributeSet);
    }

    public DragSortGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m19910a(context, attributeSet);
    }

    public void setOnDropListener(OnDropListener onDropListener) {
        this.f15996t = onDropListener;
    }

    public void setOnAnimateListener(OnAnimateListener onAnimateListener) {
        this.f15997u = onAnimateListener;
    }

    public final void m19975a() {
        this.f15995s = true;
    }

    public final void m19976b() {
        this.f15995s = false;
    }

    public final boolean m19977c() {
        return this.f15995s;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.f15974O = onItemLongClickListener;
        super.setOnItemLongClickListener(this.f15975P);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.f15976Q = onItemClickListener;
        super.setOnItemClickListener(this.f15977R);
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.f15973N = onScrollListener;
        super.setOnScrollListener(this.f15978S);
    }

    public void setDraggedItemBackgroundDrawable(Drawable drawable) {
        this.f15972M = drawable;
    }

    private void m19910a(Context context, AttributeSet attributeSet) {
        m19915a(DragSortGridView.class, (View) this);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DragSortGridView);
            this.f15964E = obtainStyledAttributes.getInt(0, 0);
            this.f15965F = (int) obtainStyledAttributes.getDimension(1, 0.0f);
            obtainStyledAttributes.recycle();
        }
        this.f15963D = new C12333(this);
        this.f16000x = this.f15969J.a();
        this.f16000x.a(f15958a);
        this.f16002z = new C12344(this);
        super.setOnScrollListener(this.f15978S);
        this.f15991o = (int) ((context.getResources().getDisplayMetrics().density * 8.0f) + 0.5f);
    }

    public void setColumnWidthCompat(int i) {
        this.f15965F = i;
    }

    public void setHoverScaleFactor(double d) {
        this.f15968I = d;
    }

    public void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1340285418);
        super.onAttachedToWindow();
        this.f16000x.a(this.f16002z);
        this.f15970K = m19938d();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -452456210, a);
    }

    public HoverBehavior getHoverBehavior() {
        return this.f15971L;
    }

    public void setHoverBehavior(HoverBehavior hoverBehavior) {
        this.f15971L = hoverBehavior;
        this.f15970K = m19938d();
    }

    private HoverRenderer m19938d() {
        C12355 c12355 = new C12355(this);
        switch (this.f15971L) {
            case CLONE_VIEW:
                return new ViewHoverRenderer(c12355);
            default:
                return new BitmapHoverRenderer(c12355);
        }
    }

    public void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1685295637);
        super.onDetachedFromWindow();
        this.f16000x.m();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1413370713, a);
    }

    private void m19909a(int i, int i2) {
        getAdapterInterface().m19872a(i, i2);
    }

    private int getColumnCount() {
        return getNumColumnsCompat();
    }

    private AbstractDragSortGridAdapter getAdapterInterface() {
        return (AbstractDragSortGridAdapter) getAdapter();
    }

    public static void m19913a(DragSortGridView dragSortGridView, long j) {
        int b = dragSortGridView.m19920b(j);
        for (int firstVisiblePosition = dragSortGridView.getFirstVisiblePosition(); firstVisiblePosition <= dragSortGridView.getLastVisiblePosition(); firstVisiblePosition++) {
            if (b != firstVisiblePosition) {
                dragSortGridView.f15986j.add(Long.valueOf(dragSortGridView.m19905a(firstVisiblePosition)));
            }
        }
    }

    private int m19920b(long j) {
        View c = m19933c(j);
        if (c == null) {
            return -1;
        }
        return getPositionForView(c);
    }

    private View m19933c(long j) {
        int firstVisiblePosition = getFirstVisiblePosition();
        Adapter adapter = getAdapter();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (adapter.getItemId(firstVisiblePosition + i) == j) {
                return childAt;
            }
        }
        return null;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1330461665);
        boolean z = this.f15988l;
        int pointToPosition;
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.f15982f = (int) motionEvent.getX();
                this.f15983g = (int) motionEvent.getY();
                this.f15989m = motionEvent.getPointerId(0);
                if (this.f15995s && isEnabled()) {
                    layoutChildren();
                    this.f15980d = 0;
                    this.f15981e = 0;
                    pointToPosition = pointToPosition(this.f15982f, this.f15983g);
                    View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                    if (childAt != null) {
                        this.f15987k = getAdapter().getItemId(pointToPosition);
                        this.f15970K.mo1220a(childAt);
                        if (m19956h()) {
                            childAt.setVisibility(4);
                        }
                        this.f15988l = true;
                        this.f15987k = this.f15987k;
                        break;
                    }
                    LogUtils.a(-422118071, a);
                    return false;
                } else if (!isEnabled()) {
                    LogUtils.a(-136557405, a);
                    return false;
                }
                break;
            case 1:
                m19947f(this);
                if (this.f15996t != null && z) {
                    this.f15996t.m19903a();
                    break;
                }
            case 2:
                if (this.f15989m != -1) {
                    pointToPosition = motionEvent.findPointerIndex(this.f15989m);
                    this.f15984h = (int) motionEvent.getY(pointToPosition);
                    this.f15985i = (int) motionEvent.getX(pointToPosition);
                    pointToPosition = this.f15984h - this.f15983g;
                    int i = this.f15985i - this.f15982f;
                    if (this.f15988l) {
                        this.f15970K.mo1218a(i + this.f15981e, pointToPosition + this.f15980d);
                        invalidate();
                        m19960j(this);
                        this.f15990n = false;
                        this.f16000x;
                        LogUtils.a(901757100, a);
                        return false;
                    }
                }
                break;
            case 3:
                m19958i();
                if (this.f15996t != null && z) {
                    this.f15996t.m19903a();
                    break;
                }
            case 6:
                if (motionEvent.getPointerId(MotionEventCompat.b(motionEvent)) == this.f15989m) {
                    m19947f(this);
                    break;
                }
                break;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        LogUtils.a(-794015937, a);
        return onTouchEvent;
    }

    public static void m19944e(DragSortGridView dragSortGridView) {
        dragSortGridView.f15990n = dragSortGridView.m19918a(dragSortGridView.f15970K.mo1225d());
    }

    private boolean m19918a(Rect rect) {
        int computeVerticalScrollOffset = computeVerticalScrollOffset();
        int height = getHeight();
        int computeVerticalScrollExtent = computeVerticalScrollExtent();
        int computeVerticalScrollRange = computeVerticalScrollRange();
        int i = rect.top;
        int height2 = rect.height();
        if (i <= 0 && computeVerticalScrollOffset > 0) {
            smoothScrollBy(-this.f15991o, 0);
            return true;
        } else if (i + height2 < height || computeVerticalScrollOffset + computeVerticalScrollExtent >= computeVerticalScrollRange) {
            return false;
        } else {
            smoothScrollBy(this.f15991o, 0);
            return true;
        }
    }

    public static void m19947f(DragSortGridView dragSortGridView) {
        View c = dragSortGridView.m19933c(dragSortGridView.f15987k);
        if (dragSortGridView.f15988l || dragSortGridView.f15992p) {
            dragSortGridView.f15988l = false;
            dragSortGridView.f15992p = false;
            dragSortGridView.f15990n = false;
            dragSortGridView.f15989m = -1;
            dragSortGridView.f16000x.l();
            dragSortGridView.f16001y = true;
            if (dragSortGridView.f15993q != 0) {
                dragSortGridView.f15992p = true;
                return;
            } else {
                dragSortGridView.f15970K.mo1223b(c);
                return;
            }
        }
        dragSortGridView.m19958i();
    }

    private void m19911a(View view) {
        this.f15986j.clear();
        this.f15987k = -1;
        view.setVisibility(0);
        this.f15970K.mo1222b();
        invalidate();
    }

    public static void m19951g(DragSortGridView dragSortGridView) {
        boolean z = (dragSortGridView.f15998v || dragSortGridView.f15999w) ? false : true;
        dragSortGridView.setEnabled(z);
    }

    private static boolean m19956h() {
        return VERSION.SDK_INT >= 11;
    }

    private void m19958i() {
        View c = m19933c(this.f15987k);
        if (this.f15988l) {
            m19911a(c);
        }
        this.f15988l = false;
        this.f15990n = false;
        this.f15989m = -1;
    }

    public static void m19960j(DragSortGridView dragSortGridView) {
        final int i = dragSortGridView.f15984h - dragSortGridView.f15983g;
        final int i2 = dragSortGridView.f15985i - dragSortGridView.f15982f;
        int centerY = (dragSortGridView.f15970K.mo1224c().centerY() + dragSortGridView.f15980d) + i;
        int centerX = (dragSortGridView.f15970K.mo1224c().centerX() + dragSortGridView.f15981e) + i2;
        View c = dragSortGridView.m19933c(dragSortGridView.f15987k);
        View view = null;
        float f = 0.0f;
        float f2 = 0.0f;
        Point b = dragSortGridView.m19923b(c);
        for (Long longValue : dragSortGridView.f15986j) {
            float abs;
            View view2;
            View c2 = dragSortGridView.m19933c(longValue.longValue());
            if (c2 != null) {
                Point b2 = dragSortGridView.m19923b(c2);
                if ((m19940d(b2, b) && centerY < c2.getBottom() && centerX > c2.getLeft()) || ((m19934c(b2, b) && centerY < c2.getBottom() && centerX < c2.getRight()) || ((m19927b(b2, b) && centerY > c2.getTop() && centerX > c2.getLeft()) || ((m19917a(b2, b) && centerY > c2.getTop() && centerX < c2.getRight()) || ((m19945e(b2, b) && centerY < c2.getBottom()) || ((m19948f(b2, b) && centerY > c2.getTop()) || ((m19953g(b2, b) && centerX > c2.getLeft()) || (m19957h(b2, b) && centerX < c2.getRight())))))))) {
                    float abs2 = Math.abs(m19929c(c2) - m19929c(c));
                    abs = Math.abs(m19936d(c2) - m19936d(c));
                    if (abs2 >= f && abs >= f2) {
                        f2 = abs2;
                        view2 = c2;
                        view = view2;
                        f = f2;
                        f2 = abs;
                    }
                }
            }
            abs = f2;
            f2 = f;
            view2 = view;
            view = view2;
            f = f2;
            f2 = abs;
        }
        if (view != null) {
            final int positionForView = dragSortGridView.getPositionForView(c);
            final int positionForView2 = dragSortGridView.getPositionForView(view);
            if (positionForView2 == -1 || positionForView2 >= dragSortGridView.getAdapterInterface().m19871a()) {
                dragSortGridView.f15987k = dragSortGridView.f15987k;
                return;
            }
            dragSortGridView.m19909a(positionForView, positionForView2);
            dragSortGridView.f15983g = dragSortGridView.f15984h;
            dragSortGridView.f15982f = dragSortGridView.f15985i;
            c.setVisibility(0);
            if (m19956h()) {
                view.setVisibility(4);
            }
            dragSortGridView.f15987k = dragSortGridView.f15987k;
            final ViewTreeObserver viewTreeObserver = dragSortGridView.getViewTreeObserver();
            if (!m19956h() || viewTreeObserver == null) {
                dragSortGridView.f15980d += i;
                dragSortGridView.f15981e += i2;
                return;
            }
            viewTreeObserver.addOnPreDrawListener(new OnPreDrawListener(dragSortGridView) {
                final /* synthetic */ DragSortGridView f15949f;

                public boolean onPreDraw() {
                    viewTreeObserver.removeOnPreDrawListener(this);
                    DragSortGridView.m19942e(this.f15949f, i);
                    DragSortGridView.m19946f(this.f15949f, i2);
                    DragSortGridView.m19925b(this.f15949f, positionForView, positionForView2);
                    return true;
                }
            });
        }
    }

    private static boolean m19917a(Point point, Point point2) {
        return point.y > point2.y && point.x < point2.x;
    }

    private static boolean m19927b(Point point, Point point2) {
        return point.y > point2.y && point.x > point2.x;
    }

    private static boolean m19934c(Point point, Point point2) {
        return point.y < point2.y && point.x < point2.x;
    }

    private static boolean m19940d(Point point, Point point2) {
        return point.y < point2.y && point.x > point2.x;
    }

    private static boolean m19945e(Point point, Point point2) {
        return point.y < point2.y && point.x == point2.x;
    }

    private static boolean m19948f(Point point, Point point2) {
        return point.y > point2.y && point.x == point2.x;
    }

    private static boolean m19953g(Point point, Point point2) {
        return point.y == point2.y && point.x > point2.x;
    }

    private static boolean m19957h(Point point, Point point2) {
        return point.y == point2.y && point.x < point2.x;
    }

    private Point m19923b(View view) {
        int positionForView = getPositionForView(view);
        int numColumnsCompat = getNumColumnsCompat();
        return new Point(positionForView % numColumnsCompat, positionForView / numColumnsCompat);
    }

    private long m19905a(int i) {
        return getAdapter().getItemId(i);
    }

    private static float m19929c(View view) {
        return (float) Math.abs((view.getRight() - view.getLeft()) / 2);
    }

    private static float m19936d(View view) {
        return (float) Math.abs((view.getBottom() - view.getTop()) / 2);
    }

    private int getNumColumnsCompat() {
        int i = 0;
        if (m19956h()) {
            return getNumColumnsCompat11();
        }
        if (getChildCount() > 0) {
            int measuredWidth = getChildAt(0).getMeasuredWidth();
            if (measuredWidth > 0) {
                i = getWidth() / measuredWidth;
            }
        }
        return i <= 0 ? -1 : i;
    }

    @TargetApi(11)
    private int getNumColumnsCompat11() {
        return getNumColumns();
    }

    @TargetApi(11)
    public static void m19925b(DragSortGridView dragSortGridView, int i, int i2) {
        Object obj = i2 > i ? 1 : null;
        Collection b = Lists.b();
        int min;
        View c;
        if (obj != null) {
            for (min = Math.min(i, i2); min < Math.max(i, i2); min++) {
                c = dragSortGridView.m19933c(dragSortGridView.m19905a(min));
                if ((min + 1) % dragSortGridView.getNumColumnsCompat() == 0) {
                    b.add(m19907a(c, (float) ((-c.getWidth()) * (dragSortGridView.getNumColumnsCompat() - 1)), 0.0f, (float) c.getHeight(), 0.0f));
                } else {
                    b.add(m19907a(c, (float) c.getWidth(), 0.0f, 0.0f, 0.0f));
                }
            }
        } else {
            for (min = Math.max(i, i2); min > Math.min(i, i2); min--) {
                c = dragSortGridView.m19933c(dragSortGridView.m19905a(min));
                if ((dragSortGridView.getNumColumnsCompat() + min) % dragSortGridView.getNumColumnsCompat() == 0) {
                    b.add(m19907a(c, (float) (c.getWidth() * (dragSortGridView.getNumColumnsCompat() - 1)), 0.0f, (float) (-c.getHeight()), 0.0f));
                } else {
                    b.add(m19907a(c, (float) (-c.getWidth()), 0.0f, 0.0f, 0.0f));
                }
            }
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(b);
        animatorSet.setDuration(300);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.addListener(new C12377(dragSortGridView));
        animatorSet.start();
    }

    @TargetApi(11)
    private static AnimatorSet m19907a(View view, float f, float f2, float f3, float f4) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", new float[]{f, f2});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "translationY", new float[]{f3, f4});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        return animatorSet;
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        this.f15970K.mo1219a(canvas);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f15966G != getMeasuredWidth() && this.f15964E > 0) {
            setPadding(0, getPaddingTop(), 0, getPaddingBottom());
            setColumnWidth(this.f15965F);
            setNumColumns(-1);
            setStretchMode(0);
            super.onMeasure(i, i2);
            int measuredWidth;
            if (getNumColumnsCompat() < this.f15964E) {
                setNumColumns(this.f15964E);
                setStretchMode(2);
                if (!m19956h() && getNumColumnsCompat() == -1) {
                    measuredWidth = getMeasuredWidth() - ((this.f15965F * this.f15964E) + (getRequestedHorizontalSpacing() * (this.f15964E - 1)));
                    if (measuredWidth > 0) {
                        measuredWidth /= 2;
                        setPadding(measuredWidth, getPaddingTop(), measuredWidth, getPaddingBottom());
                    }
                }
                super.onMeasure(i, i2);
            } else if (this.f15966G != getMeasuredWidth()) {
                measuredWidth = (getMeasuredWidth() - ((this.f15965F * getNumColumnsCompat()) + (getRequestedHorizontalSpacing() * (getNumColumnsCompat() - 1)))) / 2;
                setPadding(measuredWidth, getPaddingTop(), measuredWidth, getPaddingBottom());
                super.onMeasure(i, i2);
            }
        }
        this.f15966G = getMeasuredWidth();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f15979c.a();
    }

    public void setOnDrawListenerTo(OnDrawListener onDrawListener) {
        this.f15979c.b(onDrawListener);
    }

    public void setHorizontalSpacing(int i) {
        this.f15967H = i;
        super.setHorizontalSpacing(i);
    }

    public int getRequestedHorizontalSpacing() {
        return this.f15967H;
    }

    public static void m19963k(DragSortGridView dragSortGridView) {
        long now = dragSortGridView.f15962C.now();
        if (dragSortGridView.f15960A != 0) {
            long j = dragSortGridView.f15994r + 3000;
            if (now >= j) {
                dragSortGridView.f15981e = 0;
                return;
            }
            dragSortGridView.postDelayed(dragSortGridView.f15963D, j - now);
        }
    }

    public static void m19924b(DragSortGridView dragSortGridView, int i) {
        if (i != dragSortGridView.f15960A) {
            dragSortGridView.f15960A = i;
            if (i == 0) {
                dragSortGridView.f15961B.b(dragSortGridView);
                return;
            }
            dragSortGridView.f15961B.a(dragSortGridView);
            dragSortGridView.postDelayed(dragSortGridView.f15963D, 3000);
        }
    }
}

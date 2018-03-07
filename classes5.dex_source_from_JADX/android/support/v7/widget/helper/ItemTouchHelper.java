package android.support.v7.widget.helper;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.animation.AnimatorCompatHelper;
import android.support.v4.animation.AnimatorListenerCompat;
import android.support.v4.animation.AnimatorUpdateListenerCompat;
import android.support.v4.animation.ValueAnimatorCompat;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView$ChildDrawingOrderCallback;
import android.support.v7.widget.RecyclerView$OnChildAttachStateChangeListener;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.List;

/* compiled from: treehouse_home */
public class ItemTouchHelper extends ItemDecoration implements RecyclerView$OnChildAttachStateChangeListener {
    private long f1624A;
    final List<View> f1625a = new ArrayList();
    ViewHolder f1626b = null;
    float f1627c;
    float f1628d;
    float f1629e;
    float f1630f;
    float f1631g;
    float f1632h;
    int f1633i = -1;
    Callback f1634j;
    int f1635k = 0;
    int f1636l;
    public List<RecoverAnimation> f1637m = new ArrayList();
    private final float[] f1638n = new float[2];
    public int f1639o;
    public RecyclerView f1640p;
    public final Runnable f1641q = new C00881(this);
    public VelocityTracker f1642r;
    private List<ViewHolder> f1643s;
    private List<Integer> f1644t;
    private RecyclerView$ChildDrawingOrderCallback f1645u = null;
    public View f1646v = null;
    public int f1647w = -1;
    public GestureDetectorCompat f1648x;
    public final OnItemTouchListener f1649y = new C00892(this);
    private Rect f1650z;

    /* compiled from: treehouse_home */
    class C00881 implements Runnable {
        final /* synthetic */ ItemTouchHelper f1593a;

        C00881(ItemTouchHelper itemTouchHelper) {
            this.f1593a = itemTouchHelper;
        }

        public void run() {
            if (this.f1593a.f1626b != null && ItemTouchHelper.m2208e(this.f1593a)) {
                if (this.f1593a.f1626b != null) {
                    ItemTouchHelper.m2204b(this.f1593a, this.f1593a.f1626b);
                }
                this.f1593a.f1640p.removeCallbacks(this.f1593a.f1641q);
                ViewCompat.a(this.f1593a.f1640p, this);
            }
        }
    }

    /* compiled from: treehouse_home */
    class C00892 implements OnItemTouchListener {
        final /* synthetic */ ItemTouchHelper f1594a;

        C00892(ItemTouchHelper itemTouchHelper) {
            this.f1594a = itemTouchHelper;
        }

        public final boolean m2161a(MotionEvent motionEvent) {
            this.f1594a.f1648x.a(motionEvent);
            int a = MotionEventCompat.a(motionEvent);
            if (a == 0) {
                this.f1594a.f1633i = MotionEventCompat.b(motionEvent, 0);
                this.f1594a.f1627c = motionEvent.getX();
                this.f1594a.f1628d = motionEvent.getY();
                ItemTouchHelper itemTouchHelper = this.f1594a;
                if (itemTouchHelper.f1642r != null) {
                    itemTouchHelper.f1642r.recycle();
                }
                itemTouchHelper.f1642r = VelocityTracker.obtain();
                if (this.f1594a.f1626b == null) {
                    RecoverAnimation recoverAnimation;
                    itemTouchHelper = this.f1594a;
                    if (itemTouchHelper.f1637m.isEmpty()) {
                        recoverAnimation = null;
                    } else {
                        View b = ItemTouchHelper.m2202b(itemTouchHelper, motionEvent);
                        for (int size = itemTouchHelper.f1637m.size() - 1; size >= 0; size--) {
                            recoverAnimation = (RecoverAnimation) itemTouchHelper.f1637m.get(size);
                            if (recoverAnimation.f1602h.a == b) {
                                break;
                            }
                        }
                        recoverAnimation = null;
                    }
                    RecoverAnimation recoverAnimation2 = recoverAnimation;
                    if (recoverAnimation2 != null) {
                        ItemTouchHelper itemTouchHelper2 = this.f1594a;
                        itemTouchHelper2.f1627c -= recoverAnimation2.f1605k;
                        itemTouchHelper2 = this.f1594a;
                        itemTouchHelper2.f1628d -= recoverAnimation2.f1606l;
                        ItemTouchHelper.m2193a(this.f1594a, recoverAnimation2.f1602h, true);
                        if (this.f1594a.f1625a.remove(recoverAnimation2.f1602h.a)) {
                            this.f1594a.f1634j.m2188b(this.f1594a.f1640p, recoverAnimation2.f1602h);
                        }
                        ItemTouchHelper.m2196a(this.f1594a, recoverAnimation2.f1602h, recoverAnimation2.f1603i);
                        ItemTouchHelper.m2197a(this.f1594a, motionEvent, this.f1594a.f1636l, 0);
                    }
                }
            } else if (a == 3 || a == 1) {
                this.f1594a.f1633i = -1;
                ItemTouchHelper.m2196a(this.f1594a, null, 0);
            } else if (this.f1594a.f1633i != -1) {
                int a2 = MotionEventCompat.a(motionEvent, this.f1594a.f1633i);
                if (a2 >= 0) {
                    ItemTouchHelper.m2199a(this.f1594a, a, motionEvent, a2);
                }
            }
            if (this.f1594a.f1642r != null) {
                this.f1594a.f1642r.addMovement(motionEvent);
            }
            if (this.f1594a.f1626b != null) {
                return true;
            }
            return false;
        }

        public final void m2162b(MotionEvent motionEvent) {
            int i = 0;
            this.f1594a.f1648x.a(motionEvent);
            if (this.f1594a.f1642r != null) {
                this.f1594a.f1642r.addMovement(motionEvent);
            }
            if (this.f1594a.f1633i != -1) {
                int a = MotionEventCompat.a(motionEvent);
                int a2 = MotionEventCompat.a(motionEvent, this.f1594a.f1633i);
                if (a2 >= 0) {
                    ItemTouchHelper.m2199a(this.f1594a, a, motionEvent, a2);
                }
                ViewHolder viewHolder = this.f1594a.f1626b;
                if (viewHolder != null) {
                    switch (a) {
                        case 1:
                        case 3:
                            if (this.f1594a.f1642r != null) {
                                this.f1594a.f1642r.computeCurrentVelocity(1000, (float) this.f1594a.f1640p.V);
                            }
                            ItemTouchHelper.m2196a(this.f1594a, null, 0);
                            this.f1594a.f1633i = -1;
                            return;
                        case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                            if (a2 >= 0) {
                                ItemTouchHelper.m2197a(this.f1594a, motionEvent, this.f1594a.f1636l, a2);
                                ItemTouchHelper.m2204b(this.f1594a, viewHolder);
                                this.f1594a.f1640p.removeCallbacks(this.f1594a.f1641q);
                                this.f1594a.f1641q.run();
                                this.f1594a.f1640p.invalidate();
                                return;
                            }
                            return;
                        case 6:
                            a = MotionEventCompat.b(motionEvent);
                            if (MotionEventCompat.b(motionEvent, a) == this.f1594a.f1633i) {
                                if (this.f1594a.f1642r != null) {
                                    this.f1594a.f1642r.computeCurrentVelocity(1000, (float) this.f1594a.f1640p.V);
                                }
                                if (a == 0) {
                                    i = 1;
                                }
                                this.f1594a.f1633i = MotionEventCompat.b(motionEvent, i);
                                ItemTouchHelper.m2197a(this.f1594a, motionEvent, this.f1594a.f1636l, a);
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
            }
        }

        public final void m2160a(boolean z) {
            if (z) {
                ItemTouchHelper.m2196a(this.f1594a, null, 0);
            }
        }
    }

    /* compiled from: treehouse_home */
    public class RecoverAnimation implements AnimatorListenerCompat {
        public final ValueAnimatorCompat f1595a;
        public final int f1596b;
        public boolean f1597c = false;
        final float f1598d;
        final float f1599e;
        final float f1600f;
        final float f1601g;
        public final ViewHolder f1602h;
        final int f1603i;
        public boolean f1604j;
        float f1605k;
        float f1606l;
        boolean f1607m = false;
        final /* synthetic */ ItemTouchHelper f1608n;
        public float f1609o;

        public RecoverAnimation(final ItemTouchHelper itemTouchHelper, ViewHolder viewHolder, int i, int i2, float f, float f2, float f3, float f4) {
            this.f1608n = itemTouchHelper;
            this.f1603i = i2;
            this.f1596b = i;
            this.f1602h = viewHolder;
            this.f1598d = f;
            this.f1599e = f2;
            this.f1600f = f3;
            this.f1601g = f4;
            this.f1595a = AnimatorCompatHelper.f1a.mo8a();
            this.f1595a.mo4a(new AnimatorUpdateListenerCompat(this) {
                final /* synthetic */ RecoverAnimation f1623b;

                public final void mo457a(ValueAnimatorCompat valueAnimatorCompat) {
                    this.f1623b.f1609o = valueAnimatorCompat.mo7c();
                }
            });
            this.f1595a.mo5a(viewHolder.a);
            this.f1595a.mo3a((AnimatorListenerCompat) this);
            this.f1609o = 0.0f;
        }

        public final void m2165b() {
            this.f1602h.a(false);
            this.f1595a.mo1a();
        }

        public final void m2166d() {
            if (this.f1598d == this.f1600f) {
                this.f1605k = ViewCompat.p(this.f1602h.a);
            } else {
                this.f1605k = this.f1598d + (this.f1609o * (this.f1600f - this.f1598d));
            }
            if (this.f1599e == this.f1601g) {
                this.f1606l = ViewCompat.q(this.f1602h.a);
            } else {
                this.f1606l = this.f1599e + (this.f1609o * (this.f1601g - this.f1599e));
            }
        }

        public void mo455a(ValueAnimatorCompat valueAnimatorCompat) {
            this.f1597c = true;
        }

        public final void mo454a() {
            this.f1609o = 1.0f;
        }
    }

    /* compiled from: treehouse_home */
    public class C00914 implements Runnable {
        final /* synthetic */ RecoverAnimation f1613a;
        final /* synthetic */ int f1614b;
        final /* synthetic */ ItemTouchHelper f1615c;

        public C00914(ItemTouchHelper itemTouchHelper, RecoverAnimation recoverAnimation, int i) {
            this.f1615c = itemTouchHelper;
            this.f1613a = recoverAnimation;
            this.f1614b = i;
        }

        public void run() {
            if (this.f1615c.f1640p != null && this.f1615c.f1640p.isAttachedToWindow() && !this.f1613a.f1607m && this.f1613a.f1602h.e() != -1) {
                ItemAnimator itemAnimator = this.f1615c.f1640p.d;
                if (itemAnimator == null || !itemAnimator.a(null)) {
                    Object obj;
                    ItemTouchHelper itemTouchHelper = this.f1615c;
                    int size = itemTouchHelper.f1637m.size();
                    for (int i = 0; i < size; i++) {
                        if (!((RecoverAnimation) itemTouchHelper.f1637m.get(i)).f1597c) {
                            obj = 1;
                            break;
                        }
                    }
                    obj = null;
                    if (obj == null) {
                        this.f1615c.f1634j.m2191f();
                        return;
                    }
                }
                this.f1615c.f1640p.post(this);
            }
        }
    }

    /* compiled from: treehouse_home */
    class C00925 implements RecyclerView$ChildDrawingOrderCallback {
        final /* synthetic */ ItemTouchHelper f1616a;

        C00925(ItemTouchHelper itemTouchHelper) {
            this.f1616a = itemTouchHelper;
        }

        public final int mo456a(int i, int i2) {
            if (this.f1616a.f1646v == null) {
                return i2;
            }
            int i3 = this.f1616a.f1647w;
            if (i3 == -1) {
                i3 = this.f1616a.f1640p.indexOfChild(this.f1616a.f1646v);
                this.f1616a.f1647w = i3;
            }
            if (i2 == i - 1) {
                return i3;
            }
            return i2 >= i3 ? i2 + 1 : i2;
        }
    }

    /* compiled from: treehouse_home */
    public abstract class Callback {
        private static final ItemTouchUIUtil f1617a;
        private static final Interpolator f1618b = new C00931();
        private static final Interpolator f1619c = new C00942();
        public int f1620d = -1;

        /* compiled from: treehouse_home */
        final class C00931 implements Interpolator {
            C00931() {
            }

            public final float getInterpolation(float f) {
                return (((f * f) * f) * f) * f;
            }
        }

        /* compiled from: treehouse_home */
        final class C00942 implements Interpolator {
            C00942() {
            }

            public final float getInterpolation(float f) {
                float f2 = f - 1.0f;
                return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
            }
        }

        public abstract int m2182a(ViewHolder viewHolder);

        public abstract boolean m2187a(ViewHolder viewHolder, ViewHolder viewHolder2);

        public abstract void m2191f();

        static {
            if (VERSION.SDK_INT >= 21) {
                f1617a = new Lollipop();
            } else if (VERSION.SDK_INT >= 11) {
                f1617a = new Honeycomb();
            } else {
                f1617a = new Gingerbread();
            }
        }

        public static int m2169a(int i, int i2) {
            int i3 = i & 789516;
            if (i3 == 0) {
                return i;
            }
            int i4 = (i3 ^ -1) & i;
            if (i2 == 0) {
                return i4 | (i3 << 2);
            }
            return (i4 | ((i3 << 1) & -789517)) | (((i3 << 1) & 789516) << 2);
        }

        public static int m2175b(int i, int i2) {
            return (m2181d(0, i2 | i) | m2181d(1, i2)) | m2181d(2, i);
        }

        private static int m2181d(int i, int i2) {
            return i2 << (i * 8);
        }

        public static int m2180c(int i, int i2) {
            int i3 = i & 3158064;
            if (i3 == 0) {
                return i;
            }
            int i4 = (i3 ^ -1) & i;
            if (i2 == 0) {
                return i4 | (i3 >> 2);
            }
            return (i4 | ((i3 >> 1) & -3158065)) | (((i3 >> 1) & 3158064) >> 2);
        }

        public final int m2184a(RecyclerView recyclerView, ViewHolder viewHolder) {
            return m2180c(m2182a(viewHolder), ViewCompat.h(recyclerView));
        }

        public boolean m2190b(ViewHolder viewHolder) {
            return true;
        }

        public boolean m2189b() {
            return true;
        }

        public static int m2179c() {
            return 0;
        }

        public ViewHolder m2185a(ViewHolder viewHolder, List<ViewHolder> list, int i, int i2) {
            int width = i + viewHolder.a.getWidth();
            int height = i2 + viewHolder.a.getHeight();
            ViewHolder viewHolder2 = null;
            int i3 = -1;
            int left = i - viewHolder.a.getLeft();
            int top = i2 - viewHolder.a.getTop();
            int size = list.size();
            int i4 = 0;
            while (i4 < size) {
                int i5;
                ViewHolder viewHolder3;
                int i6;
                ViewHolder viewHolder4;
                int i7;
                ViewHolder viewHolder5 = (ViewHolder) list.get(i4);
                if (left > 0) {
                    int right = viewHolder5.a.getRight() - width;
                    if (right < 0 && viewHolder5.a.getRight() > viewHolder.a.getRight()) {
                        right = Math.abs(right);
                        if (right > i3) {
                            i5 = right;
                            viewHolder3 = viewHolder5;
                            if (left < 0) {
                                i3 = viewHolder5.a.getLeft() - i;
                                if (i3 > 0 && viewHolder5.a.getLeft() < viewHolder.a.getLeft()) {
                                    i3 = Math.abs(i3);
                                    if (i3 > i5) {
                                        viewHolder3 = viewHolder5;
                                        if (top < 0) {
                                            i5 = viewHolder5.a.getTop() - i2;
                                            if (i5 > 0 && viewHolder5.a.getTop() < viewHolder.a.getTop()) {
                                                i5 = Math.abs(i5);
                                                if (i5 > i3) {
                                                    viewHolder3 = viewHolder5;
                                                    if (top > 0) {
                                                        i3 = viewHolder5.a.getBottom() - height;
                                                        if (i3 < 0 && viewHolder5.a.getBottom() > viewHolder.a.getBottom()) {
                                                            i3 = Math.abs(i3);
                                                            if (i3 > i5) {
                                                                i6 = i3;
                                                                viewHolder4 = viewHolder5;
                                                                i7 = i6;
                                                                i4++;
                                                                viewHolder2 = viewHolder4;
                                                                i3 = i7;
                                                            }
                                                        }
                                                    }
                                                    i7 = i5;
                                                    viewHolder4 = viewHolder3;
                                                    i4++;
                                                    viewHolder2 = viewHolder4;
                                                    i3 = i7;
                                                }
                                            }
                                        }
                                        i5 = i3;
                                        if (top > 0) {
                                            i3 = viewHolder5.a.getBottom() - height;
                                            i3 = Math.abs(i3);
                                            if (i3 > i5) {
                                                i6 = i3;
                                                viewHolder4 = viewHolder5;
                                                i7 = i6;
                                                i4++;
                                                viewHolder2 = viewHolder4;
                                                i3 = i7;
                                            }
                                        }
                                        i7 = i5;
                                        viewHolder4 = viewHolder3;
                                        i4++;
                                        viewHolder2 = viewHolder4;
                                        i3 = i7;
                                    }
                                }
                            }
                            i3 = i5;
                            if (top < 0) {
                                i5 = viewHolder5.a.getTop() - i2;
                                i5 = Math.abs(i5);
                                if (i5 > i3) {
                                    viewHolder3 = viewHolder5;
                                    if (top > 0) {
                                        i3 = viewHolder5.a.getBottom() - height;
                                        i3 = Math.abs(i3);
                                        if (i3 > i5) {
                                            i6 = i3;
                                            viewHolder4 = viewHolder5;
                                            i7 = i6;
                                            i4++;
                                            viewHolder2 = viewHolder4;
                                            i3 = i7;
                                        }
                                    }
                                    i7 = i5;
                                    viewHolder4 = viewHolder3;
                                    i4++;
                                    viewHolder2 = viewHolder4;
                                    i3 = i7;
                                }
                            }
                            i5 = i3;
                            if (top > 0) {
                                i3 = viewHolder5.a.getBottom() - height;
                                i3 = Math.abs(i3);
                                if (i3 > i5) {
                                    i6 = i3;
                                    viewHolder4 = viewHolder5;
                                    i7 = i6;
                                    i4++;
                                    viewHolder2 = viewHolder4;
                                    i3 = i7;
                                }
                            }
                            i7 = i5;
                            viewHolder4 = viewHolder3;
                            i4++;
                            viewHolder2 = viewHolder4;
                            i3 = i7;
                        }
                    }
                }
                viewHolder3 = viewHolder2;
                i5 = i3;
                if (left < 0) {
                    i3 = viewHolder5.a.getLeft() - i;
                    i3 = Math.abs(i3);
                    if (i3 > i5) {
                        viewHolder3 = viewHolder5;
                        if (top < 0) {
                            i5 = viewHolder5.a.getTop() - i2;
                            i5 = Math.abs(i5);
                            if (i5 > i3) {
                                viewHolder3 = viewHolder5;
                                if (top > 0) {
                                    i3 = viewHolder5.a.getBottom() - height;
                                    i3 = Math.abs(i3);
                                    if (i3 > i5) {
                                        i6 = i3;
                                        viewHolder4 = viewHolder5;
                                        i7 = i6;
                                        i4++;
                                        viewHolder2 = viewHolder4;
                                        i3 = i7;
                                    }
                                }
                                i7 = i5;
                                viewHolder4 = viewHolder3;
                                i4++;
                                viewHolder2 = viewHolder4;
                                i3 = i7;
                            }
                        }
                        i5 = i3;
                        if (top > 0) {
                            i3 = viewHolder5.a.getBottom() - height;
                            i3 = Math.abs(i3);
                            if (i3 > i5) {
                                i6 = i3;
                                viewHolder4 = viewHolder5;
                                i7 = i6;
                                i4++;
                                viewHolder2 = viewHolder4;
                                i3 = i7;
                            }
                        }
                        i7 = i5;
                        viewHolder4 = viewHolder3;
                        i4++;
                        viewHolder2 = viewHolder4;
                        i3 = i7;
                    }
                }
                i3 = i5;
                if (top < 0) {
                    i5 = viewHolder5.a.getTop() - i2;
                    i5 = Math.abs(i5);
                    if (i5 > i3) {
                        viewHolder3 = viewHolder5;
                        if (top > 0) {
                            i3 = viewHolder5.a.getBottom() - height;
                            i3 = Math.abs(i3);
                            if (i3 > i5) {
                                i6 = i3;
                                viewHolder4 = viewHolder5;
                                i7 = i6;
                                i4++;
                                viewHolder2 = viewHolder4;
                                i3 = i7;
                            }
                        }
                        i7 = i5;
                        viewHolder4 = viewHolder3;
                        i4++;
                        viewHolder2 = viewHolder4;
                        i3 = i7;
                    }
                }
                i5 = i3;
                if (top > 0) {
                    i3 = viewHolder5.a.getBottom() - height;
                    i3 = Math.abs(i3);
                    if (i3 > i5) {
                        i6 = i3;
                        viewHolder4 = viewHolder5;
                        i7 = i6;
                        i4++;
                        viewHolder2 = viewHolder4;
                        i3 = i7;
                    }
                }
                i7 = i5;
                viewHolder4 = viewHolder3;
                i4++;
                viewHolder2 = viewHolder4;
                i3 = i7;
            }
            return viewHolder2;
        }

        public void m2186a(ViewHolder viewHolder, int i) {
            if (viewHolder != null) {
                f1617a.mo462b(viewHolder.a);
            }
        }

        public static void m2173a(RecyclerView recyclerView, ViewHolder viewHolder, ViewHolder viewHolder2, int i, int i2, int i3) {
            LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof ViewDropHandler) {
                ((ViewDropHandler) layoutManager).a(viewHolder.a, viewHolder2.a);
                return;
            }
            if (layoutManager.g()) {
                if (layoutManager.h(viewHolder2.a) <= recyclerView.getPaddingLeft()) {
                    recyclerView.a(i);
                }
                if (layoutManager.j(viewHolder2.a) >= recyclerView.getWidth() - recyclerView.getPaddingRight()) {
                    recyclerView.a(i);
                }
            }
            if (layoutManager.h()) {
                if (layoutManager.i(viewHolder2.a) <= recyclerView.getPaddingTop()) {
                    recyclerView.a(i);
                }
                if (layoutManager.k(viewHolder2.a) >= recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                    recyclerView.a(i);
                }
            }
        }

        private void m2172a(Canvas canvas, RecyclerView recyclerView, ViewHolder viewHolder, List<RecoverAnimation> list, int i, float f, float f2) {
            int i2;
            int size = list.size();
            for (i2 = 0; i2 < size; i2++) {
                RecoverAnimation recoverAnimation = (RecoverAnimation) list.get(i2);
                recoverAnimation.m2166d();
                int save = canvas.save();
                m2171a(canvas, recyclerView, recoverAnimation.f1602h, recoverAnimation.f1605k, recoverAnimation.f1606l, recoverAnimation.f1603i, false);
                canvas.restoreToCount(save);
            }
            if (viewHolder != null) {
                i2 = canvas.save();
                m2171a(canvas, recyclerView, viewHolder, f, f2, i, true);
                canvas.restoreToCount(i2);
            }
        }

        private void m2177b(Canvas canvas, RecyclerView recyclerView, ViewHolder viewHolder, List<RecoverAnimation> list, int i, float f, float f2) {
            int i2;
            int size = list.size();
            for (i2 = 0; i2 < size; i2++) {
                RecoverAnimation recoverAnimation = (RecoverAnimation) list.get(i2);
                int save = canvas.save();
                m2176b(canvas, recyclerView, recoverAnimation.f1602h, recoverAnimation.f1605k, recoverAnimation.f1606l, recoverAnimation.f1603i, false);
                canvas.restoreToCount(save);
            }
            if (viewHolder != null) {
                i2 = canvas.save();
                m2176b(canvas, recyclerView, viewHolder, f, f2, i, true);
                canvas.restoreToCount(i2);
            }
            Object obj = null;
            int i3 = size - 1;
            while (i3 >= 0) {
                Object obj2;
                recoverAnimation = (RecoverAnimation) list.get(i3);
                if (recoverAnimation.f1597c && !recoverAnimation.f1604j) {
                    list.remove(i3);
                    recoverAnimation.f1602h.a(true);
                    obj2 = obj;
                } else if (recoverAnimation.f1597c) {
                    obj2 = obj;
                } else {
                    obj2 = 1;
                }
                i3--;
                obj = obj2;
            }
            if (obj != null) {
                recyclerView.invalidate();
            }
        }

        public void m2188b(RecyclerView recyclerView, ViewHolder viewHolder) {
            f1617a.mo461a(viewHolder.a);
        }

        private static void m2171a(Canvas canvas, RecyclerView recyclerView, ViewHolder viewHolder, float f, float f2, int i, boolean z) {
            f1617a.mo460a(canvas, recyclerView, viewHolder.a, f, f2, i, z);
        }

        private static void m2176b(Canvas canvas, RecyclerView recyclerView, ViewHolder viewHolder, float f, float f2, int i, boolean z) {
            f1617a.mo459a(canvas, recyclerView, viewHolder.a, f, f2, i);
        }

        public static long m2170a(RecyclerView recyclerView, int i) {
            ItemAnimator itemAnimator = recyclerView.d;
            if (itemAnimator == null) {
                return i == 8 ? 200 : 250;
            } else {
                if (i == 8) {
                    return itemAnimator.e;
                }
                return itemAnimator.d;
            }
        }

        public final int m2183a(RecyclerView recyclerView, int i, int i2, long j) {
            float f = 1.0f;
            if (this.f1620d == -1) {
                this.f1620d = recyclerView.getResources().getDimensionPixelSize(2131428700);
            }
            int signum = (int) (((float) (this.f1620d * ((int) Math.signum((float) i2)))) * f1619c.getInterpolation(Math.min(1.0f, (((float) Math.abs(i2)) * 1.0f) / ((float) i))));
            if (j <= 2000) {
                f = ((float) j) / 2000.0f;
            }
            int interpolation = (int) (f1618b.getInterpolation(f) * ((float) signum));
            if (interpolation == 0) {
                return i2 > 0 ? 1 : -1;
            } else {
                return interpolation;
            }
        }
    }

    /* compiled from: treehouse_home */
    public class ItemTouchHelperGestureListener extends SimpleOnGestureListener {
        final /* synthetic */ ItemTouchHelper f1621a;

        public ItemTouchHelperGestureListener(ItemTouchHelper itemTouchHelper) {
            this.f1621a = itemTouchHelper;
        }

        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public void onLongPress(MotionEvent motionEvent) {
            View b = ItemTouchHelper.m2202b(this.f1621a, motionEvent);
            if (b != null) {
                ViewHolder a = this.f1621a.f1640p.a(b);
                if (a != null) {
                    Object obj;
                    if ((this.f1621a.f1634j.m2184a(this.f1621a.f1640p, a) & 16711680) != 0) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null && MotionEventCompat.b(motionEvent, 0) == this.f1621a.f1633i) {
                        int a2 = MotionEventCompat.a(motionEvent, this.f1621a.f1633i);
                        float c = MotionEventCompat.c(motionEvent, a2);
                        float d = MotionEventCompat.d(motionEvent, a2);
                        this.f1621a.f1627c = c;
                        this.f1621a.f1628d = d;
                        ItemTouchHelper itemTouchHelper = this.f1621a;
                        this.f1621a.f1630f = 0.0f;
                        itemTouchHelper.f1629e = 0.0f;
                        if (1 != 0) {
                            ItemTouchHelper.m2196a(this.f1621a, a, 2);
                        }
                    }
                }
            }
        }
    }

    public ItemTouchHelper(Callback callback) {
        this.f1634j = callback;
    }

    private static boolean m2200a(View view, float f, float f2, float f3, float f4) {
        return f >= f3 && f <= ((float) view.getWidth()) + f3 && f2 >= f4 && f2 <= ((float) view.getHeight()) + f4;
    }

    public final void m2213a(RecyclerView recyclerView) {
        if (this.f1640p != recyclerView) {
            if (this.f1640p != null) {
                m2203b();
            }
            this.f1640p = recyclerView;
            if (this.f1640p != null) {
                this.f1639o = ViewConfiguration.get(this.f1640p.getContext()).getScaledTouchSlop();
                this.f1640p.a(this);
                this.f1640p.a(this.f1649y);
                this.f1640p.a(this);
                if (this.f1648x == null) {
                    this.f1648x = new GestureDetectorCompat(this.f1640p.getContext(), new ItemTouchHelperGestureListener(this));
                }
            }
        }
    }

    private void m2203b() {
        this.f1640p.b(this);
        this.f1640p.b(this.f1649y);
        this.f1640p.b(this);
        for (int size = this.f1637m.size() - 1; size >= 0; size--) {
            this.f1634j.m2188b(this.f1640p, ((RecoverAnimation) this.f1637m.get(0)).f1602h);
        }
        this.f1637m.clear();
        this.f1646v = null;
        this.f1647w = -1;
        m2209g();
    }

    private void m2198a(float[] fArr) {
        if ((this.f1636l & 12) != 0) {
            fArr[0] = (this.f1631g + this.f1629e) - ((float) this.f1626b.a.getLeft());
        } else {
            fArr[0] = ViewCompat.p(this.f1626b.a);
        }
        if ((this.f1636l & 3) != 0) {
            fArr[1] = (this.f1632h + this.f1630f) - ((float) this.f1626b.a.getTop());
        } else {
            fArr[1] = ViewCompat.q(this.f1626b.a);
        }
    }

    public final void m2215b(Canvas canvas, RecyclerView recyclerView, State state) {
        float f;
        float f2 = 0.0f;
        if (this.f1626b != null) {
            m2198a(this.f1638n);
            f = this.f1638n[0];
            f2 = this.f1638n[1];
        } else {
            f = 0.0f;
        }
        this.f1634j.m2177b(canvas, recyclerView, this.f1626b, this.f1637m, this.f1635k, f, f2);
    }

    public final void m2211a(Canvas canvas, RecyclerView recyclerView, State state) {
        float f;
        float f2 = 0.0f;
        this.f1647w = -1;
        if (this.f1626b != null) {
            m2198a(this.f1638n);
            f = this.f1638n[0];
            f2 = this.f1638n[1];
        } else {
            f = 0.0f;
        }
        this.f1634j.m2172a(canvas, recyclerView, this.f1626b, this.f1637m, this.f1635k, f, f2);
    }

    public static void m2196a(ItemTouchHelper itemTouchHelper, ViewHolder viewHolder, int i) {
        if (viewHolder != itemTouchHelper.f1626b || i != itemTouchHelper.f1635k) {
            itemTouchHelper.f1624A = Long.MIN_VALUE;
            int i2 = itemTouchHelper.f1635k;
            m2193a(itemTouchHelper, viewHolder, true);
            itemTouchHelper.f1635k = i;
            if (i == 2) {
                itemTouchHelper.f1646v = viewHolder.a;
                itemTouchHelper.m2210h();
            }
            int i3 = (1 << ((i * 8) + 8)) - 1;
            Object obj = null;
            if (itemTouchHelper.f1626b != null) {
                ViewHolder viewHolder2 = itemTouchHelper.f1626b;
                if (viewHolder2.a.getParent() != null) {
                    float f;
                    float signum;
                    int i4;
                    final int c = i2 == 2 ? 0 : itemTouchHelper.m2206c(viewHolder2);
                    itemTouchHelper.m2209g();
                    switch (c) {
                        case 1:
                        case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                            f = 0.0f;
                            signum = Math.signum(itemTouchHelper.f1630f) * ((float) itemTouchHelper.f1640p.getHeight());
                            break;
                        case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                        case 8:
                        case 16:
                        case 32:
                            signum = 0.0f;
                            f = Math.signum(itemTouchHelper.f1629e) * ((float) itemTouchHelper.f1640p.getWidth());
                            break;
                        default:
                            f = 0.0f;
                            signum = 0.0f;
                            break;
                    }
                    if (i2 == 2) {
                        i4 = 8;
                    } else if (c > 0) {
                        i4 = 2;
                    } else {
                        i4 = 4;
                    }
                    itemTouchHelper.m2198a(itemTouchHelper.f1638n);
                    final ViewHolder viewHolder3 = viewHolder2;
                    RecoverAnimation c00903 = new RecoverAnimation(itemTouchHelper, viewHolder2, i4, i2, itemTouchHelper.f1638n[0], itemTouchHelper.f1638n[1], f, signum) {
                        final /* synthetic */ ItemTouchHelper f1612c;

                        public final void mo455a(ValueAnimatorCompat valueAnimatorCompat) {
                            super.mo455a(valueAnimatorCompat);
                            if (!this.f1607m) {
                                if (c <= 0) {
                                    this.f1612c.f1634j.m2188b(this.f1612c.f1640p, viewHolder3);
                                } else {
                                    this.f1612c.f1625a.add(viewHolder3.a);
                                    this.j = true;
                                    if (c > 0) {
                                        ItemTouchHelper itemTouchHelper = this.f1612c;
                                        itemTouchHelper.f1640p.post(new C00914(itemTouchHelper, this, c));
                                    }
                                }
                                if (this.f1612c.f1646v == viewHolder3.a) {
                                    ItemTouchHelper.m2205b(this.f1612c, viewHolder3.a);
                                }
                            }
                        }
                    };
                    c00903.f1595a.mo2a(Callback.m2170a(itemTouchHelper.f1640p, i4));
                    itemTouchHelper.f1637m.add(c00903);
                    c00903.m2165b();
                    obj = 1;
                } else {
                    m2205b(itemTouchHelper, viewHolder2.a);
                    itemTouchHelper.f1634j.m2188b(itemTouchHelper.f1640p, viewHolder2);
                }
                itemTouchHelper.f1626b = null;
            }
            Object obj2 = obj;
            if (viewHolder != null) {
                itemTouchHelper.f1636l = (itemTouchHelper.f1634j.m2184a(itemTouchHelper.f1640p, viewHolder) & i3) >> (itemTouchHelper.f1635k * 8);
                itemTouchHelper.f1631g = (float) viewHolder.a.getLeft();
                itemTouchHelper.f1632h = (float) viewHolder.a.getTop();
                itemTouchHelper.f1626b = viewHolder;
                if (i == 2) {
                    itemTouchHelper.f1626b.a.performHapticFeedback(0);
                }
            }
            ViewParent parent = itemTouchHelper.f1640p.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(itemTouchHelper.f1626b != null);
            }
            if (obj2 == null) {
                itemTouchHelper.f1640p.getLayoutManager().H();
            }
            itemTouchHelper.f1634j.m2186a(itemTouchHelper.f1626b, itemTouchHelper.f1635k);
            itemTouchHelper.f1640p.invalidate();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m2208e(android.support.v7.widget.helper.ItemTouchHelper r14) {
        /*
        r12 = -9223372036854775808;
        r6 = 0;
        r8 = 0;
        r0 = r14.f1626b;
        if (r0 != 0) goto L_0x000b;
    L_0x0008:
        r14.f1624A = r12;
    L_0x000a:
        return r6;
    L_0x000b:
        r10 = java.lang.System.currentTimeMillis();
        r0 = r14.f1624A;
        r0 = (r0 > r12 ? 1 : (r0 == r12 ? 0 : -1));
        if (r0 != 0) goto L_0x00b9;
    L_0x0015:
        r4 = 0;
    L_0x0017:
        r0 = r14.f1640p;
        r0 = r0.getLayoutManager();
        r1 = r14.f1650z;
        if (r1 != 0) goto L_0x0028;
    L_0x0021:
        r1 = new android.graphics.Rect;
        r1.<init>();
        r14.f1650z = r1;
    L_0x0028:
        r1 = r14.f1626b;
        r1 = r1.a;
        r2 = r14.f1650z;
        r0.a(r1, r2);
        r1 = r0.g();
        if (r1 == 0) goto L_0x00e4;
    L_0x0037:
        r1 = r14.f1631g;
        r2 = r14.f1629e;
        r1 = r1 + r2;
        r1 = (int) r1;
        r2 = r14.f1650z;
        r2 = r2.left;
        r2 = r1 - r2;
        r3 = r14.f1640p;
        r3 = r3.getPaddingLeft();
        r3 = r2 - r3;
        r2 = r14.f1629e;
        r2 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1));
        if (r2 >= 0) goto L_0x00bf;
    L_0x0051:
        if (r3 >= 0) goto L_0x00bf;
    L_0x0053:
        r0 = r0.h();
        if (r0 == 0) goto L_0x010c;
    L_0x0059:
        r0 = r14.f1632h;
        r1 = r14.f1630f;
        r0 = r0 + r1;
        r0 = (int) r0;
        r1 = r14.f1650z;
        r1 = r1.top;
        r1 = r0 - r1;
        r2 = r14.f1640p;
        r2 = r2.getPaddingTop();
        r7 = r1 - r2;
        r1 = r14.f1630f;
        r1 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1));
        if (r1 >= 0) goto L_0x00e7;
    L_0x0073:
        if (r7 >= 0) goto L_0x00e7;
    L_0x0075:
        if (r3 == 0) goto L_0x0115;
    L_0x0077:
        r0 = r14.f1634j;
        r1 = r14.f1640p;
        r2 = r14.f1626b;
        r2 = r2.a;
        r2 = r2.getWidth();
        r8 = r14.f1640p;
        r8.getWidth();
        r3 = r0.m2183a(r1, r2, r3, r4);
        r8 = r3;
    L_0x008d:
        if (r7 == 0) goto L_0x0113;
    L_0x008f:
        r0 = r14.f1634j;
        r1 = r14.f1640p;
        r2 = r14.f1626b;
        r2 = r2.a;
        r2 = r2.getHeight();
        r3 = r14.f1640p;
        r3.getHeight();
        r3 = r7;
        r0 = r0.m2183a(r1, r2, r3, r4);
    L_0x00a5:
        if (r8 != 0) goto L_0x00a9;
    L_0x00a7:
        if (r0 == 0) goto L_0x010f;
    L_0x00a9:
        r2 = r14.f1624A;
        r1 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1));
        if (r1 != 0) goto L_0x00b1;
    L_0x00af:
        r14.f1624A = r10;
    L_0x00b1:
        r1 = r14.f1640p;
        r1.scrollBy(r8, r0);
        r6 = 1;
        goto L_0x000a;
    L_0x00b9:
        r0 = r14.f1624A;
        r4 = r10 - r0;
        goto L_0x0017;
    L_0x00bf:
        r2 = r14.f1629e;
        r2 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1));
        if (r2 <= 0) goto L_0x00e4;
    L_0x00c5:
        r2 = r14.f1626b;
        r2 = r2.a;
        r2 = r2.getWidth();
        r1 = r1 + r2;
        r2 = r14.f1650z;
        r2 = r2.right;
        r1 = r1 + r2;
        r2 = r14.f1640p;
        r2 = r2.getWidth();
        r3 = r14.f1640p;
        r3 = r3.getPaddingRight();
        r2 = r2 - r3;
        r3 = r1 - r2;
        if (r3 > 0) goto L_0x0053;
    L_0x00e4:
        r3 = r6;
        goto L_0x0053;
    L_0x00e7:
        r1 = r14.f1630f;
        r1 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1));
        if (r1 <= 0) goto L_0x010c;
    L_0x00ed:
        r1 = r14.f1626b;
        r1 = r1.a;
        r1 = r1.getHeight();
        r0 = r0 + r1;
        r1 = r14.f1650z;
        r1 = r1.bottom;
        r0 = r0 + r1;
        r1 = r14.f1640p;
        r1 = r1.getHeight();
        r2 = r14.f1640p;
        r2 = r2.getPaddingBottom();
        r1 = r1 - r2;
        r7 = r0 - r1;
        if (r7 > 0) goto L_0x0075;
    L_0x010c:
        r7 = r6;
        goto L_0x0075;
    L_0x010f:
        r14.f1624A = r12;
        goto L_0x000a;
    L_0x0113:
        r0 = r7;
        goto L_0x00a5;
    L_0x0115:
        r8 = r3;
        goto L_0x008d;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.helper.ItemTouchHelper.e(android.support.v7.widget.helper.ItemTouchHelper):boolean");
    }

    private List<ViewHolder> m2195a(ViewHolder viewHolder) {
        if (this.f1643s == null) {
            this.f1643s = new ArrayList();
            this.f1644t = new ArrayList();
        } else {
            this.f1643s.clear();
            this.f1644t.clear();
        }
        int c = Callback.m2179c();
        int round = Math.round(this.f1631g + this.f1629e) - c;
        int round2 = Math.round(this.f1632h + this.f1630f) - c;
        int width = (viewHolder.a.getWidth() + round) + (c * 2);
        int height = (viewHolder.a.getHeight() + round2) + (c * 2);
        int i = (round + width) / 2;
        int i2 = (round2 + height) / 2;
        LayoutManager layoutManager = this.f1640p.getLayoutManager();
        int v = layoutManager.v();
        for (int i3 = 0; i3 < v; i3++) {
            View f = layoutManager.f(i3);
            if (f != viewHolder.a && f.getBottom() >= round2 && f.getTop() <= height && f.getRight() >= round && f.getLeft() <= width) {
                ViewHolder a = this.f1640p.a(f);
                if (this.f1634j.m2190b(a)) {
                    int abs = Math.abs(i - ((f.getLeft() + f.getRight()) / 2));
                    c = Math.abs(i2 - ((f.getBottom() + f.getTop()) / 2));
                    int i4 = (abs * abs) + (c * c);
                    int size = this.f1643s.size();
                    int i5 = 0;
                    abs = 0;
                    while (abs < size && i4 > ((Integer) this.f1644t.get(abs)).intValue()) {
                        i5++;
                        abs++;
                    }
                    this.f1643s.add(i5, a);
                    this.f1644t.add(i5, Integer.valueOf(i4));
                }
            }
        }
        return this.f1643s;
    }

    public static void m2204b(ItemTouchHelper itemTouchHelper, ViewHolder viewHolder) {
        if (!itemTouchHelper.f1640p.isLayoutRequested() && itemTouchHelper.f1635k == 2) {
            float f = 0.5f;
            int i = (int) (itemTouchHelper.f1631g + itemTouchHelper.f1629e);
            int i2 = (int) (itemTouchHelper.f1632h + itemTouchHelper.f1630f);
            if (((float) Math.abs(i2 - viewHolder.a.getTop())) >= ((float) viewHolder.a.getHeight()) * f || ((float) Math.abs(i - viewHolder.a.getLeft())) >= f * ((float) viewHolder.a.getWidth())) {
                List a = itemTouchHelper.m2195a(viewHolder);
                if (a.size() != 0) {
                    ViewHolder a2 = itemTouchHelper.f1634j.m2185a(viewHolder, a, i, i2);
                    if (a2 == null) {
                        itemTouchHelper.f1643s.clear();
                        itemTouchHelper.f1644t.clear();
                        return;
                    }
                    int e = a2.e();
                    viewHolder.e();
                    if (itemTouchHelper.f1634j.m2187a(viewHolder, a2)) {
                        Callback.m2173a(itemTouchHelper.f1640p, viewHolder, a2, e, i, i2);
                    }
                }
            }
        }
    }

    public final void mo458a(View view) {
        m2205b(this, view);
        ViewHolder a = this.f1640p.a(view);
        if (a != null) {
            if (this.f1626b == null || a != this.f1626b) {
                m2193a(this, a, false);
                if (this.f1625a.remove(a.a)) {
                    this.f1634j.m2188b(this.f1640p, a);
                    return;
                }
                return;
            }
            m2196a(this, null, 0);
        }
    }

    public static int m2193a(ItemTouchHelper itemTouchHelper, ViewHolder viewHolder, boolean z) {
        for (int size = itemTouchHelper.f1637m.size() - 1; size >= 0; size--) {
            RecoverAnimation recoverAnimation = (RecoverAnimation) itemTouchHelper.f1637m.get(size);
            if (recoverAnimation.f1602h == viewHolder) {
                recoverAnimation.f1607m |= z;
                if (!recoverAnimation.f1597c) {
                    recoverAnimation.f1595a.mo6b();
                }
                itemTouchHelper.f1637m.remove(size);
                recoverAnimation.f1602h.a(true);
                return recoverAnimation.f1596b;
            }
        }
        return 0;
    }

    public final void m2212a(Rect rect, View view, RecyclerView recyclerView, State state) {
        rect.setEmpty();
    }

    private void m2209g() {
        if (this.f1642r != null) {
            this.f1642r.recycle();
            this.f1642r = null;
        }
    }

    private ViewHolder m2194a(MotionEvent motionEvent) {
        LayoutManager layoutManager = this.f1640p.getLayoutManager();
        if (this.f1633i == -1) {
            return null;
        }
        int a = MotionEventCompat.a(motionEvent, this.f1633i);
        float c = MotionEventCompat.c(motionEvent, a) - this.f1627c;
        float d = MotionEventCompat.d(motionEvent, a) - this.f1628d;
        c = Math.abs(c);
        d = Math.abs(d);
        if (c < ((float) this.f1639o) && d < ((float) this.f1639o)) {
            return null;
        }
        if (c > d && layoutManager.g()) {
            return null;
        }
        if (d > c && layoutManager.h()) {
            return null;
        }
        View b = m2202b(this, motionEvent);
        if (b != null) {
            return this.f1640p.a(b);
        }
        return null;
    }

    public static boolean m2199a(ItemTouchHelper itemTouchHelper, int i, MotionEvent motionEvent, int i2) {
        if (itemTouchHelper.f1626b != null || i != 2 || itemTouchHelper.f1635k == 2 || !itemTouchHelper.f1634j.m2189b() || itemTouchHelper.f1640p.M == 1) {
            return false;
        }
        ViewHolder a = itemTouchHelper.m2194a(motionEvent);
        if (a == null) {
            return false;
        }
        int a2 = (itemTouchHelper.f1634j.m2184a(itemTouchHelper.f1640p, a) & 65280) >> 8;
        if (a2 == 0) {
            return false;
        }
        float c = MotionEventCompat.c(motionEvent, i2);
        c -= itemTouchHelper.f1627c;
        float d = MotionEventCompat.d(motionEvent, i2) - itemTouchHelper.f1628d;
        float abs = Math.abs(c);
        float abs2 = Math.abs(d);
        if (abs < ((float) itemTouchHelper.f1639o) && abs2 < ((float) itemTouchHelper.f1639o)) {
            return false;
        }
        if (abs > abs2) {
            if (c < 0.0f && (a2 & 4) == 0) {
                return false;
            }
            if (c > 0.0f && (a2 & 8) == 0) {
                return false;
            }
        } else if (d < 0.0f && (a2 & 1) == 0) {
            return false;
        } else {
            if (d > 0.0f && (a2 & 2) == 0) {
                return false;
            }
        }
        itemTouchHelper.f1630f = 0.0f;
        itemTouchHelper.f1629e = 0.0f;
        itemTouchHelper.f1633i = MotionEventCompat.b(motionEvent, 0);
        m2196a(itemTouchHelper, a, 1);
        return true;
    }

    public static View m2202b(ItemTouchHelper itemTouchHelper, MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (itemTouchHelper.f1626b != null) {
            View view = itemTouchHelper.f1626b.a;
            if (m2200a(view, x, y, itemTouchHelper.f1631g + itemTouchHelper.f1629e, itemTouchHelper.f1632h + itemTouchHelper.f1630f)) {
                return view;
            }
        }
        for (int size = itemTouchHelper.f1637m.size() - 1; size >= 0; size--) {
            RecoverAnimation recoverAnimation = (RecoverAnimation) itemTouchHelper.f1637m.get(size);
            View view2 = recoverAnimation.f1602h.a;
            if (m2200a(view2, x, y, recoverAnimation.f1605k, recoverAnimation.f1606l)) {
                return view2;
            }
        }
        return itemTouchHelper.f1640p.a(x, y);
    }

    public static void m2197a(ItemTouchHelper itemTouchHelper, MotionEvent motionEvent, int i, int i2) {
        float c = MotionEventCompat.c(motionEvent, i2);
        float d = MotionEventCompat.d(motionEvent, i2);
        itemTouchHelper.f1629e = c - itemTouchHelper.f1627c;
        itemTouchHelper.f1630f = d - itemTouchHelper.f1628d;
        if ((i & 4) == 0) {
            itemTouchHelper.f1629e = Math.max(0.0f, itemTouchHelper.f1629e);
        }
        if ((i & 8) == 0) {
            itemTouchHelper.f1629e = Math.min(0.0f, itemTouchHelper.f1629e);
        }
        if ((i & 1) == 0) {
            itemTouchHelper.f1630f = Math.max(0.0f, itemTouchHelper.f1630f);
        }
        if ((i & 2) == 0) {
            itemTouchHelper.f1630f = Math.min(0.0f, itemTouchHelper.f1630f);
        }
    }

    private int m2206c(ViewHolder viewHolder) {
        if (this.f1635k == 2) {
            return 0;
        }
        int a = this.f1634j.m2182a(viewHolder);
        int c = (Callback.m2180c(a, ViewCompat.h(this.f1640p)) & 65280) >> 8;
        if (c == 0) {
            return 0;
        }
        int i = (a & 65280) >> 8;
        if (Math.abs(this.f1629e) > Math.abs(this.f1630f)) {
            a = m2201b(viewHolder, c);
            if (a > 0) {
                return (i & a) == 0 ? Callback.m2169a(a, ViewCompat.h(this.f1640p)) : a;
            } else {
                a = m2207c(viewHolder, c);
                if (a > 0) {
                    return a;
                }
                return 0;
            }
        }
        a = m2207c(viewHolder, c);
        if (a > 0) {
            return a;
        }
        a = m2201b(viewHolder, c);
        if (a > 0) {
            return (i & a) == 0 ? Callback.m2169a(a, ViewCompat.h(this.f1640p)) : a;
        } else {
            return 0;
        }
    }

    private int m2201b(ViewHolder viewHolder, int i) {
        int i2 = 8;
        if ((i & 12) != 0) {
            int i3 = this.f1629e > 0.0f ? 8 : 4;
            if (this.f1642r != null && this.f1633i >= 0) {
                float a = VelocityTrackerCompat.a(this.f1642r, this.f1633i);
                if (a <= 0.0f) {
                    i2 = 4;
                }
                if ((i2 & i) != 0 && i3 == i2 && Math.abs(a) >= ((float) this.f1640p.U)) {
                    return i2;
                }
            }
            float width = ((float) this.f1640p.getWidth()) * 0.5f;
            if ((i & i3) != 0 && Math.abs(this.f1629e) > width) {
                return i3;
            }
        }
        return 0;
    }

    private int m2207c(ViewHolder viewHolder, int i) {
        int i2 = 2;
        if ((i & 3) != 0) {
            int i3 = this.f1630f > 0.0f ? 2 : 1;
            if (this.f1642r != null && this.f1633i >= 0) {
                float b = VelocityTrackerCompat.b(this.f1642r, this.f1633i);
                if (b <= 0.0f) {
                    i2 = 1;
                }
                if ((i2 & i) != 0 && i2 == i3 && Math.abs(b) >= ((float) this.f1640p.U)) {
                    return i2;
                }
            }
            float height = ((float) this.f1640p.getHeight()) * 0.5f;
            if ((i & i3) != 0 && Math.abs(this.f1630f) > height) {
                return i3;
            }
        }
        return 0;
    }

    private void m2210h() {
        if (VERSION.SDK_INT < 21) {
            if (this.f1645u == null) {
                this.f1645u = new C00925(this);
            }
            this.f1640p.setChildDrawingOrderCallback(this.f1645u);
        }
    }

    public static void m2205b(ItemTouchHelper itemTouchHelper, View view) {
        if (view == itemTouchHelper.f1646v) {
            itemTouchHelper.f1646v = null;
            if (itemTouchHelper.f1645u != null) {
                itemTouchHelper.f1640p.setChildDrawingOrderCallback(null);
            }
        }
    }
}

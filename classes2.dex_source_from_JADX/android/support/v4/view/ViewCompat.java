package android.support.v4.view;

import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import java.lang.reflect.Field;
import java.util.WeakHashMap;

/* compiled from: rtc_push_log */
public class ViewCompat {
    public static final ViewCompatImpl f6441a;

    /* compiled from: rtc_push_log */
    class JbMr1ViewCompatImpl extends JBViewCompatImpl {
        public final void mo1527a(View view, Paint paint) {
            view.setLayerPaint(paint);
        }

        public final int mo1530h(View view) {
            return view.getLayoutDirection();
        }

        public final void mo1529e(View view, int i) {
            view.setLayoutDirection(i);
        }

        public final int mo1531n(View view) {
            return view.getPaddingStart();
        }

        public final int mo1532o(View view) {
            return view.getPaddingEnd();
        }

        public final void mo1528b(View view, int i, int i2, int i3, int i4) {
            view.setPaddingRelative(i, i2, i3, i4);
        }

        public final int mo1533x(View view) {
            return view.getWindowSystemUiVisibility();
        }

        public final boolean mo1526D(View view) {
            return view.isPaddingRelative();
        }

        JbMr1ViewCompatImpl() {
        }
    }

    /* compiled from: rtc_push_log */
    class JBViewCompatImpl extends ICSViewCompatImpl {
        public final boolean mo1539c(View view) {
            return view.hasTransientState();
        }

        public final void mo1540d(View view) {
            view.postInvalidateOnAnimation();
        }

        public final void mo1535a(View view, int i, int i2, int i3, int i4) {
            view.postInvalidate(i, i2, i3, i4);
        }

        public final void mo1536a(View view, Runnable runnable) {
            view.postOnAnimation(runnable);
        }

        public final void mo1537a(View view, Runnable runnable, long j) {
            view.postOnAnimationDelayed(runnable, j);
        }

        public final int mo1542e(View view) {
            return view.getImportantForAccessibility();
        }

        public final boolean mo1538a(View view, int i, Bundle bundle) {
            return view.performAccessibilityAction(i, bundle);
        }

        public final ViewParent mo1543i(View view) {
            return view.getParentForAccessibility();
        }

        public final int mo1544u(View view) {
            return view.getMinimumWidth();
        }

        public final int mo1545v(View view) {
            return view.getMinimumHeight();
        }

        public void mo1546y(View view) {
            view.requestFitSystemWindows();
        }

        public final boolean mo1534B(View view) {
            return view.getFitsSystemWindows();
        }

        JBViewCompatImpl() {
        }

        public void mo1541d(View view, int i) {
            if (i == 4) {
                i = 2;
            }
            view.setImportantForAccessibility(i);
        }
    }

    /* compiled from: rtc_push_log */
    class ICSViewCompatImpl extends HCViewCompatImpl {
        static Field f6442b;
        static boolean f6443c = false;

        public final boolean mo1551a(View view, int i) {
            return view.canScrollHorizontally(i);
        }

        public final boolean mo1553b(View view, int i) {
            return view.canScrollVertically(i);
        }

        public final void mo1549a(View view, AccessibilityEvent accessibilityEvent) {
            view.onInitializeAccessibilityEvent(accessibilityEvent);
        }

        public final void mo1550a(View view, boolean z) {
            view.setFitsSystemWindows(z);
        }

        ICSViewCompatImpl() {
        }

        public final void mo1547a(View view, @Nullable AccessibilityDelegateCompat accessibilityDelegateCompat) {
            Object obj;
            if (accessibilityDelegateCompat == null) {
                obj = null;
            } else {
                obj = accessibilityDelegateCompat.f6437a;
            }
            ViewCompatICS.m11167a(view, obj);
        }

        public final boolean mo1552b(View view) {
            if (f6443c) {
                return false;
            }
            if (f6442b == null) {
                try {
                    Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                    f6442b = declaredField;
                    declaredField.setAccessible(true);
                } catch (Throwable th) {
                    f6443c = true;
                    return false;
                }
            }
            try {
                if (f6442b.get(view) != null) {
                    return true;
                }
                return false;
            } catch (Throwable th2) {
                f6443c = true;
                return false;
            }
        }

        public final ViewPropertyAnimatorCompat mo1554w(View view) {
            if (this.f6444a == null) {
                this.a = new WeakHashMap();
            }
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = (ViewPropertyAnimatorCompat) this.f6444a.get(view);
            if (viewPropertyAnimatorCompat != null) {
                return viewPropertyAnimatorCompat;
            }
            viewPropertyAnimatorCompat = new ViewPropertyAnimatorCompat(view);
            this.f6444a.put(view, viewPropertyAnimatorCompat);
            return viewPropertyAnimatorCompat;
        }

        public final void mo1548a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            ViewCompatICS.m11168b(view, accessibilityNodeInfoCompat.b);
        }
    }

    /* compiled from: rtc_push_log */
    class HCViewCompatImpl extends GBViewCompatImpl {
        final long mo1558a() {
            return ValueAnimator.getFrameDelay();
        }

        public final float mo1566f(View view) {
            return view.getAlpha();
        }

        public final void mo1560a(View view, int i, Paint paint) {
            view.setLayerType(i, paint);
        }

        public final int mo1568g(View view) {
            return view.getLayerType();
        }

        public final int mo1557a(int i, int i2, int i3) {
            return View.resolveSizeAndState(i, i2, i3);
        }

        public final int mo1569k(View view) {
            return view.getMeasuredWidthAndState();
        }

        public final int mo1570l(View view) {
            return view.getMeasuredHeightAndState();
        }

        public final int mo1571m(View view) {
            return view.getMeasuredState();
        }

        public final float mo1572p(View view) {
            return view.getTranslationX();
        }

        public final float mo1573q(View view) {
            return view.getTranslationY();
        }

        public final float mo1574r(View view) {
            return view.getRotation();
        }

        public final float mo1575s(View view) {
            return view.getScaleX();
        }

        public final float mo1576t(View view) {
            return view.getScaleY();
        }

        public final void mo1561b(View view, float f) {
            view.setTranslationX(f);
        }

        public final void mo1563c(View view, float f) {
            view.setTranslationY(f);
        }

        public final void mo1564d(View view, float f) {
            view.setAlpha(f);
        }

        public final void mo1559a(View view, float f) {
            view.setRotation(f);
        }

        public final void mo1565e(View view, float f) {
            view.setScaleX(f);
        }

        public final void mo1567f(View view, float f) {
            view.setScaleY(f);
        }

        public final void mo1555C(View view) {
            view.jumpDrawablesToCurrentState();
        }

        public final void mo1562b(View view, boolean z) {
            view.setActivated(z);
        }

        public final int mo1556a(int i, int i2) {
            return View.combineMeasuredStates(i, i2);
        }

        HCViewCompatImpl() {
        }

        public void mo1527a(View view, Paint paint) {
            mo1560a(view, mo1568g(view), paint);
            view.invalidate();
        }
    }

    /* compiled from: rtc_push_log */
    class GBViewCompatImpl extends EclairMr1ViewCompatImpl {
        public final int mo1577a(View view) {
            return view.getOverScrollMode();
        }

        public final void mo1578c(View view, int i) {
            view.setOverScrollMode(i);
        }

        GBViewCompatImpl() {
        }
    }

    /* compiled from: rtc_push_log */
    class EclairMr1ViewCompatImpl extends BaseViewCompatImpl {
        public final boolean mo1580j(View view) {
            return view.isOpaque();
        }

        EclairMr1ViewCompatImpl() {
        }

        public final void mo1579a(ViewGroup viewGroup, boolean z) {
            ViewCompatEclairMr1.m17021a(viewGroup, z);
        }
    }

    /* compiled from: rtc_push_log */
    public class BaseViewCompatImpl implements ViewCompatImpl {
        WeakHashMap<View, ViewPropertyAnimatorCompat> f6444a = null;

        public boolean mo1582F(View view) {
            boolean z = view.getWidth() > 0 && view.getHeight() > 0;
            return z;
        }

        BaseViewCompatImpl() {
        }

        public boolean mo1551a(View view, int i) {
            if (view instanceof ScrollingView) {
                ScrollingView scrollingView = (ScrollingView) view;
                Object obj = null;
                int computeHorizontalScrollOffset = scrollingView.computeHorizontalScrollOffset();
                int computeHorizontalScrollRange = scrollingView.computeHorizontalScrollRange() - scrollingView.computeHorizontalScrollExtent();
                if (computeHorizontalScrollRange != 0) {
                    int i2;
                    if (i < 0) {
                        if (computeHorizontalScrollOffset > 0) {
                            i2 = 1;
                        }
                    } else if (computeHorizontalScrollOffset < computeHorizontalScrollRange - 1) {
                        i2 = 1;
                    }
                }
                if (obj != null) {
                    return true;
                }
            }
            return false;
        }

        public boolean mo1553b(View view, int i) {
            if (view instanceof ScrollingView) {
                ScrollingView scrollingView = (ScrollingView) view;
                Object obj = null;
                int computeVerticalScrollOffset = scrollingView.computeVerticalScrollOffset();
                int computeVerticalScrollRange = scrollingView.computeVerticalScrollRange() - scrollingView.computeVerticalScrollExtent();
                if (computeVerticalScrollRange != 0) {
                    int i2;
                    if (i < 0) {
                        if (computeVerticalScrollOffset > 0) {
                            i2 = 1;
                        }
                    } else if (computeVerticalScrollOffset < computeVerticalScrollRange - 1) {
                        i2 = 1;
                    }
                }
                if (obj != null) {
                    return true;
                }
            }
            return false;
        }

        public int mo1577a(View view) {
            return 2;
        }

        public void mo1578c(View view, int i) {
        }

        public void mo1547a(View view, AccessibilityDelegateCompat accessibilityDelegateCompat) {
        }

        public boolean mo1552b(View view) {
            return false;
        }

        public void mo1549a(View view, AccessibilityEvent accessibilityEvent) {
        }

        public void mo1548a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        }

        public boolean mo1539c(View view) {
            return false;
        }

        public void mo1540d(View view) {
            view.invalidate();
        }

        public void mo1535a(View view, int i, int i2, int i3, int i4) {
            view.invalidate(i, i2, i3, i4);
        }

        public void mo1536a(View view, Runnable runnable) {
            view.postDelayed(runnable, mo1558a());
        }

        public void mo1537a(View view, Runnable runnable, long j) {
            view.postDelayed(runnable, mo1558a() + j);
        }

        long mo1558a() {
            return 10;
        }

        public int mo1542e(View view) {
            return 0;
        }

        public void mo1541d(View view, int i) {
        }

        public boolean mo1538a(View view, int i, Bundle bundle) {
            return false;
        }

        public float mo1566f(View view) {
            return 1.0f;
        }

        public void mo1560a(View view, int i, Paint paint) {
        }

        public int mo1568g(View view) {
            return 0;
        }

        public void mo1527a(View view, Paint paint) {
        }

        public int mo1530h(View view) {
            return 0;
        }

        public void mo1529e(View view, int i) {
        }

        public ViewParent mo1543i(View view) {
            return view.getParent();
        }

        public boolean mo1580j(View view) {
            Drawable background = view.getBackground();
            if (background == null || background.getOpacity() != -1) {
                return false;
            }
            return true;
        }

        public int mo1557a(int i, int i2, int i3) {
            return View.resolveSize(i, i2);
        }

        public int mo1569k(View view) {
            return view.getMeasuredWidth();
        }

        public int mo1570l(View view) {
            return view.getMeasuredHeight();
        }

        public int mo1571m(View view) {
            return 0;
        }

        public void mo1588f(View view, int i) {
        }

        public int mo1531n(View view) {
            return view.getPaddingLeft();
        }

        public int mo1532o(View view) {
            return view.getPaddingRight();
        }

        public void mo1528b(View view, int i, int i2, int i3, int i4) {
            view.setPadding(i, i2, i3, i4);
        }

        public float mo1572p(View view) {
            return 0.0f;
        }

        public float mo1573q(View view) {
            return 0.0f;
        }

        public float mo1574r(View view) {
            return 0.0f;
        }

        public float mo1575s(View view) {
            return 0.0f;
        }

        public float mo1576t(View view) {
            return 0.0f;
        }

        public int mo1544u(View view) {
            return ViewCompatBase.b(view);
        }

        public int mo1545v(View view) {
            return ViewCompatBase.c(view);
        }

        public ViewPropertyAnimatorCompat mo1554w(View view) {
            return new ViewPropertyAnimatorCompat(view);
        }

        public void mo1559a(View view, float f) {
        }

        public void mo1561b(View view, float f) {
        }

        public void mo1563c(View view, float f) {
        }

        public void mo1564d(View view, float f) {
        }

        public void mo1565e(View view, float f) {
        }

        public void mo1567f(View view, float f) {
        }

        public int mo1533x(View view) {
            return 0;
        }

        public void mo1546y(View view) {
        }

        public void mo1589g(View view, float f) {
        }

        public float mo1590z(View view) {
            return 0.0f;
        }

        public float m11037A(View view) {
            return 0.0f;
        }

        public void mo1579a(ViewGroup viewGroup, boolean z) {
        }

        public boolean mo1534B(View view) {
            return false;
        }

        public void mo1550a(View view, boolean z) {
        }

        public void mo1555C(View view) {
        }

        public void mo1586a(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        }

        public WindowInsetsCompat mo1584a(View view, WindowInsetsCompat windowInsetsCompat) {
            return windowInsetsCompat;
        }

        public WindowInsetsCompat mo1587b(View view, WindowInsetsCompat windowInsetsCompat) {
            return windowInsetsCompat;
        }

        public void mo1562b(View view, boolean z) {
        }

        public boolean mo1526D(View view) {
            return false;
        }

        public void mo1585a(View view, ColorStateList colorStateList) {
            ViewCompatBase.a(view, colorStateList);
        }

        public void mo1581E(View view) {
            if (view instanceof NestedScrollingChild) {
                ((NestedScrollingChild) view).stopNestedScroll();
            }
        }

        public int mo1556a(int i, int i2) {
            return i | i2;
        }

        public float mo1583G(View view) {
            return m11037A(view) + mo1590z(view);
        }
    }

    /* compiled from: rtc_push_log */
    public interface ViewCompatImpl {
        boolean mo1534B(View view);

        void mo1555C(View view);

        boolean mo1526D(View view);

        void mo1581E(View view);

        boolean mo1582F(View view);

        float mo1583G(View view);

        int mo1556a(int i, int i2);

        int mo1557a(int i, int i2, int i3);

        int mo1577a(View view);

        WindowInsetsCompat mo1584a(View view, WindowInsetsCompat windowInsetsCompat);

        void mo1559a(View view, float f);

        void mo1535a(View view, int i, int i2, int i3, int i4);

        void mo1560a(View view, int i, Paint paint);

        void mo1585a(View view, ColorStateList colorStateList);

        void mo1527a(View view, Paint paint);

        void mo1547a(View view, @Nullable AccessibilityDelegateCompat accessibilityDelegateCompat);

        void mo1586a(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener);

        void mo1548a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat);

        void mo1549a(View view, AccessibilityEvent accessibilityEvent);

        void mo1536a(View view, Runnable runnable);

        void mo1537a(View view, Runnable runnable, long j);

        void mo1550a(View view, boolean z);

        void mo1579a(ViewGroup viewGroup, boolean z);

        boolean mo1551a(View view, int i);

        boolean mo1538a(View view, int i, Bundle bundle);

        WindowInsetsCompat mo1587b(View view, WindowInsetsCompat windowInsetsCompat);

        void mo1561b(View view, float f);

        void mo1528b(View view, int i, int i2, int i3, int i4);

        void mo1562b(View view, boolean z);

        boolean mo1552b(View view);

        boolean mo1553b(View view, int i);

        void mo1563c(View view, float f);

        void mo1578c(View view, int i);

        boolean mo1539c(View view);

        void mo1540d(View view);

        void mo1564d(View view, float f);

        void mo1541d(View view, int i);

        int mo1542e(View view);

        void mo1565e(View view, float f);

        void mo1529e(View view, int i);

        float mo1566f(View view);

        void mo1567f(View view, float f);

        void mo1588f(View view, int i);

        int mo1568g(View view);

        void mo1589g(View view, float f);

        int mo1530h(View view);

        ViewParent mo1543i(View view);

        boolean mo1580j(View view);

        int mo1569k(View view);

        int mo1570l(View view);

        int mo1571m(View view);

        int mo1531n(View view);

        int mo1532o(View view);

        float mo1572p(View view);

        float mo1573q(View view);

        float mo1574r(View view);

        float mo1575s(View view);

        float mo1576t(View view);

        int mo1544u(View view);

        int mo1545v(View view);

        ViewPropertyAnimatorCompat mo1554w(View view);

        int mo1533x(View view);

        void mo1546y(View view);

        float mo1590z(View view);
    }

    /* compiled from: rtc_push_log */
    class KitKatViewCompatImpl extends JbMr1ViewCompatImpl {
        public final void mo1588f(View view, int i) {
            view.setAccessibilityLiveRegion(i);
        }

        public final boolean mo1582F(View view) {
            return view.isLaidOut();
        }

        public final void mo1541d(View view, int i) {
            view.setImportantForAccessibility(i);
        }

        KitKatViewCompatImpl() {
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f6441a = new LollipopViewCompatImpl();
        } else if (i >= 19) {
            f6441a = new KitKatViewCompatImpl();
        } else if (i >= 17) {
            f6441a = new JbMr1ViewCompatImpl();
        } else if (i >= 16) {
            f6441a = new JBViewCompatImpl();
        } else if (i >= 14) {
            f6441a = new ICSViewCompatImpl();
        } else if (i >= 11) {
            f6441a = new HCViewCompatImpl();
        } else if (i >= 9) {
            f6441a = new GBViewCompatImpl();
        } else if (i >= 7) {
            f6441a = new EclairMr1ViewCompatImpl();
        } else {
            f6441a = new BaseViewCompatImpl();
        }
    }

    public static boolean m10946a(View view, int i) {
        return f6441a.mo1551a(view, i);
    }

    public static boolean m10953b(View view, int i) {
        return f6441a.mo1553b(view, i);
    }

    public static int m10934a(View view) {
        return f6441a.mo1577a(view);
    }

    public static void m10942a(View view, AccessibilityEvent accessibilityEvent) {
        f6441a.mo1549a(view, accessibilityEvent);
    }

    public static void m10941a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        f6441a.mo1548a(view, accessibilityNodeInfoCompat);
    }

    public static void m10939a(View view, AccessibilityDelegateCompat accessibilityDelegateCompat) {
        f6441a.mo1547a(view, accessibilityDelegateCompat);
    }

    public static boolean m10952b(View view) {
        return f6441a.mo1552b(view);
    }

    public static boolean m10955c(View view) {
        return f6441a.mo1539c(view);
    }

    public static void m10956d(View view) {
        f6441a.mo1540d(view);
    }

    public static void m10936a(View view, int i, int i2, int i3, int i4) {
        f6441a.mo1535a(view, i, i2, i3, i4);
    }

    public static void m10943a(View view, Runnable runnable) {
        f6441a.mo1536a(view, runnable);
    }

    public static void m10944a(View view, Runnable runnable, long j) {
        f6441a.mo1537a(view, runnable, j);
    }

    public static int m10959e(View view) {
        return f6441a.mo1542e(view);
    }

    public static void m10958d(View view, int i) {
        f6441a.mo1541d(view, i);
    }

    public static boolean m10947a(View view, int i, Bundle bundle) {
        return f6441a.mo1538a(view, i, bundle);
    }

    public static float m10961f(View view) {
        return f6441a.mo1566f(view);
    }

    public static void m10937a(View view, int i, Paint paint) {
        f6441a.mo1560a(view, i, paint);
    }

    public static int m10964g(View view) {
        return f6441a.mo1568g(view);
    }

    public static int m10967h(View view) {
        return f6441a.mo1530h(view);
    }

    public static int m10933a(int i, int i2, int i3) {
        return f6441a.mo1557a(i, i2, i3);
    }

    public static int m10968k(View view) {
        return f6441a.mo1569k(view);
    }

    public static int m10969m(View view) {
        return f6441a.mo1571m(view);
    }

    public static int m10932a(int i, int i2) {
        return f6441a.mo1556a(i, i2);
    }

    public static void m10963f(View view, int i) {
        f6441a.mo1588f(view, i);
    }

    public static int m10970n(View view) {
        return f6441a.mo1531n(view);
    }

    public static int m10971o(View view) {
        return f6441a.mo1532o(view);
    }

    public static void m10950b(View view, int i, int i2, int i3, int i4) {
        f6441a.mo1528b(view, i, i2, i3, i4);
    }

    public static float m10972p(View view) {
        return f6441a.mo1572p(view);
    }

    public static float m10973q(View view) {
        return f6441a.mo1573q(view);
    }

    public static int m10974r(View view) {
        return f6441a.mo1544u(view);
    }

    public static int m10975s(View view) {
        return f6441a.mo1545v(view);
    }

    public static ViewPropertyAnimatorCompat m10976t(View view) {
        return f6441a.mo1554w(view);
    }

    public static void m10935a(View view, float f) {
        f6441a.mo1561b(view, f);
    }

    public static void m10949b(View view, float f) {
        f6441a.mo1563c(view, f);
    }

    public static void m10954c(View view, float f) {
        f6441a.mo1564d(view, f);
    }

    public static void m10957d(View view, float f) {
        f6441a.mo1559a(view, f);
    }

    public static void m10960e(View view, float f) {
        f6441a.mo1565e(view, f);
    }

    public static void m10962f(View view, float f) {
        f6441a.mo1567f(view, f);
    }

    public static float m10977v(View view) {
        return f6441a.mo1575s(view);
    }

    public static void m10965g(View view, float f) {
        f6441a.mo1589g(view, f);
    }

    public static float m10978x(View view) {
        return f6441a.mo1590z(view);
    }

    public static int m10979y(View view) {
        return f6441a.mo1533x(view);
    }

    public static void m10980z(View view) {
        f6441a.mo1546y(view);
    }

    public static boolean m10929A(View view) {
        return f6441a.mo1534B(view);
    }

    public static void m10945a(View view, boolean z) {
        f6441a.mo1550a(view, z);
    }

    public static void m10940a(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        f6441a.mo1586a(view, onApplyWindowInsetsListener);
    }

    public static WindowInsetsCompat m10948b(View view, WindowInsetsCompat windowInsetsCompat) {
        return f6441a.mo1587b(view, windowInsetsCompat);
    }

    public static void m10951b(View view, boolean z) {
        f6441a.mo1562b(view, z);
    }

    public static void m10938a(View view, ColorStateList colorStateList) {
        f6441a.mo1585a(view, colorStateList);
    }

    public static boolean m10930E(View view) {
        return f6441a.mo1582F(view);
    }

    public static float m10931F(View view) {
        return f6441a.mo1583G(view);
    }

    public static void m10966g(View view, int i) {
        view.offsetTopAndBottom(i);
        if (i != 0 && VERSION.SDK_INT < 11) {
            view.invalidate();
        }
    }
}

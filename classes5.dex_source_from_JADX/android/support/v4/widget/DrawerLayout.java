package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.KeyEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewGroupCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.DrawerLayoutCompatApi21.InsetsListener;
import android.support.v4.widget.ViewDragHelper.Callback;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* compiled from: user_url */
public class DrawerLayout extends ViewGroup implements DrawerLayoutImpl {
    static final DrawerLayoutCompatImpl f448a;
    public static final int[] f449b = new int[]{16842931};
    public static final boolean f450c;
    public CharSequence f451A;
    private Object f452B;
    private boolean f453C;
    private final ChildAccessibilityDelegate f454d;
    private int f455e;
    private int f456f;
    private float f457g;
    private Paint f458h;
    private final ViewDragHelper f459i;
    private final ViewDragHelper f460j;
    private final ViewDragCallback f461k;
    private final ViewDragCallback f462l;
    private int f463m;
    private boolean f464n;
    private boolean f465o;
    private int f466p;
    private int f467q;
    private boolean f468r;
    public boolean f469s;
    public DrawerListener f470t;
    private float f471u;
    private float f472v;
    private Drawable f473w;
    private Drawable f474x;
    private Drawable f475y;
    public CharSequence f476z;

    /* compiled from: user_url */
    public class AccessibilityDelegate extends AccessibilityDelegateCompat {
        final /* synthetic */ DrawerLayout f433b;
        public final Rect f434c = new Rect();

        AccessibilityDelegate(DrawerLayout drawerLayout) {
            this.f433b = drawerLayout;
        }

        public final void m867a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (DrawerLayout.f450c) {
                super.a(view, accessibilityNodeInfoCompat);
            } else {
                AccessibilityNodeInfoCompat c = AccessibilityNodeInfoCompat.m698c(AccessibilityNodeInfoCompat.f379a.mo107a(accessibilityNodeInfoCompat.f380b));
                super.a(view, c);
                AccessibilityNodeInfoCompat.f379a.mo124c(accessibilityNodeInfoCompat.f380b, view);
                ViewParent i = ViewCompat.a.i(view);
                if (i instanceof View) {
                    accessibilityNodeInfoCompat.m714d((View) i);
                }
                Rect rect = this.f434c;
                c.m700a(rect);
                accessibilityNodeInfoCompat.m704b(rect);
                c.m709c(rect);
                accessibilityNodeInfoCompat.m713d(rect);
                accessibilityNodeInfoCompat.m712c(AccessibilityNodeInfoCompat.f379a.mo152r(c.f380b));
                accessibilityNodeInfoCompat.m701a(c.m729l());
                accessibilityNodeInfoCompat.m705b(c.m730m());
                accessibilityNodeInfoCompat.m716d(c.m732o());
                accessibilityNodeInfoCompat.m723h(c.m728k());
                accessibilityNodeInfoCompat.m721f(c.m726i());
                accessibilityNodeInfoCompat.m703a(c.m718d());
                accessibilityNodeInfoCompat.m707b(c.m720e());
                accessibilityNodeInfoCompat.m717d(AccessibilityNodeInfoCompat.f379a.mo153s(c.f380b));
                accessibilityNodeInfoCompat.m719e(c.m724h());
                accessibilityNodeInfoCompat.m722g(c.m727j());
                accessibilityNodeInfoCompat.m699a(c.m708c());
                AccessibilityNodeInfoCompat.f379a.mo151q(c.f380b);
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = viewGroup.getChildAt(i2);
                    if (DrawerLayout.m931m(childAt)) {
                        AccessibilityNodeInfoCompat.f379a.mo110a(accessibilityNodeInfoCompat.f380b, childAt);
                    }
                }
            }
            accessibilityNodeInfoCompat.m705b(DrawerLayout.class.getName());
            accessibilityNodeInfoCompat.m703a(false);
            accessibilityNodeInfoCompat.m707b(false);
        }

        public final void m870d(View view, AccessibilityEvent accessibilityEvent) {
            super.d(view, accessibilityEvent);
            accessibilityEvent.setClassName(DrawerLayout.class.getName());
        }

        public final boolean m869b(View view, AccessibilityEvent accessibilityEvent) {
            if (accessibilityEvent.getEventType() != 32) {
                return super.b(view, accessibilityEvent);
            }
            List text = accessibilityEvent.getText();
            View h = DrawerLayout.m925h(this.f433b);
            if (h != null) {
                CharSequence charSequence;
                int c = this.f433b.m938c(h);
                View view2 = this.f433b;
                int a = GravityCompat.a(c, ViewCompat.h(view2));
                if (a == 3) {
                    charSequence = view2.f476z;
                } else if (a == 5) {
                    charSequence = view2.f451A;
                } else {
                    charSequence = null;
                }
                CharSequence charSequence2 = charSequence;
                if (charSequence2 != null) {
                    text.add(charSequence2);
                }
            }
            return true;
        }

        public final boolean m868a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (DrawerLayout.f450c || DrawerLayout.m931m(view)) {
                return super.a(viewGroup, view, accessibilityEvent);
            }
            return false;
        }
    }

    /* compiled from: user_url */
    final class ChildAccessibilityDelegate extends AccessibilityDelegateCompat {
        final /* synthetic */ DrawerLayout f435b;

        ChildAccessibilityDelegate(DrawerLayout drawerLayout) {
            this.f435b = drawerLayout;
        }

        public final void m871a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.a(view, accessibilityNodeInfoCompat);
            if (!DrawerLayout.m931m(view)) {
                accessibilityNodeInfoCompat.m714d(null);
            }
        }
    }

    /* compiled from: user_url */
    interface DrawerLayoutCompatImpl {
        int mo172a(Object obj);

        Drawable mo173a(Context context);

        void mo174a(View view);

        void mo175a(View view, Object obj, int i);

        void mo176a(MarginLayoutParams marginLayoutParams, Object obj, int i);
    }

    /* compiled from: user_url */
    class DrawerLayoutCompatImplApi21 implements DrawerLayoutCompatImpl {
        public final void mo174a(View view) {
            if (view instanceof DrawerLayoutImpl) {
                view.setOnApplyWindowInsetsListener(new InsetsListener());
                view.setSystemUiVisibility(1280);
            }
        }

        DrawerLayoutCompatImplApi21() {
        }

        public final void mo175a(View view, Object obj, int i) {
            DrawerLayoutCompatApi21.m944a(view, obj, i);
        }

        public final void mo176a(MarginLayoutParams marginLayoutParams, Object obj, int i) {
            DrawerLayoutCompatApi21.m945a(marginLayoutParams, obj, i);
        }

        public final int mo172a(Object obj) {
            return DrawerLayoutCompatApi21.m942a(obj);
        }

        public final Drawable mo173a(Context context) {
            return DrawerLayoutCompatApi21.m943a(context);
        }
    }

    /* compiled from: user_url */
    class DrawerLayoutCompatImplBase implements DrawerLayoutCompatImpl {
        DrawerLayoutCompatImplBase() {
        }

        public final void mo174a(View view) {
        }

        public final void mo175a(View view, Object obj, int i) {
        }

        public final void mo176a(MarginLayoutParams marginLayoutParams, Object obj, int i) {
        }

        public final int mo172a(Object obj) {
            return 0;
        }

        public final Drawable mo173a(Context context) {
            return null;
        }
    }

    /* compiled from: user_url */
    public interface DrawerListener {
        void m887a();

        void m888a(float f);

        void m889a(int i);

        void m890b();
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: user_url */
    @interface EdgeGravity {
    }

    /* compiled from: user_url */
    public class LayoutParams extends MarginLayoutParams {
        public int f436a = 0;
        public float f437b;
        public boolean f438c;
        boolean f439d;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.f449b);
            this.f436a = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.f436a = layoutParams.f436a;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: user_url */
    @interface LockMode {
    }

    /* compiled from: user_url */
    public class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C00321();
        int f440a = 0;
        int f441b = 0;
        int f442c = 0;

        /* compiled from: user_url */
        final class C00321 implements Creator<SavedState> {
            C00321() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final Object[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f440a = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f440a);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: user_url */
    @interface State {
    }

    /* compiled from: user_url */
    public class ViewDragCallback extends Callback {
        final /* synthetic */ DrawerLayout f444a;
        private final int f445b;
        public ViewDragHelper f446c;
        private final Runnable f447d = new C00331(this);

        /* compiled from: user_url */
        class C00331 implements Runnable {
            final /* synthetic */ ViewDragCallback f443a;

            C00331(ViewDragCallback viewDragCallback) {
                this.f443a = viewDragCallback;
            }

            public void run() {
                ViewDragCallback.m903f(this.f443a);
            }
        }

        public ViewDragCallback(DrawerLayout drawerLayout, int i) {
            this.f444a = drawerLayout;
            this.f445b = i;
        }

        public final void m904a() {
            this.f444a.removeCallbacks(this.f447d);
        }

        public final boolean mo181a(View view) {
            return DrawerLayout.m921d(view) && this.f444a.m936a(view, this.f445b) && this.f444a.m932a(view) == 0;
        }

        public final void mo177a(int i) {
            this.f444a.m933a(i, this.f446c.f568s);
        }

        public final void mo180a(View view, int i) {
            float f;
            int width = view.getWidth();
            if (this.f444a.m936a(view, 3)) {
                f = ((float) (width + i)) / ((float) width);
            } else {
                f = ((float) (this.f444a.getWidth() - i)) / ((float) width);
            }
            this.f444a.m934a(view, f);
            view.setVisibility(f == 0.0f ? 4 : 0);
            this.f444a.invalidate();
        }

        public final void mo184b(View view) {
            ((LayoutParams) view.getLayoutParams()).f438c = false;
            m902e();
        }

        private void m902e() {
            int i = 3;
            if (this.f445b == 3) {
                i = 5;
            }
            View b = this.f444a.m937b(i);
            if (b != null) {
                this.f444a.m941e(b);
            }
        }

        public final void mo179a(View view, float f, float f2) {
            int i;
            float f3 = ((LayoutParams) view.getLayoutParams()).f437b;
            int width = view.getWidth();
            if (this.f444a.m936a(view, 3)) {
                i = (f > 0.0f || (f == 0.0f && f3 > 0.5f)) ? 0 : -width;
            } else {
                i = this.f444a.getWidth();
                if (f < 0.0f || (f == 0.0f && f3 > 0.5f)) {
                    i -= width;
                }
            }
            this.f446c.m1047a(i, view.getTop());
            this.f444a.invalidate();
        }

        public final void mo183b() {
            this.f444a.postDelayed(this.f447d, 160);
        }

        public static void m903f(ViewDragCallback viewDragCallback) {
            View view;
            int i;
            int i2 = 0;
            int i3 = viewDragCallback.f446c.f564o;
            boolean z = viewDragCallback.f445b == 3;
            if (z) {
                View b = viewDragCallback.f444a.m937b(3);
                if (b != null) {
                    i2 = -b.getWidth();
                }
                i2 += i3;
                view = b;
                i = i2;
            } else {
                i2 = viewDragCallback.f444a.getWidth() - i3;
                view = viewDragCallback.f444a.m937b(5);
                i = i2;
            }
            if (view == null) {
                return;
            }
            if (((z && view.getLeft() < i) || (!z && view.getLeft() > i)) && viewDragCallback.f444a.m932a(view) == 0) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                viewDragCallback.f446c.m1049a(view, i, view.getTop());
                layoutParams.f438c = true;
                viewDragCallback.f444a.invalidate();
                viewDragCallback.m902e();
                DrawerLayout drawerLayout = viewDragCallback.f444a;
                int i4 = 0;
                if (!drawerLayout.f469s) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    int childCount = drawerLayout.getChildCount();
                    while (i4 < childCount) {
                        drawerLayout.getChildAt(i4).dispatchTouchEvent(obtain);
                        i4++;
                    }
                    obtain.recycle();
                    drawerLayout.f469s = true;
                }
            }
        }

        public final boolean mo187c() {
            return false;
        }

        public final void mo178a(int i, int i2) {
            View b;
            if ((i & 1) == 1) {
                b = this.f444a.m937b(3);
            } else {
                b = this.f444a.m937b(5);
            }
            if (b != null && this.f444a.m932a(b) == 0) {
                this.f446c.m1046a(b, i2);
            }
        }

        public final int mo185c(View view) {
            return DrawerLayout.m921d(view) ? view.getWidth() : 0;
        }

        public final int mo182b(View view, int i) {
            if (this.f444a.m936a(view, 3)) {
                return Math.max(-view.getWidth(), Math.min(i, 0));
            }
            int width = this.f444a.getWidth();
            return Math.max(width - view.getWidth(), Math.min(i, width));
        }

        public final int mo186c(View view, int i) {
            return view.getTop();
        }
    }

    static {
        boolean z = true;
        if (VERSION.SDK_INT < 19) {
            z = false;
        }
        f450c = z;
        if (VERSION.SDK_INT >= 21) {
            f448a = new DrawerLayoutCompatImplApi21();
        } else {
            f448a = new DrawerLayoutCompatImplBase();
        }
    }

    public DrawerLayout(Context context) {
        this(context, null);
    }

    private DrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private DrawerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f454d = new ChildAccessibilityDelegate(this);
        this.f456f = -1728053248;
        this.f458h = new Paint();
        this.f465o = true;
        setDescendantFocusability(262144);
        float f = getResources().getDisplayMetrics().density;
        this.f455e = (int) ((64.0f * f) + 0.5f);
        f *= 400.0f;
        this.f461k = new ViewDragCallback(this, 3);
        this.f462l = new ViewDragCallback(this, 5);
        this.f459i = ViewDragHelper.m1028a((ViewGroup) this, 1.0f, this.f461k);
        this.f459i.f565p = 1;
        this.f459i.f563n = f;
        this.f461k.f446c = this.f459i;
        this.f460j = ViewDragHelper.m1028a((ViewGroup) this, 1.0f, this.f462l);
        this.f460j.f565p = 2;
        this.f460j.f563n = f;
        this.f462l.f446c = this.f460j;
        setFocusableInTouchMode(true);
        ViewCompat.d(this, 1);
        ViewCompat.a(this, new AccessibilityDelegate(this));
        ViewGroupCompat.f353a.mo71a(this, false);
        if (ViewCompat.A(this)) {
            f448a.mo174a((View) this);
            this.f475y = f448a.mo173a(context);
        }
    }

    public final void mo188a(Object obj, boolean z) {
        this.f452B = obj;
        this.f453C = z;
        boolean z2 = !z && getBackground() == null;
        setWillNotDraw(z2);
        requestLayout();
    }

    public void setScrimColor(int i) {
        this.f456f = i;
        invalidate();
    }

    public void setDrawerLockMode(int i) {
        m917a(i, 3);
        m917a(i, 5);
    }

    private void m917a(int i, int i2) {
        int a = GravityCompat.a(i2, ViewCompat.h(this));
        if (a == 3) {
            this.f466p = i;
        } else if (a == 5) {
            this.f467q = i;
        }
        if (i != 0) {
            (a == 3 ? this.f459i : this.f460j).m1055e();
        }
        View b;
        switch (i) {
            case 1:
                b = m937b(a);
                if (b != null) {
                    m941e(b);
                    return;
                }
                return;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                b = m937b(a);
                if (b != null) {
                    m929k(b);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final int m932a(View view) {
        int c = m938c(view);
        if (c == 3) {
            return this.f466p;
        }
        if (c == 5) {
            return this.f467q;
        }
        return 0;
    }

    final void m933a(int i, View view) {
        int i2 = 1;
        int i3 = this.f459i.f550a;
        int i4 = this.f460j.f550a;
        if (!(i3 == 1 || i4 == 1)) {
            i2 = (i3 == 2 || i4 == 2) ? 2 : 0;
        }
        if (view != null && i == 0) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (layoutParams.f437b == 0.0f) {
                m924g(view);
            } else if (layoutParams.f437b == 1.0f) {
                m926h(view);
            }
        }
        if (i2 != this.f463m) {
            this.f463m = i2;
            if (this.f470t != null) {
                this.f470t.m889a(i2);
            }
        }
    }

    private void m924g(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.f439d) {
            layoutParams.f439d = false;
            if (this.f470t != null) {
                this.f470t.m890b();
            }
            m918a(view, false);
            if (hasWindowFocus()) {
                View rootView = getRootView();
                if (rootView != null) {
                    rootView.sendAccessibilityEvent(32);
                }
            }
        }
    }

    private void m926h(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.f439d) {
            layoutParams.f439d = true;
            if (this.f470t != null) {
                this.f470t.m887a();
            }
            m918a(view, true);
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
            view.requestFocus();
        }
    }

    private void m918a(View view, boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((z || m921d(childAt)) && !(z && childAt == view)) {
                ViewCompat.d(childAt, 4);
            } else {
                ViewCompat.d(childAt, 1);
            }
        }
    }

    final void m934a(View view, float f) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f != layoutParams.f437b) {
            layoutParams.f437b = f;
            if (this.f470t != null) {
                this.f470t.m888a(f);
            }
        }
    }

    final int m938c(View view) {
        return GravityCompat.a(((LayoutParams) view.getLayoutParams()).f436a, ViewCompat.h(this));
    }

    final boolean m936a(View view, int i) {
        return (m938c(view) & i) == i;
    }

    private View m920d() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (((LayoutParams) childAt.getLayoutParams()).f439d) {
                return childAt;
            }
        }
        return null;
    }

    final View m937b(int i) {
        int a = GravityCompat.a(i, ViewCompat.h(this)) & 7;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((m938c(childAt) & 7) == a) {
                return childAt;
            }
        }
        return null;
    }

    private static String m922e(int i) {
        if ((i & 3) == 3) {
            return "LEFT";
        }
        if ((i & 5) == 5) {
            return "RIGHT";
        }
        return Integer.toHexString(i);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1765324569);
        super.onDetachedFromWindow();
        this.f465o = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 492799903, a);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 639754568);
        super.onAttachedToWindow();
        this.f465o = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 264350269, a);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void onMeasure(int r13, int r14) {
        /*
        r12 = this;
        r1 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        r4 = 0;
        r7 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r11 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r3 = android.view.View.MeasureSpec.getMode(r13);
        r5 = android.view.View.MeasureSpec.getMode(r14);
        r2 = android.view.View.MeasureSpec.getSize(r13);
        r0 = android.view.View.MeasureSpec.getSize(r14);
        if (r3 != r11) goto L_0x001b;
    L_0x0019:
        if (r5 == r11) goto L_0x0117;
    L_0x001b:
        r6 = r12.isInEditMode();
        if (r6 == 0) goto L_0x008d;
    L_0x0021:
        if (r3 == r7) goto L_0x0026;
    L_0x0023:
        if (r3 != 0) goto L_0x0026;
    L_0x0025:
        r2 = r1;
    L_0x0026:
        if (r5 == r7) goto L_0x0117;
    L_0x0028:
        if (r5 != 0) goto L_0x0117;
    L_0x002a:
        r12.setMeasuredDimension(r2, r1);
        r0 = r12.f452B;
        if (r0 == 0) goto L_0x0095;
    L_0x0031:
        r0 = android.support.v4.view.ViewCompat.A(r12);
        if (r0 == 0) goto L_0x0095;
    L_0x0037:
        r0 = 1;
        r3 = r0;
    L_0x0039:
        r5 = android.support.v4.view.ViewCompat.h(r12);
        r6 = r12.getChildCount();
    L_0x0041:
        if (r4 >= r6) goto L_0x0116;
    L_0x0043:
        r7 = r12.getChildAt(r4);
        r0 = r7.getVisibility();
        r8 = 8;
        if (r0 == r8) goto L_0x008a;
    L_0x004f:
        r0 = r7.getLayoutParams();
        r0 = (android.support.v4.widget.DrawerLayout.LayoutParams) r0;
        if (r3 == 0) goto L_0x006a;
    L_0x0057:
        r8 = r0.f436a;
        r8 = android.support.v4.view.GravityCompat.a(r8, r5);
        r9 = android.support.v4.view.ViewCompat.A(r7);
        if (r9 == 0) goto L_0x0097;
    L_0x0063:
        r9 = f448a;
        r10 = r12.f452B;
        r9.mo175a(r7, r10, r8);
    L_0x006a:
        r8 = m928j(r7);
        if (r8 == 0) goto L_0x009f;
    L_0x0070:
        r8 = r0.leftMargin;
        r8 = r2 - r8;
        r9 = r0.rightMargin;
        r8 = r8 - r9;
        r8 = android.view.View.MeasureSpec.makeMeasureSpec(r8, r11);
        r9 = r0.topMargin;
        r9 = r1 - r9;
        r0 = r0.bottomMargin;
        r0 = r9 - r0;
        r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r11);
        r7.measure(r8, r0);
    L_0x008a:
        r4 = r4 + 1;
        goto L_0x0041;
    L_0x008d:
        r0 = new java.lang.IllegalArgumentException;
        r1 = "DrawerLayout must be measured with MeasureSpec.EXACTLY.";
        r0.<init>(r1);
        throw r0;
    L_0x0095:
        r3 = r4;
        goto L_0x0039;
    L_0x0097:
        r9 = f448a;
        r10 = r12.f452B;
        r9.mo176a(r0, r10, r8);
        goto L_0x006a;
    L_0x009f:
        r8 = m921d(r7);
        if (r8 == 0) goto L_0x00f1;
    L_0x00a5:
        r8 = r12.m938c(r7);
        r8 = r8 & 7;
        r9 = r8 & 0;
        if (r9 == 0) goto L_0x00d4;
    L_0x00af:
        r0 = new java.lang.IllegalStateException;
        r1 = new java.lang.StringBuilder;
        r2 = "Child drawer has absolute gravity ";
        r1.<init>(r2);
        r2 = m922e(r8);
        r1 = r1.append(r2);
        r2 = " but this DrawerLayout";
        r1 = r1.append(r2);
        r2 = " already has a drawer view along that edge";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x00d4:
        r8 = r12.f455e;
        r9 = r0.leftMargin;
        r8 = r8 + r9;
        r9 = r0.rightMargin;
        r8 = r8 + r9;
        r9 = r0.width;
        r8 = getChildMeasureSpec(r13, r8, r9);
        r9 = r0.topMargin;
        r10 = r0.bottomMargin;
        r9 = r9 + r10;
        r0 = r0.height;
        r0 = getChildMeasureSpec(r14, r9, r0);
        r7.measure(r8, r0);
        goto L_0x008a;
    L_0x00f1:
        r0 = new java.lang.IllegalStateException;
        r1 = new java.lang.StringBuilder;
        r2 = "Child ";
        r1.<init>(r2);
        r1 = r1.append(r7);
        r2 = " at index ";
        r1 = r1.append(r2);
        r1 = r1.append(r4);
        r2 = " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0116:
        return;
    L_0x0117:
        r1 = r0;
        goto L_0x002a;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.DrawerLayout.onMeasure(int, int):void");
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f464n = true;
        int i5 = i3 - i;
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (m928j(childAt)) {
                    childAt.layout(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.leftMargin + childAt.getMeasuredWidth(), layoutParams.topMargin + childAt.getMeasuredHeight());
                } else {
                    int i7;
                    float f;
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (m936a(childAt, 3)) {
                        i7 = ((int) (((float) measuredWidth) * layoutParams.f437b)) + (-measuredWidth);
                        f = ((float) (measuredWidth + i7)) / ((float) measuredWidth);
                    } else {
                        i7 = i5 - ((int) (((float) measuredWidth) * layoutParams.f437b));
                        f = ((float) (i5 - i7)) / ((float) measuredWidth);
                    }
                    Object obj = f != layoutParams.f437b ? 1 : null;
                    int i8;
                    switch (layoutParams.f436a & 112) {
                        case 16:
                            int i9 = i4 - i2;
                            i8 = (i9 - measuredHeight) / 2;
                            if (i8 < layoutParams.topMargin) {
                                i8 = layoutParams.topMargin;
                            } else if (i8 + measuredHeight > i9 - layoutParams.bottomMargin) {
                                i8 = (i9 - layoutParams.bottomMargin) - measuredHeight;
                            }
                            childAt.layout(i7, i8, measuredWidth + i7, measuredHeight + i8);
                            break;
                        case 80:
                            i8 = i4 - i2;
                            childAt.layout(i7, (i8 - layoutParams.bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i7, i8 - layoutParams.bottomMargin);
                            break;
                        default:
                            childAt.layout(i7, layoutParams.topMargin, measuredWidth + i7, measuredHeight + layoutParams.topMargin);
                            break;
                    }
                    if (obj != null) {
                        m934a(childAt, f);
                    }
                    int i10 = layoutParams.f437b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i10) {
                        childAt.setVisibility(i10);
                    }
                }
            }
        }
        this.f464n = false;
        this.f465o = false;
    }

    public void requestLayout() {
        if (!this.f464n) {
            super.requestLayout();
        }
    }

    public void computeScroll() {
        int childCount = getChildCount();
        float f = 0.0f;
        for (int i = 0; i < childCount; i++) {
            f = Math.max(f, ((LayoutParams) getChildAt(i).getLayoutParams()).f437b);
        }
        this.f457g = f;
        if ((this.f459i.m1050a(true) | this.f460j.m1050a(true)) != 0) {
            ViewCompat.d(this);
        }
    }

    private static boolean m927i(View view) {
        Drawable background = view.getBackground();
        if (background == null || background.getOpacity() != -1) {
            return false;
        }
        return true;
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.f475y = drawable;
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.f475y;
    }

    public void setStatusBarBackground(int i) {
        this.f475y = i != 0 ? ContextCompat.a(getContext(), i) : null;
    }

    public void setStatusBarBackgroundColor(int i) {
        this.f475y = new ColorDrawable(i);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f453C && this.f475y != null) {
            int a = f448a.mo172a(this.f452B);
            if (a > 0) {
                this.f475y.setBounds(0, 0, getWidth(), a);
                this.f475y.draw(canvas);
            }
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        int right;
        int height = getHeight();
        boolean j2 = m928j(view);
        int i = 0;
        int width = getWidth();
        int save = canvas.save();
        if (j2) {
            int childCount = getChildCount();
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                if (childAt != view && childAt.getVisibility() == 0 && m927i(childAt) && m921d(childAt) && childAt.getHeight() >= height) {
                    if (m936a(childAt, 3)) {
                        right = childAt.getRight();
                        if (right <= i) {
                            right = i;
                        }
                        i = right;
                        right = width;
                    } else {
                        right = childAt.getLeft();
                        if (right < width) {
                        }
                    }
                    i2++;
                    width = right;
                }
                right = width;
                i2++;
                width = right;
            }
            canvas.clipRect(i, 0, width, getHeight());
        }
        right = width;
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        if (this.f457g > 0.0f && j2) {
            this.f458h.setColor((((int) (((float) ((this.f456f & -16777216) >>> 24)) * this.f457g)) << 24) | (this.f456f & 16777215));
            canvas.drawRect((float) i, 0.0f, (float) right, (float) getHeight(), this.f458h);
        } else if (this.f473w != null && m936a(view, 3)) {
            right = this.f473w.getIntrinsicWidth();
            i = view.getRight();
            r2 = Math.max(0.0f, Math.min(((float) i) / ((float) this.f459i.f564o), 1.0f));
            this.f473w.setBounds(i, view.getTop(), right + i, view.getBottom());
            this.f473w.setAlpha((int) (255.0f * r2));
            this.f473w.draw(canvas);
        } else if (this.f474x != null && m936a(view, 5)) {
            right = this.f474x.getIntrinsicWidth();
            i = view.getLeft();
            r2 = Math.max(0.0f, Math.min(((float) (getWidth() - i)) / ((float) this.f460j.f564o), 1.0f));
            this.f474x.setBounds(i - right, view.getTop(), i, view.getBottom());
            this.f474x.setAlpha((int) (255.0f * r2));
            this.f474x.draw(canvas);
        }
        return drawChild;
    }

    private static boolean m928j(View view) {
        return ((LayoutParams) view.getLayoutParams()).f436a == 0;
    }

    static boolean m921d(View view) {
        return (GravityCompat.a(((LayoutParams) view.getLayoutParams()).f436a, ViewCompat.h(view)) & 7) != 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r12) {
        /*
        r11 = this;
        r1 = 1;
        r2 = 0;
        r0 = android.support.v4.view.MotionEventCompat.a(r12);
        r3 = r11.f459i;
        r3 = r3.m1048a(r12);
        r4 = r11.f460j;
        r4 = r4.m1048a(r12);
        r3 = r3 | r4;
        switch(r0) {
            case 0: goto L_0x003b;
            case 1: goto L_0x0079;
            case 2: goto L_0x0064;
            case 3: goto L_0x0079;
            default: goto L_0x0016;
        };
    L_0x0016:
        r0 = r2;
    L_0x0017:
        if (r3 != 0) goto L_0x0039;
    L_0x0019:
        if (r0 != 0) goto L_0x0039;
    L_0x001b:
        r8 = 0;
        r10 = r11.getChildCount();
        r9 = r8;
    L_0x0021:
        if (r9 >= r10) goto L_0x0088;
    L_0x0023:
        r7 = r11.getChildAt(r9);
        r7 = r7.getLayoutParams();
        r7 = (android.support.v4.widget.DrawerLayout.LayoutParams) r7;
        r7 = r7.f438c;
        if (r7 == 0) goto L_0x0084;
    L_0x0031:
        r7 = 1;
    L_0x0032:
        r0 = r7;
        if (r0 != 0) goto L_0x0039;
    L_0x0035:
        r0 = r11.f469s;
        if (r0 == 0) goto L_0x003a;
    L_0x0039:
        r2 = r1;
    L_0x003a:
        return r2;
    L_0x003b:
        r0 = r12.getX();
        r4 = r12.getY();
        r11.f471u = r0;
        r11.f472v = r4;
        r5 = r11.f457g;
        r6 = 0;
        r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1));
        if (r5 <= 0) goto L_0x0081;
    L_0x004e:
        r5 = r11.f459i;
        r0 = (int) r0;
        r4 = (int) r4;
        r0 = r5.m1051b(r0, r4);
        if (r0 == 0) goto L_0x0081;
    L_0x0058:
        r0 = m928j(r0);
        if (r0 == 0) goto L_0x0081;
    L_0x005e:
        r0 = r1;
    L_0x005f:
        r11.f468r = r2;
        r11.f469s = r2;
        goto L_0x0017;
    L_0x0064:
        r0 = r11.f459i;
        r4 = 3;
        r0 = r0.m1054c(r4);
        if (r0 == 0) goto L_0x0016;
    L_0x006d:
        r0 = r11.f461k;
        r0.m904a();
        r0 = r11.f462l;
        r0.m904a();
        r0 = r2;
        goto L_0x0017;
    L_0x0079:
        r11.m919a(r1);
        r11.f468r = r2;
        r11.f469s = r2;
        goto L_0x0016;
    L_0x0081:
        r0 = r2;
        goto L_0x005f;
    L_0x0084:
        r7 = r9 + 1;
        r9 = r7;
        goto L_0x0021;
    L_0x0088:
        r7 = r8;
        goto L_0x0032;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 426146488);
        this.f459i.m1053b(motionEvent);
        this.f460j.m1053b(motionEvent);
        float x;
        float y;
        switch (motionEvent.getAction() & 255) {
            case 0:
                x = motionEvent.getX();
                y = motionEvent.getY();
                this.f471u = x;
                this.f472v = y;
                this.f468r = false;
                this.f469s = false;
                break;
            case 1:
                boolean z;
                x = motionEvent.getX();
                y = motionEvent.getY();
                View b = this.f459i.m1051b((int) x, (int) y);
                if (b != null && m928j(b)) {
                    x -= this.f471u;
                    y -= this.f472v;
                    int i = this.f459i.f551b;
                    if ((x * x) + (y * y) < ((float) (i * i))) {
                        View d = m920d();
                        if (d != null) {
                            z = m932a(d) == 2;
                            m919a(z);
                            this.f468r = false;
                            break;
                        }
                    }
                }
                z = true;
                m919a(z);
                this.f468r = false;
            case 3:
                m919a(true);
                this.f468r = false;
                this.f469s = false;
                break;
        }
        LogUtils.a(1216021719, a);
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        this.f468r = z;
        if (z) {
            m919a(true);
        }
    }

    private void m923e() {
        m919a(false);
    }

    private void m919a(boolean z) {
        int childCount = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (m921d(childAt) && (!z || layoutParams.f438c)) {
                int width = childAt.getWidth();
                if (m936a(childAt, 3)) {
                    i |= this.f459i.m1049a(childAt, -width, childAt.getTop());
                } else {
                    i |= this.f460j.m1049a(childAt, getWidth(), childAt.getTop());
                }
                layoutParams.f438c = false;
            }
        }
        this.f461k.m904a();
        this.f462l.m904a();
        if (i != 0) {
            invalidate();
        }
    }

    private void m929k(View view) {
        if (m921d(view)) {
            if (this.f465o) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                layoutParams.f437b = 1.0f;
                layoutParams.f439d = true;
                m918a(view, true);
            } else if (m936a(view, 3)) {
                this.f459i.m1049a(view, 0, view.getTop());
            } else {
                this.f460j.m1049a(view, getWidth() - view.getWidth(), view.getTop());
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public final void m939c(int i) {
        View b = m937b(i);
        if (b == null) {
            throw new IllegalArgumentException("No drawer view found with gravity " + m922e(i));
        }
        m929k(b);
    }

    public final void m941e(View view) {
        if (m921d(view)) {
            if (this.f465o) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                layoutParams.f437b = 0.0f;
                layoutParams.f439d = false;
            } else if (m936a(view, 3)) {
                this.f459i.m1049a(view, -view.getWidth(), view.getTop());
            } else {
                this.f460j.m1049a(view, getWidth(), view.getTop());
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public final void m940d(int i) {
        View b = m937b(i);
        if (b == null) {
            throw new IllegalArgumentException("No drawer view found with gravity " + m922e(i));
        }
        m941e(b);
    }

    private boolean m930l(View view) {
        if (m921d(view)) {
            return ((LayoutParams) view.getLayoutParams()).f437b > 0.0f;
        } else {
            throw new IllegalArgumentException("View " + view + " is not a drawer");
        }
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        return layoutParams instanceof MarginLayoutParams ? new LayoutParams((MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public static View m925h(DrawerLayout drawerLayout) {
        int childCount = drawerLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = drawerLayout.getChildAt(i);
            if (m921d(childAt) && drawerLayout.m930l(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            Object obj;
            if (m925h(this) != null) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                KeyEventCompat.f305a.mo52a(keyEvent);
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        View h = m925h(this);
        if (h != null && m932a(h) == 0) {
            m923e();
        }
        return h != null;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.f440a != 0) {
            View b = m937b(savedState.f440a);
            if (b != null) {
                m929k(b);
            }
        }
        m917a(savedState.f441b, 3);
        m917a(savedState.f442c, 5);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        View d = m920d();
        if (d != null) {
            savedState.f440a = ((LayoutParams) d.getLayoutParams()).f436a;
        }
        savedState.f441b = this.f466p;
        savedState.f442c = this.f467q;
        return savedState;
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (m920d() != null || m921d(view)) {
            ViewCompat.d(view, 4);
        } else {
            ViewCompat.d(view, 1);
        }
        if (!f450c) {
            ViewCompat.a(view, this.f454d);
        }
    }

    public static boolean m931m(View view) {
        return (ViewCompat.e(view) == 4 || ViewCompat.e(view) == 2) ? false : true;
    }
}

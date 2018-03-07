package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.text.TextUtilsCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.widget.ListViewAutoScrollHelper;
import android.support.v4.widget.PopupWindowCompat;
import android.support.v7.internal.widget.AppCompatPopupWindow;
import android.support.v7.internal.widget.ListViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import com.facebook.R;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.lang.reflect.Method;

/* compiled from: upsellPinLabel */
public class ListPopupWindow {
    private static Method f1157a;
    public Handler f1158A;
    private Rect f1159B;
    private boolean f1160C;
    private int f1161D;
    int f1162b;
    private Context f1163c;
    public PopupWindow f1164d;
    private ListAdapter f1165e;
    public DropDownListView f1166f;
    private int f1167g;
    public int f1168h;
    private int f1169i;
    private int f1170j;
    private boolean f1171k;
    public int f1172l;
    private boolean f1173m;
    private boolean f1174n;
    public View f1175o;
    public int f1176p;
    private DataSetObserver f1177q;
    public View f1178r;
    private Drawable f1179s;
    public OnItemClickListener f1180t;
    private OnItemSelectedListener f1181u;
    public final ResizePopupRunnable f1182v;
    private final PopupTouchInterceptor f1183w;
    private final PopupScrollListener f1184x;
    private final ListSelectorHider f1185y;
    private Runnable f1186z;

    /* compiled from: upsellPinLabel */
    public abstract class ForwardingListener implements OnTouchListener {
        private final float f782a;
        private final int f783b;
        private final int f784c;
        public final View f785d;
        private Runnable f786e;
        private Runnable f787f;
        private boolean f788g;
        private boolean f789h;
        private int f790i;
        public final int[] f791j = new int[2];

        /* compiled from: upsellPinLabel */
        class DisallowIntercept implements Runnable {
            final /* synthetic */ ForwardingListener f1398a;

            public DisallowIntercept(ForwardingListener forwardingListener) {
                this.f1398a = forwardingListener;
            }

            public void run() {
                this.f1398a.f785d.getParent().requestDisallowInterceptTouchEvent(true);
            }
        }

        /* compiled from: upsellPinLabel */
        class TriggerLongPress implements Runnable {
            final /* synthetic */ ForwardingListener f1399a;

            public TriggerLongPress(ForwardingListener forwardingListener) {
                this.f1399a = forwardingListener;
            }

            public void run() {
                ForwardingListener.m1327e(this.f1399a);
            }
        }

        public abstract ListPopupWindow mo298a();

        public ForwardingListener(View view) {
            this.f785d = view;
            this.f782a = (float) ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.f783b = ViewConfiguration.getTapTimeout();
            this.f784c = (this.f783b + ViewConfiguration.getLongPressTimeout()) / 2;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            boolean b;
            boolean z = this.f788g;
            if (z) {
                b = this.f789h ? m1325b(motionEvent) : m1325b(motionEvent) || !mo300c();
            } else {
                boolean z2 = m1324a(motionEvent) && mo299b();
                if (z2) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    this.f785d.onTouchEvent(obtain);
                    obtain.recycle();
                }
                b = z2;
            }
            this.f788g = b;
            if (b || z) {
                return true;
            }
            return false;
        }

        protected boolean mo299b() {
            ListPopupWindow a = mo298a();
            if (!(a == null || a.m1661b())) {
                a.m1662c();
            }
            return true;
        }

        protected boolean mo300c() {
            ListPopupWindow a = mo298a();
            if (a != null && a.m1661b()) {
                a.m1657a();
            }
            return true;
        }

        private boolean m1324a(MotionEvent motionEvent) {
            View view = this.f785d;
            if (!view.isEnabled()) {
                return false;
            }
            switch (MotionEventCompat.a(motionEvent)) {
                case 0:
                    this.f790i = motionEvent.getPointerId(0);
                    this.f789h = false;
                    if (this.f786e == null) {
                        this.f786e = new DisallowIntercept(this);
                    }
                    view.postDelayed(this.f786e, (long) this.f783b);
                    if (this.f787f == null) {
                        this.f787f = new TriggerLongPress(this);
                    }
                    view.postDelayed(this.f787f, (long) this.f784c);
                    return false;
                case 1:
                case 3:
                    m1326d();
                    return false;
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    int findPointerIndex = motionEvent.findPointerIndex(this.f790i);
                    if (findPointerIndex < 0) {
                        return false;
                    }
                    Object obj;
                    float x = motionEvent.getX(findPointerIndex);
                    float y = motionEvent.getY(findPointerIndex);
                    float f = this.f782a;
                    if (x < (-f) || y < (-f) || x >= ((float) (view.getRight() - view.getLeft())) + f || y >= ((float) (view.getBottom() - view.getTop())) + f) {
                        obj = null;
                    } else {
                        obj = 1;
                    }
                    if (obj != null) {
                        return false;
                    }
                    m1326d();
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    return true;
                default:
                    return false;
            }
        }

        private void m1326d() {
            if (this.f787f != null) {
                this.f785d.removeCallbacks(this.f787f);
            }
            if (this.f786e != null) {
                this.f785d.removeCallbacks(this.f786e);
            }
        }

        public static void m1327e(ForwardingListener forwardingListener) {
            forwardingListener.m1326d();
            View view = forwardingListener.f785d;
            if (view.isEnabled() && !view.isLongClickable() && forwardingListener.mo299b()) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                view.onTouchEvent(obtain);
                obtain.recycle();
                forwardingListener.f788g = true;
                forwardingListener.f789h = true;
            }
        }

        private boolean m1325b(MotionEvent motionEvent) {
            View view = this.f785d;
            ListPopupWindow a = mo298a();
            if (a == null || !a.m1661b()) {
                return false;
            }
            View view2 = a.f1166f;
            if (view2 == null || !view2.isShown()) {
                return false;
            }
            MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
            int[] iArr = this.f791j;
            view.getLocationOnScreen(iArr);
            obtainNoHistory.offsetLocation((float) iArr[0], (float) iArr[1]);
            iArr = this.f791j;
            view2.getLocationOnScreen(iArr);
            obtainNoHistory.offsetLocation((float) (-iArr[0]), (float) (-iArr[1]));
            boolean a2 = view2.m1935a(obtainNoHistory, this.f790i);
            obtainNoHistory.recycle();
            int a3 = MotionEventCompat.a(motionEvent);
            boolean z;
            if (a3 == 1 || a3 == 3) {
                z = false;
            } else {
                z = true;
            }
            if (a2 && r2) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: upsellPinLabel */
    class C00682 implements Runnable {
        final /* synthetic */ ListPopupWindow f1391a;

        C00682(ListPopupWindow listPopupWindow) {
            this.f1391a = listPopupWindow;
        }

        public void run() {
            View view = this.f1391a.f1178r;
            if (view != null && view.getWindowToken() != null) {
                this.f1391a.m1662c();
            }
        }
    }

    /* compiled from: upsellPinLabel */
    class C00693 implements OnItemSelectedListener {
        final /* synthetic */ ListPopupWindow f1392a;

        C00693(ListPopupWindow listPopupWindow) {
            this.f1392a = listPopupWindow;
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            if (i != -1) {
                DropDownListView dropDownListView = this.f1392a.f1166f;
                if (dropDownListView != null) {
                    dropDownListView.f1393f = false;
                }
            }
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* compiled from: upsellPinLabel */
    public class DropDownListView extends ListViewCompat {
        public boolean f1393f;
        private boolean f1394g;
        public boolean f1395h;
        public ViewPropertyAnimatorCompat f1396i;
        private ListViewAutoScrollHelper f1397j;

        public DropDownListView(Context context, boolean z) {
            super(context, null, 2130772040);
            this.f1394g = z;
            setCacheColorHint(0);
        }

        public final boolean m1935a(MotionEvent motionEvent, int i) {
            boolean z;
            boolean z2;
            int a = MotionEventCompat.a(motionEvent);
            switch (a) {
                case 1:
                    z = false;
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    z = true;
                    break;
                case 3:
                    z = false;
                    z2 = false;
                    break;
                default:
                    z = false;
                    z2 = true;
                    break;
            }
            int findPointerIndex = motionEvent.findPointerIndex(i);
            if (findPointerIndex < 0) {
                z = false;
                z2 = false;
            } else {
                int x = (int) motionEvent.getX(findPointerIndex);
                findPointerIndex = (int) motionEvent.getY(findPointerIndex);
                int pointToPosition = pointToPosition(x, findPointerIndex);
                if (pointToPosition == -1) {
                    z2 = z;
                    z = true;
                } else {
                    View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                    m1933a(childAt, pointToPosition, (float) x, (float) findPointerIndex);
                    if (a == 1) {
                        performItemClick(childAt, pointToPosition, getItemIdAtPosition(pointToPosition));
                    }
                    z = false;
                    z2 = true;
                }
            }
            if (!z2 || r0) {
                this.f1395h = false;
                setPressed(false);
                drawableStateChanged();
                if (this.f1396i != null) {
                    this.f1396i.m492a();
                    this.f1396i = null;
                }
            }
            if (z2) {
                if (this.f1397j == null) {
                    this.f1397j = new ListViewAutoScrollHelper(this);
                }
                this.f1397j.m850a(true);
                this.f1397j.onTouch(this, motionEvent);
            } else if (this.f1397j != null) {
                this.f1397j.m850a(false);
            }
            return z2;
        }

        private void m1933a(View view, int i, float f, float f2) {
            this.f1395h = true;
            setPressed(true);
            layoutChildren();
            setSelection(i);
            m1630a(i, view, f, f2);
            setSelectorEnabled(false);
            refreshDrawableState();
        }

        protected final boolean mo449a() {
            return this.f1395h || super.mo449a();
        }

        public boolean isInTouchMode() {
            return (this.f1394g && this.f1393f) || super.isInTouchMode();
        }

        public boolean hasWindowFocus() {
            return this.f1394g || super.hasWindowFocus();
        }

        public boolean isFocused() {
            return this.f1394g || super.isFocused();
        }

        public boolean hasFocus() {
            return this.f1394g || super.hasFocus();
        }
    }

    /* compiled from: upsellPinLabel */
    class ListSelectorHider implements Runnable {
        final /* synthetic */ ListPopupWindow f1400a;

        public ListSelectorHider(ListPopupWindow listPopupWindow) {
            this.f1400a = listPopupWindow;
        }

        public void run() {
            this.f1400a.m1664e();
        }
    }

    /* compiled from: upsellPinLabel */
    class PopupDataSetObserver extends DataSetObserver {
        final /* synthetic */ ListPopupWindow f1401a;

        public PopupDataSetObserver(ListPopupWindow listPopupWindow) {
            this.f1401a = listPopupWindow;
        }

        public void onChanged() {
            if (this.f1401a.m1661b()) {
                this.f1401a.m1662c();
            }
        }

        public void onInvalidated() {
            this.f1401a.m1657a();
        }
    }

    /* compiled from: upsellPinLabel */
    class PopupScrollListener implements OnScrollListener {
        final /* synthetic */ ListPopupWindow f1402a;

        public PopupScrollListener(ListPopupWindow listPopupWindow) {
            this.f1402a = listPopupWindow;
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1 && !this.f1402a.m1665f() && this.f1402a.f1164d.getContentView() != null) {
                HandlerDetour.a(this.f1402a.f1158A, this.f1402a.f1182v);
                this.f1402a.f1182v.run();
            }
        }
    }

    /* compiled from: upsellPinLabel */
    class PopupTouchInterceptor implements OnTouchListener {
        final /* synthetic */ ListPopupWindow f1403a;

        public PopupTouchInterceptor(ListPopupWindow listPopupWindow) {
            this.f1403a = listPopupWindow;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && this.f1403a.f1164d != null && this.f1403a.f1164d.isShowing() && x >= 0 && x < this.f1403a.f1164d.getWidth() && y >= 0 && y < this.f1403a.f1164d.getHeight()) {
                HandlerDetour.b(this.f1403a.f1158A, this.f1403a.f1182v, 250, 597680316);
            } else if (action == 1) {
                HandlerDetour.a(this.f1403a.f1158A, this.f1403a.f1182v);
            }
            return false;
        }
    }

    /* compiled from: upsellPinLabel */
    class ResizePopupRunnable implements Runnable {
        final /* synthetic */ ListPopupWindow f1404a;

        public ResizePopupRunnable(ListPopupWindow listPopupWindow) {
            this.f1404a = listPopupWindow;
        }

        public void run() {
            if (this.f1404a.f1166f != null && this.f1404a.f1166f.getCount() > this.f1404a.f1166f.getChildCount() && this.f1404a.f1166f.getChildCount() <= this.f1404a.f1162b) {
                this.f1404a.f1164d.setInputMethodMode(2);
                this.f1404a.m1662c();
            }
        }
    }

    static {
        try {
            f1157a = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", new Class[]{Boolean.TYPE});
        } catch (NoSuchMethodException e) {
            Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
        }
    }

    public ListPopupWindow(Context context) {
        this(context, null, 2130772041);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f1167g = -2;
        this.f1168h = -2;
        this.f1172l = 0;
        this.f1173m = false;
        this.f1174n = false;
        this.f1162b = Integer.MAX_VALUE;
        this.f1176p = 0;
        this.f1182v = new ResizePopupRunnable(this);
        this.f1183w = new PopupTouchInterceptor(this);
        this.f1184x = new PopupScrollListener(this);
        this.f1185y = new ListSelectorHider(this);
        this.f1158A = new Handler();
        this.f1159B = new Rect();
        this.f1163c = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ListPopupWindow, i, i2);
        this.f1169i = obtainStyledAttributes.getDimensionPixelOffset(0, 0);
        this.f1170j = obtainStyledAttributes.getDimensionPixelOffset(1, 0);
        if (this.f1170j != 0) {
            this.f1171k = true;
        }
        obtainStyledAttributes.recycle();
        this.f1164d = new AppCompatPopupWindow(context, attributeSet, i);
        this.f1164d.setInputMethodMode(1);
        this.f1161D = TextUtilsCompat.a(this.f1163c.getResources().getConfiguration().locale);
    }

    public void mo369a(ListAdapter listAdapter) {
        if (this.f1177q == null) {
            this.f1177q = new PopupDataSetObserver(this);
        } else if (this.f1165e != null) {
            this.f1165e.unregisterDataSetObserver(this.f1177q);
        }
        this.f1165e = listAdapter;
        if (this.f1165e != null) {
            listAdapter.registerDataSetObserver(this.f1177q);
        }
        if (this.f1166f != null) {
            this.f1166f.setAdapter(this.f1165e);
        }
    }

    public final void m1660a(boolean z) {
        this.f1160C = z;
        this.f1164d.setFocusable(z);
    }

    public final void m1663c(int i) {
        Drawable background = this.f1164d.getBackground();
        if (background != null) {
            background.getPadding(this.f1159B);
            this.f1168h = (this.f1159B.left + this.f1159B.right) + i;
            return;
        }
        this.f1168h = i;
    }

    public final void m1662c() {
        boolean z = true;
        boolean z2 = false;
        int i = -1;
        int i2 = m1656i();
        boolean f = m1665f();
        if (this.f1164d.isShowing()) {
            int width = this.f1168h == -1 ? -1 : this.f1168h == -2 ? this.f1178r.getWidth() : this.f1168h;
            if (this.f1167g == -1) {
                if (!f) {
                    i2 = -1;
                }
                if (f) {
                    PopupWindow popupWindow = this.f1164d;
                    if (this.f1168h != -1) {
                        i = 0;
                    }
                    popupWindow.setWindowLayoutMode(i, 0);
                } else {
                    this.f1164d.setWindowLayoutMode(this.f1168h == -1 ? -1 : 0, -1);
                }
            } else if (this.f1167g != -2) {
                i2 = this.f1167g;
            }
            PopupWindow popupWindow2 = this.f1164d;
            if (!(this.f1174n || this.f1173m)) {
                z2 = true;
            }
            popupWindow2.setOutsideTouchable(z2);
            this.f1164d.update(this.f1178r, this.f1169i, this.f1170j, width, i2);
            return;
        }
        int i3;
        if (this.f1168h == -1) {
            i3 = -1;
        } else if (this.f1168h == -2) {
            this.f1164d.setWidth(this.f1178r.getWidth());
            i3 = 0;
        } else {
            this.f1164d.setWidth(this.f1168h);
            i3 = 0;
        }
        if (this.f1167g == -1) {
            width = -1;
        } else if (this.f1167g == -2) {
            this.f1164d.setHeight(i2);
            width = 0;
        } else {
            this.f1164d.setHeight(this.f1167g);
            width = 0;
        }
        this.f1164d.setWindowLayoutMode(i3, width);
        m1655b(true);
        popupWindow = this.f1164d;
        if (this.f1174n || this.f1173m) {
            z = false;
        }
        popupWindow.setOutsideTouchable(z);
        this.f1164d.setTouchInterceptor(this.f1183w);
        PopupWindowCompat.f506a.mo192a(this.f1164d, this.f1178r, this.f1169i, this.f1170j, this.f1172l);
        this.f1166f.setSelection(-1);
        if (!this.f1160C || this.f1166f.isInTouchMode()) {
            m1664e();
        }
        if (!this.f1160C) {
            HandlerDetour.a(this.f1158A, this.f1185y, 764479112);
        }
    }

    public final void m1657a() {
        this.f1164d.dismiss();
        if (this.f1175o != null) {
            ViewParent parent = this.f1175o.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f1175o);
            }
        }
        this.f1164d.setContentView(null);
        this.f1166f = null;
        HandlerDetour.a(this.f1158A, this.f1182v);
    }

    public final void m1659a(OnDismissListener onDismissListener) {
        this.f1164d.setOnDismissListener(onDismissListener);
    }

    public final void m1664e() {
        DropDownListView dropDownListView = this.f1166f;
        if (dropDownListView != null) {
            dropDownListView.f1393f = true;
            dropDownListView.requestLayout();
        }
    }

    public final boolean m1661b() {
        return this.f1164d.isShowing();
    }

    public final boolean m1665f() {
        return this.f1164d.getInputMethodMode() == 2;
    }

    private int m1656i() {
        int measuredHeight;
        int i = 0;
        LayoutParams layoutParams;
        if (this.f1166f == null) {
            Context context = this.f1163c;
            this.f1186z = new C00682(this);
            this.f1166f = new DropDownListView(context, !this.f1160C);
            if (this.f1179s != null) {
                this.f1166f.setSelector(this.f1179s);
            }
            this.f1166f.setAdapter(this.f1165e);
            this.f1166f.setOnItemClickListener(this.f1180t);
            this.f1166f.setFocusable(true);
            this.f1166f.setFocusableInTouchMode(true);
            this.f1166f.setOnItemSelectedListener(new C00693(this));
            this.f1166f.setOnScrollListener(this.f1184x);
            if (this.f1181u != null) {
                this.f1166f.setOnItemSelectedListener(this.f1181u);
            }
            View view = this.f1166f;
            View view2 = this.f1175o;
            if (view2 != null) {
                View linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-1, 0, 1.0f);
                switch (this.f1176p) {
                    case 0:
                        linearLayout.addView(view2);
                        linearLayout.addView(view, layoutParams2);
                        break;
                    case 1:
                        linearLayout.addView(view, layoutParams2);
                        linearLayout.addView(view2);
                        break;
                    default:
                        Log.e("ListPopupWindow", "Invalid hint position " + this.f1176p);
                        break;
                }
                view2.measure(MeasureSpec.makeMeasureSpec(this.f1168h, Integer.MIN_VALUE), 0);
                layoutParams = (LayoutParams) view2.getLayoutParams();
                measuredHeight = layoutParams.bottomMargin + (view2.getMeasuredHeight() + layoutParams.topMargin);
                view = linearLayout;
            } else {
                measuredHeight = 0;
            }
            this.f1164d.setContentView(view);
        } else {
            this.f1164d.getContentView();
            View view3 = this.f1175o;
            if (view3 != null) {
                layoutParams = (LayoutParams) view3.getLayoutParams();
                measuredHeight = (view3.getMeasuredHeight() + layoutParams.topMargin) + layoutParams.bottomMargin;
            } else {
                measuredHeight = 0;
            }
        }
        Drawable background = this.f1164d.getBackground();
        if (background != null) {
            background.getPadding(this.f1159B);
            i = this.f1159B.bottom + this.f1159B.top;
            if (!this.f1171k) {
                this.f1170j = -this.f1159B.top;
            }
        } else {
            this.f1159B.setEmpty();
        }
        this.f1164d.getInputMethodMode();
        int maxAvailableHeight = this.f1164d.getMaxAvailableHeight(this.f1178r, this.f1170j);
        if (this.f1173m || this.f1167g == -1) {
            return maxAvailableHeight + i;
        }
        int makeMeasureSpec;
        switch (this.f1168h) {
            case -2:
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f1163c.getResources().getDisplayMetrics().widthPixels - (this.f1159B.left + this.f1159B.right), Integer.MIN_VALUE);
                break;
            case -1:
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f1163c.getResources().getDisplayMetrics().widthPixels - (this.f1159B.left + this.f1159B.right), 1073741824);
                break;
            default:
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f1168h, 1073741824);
                break;
        }
        makeMeasureSpec = this.f1166f.m1629a(makeMeasureSpec, maxAvailableHeight - measuredHeight, -1);
        if (makeMeasureSpec > 0) {
            measuredHeight += i;
        }
        return makeMeasureSpec + measuredHeight;
    }

    private void m1655b(boolean z) {
        if (f1157a != null) {
            try {
                f1157a.invoke(this.f1164d, new Object[]{Boolean.valueOf(z)});
            } catch (Exception e) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }
}

package android.support.v7.internal.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v4.view.ViewPropertyAnimatorUpdateListener;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.internal.view.ActionBarPolicy;
import android.support.v7.internal.view.SupportMenuInflater;
import android.support.v7.internal.view.ViewPropertyAnimatorCompatSet;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.widget.ActionBarContainer;
import android.support.v7.internal.widget.ActionBarContextView;
import android.support.v7.internal.widget.ActionBarOverlayLayout;
import android.support.v7.internal.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback;
import android.support.v7.internal.widget.DecorToolbar;
import android.support.v7.internal.widget.ScrollingTabContainerView;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode.Callback;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.facebook.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: upsell_buy_success_impression */
public class WindowDecorActionBar extends ActionBar implements ActionBarVisibilityCallback {
    static final /* synthetic */ boolean f670h = (!WindowDecorActionBar.class.desiredAssertionStatus());
    private static final boolean f671i;
    public int f672A;
    private boolean f673B;
    private int f674C = 0;
    public boolean f675D = true;
    public boolean f676E;
    public boolean f677F;
    private boolean f678G;
    private boolean f679H = true;
    public ViewPropertyAnimatorCompatSet f680I;
    private boolean f681J;
    ActionModeImpl f682a;
    public ActionMode f683b;
    public Callback f684c;
    boolean f685d;
    final ViewPropertyAnimatorListener f686e = new C00431(this);
    final ViewPropertyAnimatorListener f687f = new C00442(this);
    final ViewPropertyAnimatorUpdateListener f688g = new C00453(this);
    public Context f689j;
    private Context f690k;
    private Activity f691l;
    private Dialog f692m;
    public ActionBarOverlayLayout f693n;
    public ActionBarContainer f694o;
    public DecorToolbar f695p;
    public ActionBarContextView f696q;
    public ActionBarContainer f697r;
    public View f698s;
    private ScrollingTabContainerView f699t;
    private ArrayList<TabImpl> f700u = new ArrayList();
    public TabImpl f701v;
    private int f702w = -1;
    private boolean f703x;
    private boolean f704y;
    private ArrayList<Object> f705z = new ArrayList();

    /* compiled from: upsell_buy_success_impression */
    class C00431 extends ViewPropertyAnimatorListenerAdapter {
        final /* synthetic */ WindowDecorActionBar f654a;

        C00431(WindowDecorActionBar windowDecorActionBar) {
            this.f654a = windowDecorActionBar;
        }

        public final void mo88b(View view) {
            if (this.f654a.f675D && this.f654a.f698s != null) {
                ViewCompat.b(this.f654a.f698s, 0.0f);
                ViewCompat.b(this.f654a.f694o, 0.0f);
            }
            if (this.f654a.f697r != null && this.f654a.f672A == 1) {
                this.f654a.f697r.setVisibility(8);
            }
            this.f654a.f694o.setVisibility(8);
            this.f654a.f694o.setTransitioning(false);
            this.f654a.f680I = null;
            WindowDecorActionBar windowDecorActionBar = this.f654a;
            if (windowDecorActionBar.f684c != null) {
                windowDecorActionBar.f684c.mo230a(windowDecorActionBar.f683b);
                windowDecorActionBar.f683b = null;
                windowDecorActionBar.f684c = null;
            }
            if (this.f654a.f693n != null) {
                ViewCompat.z(this.f654a.f693n);
            }
        }
    }

    /* compiled from: upsell_buy_success_impression */
    class C00442 extends ViewPropertyAnimatorListenerAdapter {
        final /* synthetic */ WindowDecorActionBar f655a;

        C00442(WindowDecorActionBar windowDecorActionBar) {
            this.f655a = windowDecorActionBar;
        }

        public final void mo88b(View view) {
            this.f655a.f680I = null;
            this.f655a.f694o.requestLayout();
        }
    }

    /* compiled from: upsell_buy_success_impression */
    class C00453 implements ViewPropertyAnimatorUpdateListener {
        final /* synthetic */ WindowDecorActionBar f656a;

        C00453(WindowDecorActionBar windowDecorActionBar) {
            this.f656a = windowDecorActionBar;
        }

        public final void mo241a() {
            ((View) this.f656a.f694o.getParent()).invalidate();
        }
    }

    /* compiled from: upsell_buy_success_impression */
    public class ActionModeImpl extends ActionMode implements MenuBuilder.Callback {
        final /* synthetic */ WindowDecorActionBar f659a;
        private final Context f660b;
        private final MenuBuilder f661c;
        private Callback f662d;
        private WeakReference<View> f663e;

        public ActionModeImpl(WindowDecorActionBar windowDecorActionBar, Context context, Callback callback) {
            this.f659a = windowDecorActionBar;
            this.f660b = context;
            this.f662d = callback;
            MenuBuilder menuBuilder = new MenuBuilder(context);
            this.f661c = menuBuilder;
            this.f661c.mo330a((MenuBuilder.Callback) this);
        }

        public final MenuInflater mo242a() {
            return new SupportMenuInflater(this.f660b);
        }

        public final Menu mo247b() {
            return this.f661c;
        }

        public final void mo250c() {
            if (this.f659a.f682a == this) {
                if (WindowDecorActionBar.m1238b(this.f659a.f676E, this.f659a.f677F, false)) {
                    this.f662d.mo230a(this);
                } else {
                    this.f659a.f683b = this;
                    this.f659a.f684c = this.f662d;
                }
                this.f662d = null;
                this.f659a.m1271f(false);
                this.f659a.f696q.m1521b();
                this.f659a.f695p.mo383a().sendAccessibilityEvent(32);
                this.f659a.f693n.setHideOnContentScrollEnabled(this.f659a.f685d);
                this.f659a.f682a = null;
            }
        }

        public final void mo251d() {
            if (this.f659a.f682a == this) {
                this.f661c.m1416f();
                try {
                    this.f662d.mo233b(this, this.f661c);
                } finally {
                    this.f661c.m1417g();
                }
            }
        }

        public final boolean m1221e() {
            this.f661c.m1416f();
            try {
                boolean a = this.f662d.mo231a((ActionMode) this, this.f661c);
                return a;
            } finally {
                this.f661c.m1417g();
            }
        }

        public final void mo244a(View view) {
            this.f659a.f696q.setCustomView(view);
            this.f663e = new WeakReference(view);
        }

        public final void mo245a(CharSequence charSequence) {
            this.f659a.f696q.setSubtitle(charSequence);
        }

        public final void mo249b(CharSequence charSequence) {
            this.f659a.f696q.setTitle(charSequence);
        }

        public final void mo243a(int i) {
            mo249b(this.f659a.f689j.getResources().getString(i));
        }

        public final void mo248b(int i) {
            mo245a(this.f659a.f689j.getResources().getString(i));
        }

        public final CharSequence mo252f() {
            return this.f659a.f696q.f998j;
        }

        public final CharSequence mo253g() {
            return this.f659a.f696q.f999k;
        }

        public final void mo246a(boolean z) {
            super.mo246a(z);
            this.f659a.f696q.setTitleOptional(z);
        }

        public final boolean mo254h() {
            return this.f659a.f696q.f1008t;
        }

        public final View mo255i() {
            return this.f663e != null ? (View) this.f663e.get() : null;
        }

        public final boolean mo214a(MenuBuilder menuBuilder, MenuItem menuItem) {
            if (this.f662d != null) {
                return this.f662d.mo232a((ActionMode) this, menuItem);
            }
            return false;
        }

        public final void b_(MenuBuilder menuBuilder) {
            if (this.f662d != null) {
                mo251d();
                this.f659a.f696q.mo344a();
            }
        }
    }

    /* compiled from: upsell_buy_success_impression */
    public class TabImpl extends Tab {
        final /* synthetic */ WindowDecorActionBar f664a;
        private Drawable f665b;
        private CharSequence f666c;
        private CharSequence f667d;
        private int f668e;
        private View f669f;

        public final View mo259d() {
            return this.f669f;
        }

        public final Drawable mo257b() {
            return this.f665b;
        }

        public final int mo256a() {
            return this.f668e;
        }

        public final CharSequence mo258c() {
            return this.f666c;
        }

        public final void mo260e() {
            this.f664a.m1254a((Tab) this);
        }

        public final CharSequence mo261f() {
            return this.f667d;
        }
    }

    static {
        boolean z = true;
        if (VERSION.SDK_INT < 14) {
            z = false;
        }
        f671i = z;
    }

    public WindowDecorActionBar(Activity activity, boolean z) {
        this.f691l = activity;
        View decorView = activity.getWindow().getDecorView();
        m1237b(decorView);
        if (!z) {
            this.f698s = decorView.findViewById(16908290);
        }
    }

    public WindowDecorActionBar(Dialog dialog) {
        this.f692m = dialog;
        m1237b(dialog.getWindow().getDecorView());
    }

    public WindowDecorActionBar(View view) {
        if (f670h || view.isInEditMode()) {
            m1237b(view);
            return;
        }
        throw new AssertionError();
    }

    private void m1237b(View view) {
        this.f693n = (ActionBarOverlayLayout) view.findViewById(2131559128);
        if (this.f693n != null) {
            this.f693n.setActionBarVisibilityCallback(this);
        }
        this.f695p = m1239c(view.findViewById(2131559130));
        this.f696q = (ActionBarContextView) view.findViewById(2131559131);
        this.f694o = (ActionBarContainer) view.findViewById(2131559129);
        this.f697r = (ActionBarContainer) view.findViewById(2131558404);
        if (this.f695p == null || this.f696q == null || this.f694o == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        boolean z;
        this.f689j = this.f695p.mo392b();
        this.f672A = this.f695p.mo396c() ? 1 : 0;
        if ((this.f695p.mo413p() & 4) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.f703x = true;
        }
        ActionBarPolicy a = ActionBarPolicy.m1276a(this.f689j);
        if (a.f707a.getApplicationInfo().targetSdkVersion < 14) {
        }
        m1241g(a.m1277d());
        TypedArray obtainStyledAttributes = this.f689j.obtainStyledAttributes(null, R.styleable.ActionBar, 2130771984, 0);
        if (obtainStyledAttributes.getBoolean(17, false)) {
            mo273b(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(22, 0);
        if (dimensionPixelSize != 0) {
            mo264a((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    private static DecorToolbar m1239c(View view) {
        if (view instanceof DecorToolbar) {
            return (DecorToolbar) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    public final void mo264a(float f) {
        ViewCompat.g(this.f694o, f);
        if (this.f697r != null) {
            ViewCompat.g(this.f697r, f);
        }
    }

    private void m1241g(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = true;
        this.f673B = z;
        if (this.f673B) {
            this.f694o.setTabContainer(null);
            this.f695p.mo386a(this.f699t);
        } else {
            this.f695p.mo386a(null);
            this.f694o.setTabContainer(this.f699t);
        }
        if (m1246n() == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.f699t != null) {
            if (z2) {
                this.f699t.setVisibility(0);
                if (this.f693n != null) {
                    ViewCompat.z(this.f693n);
                }
            } else {
                this.f699t.setVisibility(8);
            }
        }
        DecorToolbar decorToolbar = this.f695p;
        if (this.f673B || !z2) {
            z3 = false;
        } else {
            z3 = true;
        }
        decorToolbar.mo391a(z3);
        ActionBarOverlayLayout actionBarOverlayLayout = this.f693n;
        if (this.f673B || !z2) {
            z4 = false;
        }
        actionBarOverlayLayout.f1031k = z4;
    }

    private void m1245m() {
        if (this.f699t == null) {
            ScrollingTabContainerView scrollingTabContainerView = new ScrollingTabContainerView(this.f689j);
            if (this.f673B) {
                scrollingTabContainerView.setVisibility(0);
                this.f695p.mo386a(scrollingTabContainerView);
            } else {
                if (m1246n() == 2) {
                    scrollingTabContainerView.setVisibility(0);
                    if (this.f693n != null) {
                        ViewCompat.z(this.f693n);
                    }
                } else {
                    scrollingTabContainerView.setVisibility(8);
                }
                this.f694o.setTabContainer(scrollingTabContainerView);
            }
            this.f699t = scrollingTabContainerView;
        }
    }

    public final void mo281e(int i) {
        this.f674C = i;
    }

    public final void mo279d(boolean z) {
        if (z != this.f704y) {
            this.f704y = z;
            int size = this.f705z.size();
            for (int i = 0; i < size; i++) {
                this.f705z.get(i);
            }
        }
    }

    public final void mo265a(int i) {
        mo267a(LayoutInflater.from(mo280e()).inflate(i, this.f695p.mo383a(), false));
    }

    public final void mo269a(boolean z) {
        mo266a(z ? 4 : 0, 4);
    }

    public final void mo271b(int i) {
        mo268a(this.f689j.getString(i));
    }

    private void m1240f(int i) {
        switch (this.f695p.mo414q()) {
            case 1:
                this.f695p.mo400e(i);
                return;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                m1254a((Tab) this.f700u.get(i));
                return;
            default:
                throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
        }
    }

    public final void mo268a(CharSequence charSequence) {
        this.f695p.mo394b(charSequence);
    }

    public final void mo272b(CharSequence charSequence) {
        this.f695p.mo390a(charSequence);
    }

    public final void mo266a(int i, int i2) {
        int p = this.f695p.mo413p();
        if ((i2 & 4) != 0) {
            this.f703x = true;
        }
        this.f695p.mo395c((p & (i2 ^ -1)) | (i & i2));
    }

    public final View mo263a() {
        return this.f695p.mo416s();
    }

    private int m1246n() {
        return this.f695p.mo414q();
    }

    public final int mo270b() {
        return this.f695p.mo413p();
    }

    public final ActionMode mo262a(Callback callback) {
        if (this.f682a != null) {
            this.f682a.mo250c();
        }
        this.f693n.setHideOnContentScrollEnabled(false);
        this.f696q.m1523c();
        ActionMode actionModeImpl = new ActionModeImpl(this, this.f696q.getContext(), callback);
        if (!actionModeImpl.m1221e()) {
            return null;
        }
        actionModeImpl.mo251d();
        this.f696q.m1518a(actionModeImpl);
        m1271f(true);
        if (!(this.f697r == null || this.f672A != 1 || this.f697r.getVisibility() == 0)) {
            this.f697r.setVisibility(0);
            if (this.f693n != null) {
                ViewCompat.z(this.f693n);
            }
        }
        this.f696q.sendAccessibilityEvent(32);
        this.f682a = actionModeImpl;
        return actionModeImpl;
    }

    public final void m1254a(Tab tab) {
        int i = -1;
        if (m1246n() != 2) {
            int a;
            if (tab != null) {
                a = tab.mo256a();
            } else {
                a = -1;
            }
            this.f702w = a;
            return;
        }
        FragmentTransaction fragmentTransaction;
        if (!(this.f691l instanceof FragmentActivity) || this.f695p.mo383a().isInEditMode()) {
            fragmentTransaction = null;
        } else {
            fragmentTransaction = ((FragmentActivity) this.f691l).kO_().a().a();
        }
        if (this.f701v != tab) {
            ScrollingTabContainerView scrollingTabContainerView = this.f699t;
            if (tab != null) {
                i = tab.mo256a();
            }
            scrollingTabContainerView.setTabSelected(i);
            this.f701v = (TabImpl) tab;
        } else if (this.f701v != null) {
            this.f699t.m1641a(tab.mo256a());
        }
        if (fragmentTransaction != null && !fragmentTransaction.e()) {
            fragmentTransaction.b();
        }
    }

    public final void mo282e(boolean z) {
        this.f675D = z;
    }

    public final void mo274c() {
        if (this.f676E) {
            this.f676E = false;
            m1242h(false);
        }
    }

    private void m1247o() {
        if (!this.f678G) {
            this.f678G = true;
            if (this.f693n != null) {
                ActionBarOverlayLayout actionBarOverlayLayout = this.f693n;
            }
            m1242h(false);
        }
    }

    public final void mo284j() {
        if (this.f677F) {
            this.f677F = false;
            m1242h(true);
        }
    }

    public final void mo277d() {
        if (!this.f676E) {
            this.f676E = true;
            m1242h(false);
        }
    }

    private void m1248p() {
        if (this.f678G) {
            this.f678G = false;
            if (this.f693n != null) {
                ActionBarOverlayLayout actionBarOverlayLayout = this.f693n;
            }
            m1242h(false);
        }
    }

    public final void mo285k() {
        if (!this.f677F) {
            this.f677F = true;
            m1242h(true);
        }
    }

    public final void mo273b(boolean z) {
        if (!z || this.f693n.f1030j) {
            this.f685d = z;
            this.f693n.setHideOnContentScrollEnabled(z);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }

    public static boolean m1238b(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        if (z || z2) {
            return false;
        }
        return true;
    }

    private void m1242h(boolean z) {
        if (m1238b(this.f676E, this.f677F, this.f678G)) {
            if (!this.f679H) {
                this.f679H = true;
                m1243i(z);
            }
        } else if (this.f679H) {
            this.f679H = false;
            m1244j(z);
        }
    }

    private void m1243i(boolean z) {
        if (this.f680I != null) {
            this.f680I.m1320b();
        }
        this.f694o.setVisibility(0);
        if (this.f674C == 0 && f671i && (this.f681J || z)) {
            ViewCompat.b(this.f694o, 0.0f);
            float f = (float) (-this.f694o.getHeight());
            if (z) {
                int[] iArr = new int[]{0, 0};
                this.f694o.getLocationInWindow(iArr);
                f -= (float) iArr[1];
            }
            ViewCompat.b(this.f694o, f);
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
            ViewPropertyAnimatorCompat c = ViewCompat.t(this.f694o).m496c(0.0f);
            c.m490a(this.f688g);
            viewPropertyAnimatorCompatSet.m1316a(c);
            if (this.f675D && this.f698s != null) {
                ViewCompat.b(this.f698s, f);
                viewPropertyAnimatorCompatSet.m1316a(ViewCompat.t(this.f698s).m496c(0.0f));
            }
            if (this.f697r != null && this.f672A == 1) {
                ViewCompat.b(this.f697r, (float) this.f697r.getHeight());
                this.f697r.setVisibility(0);
                viewPropertyAnimatorCompatSet.m1316a(ViewCompat.t(this.f697r).m496c(0.0f));
            }
            viewPropertyAnimatorCompatSet.m1318a(AnimationUtils.loadInterpolator(this.f689j, 17432582));
            viewPropertyAnimatorCompatSet.m1315a(250);
            viewPropertyAnimatorCompatSet.m1317a(this.f687f);
            this.f680I = viewPropertyAnimatorCompatSet;
            viewPropertyAnimatorCompatSet.m1319a();
        } else {
            ViewCompat.c(this.f694o, 1.0f);
            ViewCompat.b(this.f694o, 0.0f);
            if (this.f675D && this.f698s != null) {
                ViewCompat.b(this.f698s, 0.0f);
            }
            if (this.f697r != null && this.f672A == 1) {
                ViewCompat.c(this.f697r, 1.0f);
                ViewCompat.b(this.f697r, 0.0f);
                this.f697r.setVisibility(0);
            }
            this.f687f.mo88b(null);
        }
        if (this.f693n != null) {
            ViewCompat.z(this.f693n);
        }
    }

    private void m1244j(boolean z) {
        if (this.f680I != null) {
            this.f680I.m1320b();
        }
        if (this.f674C == 0 && f671i && (this.f681J || z)) {
            ViewCompat.c(this.f694o, 1.0f);
            this.f694o.setTransitioning(true);
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
            float f = (float) (-this.f694o.getHeight());
            if (z) {
                int[] iArr = new int[]{0, 0};
                this.f694o.getLocationInWindow(iArr);
                f -= (float) iArr[1];
            }
            ViewPropertyAnimatorCompat c = ViewCompat.t(this.f694o).m496c(f);
            c.m490a(this.f688g);
            viewPropertyAnimatorCompatSet.m1316a(c);
            if (this.f675D && this.f698s != null) {
                viewPropertyAnimatorCompatSet.m1316a(ViewCompat.t(this.f698s).m496c(f));
            }
            if (this.f697r != null && this.f697r.getVisibility() == 0) {
                ViewCompat.c(this.f697r, 1.0f);
                viewPropertyAnimatorCompatSet.m1316a(ViewCompat.t(this.f697r).m496c((float) this.f697r.getHeight()));
            }
            viewPropertyAnimatorCompatSet.m1318a(AnimationUtils.loadInterpolator(this.f689j, 17432581));
            viewPropertyAnimatorCompatSet.m1315a(250);
            viewPropertyAnimatorCompatSet.m1317a(this.f686e);
            this.f680I = viewPropertyAnimatorCompatSet;
            viewPropertyAnimatorCompatSet.m1319a();
            return;
        }
        this.f686e.mo88b(null);
    }

    public final void m1271f(boolean z) {
        int i;
        int i2 = 0;
        if (z) {
            m1247o();
        } else {
            m1248p();
        }
        DecorToolbar decorToolbar = this.f695p;
        if (z) {
            i = 8;
        } else {
            i = 0;
        }
        decorToolbar.mo402f(i);
        ActionBarContextView actionBarContextView = this.f696q;
        if (!z) {
            i2 = 8;
        }
        actionBarContextView.m1491a(i2);
    }

    public final Context mo280e() {
        if (this.f690k == null) {
            TypedValue typedValue = new TypedValue();
            this.f689j.getTheme().resolveAttribute(2130771987, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.f690k = new ContextThemeWrapper(this.f689j, i);
            } else {
                this.f690k = this.f689j;
            }
        }
        return this.f690k;
    }

    public final void mo278d(int i) {
        this.f695p.mo404g(i);
    }

    public final void mo286l() {
        if (this.f680I != null) {
            this.f680I.m1320b();
            this.f680I = null;
        }
    }

    public final boolean mo283h() {
        if (this.f695p == null || !this.f695p.mo398d()) {
            return false;
        }
        this.f695p.mo399e();
        return true;
    }

    public final void mo267a(View view) {
        this.f695p.mo388a(view);
    }

    public final void mo275c(int i) {
        boolean z;
        boolean z2 = true;
        int q = this.f695p.mo414q();
        switch (q) {
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                int i2 = -1;
                switch (this.f695p.mo414q()) {
                    case 1:
                        i2 = this.f695p.mo415r();
                        break;
                    case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                        if (this.f701v != null) {
                            i2 = this.f701v.mo256a();
                            break;
                        }
                        break;
                }
                this.f702w = i2;
                m1254a(null);
                this.f699t.setVisibility(8);
                break;
        }
        if (!(q == i || this.f673B || this.f693n == null)) {
            ViewCompat.z(this.f693n);
        }
        this.f695p.mo397d(i);
        switch (i) {
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                m1245m();
                this.f699t.setVisibility(0);
                if (this.f702w != -1) {
                    m1240f(this.f702w);
                    this.f702w = -1;
                    break;
                }
                break;
        }
        DecorToolbar decorToolbar = this.f695p;
        if (i != 2 || this.f673B) {
            z = false;
        } else {
            z = true;
        }
        decorToolbar.mo391a(z);
        ActionBarOverlayLayout actionBarOverlayLayout = this.f693n;
        if (i != 2 || this.f673B) {
            z2 = false;
        }
        actionBarOverlayLayout.f1031k = z2;
    }

    public final void mo276c(boolean z) {
        if (!this.f703x) {
            mo269a(z);
        }
    }
}

package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v7.internal.app.WindowDecorActionBar;
import android.support.v7.internal.view.ContextThemeWrapper;
import android.support.v7.internal.view.StandaloneActionMode;
import android.support.v7.internal.view.menu.ExpandedMenuView;
import android.support.v7.internal.view.menu.ListMenuPresenter;
import android.support.v7.internal.view.menu.ListMenuPresenter.MenuAdapter;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuBuilder.Callback;
import android.support.v7.internal.view.menu.MenuPresenter;
import android.support.v7.internal.widget.ActionBarContextView;
import android.support.v7.internal.widget.DecorContentParent;
import android.support.v7.internal.widget.FitWindowsViewGroup;
import android.support.v7.internal.widget.FitWindowsViewGroup.OnFitSystemWindowsListener;
import android.support.v7.internal.widget.TintManager;
import android.support.v7.internal.widget.ViewStubCompat;
import android.support.v7.internal.widget.ViewUtils;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.LinearLayoutCompat;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.facebook.R;

/* compiled from: url cannot be null */
public class AppCompatDelegateImplV7 extends AppCompatDelegateImplBase implements Callback {
    private PanelFeatureState[] f589A;
    private PanelFeatureState f590B;
    public boolean f591C;
    public int f592D;
    private final Runnable f593E = new C00381(this);
    private boolean f594F;
    public boolean f595G;
    private Rect f596H;
    private Rect f597I;
    public ActionMode f598k;
    ActionBarContextView f599l;
    PopupWindow f600m;
    Runnable f601n;
    private Fragment f602o;
    private DecorContentParent f603p;
    private ActionMenuPresenterCallback f604q;
    private PanelMenuPresenterCallback f605r;
    private boolean f606s;
    private ViewGroup f607t;
    private ViewGroup f608u;
    private TextView f609v;
    private View f610w;
    private boolean f611x;
    private boolean f612y;
    private boolean f613z;

    /* compiled from: url cannot be null */
    class C00381 implements Runnable {
        final /* synthetic */ AppCompatDelegateImplV7 f616a;

        C00381(AppCompatDelegateImplV7 appCompatDelegateImplV7) {
            this.f616a = appCompatDelegateImplV7;
        }

        public void run() {
            if (!this.f616a.f595G) {
                if ((this.f616a.f592D & 1) != 0) {
                    AppCompatDelegateImplV7.m1128h(this.f616a, 0);
                }
                if ((this.f616a.f592D & 256) != 0) {
                    AppCompatDelegateImplV7.m1128h(this.f616a, 8);
                }
                this.f616a.f591C = false;
                this.f616a.f592D = 0;
            }
        }
    }

    /* compiled from: url cannot be null */
    class C00392 implements OnApplyWindowInsetsListener {
        final /* synthetic */ AppCompatDelegateImplV7 f617a;

        C00392(AppCompatDelegateImplV7 appCompatDelegateImplV7) {
            this.f617a = appCompatDelegateImplV7;
        }

        public final WindowInsetsCompat mo226a(View view, WindowInsetsCompat windowInsetsCompat) {
            int b = windowInsetsCompat.mo92b();
            int i = AppCompatDelegateImplV7.m1129i(this.f617a, b);
            if (b != i) {
                windowInsetsCompat = windowInsetsCompat.mo91a(windowInsetsCompat.mo90a(), i, windowInsetsCompat.mo93c(), windowInsetsCompat.mo94d());
            }
            return ViewCompat.a.a(view, windowInsetsCompat);
        }
    }

    /* compiled from: url cannot be null */
    class C00403 implements OnFitSystemWindowsListener {
        final /* synthetic */ AppCompatDelegateImplV7 f618a;

        C00403(AppCompatDelegateImplV7 appCompatDelegateImplV7) {
            this.f618a = appCompatDelegateImplV7;
        }

        public final void mo227a(Rect rect) {
            rect.top = AppCompatDelegateImplV7.m1129i(this.f618a, rect.top);
        }
    }

    /* compiled from: url cannot be null */
    class C00414 implements Runnable {
        final /* synthetic */ AppCompatDelegateImplV7 f619a;

        C00414(AppCompatDelegateImplV7 appCompatDelegateImplV7) {
            this.f619a = appCompatDelegateImplV7;
        }

        public void run() {
            this.f619a.f600m.showAtLocation(this.f619a.f599l, 55, 0, 0);
        }
    }

    /* compiled from: url cannot be null */
    final class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        final /* synthetic */ AppCompatDelegateImplV7 f620a;

        public ActionMenuPresenterCallback(AppCompatDelegateImplV7 appCompatDelegateImplV7) {
            this.f620a = appCompatDelegateImplV7;
        }

        public final boolean a_(MenuBuilder menuBuilder) {
            Window.Callback j = this.f620a.m1107j();
            if (j != null) {
                j.onMenuOpened(8, menuBuilder);
            }
            return true;
        }

        public final void mo228a(MenuBuilder menuBuilder, boolean z) {
            AppCompatDelegateImplV7.m1117b(this.f620a, menuBuilder);
        }
    }

    /* compiled from: url cannot be null */
    class ActionModeCallbackWrapper implements ActionMode.Callback {
        final /* synthetic */ AppCompatDelegateImplV7 f621a;
        private ActionMode.Callback f622b;

        public ActionModeCallbackWrapper(AppCompatDelegateImplV7 appCompatDelegateImplV7, ActionMode.Callback callback) {
            this.f621a = appCompatDelegateImplV7;
            this.f622b = callback;
        }

        public final boolean mo231a(ActionMode actionMode, Menu menu) {
            return this.f622b.mo231a(actionMode, menu);
        }

        public final boolean mo233b(ActionMode actionMode, Menu menu) {
            return this.f622b.mo233b(actionMode, menu);
        }

        public final boolean mo232a(ActionMode actionMode, MenuItem menuItem) {
            return this.f622b.mo232a(actionMode, menuItem);
        }

        public final void mo230a(ActionMode actionMode) {
            this.f622b.mo230a(actionMode);
            if (this.f621a.f600m != null) {
                this.f621a.f576b.mo239b().removeCallbacks(this.f621a.f601n);
                this.f621a.f600m.dismiss();
            } else if (this.f621a.f599l != null) {
                this.f621a.f599l.setVisibility(8);
                if (this.f621a.f599l.getParent() != null) {
                    ViewCompat.z((View) this.f621a.f599l.getParent());
                }
            }
            if (this.f621a.f599l != null) {
                this.f621a.f599l.removeAllViews();
            }
            this.f621a.f598k = null;
        }
    }

    /* compiled from: url cannot be null */
    class ListMenuDecorView extends FrameLayout {
        final /* synthetic */ AppCompatDelegateImplV7 f623a;

        public ListMenuDecorView(AppCompatDelegateImplV7 appCompatDelegateImplV7, Context context) {
            this.f623a = appCompatDelegateImplV7;
            super(context);
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return this.f623a.mo215a(keyEvent);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                Object obj;
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (x < -5 || y < -5 || x > getWidth() + 5 || y > getHeight() + 5) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    AppCompatDelegateImplV7.m1125e(this.f623a, 0);
                    return true;
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        public void setBackgroundResource(int i) {
            setBackgroundDrawable(TintManager.m1681a(getContext(), i));
        }
    }

    /* compiled from: url cannot be null */
    public final class PanelFeatureState {
        int f627a;
        public int f628b;
        int f629c;
        int f630d;
        int f631e;
        public int f632f;
        public ViewGroup f633g;
        View f634h;
        View f635i;
        public MenuBuilder f636j;
        public ListMenuPresenter f637k;
        public Context f638l;
        boolean f639m;
        boolean f640n;
        boolean f641o;
        public boolean f642p;
        boolean f643q = false;
        boolean f644r;
        Bundle f645s;

        /* compiled from: url cannot be null */
        public class SavedState implements Parcelable {
            public static final Creator<SavedState> CREATOR = new C00421();
            public int f624a;
            public boolean f625b;
            public Bundle f626c;

            /* compiled from: url cannot be null */
            final class C00421 implements Creator<SavedState> {
                C00421() {
                }

                public final Object createFromParcel(Parcel parcel) {
                    boolean z = true;
                    SavedState savedState = new SavedState();
                    savedState.f624a = parcel.readInt();
                    if (parcel.readInt() != 1) {
                        z = false;
                    }
                    savedState.f625b = z;
                    if (savedState.f625b) {
                        savedState.f626c = parcel.readBundle();
                    }
                    return savedState;
                }

                public final Object[] newArray(int i) {
                    return new SavedState[i];
                }
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f624a);
                parcel.writeInt(this.f625b ? 1 : 0);
                if (this.f625b) {
                    parcel.writeBundle(this.f626c);
                }
            }
        }

        PanelFeatureState(int i) {
            this.f627a = i;
        }

        public final boolean m1169a() {
            if (this.f634h == null) {
                return false;
            }
            if (this.f635i != null) {
                return true;
            }
            if (this.f637k.m1378a().getCount() > 0) {
                return true;
            }
            return false;
        }

        final void m1168a(MenuBuilder menuBuilder) {
            if (menuBuilder != this.f636j) {
                if (this.f636j != null) {
                    this.f636j.m1409b(this.f637k);
                }
                this.f636j = menuBuilder;
                if (menuBuilder != null && this.f637k != null) {
                    menuBuilder.m1401a(this.f637k);
                }
            }
        }
    }

    /* compiled from: url cannot be null */
    final class PanelMenuPresenterCallback implements MenuPresenter.Callback {
        final /* synthetic */ AppCompatDelegateImplV7 f646a;

        public PanelMenuPresenterCallback(AppCompatDelegateImplV7 appCompatDelegateImplV7) {
            this.f646a = appCompatDelegateImplV7;
        }

        public final void mo228a(MenuBuilder menuBuilder, boolean z) {
            Menu menu;
            Menu q = menuBuilder.mo336q();
            boolean z2 = q != menuBuilder;
            AppCompatDelegateImplV7 appCompatDelegateImplV7 = this.f646a;
            if (z2) {
                menu = q;
            }
            PanelFeatureState a = AppCompatDelegateImplV7.m1110a(appCompatDelegateImplV7, menu);
            if (a == null) {
                return;
            }
            if (z2) {
                AppCompatDelegateImplV7.m1112a(this.f646a, a.f627a, a, q);
                AppCompatDelegateImplV7.m1113a(this.f646a, a, true);
                return;
            }
            AppCompatDelegateImplV7.m1113a(this.f646a, a, z);
        }

        public final boolean a_(MenuBuilder menuBuilder) {
            if (menuBuilder == null && this.f646a.f580f) {
                Window.Callback j = this.f646a.m1107j();
                if (!(j == null || this.f646a.f588n)) {
                    j.onMenuOpened(8, menuBuilder);
                }
            }
            return true;
        }
    }

    public AppCompatDelegateImplV7(Context context, Window window, AppCompatCallback appCompatCallback) {
        super(context, window, appCompatCallback);
    }

    public AppCompatDelegateImplV7(Fragment fragment, WindowLike windowLike, AppCompatCallback appCompatCallback) {
        super(fragment.getContext(), windowLike, appCompatCallback);
        this.f602o = fragment;
    }

    public final void mo204a(Bundle bundle) {
        super.mo204a(bundle);
        this.f607t = (ViewGroup) this.f576b.mo239b();
        if ((this.f577c instanceof Activity) && NavUtils.m120b((Activity) this.f577c) != null) {
            ActionBar actionBar = this.f585k;
            if (actionBar == null) {
                this.f594F = true;
            } else {
                actionBar.mo276c(true);
            }
        }
    }

    public final ActionBar mo223f() {
        ActionBar windowDecorActionBar;
        m1130l();
        if (this.f602o != null) {
            if (this.f602o.T == null) {
                return null;
            }
            windowDecorActionBar = new WindowDecorActionBar(this.f602o.T);
        } else if (this.f577c instanceof Activity) {
            windowDecorActionBar = new WindowDecorActionBar((Activity) this.f577c, this.f581g);
        } else if (this.f577c instanceof Dialog) {
            windowDecorActionBar = new WindowDecorActionBar((Dialog) this.f577c);
        } else {
            windowDecorActionBar = new WindowDecorActionBar(this.f608u);
        }
        windowDecorActionBar.mo276c(this.f594F);
        return windowDecorActionBar;
    }

    public final void mo210a(View view) {
        m1130l();
        ViewGroup viewGroup = (ViewGroup) this.f608u.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f577c.onContentChanged();
    }

    public final void mo209a(int i) {
        m1130l();
        ViewGroup viewGroup = (ViewGroup) this.f608u.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f575a).inflate(i, viewGroup);
        this.f577c.onContentChanged();
    }

    public final void mo211a(View view, LayoutParams layoutParams) {
        m1130l();
        ViewGroup viewGroup = (ViewGroup) this.f608u.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f577c.onContentChanged();
    }

    public final void mo216b(View view, LayoutParams layoutParams) {
        m1130l();
        ((ViewGroup) this.f608u.findViewById(16908290)).addView(view, layoutParams);
        this.f577c.onContentChanged();
    }

    public final View mo208a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (!this.f580f) {
            return this.f602o.a(layoutInflater, viewGroup, bundle);
        }
        Context contextThemeWrapper;
        TypedValue typedValue = new TypedValue();
        this.f575a.getTheme().resolveAttribute(2130771986, typedValue, true);
        if (typedValue.resourceId != 0) {
            contextThemeWrapper = new ContextThemeWrapper(this.f575a, typedValue.resourceId);
        } else {
            contextThemeWrapper = this.f575a;
        }
        this.f608u = (ViewGroup) LayoutInflater.from(contextThemeWrapper).inflate(2130903059, viewGroup, false);
        this.f603p = (DecorContentParent) this.f608u.findViewById(2131559128);
        this.f603p.setWindowCallback(m1107j());
        if (this.f581g) {
            this.f603p.mo347a(9);
        }
        if (this.f611x) {
            this.f603p.mo347a(2);
        }
        if (this.f612y) {
            this.f603p.mo347a(5);
        }
        ViewGroup viewGroup2 = (ViewGroup) this.f608u.findViewById(2131558403);
        CharSequence k = m1108k();
        if (!TextUtils.isEmpty(k)) {
            mo212a(k);
        }
        viewGroup2.addView(this.f602o.a(layoutInflater, viewGroup2, bundle));
        mo225a(this.f608u);
        this.f606s = true;
        this.f595G = false;
        PanelFeatureState f = m1126f(0);
        if (!this.f588n && (f == null || f.f636j == null)) {
            m1127g(8);
        }
        return this.f608u;
    }

    public final void mo219c() {
        this.f595G = true;
        if (this.f608u != null) {
            this.f591C = false;
            this.f607t.removeCallbacks(this.f593E);
            this.f608u = null;
        }
    }

    private void m1130l() {
        if (!this.f606s) {
            LayoutInflater from = LayoutInflater.from(this.f575a);
            if (this.f584j) {
                if (this.f582h) {
                    this.f608u = (ViewGroup) from.inflate(2130903058, null);
                } else {
                    this.f608u = (ViewGroup) from.inflate(2130903057, null);
                }
                if (VERSION.SDK_INT >= 21) {
                    ViewCompat.a(this.f608u, new C00392(this));
                } else {
                    ((FitWindowsViewGroup) this.f608u).setOnFitSystemWindowsListener(new C00403(this));
                }
            } else if (this.f583i) {
                this.f608u = (ViewGroup) from.inflate(2130903049, null);
            } else if (this.f580f) {
                Context contextThemeWrapper;
                TypedValue typedValue = new TypedValue();
                this.f575a.getTheme().resolveAttribute(2130771986, typedValue, true);
                if (typedValue.resourceId != 0) {
                    contextThemeWrapper = new ContextThemeWrapper(this.f575a, typedValue.resourceId);
                } else {
                    contextThemeWrapper = this.f575a;
                }
                this.f608u = (ViewGroup) LayoutInflater.from(contextThemeWrapper).inflate(2130903059, null);
                this.f603p = (DecorContentParent) this.f608u.findViewById(2131559128);
                this.f603p.setWindowCallback(m1107j());
                if (this.f581g) {
                    this.f603p.mo347a(9);
                }
                if (this.f611x) {
                    this.f603p.mo347a(2);
                }
                if (this.f612y) {
                    this.f603p.mo347a(5);
                }
            }
            if (this.f608u == null) {
                throw new IllegalArgumentException("AppCompat does not support the current theme features");
            }
            if (this.f603p == null) {
                this.f609v = (TextView) this.f608u.findViewById(2131558927);
            }
            ViewUtils.m1757b(this.f608u);
            ViewGroup viewGroup = (ViewGroup) this.f576b.mo234a(16908290);
            ViewGroup viewGroup2 = (ViewGroup) this.f608u.findViewById(2131558403);
            while (viewGroup.getChildCount() > 0) {
                View childAt = viewGroup.getChildAt(0);
                viewGroup.removeViewAt(0);
                viewGroup2.addView(childAt);
            }
            this.f576b.mo237a(this.f608u);
            viewGroup.setId(-1);
            viewGroup2.setId(16908290);
            if (viewGroup instanceof FrameLayout) {
                ((FrameLayout) viewGroup).setForeground(null);
            }
            CharSequence k = m1108k();
            if (!TextUtils.isEmpty(k)) {
                mo212a(k);
            }
            m1131m();
            mo225a(this.f608u);
            this.f606s = true;
            PanelFeatureState f = m1126f(0);
            if (!this.f588n) {
                if (f == null || f.f636j == null) {
                    m1127g(8);
                }
            }
        }
    }

    void mo225a(ViewGroup viewGroup) {
    }

    private void m1131m() {
        TypedValue typedValue;
        TypedValue typedValue2;
        TypedValue typedValue3;
        int dimension;
        int dimension2;
        TypedValue typedValue4 = null;
        TypedArray obtainStyledAttributes = this.f575a.obtainStyledAttributes(R.styleable.Theme);
        if (obtainStyledAttributes.hasValue(6)) {
            typedValue = new TypedValue();
            obtainStyledAttributes.getValue(6, typedValue);
        } else {
            typedValue = null;
        }
        if (obtainStyledAttributes.hasValue(8)) {
            typedValue2 = new TypedValue();
            obtainStyledAttributes.getValue(8, typedValue2);
        } else {
            typedValue2 = null;
        }
        if (obtainStyledAttributes.hasValue(9)) {
            typedValue3 = new TypedValue();
            obtainStyledAttributes.getValue(9, typedValue3);
        } else {
            typedValue3 = null;
        }
        if (obtainStyledAttributes.hasValue(7)) {
            typedValue4 = new TypedValue();
            obtainStyledAttributes.getValue(7, typedValue4);
        }
        DisplayMetrics displayMetrics = this.f575a.getResources().getDisplayMetrics();
        Object obj = displayMetrics.widthPixels < displayMetrics.heightPixels ? 1 : null;
        if (obj == null) {
            typedValue2 = typedValue;
        }
        if (!(typedValue2 == null || typedValue2.type == 0)) {
            if (typedValue2.type == 5) {
                dimension = (int) typedValue2.getDimension(displayMetrics);
            } else if (typedValue2.type == 6) {
                dimension = (int) typedValue2.getFraction((float) displayMetrics.widthPixels, (float) displayMetrics.widthPixels);
            }
            if (obj == null) {
                typedValue3 = typedValue4;
            }
            if (!(typedValue3 == null || typedValue3.type == 0)) {
                if (typedValue3.type != 5) {
                    dimension2 = (int) typedValue3.getDimension(displayMetrics);
                } else if (typedValue3.type == 6) {
                    dimension2 = (int) typedValue3.getFraction((float) displayMetrics.heightPixels, (float) displayMetrics.heightPixels);
                }
                if (!(dimension == -1 && dimension2 == -1)) {
                    this.f576b.mo236a(dimension, dimension2);
                }
                obtainStyledAttributes.recycle();
            }
            dimension2 = -1;
            this.f576b.mo236a(dimension, dimension2);
            obtainStyledAttributes.recycle();
        }
        dimension = -1;
        if (obj == null) {
            typedValue3 = typedValue4;
        }
        if (typedValue3.type != 5) {
            if (typedValue3.type == 6) {
                dimension2 = (int) typedValue3.getFraction((float) displayMetrics.heightPixels, (float) displayMetrics.heightPixels);
            }
            dimension2 = -1;
        } else {
            dimension2 = (int) typedValue3.getDimension(displayMetrics);
        }
        this.f576b.mo236a(dimension, dimension2);
        obtainStyledAttributes.recycle();
    }

    public final boolean mo217b(int i) {
        switch (i) {
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                m1132o();
                this.f611x = true;
                return true;
            case 5:
                m1132o();
                this.f612y = true;
                return true;
            case 8:
                m1132o();
                this.f = true;
                return true;
            case 9:
                m1132o();
                this.g = true;
                return true;
            case 10:
                m1132o();
                this.h = true;
                return true;
            default:
                return this.f576b.mo240b(i);
        }
    }

    final void mo212a(CharSequence charSequence) {
        if (this.f603p != null) {
            this.f603p.setWindowTitle(charSequence);
        } else if (mo203a() != null) {
            mo203a().mo272b(charSequence);
        } else if (this.f609v != null) {
            this.f609v.setText(charSequence);
        }
    }

    final boolean mo220c(int i) {
        if (i == 8) {
            ActionBar a = mo203a();
            if (a != null) {
                a.mo279d(false);
            }
            return true;
        } else if (i != 0) {
            return false;
        } else {
            PanelFeatureState f = m1126f(i);
            if (!f.f641o) {
                return false;
            }
            m1113a(this, f, false);
            return false;
        }
    }

    final boolean mo222d(int i) {
        if (i != 8) {
            return false;
        }
        ActionBar a = mo203a();
        if (a == null) {
            return true;
        }
        a.mo279d(true);
        return true;
    }

    public final boolean mo214a(MenuBuilder menuBuilder, MenuItem menuItem) {
        Window.Callback j = m1107j();
        if (!(j == null || this.f588n)) {
            PanelFeatureState a = m1110a(this, menuBuilder.mo336q());
            if (a != null) {
                return j.onMenuItemSelected(a.f627a, menuItem);
            }
        }
        return false;
    }

    public final void b_(MenuBuilder menuBuilder) {
        m1114a(true);
    }

    public final ActionMode m1144b(ActionMode.Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        if (this.f598k != null) {
            this.f598k.mo250c();
        }
        ActionMode.Callback actionModeCallbackWrapper = new ActionModeCallbackWrapper(this, callback);
        ActionBar a = mo203a();
        if (a != null) {
            this.f598k = a.mo262a(actionModeCallbackWrapper);
        }
        if (this.f598k == null) {
            this.f598k = mo207a(actionModeCallbackWrapper);
        }
        return this.f598k;
    }

    public final void mo221d() {
        if (mo203a() == null || null == null) {
            m1127g(0);
        }
    }

    final ActionMode mo207a(ActionMode.Callback callback) {
        if (this.f598k != null) {
            this.f598k.mo250c();
        }
        ActionMode.Callback actionModeCallbackWrapper = new ActionModeCallbackWrapper(this, callback);
        Context h = m1106h();
        if (this.f599l == null) {
            if (this.f583i) {
                this.f599l = new ActionBarContextView(h);
                this.f600m = new PopupWindow(h, null, 2130772005);
                this.f600m.setContentView(this.f599l);
                this.f600m.setWidth(-1);
                TypedValue typedValue = new TypedValue();
                this.f575a.getTheme().resolveAttribute(2130771988, typedValue, true);
                this.f599l.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, this.f575a.getResources().getDisplayMetrics()));
                this.f600m.setHeight(-2);
                this.f601n = new C00414(this);
            } else {
                ViewStubCompat viewStubCompat = (ViewStubCompat) this.f608u.findViewById(2131559126);
                if (viewStubCompat != null) {
                    viewStubCompat.f1258d = LayoutInflater.from(h);
                    this.f599l = (ActionBarContextView) viewStubCompat.m1752a();
                }
            }
        }
        if (this.f599l != null) {
            boolean z;
            this.f599l.m1523c();
            ActionBarContextView actionBarContextView = this.f599l;
            if (this.f600m == null) {
                z = true;
            } else {
                z = false;
            }
            ActionMode standaloneActionMode = new StandaloneActionMode(h, actionBarContextView, actionModeCallbackWrapper, z);
            if (callback.mo231a(standaloneActionMode, standaloneActionMode.mo247b())) {
                standaloneActionMode.mo251d();
                this.f599l.m1518a(standaloneActionMode);
                this.f599l.setVisibility(0);
                this.f598k = standaloneActionMode;
                if (this.f600m != null) {
                    this.f576b.mo239b().post(this.f601n);
                }
                this.f599l.sendAccessibilityEvent(32);
                if (this.f599l.getParent() != null) {
                    ViewCompat.z((View) this.f599l.getParent());
                }
            } else {
                this.f598k = null;
            }
        }
        return this.f598k;
    }

    final boolean mo213a(int i, KeyEvent keyEvent) {
        if (mo203a() != null && null != null) {
            return true;
        }
        if (this.f590B == null || !m1116a(this.f590B, keyEvent.getKeyCode(), keyEvent, 1)) {
            if (this.f590B == null) {
                PanelFeatureState f = m1126f(0);
                m1120b(f, keyEvent);
                boolean a = m1116a(f, keyEvent.getKeyCode(), keyEvent, 1);
                f.f639m = false;
                if (a) {
                    return true;
                }
            }
            return false;
        } else if (this.f590B == null) {
            return true;
        } else {
            this.f590B.f640n = true;
            return true;
        }
    }

    final boolean mo215a(KeyEvent keyEvent) {
        boolean z = true;
        if (keyEvent.getKeyCode() == 82 && this.f577c.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() != 0) {
            z = false;
        }
        return z ? m1121c(keyCode, keyEvent) : m1118b(keyCode, keyEvent);
    }

    private boolean m1118b(int i, KeyEvent keyEvent) {
        switch (i) {
            case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                PanelFeatureState f = m1126f(0);
                if (f == null || !f.f641o) {
                    Object obj = 1;
                    if (this.f598k != null) {
                        this.f598k.mo250c();
                    } else {
                        ActionBar a = mo203a();
                        if (a == null || !a.mo283h()) {
                            obj = null;
                        }
                    }
                    if (obj != null) {
                        return true;
                    }
                }
                m1113a(this, f, true);
                return true;
                break;
            case 82:
                m1124e(0, keyEvent);
                return true;
        }
        return false;
    }

    private boolean m1121c(int i, KeyEvent keyEvent) {
        switch (i) {
            case 82:
                m1123d(0, keyEvent);
                return true;
            default:
                if (VERSION.SDK_INT < 11) {
                    return mo213a(i, keyEvent);
                }
                return false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m1111a(android.support.v7.app.AppCompatDelegateImplV7.PanelFeatureState r12, android.view.KeyEvent r13) {
        /*
        r11 = this;
        r1 = -1;
        r3 = 0;
        r9 = 1;
        r2 = -2;
        r0 = r12.f641o;
        if (r0 != 0) goto L_0x000d;
    L_0x0008:
        r10 = r11.f588n;
        r0 = r10;
        if (r0 == 0) goto L_0x000e;
    L_0x000d:
        return;
    L_0x000e:
        r0 = r12.f627a;
        if (r0 != 0) goto L_0x0033;
    L_0x0012:
        r4 = r11.f575a;
        r0 = r4.getResources();
        r0 = r0.getConfiguration();
        r0 = r0.screenLayout;
        r0 = r0 & 15;
        r5 = 4;
        if (r0 != r5) goto L_0x0047;
    L_0x0023:
        r0 = r9;
    L_0x0024:
        r4 = r4.getApplicationInfo();
        r4 = r4.targetSdkVersion;
        r5 = 11;
        if (r4 < r5) goto L_0x0049;
    L_0x002e:
        r4 = r9;
    L_0x002f:
        if (r0 == 0) goto L_0x0033;
    L_0x0031:
        if (r4 != 0) goto L_0x000d;
    L_0x0033:
        r0 = r11.m1107j();
        if (r0 == 0) goto L_0x004b;
    L_0x0039:
        r4 = r12.f627a;
        r5 = r12.f636j;
        r0 = r0.onMenuOpened(r4, r5);
        if (r0 != 0) goto L_0x004b;
    L_0x0043:
        m1113a(r11, r12, r9);
        goto L_0x000d;
    L_0x0047:
        r0 = r3;
        goto L_0x0024;
    L_0x0049:
        r4 = r3;
        goto L_0x002f;
    L_0x004b:
        r0 = r11.f575a;
        r4 = "window";
        r0 = r0.getSystemService(r4);
        r8 = r0;
        r8 = (android.view.WindowManager) r8;
        if (r8 == 0) goto L_0x000d;
    L_0x0058:
        r0 = r11.m1120b(r12, r13);
        if (r0 == 0) goto L_0x000d;
    L_0x005e:
        r0 = r12.f633g;
        if (r0 == 0) goto L_0x0066;
    L_0x0062:
        r0 = r12.f643q;
        if (r0 == 0) goto L_0x00f0;
    L_0x0066:
        r0 = r12.f633g;
        if (r0 != 0) goto L_0x00de;
    L_0x006a:
        r0 = r11.m1115a(r12);
        if (r0 == 0) goto L_0x000d;
    L_0x0070:
        r0 = r12.f633g;
        if (r0 == 0) goto L_0x000d;
    L_0x0074:
        r0 = r11.m1122c(r12);
        if (r0 == 0) goto L_0x000d;
    L_0x007a:
        r0 = r12.m1169a();
        if (r0 == 0) goto L_0x000d;
    L_0x0080:
        r0 = r12.f634h;
        r0 = r0.getLayoutParams();
        if (r0 != 0) goto L_0x0102;
    L_0x0088:
        r0 = new android.view.ViewGroup$LayoutParams;
        r0.<init>(r2, r2);
        r1 = r0;
    L_0x008e:
        r0 = r12.f628b;
        r4 = r12.f633g;
        r4.setBackgroundResource(r0);
        r0 = r12.f634h;
        r0 = r0.getParent();
        if (r0 == 0) goto L_0x00a8;
    L_0x009d:
        r4 = r0 instanceof android.view.ViewGroup;
        if (r4 == 0) goto L_0x00a8;
    L_0x00a1:
        r0 = (android.view.ViewGroup) r0;
        r4 = r12.f634h;
        r0.removeView(r4);
    L_0x00a8:
        r0 = r12.f633g;
        r4 = r12.f634h;
        r0.addView(r4, r1);
        r0 = r12.f634h;
        r0 = r0.hasFocus();
        if (r0 != 0) goto L_0x00bc;
    L_0x00b7:
        r0 = r12.f634h;
        r0.requestFocus();
    L_0x00bc:
        r1 = r2;
    L_0x00bd:
        r12.f640n = r3;
        r0 = new android.view.WindowManager$LayoutParams;
        r3 = r12.f630d;
        r4 = r12.f631e;
        r5 = 1002; // 0x3ea float:1.404E-42 double:4.95E-321;
        r6 = 8519680; // 0x820000 float:1.1938615E-38 double:4.209281E-317;
        r7 = -3;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);
        r1 = r12.f629c;
        r0.gravity = r1;
        r1 = r12.f632f;
        r0.windowAnimations = r1;
        r1 = r12.f633g;
        r8.addView(r1, r0);
        r12.f641o = r9;
        goto L_0x000d;
    L_0x00de:
        r0 = r12.f643q;
        if (r0 == 0) goto L_0x0074;
    L_0x00e2:
        r0 = r12.f633g;
        r0 = r0.getChildCount();
        if (r0 <= 0) goto L_0x0074;
    L_0x00ea:
        r0 = r12.f633g;
        r0.removeAllViews();
        goto L_0x0074;
    L_0x00f0:
        r0 = r12.f635i;
        if (r0 == 0) goto L_0x0100;
    L_0x00f4:
        r0 = r12.f635i;
        r0 = r0.getLayoutParams();
        if (r0 == 0) goto L_0x0100;
    L_0x00fc:
        r0 = r0.width;
        if (r0 == r1) goto L_0x00bd;
    L_0x0100:
        r1 = r2;
        goto L_0x00bd;
    L_0x0102:
        r1 = r0;
        goto L_0x008e;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.AppCompatDelegateImplV7.a(android.support.v7.app.AppCompatDelegateImplV7$PanelFeatureState, android.view.KeyEvent):void");
    }

    private boolean m1115a(PanelFeatureState panelFeatureState) {
        Context h = m1106h();
        TypedValue typedValue = new TypedValue();
        Theme newTheme = h.getResources().newTheme();
        newTheme.setTo(h.getTheme());
        newTheme.resolveAttribute(2130771983, typedValue, true);
        if (typedValue.resourceId != 0) {
            newTheme.applyStyle(typedValue.resourceId, true);
        }
        newTheme.resolveAttribute(2130772046, typedValue, true);
        if (typedValue.resourceId != 0) {
            newTheme.applyStyle(typedValue.resourceId, true);
        } else {
            newTheme.applyStyle(2131624146, true);
        }
        Context contextThemeWrapper = new ContextThemeWrapper(h, 0);
        contextThemeWrapper.getTheme().setTo(newTheme);
        panelFeatureState.f638l = contextThemeWrapper;
        TypedArray obtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(R.styleable.Theme);
        panelFeatureState.f628b = obtainStyledAttributes.getResourceId(76, 0);
        panelFeatureState.f632f = obtainStyledAttributes.getResourceId(1, 0);
        obtainStyledAttributes.recycle();
        panelFeatureState.f633g = new ListMenuDecorView(this, panelFeatureState.f638l);
        panelFeatureState.f629c = 81;
        return true;
    }

    private void m1114a(boolean z) {
        if (this.f603p == null || !this.f603p.mo349b() || (ViewConfigurationCompat.b(ViewConfiguration.get(this.f575a)) && !this.f603p.mo351d())) {
            PanelFeatureState f = m1126f(0);
            f.f643q = true;
            m1113a(this, f, false);
            m1111a(f, null);
            return;
        }
        Window.Callback j = m1107j();
        if (this.f603p.mo350c() && z) {
            this.f603p.mo353f();
            if (!this.f588n) {
                j.onPanelClosed(8, m1126f(0).f636j);
            }
        } else if (j != null && !this.f588n) {
            if (this.f591C && (this.f592D & 1) != 0) {
                this.f607t.removeCallbacks(this.f593E);
                this.f593E.run();
            }
            PanelFeatureState f2 = m1126f(0);
            if (f2.f636j != null && !f2.f644r && j.onPreparePanel(0, f2.f635i, f2.f636j)) {
                j.onMenuOpened(8, f2.f636j);
                this.f603p.mo352e();
            }
        }
    }

    private boolean m1119b(PanelFeatureState panelFeatureState) {
        Context contextThemeWrapper;
        MenuBuilder menuBuilder;
        Context context = this.f575a;
        if ((panelFeatureState.f627a == 0 || panelFeatureState.f627a == 8) && this.f603p != null) {
            TypedValue typedValue = new TypedValue();
            Theme theme = context.getTheme();
            theme.resolveAttribute(2130771986, typedValue, true);
            Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(2130771987, typedValue, true);
            } else {
                theme.resolveAttribute(2130771987, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            Theme theme3 = theme2;
            if (theme3 != null) {
                contextThemeWrapper = new ContextThemeWrapper(context, 0);
                contextThemeWrapper.getTheme().setTo(theme3);
                menuBuilder = new MenuBuilder(contextThemeWrapper);
                menuBuilder.mo330a((Callback) this);
                panelFeatureState.m1168a(menuBuilder);
                return true;
            }
        }
        contextThemeWrapper = context;
        menuBuilder = new MenuBuilder(contextThemeWrapper);
        menuBuilder.mo330a((Callback) this);
        panelFeatureState.m1168a(menuBuilder);
        return true;
    }

    private boolean m1122c(PanelFeatureState panelFeatureState) {
        if (panelFeatureState.f635i != null) {
            panelFeatureState.f634h = panelFeatureState.f635i;
            return true;
        } else if (panelFeatureState.f636j == null) {
            return false;
        } else {
            ExpandedMenuView expandedMenuView;
            if (this.f605r == null) {
                this.f605r = new PanelMenuPresenterCallback(this);
            }
            MenuPresenter.Callback callback = this.f605r;
            if (panelFeatureState.f636j == null) {
                expandedMenuView = null;
            } else {
                if (panelFeatureState.f637k == null) {
                    panelFeatureState.f637k = new ListMenuPresenter(panelFeatureState.f638l, 2130903053);
                    panelFeatureState.f637k.f845i = callback;
                    panelFeatureState.f636j.m1401a(panelFeatureState.f637k);
                }
                Object obj = panelFeatureState.f637k;
                ViewGroup viewGroup = panelFeatureState.f633g;
                if (obj.f840d == null) {
                    obj.f840d = (ExpandedMenuView) obj.f838b.inflate(2130903050, viewGroup, false);
                    if (obj.f843g == null) {
                        obj.f843g = new MenuAdapter(obj);
                    }
                    obj.f840d.setAdapter(obj.f843g);
                    obj.f840d.setOnItemClickListener(obj);
                }
                expandedMenuView = obj.f840d;
            }
            panelFeatureState.f634h = expandedMenuView;
            return panelFeatureState.f634h != null;
        }
    }

    private boolean m1120b(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        if (this.f588n) {
            return false;
        }
        if (panelFeatureState.f639m) {
            return true;
        }
        if (!(this.f590B == null || this.f590B == panelFeatureState)) {
            m1113a(this, this.f590B, false);
        }
        Window.Callback j = m1107j();
        if (j != null) {
            panelFeatureState.f635i = j.onCreatePanelView(panelFeatureState.f627a);
        }
        boolean z = panelFeatureState.f627a == 0 || panelFeatureState.f627a == 8;
        if (z && this.f603p != null) {
            this.f603p.mo354g();
        }
        if (panelFeatureState.f635i == null) {
            if (panelFeatureState.f636j == null || panelFeatureState.f644r) {
                if (panelFeatureState.f636j == null && (!m1119b(panelFeatureState) || panelFeatureState.f636j == null)) {
                    return false;
                }
                if (z && this.f603p != null) {
                    if (this.f604q == null) {
                        this.f604q = new ActionMenuPresenterCallback(this);
                    }
                    this.f603p.mo348a(panelFeatureState.f636j, this.f604q);
                }
                panelFeatureState.f636j.m1416f();
                if (j.onCreatePanelMenu(panelFeatureState.f627a, panelFeatureState.f636j)) {
                    panelFeatureState.f644r = false;
                } else {
                    panelFeatureState.m1168a(null);
                    if (!z || this.f603p == null) {
                        return false;
                    }
                    this.f603p.mo348a(null, this.f604q);
                    return false;
                }
            }
            panelFeatureState.f636j.m1416f();
            if (panelFeatureState.f645s != null) {
                panelFeatureState.f636j.m1408b(panelFeatureState.f645s);
                panelFeatureState.f645s = null;
            }
            if (j.onPreparePanel(0, panelFeatureState.f635i, panelFeatureState.f636j)) {
                if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1) {
                    z = true;
                } else {
                    z = false;
                }
                panelFeatureState.f642p = z;
                panelFeatureState.f636j.setQwertyMode(panelFeatureState.f642p);
                panelFeatureState.f636j.m1417g();
            } else {
                if (z && this.f603p != null) {
                    this.f603p.mo348a(null, this.f604q);
                }
                panelFeatureState.f636j.m1417g();
                return false;
            }
        }
        panelFeatureState.f639m = true;
        panelFeatureState.f640n = false;
        this.f590B = panelFeatureState;
        return true;
    }

    public static void m1117b(AppCompatDelegateImplV7 appCompatDelegateImplV7, MenuBuilder menuBuilder) {
        if (!appCompatDelegateImplV7.f613z) {
            appCompatDelegateImplV7.f613z = true;
            appCompatDelegateImplV7.f603p.mo355h();
            Window.Callback j = appCompatDelegateImplV7.m1107j();
            if (!(j == null || appCompatDelegateImplV7.f588n)) {
                j.onPanelClosed(8, menuBuilder);
            }
            appCompatDelegateImplV7.f613z = false;
        }
    }

    public static void m1125e(AppCompatDelegateImplV7 appCompatDelegateImplV7, int i) {
        m1113a(appCompatDelegateImplV7, appCompatDelegateImplV7.m1126f(i), true);
    }

    public static void m1113a(AppCompatDelegateImplV7 appCompatDelegateImplV7, PanelFeatureState panelFeatureState, boolean z) {
        if (z && panelFeatureState.f627a == 0 && appCompatDelegateImplV7.f603p != null && appCompatDelegateImplV7.f603p.mo350c()) {
            m1117b(appCompatDelegateImplV7, panelFeatureState.f636j);
            return;
        }
        boolean z2 = panelFeatureState.f641o;
        WindowManager windowManager = (WindowManager) appCompatDelegateImplV7.f575a.getSystemService("window");
        if (!(windowManager == null || !z2 || panelFeatureState.f633g == null)) {
            windowManager.removeView(panelFeatureState.f633g);
        }
        panelFeatureState.f639m = false;
        panelFeatureState.f640n = false;
        panelFeatureState.f641o = false;
        if (z2 && z) {
            m1112a(appCompatDelegateImplV7, panelFeatureState.f627a, panelFeatureState, null);
        }
        panelFeatureState.f634h = null;
        panelFeatureState.f643q = true;
        if (appCompatDelegateImplV7.f590B == panelFeatureState) {
            appCompatDelegateImplV7.f590B = null;
        }
    }

    private boolean m1123d(int i, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() == 0) {
            PanelFeatureState f = m1126f(i);
            if (!f.f641o) {
                return m1120b(f, keyEvent);
            }
        }
        return false;
    }

    private void m1124e(int i, KeyEvent keyEvent) {
        boolean z = true;
        if (this.f598k == null) {
            PanelFeatureState f = m1126f(i);
            if (i != 0 || this.f603p == null || !this.f603p.mo349b() || ViewConfigurationCompat.b(ViewConfiguration.get(this.f575a))) {
                boolean z2;
                if (f.f641o || f.f640n) {
                    z2 = f.f641o;
                    m1113a(this, f, true);
                    z = z2;
                } else {
                    if (f.f639m) {
                        if (f.f644r) {
                            f.f639m = false;
                            z2 = m1120b(f, keyEvent);
                        } else {
                            z2 = true;
                        }
                        if (z2) {
                            m1111a(f, keyEvent);
                        }
                    }
                    z = false;
                }
            } else if (this.f603p.mo350c()) {
                z = this.f603p.mo353f();
            } else {
                if (!this.f588n && m1120b(f, keyEvent)) {
                    z = this.f603p.mo352e();
                }
                z = false;
            }
            if (z) {
                AudioManager audioManager = (AudioManager) this.f575a.getSystemService("audio");
                if (audioManager != null) {
                    audioManager.playSoundEffect(0);
                } else {
                    Log.w("AppCompatDelegate", "Couldn't get audio manager");
                }
            }
        }
    }

    public static void m1112a(AppCompatDelegateImplV7 appCompatDelegateImplV7, int i, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i >= 0 && i < appCompatDelegateImplV7.f589A.length) {
                panelFeatureState = appCompatDelegateImplV7.f589A[i];
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.f636j;
            }
        }
        if (panelFeatureState == null || panelFeatureState.f641o) {
            Window.Callback j = appCompatDelegateImplV7.m1107j();
            if (j != null) {
                j.onPanelClosed(i, menu);
            }
        }
    }

    public static PanelFeatureState m1110a(AppCompatDelegateImplV7 appCompatDelegateImplV7, Menu menu) {
        PanelFeatureState[] panelFeatureStateArr = appCompatDelegateImplV7.f589A;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        for (int i = 0; i < length; i++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i];
            if (panelFeatureState != null && panelFeatureState.f636j == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    private PanelFeatureState m1126f(int i) {
        Object obj = this.f589A;
        if (obj == null || obj.length <= i) {
            Object obj2 = new PanelFeatureState[(i + 1)];
            if (obj != null) {
                System.arraycopy(obj, 0, obj2, 0, obj.length);
            }
            this.f589A = obj2;
            obj = obj2;
        }
        PanelFeatureState panelFeatureState = obj[i];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        panelFeatureState = new PanelFeatureState(i);
        obj[i] = panelFeatureState;
        return panelFeatureState;
    }

    private boolean m1116a(PanelFeatureState panelFeatureState, int i, KeyEvent keyEvent, int i2) {
        boolean z = false;
        if (!keyEvent.isSystem()) {
            if ((panelFeatureState.f639m || m1120b(panelFeatureState, keyEvent)) && panelFeatureState.f636j != null) {
                z = panelFeatureState.f636j.performShortcut(i, keyEvent, i2);
            }
            if (z && (i2 & 1) == 0 && this.f603p == null) {
                m1113a(this, panelFeatureState, true);
            }
        }
        return z;
    }

    private void m1127g(int i) {
        this.f592D |= 1 << i;
        if (!this.f591C && this.f607t != null) {
            ViewCompat.a(this.f607t, this.f593E);
            this.f591C = true;
        }
    }

    public static void m1128h(AppCompatDelegateImplV7 appCompatDelegateImplV7, int i) {
        PanelFeatureState f = appCompatDelegateImplV7.m1126f(i);
        if (f.f636j != null) {
            Bundle bundle = new Bundle();
            f.f636j.m1399a(bundle);
            if (bundle.size() > 0) {
                f.f645s = bundle;
            }
            f.f636j.m1416f();
            f.f636j.clear();
        }
        f.f644r = true;
        f.f643q = true;
        if ((i == 8 || i == 0) && appCompatDelegateImplV7.f603p != null) {
            f = appCompatDelegateImplV7.m1126f(0);
            if (f != null) {
                f.f639m = false;
                appCompatDelegateImplV7.m1120b(f, null);
            }
        }
    }

    public static int m1129i(AppCompatDelegateImplV7 appCompatDelegateImplV7, int i) {
        int i2;
        int i3 = 1;
        int i4 = 0;
        if (appCompatDelegateImplV7.f599l == null || !(appCompatDelegateImplV7.f599l.getLayoutParams() instanceof MarginLayoutParams)) {
            i2 = 0;
        } else {
            int i5;
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) appCompatDelegateImplV7.f599l.getLayoutParams();
            if (appCompatDelegateImplV7.f599l.isShown()) {
                if (appCompatDelegateImplV7.f596H == null) {
                    appCompatDelegateImplV7.f596H = new Rect();
                    appCompatDelegateImplV7.f597I = new Rect();
                }
                Rect rect = appCompatDelegateImplV7.f596H;
                Rect rect2 = appCompatDelegateImplV7.f597I;
                rect.set(0, i, 0, 0);
                ViewUtils.m1755a(appCompatDelegateImplV7.f608u, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i : 0)) {
                    marginLayoutParams.topMargin = i;
                    if (appCompatDelegateImplV7.f610w == null) {
                        appCompatDelegateImplV7.f610w = new View(appCompatDelegateImplV7.f575a);
                        appCompatDelegateImplV7.f610w.setBackgroundColor(appCompatDelegateImplV7.f575a.getResources().getColor(2131361795));
                        appCompatDelegateImplV7.f608u.addView(appCompatDelegateImplV7.f610w, -1, new LayoutParams(-1, i));
                        i5 = 1;
                    } else {
                        LayoutParams layoutParams = appCompatDelegateImplV7.f610w.getLayoutParams();
                        if (layoutParams.height != i) {
                            layoutParams.height = i;
                            appCompatDelegateImplV7.f610w.setLayoutParams(layoutParams);
                        }
                        i5 = 1;
                    }
                } else {
                    i5 = 0;
                }
                if (appCompatDelegateImplV7.f610w == null) {
                    i3 = 0;
                }
                if (!(appCompatDelegateImplV7.f582h || i3 == 0)) {
                    i = 0;
                }
                int i6 = i5;
                i5 = i3;
                i3 = i6;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                i5 = 0;
            } else {
                i3 = 0;
                i5 = 0;
            }
            if (i3 != 0) {
                appCompatDelegateImplV7.f599l.setLayoutParams(marginLayoutParams);
            }
            i2 = i5;
        }
        if (appCompatDelegateImplV7.f610w != null) {
            View view = appCompatDelegateImplV7.f610w;
            if (i2 == 0) {
                i4 = 8;
            }
            view.setVisibility(i4);
        }
        return i;
    }

    private void m1132o() {
        if (this.f606s) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }
}

package android.support.v7.internal.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v7.internal.view.menu.ActionMenuItem;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuPresenter;
import android.support.v7.widget.ActionMenuPresenter;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window.Callback;
import com.facebook.R;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: ui_version */
public class ToolbarWidgetWrapper implements DecorToolbar {
    public Toolbar f1236a;
    public int f1237b;
    private View f1238c;
    public SpinnerCompat f1239d;
    private View f1240e;
    private Drawable f1241f;
    private Drawable f1242g;
    private Drawable f1243h;
    private boolean f1244i;
    public CharSequence f1245j;
    public CharSequence f1246k;
    private CharSequence f1247l;
    public Callback f1248m;
    public boolean f1249n;
    private ActionMenuPresenter f1250o;
    private int f1251p;
    private final TintManager f1252q;
    private int f1253r;
    private Drawable f1254s;

    /* compiled from: ui_version */
    class C00601 implements OnClickListener {
        final ActionMenuItem f1231a = new ActionMenuItem(this.f1232b.f1236a.getContext(), 0, 16908332, 0, 0, this.f1232b.f1245j);
        final /* synthetic */ ToolbarWidgetWrapper f1232b;

        C00601(ToolbarWidgetWrapper toolbarWidgetWrapper) {
            this.f1232b = toolbarWidgetWrapper;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 338948077);
            if (this.f1232b.f1248m != null && this.f1232b.f1249n) {
                this.f1232b.f1248m.onMenuItemSelected(0, this.f1231a);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -173820742, a);
        }
    }

    /* compiled from: ui_version */
    class C00612 extends ViewPropertyAnimatorListenerAdapter {
        final /* synthetic */ ToolbarWidgetWrapper f1233a;
        private boolean f1234b = false;

        C00612(ToolbarWidgetWrapper toolbarWidgetWrapper) {
            this.f1233a = toolbarWidgetWrapper;
        }

        public final void mo88b(View view) {
            if (!this.f1234b) {
                this.f1233a.f1236a.setVisibility(8);
            }
        }

        public final void mo89c(View view) {
            this.f1234b = true;
        }
    }

    /* compiled from: ui_version */
    class C00623 extends ViewPropertyAnimatorListenerAdapter {
        final /* synthetic */ ToolbarWidgetWrapper f1235a;

        C00623(ToolbarWidgetWrapper toolbarWidgetWrapper) {
            this.f1235a = toolbarWidgetWrapper;
        }

        public final void mo87a(View view) {
            this.f1235a.f1236a.setVisibility(0);
        }
    }

    public ToolbarWidgetWrapper(Toolbar toolbar, boolean z) {
        this(toolbar, z, 2131230819, 2130837524);
    }

    private ToolbarWidgetWrapper(Toolbar toolbar, boolean z, int i, int i2) {
        this.f1251p = 0;
        this.f1253r = 0;
        this.f1236a = toolbar;
        this.f1245j = toolbar.f1588v;
        this.f1246k = toolbar.f1589w;
        this.f1244i = this.f1245j != null;
        this.f1243h = toolbar.getNavigationIcon();
        if (z) {
            TintTypedArray a = TintTypedArray.m1693a(toolbar.getContext(), null, R.styleable.ActionBar, 2130771984, 0);
            CharSequence b = a.m1697b(24);
            if (!TextUtils.isEmpty(b)) {
                mo394b(b);
            }
            b = a.m1697b(25);
            if (!TextUtils.isEmpty(b)) {
                this.f1246k = b;
                if ((this.f1237b & 8) != 0) {
                    this.f1236a.setSubtitle(b);
                }
            }
            Drawable a2 = a.m1695a(7);
            if (a2 != null) {
                m1709c(a2);
            }
            a2 = a.m1695a(6);
            if (this.f1243h == null && a2 != null) {
                mo385a(a2);
            }
            a2 = a.m1695a(1);
            if (a2 != null) {
                m1711d(a2);
            }
            mo395c(a.m1694a(3, 0));
            int f = a.m1704f(11, 0);
            if (f != 0) {
                mo388a(LayoutInflater.from(this.f1236a.getContext()).inflate(f, this.f1236a, false));
                mo395c(this.f1237b | 16);
            }
            f = a.m1703e(0, 0);
            if (f > 0) {
                LayoutParams layoutParams = this.f1236a.getLayoutParams();
                layoutParams.height = f;
                this.f1236a.setLayoutParams(layoutParams);
            }
            f = a.m1699c(18, -1);
            int c = a.m1699c(19, -1);
            if (f >= 0 || c >= 0) {
                this.f1236a.m2148a(Math.max(f, 0), Math.max(c, 0));
            }
            f = a.m1704f(4, 0);
            if (f != 0) {
                this.f1236a.m2149a(this.f1236a.getContext(), f);
            }
            f = a.m1704f(5, 0);
            if (f != 0) {
                this.f1236a.m2152b(this.f1236a.getContext(), f);
            }
            int f2 = a.m1704f(23, 0);
            if (f2 != 0) {
                this.f1236a.setPopupTheme(f2);
            }
            a.m1698b();
            this.f1252q = a.m1700c();
        } else {
            int i3 = 11;
            if (this.f1236a.getNavigationIcon() != null) {
                i3 = 15;
            }
            this.f1237b = i3;
            this.f1252q = new TintManager(toolbar.getContext());
        }
        m1713h(i);
        this.f1247l = this.f1236a.getNavigationContentDescription();
        m1708b(this.f1252q.m1690a(i2));
        this.f1236a.setNavigationOnClickListener(new C00601(this));
    }

    private void m1713h(int i) {
        if (i != this.f1253r) {
            this.f1253r = i;
            if (TextUtils.isEmpty(this.f1236a.getNavigationContentDescription())) {
                m1714i(this.f1253r);
            }
        }
    }

    private void m1708b(Drawable drawable) {
        if (this.f1254s != drawable) {
            this.f1254s = drawable;
            m1717x();
        }
    }

    public final ViewGroup mo383a() {
        return this.f1236a;
    }

    public final Context mo392b() {
        return this.f1236a.getContext();
    }

    public final boolean mo396c() {
        return false;
    }

    public final boolean mo398d() {
        return this.f1236a.m2158g();
    }

    public final void mo399e() {
        this.f1236a.m2159h();
    }

    public final void mo389a(Callback callback) {
        this.f1248m = callback;
    }

    public final void mo390a(CharSequence charSequence) {
        if (!this.f1244i) {
            m1710c(charSequence);
        }
    }

    public final CharSequence mo401f() {
        return this.f1236a.f1588v;
    }

    public final void mo394b(CharSequence charSequence) {
        this.f1244i = true;
        m1710c(charSequence);
    }

    private void m1710c(CharSequence charSequence) {
        this.f1245j = charSequence;
        if ((this.f1237b & 8) != 0) {
            this.f1236a.setTitle(charSequence);
        }
    }

    public final void mo403g() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public final void mo405h() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public final void mo384a(int i) {
        mo385a(i != 0 ? this.f1252q.m1690a(i) : null);
    }

    public final void mo385a(Drawable drawable) {
        this.f1241f = drawable;
        m1715u();
    }

    public final void mo393b(int i) {
        m1709c(i != 0 ? this.f1252q.m1690a(i) : null);
    }

    private void m1709c(Drawable drawable) {
        this.f1242g = drawable;
        m1715u();
    }

    private void m1715u() {
        Drawable drawable = null;
        if ((this.f1237b & 2) != 0) {
            drawable = (this.f1237b & 1) != 0 ? this.f1242g != null ? this.f1242g : this.f1241f : this.f1241f;
        }
        this.f1236a.setLogo(drawable);
    }

    public final boolean mo406i() {
        return this.f1236a.m2151a();
    }

    public final boolean mo407j() {
        return this.f1236a.m2153b();
    }

    public final boolean mo408k() {
        return this.f1236a.m2154c();
    }

    public final boolean mo409l() {
        return this.f1236a.m2155d();
    }

    public final boolean mo410m() {
        return this.f1236a.m2156e();
    }

    public final void mo411n() {
        this.f1249n = true;
    }

    public final void mo387a(Menu menu, MenuPresenter.Callback callback) {
        if (this.f1250o == null) {
            this.f1250o = new ActionMenuPresenter(this.f1236a.getContext());
            this.f1250o.f813j = 2131558406;
        }
        this.f1250o.f810g = callback;
        this.f1236a.m2150a((MenuBuilder) menu, this.f1250o);
    }

    public final void mo412o() {
        this.f1236a.m2157f();
    }

    public final int mo413p() {
        return this.f1237b;
    }

    public final void mo395c(int i) {
        int i2 = this.f1237b ^ i;
        this.f1237b = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    m1717x();
                    m1716w();
                } else {
                    this.f1236a.setNavigationIcon(null);
                }
            }
            if ((i2 & 3) != 0) {
                m1715u();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.f1236a.setTitle(this.f1245j);
                    this.f1236a.setSubtitle(this.f1246k);
                } else {
                    this.f1236a.setTitle(null);
                    this.f1236a.setSubtitle(null);
                }
            }
            if ((i2 & 16) != 0 && this.f1240e != null) {
                if ((i & 16) != 0) {
                    this.f1236a.addView(this.f1240e);
                } else {
                    this.f1236a.removeView(this.f1240e);
                }
            }
        }
    }

    public final void mo386a(ScrollingTabContainerView scrollingTabContainerView) {
        if (this.f1238c != null && this.f1238c.getParent() == this.f1236a) {
            this.f1236a.removeView(this.f1238c);
        }
        this.f1238c = scrollingTabContainerView;
        if (scrollingTabContainerView != null && this.f1251p == 2) {
            this.f1236a.addView(this.f1238c, 0);
            Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.f1238c.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = -2;
            layoutParams.a = 8388691;
            scrollingTabContainerView.f1143i = true;
        }
    }

    public final void mo391a(boolean z) {
        this.f1236a.setCollapsible(z);
    }

    public final int mo414q() {
        return this.f1251p;
    }

    public final void mo397d(int i) {
        int i2 = this.f1251p;
        if (i != i2) {
            switch (i2) {
                case 1:
                    if (this.f1239d != null && this.f1239d.getParent() == this.f1236a) {
                        this.f1236a.removeView(this.f1239d);
                        break;
                    }
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    if (this.f1238c != null && this.f1238c.getParent() == this.f1236a) {
                        this.f1236a.removeView(this.f1238c);
                        break;
                    }
            }
            this.f1251p = i;
            switch (i) {
                case 0:
                    return;
                case 1:
                    if (this.f1239d == null) {
                        this.f1239d = new SpinnerCompat(mo392b(), null, 2130772010);
                        this.f1239d.setLayoutParams(new Toolbar.LayoutParams(-2, -2, 8388627));
                    }
                    this.f1236a.addView(this.f1239d, 0);
                    return;
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    if (this.f1238c != null) {
                        this.f1236a.addView(this.f1238c, 0);
                        Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.f1238c.getLayoutParams();
                        layoutParams.width = -2;
                        layoutParams.height = -2;
                        layoutParams.a = 8388691;
                        return;
                    }
                    return;
                default:
                    throw new IllegalArgumentException("Invalid navigation mode " + i);
            }
        }
    }

    public final void mo400e(int i) {
        if (this.f1239d == null) {
            throw new IllegalStateException("Can't set dropdown selected position without an adapter");
        }
        this.f1239d.setSelection(i);
    }

    public final int mo415r() {
        return this.f1239d != null ? this.f1239d.f970v : 0;
    }

    public final void mo388a(View view) {
        if (!(this.f1240e == null || (this.f1237b & 16) == 0)) {
            this.f1236a.removeView(this.f1240e);
        }
        this.f1240e = view;
        if (view != null && (this.f1237b & 16) != 0) {
            this.f1236a.addView(this.f1240e);
        }
    }

    public final View mo416s() {
        return this.f1240e;
    }

    public final void mo402f(int i) {
        if (i == 8) {
            ViewCompat.t(this.f1236a).m487a(0.0f).m489a(new C00612(this));
        } else if (i == 0) {
            ViewCompat.t(this.f1236a).m487a(1.0f).m489a(new C00623(this));
        }
    }

    private void m1711d(Drawable drawable) {
        this.f1243h = drawable;
        m1717x();
    }

    public final void mo404g(int i) {
        m1711d(i != 0 ? this.f1252q.m1690a(i) : null);
    }

    private void m1712e(CharSequence charSequence) {
        this.f1247l = charSequence;
        m1716w();
    }

    private void m1714i(int i) {
        m1712e(i == 0 ? null : mo392b().getString(i));
    }

    private void m1716w() {
        if ((this.f1237b & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.f1247l)) {
            this.f1236a.setNavigationContentDescription(this.f1253r);
        } else {
            this.f1236a.setNavigationContentDescription(this.f1247l);
        }
    }

    private void m1717x() {
        if ((this.f1237b & 4) != 0) {
            this.f1236a.setNavigationIcon(this.f1243h != null ? this.f1243h : this.f1254s);
        }
    }
}

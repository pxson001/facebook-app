package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.ActionProvider.VisibilityListener;
import android.support.v4.view.MenuItemCompat.OnActionExpandListener;
import android.support.v7.internal.view.menu.MenuView.ItemView;
import android.support.v7.internal.widget.TintManager;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug.CapturedViewProperty;
import android.widget.LinearLayout;

/* compiled from: unsubscribe_description */
public final class MenuItemImpl implements SupportMenuItem {
    public static String f875w;
    public static String f876x;
    public static String f877y;
    public static String f878z;
    private final int f879a;
    private final int f880b;
    private final int f881c;
    public final int f882d;
    private CharSequence f883e;
    private CharSequence f884f;
    private Intent f885g;
    private char f886h;
    private char f887i;
    private Drawable f888j;
    private int f889k = 0;
    public MenuBuilder f890l;
    private SubMenuBuilder f891m;
    private Runnable f892n;
    private OnMenuItemClickListener f893o;
    private int f894p = 16;
    public int f895q = 0;
    private View f896r;
    private ActionProvider f897s;
    private OnActionExpandListener f898t;
    private boolean f899u = false;
    public ContextMenuInfo f900v;

    /* compiled from: unsubscribe_description */
    class C00471 implements VisibilityListener {
        final /* synthetic */ MenuItemImpl f874a;

        C00471(MenuItemImpl menuItemImpl) {
            this.f874a = menuItemImpl;
        }

        public final void mo315a() {
            this.f874a.f890l.m1418h();
        }
    }

    public final /* synthetic */ MenuItem setActionView(View view) {
        return m1426a(view);
    }

    MenuItemImpl(MenuBuilder menuBuilder, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.f890l = menuBuilder;
        this.f879a = i2;
        this.f880b = i;
        this.f881c = i3;
        this.f882d = i4;
        this.f883e = charSequence;
        this.f895q = i5;
    }

    public final boolean m1434b() {
        if ((this.f893o != null && this.f893o.onMenuItemClick(this)) || this.f890l.mo331a(this.f890l.mo336q(), (MenuItem) this)) {
            return true;
        }
        if (this.f892n != null) {
            this.f892n.run();
            return true;
        }
        if (this.f885g != null) {
            try {
                this.f890l.m1414d().startActivity(this.f885g);
                return true;
            } catch (Throwable e) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e);
            }
        }
        if (this.f897s == null || !this.f897s.mo318d()) {
            return false;
        }
        return true;
    }

    public final boolean isEnabled() {
        return (this.f894p & 16) != 0;
    }

    public final MenuItem setEnabled(boolean z) {
        if (z) {
            this.f894p |= 16;
        } else {
            this.f894p &= -17;
        }
        this.f890l.m1410b(false);
        return this;
    }

    public final int getGroupId() {
        return this.f880b;
    }

    @CapturedViewProperty
    public final int getItemId() {
        return this.f879a;
    }

    public final int getOrder() {
        return this.f881c;
    }

    public final Intent getIntent() {
        return this.f885g;
    }

    public final MenuItem setIntent(Intent intent) {
        this.f885g = intent;
        return this;
    }

    public final char getAlphabeticShortcut() {
        return this.f887i;
    }

    public final MenuItem setAlphabeticShortcut(char c) {
        if (this.f887i != c) {
            this.f887i = Character.toLowerCase(c);
            this.f890l.m1410b(false);
        }
        return this;
    }

    public final char getNumericShortcut() {
        return this.f886h;
    }

    public final MenuItem setNumericShortcut(char c) {
        if (this.f886h != c) {
            this.f886h = c;
            this.f890l.m1410b(false);
        }
        return this;
    }

    public final MenuItem setShortcut(char c, char c2) {
        this.f886h = c;
        this.f887i = Character.toLowerCase(c2);
        this.f890l.m1410b(false);
        return this;
    }

    public final char m1436d() {
        return this.f890l.mo333b() ? this.f887i : this.f886h;
    }

    final boolean m1439f() {
        return this.f890l.mo335c() && m1436d() != '\u0000';
    }

    public final SubMenu getSubMenu() {
        return this.f891m;
    }

    public final boolean hasSubMenu() {
        return this.f891m != null;
    }

    final void m1431a(SubMenuBuilder subMenuBuilder) {
        this.f891m = subMenuBuilder;
        subMenuBuilder.setHeaderTitle(getTitle());
    }

    @CapturedViewProperty
    public final CharSequence getTitle() {
        return this.f883e;
    }

    final CharSequence m1430a(ItemView itemView) {
        return (itemView == null || !itemView.gO_()) ? getTitle() : getTitleCondensed();
    }

    public final MenuItem setTitle(CharSequence charSequence) {
        this.f883e = charSequence;
        this.f890l.m1410b(false);
        if (this.f891m != null) {
            this.f891m.setHeaderTitle(charSequence);
        }
        return this;
    }

    public final MenuItem setTitle(int i) {
        return setTitle(this.f890l.f850e.getString(i));
    }

    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f884f != null ? this.f884f : this.f883e;
        if (VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) {
            return charSequence;
        }
        return charSequence.toString();
    }

    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f884f = charSequence;
        this.f890l.m1410b(false);
        return this;
    }

    public final Drawable getIcon() {
        if (this.f888j != null) {
            return this.f888j;
        }
        if (this.f889k == 0) {
            return null;
        }
        Drawable a = TintManager.m1681a(this.f890l.f850e, this.f889k);
        this.f889k = 0;
        this.f888j = a;
        return a;
    }

    public final MenuItem setIcon(Drawable drawable) {
        this.f889k = 0;
        this.f888j = drawable;
        this.f890l.m1410b(false);
        return this;
    }

    public final MenuItem setIcon(int i) {
        this.f888j = null;
        this.f889k = i;
        this.f890l.m1410b(false);
        return this;
    }

    public final boolean isCheckable() {
        return (this.f894p & 1) == 1;
    }

    public final MenuItem setCheckable(boolean z) {
        int i = this.f894p;
        this.f894p = (z ? 1 : 0) | (this.f894p & -2);
        if (i != this.f894p) {
            this.f890l.m1410b(false);
        }
        return this;
    }

    public final void m1432a(boolean z) {
        this.f894p = (z ? 4 : 0) | (this.f894p & -5);
    }

    public final boolean m1440g() {
        return (this.f894p & 4) != 0;
    }

    public final boolean isChecked() {
        return (this.f894p & 2) == 2;
    }

    public final MenuItem setChecked(boolean z) {
        if ((this.f894p & 4) != 0) {
            MenuBuilder menuBuilder = this.f890l;
            int groupId = getGroupId();
            int size = menuBuilder.f855j.size();
            for (int i = 0; i < size; i++) {
                MenuItemImpl menuItemImpl = (MenuItemImpl) menuBuilder.f855j.get(i);
                if (menuItemImpl.getGroupId() == groupId && menuItemImpl.m1440g() && menuItemImpl.isCheckable()) {
                    menuItemImpl.m1433b(menuItemImpl == this);
                }
            }
        } else {
            m1433b(z);
        }
        return this;
    }

    public final void m1433b(boolean z) {
        int i;
        int i2 = this.f894p;
        int i3 = this.f894p & -3;
        if (z) {
            i = 2;
        } else {
            i = 0;
        }
        this.f894p = i | i3;
        if (i2 != this.f894p) {
            this.f890l.m1410b(false);
        }
    }

    public final boolean isVisible() {
        if (this.f897s == null || !this.f897s.mo326b()) {
            if ((this.f894p & 8) != 0) {
                return false;
            }
            return true;
        } else if ((this.f894p & 8) == 0 && this.f897s.mo327c()) {
            return true;
        } else {
            return false;
        }
    }

    final boolean m1435c(boolean z) {
        int i = this.f894p;
        this.f894p = (z ? 0 : 8) | (this.f894p & -9);
        if (i != this.f894p) {
            return true;
        }
        return false;
    }

    public final MenuItem setVisible(boolean z) {
        if (m1435c(z)) {
            this.f890l.m1418h();
        }
        return this;
    }

    public final MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f893o = onMenuItemClickListener;
        return this;
    }

    public final String toString() {
        return this.f883e.toString();
    }

    public final ContextMenuInfo getMenuInfo() {
        return this.f900v;
    }

    public final boolean m1441j() {
        return (this.f894p & 32) == 32;
    }

    public final boolean m1442k() {
        return (this.f895q & 1) == 1;
    }

    public final boolean m1443l() {
        return (this.f895q & 2) == 2;
    }

    public final void m1437d(boolean z) {
        if (z) {
            this.f894p |= 32;
        } else {
            this.f894p &= -33;
        }
    }

    public final void setShowAsAction(int i) {
        switch (i & 3) {
            case 0:
            case 1:
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                this.f895q = i;
                this.f890l.m1419i();
                return;
            default:
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
    }

    private SupportMenuItem m1426a(View view) {
        this.f896r = view;
        this.f897s = null;
        if (view != null && view.getId() == -1 && this.f879a > 0) {
            view.setId(this.f879a);
        }
        this.f890l.m1419i();
        return this;
    }

    public final MenuItem setActionView(int i) {
        Context context = this.f890l.f850e;
        m1426a(LayoutInflater.from(context).inflate(i, new LinearLayout(context), false));
        return this;
    }

    public final View getActionView() {
        if (this.f896r != null) {
            return this.f896r;
        }
        if (this.f897s == null) {
            return null;
        }
        this.f896r = this.f897s.mo324a((MenuItem) this);
        return this.f896r;
    }

    public final MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public final android.view.ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    public final ActionProvider mo289a() {
        return this.f897s;
    }

    public final SupportMenuItem mo287a(ActionProvider actionProvider) {
        if (this.f897s != null) {
            this.f897s.mo325a(null);
        }
        this.f896r = null;
        this.f897s = actionProvider;
        this.f890l.m1410b(true);
        if (this.f897s != null) {
            this.f897s.mo325a(new C00471(this));
        }
        return this;
    }

    public final MenuItem setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    public final boolean expandActionView() {
        if (!m1444n()) {
            return false;
        }
        if (this.f898t == null || this.f898t.mo322a(this)) {
            return this.f890l.mo332a(this);
        }
        return false;
    }

    public final boolean collapseActionView() {
        if ((this.f895q & 8) == 0) {
            return false;
        }
        if (this.f896r == null) {
            return true;
        }
        if (this.f898t == null || this.f898t.mo323b(this)) {
            return this.f890l.mo334b(this);
        }
        return false;
    }

    public final SupportMenuItem mo288a(OnActionExpandListener onActionExpandListener) {
        this.f898t = onActionExpandListener;
        return this;
    }

    public final boolean m1444n() {
        if ((this.f895q & 8) == 0) {
            return false;
        }
        if (this.f896r == null && this.f897s != null) {
            this.f896r = this.f897s.mo324a((MenuItem) this);
        }
        if (this.f896r != null) {
            return true;
        }
        return false;
    }

    public final void m1438e(boolean z) {
        this.f899u = z;
        this.f890l.m1410b(false);
    }

    public final boolean isActionViewExpanded() {
        return this.f899u;
    }

    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setOnActionExpandListener()");
    }
}

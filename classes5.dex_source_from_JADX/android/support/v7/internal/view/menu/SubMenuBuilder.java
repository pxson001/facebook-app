package android.support.v7.internal.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.internal.view.menu.MenuBuilder.Callback;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* compiled from: unowned_page_attribution */
public class SubMenuBuilder extends MenuBuilder implements SubMenu {
    public MenuBuilder f930d;
    private MenuItemImpl f931e;

    public SubMenuBuilder(Context context, MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        super(context);
        this.f930d = menuBuilder;
        this.f931e = menuItemImpl;
    }

    public void setQwertyMode(boolean z) {
        this.f930d.setQwertyMode(z);
    }

    public final boolean mo333b() {
        return this.f930d.mo333b();
    }

    public final boolean mo335c() {
        return this.f930d.mo335c();
    }

    public MenuItem getItem() {
        return this.f931e;
    }

    public final void mo330a(Callback callback) {
        this.f930d.mo330a(callback);
    }

    public final MenuBuilder mo336q() {
        return this.f930d;
    }

    final boolean mo331a(MenuBuilder menuBuilder, MenuItem menuItem) {
        return super.mo331a(menuBuilder, menuItem) || this.f930d.mo331a(menuBuilder, menuItem);
    }

    public SubMenu setIcon(Drawable drawable) {
        this.f931e.setIcon(drawable);
        return this;
    }

    public SubMenu setIcon(int i) {
        this.f931e.setIcon(i);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        super.m1395a(drawable);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        super.m1397a(charSequence);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        super.m1396a(view);
        return this;
    }

    public final boolean mo332a(MenuItemImpl menuItemImpl) {
        return this.f930d.mo332a(menuItemImpl);
    }

    public final boolean mo334b(MenuItemImpl menuItemImpl) {
        return this.f930d.mo334b(menuItemImpl);
    }

    public final String mo329a() {
        int itemId = this.f931e != null ? this.f931e.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.mo329a() + ":" + itemId;
    }

    public SubMenu setHeaderIcon(int i) {
        super.m1395a(ContextCompat.a(this.f850e, i));
        return this;
    }

    public SubMenu setHeaderTitle(int i) {
        super.m1397a(this.f850e.getResources().getString(i));
        return this;
    }
}

package android.support.v7.internal.view.menu;

import android.content.Context;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.internal.view.SupportSubMenu;
import android.support.v4.util.ArrayMap;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Map;

/* compiled from: update_override */
public abstract class BaseMenuWrapper<T> extends BaseWrapper<T> {
    final Context f815a;
    public Map<SupportMenuItem, MenuItem> f816c;
    public Map<SupportSubMenu, SubMenu> f817d;

    BaseMenuWrapper(Context context, T t) {
        super(t);
        this.f815a = context;
    }

    final MenuItem m1366a(MenuItem menuItem) {
        if (!(menuItem instanceof SupportMenuItem)) {
            return menuItem;
        }
        SupportMenuItem supportMenuItem = (SupportMenuItem) menuItem;
        if (this.f816c == null) {
            this.f816c = new ArrayMap();
        }
        MenuItem menuItem2 = (MenuItem) this.f816c.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        menuItem2 = MenuWrapperFactory.m1473a(this.f815a, supportMenuItem);
        this.f816c.put(supportMenuItem, menuItem2);
        return menuItem2;
    }

    final SubMenu m1367a(SubMenu subMenu) {
        if (!(subMenu instanceof SupportSubMenu)) {
            return subMenu;
        }
        SupportSubMenu supportSubMenu = (SupportSubMenu) subMenu;
        if (this.f817d == null) {
            this.f817d = new ArrayMap();
        }
        SubMenu subMenu2 = (SubMenu) this.f817d.get(supportSubMenu);
        if (subMenu2 != null) {
            return subMenu2;
        }
        subMenu2 = MenuWrapperFactory.m1474a(this.f815a, supportSubMenu);
        this.f817d.put(supportSubMenu, subMenu2);
        return subMenu2;
    }
}

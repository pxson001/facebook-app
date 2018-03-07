package com.facebook.fbui.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.database.DataSetObserver;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import com.facebook.fbui.menu.MenuItemImpl.OnItemChangedListener;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Z)V */
public class PopoverMenu extends BaseAdapter implements Menu, OnItemClickListener, OnItemChangedListener {
    protected Callback f12131a;
    protected MenuPresenter f12132b;
    public Context f12133c;
    private List<MenuItemImpl> f12134d;
    private boolean f12135e = false;
    private ColorStateList f12136f;
    private boolean f12137g = false;

    /* compiled from: Z)V */
    public interface Callback {
        boolean mo1220a(MenuItem menuItem);
    }

    /* compiled from: Z)V */
    public interface MenuPresenter {
        void mo1218a();

        void mo1219a(PopoverMenu popoverMenu, boolean z);
    }

    public /* synthetic */ MenuItem add(int i) {
        return m20159a(i);
    }

    public /* synthetic */ MenuItem add(int i, int i2, int i3, int i4) {
        return m20161a(i2, i3, i4);
    }

    public /* synthetic */ MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return m20162a(i2, i3, charSequence);
    }

    public /* synthetic */ MenuItem add(CharSequence charSequence) {
        return m20163a(charSequence);
    }

    public PopoverMenu(Context context) {
        this.f12133c = context;
        this.f12134d = new ArrayList();
    }

    public final Context m20158a() {
        return this.f12133c;
    }

    public final void m20167a(Callback callback) {
        if (this.f12131a != callback) {
            this.f12131a = callback;
            for (MenuItemImpl menuItemImpl : this.f12134d) {
                if (menuItemImpl.hasSubMenu()) {
                    ((PopoverSubMenu) menuItemImpl.getSubMenu()).m20167a(this.f12131a);
                }
            }
        }
    }

    public final void m20168a(MenuPresenter menuPresenter) {
        if (this.f12132b != menuPresenter) {
            this.f12132b = menuPresenter;
            for (MenuItemImpl menuItemImpl : this.f12134d) {
                if (menuItemImpl.hasSubMenu()) {
                    ((PopoverSubMenu) menuItemImpl.getSubMenu()).m20168a(this.f12132b);
                }
            }
        }
    }

    public final void m20169a(boolean z) {
        if (this.f12135e != z) {
            this.f12135e = z;
            AdapterDetour.a(this, -1817407976);
        }
    }

    public final void m20165a(ColorStateList colorStateList) {
        this.f12137g = true;
        this.f12136f = colorStateList;
        AdapterDetour.a(this, -1025470583);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.f12131a != null) {
            if (adapterView.getAdapter() != this) {
                i--;
            }
            MenuItem item = getItem(i);
            if (item instanceof MenuItemImpl) {
                MenuItemImpl menuItemImpl = (MenuItemImpl) item;
                if (!menuItemImpl.isEnabled()) {
                    return;
                }
                if (menuItemImpl.m20148a()) {
                    close();
                    return;
                } else if (menuItemImpl.hasSubMenu()) {
                    PopoverSubMenu popoverSubMenu = (PopoverSubMenu) menuItemImpl.getSubMenu();
                    if (this.f12132b != null) {
                        this.f12132b.mo1219a(popoverSubMenu, true);
                        return;
                    }
                    return;
                } else {
                    this.f12131a.mo1220a(menuItemImpl);
                    close();
                    return;
                }
            }
            this.f12131a.mo1220a(item);
            close();
        }
    }

    public int getCount() {
        if (this.f12134d == null) {
            return 0;
        }
        int i = 0;
        for (MenuItemImpl isVisible : this.f12134d) {
            int i2;
            if (isVisible.isVisible()) {
                i2 = i + 1;
            } else {
                i2 = i;
            }
            i = i2;
        }
        return i;
    }

    public MenuItem getItem(int i) {
        for (MenuItem menuItem : this.f12134d) {
            if (menuItem.isVisible()) {
                i--;
                continue;
            }
            if (i < 0) {
                return menuItem;
            }
        }
        return null;
    }

    public void close() {
        if (this.f12132b != null) {
            this.f12132b.mo1218a();
        }
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        return false;
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return false;
    }

    public boolean performIdentifierAction(int i, int i2) {
        MenuItem findItem = findItem(i);
        if (findItem instanceof MenuItemImpl) {
            return ((MenuItemImpl) findItem).m20148a();
        }
        return false;
    }

    public void setQwertyMode(boolean z) {
    }

    public long getItemId(int i) {
        return (long) getItem(i).getItemId();
    }

    public boolean hasStableIds() {
        return false;
    }

    public boolean areAllItemsEnabled() {
        return true;
    }

    public boolean isEnabled(int i) {
        return getItem(i).isEnabled();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = new PopoverListItemView(viewGroup.getContext());
        } else {
            PopoverListItemView popoverListItemView = (PopoverListItemView) view;
        }
        view.m20152a(getItem(i));
        view.m20153a(this.f12135e);
        if (this.f12137g) {
            view.m20151a(this.f12136f);
        }
        return view;
    }

    public final MenuItemImpl m20163a(CharSequence charSequence) {
        MenuItemImpl menuItemImpl = new MenuItemImpl((Menu) this, 0, 0, charSequence);
        m20166a(menuItemImpl);
        return menuItemImpl;
    }

    public final MenuItemImpl m20159a(int i) {
        MenuItemImpl menuItemImpl = new MenuItemImpl((Menu) this, 0, 0, i);
        m20166a(menuItemImpl);
        return menuItemImpl;
    }

    public final MenuItemImpl m20162a(int i, int i2, CharSequence charSequence) {
        MenuItemImpl menuItemImpl = new MenuItemImpl((Menu) this, i, i2, charSequence);
        m20166a(menuItemImpl);
        return menuItemImpl;
    }

    public final MenuItemImpl m20161a(int i, int i2, int i3) {
        MenuItemImpl menuItemImpl = new MenuItemImpl((Menu) this, i, i2, i3);
        m20166a(menuItemImpl);
        return menuItemImpl;
    }

    public final MenuItemImpl m20164a(CharSequence charSequence, CharSequence charSequence2) {
        MenuItemImpl menuItemImpl = new MenuItemImpl((Menu) this, 0, 0, charSequence);
        menuItemImpl.m20147a(charSequence2);
        m20166a(menuItemImpl);
        return menuItemImpl;
    }

    public final MenuItemImpl m20160a(int i, int i2) {
        MenuItemImpl menuItemImpl = new MenuItemImpl((Menu) this, 0, 0, i);
        menuItemImpl.m20146a(i2);
        m20166a(menuItemImpl);
        return menuItemImpl;
    }

    public final void m20166a(MenuItemImpl menuItemImpl) {
        if (!this.f12134d.contains(menuItemImpl)) {
            int i = 0;
            for (MenuItemImpl order : this.f12134d) {
                if (order.getOrder() > menuItemImpl.getOrder()) {
                    this.f12134d.add(i, menuItemImpl);
                    AdapterDetour.a(this, -217046141);
                    return;
                }
                i++;
            }
            this.f12134d.add(menuItemImpl);
            AdapterDetour.a(this, -1785285878);
        }
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return m20157a(m20163a(charSequence));
    }

    public SubMenu addSubMenu(int i) {
        return m20157a(m20159a(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return m20157a(m20162a(i2, i3, charSequence));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return m20157a(m20161a(i2, i3, i4));
    }

    private SubMenu m20157a(MenuItem menuItem) {
        SubMenu popoverSubMenu = new PopoverSubMenu(this.f12133c);
        popoverSubMenu.f12152d = this;
        popoverSubMenu.f12151c = menuItem;
        popoverSubMenu.m20167a(this.f12131a);
        popoverSubMenu.m20168a(this.f12132b);
        ((MenuItemImpl) menuItem).f12120n = popoverSubMenu;
        return popoverSubMenu;
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        return 0;
    }

    public void removeItem(int i) {
        Object obj = null;
        for (MenuItemImpl menuItemImpl : this.f12134d) {
            if (menuItemImpl.getItemId() == i) {
                obj = menuItemImpl;
            } else if (menuItemImpl.hasSubMenu()) {
                menuItemImpl.getSubMenu().removeItem(i);
            }
        }
        if (obj != null) {
            this.f12134d.remove(obj);
        }
        AdapterDetour.a(this, -1392451349);
    }

    public void removeGroup(int i) {
    }

    public void clear() {
        this.f12134d.clear();
        AdapterDetour.a(this, 488129259);
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
    }

    public void setGroupVisible(int i, boolean z) {
    }

    public void setGroupEnabled(int i, boolean z) {
    }

    public boolean hasVisibleItems() {
        for (MenuItemImpl isVisible : this.f12134d) {
            if (isVisible.isVisible()) {
                return true;
            }
        }
        return false;
    }

    public MenuItem findItem(int i) {
        for (MenuItemImpl menuItemImpl : this.f12134d) {
            if (menuItemImpl.getItemId() == i) {
                return menuItemImpl;
            }
            if (menuItemImpl.hasSubMenu()) {
                MenuItem findItem = menuItemImpl.getSubMenu().findItem(i);
                if (findItem != null) {
                    return findItem;
                }
            }
        }
        return null;
    }

    public int size() {
        return this.f12134d == null ? 0 : this.f12134d.size();
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        if (dataSetObserver != null) {
            super.unregisterDataSetObserver(dataSetObserver);
        }
    }

    public final void mo1208f() {
        AdapterDetour.a(this, 183210099);
    }
}

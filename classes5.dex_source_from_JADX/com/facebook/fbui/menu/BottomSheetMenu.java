package com.facebook.fbui.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.fbui.menu.MenuItemImpl.OnItemChangedListener;
import com.facebook.messaging.composer.botcomposer.BotMenuContentAdapter.1;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ZERO_RATING_OPTIN */
public class BottomSheetMenu extends Adapter<ViewHolder> implements Menu, OnItemChangedListener {
    protected 1 f12097a;
    protected MenuPresenter f12098b;
    public Context f12099c;
    private List<MenuItem> f12100d;
    private boolean f12101e = false;
    private ColorStateList f12102f;
    private boolean f12103g = false;

    /* compiled from: ZERO_RATING_OPTIN */
    public interface MenuPresenter {
        void m20128a();

        void m20129b();
    }

    /* compiled from: ZERO_RATING_OPTIN */
    class RowViewHolder extends ViewHolder {
        public RowViewHolder(View view) {
            super(view);
        }
    }

    public /* synthetic */ MenuItem add(int i) {
        return m20142e(i);
    }

    public /* synthetic */ MenuItem add(int i, int i2, int i3, int i4) {
        return m20131a(i2, i3, i4);
    }

    public /* synthetic */ MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return m20132a(i2, i3, charSequence);
    }

    public /* synthetic */ MenuItem add(CharSequence charSequence) {
        return m20135a(charSequence);
    }

    public BottomSheetMenu(Context context) {
        this.f12099c = context;
        this.f12100d = new ArrayList();
    }

    public final void m20139a(1 1) {
        if (this.f12097a != 1) {
            this.f12097a = 1;
            for (MenuItem menuItem : this.f12100d) {
                if (menuItem.hasSubMenu()) {
                    ((BottomSheetMenu) menuItem.getSubMenu()).m20139a(this.f12097a);
                }
            }
        }
    }

    public final void m20138a(MenuPresenter menuPresenter) {
        if (this.f12098b != menuPresenter) {
            this.f12098b = menuPresenter;
            for (MenuItem menuItem : this.f12100d) {
                if (menuItem.hasSubMenu()) {
                    ((BottomSheetMenu) menuItem.getSubMenu()).m20138a(this.f12098b);
                }
            }
        }
    }

    public final void m20137a(MenuItem menuItem) {
        if (menuItem instanceof MenuItemImpl) {
            MenuItemImpl menuItemImpl = (MenuItemImpl) menuItem;
            if (menuItemImpl.isEnabled()) {
                if (!menuItemImpl.m20148a()) {
                    if (menuItemImpl.hasSubMenu()) {
                        menuItemImpl.getSubMenu();
                        if (this.f12098b != null) {
                            this.f12098b.m20128a();
                            return;
                        }
                        return;
                    } else if (this.f12097a != null) {
                        this.f12097a.a(menuItemImpl);
                    }
                }
                close();
                return;
            }
            return;
        }
        if (this.f12097a != null) {
            this.f12097a.a(menuItem);
        }
        close();
    }

    public int mo1210e() {
        if (this.f12100d == null) {
            return 0;
        }
        int i = 0;
        for (MenuItem isVisible : this.f12100d) {
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
        for (MenuItem menuItem : this.f12100d) {
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
        if (this.f12098b != null) {
            this.f12098b.m20129b();
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

    public ViewHolder m20134a(ViewGroup viewGroup, int i) {
        return new RowViewHolder(new PopoverListItemView(viewGroup.getContext()));
    }

    public void m20136a(ViewHolder viewHolder, int i) {
        PopoverListItemView popoverListItemView = (PopoverListItemView) viewHolder.a;
        popoverListItemView.m20152a(getItem(i));
        popoverListItemView.m20153a(this.f12101e);
        if (this.f12103g) {
            popoverListItemView.m20151a(this.f12102f);
        }
    }

    public final long H_(int i) {
        return (long) getItem(i).getItemId();
    }

    public int aZ_() {
        return mo1210e();
    }

    public final MenuItemImpl m20135a(CharSequence charSequence) {
        Object menuItemImpl = new MenuItemImpl((Menu) this, 0, 0, charSequence);
        m20140b(menuItemImpl);
        return menuItemImpl;
    }

    public final MenuItemImpl m20142e(int i) {
        Object menuItemImpl = new MenuItemImpl((Menu) this, 0, 0, i);
        m20140b(menuItemImpl);
        return menuItemImpl;
    }

    private MenuItemImpl m20132a(int i, int i2, CharSequence charSequence) {
        Object menuItemImpl = new MenuItemImpl((Menu) this, i, i2, charSequence);
        m20140b(menuItemImpl);
        return menuItemImpl;
    }

    private MenuItemImpl m20131a(int i, int i2, int i3) {
        Object menuItemImpl = new MenuItemImpl((Menu) this, i, i2, i3);
        m20140b(menuItemImpl);
        return menuItemImpl;
    }

    public final void m20140b(MenuItem menuItem) {
        if (!this.f12100d.contains(menuItem)) {
            int i = 0;
            for (MenuItem order : this.f12100d) {
                if (order.getOrder() > menuItem.getOrder()) {
                    this.f12100d.add(i, menuItem);
                    notifyDataSetChanged();
                    return;
                }
                i++;
            }
            this.f12100d.add(menuItem);
            notifyDataSetChanged();
        }
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return m20133c(m20135a(charSequence));
    }

    public SubMenu addSubMenu(int i) {
        return m20133c(m20142e(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return m20133c(m20132a(i2, i3, charSequence));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return m20133c(m20131a(i2, i3, i4));
    }

    private SubMenu m20133c(MenuItem menuItem) {
        if (!(menuItem instanceof MenuItemImpl)) {
            return null;
        }
        SubMenu bottomSheetSubMenu = new BottomSheetSubMenu(this.f12099c);
        bottomSheetSubMenu.f12105d = this;
        bottomSheetSubMenu.f12104c = menuItem;
        bottomSheetSubMenu.m20139a(this.f12097a);
        bottomSheetSubMenu.m20138a(this.f12098b);
        ((MenuItemImpl) menuItem).f12120n = bottomSheetSubMenu;
        return bottomSheetSubMenu;
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        return 0;
    }

    public void removeItem(int i) {
        Object obj = null;
        for (MenuItem menuItem : this.f12100d) {
            if (menuItem.getItemId() == i) {
                obj = menuItem;
            } else if (menuItem.hasSubMenu()) {
                menuItem.getSubMenu().removeItem(i);
            }
        }
        if (obj != null) {
            this.f12100d.remove(obj);
        }
        notifyDataSetChanged();
    }

    public void removeGroup(int i) {
    }

    public void clear() {
        this.f12100d.clear();
        notifyDataSetChanged();
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
    }

    public void setGroupVisible(int i, boolean z) {
    }

    public void setGroupEnabled(int i, boolean z) {
    }

    public boolean hasVisibleItems() {
        for (MenuItem isVisible : this.f12100d) {
            if (isVisible.isVisible()) {
                return true;
            }
        }
        return false;
    }

    public MenuItem findItem(int i) {
        for (MenuItem menuItem : this.f12100d) {
            MenuItem menuItem2;
            if (menuItem2.getItemId() == i) {
                return menuItem2;
            }
            if (menuItem2.hasSubMenu()) {
                menuItem2 = menuItem2.getSubMenu().findItem(i);
                if (menuItem2 != null) {
                    return menuItem2;
                }
            }
        }
        return null;
    }

    public int size() {
        return this.f12100d == null ? 0 : this.f12100d.size();
    }

    public final void mo1208f() {
        notifyDataSetChanged();
    }
}

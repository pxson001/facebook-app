package com.facebook.fbui.menu;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;

/* compiled from: unsubscribe_description */
public class MenuItemImpl implements MenuItem {
    private int f12107a;
    private int f12108b;
    private CharSequence f12109c;
    public CharSequence f12110d;
    public CharSequence f12111e;
    private boolean f12112f = false;
    private boolean f12113g = false;
    private boolean f12114h = true;
    private boolean f12115i = true;
    public boolean f12116j = false;
    public boolean f12117k = false;
    private Drawable f12118l;
    private Menu f12119m;
    public SubMenu f12120n;
    private OnMenuItemClickListener f12121o;

    /* compiled from: unsubscribe_description */
    public interface OnItemChangedListener {
        void mo1208f();
    }

    public MenuItemImpl(Menu menu, int i, int i2, int i3) {
        this.f12119m = menu;
        this.f12107a = i;
        this.f12108b = i2;
        setTitle(i3);
    }

    public MenuItemImpl(Menu menu, int i, int i2, CharSequence charSequence) {
        this.f12119m = menu;
        this.f12107a = i;
        this.f12108b = i2;
        setTitle(charSequence);
    }

    final boolean m20148a() {
        if (this.f12121o != null) {
            return this.f12121o.onMenuItemClick(this);
        }
        return false;
    }

    public int getItemId() {
        return this.f12107a;
    }

    public int getGroupId() {
        return 0;
    }

    public int getOrder() {
        return this.f12108b;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f12109c = charSequence;
        if (this.f12119m instanceof OnItemChangedListener) {
            ((OnItemChangedListener) this.f12119m).mo1208f();
        }
        return this;
    }

    public MenuItem setTitle(int i) {
        Context context;
        if (this.f12119m instanceof PopoverMenu) {
            context = ((PopoverMenu) this.f12119m).f12133c;
        } else {
            context = ((BottomSheetMenu) this.f12119m).f12099c;
        }
        return setTitle(context.getResources().getString(i));
    }

    public CharSequence getTitle() {
        return this.f12109c;
    }

    public final MenuItem m20147a(CharSequence charSequence) {
        this.f12110d = charSequence;
        if (this.f12119m instanceof OnItemChangedListener) {
            ((OnItemChangedListener) this.f12119m).mo1208f();
        }
        return this;
    }

    public final MenuItem m20146a(int i) {
        Context context;
        if (this.f12119m instanceof PopoverMenu) {
            context = ((PopoverMenu) this.f12119m).f12133c;
        } else {
            context = ((BottomSheetMenu) this.f12119m).f12099c;
        }
        return m20147a(context.getResources().getString(i));
    }

    public final MenuItem m20149b(CharSequence charSequence) {
        this.f12111e = charSequence;
        if (this.f12119m instanceof OnItemChangedListener) {
            ((OnItemChangedListener) this.f12119m).mo1208f();
        }
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        return this;
    }

    public CharSequence getTitleCondensed() {
        return null;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f12118l = drawable;
        if (this.f12119m instanceof OnItemChangedListener) {
            ((OnItemChangedListener) this.f12119m).mo1208f();
        }
        return this;
    }

    public MenuItem setIcon(int i) {
        if (i > 0) {
            Context context;
            if (this.f12119m instanceof PopoverMenu) {
                context = ((PopoverMenu) this.f12119m).f12133c;
            } else {
                context = ((BottomSheetMenu) this.f12119m).f12099c;
            }
            setIcon(context.getResources().getDrawable(i));
        }
        return this;
    }

    public Drawable getIcon() {
        return this.f12118l;
    }

    public MenuItem setVisible(boolean z) {
        if (this.f12114h != z) {
            this.f12114h = z;
            if (this.f12119m instanceof OnItemChangedListener) {
                ((OnItemChangedListener) this.f12119m).mo1208f();
            }
        }
        return this;
    }

    public boolean isVisible() {
        if (hasSubMenu()) {
            return this.f12114h && this.f12120n.hasVisibleItems();
        } else {
            return this.f12114h;
        }
    }

    public MenuItem setEnabled(boolean z) {
        if (this.f12115i != z) {
            this.f12115i = z;
            if (this.f12119m instanceof OnItemChangedListener) {
                ((OnItemChangedListener) this.f12119m).mo1208f();
            }
        }
        return this;
    }

    public boolean isEnabled() {
        return this.f12115i;
    }

    public boolean hasSubMenu() {
        return this.f12120n != null;
    }

    public SubMenu getSubMenu() {
        return this.f12120n;
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f12121o = onMenuItemClickListener;
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        return this;
    }

    public Intent getIntent() {
        return null;
    }

    public MenuItem setShortcut(char c, char c2) {
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        return this;
    }

    public char getNumericShortcut() {
        return '\u0000';
    }

    public MenuItem setAlphabeticShortcut(char c) {
        return this;
    }

    public char getAlphabeticShortcut() {
        return '\u0000';
    }

    public MenuItem setCheckable(boolean z) {
        if (this.f12112f != z) {
            this.f12112f = z;
            if (this.f12119m instanceof OnItemChangedListener) {
                ((OnItemChangedListener) this.f12119m).mo1208f();
            }
        }
        return this;
    }

    public boolean isCheckable() {
        return this.f12112f;
    }

    public MenuItem setChecked(boolean z) {
        if (this.f12113g != z) {
            this.f12113g = z;
            if (this.f12119m instanceof OnItemChangedListener) {
                ((OnItemChangedListener) this.f12119m).mo1208f();
            }
        }
        return this;
    }

    public boolean isChecked() {
        return this.f12113g;
    }

    public ContextMenuInfo getMenuInfo() {
        return null;
    }

    public void setShowAsAction(int i) {
    }

    public MenuItem setShowAsActionFlags(int i) {
        return null;
    }

    public MenuItem setActionView(View view) {
        return null;
    }

    public MenuItem setActionView(int i) {
        return null;
    }

    public View getActionView() {
        return null;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        return null;
    }

    public ActionProvider getActionProvider() {
        return null;
    }

    public boolean expandActionView() {
        return false;
    }

    public boolean collapseActionView() {
        return false;
    }

    public boolean isActionViewExpanded() {
        return false;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        return null;
    }
}

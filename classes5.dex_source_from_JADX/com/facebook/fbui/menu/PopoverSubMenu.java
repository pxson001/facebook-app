package com.facebook.fbui.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.AdapterView;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;

/* compiled from: Z */
public class PopoverSubMenu extends PopoverMenu implements SubMenu {
    public MenuItem f12151c;
    public PopoverMenu f12152d;
    private MenuItem f12153e;

    public PopoverSubMenu(Context context) {
        super(context);
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        m20174a(charSequence, null);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        m20174a(null, drawable);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        return this;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.f12131a != null) {
            if (this.f12153e == null || i != 0 || this.f12132b == null) {
                super.onItemClick(adapterView, view, i, j);
            } else {
                this.f12132b.mo1219a(this.f12152d, false);
            }
        }
    }

    public SubMenu setHeaderIcon(int i) {
        setHeaderIcon(this.f12133c.getResources().getDrawable(i));
        return this;
    }

    public SubMenu setHeaderTitle(int i) {
        setHeaderTitle(this.f12133c.getString(i));
        return this;
    }

    public int getCount() {
        int count = super.getCount();
        return this.f12153e != null ? count + 1 : count;
    }

    public int size() {
        int size = super.size();
        return this.f12153e != null ? size + 1 : size;
    }

    public MenuItem getItem(int i) {
        if (this.f12153e != null) {
            if (i == 0) {
                return this.f12153e;
            }
            i--;
        }
        return super.getItem(i);
    }

    public void clearHeader() {
        this.f12153e = null;
    }

    public void clear() {
        clearHeader();
        super.clear();
    }

    public SubMenu setIcon(int i) {
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        return this;
    }

    public MenuItem getItem() {
        return this.f12151c;
    }

    private void m20174a(CharSequence charSequence, Drawable drawable) {
        if (this.f12153e == null) {
            this.f12153e = new MenuItemImpl((Menu) this, 0, 0, charSequence);
        }
        if (charSequence != null) {
            this.f12153e.setTitle(charSequence);
        }
        if (drawable != null) {
            this.f12153e.setIcon(drawable);
        }
        AdapterDetour.a(this, -1393496040);
    }
}

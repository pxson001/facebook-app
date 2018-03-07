package com.facebook.fbui.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* compiled from: ZERO_RATING_MEGAPHONE_SHARE */
public class BottomSheetSubMenu extends BottomSheetMenu implements SubMenu {
    public MenuItem f12104c;
    public BottomSheetMenu f12105d;
    private MenuItem f12106e;

    public BottomSheetSubMenu(Context context) {
        super(context);
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        m20144a(charSequence, null);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        m20144a(null, drawable);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        return this;
    }

    public final int mo1210e() {
        int e = super.mo1210e();
        return this.f12106e != null ? e + 1 : e;
    }

    public int size() {
        int size = super.size();
        return this.f12106e != null ? size + 1 : size;
    }

    public SubMenu setHeaderIcon(int i) {
        setHeaderIcon(this.f12099c.getResources().getDrawable(i));
        return this;
    }

    public SubMenu setHeaderTitle(int i) {
        setHeaderTitle(this.f12099c.getString(i));
        return this;
    }

    public MenuItem getItem(int i) {
        if (this.f12106e != null) {
            if (i == 0) {
                return this.f12106e;
            }
            i--;
        }
        return super.getItem(i);
    }

    public void clearHeader() {
        this.f12106e = null;
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
        return this.f12104c;
    }

    private void m20144a(CharSequence charSequence, Drawable drawable) {
        if (this.f12106e == null) {
            this.f12106e = new MenuItemImpl((Menu) this, 0, 0, charSequence);
        }
        if (charSequence != null) {
            this.f12106e.setTitle(charSequence);
        }
        if (drawable != null) {
            this.f12106e.setIcon(drawable);
        }
        notifyDataSetChanged();
    }
}

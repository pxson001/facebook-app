package android.support.v7.internal.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.internal.view.SupportSubMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* compiled from: unowned_page_action_menu_report_page */
class SubMenuWrapperICS extends MenuWrapperICS implements SubMenu {
    SubMenuWrapperICS(Context context, SupportSubMenu supportSubMenu) {
        super(context, supportSubMenu);
    }

    private SupportSubMenu m1483b() {
        return (SupportSubMenu) this.f814b;
    }

    public SubMenu setHeaderTitle(int i) {
        m1483b().setHeaderTitle(i);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        m1483b().setHeaderTitle(charSequence);
        return this;
    }

    public SubMenu setHeaderIcon(int i) {
        m1483b().setHeaderIcon(i);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        m1483b().setHeaderIcon(drawable);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        m1483b().setHeaderView(view);
        return this;
    }

    public void clearHeader() {
        m1483b().clearHeader();
    }

    public SubMenu setIcon(int i) {
        m1483b().setIcon(i);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        m1483b().setIcon(drawable);
        return this;
    }

    public MenuItem getItem() {
        return m1366a(m1483b().getItem());
    }
}

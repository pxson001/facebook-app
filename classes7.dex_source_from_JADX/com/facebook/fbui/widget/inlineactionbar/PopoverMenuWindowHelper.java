package com.facebook.fbui.widget.inlineactionbar;

import android.content.Context;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuItemImpl;
import android.support.v7.internal.view.menu.MenuPresenter;
import android.support.v7.internal.view.menu.MenuPresenter.Callback;
import android.support.v7.internal.view.menu.SubMenuBuilder;
import android.view.MenuItem;
import android.view.View;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.fbui.popover.PopoverMenuWindow;
import com.facebook.fbui.popover.PopoverMenuWindow.OnMenuItemClickListener;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.fbui.popover.PopoverWindow.OnDismissListener;
import com.facebook.fig.menu.FigPopoverMenuWindow;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import java.util.ArrayList;

/* compiled from: source_card_style */
public class PopoverMenuWindowHelper implements MenuPresenter, OnMenuItemClickListener, OnDismissListener {
    private Context f3611a;
    private PopoverMenuWindow f3612b;
    public MenuBuilder f3613c;
    private View f3614d;
    public boolean f3615e;
    private MenuAdapter f3616f;
    public Callback f3617g;

    /* compiled from: source_card_style */
    class MenuAdapter extends PopoverMenu {
        final /* synthetic */ PopoverMenuWindowHelper f3632c;
        public MenuBuilder f3633d;
        private int f3634e = -1;

        public /* synthetic */ MenuItem getItem(int i) {
            return m4358b(i);
        }

        public /* synthetic */ Object m26530getItem(int i) {
            return m4358b(i);
        }

        public MenuAdapter(PopoverMenuWindowHelper popoverMenuWindowHelper, Context context, MenuBuilder menuBuilder) {
            this.f3632c = popoverMenuWindowHelper;
            super(context);
            this.f3633d = menuBuilder;
            m4359b();
        }

        public int getCount() {
            ArrayList m = this.f3632c.f3615e ? this.f3633d.m() : this.f3633d.j();
            if (this.f3634e < 0) {
                return m.size();
            }
            return m.size() - 1;
        }

        public boolean hasVisibleItems() {
            return this.f3633d.hasVisibleItems();
        }

        private MenuItemImpl m4358b(int i) {
            ArrayList m = this.f3632c.f3615e ? this.f3633d.m() : this.f3633d.j();
            if (this.f3634e >= 0 && i >= this.f3634e) {
                i++;
            }
            return (MenuItemImpl) m.get(i);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        private void m4359b() {
            MenuItemImpl menuItemImpl = this.f3632c.f3613c.x;
            if (menuItemImpl != null) {
                ArrayList m = this.f3632c.f3613c.m();
                int size = m.size();
                for (int i = 0; i < size; i++) {
                    if (((MenuItemImpl) m.get(i)) == menuItemImpl) {
                        this.f3634e = i;
                        return;
                    }
                }
            }
            this.f3634e = -1;
        }

        public void notifyDataSetChanged() {
            m4359b();
            super.notifyDataSetChanged();
        }
    }

    public PopoverMenuWindowHelper(Context context, MenuBuilder menuBuilder, View view, boolean z) {
        this.f3611a = context;
        this.f3613c = menuBuilder;
        this.f3615e = z;
        this.f3614d = view;
        menuBuilder.a(this);
    }

    public final boolean m4333a() {
        this.f3612b = new FigPopoverMenuWindow(this.f3611a);
        this.f3612b.H = this;
        this.f3612b.p = this;
        this.f3616f = new MenuAdapter(this, this.f3611a, this.f3613c);
        this.f3612b.a(this.f3616f);
        View view = this.f3614d;
        if (view == null) {
            return false;
        }
        this.f3612b.c(view);
        this.f3612b.d();
        return true;
    }

    public final void m4340c() {
        if (m4342d()) {
            this.f3612b.l();
        }
    }

    public boolean mo173a(PopoverWindow popoverWindow) {
        this.f3612b = null;
        this.f3613c.close();
        return true;
    }

    public final boolean m4342d() {
        return this.f3612b != null && this.f3612b.r;
    }

    public final boolean m4335a(MenuItem menuItem) {
        this.f3616f.f3633d.a(menuItem, 0);
        return true;
    }

    public final void m4331a(Context context, MenuBuilder menuBuilder) {
    }

    public final void m4337b(boolean z) {
        if (this.f3616f != null) {
            AdapterDetour.a(this.f3616f, -1398714857);
        }
    }

    public final boolean m4334a(SubMenuBuilder subMenuBuilder) {
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        PopoverMenuWindowHelper popoverMenuWindowHelper = new PopoverMenuWindowHelper(this.f3611a, subMenuBuilder, this.f3614d, false);
        popoverMenuWindowHelper.f3617g = this.f3617g;
        if (!popoverMenuWindowHelper.m4333a()) {
            return false;
        }
        if (this.f3617g != null) {
            this.f3617g.a_(subMenuBuilder);
        }
        return true;
    }

    public final void m4332a(MenuBuilder menuBuilder, boolean z) {
        if (menuBuilder == this.f3613c) {
            m4340c();
            if (this.f3617g != null) {
                this.f3617g.a(menuBuilder, z);
            }
        }
    }

    public final boolean m4338b() {
        return false;
    }

    public final boolean m4339b(MenuItemImpl menuItemImpl) {
        return false;
    }

    public final boolean m4341c(MenuItemImpl menuItemImpl) {
        return false;
    }
}

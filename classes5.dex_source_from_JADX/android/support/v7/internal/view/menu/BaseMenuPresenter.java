package android.support.v7.internal.view.menu;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v7.internal.view.menu.MenuPresenter.Callback;
import android.support.v7.internal.view.menu.MenuView.ItemView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* compiled from: uploadAccount= */
public abstract class BaseMenuPresenter implements MenuPresenter {
    protected Context f804a;
    public Context f805b;
    public MenuBuilder f806c;
    protected LayoutInflater f807d;
    protected LayoutInflater f808e;
    public MenuView f809f;
    public Callback f810g;
    private int f811h;
    private int f812i;
    public int f813j;

    public abstract void mo421a(MenuItemImpl menuItemImpl, ItemView itemView);

    public BaseMenuPresenter(Context context, int i, int i2) {
        this.f804a = context;
        this.f807d = LayoutInflater.from(context);
        this.f811h = i;
        this.f812i = i2;
    }

    public void mo306a(Context context, MenuBuilder menuBuilder) {
        this.f805b = context;
        this.f808e = LayoutInflater.from(this.f805b);
        this.f806c = menuBuilder;
    }

    public MenuView mo419a(ViewGroup viewGroup) {
        if (this.f809f == null) {
            this.f809f = (MenuView) this.f807d.inflate(this.f811h, viewGroup, false);
            this.f809f.mo313a(this.f806c);
            mo309b(true);
        }
        return this.f809f;
    }

    public void mo309b(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.f809f;
        if (viewGroup != null) {
            int i;
            if (this.f806c != null) {
                this.f806c.m1421k();
                ArrayList j = this.f806c.m1420j();
                int size = j.size();
                int i2 = 0;
                i = 0;
                while (i2 < size) {
                    int i3;
                    MenuItemImpl menuItemImpl = (MenuItemImpl) j.get(i2);
                    if (mo423a(menuItemImpl)) {
                        View childAt = viewGroup.getChildAt(i);
                        MenuItemImpl itemData = childAt instanceof ItemView ? ((ItemView) childAt).getItemData() : null;
                        View a = mo420a(menuItemImpl, childAt, viewGroup);
                        if (menuItemImpl != itemData) {
                            a.setPressed(false);
                            ViewCompat.a.C(a);
                        }
                        if (a != childAt) {
                            ViewGroup viewGroup2 = (ViewGroup) a.getParent();
                            if (viewGroup2 != null) {
                                viewGroup2.removeView(a);
                            }
                            ((ViewGroup) this.f809f).addView(a, i);
                        }
                        i3 = i + 1;
                    } else {
                        i3 = i;
                    }
                    i2++;
                    i = i3;
                }
            } else {
                i = 0;
            }
            while (i < viewGroup.getChildCount()) {
                if (!mo424a(viewGroup, i)) {
                    i++;
                }
            }
        }
    }

    protected boolean mo424a(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    public ItemView m1361b(ViewGroup viewGroup) {
        return (ItemView) this.f807d.inflate(this.f812i, viewGroup, false);
    }

    public View mo420a(MenuItemImpl menuItemImpl, View view, ViewGroup viewGroup) {
        ItemView itemView;
        if (view instanceof ItemView) {
            itemView = (ItemView) view;
        } else {
            itemView = m1361b(viewGroup);
        }
        mo421a(menuItemImpl, itemView);
        return (View) itemView;
    }

    public boolean mo423a(MenuItemImpl menuItemImpl) {
        return true;
    }

    public void mo307a(MenuBuilder menuBuilder, boolean z) {
        if (this.f810g != null) {
            this.f810g.mo228a(menuBuilder, z);
        }
    }

    public boolean mo308a(SubMenuBuilder subMenuBuilder) {
        if (this.f810g != null) {
            return this.f810g.a_(subMenuBuilder);
        }
        return false;
    }

    public boolean mo310b() {
        return false;
    }

    public final boolean mo311b(MenuItemImpl menuItemImpl) {
        return false;
    }

    public final boolean mo312c(MenuItemImpl menuItemImpl) {
        return false;
    }
}

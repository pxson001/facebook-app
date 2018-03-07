package android.support.v7.internal.view.menu;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.support.v7.internal.view.menu.MenuPresenter.Callback;
import android.support.v7.internal.view.menu.MenuView.ItemView;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import java.util.ArrayList;

/* compiled from: upcoming_card */
public class ListMenuPresenter implements MenuPresenter, OnItemClickListener {
    Context f837a;
    public LayoutInflater f838b;
    MenuBuilder f839c;
    public ExpandedMenuView f840d;
    int f841e;
    int f842f;
    public MenuAdapter f843g;
    public int f844h;
    public Callback f845i;

    /* compiled from: upcoming_card */
    public class MenuAdapter extends BaseAdapter {
        final /* synthetic */ ListMenuPresenter f835a;
        private int f836b = -1;

        public /* synthetic */ Object getItem(int i) {
            return m1377a(i);
        }

        public MenuAdapter(ListMenuPresenter listMenuPresenter) {
            this.f835a = listMenuPresenter;
            m1376a();
        }

        public int getCount() {
            int size = this.f835a.f839c.m1422m().size() - this.f835a.f844h;
            return this.f836b < 0 ? size : size - 1;
        }

        public final MenuItemImpl m1377a(int i) {
            ArrayList m = this.f835a.f839c.m1422m();
            int i2 = this.f835a.f844h + i;
            if (this.f836b >= 0 && i2 >= this.f836b) {
                i2++;
            }
            return (MenuItemImpl) m.get(i2);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            View inflate;
            if (view == null) {
                inflate = this.f835a.f838b.inflate(this.f835a.f842f, viewGroup, false);
            } else {
                inflate = view;
            }
            ((ItemView) inflate).mo301a(m1377a(i), 0);
            return inflate;
        }

        private void m1376a() {
            MenuItemImpl menuItemImpl = this.f835a.f839c.f869x;
            if (menuItemImpl != null) {
                ArrayList m = this.f835a.f839c.m1422m();
                int size = m.size();
                for (int i = 0; i < size; i++) {
                    if (((MenuItemImpl) m.get(i)) == menuItemImpl) {
                        this.f836b = i;
                        return;
                    }
                }
            }
            this.f836b = -1;
        }

        public void notifyDataSetChanged() {
            m1376a();
            super.notifyDataSetChanged();
        }
    }

    public ListMenuPresenter(Context context, int i) {
        this(i, 0);
        this.f837a = context;
        this.f838b = LayoutInflater.from(this.f837a);
    }

    public ListMenuPresenter(int i, int i2) {
        this.f842f = i;
        this.f841e = i2;
    }

    public final void mo306a(Context context, MenuBuilder menuBuilder) {
        if (this.f841e != 0) {
            this.f837a = new ContextThemeWrapper(context, this.f841e);
            this.f838b = LayoutInflater.from(this.f837a);
        } else if (this.f837a != null) {
            this.f837a = context;
            if (this.f838b == null) {
                this.f838b = LayoutInflater.from(this.f837a);
            }
        }
        this.f839c = menuBuilder;
        if (this.f843g != null) {
            AdapterDetour.a(this.f843g, -1318884659);
        }
    }

    public final ListAdapter m1378a() {
        if (this.f843g == null) {
            this.f843g = new MenuAdapter(this);
        }
        return this.f843g;
    }

    public final void mo309b(boolean z) {
        if (this.f843g != null) {
            AdapterDetour.a(this.f843g, 1780550523);
        }
    }

    public final boolean mo308a(SubMenuBuilder subMenuBuilder) {
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        MenuDialogHelper menuDialogHelper = new MenuDialogHelper(subMenuBuilder);
        MenuBuilder menuBuilder = menuDialogHelper.f871b;
        Builder builder = new Builder(menuBuilder.f850e);
        menuDialogHelper.f870a = new ListMenuPresenter(2130903053, 2131624146);
        menuDialogHelper.f870a.f845i = menuDialogHelper;
        menuDialogHelper.f871b.m1401a(menuDialogHelper.f870a);
        builder.setAdapter(menuDialogHelper.f870a.m1378a(), menuDialogHelper);
        View view = menuBuilder.f849c;
        if (view != null) {
            builder.setCustomTitle(view);
        } else {
            builder.setIcon(menuBuilder.f848b).setTitle(menuBuilder.f847a);
        }
        builder.setOnKeyListener(menuDialogHelper);
        menuDialogHelper.f872c = builder.create();
        menuDialogHelper.f872c.setOnDismissListener(menuDialogHelper);
        LayoutParams attributes = menuDialogHelper.f872c.getWindow().getAttributes();
        attributes.type = 1003;
        if (null != null) {
            attributes.token = null;
        }
        attributes.flags |= 131072;
        menuDialogHelper.f872c.show();
        if (this.f845i != null) {
            this.f845i.a_(subMenuBuilder);
        }
        return true;
    }

    public final void mo307a(MenuBuilder menuBuilder, boolean z) {
        if (this.f845i != null) {
            this.f845i.mo228a(menuBuilder, z);
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f839c.m1407a(this.f843g.m1377a(i), (MenuPresenter) this, 0);
    }

    public final boolean mo310b() {
        return false;
    }

    public final boolean mo311b(MenuItemImpl menuItemImpl) {
        return false;
    }

    public final boolean mo312c(MenuItemImpl menuItemImpl) {
        return false;
    }
}

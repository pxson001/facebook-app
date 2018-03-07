package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.internal.view.menu.MenuPresenter.Callback;
import android.support.v7.internal.view.menu.MenuView.ItemView;
import android.support.v7.widget.ListPopupWindow;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import java.util.ArrayList;

/* compiled from: unowned_place_photo_inline */
public class MenuPopupHelper implements MenuPresenter, OnKeyListener, OnGlobalLayoutListener, OnItemClickListener, OnDismissListener {
    static final int f912a = 2130903055;
    public boolean f913b;
    private final Context f914c;
    public final LayoutInflater f915d;
    public final MenuBuilder f916e;
    private final MenuAdapter f917f;
    public final boolean f918g;
    private final int f919h;
    private final int f920i;
    private final int f921j;
    public View f922k;
    public ListPopupWindow f923l;
    private ViewTreeObserver f924m;
    public Callback f925n;
    private ViewGroup f926o;
    private boolean f927p;
    private int f928q;
    public int f929r;

    /* compiled from: unowned_place_photo_inline */
    class MenuAdapter extends BaseAdapter {
        final /* synthetic */ MenuPopupHelper f909a;
        public MenuBuilder f910b;
        private int f911c = -1;

        public /* synthetic */ Object getItem(int i) {
            return m1459a(i);
        }

        public MenuAdapter(MenuPopupHelper menuPopupHelper, MenuBuilder menuBuilder) {
            this.f909a = menuPopupHelper;
            this.f910b = menuBuilder;
            m1458a();
        }

        public int getCount() {
            ArrayList m = this.f909a.f918g ? this.f910b.m1422m() : this.f910b.m1420j();
            if (this.f911c < 0) {
                return m.size();
            }
            return m.size() - 1;
        }

        public final MenuItemImpl m1459a(int i) {
            ArrayList m = this.f909a.f918g ? this.f910b.m1422m() : this.f910b.m1420j();
            if (this.f911c >= 0 && i >= this.f911c) {
                i++;
            }
            return (MenuItemImpl) m.get(i);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            View inflate;
            if (view == null) {
                inflate = this.f909a.f915d.inflate(MenuPopupHelper.f912a, viewGroup, false);
            } else {
                inflate = view;
            }
            ItemView itemView = (ItemView) inflate;
            if (this.f909a.f913b) {
                ((ListMenuItemView) inflate).setForceShowIcon(true);
            }
            itemView.mo301a(m1459a(i), 0);
            return inflate;
        }

        private void m1458a() {
            MenuItemImpl menuItemImpl = this.f909a.f916e.f869x;
            if (menuItemImpl != null) {
                ArrayList m = this.f909a.f916e.m1422m();
                int size = m.size();
                for (int i = 0; i < size; i++) {
                    if (((MenuItemImpl) m.get(i)) == menuItemImpl) {
                        this.f911c = i;
                        return;
                    }
                }
            }
            this.f911c = -1;
        }

        public void notifyDataSetChanged() {
            m1458a();
            super.notifyDataSetChanged();
        }
    }

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder, View view) {
        this(context, menuBuilder, view, false, 2130772026);
    }

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder, View view, boolean z, int i) {
        this(context, menuBuilder, view, z, i, 0);
    }

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder, View view, boolean z, int i, int i2) {
        this.f929r = 0;
        this.f914c = context;
        this.f915d = LayoutInflater.from(context);
        this.f916e = menuBuilder;
        this.f917f = new MenuAdapter(this, this.f916e);
        this.f918g = z;
        this.f920i = i;
        this.f921j = i2;
        Resources resources = context.getResources();
        this.f919h = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(2131427330));
        this.f922k = view;
        menuBuilder.m1402a((MenuPresenter) this, context);
    }

    public final void m1461a() {
        if (!m1469d()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public final boolean m1469d() {
        boolean z = false;
        this.f923l = new ListPopupWindow(this.f914c, null, this.f920i, this.f921j);
        this.f923l.m1659a((OnDismissListener) this);
        this.f923l.f1180t = this;
        this.f923l.mo369a(this.f917f);
        this.f923l.m1660a(true);
        View view = this.f922k;
        if (view == null) {
            return false;
        }
        if (this.f924m == null) {
            z = true;
        }
        this.f924m = view.getViewTreeObserver();
        if (z) {
            this.f924m.addOnGlobalLayoutListener(this);
        }
        this.f923l.f1178r = view;
        this.f923l.f1172l = this.f929r;
        if (!this.f927p) {
            this.f928q = m1460g();
            this.f927p = true;
        }
        this.f923l.m1663c(this.f928q);
        this.f923l.f1164d.setInputMethodMode(2);
        this.f923l.m1662c();
        this.f923l.f1166f.setOnKeyListener(this);
        return true;
    }

    public final void m1470e() {
        if (m1471f()) {
            this.f923l.m1657a();
        }
    }

    public void onDismiss() {
        this.f923l = null;
        this.f916e.close();
        if (this.f924m != null) {
            if (!this.f924m.isAlive()) {
                this.f924m = this.f922k.getViewTreeObserver();
            }
            this.f924m.removeGlobalOnLayoutListener(this);
            this.f924m = null;
        }
    }

    public final boolean m1471f() {
        return this.f923l != null && this.f923l.m1661b();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        MenuAdapter menuAdapter = this.f917f;
        menuAdapter.f910b.m1406a(menuAdapter.m1459a(i), 0);
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        m1470e();
        return true;
    }

    private int m1460g() {
        ListAdapter listAdapter = this.f917f;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i = 0;
        int i2 = 0;
        View view = null;
        int i3 = 0;
        while (i < count) {
            View view2;
            int itemViewType = listAdapter.getItemViewType(i);
            if (itemViewType != i2) {
                i2 = itemViewType;
                view2 = null;
            } else {
                view2 = view;
            }
            if (this.f926o == null) {
                this.f926o = new FrameLayout(this.f914c);
            }
            view = listAdapter.getView(i, view2, this.f926o);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            itemViewType = view.getMeasuredWidth();
            if (itemViewType >= this.f919h) {
                return this.f919h;
            }
            if (itemViewType <= i3) {
                itemViewType = i3;
            }
            i++;
            i3 = itemViewType;
        }
        return i3;
    }

    public void onGlobalLayout() {
        if (m1471f()) {
            View view = this.f922k;
            if (view == null || !view.isShown()) {
                m1470e();
            } else if (m1471f()) {
                this.f923l.m1662c();
            }
        }
    }

    public final void mo306a(Context context, MenuBuilder menuBuilder) {
    }

    public final void mo309b(boolean z) {
        this.f927p = false;
        if (this.f917f != null) {
            AdapterDetour.a(this.f917f, 576999916);
        }
    }

    public final boolean mo308a(SubMenuBuilder subMenuBuilder) {
        if (subMenuBuilder.hasVisibleItems()) {
            boolean z;
            MenuPopupHelper menuPopupHelper = new MenuPopupHelper(this.f914c, subMenuBuilder, this.f922k);
            menuPopupHelper.f925n = this.f925n;
            int size = subMenuBuilder.size();
            for (int i = 0; i < size; i++) {
                MenuItem item = subMenuBuilder.getItem(i);
                if (item.isVisible() && item.getIcon() != null) {
                    z = true;
                    break;
                }
            }
            z = false;
            menuPopupHelper.f913b = z;
            if (menuPopupHelper.m1469d()) {
                if (this.f925n == null) {
                    return true;
                }
                this.f925n.a_(subMenuBuilder);
                return true;
            }
        }
        return false;
    }

    public final void mo307a(MenuBuilder menuBuilder, boolean z) {
        if (menuBuilder == this.f916e) {
            m1470e();
            if (this.f925n != null) {
                this.f925n.mo228a(menuBuilder, z);
            }
        }
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

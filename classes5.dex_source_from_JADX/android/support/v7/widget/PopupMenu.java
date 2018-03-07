package android.support.v7.widget;

import android.content.Context;
import android.support.v7.internal.view.SupportMenuInflater;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuBuilder.Callback;
import android.support.v7.internal.view.menu.MenuPopupHelper;
import android.support.v7.internal.view.menu.MenuPresenter;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* compiled from: trending_topic_data */
public class PopupMenu implements Callback, MenuPresenter.Callback {
    private Context f1405a;
    public MenuBuilder f1406b;
    private View f1407c;
    private MenuPopupHelper f1408d;
    public OnMenuItemClickListener f1409e;

    /* compiled from: trending_topic_data */
    public interface OnMenuItemClickListener {
        boolean m1936a(MenuItem menuItem);
    }

    public PopupMenu(Context context, View view) {
        this(context, view, 0);
    }

    private PopupMenu(Context context, View view, int i) {
        this(context, view, i, 2130772026, 0);
    }

    private PopupMenu(Context context, View view, int i, int i2, int i3) {
        this.f1405a = context;
        this.f1406b = new MenuBuilder(context);
        this.f1406b.mo330a((Callback) this);
        this.f1407c = view;
        this.f1408d = new MenuPopupHelper(context, this.f1406b, view, false, i2, i3);
        this.f1408d.f929r = i;
        this.f1408d.f925n = this;
    }

    public final MenuInflater m1939b() {
        return new SupportMenuInflater(this.f1405a);
    }

    public final void m1940c() {
        this.f1408d.m1461a();
    }

    public final boolean mo214a(MenuBuilder menuBuilder, MenuItem menuItem) {
        if (this.f1409e != null) {
            return this.f1409e.m1936a(menuItem);
        }
        return false;
    }

    public final void mo228a(MenuBuilder menuBuilder, boolean z) {
    }

    public final boolean a_(MenuBuilder menuBuilder) {
        if (menuBuilder == null) {
            return false;
        }
        if (!menuBuilder.hasVisibleItems()) {
            return true;
        }
        new MenuPopupHelper(this.f1405a, menuBuilder, this.f1407c).m1461a();
        return true;
    }

    public final void b_(MenuBuilder menuBuilder) {
    }
}

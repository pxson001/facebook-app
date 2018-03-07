package android.support.v4.internal.view;

import android.support.v4.view.ActionProvider;
import android.support.v4.view.MenuItemCompat.OnActionExpandListener;
import android.view.MenuItem;
import android.view.View;

/* compiled from: viewer_inviters */
public interface SupportMenuItem extends MenuItem {
    SupportMenuItem mo287a(ActionProvider actionProvider);

    SupportMenuItem mo288a(OnActionExpandListener onActionExpandListener);

    ActionProvider mo289a();

    boolean collapseActionView();

    boolean expandActionView();

    View getActionView();

    boolean isActionViewExpanded();

    MenuItem setActionView(int i);

    MenuItem setActionView(View view);

    void setShowAsAction(int i);

    MenuItem setShowAsActionFlags(int i);
}

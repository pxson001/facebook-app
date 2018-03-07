package android.support.v7.internal.view.menu;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.view.CollapsibleActionView;
import android.util.Log;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.reflect.Method;

@TargetApi(14)
/* compiled from: unrated */
public class MenuItemWrapperICS extends BaseMenuWrapper<SupportMenuItem> implements MenuItem {
    private Method f906c;

    /* compiled from: unrated */
    public class ActionProviderWrapper extends ActionProvider {
        final android.view.ActionProvider f901a;
        final /* synthetic */ MenuItemWrapperICS f902b;

        public ActionProviderWrapper(MenuItemWrapperICS menuItemWrapperICS, Context context, android.view.ActionProvider actionProvider) {
            this.f902b = menuItemWrapperICS;
            super(context);
            this.f901a = actionProvider;
        }

        public final View mo316a() {
            return this.f901a.onCreateActionView();
        }

        public final boolean mo318d() {
            return this.f901a.onPerformDefaultAction();
        }

        public final boolean mo319e() {
            return this.f901a.hasSubMenu();
        }

        public final void mo317a(SubMenu subMenu) {
            this.f901a.onPrepareSubMenu(this.f902b.m1367a(subMenu));
        }
    }

    /* compiled from: unrated */
    public class CollapsibleActionViewWrapper extends FrameLayout implements CollapsibleActionView {
        public final android.view.CollapsibleActionView f903a;

        CollapsibleActionViewWrapper(View view) {
            super(view.getContext());
            this.f903a = (android.view.CollapsibleActionView) view;
            addView(view);
        }

        public void onActionViewExpanded() {
            this.f903a.onActionViewExpanded();
        }

        public void onActionViewCollapsed() {
            this.f903a.onActionViewCollapsed();
        }
    }

    /* compiled from: unrated */
    class OnActionExpandListenerWrapper extends BaseWrapper<OnActionExpandListener> implements MenuItemCompat.OnActionExpandListener {
        final /* synthetic */ MenuItemWrapperICS f904a;

        OnActionExpandListenerWrapper(MenuItemWrapperICS menuItemWrapperICS, OnActionExpandListener onActionExpandListener) {
            this.f904a = menuItemWrapperICS;
            super(onActionExpandListener);
        }

        public final boolean mo322a(MenuItem menuItem) {
            return ((OnActionExpandListener) this.f814b).onMenuItemActionExpand(this.f904a.m1366a(menuItem));
        }

        public final boolean mo323b(MenuItem menuItem) {
            return ((OnActionExpandListener) this.f814b).onMenuItemActionCollapse(this.f904a.m1366a(menuItem));
        }
    }

    /* compiled from: unrated */
    class OnMenuItemClickListenerWrapper extends BaseWrapper<OnMenuItemClickListener> implements OnMenuItemClickListener {
        final /* synthetic */ MenuItemWrapperICS f905a;

        OnMenuItemClickListenerWrapper(MenuItemWrapperICS menuItemWrapperICS, OnMenuItemClickListener onMenuItemClickListener) {
            this.f905a = menuItemWrapperICS;
            super(onMenuItemClickListener);
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            return ((OnMenuItemClickListener) this.f814b).onMenuItemClick(this.f905a.m1366a(menuItem));
        }
    }

    MenuItemWrapperICS(Context context, SupportMenuItem supportMenuItem) {
        super(context, supportMenuItem);
    }

    public int getItemId() {
        return ((SupportMenuItem) this.f814b).getItemId();
    }

    public int getGroupId() {
        return ((SupportMenuItem) this.f814b).getGroupId();
    }

    public int getOrder() {
        return ((SupportMenuItem) this.f814b).getOrder();
    }

    public MenuItem setTitle(CharSequence charSequence) {
        ((SupportMenuItem) this.f814b).setTitle(charSequence);
        return this;
    }

    public MenuItem setTitle(int i) {
        ((SupportMenuItem) this.f814b).setTitle(i);
        return this;
    }

    public CharSequence getTitle() {
        return ((SupportMenuItem) this.f814b).getTitle();
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        ((SupportMenuItem) this.f814b).setTitleCondensed(charSequence);
        return this;
    }

    public CharSequence getTitleCondensed() {
        return ((SupportMenuItem) this.f814b).getTitleCondensed();
    }

    public MenuItem setIcon(Drawable drawable) {
        ((SupportMenuItem) this.f814b).setIcon(drawable);
        return this;
    }

    public MenuItem setIcon(int i) {
        ((SupportMenuItem) this.f814b).setIcon(i);
        return this;
    }

    public Drawable getIcon() {
        return ((SupportMenuItem) this.f814b).getIcon();
    }

    public MenuItem setIntent(Intent intent) {
        ((SupportMenuItem) this.f814b).setIntent(intent);
        return this;
    }

    public Intent getIntent() {
        return ((SupportMenuItem) this.f814b).getIntent();
    }

    public MenuItem setShortcut(char c, char c2) {
        ((SupportMenuItem) this.f814b).setShortcut(c, c2);
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        ((SupportMenuItem) this.f814b).setNumericShortcut(c);
        return this;
    }

    public char getNumericShortcut() {
        return ((SupportMenuItem) this.f814b).getNumericShortcut();
    }

    public MenuItem setAlphabeticShortcut(char c) {
        ((SupportMenuItem) this.f814b).setAlphabeticShortcut(c);
        return this;
    }

    public char getAlphabeticShortcut() {
        return ((SupportMenuItem) this.f814b).getAlphabeticShortcut();
    }

    public MenuItem setCheckable(boolean z) {
        ((SupportMenuItem) this.f814b).setCheckable(z);
        return this;
    }

    public boolean isCheckable() {
        return ((SupportMenuItem) this.f814b).isCheckable();
    }

    public MenuItem setChecked(boolean z) {
        ((SupportMenuItem) this.f814b).setChecked(z);
        return this;
    }

    public boolean isChecked() {
        return ((SupportMenuItem) this.f814b).isChecked();
    }

    public MenuItem setVisible(boolean z) {
        return ((SupportMenuItem) this.f814b).setVisible(z);
    }

    public boolean isVisible() {
        return ((SupportMenuItem) this.f814b).isVisible();
    }

    public MenuItem setEnabled(boolean z) {
        ((SupportMenuItem) this.f814b).setEnabled(z);
        return this;
    }

    public boolean isEnabled() {
        return ((SupportMenuItem) this.f814b).isEnabled();
    }

    public boolean hasSubMenu() {
        return ((SupportMenuItem) this.f814b).hasSubMenu();
    }

    public SubMenu getSubMenu() {
        return m1367a(((SupportMenuItem) this.f814b).getSubMenu());
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        ((SupportMenuItem) this.f814b).setOnMenuItemClickListener(onMenuItemClickListener != null ? new OnMenuItemClickListenerWrapper(this, onMenuItemClickListener) : null);
        return this;
    }

    public ContextMenuInfo getMenuInfo() {
        return ((SupportMenuItem) this.f814b).getMenuInfo();
    }

    public void setShowAsAction(int i) {
        ((SupportMenuItem) this.f814b).setShowAsAction(i);
    }

    public MenuItem setShowAsActionFlags(int i) {
        ((SupportMenuItem) this.f814b).setShowAsActionFlags(i);
        return this;
    }

    public MenuItem setActionView(View view) {
        if (view instanceof android.view.CollapsibleActionView) {
            view = new CollapsibleActionViewWrapper(view);
        }
        ((SupportMenuItem) this.f814b).setActionView(view);
        return this;
    }

    public MenuItem setActionView(int i) {
        ((SupportMenuItem) this.f814b).setActionView(i);
        View actionView = ((SupportMenuItem) this.f814b).getActionView();
        if (actionView instanceof android.view.CollapsibleActionView) {
            ((SupportMenuItem) this.f814b).setActionView(new CollapsibleActionViewWrapper(actionView));
        }
        return this;
    }

    public View getActionView() {
        View actionView = ((SupportMenuItem) this.f814b).getActionView();
        return actionView instanceof CollapsibleActionViewWrapper ? (View) ((CollapsibleActionViewWrapper) actionView).f903a : actionView;
    }

    public MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        ((SupportMenuItem) this.f814b).mo287a(actionProvider != null ? mo328a(actionProvider) : null);
        return this;
    }

    public android.view.ActionProvider getActionProvider() {
        ActionProvider a = ((SupportMenuItem) this.f814b).mo289a();
        if (a instanceof ActionProviderWrapper) {
            return ((ActionProviderWrapper) a).f901a;
        }
        return null;
    }

    public boolean expandActionView() {
        return ((SupportMenuItem) this.f814b).expandActionView();
    }

    public boolean collapseActionView() {
        return ((SupportMenuItem) this.f814b).collapseActionView();
    }

    public boolean isActionViewExpanded() {
        return ((SupportMenuItem) this.f814b).isActionViewExpanded();
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        ((SupportMenuItem) this.f814b).mo288a(onActionExpandListener != null ? new OnActionExpandListenerWrapper(this, onActionExpandListener) : null);
        return this;
    }

    public final void m1452a(boolean z) {
        try {
            if (this.f906c == null) {
                this.f906c = ((SupportMenuItem) this.f814b).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
            }
            this.f906c.invoke(this.f814b, new Object[]{Boolean.valueOf(z)});
        } catch (Throwable e) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e);
        }
    }

    ActionProviderWrapper mo328a(android.view.ActionProvider actionProvider) {
        return new ActionProviderWrapper(this, this.f815a, actionProvider);
    }
}

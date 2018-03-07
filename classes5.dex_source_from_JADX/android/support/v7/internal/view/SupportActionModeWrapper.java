package android.support.v7.internal.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.util.SimpleArrayMap;
import android.support.v7.internal.view.menu.MenuWrapperFactory;
import android.support.v7.view.ActionMode.Callback;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

@TargetApi(11)
/* compiled from: upsell_accept_button_label */
public class SupportActionModeWrapper extends ActionMode {
    final Context f722a;
    final android.support.v7.view.ActionMode f723b;

    /* compiled from: upsell_accept_button_label */
    public class CallbackWrapper implements Callback {
        final ActionMode.Callback f718a;
        final Context f719b;
        final SimpleArrayMap<android.support.v7.view.ActionMode, SupportActionModeWrapper> f720c = new SimpleArrayMap();
        final SimpleArrayMap<Menu, Menu> f721d = new SimpleArrayMap();

        public CallbackWrapper(Context context, ActionMode.Callback callback) {
            this.f719b = context;
            this.f718a = callback;
        }

        public final boolean mo231a(android.support.v7.view.ActionMode actionMode, Menu menu) {
            return this.f718a.onCreateActionMode(m1297b(actionMode), m1296a(menu));
        }

        public final boolean mo233b(android.support.v7.view.ActionMode actionMode, Menu menu) {
            return this.f718a.onPrepareActionMode(m1297b(actionMode), m1296a(menu));
        }

        public final boolean mo232a(android.support.v7.view.ActionMode actionMode, MenuItem menuItem) {
            return this.f718a.onActionItemClicked(m1297b(actionMode), MenuWrapperFactory.m1473a(this.f719b, (SupportMenuItem) menuItem));
        }

        public final void mo230a(android.support.v7.view.ActionMode actionMode) {
            this.f718a.onDestroyActionMode(m1297b(actionMode));
        }

        private Menu m1296a(Menu menu) {
            Menu menu2 = (Menu) this.f721d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            menu2 = MenuWrapperFactory.m1472a(this.f719b, (SupportMenu) menu);
            this.f721d.put(menu, menu2);
            return menu2;
        }

        private ActionMode m1297b(android.support.v7.view.ActionMode actionMode) {
            SupportActionModeWrapper supportActionModeWrapper = (SupportActionModeWrapper) this.f720c.get(actionMode);
            if (supportActionModeWrapper != null) {
                return supportActionModeWrapper;
            }
            ActionMode supportActionModeWrapper2 = new SupportActionModeWrapper(this.f719b, actionMode);
            this.f720c.put(actionMode, supportActionModeWrapper2);
            return supportActionModeWrapper2;
        }
    }

    public SupportActionModeWrapper(Context context, android.support.v7.view.ActionMode actionMode) {
        this.f722a = context;
        this.f723b = actionMode;
    }

    public Object getTag() {
        return this.f723b.f657a;
    }

    public void setTag(Object obj) {
        this.f723b.f657a = obj;
    }

    public void setTitle(CharSequence charSequence) {
        this.f723b.mo249b(charSequence);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f723b.mo245a(charSequence);
    }

    public void invalidate() {
        this.f723b.mo251d();
    }

    public void finish() {
        this.f723b.mo250c();
    }

    public Menu getMenu() {
        return MenuWrapperFactory.m1472a(this.f722a, (SupportMenu) this.f723b.mo247b());
    }

    public CharSequence getTitle() {
        return this.f723b.mo252f();
    }

    public void setTitle(int i) {
        this.f723b.mo243a(i);
    }

    public CharSequence getSubtitle() {
        return this.f723b.mo253g();
    }

    public void setSubtitle(int i) {
        this.f723b.mo248b(i);
    }

    public View getCustomView() {
        return this.f723b.mo255i();
    }

    public void setCustomView(View view) {
        this.f723b.mo244a(view);
    }

    public MenuInflater getMenuInflater() {
        return this.f723b.mo242a();
    }

    public boolean getTitleOptionalHint() {
        return this.f723b.f658b;
    }

    public void setTitleOptionalHint(boolean z) {
        this.f723b.mo246a(z);
    }

    public boolean isTitleOptional() {
        return this.f723b.mo254h();
    }
}

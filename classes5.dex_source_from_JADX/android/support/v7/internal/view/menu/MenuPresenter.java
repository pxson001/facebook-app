package android.support.v7.internal.view.menu;

import android.content.Context;

/* compiled from: upsell_show_loan_impression */
public interface MenuPresenter {

    /* compiled from: upsell_show_loan_impression */
    public interface Callback {
        void mo228a(MenuBuilder menuBuilder, boolean z);

        boolean a_(MenuBuilder menuBuilder);
    }

    void mo306a(Context context, MenuBuilder menuBuilder);

    void mo307a(MenuBuilder menuBuilder, boolean z);

    boolean mo308a(SubMenuBuilder subMenuBuilder);

    void mo309b(boolean z);

    boolean mo310b();

    boolean mo311b(MenuItemImpl menuItemImpl);

    boolean mo312c(MenuItemImpl menuItemImpl);
}

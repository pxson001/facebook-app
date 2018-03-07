package com.facebook.messaging.composer.botcomposer;

import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;
import com.facebook.fbui.menu.MenuItemImpl;
import com.facebook.inject.Assisted;
import com.facebook.messaging.composer.botcomposer.BotMenuController.C02824;
import com.facebook.widget.bottomsheet.BottomSheetAdapter;
import javax.inject.Inject;

/* compiled from: theme_width */
public class BotMenuContentAdapter extends BottomSheetAdapter {
    public C02824 f1726c;

    /* compiled from: theme_width */
    public class C02781 {
        final /* synthetic */ BotMenuContentAdapter f1724a;

        C02781(BotMenuContentAdapter botMenuContentAdapter) {
            this.f1724a = botMenuContentAdapter;
        }

        public final boolean m1716a(MenuItem menuItem) {
            if (this.f1724a.f1726c != null) {
                MenuItemDataWrapper menuItemDataWrapper = (MenuItemDataWrapper) menuItem;
                C02824 c02824 = this.f1724a.f1726c;
                c02824.f1731a.f1736e.m1702a(c02824.f1731a.f1740i, menuItemDataWrapper.f1725a.f1743c.dbValue);
            }
            return false;
        }
    }

    /* compiled from: theme_width */
    public class MenuItemDataWrapper extends MenuItemImpl {
        public final BotMenuItem f1725a;

        public MenuItemDataWrapper(Menu menu, BotMenuItem botMenuItem) {
            super(menu, 0, 0, botMenuItem.f1742b);
            this.f1725a = botMenuItem;
        }
    }

    @Inject
    public BotMenuContentAdapter(@Assisted Context context) {
        super(context);
        a(new C02781(this));
    }
}

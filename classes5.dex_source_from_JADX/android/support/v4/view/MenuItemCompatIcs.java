package android.support.v4.view;

import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;

/* compiled from: video_flyout */
class MenuItemCompatIcs {

    /* compiled from: video_flyout */
    interface SupportActionExpandProxy {
        boolean mo63a(MenuItem menuItem);

        boolean mo64b(MenuItem menuItem);
    }

    /* compiled from: video_flyout */
    class OnActionExpandListenerWrapper implements OnActionExpandListener {
        private SupportActionExpandProxy f309a;

        public OnActionExpandListenerWrapper(SupportActionExpandProxy supportActionExpandProxy) {
            this.f309a = supportActionExpandProxy;
        }

        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.f309a.mo63a(menuItem);
        }

        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.f309a.mo64b(menuItem);
        }
    }

    MenuItemCompatIcs() {
    }

    public static MenuItem m384a(MenuItem menuItem, SupportActionExpandProxy supportActionExpandProxy) {
        return menuItem.setOnActionExpandListener(new OnActionExpandListenerWrapper(supportActionExpandProxy));
    }
}

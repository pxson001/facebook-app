package android.support.v4.view;

import android.os.Build.VERSION;
import android.support.v4.internal.view.SupportMenuItem;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

/* compiled from: video_format */
public class MenuItemCompat {
    static final MenuVersionImpl f308a;

    /* compiled from: video_format */
    interface MenuVersionImpl {
        MenuItem mo56a(MenuItem menuItem, OnActionExpandListener onActionExpandListener);

        MenuItem mo57a(MenuItem menuItem, View view);

        View mo58a(MenuItem menuItem);

        boolean mo59a(MenuItem menuItem, int i);

        MenuItem mo60b(MenuItem menuItem, int i);

        boolean mo61b(MenuItem menuItem);

        boolean mo62c(MenuItem menuItem);
    }

    /* compiled from: video_format */
    class BaseMenuVersionImpl implements MenuVersionImpl {
        BaseMenuVersionImpl() {
        }

        public final boolean mo59a(MenuItem menuItem, int i) {
            return false;
        }

        public final MenuItem mo57a(MenuItem menuItem, View view) {
            return menuItem;
        }

        public final MenuItem mo60b(MenuItem menuItem, int i) {
            return menuItem;
        }

        public final View mo58a(MenuItem menuItem) {
            return null;
        }

        public final boolean mo61b(MenuItem menuItem) {
            return false;
        }

        public final boolean mo62c(MenuItem menuItem) {
            return false;
        }

        public final MenuItem mo56a(MenuItem menuItem, OnActionExpandListener onActionExpandListener) {
            return menuItem;
        }
    }

    /* compiled from: video_format */
    class HoneycombMenuVersionImpl implements MenuVersionImpl {
        public final boolean mo59a(MenuItem menuItem, int i) {
            menuItem.setShowAsAction(i);
            return true;
        }

        public final MenuItem mo57a(MenuItem menuItem, View view) {
            return menuItem.setActionView(view);
        }

        public final MenuItem mo60b(MenuItem menuItem, int i) {
            return menuItem.setActionView(i);
        }

        public final View mo58a(MenuItem menuItem) {
            return menuItem.getActionView();
        }

        HoneycombMenuVersionImpl() {
        }

        public boolean mo61b(MenuItem menuItem) {
            return false;
        }

        public boolean mo62c(MenuItem menuItem) {
            return false;
        }

        public MenuItem mo56a(MenuItem menuItem, OnActionExpandListener onActionExpandListener) {
            return menuItem;
        }
    }

    /* compiled from: video_format */
    class IcsMenuVersionImpl extends HoneycombMenuVersionImpl {
        public final boolean mo61b(MenuItem menuItem) {
            return menuItem.expandActionView();
        }

        public final boolean mo62c(MenuItem menuItem) {
            return menuItem.isActionViewExpanded();
        }

        IcsMenuVersionImpl() {
        }

        public final MenuItem mo56a(MenuItem menuItem, final OnActionExpandListener onActionExpandListener) {
            if (onActionExpandListener == null) {
                return MenuItemCompatIcs.m384a(menuItem, null);
            }
            return MenuItemCompatIcs.m384a(menuItem, new SupportActionExpandProxy(this) {
                final /* synthetic */ IcsMenuVersionImpl f307b;

                public final boolean mo63a(MenuItem menuItem) {
                    return onActionExpandListener.mo322a(menuItem);
                }

                public final boolean mo64b(MenuItem menuItem) {
                    return onActionExpandListener.mo323b(menuItem);
                }
            });
        }
    }

    /* compiled from: video_format */
    public interface OnActionExpandListener {
        boolean mo322a(MenuItem menuItem);

        boolean mo323b(MenuItem menuItem);
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 14) {
            f308a = new IcsMenuVersionImpl();
        } else if (i >= 11) {
            f308a = new HoneycombMenuVersionImpl();
        } else {
            f308a = new BaseMenuVersionImpl();
        }
    }

    public static boolean m380a(MenuItem menuItem, int i) {
        if (!(menuItem instanceof SupportMenuItem)) {
            return f308a.mo59a(menuItem, i);
        }
        ((SupportMenuItem) menuItem).setShowAsAction(i);
        return true;
    }

    public static MenuItem m378a(MenuItem menuItem, View view) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).setActionView(view);
        }
        return f308a.mo57a(menuItem, view);
    }

    public static MenuItem m381b(MenuItem menuItem, int i) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).setActionView(i);
        }
        return f308a.mo60b(menuItem, i);
    }

    public static View m379a(MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).getActionView();
        }
        return f308a.mo58a(menuItem);
    }

    public static MenuItem m376a(MenuItem menuItem, ActionProvider actionProvider) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).mo287a(actionProvider);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    public static boolean m382b(MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).expandActionView();
        }
        return f308a.mo61b(menuItem);
    }

    public static boolean m383c(MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).isActionViewExpanded();
        }
        return f308a.mo62c(menuItem);
    }

    public static MenuItem m377a(MenuItem menuItem, OnActionExpandListener onActionExpandListener) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).mo288a(onActionExpandListener);
        }
        return f308a.mo56a(menuItem, onActionExpandListener);
    }
}

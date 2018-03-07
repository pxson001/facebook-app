package com.facebook.widget.titlebar;

import android.support.v4.view.MenuItemCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: rankingModel */
public class FbTitleBarMenuHelper {
    public static final ImmutableList<Integer> f6246a = ImmutableList.of(Integer.valueOf(2131558450), Integer.valueOf(2131558451), Integer.valueOf(2131558452), Integer.valueOf(2131558453));

    public static void m8793a(Menu menu, List<TitleBarButtonSpec> list) {
        int i = 0;
        for (TitleBarButtonSpec titleBarButtonSpec : list) {
            int i2;
            if (titleBarButtonSpec.r != -1) {
                i2 = titleBarButtonSpec.r;
            } else {
                i2 = ((Integer) f6246a.get(i)).intValue();
            }
            MenuItem add = menu.add(0, i2, 0, "");
            if (titleBarButtonSpec.l != 0) {
                MenuItemCompat.b(add, titleBarButtonSpec.l);
                View a = MenuItemCompat.a(add);
                if (a != null) {
                    if (a instanceof TintableTitleBarButton) {
                        ((TintableTitleBarButton) a).setButtonTintColor(titleBarButtonSpec.m);
                    }
                    a.setContentDescription(titleBarButtonSpec.k);
                    a.setSelected(titleBarButtonSpec.s);
                }
            }
            if (titleBarButtonSpec.d != null) {
                add.setIcon(titleBarButtonSpec.d);
            }
            if (titleBarButtonSpec.i != null) {
                add.setTitle(titleBarButtonSpec.i);
            }
            MenuItemCompat.a(add, 2);
            add.setEnabled(titleBarButtonSpec.t);
            int i3 = i + 1;
            if (i3 < f6246a.size()) {
                i = i3;
            } else {
                return;
            }
        }
    }

    public final void m8795a(Menu menu, final List<TitleBarButtonSpec> list, @Nullable final OnToolbarButtonListener onToolbarButtonListener) {
        int size = menu.size();
        for (int i = 0; i < size; i++) {
            View a = MenuItemCompat.a(menu.getItem(i));
            if (a != null) {
                a.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ FbTitleBarMenuHelper f6245d;

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, -566083620);
                        if (onToolbarButtonListener != null) {
                            onToolbarButtonListener.a(view, (TitleBarButtonSpec) list.get(i));
                        }
                        Logger.a(2, EntryType.UI_INPUT_END, 1464131865, a);
                    }
                });
            }
        }
    }

    public static boolean m8794a(MenuItem menuItem, List<TitleBarButtonSpec> list, OnToolbarButtonListener onToolbarButtonListener) {
        int i = 0;
        int itemId = menuItem.getItemId();
        int i2 = 0;
        while (i2 < f6246a.size()) {
            if (((Integer) f6246a.get(i2)).intValue() == itemId) {
                break;
            }
            i2++;
        }
        i2 = -1;
        if (i2 == -1) {
            while (i < list.size()) {
                if (((TitleBarButtonSpec) list.get(i)).r == itemId) {
                    break;
                }
                i++;
            }
        }
        i = i2;
        int i3 = i;
        if (i3 < 0 || i3 >= list.size()) {
            return false;
        }
        onToolbarButtonListener.a(MenuItemCompat.a(menuItem), (TitleBarButtonSpec) list.get(i3));
        return true;
    }
}

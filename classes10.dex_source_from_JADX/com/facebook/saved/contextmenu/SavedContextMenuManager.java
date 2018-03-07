package com.facebook.saved.contextmenu;

import android.support.v4.app.Fragment;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.facebook.analytics.CurationMechanism;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.fig.menu.FigPopoverMenuWindow;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBinderSet;
import com.facebook.saved.analytics.SaveAnalyticsLogger;
import com.facebook.saved.contextmenu.interfaces.STATICDI_MULTIBIND_PROVIDER$SavedContextMenuItem;
import com.facebook.saved.contextmenu.interfaces.SavableItemWrapper;
import com.facebook.saved.contextmenu.interfaces.SavedContextMenuItem;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: is_top_up_incentive */
public class SavedContextMenuManager {
    public final SaveAnalyticsLogger f8968a;
    public final Set<SavedContextMenuItem> f8969b;

    public static SavedContextMenuManager m8962a(InjectorLike injectorLike) {
        return new SavedContextMenuManager(SaveAnalyticsLogger.a(injectorLike), new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$SavedContextMenuItem(injectorLike)));
    }

    @Inject
    public SavedContextMenuManager(SaveAnalyticsLogger saveAnalyticsLogger, Set<SavedContextMenuItem> set) {
        this.f8968a = saveAnalyticsLogger;
        this.f8969b = set;
    }

    public final void m8965a(SavableItemWrapper savableItemWrapper, View view, Fragment fragment, CurationMechanism curationMechanism) {
        FigPopoverMenuWindow figPopoverMenuWindow = new FigPopoverMenuWindow(view.getContext());
        PopoverMenu c = figPopoverMenuWindow.c();
        Builder builder = ImmutableList.builder();
        for (SavedContextMenuItem savedContextMenuItem : this.f8969b) {
            if (savedContextMenuItem.mo409a().isAssignableFrom(savableItemWrapper.getClass()) && savedContextMenuItem.mo413b(savableItemWrapper)) {
                builder.c(savedContextMenuItem);
            }
        }
        ImmutableList b = builder.b();
        if (!b.isEmpty()) {
            int size = b.size();
            for (int i = 0; i < size; i++) {
                m8963a(fragment, c, (SavedContextMenuItem) b.get(i), savableItemWrapper);
            }
            figPopoverMenuWindow.a(view);
            m8964a(savableItemWrapper, b, curationMechanism);
        }
    }

    private void m8963a(final Fragment fragment, PopoverMenu popoverMenu, final SavedContextMenuItem savedContextMenuItem, final SavableItemWrapper savableItemWrapper) {
        CharSequence a = savedContextMenuItem.mo410a(savableItemWrapper);
        MenuItem a2 = a == null ? popoverMenu.a(savedContextMenuItem.mo412b()) : popoverMenu.a(savedContextMenuItem.mo412b(), a);
        a2.setIcon(savedContextMenuItem.mo415d());
        a2.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
            final /* synthetic */ SavedContextMenuManager f8967d;

            public boolean onMenuItemClick(MenuItem menuItem) {
                SavedContextMenuManager savedContextMenuManager = this.f8967d;
                SavedContextMenuItem savedContextMenuItem = savedContextMenuItem;
                savedContextMenuManager.f8968a.a("saved_dashboard", Strings.nullToEmpty(savableItemWrapper.mo424a()), savedContextMenuItem.mo414c());
                return savedContextMenuItem.mo411a(savableItemWrapper, fragment);
            }
        });
    }

    private void m8964a(SavableItemWrapper savableItemWrapper, ImmutableList<SavedContextMenuItem> immutableList, CurationMechanism curationMechanism) {
        SaveAnalyticsLogger saveAnalyticsLogger = this.f8968a;
        String str = "saved_dashboard";
        String nullToEmpty = Strings.nullToEmpty(savableItemWrapper.mo424a());
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            builder.c(((SavedContextMenuItem) immutableList.get(i)).mo414c());
        }
        saveAnalyticsLogger.a(str, nullToEmpty, builder.b(), curationMechanism);
    }
}

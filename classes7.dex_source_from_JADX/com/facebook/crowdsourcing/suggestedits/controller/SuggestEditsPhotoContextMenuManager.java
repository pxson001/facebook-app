package com.facebook.crowdsourcing.suggestedits.controller;

import android.support.v4.app.Fragment;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.crowdsourcing.enums.SuggestEditsInputType;
import com.facebook.crowdsourcing.picker.SuggestEditsPickerLauncher;
import com.facebook.crowdsourcing.suggestedits.data.SuggestEditsHeaderHolder;
import com.facebook.crowdsourcing.suggestedits.listener.SuggestEditsFieldChangedListener;
import com.facebook.fbui.menu.MenuItemImpl;
import com.facebook.fbui.popover.PopoverMenuWindow;
import com.facebook.fig.menu.FigPopoverMenuWindow;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream */
public class SuggestEditsPhotoContextMenuManager {
    public final Provider<Boolean> f17654a;
    public SuggestEditsPickerLauncher f17655b;

    /* compiled from: com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream */
    public class C14761 implements OnClickListener {
        final /* synthetic */ Fragment f17639a;
        final /* synthetic */ SuggestEditsHeaderHolder f17640b;
        final /* synthetic */ SuggestEditsFieldChangedListener f17641c;
        final /* synthetic */ SuggestEditsPhotoContextMenuManager f17642d;

        public C14761(SuggestEditsPhotoContextMenuManager suggestEditsPhotoContextMenuManager, Fragment fragment, SuggestEditsHeaderHolder suggestEditsHeaderHolder, SuggestEditsFieldChangedListener suggestEditsFieldChangedListener) {
            this.f17642d = suggestEditsPhotoContextMenuManager;
            this.f17639a = fragment;
            this.f17640b = suggestEditsHeaderHolder;
            this.f17641c = suggestEditsFieldChangedListener;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2051516967);
            SuggestEditsPhotoContextMenuManager.m21480a(this.f17642d, view, this.f17639a, this.f17640b, this.f17641c);
            Logger.a(2, EntryType.UI_INPUT_END, 163927941, a);
        }
    }

    /* compiled from: com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream */
    class ContextMenuItem {
        public final String f17651a;
        public final int f17652b;
        public final OnMenuItemClickListener f17653c;

        ContextMenuItem(String str, int i, OnMenuItemClickListener onMenuItemClickListener) {
            this.f17651a = str;
            this.f17652b = i;
            this.f17653c = onMenuItemClickListener;
        }
    }

    @Inject
    public SuggestEditsPhotoContextMenuManager(Provider<Boolean> provider, SuggestEditsPickerLauncher suggestEditsPickerLauncher) {
        this.f17654a = provider;
        this.f17655b = suggestEditsPickerLauncher;
    }

    public static void m21480a(SuggestEditsPhotoContextMenuManager suggestEditsPhotoContextMenuManager, View view, final Fragment fragment, final SuggestEditsHeaderHolder suggestEditsHeaderHolder, final SuggestEditsFieldChangedListener suggestEditsFieldChangedListener) {
        int i;
        Object obj;
        Collection a = Lists.a();
        String string = fragment.jW_().getString(2131239139);
        if (((Boolean) suggestEditsPhotoContextMenuManager.f17654a.get()).booleanValue()) {
            i = 2130839749;
        } else {
            i = 2130843505;
        }
        m21482a(a, string, i, new OnMenuItemClickListener(suggestEditsPhotoContextMenuManager) {
            final /* synthetic */ SuggestEditsPhotoContextMenuManager f17646d;

            public boolean onMenuItemClick(MenuItem menuItem) {
                SuggestEditsPhotoContextMenuManager suggestEditsPhotoContextMenuManager = this.f17646d;
                Fragment fragment = fragment;
                SuggestEditsHeaderHolder suggestEditsHeaderHolder = suggestEditsHeaderHolder;
                suggestEditsPhotoContextMenuManager.f17655b.m21362a(suggestEditsHeaderHolder.m21511c(), SuggestEditsInputType.PHOTO_PICKER, suggestEditsFieldChangedListener, fragment);
                return true;
            }
        });
        if (suggestEditsHeaderHolder.m21512e()) {
            m21482a(a, fragment.jW_().getString(2131239140), 2130843508, new OnMenuItemClickListener(suggestEditsPhotoContextMenuManager) {
                final /* synthetic */ SuggestEditsPhotoContextMenuManager f17648b;

                public boolean onMenuItemClick(MenuItem menuItem) {
                    suggestEditsHeaderHolder.m21513h();
                    return true;
                }
            });
        }
        if (suggestEditsHeaderHolder.f17669e.f17674d == null || !SuggestEditsHeaderHolder.m21506a(suggestEditsHeaderHolder.f17669e.f17672b, suggestEditsHeaderHolder.f17669e.f17674d) || SuggestEditsHeaderHolder.m21506a(suggestEditsHeaderHolder.f17669e.f17672b, suggestEditsHeaderHolder.f17669e.f17673c)) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            m21482a(a, fragment.jW_().getString(2131239141), 2130843509, new OnMenuItemClickListener(suggestEditsPhotoContextMenuManager) {
                final /* synthetic */ SuggestEditsPhotoContextMenuManager f17650b;

                public boolean onMenuItemClick(MenuItem menuItem) {
                    suggestEditsHeaderHolder.m21514i();
                    return true;
                }
            });
        }
        ImmutableList copyOf = ImmutableList.copyOf(a);
        if (copyOf.size() == 1) {
            ((ContextMenuItem) copyOf.get(0)).f17653c.onMenuItemClick(null);
            return;
        }
        FigPopoverMenuWindow figPopoverMenuWindow = new FigPopoverMenuWindow(fragment.getContext());
        m21481a(figPopoverMenuWindow, copyOf);
        figPopoverMenuWindow.f(view);
    }

    public static void m21482a(List<ContextMenuItem> list, String str, int i, OnMenuItemClickListener onMenuItemClickListener) {
        list.add(new ContextMenuItem(str, i, onMenuItemClickListener));
    }

    private static void m21481a(PopoverMenuWindow popoverMenuWindow, ImmutableList<ContextMenuItem> immutableList) {
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            ContextMenuItem contextMenuItem = (ContextMenuItem) immutableList.get(i);
            MenuItemImpl a = popoverMenuWindow.c().a(contextMenuItem.f17651a);
            a.setIcon(contextMenuItem.f17652b);
            a.setOnMenuItemClickListener(contextMenuItem.f17653c);
        }
    }
}

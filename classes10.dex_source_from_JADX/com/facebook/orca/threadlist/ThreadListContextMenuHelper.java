package com.facebook.orca.threadlist;

import android.os.Bundle;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.annotations.IsGlobalMessageDeleteEnabled;
import com.facebook.messaging.annotations.IsMessengerThreadShortcutsEnabled;
import com.facebook.messaging.blocking.annotations.IsBlockMessagesEnabled;
import com.facebook.messaging.cache.ThreadUnreadCountUtil;
import com.facebook.messaging.dialog.MenuDialogItemBuilder;
import com.facebook.messaging.dialog.MenuDialogParamsBuilder;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.sms.defaultapp.SmsPermissionsUtil;
import com.facebook.orca.notify.NotificationSettingsUtil;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.collect.ImmutableSet;
import javax.inject.Provider;

/* compiled from: native_timeline_profile */
public class ThreadListContextMenuHelper {
    private static final ImmutableSet<Integer> f6576a = ImmutableSet.of(Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(9), new Integer[0]);
    private static final ImmutableSet<Integer> f6577b = ImmutableSet.of(Integer.valueOf(11), Integer.valueOf(12));
    private static final ImmutableSet<Integer> f6578c = ImmutableSet.of(Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(9), new Integer[0]);
    @IsGlobalMessageDeleteEnabled
    @Inject
    private Provider<Boolean> f6579d;
    @Inject
    @IsBlockMessagesEnabled
    public Provider<Boolean> f6580e;
    @Inject
    public Product f6581f;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<NotificationSettingsUtil> f6582g = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<ThreadUnreadCountUtil> f6583h = UltralightRuntime.b;
    @IsMessengerThreadShortcutsEnabled
    @Inject
    private Provider<Boolean> f6584i;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<SmsPermissionsUtil> f6585j = UltralightRuntime.b;

    public static ThreadListContextMenuHelper m6274b(InjectorLike injectorLike) {
        ThreadListContextMenuHelper threadListContextMenuHelper = new ThreadListContextMenuHelper();
        threadListContextMenuHelper.m6272a(IdBasedProvider.a(injectorLike, 4063), IdBasedProvider.a(injectorLike, 4110), ProductMethodAutoProvider.b(injectorLike), IdBasedLazy.a(injectorLike, 2906), IdBasedLazy.a(injectorLike, 7709), IdBasedProvider.a(injectorLike, 4076), IdBasedSingletonScopeProvider.b(injectorLike, 8460));
        return threadListContextMenuHelper;
    }

    public final MenuDialogParamsBuilder m6275a(ThreadSummary threadSummary, boolean z) {
        int i;
        MenuDialogParamsBuilder menuDialogParamsBuilder = new MenuDialogParamsBuilder();
        if (ThreadKey.e(threadSummary.a)) {
            menuDialogParamsBuilder.b = "";
        } else {
            menuDialogParamsBuilder.a = 2131231033;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("thread_summary", threadSummary);
        menuDialogParamsBuilder.d = bundle;
        if (m6273a(1, threadSummary)) {
            MenuDialogItemBuilder menuDialogItemBuilder = new MenuDialogItemBuilder();
            menuDialogItemBuilder.a = 1;
            menuDialogItemBuilder = menuDialogItemBuilder;
            menuDialogItemBuilder.b = 2131231036;
            menuDialogItemBuilder = menuDialogItemBuilder;
            menuDialogItemBuilder.d = "archive";
            menuDialogParamsBuilder.a(menuDialogItemBuilder.f());
        }
        if (m6273a(6, threadSummary)) {
            menuDialogItemBuilder = new MenuDialogItemBuilder();
            menuDialogItemBuilder.a = 6;
            menuDialogItemBuilder = menuDialogItemBuilder;
            menuDialogItemBuilder.b = 2131231037;
            menuDialogItemBuilder = menuDialogItemBuilder;
            menuDialogItemBuilder.d = "spam";
            menuDialogParamsBuilder.a(menuDialogItemBuilder.f());
        }
        if (m6273a(0, threadSummary)) {
            menuDialogItemBuilder = new MenuDialogItemBuilder();
            menuDialogItemBuilder.a = 0;
            MenuDialogItemBuilder menuDialogItemBuilder2 = menuDialogItemBuilder;
            if (((Boolean) this.f6579d.get()).booleanValue()) {
                i = 2131231035;
            } else {
                i = 2131231034;
            }
            menuDialogItemBuilder2.b = i;
            menuDialogItemBuilder = menuDialogItemBuilder2;
            menuDialogItemBuilder.d = "delete";
            menuDialogParamsBuilder.a(menuDialogItemBuilder.f());
        }
        if (m6273a(4, threadSummary)) {
            menuDialogItemBuilder = new MenuDialogItemBuilder();
            menuDialogItemBuilder.a = 4;
            menuDialogItemBuilder = menuDialogItemBuilder;
            menuDialogItemBuilder.b = 2131231366;
            menuDialogItemBuilder = menuDialogItemBuilder;
            menuDialogItemBuilder.d = "leave conversation";
            menuDialogParamsBuilder.a(menuDialogItemBuilder.f());
        }
        if (m6273a(3, threadSummary) && m6273a(7, threadSummary)) {
            Object obj;
            if (((NotificationSettingsUtil) this.f6582g.get()).a(threadSummary.a).b()) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                menuDialogItemBuilder = new MenuDialogItemBuilder();
                menuDialogItemBuilder.a = 7;
                menuDialogItemBuilder = menuDialogItemBuilder;
                menuDialogItemBuilder.b = 2131231362;
                menuDialogItemBuilder = menuDialogItemBuilder;
                menuDialogItemBuilder.d = "unmute";
                menuDialogParamsBuilder.a(menuDialogItemBuilder.f());
            } else {
                menuDialogItemBuilder = new MenuDialogItemBuilder();
                menuDialogItemBuilder.a = 3;
                menuDialogItemBuilder = menuDialogItemBuilder;
                menuDialogItemBuilder.b = 2131231361;
                menuDialogItemBuilder = menuDialogItemBuilder;
                menuDialogItemBuilder.d = "mute";
                menuDialogParamsBuilder.a(menuDialogItemBuilder.f());
            }
        }
        if (z && m6273a(2, threadSummary)) {
            menuDialogItemBuilder = new MenuDialogItemBuilder();
            menuDialogItemBuilder.a = 2;
            menuDialogItemBuilder = menuDialogItemBuilder;
            menuDialogItemBuilder.b = 2131231038;
            menuDialogItemBuilder = menuDialogItemBuilder;
            menuDialogItemBuilder.d = "popout chathead";
            menuDialogParamsBuilder.a(menuDialogItemBuilder.f());
        }
        if (m6273a(5, threadSummary)) {
            menuDialogItemBuilder = new MenuDialogItemBuilder();
            menuDialogItemBuilder.a = 5;
            menuDialogItemBuilder = menuDialogItemBuilder;
            menuDialogItemBuilder.b = 2131231039;
            menuDialogItemBuilder = menuDialogItemBuilder;
            menuDialogItemBuilder.d = "create conversation shortcut";
            menuDialogParamsBuilder.a(menuDialogItemBuilder.f());
        }
        if (m6273a(8, threadSummary) && m6273a(9, threadSummary)) {
            if (((ThreadUnreadCountUtil) this.f6583h.get()).a(threadSummary)) {
                menuDialogItemBuilder = new MenuDialogItemBuilder();
                menuDialogItemBuilder.a = 8;
                menuDialogItemBuilder = menuDialogItemBuilder;
                menuDialogItemBuilder.b = 2131231040;
                menuDialogItemBuilder = menuDialogItemBuilder;
                menuDialogItemBuilder.d = "mark read";
                menuDialogParamsBuilder.a(menuDialogItemBuilder.f());
            } else {
                menuDialogItemBuilder = new MenuDialogItemBuilder();
                menuDialogItemBuilder.a = 9;
                menuDialogItemBuilder = menuDialogItemBuilder;
                menuDialogItemBuilder.b = 2131231041;
                menuDialogItemBuilder = menuDialogItemBuilder;
                menuDialogItemBuilder.d = "mark unread";
                menuDialogParamsBuilder.a(menuDialogItemBuilder.f());
            }
        }
        if (m6273a(10, threadSummary)) {
            menuDialogItemBuilder = new MenuDialogItemBuilder();
            menuDialogItemBuilder.a = 10;
            menuDialogItemBuilder = menuDialogItemBuilder;
            menuDialogItemBuilder.b = 2131240217;
            menuDialogItemBuilder = menuDialogItemBuilder;
            menuDialogItemBuilder.d = "block messages";
            menuDialogParamsBuilder.a(menuDialogItemBuilder.f());
        }
        if (m6273a(11, threadSummary)) {
            menuDialogItemBuilder = new MenuDialogItemBuilder();
            menuDialogItemBuilder.a = 11;
            menuDialogItemBuilder = menuDialogItemBuilder;
            menuDialogItemBuilder.b = 2131232379;
            menuDialogItemBuilder = menuDialogItemBuilder;
            menuDialogItemBuilder.d = "turn off sms promo";
            menuDialogParamsBuilder.a(menuDialogItemBuilder.f());
        }
        if (m6273a(12, threadSummary)) {
            menuDialogItemBuilder = new MenuDialogItemBuilder();
            menuDialogItemBuilder.a = 12;
            menuDialogItemBuilder2 = menuDialogItemBuilder;
            if (((SmsPermissionsUtil) this.f6585j.get()).b()) {
                i = 2131232380;
            } else {
                i = 2131232381;
            }
            menuDialogItemBuilder2.b = i;
            menuDialogItemBuilder = menuDialogItemBuilder2;
            menuDialogItemBuilder.d = "sms promo enable readonly";
            menuDialogParamsBuilder.a(menuDialogItemBuilder.f());
        }
        return menuDialogParamsBuilder;
    }

    private void m6272a(Provider<Boolean> provider, Provider<Boolean> provider2, Product product, com.facebook.inject.Lazy<NotificationSettingsUtil> lazy, com.facebook.inject.Lazy<ThreadUnreadCountUtil> lazy2, Provider<Boolean> provider3, com.facebook.inject.Lazy<SmsPermissionsUtil> lazy3) {
        this.f6579d = provider;
        this.f6580e = provider2;
        this.f6581f = product;
        this.f6582g = lazy;
        this.f6583h = lazy2;
        this.f6584i = provider3;
        this.f6585j = lazy3;
    }

    private boolean m6273a(int i, ThreadSummary threadSummary) {
        ThreadKey threadKey = threadSummary.a;
        if (ThreadKey.e(threadKey)) {
            return f6577b.contains(Integer.valueOf(i));
        }
        if (f6577b.contains(Integer.valueOf(i))) {
            return false;
        }
        if (ThreadKey.d(threadKey)) {
            return f6576a.contains(Integer.valueOf(i));
        }
        if (ThreadKey.g(threadKey)) {
            return f6578c.contains(Integer.valueOf(i));
        }
        if (!ThreadKey.c(threadKey) && i == 4) {
            return false;
        }
        if (i == 5) {
            return ((Boolean) this.f6584i.get()).booleanValue();
        }
        if (i != 10) {
            return true;
        }
        boolean z = threadSummary.a == null ? false : (!((Boolean) this.f6580e.get()).booleanValue() || this.f6581f != Product.MESSENGER || threadSummary.a.b() || threadSummary.a.d() || threadSummary.a.e()) ? false : true;
        return z;
    }
}

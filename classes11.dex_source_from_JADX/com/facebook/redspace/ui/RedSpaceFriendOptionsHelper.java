package com.facebook.redspace.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.menu.MenuItemImpl;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.fbui.popover.PopoverMenuWindow;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.fbui.popover.PopoverWindow.OnDismissListener;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.redspace.abtest.RedSpaceStrings;
import com.facebook.redspace.analytics.logger.RedSpaceLogger;
import com.facebook.redspace.data.RedSpaceFriendsCollection;
import com.facebook.redspace.data.RedSpaceFriendsFetchResult;
import com.facebook.redspace.data.RedSpaceFriendsSection;
import com.facebook.redspace.data.RedSpaceMutationsExecutor;
import com.facebook.redspace.fetcher.RedSpaceViewerProfileFetcher;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFeedProfileFragmentModel;
import com.facebook.redspace.ui.animation.RedSpaceAnimations;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.collect.ImmutableList;
import javax.inject.Provider;

@ContextScoped
/* compiled from: PROCESSING */
public class RedSpaceFriendOptionsHelper {
    private static final String f12310c = RedSpaceFriendOptionsHelper.class.getSimpleName();
    private static RedSpaceFriendOptionsHelper f12311k;
    private static final Object f12312l = new Object();
    @Inject
    volatile Provider<RedSpaceFriendsCollection> f12313a = UltralightRuntime.a;
    @Inject
    volatile Provider<RedSpaceAnimations> f12314b = UltralightRuntime.a;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<IFeedIntentBuilder> f12315d = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<RedSpaceMutationsExecutor> f12316e = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<RedSpaceLogger> f12317f = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<SecureContextHelper> f12318g = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<RedSpaceViewerProfileFetcher> f12319h = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<RedSpaceStrings> f12320i = UltralightRuntime.b;
    public PopoverMenuWindow f12321j;

    /* compiled from: PROCESSING */
    public class C14563 implements OnDismissListener {
        final /* synthetic */ RedSpaceFriendOptionsHelper f12309a;

        public C14563(RedSpaceFriendOptionsHelper redSpaceFriendOptionsHelper) {
            this.f12309a = redSpaceFriendOptionsHelper;
        }

        public final boolean m12736a(PopoverWindow popoverWindow) {
            this.f12309a.f12321j = null;
            return false;
        }
    }

    private static RedSpaceFriendOptionsHelper m12739b(InjectorLike injectorLike) {
        RedSpaceFriendOptionsHelper redSpaceFriendOptionsHelper = new RedSpaceFriendOptionsHelper();
        redSpaceFriendOptionsHelper.m12738a(IdBasedProvider.a(injectorLike, 10169), IdBasedProvider.a(injectorLike, 10222), IdBasedSingletonScopeProvider.b(injectorLike, 2347), IdBasedSingletonScopeProvider.b(injectorLike, 10172), IdBasedSingletonScopeProvider.b(injectorLike, 10162), IdBasedSingletonScopeProvider.b(injectorLike, 968), IdBasedLazy.a(injectorLike, 10188), IdBasedLazy.a(injectorLike, 3264));
        return redSpaceFriendOptionsHelper;
    }

    private void m12738a(Provider<RedSpaceFriendsCollection> provider, Provider<RedSpaceAnimations> provider2, com.facebook.inject.Lazy<IFeedIntentBuilder> lazy, com.facebook.inject.Lazy<RedSpaceMutationsExecutor> lazy2, com.facebook.inject.Lazy<RedSpaceLogger> lazy3, com.facebook.inject.Lazy<SecureContextHelper> lazy4, com.facebook.inject.Lazy<RedSpaceViewerProfileFetcher> lazy5, com.facebook.inject.Lazy<RedSpaceStrings> lazy6) {
        this.f12313a = provider;
        this.f12314b = provider2;
        this.f12315d = lazy;
        this.f12316e = lazy2;
        this.f12317f = lazy3;
        this.f12318g = lazy4;
        this.f12319h = lazy5;
        this.f12320i = lazy6;
    }

    public static RedSpaceFriendOptionsHelper m12737a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RedSpaceFriendOptionsHelper b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12312l) {
                RedSpaceFriendOptionsHelper redSpaceFriendOptionsHelper;
                if (a2 != null) {
                    redSpaceFriendOptionsHelper = (RedSpaceFriendOptionsHelper) a2.a(f12312l);
                } else {
                    redSpaceFriendOptionsHelper = f12311k;
                }
                if (redSpaceFriendOptionsHelper == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12739b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12312l, b3);
                        } else {
                            f12311k = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = redSpaceFriendOptionsHelper;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m12741a(Context context, View view, final RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel, final RedSpaceFriendsSection redSpaceFriendsSection) {
        this.f12321j = new PopoverMenuWindow(context);
        this.f12321j.H = new C14563(this);
        PopoverMenu c = this.f12321j.c();
        MenuItemImpl a;
        if (redSpaceFriendsSection.isTop()) {
            a = c.a(((RedSpaceStrings) this.f12320i.get()).i());
            a.setIcon(2130839819);
            a.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                final /* synthetic */ RedSpaceFriendOptionsHelper f12305c;

                public boolean onMenuItemClick(MenuItem menuItem) {
                    this.f12305c.m12743a(redSpaceFeedProfileFragmentModel, redSpaceFriendsSection, RedSpaceFriendOptionsHelper.m12740b(redSpaceFriendsSection));
                    return true;
                }
            });
        } else {
            a = c.a(((RedSpaceStrings) this.f12320i.get()).h());
            a.setIcon(2130840035);
            a.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                final /* synthetic */ RedSpaceFriendOptionsHelper f12308c;

                public boolean onMenuItemClick(MenuItem menuItem) {
                    this.f12308c.m12744b(redSpaceFeedProfileFragmentModel, redSpaceFriendsSection, RedSpaceFriendOptionsHelper.m12740b(redSpaceFriendsSection));
                    return true;
                }
            });
        }
        this.f12321j.a(view);
        RedSpaceLogger redSpaceLogger = (RedSpaceLogger) this.f12317f.get();
        String b = m12740b(redSpaceFriendsSection);
        HoneyClientEventFast a2 = redSpaceLogger.b.a("open_person_options", false);
        if (a2.a()) {
            a2.a("redspace");
            a2.a("source", b);
            a2.b();
        }
    }

    public final void m12743a(RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel, RedSpaceFriendsSection redSpaceFriendsSection, String str) {
        ((RedSpaceMutationsExecutor) this.f12316e.get()).m12286a(redSpaceFeedProfileFragmentModel, redSpaceFriendsSection);
        RedSpaceLogger redSpaceLogger = (RedSpaceLogger) this.f12317f.get();
        String k = redSpaceFeedProfileFragmentModel.k();
        HoneyClientEventFast a = redSpaceLogger.b.a("remove_from_frequents", false);
        if (a.a()) {
            a.a("redspace");
            a.a("source", str);
            a.a("person_id", k);
            a.b();
        }
    }

    public final void m12744b(RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel, RedSpaceFriendsSection redSpaceFriendsSection, String str) {
        ((RedSpaceMutationsExecutor) this.f12316e.get()).m12287a(redSpaceFeedProfileFragmentModel, redSpaceFriendsSection, true);
        RedSpaceLogger redSpaceLogger = (RedSpaceLogger) this.f12317f.get();
        String k = redSpaceFeedProfileFragmentModel.k();
        HoneyClientEventFast a = redSpaceLogger.b.a("add_to_frequents", false);
        if (a.a()) {
            a.a("redspace");
            a.a("source", str);
            a.a("person_id", k);
            a.b();
        }
    }

    public final void m12742a(Context context, RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel, String str) {
        if (context != null) {
            if (context instanceof Activity) {
                this.f12314b.get();
                RedSpaceAnimations.m12836a((Activity) context);
            }
            RedSpaceFriendsCollection redSpaceFriendsCollection = (RedSpaceFriendsCollection) this.f12313a.get();
            redSpaceFriendsCollection.m12214a(new RedSpaceFriendsFetchResult(ImmutableList.of(redSpaceFeedProfileFragmentModel), null, null, null));
            Intent intent = new Intent(context, RedSpaceUserActivity.class);
            intent.putExtra("bundle_collection_single", redSpaceFriendsCollection);
            intent.putExtra("bundle_source", str);
            ((SecureContextHelper) this.f12318g.get()).a(intent, context);
        }
    }

    public static String m12740b(RedSpaceFriendsSection redSpaceFriendsSection) {
        return redSpaceFriendsSection.isOverflow() ? "person_list" : "grid";
    }
}

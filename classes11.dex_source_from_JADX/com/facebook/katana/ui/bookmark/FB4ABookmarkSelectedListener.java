package com.facebook.katana.ui.bookmark;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import com.facebook.adsmanager.deeplinking.AdsManagerDeepLinkingUtils;
import com.facebook.analytics.util.LoggerUtils;
import com.facebook.api.feedtype.FeedType;
import com.facebook.api.feedtype.FeedType.Name;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.base.activity.ReactFragmentActivity;
import com.facebook.bookmark.BookmarkManager;
import com.facebook.bookmark.client.BookmarkClient;
import com.facebook.bookmark.model.Bookmark;
import com.facebook.bookmark.model.BookmarkWithOnClickIntent;
import com.facebook.bookmark.ui.analytics.BookmarkAnalytics;
import com.facebook.bookmark.ui.event.BaseBookmarkSelectedListener;
import com.facebook.bookmark.ui.event.BookmarkEvent;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.TriState;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.events.gating.ExperimentsForEventsGatingModule;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.ContextScope;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.intent.thirdparty.NativeThirdPartyUriHelper;
import com.facebook.katana.activity.FacebookActivity;
import com.facebook.katana.activity.FacebookActivityDelegate;
import com.facebook.katana.activity.photos.PhotosTabActivity;
import com.facebook.katana.app.module.FacebookActivityDelegateMethodAutoProvider;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.nearby.v2.logging.NearbyPlacesSession.EntryPoint;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.saved.analytics.SaveAnalyticsLogger.Referer;
import com.facebook.saved.gating.feature.SavedDashboardV2;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: weekly_new_likes */
public class FB4ABookmarkSelectedListener extends BaseBookmarkSelectedListener {
    private static FB4ABookmarkSelectedListener f150k;
    private static final Object f151l = new Object();
    private final BookmarkManager f152a;
    private final FacebookActivityDelegate f153b;
    private final Provider<TriState> f154c;
    private final Lazy<Fb4aUriIntentMapper> f155d;
    private final QeAccessor f156e;
    private final GatekeeperStoreImpl f157f;
    private final AdsManagerDeepLinkingUtils f158g;
    private final BookmarkAnalytics f159h;
    private ComponentName f160i;
    private ComponentName f161j;

    private static FB4ABookmarkSelectedListener m158b(InjectorLike injectorLike) {
        return new FB4ABookmarkSelectedListener((SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (BookmarkManager) BookmarkClient.a(injectorLike), FacebookActivityDelegateMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 2436), IdBasedProvider.a(injectorLike, 640), IdBasedProvider.a(injectorLike, 12), IdBasedProvider.a(injectorLike, 13), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), AdsManagerDeepLinkingUtils.a(injectorLike), BookmarkAnalytics.b(injectorLike));
    }

    public static FB4ABookmarkSelectedListener m155a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FB4ABookmarkSelectedListener b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f151l) {
                FB4ABookmarkSelectedListener fB4ABookmarkSelectedListener;
                if (a2 != null) {
                    fB4ABookmarkSelectedListener = (FB4ABookmarkSelectedListener) a2.a(f151l);
                } else {
                    fB4ABookmarkSelectedListener = f150k;
                }
                if (fB4ABookmarkSelectedListener == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m158b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f151l, b3);
                        } else {
                            f150k = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = fB4ABookmarkSelectedListener;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public FB4ABookmarkSelectedListener(SecureContextHelper secureContextHelper, BookmarkManager bookmarkManager, FacebookActivityDelegate facebookActivityDelegate, Lazy<Fb4aUriIntentMapper> lazy, Provider<TriState> provider, @FragmentChromeActivity Provider<ComponentName> provider2, @ReactFragmentActivity Provider<ComponentName> provider3, QeAccessor qeAccessor, GatekeeperStore gatekeeperStore, AdsManagerDeepLinkingUtils adsManagerDeepLinkingUtils, BookmarkAnalytics bookmarkAnalytics) {
        super(secureContextHelper);
        this.f153b = facebookActivityDelegate;
        this.f152a = bookmarkManager;
        this.f154c = provider;
        this.f155d = lazy;
        this.f156e = qeAccessor;
        this.f160i = (ComponentName) provider2.get();
        this.f161j = (ComponentName) provider3.get();
        this.f157f = gatekeeperStore;
        this.f158g = adsManagerDeepLinkingUtils;
        this.f159h = bookmarkAnalytics;
    }

    protected final boolean m161c(BookmarkEvent bookmarkEvent) {
        if (!bookmarkEvent.b().startsWith(FBLinks.aa)) {
            return super.c(bookmarkEvent);
        }
        LoggerUtils.a(bookmarkEvent.a).a("via_sidebar");
        this.f159h.a(bookmarkEvent, "local_module");
        this.f159h.a(bookmarkEvent.b);
        this.f153b.f();
        return true;
    }

    protected final void m159a(BookmarkEvent bookmarkEvent, @Nullable Intent intent) {
        super.a(bookmarkEvent, intent);
        String str = "local_module";
        if (intent == null) {
            str = "error";
        } else if (intent.hasExtra("application_link_type")) {
            str = intent.getStringExtra("application_link_type");
            intent.removeExtra("application_link_type");
        }
        this.f159h.a(bookmarkEvent.b);
        this.f159h.a(bookmarkEvent, str);
        if (!(intent == null || bookmarkEvent.b == null || !"group".equals(bookmarkEvent.b.type))) {
            intent.putExtra("group_feed_title", bookmarkEvent.b.toString());
        }
        if (intent != null && bookmarkEvent.b != null && bookmarkEvent.b.b() > 0) {
            if ("group".equals(bookmarkEvent.b.type) || "friend_list".equals(bookmarkEvent.b.type) || 586254444758776L == bookmarkEvent.b.id || 2344061033L == bookmarkEvent.b.id) {
                this.f152a.a(bookmarkEvent.b.id, 0);
            }
        }
    }

    protected final Intent m160b(BookmarkEvent bookmarkEvent) {
        Object obj;
        Bookmark bookmark = bookmarkEvent.b;
        if (bookmark == null || !(4748854339L == bookmark.id || 608920319153834L == bookmark.id)) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            FeedType feedType;
            if (608920319153834L == bookmark.id) {
                feedType = FeedType.a;
            } else {
                feedType = FeedType.b;
            }
            return m152a(feedType);
        } else if (bookmarkEvent.e) {
            return m153a(bookmark, bookmarkEvent);
        } else {
            String b = bookmarkEvent.b();
            if (bookmark != null && 217974574879787L == bookmark.id && (bookmarkEvent.a() instanceof Uri)) {
                return new Intent().setAction("android.intent.action.VIEW").setData((Uri) bookmarkEvent.a());
            }
            if (bookmark != null && 2344061033L == bookmark.id) {
                return m151a();
            }
            if (bookmark != null && 586254444758776L == bookmark.id) {
                return m157b();
            }
            if (bookmark != null && "friend_list".equals(bookmark.type)) {
                return m154a(String.valueOf(bookmark.id), bookmark.name);
            }
            if (bookmark != null && 6802152230L == bookmark.id && this.f158g.b()) {
                return AdsManagerDeepLinkingUtils.a("fb-ama://");
            }
            if (b == null) {
                ((AbstractFbErrorReporter) FbErrorReporterImpl.a(FbInjector.get(bookmarkEvent.a))).a("bookmarks", "The bookmark with id: " + (bookmarkEvent.b == null ? null : Long.valueOf(bookmarkEvent.b.id)) + " does not have url");
                return null;
            }
            Intent a;
            Intent intent;
            if (bookmark instanceof BookmarkWithOnClickIntent) {
                a = ((BookmarkWithOnClickIntent) bookmark).a();
            } else {
                a = null;
            }
            if (a == null) {
                String str;
                a = ((Fb4aUriIntentMapper) this.f155d.get()).a(bookmarkEvent.a, b);
                if (a == null && bookmarkEvent.b.id == 217974574879787L) {
                    str = "https://m.facebook.com/messages/";
                    a = ((Fb4aUriIntentMapper) this.f155d.get()).a(bookmarkEvent.a, str);
                } else {
                    str = b;
                }
                if (a == null) {
                    intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    NativeThirdPartyUriHelper.a(bookmarkEvent.a, intent);
                    if (bookmarkEvent.a != null && (bookmarkEvent.a instanceof FacebookActivity)) {
                        ((FacebookActivity) bookmarkEvent.a).i().e();
                    }
                    if (bookmark == null && bookmark.id == 176083715796362L) {
                        intent.putExtra("nearby_places_entry", EntryPoint.BOOKMARK);
                        return intent;
                    }
                }
            }
            intent = a;
            NativeThirdPartyUriHelper.a(bookmarkEvent.a, intent);
            ((FacebookActivity) bookmarkEvent.a).i().e();
            return bookmark == null ? intent : intent;
        }
    }

    private Intent m153a(Bookmark bookmark, BookmarkEvent bookmarkEvent) {
        if (bookmark != null && "friend_list".equals(bookmark.type)) {
            return m154a(String.valueOf(bookmark.id), bookmark.name);
        }
        if (bookmark != null && FBLinks.O.compareTo(m156a(bookmark.url)) == 0) {
            return ((Fb4aUriIntentMapper) this.f155d.get()).a(bookmarkEvent.a, bookmarkEvent.b());
        }
        if (bookmark == null || FBLinks.bm.compareTo(m156a(bookmark.url)) != 0 || TriState.YES != this.f154c.get()) {
            return null;
        }
        Intent intent = new Intent(bookmarkEvent.a, PhotosTabActivity.class);
        intent.putExtra("tab_to_show", "sync");
        return intent;
    }

    private Intent m152a(FeedType feedType) {
        Intent component = new Intent().setComponent(this.f160i);
        component.putExtra("target_fragment", ContentFragmentType.NATIVE_NEWS_FEED_FRAGMENT.ordinal());
        component.putExtra("feed_type", feedType.a());
        return component;
    }

    private Intent m154a(String str, String str2) {
        Intent a = m152a(new FeedType(str, Name.b));
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(str2);
        a.putExtra("feed_type_name", Name.b.A);
        a.putExtra("friend_list_feed_id", str);
        a.putExtra("friend_list_name", str2);
        return a;
    }

    private Intent m151a() {
        Intent component = new Intent().setComponent(this.f156e.a(Liveness.Live, ExperimentsForEventsGatingModule.N, false) ? this.f161j : this.f160i);
        component.putExtra("target_fragment", ContentFragmentType.EVENTS_DASHBOARD_FRAGMENT.ordinal());
        return component;
    }

    private Intent m157b() {
        Intent component = new Intent().setComponent(this.f160i);
        component.setPackage(this.f160i.getPackageName());
        component.putExtra("target_fragment", ContentFragmentType.SAVED_FRAGMENT.ordinal());
        component.putExtra("extra_referer", Referer.MOBILE_SAVED_BOOKMARK.toString());
        if (SavedDashboardV2.a(this.f157f)) {
            component.putExtra("inflate_fragment_before_animation", true);
        }
        return component;
    }

    private static String m156a(String str) {
        if (str != null) {
            Uri parse = Uri.parse(str);
            if (parse != null) {
                String builder = new Builder().scheme(parse.getScheme()).authority(parse.getAuthority()).path(parse.getPath()).toString();
                if (builder.endsWith("/")) {
                    return builder.substring(0, builder.length() - 1);
                }
                return builder;
            }
        }
        return null;
    }
}

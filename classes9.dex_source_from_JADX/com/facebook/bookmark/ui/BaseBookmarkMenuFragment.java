package com.facebook.bookmark.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import com.facebook.analytics.MessengerEntryLogger;
import com.facebook.analytics.MessengerEntryLogger.EntryPoints;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.apptab.state.TabBarStateManager;
import com.facebook.apptab.state.TabTag;
import com.facebook.base.fragment.FbFragment;
import com.facebook.bookmark.BookmarkLoaderCallbacks;
import com.facebook.bookmark.BookmarkManager;
import com.facebook.bookmark.BookmarkManager.BookmarkCallback;
import com.facebook.bookmark.client.BookmarkClient;
import com.facebook.bookmark.model.Bookmark;
import com.facebook.bookmark.model.BookmarksGroup;
import com.facebook.bookmark.ui.BookmarkAdapter.BaseViewItem;
import com.facebook.bookmark.ui.BookmarkAdapter.RowType;
import com.facebook.bookmark.ui.BookmarkAdapter.ViewItem;
import com.facebook.bookmark.ui.analytics.BookmarkAnalytics;
import com.facebook.bookmark.ui.event.BaseBookmarkSelectedListener;
import com.facebook.bookmark.ui.event.BookmarkEvent;
import com.facebook.bookmark.ui.event.BookmarkEventBuilder;
import com.facebook.common.callercontexttagger.AnalyticsTagger;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.locale.Locales;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.ui.bookmark.FB4ABookmarkSelectedListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.util.MessengerAppUtils;
import com.facebook.perf.InteractionTTILogger;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.qrcode.promo.QRCodePromoConfig;
import com.facebook.redspace.abtest.ExperimentsForRedSpaceExperimentsModule;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.OnDrawListenerSet.OnDrawListener;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.listview.ListViewProxy;
import com.facebook.widget.listview.ScrollableListContainer;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: receiver_profile */
public abstract class BaseBookmarkMenuFragment extends FbFragment implements OnScrollListener, OnItemClickListener, OnItemLongClickListener, AnalyticsFragment, BookmarkCallback, ScrollableListContainer {
    private static final Pattern ar = Pattern.compile("(" + FBLinks.b + "[^?]+)(\\?.*)?");
    private static String ay = null;
    @Inject
    TabBarStateManager f5696a;
    @Inject
    InteractionTTILogger al;
    @Inject
    QeAccessor am;
    @Inject
    QRCodePromoConfig an;
    protected int ao;
    protected BookmarkAdapter ap;
    protected Map<Long, Integer> aq = Maps.c();
    public boolean as = false;
    private OnDrawListener at;
    private final int au;
    private BetterListView av;
    private int aw = 0;
    private int ax = -1;
    private ImmutableSet<String> az;
    @Inject
    BookmarkAnalytics f5697b;
    @Inject
    AnalyticsTagger f5698c;
    @Inject
    PerformanceLogger f5699d;
    @Inject
    Locales f5700e;
    @Inject
    protected BaseBookmarkSelectedListener f5701f;
    @Inject
    public BookmarkManager f5702g;
    @Inject
    MessengerAppUtils f5703h;
    @Inject
    MessengerEntryLogger f5704i;

    /* compiled from: receiver_profile */
    class C06061 implements OnDrawListener {
        final /* synthetic */ BaseBookmarkMenuFragment f5695a;

        C06061(BaseBookmarkMenuFragment baseBookmarkMenuFragment) {
            this.f5695a = baseBookmarkMenuFragment;
        }

        public final boolean gD_() {
            if (this.f5695a.as && this.f5695a.ap.getCount() > 0) {
                this.f5695a.f5699d.a(TabTag.Bookmark.loadTabTabPerfMarkerId, TabTag.Bookmark.loadTabTabPerfMarkerName, "load_type", "hot", false);
                this.f5695a.f5699d.c(TabTag.Bookmark.loadTabTabPerfMarkerId, TabTag.Bookmark.loadTabTabPerfMarkerName);
                this.f5695a.f5699d.a(TabTag.Bookmark.loadTabTabPerfMarkerIdNoAnim, TabTag.Bookmark.loadTabTabPerfMarkerNameNoAnim, "load_type", "hot", false);
                this.f5695a.f5699d.c(TabTag.Bookmark.loadTabTabPerfMarkerIdNoAnim, TabTag.Bookmark.loadTabTabPerfMarkerNameNoAnim);
                this.f5695a.as = false;
            }
            return false;
        }
    }

    /* compiled from: receiver_profile */
    public enum ViewItemType implements RowType {
        Profile,
        NewsFeed,
        Messages,
        Bookmark,
        Divider,
        CollapsibleDivider,
        SeeAll,
        IconLabel,
        Loader,
        Ad
    }

    public static void m5919a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((BaseBookmarkMenuFragment) obj).m5917a(TabBarStateManager.a(injectorLike), BookmarkAnalytics.m5960b(injectorLike), AnalyticsTagger.a(injectorLike), (PerformanceLogger) DelegatingPerformanceLogger.a(injectorLike), Locales.a(injectorLike), (BaseBookmarkSelectedListener) FB4ABookmarkSelectedListener.a(injectorLike), BookmarkClient.m5806a(injectorLike), MessengerAppUtils.a(injectorLike), MessengerEntryLogger.a(injectorLike), InteractionTTILogger.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), QRCodePromoConfig.b(injectorLike));
    }

    protected abstract void aq();

    protected abstract int m5928e();

    private void m5917a(TabBarStateManager tabBarStateManager, BookmarkAnalytics bookmarkAnalytics, AnalyticsTagger analyticsTagger, PerformanceLogger performanceLogger, Locales locales, BaseBookmarkSelectedListener baseBookmarkSelectedListener, BookmarkManager bookmarkManager, MessengerAppUtils messengerAppUtils, MessengerEntryLogger messengerEntryLogger, InteractionTTILogger interactionTTILogger, QeAccessor qeAccessor, QRCodePromoConfig qRCodePromoConfig) {
        this.f5696a = tabBarStateManager;
        this.f5697b = bookmarkAnalytics;
        this.f5698c = analyticsTagger;
        this.f5699d = performanceLogger;
        this.f5700e = locales;
        this.f5701f = baseBookmarkSelectedListener;
        this.f5702g = bookmarkManager;
        this.f5703h = messengerAppUtils;
        this.f5704i = messengerEntryLogger;
        this.al = interactionTTILogger;
        this.am = qeAccessor;
        this.an = qRCodePromoConfig;
    }

    public BaseBookmarkMenuFragment(int i, int i2) {
        this.ao = i;
        this.au = i2;
    }

    public void m5926c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = BaseBookmarkMenuFragment.class;
        m5919a(this, getContext());
        Builder builder = ImmutableSet.builder();
        ImmutableList immutableList = this.f5696a.a().a;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            String replace = ((TabTag) immutableList.get(i)).fblink.replace("_tab", "");
            builder.c(replace);
            if (!replace.endsWith("/")) {
                builder.c(replace + "/");
            }
        }
        this.az = builder.b();
        this.f5699d.a(TabTag.Bookmark.loadTabTabPerfMarkerId, TabTag.Bookmark.loadTabTabPerfMarkerName, "load_type", this.f5702g.mo221d() == DataFreshnessResult.NO_DATA ? "cold" : "warm", true);
        this.f5699d.a(TabTag.Bookmark.loadTabTabPerfMarkerIdNoAnim, TabTag.Bookmark.loadTabTabPerfMarkerNameNoAnim, "load_type", this.f5702g.mo221d() == DataFreshnessResult.NO_DATA ? "cold" : "warm", true);
        this.at = new C06061(this);
    }

    public View m5921a(LayoutInflater layoutInflater, ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1001483779);
        View inflate = layoutInflater.inflate(this.ao, viewGroup, false);
        this.f5698c.a(inflate, "sidebar_menu", this);
        this.av = (BetterListView) inflate.findViewById(this.au);
        this.av.a(this.at);
        this.av.setOnScrollListener(this);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -701145182, a);
        return inflate;
    }

    public void m5927d(@Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2059522615);
        super.d(bundle);
        this.ap = new BookmarkAdapter(m5928e());
        aq();
        this.av.setEnabled(true);
        this.av.setOnItemClickListener(this);
        this.av.setOnItemLongClickListener(this);
        this.av.setAdapter(this.ap);
        E().a(0, null, new BookmarkLoaderCallbacks(getContext(), this.f5702g, true, this));
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1198968792, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1895121128);
        super.mY_();
        this.av = null;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 2000303552, a);
    }

    public final void m5924a(List<ViewItem> list) {
        Preconditions.checkNotNull(list);
        if (mx_()) {
            if (!this.an.b()) {
                int i;
                List arrayList = new ArrayList();
                for (i = 0; i < list.size(); i++) {
                    Bookmark c = ((ViewItem) list.get(i)).mo226c();
                    if (c != null && c.id == 215892748571027L) {
                        arrayList.add(Integer.valueOf(i));
                    }
                }
                for (i = arrayList.size() - 1; i >= 0; i--) {
                    list.remove(((Integer) arrayList.get(i)).intValue());
                }
                list = list;
            }
            for (int i2 = 0; i2 < list.size(); i2++) {
                Bookmark c2 = ((ViewItem) list.get(i2)).mo226c();
                if (c2 != null) {
                    this.aq.put(Long.valueOf(c2.id), Integer.valueOf(i2));
                }
            }
            this.ap.m5958a(list);
            this.f5697b.m5963a(this.ap.m5957a());
        }
    }

    public void m5920G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1990071208);
        super.G();
        String c = this.f5700e.c();
        if (ay == null) {
            ay = c;
        }
        if (!Objects.equal(c, ay)) {
            ay = c;
            this.f5702g.mo215a();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1854718099, a);
    }

    protected final boolean m5925b(Bookmark bookmark) {
        if (bookmark.id == 678003258979791L) {
            return false;
        }
        if (bookmark.id == 217974574879787L) {
            return true;
        }
        if (bookmark.url != null && bookmark.url.startsWith(FBLinks.aa)) {
            return this.am.a(ExperimentsForRedSpaceExperimentsModule.h, false);
        }
        Matcher matcher = ar.matcher(bookmark.url);
        if (matcher.matches() && this.az.contains(matcher.group(1)) && 608920319153834L != bookmark.id) {
            return true;
        }
        return false;
    }

    public final void mo212a(Bookmark bookmark) {
        if (this.aq.containsKey(Long.valueOf(bookmark.id))) {
            BaseViewItem baseViewItem = (BaseViewItem) this.ap.getItem(((Integer) this.aq.get(Long.valueOf(bookmark.id))).intValue());
            if (baseViewItem.f5707d instanceof Bookmark) {
                ((Bookmark) baseViewItem.f5707d).m5860a(bookmark.m5863b());
                AdapterDetour.a(this.ap, -62681230);
                return;
            }
            BLog.b(BaseBookmarkMenuFragment.class, "could not update unread count in the list view because the position went wrong!");
        }
    }

    public void mo213a(BookmarksGroup bookmarksGroup) {
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.aw = i;
        this.ax = i2;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.av != null) {
            Object itemAtPosition = this.av.getItemAtPosition(i);
            if (itemAtPosition instanceof BaseViewItem) {
                BaseViewItem baseViewItem = (BaseViewItem) itemAtPosition;
                if (baseViewItem.f5707d instanceof Bookmark) {
                    String str;
                    Bookmark c = baseViewItem.mo226c();
                    String str2 = ((Bookmark) baseViewItem.f5707d).url;
                    if (217974574879787L == c.id) {
                        this.f5704i.a(EntryPoints.BOOKMARKS);
                        if (!this.f5703h.d()) {
                            str2 = "https://m.facebook.com/messages/";
                        }
                    }
                    if (230259100322928L == c.id) {
                        str2 = FBLinks.D;
                    }
                    if (983686418327131L == c.id) {
                        str2 = StringFormatUtil.formatStrLocaleSafe(FBLinks.y, "bookmarks");
                    }
                    if (526732794016279L == c.id) {
                        str2 = FBLinks.fp;
                    }
                    if (1051106384948944L == c.id) {
                        str = FBLinks.ga;
                    } else {
                        str = str2;
                    }
                    m5918a((Bookmark) baseViewItem.f5707d, baseViewItem, str);
                }
            }
        }
    }

    private void m5918a(Bookmark bookmark, @Nullable BaseViewItem baseViewItem, @Nullable String str) {
        this.al.a(getClass().getSimpleName());
        BaseBookmarkSelectedListener baseBookmarkSelectedListener = this.f5701f;
        BookmarkEventBuilder newBuilder = BookmarkEvent.newBuilder();
        newBuilder.f5743a = (Activity) getContext();
        BookmarkEventBuilder bookmarkEventBuilder = newBuilder;
        bookmarkEventBuilder.f5744b = bookmark;
        bookmarkEventBuilder = bookmarkEventBuilder;
        bookmarkEventBuilder.f5745c = baseViewItem;
        bookmarkEventBuilder = bookmarkEventBuilder;
        if (str == null) {
            str = bookmark.url;
        }
        bookmarkEventBuilder.f5746d = str;
        if (!baseBookmarkSelectedListener.m5965a(bookmarkEventBuilder.m5971a())) {
            this.al.a();
        }
    }

    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object itemAtPosition = this.av.getItemAtPosition(i);
        if (!(itemAtPosition instanceof BaseViewItem)) {
            return false;
        }
        BaseViewItem baseViewItem = (BaseViewItem) itemAtPosition;
        if (!(baseViewItem.f5707d instanceof Bookmark)) {
            return false;
        }
        String str;
        BaseBookmarkSelectedListener baseBookmarkSelectedListener;
        BookmarkEventBuilder newBuilder;
        BookmarkEventBuilder bookmarkEventBuilder;
        BookmarkEventBuilder bookmarkEventBuilder2;
        String str2 = baseViewItem.mo226c().url;
        if (baseViewItem.mo226c().id == 217974574879787L) {
            this.f5704i.a(EntryPoints.BOOKMARKS);
            if (!this.f5703h.d()) {
                str = "https://m.facebook.com/messages/";
                baseBookmarkSelectedListener = this.f5701f;
                newBuilder = BookmarkEvent.newBuilder();
                newBuilder.f5743a = (Activity) getContext();
                newBuilder = newBuilder;
                newBuilder.f5744b = (Bookmark) baseViewItem.f5707d;
                bookmarkEventBuilder = newBuilder;
                bookmarkEventBuilder.f5747e = true;
                bookmarkEventBuilder = bookmarkEventBuilder;
                bookmarkEventBuilder.f5745c = baseViewItem;
                bookmarkEventBuilder2 = bookmarkEventBuilder;
                bookmarkEventBuilder2.f5746d = str;
                return baseBookmarkSelectedListener.m5965a(bookmarkEventBuilder2.m5971a());
            }
        }
        str = str2;
        baseBookmarkSelectedListener = this.f5701f;
        newBuilder = BookmarkEvent.newBuilder();
        newBuilder.f5743a = (Activity) getContext();
        newBuilder = newBuilder;
        newBuilder.f5744b = (Bookmark) baseViewItem.f5707d;
        bookmarkEventBuilder = newBuilder;
        bookmarkEventBuilder.f5747e = true;
        bookmarkEventBuilder = bookmarkEventBuilder;
        bookmarkEventBuilder.f5745c = baseViewItem;
        bookmarkEventBuilder2 = bookmarkEventBuilder;
        bookmarkEventBuilder2.f5746d = str;
        return baseBookmarkSelectedListener.m5965a(bookmarkEventBuilder2.m5971a());
    }

    public final void gB_() {
        if (this.av != null) {
            this.av.smoothScrollToPosition(0);
        }
    }

    public final boolean gC_() {
        return this.av != null && this.av.getFirstVisiblePosition() == 0;
    }

    @Nullable
    public ScrollingViewProxy m5929n() {
        return this.av == null ? null : new ListViewProxy(this.av);
    }

    public final String am_() {
        return TabTag.Bookmark.analyticsTag;
    }
}

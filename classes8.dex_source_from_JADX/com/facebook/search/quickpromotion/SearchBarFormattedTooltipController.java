package com.facebook.search.quickpromotion;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.fbui.popover.PopoverWindow.OnDismissListener;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.fbui.tooltip.Tooltip.OnTooltipClickListener;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.abtest.SearchAbTestGatekeepers;
import com.facebook.search.logging.SearchAwarenessLogger;
import com.facebook.search.model.SearchAwarenessUnitProperties;
import com.facebook.search.quickpromotion.SearchAwarenessFormattedTooltip.C23762;
import com.facebook.search.quickpromotion.SearchAwarenessFormattedTooltip.C23773;
import com.facebook.search.quickpromotion.SearchAwarenessOptOutController.OnActionClickListener;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import javax.inject.Provider;

/* compiled from: TC; */
public class SearchBarFormattedTooltipController implements AwarenessUnitController {
    @Inject
    public volatile Provider<SearchAwarenessFormattedTooltip> f22486a = UltralightRuntime.a;
    private final Context f22487b;
    private final SearchAwarenessLogger f22488c;
    public final AbstractFbErrorReporter f22489d;
    public final SearchAwarenessUnitProperties f22490e;
    public final SearchAwarenessController f22491f;
    public final SearchAwarenessOptOutController f22492g;
    public final View f22493h;
    private final UriIntentMapper f22494i;
    private final SecureContextHelper f22495j;
    public final QeAccessor f22496k;
    private final GatekeeperStoreImpl f22497l;
    @Nullable
    public Tooltip f22498m;

    /* compiled from: TC; */
    class C23971 implements OnDismissListener {
        final /* synthetic */ SearchBarFormattedTooltipController f22481a;

        C23971(SearchBarFormattedTooltipController searchBarFormattedTooltipController) {
            this.f22481a = searchBarFormattedTooltipController;
        }

        public final boolean m25960a(PopoverWindow popoverWindow) {
            this.f22481a.mo1237d();
            this.f22481a.mo1238e();
            return true;
        }
    }

    /* compiled from: TC; */
    public class C23982 implements OnClickListener {
        final /* synthetic */ SearchBarFormattedTooltipController f22482a;

        public C23982(SearchBarFormattedTooltipController searchBarFormattedTooltipController) {
            this.f22482a = searchBarFormattedTooltipController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1876001413);
            if (this.f22482a.f22498m != null) {
                this.f22482a.f22498m.l();
            }
            SearchBarFormattedTooltipController.m25964a(this.f22482a, this.f22482a.f22496k.a(ExperimentsForSearchAbTestModule.ax, ""));
            Logger.a(2, EntryType.UI_INPUT_END, 845204211, a);
        }
    }

    /* compiled from: TC; */
    public class C24003 implements OnClickListener {
        final /* synthetic */ SearchBarFormattedTooltipController f22484a;

        /* compiled from: TC; */
        class C23991 implements OnActionClickListener {
            final /* synthetic */ C24003 f22483a;

            C23991(C24003 c24003) {
                this.f22483a = c24003;
            }

            public final void mo1239a() {
                if (this.f22483a.f22484a.f22498m != null) {
                    this.f22483a.f22484a.f22498m.l();
                    this.f22483a.f22484a.f22491f.a(this.f22483a.f22484a.f22490e.f22251a);
                }
            }

            public final void mo1240b() {
                if (this.f22483a.f22484a.f22498m != null) {
                    this.f22483a.f22484a.f22498m.l();
                    this.f22483a.f22484a.f22491f.a(this.f22483a.f22484a.f22490e.f22251a);
                }
            }
        }

        public C24003(SearchBarFormattedTooltipController searchBarFormattedTooltipController) {
            this.f22484a = searchBarFormattedTooltipController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -772364477);
            if (SearchBarFormattedTooltipController.m25965b(this.f22484a)) {
                this.f22484a.f22492g.m25893a(AwarenessType.LEARNING_NUX, new C23991(this), this.f22484a.f22493h.getWindowToken());
            } else {
                this.f22484a.f22491f.a(this.f22484a.f22490e.f22251a);
                if (this.f22484a.f22498m != null) {
                    this.f22484a.f22498m.l();
                }
            }
            LogUtils.a(-1673724949, a);
        }
    }

    /* compiled from: TC; */
    public class C24014 implements OnTooltipClickListener {
        final /* synthetic */ SearchBarFormattedTooltipController f22485a;

        public C24014(SearchBarFormattedTooltipController searchBarFormattedTooltipController) {
            this.f22485a = searchBarFormattedTooltipController;
        }

        public final void m25963a() {
            SearchBarFormattedTooltipController.m25964a(this.f22485a, this.f22485a.f22496k.a(ExperimentsForSearchAbTestModule.ax, ""));
            this.f22485a.mo1237d();
        }
    }

    @Inject
    public SearchBarFormattedTooltipController(Context context, @Assisted View view, @Assisted SearchAwarenessUnitProperties searchAwarenessUnitProperties, @Assisted SearchAwarenessController searchAwarenessController, SearchAwarenessOptOutController searchAwarenessOptOutController, UriIntentMapper uriIntentMapper, SecureContextHelper secureContextHelper, QeAccessor qeAccessor, GatekeeperStoreImpl gatekeeperStoreImpl, SearchAwarenessLogger searchAwarenessLogger, AbstractFbErrorReporter abstractFbErrorReporter) {
        Preconditions.checkNotNull(view);
        Preconditions.checkNotNull(searchAwarenessUnitProperties);
        this.f22487b = context;
        this.f22494i = uriIntentMapper;
        this.f22495j = secureContextHelper;
        this.f22496k = qeAccessor;
        this.f22497l = gatekeeperStoreImpl;
        this.f22488c = searchAwarenessLogger;
        this.f22490e = searchAwarenessUnitProperties;
        this.f22491f = searchAwarenessController;
        this.f22492g = searchAwarenessOptOutController;
        this.f22493h = view;
        this.f22489d = abstractFbErrorReporter;
    }

    public final boolean mo1236c() {
        return !this.f22492g.m25894a(AwarenessType.LEARNING_NUX) && this.f22490e.f22256f;
    }

    public final void mo1235a(ImmutableMap<String, ?> immutableMap) {
        SearchAwarenessFormattedTooltip searchAwarenessFormattedTooltip;
        Object g = this.f22490e.f22251a.mo560g();
        Object d = this.f22490e.f22251a.mo559d();
        if (TextUtils.isEmpty(g) && TextUtils.isEmpty(d)) {
            this.f22489d.a("SearchAwareness", "title and description are empty for formatted tooltip.");
            searchAwarenessFormattedTooltip = null;
        } else {
            searchAwarenessFormattedTooltip = (SearchAwarenessFormattedTooltip) this.f22486a.get();
            searchAwarenessFormattedTooltip.a(Html.fromHtml(g));
            searchAwarenessFormattedTooltip.b(Html.fromHtml(d));
            searchAwarenessFormattedTooltip.a(Position.BELOW);
            searchAwarenessFormattedTooltip.t = -1;
            searchAwarenessFormattedTooltip.f22374t = 0.7f;
            if (this.f22496k.a(ExperimentsForSearchAbTestModule.as, false)) {
                searchAwarenessFormattedTooltip.x = false;
                searchAwarenessFormattedTooltip.f22368n.setOnClickListener(new C23762(searchAwarenessFormattedTooltip, new C23982(this)));
                searchAwarenessFormattedTooltip.f22369o.setOnClickListener(new C23773(searchAwarenessFormattedTooltip, new C24003(this)));
            } else {
                searchAwarenessFormattedTooltip.a(new C24014(this));
            }
            searchAwarenessFormattedTooltip.f(this.f22493h);
        }
        this.f22498m = searchAwarenessFormattedTooltip;
        if (this.f22498m != null) {
            this.f22498m.H = new C23971(this);
        }
        this.f22488c.a(this.f22490e, immutableMap);
    }

    public final void mo1237d() {
        this.f22490e.f22256f = false;
    }

    public final void mo1238e() {
        if (this.f22498m != null) {
            this.f22488c.b(this.f22490e);
            this.f22498m = null;
        }
    }

    public static void m25964a(SearchBarFormattedTooltipController searchBarFormattedTooltipController, String str) {
        if (!TextUtils.isEmpty(str)) {
            Intent a = searchBarFormattedTooltipController.f22494i.a(searchBarFormattedTooltipController.f22487b, str);
            if (a != null) {
                a.addFlags(268435456);
                searchBarFormattedTooltipController.f22495j.a(a, searchBarFormattedTooltipController.f22487b);
            }
        }
    }

    public static boolean m25965b(SearchBarFormattedTooltipController searchBarFormattedTooltipController) {
        return searchBarFormattedTooltipController.f22497l.a(SearchAbTestGatekeepers.l, false);
    }
}

package com.facebook.composer.minutiae.ridge;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import com.facebook.audiofingerprinting.AudioFingerprintingSuggestionsCache;
import com.facebook.base.fragment.AbstractFbFragmentListener;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.util.TriState;
import com.facebook.composer.minutiae.MinutiaeSuggestionAdapter;
import com.facebook.composer.minutiae.analytics.RidgeAnalyticsEventBuilder;
import com.facebook.composer.minutiae.analytics.RidgeAnalyticsLogger;
import com.facebook.composer.minutiae.event.MinutiaeEventBus;
import com.facebook.composer.minutiae.event.MinutiaeEventSubscriber;
import com.facebook.composer.minutiae.event.MinutiaeEvents.RidgeDisabledEvent;
import com.facebook.composer.minutiae.event.MinutiaeEvents.RidgeEnabledEvent;
import com.facebook.composer.minutiae.event.MinutiaeEvents.RidgeFailedEvent;
import com.facebook.composer.minutiae.event.MinutiaeEvents.RidgeRefreshEvent;
import com.facebook.composer.minutiae.event.MinutiaeEvents.RidgeResultsFoundEvent;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLInterfaces.MinutiaeTaggableActivity;
import com.facebook.composer.minutiae.prefs.MinutiaePrefKeys;
import com.facebook.composer.minutiae.ridge.config.RidgeTooltipNuxXConfigUtil;
import com.facebook.composer.minutiae.util.MinutiaeConfiguration;
import com.facebook.composer.minutiae.util.RidgeOptInController;
import com.facebook.composer.minutiae.view.RidgeRefreshableListViewContainer;
import com.facebook.content.event.FbEvent;
import com.facebook.content.event.FbEventSubscriber;
import com.facebook.content.event.FbEventSubscriberListManager;
import com.facebook.inject.Assisted;
import com.facebook.widget.refreshableview.RefreshableViewContainerLike.OnRefreshListener;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: tile_count */
public class RidgeFragmentController extends AbstractFbFragmentListener {
    private static final String f1748a = RidgeFragmentController.class.getSimpleName();
    public final FbEventSubscriberListManager f1749b = new FbEventSubscriberListManager();
    private final Provider<TriState> f1750c;
    private final RidgeTooltipNuxXConfigUtil f1751d;
    private final AbstractFbErrorReporter f1752e;
    private final RidgeAnalyticsLogger f1753f;
    public final AudioFingerprintingSuggestionsCache f1754g;
    public final RidgeOptInController f1755h;
    public final MinutiaeEventBus f1756i;
    public final RidgeHost f1757j;
    public final MinutiaeSuggestionAdapter f1758k = ((MinutiaeSuggestionAdapter) Preconditions.checkNotNull(this.f1757j.as()));
    public final Optional<RidgeRefreshableListViewContainer> f1759l = ((Optional) Preconditions.checkNotNull(this.f1757j.at()));
    private final MinutiaeConfiguration f1760m = ((MinutiaeConfiguration) Preconditions.checkNotNull(this.f1757j.ar()));

    /* compiled from: tile_count */
    public class C01711 extends MinutiaeEventSubscriber<RidgeResultsFoundEvent> {
        final /* synthetic */ RidgeFragmentController f1743a;

        public C01711(RidgeFragmentController ridgeFragmentController) {
            this.f1743a = ridgeFragmentController;
        }

        public final void m1713b(FbEvent fbEvent) {
            this.f1743a.f1758k.m1429a(((RidgeResultsFoundEvent) fbEvent).f1523a);
            if (RidgeFragmentController.m1723i(this.f1743a)) {
                ((RidgeRefreshableListViewContainer) this.f1743a.f1759l.get()).f();
            }
        }

        public final Class m1712a() {
            return RidgeResultsFoundEvent.class;
        }
    }

    /* compiled from: tile_count */
    public class C01722 extends MinutiaeEventSubscriber<RidgeFailedEvent> {
        final /* synthetic */ RidgeFragmentController f1744a;

        public C01722(RidgeFragmentController ridgeFragmentController) {
            this.f1744a = ridgeFragmentController;
        }

        public final void m1715b(FbEvent fbEvent) {
            ((RidgeRefreshableListViewContainer) this.f1744a.f1759l.get()).m1854a(((RidgeFailedEvent) fbEvent).f1522a);
        }

        public final Class m1714a() {
            return RidgeFailedEvent.class;
        }
    }

    /* compiled from: tile_count */
    public class C01733 extends MinutiaeEventSubscriber<RidgeDisabledEvent> {
        final /* synthetic */ RidgeFragmentController f1745a;

        public C01733(RidgeFragmentController ridgeFragmentController) {
            this.f1745a = ridgeFragmentController;
        }

        public final void m1717b(FbEvent fbEvent) {
            ((RidgeRefreshableListViewContainer) this.f1745a.f1759l.get()).m1858k();
        }

        public final Class m1716a() {
            return RidgeDisabledEvent.class;
        }
    }

    /* compiled from: tile_count */
    public class C01744 extends MinutiaeEventSubscriber<RidgeEnabledEvent> {
        final /* synthetic */ RidgeFragmentController f1746a;

        public C01744(RidgeFragmentController ridgeFragmentController) {
            this.f1746a = ridgeFragmentController;
        }

        public final void m1719b(FbEvent fbEvent) {
            ((RidgeRefreshableListViewContainer) this.f1746a.f1759l.get()).m1859l();
        }

        public final Class m1718a() {
            return RidgeEnabledEvent.class;
        }
    }

    /* compiled from: tile_count */
    class C01755 extends OnRefreshListener {
        final /* synthetic */ RidgeFragmentController f1747a;

        C01755(RidgeFragmentController ridgeFragmentController) {
            this.f1747a = ridgeFragmentController;
        }

        public final void m1720b(boolean z) {
            if (!z) {
                return;
            }
            if (this.f1747a.f1755h.m1827c() && this.f1747a.f1755h.m1828e()) {
                this.f1747a.f1756i.a(new RidgeRefreshEvent());
            } else {
                ((RidgeRefreshableListViewContainer) this.f1747a.f1759l.get()).m1858k();
            }
        }
    }

    @Inject
    public RidgeFragmentController(@Assisted RidgeHost ridgeHost, Provider<TriState> provider, RidgeTooltipNuxXConfigUtil ridgeTooltipNuxXConfigUtil, FbErrorReporter fbErrorReporter, RidgeAnalyticsLogger ridgeAnalyticsLogger, AudioFingerprintingSuggestionsCache audioFingerprintingSuggestionsCache, RidgeOptInController ridgeOptInController, MinutiaeEventBus minutiaeEventBus) {
        this.f1750c = provider;
        this.f1751d = ridgeTooltipNuxXConfigUtil;
        this.f1752e = fbErrorReporter;
        this.f1753f = ridgeAnalyticsLogger;
        this.f1754g = audioFingerprintingSuggestionsCache;
        this.f1755h = ridgeOptInController;
        this.f1756i = minutiaeEventBus;
        this.f1757j = ridgeHost;
    }

    public final void m1724a(Fragment fragment, View view, Bundle bundle) {
        this.f1749b.a(new FbEventSubscriber[]{new C01711(this)});
        if (m1723i(this)) {
            this.f1749b.a(new FbEventSubscriber[]{new C01722(this), new C01733(this), new C01744(this)});
        }
        m1721g();
    }

    private void m1721g() {
        if (m1723i(this)) {
            boolean z;
            RidgeRefreshableListViewContainer ridgeRefreshableListViewContainer = (RidgeRefreshableListViewContainer) this.f1759l.get();
            if (m1722h()) {
                z = false;
            } else {
                z = true;
            }
            ridgeRefreshableListViewContainer.x = z;
            ((RidgeRefreshableListViewContainer) this.f1759l.get()).setOnRefreshListener(new C01755(this));
        }
    }

    public final void m1728d(Fragment fragment) {
        super.d(fragment);
        this.f1754g.f1070b = (MinutiaeTaggableActivity) this.f1757j.av().orNull();
        ImmutableList a = this.f1754g.m1023a();
        if (a == null) {
            return;
        }
        if (this.f1757j.aq()) {
            this.f1758k.f1348g = a;
        } else {
            this.f1758k.m1429a(a);
        }
    }

    public final void m1725b() {
        this.f1749b.b(this.f1756i);
    }

    public final void m1726c() {
        if (m1723i(this)) {
            boolean z;
            RidgeRefreshableListViewContainer ridgeRefreshableListViewContainer = (RidgeRefreshableListViewContainer) this.f1759l.get();
            if (m1722h()) {
                z = false;
            } else {
                z = true;
            }
            ridgeRefreshableListViewContainer.x = z;
        }
        this.f1749b.a(this.f1756i);
    }

    private boolean m1722h() {
        return this.f1755h.m1827c();
    }

    public static boolean m1723i(RidgeFragmentController ridgeFragmentController) {
        return ridgeFragmentController.f1759l.isPresent();
    }

    public final void m1727d() {
        if (this.f1750c.get() == TriState.YES && this.f1757j.au() && !this.f1755h.f1852a.a(MinutiaePrefKeys.f1619g, false) && !this.f1755h.m1832j() && this.f1755h.m1825a() < this.f1751d.m1732a()) {
            String l = this.f1760m.f1839e.l();
            if (this.f1751d.m1733a(l)) {
                this.f1757j.mo80e().mo67b(this.f1751d.m1735b(l));
                RidgeAnalyticsLogger ridgeAnalyticsLogger = this.f1753f;
                String str = this.f1757j.ar().f1835a;
                int a = this.f1755h.m1825a();
                RidgeAnalyticsEventBuilder a2 = RidgeAnalyticsLogger.m1551a("ridge_tooltip_nux_impression", str);
                a2.f1462a.a("ridge_tooltip_nux_impression_count", a);
                a2.m1550a(ridgeAnalyticsLogger.f1464a);
                RidgeOptInController ridgeOptInController = this.f1755h;
                ridgeOptInController.f1852a.edit().a(MinutiaePrefKeys.f1622j, ridgeOptInController.f1852a.a(MinutiaePrefKeys.f1622j, 0) + 1).commit();
                return;
            }
            this.f1752e.b(f1748a, "Invalid Ridge Tooltip Nux XConfig for action " + l + ": " + this.f1751d.m1734b());
        }
    }
}

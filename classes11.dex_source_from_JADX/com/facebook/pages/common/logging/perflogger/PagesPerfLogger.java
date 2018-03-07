package com.facebook.pages.common.logging.perflogger;

import android.os.ParcelUuid;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.content.event.FbEvent;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.inject.InjectorLike;
import com.facebook.pages.common.job_sequencer.PagesJobSequencer;
import com.facebook.pages.common.job_sequencer.SequencerSignal;
import com.facebook.pages.common.scoped_eventbus.scopedevent.PageScopedEventBus;
import com.facebook.pages.common.scoped_eventbus.scopedevent.PageScopedEventsSubscribers.PageFragmentScopedHeaderPerfLoggingEvent;
import com.facebook.pages.common.scoped_eventbus.scopedevent.PageScopedEventsSubscribers.PageFragmentScopedHeaderPerfLoggingEvent.HeaderPerfLoggingEventType;
import com.facebook.pages.common.scoped_eventbus.scopedevent.PageScopedEventsSubscribers.PageFragmentScopedHeaderPerfLoggingEventSubscriber;
import com.facebook.pages.common.sequencelogger.PageHeaderSequenceLoggerHelper;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.inject.Inject;

/* compiled from: share_call_to_action_title */
public class PagesPerfLogger {
    private final PageScopedEventBus f1653a;
    public final PageHeaderSequenceLoggerHelper f1654b;
    public final QuickPerformanceLogger f1655c;
    public final PagesJobSequencer f1656d;
    public int f1657e;
    public int f1658f;
    private PageFragmentScopedHeaderPerfLoggingEventSubscriber f1659g;
    public String f1660h;
    public TriState f1661i;
    public String f1662j;
    public final Map<String, String> f1663k = new HashMap();
    public HeaderPerfLoggingEventType f1664l;

    /* compiled from: share_call_to_action_title */
    /* synthetic */ class C02292 {
        static final /* synthetic */ int[] f1647a = new int[HeaderPerfLoggingEventType.values().length];

        static {
            try {
                f1647a[HeaderPerfLoggingEventType.ACTION_BAR_DISPATCH_DRAW_WITH_DATA.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1647a[HeaderPerfLoggingEventType.CALL_TO_ACTION.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* compiled from: share_call_to_action_title */
    public class EntityHeaderState {
        public final boolean f1648a;
        public final boolean f1649b;
        public final boolean f1650c;
        public final boolean f1651d;
        public final boolean f1652e;

        public EntityHeaderState(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
            this.f1648a = z;
            this.f1649b = z2;
            this.f1650c = z3;
            this.f1651d = z4;
            this.f1652e = z5;
        }
    }

    public static PagesPerfLogger m2463a(InjectorLike injectorLike) {
        return new PagesPerfLogger(PageScopedEventBus.a(injectorLike), PageHeaderSequenceLoggerHelper.a(injectorLike), QuickPerformanceLoggerMethodAutoProvider.a(injectorLike), PagesJobSequencer.m2443a(injectorLike));
    }

    @Inject
    public PagesPerfLogger(PageScopedEventBus pageScopedEventBus, PageHeaderSequenceLoggerHelper pageHeaderSequenceLoggerHelper, QuickPerformanceLogger quickPerformanceLogger, PagesJobSequencer pagesJobSequencer) {
        this.f1653a = pageScopedEventBus;
        this.f1654b = pageHeaderSequenceLoggerHelper;
        this.f1655c = quickPerformanceLogger;
        this.f1656d = pagesJobSequencer;
    }

    public final void m2466a(String str, String str2) {
        this.f1663k.put(str, str2);
        if (this.f1655c.f(1245312)) {
            this.f1655c.a(1245312, StringFormatUtil.a("%s:%s", new Object[]{str, str2}));
        }
    }

    public final void m2464a(String str) {
        this.f1654b.e(this.f1662j, str, null);
    }

    public final void m2465a(String str, ParcelUuid parcelUuid, EntityHeaderState entityHeaderState) {
        this.f1660h = str;
        if (parcelUuid != null) {
            this.f1662j = parcelUuid.toString();
        }
        this.f1657e = ((((1 << HeaderPerfLoggingEventType.HEADER_DISPATCH_DRAW_HAS_DATA.ordinal()) | (1 << HeaderPerfLoggingEventType.COVER_PHOTO_COMPLETE.ordinal())) | (1 << HeaderPerfLoggingEventType.PROFILE_PHOTO_COMPLETE.ordinal())) | (1 << HeaderPerfLoggingEventType.ACTION_BAR_DISPATCH_DRAW_WITH_DATA.ordinal())) | (1 << HeaderPerfLoggingEventType.CALL_TO_ACTION.ordinal());
        if (entityHeaderState.f1652e) {
            this.f1657e |= 1 << HeaderPerfLoggingEventType.METABAX.ordinal();
        }
        this.f1659g = new PageFragmentScopedHeaderPerfLoggingEventSubscriber(this, parcelUuid) {
            final /* synthetic */ PagesPerfLogger f1646b;

            public final void m2462b(FbEvent fbEvent) {
                PageFragmentScopedHeaderPerfLoggingEvent pageFragmentScopedHeaderPerfLoggingEvent = (PageFragmentScopedHeaderPerfLoggingEvent) fbEvent;
                PagesPerfLogger pagesPerfLogger = this.f1646b;
                pagesPerfLogger.f1658f |= 1 << pageFragmentScopedHeaderPerfLoggingEvent.c.ordinal();
                this.f1646b.f1664l = pageFragmentScopedHeaderPerfLoggingEvent.c;
                switch (C02292.f1647a[pageFragmentScopedHeaderPerfLoggingEvent.c.ordinal()]) {
                    case 1:
                        this.f1646b.f1654b.c("TimeToActionBarRendered", this.f1646b.f1662j, null);
                        this.f1646b.f1655c.a(1245312, (short) 104);
                        break;
                    case 2:
                        pagesPerfLogger = this.f1646b;
                        String str = "HasCta";
                        String str2 = (pageFragmentScopedHeaderPerfLoggingEvent.b.isPresent() && pageFragmentScopedHeaderPerfLoggingEvent.b.get() == DataFreshnessResult.NO_DATA) ? "false" : "true";
                        pagesPerfLogger.m2466a(str, str2);
                        break;
                }
                if (pageFragmentScopedHeaderPerfLoggingEvent.d != null) {
                    for (Entry entry : pageFragmentScopedHeaderPerfLoggingEvent.d.entrySet()) {
                        this.f1646b.m2466a((String) entry.getKey(), (String) entry.getValue());
                    }
                }
                pagesPerfLogger = this.f1646b;
                String str3 = this.f1646b.f1662j;
                boolean z = true;
                if ((pagesPerfLogger.f1657e & pagesPerfLogger.f1658f) == pagesPerfLogger.f1657e && !StringUtil.a(str3)) {
                    boolean z2;
                    if (pagesPerfLogger.f1664l != null) {
                        pagesPerfLogger.m2466a("LastEvent", pagesPerfLogger.f1664l.toString());
                    }
                    ImmutableMap copyOf = pagesPerfLogger.f1663k.isEmpty() ? null : ImmutableMap.copyOf(pagesPerfLogger.f1663k);
                    PageHeaderSequenceLoggerHelper pageHeaderSequenceLoggerHelper = pagesPerfLogger.f1654b;
                    if (pagesPerfLogger.f1661i == TriState.YES) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    pageHeaderSequenceLoggerHelper.a(z2, pagesPerfLogger.f1663k);
                    if (pagesPerfLogger.f1654b.c(str3)) {
                        PageHeaderSequenceLoggerHelper pageHeaderSequenceLoggerHelper2 = pagesPerfLogger.f1654b;
                        if (pagesPerfLogger.f1661i != TriState.YES) {
                            z = false;
                        }
                        pageHeaderSequenceLoggerHelper2.a(str3, z, copyOf);
                    }
                    pagesPerfLogger.f1655c.b(1245312, pagesPerfLogger.f1662j.hashCode(), (short) 2);
                    pagesPerfLogger.f1656d.m2450a(pagesPerfLogger.f1660h, ImmutableSet.of(SequencerSignal.HEADER_PERF_LOGGING_STOPPED));
                }
            }
        };
        this.f1653a.a(this.f1659g);
        this.f1655c.e(1245312, this.f1662j.hashCode());
        this.f1654b.a(this.f1662j).e(this.f1662j);
        if (entityHeaderState.f1648a) {
            m2466a("EntityHeaderEnabled", "true");
            m2466a("SplittingHeader", entityHeaderState.f1649b ? "true" : "false");
            m2466a("NarrowCta", entityHeaderState.f1650c ? "true" : "false");
            m2466a("HasMetabox", entityHeaderState.f1652e ? "true" : "false");
        }
    }

    public final void m2467e() {
        this.f1653a.b(this.f1659g);
    }
}

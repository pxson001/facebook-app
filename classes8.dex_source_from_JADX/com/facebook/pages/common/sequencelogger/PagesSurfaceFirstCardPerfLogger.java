package com.facebook.pages.common.sequencelogger;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.pages.common.constants.PagesPerfConstants.PageSequences;
import com.facebook.pages.common.constants.PagesPerfConstants.PageSequences.PageSurfaceFirstCardSequenceeDefinition;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.widget.OnDrawListenerSet.OnDrawListener;
import com.google.common.collect.ImmutableMap;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: creation_tab */
public class PagesSurfaceFirstCardPerfLogger {
    public final PagesSequenceLoggerHelper f16606a;
    public final QuickPerformanceLogger f16607b;
    public boolean f16608c;
    public final Map<String, String> f16609d = new HashMap();

    /* compiled from: creation_tab */
    public class OnFirstCardRenderedListenerImpl implements OnDrawListener {
        final /* synthetic */ PagesSurfaceFirstCardPerfLogger f16605a;

        public OnFirstCardRenderedListenerImpl(PagesSurfaceFirstCardPerfLogger pagesSurfaceFirstCardPerfLogger) {
            this.f16605a = pagesSurfaceFirstCardPerfLogger;
        }

        public final boolean gD_() {
            if (!this.f16605a.f16608c) {
                return false;
            }
            PagesSurfaceFirstCardPerfLogger pagesSurfaceFirstCardPerfLogger = this.f16605a;
            if (pagesSurfaceFirstCardPerfLogger.f16608c) {
                pagesSurfaceFirstCardPerfLogger.f16606a.m19633a(PageSequences.f1721g, ImmutableMap.copyOf(pagesSurfaceFirstCardPerfLogger.f16609d));
                pagesSurfaceFirstCardPerfLogger.f16607b.b(1245309, (short) 2);
            }
            return true;
        }
    }

    public static PagesSurfaceFirstCardPerfLogger m19639a(InjectorLike injectorLike) {
        return new PagesSurfaceFirstCardPerfLogger(PagesSequenceLoggerHelper.m19632b(injectorLike), QuickPerformanceLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public PagesSurfaceFirstCardPerfLogger(PagesSequenceLoggerHelper pagesSequenceLoggerHelper, QuickPerformanceLogger quickPerformanceLogger) {
        this.f16606a = pagesSequenceLoggerHelper;
        this.f16607b = quickPerformanceLogger;
    }

    public final void m19640a() {
        this.f16606a.m19636b("TimeToSurfaceTabFragmentCreate", PageSequences.f1721g);
        this.f16607b.a(1245309, (short) 82);
    }

    public final void m19642d() {
        if (!this.f16608c) {
            this.f16608c = true;
            this.f16606a.m19636b("TimeToFirstCardDataLoaded", PageSequences.f1721g);
            this.f16607b.a(1245309, (short) 24);
        }
    }

    public final void m19643e() {
        this.f16606a.m19637c(PageSequences.f1721g);
        this.f16607b.d(1245309);
    }

    public final void m19644f() {
        PagesSequenceLoggerHelper pagesSequenceLoggerHelper = this.f16606a;
        PageSurfaceFirstCardSequenceeDefinition pageSurfaceFirstCardSequenceeDefinition = PageSequences.f1721g;
        if (pagesSequenceLoggerHelper.f16603a.e(pageSurfaceFirstCardSequenceeDefinition) != null) {
            pagesSequenceLoggerHelper.f16603a.c(pageSurfaceFirstCardSequenceeDefinition);
        }
        this.f16607b.b(1245309, (short) 3);
    }

    public final void m19641a(String str, String str2) {
        this.f16609d.put(str, str2);
        if (this.f16607b.f(1245309)) {
            this.f16607b.a(1245309, StringFormatUtil.a("%s:%s", new Object[]{str, str2}));
        }
    }

    public final void m19645h() {
        this.f16607b.b(1245309);
        this.f16606a.m19637c(PageSequences.f1721g);
        this.f16606a.m19635b(PageSequences.f1721g);
        this.f16606a.m19634a("TimeToSurfaceTabFragmentCreate", PageSequences.f1721g);
        this.f16606a.m19634a("TimeToSurfaceTabFragmentViewCreated", PageSequences.f1721g);
        this.f16606a.m19634a("TimeToFirstCardDataLoadStart", PageSequences.f1721g);
        this.f16606a.m19634a("TimeToFirstCardDataLoaded", PageSequences.f1721g);
    }
}

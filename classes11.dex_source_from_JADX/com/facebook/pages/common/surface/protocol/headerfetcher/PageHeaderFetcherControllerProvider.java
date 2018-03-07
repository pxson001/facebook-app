package com.facebook.pages.common.surface.protocol.headerfetcher;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.pages.PageViewReferrer;
import com.facebook.pages.common.logging.analytics.PagesAnalytics;
import com.facebook.pages.common.sequencelogger.PageHeaderSequenceLoggerHelper;
import com.facebook.pages.common.sequencelogger.PagesManagerStartupSequencesHelper;
import com.facebook.pages.common.surface.protocol.headerfetcher.PageHeaderFetcherController.PageHeaderDataListener;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.ui.futures.TasksManager;

/* compiled from: response_received */
public class PageHeaderFetcherControllerProvider extends AbstractAssistedProvider<PageHeaderFetcherController> {
    public final PageHeaderFetcherController m3467a(PageHeaderDataListener pageHeaderDataListener, Long l, PageViewReferrer pageViewReferrer, String str) {
        return new PageHeaderFetcherController(QuickPerformanceLoggerMethodAutoProvider.a(this), PagesManagerStartupSequencesHelper.a(this), PageHeaderSequenceLoggerHelper.a(this), PagesAnalytics.a(this), TasksManager.b(this), PageHeaderFetchQueryExecutor.m3449b((InjectorLike) this), PageHeaderEarlyFetcher.m3439a((InjectorLike) this), pageHeaderDataListener, l, pageViewReferrer, str);
    }
}

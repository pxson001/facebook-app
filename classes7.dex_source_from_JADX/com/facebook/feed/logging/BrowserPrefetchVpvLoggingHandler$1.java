package com.facebook.feed.logging;

import com.facebook.browser.prefetch.BrowserPrefetcher;
import com.facebook.graphql.enums.GraphQLBrowserPrefetchType;

/* compiled from: android.intent.action.TIMEZONE_CHANGED */
class BrowserPrefetchVpvLoggingHandler$1 implements Runnable {
    final /* synthetic */ BrowserPrefetcher f19332a;
    final /* synthetic */ String f19333b;
    final /* synthetic */ GraphQLBrowserPrefetchType f19334c;
    final /* synthetic */ BrowserPrefetchVpvLoggingHandler f19335d;

    BrowserPrefetchVpvLoggingHandler$1(BrowserPrefetchVpvLoggingHandler browserPrefetchVpvLoggingHandler, BrowserPrefetcher browserPrefetcher, String str, GraphQLBrowserPrefetchType graphQLBrowserPrefetchType) {
        this.f19335d = browserPrefetchVpvLoggingHandler;
        this.f19332a = browserPrefetcher;
        this.f19333b = str;
        this.f19334c = graphQLBrowserPrefetchType;
    }

    public void run() {
        this.f19332a.a(this.f19333b, this.f19334c);
    }
}

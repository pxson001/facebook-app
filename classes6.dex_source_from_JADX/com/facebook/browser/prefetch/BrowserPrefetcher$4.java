package com.facebook.browser.prefetch;

import com.facebook.graphql.enums.GraphQLBrowserPrefetchType;
import java.util.List;

/* compiled from: privacy_scope_edit */
class BrowserPrefetcher$4 implements Runnable {
    final /* synthetic */ List f7429a;
    final /* synthetic */ BrowserPrefetcher f7430b;

    BrowserPrefetcher$4(BrowserPrefetcher browserPrefetcher, List list) {
        this.f7430b = browserPrefetcher;
        this.f7429a = list;
    }

    public void run() {
        this.f7430b.a(new BrowserPrefetchRequest(this.f7429a), false, GraphQLBrowserPrefetchType.HTML_ONLY);
    }
}

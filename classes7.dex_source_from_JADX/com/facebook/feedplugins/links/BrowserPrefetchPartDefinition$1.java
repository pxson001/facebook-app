package com.facebook.feedplugins.links;

import com.facebook.feedplugins.links.BrowserPrefetchPartDefinition.State;
import com.facebook.graphql.enums.GraphQLBrowserPrefetchType;

/* compiled from: SUCCESS */
class BrowserPrefetchPartDefinition$1 implements Runnable {
    final /* synthetic */ State f23510a;
    final /* synthetic */ GraphQLBrowserPrefetchType f23511b;
    final /* synthetic */ BrowserPrefetchPartDefinition f23512c;

    BrowserPrefetchPartDefinition$1(BrowserPrefetchPartDefinition browserPrefetchPartDefinition, State state, GraphQLBrowserPrefetchType graphQLBrowserPrefetchType) {
        this.f23512c = browserPrefetchPartDefinition;
        this.f23510a = state;
        this.f23511b = graphQLBrowserPrefetchType;
    }

    public void run() {
        this.f23512c.a.a(this.f23510a.c.toString(), this.f23511b);
    }
}

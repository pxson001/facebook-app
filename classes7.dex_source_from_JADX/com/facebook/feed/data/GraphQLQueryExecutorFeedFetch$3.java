package com.facebook.feed.data;

/* compiled from: appirater_should_show_dialog */
class GraphQLQueryExecutorFeedFetch$3 implements Runnable {
    final /* synthetic */ Throwable f19188a;
    final /* synthetic */ GraphQLQueryExecutorFeedFetch f19189b;

    GraphQLQueryExecutorFeedFetch$3(GraphQLQueryExecutorFeedFetch graphQLQueryExecutorFeedFetch, Throwable th) {
        this.f19189b = graphQLQueryExecutorFeedFetch;
        this.f19188a = th;
    }

    public void run() {
        if (!this.f19189b.c.f.b()) {
            this.f19189b.c.f.a(this.f19188a);
        }
    }
}

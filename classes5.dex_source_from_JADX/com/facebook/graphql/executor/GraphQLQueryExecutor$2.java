package com.facebook.graphql.executor;

import com.facebook.common.executors.BackgroundWorkLogger.StatsCollector;

/* compiled from: lightweight_place_picker_search_results_id */
class GraphQLQueryExecutor$2 extends Thread {
    final /* synthetic */ GraphQLQueryExecutor f3203a;

    GraphQLQueryExecutor$2(GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f3203a = graphQLQueryExecutor;
    }

    public void run() {
        StatsCollector a = this.f3203a.m.a("GraphQLQueryExecutor", "waitForQueueDrain");
        if (a != null) {
            a.a();
        }
        try {
            GraphQLQueryExecutor.t.writeLock().lock();
        } finally {
            if (a != null) {
                a.a(true);
            }
        }
    }
}

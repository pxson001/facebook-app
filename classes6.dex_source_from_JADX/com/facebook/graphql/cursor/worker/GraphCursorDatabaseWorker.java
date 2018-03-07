package com.facebook.graphql.cursor.worker;

import com.facebook.conditionalworker.ConditionalWorker;
import com.facebook.conditionalworker.ConditionalWorkerRunner;
import com.facebook.conditionalworker.States.AppState;
import com.facebook.graphql.cursor.database.GraphCursorDatabase;
import javax.inject.Inject;

/* compiled from: mPriority */
public class GraphCursorDatabaseWorker implements ConditionalWorker {
    private final GraphCursorDatabase f10986a;

    @Inject
    public GraphCursorDatabaseWorker(GraphCursorDatabase graphCursorDatabase) {
        this.f10986a = graphCursorDatabase;
    }

    public final boolean m17632a(ConditionalWorkerRunner conditionalWorkerRunner) {
        if (conditionalWorkerRunner.f.b() != AppState.BACKGROUND) {
            return false;
        }
        this.f10986a.ai_();
        return true;
    }
}

package com.facebook.ufiservices.data;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.util.concurrent.SettableFuture;
import java.util.List;

/* compiled from: data1 */
class FeedbackLoader$2 extends AbstractDisposableFutureCallback<List<GraphQLFeedback>> {
    final /* synthetic */ GraphQLFeedback f17986a;
    final /* synthetic */ SettableFuture f17987b;
    final /* synthetic */ FeedbackLoader f17988c;

    FeedbackLoader$2(FeedbackLoader feedbackLoader, GraphQLFeedback graphQLFeedback, SettableFuture settableFuture) {
        this.f17988c = feedbackLoader;
        this.f17986a = graphQLFeedback;
        this.f17987b = settableFuture;
    }

    protected final void m26510a(Object obj) {
        List<GraphQLFeedback> list = (List) obj;
        GraphQLFeedback graphQLFeedback = this.f17986a;
        GraphQLFeedback graphQLFeedback2 = graphQLFeedback;
        for (GraphQLFeedback graphQLFeedback3 : list) {
            if (graphQLFeedback3 != null) {
                graphQLFeedback3 = this.f17988c.m.b(graphQLFeedback2, graphQLFeedback3);
            } else {
                graphQLFeedback3 = graphQLFeedback2;
            }
            graphQLFeedback2 = graphQLFeedback3;
        }
        FutureDetour.a(this.f17987b, graphQLFeedback2, -2024857353);
    }

    protected final void m26511a(Throwable th) {
        this.f17987b.a(th);
    }
}

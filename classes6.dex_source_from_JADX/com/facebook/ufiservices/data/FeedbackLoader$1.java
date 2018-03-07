package com.facebook.ufiservices.data;

import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.RequestObserver;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.util.concurrent.SettableFuture;

/* compiled from: data1 */
class FeedbackLoader$1 implements RequestObserver<GraphQLResult<GraphQLFeedback>> {
    GraphQLFeedback f17982a = this.f17983b;
    final /* synthetic */ GraphQLFeedback f17983b;
    final /* synthetic */ SettableFuture f17984c;
    final /* synthetic */ FeedbackLoader f17985d;

    FeedbackLoader$1(FeedbackLoader feedbackLoader, GraphQLFeedback graphQLFeedback, SettableFuture settableFuture) {
        this.f17985d = feedbackLoader;
        this.f17983b = graphQLFeedback;
        this.f17984c = settableFuture;
    }

    public final void m26508a(Object obj) {
        this.f17982a = this.f17985d.m.b(this.f17982a, (GraphQLFeedback) ((GraphQLResult) obj).e);
    }

    public final void m26507a() {
        FutureDetour.a(this.f17984c, this.f17982a, -213268937);
    }

    public final void m26509a(Throwable th) {
        this.f17984c.a(th);
    }
}

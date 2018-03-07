package com.facebook.feed.util.composer;

import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.enums.GraphQLFeedOptimisticPublishState;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStory;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nonnull;

/* compiled from: should_ask_user */
class ComposerActivityReceiver$2 implements FutureCallback<OperationResult> {
    final /* synthetic */ GraphQLStory f3778a;
    final /* synthetic */ String f3779b;
    final /* synthetic */ String f3780c;
    final /* synthetic */ ComposerActivityReceiver f3781d;

    ComposerActivityReceiver$2(ComposerActivityReceiver composerActivityReceiver, GraphQLStory graphQLStory, String str, String str2) {
        this.f3781d = composerActivityReceiver;
        this.f3778a = graphQLStory;
        this.f3779b = str;
        this.f3780c = str2;
    }

    public void onSuccess(@Nonnull Object obj) {
        try {
            GraphQLStory a = OptimisticPostStoryBuilder.m4452a(this.f3778a, ((GraphQLMedia) ((GraphQLResult) ((OperationResult) obj).k()).d()).I());
            this.f3781d.m.a(a, GraphQLFeedOptimisticPublishState.SUCCESS);
            ComposerActivityReceiver.a(this.f3781d, this.f3779b, this.f3780c, a);
            this.f3781d.c.b(a);
            this.f3781d.c.b();
        } catch (Throwable e) {
            onFailure(e);
        }
    }

    public void onFailure(Throwable th) {
        this.f3781d.g.b("optimistic_fetch_failure", "requestId=" + this.f3779b + ", postId=" + this.f3780c, th);
        this.f3781d.m.a(this.f3778a, GraphQLFeedOptimisticPublishState.SUCCESS);
        this.f3781d.d.a(this.f3779b);
        this.f3781d.d.b(this.f3780c);
        this.f3781d.c.a();
    }
}

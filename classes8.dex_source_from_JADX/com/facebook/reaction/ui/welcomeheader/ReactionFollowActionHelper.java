package com.facebook.reaction.ui.welcomeheader;

import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.friends.FriendingClient;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.google.common.util.concurrent.FutureCallback;
import javax.inject.Inject;

/* compiled from: Undefined Header View State */
public class ReactionFollowActionHelper {
    public final DefaultAndroidThreadUtil f21206a;
    public final FriendingClient f21207b;
    public GraphQLSubscribeStatus f21208c;

    /* compiled from: Undefined Header View State */
    public class C22571 implements FutureCallback<Void> {
        final /* synthetic */ GraphQLSubscribeStatus f21204a;
        final /* synthetic */ ReactionFollowActionHelper f21205b;

        public C22571(ReactionFollowActionHelper reactionFollowActionHelper, GraphQLSubscribeStatus graphQLSubscribeStatus) {
            this.f21205b = reactionFollowActionHelper;
            this.f21204a = graphQLSubscribeStatus;
        }

        public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
        }

        public void onFailure(Throwable th) {
            this.f21205b.f21208c = this.f21204a;
        }
    }

    @Inject
    public ReactionFollowActionHelper(DefaultAndroidThreadUtil defaultAndroidThreadUtil, FriendingClient friendingClient) {
        this.f21206a = defaultAndroidThreadUtil;
        this.f21207b = friendingClient;
    }
}

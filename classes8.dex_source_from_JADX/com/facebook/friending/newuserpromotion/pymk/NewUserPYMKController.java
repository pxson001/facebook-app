package com.facebook.friending.newuserpromotion.pymk;

import android.content.Context;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.friending.newuserpromotion.NewUserFriendingAdapter;
import com.facebook.friends.FriendingClient;
import com.facebook.friends.constants.FriendingLocation;
import com.facebook.friends.controllers.FriendingExceptionHandler;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.inject.Assisted;
import com.facebook.ui.futures.TasksManager;
import javax.inject.Inject;

/* compiled from: fetched_from_memory_cache */
public class NewUserPYMKController {
    public final FriendingClient f13391a;
    public final FriendingExceptionHandler f13392b;
    public final Context f13393c;
    public final FriendingLocation f13394d;
    public final NewUserFriendingAdapter f13395e;
    public final TasksManager<String> f13396f;

    /* compiled from: fetched_from_memory_cache */
    public class C14241 extends AbstractDisposableFutureCallback<GraphQLFriendshipStatus> {
        final /* synthetic */ long f13388a;
        final /* synthetic */ GraphQLFriendshipStatus f13389b;
        final /* synthetic */ NewUserPYMKController f13390c;

        public C14241(NewUserPYMKController newUserPYMKController, long j, GraphQLFriendshipStatus graphQLFriendshipStatus) {
            this.f13390c = newUserPYMKController;
            this.f13388a = j;
            this.f13389b = graphQLFriendshipStatus;
        }

        public final void m15021a(Throwable th) {
            this.f13390c.f13392b.a(th);
            this.f13390c.f13395e.m14992a(this.f13388a, this.f13389b);
        }
    }

    @Inject
    public NewUserPYMKController(FriendingClient friendingClient, FriendingExceptionHandler friendingExceptionHandler, @Assisted Context context, @Assisted FriendingLocation friendingLocation, @Assisted NewUserFriendingAdapter newUserFriendingAdapter, @Assisted TasksManager tasksManager) {
        this.f13391a = friendingClient;
        this.f13392b = friendingExceptionHandler;
        this.f13393c = context;
        this.f13394d = friendingLocation;
        this.f13395e = newUserFriendingAdapter;
        this.f13396f = tasksManager;
    }
}

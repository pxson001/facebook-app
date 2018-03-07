package com.facebook.friending.newuserpromotion.friendrequests;

import android.content.Context;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.friending.newuserpromotion.NewUserFriendingAdapter;
import com.facebook.friends.FriendingCacheHandler;
import com.facebook.friends.FriendingCacheHandlerProvider;
import com.facebook.friends.FriendingClient;
import com.facebook.friends.constants.FriendingLocation;
import com.facebook.friends.controllers.FriendingExceptionHandler;
import com.facebook.friends.model.FriendRequest;
import com.facebook.friends.model.FriendRequestState;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.error.GraphQLException;
import com.facebook.inject.Assisted;
import com.facebook.ui.futures.TasksManager;
import javax.inject.Inject;

/* compiled from: field_label */
public class NewUserFriendRequestsController {
    public final FriendingClient f13380a;
    public final FriendingExceptionHandler f13381b;
    public final FriendingCacheHandler f13382c;
    public final Context f13383d;
    public final FriendingLocation f13384e;
    public final NewUserFriendingAdapter f13385f;
    public final TasksManager<String> f13386g;

    /* compiled from: field_label */
    public class C14231 extends AbstractDisposableFutureCallback<GraphQLFriendshipStatus> {
        final /* synthetic */ FriendRequest f13378a;
        final /* synthetic */ NewUserFriendRequestsController f13379b;

        public C14231(NewUserFriendRequestsController newUserFriendRequestsController, FriendRequest friendRequest) {
            this.f13379b = newUserFriendRequestsController;
            this.f13378a = friendRequest;
        }

        public final void m15015a(Throwable th) {
            NewUserFriendRequestsController newUserFriendRequestsController = this.f13379b;
            FriendRequest friendRequest = this.f13378a;
            newUserFriendRequestsController.f13381b.a(th);
            if (th instanceof GraphQLException) {
                newUserFriendRequestsController.f13385f.m14994a(friendRequest.b);
            } else {
                newUserFriendRequestsController.f13385f.m14995a(friendRequest.b, FriendRequestState.NEEDS_RESPONSE);
            }
        }
    }

    @Inject
    public NewUserFriendRequestsController(FriendingClient friendingClient, FriendingExceptionHandler friendingExceptionHandler, FriendingCacheHandlerProvider friendingCacheHandlerProvider, @Assisted Context context, @Assisted FriendingLocation friendingLocation, @Assisted NewUserFriendingAdapter newUserFriendingAdapter, @Assisted TasksManager tasksManager) {
        this.f13380a = friendingClient;
        this.f13381b = friendingExceptionHandler;
        this.f13382c = friendingCacheHandlerProvider.a(tasksManager);
        this.f13383d = context;
        this.f13384e = friendingLocation;
        this.f13385f = newUserFriendingAdapter;
        this.f13386g = tasksManager;
    }
}

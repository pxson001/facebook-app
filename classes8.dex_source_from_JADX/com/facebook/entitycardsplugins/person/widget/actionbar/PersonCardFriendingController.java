package com.facebook.entitycardsplugins.person.widget.actionbar;

import android.content.Context;
import com.facebook.entitycards.analytics.EntityCardsAnalytics.DismissalReason;
import com.facebook.entitycards.intent.EntityCardsFragment.C11761;
import com.facebook.entitycardsplugins.person.protocol.PersonCardGraphQLModels.PersonCardModel;
import com.facebook.entitycardsplugins.person.widget.actionbar.PersonCardActionBarPresenter.C12151;
import com.facebook.friends.FriendingClient;
import com.facebook.friends.constants.FriendRequestCancelRef;
import com.facebook.friends.constants.FriendRequestHowFound;
import com.facebook.friends.constants.FriendRequestMakeRef;
import com.facebook.friends.constants.FriendRequestResponse;
import com.facebook.friends.constants.FriendRequestResponseRef;
import com.facebook.friends.constants.FriendingLocation;
import com.facebook.friends.constants.RemoveFriendRef;
import com.facebook.friends.controllers.FriendingExceptionHandler;
import com.facebook.friends.events.FriendingEventBus;
import com.facebook.friends.events.FriendingEvents.UserBlockedEvent;
import com.facebook.graphql.calls.ActorSubscribeInputData;
import com.facebook.graphql.calls.ActorUnsubscribeInputData.SubscribeLocation;
import com.facebook.graphql.calls.ProfileUpdateSecondarySubscribeStatusInputData.Location;
import com.facebook.graphql.calls.ProfileUpdateSecondarySubscribeStatusInputData.NewStatus;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLSecondarySubscribeStatus;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.inject.Assisted;
import com.facebook.timeline.cache.TimelineUserDataCleaner;
import com.google.common.base.Functions;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: heisman_open_selfie_camera */
public class PersonCardFriendingController {
    public final FriendingLocation f11344a;
    public final FriendRequestMakeRef f11345b;
    public final FriendingClient f11346c;
    private final PersonCardFriendingDialogs f11347d;
    public final ExecutorService f11348e;
    public final Provider<String> f11349f;
    public final TimelineUserDataCleaner f11350g;
    public final FriendingExceptionHandler f11351h;
    public final FriendingEventBus f11352i;
    @Nullable
    public ListenableFuture<Void> f11353j = null;

    /* compiled from: heisman_open_selfie_camera */
    class C12264 implements FutureCallback<Void> {
        final /* synthetic */ PersonCardFriendingController f11329a;

        C12264(PersonCardFriendingController personCardFriendingController) {
            this.f11329a = personCardFriendingController;
        }

        public void onSuccess(Object obj) {
            this.f11329a.f11350g.a("BlockFromPersonCardOnSuccess");
        }

        public void onFailure(Throwable th) {
        }
    }

    /* compiled from: heisman_open_selfie_camera */
    /* synthetic */ class C12308 {
        static final /* synthetic */ int[] f11343a = new int[GraphQLFriendshipStatus.values().length];

        static {
            try {
                f11343a[GraphQLFriendshipStatus.CAN_REQUEST.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f11343a[GraphQLFriendshipStatus.ARE_FRIENDS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f11343a[GraphQLFriendshipStatus.INCOMING_REQUEST.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f11343a[GraphQLFriendshipStatus.OUTGOING_REQUEST.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f11343a[GraphQLFriendshipStatus.CANNOT_REQUEST.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    @Inject
    public PersonCardFriendingController(@Assisted FriendingLocation friendingLocation, @Assisted FriendRequestMakeRef friendRequestMakeRef, FriendingClient friendingClient, PersonCardFriendingDialogs personCardFriendingDialogs, ExecutorService executorService, Provider<String> provider, TimelineUserDataCleaner timelineUserDataCleaner, FriendingExceptionHandler friendingExceptionHandler, FriendingEventBus friendingEventBus) {
        this.f11344a = friendingLocation;
        this.f11345b = friendRequestMakeRef;
        this.f11346c = friendingClient;
        this.f11347d = personCardFriendingDialogs;
        this.f11348e = executorService;
        this.f11349f = provider;
        this.f11350g = timelineUserDataCleaner;
        this.f11351h = friendingExceptionHandler;
        this.f11352i = friendingEventBus;
    }

    public final void m13282a(Context context, PersonCardModel personCardModel, C12151 c12151) {
        if (this.f11353j == null || this.f11353j.isDone()) {
            long parseLong = Long.parseLong(personCardModel.m13204r());
            GraphQLFriendshipStatus j = personCardModel.m13196j();
            GraphQLSubscribeStatus n = personCardModel.m13200n();
            GraphQLSecondarySubscribeStatus m = personCardModel.m13199m();
            boolean d = personCardModel.m13194d();
            boolean do_ = personCardModel.do_();
            if (j != null) {
                switch (C12308.f11343a[j.ordinal()]) {
                    case 1:
                        m13275a(context, parseLong, j, n, m, d, do_, c12151);
                        return;
                    case 2:
                        m13276a(context, parseLong, personCardModel.m13207u(), j, n, m, d, do_, c12151);
                        return;
                    case 3:
                        m13280b(context, parseLong, j, n, m, d, do_, c12151);
                        return;
                    case 4:
                        m13274a(parseLong, j, n, m, d, do_, c12151);
                        return;
                    case 5:
                        return;
                    default:
                        return;
                }
            }
        }
    }

    private void m13275a(Context context, long j, GraphQLFriendshipStatus graphQLFriendshipStatus, GraphQLSubscribeStatus graphQLSubscribeStatus, GraphQLSecondarySubscribeStatus graphQLSecondarySubscribeStatus, boolean z, boolean z2, C12151 c12151) {
        this.f11353j = Futures.a(this.f11346c.b(j, m13273a(), null, this.f11345b), Functions.constant(null), this.f11348e);
        c12151.m13249a(GraphQLFriendshipStatus.OUTGOING_REQUEST, graphQLSubscribeStatus, graphQLSecondarySubscribeStatus, z, z2);
        m13279a(this.f11353j, graphQLFriendshipStatus, graphQLSubscribeStatus, graphQLSecondarySubscribeStatus, z, z2, c12151);
        m13278a(this.f11353j, j, context);
    }

    private void m13276a(Context context, long j, String str, GraphQLFriendshipStatus graphQLFriendshipStatus, GraphQLSubscribeStatus graphQLSubscribeStatus, GraphQLSecondarySubscribeStatus graphQLSecondarySubscribeStatus, boolean z, boolean z2, C12151 c12151) {
        final C12151 c121512 = c12151;
        final GraphQLSubscribeStatus graphQLSubscribeStatus2 = graphQLSubscribeStatus;
        final GraphQLSecondarySubscribeStatus graphQLSecondarySubscribeStatus2 = graphQLSecondarySubscribeStatus;
        final boolean z3 = z;
        final boolean z4 = z2;
        final long j2 = j;
        final GraphQLFriendshipStatus graphQLFriendshipStatus2 = graphQLFriendshipStatus;
        this.f11353j = Futures.b(this.f11347d.m13290a(context, str), new AsyncFunction<Void, Void>(this) {
            final /* synthetic */ PersonCardFriendingController f11316h;

            public final ListenableFuture m13270a(Object obj) {
                RemoveFriendRef removeFriendRef;
                c121512.m13249a(GraphQLFriendshipStatus.CAN_REQUEST, graphQLSubscribeStatus2, graphQLSecondarySubscribeStatus2, z3, z4);
                FriendingClient friendingClient = this.f11316h.f11346c;
                long j = j2;
                PersonCardFriendingController personCardFriendingController = this.f11316h;
                if (personCardFriendingController.f11344a == null || personCardFriendingController.f11344a.removeFriendRef == null) {
                    removeFriendRef = RemoveFriendRef.ENTITY_CARDS;
                } else {
                    removeFriendRef = personCardFriendingController.f11344a.removeFriendRef;
                }
                ListenableFuture a = Futures.a(friendingClient.a(j, removeFriendRef), Functions.constant(null), this.f11316h.f11348e);
                this.f11316h.m13279a(this.f11316h.f11353j, graphQLFriendshipStatus2, graphQLSubscribeStatus2, graphQLSecondarySubscribeStatus2, z3, z4, c121512);
                return a;
            }
        }, this.f11348e);
    }

    private void m13280b(Context context, long j, GraphQLFriendshipStatus graphQLFriendshipStatus, GraphQLSubscribeStatus graphQLSubscribeStatus, GraphQLSecondarySubscribeStatus graphQLSecondarySubscribeStatus, boolean z, boolean z2, C12151 c12151) {
        final C12151 c121512 = c12151;
        final GraphQLSubscribeStatus graphQLSubscribeStatus2 = graphQLSubscribeStatus;
        final GraphQLSecondarySubscribeStatus graphQLSecondarySubscribeStatus2 = graphQLSecondarySubscribeStatus;
        final boolean z3 = z;
        final boolean z4 = z2;
        final long j2 = j;
        final GraphQLFriendshipStatus graphQLFriendshipStatus2 = graphQLFriendshipStatus;
        this.f11353j = Futures.b(this.f11347d.m13289a(context), new AsyncFunction<FriendRequestResponse, Void>(this) {
            final /* synthetic */ PersonCardFriendingController f11324h;

            public final ListenableFuture m13271a(Object obj) {
                FriendRequestResponseRef friendRequestResponseRef;
                FriendRequestResponse friendRequestResponse = (FriendRequestResponse) obj;
                c121512.m13249a(friendRequestResponse == FriendRequestResponse.CONFIRM ? GraphQLFriendshipStatus.ARE_FRIENDS : GraphQLFriendshipStatus.CAN_REQUEST, graphQLSubscribeStatus2, graphQLSecondarySubscribeStatus2, z3, z4);
                FriendingClient friendingClient = this.f11324h.f11346c;
                long j = j2;
                PersonCardFriendingController personCardFriendingController = this.f11324h;
                if (personCardFriendingController.f11344a == null || personCardFriendingController.f11344a.friendRequestResponseRef == null) {
                    friendRequestResponseRef = FriendRequestResponseRef.ENTITY_CARDS;
                } else {
                    friendRequestResponseRef = personCardFriendingController.f11344a.friendRequestResponseRef;
                }
                ListenableFuture a = Futures.a(friendingClient.a(j, friendRequestResponse, friendRequestResponseRef), Functions.constant(null), this.f11324h.f11348e);
                this.f11324h.m13279a(this.f11324h.f11353j, graphQLFriendshipStatus2, graphQLSubscribeStatus2, graphQLSecondarySubscribeStatus2, z3, z4, c121512);
                return a;
            }
        }, this.f11348e);
    }

    private void m13274a(long j, GraphQLFriendshipStatus graphQLFriendshipStatus, GraphQLSubscribeStatus graphQLSubscribeStatus, GraphQLSecondarySubscribeStatus graphQLSecondarySubscribeStatus, boolean z, boolean z2, C12151 c12151) {
        this.f11353j = Futures.a(this.f11346c.a(j, m13281d()), Functions.constant(null), this.f11348e);
        c12151.m13249a(GraphQLFriendshipStatus.CAN_REQUEST, graphQLSubscribeStatus, graphQLSecondarySubscribeStatus, z, z2);
        m13279a(this.f11353j, graphQLFriendshipStatus, graphQLSubscribeStatus, graphQLSecondarySubscribeStatus, z, z2, c12151);
    }

    public final void m13283a(Context context, String str, final long j, final C12151 c12151) {
        this.f11353j = Futures.b(this.f11347d.m13291b(context, str), new AsyncFunction<Void, Void>(this) {
            final /* synthetic */ PersonCardFriendingController f11328c;

            /* compiled from: heisman_open_selfie_camera */
            class C12241 implements FutureCallback<Void> {
                final /* synthetic */ C12253 f11325a;

                C12241(C12253 c12253) {
                    this.f11325a = c12253;
                }

                public void onSuccess(Object obj) {
                    C12151 c12151 = c12151;
                    c12151.f11272a.f11305z.a(new UserBlockedEvent(Long.parseLong(c12151.f11272a.f11302w.m13204r())));
                    c12151.m13249a(GraphQLFriendshipStatus.CANNOT_REQUEST, GraphQLSubscribeStatus.CANNOT_SUBSCRIBE, GraphQLSecondarySubscribeStatus.REGULAR_FOLLOW, false, false);
                    C11761 c11761 = c12151.f11272a.f11279A;
                    c11761.f10965a.m12915a(true, DismissalReason.USER_BLOCKED);
                }

                public void onFailure(Throwable th) {
                }
            }

            public final ListenableFuture m13272a(@Nullable Object obj) {
                ListenableFuture a = this.f11328c.f11346c.a(Long.parseLong((String) this.f11328c.f11349f.get()), j);
                Futures.a(a, new C12241(this), this.f11328c.f11348e);
                return a;
            }
        }, this.f11348e);
        Futures.a(this.f11353j, new C12264(this), this.f11348e);
    }

    public final void m13284a(PersonCardModel personCardModel, C12151 c12151, GraphQLSubscribeStatus graphQLSubscribeStatus, GraphQLSecondarySubscribeStatus graphQLSecondarySubscribeStatus) {
        if (this.f11353j == null || this.f11353j.isDone()) {
            GraphQLFriendshipStatus j = personCardModel.m13196j();
            GraphQLSubscribeStatus n = personCardModel.m13200n();
            GraphQLSecondarySubscribeStatus m = personCardModel.m13199m();
            boolean d = personCardModel.m13194d();
            boolean do_ = personCardModel.do_();
            c12151.m13249a(j, graphQLSubscribeStatus, graphQLSecondarySubscribeStatus, d, do_);
            if (graphQLSubscribeStatus == GraphQLSubscribeStatus.CAN_SUBSCRIBE) {
                this.f11353j = this.f11346c.a(personCardModel.m13204r(), SubscribeLocation.ENTITY_CARDS);
            } else {
                Object obj = graphQLSecondarySubscribeStatus != m ? 1 : null;
                Object obj2 = (n != graphQLSubscribeStatus || (n == GraphQLSubscribeStatus.CAN_SUBSCRIBE && graphQLSecondarySubscribeStatus == GraphQLSecondarySubscribeStatus.SEE_FIRST)) ? 1 : null;
                final NewStatus newStatus = graphQLSecondarySubscribeStatus == GraphQLSecondarySubscribeStatus.SEE_FIRST ? NewStatus.SEE_FIRST : NewStatus.REGULAR_FOLLOW;
                if (obj2 != null) {
                    this.f11353j = this.f11346c.a(personCardModel.m13204r(), ActorSubscribeInputData.SubscribeLocation.ENTITY_CARDS);
                    if (obj != null) {
                        final PersonCardModel personCardModel2 = personCardModel;
                        Futures.a(this.f11353j, new FutureCallback<Void>(this) {
                            final /* synthetic */ PersonCardFriendingController f11332c;

                            public void onSuccess(@Nullable Object obj) {
                                this.f11332c.f11353j = this.f11332c.f11346c.a(personCardModel2.m13204r(), newStatus, Location.ENTITY_CARDS);
                            }

                            public void onFailure(Throwable th) {
                            }
                        }, this.f11348e);
                    }
                } else if (obj != null) {
                    this.f11353j = this.f11346c.a(personCardModel.m13204r(), newStatus, Location.ENTITY_CARDS);
                }
            }
            if (this.f11353j != null) {
                m13279a(this.f11353j, j, n, m, d, do_, c12151);
            }
        }
    }

    private static FriendRequestHowFound m13273a() {
        return FriendRequestHowFound.ENTITY_CARDS;
    }

    private FriendRequestCancelRef m13281d() {
        if (this.f11344a == null || this.f11344a.friendRequestCancelRef == null) {
            return FriendRequestCancelRef.ENTITY_CARDS;
        }
        return this.f11344a.friendRequestCancelRef;
    }

    private void m13279a(ListenableFuture listenableFuture, GraphQLFriendshipStatus graphQLFriendshipStatus, GraphQLSubscribeStatus graphQLSubscribeStatus, GraphQLSecondarySubscribeStatus graphQLSecondarySubscribeStatus, boolean z, boolean z2, C12151 c12151) {
        if (listenableFuture != null) {
            final C12151 c121512 = c12151;
            final GraphQLFriendshipStatus graphQLFriendshipStatus2 = graphQLFriendshipStatus;
            final GraphQLSubscribeStatus graphQLSubscribeStatus2 = graphQLSubscribeStatus;
            final GraphQLSecondarySubscribeStatus graphQLSecondarySubscribeStatus2 = graphQLSecondarySubscribeStatus;
            final boolean z3 = z;
            final boolean z4 = z2;
            Futures.a(listenableFuture, new FutureCallback(this) {
                final /* synthetic */ PersonCardFriendingController f11339g;

                public void onSuccess(Object obj) {
                }

                public void onFailure(Throwable th) {
                    c121512.m13249a(graphQLFriendshipStatus2, graphQLSubscribeStatus2, graphQLSecondarySubscribeStatus2, z3, z4);
                }
            }, this.f11348e);
        }
    }

    private void m13278a(ListenableFuture listenableFuture, final long j, final Context context) {
        if (listenableFuture != null) {
            Futures.a(listenableFuture, new FutureCallback<Void>(this) {
                final /* synthetic */ PersonCardFriendingController f11342c;

                public /* bridge */ /* synthetic */ void onSuccess(@Nullable Object obj) {
                }

                public void onFailure(Throwable th) {
                    FriendingExceptionHandler friendingExceptionHandler = this.f11342c.f11351h;
                    long j = j;
                    Context context = context;
                    PersonCardFriendingController personCardFriendingController = this.f11342c;
                    friendingExceptionHandler.a(th, 2131230758, DialogConfirmListenerHelper.m13248a(j, context, FriendRequestHowFound.ENTITY_CARDS, this.f11342c.f11345b, this.f11342c.f11346c, this.f11342c.f11352i, this.f11342c.f11351h, this.f11342c.f11348e), context);
                }
            }, this.f11348e);
        }
    }
}

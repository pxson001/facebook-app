package com.facebook.friends;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.util.LongSparseArray;
import com.facebook.auth.module.ViewerContextManagerProvider;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.C0055x2995691a;
import com.facebook.common.util.StringUtil;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.feed.abtest.ExperimentsForNewsFeedAbTestModule;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.friends.abtest.ExperimentsForFriendsExperimentModule;
import com.facebook.friends.cache.FriendshipStatusCache;
import com.facebook.friends.constants.FriendRequestCancelRef;
import com.facebook.friends.constants.FriendRequestHowFound;
import com.facebook.friends.constants.FriendRequestMakeRef;
import com.facebook.friends.constants.FriendRequestResponse;
import com.facebook.friends.constants.FriendRequestResponseRef;
import com.facebook.friends.constants.PeopleYouMayInviteLocation;
import com.facebook.friends.constants.PeopleYouMayKnowLocation;
import com.facebook.friends.constants.RemoveFriendRef;
import com.facebook.friends.model.FriendRequest;
import com.facebook.friends.model.PersonYouMayKnow;
import com.facebook.friends.protocol.BlockUserMethod.Params;
import com.facebook.friends.protocol.FriendMutations.ActorSecondarySubscribeCoreMutationString;
import com.facebook.friends.protocol.FriendMutations.ActorSubscribeCoreMutationString;
import com.facebook.friends.protocol.FriendMutations.ActorUnsubscribeCoreMutationString;
import com.facebook.friends.protocol.FriendMutations.ContactInviteCoreMutationString;
import com.facebook.friends.protocol.FriendMutations.FriendRemoveCoreMutationString;
import com.facebook.friends.protocol.FriendMutations.FriendRequestAcceptCoreMutationString;
import com.facebook.friends.protocol.FriendMutations.FriendRequestCancelCoreMutationString;
import com.facebook.friends.protocol.FriendMutations.FriendRequestDeleteCoreMutationString;
import com.facebook.friends.protocol.FriendMutations.FriendRequestSendCoreMutationString;
import com.facebook.friends.protocol.FriendMutations.FriendSuggestionIgnoreCoreMutationString;
import com.facebook.friends.protocol.FriendMutations.FutureFriendingCoreMutationString;
import com.facebook.friends.protocol.FriendMutationsModels.ContactInviteCoreMutationFieldsModel;
import com.facebook.friends.protocol.FriendMutationsModels.FutureFriendingCoreMutationFieldsModel;
import com.facebook.friends.protocol.FriendRequestsConsistencyGraphQLModels.FriendRequestsRepresentedProfileFieldsModel.Builder;
import com.facebook.friends.protocol.PokeUserMethod;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.graphql.calls.ActorSubscribeInputData;
import com.facebook.graphql.calls.ActorSubscribeInputData.SubscribeLocation;
import com.facebook.graphql.calls.ActorUnsubscribeInputData;
import com.facebook.graphql.calls.ContactInviteInputData;
import com.facebook.graphql.calls.FriendRemoveInputData;
import com.facebook.graphql.calls.FriendRequestAcceptInputData;
import com.facebook.graphql.calls.FriendRequestAcceptInputData.Source;
import com.facebook.graphql.calls.FriendRequestCancelInputData;
import com.facebook.graphql.calls.FriendRequestDeleteInputData;
import com.facebook.graphql.calls.FriendRequestSendInputData;
import com.facebook.graphql.calls.FriendRequestSendInputData.Refs;
import com.facebook.graphql.calls.FriendSuggestionIgnoreInputData;
import com.facebook.graphql.calls.FutureFriendingInputData;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.ProfileUpdateSecondarySubscribeStatusInputData;
import com.facebook.graphql.calls.ProfileUpdateSecondarySubscribeStatusInputData.Location;
import com.facebook.graphql.calls.ProfileUpdateSecondarySubscribeStatusInputData.NewStatus;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLSecondarySubscribeStatus;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.request.MutationRequest;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLPageInfo;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.inject.ForAppContext;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.InterstitialStartHelper;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.notifications.logging.NotificationsFunnelLogger;
import com.facebook.offlinemode.common.OfflineQueryBehavior;
import com.facebook.offlinemode.common.PendingRequest;
import com.facebook.offlinemode.db.PendingGraphQlMutationRequest;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Absent;
import com.google.common.base.Functions;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;

/* compiled from: framesCallToAction */
public class FriendingClient {
    private static final String f23293c = FriendingClient.class.getSimpleName();
    private static final AtomicInteger f23294d = new AtomicInteger(0);
    @GuardedBy("this")
    GraphQLPageInfo f23295a;
    @GuardedBy("this")
    GraphQLPageInfo f23296b;
    private final Context f23297e;
    public final DefaultBlueServiceOperationFactory f23298f;
    private final InterstitialStartHelper f23299g;
    public final FriendingStartOperationHelper f23300h;
    private final FriendingQueryExecutor f23301i;
    public final FriendshipStatusCache f23302j;
    public final FunnelLoggerImpl f23303k;
    public final ExecutorService f23304l;
    private final AbstractFbErrorReporter f23305m;
    private final ViewerContextManager f23306n;
    private final LongSparseArray<ListenableFuture<GraphQLFriendshipStatus>> f23307o = new LongSparseArray();
    public final FeedEventBus f23308p;
    private final QeAccessor f23309q;
    private final NotificationsFunnelLogger f23310r;

    public static FriendingClient m31425b(InjectorLike injectorLike) {
        return new FriendingClient((Context) injectorLike.getInstance(Context.class, ForAppContext.class), DefaultBlueServiceOperationFactory.m3782b(injectorLike), InterstitialStartHelper.m13670b(injectorLike), FriendingStartOperationHelper.m31459b(injectorLike), FriendingQueryExecutor.m31461a(injectorLike), FriendshipStatusCache.m31471a(injectorLike), FunnelLoggerImpl.m8018a(injectorLike), C0055x2995691a.m1881a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), ViewerContextManagerProvider.m2496b(injectorLike), FeedEventBus.m4573a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), NotificationsFunnelLogger.m29041a(injectorLike));
    }

    public static FriendingClient m31415a(InjectorLike injectorLike) {
        return m31425b(injectorLike);
    }

    @Inject
    public FriendingClient(@ForAppContext Context context, DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, InterstitialStartHelper interstitialStartHelper, FriendingStartOperationHelper friendingStartOperationHelper, FriendingQueryExecutor friendingQueryExecutor, FriendshipStatusCache friendshipStatusCache, FunnelLoggerImpl funnelLoggerImpl, ExecutorService executorService, AbstractFbErrorReporter abstractFbErrorReporter, ViewerContextManager viewerContextManager, FeedEventBus feedEventBus, QeAccessor qeAccessor, NotificationsFunnelLogger notificationsFunnelLogger) {
        this.f23297e = context;
        this.f23298f = defaultBlueServiceOperationFactory;
        this.f23299g = interstitialStartHelper;
        this.f23300h = friendingStartOperationHelper;
        this.f23301i = friendingQueryExecutor;
        this.f23302j = friendshipStatusCache;
        this.f23303k = funnelLoggerImpl;
        this.f23304l = executorService;
        this.f23305m = abstractFbErrorReporter;
        this.f23306n = viewerContextManager;
        this.f23308p = feedEventBus;
        this.f23309q = qeAccessor;
        this.f23310r = notificationsFunnelLogger;
        m31457h();
    }

    public final ListenableFuture<GraphQLFriendshipStatus> m31438a(long j, FriendRequestResponse friendRequestResponse, FriendRequestResponseRef friendRequestResponseRef) {
        if (friendRequestResponseRef == null) {
            Throwable illegalArgumentException = new IllegalArgumentException("FriendRequestResponseRef should not be null.");
            this.f23305m.m2346a(f23293c, illegalArgumentException);
            return Futures.m2453a(illegalArgumentException);
        }
        ListenableFuture a;
        switch (14.a[friendRequestResponse.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                a = m31417a(j, friendRequestResponseRef);
                m31423a(a, j, GraphQLFriendshipStatus.ARE_FRIENDS);
                m31421a(j, a);
                return a;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                a = m31426b(j, friendRequestResponseRef);
                m31423a(a, j, GraphQLFriendshipStatus.CAN_REQUEST);
                m31421a(j, a);
                return a;
            default:
                throw new IllegalArgumentException("Unexpected FriendRequestResponse: " + friendRequestResponse);
        }
    }

    private ListenableFuture<GraphQLFriendshipStatus> m31417a(long j, FriendRequestResponseRef friendRequestResponseRef) {
        FriendRequestAcceptInputData friendRequestAcceptInputData = new FriendRequestAcceptInputData();
        friendRequestAcceptInputData.m11395a("source", (Source) m31420a(Source.values(), friendRequestResponseRef.value));
        GraphQlCallInput graphQlCallInput = friendRequestAcceptInputData;
        graphQlCallInput.m11397a("friend_requester_id", String.valueOf(j));
        graphQlCallInput = graphQlCallInput;
        Builder builder = new Builder();
        builder.b = String.valueOf(j);
        builder = builder;
        builder.a = GraphQLFriendshipStatus.ARE_FRIENDS;
        builder = builder;
        builder.d = GraphQLSubscribeStatus.IS_SUBSCRIBED;
        GraphQLVisitableModel a = builder.a();
        TypedGraphQLMutationString friendRequestAcceptCoreMutationString = new FriendRequestAcceptCoreMutationString();
        friendRequestAcceptCoreMutationString.m11310a("input", graphQlCallInput);
        this.f23310r.m29050c("friend_accept");
        return Futures.m2450a(m31419a(friendRequestAcceptCoreMutationString, a, j), new 1(this), this.f23304l);
    }

    private ListenableFuture<GraphQLFriendshipStatus> m31426b(long j, FriendRequestResponseRef friendRequestResponseRef) {
        FriendRequestDeleteInputData friendRequestDeleteInputData = new FriendRequestDeleteInputData();
        friendRequestDeleteInputData.m11395a("source", (FriendRequestDeleteInputData.Source) m31420a(FriendRequestDeleteInputData.Source.values(), friendRequestResponseRef.value));
        GraphQlCallInput graphQlCallInput = friendRequestDeleteInputData;
        graphQlCallInput.m11397a("friend_requester_id", String.valueOf(j));
        graphQlCallInput = graphQlCallInput;
        Builder builder = new Builder();
        builder.b = String.valueOf(j);
        builder = builder;
        builder.a = GraphQLFriendshipStatus.CAN_REQUEST;
        GraphQLVisitableModel a = builder.a();
        TypedGraphQLMutationString friendRequestDeleteCoreMutationString = new FriendRequestDeleteCoreMutationString();
        friendRequestDeleteCoreMutationString.m11310a("input", graphQlCallInput);
        this.f23310r.m29050c("friend_reject");
        return Futures.m2450a(m31419a(friendRequestDeleteCoreMutationString, a, j), new 2(this), this.f23304l);
    }

    public final ListenableFuture<List<FriendRequest>> m31430a(int i, CallerContext callerContext) {
        return Futures.m2450a(this.f23301i.m31469a(m31427i(), i, callerContext), new 3(this), this.f23304l);
    }

    public final ListenableFuture<List<PersonYouMayKnow>> m31431a(int i, PeopleYouMayKnowLocation peopleYouMayKnowLocation, CallerContext callerContext) {
        return m31432a(i, null, peopleYouMayKnowLocation, callerContext);
    }

    public final ListenableFuture<List<PersonYouMayKnow>> m31432a(int i, @Nullable Integer num, PeopleYouMayKnowLocation peopleYouMayKnowLocation, CallerContext callerContext) {
        return Futures.m2450a(this.f23301i.m31470a(m31428j(), i, num, peopleYouMayKnowLocation, callerContext), new 4(this), this.f23304l);
    }

    public final ListenableFuture<Void> m31435a(long j, CallerContext callerContext) {
        Bundle bundle = new Bundle();
        bundle.putString("blacklistPeopleYouMayKnowParamsKey", String.valueOf(j));
        return Futures.m2450a(BlueServiceOperationFactoryDetour.a(this.f23298f, "friending_blacklist_people_you_may_know", bundle, ErrorPropagation.BY_EXCEPTION, callerContext, -495252278).mo3452a(), Functions.constant(null), this.f23304l);
    }

    public final ListenableFuture<GraphQLFriendshipStatus> m31437a(long j, FriendRequestHowFound friendRequestHowFound, @Nullable PeopleYouMayKnowLocation peopleYouMayKnowLocation, FriendRequestMakeRef friendRequestMakeRef) {
        Preconditions.checkNotNull(friendRequestHowFound);
        FriendRequestSendInputData a = new FriendRequestSendInputData().a((FriendRequestSendInputData.Source) m31420a(FriendRequestSendInputData.Source.values(), friendRequestHowFound.value)).a(ImmutableList.of(String.valueOf(j)));
        a.m11398a("warn_ack_for_ids", ImmutableList.of(String.valueOf(j)));
        return m31416a(j, friendRequestHowFound, peopleYouMayKnowLocation, friendRequestMakeRef, a);
    }

    public final ListenableFuture<GraphQLFriendshipStatus> m31450b(long j, FriendRequestHowFound friendRequestHowFound, @Nullable PeopleYouMayKnowLocation peopleYouMayKnowLocation, FriendRequestMakeRef friendRequestMakeRef) {
        Preconditions.checkNotNull(friendRequestHowFound);
        return m31416a(j, friendRequestHowFound, peopleYouMayKnowLocation, friendRequestMakeRef, new FriendRequestSendInputData().a((FriendRequestSendInputData.Source) m31420a(FriendRequestSendInputData.Source.values(), friendRequestHowFound.value)).a(ImmutableList.of(String.valueOf(j))));
    }

    private ListenableFuture<GraphQLFriendshipStatus> m31416a(long j, FriendRequestHowFound friendRequestHowFound, @Nullable PeopleYouMayKnowLocation peopleYouMayKnowLocation, FriendRequestMakeRef friendRequestMakeRef, FriendRequestSendInputData friendRequestSendInputData) {
        if (f23294d.get() > 32767) {
            f23294d.set(0);
        }
        short andIncrement = (short) f23294d.getAndIncrement();
        this.f23303k.m8034a(FunnelRegistry.f21176w, (long) andIncrement);
        this.f23310r.m29050c("friend_request");
        if (friendRequestMakeRef != null) {
            friendRequestSendInputData.m11398a("refs", ImmutableList.of((Refs) m31420a(Refs.values(), friendRequestMakeRef.value)));
        }
        if (peopleYouMayKnowLocation != null) {
            friendRequestSendInputData.m11395a("people_you_may_know_location", (FriendRequestSendInputData.PeopleYouMayKnowLocation) m31420a(FriendRequestSendInputData.PeopleYouMayKnowLocation.values(), peopleYouMayKnowLocation.value));
        }
        Builder builder = new Builder();
        builder.b = String.valueOf(j);
        builder = builder;
        builder.a = GraphQLFriendshipStatus.OUTGOING_REQUEST;
        builder = builder;
        builder.d = GraphQLSubscribeStatus.IS_SUBSCRIBED;
        GraphQLVisitableModel a = builder.a();
        TypedGraphQLMutationString friendRequestSendCoreMutationString = new FriendRequestSendCoreMutationString();
        friendRequestSendCoreMutationString.m11310a("input", (GraphQlCallInput) friendRequestSendInputData);
        ListenableFuture a2 = Futures.m2450a(m31419a(friendRequestSendCoreMutationString, a, j), new 6(this), this.f23304l);
        Futures.m2458a(a2, new 7(this, andIncrement, friendRequestHowFound), this.f23304l);
        m31423a(a2, j, GraphQLFriendshipStatus.OUTGOING_REQUEST);
        if (this.f23309q.mo596a(ExperimentsForNewsFeedAbTestModule.aa, false)) {
            m31422a(a2);
        }
        this.f23299g.m13671a(this.f23297e, new InterstitialTrigger(Action.FRIEND_REQUEST_SENT));
        if (friendRequestHowFound == FriendRequestHowFound.PROFILE_BUTTON) {
            this.f23299g.m13671a(this.f23297e, new InterstitialTrigger(Action.PROFILE_FRIEND_REQUEST_SENT));
        }
        a2 = Futures.m2459b(a2);
        m31421a(j, a2);
        return a2;
    }

    public final ListenableFuture<GraphQLFriendshipStatus> m31436a(long j, FriendRequestCancelRef friendRequestCancelRef) {
        FriendRequestCancelInputData friendRequestCancelInputData = new FriendRequestCancelInputData();
        friendRequestCancelInputData.m11395a("source", (FriendRequestCancelInputData.Source) m31420a(FriendRequestCancelInputData.Source.values(), friendRequestCancelRef.value));
        GraphQlCallInput graphQlCallInput = friendRequestCancelInputData;
        graphQlCallInput.m11397a("cancelled_friend_requestee_id", String.valueOf(j));
        graphQlCallInput = graphQlCallInput;
        Builder builder = new Builder();
        builder.b = String.valueOf(j);
        builder = builder;
        builder.a = GraphQLFriendshipStatus.CAN_REQUEST;
        GraphQLVisitableModel a = builder.a();
        TypedGraphQLMutationString friendRequestCancelCoreMutationString = new FriendRequestCancelCoreMutationString();
        friendRequestCancelCoreMutationString.m11310a("input", graphQlCallInput);
        ListenableFuture a2 = Futures.m2450a(m31419a(friendRequestCancelCoreMutationString, a, j), new 8(this), this.f23304l);
        m31423a(a2, j, GraphQLFriendshipStatus.CAN_REQUEST);
        m31421a(j, a2);
        return a2;
    }

    public final ListenableFuture<GraphQLFriendshipStatus> m31433a(long j) {
        FriendSuggestionIgnoreInputData friendSuggestionIgnoreInputData = new FriendSuggestionIgnoreInputData();
        friendSuggestionIgnoreInputData.m11397a("suggested_friend_id", String.valueOf(j));
        GraphQlCallInput graphQlCallInput = friendSuggestionIgnoreInputData;
        Builder builder = new Builder();
        builder.b = String.valueOf(j);
        builder = builder;
        builder.a = GraphQLFriendshipStatus.CAN_REQUEST;
        GraphQLVisitableModel a = builder.a();
        TypedGraphQLMutationString friendSuggestionIgnoreCoreMutationString = new FriendSuggestionIgnoreCoreMutationString();
        friendSuggestionIgnoreCoreMutationString.m11310a("input", graphQlCallInput);
        ListenableFuture a2 = Futures.m2450a(m31419a(friendSuggestionIgnoreCoreMutationString, a, j), new 9(this), this.f23304l);
        m31423a(a2, j, GraphQLFriendshipStatus.CAN_REQUEST);
        return a2;
    }

    public final ListenableFuture<GraphQLFriendshipStatus> m31439a(long j, RemoveFriendRef removeFriendRef) {
        if (removeFriendRef == null) {
            Throwable illegalArgumentException = new IllegalArgumentException("RemoveFriendRef should not be null.");
            this.f23305m.m2346a(f23293c, illegalArgumentException);
            return Futures.m2453a(illegalArgumentException);
        }
        FriendRemoveInputData friendRemoveInputData = new FriendRemoveInputData();
        friendRemoveInputData.m11395a("source", (FriendRemoveInputData.Source) m31420a(FriendRemoveInputData.Source.values(), removeFriendRef.value));
        GraphQlCallInput graphQlCallInput = friendRemoveInputData;
        graphQlCallInput.m11397a("unfriended_user_id", String.valueOf(j));
        graphQlCallInput = graphQlCallInput;
        Builder builder = new Builder();
        builder.b = String.valueOf(j);
        builder = builder;
        builder.a = GraphQLFriendshipStatus.CAN_REQUEST;
        builder = builder;
        builder.d = GraphQLSubscribeStatus.CAN_SUBSCRIBE;
        GraphQLVisitableModel a = builder.a();
        TypedGraphQLMutationString friendRemoveCoreMutationString = new FriendRemoveCoreMutationString();
        friendRemoveCoreMutationString.m11310a("input", graphQlCallInput);
        ListenableFuture a2 = Futures.m2450a(m31419a(friendRemoveCoreMutationString, a, j), new 10(this), this.f23304l);
        m31423a(a2, j, GraphQLFriendshipStatus.CAN_REQUEST);
        m31421a(j, a2);
        return a2;
    }

    public final ListenableFuture<Void> m31443a(String str, SubscribeLocation subscribeLocation) {
        return m31444a(str, subscribeLocation, false);
    }

    public final ListenableFuture<Void> m31444a(String str, SubscribeLocation subscribeLocation, boolean z) {
        ActorSubscribeInputData actorSubscribeInputData = new ActorSubscribeInputData();
        actorSubscribeInputData.m11397a("subscribee_id", str);
        GraphQlCallInput graphQlCallInput = actorSubscribeInputData;
        graphQlCallInput.m11395a("subscribe_location", (Enum) subscribeLocation);
        graphQlCallInput = graphQlCallInput;
        TypedGraphQLMutationString actorSubscribeCoreMutationString = new ActorSubscribeCoreMutationString();
        actorSubscribeCoreMutationString.m11310a("input", graphQlCallInput);
        MutationRequest a = GraphQLRequest.m11588a(actorSubscribeCoreMutationString);
        Builder builder = new Builder();
        builder.b = str;
        builder = builder;
        builder.d = GraphQLSubscribeStatus.IS_SUBSCRIBED;
        a = a.a(builder.a());
        if (z) {
            a.e = this.f23306n.mo212a();
        }
        return Futures.m2449a(this.f23300h.m31460a(a), Functions.constant(null));
    }

    public final ListenableFuture<Void> m31447a(String str, NewStatus newStatus, Location location) {
        return m31448a(str, newStatus, location, false);
    }

    public final ListenableFuture<Void> m31448a(String str, NewStatus newStatus, Location location, boolean z) {
        GraphQLSecondarySubscribeStatus graphQLSecondarySubscribeStatus;
        ProfileUpdateSecondarySubscribeStatusInputData profileUpdateSecondarySubscribeStatusInputData = new ProfileUpdateSecondarySubscribeStatusInputData();
        profileUpdateSecondarySubscribeStatusInputData.m11397a("profile_id", str);
        GraphQlCallInput graphQlCallInput = profileUpdateSecondarySubscribeStatusInputData;
        graphQlCallInput.m11395a("new_status", (Enum) newStatus);
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.m11395a("location", (Enum) location);
        graphQlCallInput = graphQlCallInput;
        TypedGraphQLMutationString actorSecondarySubscribeCoreMutationString = new ActorSecondarySubscribeCoreMutationString();
        actorSecondarySubscribeCoreMutationString.m11310a("input", graphQlCallInput);
        MutationRequest a = GraphQLRequest.m11588a(actorSecondarySubscribeCoreMutationString);
        Builder builder = new Builder();
        builder.b = str;
        builder = builder;
        builder.d = GraphQLSubscribeStatus.IS_SUBSCRIBED;
        Builder builder2 = builder;
        if (newStatus == NewStatus.SEE_FIRST) {
            graphQLSecondarySubscribeStatus = GraphQLSecondarySubscribeStatus.SEE_FIRST;
        } else {
            graphQLSecondarySubscribeStatus = null;
        }
        builder2.c = graphQLSecondarySubscribeStatus;
        MutationRequest a2 = a.a(builder2.a());
        if (z) {
            a2.e = this.f23306n.mo212a();
        }
        return Futures.m2449a(this.f23300h.m31460a(a2), Functions.constant(null));
    }

    public final ListenableFuture<Void> m31445a(String str, ActorUnsubscribeInputData.SubscribeLocation subscribeLocation) {
        return m31446a(str, subscribeLocation, false);
    }

    public final ListenableFuture<Void> m31446a(String str, ActorUnsubscribeInputData.SubscribeLocation subscribeLocation, boolean z) {
        ActorUnsubscribeInputData actorUnsubscribeInputData = new ActorUnsubscribeInputData();
        actorUnsubscribeInputData.m11397a("unsubscribee_id", str);
        GraphQlCallInput graphQlCallInput = actorUnsubscribeInputData;
        graphQlCallInput.m11395a("subscribe_location", (Enum) subscribeLocation);
        graphQlCallInput = graphQlCallInput;
        TypedGraphQLMutationString actorUnsubscribeCoreMutationString = new ActorUnsubscribeCoreMutationString();
        actorUnsubscribeCoreMutationString.m11310a("input", graphQlCallInput);
        MutationRequest a = GraphQLRequest.m11588a(actorUnsubscribeCoreMutationString);
        Builder builder = new Builder();
        builder.b = str;
        builder = builder;
        builder.d = GraphQLSubscribeStatus.CAN_SUBSCRIBE;
        a = a.a(builder.a());
        if (z) {
            a.e = this.f23306n.mo212a();
        }
        return Futures.m2449a(this.f23300h.m31460a(a), Functions.constant(null));
    }

    public final ListenableFuture<Void> m31440a(FutureFriendingInputData.Action action, String str, @Nullable String str2, @Nullable String str3) {
        Preconditions.checkNotNull(action);
        Preconditions.checkNotNull(str);
        FutureFriendingInputData futureFriendingInputData = new FutureFriendingInputData();
        futureFriendingInputData.m11395a("action", (Enum) action);
        GraphQlCallInput graphQlCallInput = futureFriendingInputData;
        graphQlCallInput.m11397a("credential", str);
        graphQlCallInput = graphQlCallInput;
        if (!StringUtil.m3589a((CharSequence) str2)) {
            graphQlCallInput.m11397a("name", str2);
        }
        if (!StringUtil.m3589a((CharSequence) str3)) {
            graphQlCallInput.m11397a("contact_id", str3);
        }
        FutureFriendingCoreMutationFieldsModel.Builder builder = new FutureFriendingCoreMutationFieldsModel.Builder();
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(HTTPTransportCallback.BODY_BYTES_RECEIVED);
        int a = ModelHelper.m23093a(flatBufferBuilder, builder.a);
        flatBufferBuilder.m21510c(1);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21513d(flatBufferBuilder.m21511d());
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.m21515e());
        wrap.position(0);
        GraphQLVisitableModel futureFriendingCoreMutationFieldsModel = new FutureFriendingCoreMutationFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
        TypedGraphQLMutationString futureFriendingCoreMutationString = new FutureFriendingCoreMutationString();
        futureFriendingCoreMutationString.m11310a("input", graphQlCallInput);
        return Futures.m2450a(m31418a(futureFriendingCoreMutationString, futureFriendingCoreMutationFieldsModel), Functions.constant(null), this.f23304l);
    }

    public final ListenableFuture<Void> m31442a(String str, PeopleYouMayInviteLocation peopleYouMayInviteLocation, @Nullable String str2, @Nullable String str3) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(peopleYouMayInviteLocation);
        ContactInviteInputData contactInviteInputData = new ContactInviteInputData();
        contactInviteInputData.m11397a("credential", str);
        GraphQlCallInput graphQlCallInput = contactInviteInputData;
        graphQlCallInput.m11397a("location", peopleYouMayInviteLocation.value);
        graphQlCallInput = graphQlCallInput;
        if (str2 != null) {
            graphQlCallInput.m11397a("name", str2);
        }
        if (str3 != null) {
            graphQlCallInput.m11397a("contact_id", str3);
        }
        ContactInviteCoreMutationFieldsModel.Builder builder = new ContactInviteCoreMutationFieldsModel.Builder();
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(HTTPTransportCallback.BODY_BYTES_RECEIVED);
        int a = ModelHelper.m23093a(flatBufferBuilder, builder.a);
        flatBufferBuilder.m21510c(1);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21513d(flatBufferBuilder.m21511d());
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.m21515e());
        wrap.position(0);
        GraphQLVisitableModel contactInviteCoreMutationFieldsModel = new ContactInviteCoreMutationFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
        TypedGraphQLMutationString contactInviteCoreMutationString = new ContactInviteCoreMutationString();
        contactInviteCoreMutationString.m11310a("input", graphQlCallInput);
        return Futures.m2450a(m31418a(contactInviteCoreMutationString, contactInviteCoreMutationFieldsModel), Functions.constant(null), this.f23304l);
    }

    public final ListenableFuture<Boolean> m31441a(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("blacklistPeopleYouMayInviteParamsKey", str);
        return Futures.m2449a(FriendingStartOperationHelper.m31458a(BlueServiceOperationFactoryDetour.a(this.f23298f, "friending_blacklist_people_you_may_invite", bundle, 1258957929)), new 11(this));
    }

    public final ListenableFuture<Void> m31434a(long j, long j2) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("blockUser", new Params(j, j2));
        return Futures.m2449a(FriendingStartOperationHelper.m31458a(BlueServiceOperationFactoryDetour.a(this.f23298f, "friending_block_user", bundle, 217127422)), Functions.constant(null));
    }

    public final ListenableFuture<Void> m31449b(long j, long j2) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("pokeUser", new PokeUserMethod.Params(j, j2));
        return Futures.m2449a(FriendingStartOperationHelper.m31458a(BlueServiceOperationFactoryDetour.a(this.f23298f, "friending_poke_user", bundle, -1221586109)), Functions.constant(null));
    }

    public final ListenableFuture<Void> m31429a() {
        return Futures.m2450a(BlueServiceOperationFactoryDetour.a(this.f23298f, "friending_mark_friend_requests_seen", new Bundle(), 1648251987).mo3452a(), Functions.constant(null), this.f23304l);
    }

    public final synchronized boolean m31451b() {
        return this.f23296b.mo1407b();
    }

    public final synchronized boolean m31452c() {
        return this.f23295a.mo1407b();
    }

    private synchronized String m31427i() {
        return this.f23296b.mo1405a();
    }

    private synchronized String m31428j() {
        return this.f23295a.mo1405a();
    }

    public final synchronized boolean m31453d() {
        return m31424a(this.f23296b);
    }

    public final synchronized boolean m31454e() {
        return m31424a(this.f23295a);
    }

    public final synchronized Optional<String> m31455f() {
        Optional<String> withType;
        if (!this.f23296b.mo1407b() || StringUtil.m3589a(this.f23296b.mo1405a())) {
            withType = Absent.withType();
        } else {
            withType = Optional.of(this.f23296b.mo1405a());
        }
        return withType;
    }

    public final synchronized Optional<String> m31456g() {
        Optional<String> withType;
        if (!this.f23295a.mo1407b() || StringUtil.m3589a(this.f23295a.mo1405a())) {
            withType = Absent.withType();
        } else {
            withType = Optional.of(this.f23295a.mo1405a());
        }
        return withType;
    }

    public final synchronized void m31457h() {
        this.f23295a = GraphQLHelper.m22460a(null, null, false, true);
        this.f23296b = GraphQLHelper.m22460a(null, null, false, true);
    }

    private <T> ListenableFuture<GraphQLResult<T>> m31418a(TypedGraphQLMutationString<T> typedGraphQLMutationString, GraphQLVisitableModel graphQLVisitableModel) {
        return this.f23300h.m31460a(GraphQLRequest.m11588a((TypedGraphQLMutationString) typedGraphQLMutationString).a(graphQLVisitableModel));
    }

    private <T> ListenableFuture<GraphQLResult<T>> m31419a(TypedGraphQLMutationString<T> typedGraphQLMutationString, GraphQLVisitableModel graphQLVisitableModel, long j) {
        ListenableFuture<GraphQLResult<T>> a;
        MutationRequest a2 = GraphQLRequest.m11588a((TypedGraphQLMutationString) typedGraphQLMutationString).a(graphQLVisitableModel);
        FriendingStartOperationHelper friendingStartOperationHelper = this.f23300h;
        String valueOf = String.valueOf(j);
        if (friendingStartOperationHelper.f23312b.mo596a(ExperimentsForFriendsExperimentModule.a, false)) {
            Object obj;
            String str;
            PendingGraphQlMutationRequest.Builder a3 = new PendingGraphQlMutationRequest.Builder().a(a2);
            a3.a = a2.a.f6530b + valueOf;
            PendingRequest.Builder builder = a3;
            TypedGraphQLMutationString typedGraphQLMutationString2 = a2.a;
            if ((typedGraphQLMutationString2 instanceof FriendRequestSendCoreMutationString) || (typedGraphQLMutationString2 instanceof FriendRequestCancelCoreMutationString)) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                str = "FRIENDING_MUTATION_" + valueOf;
            } else {
                str = null;
            }
            builder.b = str;
            a = friendingStartOperationHelper.f23311a.m10450a((PendingGraphQlMutationRequest) builder.a(), OfflineQueryBehavior.c);
        } else {
            a = friendingStartOperationHelper.m31460a(a2);
        }
        return a;
    }

    @VisibleForTesting
    private static <T> T m31420a(T[] tArr, String str) {
        for (T t : tArr) {
            if (Objects.equal(str, t.toString())) {
                return t;
            }
        }
        throw new IllegalArgumentException("no source for ref value " + str);
    }

    private void m31423a(ListenableFuture<GraphQLFriendshipStatus> listenableFuture, long j, GraphQLFriendshipStatus graphQLFriendshipStatus) {
        Futures.m2458a((ListenableFuture) listenableFuture, new 12(this, j, graphQLFriendshipStatus), MoreExecutors.m1813a());
    }

    private void m31422a(ListenableFuture<?> listenableFuture) {
        Futures.m2458a((ListenableFuture) listenableFuture, new 13(this), MoreExecutors.m1813a());
    }

    private static boolean m31424a(GraphQLPageInfo graphQLPageInfo) {
        return StringUtil.m3589a(graphQLPageInfo.v_()) && StringUtil.m3589a(graphQLPageInfo.mo1405a()) && !graphQLPageInfo.mo1408c() && graphQLPageInfo.mo1407b();
    }

    private void m31421a(long j, ListenableFuture<GraphQLFriendshipStatus> listenableFuture) {
        ListenableFuture listenableFuture2 = (ListenableFuture) this.f23307o.m4358a(j);
        if (!(listenableFuture2 == null || listenableFuture2.isDone())) {
            listenableFuture2.cancel(true);
        }
        this.f23307o.m4364b(j, listenableFuture);
    }
}

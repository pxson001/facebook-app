package com.facebook.timeline.header.menus;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.common.util.ContextUtils;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.friends.FriendingClient;
import com.facebook.friends.constants.FriendRequestHowFound;
import com.facebook.friends.constants.FriendRequestMakeRef;
import com.facebook.friends.constants.PeopleYouMayKnowLocation;
import com.facebook.friends.controllers.FriendingExceptionHandler;
import com.facebook.friends.events.FriendingEventBus;
import com.facebook.friends.events.FriendingEvents.FriendshipStatusChangedEvent;
import com.facebook.friends.events.FriendingEvents.SubscribeStatusChangedEvent;
import com.facebook.graphql.calls.ActorSubscribeInputData.SubscribeLocation;
import com.facebook.graphql.calls.ActorUnsubscribeInputData;
import com.facebook.graphql.calls.ProfileUpdateSecondarySubscribeStatusInputData.Location;
import com.facebook.graphql.calls.ProfileUpdateSecondarySubscribeStatusInputData.NewStatus;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLSecondarySubscribeStatus;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.graphql.error.GraphQLException;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.timeline.TimelineFragment;
import com.facebook.timeline.cache.TimelineUserDataCleaner;
import com.facebook.timeline.datafetcher.TimelineDataFetcher;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: fetch_dominant_color */
public class TimelineFriendingClient {
    public final Lazy<FriendingClient> f11900a;
    public final Lazy<FriendingExceptionHandler> f11901b;
    private final TimelineContext f11902c;
    public final TimelineHeaderUserData f11903d;
    public final TimelineDataFetcher f11904e;
    public final Provider<TimelineUserDataCleaner> f11905f;
    private final TimelineFragment f11906g;
    public final FriendingEventBus f11907h;
    public final Executor f11908i;
    public final Lazy<Toaster> f11909j;
    private final Context f11910k;
    public GraphQLSubscribeStatus f11911l;
    public GraphQLSecondarySubscribeStatus f11912m;
    public boolean f11913n = false;

    /* compiled from: fetch_dominant_color */
    public class C17022 implements FutureCallback<GraphQLFriendshipStatus> {
        final /* synthetic */ long f11879a;
        final /* synthetic */ GraphQLFriendshipStatus f11880b;
        final /* synthetic */ TimelineFriendingClient f11881c;

        public C17022(TimelineFriendingClient timelineFriendingClient, long j, GraphQLFriendshipStatus graphQLFriendshipStatus) {
            this.f11881c = timelineFriendingClient;
            this.f11879a = j;
            this.f11880b = graphQLFriendshipStatus;
        }

        public void onSuccess(Object obj) {
            TimelineFriendingClient.m11951a(this.f11881c, this.f11879a, this.f11880b, false);
        }

        public void onFailure(Throwable th) {
            this.f11881c.f11904e.m10561a(false);
            ((Toaster) this.f11881c.f11909j.get()).b(new ToastBuilder(2131234932));
        }
    }

    /* compiled from: fetch_dominant_color */
    public class C17033 implements FutureCallback<GraphQLFriendshipStatus> {
        final /* synthetic */ long f11882a;
        final /* synthetic */ TimelineFriendingClient f11883b;

        public C17033(TimelineFriendingClient timelineFriendingClient, long j) {
            this.f11883b = timelineFriendingClient;
            this.f11882a = j;
        }

        public void onSuccess(Object obj) {
            TimelineFriendingClient.m11951a(this.f11883b, this.f11882a, GraphQLFriendshipStatus.CAN_REQUEST, false);
        }

        public void onFailure(Throwable th) {
            if (!(th instanceof CancellationException)) {
                ((TimelineUserDataCleaner) this.f11883b.f11905f.get()).a("RemoveFriendOnFailure");
            }
            ((Toaster) this.f11883b.f11909j.get()).b(new ToastBuilder(2131234933));
        }
    }

    /* compiled from: fetch_dominant_color */
    public class C17044 implements FutureCallback<GraphQLFriendshipStatus> {
        final /* synthetic */ long f11884a;
        final /* synthetic */ TimelineFriendingClient f11885b;

        public C17044(TimelineFriendingClient timelineFriendingClient, long j) {
            this.f11885b = timelineFriendingClient;
            this.f11884a = j;
        }

        public void onSuccess(Object obj) {
            TimelineFriendingClient.m11951a(this.f11885b, this.f11884a, GraphQLFriendshipStatus.CAN_REQUEST, false);
        }

        public void onFailure(Throwable th) {
            if (!(th instanceof CancellationException)) {
                this.f11885b.f11904e.m10555a().m10620g();
            }
            ((Toaster) this.f11885b.f11909j.get()).b(new ToastBuilder(2131234934));
        }
    }

    @Inject
    public TimelineFriendingClient(Lazy<FriendingClient> lazy, Lazy<FriendingExceptionHandler> lazy2, @Assisted TimelineContext timelineContext, @Assisted TimelineHeaderUserData timelineHeaderUserData, @Assisted TimelineDataFetcher timelineDataFetcher, @Assisted ViewCallback viewCallback, Lazy<Toaster> lazy3, Provider<TimelineUserDataCleaner> provider, FriendingEventBus friendingEventBus, Executor executor, Context context) {
        this.f11900a = (Lazy) Preconditions.checkNotNull(lazy);
        this.f11901b = lazy2;
        this.f11902c = timelineContext;
        this.f11906g = viewCallback;
        this.f11903d = (TimelineHeaderUserData) Preconditions.checkNotNull(timelineHeaderUserData);
        this.f11904e = (TimelineDataFetcher) Preconditions.checkNotNull(timelineDataFetcher);
        this.f11909j = lazy3;
        this.f11907h = friendingEventBus;
        this.f11905f = provider;
        this.f11908i = executor;
        this.f11910k = context;
    }

    public final FriendingClient m11956a() {
        return (FriendingClient) this.f11900a.get();
    }

    public final void m11958a(long j, FriendRequestHowFound friendRequestHowFound, PeopleYouMayKnowLocation peopleYouMayKnowLocation, FriendRequestMakeRef friendRequestMakeRef) {
        m11951a(this, j, GraphQLFriendshipStatus.OUTGOING_REQUEST, true);
        final long j2 = j;
        final FriendRequestHowFound friendRequestHowFound2 = friendRequestHowFound;
        final PeopleYouMayKnowLocation peopleYouMayKnowLocation2 = peopleYouMayKnowLocation;
        final FriendRequestMakeRef friendRequestMakeRef2 = friendRequestMakeRef;
        Futures.a(((FriendingClient) this.f11900a.get()).b(j, friendRequestHowFound, peopleYouMayKnowLocation, friendRequestMakeRef), new FutureCallback<GraphQLFriendshipStatus>(this) {
            final /* synthetic */ TimelineFriendingClient f11878e;

            public void onSuccess(Object obj) {
                TimelineFriendingClient.m11951a(this.f11878e, j2, GraphQLFriendshipStatus.OUTGOING_REQUEST, false);
            }

            public void onFailure(Throwable th) {
                TimelineFriendingClient.m11951a(this.f11878e, j2, GraphQLFriendshipStatus.CAN_REQUEST, false);
                if (!this.f11878e.f11913n) {
                    ((FriendingExceptionHandler) this.f11878e.f11901b.get()).a(th, 2131234927, this.f11878e.m11953b(j2, friendRequestHowFound2, peopleYouMayKnowLocation2, friendRequestMakeRef2));
                }
                this.f11878e.f11904e.m10555a().m10620g();
            }
        }, this.f11908i);
    }

    public final ListenableFuture<Void> m11957a(boolean z, boolean z2) {
        GraphQLSecondarySubscribeStatus graphQLSecondarySubscribeStatus;
        GraphQLSubscribeStatus graphQLSubscribeStatus = z ? GraphQLSubscribeStatus.IS_SUBSCRIBED : GraphQLSubscribeStatus.CAN_SUBSCRIBE;
        if (z2 && this.f11912m != GraphQLSecondarySubscribeStatus.SEE_FIRST) {
            graphQLSecondarySubscribeStatus = GraphQLSecondarySubscribeStatus.SEE_FIRST;
        } else if (this.f11912m != GraphQLSecondarySubscribeStatus.SEE_FIRST || z2) {
            graphQLSecondarySubscribeStatus = this.f11912m;
        } else {
            graphQLSecondarySubscribeStatus = GraphQLSecondarySubscribeStatus.REGULAR_FOLLOW;
        }
        this.f11903d.a(graphQLSecondarySubscribeStatus);
        this.f11903d.a(graphQLSubscribeStatus);
        m11955c(this);
        long g = this.f11902c.g();
        final SettableFuture f = SettableFuture.f();
        this.f11907h.a(new SubscribeStatusChangedEvent(g, graphQLSubscribeStatus, graphQLSecondarySubscribeStatus, true));
        if (this.f11911l == graphQLSubscribeStatus) {
            m11952a(this, z2, g, f);
        } else {
            ListenableFuture a;
            if (z) {
                a = ((FriendingClient) this.f11900a.get()).a(String.valueOf(g), SubscribeLocation.PROFILE);
            } else {
                a = ((FriendingClient) this.f11900a.get()).a(String.valueOf(g), ActorUnsubscribeInputData.SubscribeLocation.PROFILE);
            }
            final boolean z3 = z;
            final GraphQLSecondarySubscribeStatus graphQLSecondarySubscribeStatus2 = graphQLSecondarySubscribeStatus;
            final boolean z4 = z2;
            final long j = g;
            Futures.a(a, new FutureCallback<Void>(this) {
                final /* synthetic */ TimelineFriendingClient f11891f;

                public void onSuccess(Object obj) {
                    Void voidR = (Void) obj;
                    if (!z3 || this.f11891f.f11912m == graphQLSecondarySubscribeStatus2) {
                        this.f11891f.f11904e.m10555a().m10620g();
                        FutureDetour.a(f, voidR, -902226426);
                        return;
                    }
                    TimelineFriendingClient.m11952a(this.f11891f, z4, j, f);
                }

                public void onFailure(Throwable th) {
                    this.f11891f.f11907h.a(new SubscribeStatusChangedEvent(j, this.f11891f.f11911l, this.f11891f.f11912m, false));
                    this.f11891f.f11903d.a(this.f11891f.f11912m);
                    this.f11891f.f11903d.a(this.f11891f.f11911l);
                    TimelineFriendingClient.m11955c(this.f11891f);
                    if (!(th instanceof CancellationException)) {
                        this.f11891f.f11904e.m10555a().m10620g();
                    }
                    ((Toaster) this.f11891f.f11909j.get()).b(new ToastBuilder(z3 ? 2131234915 : 2131234916));
                    f.a(th);
                }
            }, this.f11908i);
        }
        return f;
    }

    public static void m11952a(TimelineFriendingClient timelineFriendingClient, boolean z, long j, final SettableFuture settableFuture) {
        ListenableFuture a;
        if (z) {
            a = ((FriendingClient) timelineFriendingClient.f11900a.get()).a(String.valueOf(j), NewStatus.SEE_FIRST, Location.PROFILE);
        } else {
            a = ((FriendingClient) timelineFriendingClient.f11900a.get()).a(String.valueOf(j), NewStatus.REGULAR_FOLLOW, Location.PROFILE);
        }
        Futures.a(a, new FutureCallback<Void>(timelineFriendingClient) {
            final /* synthetic */ TimelineFriendingClient f11893b;

            public void onSuccess(Object obj) {
                Void voidR = (Void) obj;
                this.f11893b.f11904e.m10555a().m10620g();
                FutureDetour.a(settableFuture, voidR, -44994262);
            }

            public void onFailure(Throwable th) {
                this.f11893b.f11903d.a(this.f11893b.f11912m);
                TimelineFriendingClient.m11955c(this.f11893b);
                if (!(th instanceof CancellationException)) {
                    this.f11893b.f11904e.m10555a().m10620g();
                }
                TimelineFriendingClient timelineFriendingClient = this.f11893b;
                if (TimelineFriendingClient.m11954b(th)) {
                    this.f11893b.m11959a(th);
                } else {
                    ((Toaster) this.f11893b.f11909j.get()).b(new ToastBuilder(2131234915));
                }
                settableFuture.a(th);
            }
        }, timelineFriendingClient.f11908i);
    }

    @VisibleForTesting
    protected final void m11959a(Throwable th) {
        if (m11954b(th)) {
            Activity activity = (Activity) ContextUtils.a(this.f11910k, Activity.class);
            if (activity != null && !activity.isFinishing()) {
                Builder builder = new Builder(this.f11910k);
                builder.a(2131234917);
                builder.b(this.f11910k.getString(2131234918, new Object[]{this.f11903d.N()}));
                builder.a(2131230726, null);
                builder.a().show();
            }
        }
    }

    public static boolean m11954b(Throwable th) {
        if (th == null || !(th instanceof GraphQLException)) {
            return false;
        }
        GraphQLException graphQLException = (GraphQLException) th;
        if (graphQLException.error == null || graphQLException.error.a() != 1529005) {
            return false;
        }
        return true;
    }

    public static void m11955c(TimelineFriendingClient timelineFriendingClient) {
        if (timelineFriendingClient.f11906g != null) {
            timelineFriendingClient.f11906g.mo_();
        }
    }

    public static void m11951a(TimelineFriendingClient timelineFriendingClient, long j, GraphQLFriendshipStatus graphQLFriendshipStatus, boolean z) {
        timelineFriendingClient.f11907h.a(new FriendshipStatusChangedEvent(j, graphQLFriendshipStatus, z));
    }

    private OnClickListener m11953b(long j, FriendRequestHowFound friendRequestHowFound, PeopleYouMayKnowLocation peopleYouMayKnowLocation, FriendRequestMakeRef friendRequestMakeRef) {
        final long j2 = j;
        final FriendRequestHowFound friendRequestHowFound2 = friendRequestHowFound;
        final PeopleYouMayKnowLocation peopleYouMayKnowLocation2 = peopleYouMayKnowLocation;
        final FriendRequestMakeRef friendRequestMakeRef2 = friendRequestMakeRef;
        return new OnClickListener(this) {
            final /* synthetic */ TimelineFriendingClient f11899e;

            /* compiled from: fetch_dominant_color */
            class C17071 implements FutureCallback<GraphQLFriendshipStatus> {
                final /* synthetic */ C17087 f11894a;

                C17071(C17087 c17087) {
                    this.f11894a = c17087;
                }

                public void onSuccess(@Nullable Object obj) {
                    TimelineFriendingClient.m11951a(this.f11894a.f11899e, j2, GraphQLFriendshipStatus.OUTGOING_REQUEST, false);
                }

                public void onFailure(Throwable th) {
                    TimelineFriendingClient.m11951a(this.f11894a.f11899e, j2, GraphQLFriendshipStatus.CAN_REQUEST, false);
                    ((FriendingExceptionHandler) this.f11894a.f11899e.f11901b.get()).a(th);
                }
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                ListenableFuture a = ((FriendingClient) this.f11899e.f11900a.get()).a(j2, friendRequestHowFound2, peopleYouMayKnowLocation2, friendRequestMakeRef2);
                TimelineFriendingClient.m11951a(this.f11899e, j2, GraphQLFriendshipStatus.OUTGOING_REQUEST, true);
                Futures.a(a, new C17071(this), this.f11899e.f11908i);
            }
        };
    }
}

package com.facebook.timeline.service;

import android.content.Context;
import android.content.Intent;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalBroadcast;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLQueryFuture;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.RequestObservable;
import com.facebook.graphql.executor.RequestObserver;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.timeline.TimelineFetchFutures;
import com.facebook.timeline.datafetcher.TimelineFirstUnitsQueryExecutor;
import com.facebook.timeline.datafetcher.TimelineFirstUnitsQueryExecutor.FirstUnitsObservables;
import com.facebook.timeline.datafetcher.TimelineFirstUnitsQueryExecutor.ProtilesResult;
import com.facebook.timeline.datafetcher.TimelineHeaderRequestFactory;
import com.facebook.timeline.datafetcher.TimelineNonSelfFirstUnitsQueryExecutor;
import com.facebook.timeline.datafetcher.TimelineSelfFirstUnitsQueryExecutor;
import com.facebook.timeline.profileprotocol.FetchTimelineFirstUnitsParams;
import com.facebook.timeline.profileprotocol.FetchTimelineHeaderParamsFactory;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.TimelineHeaderUserFieldsModel;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.UserTimelineSelfQueryFieldsModel;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.ultralight.Inject;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.MoreExecutors.DirectExecutor;
import java.util.concurrent.Executor;
import javax.inject.Provider;

/* compiled from: extra_poll_times */
public class ProfileLoadManager {
    public static final CallerContext f12667n = CallerContext.a(ProfileLoadManager.class);
    @Inject
    public TimelineFetchFutures f12668a;
    @Inject
    TimelineImagePrefetcher f12669b;
    @Inject
    public ProfileLoadNotificationManager f12670c;
    @Inject
    public Provider<TimelineSelfFirstUnitsQueryExecutor> f12671d;
    @Inject
    public Provider<TimelineNonSelfFirstUnitsQueryExecutor> f12672e;
    @Inject
    public Provider<FetchTimelineHeaderParamsFactory> f12673f;
    @Inject
    public Provider<TimelineHeaderRequestFactory> f12674g;
    @Inject
    public Provider<GraphQLQueryExecutor> f12675h;
    @Inject
    @LoggedInUserId
    Provider<String> f12676i;
    @Inject
    @ForUiThread
    Provider<Executor> f12677j;
    @Inject
    @LocalBroadcast
    public Provider<FbBroadcastManager> f12678k;
    @Inject
    FbNetworkManager f12679l;
    @Inject
    public ProfileLoadRequestPool f12680m;
    public SelfRegistrableReceiverImpl f12681o;

    /* compiled from: extra_poll_times */
    public class C17804 implements ActionReceiver {
        final /* synthetic */ ProfileLoadManager f12664a;

        public C17804(ProfileLoadManager profileLoadManager) {
            this.f12664a = profileLoadManager;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -779217700);
            if (this.f12664a.f12679l.d()) {
                ProfileLoadManager profileLoadManager = this.f12664a;
                ImmutableList c = profileLoadManager.f12680m.m12647c();
                int size = c.size();
                for (int i = 0; i < size; i++) {
                    ProfileLoadRequest profileLoadRequest = (ProfileLoadRequest) c.get(i);
                    profileLoadRequest.f12696b++;
                    profileLoadManager.m12618a(profileLoadRequest);
                }
                profileLoadManager.f12681o.c();
            }
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -337219775, a);
        }
    }

    public static ProfileLoadManager m12613b(InjectorLike injectorLike) {
        ProfileLoadManager profileLoadManager = new ProfileLoadManager();
        profileLoadManager.m12610a(TimelineFetchFutures.m10267a(injectorLike), TimelineImagePrefetcher.m12670a(injectorLike), ProfileLoadNotificationManager.m12626b(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 11187), IdBasedSingletonScopeProvider.a(injectorLike, 11183), IdBasedSingletonScopeProvider.a(injectorLike, 11309), IdBasedSingletonScopeProvider.a(injectorLike, 11181), IdBasedProvider.a(injectorLike, 2164), IdBasedProvider.a(injectorLike, 4442), IdBasedSingletonScopeProvider.a(injectorLike, 3863), IdBasedProvider.a(injectorLike, 401), FbNetworkManager.a(injectorLike), ProfileLoadRequestPool.m12637b(injectorLike));
        return profileLoadManager;
    }

    private void m12610a(TimelineFetchFutures timelineFetchFutures, TimelineImagePrefetcher timelineImagePrefetcher, ProfileLoadNotificationManager profileLoadNotificationManager, Provider<TimelineSelfFirstUnitsQueryExecutor> provider, Provider<TimelineNonSelfFirstUnitsQueryExecutor> provider2, Provider<FetchTimelineHeaderParamsFactory> provider3, Provider<TimelineHeaderRequestFactory> provider4, Provider<GraphQLQueryExecutor> provider5, Provider<String> provider6, Provider<Executor> provider7, Provider<FbBroadcastManager> provider8, FbNetworkManager fbNetworkManager, ProfileLoadRequestPool profileLoadRequestPool) {
        this.f12668a = timelineFetchFutures;
        this.f12669b = timelineImagePrefetcher;
        this.f12670c = profileLoadNotificationManager;
        this.f12671d = provider;
        this.f12672e = provider2;
        this.f12673f = provider3;
        this.f12674g = provider4;
        this.f12675h = provider5;
        this.f12676i = provider6;
        this.f12677j = provider7;
        this.f12678k = provider8;
        this.f12679l = fbNetworkManager;
        this.f12680m = profileLoadRequestPool;
    }

    public final void m12618a(final ProfileLoadRequest profileLoadRequest) {
        if (!this.f12680m.m12649d(profileLoadRequest)) {
            Long.valueOf(profileLoadRequest.m12632a());
            long a = profileLoadRequest.m12632a();
            Optional fromNullable = Optional.fromNullable(profileLoadRequest.f12695a.f12693c);
            GraphQLQueryFuture a2 = this.f12668a.m10270a(a);
            if (a2 == null) {
                a2 = ((GraphQLQueryExecutor) this.f12675h.get()).a(((TimelineHeaderRequestFactory) this.f12674g.get()).m10642a(((FetchTimelineHeaderParamsFactory) this.f12673f.get()).m12095a(a, fromNullable), GraphQLCachePolicy.d, f12667n, RequestPriority.NON_INTERACTIVE));
            }
            GraphQLQueryFuture graphQLQueryFuture = a2;
            this.f12668a.m10271a(profileLoadRequest.m12632a(), 1);
            PrefetchListener prefetchListener = new PrefetchListener(new Object(this) {
                final /* synthetic */ ProfileLoadManager f12657b;

                public final void m12600a(Object obj) {
                    ProfileFetchResults profileFetchResults = (ProfileFetchResults) obj;
                    if (profileFetchResults.f12655a != null) {
                        ProfileLoadManager.m12611a(this.f12657b, profileFetchResults, profileLoadRequest);
                    }
                }
            }, new ProfileFetchResults());
            this.f12670c.m12628a(profileLoadRequest.m12632a(), profileLoadRequest.m12633b(), profileLoadRequest.m12634c());
            m12614b(profileLoadRequest);
            m12608a(graphQLQueryFuture, prefetchListener, profileLoadRequest);
            m12607a(profileLoadRequest.m12632a(), prefetchListener);
            prefetchListener.m12599c();
        }
    }

    public final void m12617a() {
        ImmutableList b = this.f12680m.m12645b();
        ImmutableList c = this.f12680m.m12647c();
        this.f12680m.f12699c.edit().clear().commit();
        m12612a(b);
        m12612a(c);
    }

    private void m12612a(ImmutableList<ProfileLoadRequest> immutableList) {
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            m12618a((ProfileLoadRequest) immutableList.get(i));
        }
    }

    public static void m12611a(ProfileLoadManager profileLoadManager, final ProfileFetchResults profileFetchResults, final ProfileLoadRequest profileLoadRequest) {
        ExecutorDetour.a((Executor) profileLoadManager.f12677j.get(), new Runnable(profileLoadManager) {
            final /* synthetic */ ProfileLoadManager f12660c;

            public void run() {
                this.f12660c.f12668a.m10271a(profileLoadRequest.m12632a(), 2);
                Intent intent = new Intent("com.facebook.intent.action.ACTION_GET_NOTIFIED_PROFILE_LOADED");
                intent.putExtra("com.facebook.katana.profile.id", profileLoadRequest.m12632a());
                ((BaseFbBroadcastManager) this.f12660c.f12678k.get()).a(intent);
                this.f12660c.f12670c.m12630b(profileLoadRequest.m12632a(), profileFetchResults.f12655a.q(), profileLoadRequest.m12634c());
            }
        }, 1309961128);
        profileLoadManager.m12615c(profileLoadRequest);
    }

    private synchronized void m12614b(ProfileLoadRequest profileLoadRequest) {
        this.f12680m.m12643a(profileLoadRequest);
    }

    private synchronized void m12615c(ProfileLoadRequest profileLoadRequest) {
        this.f12680m.m12646b(profileLoadRequest);
    }

    public static void m12616d(ProfileLoadManager profileLoadManager, ProfileLoadRequest profileLoadRequest) {
        profileLoadManager.f12670c.m12627a(profileLoadRequest.m12632a(), profileLoadRequest.m12633b());
        profileLoadManager.f12668a.m10271a(profileLoadRequest.m12632a(), 2);
        profileLoadManager.m12615c(profileLoadRequest);
    }

    private void m12608a(GraphQLQueryFuture<? extends GraphQLResult<?>> graphQLQueryFuture, final PrefetchListener<ProfileFetchResults> prefetchListener, final ProfileLoadRequest profileLoadRequest) {
        Futures.a(graphQLQueryFuture, new AbstractDisposableFutureCallback<GraphQLResult<?>>(this) {
            final /* synthetic */ ProfileLoadManager f12663c;

            protected final void m12601a(Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (graphQLResult != null && graphQLResult.e != null) {
                    ProfileLoadManager profileLoadManager = this.f12663c;
                    TimelineHeaderUserFieldsModel a = ProfileLoadManager.m12606a(graphQLResult.e);
                    ((ProfileFetchResults) prefetchListener.f12652b).f12655a = a;
                    this.f12663c.f12669b.m12674a(a, new TimelineImagePrefetchDataSubscriber(prefetchListener));
                }
            }

            protected final void m12602a(Throwable th) {
                Object obj;
                ProfileLoadManager profileLoadManager = this.f12663c;
                if (profileLoadRequest.f12696b < 3) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    profileLoadManager = this.f12663c;
                    ProfileLoadRequest profileLoadRequest = profileLoadRequest;
                    profileLoadManager.f12670c.m12629b(profileLoadRequest.m12632a(), profileLoadRequest.m12633b());
                    profileLoadManager.f12680m.m12648c(profileLoadRequest);
                    if (profileLoadManager.f12681o == null || !profileLoadManager.f12681o.a()) {
                        profileLoadManager.f12681o = ((BaseFbBroadcastManager) profileLoadManager.f12678k.get()).a().a("com.facebook.orca.ACTION_NETWORK_CONNECTIVITY_CHANGED", new C17804(profileLoadManager)).a();
                    }
                    profileLoadManager.f12681o.b();
                    return;
                }
                ProfileLoadManager.m12616d(this.f12663c, profileLoadRequest);
            }
        }, DirectExecutor.INSTANCE);
    }

    public static TimelineHeaderUserFieldsModel m12606a(Object obj) {
        if (obj instanceof UserTimelineSelfQueryFieldsModel) {
            return ((UserTimelineSelfQueryFieldsModel) obj).a();
        }
        return (TimelineHeaderUserFieldsModel) obj;
    }

    private void m12607a(long j, final PrefetchListener prefetchListener) {
        TimelineFirstUnitsQueryExecutor timelineFirstUnitsQueryExecutor;
        if (String.valueOf(j).equals((String) this.f12676i.get())) {
            timelineFirstUnitsQueryExecutor = (TimelineFirstUnitsQueryExecutor) this.f12671d.get();
        } else {
            timelineFirstUnitsQueryExecutor = (TimelineFirstUnitsQueryExecutor) this.f12672e.get();
        }
        FirstUnitsObservables a = timelineFirstUnitsQueryExecutor.mo506a(false, new FetchTimelineFirstUnitsParams(j, null, false), f12667n);
        RequestObserver c17815 = new RequestObserver(this) {
            final /* synthetic */ ProfileLoadManager f12666b;

            public final void m12603a() {
                prefetchListener.m12598b();
            }

            public final void m12605a(Throwable th) {
                prefetchListener.m12598b();
            }

            public final void m12604a(Object obj) {
                if (obj instanceof ProtilesResult) {
                    this.f12666b.f12669b.m12673a((ProtilesResult) obj, new TimelineImagePrefetchDataSubscriber(prefetchListener));
                }
            }
        };
        m12609a(a.f10485a, c17815, prefetchListener);
        m12609a(a.f10489e, c17815, prefetchListener);
        m12609a(a.f10487c, c17815, prefetchListener);
        m12609a(a.f10490f, c17815, prefetchListener);
        m12609a(a.f10488d, c17815, prefetchListener);
        m12609a(a.f10492h, c17815, prefetchListener);
    }

    public static void m12609a(RequestObservable<?> requestObservable, RequestObserver requestObserver, PrefetchListener prefetchListener) {
        if (requestObservable != null) {
            prefetchListener.m12597a();
            requestObservable.a(requestObserver);
        }
    }
}

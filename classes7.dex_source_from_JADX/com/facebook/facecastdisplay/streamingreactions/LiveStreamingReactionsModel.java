package com.facebook.facecastdisplay.streamingreactions;

import android.os.Handler;
import android.util.SparseArray;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.common.executors.ScheduledExecutorService_SingleThreadedExecutorServiceMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.facecastdisplay.protocol.FetchLiveReactionsQuery;
import com.facebook.facecastdisplay.protocol.FetchLiveReactionsQuery.FetchLiveReactionsQueryString;
import com.facebook.facecastdisplay.protocol.FetchLiveReactionsQuery.LiveReactionSubscriptionString;
import com.facebook.facecastdisplay.protocol.FetchLiveReactionsQueryModels.FetchLiveReactionsQueryModel;
import com.facebook.facecastdisplay.protocol.FetchLiveReactionsQueryModels.LiveReactionSubscriptionModel;
import com.facebook.facecastdisplay.protocol.FetchLiveReactionsQueryModels.LiveReactionSubscriptionModel.ReactorModel;
import com.facebook.facecastdisplay.protocol.FetchLiveReactionsQueryModels.LiveReactionsFeedbackFragmentModel;
import com.facebook.facecastdisplay.protocol.FetchLiveReactionsQueryModels.LiveReactionsFeedbackFragmentModel.ReactionsStreamModel;
import com.facebook.feedback.reactions.ui.FeedbackReactionsController;
import com.facebook.graphql.calls.FeedbackAddStreamingReactionSubscribeInputData;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.GraphQLSubscriptionHolder;
import com.facebook.graphql.mqtt.GraphQLSubscriptionConnector;
import com.facebook.graphql.mqtt.GraphQLSubscriptionConnector.GraphQLSubscriptionConnectorException;
import com.facebook.graphql.mqtt.GraphQLSubscriptionConnector.GraphQLSubscriptionHandle;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: state_original_sections */
public class LiveStreamingReactionsModel implements StreamingReactionsModel {
    public static final String f3304a = LiveStreamingReactionsModel.class.getName();
    private final GraphQLSubscriptionHolder f3305b;
    private final GraphQLSubscriptionConnector f3306c;
    private final ExecutorService f3307d;
    private final Handler f3308e;
    public final Clock f3309f;
    private final Lazy<FeedbackReactionsController> f3310g = null;
    private final float f3311h;
    private final int f3312i;
    private final SparseArray<Integer> f3313j = new SparseArray();
    private final SparseArray<Integer> f3314k = new SparseArray();
    public final SparseArray<Integer> f3315l = new SparseArray();
    @Nullable
    private volatile GraphQLSubscriptionHandle f3316m;
    @Nullable
    public StreamingReactionsModelListener f3317n;
    @Nullable
    private String f3318o;
    @Nullable
    private volatile String f3319p;
    public volatile boolean f3320q;
    private volatile boolean f3321r;
    private volatile long f3322s;
    private volatile long f3323t;
    private volatile double f3324u;
    private volatile boolean f3325v;

    /* compiled from: state_original_sections */
    class C02851 extends AbstractDisposableFutureCallback<GraphQLResult<FetchLiveReactionsQueryModel>> {
        final /* synthetic */ LiveStreamingReactionsModel f3296a;

        public final void m4052a(Throwable th) {
            String str = LiveStreamingReactionsModel.f3304a;
        }

        C02851(LiveStreamingReactionsModel liveStreamingReactionsModel) {
            this.f3296a = liveStreamingReactionsModel;
        }

        public final void m4051a(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            String str;
            if (graphQLResult == null || graphQLResult.e == null) {
                str = LiveStreamingReactionsModel.f3304a;
            } else if (((FetchLiveReactionsQueryModel) graphQLResult.e).m3326j() != null) {
                LiveStreamingReactionsModel.m4062a(this.f3296a, ((FetchLiveReactionsQueryModel) graphQLResult.e).m3326j());
            } else {
                str = LiveStreamingReactionsModel.f3304a;
            }
        }
    }

    /* compiled from: state_original_sections */
    class C02862 implements Runnable {
        final /* synthetic */ LiveStreamingReactionsModel f3297a;

        C02862(LiveStreamingReactionsModel liveStreamingReactionsModel) {
            this.f3297a = liveStreamingReactionsModel;
        }

        public void run() {
            synchronized (this.f3297a) {
                this.f3297a.f3323t = this.f3297a.f3309f.a();
                if (this.f3297a.f3317n != null && this.f3297a.f3320q) {
                    this.f3297a.f3317n.mo161a(this.f3297a.f3315l);
                }
                this.f3297a.f3315l.clear();
                this.f3297a.f3325v = false;
            }
        }
    }

    /* compiled from: state_original_sections */
    class C02895 implements FutureCallback<LiveReactionSubscriptionModel> {
        final /* synthetic */ LiveStreamingReactionsModel f3303a;

        public void onFailure(Throwable th) {
            String str = LiveStreamingReactionsModel.f3304a;
        }

        C02895(LiveStreamingReactionsModel liveStreamingReactionsModel) {
            this.f3303a = liveStreamingReactionsModel;
        }

        public void onSuccess(@Nullable Object obj) {
            LiveReactionSubscriptionModel liveReactionSubscriptionModel = (LiveReactionSubscriptionModel) obj;
            if (liveReactionSubscriptionModel == null) {
                String str = LiveStreamingReactionsModel.f3304a;
                return;
            }
            if (liveReactionSubscriptionModel.m3401k() == null || liveReactionSubscriptionModel.m3401k().m3394j() == null || liveReactionSubscriptionModel.m3400j() == null) {
                str = LiveStreamingReactionsModel.f3304a;
            } else {
                LiveStreamingReactionsModel.m4061a(this.f3303a, liveReactionSubscriptionModel.m3401k(), liveReactionSubscriptionModel.m3400j().m3383j());
            }
            if (liveReactionSubscriptionModel.m3398a() != null) {
                LiveStreamingReactionsModel.m4062a(this.f3303a, liveReactionSubscriptionModel.m3398a());
            } else {
                str = LiveStreamingReactionsModel.f3304a;
            }
        }
    }

    public static LiveStreamingReactionsModel m4065b(InjectorLike injectorLike) {
        return new LiveStreamingReactionsModel(GraphQLSubscriptionHolder.b(injectorLike), GraphQLSubscriptionConnector.a(injectorLike), ScheduledExecutorService_SingleThreadedExecutorServiceMethodAutoProvider.b(injectorLike), Handler_ForUiThreadMethodAutoProvider.b(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 1783), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public LiveStreamingReactionsModel(GraphQLSubscriptionHolder graphQLSubscriptionHolder, GraphQLSubscriptionConnector graphQLSubscriptionConnector, ExecutorService executorService, Handler handler, Clock clock, Lazy<FeedbackReactionsController> lazy, QeAccessor qeAccessor) {
        this.f3305b = graphQLSubscriptionHolder;
        this.f3306c = graphQLSubscriptionConnector;
        this.f3307d = executorService;
        this.f3308e = handler;
        this.f3309f = clock;
        this.f3311h = qeAccessor.a(ExperimentsForStreamingReactionsModule.f3287e, 5.0f);
        this.f3312i = qeAccessor.a(ExperimentsForStreamingReactionsModule.f3290h, 2000);
    }

    public final synchronized void mo150a(StreamingReactionsModelListener streamingReactionsModelListener, String str, @Nullable String str2) {
        if (!this.f3320q) {
            this.f3320q = true;
            this.f3317n = (StreamingReactionsModelListener) Preconditions.a(streamingReactionsModelListener);
            this.f3318o = (String) Preconditions.a(str);
            this.f3319p = str2;
            C02851 c02851 = new C02851(this);
            FetchLiveReactionsQueryString a = FetchLiveReactionsQuery.m3318a();
            a.a("targetID", this.f3318o);
            Futures.a(this.f3305b.a(GraphQLRequest.a(a).a(true).a(GraphQLCachePolicy.d), c02851, "LiveReactions" + str), c02851, this.f3307d);
            if (this.f3319p != null) {
                m4063a(this.f3319p);
            }
            this.f3321r = false;
        }
    }

    public final synchronized void mo148a() {
        if (this.f3320q) {
            this.f3320q = false;
            this.f3308e.removeCallbacksAndMessages(null);
            this.f3325v = false;
            this.f3305b.b();
            if (this.f3316m != null) {
                this.f3306c.a(Collections.singleton(this.f3316m));
                this.f3316m = null;
            }
        }
    }

    public final synchronized void mo149a(int i) {
        this.f3314k.put(i, Integer.valueOf(((Integer) this.f3314k.get(i, Integer.valueOf(0))).intValue() + 1));
    }

    public final boolean mo152b() {
        return this.f3320q;
    }

    public final double mo153c() {
        return Math.max(this.f3324u, 0.0d);
    }

    public final int mo154d() {
        return this.f3312i;
    }

    public final void mo151b(int i) {
    }

    public static synchronized void m4062a(LiveStreamingReactionsModel liveStreamingReactionsModel, LiveReactionsFeedbackFragmentModel liveReactionsFeedbackFragmentModel) {
        synchronized (liveStreamingReactionsModel) {
            if (liveReactionsFeedbackFragmentModel.m3443a() != null && liveStreamingReactionsModel.f3319p == null && liveStreamingReactionsModel.f3316m == null) {
                liveStreamingReactionsModel.m4063a(liveReactionsFeedbackFragmentModel.m3443a());
            }
            if (liveReactionsFeedbackFragmentModel.m3446j() != null) {
                ImmutableList j = liveReactionsFeedbackFragmentModel.m3446j();
                int size = j.size();
                int i = 0;
                int i2 = 0;
                while (i < size) {
                    int i3;
                    ReactionsStreamModel reactionsStreamModel = (ReactionsStreamModel) j.get(i);
                    if (reactionsStreamModel == null || reactionsStreamModel.m3439j() == null) {
                        i3 = i2;
                    } else {
                        int intValue;
                        int j2 = reactionsStreamModel.m3439j().m3433j();
                        int intValue2 = ((Integer) liveStreamingReactionsModel.f3313j.get(j2, Integer.valueOf(0))).intValue();
                        if (liveStreamingReactionsModel.f3321r) {
                            intValue = ((Integer) liveStreamingReactionsModel.f3314k.get(j2, Integer.valueOf(0))).intValue();
                            intValue2 = reactionsStreamModel.m3435a() - intValue2;
                            int max = Math.max(intValue - intValue2, 0);
                            intValue2 -= intValue;
                            if (intValue2 > 0) {
                                liveStreamingReactionsModel.f3315l.put(j2, Integer.valueOf(((Integer) liveStreamingReactionsModel.f3315l.get(j2, Integer.valueOf(0))).intValue() + intValue2));
                                intValue = i2 + intValue2;
                            } else {
                                intValue = i2;
                            }
                            liveStreamingReactionsModel.f3314k.put(j2, Integer.valueOf(max));
                        } else {
                            intValue = i2;
                        }
                        liveStreamingReactionsModel.f3313j.put(j2, Integer.valueOf(reactionsStreamModel.m3435a()));
                        i3 = intValue;
                    }
                    i++;
                    i2 = i3;
                }
                if (liveStreamingReactionsModel.f3321r) {
                    Runnable c02862 = new C02862(liveStreamingReactionsModel);
                    liveStreamingReactionsModel.f3324u = ((double) i2) / (((double) (liveStreamingReactionsModel.f3309f.a() - liveStreamingReactionsModel.f3322s)) / 1000.0d);
                    if (!liveStreamingReactionsModel.f3325v) {
                        long a = liveStreamingReactionsModel.f3309f.a() - liveStreamingReactionsModel.f3323t;
                        if (liveStreamingReactionsModel.f3324u < ((double) liveStreamingReactionsModel.f3311h) || a > ((long) liveStreamingReactionsModel.f3312i)) {
                            HandlerDetour.a(liveStreamingReactionsModel.f3308e, c02862, -564883227);
                        } else {
                            HandlerDetour.b(liveStreamingReactionsModel.f3308e, c02862, ((long) liveStreamingReactionsModel.f3312i) - a, 278223731);
                        }
                        liveStreamingReactionsModel.f3325v = true;
                    }
                } else {
                    liveStreamingReactionsModel.f3323t = liveStreamingReactionsModel.f3309f.a();
                }
                liveStreamingReactionsModel.f3322s = liveStreamingReactionsModel.f3309f.a();
                liveStreamingReactionsModel.f3321r = true;
                final SparseArray clone = liveStreamingReactionsModel.f3313j.clone();
                HandlerDetour.a(liveStreamingReactionsModel.f3308e, new Runnable(liveStreamingReactionsModel) {
                    final /* synthetic */ LiveStreamingReactionsModel f3299b;

                    public void run() {
                        if (this.f3299b.f3317n != null && this.f3299b.f3320q) {
                            this.f3299b.f3317n.mo163b(clone);
                        }
                    }
                }, -1826515774);
            }
        }
    }

    public static synchronized void m4061a(LiveStreamingReactionsModel liveStreamingReactionsModel, final ReactorModel reactorModel, final int i) {
        synchronized (liveStreamingReactionsModel) {
            if (reactorModel.m3394j() != null && reactorModel.m3395k()) {
                liveStreamingReactionsModel.f3314k.put(i, Integer.valueOf(((Integer) liveStreamingReactionsModel.f3314k.get(i, Integer.valueOf(0))).intValue() + 1));
                HandlerDetour.a(liveStreamingReactionsModel.f3308e, new Runnable(liveStreamingReactionsModel) {
                    final /* synthetic */ LiveStreamingReactionsModel f3302c;

                    public void run() {
                        if (this.f3302c.f3317n != null && this.f3302c.f3320q) {
                            this.f3302c.f3317n.mo160a(i, reactorModel.m3394j());
                        }
                    }
                }, 1552116274);
            }
        }
    }

    private synchronized void m4063a(String str) {
        if (this.f3320q) {
            this.f3319p = (String) Preconditions.a(str);
            C02895 c02895 = new C02895(this);
            LiveReactionSubscriptionString d = FetchLiveReactionsQuery.m3319d();
            d.a("input", new FeedbackAddStreamingReactionSubscribeInputData().a(this.f3319p));
            try {
                this.f3316m = this.f3306c.a(d, c02895);
            } catch (GraphQLSubscriptionConnectorException e) {
            }
        }
    }
}

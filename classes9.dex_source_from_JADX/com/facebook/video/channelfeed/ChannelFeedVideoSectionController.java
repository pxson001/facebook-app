package com.facebook.video.channelfeed;

import android.text.TextUtils;
import com.facebook.common.time.Clock;
import com.facebook.device.ScreenUtil;
import com.facebook.feed.rows.adapter.api.MultiRowAdapter;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.calls.EntryPointInputVideoChannelEntryPoint;
import com.facebook.graphql.executor.GraphQLQueryFuture;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.FetchTimeMsHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLVideoChannelFeedEdge;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
import com.facebook.inject.Assisted;
import com.facebook.video.analytics.VideoChannelSessionManager;
import com.facebook.video.channelfeed.abtest.ChannelFeedConfig;
import com.facebook.video.channelfeed.protocol.FetchVideoChannelQueryModels.ChannelFeedVideoChannelFeedFragmentModel;
import com.facebook.video.channelfeed.protocol.FetchVideoChannelQueryModels.ChannelFeedVideoChannelFragmentModel;
import com.facebook.video.channelfeed.protocol.FetchVideoChannelQueryModels.FetchVideoChannelByVideoQueryModel;
import com.facebook.video.channelfeed.protocol.FetchVideoChannelQueryModels.FetchVideosByVideoChannelQueryModel;
import com.facebook.video.channelfeed.protocol.FetchVideoChannelQueryOptimizedFragmentsQEModels.ChannelFeedVideoChannelFeedFragmentQEModel;
import com.facebook.video.channelfeed.protocol.FetchVideoChannelQueryOptimizedFragmentsQEModels.ChannelFeedVideoChannelFragmentQEModel;
import com.facebook.video.channelfeed.protocol.FetchVideoChannelQueryOptimizedFragmentsQEModels.FetchVideoChannelByVideoQueryQEModel;
import com.facebook.video.channelfeed.protocol.FetchVideoChannelQueryOptimizedFragmentsQEModels.FetchVideosByVideoChannelQueryQEModel;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy.OnScrollListener;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: syncTime */
public class ChannelFeedVideoSectionController {
    private static final String f2562a = ChannelFeedVideoSectionController.class.getSimpleName();
    private final VideoChannelLoadedCallback f2563b;
    private final Clock f2564c;
    @Nullable
    public String f2565d;
    @Nullable
    public final String f2566e;
    private final EntryPointInputVideoChannelEntryPoint f2567f;
    public final boolean f2568g;
    private final boolean f2569h;
    private final ChannelFeedStoryUtil f2570i;
    public boolean f2571j;
    public final ScrollingViewProxy f2572k;
    private final VideoChannelItemCollection f2573l;
    public final MultiRowAdapter f2574m;
    public final VideoChannelLoader f2575n;
    public final Executor f2576o;
    public final FetchMoreScrollListener f2577p = new FetchMoreScrollListener(this);
    private final ChannelFeedLoadingCard f2578q;
    private final int f2579r;
    private final int f2580s;
    public final int f2581t;
    public final int f2582u;
    private final int f2583v;
    @Nullable
    public GraphQLQueryFuture f2584w;
    @Nullable
    public DefaultPageInfoFieldsModel f2585x;
    private final VideoChannelSessionManager f2586y;
    public final boolean f2587z;

    /* compiled from: syncTime */
    public interface VideoChannelLoadedCallback {
        void mo72a(ChannelFeedVideoChannelFragmentModel channelFeedVideoChannelFragmentModel);

        void mo73a(ChannelFeedVideoChannelFragmentQEModel channelFeedVideoChannelFragmentQEModel);

        void mo74a(String str, ChannelFeedVideoChannelFeedFragmentModel channelFeedVideoChannelFeedFragmentModel);

        void mo75a(String str, ChannelFeedVideoChannelFeedFragmentQEModel channelFeedVideoChannelFeedFragmentQEModel);
    }

    /* compiled from: syncTime */
    public class C02363 implements FutureCallback<GraphQLResult> {
        final /* synthetic */ GraphQLQueryFuture f2557a;
        final /* synthetic */ ChannelFeedVideoSectionController f2558b;

        public C02363(ChannelFeedVideoSectionController channelFeedVideoSectionController, GraphQLQueryFuture graphQLQueryFuture) {
            this.f2558b = channelFeedVideoSectionController;
            this.f2557a = graphQLQueryFuture;
        }

        public void onSuccess(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            ChannelFeedVideoSectionController.m2497f(this.f2558b);
            if (!this.f2557a.isCancelled() && graphQLResult != null && graphQLResult.e != null) {
                Object obj2 = graphQLResult.e;
                if (obj2 instanceof FetchVideosByVideoChannelQueryModel) {
                    FetchVideosByVideoChannelQueryModel fetchVideosByVideoChannelQueryModel = (FetchVideosByVideoChannelQueryModel) obj2;
                    if (fetchVideosByVideoChannelQueryModel.a() != null) {
                        ChannelFeedVideoSectionController.m2493b(this.f2558b, fetchVideosByVideoChannelQueryModel.a());
                    }
                } else if (obj2 instanceof FetchVideosByVideoChannelQueryQEModel) {
                    FetchVideosByVideoChannelQueryQEModel fetchVideosByVideoChannelQueryQEModel = (FetchVideosByVideoChannelQueryQEModel) obj2;
                    if (fetchVideosByVideoChannelQueryQEModel.a() != null) {
                        ChannelFeedVideoSectionController.m2493b(this.f2558b, fetchVideosByVideoChannelQueryQEModel.a());
                    }
                }
            }
        }

        public void onFailure(Throwable th) {
            if (!this.f2557a.isCancelled()) {
                ChannelFeedVideoSectionController.m2497f(this.f2558b);
            }
        }
    }

    /* compiled from: syncTime */
    class FetchMoreScrollListener implements OnScrollListener {
        final /* synthetic */ ChannelFeedVideoSectionController f2561a;

        public FetchMoreScrollListener(ChannelFeedVideoSectionController channelFeedVideoSectionController) {
            this.f2561a = channelFeedVideoSectionController;
        }

        public final void m2487a(ScrollingViewProxy scrollingViewProxy, int i) {
        }

        public final void m2488a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
            ChannelFeedVideoSectionController channelFeedVideoSectionController = this.f2561a;
            Object obj = null;
            if (channelFeedVideoSectionController.f2574m != null && channelFeedVideoSectionController.f2574m.e() < channelFeedVideoSectionController.f2581t && channelFeedVideoSectionController.f2584w == null && i2 > 0 && i3 > 0 && !TextUtils.isEmpty(channelFeedVideoSectionController.f2565d) && (channelFeedVideoSectionController.f2585x == null || channelFeedVideoSectionController.f2585x.b())) {
                if ((channelFeedVideoSectionController.f2574m.e() - 1) - channelFeedVideoSectionController.f2574m.s_(i) <= channelFeedVideoSectionController.f2582u) {
                    obj = 1;
                }
            }
            if (obj != null) {
                this.f2561a.f2584w = ChannelFeedVideoSectionController.m2495d(this.f2561a);
            }
        }
    }

    @Inject
    public ChannelFeedVideoSectionController(@Nullable @Assisted String str, @Nullable @Assisted String str2, @Assisted EntryPointInputVideoChannelEntryPoint entryPointInputVideoChannelEntryPoint, @Assisted boolean z, @Assisted boolean z2, @Assisted ScrollingViewProxy scrollingViewProxy, @Assisted VideoChannelItemCollection videoChannelItemCollection, @Assisted MultiRowAdapter multiRowAdapter, @Assisted VideoChannelLoadedCallback videoChannelLoadedCallback, @Nullable @Assisted ChannelFeedLoadingCard channelFeedLoadingCard, @Assisted boolean z3, ChannelFeedConfig channelFeedConfig, ChannelFeedStoryUtil channelFeedStoryUtil, Clock clock, ScreenUtil screenUtil, Executor executor, VideoChannelSessionManager videoChannelSessionManager, VideoChannelLoader videoChannelLoader) {
        this.f2565d = str;
        this.f2566e = str2;
        this.f2567f = entryPointInputVideoChannelEntryPoint;
        this.f2568g = z;
        this.f2569h = z2;
        this.f2572k = scrollingViewProxy;
        this.f2573l = videoChannelItemCollection;
        this.f2574m = multiRowAdapter;
        this.f2563b = videoChannelLoadedCallback;
        this.f2578q = channelFeedLoadingCard;
        this.f2570i = channelFeedStoryUtil;
        this.f2564c = clock;
        this.f2576o = executor;
        this.f2586y = videoChannelSessionManager;
        this.f2575n = videoChannelLoader;
        this.f2587z = z3;
        this.f2579r = this.f2569h ? channelFeedConfig.b : 5;
        this.f2580s = channelFeedConfig.c;
        this.f2581t = channelFeedConfig.d;
        this.f2582u = channelFeedConfig.e;
        this.f2583v = screenUtil.d() / 4;
        this.f2571j = true;
        if (z3) {
            this.f2584w = null;
        } else if (this.f2565d != null) {
            this.f2584w = m2491a(this.f2565d, this.f2566e);
        } else {
            this.f2584w = m2490a(this.f2566e);
        }
        if (this.f2569h) {
            this.f2572k.b(this.f2577p);
        }
    }

    private GraphQLQueryFuture<GraphQLResult> m2491a(String str, @Nullable String str2) {
        if (m2489a(this.f2579r) <= 0) {
            return null;
        }
        m2496e();
        final GraphQLQueryFuture<GraphQLResult> a = this.f2575n.m2574a(str, str2, this.f2579r, this.f2567f, this.f2568g);
        Futures.a(a, new FutureCallback<GraphQLResult>(this) {
            final /* synthetic */ ChannelFeedVideoSectionController f2554b;

            public void onSuccess(@Nullable Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                this.f2554b.f2571j = false;
                ChannelFeedVideoSectionController.m2497f(this.f2554b);
                if (graphQLResult != null && graphQLResult.e != null && !a.isCancelled()) {
                    ChannelFeedVideoSectionController.m2492a(this.f2554b, graphQLResult.e);
                }
            }

            public void onFailure(Throwable th) {
                this.f2554b.f2571j = false;
                if (!a.isCancelled()) {
                    ChannelFeedVideoSectionController.m2497f(this.f2554b);
                }
            }
        }, this.f2576o);
        return a;
    }

    private GraphQLQueryFuture<GraphQLResult> m2490a(String str) {
        if (m2489a(this.f2579r) <= 0) {
            return null;
        }
        m2496e();
        final GraphQLQueryFuture<GraphQLResult> a = this.f2575n.m2573a(str, this.f2579r, this.f2567f, this.f2568g);
        Futures.a(a, new FutureCallback<GraphQLResult>(this) {
            final /* synthetic */ ChannelFeedVideoSectionController f2556b;

            public void onSuccess(@Nullable Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                this.f2556b.f2571j = false;
                ChannelFeedVideoSectionController.m2497f(this.f2556b);
                if (graphQLResult != null && graphQLResult.e != null && !a.isCancelled()) {
                    Object obj2 = graphQLResult.e;
                    if (obj2 instanceof FetchVideoChannelByVideoQueryModel) {
                        FetchVideoChannelByVideoQueryModel fetchVideoChannelByVideoQueryModel = (FetchVideoChannelByVideoQueryModel) obj2;
                        if (fetchVideoChannelByVideoQueryModel.j() != null) {
                            ChannelFeedVideoSectionController.m2492a(this.f2556b, fetchVideoChannelByVideoQueryModel.j());
                        }
                    } else if (obj2 instanceof FetchVideoChannelByVideoQueryQEModel) {
                        FetchVideoChannelByVideoQueryQEModel fetchVideoChannelByVideoQueryQEModel = (FetchVideoChannelByVideoQueryQEModel) obj2;
                        if (fetchVideoChannelByVideoQueryQEModel.j() != null) {
                            ChannelFeedVideoSectionController.m2492a(this.f2556b, fetchVideoChannelByVideoQueryQEModel.j());
                        }
                    }
                }
            }

            public void onFailure(Throwable th) {
                this.f2556b.f2571j = false;
                if (!a.isCancelled()) {
                    ChannelFeedVideoSectionController.m2497f(this.f2556b);
                }
            }
        }, this.f2576o);
        return a;
    }

    public static GraphQLQueryFuture m2495d(ChannelFeedVideoSectionController channelFeedVideoSectionController) {
        if (channelFeedVideoSectionController.f2585x == null || !channelFeedVideoSectionController.f2585x.b()) {
            return null;
        }
        int a = channelFeedVideoSectionController.m2489a(channelFeedVideoSectionController.f2580s);
        if (a <= 0) {
            return null;
        }
        channelFeedVideoSectionController.m2496e();
        final GraphQLQueryFuture a2 = channelFeedVideoSectionController.f2575n.m2575a(channelFeedVideoSectionController.f2565d, channelFeedVideoSectionController.f2566e, channelFeedVideoSectionController.f2585x.a(), a, channelFeedVideoSectionController.f2568g);
        Futures.a(a2, new FutureCallback<GraphQLResult>(channelFeedVideoSectionController) {
            final /* synthetic */ ChannelFeedVideoSectionController f2560b;

            public void onSuccess(@Nullable Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                ChannelFeedVideoSectionController.m2497f(this.f2560b);
                if (!a2.isCancelled() && graphQLResult != null && graphQLResult.e != null) {
                    Object obj2 = graphQLResult.e;
                    if (obj2 instanceof FetchVideosByVideoChannelQueryModel) {
                        FetchVideosByVideoChannelQueryModel fetchVideosByVideoChannelQueryModel = (FetchVideosByVideoChannelQueryModel) obj2;
                        if (fetchVideosByVideoChannelQueryModel.a() != null) {
                            ChannelFeedVideoSectionController.m2494c(this.f2560b, fetchVideosByVideoChannelQueryModel.a());
                        }
                    } else if (obj2 instanceof FetchVideosByVideoChannelQueryQEModel) {
                        FetchVideosByVideoChannelQueryQEModel fetchVideosByVideoChannelQueryQEModel = (FetchVideosByVideoChannelQueryQEModel) obj2;
                        if (fetchVideosByVideoChannelQueryQEModel.a() != null) {
                            ChannelFeedVideoSectionController.m2494c(this.f2560b, fetchVideosByVideoChannelQueryQEModel.a());
                        }
                    }
                }
            }

            public void onFailure(Throwable th) {
                if (!a2.isCancelled()) {
                    ChannelFeedVideoSectionController.m2497f(this.f2560b);
                }
            }
        }, channelFeedVideoSectionController.f2576o);
        return a2;
    }

    public static void m2492a(ChannelFeedVideoSectionController channelFeedVideoSectionController, Object obj) {
        if (obj instanceof ChannelFeedVideoChannelFragmentModel) {
            ChannelFeedVideoChannelFragmentModel channelFeedVideoChannelFragmentModel = (ChannelFeedVideoChannelFragmentModel) obj;
            channelFeedVideoSectionController.f2565d = channelFeedVideoChannelFragmentModel.j();
            channelFeedVideoSectionController.f2585x = channelFeedVideoChannelFragmentModel.k().j();
            channelFeedVideoSectionController.f2563b.mo72a(channelFeedVideoChannelFragmentModel);
        } else if (obj instanceof ChannelFeedVideoChannelFragmentQEModel) {
            ChannelFeedVideoChannelFragmentQEModel channelFeedVideoChannelFragmentQEModel = (ChannelFeedVideoChannelFragmentQEModel) obj;
            channelFeedVideoSectionController.f2565d = channelFeedVideoChannelFragmentQEModel.j();
            channelFeedVideoSectionController.f2585x = channelFeedVideoChannelFragmentQEModel.k().j();
            channelFeedVideoSectionController.f2563b.mo73a(channelFeedVideoChannelFragmentQEModel);
        } else {
            return;
        }
        channelFeedVideoSectionController.f2572k.a(channelFeedVideoSectionController.f2572k.h(), channelFeedVideoSectionController.f2572k.g(), channelFeedVideoSectionController.f2572k.i(), channelFeedVideoSectionController.f2583v);
        channelFeedVideoSectionController.f2584w = null;
    }

    public static void m2493b(ChannelFeedVideoSectionController channelFeedVideoSectionController, Object obj) {
        if (obj instanceof ChannelFeedVideoChannelFeedFragmentModel) {
            ChannelFeedVideoChannelFeedFragmentModel channelFeedVideoChannelFeedFragmentModel = (ChannelFeedVideoChannelFeedFragmentModel) obj;
            channelFeedVideoSectionController.f2585x = channelFeedVideoChannelFeedFragmentModel.j();
            channelFeedVideoSectionController.f2563b.mo74a(channelFeedVideoSectionController.f2565d, channelFeedVideoChannelFeedFragmentModel);
        } else if (obj instanceof ChannelFeedVideoChannelFeedFragmentQEModel) {
            ChannelFeedVideoChannelFeedFragmentQEModel channelFeedVideoChannelFeedFragmentQEModel = (ChannelFeedVideoChannelFeedFragmentQEModel) obj;
            channelFeedVideoSectionController.f2585x = channelFeedVideoChannelFeedFragmentQEModel.j();
            channelFeedVideoSectionController.f2563b.mo75a(channelFeedVideoSectionController.f2565d, channelFeedVideoChannelFeedFragmentQEModel);
        } else {
            return;
        }
        channelFeedVideoSectionController.f2584w = null;
    }

    public static void m2494c(ChannelFeedVideoSectionController channelFeedVideoSectionController, Object obj) {
        ImmutableList a;
        if (obj instanceof ChannelFeedVideoChannelFeedFragmentModel) {
            ChannelFeedVideoChannelFeedFragmentModel channelFeedVideoChannelFeedFragmentModel = (ChannelFeedVideoChannelFeedFragmentModel) obj;
            channelFeedVideoSectionController.f2585x = channelFeedVideoChannelFeedFragmentModel.j();
            a = channelFeedVideoChannelFeedFragmentModel.a();
        } else if (obj instanceof ChannelFeedVideoChannelFeedFragmentQEModel) {
            ChannelFeedVideoChannelFeedFragmentQEModel channelFeedVideoChannelFeedFragmentQEModel = (ChannelFeedVideoChannelFeedFragmentQEModel) obj;
            channelFeedVideoSectionController.f2585x = channelFeedVideoChannelFeedFragmentQEModel.j();
            a = channelFeedVideoChannelFeedFragmentQEModel.a();
        } else {
            return;
        }
        if (a != null && !a.isEmpty()) {
            long a2 = channelFeedVideoSectionController.f2564c.a();
            List arrayList = new ArrayList();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                FeedUnit a3 = ((GraphQLVideoChannelFeedEdge) a.get(i)).a();
                if (a3 instanceof GraphQLStory) {
                    GraphQLStory graphQLStory = (GraphQLStory) a3;
                    FetchTimeMsHelper.a(graphQLStory, a2);
                    String a4 = channelFeedVideoSectionController.f2570i.m2439a(graphQLStory);
                    if (a4 != null) {
                        channelFeedVideoSectionController.f2573l.m2566b(FeedProps.c(graphQLStory));
                        arrayList.add(a4);
                    }
                }
            }
            if (channelFeedVideoSectionController.f2566e != null) {
                channelFeedVideoSectionController.f2586y.a(channelFeedVideoSectionController.f2566e, arrayList);
            }
            channelFeedVideoSectionController.f2574m.notifyDataSetChanged();
            channelFeedVideoSectionController.f2584w = null;
            Integer.valueOf(a.size());
        }
    }

    private int m2489a(int i) {
        if (!this.f2569h) {
            return i;
        }
        int i2 = this.f2581t;
        if (this.f2574m != null) {
            i2 -= this.f2574m.e();
        }
        return i2 <= 0 ? 0 : Math.min(i2, i);
    }

    private void m2496e() {
        if (this.f2578q != null) {
            this.f2572k.e(this.f2578q);
        }
    }

    public static void m2497f(ChannelFeedVideoSectionController channelFeedVideoSectionController) {
        if (channelFeedVideoSectionController.f2578q != null) {
            channelFeedVideoSectionController.f2572k.b(channelFeedVideoSectionController.f2578q);
        }
    }
}

package com.facebook.facecastdisplay;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.util.CollectionUtil;
import com.facebook.facecastdisplay.LiveInfoEventModel.LiveInfoType;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQuery.FetchLiveVideoVODBackfillCommentsQueryString;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQuery.FetchLiveVideoVODCommentsQueryString;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.FeedbackLiveVideoCommentCoreFragmentModel.FeedbackModel;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.FeedbackLiveVideoVODBackfillCommentsFragmentModel;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.FeedbackLiveVideoVODCommentsFragmentModel;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.FetchLiveVideoVODBackfillCommentsQueryModel;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.FetchLiveVideoVODCommentsQueryModel;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.LiveVideoVODVideoTimestampedCommentsModel;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.LiveVideoVODVideoTimestampedCommentsModel.EdgesModel;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.LiveVideoVODVideoTimestampedCommentsModel.EdgesModel.NodeModel;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesWithAggregatedRangesFieldsModel;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: attachment_removed */
public class VodEventsStore implements FacecastEventsStore {
    public static final String f19026a = VodEventsStore.class.getName();
    public static final PrefKey f19027b = ((PrefKey) SharedPrefKeys.h.a("live_indicator_info_event_key"));
    private final DefaultAndroidThreadUtil f19028c;
    public final GraphQLQueryExecutor f19029d;
    public final Executor f19030e;
    public final AbstractFbErrorReporter f19031f;
    public final Queue<LiveEventModel> f19032g = new LinkedList();
    public final FbSharedPreferences f19033h;
    public int f19034i;
    public int f19035j;
    public int f19036k;
    public int f19037l;
    public boolean f19038m;
    @Nullable
    public String f19039n;
    @Nullable
    public ListenableFuture<GraphQLResult<FetchLiveVideoVODCommentsQueryModel>> f19040o;
    @Nullable
    public ListenableFuture<GraphQLResult<FetchLiveVideoVODBackfillCommentsQueryModel>> f19041p;
    @Nullable
    public FacecastEventStoreListener f19042q;

    /* compiled from: attachment_removed */
    public class C16541 extends AbstractDisposableFutureCallback<GraphQLResult<FetchLiveVideoVODCommentsQueryModel>> {
        final /* synthetic */ VodEventsStore f19024a;

        public C16541(VodEventsStore vodEventsStore) {
            this.f19024a = vodEventsStore;
        }

        protected final void m22597a(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (this.f19024a.f19040o != null && !this.f19024a.f19040o.isCancelled()) {
                LinkedList linkedList;
                if (graphQLResult == null) {
                    linkedList = null;
                } else {
                    FetchLiveVideoVODCommentsQueryModel fetchLiveVideoVODCommentsQueryModel = (FetchLiveVideoVODCommentsQueryModel) graphQLResult.e;
                    if (fetchLiveVideoVODCommentsQueryModel == null) {
                        linkedList = null;
                    } else {
                        FeedbackLiveVideoVODCommentsFragmentModel j = fetchLiveVideoVODCommentsQueryModel.m3764j();
                        linkedList = j == null ? null : j.m3658q() == null ? null : VodEventsStore.m22601a(j.m3658q());
                    }
                }
                LinkedList linkedList2 = linkedList;
                if (CollectionUtil.b(linkedList2)) {
                    this.f19024a.f19032g.addAll(linkedList2);
                }
                VodEventsStore vodEventsStore = this.f19024a;
                vodEventsStore.f19035j += 60;
            }
        }

        protected final void m22598a(Throwable th) {
            if (this.f19024a.f19040o != null && !this.f19024a.f19040o.isCancelled()) {
                this.f19024a.f19031f.a(VodEventsStore.f19026a + "_graphFailure", new StringBuilder("Failed to get vod comment events for ").append(this.f19024a.f19039n).toString() != null ? this.f19024a.f19039n : "no story id", th);
            }
        }
    }

    /* compiled from: attachment_removed */
    public class C16552 extends AbstractDisposableFutureCallback<GraphQLResult<FetchLiveVideoVODBackfillCommentsQueryModel>> {
        final /* synthetic */ VodEventsStore f19025a;

        public C16552(VodEventsStore vodEventsStore) {
            this.f19025a = vodEventsStore;
        }

        protected final void m22599a(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (this.f19025a.f19041p != null && !this.f19025a.f19041p.isCancelled()) {
                LinkedList linkedList;
                if (graphQLResult == null) {
                    linkedList = null;
                } else {
                    FetchLiveVideoVODBackfillCommentsQueryModel fetchLiveVideoVODBackfillCommentsQueryModel = (FetchLiveVideoVODBackfillCommentsQueryModel) graphQLResult.e;
                    if (fetchLiveVideoVODBackfillCommentsQueryModel == null) {
                        linkedList = null;
                    } else {
                        FeedbackLiveVideoVODBackfillCommentsFragmentModel j = fetchLiveVideoVODBackfillCommentsQueryModel.m3757j();
                        linkedList = j == null ? null : VodEventsStore.m22601a(j.m3633q());
                    }
                }
                List list = linkedList;
                if (CollectionUtil.b(list) && this.f19025a.f19042q != null) {
                    this.f19025a.f19042q.mo146a(list);
                }
            }
        }

        protected final void m22600a(Throwable th) {
            if (this.f19025a.f19041p != null && !this.f19025a.f19041p.isCancelled()) {
                this.f19025a.f19031f.a(VodEventsStore.f19026a + "_graphFailure", new StringBuilder("Failed to get vod comment events for ").append(this.f19025a.f19039n).toString() != null ? this.f19025a.f19039n : "no story id", th);
            }
        }
    }

    @Inject
    public VodEventsStore(DefaultAndroidThreadUtil defaultAndroidThreadUtil, Executor executor, GraphQLQueryExecutor graphQLQueryExecutor, AbstractFbErrorReporter abstractFbErrorReporter, FbSharedPreferences fbSharedPreferences) {
        this.f19028c = defaultAndroidThreadUtil;
        this.f19030e = executor;
        this.f19029d = graphQLQueryExecutor;
        this.f19031f = abstractFbErrorReporter;
        this.f19033h = fbSharedPreferences;
    }

    public final void mo134a(FacecastEventStoreListener facecastEventStoreListener) {
        this.f19028c.a();
        this.f19042q = facecastEventStoreListener;
    }

    public final void mo135a(String str) {
        this.f19028c.a();
        this.f19039n = str;
        this.f19034i = -1;
        this.f19037l = this.f19033h.a(f19027b, 0);
        if (this.f19042q != null) {
            this.f19042q.mo147b();
        }
    }

    public final void mo132a() {
        this.f19028c.a();
        this.f19032g.clear();
        if (this.f19040o != null) {
            this.f19040o.cancel(false);
        }
        if (this.f19041p != null) {
            this.f19041p.cancel(false);
        }
    }

    public final void mo137b(String str) {
    }

    public final void mo139c(String str) {
    }

    public final void mo136a(boolean z) {
    }

    public final void mo138b(boolean z) {
    }

    public final void mo140d(String str) {
    }

    public final void mo141e(String str) {
    }

    public final void mo133a(float f) {
        this.f19028c.a();
        if (this.f19034i == -1 || Math.abs(f - ((float) this.f19034i)) > 2.0f) {
            int i = (int) f;
            this.f19035j = i;
            this.f19036k = i - 2;
            this.f19034i = i;
            this.f19032g.clear();
            if (this.f19040o != null) {
                this.f19040o.cancel(false);
            }
            if (this.f19041p != null) {
                this.f19041p.cancel(false);
            }
            GraphQlQueryString fetchLiveVideoVODBackfillCommentsQueryString = new FetchLiveVideoVODBackfillCommentsQueryString();
            fetchLiveVideoVODBackfillCommentsQueryString.a("after_timestamp", Integer.valueOf(0));
            fetchLiveVideoVODBackfillCommentsQueryString.a("before_timestamp", Integer.valueOf(i));
            fetchLiveVideoVODBackfillCommentsQueryString.a("count", Integer.valueOf(30));
            fetchLiveVideoVODBackfillCommentsQueryString.a("targetID", this.f19039n);
            this.f19041p = this.f19029d.a(GraphQLRequest.a(fetchLiveVideoVODBackfillCommentsQueryString));
            Futures.a(this.f19041p, new C16552(this), this.f19030e);
            if (this.f19042q != null) {
                this.f19042q.mo143a();
            }
        }
        this.f19034i = (int) f;
        if (f > ((float) (this.f19036k + 2))) {
            m22602a((int) f);
        }
        if (f > ((float) (this.f19035j - 15))) {
            Object obj;
            if ((this.f19040o == null || this.f19040o.isDone()) && (this.f19041p == null || this.f19041p.isDone())) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj == null) {
                i = this.f19035j;
                GraphQlQueryString fetchLiveVideoVODCommentsQueryString = new FetchLiveVideoVODCommentsQueryString();
                fetchLiveVideoVODCommentsQueryString.a("after_timestamp", Integer.valueOf(i));
                fetchLiveVideoVODCommentsQueryString.a("before_timestamp", Integer.valueOf(i + 60));
                fetchLiveVideoVODCommentsQueryString.a("count", Integer.valueOf(30));
                fetchLiveVideoVODCommentsQueryString.a("targetID", this.f19039n);
                this.f19040o = this.f19029d.a(GraphQLRequest.a(fetchLiveVideoVODCommentsQueryString));
                Futures.a(this.f19040o, new C16541(this), this.f19030e);
            }
        }
    }

    private void m22602a(int i) {
        if (!this.f19032g.isEmpty()) {
            LiveEventModel liveEventModel = (LiveCommentEventModel) this.f19032g.peek();
            if (liveEventModel.f2856h < i + 2) {
                LiveEventModel liveEventModel2;
                this.f19032g.remove();
                if (this.f19037l >= 3 || this.f19038m || !liveEventModel.f2855g) {
                    liveEventModel2 = null;
                } else {
                    this.f19038m = true;
                    this.f19037l++;
                    this.f19033h.edit().a(f19027b, this.f19037l).commit();
                    liveEventModel2 = new LiveInfoEventModel(LiveInfoType.LIVE_INDICATOR_INFO);
                }
                if (liveEventModel2 == null) {
                    if (this.f19042q != null) {
                        this.f19042q.mo144a(liveEventModel);
                    }
                } else if (this.f19042q != null) {
                    this.f19042q.mo146a(Arrays.asList(new LiveEventModel[]{liveEventModel, r1}));
                }
                this.f19036k = i;
            }
        }
    }

    public static LinkedList<LiveEventModel> m22601a(LiveVideoVODVideoTimestampedCommentsModel liveVideoVODVideoTimestampedCommentsModel) {
        if (liveVideoVODVideoTimestampedCommentsModel == null) {
            return null;
        }
        LinkedList<LiveEventModel> linkedList = new LinkedList();
        ImmutableList a = liveVideoVODVideoTimestampedCommentsModel.m3891a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            LiveCommentEventModel liveCommentEventModel = null;
            NodeModel a2 = ((EdgesModel) a.get(i)).m3886a();
            if (a2 != null) {
                DefaultTextWithEntitiesWithAggregatedRangesFieldsModel k = a2.m3880k();
                if (k != null) {
                    String a3 = k.a();
                    if (a3 != null) {
                        LiveEventAuthor a4 = LiveEventAuthor.m3183a(a2.m3879j());
                        if (a4 != null) {
                            FeedbackModel l = a2.m3881l();
                            if (l != null) {
                                String l2 = l.m3511l();
                                if (l2 != null) {
                                    String m = l.m3512m();
                                    if (m != null) {
                                        liveCommentEventModel = new LiveCommentEventModel(a4, a3, l2, m, l.m3510k(), l.m3509j(), a2.m3883n(), a2.m3882m());
                                    }
                                }
                            }
                        }
                    }
                }
            }
            LiveCommentEventModel liveCommentEventModel2 = liveCommentEventModel;
            if (liveCommentEventModel2 != null) {
                linkedList.add(liveCommentEventModel2);
            }
        }
        return linkedList;
    }
}

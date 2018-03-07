package com.facebook.facecastdisplay.streamingreactions;

import android.util.SparseArray;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.util.CollectionUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.facecastdisplay.protocol.FetchLiveReactionsQuery.FetchLiveVODReactionsQueryString;
import com.facebook.facecastdisplay.protocol.FetchLiveReactionsQueryModels.FetchLiveVODReactionsQueryModel;
import com.facebook.facecastdisplay.protocol.FetchLiveReactionsQueryModels.FetchLiveVODReactionsQueryModel.FeedbackModel;
import com.facebook.facecastdisplay.protocol.FetchLiveReactionsQueryModels.FetchLiveVODReactionsQueryModel.FeedbackModel.ReactionTimeSlicesModel;
import com.facebook.facecastdisplay.protocol.FetchLiveReactionsQueryModels.FetchLiveVODReactionsQueryModel.FeedbackModel.ReactionTimeSlicesModel.ReactionsModel;
import com.facebook.facecastdisplay.protocol.FetchLiveReactionsQueryModels.FetchLiveVODReactionsQueryModel.FeedbackModel.ReactionTimeSlicesModel.ReactionsModel.ImportantReactorsModel;
import com.facebook.facecastdisplay.protocol.FetchLiveReactionsQueryModels.FetchLiveVODReactionsQueryModel.FeedbackModel.ReactionTimeSlicesModel.ReactionsModel.ReactionInfoModel;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: start should be called before calling getBytesPerFrame() */
public class VodStreamingReactionsModel implements StreamingReactionsModel {
    public static final String f3446a = VodStreamingReactionsModel.class.getName();
    public final Executor f3447b;
    public final GraphQLQueryExecutor f3448c;
    public final AbstractFbErrorReporter f3449d;
    public final Queue<ReactionTimeSlicesModel> f3450e = new LinkedList();
    private boolean f3451f;
    public int f3452g;
    public int f3453h;
    private int f3454i;
    private double f3455j;
    @Nullable
    public StreamingReactionsModelListener f3456k;
    @Nullable
    public String f3457l;
    @Nullable
    public ListenableFuture<GraphQLResult<FetchLiveVODReactionsQueryModel>> f3458m;

    /* compiled from: start should be called before calling getBytesPerFrame() */
    public class C02981 extends AbstractDisposableFutureCallback<GraphQLResult<FetchLiveVODReactionsQueryModel>> {
        final /* synthetic */ VodStreamingReactionsModel f3445a;

        public C02981(VodStreamingReactionsModel vodStreamingReactionsModel) {
            this.f3445a = vodStreamingReactionsModel;
        }

        protected final void m4154a(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (this.f3445a.f3458m != null && !this.f3445a.f3458m.isCancelled()) {
                VodStreamingReactionsModel vodStreamingReactionsModel = this.f3445a;
                if (!(graphQLResult == null || graphQLResult.e == null)) {
                    FetchLiveVODReactionsQueryModel fetchLiveVODReactionsQueryModel = (FetchLiveVODReactionsQueryModel) graphQLResult.e;
                    if (fetchLiveVODReactionsQueryModel != null) {
                        FeedbackModel j = fetchLiveVODReactionsQueryModel.m3374j();
                        if (j != null) {
                            ImmutableList a = j.m3366a();
                            if (!CollectionUtil.a(a)) {
                                int size = a.size();
                                for (int i = 0; i < size; i++) {
                                    ReactionTimeSlicesModel reactionTimeSlicesModel = (ReactionTimeSlicesModel) a.get(i);
                                    if (reactionTimeSlicesModel != null) {
                                        vodStreamingReactionsModel.f3450e.add(reactionTimeSlicesModel);
                                    }
                                }
                            }
                        }
                    }
                }
                vodStreamingReactionsModel = this.f3445a;
                vodStreamingReactionsModel.f3453h += 60;
            }
        }

        protected final void m4155a(Throwable th) {
            if (this.f3445a.f3458m != null && !this.f3445a.f3458m.isCancelled()) {
                this.f3445a.f3449d.a(VodStreamingReactionsModel.f3446a + "_graphFailure", new StringBuilder("Failed to get vod reactions for ").append(this.f3445a.f3457l).toString() != null ? this.f3445a.f3457l : "no story id", th);
            }
        }
    }

    @Inject
    public VodStreamingReactionsModel(Executor executor, GraphQLQueryExecutor graphQLQueryExecutor, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f3447b = executor;
        this.f3448c = graphQLQueryExecutor;
        this.f3449d = abstractFbErrorReporter;
    }

    public final void mo150a(StreamingReactionsModelListener streamingReactionsModelListener, String str, String str2) {
        if (!this.f3451f) {
            this.f3451f = true;
            this.f3456k = (StreamingReactionsModelListener) Preconditions.a(streamingReactionsModelListener);
            this.f3457l = (String) Preconditions.a(str);
            this.f3452g = -1;
            this.f3454i = -1;
            this.f3455j = 0.0d;
        }
    }

    public final void mo148a() {
        if (this.f3451f) {
            this.f3451f = false;
            this.f3450e.clear();
            if (this.f3458m != null) {
                this.f3458m.cancel(false);
            }
        }
    }

    public final void mo149a(int i) {
    }

    public final boolean mo152b() {
        return this.f3451f;
    }

    public final double mo153c() {
        return this.f3455j;
    }

    public final int mo154d() {
        return this.f3454i * 1000;
    }

    public final void mo151b(int i) {
        if (this.f3451f) {
            if (this.f3452g == -1 || Math.abs(i - this.f3452g) >= 2) {
                this.f3453h = i;
                this.f3452g = i;
                this.f3450e.clear();
                if (this.f3456k != null) {
                    this.f3456k.mo159a();
                }
                if (this.f3458m != null) {
                    this.f3458m.cancel(false);
                }
            }
            this.f3452g = i;
            m4157d(i);
            if (i >= this.f3453h - 15) {
                Object obj;
                if (this.f3458m == null || this.f3458m.isDone()) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj == null) {
                    int i2 = this.f3453h;
                    GraphQlQueryString fetchLiveVODReactionsQueryString = new FetchLiveVODReactionsQueryString();
                    fetchLiveVODReactionsQueryString.a("after_timestamp", Integer.valueOf(i2));
                    fetchLiveVODReactionsQueryString.a("duration", Integer.valueOf(60));
                    fetchLiveVODReactionsQueryString.a("targetID", this.f3457l);
                    this.f3458m = this.f3448c.a(GraphQLRequest.a(fetchLiveVODReactionsQueryString));
                    Futures.a(this.f3458m, new C02981(this), this.f3447b);
                }
            }
        }
    }

    private void m4157d(int i) {
        while (!this.f3450e.isEmpty() && ((ReactionTimeSlicesModel) this.f3450e.peek()).m3361k() <= ((long) i)) {
            ReactionTimeSlicesModel reactionTimeSlicesModel = (ReactionTimeSlicesModel) this.f3450e.remove();
            if (reactionTimeSlicesModel.m3361k() + reactionTimeSlicesModel.m3357a() > ((long) i)) {
                this.f3454i = (int) reactionTimeSlicesModel.m3357a();
                m4156a(reactionTimeSlicesModel);
                return;
            }
        }
    }

    private void m4156a(ReactionTimeSlicesModel reactionTimeSlicesModel) {
        SparseArray sparseArray = new SparseArray();
        ImmutableList j = reactionTimeSlicesModel.m3360j();
        int size = j.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int a;
            ReactionsModel reactionsModel = (ReactionsModel) j.get(i);
            ReactionInfoModel k = reactionsModel.m3354k();
            if (k != null) {
                ImmutableList j2 = reactionsModel.m3353j();
                int size2 = j2.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    Object j3 = ((ImportantReactorsModel) j2.get(i3)).m3339j();
                    if (!(StringUtil.a(j3) || this.f3456k == null)) {
                        this.f3456k.mo160a(k.m3347j(), j3);
                    }
                }
                sparseArray.put(k.m3347j(), Integer.valueOf(Math.max(reactionsModel.m3349a() - reactionsModel.m3353j().size(), 0)));
                a = reactionsModel.m3349a() + i2;
            } else {
                a = i2;
            }
            i++;
            i2 = a;
        }
        this.f3455j = ((double) i2) / ((double) reactionTimeSlicesModel.m3357a());
        if (this.f3456k != null) {
            this.f3456k.mo161a(sparseArray);
        }
    }
}

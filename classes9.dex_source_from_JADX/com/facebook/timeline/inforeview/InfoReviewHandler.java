package com.facebook.timeline.inforeview;

import android.content.Context;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.graphql.calls.TimelineInfoReviewItemHideInputData;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.timeline.event.HeaderDataEvents.AdapterDataChangedEvent;
import com.facebook.timeline.event.TimelineHeaderEventBus;
import com.facebook.timeline.protocol.TimelineInfoReviewGraphQLModels.InfoReviewItemFragmentModel;
import com.facebook.timeline.protocol.TimelineInfoReviewGraphQLModels.InfoReviewItemsFragmentModel;
import com.facebook.timeline.protocol.TimelineInfoReviewGraphQLModels.InfoReviewItemsFragmentModel.Builder;
import com.facebook.timeline.protocol.TimelineInfoReviewMutation;
import com.facebook.timeline.protocol.TimelineInfoReviewMutation.TimelineInfoReviewItemHideMutationString;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: upload_id */
public class InfoReviewHandler {
    private final IFeedIntentBuilder f849a;
    private final GraphQLQueryExecutor f850b;
    private final DefaultAndroidThreadUtil f851c;
    public final AbstractFbErrorReporter f852d;

    @Inject
    public InfoReviewHandler(IFeedIntentBuilder iFeedIntentBuilder, GraphQLQueryExecutor graphQLQueryExecutor, DefaultAndroidThreadUtil defaultAndroidThreadUtil, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f849a = iFeedIntentBuilder;
        this.f850b = graphQLQueryExecutor;
        this.f851c = defaultAndroidThreadUtil;
        this.f852d = abstractFbErrorReporter;
    }

    public final void m887a(@Nonnull Context context, @Nonnull String str) {
        this.f849a.a(context, str);
    }

    public final void m888a(@Nonnull final InfoReviewItemFragmentModel infoReviewItemFragmentModel, @Nonnull TimelineInfoReviewData timelineInfoReviewData, @Nonnull TimelineHeaderEventBus timelineHeaderEventBus) {
        String g = infoReviewItemFragmentModel.g();
        InfoReviewItemsFragmentModel infoReviewItemsFragmentModel = (InfoReviewItemsFragmentModel) timelineInfoReviewData.b;
        Builder builder = new Builder();
        builder.a = infoReviewItemsFragmentModel.a();
        builder.b = infoReviewItemsFragmentModel.j();
        Builder builder2 = builder;
        ImmutableList.Builder builder3 = new ImmutableList.Builder();
        ImmutableList a = infoReviewItemsFragmentModel.a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            InfoReviewItemFragmentModel infoReviewItemFragmentModel2 = (InfoReviewItemFragmentModel) a.get(i);
            if (!(infoReviewItemFragmentModel2 == null || infoReviewItemFragmentModel2.g() == null || infoReviewItemFragmentModel2.g().equals(g))) {
                builder3.c(InfoReviewItemFragmentModel.a(infoReviewItemFragmentModel2));
            }
        }
        builder2.a = builder3.b();
        timelineInfoReviewData.m921a(builder2.a(), 2);
        timelineHeaderEventBus.a(new AdapterDataChangedEvent());
        this.f851c.a(this.f850b.a(GraphQLRequest.a((TimelineInfoReviewItemHideMutationString) TimelineInfoReviewMutation.a().a("input", new TimelineInfoReviewItemHideInputData().a(infoReviewItemFragmentModel.d())))), new FutureCallback(this) {
            final /* synthetic */ InfoReviewHandler f848b;

            public void onSuccess(@Nullable Object obj) {
            }

            public void onFailure(Throwable th) {
                this.f848b.f852d.a("InfoReviewHandler.hide_failed", "Hide failed for info review item " + infoReviewItemFragmentModel.g());
            }
        });
    }
}

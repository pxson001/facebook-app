package com.facebook.feedplugins.topiccustomizationstory.partdefinitions;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.protocol.FetchNewsFeedGraphQLModels.TrueTopicFeedOptionFragmentModel;
import com.facebook.feed.topicfeeds.customization.TopicFeedsIntentFactory;
import com.facebook.feedplugins.topiccustomizationstory.protocols.TopicFeedOptionMutations.TopicFeedOptionDeselectMutationString;
import com.facebook.feedplugins.topiccustomizationstory.protocols.TopicFeedOptionMutations.TopicFeedOptionSelectMutationString;
import com.facebook.feedplugins.topiccustomizationstory.protocols.TopicFeedOptionMutationsModels.TopicFeedOptionDeselectMutationModel;
import com.facebook.feedplugins.topiccustomizationstory.protocols.TopicFeedOptionMutationsModels.TopicFeedOptionSelectMutationModel;
import com.facebook.feedplugins.topiccustomizationstory.protocols.TrueTopicFeedOptionConversionHelper;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.TopicFeedOptionDeselectInputData;
import com.facebook.graphql.calls.TopicFeedOptionSelectInputData;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLTopicCustomizationStory;
import com.facebook.graphql.model.GraphQLTrueTopicFeedOption;
import com.facebook.graphql.model.GraphQLTrueTopicFeedOptionsEdge;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;

/* compiled from: android.util.Singleton */
public class TopicCustomizationStoryUtil {

    /* compiled from: android.util.Singleton */
    final class C11531 implements OnClickListener {
        final /* synthetic */ TopicFeedsIntentFactory f9968a;
        final /* synthetic */ GraphQLTopicCustomizationStory f9969b;
        final /* synthetic */ SecureContextHelper f9970c;
        final /* synthetic */ Context f9971d;

        C11531(TopicFeedsIntentFactory topicFeedsIntentFactory, GraphQLTopicCustomizationStory graphQLTopicCustomizationStory, SecureContextHelper secureContextHelper, Context context) {
            this.f9968a = topicFeedsIntentFactory;
            this.f9969b = graphQLTopicCustomizationStory;
            this.f9970c = secureContextHelper;
            this.f9971d = context;
        }

        public final void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -91555439);
            this.f9970c.a(this.f9968a.a(this.f9969b.N()), 2056, (Activity) this.f9971d);
            Logger.a(2, EntryType.UI_INPUT_END, 1038837098, a);
        }
    }

    /* compiled from: android.util.Singleton */
    final class C11542 implements OnClickListener {
        final /* synthetic */ Props f9972a;
        final /* synthetic */ NewsFeedAnalyticsEventBuilder f9973b;
        final /* synthetic */ AnalyticsLogger f9974c;
        final /* synthetic */ String f9975d;
        final /* synthetic */ GraphQLQueryExecutor f9976e;
        final /* synthetic */ ExecutorService f9977f;

        C11542(Props props, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, AnalyticsLogger analyticsLogger, String str, GraphQLQueryExecutor graphQLQueryExecutor, ExecutorService executorService) {
            this.f9972a = props;
            this.f9973b = newsFeedAnalyticsEventBuilder;
            this.f9974c = analyticsLogger;
            this.f9975d = str;
            this.f9976e = graphQLQueryExecutor;
            this.f9977f = executorService;
        }

        public final void onClick(View view) {
            boolean z;
            HoneyAnalyticsEvent honeyAnalyticsEvent;
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1134219740);
            Props props = this.f9972a;
            NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder = this.f9973b;
            AnalyticsLogger analyticsLogger = this.f9974c;
            ArrayNode a2 = GraphQLHelper.a(props.f9978a);
            if (props.f9979b.l()) {
                z = false;
            } else {
                z = true;
            }
            Boolean valueOf = Boolean.valueOf(z);
            String k = props.f9979b.n().k();
            int indexOf = props.f9978a.l().indexOf(props.f9979b);
            if (NewsFeedAnalyticsEventBuilder.B(a2)) {
                honeyAnalyticsEvent = null;
            } else {
                HoneyClientEvent a3 = new HoneyClientEvent("topic_feeds_customization_in_feed_unit").a("tracking", a2).a("customization_type_selection", valueOf).b("subtopic_id", k).a("index", indexOf);
                a3.c = "native_newsfeed";
                honeyAnalyticsEvent = a3;
            }
            analyticsLogger.a(honeyAnalyticsEvent);
            if (this.f9972a.f9979b.l()) {
                TopicCustomizationStoryUtil.m10329c(this.f9975d, this.f9972a, this.f9976e, this.f9977f);
            } else {
                TopicCustomizationStoryUtil.m10330d(this.f9975d, this.f9972a, this.f9976e, this.f9977f);
            }
            LogUtils.a(-2000459239, a);
        }
    }

    /* compiled from: android.util.Singleton */
    final class C11553 implements FutureCallback<GraphQLResult<TopicFeedOptionDeselectMutationModel>> {
        C11553() {
        }

        public final /* bridge */ /* synthetic */ void onSuccess(@Nullable Object obj) {
        }

        public final void onFailure(Throwable th) {
        }
    }

    /* compiled from: android.util.Singleton */
    final class C11564 implements FutureCallback<GraphQLResult<TopicFeedOptionSelectMutationModel>> {
        C11564() {
        }

        public final /* bridge */ /* synthetic */ void onSuccess(@Nullable Object obj) {
        }

        public final void onFailure(Throwable th) {
        }
    }

    /* compiled from: android.util.Singleton */
    public class Props {
        public final GraphQLTopicCustomizationStory f9978a;
        public final GraphQLTrueTopicFeedOption f9979b;

        public Props(GraphQLTopicCustomizationStory graphQLTopicCustomizationStory, GraphQLTrueTopicFeedOption graphQLTrueTopicFeedOption) {
            this.f9978a = graphQLTopicCustomizationStory;
            this.f9979b = graphQLTrueTopicFeedOption;
        }
    }

    public static OnClickListener m10325a(TopicFeedsIntentFactory topicFeedsIntentFactory, SecureContextHelper secureContextHelper, Context context, GraphQLTopicCustomizationStory graphQLTopicCustomizationStory) {
        return new C11531(topicFeedsIntentFactory, graphQLTopicCustomizationStory, secureContextHelper, context);
    }

    public static OnClickListener m10326a(String str, Props props, GraphQLQueryExecutor graphQLQueryExecutor, ExecutorService executorService, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, AnalyticsLogger analyticsLogger) {
        return new C11542(props, newsFeedAnalyticsEventBuilder, analyticsLogger, str, graphQLQueryExecutor, executorService);
    }

    public static void m10329c(String str, Props props, GraphQLQueryExecutor graphQLQueryExecutor, ExecutorService executorService) {
        TopicFeedOptionDeselectInputData topicFeedOptionDeselectInputData = new TopicFeedOptionDeselectInputData();
        topicFeedOptionDeselectInputData.a("actor_id", str);
        GraphQlCallInput graphQlCallInput = topicFeedOptionDeselectInputData;
        graphQlCallInput.a("deselected_option_ids", ImmutableList.of(props.f9979b.k()));
        Futures.a(graphQLQueryExecutor.a(GraphQLRequest.a((TopicFeedOptionDeselectMutationString) new TopicFeedOptionDeselectMutationString().a("input", graphQlCallInput)).a(m10327a(props))), new C11553(), executorService);
    }

    public static void m10330d(String str, Props props, GraphQLQueryExecutor graphQLQueryExecutor, ExecutorService executorService) {
        TopicFeedOptionSelectInputData topicFeedOptionSelectInputData = new TopicFeedOptionSelectInputData();
        topicFeedOptionSelectInputData.a("actor_id", str);
        GraphQlCallInput graphQlCallInput = topicFeedOptionSelectInputData;
        graphQlCallInput.a("selected_option_ids", ImmutableList.of(props.f9979b.k()));
        Futures.a(graphQLQueryExecutor.a(GraphQLRequest.a((TopicFeedOptionSelectMutationString) new TopicFeedOptionSelectMutationString().a("input", graphQlCallInput)).a(m10328b(props))), new C11564(), executorService);
    }

    private static TopicFeedOptionDeselectMutationModel m10327a(Props props) {
        Builder builder = ImmutableList.builder();
        ImmutableList a = props.f9978a.J().a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            GraphQLTrueTopicFeedOptionsEdge graphQLTrueTopicFeedOptionsEdge = (GraphQLTrueTopicFeedOptionsEdge) a.get(i);
            if (graphQLTrueTopicFeedOptionsEdge.a() != null) {
                if (graphQLTrueTopicFeedOptionsEdge.a().k() != props.f9979b.k()) {
                    builder.c(TrueTopicFeedOptionConversionHelper.m10346a(graphQLTrueTopicFeedOptionsEdge.a()));
                } else {
                    TrueTopicFeedOptionFragmentModel.Builder a2 = TrueTopicFeedOptionFragmentModel.Builder.a(TrueTopicFeedOptionConversionHelper.m10346a(graphQLTrueTopicFeedOptionsEdge.a()));
                    a2.c = false;
                    builder.c(a2.a());
                }
            }
        }
        TopicFeedOptionDeselectMutationModel.Builder builder2 = new TopicFeedOptionDeselectMutationModel.Builder();
        builder2.f9980a = builder.b();
        builder2 = builder2;
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a3 = ModelHelper.a(flatBufferBuilder, builder2.f9980a);
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a3);
        flatBufferBuilder.d(flatBufferBuilder.d());
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        return new TopicFeedOptionDeselectMutationModel(new MutableFlatBuffer(wrap, null, null, true, null));
    }

    private static TopicFeedOptionSelectMutationModel m10328b(Props props) {
        Builder builder = ImmutableList.builder();
        ImmutableList a = props.f9978a.J().a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            GraphQLTrueTopicFeedOptionsEdge graphQLTrueTopicFeedOptionsEdge = (GraphQLTrueTopicFeedOptionsEdge) a.get(i);
            if (graphQLTrueTopicFeedOptionsEdge.a() != null) {
                if (graphQLTrueTopicFeedOptionsEdge.a().k() != props.f9979b.k()) {
                    builder.c(TrueTopicFeedOptionConversionHelper.m10346a(graphQLTrueTopicFeedOptionsEdge.a()));
                } else {
                    TrueTopicFeedOptionFragmentModel.Builder a2 = TrueTopicFeedOptionFragmentModel.Builder.a(TrueTopicFeedOptionConversionHelper.m10346a(graphQLTrueTopicFeedOptionsEdge.a()));
                    a2.c = true;
                    builder.c(a2.a());
                }
            }
        }
        TopicFeedOptionSelectMutationModel.Builder builder2 = new TopicFeedOptionSelectMutationModel.Builder();
        builder2.f9982a = builder.b();
        builder2 = builder2;
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a3 = ModelHelper.a(flatBufferBuilder, builder2.f9982a);
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a3);
        flatBufferBuilder.d(flatBufferBuilder.d());
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        return new TopicFeedOptionSelectMutationModel(new MutableFlatBuffer(wrap, null, null, true, null));
    }
}

package com.facebook.facecastdisplay.streamingreactions;

import com.facebook.common.time.Clock;
import com.facebook.facecastdisplay.protocol.FetchLiveReactionsQuery.LiveReactionsAddStreamingReactionMutationString;
import com.facebook.graphql.calls.FeedbackAddStreamingReactionInputData;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import java.util.Arrays;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: startAfterEdge called from a valid position */
public class StreamingReactionsInputMutator {
    private final GraphQLQueryExecutor f3373a;
    private final String f3374b;
    private final Clock f3375c;

    @Inject
    public StreamingReactionsInputMutator(GraphQLQueryExecutor graphQLQueryExecutor, String str, Clock clock) {
        this.f3373a = graphQLQueryExecutor;
        this.f3374b = str;
        this.f3375c = clock;
    }

    public final void m4107a(int i, @Nullable GraphQLStory graphQLStory, int i2) {
        if (graphQLStory != null && graphQLStory.l() != null) {
            GraphQLStoryAttachment o = StoryAttachmentHelper.o(graphQLStory);
            if (o != null && o.r() != null) {
                boolean al = o.r().al();
                GraphQlQueryString liveReactionsAddStreamingReactionMutationString = new LiveReactionsAddStreamingReactionMutationString();
                FeedbackAddStreamingReactionInputData feedbackAddStreamingReactionInputData = new FeedbackAddStreamingReactionInputData();
                feedbackAddStreamingReactionInputData.a("feedback_id", graphQLStory.l().z_());
                GraphQlCallInput graphQlCallInput = feedbackAddStreamingReactionInputData;
                graphQlCallInput.a("actor_id", this.f3374b);
                graphQlCallInput = graphQlCallInput;
                graphQlCallInput.a("reaction_key", Integer.valueOf(i));
                graphQlCallInput = graphQlCallInput;
                String str = "tracking";
                graphQlCallInput.a(str, Arrays.asList(new String[]{graphQLStory.k()}));
                graphQlCallInput = graphQlCallInput;
                if (al) {
                    graphQlCallInput.a("content_time_offset", Integer.valueOf(i2));
                } else {
                    graphQlCallInput.a("on_demand_content_time_offset", Integer.valueOf(i2));
                }
                liveReactionsAddStreamingReactionMutationString.a("input", graphQlCallInput);
                this.f3373a.a(GraphQLRequest.a(liveReactionsAddStreamingReactionMutationString));
            }
        }
    }
}

package com.facebook.crowdsourcing.feather.graphql;

import android.content.Context;
import android.util.TypedValue;
import com.facebook.common.futures.DisposableFutureCallback;
import com.facebook.crowdsourcing.logging.CrowdEndpoint;
import com.facebook.crowdsourcing.logging.CrowdEntryPoint;
import com.facebook.crowdsourcing.protocol.graphql.FeatherQueries.FeatherQuestionsQueryString;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.ui.futures.TasksManager;
import javax.inject.Inject;

/* compiled from: max_batch_size */
public class FeatherQueryHelper {
    @Inject
    public TasksManager f14941a;
    @Inject
    public GraphQLQueryExecutor f14942b;

    public final void m21375a(Context context, String str, DisposableFutureCallback disposableFutureCallback) {
        TypedGraphQlQueryString featherQuestionsQueryString = new FeatherQuestionsQueryString();
        featherQuestionsQueryString.m11315a("page_id", str);
        featherQuestionsQueryString.m11314a("place_question_photo_size", Integer.valueOf(Math.max(context.getResources().getDisplayMetrics().heightPixels / 2, context.getResources().getDisplayMetrics().widthPixels / 2)));
        featherQuestionsQueryString.m11314a("profile_picture_size", Float.valueOf(TypedValue.applyDimension(1, 48.0f, context.getResources().getDisplayMetrics())));
        featherQuestionsQueryString.m11315a("endpoint", CrowdEndpoint.FEATHER.getFullName());
        featherQuestionsQueryString.m11315a("entry_point", CrowdEntryPoint.FEATHER_POST_COMPOSE.getFullName());
        this.f14941a.m14553a("task_fetch_questions" + str, this.f14942b.m10446a(GraphQLRequest.m11587a(featherQuestionsQueryString)), disposableFutureCallback);
    }
}

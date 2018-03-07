package com.facebook.topics.data;

import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.TopicHideUserInputData;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.inject.InjectorLike;
import com.facebook.topics.protocol.UserTopicMutations.TopicHideUserMutationString;
import com.facebook.ui.futures.TasksManager;
import javax.inject.Inject;

/* compiled from: network_info_read_count */
public class UserTopicHideMutator {
    private final TasksManager f12547a;
    private final GraphQLQueryExecutor f12548b;
    private final String f12549c;

    public static UserTopicHideMutator m18621b(InjectorLike injectorLike) {
        return new UserTopicHideMutator(TasksManager.m14550b(injectorLike), GraphQLQueryExecutor.m10435a(injectorLike), String_LoggedInUserIdMethodAutoProvider.m4329b(injectorLike));
    }

    @Inject
    public UserTopicHideMutator(TasksManager tasksManager, GraphQLQueryExecutor graphQLQueryExecutor, String str) {
        this.f12547a = tasksManager;
        this.f12548b = graphQLQueryExecutor;
        this.f12549c = str;
    }

    public static UserTopicHideMutator m18620a(InjectorLike injectorLike) {
        return m18621b(injectorLike);
    }

    public final void m18622a(String str, String str2, AbstractDisposableFutureCallback abstractDisposableFutureCallback) {
        TypedGraphQLMutationString topicHideUserMutationString = new TopicHideUserMutationString();
        TopicHideUserInputData topicHideUserInputData = new TopicHideUserInputData();
        topicHideUserInputData.m11397a("actor_id", this.f12549c);
        GraphQlCallInput graphQlCallInput = topicHideUserInputData;
        graphQlCallInput.m11397a("hide_topic_id", str);
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.m11397a("hide_user_id", str2);
        topicHideUserMutationString.m11310a("input", graphQlCallInput);
        this.f12547a.m14562c("MUTATE_USER_TOPIC_HIDE_KEY", this.f12548b.m10448a(GraphQLRequest.m11588a(topicHideUserMutationString)), abstractDisposableFutureCallback);
    }
}

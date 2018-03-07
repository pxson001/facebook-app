package com.facebook.messaging.users.username.graphql;

import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.UserChangeUsernameInputData;
import com.facebook.graphql.calls.UserChangeUsernameInputData.SaveUsername;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.request.MutationRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.service.model.EditUsernameResult;
import com.facebook.messaging.users.username.graphql.EditUsernameMutation.EditUsernameMutationString;
import com.facebook.offlinemode.common.OfflineQueryBehavior;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.ultralight.Inject;
import com.google.common.util.concurrent.ListenableFuture;
import javax.inject.Provider;

/* compiled from: picker_location */
public class MessagingUsernameGraphQLHandler {
    private final GraphQLQueryExecutor f4920a;
    private final Provider<String> f4921b;

    public static MessagingUsernameGraphQLHandler m4476b(InjectorLike injectorLike) {
        return new MessagingUsernameGraphQLHandler(GraphQLQueryExecutor.a(injectorLike), IdBasedProvider.a(injectorLike, 4442));
    }

    @Inject
    private MessagingUsernameGraphQLHandler(GraphQLQueryExecutor graphQLQueryExecutor, Provider<String> provider) {
        this.f4920a = graphQLQueryExecutor;
        this.f4921b = provider;
    }

    public final ListenableFuture<GraphQLResult> m4477a(String str) {
        return this.f4920a.a(m4475a(str, false), OfflineQueryBehavior.a);
    }

    public final EditUsernameResult m4478b(String str) {
        if (((GraphQLResult) FutureDetour.a(this.f4920a.a(m4475a(str, true), OfflineQueryBehavior.a), -71605704)) != null) {
            return new EditUsernameResult(str);
        }
        throw new IllegalStateException();
    }

    private MutationRequest m4475a(String str, boolean z) {
        Enum enumR = z ? SaveUsername.TRUE : SaveUsername.FALSE;
        GraphQlQueryString editUsernameMutationString = new EditUsernameMutationString();
        UserChangeUsernameInputData userChangeUsernameInputData = new UserChangeUsernameInputData();
        userChangeUsernameInputData.a("actor_id", (String) this.f4921b.get());
        GraphQlCallInput graphQlCallInput = userChangeUsernameInputData;
        graphQlCallInput.a("username", str);
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.a("save_username", enumR);
        editUsernameMutationString.a("input", graphQlCallInput);
        return GraphQLRequest.a(editUsernameMutationString);
    }
}

package com.facebook.search.results.environment.entity;

import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.multirow.api.AnyEnvironment;
import javax.annotation.Nullable;

/* compiled from: Start media params are incomplete - flickering or other artifacts may occur */
public interface CanProvideRoleForEntity extends AnyEnvironment {
    @Nullable
    GraphQLGraphSearchResultRole mo1252c(GraphQLNode graphQLNode);

    @Nullable
    String mo1253d(GraphQLNode graphQLNode);
}

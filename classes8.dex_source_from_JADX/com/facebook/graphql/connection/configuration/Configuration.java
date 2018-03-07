package com.facebook.graphql.connection.configuration;

import com.facebook.graphql.connection.ConnectionTailLoaderManager.RowIterator;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;

/* compiled from: widthDps */
public abstract class Configuration {
    public abstract RowIterator mo18a(TailFetchLocation tailFetchLocation, GraphQLResult graphQLResult);

    public abstract GraphQLRequest mo19a(TailFetchLocation tailFetchLocation);

    public abstract String mo20a();
}

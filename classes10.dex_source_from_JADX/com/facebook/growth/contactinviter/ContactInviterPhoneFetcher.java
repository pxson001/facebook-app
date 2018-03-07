package com.facebook.growth.contactinviter;

import com.facebook.graphql.executor.GraphQLQueryExecutor;
import javax.inject.Inject;

/* compiled from: TERMS_OF_SERVICE */
public class ContactInviterPhoneFetcher {
    public GraphQLQueryExecutor f23298a;
    public FreeFbJsonParams f23299b;

    @Inject
    public ContactInviterPhoneFetcher(GraphQLQueryExecutor graphQLQueryExecutor, FreeFbJsonParams freeFbJsonParams) {
        this.f23298a = graphQLQueryExecutor;
        this.f23299b = freeFbJsonParams;
    }
}

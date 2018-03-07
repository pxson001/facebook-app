package com.facebook.contacts.pna;

import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: platform_xmd */
public class PhoneNumberAcquisitionClient {
    public final GraphQLQueryExecutor f6501a;

    public static PhoneNumberAcquisitionClient m6847b(InjectorLike injectorLike) {
        return new PhoneNumberAcquisitionClient(GraphQLQueryExecutor.a(injectorLike));
    }

    @Inject
    public PhoneNumberAcquisitionClient(GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f6501a = graphQLQueryExecutor;
    }
}

package com.facebook.adsexperiencetool.protocol;

import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: enumType */
public class AdsExperienceMutator {
    public final GraphQLQueryExecutor f14447a;
    public final Provider<String> f14448b;

    public static AdsExperienceMutator m14594a(InjectorLike injectorLike) {
        return new AdsExperienceMutator(GraphQLQueryExecutor.a(injectorLike), IdBasedProvider.a(injectorLike, 4442));
    }

    @Inject
    public AdsExperienceMutator(GraphQLQueryExecutor graphQLQueryExecutor, Provider<String> provider) {
        this.f14447a = graphQLQueryExecutor;
        this.f14448b = provider;
    }
}

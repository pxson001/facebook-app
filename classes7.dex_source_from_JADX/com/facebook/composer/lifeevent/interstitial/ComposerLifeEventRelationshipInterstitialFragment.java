package com.facebook.composer.lifeevent.interstitial;

import com.facebook.composer.lifeevent.protocol.FetchLifeEventComposerDataGraphQL.PeopleEntitiesTypeAheadSuggestionsQueryString;
import com.facebook.composer.lifeevent.protocol.FetchLifeEventComposerDataGraphQLModels.PeopleEntitiesTypeAheadSuggestionsQueryModel;
import com.facebook.composer.lifeevent.protocol.FetchLifeEventComposerDataGraphQLModels.TypeAheadSuggestionFieldsModel;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;

/* compiled from: core_attribute_line_spacing */
public abstract class ComposerLifeEventRelationshipInterstitialFragment extends ComposerLifeEventInterstitialFragment {

    /* compiled from: core_attribute_line_spacing */
    class C13381 implements Function<GraphQLResult<PeopleEntitiesTypeAheadSuggestionsQueryModel>, ImmutableList<TypeAheadSuggestionFieldsModel>> {
        final /* synthetic */ ComposerLifeEventRelationshipInterstitialFragment f16753a;

        C13381(ComposerLifeEventRelationshipInterstitialFragment composerLifeEventRelationshipInterstitialFragment) {
            this.f16753a = composerLifeEventRelationshipInterstitialFragment;
        }

        public Object apply(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null || ((PeopleEntitiesTypeAheadSuggestionsQueryModel) graphQLResult.e).a() == null) {
                return RegularImmutableList.a;
            }
            return ((PeopleEntitiesTypeAheadSuggestionsQueryModel) graphQLResult.e).a().a();
        }
    }

    protected final String mo1292b() {
        return b(2131234178);
    }

    protected final boolean aq() {
        return true;
    }

    protected final ListenableFuture<ImmutableList<TypeAheadSuggestionFieldsModel>> mo1291a(String str) {
        GraphQlQueryString peopleEntitiesTypeAheadSuggestionsQueryString = new PeopleEntitiesTypeAheadSuggestionsQueryString();
        peopleEntitiesTypeAheadSuggestionsQueryString.a("query", str).a("image_size", Integer.valueOf(jW_().getDimensionPixelSize(2131427457)));
        return Futures.a(this.f16713c.a(GraphQLRequest.a(peopleEntitiesTypeAheadSuggestionsQueryString).a(GraphQLCachePolicy.c)), new C13381(this), MoreExecutors.a());
    }
}

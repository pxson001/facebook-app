package com.facebook.composer.lifeevent.interstitial;

import com.facebook.composer.lifeevent.model.ComposerLifeEventModel.Builder;
import com.facebook.composer.lifeevent.protocol.FetchLifeEventComposerDataGraphQL.CollegeEntitiesTypeAheadSuggestionsQueryString;
import com.facebook.composer.lifeevent.protocol.FetchLifeEventComposerDataGraphQLModels.CollegeEntitiesTypeAheadSuggestionsQueryModel;
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

/* compiled from: core_attribute_padding */
public class ComposerLifeEventCollegeInterstitialFragment extends ComposerLifeEventEducationInterstitialFragment {

    /* compiled from: core_attribute_padding */
    class C13221 implements Function<GraphQLResult<CollegeEntitiesTypeAheadSuggestionsQueryModel>, ImmutableList<TypeAheadSuggestionFieldsModel>> {
        final /* synthetic */ ComposerLifeEventCollegeInterstitialFragment f16710a;

        C13221(ComposerLifeEventCollegeInterstitialFragment composerLifeEventCollegeInterstitialFragment) {
            this.f16710a = composerLifeEventCollegeInterstitialFragment;
        }

        public Object apply(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null || ((CollegeEntitiesTypeAheadSuggestionsQueryModel) graphQLResult.e).a() == null) {
                return RegularImmutableList.a;
            }
            return ((CollegeEntitiesTypeAheadSuggestionsQueryModel) graphQLResult.e).a().a();
        }
    }

    protected final String mo1292b() {
        return b(2131234181);
    }

    protected final Builder mo1290a(Builder builder, TypeAheadSuggestionFieldsModel typeAheadSuggestionFieldsModel) {
        builder.a = a(2131234183, new Object[]{typeAheadSuggestionFieldsModel.k()});
        Builder builder2 = builder;
        builder2.j = typeAheadSuggestionFieldsModel.j();
        return builder2;
    }

    protected final ListenableFuture<ImmutableList<TypeAheadSuggestionFieldsModel>> mo1291a(String str) {
        GraphQlQueryString collegeEntitiesTypeAheadSuggestionsQueryString = new CollegeEntitiesTypeAheadSuggestionsQueryString();
        collegeEntitiesTypeAheadSuggestionsQueryString.a("query", str).a("image_size", Integer.valueOf(jW_().getDimensionPixelSize(2131427457)));
        return Futures.a(this.f16713c.a(GraphQLRequest.a(collegeEntitiesTypeAheadSuggestionsQueryString).a(GraphQLCachePolicy.c)), new C13221(this), MoreExecutors.a());
    }
}

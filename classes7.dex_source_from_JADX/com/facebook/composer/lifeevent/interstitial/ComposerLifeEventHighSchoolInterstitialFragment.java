package com.facebook.composer.lifeevent.interstitial;

import com.facebook.composer.lifeevent.model.ComposerLifeEventModel.Builder;
import com.facebook.composer.lifeevent.protocol.FetchLifeEventComposerDataGraphQL.HighSchoolEntitiesTypeAheadSuggestionsQueryString;
import com.facebook.composer.lifeevent.protocol.FetchLifeEventComposerDataGraphQLModels.HighSchoolEntitiesTypeAheadSuggestionsQueryModel;
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

/* compiled from: core_attribute_glyph_alignment */
public class ComposerLifeEventHighSchoolInterstitialFragment extends ComposerLifeEventEducationInterstitialFragment {

    /* compiled from: core_attribute_glyph_alignment */
    class C13231 implements Function<GraphQLResult<HighSchoolEntitiesTypeAheadSuggestionsQueryModel>, ImmutableList<TypeAheadSuggestionFieldsModel>> {
        final /* synthetic */ ComposerLifeEventHighSchoolInterstitialFragment f16720a;

        C13231(ComposerLifeEventHighSchoolInterstitialFragment composerLifeEventHighSchoolInterstitialFragment) {
            this.f16720a = composerLifeEventHighSchoolInterstitialFragment;
        }

        public Object apply(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null || ((HighSchoolEntitiesTypeAheadSuggestionsQueryModel) graphQLResult.e).a() == null) {
                return RegularImmutableList.a;
            }
            return ((HighSchoolEntitiesTypeAheadSuggestionsQueryModel) graphQLResult.e).a().a();
        }
    }

    protected final String mo1292b() {
        return b(2131234180);
    }

    protected final Builder mo1290a(Builder builder, TypeAheadSuggestionFieldsModel typeAheadSuggestionFieldsModel) {
        builder.a = a(2131234183, new Object[]{typeAheadSuggestionFieldsModel.k()});
        Builder builder2 = builder;
        builder2.j = typeAheadSuggestionFieldsModel.j();
        return builder2;
    }

    protected final ListenableFuture<ImmutableList<TypeAheadSuggestionFieldsModel>> mo1291a(String str) {
        GraphQlQueryString highSchoolEntitiesTypeAheadSuggestionsQueryString = new HighSchoolEntitiesTypeAheadSuggestionsQueryString();
        highSchoolEntitiesTypeAheadSuggestionsQueryString.a("query", str).a("image_size", Integer.valueOf(jW_().getDimensionPixelSize(2131427457)));
        return Futures.a(this.f16713c.a(GraphQLRequest.a(highSchoolEntitiesTypeAheadSuggestionsQueryString).a(GraphQLCachePolicy.c)), new C13231(this), MoreExecutors.a());
    }
}

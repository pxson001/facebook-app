package com.facebook.composer.lifeevent.interstitial;

import com.facebook.composer.lifeevent.model.ComposerLifeEventModel.Builder;
import com.facebook.composer.lifeevent.protocol.FetchLifeEventComposerDataGraphQL.WorkEntitiesTypeAheadSuggestionsQueryString;
import com.facebook.composer.lifeevent.protocol.FetchLifeEventComposerDataGraphQLModels.TypeAheadSuggestionFieldsModel;
import com.facebook.composer.lifeevent.protocol.FetchLifeEventComposerDataGraphQLModels.WorkEntitiesTypeAheadSuggestionsQueryModel;
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

/* compiled from: copyright_monitor_stop */
public class ComposerLifeEventWorkInterstitialFragment extends ComposerLifeEventInterstitialFragment {

    /* compiled from: copyright_monitor_stop */
    class C13391 implements Function<GraphQLResult<WorkEntitiesTypeAheadSuggestionsQueryModel>, ImmutableList<TypeAheadSuggestionFieldsModel>> {
        final /* synthetic */ ComposerLifeEventWorkInterstitialFragment f16754a;

        C13391(ComposerLifeEventWorkInterstitialFragment composerLifeEventWorkInterstitialFragment) {
            this.f16754a = composerLifeEventWorkInterstitialFragment;
        }

        public Object apply(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null || ((WorkEntitiesTypeAheadSuggestionsQueryModel) graphQLResult.e).a() == null) {
                return RegularImmutableList.a;
            }
            return ((WorkEntitiesTypeAheadSuggestionsQueryModel) graphQLResult.e).a().a();
        }
    }

    protected final String mo1289e() {
        return b(2131234176);
    }

    protected final String mo1292b() {
        return b(2131234179);
    }

    protected final boolean aq() {
        return false;
    }

    protected final Builder mo1290a(Builder builder, TypeAheadSuggestionFieldsModel typeAheadSuggestionFieldsModel) {
        builder.a = a(2131234184, new Object[]{typeAheadSuggestionFieldsModel.k()});
        Builder builder2 = builder;
        builder2.k = typeAheadSuggestionFieldsModel.j();
        return builder2;
    }

    protected final ListenableFuture<ImmutableList<TypeAheadSuggestionFieldsModel>> mo1291a(String str) {
        GraphQlQueryString workEntitiesTypeAheadSuggestionsQueryString = new WorkEntitiesTypeAheadSuggestionsQueryString();
        workEntitiesTypeAheadSuggestionsQueryString.a("query", str).a("image_size", Integer.valueOf(jW_().getDimensionPixelSize(2131427457)));
        return Futures.a(this.f16713c.a(GraphQLRequest.a(workEntitiesTypeAheadSuggestionsQueryString).a(GraphQLCachePolicy.c)), new C13391(this), MoreExecutors.a());
    }
}

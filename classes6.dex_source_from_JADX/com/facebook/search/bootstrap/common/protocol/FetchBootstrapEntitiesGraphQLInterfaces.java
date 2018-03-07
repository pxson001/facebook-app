package com.facebook.search.bootstrap.common.protocol;

import com.facebook.search.bootstrap.common.protocol.FetchBootstrapEntitiesGraphQLModels.AddEntityFragmentModel.SearchableModel;
import com.facebook.search.graphql.SearchEntityInterfaces.StructuredGrammarCost;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: extra_error_details */
public class FetchBootstrapEntitiesGraphQLInterfaces {

    /* compiled from: extra_error_details */
    public interface AddEntityFragment {
        @Nullable
        String mo1229a();

        @Nullable
        SearchableModel mo1230b();

        @Nonnull
        ImmutableList<? extends StructuredGrammarCost> mo1231c();

        @Nullable
        String mo1232d();
    }
}

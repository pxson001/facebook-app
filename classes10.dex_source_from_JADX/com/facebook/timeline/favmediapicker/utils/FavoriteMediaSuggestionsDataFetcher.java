package com.facebook.timeline.favmediapicker.utils;

import android.content.Context;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.timeline.favmediapicker.protocol.FetchFavoriteMediaPickerSuggestionsModels.FavoriteMediaUserModel;
import com.facebook.timeline.favmediapicker.protocol.FetchFavoriteMediaPickerSuggestionsModels.SuggestedMediasetModel;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: friends_nearby_ping_failed */
public class FavoriteMediaSuggestionsDataFetcher {
    public static final CallerContext f11141a = CallerContext.a(FavoriteMediaSuggestionsDataFetcher.class, "favorite_media_picker");
    private static FavoriteMediaSuggestionsDataFetcher f11142c;
    private static final Object f11143d = new Object();
    public final GraphQLQueryExecutor f11144b;

    /* compiled from: friends_nearby_ping_failed */
    public class C16141 implements Function<GraphQLResult<FavoriteMediaUserModel>, ImmutableList<SuggestedMediasetModel>> {
        final /* synthetic */ FavoriteMediaSuggestionsDataFetcher f11140a;

        public C16141(FavoriteMediaSuggestionsDataFetcher favoriteMediaSuggestionsDataFetcher) {
            this.f11140a = favoriteMediaSuggestionsDataFetcher;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            return (graphQLResult == null || ((FavoriteMediaUserModel) graphQLResult.e).m11162a() == null) ? null : ((FavoriteMediaUserModel) graphQLResult.e).m11162a().m11158a();
        }

        public boolean equals(@Nullable Object obj) {
            return false;
        }
    }

    private static FavoriteMediaSuggestionsDataFetcher m11294b(InjectorLike injectorLike) {
        return new FavoriteMediaSuggestionsDataFetcher(GraphQLQueryExecutor.a(injectorLike));
    }

    @Inject
    public FavoriteMediaSuggestionsDataFetcher(GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f11144b = graphQLQueryExecutor;
    }

    public static FavoriteMediaSuggestionsDataFetcher m11293a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FavoriteMediaSuggestionsDataFetcher b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f11143d) {
                FavoriteMediaSuggestionsDataFetcher favoriteMediaSuggestionsDataFetcher;
                if (a2 != null) {
                    favoriteMediaSuggestionsDataFetcher = (FavoriteMediaSuggestionsDataFetcher) a2.a(f11143d);
                } else {
                    favoriteMediaSuggestionsDataFetcher = f11142c;
                }
                if (favoriteMediaSuggestionsDataFetcher == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m11294b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f11143d, b3);
                        } else {
                            f11142c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = favoriteMediaSuggestionsDataFetcher;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

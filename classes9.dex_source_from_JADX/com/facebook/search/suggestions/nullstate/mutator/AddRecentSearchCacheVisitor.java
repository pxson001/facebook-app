package com.facebook.search.suggestions.nullstate.mutator;

import com.facebook.graphql.executor.cache.RecursiveModelTransformer;
import com.facebook.graphql.executor.iface.CacheVisitor;
import com.facebook.graphql.executor.iface.TypedModelVisitor;
import com.facebook.inject.Assisted;
import com.facebook.search.model.NullStateSuggestionTypeaheadUnit;
import com.facebook.search.model.converter.RecentSearchSuggestionGraphQLModelConverter;
import com.facebook.search.protocol.FetchRecentSearchesGraphQLModels.FBRecentSearchesQueryModel.RecentSearchesModel;
import com.facebook.search.protocol.FetchRecentSearchesGraphQLModels.FBRecentSearchesQueryModel.RecentSearchesModel.EdgesModel;
import com.facebook.search.protocol.FetchRecentSearchesGraphQLModels.FBRecentSearchesQueryModel.RecentSearchesModel.EdgesModel.NodeModel;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Sets;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: warm_perf_marker */
public class AddRecentSearchCacheVisitor implements CacheVisitor {
    private final String f231a;
    private final RecursiveModelTransformer<RecentSearchesModel> f232b;

    @Inject
    public AddRecentSearchCacheVisitor(@Assisted String str, @Assisted final NullStateSuggestionTypeaheadUnit nullStateSuggestionTypeaheadUnit, @Assisted final Integer num, final RecentSearchSuggestionGraphQLModelConverter recentSearchSuggestionGraphQLModelConverter) {
        this.f231a = str;
        this.f232b = new RecursiveModelTransformer(RecentSearchesModel.class, new TypedModelVisitor<RecentSearchesModel>(this) {
            final /* synthetic */ AddRecentSearchCacheVisitor f230d;

            @Nullable
            public final Object m353a(@Nullable Object obj) {
                int i;
                RecentSearchesModel recentSearchesModel = (RecentSearchesModel) obj;
                ImmutableList a = recentSearchesModel.a();
                EdgesModel a2 = RecentSearchSuggestionGraphQLModelConverter.a(nullStateSuggestionTypeaheadUnit);
                Builder builder = new Builder();
                Object obj2 = 1;
                int size = a.size();
                int i2 = 0;
                int i3 = 0;
                while (i2 < size) {
                    Object obj3;
                    if (AddRecentSearchCacheVisitor.m354b((EdgesModel) a.get(i2), a2)) {
                        builder.c(a2);
                        i = i3 + 1;
                        obj3 = null;
                    } else {
                        obj3 = obj2;
                        i = i3;
                    }
                    i2++;
                    i3 = i;
                    obj2 = obj3;
                }
                if (obj2 != null) {
                    builder.c(a2);
                    i3++;
                }
                i2 = a.size();
                i = 0;
                int i4 = i3;
                while (i < i2) {
                    EdgesModel edgesModel = (EdgesModel) a.get(i);
                    if (i4 == num.intValue()) {
                        break;
                    }
                    int i5;
                    if (AddRecentSearchCacheVisitor.m354b(edgesModel, a2)) {
                        i5 = i4;
                    } else {
                        builder.c(edgesModel);
                        i5 = i4 + 1;
                    }
                    i++;
                    i4 = i5;
                }
                RecentSearchesModel.Builder builder2 = new RecentSearchesModel.Builder();
                builder2.a = recentSearchesModel.a();
                RecentSearchesModel.Builder builder3 = builder2;
                builder3.a = builder.b();
                return builder3.a();
            }
        });
    }

    public final <T> T m355a(T t) {
        return this.f232b.a(t);
    }

    public final Set<String> m356a() {
        return Sets.a(new String[]{this.f231a});
    }

    public static boolean m354b(EdgesModel edgesModel, EdgesModel edgesModel2) {
        NodeModel a = edgesModel.a();
        NodeModel a2 = edgesModel2.a();
        if (a.o().length() <= 0 || a2.o().length() <= 0) {
            return Objects.equal(a.p(), a2.p());
        }
        return Objects.equal(a.o(), a2.o());
    }
}

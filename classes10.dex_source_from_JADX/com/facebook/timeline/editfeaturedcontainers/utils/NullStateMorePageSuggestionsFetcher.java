package com.facebook.timeline.editfeaturedcontainers.utils;

import android.content.Context;
import android.widget.Toast;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.adapter.api.MultiRowRecyclerViewAdapter;
import com.facebook.graphql.calls.SectionTypesInputFeaturedPageSuggestionsSectionType;
import com.facebook.graphql.enums.GraphQLIntroFeaturedPageSuggestionsSectionType;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.timeline.editfeaturedcontainers.models.NullStateData;
import com.facebook.timeline.editfeaturedcontainers.protocol.FetchNullStateGraphQLModels.FeaturedPageSectionModel;
import com.facebook.timeline.editfeaturedcontainers.rows.environments.HasMorePageSuggestionsFetcher;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: geofence_exited_start */
public class NullStateMorePageSuggestionsFetcher implements HasMorePageSuggestionsFetcher {
    private static NullStateMorePageSuggestionsFetcher f10957f;
    private static final Object f10958g = new Object();
    public final NullStateData f10959a;
    private final NullStateSuggestionsDataFetcher f10960b;
    private final Executor f10961c;
    public MultiRowRecyclerViewAdapter f10962d;
    private AbstractDisposableFutureCallback<ImmutableList<FeaturedPageSectionModel>> f10963e;

    private static NullStateMorePageSuggestionsFetcher m11086b(InjectorLike injectorLike) {
        return new NullStateMorePageSuggestionsFetcher(NullStateData.m10787a(injectorLike), NullStateSuggestionsDataFetcher.m11090a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public NullStateMorePageSuggestionsFetcher(NullStateData nullStateData, NullStateSuggestionsDataFetcher nullStateSuggestionsDataFetcher, Executor executor) {
        this.f10959a = nullStateData;
        this.f10960b = nullStateSuggestionsDataFetcher;
        this.f10961c = executor;
    }

    public final void mo517a(int i, int i2, ImmutableList<SectionTypesInputFeaturedPageSuggestionsSectionType> immutableList, final Context context) {
        this.f10963e = new AbstractDisposableFutureCallback<ImmutableList<FeaturedPageSectionModel>>(this) {
            final /* synthetic */ NullStateMorePageSuggestionsFetcher f10956b;

            public final void m11083a(@Nullable Object obj) {
                ImmutableList immutableList = (ImmutableList) obj;
                if (immutableList != null) {
                    NullStateData nullStateData = this.f10956b.f10959a;
                    FeaturedPageSectionModel featuredPageSectionModel = (FeaturedPageSectionModel) immutableList.get(0);
                    GraphQLIntroFeaturedPageSuggestionsSectionType j = featuredPageSectionModel.m10820j();
                    int i = 0;
                    while (i < nullStateData.f10768a.size()) {
                        if ((nullStateData.f10768a.get(i) instanceof FeaturedPageSectionModel) && ((FeaturedPageSectionModel) nullStateData.f10768a.get(i)).m10820j() == j) {
                            break;
                        }
                        i++;
                    }
                    i = -1;
                    int i2 = i;
                    if (i2 != -1) {
                        nullStateData.f10768a.set(i2, featuredPageSectionModel);
                    }
                    if (this.f10956b.f10962d != null) {
                        this.f10956b.f10962d.notifyDataSetChanged();
                        return;
                    }
                    return;
                }
                NullStateMorePageSuggestionsFetcher nullStateMorePageSuggestionsFetcher = this.f10956b;
                Toast.makeText(context, 2131241394, 1).show();
            }

            public final void m11084a(Throwable th) {
                NullStateMorePageSuggestionsFetcher nullStateMorePageSuggestionsFetcher = this.f10956b;
                Toast.makeText(context, 2131241394, 1).show();
            }
        };
        Futures.a(this.f10960b.m11092a(i, i2, immutableList), this.f10963e, this.f10961c);
    }

    public static NullStateMorePageSuggestionsFetcher m11085a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NullStateMorePageSuggestionsFetcher b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f10958g) {
                NullStateMorePageSuggestionsFetcher nullStateMorePageSuggestionsFetcher;
                if (a2 != null) {
                    nullStateMorePageSuggestionsFetcher = (NullStateMorePageSuggestionsFetcher) a2.a(f10958g);
                } else {
                    nullStateMorePageSuggestionsFetcher = f10957f;
                }
                if (nullStateMorePageSuggestionsFetcher == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m11086b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f10958g, b3);
                        } else {
                            f10957f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = nullStateMorePageSuggestionsFetcher;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void mo518a(MultiRowRecyclerViewAdapter multiRowRecyclerViewAdapter) {
        this.f10962d = multiRowRecyclerViewAdapter;
    }

    public final void mo516a() {
        if (this.f10963e != null) {
            this.f10963e.jc_();
        }
    }
}

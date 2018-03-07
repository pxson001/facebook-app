package com.facebook.search.suggestions.nullstate;

import android.content.res.Resources;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.api.GraphSearchQuery.ScopedEntityType;
import com.facebook.search.api.NullStateStatus;
import com.facebook.search.model.EmptyScopedNullStateTypeaheadUnit;
import com.facebook.search.model.SearchBoxQueryState;
import com.facebook.search.model.SuggestionGroup;
import com.facebook.search.model.SuggestionGroup.Builder;
import com.facebook.search.model.SuggestionGroup.Type;
import com.facebook.search.model.TypeaheadUnit;
import com.facebook.search.suggestions.SuggestionsListRowItemFactory;
import com.facebook.search.suggestions.nullstate.NullStateSupplier.NullStateStatusListener;
import com.facebook.search.suggestions.simplesearch.RemoteTypeaheadFetcher;
import com.facebook.ui.typeahead.FetchState;
import com.facebook.ui.typeahead.OnFetchStateChangedListener;
import com.facebook.ui.typeahead.TypeaheadFetcher.OnSuggestionsFetchedListener;
import com.facebook.ui.typeahead.TypeaheadResponse;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableBiMap;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;

@ThreadSafe
/* compiled from: web_url */
public class ScopedNullStateSupplier extends NullStateSupplier implements OnFetchStateChangedListener, OnSuggestionsFetchedListener<TypeaheadUnit> {
    private final SuggestionsListRowItemFactory f210a;
    private final Resources f211b;
    private final RemoteTypeaheadFetcher f212c;
    private TypeaheadResponse<TypeaheadUnit> f213d = null;
    private ScopedEntityType f214e = null;
    private ImmutableList<TypeaheadUnit> f215f = RegularImmutableList.a;
    private NullStateStatusListener f216g;
    private OnFetchStateChangedListener f217h;

    /* compiled from: web_url */
    /* synthetic */ class C00271 {
        static final /* synthetic */ int[] f209a = new int[ScopedEntityType.values().length];

        static {
            try {
                f209a[ScopedEntityType.USER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f209a[ScopedEntityType.PAGE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f209a[ScopedEntityType.GROUP.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    @Inject
    public ScopedNullStateSupplier(Resources resources, SuggestionsListRowItemFactory suggestionsListRowItemFactory, RemoteTypeaheadFetcher remoteTypeaheadFetcher) {
        this.f211b = resources;
        this.f210a = suggestionsListRowItemFactory;
        this.f212c = remoteTypeaheadFetcher;
    }

    public final boolean m340a() {
        return true;
    }

    public final NullStateStatus m342c() {
        return this.f213d != null ? NullStateStatus.READY : NullStateStatus.NOT_READY;
    }

    public final void m337a(NullStateStatusListener nullStateStatusListener, OnFetchStateChangedListener onFetchStateChangedListener) {
        this.f216g = nullStateStatusListener;
        this.f217h = onFetchStateChangedListener;
    }

    public Object get() {
        Object of;
        synchronized (this) {
            if (c().equals(NullStateStatus.NOT_READY)) {
                of = ImmutableList.of();
            } else {
                Preconditions.checkNotNull(this.f213d.b().b());
                of = SuggestionsListRowItemFactory.b(this.f213d.b().b().isEmpty() ? m334k() : m335l());
            }
        }
        return of;
    }

    public final void m339a(TypeaheadResponse<TypeaheadUnit> typeaheadResponse) {
        this.f213d = typeaheadResponse;
        if (this.f216g != null) {
            this.f216g.a(NullStateStatus.READY);
        }
    }

    public final void m338a(FetchState fetchState) {
        if (fetchState == FetchState.ERROR && this.f216g != null) {
            this.f216g.a(NullStateStatus.READY);
        }
        if (this.f217h != null) {
            this.f217h.a(fetchState);
        }
    }

    public final synchronized void m341b() {
        this.f213d = null;
        this.f215f = null;
    }

    public final SearchBoxQueryState m343f() {
        return SearchBoxQueryState.SINGLE_STATE;
    }

    private int m333e() {
        switch (C00271.f209a[this.f214e.ordinal()]) {
            case 1:
                return 2131237434;
            case 2:
                return 2131237433;
            case 3:
                return 2131237432;
            default:
                throw new IllegalArgumentException(StringFormatUtil.formatStrLocaleSafe("Scoped search not supported for entity of type %s", this.f214e.toString()));
        }
    }

    private ImmutableList<SuggestionGroup> m334k() {
        Builder builder = new Builder();
        builder.b = this.f215f;
        builder = builder;
        builder.a = Type.NO_GROUP;
        return ImmutableList.of(builder.a());
    }

    private ImmutableList<SuggestionGroup> m335l() {
        Builder builder = new Builder();
        builder.b = ImmutableList.copyOf(this.f213d.b.b);
        builder = builder;
        builder.a = Type.KEYWORD;
        builder = builder;
        builder.c = this.f211b.getString(m333e());
        return ImmutableList.of(builder.a());
    }

    public final void m336a(GraphSearchQuery graphSearchQuery) {
        Preconditions.checkNotNull(graphSearchQuery.h);
        this.f214e = graphSearchQuery.h;
        this.f215f = ImmutableList.of(new EmptyScopedNullStateTypeaheadUnit(this.f214e));
        if (!StringUtil.c(graphSearchQuery.b)) {
            graphSearchQuery = GraphSearchQuery.a(graphSearchQuery, "");
        }
        this.f212c.a(this);
        this.f212c.a(this);
        this.f213d = null;
        if (this.f212c.d()) {
            this.f212c.a(RegularImmutableBiMap.a);
        }
        this.f212c.b(graphSearchQuery);
    }
}

package com.facebook.search.suggestions.systems;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.graphql.calls.ExactMatchInputExactMatch;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.api.GraphSearchQuery.ModifierKeys;
import com.facebook.search.api.GraphSearchQuery.ScopedEntityType;
import com.facebook.search.api.GraphSearchQueryPlaceModifier;
import com.facebook.search.api.SearchQueryFunctions;
import com.facebook.search.model.KeywordTypeaheadUnit;
import com.facebook.search.model.KeywordTypeaheadUnit.KeywordType;
import com.facebook.search.model.KeywordTypeaheadUnit.Source;
import com.facebook.search.model.SearchBoxQueryState;
import com.facebook.search.model.SuggestionGroup;
import com.facebook.search.model.SuggestionGroup.Type;
import com.facebook.search.model.TypeaheadUnit;
import com.facebook.search.model.TypeaheadUnits;
import com.facebook.search.searchbox.GraphSearchTitleSearchBoxSupplier;
import com.facebook.search.suggestions.SuggestionsListRowItemFactory;
import com.facebook.search.suggestions.model.DividerTypeaheadUnit;
import com.facebook.ui.typeahead.FetchState;
import com.facebook.ui.typeahead.SearchResponse;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.RegularImmutableList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: viewer() { peer_to_peer_payment_enabled } */
public class SingleStateSearchTypeaheadSystem extends BaseSearchTypeaheadSystem {
    private static SingleStateSearchTypeaheadSystem f337f;
    private static final Object f338g = new Object();
    private final Resources f339a;
    private final SuggestionsListRowItemFactory f340b;
    public final GraphSearchTitleSearchBoxSupplier f341c;
    private final QeAccessor f342d;
    private final ImmutableMap<String, TypeaheadUnitProperties> f343e = ImmutableMap.of(this.f339a.getString(2131237501), new TypeaheadUnitProperties(KeywordType.keyword, this.f339a.getString(2131237504)), this.f339a.getString(2131237500), new TypeaheadUnitProperties(KeywordType.photos, this.f339a.getString(2131237503)), this.f339a.getString(2131237502), new TypeaheadUnitProperties(KeywordType.videos, this.f339a.getString(2131237505)));

    /* compiled from: viewer() { peer_to_peer_payment_enabled } */
    public class TypeaheadUnitProperties {
        public KeywordType f335a;
        public String f336b;

        public TypeaheadUnitProperties(KeywordType keywordType, String str) {
            this.f335a = keywordType;
            this.f336b = str;
        }
    }

    private static SingleStateSearchTypeaheadSystem m483b(InjectorLike injectorLike) {
        return new SingleStateSearchTypeaheadSystem(ResourcesMethodAutoProvider.a(injectorLike), SuggestionsListRowItemFactory.a(injectorLike), GraphSearchTitleSearchBoxSupplier.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public SingleStateSearchTypeaheadSystem(Resources resources, SuggestionsListRowItemFactory suggestionsListRowItemFactory, GraphSearchTitleSearchBoxSupplier graphSearchTitleSearchBoxSupplier, QeAccessor qeAccessor) {
        this.f339a = resources;
        this.f340b = suggestionsListRowItemFactory;
        this.f341c = graphSearchTitleSearchBoxSupplier;
        this.f342d = qeAccessor;
    }

    public static SingleStateSearchTypeaheadSystem m479a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SingleStateSearchTypeaheadSystem b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f338g) {
                SingleStateSearchTypeaheadSystem singleStateSearchTypeaheadSystem;
                if (a2 != null) {
                    singleStateSearchTypeaheadSystem = (SingleStateSearchTypeaheadSystem) a2.a(f338g);
                } else {
                    singleStateSearchTypeaheadSystem = f337f;
                }
                if (singleStateSearchTypeaheadSystem == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m483b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f338g, b3);
                        } else {
                            f337f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = singleStateSearchTypeaheadSystem;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ImmutableList<TypeaheadUnit> mo44a(GraphSearchQuery graphSearchQuery, SearchResponse<TypeaheadUnit> searchResponse, TypeaheadUnit typeaheadUnit, FetchState fetchState) {
        Map linkedHashMap = new LinkedHashMap();
        ImmutableList immutableList = searchResponse.b;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            TypeaheadUnit typeaheadUnit2 = (TypeaheadUnit) immutableList.get(i);
            Type k = typeaheadUnit2.k();
            if (!(k.equals(Type.ENTITY) || typeaheadUnit2.y() || (k.equals(Type.KEYWORD) && this.f343e.keySet().contains(((KeywordTypeaheadUnit) typeaheadUnit2).a().trim())))) {
                if (!linkedHashMap.containsKey(k)) {
                    linkedHashMap.put(k, new Builder());
                    if (k.equals(Type.KEYWORD)) {
                        ((Builder) linkedHashMap.get(k)).b(m480a(graphSearchQuery, TypeaheadUnits.a(typeaheadUnit2)));
                    }
                }
                ((Builder) linkedHashMap.get(k)).c(typeaheadUnit2);
            }
        }
        if (linkedHashMap.isEmpty()) {
            linkedHashMap.put(Type.KEYWORD, new Builder().b(m480a(graphSearchQuery, false)));
        }
        Builder builder = new Builder();
        Iterator it = linkedHashMap.keySet().iterator();
        while (it.hasNext()) {
            Type type = (Type) it.next();
            SuggestionGroup.Builder builder2 = new SuggestionGroup.Builder();
            builder2.a = type;
            builder2 = builder2;
            builder2.c = m481a(type);
            builder2 = builder2;
            builder2.b = ((Builder) linkedHashMap.get(type)).b();
            builder.c(builder2.a());
            if (it.hasNext()) {
                SuggestionGroup.Builder builder3 = new SuggestionGroup.Builder();
                builder3.a = Type.NO_GROUP;
                builder3 = builder3;
                builder3.b = ImmutableList.of(DividerTypeaheadUnit.f170a);
                builder.c(builder3.a());
            }
        }
        return this.f340b.a(builder.b());
    }

    public final TypeaheadUnit mo43a(GraphSearchQuery graphSearchQuery) {
        String str;
        Source source = Source.SEARCH_BUTTON;
        if (this.f341c.a == null || this.f341c.a.e == null) {
            str = "";
        } else {
            str = this.f341c.a.e.getText().toString();
        }
        return m478a(source, str.trim());
    }

    private ImmutableList<TypeaheadUnit> m480a(GraphSearchQuery graphSearchQuery, boolean z) {
        if (graphSearchQuery.h == ScopedEntityType.URL) {
            return ImmutableList.of(m478a(Source.ECHO, graphSearchQuery.b));
        }
        boolean z2 = ((GraphSearchQueryPlaceModifier) graphSearchQuery.a(ModifierKeys.PLACE)) != null && this.f342d.a(ExperimentsForSearchAbTestModule.by, false);
        if (z2) {
            return ImmutableList.of(m482b(graphSearchQuery));
        }
        if (z) {
            return RegularImmutableList.a;
        }
        Builder builder = new Builder();
        Iterator it = this.f343e.keySet().iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            builder.c(KeywordTypeaheadUnit.Builder.a(StringFormatUtil.formatStrLocaleSafe(str, graphSearchQuery.b.toLowerCase(Locale.getDefault())), ((TypeaheadUnitProperties) this.f343e.get(str)).f336b, null, false, Source.INJECTED_SUGGESTION, ((TypeaheadUnitProperties) this.f343e.get(str)).f335a));
        }
        return builder.b();
    }

    private KeywordTypeaheadUnit m482b(GraphSearchQuery graphSearchQuery) {
        String str;
        String str2 = graphSearchQuery.f;
        GraphSearchQueryPlaceModifier graphSearchQueryPlaceModifier = (GraphSearchQueryPlaceModifier) graphSearchQuery.a(ModifierKeys.PLACE);
        KeywordTypeaheadUnit.Builder builder = new KeywordTypeaheadUnit.Builder();
        builder.b = graphSearchQuery.g;
        builder = builder;
        builder.d = graphSearchQuery.g;
        builder = builder;
        if (graphSearchQueryPlaceModifier == null) {
            str = null;
        } else {
            str = graphSearchQueryPlaceModifier.b;
        }
        builder.s = str;
        KeywordTypeaheadUnit.Builder builder2 = builder;
        builder2.r = this.f339a.getString(2131237493);
        builder2 = builder2;
        builder2.t = true;
        builder2 = builder2;
        builder2.c = SearchQueryFunctions.r(graphSearchQuery.f);
        builder2 = builder2;
        builder2.e = "content";
        builder2 = builder2;
        builder2.f = ExactMatchInputExactMatch.TRUE;
        builder2 = builder2;
        builder2.g = KeywordType.local;
        builder2 = builder2;
        builder2.k = Source.ECHO;
        return builder2.b();
    }

    public final SearchBoxQueryState mo42b() {
        return SearchBoxQueryState.SINGLE_STATE;
    }

    private static KeywordTypeaheadUnit m478a(Source source, String str) {
        KeywordTypeaheadUnit.Builder builder = new KeywordTypeaheadUnit.Builder();
        builder.b = str;
        builder = builder;
        builder.d = str;
        builder = builder;
        builder.e = "content";
        builder = builder;
        builder.f = ExactMatchInputExactMatch.FALSE;
        builder = builder;
        builder.k = source;
        builder = builder;
        builder.c = SearchQueryFunctions.o(str);
        return builder.b();
    }

    @Nullable
    private String m481a(Type type) {
        if (type.equals(Type.ENTITY)) {
            return null;
        }
        return this.f339a.getString(2131237491);
    }
}

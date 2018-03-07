package com.facebook.search.suggestions.systems;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.locale.Locales;
import com.facebook.graphql.calls.ExactMatchInputExactMatch;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.api.SearchQueryFunctions;
import com.facebook.search.model.EntityTypeaheadUnit;
import com.facebook.search.model.KeywordTypeaheadUnit;
import com.facebook.search.model.KeywordTypeaheadUnit.KeywordType;
import com.facebook.search.model.KeywordTypeaheadUnit.Source;
import com.facebook.search.model.SuggestionGroup;
import com.facebook.search.model.SuggestionGroup.Type;
import com.facebook.search.model.TypeaheadUnit;
import com.facebook.search.searchbox.GraphSearchTitleSearchBoxSupplier;
import com.facebook.search.suggestions.SuggestionsListRowItemFactory;
import com.facebook.search.suggestions.model.DividerTypeaheadUnit;
import com.facebook.search.typeahead.TypeaheadUnitCollection;
import com.facebook.search.util.GraphSearchConfig;
import com.facebook.ui.typeahead.FetchState;
import com.facebook.ui.typeahead.SearchResponse;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: viewer_can_enable */
public class KeywordsOnTopSearchTypeaheadSystem extends BaseSearchTypeaheadSystem {
    private final Resources f296a;
    private final GraphSearchTitleSearchBoxSupplier f297b;
    private final SuggestionsListRowItemFactory f298c;
    private final Locales f299d;
    private final AbstractFbErrorReporter f300e;
    private final int f301f;
    private final QeAccessor f302g;
    private int f303h;
    private int f304i = 0;
    private List<KeywordTypeaheadUnit> f305j = new ArrayList();
    private List<TypeaheadUnit> f306k = new ArrayList();
    @Nullable
    private List<KeywordTypeaheadUnit> f307l;
    @Nullable
    private String f308m;

    public static KeywordsOnTopSearchTypeaheadSystem m447b(InjectorLike injectorLike) {
        return new KeywordsOnTopSearchTypeaheadSystem(ResourcesMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), GraphSearchTitleSearchBoxSupplier.a(injectorLike), SuggestionsListRowItemFactory.a(injectorLike), Locales.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public KeywordsOnTopSearchTypeaheadSystem(Resources resources, AbstractFbErrorReporter abstractFbErrorReporter, GraphSearchTitleSearchBoxSupplier graphSearchTitleSearchBoxSupplier, SuggestionsListRowItemFactory suggestionsListRowItemFactory, Locales locales, QeAccessor qeAccessor) {
        this.f296a = resources;
        this.f297b = graphSearchTitleSearchBoxSupplier;
        this.f298c = suggestionsListRowItemFactory;
        this.f300e = abstractFbErrorReporter;
        this.f299d = locales;
        this.f301f = qeAccessor.a(ExperimentsForSearchAbTestModule.J, 3);
        this.f302g = qeAccessor;
        this.f303h = this.f301f;
    }

    public final ImmutableList<TypeaheadUnit> mo44a(GraphSearchQuery graphSearchQuery, SearchResponse<TypeaheadUnit> searchResponse, TypeaheadUnit typeaheadUnit, FetchState fetchState) {
        this.f308m = this.f297b.c().trim().toLowerCase(this.f299d.a());
        if (this.f308m.length() == 1 && searchResponse.b().isEmpty()) {
            return ImmutableList.of();
        }
        Object obj;
        if (this.f304i == 1 && this.f308m.length() > 1 && this.f307l != null) {
            this.f305j = this.f307l;
            this.f307l = null;
        }
        if (searchResponse.c() > 0) {
            this.f303h = Math.max(searchResponse.c(), this.f301f);
        }
        List arrayList = new ArrayList(this.f303h);
        List arrayList2 = new ArrayList();
        Object obj2 = null;
        Map hashMap = new HashMap();
        ImmutableList b = searchResponse.b();
        int size = b.size();
        for (int i = 0; i < size; i++) {
            TypeaheadUnit typeaheadUnit2 = (TypeaheadUnit) b.get(i);
            if (typeaheadUnit2.k() == Type.KEYWORD) {
                if (typeaheadUnit2 instanceof KeywordTypeaheadUnit) {
                    KeywordTypeaheadUnit keywordTypeaheadUnit = (KeywordTypeaheadUnit) typeaheadUnit2;
                    String a = keywordTypeaheadUnit.a();
                    KeywordTypeaheadUnit keywordTypeaheadUnit2 = (KeywordTypeaheadUnit) hashMap.get(a);
                    if (keywordTypeaheadUnit2 == null) {
                        if (arrayList.size() < this.f303h) {
                            if (m444a(keywordTypeaheadUnit, this.f308m)) {
                                obj = 1;
                            } else {
                                obj = obj2;
                            }
                            hashMap.put(a, keywordTypeaheadUnit);
                            arrayList.add(keywordTypeaheadUnit);
                            obj2 = obj;
                        }
                    } else if (keywordTypeaheadUnit.D() > keywordTypeaheadUnit2.D()) {
                        arrayList.remove(keywordTypeaheadUnit2);
                        hashMap.put(a, keywordTypeaheadUnit);
                        arrayList.add(keywordTypeaheadUnit);
                    }
                }
            } else if (typeaheadUnit2.k() == Type.ENTITY) {
                arrayList2.add(typeaheadUnit2);
            }
        }
        Object obj3 = null;
        if (arrayList.isEmpty() && obj2 == null) {
            arrayList.add(m436a(graphSearchQuery, Source.ECHO, this.f308m));
            obj3 = 1;
        }
        m443a(arrayList);
        if (arrayList.size() < this.f303h && r0 == null && obj2 == null) {
            m445a(arrayList, m436a(graphSearchQuery, Source.ECHO, this.f308m));
        }
        if (arrayList.size() < this.f303h) {
            m442a(graphSearchQuery, arrayList, arrayList2, this.f303h - arrayList.size());
        }
        obj3 = (this.f304i == 1 && this.f308m.length() == 1) ? 1 : null;
        obj = this.f305j.size() == arrayList.size() ? 1 : null;
        if (!(obj3 == null || obj == null || this.f305j.isEmpty() || m448b(this.f305j))) {
            this.f307l = arrayList;
            arrayList = this.f305j;
        }
        return m441a(graphSearchQuery, this.f308m, arrayList, arrayList2, fetchState);
    }

    public final TypeaheadUnit mo43a(GraphSearchQuery graphSearchQuery) {
        return m436a(graphSearchQuery, Source.SEARCH_BUTTON, this.f297b.c().trim());
    }

    public final void mo40a() {
        this.f304i = 0;
        this.f305j.clear();
        this.f306k.clear();
        this.f307l = null;
        this.f303h = this.f301f;
    }

    public final boolean mo41a(GraphSearchQuery graphSearchQuery, TypeaheadUnitCollection typeaheadUnitCollection) {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        int i = 0;
        for (KeywordTypeaheadUnit keywordTypeaheadUnit : this.f305j) {
            if (!keywordTypeaheadUnit.x() && i < this.f303h) {
                i++;
                arrayList.add(keywordTypeaheadUnit);
            }
            i = i;
        }
        for (TypeaheadUnit typeaheadUnit : this.f306k) {
            if (!typeaheadUnit.x()) {
                arrayList2.add(typeaheadUnit);
            }
        }
        m442a(graphSearchQuery, arrayList, arrayList2, this.f303h - i);
        typeaheadUnitCollection.m529a(m441a(graphSearchQuery, this.f297b.c().trim().toLowerCase(this.f299d.a()), arrayList, arrayList2, FetchState.IDLE));
        return true;
    }

    private static boolean m445a(List<KeywordTypeaheadUnit> list, KeywordTypeaheadUnit keywordTypeaheadUnit) {
        for (KeywordTypeaheadUnit equals : list) {
            if (keywordTypeaheadUnit.equals(equals)) {
                return false;
            }
        }
        list.add(keywordTypeaheadUnit);
        return true;
    }

    private ImmutableList<TypeaheadUnit> m441a(GraphSearchQuery graphSearchQuery, String str, List<KeywordTypeaheadUnit> list, List<TypeaheadUnit> list2, FetchState fetchState) {
        if (list.isEmpty()) {
            this.f300e.a("EmptyKeywordTypeaheadError", "No keyword units available on cleanup with typeahead text: " + str);
        }
        this.f304i = str.length();
        this.f305j = list;
        this.f306k = list2;
        Builder builder = ImmutableList.builder();
        SuggestionGroup.Builder builder2 = new SuggestionGroup.Builder();
        builder2.a = Type.KEYWORD;
        builder2 = builder2;
        builder2.b = ImmutableList.copyOf(list);
        builder.c(builder2.a());
        if (!list2.isEmpty()) {
            builder2 = new SuggestionGroup.Builder();
            builder2.a = Type.NO_GROUP;
            builder2 = builder2;
            builder2.b = ImmutableList.of(DividerTypeaheadUnit.f170a);
            builder.c(builder2.a());
            builder2 = new SuggestionGroup.Builder();
            builder2.a = Type.ENTITY;
            builder2 = builder2;
            builder2.b = ImmutableList.copyOf(list2);
            builder.c(builder2.a());
        }
        builder.b(m440a(graphSearchQuery, str, fetchState, (List) list2, (List) list));
        return this.f298c.a(builder.b());
    }

    private ImmutableList<SuggestionGroup> m440a(GraphSearchQuery graphSearchQuery, String str, FetchState fetchState, List<TypeaheadUnit> list, List<KeywordTypeaheadUnit> list2) {
        if (fetchState == FetchState.ACTIVE) {
            return RegularImmutableList.a;
        }
        KeywordTypeaheadUnit keywordTypeaheadUnit = !list2.isEmpty() ? (KeywordTypeaheadUnit) list2.get(list2.size() - 1) : null;
        Object obj = (keywordTypeaheadUnit == null || !m444a(keywordTypeaheadUnit, str)) ? null : 1;
        if (list.isEmpty() && obj != null) {
            return RegularImmutableList.a;
        }
        SuggestionGroup.Builder builder = new SuggestionGroup.Builder();
        builder.a = Type.KEYWORD;
        builder = builder;
        builder.b = ImmutableList.of(m439a(graphSearchQuery, str));
        return ImmutableList.of(builder.a());
    }

    private void m442a(GraphSearchQuery graphSearchQuery, List<KeywordTypeaheadUnit> list, List<TypeaheadUnit> list2, int i) {
        int i2 = 0;
        if (i > 0) {
            if (!GraphSearchConfig.b(graphSearchQuery) || list2.isEmpty()) {
                for (TypeaheadUnit typeaheadUnit : list2) {
                    if (typeaheadUnit instanceof EntityTypeaheadUnit) {
                        EntityTypeaheadUnit entityTypeaheadUnit = (EntityTypeaheadUnit) typeaheadUnit;
                        int i3 = i - (m445a((List) list, m435a(graphSearchQuery, entityTypeaheadUnit)) ? 1 : 0);
                        if (i3 != 0) {
                            int i4;
                            if (m445a((List) list, m446b(graphSearchQuery, entityTypeaheadUnit))) {
                                i4 = 1;
                            } else {
                                i4 = 0;
                            }
                            i = i3 - i4;
                            if (i == 0) {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                }
                return;
            }
            while (i2 < i) {
                KeywordTypeaheadUnit.Builder builder = new KeywordTypeaheadUnit.Builder();
                builder.b = "";
                builder = builder;
                builder.c = "";
                builder = builder;
                builder.v = RegularImmutableList.a;
                builder = builder;
                builder.e = "";
                builder = builder;
                builder.u = true;
                list.add(builder.b());
                i2++;
            }
        }
    }

    private void m443a(List<KeywordTypeaheadUnit> list) {
        int size = list.size();
        if (size < this.f303h) {
            int size2 = this.f305j.size();
            int i = this.f303h - size;
            int i2 = size;
            while (i2 < size2 && i > 0) {
                if (i2 < size2) {
                    KeywordTypeaheadUnit keywordTypeaheadUnit = (KeywordTypeaheadUnit) this.f305j.get(i2);
                    if (this.f308m == null || !keywordTypeaheadUnit.a().trim().startsWith(this.f308m)) {
                        size = i - (m445a((List) list, m438a(keywordTypeaheadUnit)) ? 1 : 0);
                    } else {
                        size = i - (m445a((List) list, keywordTypeaheadUnit) ? 1 : 0);
                    }
                } else {
                    size = i;
                }
                i2++;
                i = size;
            }
        }
    }

    private static boolean m448b(List<? extends TypeaheadUnit> list) {
        for (TypeaheadUnit x : list) {
            if (x.x()) {
                return true;
            }
        }
        return false;
    }

    private static KeywordTypeaheadUnit m438a(KeywordTypeaheadUnit keywordTypeaheadUnit) {
        if (keywordTypeaheadUnit.x()) {
            return keywordTypeaheadUnit;
        }
        KeywordTypeaheadUnit.Builder a = KeywordTypeaheadUnit.Builder.a(keywordTypeaheadUnit);
        a.u = true;
        return a.b();
    }

    private static boolean m444a(KeywordTypeaheadUnit keywordTypeaheadUnit, String str) {
        return keywordTypeaheadUnit.a().trim().equalsIgnoreCase(str);
    }

    private KeywordTypeaheadUnit m436a(GraphSearchQuery graphSearchQuery, Source source, String str) {
        KeywordTypeaheadUnit.Builder builder = new KeywordTypeaheadUnit.Builder();
        builder.b = str;
        builder = builder;
        builder.r = this.f296a.getString(2131237499);
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
        builder = builder;
        builder.v = GraphSearchConfig.a(graphSearchQuery);
        return builder.b();
    }

    private TypeaheadUnit m439a(GraphSearchQuery graphSearchQuery, String str) {
        KeywordTypeaheadUnit.Builder a = KeywordTypeaheadUnit.Builder.a(m436a(graphSearchQuery, Source.ESCAPE, str));
        a.g = KeywordType.escape;
        a = a;
        a.r = null;
        return a.b();
    }

    private KeywordTypeaheadUnit m437a(GraphSearchQuery graphSearchQuery, String str, KeywordType keywordType) {
        KeywordTypeaheadUnit.Builder builder = new KeywordTypeaheadUnit.Builder();
        builder.b = str;
        builder = builder;
        builder.r = this.f296a.getString(2131237499);
        builder = builder;
        builder.d = str;
        builder = builder;
        builder.e = "content";
        builder = builder;
        builder.f = ExactMatchInputExactMatch.FALSE;
        builder = builder;
        builder.k = Source.INJECTED_SUGGESTION;
        builder = builder;
        builder.g = keywordType;
        builder = builder;
        builder.c = SearchQueryFunctions.o(str);
        builder = builder;
        builder.v = GraphSearchConfig.a(graphSearchQuery);
        return builder.b();
    }

    private KeywordTypeaheadUnit m435a(GraphSearchQuery graphSearchQuery, EntityTypeaheadUnit entityTypeaheadUnit) {
        return m437a(graphSearchQuery, this.f296a.getString(2131237510, new Object[]{entityTypeaheadUnit.b.toLowerCase(this.f299d.a())}), KeywordType.photos);
    }

    private KeywordTypeaheadUnit m446b(GraphSearchQuery graphSearchQuery, EntityTypeaheadUnit entityTypeaheadUnit) {
        return m437a(graphSearchQuery, this.f296a.getString(2131237511, new Object[]{entityTypeaheadUnit.b.toLowerCase(this.f299d.a())}), KeywordType.keyword);
    }
}

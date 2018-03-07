package com.facebook.search.suggestions.loader;

import com.facebook.inject.InjectorLike;
import com.facebook.search.model.EntityTypeaheadUnit;
import com.facebook.search.model.EntityTypeaheadUnit.Builder;
import com.facebook.search.model.KeywordTypeaheadUnit;
import com.facebook.search.model.TypeaheadUnit;
import com.facebook.ui.typeahead.FetchSource;
import com.facebook.ui.typeahead.TypeaheadSuggestionDeduper;
import com.google.common.base.Strings;

/* compiled from: {balance} */
public class GraphSearchTypeaheadSuggestionDeduper implements TypeaheadSuggestionDeduper<TypeaheadUnit> {
    public static GraphSearchTypeaheadSuggestionDeduper m212a(InjectorLike injectorLike) {
        return new GraphSearchTypeaheadSuggestionDeduper();
    }

    public final Object m213a(Object obj, Object obj2, FetchSource fetchSource) {
        TypeaheadUnit typeaheadUnit = (TypeaheadUnit) obj;
        TypeaheadUnit typeaheadUnit2 = (TypeaheadUnit) obj2;
        if ((typeaheadUnit instanceof EntityTypeaheadUnit) && (typeaheadUnit2 instanceof EntityTypeaheadUnit)) {
            return m210a((EntityTypeaheadUnit) typeaheadUnit, (EntityTypeaheadUnit) typeaheadUnit2, fetchSource);
        }
        if ((typeaheadUnit instanceof KeywordTypeaheadUnit) && (typeaheadUnit2 instanceof KeywordTypeaheadUnit)) {
            return m211a((KeywordTypeaheadUnit) typeaheadUnit, (KeywordTypeaheadUnit) typeaheadUnit2, fetchSource);
        }
        return typeaheadUnit;
    }

    private static TypeaheadUnit m210a(EntityTypeaheadUnit entityTypeaheadUnit, EntityTypeaheadUnit entityTypeaheadUnit2, FetchSource fetchSource) {
        boolean z = true;
        Builder a;
        if (fetchSource == FetchSource.MEMORY_CACHE) {
            a = new Builder().a(entityTypeaheadUnit);
            if (!(entityTypeaheadUnit.j || entityTypeaheadUnit2.j)) {
                z = false;
            }
            a.j = z;
            return a.p();
        } else if (entityTypeaheadUnit.j || entityTypeaheadUnit.l) {
            Builder a2 = new Builder().a(entityTypeaheadUnit2);
            a2.j = entityTypeaheadUnit.j;
            a2 = a2;
            a2.l = entityTypeaheadUnit.l;
            return a2.p();
        } else if (!entityTypeaheadUnit2.j) {
            return Strings.isNullOrEmpty(entityTypeaheadUnit.f) ? entityTypeaheadUnit2 : entityTypeaheadUnit;
        } else {
            a = new Builder().a(entityTypeaheadUnit);
            a.j = true;
            return a.p();
        }
    }

    private static TypeaheadUnit m211a(KeywordTypeaheadUnit keywordTypeaheadUnit, KeywordTypeaheadUnit keywordTypeaheadUnit2, FetchSource fetchSource) {
        boolean z = true;
        KeywordTypeaheadUnit.Builder builder;
        if (fetchSource == FetchSource.MEMORY_CACHE) {
            builder = new KeywordTypeaheadUnit.Builder();
            builder = KeywordTypeaheadUnit.Builder.a(keywordTypeaheadUnit);
            if (!(keywordTypeaheadUnit.m || keywordTypeaheadUnit2.m)) {
                z = false;
            }
            builder.m = z;
            return builder.b();
        } else if (keywordTypeaheadUnit.m) {
            builder = new KeywordTypeaheadUnit.Builder();
            builder = KeywordTypeaheadUnit.Builder.a(keywordTypeaheadUnit2);
            builder.m = true;
            return builder.b();
        } else if (!keywordTypeaheadUnit2.m) {
            return keywordTypeaheadUnit2;
        } else {
            builder = new KeywordTypeaheadUnit.Builder();
            builder = KeywordTypeaheadUnit.Builder.a(keywordTypeaheadUnit);
            builder.m = true;
            return builder.b();
        }
    }
}

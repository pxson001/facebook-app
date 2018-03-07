package com.facebook.search.suggestions;

import android.annotation.SuppressLint;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.search.abtest.SearchAbTestGatekeepers;
import com.facebook.search.model.EntityTypeaheadUnit;
import com.facebook.search.model.KeywordTypeaheadUnit;
import com.facebook.search.model.TypeaheadUnit;
import com.facebook.search.model.visitor.GetTitleOfTypeaheadSuggestionVisitor;
import com.facebook.search.util.TypeaheadPhoneticTextMatcher;
import com.facebook.search.util.TypeaheadTextMatcher;
import com.facebook.search.util.TypeaheadTextMatcherFactory;
import com.facebook.search.util.text.TextToPhoneticAndNormalizedTokensUtil;
import com.facebook.ui.typeahead.BaseSuggestionFilter;
import com.facebook.ui.typeahead.TypeaheadResponse;
import javax.inject.Inject;

/* compiled from: PHOTO */
public class QueryTextSuggestionFilter extends BaseSuggestionFilter<TypeaheadUnit> {
    private final TypeaheadTextMatcherFactory f25341a;
    private final GetTitleOfTypeaheadSuggestionVisitor f25342b;
    private final GatekeeperStoreImpl f25343c;

    public final boolean m28593a(Object obj, TypeaheadResponse typeaheadResponse, String str) {
        return m28592a((TypeaheadUnit) obj, str, typeaheadResponse.a.b);
    }

    @Inject
    public QueryTextSuggestionFilter(TypeaheadTextMatcherFactory typeaheadTextMatcherFactory, GetTitleOfTypeaheadSuggestionVisitor getTitleOfTypeaheadSuggestionVisitor, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f25341a = typeaheadTextMatcherFactory;
        this.f25342b = getTitleOfTypeaheadSuggestionVisitor;
        this.f25343c = gatekeeperStoreImpl;
    }

    private boolean m28592a(TypeaheadUnit typeaheadUnit, String str, String str2) {
        if (typeaheadUnit instanceof KeywordTypeaheadUnit) {
            return m28591a((KeywordTypeaheadUnit) typeaheadUnit, str, str2);
        }
        if (typeaheadUnit instanceof EntityTypeaheadUnit) {
            Object obj;
            EntityTypeaheadUnit entityTypeaheadUnit = (EntityTypeaheadUnit) typeaheadUnit;
            if (entityTypeaheadUnit.f22055k == null || entityTypeaheadUnit.f22055k.isEmpty()) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                return TypeaheadTextMatcher.m10674a(entityTypeaheadUnit.f22055k, this.f25341a.m10676a(str).f8936b);
            } else if (entityTypeaheadUnit.f22056l) {
                TypeaheadPhoneticTextMatcher typeaheadPhoneticTextMatcher;
                TypeaheadTextMatcherFactory typeaheadTextMatcherFactory = this.f25341a;
                if (typeaheadTextMatcherFactory.f8953e.containsKey(str)) {
                    typeaheadPhoneticTextMatcher = (TypeaheadPhoneticTextMatcher) typeaheadTextMatcherFactory.f8953e.get(str);
                } else {
                    TypeaheadPhoneticTextMatcher typeaheadPhoneticTextMatcher2 = new TypeaheadPhoneticTextMatcher((TextToPhoneticAndNormalizedTokensUtil) typeaheadTextMatcherFactory.f8950b.get(), typeaheadTextMatcherFactory.f8951c, str);
                    typeaheadTextMatcherFactory.f8953e.put(str, typeaheadPhoneticTextMatcher2);
                    typeaheadPhoneticTextMatcher = typeaheadPhoneticTextMatcher2;
                }
                TypeaheadPhoneticTextMatcher typeaheadPhoneticTextMatcher3 = typeaheadPhoneticTextMatcher;
                return TypeaheadTextMatcher.m10674a(typeaheadPhoneticTextMatcher3.f8938a.a(entityTypeaheadUnit.f22046b), typeaheadPhoneticTextMatcher3.f8939b);
            }
        }
        return this.f25341a.m10676a(str).m10665a((String) typeaheadUnit.a(this.f25342b));
    }

    @SuppressLint({"BadMethodUse-java.lang.String.length"})
    private boolean m28591a(KeywordTypeaheadUnit keywordTypeaheadUnit, String str, String str2) {
        if (str2.startsWith(str)) {
            return true;
        }
        if (!str.startsWith(str2)) {
            return false;
        }
        String a = keywordTypeaheadUnit.mo1211a();
        if (this.f25341a.m10676a(str).m10665a(a)) {
            return true;
        }
        Object substring;
        int length = str.length();
        int length2 = str2.length();
        int length3 = a.length();
        int i = keywordTypeaheadUnit.f22133v;
        if (keywordTypeaheadUnit.f22133v > 0) {
            length = (length + i) - length2;
            if (length3 < length) {
                return false;
            }
            str = str.substring(length2);
            substring = a.substring(i, length);
        } else if (length3 < length) {
            return false;
        } else {
            substring = a.substring(0, length);
        }
        if (str.equals(substring)) {
            return this.f25343c.a(SearchAbTestGatekeepers.b).asBoolean(false);
        }
        return false;
    }
}

package com.facebook.search.model;

import com.facebook.search.model.KeywordTypeaheadUnit.KeywordType;
import com.facebook.search.model.SuggestionGroup.Type;

/* compiled from: THROWBACK_FEED_EMPTY_STATE */
public class TypeaheadUnits {
    public static boolean m25795a(TypeaheadUnit typeaheadUnit) {
        if (typeaheadUnit.k() != Type.KEYWORD) {
            return false;
        }
        KeywordTypeaheadUnit keywordTypeaheadUnit = (KeywordTypeaheadUnit) typeaheadUnit;
        if (keywordTypeaheadUnit.f22118g == KeywordType.local || keywordTypeaheadUnit.f22118g == KeywordType.local_category) {
            return true;
        }
        return false;
    }
}

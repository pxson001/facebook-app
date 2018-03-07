package com.facebook.search.util;

import com.facebook.search.util.text.TextToPhoneticAndNormalizedTokensUtil;
import com.google.common.collect.ImmutableList;

/* compiled from: member_count_to_fetch */
public class TypeaheadPhoneticTextMatcher {
    public final TextToPhoneticAndNormalizedTokensUtil f8938a;
    public final ImmutableList<String> f8939b;
    private final TypeaheadTextMatcher f8940c;

    public TypeaheadPhoneticTextMatcher(TextToPhoneticAndNormalizedTokensUtil textToPhoneticAndNormalizedTokensUtil, TypeaheadTextMatcher typeaheadTextMatcher, String str) {
        this.f8938a = textToPhoneticAndNormalizedTokensUtil;
        this.f8940c = typeaheadTextMatcher;
        this.f8939b = textToPhoneticAndNormalizedTokensUtil.a(str);
    }
}

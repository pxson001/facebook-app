package com.facebook.search.util;

import com.facebook.search.util.text.TextToNormalizedWordsUtil;
import com.google.common.collect.ImmutableList;

/* compiled from: member_picker_merged_section */
public class TypeaheadNormalizedTextMatcher {
    private final TextToNormalizedWordsUtil f8935a;
    public final ImmutableList<String> f8936b;
    private final TypeaheadTextMatcher f8937c;

    public TypeaheadNormalizedTextMatcher(TextToNormalizedWordsUtil textToNormalizedWordsUtil, TypeaheadTextMatcher typeaheadTextMatcher, String str) {
        this.f8935a = textToNormalizedWordsUtil;
        this.f8937c = typeaheadTextMatcher;
        this.f8936b = textToNormalizedWordsUtil.a(str);
    }

    public final boolean m10665a(String str) {
        return TypeaheadTextMatcher.m10674a(this.f8935a.a(str), this.f8936b);
    }
}

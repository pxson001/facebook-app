package com.facebook.search.util;

import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.search.util.text.TextToNormalizedWordsUtil;
import com.facebook.search.util.text.TextToPhoneticAndNormalizedTokensUtil;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: megaphone_image_resize_mode_option */
public class TypeaheadTextMatcherFactory {
    private final TextToNormalizedWordsUtil f8949a;
    public final Lazy<TextToPhoneticAndNormalizedTokensUtil> f8950b;
    public final TypeaheadTextMatcher f8951c;
    private final Map<String, TypeaheadNormalizedTextMatcher> f8952d = new HashMap();
    public final Map<String, TypeaheadPhoneticTextMatcher> f8953e = new HashMap();

    public static TypeaheadTextMatcherFactory m10675b(InjectorLike injectorLike) {
        return new TypeaheadTextMatcherFactory(TextToNormalizedWordsUtil.b(injectorLike), IdBasedLazy.a(injectorLike, 10949), new TypeaheadTextMatcher());
    }

    @Inject
    public TypeaheadTextMatcherFactory(TextToNormalizedWordsUtil textToNormalizedWordsUtil, Lazy<TextToPhoneticAndNormalizedTokensUtil> lazy, TypeaheadTextMatcher typeaheadTextMatcher) {
        this.f8949a = textToNormalizedWordsUtil;
        this.f8950b = lazy;
        this.f8951c = typeaheadTextMatcher;
    }

    public final TypeaheadNormalizedTextMatcher m10676a(String str) {
        if (this.f8952d.containsKey(str)) {
            return (TypeaheadNormalizedTextMatcher) this.f8952d.get(str);
        }
        TypeaheadNormalizedTextMatcher typeaheadNormalizedTextMatcher = new TypeaheadNormalizedTextMatcher(this.f8949a, this.f8951c, str);
        this.f8952d.put(str, typeaheadNormalizedTextMatcher);
        return typeaheadNormalizedTextMatcher;
    }
}

package com.facebook.search.util.text;

import com.facebook.common.i18n.BreakIteratorHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.user.names.NameNormalizer;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

/* compiled from: event_sms_members */
public class TextToNormalizedWordsUtil {
    private final BreakIteratorHelper f15946a;
    private final NameNormalizer f15947b;

    public static TextToNormalizedWordsUtil m23590b(InjectorLike injectorLike) {
        return new TextToNormalizedWordsUtil(BreakIteratorHelper.a(injectorLike), NameNormalizer.b(injectorLike));
    }

    @Inject
    public TextToNormalizedWordsUtil(BreakIteratorHelper breakIteratorHelper, NameNormalizer nameNormalizer) {
        this.f15946a = breakIteratorHelper;
        this.f15947b = nameNormalizer;
    }

    public final ImmutableList<String> m23591a(String str) {
        return m23589a(this.f15946a.a(str));
    }

    public final ImmutableList<String> m23592b(String str) {
        return m23589a(ImmutableList.of(str));
    }

    private ImmutableList<String> m23589a(ImmutableList<String> immutableList) {
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            String a = this.f15947b.a((String) immutableList.get(i));
            if (!Strings.isNullOrEmpty(a)) {
                builder.c(a);
            }
        }
        return builder.b();
    }
}

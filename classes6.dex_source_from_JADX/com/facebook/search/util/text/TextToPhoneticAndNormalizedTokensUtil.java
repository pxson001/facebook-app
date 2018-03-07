package com.facebook.search.util.text;

import com.facebook.common.i18n.BreakIteratorHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.user.names.NameNormalizer;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

/* compiled from: event_sms_invitees */
public class TextToPhoneticAndNormalizedTokensUtil {
    private final BreakIteratorHelper f15948a;
    private final DoubleMetaphone f15949b;
    private final NameNormalizer f15950c;

    public static TextToPhoneticAndNormalizedTokensUtil m23593b(InjectorLike injectorLike) {
        return new TextToPhoneticAndNormalizedTokensUtil(BreakIteratorHelper.a(injectorLike), new DoubleMetaphone(), NameNormalizer.b(injectorLike));
    }

    @Inject
    public TextToPhoneticAndNormalizedTokensUtil(BreakIteratorHelper breakIteratorHelper, DoubleMetaphone doubleMetaphone, NameNormalizer nameNormalizer) {
        this.f15948a = breakIteratorHelper;
        this.f15949b = doubleMetaphone;
        this.f15950c = nameNormalizer;
    }

    public final ImmutableList<String> m23594a(String str) {
        ImmutableList a = this.f15948a.a(str);
        Builder builder = ImmutableList.builder();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            String str2 = (String) a.get(i);
            if (str2.length() >= 3) {
                builder.c(this.f15949b.m23588a(str2));
            } else {
                builder.c(this.f15950c.a(str2));
            }
        }
        return builder.b();
    }
}

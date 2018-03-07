package com.facebook.text.imagerange;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: end_time */
class TextWithImageFetcher$3 implements Function<List<TextWithImageFetcher$IconSpanDefinition>, CharSequence> {
    final /* synthetic */ CharSequence f13026a;
    final /* synthetic */ float f13027b;
    final /* synthetic */ int f13028c;
    final /* synthetic */ TextWithImageFetcher f13029d;

    TextWithImageFetcher$3(TextWithImageFetcher textWithImageFetcher, CharSequence charSequence, float f, int i) {
        this.f13029d = textWithImageFetcher;
        this.f13026a = charSequence;
        this.f13027b = f;
        this.f13028c = i;
    }

    public Object apply(@Nullable Object obj) {
        List list = (List) obj;
        Preconditions.checkNotNull(list);
        ArrayList a = Lists.a(list);
        a.removeAll(Collections.singleton(null));
        Collections.sort(a, TextWithImageFetcher.a);
        CharSequence charSequence = this.f13026a;
        int size = a.size();
        for (int i = 0; i < size; i++) {
            TextWithImageFetcher$IconSpanDefinition textWithImageFetcher$IconSpanDefinition = (TextWithImageFetcher$IconSpanDefinition) a.get(i);
            charSequence = this.f13029d.a(charSequence, textWithImageFetcher$IconSpanDefinition.f13061b, textWithImageFetcher$IconSpanDefinition.f13060a.m13903b(), this.f13027b, this.f13028c);
        }
        return charSequence;
    }
}

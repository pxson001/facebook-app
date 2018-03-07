package com.facebook.transliteration;

import com.facebook.common.i18n.StringLengthHelper;
import com.google.common.base.Preconditions;
import java.util.ArrayList;

/* compiled from: extra_composition_editing */
public class WordDetector {
    public static ExtractedWord m19105a(String str, int i) {
        int a = StringLengthHelper.a(str);
        if (a == 0) {
            return null;
        }
        if (i > a) {
            throw new IndexOutOfBoundsException();
        }
        String[] split = str.split("((?<=[^a-zA-Z])|(?=[^a-zA-Z]))");
        int length = split.length;
        ArrayList arrayList = new ArrayList(length);
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            String str2 = split[i2];
            int length2 = i3 + (str2.length() - 1);
            ExtractedWord extractedWord = new ExtractedWord(str2, i3, length2);
            arrayList.add(extractedWord);
            if (i < i3 || i > length2) {
                i3 = length2 + 1;
                i2++;
            } else if (str2.matches("[a-zA-Z]+")) {
                return extractedWord;
            } else {
                if (i2 <= 0 || !split[i2 - 1].matches("[a-zA-Z]+")) {
                    return null;
                }
                return (ExtractedWord) arrayList.get(arrayList.size() - 2);
            }
        }
        if (i != a) {
            throw new IllegalStateException();
        } else if (split[length - 1].matches("[a-zA-Z]+")) {
            return (ExtractedWord) arrayList.get(arrayList.size() - 1);
        } else {
            return null;
        }
    }

    public static ModifiedSentence m19106a(String str, ExtractedWord extractedWord, String str2) {
        int a = StringLengthHelper.a(str);
        Preconditions.checkArgument(a > 0);
        Preconditions.checkNotNull(extractedWord);
        String str3 = str.substring(0, extractedWord.f15052b) + str2;
        return new ModifiedSentence(str3 + str.substring(extractedWord.f15053c + 1, a), StringLengthHelper.a(str3));
    }
}

package com.facebook.contacts.index;

import java.text.Normalizer;
import java.text.Normalizer.Form;

/* compiled from: phoneNumbers */
public class PhoneNumberNormalizer {
    public static String m12038a(String str) {
        String normalize = Normalizer.normalize(str, Form.NFKC);
        StringBuilder stringBuilder = new StringBuilder(16);
        for (int i = 0; i < normalize.length(); i++) {
            char charAt = normalize.charAt(i);
            if (Character.isDigit(charAt) || charAt == '+') {
                stringBuilder.append(charAt);
            }
        }
        return stringBuilder.toString();
    }
}

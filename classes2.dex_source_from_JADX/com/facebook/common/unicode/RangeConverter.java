package com.facebook.common.unicode;

/* compiled from: google_app_measurement.db */
public final class RangeConverter {
    public static CodePointRange m29943a(String str, UTF16Range uTF16Range) {
        if (uTF16Range.f22086a >= 0 && uTF16Range.f22086a <= str.length() && uTF16Range.f22087b >= 0 && uTF16Range.f22086a + uTF16Range.f22087b <= str.length()) {
            return new CodePointRange(str.codePointCount(0, uTF16Range.f22086a), str.codePointCount(uTF16Range.f22086a, uTF16Range.m29947c()));
        }
        throw new IndexOutOfBoundsException("Range " + uTF16Range + " out of bounds for string: [" + str + "]");
    }

    public static UTF16Range m29945a(String str, CodePointRange codePointRange) {
        return m29944a(str, codePointRange.f22084a, codePointRange.f22085b);
    }

    public static UTF16Range m29944a(String str, int i, int i2) {
        int offsetByCodePoints = str.offsetByCodePoints(0, i);
        return new UTF16Range(offsetByCodePoints, str.offsetByCodePoints(offsetByCodePoints, i2) - offsetByCodePoints);
    }
}

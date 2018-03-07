package com.facebook.search.bootstrap.db.resolvers;

/* compiled from: existing_place_selected */
public class LevenshteinDistance {
    public static int m23433a(String str, String str2, int i) {
        if (str == null || str2 == null) {
            throw new IllegalArgumentException("Strings must not be null");
        }
        int length = str.length();
        int length2 = str2.length();
        if (length == 0) {
            return length2;
        }
        if (length2 == 0) {
            return length;
        }
        int i2;
        int[] iArr = new int[(length + 1)];
        int[] iArr2 = new int[(length + 1)];
        for (i2 = 0; i2 <= length; i2++) {
            iArr[i2] = i2;
        }
        int i3 = 1;
        int[] iArr3 = iArr2;
        while (i3 <= length2) {
            char charAt = str2.charAt(i3 - 1);
            iArr3[0] = i3;
            int i4 = i + 1;
            int i5 = 1;
            while (i5 <= length) {
                iArr3[i5] = Math.min(Math.min(iArr3[i5 - 1] + 1, iArr[i5] + 1), (str.charAt(i5 + -1) == charAt ? 0 : 1) + iArr[i5 - 1]);
                if (i4 > iArr3[i5]) {
                    i2 = iArr3[i5];
                } else {
                    i2 = i4;
                }
                i5++;
                i4 = i2;
            }
            i2 = i3 == length2 ? iArr3[length] > i ? i + 1 : iArr3[length] : i4;
            if (i2 > i) {
                return i2;
            }
            i3++;
            int[] iArr4 = iArr;
            iArr = iArr3;
            iArr3 = iArr4;
        }
        return iArr[length];
    }
}

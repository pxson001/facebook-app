package com.facebook.payments.paymentmethods.cardform;

import android.text.Editable;
import com.facebook.common.util.StringUtil;
import com.facebook.payments.paymentmethods.model.FbPaymentCardType;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

/* compiled from: tap_action */
public class PaymentMethodInputFormattingUtils {
    private static final String f1859a = ("3|" + FbPaymentCardType.AMEX.getPrefixMatchRegexPattern().pattern() + "[\\d]*");
    private static final String f1860b = ("6|60|601|64|62|622|622[19]|62212|62292|" + FbPaymentCardType.DISCOVER.getPrefixMatchRegexPattern().pattern() + "[\\d]*");
    private static final String f1861c = ("3|35|352|" + FbPaymentCardType.JCB.getPrefixMatchRegexPattern().pattern() + "[\\d]*");
    private static final String f1862d = ("5|" + FbPaymentCardType.MASTER_CARD.getPrefixMatchRegexPattern().pattern() + "[\\d]*");
    private static final String f1863e = (FbPaymentCardType.VISA.getPrefixMatchRegexPattern().pattern() + "[\\d]*");
    private static final Pattern f1864f = Pattern.compile(f1859a);
    private static final Pattern f1865g = Pattern.compile(f1860b);
    private static final Pattern f1866h = Pattern.compile(f1861c);
    private static final Pattern f1867i = Pattern.compile(f1862d);
    private static final Pattern f1868j = Pattern.compile(f1863e);

    public static FbPaymentCardType m2044a(@Nullable String str) {
        if (StringUtil.a(str)) {
            return FbPaymentCardType.UNKNOWN;
        }
        String b = m2051b(str);
        if (m2050a(b, f1868j)) {
            return FbPaymentCardType.VISA;
        }
        if (m2050a(b, f1867i)) {
            return FbPaymentCardType.MASTER_CARD;
        }
        if (m2050a(b, f1864f)) {
            return FbPaymentCardType.AMEX;
        }
        if (m2050a(b, f1866h)) {
            return FbPaymentCardType.JCB;
        }
        if (m2050a(b, f1865g)) {
            return FbPaymentCardType.DISCOVER;
        }
        return FbPaymentCardType.UNKNOWN;
    }

    private static boolean m2050a(String str, Pattern pattern) {
        return pattern.matcher(str).matches();
    }

    public static String m2051b(String str) {
        return str.replaceAll("[^\\d+]", "");
    }

    public static void m2049a(Editable editable, char c) {
        FbPaymentCardType a = m2044a(editable.toString());
        int length = editable.length();
        if (a != FbPaymentCardType.AMEX && length > 19) {
            return;
        }
        if ((a != FbPaymentCardType.AMEX || length <= 17) && length >= 5) {
            String b = m2051b(editable.toString());
            int length2 = b.length();
            StringBuilder stringBuilder = new StringBuilder(b);
            if (a != FbPaymentCardType.AMEX) {
                if (length2 > 4) {
                    stringBuilder = m2047a(stringBuilder, 4, c);
                    if (length2 > 8) {
                        stringBuilder = m2047a(stringBuilder, 9, c);
                        if (length2 > 12) {
                            stringBuilder = m2047a(stringBuilder, 14, c);
                        }
                    }
                }
            } else if (length2 > 4) {
                stringBuilder = m2047a(stringBuilder, 4, c);
                if (length2 > 10) {
                    stringBuilder = m2047a(stringBuilder, 11, c);
                }
            }
            editable.replace(0, length, stringBuilder.toString());
        }
    }

    public static StringBuilder m2047a(StringBuilder stringBuilder, int i, char c) {
        return stringBuilder.insert(i, c);
    }

    public static void m2048a(Editable editable) {
        int length = editable.length();
        if (length <= 5 && length > 0) {
            length = 0;
            while (length < editable.length()) {
                if (editable.charAt(length) < '0' || editable.charAt(length) > '9') {
                    editable.delete(length, length + 1);
                } else {
                    length++;
                }
            }
            length = editable.length();
            if ((length == 1 && editable.charAt(0) > '1') || (length == 2 && editable.charAt(0) == '1' && editable.charAt(1) > '2')) {
                editable.insert(0, "0");
            }
            if (editable.length() >= 2) {
                editable.replace(2, 2, "/");
            }
        }
    }

    public static String m2046a(FbPaymentCardType fbPaymentCardType, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        if (fbPaymentCardType == FbPaymentCardType.AMEX) {
            stringBuilder.append(m2045a(4));
            stringBuilder.append(" ");
            stringBuilder.append(m2045a(6));
            stringBuilder.append(" ");
            stringBuilder.append(m2045a(1));
        } else {
            stringBuilder.append(m2045a(4));
            stringBuilder.append(" ");
            stringBuilder.append(m2045a(4));
            stringBuilder.append(" ");
            stringBuilder.append(m2045a(4));
            stringBuilder.append(" ");
        }
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    public static String m2045a(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            stringBuilder.append("•");
        }
        return stringBuilder.toString();
    }
}

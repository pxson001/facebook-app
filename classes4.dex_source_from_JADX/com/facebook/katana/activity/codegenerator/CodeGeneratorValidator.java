package com.facebook.katana.activity.codegenerator;

import com.facebook.common.util.StringUtil;
import java.util.Locale;

/* compiled from: short_summary_graphql_text_with_entities */
public class CodeGeneratorValidator {
    public static boolean m2398a(String str) {
        if (StringUtil.c(str) || str.length() != 16) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (('A' > charAt || charAt > 'Z') && ('2' > charAt || charAt > '7')) {
                return false;
            }
        }
        return true;
    }

    public static String m2399b(String str) {
        if (StringUtil.c(str)) {
            return "";
        }
        return str.toUpperCase(Locale.US).trim().replaceAll(" ", "");
    }
}

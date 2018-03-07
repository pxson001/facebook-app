package com.fasterxml.jackson.databind;

import java.io.Serializable;

/* compiled from: client_mutation_id */
public abstract class PropertyNamingStrategy implements Serializable {
    public static final PropertyNamingStrategy f5981a = new LowerCaseWithUnderscoresStrategy();
    public static final PropertyNamingStrategy f5982b = new PascalCaseStrategy();

    /* compiled from: client_mutation_id */
    public abstract class PropertyNamingStrategyBase extends PropertyNamingStrategy {
        public abstract String mo640e(String str);

        public final String mo636a(String str) {
            return mo640e(str);
        }

        public final String mo637b(String str) {
            return mo640e(str);
        }

        public final String mo638c(String str) {
            return mo640e(str);
        }

        public final String mo639d(String str) {
            return mo640e(str);
        }
    }

    /* compiled from: client_mutation_id */
    public class LowerCaseWithUnderscoresStrategy extends PropertyNamingStrategyBase {
        public final String mo640e(String str) {
            if (str == null) {
                return str;
            }
            int length = str.length();
            StringBuilder stringBuilder = new StringBuilder(length * 2);
            int i = 0;
            Object obj = null;
            int i2 = 0;
            while (i < length) {
                Object obj2;
                char charAt = str.charAt(i);
                if (i > 0 || charAt != '_') {
                    int i3;
                    char c;
                    if (Character.isUpperCase(charAt)) {
                        if (obj == null && i2 > 0 && stringBuilder.charAt(i2 - 1) != '_') {
                            stringBuilder.append('_');
                            i2++;
                        }
                        char toLowerCase = Character.toLowerCase(charAt);
                        obj2 = 1;
                        i3 = i2;
                        c = toLowerCase;
                    } else {
                        i3 = i2;
                        c = charAt;
                        obj2 = null;
                    }
                    stringBuilder.append(c);
                    i2 = i3 + 1;
                } else {
                    obj2 = obj;
                }
                i++;
                obj = obj2;
            }
            return i2 > 0 ? stringBuilder.toString() : str;
        }
    }

    /* compiled from: client_mutation_id */
    public class PascalCaseStrategy extends PropertyNamingStrategyBase {
        public final String mo640e(String str) {
            if (str == null || str.length() == 0) {
                return str;
            }
            char charAt = str.charAt(0);
            if (Character.isUpperCase(charAt)) {
                return str;
            }
            StringBuilder stringBuilder = new StringBuilder(str);
            stringBuilder.setCharAt(0, Character.toUpperCase(charAt));
            return stringBuilder.toString();
        }
    }

    public String mo636a(String str) {
        return str;
    }

    public String mo637b(String str) {
        return str;
    }

    public String mo638c(String str) {
        return str;
    }

    public String mo639d(String str) {
        return str;
    }
}

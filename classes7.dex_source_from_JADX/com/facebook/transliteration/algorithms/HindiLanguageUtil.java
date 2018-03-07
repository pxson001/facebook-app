package com.facebook.transliteration.algorithms;

/* compiled from: extra_composition_data */
public class HindiLanguageUtil {
    public static boolean m19108a(String str, String str2) {
        char c = str.toCharArray()[str.length() - 1];
        char c2 = str2.toCharArray()[0];
        if (!(str.equals("</s>") && m19107a(c2))) {
            Object obj;
            if (c == '्') {
                obj = 1;
            } else {
                obj = null;
            }
            if (((obj == null && !m19109b(c)) || !m19109b(c2)) && !(m19107a(c) && m19107a(c2) && !m19109b(c2))) {
                if ((c >= 'ऀ' && c <= 'औ') || c == 'ऩ' || c == 'ऱ' || c == 'ऴ' || (c >= 'ऺ' && c <= 'ॿ')) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null) {
                    return false;
                }
                if (c2 == '़') {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean m19107a(char c) {
        if ((c < 'ऀ' || c > 'ः') && ((c < 'ऺ' || c > '़') && ((c < 'ा' || c > 'ॏ') && ((c < '॑' || c > 'ॗ') && (c < 'ॢ' || c > 'ॣ'))))) {
            return false;
        }
        return true;
    }

    private static boolean m19109b(char c) {
        if (c < 'ँ' || c > 'ः') {
            return false;
        }
        return true;
    }
}

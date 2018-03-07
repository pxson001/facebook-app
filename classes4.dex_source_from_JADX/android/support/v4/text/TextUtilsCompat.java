package android.support.v4.text;

import android.support.annotation.Nullable;
import java.util.Locale;

/* compiled from: profile_pic_medium_size */
public class TextUtilsCompat {
    public static final Locale f4112a = new Locale("", "");
    private static String f4113b = "Arab";
    private static String f4114c = "Hebr";

    public static int m4656a(@Nullable Locale locale) {
        if (!(locale == null || locale.equals(f4112a))) {
            String a = ICUCompat.f4115a.mo338a(ICUCompat.f4115a.mo339b(locale.toString()));
            if (a == null) {
                int i = 0;
                switch (Character.getDirectionality(locale.getDisplayName(locale).charAt(0))) {
                    case (byte) 1:
                    case (byte) 2:
                        i = 1;
                        break;
                }
                return i;
            } else if (a.equalsIgnoreCase(f4113b) || a.equalsIgnoreCase(f4114c)) {
                return 1;
            }
        }
        return 0;
    }
}

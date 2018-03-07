package com.facebook.config.versioninfo;

import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: sidebar_menu */
public class VersionStringComparator implements Comparator<String> {
    private static final Pattern f4834a = Pattern.compile("(\\d*)(\\D*)");

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m8673a((String) obj, (String) obj2);
    }

    public final int m8673a(String str, String str2) {
        String[] split = str.trim().split("\\.");
        String[] split2 = str2.trim().split("\\.");
        int max = Math.max(split.length, split2.length);
        int i = 0;
        int i2 = 0;
        while (i2 == 0 && i < max) {
            CharSequence charSequence = i < split.length ? split[i] : "";
            CharSequence charSequence2 = i < split2.length ? split2[i] : "";
            Matcher matcher = f4834a.matcher(charSequence);
            Matcher matcher2 = f4834a.matcher(charSequence2);
            int i3 = i2;
            do {
                boolean find = matcher.find();
                boolean find2 = matcher2.find();
                if (!find && !find2) {
                    break;
                }
                int a = find ? m8672a(matcher.group(1), 0) : 0;
                if (find2) {
                    i3 = m8672a(matcher2.group(1), 0);
                } else {
                    i3 = 0;
                }
                a = m8671a(a, i3);
                if (a == 0) {
                    String group = find ? matcher.group(2) : "";
                    String group2 = find2 ? matcher2.group(2) : "";
                    if (group.length() == 0 && group2.length() > 0) {
                        a = 1;
                    } else if (group2.length() == 0 && group.length() > 0) {
                        a = -1;
                    }
                    if (a == 0) {
                        i3 = group.compareTo(group2);
                        continue;
                    }
                }
                i3 = a;
                continue;
            } while (i3 == 0);
            i++;
            i2 = i3;
        }
        return i2;
    }

    private static int m8671a(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        if (i > i2) {
            return 1;
        }
        return 0;
    }

    private static int m8672a(String str, int i) {
        try {
            i = Integer.parseInt(str);
        } catch (NumberFormatException e) {
        }
        return i;
    }
}

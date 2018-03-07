package com.facebook.composer.controller;

import com.facebook.ipc.composer.intent.ComposerShareParams;
import com.facebook.ipc.composer.intent.ComposerShareParams.Builder;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

/* compiled from: has_logged_view */
public class LinkifyController {
    private static final Pattern f6325a = Pattern.compile("(?:(?:(?:(?:ht|f)tps?)://(?:(?:(?:[\\.:\\-_%@]|[^\\s!\"#%&'\\(\\)\\*,\\-\\./:;<>\\?@\\[\\\\\\]\\^_`\\{\\|\\}\\u2000-\\u206F\\u00ab\\u00bb\\uff08\\uff09])*[^\\s!\"#%&'\\(\\)\\*,\\-\\./:;<>\\?@\\[\\\\\\]\\^_`\\{\\|\\}\\u2000-\\u206F\\u00ab\\u00bb\\uff08\\uff09])|\\[(?:(?:[A-Fa-f0-9]{1,4}::?){1,7}[A-Fa-f0-9]{1,4})\\])(?::\\d+){0,1})|(?:(?:(?:(?:25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])[.]){3}(?:25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9]))(?::\\d+){0,1})|(?:\\[(?:(?:[A-Fa-f0-9]{1,4}::?){1,7}[A-Fa-f0-9]{1,4})\\](?::\\d+){0,1})|(?:(?:\\b)www\\d{0,3}[.](?:(?:(?:[\\.:\\-_%@]|[^\\s!\"#%&'\\(\\)\\*,\\-\\./:;<>\\?@\\[\\\\\\]\\^_`\\{\\|\\}\\u2000-\\u206F\\u00ab\\u00bb\\uff08\\uff09])*[^\\s!\"#%&'\\(\\)\\*,\\-\\./:;<>\\?@\\[\\\\\\]\\^_`\\{\\|\\}\\u2000-\\u206F\\u00ab\\u00bb\\uff08\\uff09])|\\[(?:(?:[A-Fa-f0-9]{1,4}::?){1,7}[A-Fa-f0-9]{1,4})\\])(?:[.][a-z]{2,4})(?::\\d+){0,1})|(?:(?:(?:(?:[\\.:\\-_%@]|[^\\s!\"#%&'\\(\\)\\*,\\-\\./:;<>\\?@\\[\\\\\\]\\^_`\\{\\|\\}\\u2000-\\u206F\\u00ab\\u00bb\\uff08\\uff09])*[^\\s!\"#%&'\\(\\)\\*,\\-\\./:;<>\\?@\\[\\\\\\]\\^_`\\{\\|\\}\\u2000-\\u206F\\u00ab\\u00bb\\uff08\\uff09])|\\[(?:(?:[A-Fa-f0-9]{1,4}::?){1,7}[A-Fa-f0-9]{1,4})\\])(?:[.][a-z]{2,4})(?::\\d+){0,1}(?=[/?#]))|(?:(?:(?:(?:[\\.:\\-_%@]|[^\\s!\"#%&'\\(\\)\\*,\\-\\./:;<>\\?@\\[\\\\\\]\\^_`\\{\\|\\}\\u2000-\\u206F\\u00ab\\u00bb\\uff08\\uff09])*[^\\s!\"#%&'\\(\\)\\*,\\-\\./:;<>\\?@\\[\\\\\\]\\^_`\\{\\|\\}\\u2000-\\u206F\\u00ab\\u00bb\\uff08\\uff09])|\\[(?:(?:[A-Fa-f0-9]{1,4}::?){1,7}[A-Fa-f0-9]{1,4})\\])[.](com|pr|org|net|edu|gov|uk|fm|ly)))", 10);
    private static final Pattern f6326b = Pattern.compile("^\\[[0-9]{1,4}:[0-9]{1,4}:[A-Fa-f0-9]{1,4}\\]", 10);
    private static final Pattern f6327c = Pattern.compile("((?:(?:(?:ht|f)tps?)://(?:(?:(?:[\\.:\\-_%@]|[^\\s!\"#%&'\\(\\)\\*,\\-\\./:;<>\\?@\\[\\\\\\]\\^_`\\{\\|\\}\\u2000-\\u206F\\u00ab\\u00bb\\uff08\\uff09])*[^\\s!\"#%&'\\(\\)\\*,\\-\\./:;<>\\?@\\[\\\\\\]\\^_`\\{\\|\\}\\u2000-\\u206F\\u00ab\\u00bb\\uff08\\uff09])|\\[(?:(?:[A-Fa-f0-9]{1,4}::?){1,7}[A-Fa-f0-9]{1,4})\\])(?::\\d+){0,1})|(?:(?:\\b)www\\d{0,3}[.](?:(?:(?:[\\.:\\-_%@]|[^\\s!\"#%&'\\(\\)\\*,\\-\\./:;<>\\?@\\[\\\\\\]\\^_`\\{\\|\\}\\u2000-\\u206F\\u00ab\\u00bb\\uff08\\uff09])*[^\\s!\"#%&'\\(\\)\\*,\\-\\./:;<>\\?@\\[\\\\\\]\\^_`\\{\\|\\}\\u2000-\\u206F\\u00ab\\u00bb\\uff08\\uff09])|\\[(?:(?:[A-Fa-f0-9]{1,4}::?){1,7}[A-Fa-f0-9]{1,4})\\])(?:[.][a-z]{2,4})(?::\\d+){0,1}))");
    private static final Pattern f6328d = Pattern.compile("[/#?]", 10);
    private static final Pattern f6329e = Pattern.compile("[\\s\\(\\)<>\\?#]", 10);
    private static final Pattern f6330f = Pattern.compile("[\\s!\"#%&'\\(\\)\\*,\\./:;<>\\?@\\[\\\\\\]\\^`\\{\\|\\}\\u00ab\\u00bb\\u2000-\\u206F\\uff08\\uff09]", 10);
    private static final Pattern f6331g = Pattern.compile("\\s\\(\\)<>");
    private static final Pattern f6332h = Pattern.compile("[\\s'\";]");

    public final ComposerShareParams m7757a(CharSequence charSequence, boolean z, ImmutableList<String> immutableList) {
        if (z || (charSequence.length() != 0 && f6332h.matcher(charSequence.subSequence(charSequence.length() - 1, charSequence.length())).find())) {
            return m7754a(charSequence, (ImmutableList) immutableList);
        }
        return null;
    }

    @VisibleForTesting
    private ComposerShareParams m7754a(CharSequence charSequence, ImmutableList<String> immutableList) {
        Matcher matcher = f6325a.matcher(charSequence);
        while (matcher.find()) {
            String a = m7756a(matcher, charSequence);
            if (a != null && !immutableList.contains(a)) {
                return Builder.a(a).b();
            }
        }
        return null;
    }

    private String m7756a(Matcher matcher, CharSequence charSequence) {
        String group = matcher.group();
        if (group.startsWith("[") && matcher.start() > 0 && Character.codePointBefore(charSequence, matcher.start()) == 64 && f6326b.matcher(group).find()) {
            return null;
        }
        int end = matcher.end();
        if (end == charSequence.length()) {
            return m7755a(group);
        }
        CharSequence stringBuffer = new StringBuffer();
        stringBuffer.appendCodePoint(Character.codePointAt(charSequence, end));
        if (!f6328d.matcher(stringBuffer).find()) {
            return m7755a(group);
        }
        int offsetByCodePoints = Character.offsetByCodePoints(charSequence, end, 1);
        int i = 0;
        int i2 = end;
        int i3 = 0;
        while (offsetByCodePoints < charSequence.length()) {
            int codePointAt = Character.codePointAt(charSequence, offsetByCodePoints);
            stringBuffer.setLength(0);
            stringBuffer.appendCodePoint(codePointAt);
            if (i != 0) {
                if (codePointAt != 40) {
                    if (codePointAt != 41) {
                        if (f6331g.matcher(stringBuffer).find()) {
                            break;
                        }
                    } else {
                        i3--;
                        if (i3 == 0) {
                            i = 0;
                            i2 = offsetByCodePoints;
                        }
                    }
                } else {
                    i3++;
                }
            } else if (codePointAt == 40) {
                i3++;
                i = 1;
            } else if (f6328d.matcher(stringBuffer).find() || !f6330f.matcher(stringBuffer).find()) {
                i2 = offsetByCodePoints;
            } else if (f6329e.matcher(stringBuffer).find()) {
                break;
            }
            offsetByCodePoints = Character.offsetByCodePoints(charSequence, offsetByCodePoints, 1);
        }
        return m7755a(group + charSequence.subSequence(end, Character.offsetByCodePoints(charSequence, i2, 1)));
    }

    private static String m7755a(@Nullable String str) {
        if (str == null || str.indexOf(64) == -1 || f6327c.matcher(str).find()) {
            return str;
        }
        return null;
    }
}

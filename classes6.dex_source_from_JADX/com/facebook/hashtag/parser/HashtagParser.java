package com.facebook.hashtag.parser;

import com.facebook.common.unicode.UTF16Range;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: mOverlayId */
public class HashtagParser {
    private static final String f10993b = ("\\p{L}\\p{Mn}\\p{Mc}" + HashtagParserConstants.f11000a);
    private static final String f10994c = (f10993b + "\\p{Nd}_");
    private static final String f10995d = ("[" + f10993b + "]");
    private static final String f10996e = ("[" + f10994c + "]");
    private static final String f10997f = ("\\A|\\z|[^&" + f10994c + "]");
    public static final Pattern f10998g = Pattern.compile("(" + f10997f + ")([#\\uff03]" + f10996e + "*" + f10995d + f10996e + "*)");
    public final CharSequence f10999a;

    public HashtagParser(CharSequence charSequence) {
        this.f10999a = charSequence;
    }

    public final List<UTF16Range> m17646a(List<UTF16Range> list) {
        Matcher matcher = f10998g.matcher(this.f10999a);
        List b = Lists.b();
        while (matcher.find()) {
            if ((matcher.end(2) - matcher.start(2)) - 1 <= 100) {
                b.add(new UTF16Range(matcher.start(2), matcher.end(2) - matcher.start(2)));
            }
        }
        Collection a = m17645a(m17645a(b, HyperlinkParser.m17650a(this.f10999a)), list);
        if (a.size() > 30) {
            a = a.subList(0, 30);
        }
        return ImmutableList.copyOf(a);
    }

    public final List<String> m17647b() {
        Matcher matcher = f10998g.matcher(this.f10999a);
        Collection a = Lists.a();
        while (matcher.find()) {
            a.add(matcher.group(2));
        }
        return ImmutableList.copyOf(a);
    }

    private static List<UTF16Range> m17645a(List<UTF16Range> list, List<UTF16Range> list2) {
        if (list2.isEmpty()) {
            return list;
        }
        List<UTF16Range> a = Lists.a(list.size());
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            Object obj;
            UTF16Range uTF16Range = (UTF16Range) list.get(i2);
            int i3 = i;
            while (i3 < list2.size()) {
                if (((UTF16Range) list2.get(i3)).c() <= uTF16Range.a) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null) {
                    break;
                }
                i3++;
            }
            if (i3 == list2.size()) {
                a.addAll(list.subList(i2, list.size()));
                return a;
            }
            UTF16Range uTF16Range2 = (UTF16Range) list2.get(i3);
            if (uTF16Range2.a >= uTF16Range.c() || uTF16Range.a >= uTF16Range2.c()) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj == null) {
                a.add(uTF16Range);
            }
            i = i3;
        }
        return a;
    }
}

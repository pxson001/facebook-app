package com.facebook.hashtag.parser;

import com.facebook.common.unicode.UTF16Range;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: mObjectId */
public class HyperlinkParser {
    public static Map<Character, Integer> f11002a = new Builder().b(Character.valueOf('<'), Integer.valueOf(1)).b(Character.valueOf('['), Integer.valueOf(2)).b(Character.valueOf('{'), Integer.valueOf(3)).b(Character.valueOf('('), Integer.valueOf(4)).b(Character.valueOf('>'), Integer.valueOf(-1)).b(Character.valueOf(']'), Integer.valueOf(-2)).b(Character.valueOf('}'), Integer.valueOf(-3)).b(Character.valueOf(')'), Integer.valueOf(-4)).b();
    public static Pattern f11003b = Pattern.compile("(?:\\[[^\\]]*:[\\da-f]|[\\p{L}\\p{M}\\p{N}\\-_]\\.[\\p{L}\\p{M}\\p{N}\\-_])");
    public static final Pattern f11004c = Pattern.compile(HyperlinkParserConstants.f11005a, 42);

    HyperlinkParser() {
    }

    public static List<UTF16Range> m17650a(CharSequence charSequence) {
        List<UTF16Range> emptyList;
        if (charSequence.length() < 4 || ((1 == 0 && charSequence.length() < 7) || ((m17649a(charSequence, '.') < 0 && m17649a(charSequence, ':') < 0) || f11003b.matcher(charSequence).matches()))) {
            emptyList = Collections.emptyList();
        } else {
            Matcher matcher = f11004c.matcher(charSequence);
            List<UTF16Range> b = Lists.b();
            while (matcher.find()) {
                int start = matcher.start();
                int end = matcher.end();
                if (start <= 0 || charSequence.charAt(start - 1) != '@') {
                    int i;
                    LinkedList b2 = Lists.b();
                    int i2 = start;
                    int i3 = start;
                    while (i2 < end) {
                        Integer num = (Integer) f11002a.get(Character.valueOf(charSequence.charAt(i2)));
                        if (num != null) {
                            if (b2.isEmpty()) {
                                i = i2;
                            } else {
                                i = i3;
                            }
                            if (num.intValue() > 0) {
                                b2.addFirst(num);
                            } else if (b2.isEmpty()) {
                                continue;
                            } else {
                                if (num.intValue() + ((Integer) b2.removeLast()).intValue() != 0) {
                                    b2.addFirst(Integer.valueOf(0));
                                    break;
                                }
                            }
                        } else {
                            i = i3;
                        }
                        i2++;
                        i3 = i;
                    }
                    i = i3;
                    if (b2.isEmpty()) {
                        b.add(new UTF16Range(start, end - start));
                    } else {
                        b.add(new UTF16Range(start, i - start));
                    }
                }
            }
            emptyList = b;
        }
        return emptyList;
    }

    public static int m17649a(CharSequence charSequence, char c) {
        for (int i = 0; i < charSequence.length(); i++) {
            if (charSequence.charAt(i) == c) {
                return i;
            }
        }
        return -1;
    }
}

package com.facebook.livephotos.exoplayer.extractor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: page_service_card_see_all */
public final class GaplessInfo {
    private static final Pattern f7025c = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    public final int f7026a;
    public final int f7027b;

    public static GaplessInfo m8898a(String str, String str2) {
        if (!"iTunSMPB".equals(str)) {
            return null;
        }
        Matcher matcher = f7025c.matcher(str2);
        if (!matcher.find()) {
            return null;
        }
        try {
            int parseInt = Integer.parseInt(matcher.group(1), 16);
            int parseInt2 = Integer.parseInt(matcher.group(2), 16);
            if (parseInt == 0 && parseInt2 == 0) {
                return null;
            }
            return new GaplessInfo(parseInt, parseInt2);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static GaplessInfo m8897a(int i) {
        int i2 = i >> 12;
        int i3 = i & 4095;
        return (i2 == 0 && i3 == 0) ? null : new GaplessInfo(i2, i3);
    }

    private GaplessInfo(int i, int i2) {
        this.f7026a = i;
        this.f7027b = i2;
    }
}

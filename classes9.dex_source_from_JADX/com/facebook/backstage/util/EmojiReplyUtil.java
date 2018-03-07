package com.facebook.backstage.util;

import com.google.common.collect.ImmutableSet;

/* compiled from: removeMembers */
public class EmojiReplyUtil {
    public static final ImmutableSet<String> f5567a = ImmutableSet.of("😁", "😍", "😂", "😳", "😱", "😕", new String[]{"😮", "💩"});

    private EmojiReplyUtil() {
    }

    public static boolean m5771a(CharSequence charSequence) {
        return f5567a.contains(charSequence);
    }
}

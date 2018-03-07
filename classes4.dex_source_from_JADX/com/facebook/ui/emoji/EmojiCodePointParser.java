package com.facebook.ui.emoji;

import com.facebook.inject.Lazy;
import com.facebook.ui.emoji.model.Emoji;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: encryptInit */
public class EmojiCodePointParser {
    private final EmojiCodePointFilter f13076a;
    private final Lazy<Emojis> f13077b;

    @Inject
    public EmojiCodePointParser(EmojiCodePointFilter emojiCodePointFilter, Lazy<Emojis> lazy) {
        this.f13076a = emojiCodePointFilter;
        this.f13077b = lazy;
    }

    @Nullable
    public final Emoji m13923a(CharSequence charSequence, int i) {
        int codePointAt = Character.codePointAt(charSequence, i);
        int charCount = Character.charCount(codePointAt);
        if (i + charCount < charSequence.length()) {
            charCount = Character.codePointAt(charSequence, i + charCount);
        } else {
            charCount = 0;
        }
        if (!EmojiCodePointFilter.a(codePointAt, charCount)) {
            return null;
        }
        List list;
        if (charCount != 8205) {
            list = null;
        } else {
            List arrayList = new ArrayList();
            int charCount2 = (Character.charCount(codePointAt) + Character.charCount(charCount)) + i;
            while (charCount2 < charSequence.length() && arrayList.size() < 6) {
                int codePointAt2 = Character.codePointAt(charSequence, charCount2);
                charCount2 += Character.charCount(codePointAt2);
                arrayList.add(Integer.valueOf(codePointAt2));
            }
            list = arrayList;
        }
        List list2 = list;
        if (list2 == null) {
            return ((Emojis) this.f13077b.get()).a(codePointAt, charCount);
        }
        Emoji emoji = null;
        while (!list2.isEmpty()) {
            emoji = ((Emojis) this.f13077b.get()).a(codePointAt, charCount, list2);
            if (emoji != null) {
                break;
            }
            list2.remove(list2.size() - 1);
        }
        return emoji;
    }
}

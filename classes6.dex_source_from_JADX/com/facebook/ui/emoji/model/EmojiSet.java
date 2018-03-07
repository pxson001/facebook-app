package com.facebook.ui.emoji.model;

import com.google.common.base.Preconditions;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: credential_response */
public final class EmojiSet {
    public final int f18351a;
    public final int f18352b;
    @Nullable
    public final List<Emoji> f18353c;
    public final Type f18354d;

    /* compiled from: credential_response */
    public enum Type {
        PREDEFINED,
        RECENTLY_USED
    }

    public static EmojiSet m26965a(int i, int i2, List<Emoji> list) {
        Preconditions.checkNotNull(list);
        return new EmojiSet(i, i2, list, Type.PREDEFINED);
    }

    private EmojiSet(int i, int i2, List<Emoji> list, Type type) {
        this.f18351a = i;
        this.f18352b = i2;
        this.f18353c = list;
        this.f18354d = type;
    }
}

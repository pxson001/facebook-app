package com.facebook.messaging.customthreads;

import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.messages.Message;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: settings/dataandstorage */
public class CustomThreadsEmojiLike {
    private final Provider<Boolean> f2365a;

    public static CustomThreadsEmojiLike m2583b(InjectorLike injectorLike) {
        return new CustomThreadsEmojiLike(IdBasedProvider.a(injectorLike, 4144));
    }

    @Inject
    public CustomThreadsEmojiLike(Provider<Boolean> provider) {
        this.f2365a = provider;
    }

    public final boolean m2584a(Message message) {
        return m2585b(message) != null;
    }

    @Nullable
    public final String m2585b(Message message) {
        if (!((Boolean) this.f2365a.get()).booleanValue()) {
            return null;
        }
        String str = (String) message.v.get("hot_emoji_size");
        return str == null ? (String) message.v.get("emoji_like") : str;
    }

    public static CustomThreadsEmojiLike m2582a(InjectorLike injectorLike) {
        return m2583b(injectorLike);
    }
}

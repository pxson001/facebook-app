package com.facebook.messaging.chatheads.ipc;

import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.prefs.counters.UiCounters;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: shared_preferences_not_initialized */
public class ChatHeadsMuteStateManager {
    public final UiCounters f2243a;
    public final Clock f2244b;
    public final Provider<Boolean> f2245c;

    public static ChatHeadsMuteStateManager m2473b(InjectorLike injectorLike) {
        return new ChatHeadsMuteStateManager(UiCounters.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 4136));
    }

    @Inject
    public ChatHeadsMuteStateManager(UiCounters uiCounters, Clock clock, Provider<Boolean> provider) {
        this.f2243a = uiCounters;
        this.f2244b = clock;
        this.f2245c = provider;
    }

    public static ChatHeadsMuteStateManager m2472a(InjectorLike injectorLike) {
        return m2473b(injectorLike);
    }

    public final void m2474b(@Nullable ThreadKey threadKey) {
        if (threadKey != null) {
            this.f2243a.d("chat_head_mute_state", threadKey.g());
        }
    }
}

package com.facebook.messaging.chatheads.prefs;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: is_unread */
public class Boolean_IsChatHeadsNYConfettiGlobeEnabledMethodAutoProvider extends AbstractProvider<Boolean> {
    private static Boolean m18906b(InjectorLike injectorLike) {
        return ChatHeadsPrefsModule.m18908a(IsChatHeadsNYConfettiGlobeEnabledProvider.m18914a(injectorLike));
    }

    public Object get() {
        return ChatHeadsPrefsModule.m18908a(IsChatHeadsNYConfettiGlobeEnabledProvider.m18914a(this));
    }
}

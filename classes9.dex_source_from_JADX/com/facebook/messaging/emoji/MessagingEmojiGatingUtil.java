package com.facebook.messaging.emoji;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.prefs.omnistore.MessengerOmnistoreUserPrefs;
import com.facebook.messaging.prefs.omnistore.MessengerOmnistoreUserPrefsKey;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.ui.emoji.data.EmojisDataMethodAutoProvider;
import com.facebook.ui.emoji.data.FacebookEmojisData;
import javax.inject.Inject;

/* compiled from: male */
public class MessagingEmojiGatingUtil {
    private FacebookEmojisData f10979a;
    private FbSharedPreferences f10980b;
    private GatekeeperStoreImpl f10981c;
    private MessengerOmnistoreUserPrefs f10982d;

    public static MessagingEmojiGatingUtil m11390b(InjectorLike injectorLike) {
        return new MessagingEmojiGatingUtil(EmojisDataMethodAutoProvider.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), MessengerOmnistoreUserPrefs.a(injectorLike));
    }

    @Inject
    public MessagingEmojiGatingUtil(FacebookEmojisData facebookEmojisData, FbSharedPreferences fbSharedPreferences, GatekeeperStoreImpl gatekeeperStoreImpl, MessengerOmnistoreUserPrefs messengerOmnistoreUserPrefs) {
        this.f10979a = facebookEmojisData;
        this.f10980b = fbSharedPreferences;
        this.f10981c = gatekeeperStoreImpl;
        this.f10982d = messengerOmnistoreUserPrefs;
    }

    public final boolean m11392a() {
        return m11391f() && this.f10981c.a(229, false);
    }

    public final boolean m11393b() {
        return m11391f() && this.f10981c.a(257, false);
    }

    public final boolean m11394c() {
        boolean z = m11391f() && this.f10981c.a(210, false) && !this.f10982d.b(MessengerOmnistoreUserPrefsKey.EMOJI_COLOR_PREF).isPresent() && !this.f10980b.a(EmojiPrefKeys.e, false);
        return this.f10980b.a(EmojiPrefKeys.f, false) || z;
    }

    public final boolean m11395d() {
        boolean z = m11391f() && this.f10981c.a(210, false) && !this.f10982d.b(MessengerOmnistoreUserPrefsKey.EMOJI_COLOR_PREF).isPresent() && !this.f10980b.a(EmojiPrefKeys.g, false);
        return this.f10980b.a(EmojiPrefKeys.h, false) || z;
    }

    public final boolean m11396e() {
        return m11391f() && this.f10981c.a(212, false);
    }

    private boolean m11391f() {
        FacebookEmojisData facebookEmojisData = this.f10979a;
        return 1 == 0;
    }
}

package com.facebook.messaging.audio.composer;

import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: original_fbid */
public class AudioComposerPrefKeys {
    private static final PrefKey f8029a;
    private static final PrefKey f8030b;

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("audio_composer/");
        f8029a = prefKey;
        f8030b = (PrefKey) prefKey.a("open/");
    }

    public static PrefKey m8296a(ThreadKey threadKey) {
        return (PrefKey) f8030b.a(threadKey.toString());
    }
}

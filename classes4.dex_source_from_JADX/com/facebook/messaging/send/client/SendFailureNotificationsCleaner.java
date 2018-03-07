package com.facebook.messaging.send.client;

import com.facebook.common.init.INeedInit;
import com.facebook.common.time.SystemClock;
import com.facebook.messaging.prefs.MessagingPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.PrefKey;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: mOwnerId */
public class SendFailureNotificationsCleaner implements INeedInit {
    private final FbSharedPreferences f8594a;
    private final SystemClock f8595b;

    @Inject
    public SendFailureNotificationsCleaner(FbSharedPreferences fbSharedPreferences, SystemClock systemClock) {
        this.f8594a = fbSharedPreferences;
        this.f8595b = systemClock;
    }

    public void init() {
        if (this.f8594a.a()) {
            ImmutableList of = ImmutableList.of(MessagingPrefKeys.aS, MessagingPrefKeys.aQ, MessagingPrefKeys.aR);
            long a = this.f8595b.a();
            int size = of.size();
            for (int i = 0; i < size; i++) {
                PrefKey prefKey = (PrefKey) of.get(i);
                long a2 = a - this.f8594a.a(prefKey, 0);
                if (a2 < 0 || a2 > 3600000) {
                    this.f8594a.edit().a(prefKey).commit();
                }
            }
        }
    }
}

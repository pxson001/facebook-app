package com.facebook.messaging.giftwrap;

import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.prefs.MessagingPrefKeys;
import com.facebook.prefs.shared.PrefKey;

/* compiled from: mSendPaymentBankDetails */
public class GiftWrapPrefKeys {
    public static final PrefKey f11120a;
    public static final PrefKey f11121b = ((PrefKey) f11122c.a("show_entry_points"));
    private static final PrefKey f11122c;

    static {
        PrefKey prefKey = (PrefKey) MessagingPrefKeys.c.a("giftwrap/");
        f11122c = prefKey;
        f11120a = (PrefKey) prefKey.a("unwrapped/");
    }

    public static PrefKey m11499a(Message message) {
        return message.n != null ? (PrefKey) f11120a.a(message.n) : (PrefKey) f11120a.a(message.a);
    }
}

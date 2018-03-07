package com.facebook.messaging.ephemeral;

import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageUtil;
import com.facebook.messaging.model.threadkey.ThreadKey;
import javax.inject.Inject;

/* compiled from: set-downloaded-packs */
public class EphemeralProgressUtil {
    private final Clock f2463a;

    public static EphemeralProgressUtil m2737b(InjectorLike injectorLike) {
        return new EphemeralProgressUtil((Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public EphemeralProgressUtil(Clock clock) {
        this.f2463a = clock;
    }

    public final int m2739a(Message message) {
        if (m2738d(message)) {
            return Integer.MAX_VALUE;
        }
        long intValue;
        if (!ThreadKey.g(message.b)) {
            intValue = (message.c + ((long) message.J.intValue())) - this.f2463a.a();
        } else if (message.K == null || message.K.longValue() <= 0) {
            intValue = (long) message.J.intValue();
        } else {
            intValue = message.K.longValue() - this.f2463a.a();
        }
        if (intValue > 0) {
            return (int) intValue;
        }
        return 0;
    }

    public static EphemeralProgressUtil m2735a(InjectorLike injectorLike) {
        return m2737b(injectorLike);
    }

    public static long m2736b(Message message) {
        if (m2738d(message)) {
            return 2147483647L;
        }
        return 1000;
    }

    public final boolean m2740c(Message message) {
        return !m2738d(message) && m2739a(message) <= 0;
    }

    public static boolean m2738d(Message message) {
        return !MessageUtil.V(message) || MessageUtil.a(message) || MessageUtil.b(message) || message.J.intValue() == 1;
    }
}

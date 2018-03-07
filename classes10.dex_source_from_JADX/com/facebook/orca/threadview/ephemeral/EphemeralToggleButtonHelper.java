package com.facebook.orca.threadview.ephemeral;

import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.ephemeral.ModifyThreadEphemeralityHelper;
import com.facebook.messaging.ephemeral.analytics.EphemeralAnalyticsLogger;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.sounds.MessengerSoundUtil;
import javax.inject.Inject;

/* compiled from: matched_contacts_param */
public class EphemeralToggleButtonHelper {
    private final EphemeralAnalyticsLogger f8166a;
    private final MessengerSoundUtil f8167b;
    private final ModifyThreadEphemeralityHelper f8168c;

    public static EphemeralToggleButtonHelper m8081b(InjectorLike injectorLike) {
        return new EphemeralToggleButtonHelper(EphemeralAnalyticsLogger.b(injectorLike), MessengerSoundUtil.a(injectorLike), ModifyThreadEphemeralityHelper.b(injectorLike));
    }

    @Inject
    public EphemeralToggleButtonHelper(EphemeralAnalyticsLogger ephemeralAnalyticsLogger, MessengerSoundUtil messengerSoundUtil, ModifyThreadEphemeralityHelper modifyThreadEphemeralityHelper) {
        this.f8166a = ephemeralAnalyticsLogger;
        this.f8167b = messengerSoundUtil;
        this.f8168c = modifyThreadEphemeralityHelper;
    }

    public final void m8082a(final EphemeralToggleButton ephemeralToggleButton, final ThreadSummary threadSummary) {
        ephemeralToggleButton.setEphemeralModeWithAnimation(!threadSummary.h());
        this.f8166a.a.a(new HoneyClientEvent("ephemeral_toggle"));
        m8080a(threadSummary);
        this.f8168c.e = new Object(this) {
            final /* synthetic */ EphemeralToggleButtonHelper f8165c;

            public final void m8078a() {
                ephemeralToggleButton.m8077a();
                ephemeralToggleButton.setSelected(threadSummary.h());
            }
        };
        this.f8168c.a(threadSummary);
    }

    public static EphemeralToggleButtonHelper m8079a(InjectorLike injectorLike) {
        return m8081b(injectorLike);
    }

    private void m8080a(ThreadSummary threadSummary) {
        if (threadSummary.h()) {
            this.f8167b.p();
        } else {
            this.f8167b.o();
        }
    }
}

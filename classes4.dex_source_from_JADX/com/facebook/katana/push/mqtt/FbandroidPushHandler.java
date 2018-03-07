package com.facebook.katana.push.mqtt;

import com.facebook.notifications.common.JewelCounters;
import com.facebook.notifications.common.JewelCounters.Jewel;
import com.facebook.notifications.util.InboxJewelCountSourceController;
import javax.inject.Inject;

/* compiled from: fetchTaggedStickerIdsParams */
public class FbandroidPushHandler {
    public final JewelCounters f11686a;
    private final InboxJewelCountSourceController f11687b;

    @Inject
    public FbandroidPushHandler(JewelCounters jewelCounters, InboxJewelCountSourceController inboxJewelCountSourceController) {
        this.f11686a = jewelCounters;
        this.f11687b = inboxJewelCountSourceController;
    }

    public final void m12233a(int i, int i2) {
        JewelCounters jewelCounters = this.f11686a;
        Jewel jewel = Jewel.INBOX;
        if (!this.f11687b.m8009a()) {
            i2 = i;
        }
        jewelCounters.a(jewel, i2);
    }
}

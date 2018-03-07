package com.facebook.placetips.bootstrap.event;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.placetips.bootstrap.PresenceDescription;
import com.google.common.base.Optional;

/* compiled from: top_of_feed */
public class PlaceTipsPresenceChangedEvent extends PlaceTipsEvent implements PlaceTipsPresenceEvent {
    public final Optional<PresenceDescription> f2415a;
    public final Optional<PresenceDescription> f2416b;

    public PlaceTipsPresenceChangedEvent(Optional<PresenceDescription> optional, Optional<PresenceDescription> optional2) {
        this.f2415a = optional;
        this.f2416b = optional2;
    }

    public final Optional<PresenceDescription> mo658d() {
        return this.f2416b;
    }

    public final String mo657a() {
        Object h;
        String str = "PulsarPresenceChanged\n\tfrom: %s\n\tto: %s";
        if (this.f2415a.isPresent()) {
            h = ((PresenceDescription) this.f2415a.get()).h();
        } else {
            String str2 = "null";
        }
        return StringFormatUtil.formatStrLocaleSafe(str, h, this.f2416b.isPresent() ? ((PresenceDescription) this.f2416b.get()).h() : "null");
    }
}

package com.facebook.placetips.bootstrap.event;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.placetips.bootstrap.PresenceDescription;
import com.google.common.base.Optional;

/* compiled from: too_many */
public class PlaceTipsPresenceStayedTheSameEvent extends PlaceTipsEvent implements PlaceTipsPresenceEvent {
    private final Optional<PresenceDescription> f2418a;

    public PlaceTipsPresenceStayedTheSameEvent(Optional<PresenceDescription> optional) {
        this.f2418a = optional;
    }

    public final Optional<PresenceDescription> mo658d() {
        return this.f2418a;
    }

    public final String mo657a() {
        return StringFormatUtil.formatStrLocaleSafe("Pulsar presence stayed the same: %s", this.f2418a.isPresent() ? ((PresenceDescription) this.f2418a.get()).h() : "null");
    }
}

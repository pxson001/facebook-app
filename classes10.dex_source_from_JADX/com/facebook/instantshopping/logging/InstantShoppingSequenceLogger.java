package com.facebook.instantshopping.logging;

import com.facebook.sequencelogger.AbstractSequenceDefinition;
import com.facebook.sequencelogger.Sequence;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.google.common.collect.ImmutableMap;

/* compiled from: Shift_JIS */
public abstract class InstantShoppingSequenceLogger {
    public SequenceLogger f23520a;
    public AbstractSequenceDefinition f23521b;
    public Sequence f23522c;

    private Sequence m24846b() {
        if (this.f23521b != null) {
            return this.f23520a.e(this.f23521b);
        }
        return null;
    }

    public final void m24848b(String str) {
        m24849b(str, null);
    }

    public final void m24847a(String str, ImmutableMap<String, String> immutableMap) {
        this.f23522c = m24846b();
        if (this.f23522c == null && this.f23521b != null) {
            this.f23522c = this.f23520a.a(this.f23521b);
        }
        if (this.f23522c != null) {
            SequenceLoggerDetour.a(this.f23522c, str, null, immutableMap, 1799066955);
        }
    }

    public final void m24849b(String str, ImmutableMap<String, String> immutableMap) {
        this.f23522c = m24846b();
        if (this.f23522c != null && this.f23522c.f(str)) {
            SequenceLoggerDetour.b(this.f23522c, str, null, immutableMap, -1807167537);
        }
    }

    public final void m24850c(String str) {
        this.f23522c = m24846b();
        if (this.f23522c != null && this.f23522c.f(str)) {
            SequenceLoggerDetour.d(this.f23522c, str, 1339290792);
        }
    }
}

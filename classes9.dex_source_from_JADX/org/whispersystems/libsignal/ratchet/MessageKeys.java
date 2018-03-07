package org.whispersystems.libsignal.ratchet;

import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: action_set_primary */
public class MessageKeys {
    public final SecretKeySpec f21339a;
    public final SecretKeySpec f21340b;
    public final IvParameterSpec f21341c;
    public final int f21342d;

    public MessageKeys(SecretKeySpec secretKeySpec, SecretKeySpec secretKeySpec2, IvParameterSpec ivParameterSpec, int i) {
        this.f21339a = secretKeySpec;
        this.f21340b = secretKeySpec2;
        this.f21341c = ivParameterSpec;
        this.f21342d = i;
    }

    public final SecretKeySpec m21888a() {
        return this.f21339a;
    }

    public final SecretKeySpec m21889b() {
        return this.f21340b;
    }

    public final IvParameterSpec m21890c() {
        return this.f21341c;
    }

    public final int m21891d() {
        return this.f21342d;
    }
}

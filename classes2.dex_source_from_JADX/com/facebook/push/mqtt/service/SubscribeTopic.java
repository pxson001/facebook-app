package com.facebook.push.mqtt.service;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

/* compiled from: iorg_external_url_safe_mode_prompt */
public class SubscribeTopic {
    public final String f19455a;
    public final int f19456b;

    public SubscribeTopic(String str, int i) {
        this.f19455a = (String) Preconditions.checkNotNull(str);
        this.f19456b = ((Integer) Preconditions.checkNotNull(Integer.valueOf(i))).intValue();
    }

    public final String m27138a() {
        return this.f19455a;
    }

    public String toString() {
        return this.f19455a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SubscribeTopic subscribeTopic = (SubscribeTopic) obj;
        if (Objects.equal(this.f19455a, subscribeTopic.f19455a) && this.f19456b == subscribeTopic.f19456b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(this.f19455a, Integer.valueOf(this.f19456b));
    }
}

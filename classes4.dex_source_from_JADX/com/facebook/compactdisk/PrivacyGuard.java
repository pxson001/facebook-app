package com.facebook.compactdisk;

import android.content.Context;
import android.content.SharedPreferences;
import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
/* compiled from: max_peak_ms */
public class PrivacyGuard {
    private String f8184a;
    private SharedPreferences f8185b;

    public PrivacyGuard(Context context) {
        this.f8185b = context.getSharedPreferences("CompactDisk", 0);
    }

    @DoNotStrip
    public synchronized String getUUID() {
        if (this.f8184a == null) {
            this.f8184a = this.f8185b.getString("UUID", null);
            if (this.f8184a == null) {
                this.f8184a = SafeUUIDGenerator.a().toString();
                this.f8185b.edit().putString("UUID", this.f8184a).apply();
            }
        }
        return this.f8184a;
    }

    @DoNotStrip
    public synchronized void purgeUUID() {
        this.f8184a = null;
        this.f8185b.edit().remove("UUID").apply();
    }
}

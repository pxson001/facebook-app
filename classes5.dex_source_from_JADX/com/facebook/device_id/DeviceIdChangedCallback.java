package com.facebook.device_id;

import javax.annotation.Nullable;

/* compiled from: scheduled_start_time */
public interface DeviceIdChangedCallback {

    /* compiled from: scheduled_start_time */
    public enum ChangeType {
        FB_SYNC("fb_sync"),
        REGENERATE("regenerate"),
        GLOBAL_SYNC("global_sync");
        
        private String mType;

        private ChangeType(String str) {
            this.mType = str;
        }

        public final String type() {
            return this.mType;
        }
    }

    void m4059a(UniqueDeviceId uniqueDeviceId, UniqueDeviceId uniqueDeviceId2, ChangeType changeType, @Nullable String str);
}

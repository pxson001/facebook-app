package com.facebook.notifications.sync;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.util.concurrent.SettableFuture;

/* compiled from: min_messenger_version_for_secure_browser_share_from_chrome */
public class NotificationsSyncConstants {
    public static final PrefKey f7689a;
    public static final PrefKey f7690b;
    static final ImmutableMap<SyncSource, SyncType> f7691c = new Builder().b(SyncSource.COLD_START, SyncType.FULL).b(SyncSource.PULL_TO_REFRESH, SyncType.FULL).b(SyncSource.BACKGROUND, SyncType.FULL).b(SyncSource.MQTT_FULL, SyncType.FULL).b(SyncSource.MQTT_NEW, SyncType.NEW_NOTIFICATIONS).b(SyncSource.PUSH, SyncType.NEW_NOTIFICATIONS).b(SyncSource.PAGES, SyncType.FULL).b(SyncSource.PAGES_COUNT_CHANGED, SyncType.NEW_NOTIFICATIONS).b(SyncSource.GROUPS, SyncType.NEW_NOTIFICATIONS).b(SyncSource.FRAGMENT_LOADED, SyncType.FULL).b(SyncSource.CONNECTIVITY, SyncType.FULL).b(SyncSource.UNKNOWN, SyncType.NEW_NOTIFICATIONS).b();
    static final SettableFuture f7692d;

    /* compiled from: min_messenger_version_for_secure_browser_share_from_chrome */
    public enum SyncSource {
        COLD_START("cold_start"),
        PULL_TO_REFRESH("pull_to_refresh"),
        BACKGROUND("background"),
        MQTT_FULL("mqtt"),
        MQTT_NEW("mqtt"),
        PUSH("push"),
        SCROLL("scroll"),
        PAGES("pages"),
        PAGES_COUNT_CHANGED("pages_count_changed"),
        GROUPS("groups"),
        FRAGMENT_LOADED("fragment_loaded"),
        CONNECTIVITY("connectivity"),
        UNKNOWN("unknown");
        
        public final String name;

        private SyncSource(String str) {
            this.name = str;
        }

        public final String toString() {
            return this.name;
        }

        public static SyncSource fromString(String str) {
            if (str == null) {
                return UNKNOWN;
            }
            for (SyncSource syncSource : values()) {
                if (syncSource.name.equals(str)) {
                    return syncSource;
                }
            }
            return UNKNOWN;
        }
    }

    /* compiled from: min_messenger_version_for_secure_browser_share_from_chrome */
    public enum SyncType {
        FULL,
        NEW_NOTIFICATIONS
    }

    /* compiled from: min_messenger_version_for_secure_browser_share_from_chrome */
    public class NotificationsSyncPolicyException extends Exception {
        public NotificationsSyncPolicyException() {
            super("Notifications sync failed due to sync manager policy");
        }
    }

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("notifications/");
        f7689a = prefKey;
        f7690b = (PrefKey) prefKey.a("notifications_mqtt_sync_interval");
        SettableFuture f = SettableFuture.f();
        f7692d = f;
        f.a(new NotificationsSyncPolicyException());
    }
}

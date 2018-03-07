package com.facebook.presence;

/* compiled from: mqtt_notifications_fetch_seen_state */
public enum PresenceManager$PresenceDownloadState {
    MQTT_DISCONNECTED,
    MQTT_CONNECTED_WAITING_FOR_PRESENCE,
    PRESENCE_MAP_RECEIVED,
    TP_DISABLED,
    TP_WAITING_FOR_FULL_LIST,
    TP_FULL_LIST_RECEIVED
}

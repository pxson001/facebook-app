package com.facebook.push.mqtt.service;

import com.google.common.base.Objects;

/* compiled from: heisman_camera_intent_data */
public class StickySubscribeTopic {
    public final SubscribeTopic f10762a;
    public final SubscribeWhen f10763b;
    public final String f10764c;

    /* compiled from: heisman_camera_intent_data */
    public enum SubscribeWhen {
        SUBSCRIBE_ALWAYS,
        SUBSCRIBE_ON_DEVICE_USE
    }

    public StickySubscribeTopic(SubscribeTopic subscribeTopic, SubscribeWhen subscribeWhen, String str) {
        this.f10762a = subscribeTopic;
        this.f10763b = subscribeWhen;
        this.f10764c = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        StickySubscribeTopic stickySubscribeTopic = (StickySubscribeTopic) obj;
        if (Objects.equal(this.f10764c, stickySubscribeTopic.f10764c) && Objects.equal(this.f10763b, stickySubscribeTopic.f10763b) && Objects.equal(this.f10762a, stickySubscribeTopic.f10762a)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f10764c, this.f10763b, this.f10762a});
    }

    public String toString() {
        return Objects.toStringHelper(this).add("topic", this.f10762a).add("subscribeWhen", this.f10763b).add("category", this.f10764c).toString();
    }
}

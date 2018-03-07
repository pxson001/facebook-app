package com.facebook.sounds;

import java.util.Map;

/* compiled from: event_rsvp_subscribe */
public class SoundResourceStore {
    private final Map<String, Integer> f15970a;

    public SoundResourceStore(Map<String, Integer> map) {
        this.f15970a = map;
    }

    public final Integer m23605a(String str) {
        Integer num = (Integer) this.f15970a.get(str);
        if (num == null) {
            return Integer.valueOf(0);
        }
        return num;
    }
}

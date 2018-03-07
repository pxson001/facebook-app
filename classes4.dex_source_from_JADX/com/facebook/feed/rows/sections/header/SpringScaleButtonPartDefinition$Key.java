package com.facebook.feed.rows.sections.header;

import com.facebook.feed.rows.core.persistence.ContextStateKey;

/* compiled from: native_settings_launched */
public class SpringScaleButtonPartDefinition$Key implements ContextStateKey<String, SpringScaleButtonPartDefinition$SpringState> {
    private final String f7288a;

    public SpringScaleButtonPartDefinition$Key(String str) {
        this.f7288a = SpringScaleButtonPartDefinition.class + str;
    }

    public final Object m7603b() {
        return this.f7288a;
    }

    public final Object m7602a() {
        return new SpringScaleButtonPartDefinition$SpringState();
    }
}

package com.facebook.components.fb.widget;

import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.springs.Spring;
import com.facebook.widget.springbutton.SpringFactory;

/* compiled from: creative_cam_back */
public class TouchSpringIconComponentSpec$Key implements ContextStateKey<String, Spring> {
    private final String f16662a;
    private final SpringFactory f16663b;

    public TouchSpringIconComponentSpec$Key(String str, SpringFactory springFactory) {
        this.f16662a = TouchSpringIconComponentSpec.class + str;
        this.f16663b = springFactory;
    }

    public final Object m20701b() {
        return this.f16662a;
    }

    public final Object m20700a() {
        return this.f16663b.a();
    }
}

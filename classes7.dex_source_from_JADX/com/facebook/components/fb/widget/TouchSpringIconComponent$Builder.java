package com.facebook.components.fb.widget;

import android.graphics.drawable.Drawable;
import com.facebook.components.Component;
import com.facebook.components.Component.Builder;
import com.facebook.components.ComponentContext;
import com.facebook.components.reference.Reference;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* compiled from: creative_cam_front */
public class TouchSpringIconComponent$Builder extends Builder<TouchSpringIconComponent> {
    TouchSpringIconComponent$State f16651a;
    final /* synthetic */ TouchSpringIconComponent f16652b;
    private String[] f16653c = new String[]{"environment", "id", "scope", "drawable"};
    private int f16654d = 4;
    private BitSet f16655e = new BitSet(this.f16654d);

    public TouchSpringIconComponent$Builder(TouchSpringIconComponent touchSpringIconComponent) {
        this.f16652b = touchSpringIconComponent;
    }

    public static void m20692a(TouchSpringIconComponent$Builder touchSpringIconComponent$Builder, ComponentContext componentContext, int i, TouchSpringIconComponent$State touchSpringIconComponent$State) {
        super.a(componentContext, i, touchSpringIconComponent$State);
        touchSpringIconComponent$Builder.f16651a = touchSpringIconComponent$State;
        touchSpringIconComponent$Builder.f16655e.clear();
    }

    public final TouchSpringIconComponent$Builder m20694a(E e) {
        this.f16651a.f16656a = e;
        this.f16655e.set(0);
        return this;
    }

    public final TouchSpringIconComponent$Builder m20696a(String str) {
        this.f16651a.f16657b = str;
        this.f16655e.set(1);
        return this;
    }

    public final TouchSpringIconComponent$Builder m20695a(CacheableEntity cacheableEntity) {
        this.f16651a.f16658c = cacheableEntity;
        this.f16655e.set(2);
        return this;
    }

    public final TouchSpringIconComponent$Builder m20693a(Reference<Drawable> reference) {
        this.f16651a.f16660e = reference;
        this.f16655e.set(3);
        return this;
    }

    public final Component<TouchSpringIconComponent> m20698d() {
        int i = 0;
        if (this.f16655e == null || this.f16655e.nextClearBit(0) >= this.f16654d) {
            TouchSpringIconComponent$State touchSpringIconComponent$State = this.f16651a;
            m20697a();
            return touchSpringIconComponent$State;
        }
        List arrayList = new ArrayList();
        while (i < this.f16654d) {
            if (!this.f16655e.get(i)) {
                arrayList.add(this.f16653c[i]);
            }
            i++;
        }
        throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
    }

    protected final void m20697a() {
        super.a();
        this.f16651a = null;
        this.f16652b.c.a(this);
    }
}

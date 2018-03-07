package com.facebook.components;

import android.support.annotation.StyleRes;

/* compiled from: gametime_ref */
public final class Layout {
    private Layout() {
    }

    public static ComponentLayout$Builder m30715a(ComponentContext componentContext, Component<?> component, @StyleRes int i) {
        return componentContext.m30447a((Component) component, i);
    }

    public static ComponentLayout$Builder m30714a(ComponentContext componentContext, Component<?> component) {
        return m30715a(componentContext, component, 0);
    }
}

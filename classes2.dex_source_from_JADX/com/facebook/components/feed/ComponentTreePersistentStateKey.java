package com.facebook.components.feed;

import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentTree;
import com.facebook.components.ComponentTree.Builder;
import com.facebook.components.ComponentsLogger;
import com.facebook.components.ComponentsPools;
import com.facebook.components.fb.logger.QPLComponentsLogger;
import com.facebook.feed.rows.core.persistence.ContextStateKey;

/* compiled from: gc_ms */
public class ComponentTreePersistentStateKey implements ContextStateKey<String, ComponentTree> {
    private final String f22729a;
    private final Component<?> f22730b;
    private final ComponentContext f22731c;
    private final QPLComponentsLogger f22732d;
    private final String f22733e;

    public ComponentTreePersistentStateKey(String str, String str2, ComponentContext componentContext, Component<?> component, ComponentsLogger componentsLogger) {
        this.f22729a = str + str2;
        this.f22731c = componentContext;
        this.f22730b = component;
        this.f22732d = componentsLogger;
        this.f22733e = str2;
    }

    public final Object mo2130a() {
        Builder a = ComponentsPools.m30512a(this.f22731c, this.f22730b);
        a.f22737d = true;
        a = a;
        a.f22741h = this.f22732d;
        a = a;
        a.f22742i = this.f22733e;
        return a.m30701b();
    }

    public final Object mo2131b() {
        return this.f22729a;
    }
}

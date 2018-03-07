package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.databind.deser.SettableAnyProperty;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;

/* compiled from: cid */
public abstract class PropertyValue {
    public final PropertyValue f6041a;
    public final Object f6042b;

    /* compiled from: cid */
    final class Any extends PropertyValue {
        final SettableAnyProperty f6043c;
        final String f6044d;

        public Any(PropertyValue propertyValue, Object obj, SettableAnyProperty settableAnyProperty, String str) {
            super(propertyValue, obj);
            this.f6043c = settableAnyProperty;
            this.f6044d = str;
        }

        public final void mo661a(Object obj) {
            this.f6043c.m10963a(obj, this.f6044d, this.f6042b);
        }
    }

    /* compiled from: cid */
    final class Map extends PropertyValue {
        final Object f6045c;

        public Map(PropertyValue propertyValue, Object obj, Object obj2) {
            super(propertyValue, obj);
            this.f6045c = obj2;
        }

        public final void mo661a(Object obj) {
            ((java.util.Map) obj).put(this.f6045c, this.f6042b);
        }
    }

    /* compiled from: cid */
    final class Regular extends PropertyValue {
        final SettableBeanProperty f6046c;

        public Regular(PropertyValue propertyValue, Object obj, SettableBeanProperty settableBeanProperty) {
            super(propertyValue, obj);
            this.f6046c = settableBeanProperty;
        }

        public final void mo661a(Object obj) {
            this.f6046c.mo649a(obj, this.f6042b);
        }
    }

    public abstract void mo661a(Object obj);

    protected PropertyValue(PropertyValue propertyValue, Object obj) {
        this.f6041a = propertyValue;
        this.f6042b = obj;
    }
}

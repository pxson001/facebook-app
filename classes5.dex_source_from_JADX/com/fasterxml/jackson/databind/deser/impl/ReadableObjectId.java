package com.fasterxml.jackson.databind.deser.impl;

/* compiled from: ci_pymk */
public class ReadableObjectId {
    public final Object f6054a;
    public Object f6055b;

    public ReadableObjectId(Object obj) {
        this.f6054a = obj;
    }

    public final void m11109a(Object obj) {
        if (this.f6055b != null) {
            throw new IllegalStateException("Already had POJO for id (" + this.f6054a.getClass().getName() + ") [" + this.f6054a + "]");
        }
        this.f6055b = obj;
    }
}

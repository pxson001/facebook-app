package com.facebook.rebound;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: face_detection_tracker */
public class BaseSpringSystem {
    private final Map<String, Spring> f15419a = new HashMap();
    public final Set<Spring> f15420b = new CopyOnWriteArraySet();
    private final SpringLooper f15421c;
    private final CopyOnWriteArraySet<Object> f15422d = new CopyOnWriteArraySet();
    public boolean f15423e = true;

    public BaseSpringSystem(SpringLooper springLooper) {
        if (springLooper == null) {
            throw new IllegalArgumentException("springLooper is required");
        }
        this.f15421c = springLooper;
        this.f15421c.f15409a = this;
    }

    public final Spring m23035a() {
        Spring spring = new Spring(this);
        m23034a(spring);
        return spring;
    }

    private void m23034a(Spring spring) {
        if (spring == null) {
            throw new IllegalArgumentException("spring is required");
        } else if (this.f15419a.containsKey(spring.f15429d)) {
            throw new IllegalArgumentException("spring is already registered");
        } else {
            this.f15419a.put(spring.f15429d, spring);
        }
    }

    public final void m23036a(double d) {
        Iterator it = this.f15422d.iterator();
        while (it.hasNext()) {
            it.next();
        }
        for (Spring spring : this.f15420b) {
            Object obj;
            if (spring.m23055e() && spring.f15435j) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                spring.m23057f(d / 1000.0d);
            } else {
                this.f15420b.remove(spring);
            }
        }
        if (this.f15420b.isEmpty()) {
            this.f15423e = true;
        }
        it = this.f15422d.iterator();
        while (it.hasNext()) {
            it.next();
        }
        if (this.f15423e) {
            this.f15421c.mo1218c();
        }
    }

    public final void m23037a(String str) {
        Spring spring = (Spring) this.f15419a.get(str);
        if (spring == null) {
            throw new IllegalArgumentException("springId " + str + " does not reference a registered spring");
        }
        this.f15420b.add(spring);
        if (this.f15423e) {
            this.f15423e = false;
            this.f15421c.mo1217b();
        }
    }
}

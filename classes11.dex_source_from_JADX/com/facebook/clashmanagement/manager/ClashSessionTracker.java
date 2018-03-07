package com.facebook.clashmanagement.manager;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: keyId */
class ClashSessionTracker {
    private final ClashLocation f5916a;
    @GuardedBy("this")
    private final PriorityQueue<ClashUnitState> f5917b = new PriorityQueue();
    @GuardedBy("this")
    private final Map<ClashUnit, ClashUnitState> f5918c = new HashMap();

    /* compiled from: keyId */
    class ClashUnitState implements Comparable<ClashUnitState> {
        ClashUnitBase f5913a;
        int f5914b;
        int f5915c;

        public /* synthetic */ int compareTo(Object obj) {
            return m7331a((ClashUnitState) obj);
        }

        public ClashUnitState(ClashUnitBase clashUnitBase, int i, int i2) {
            this.f5913a = clashUnitBase;
            this.f5914b = i;
            this.f5915c = i2;
        }

        private int m7331a(ClashUnitState clashUnitState) {
            if (this.f5914b == clashUnitState.f5914b) {
                return this.f5915c - clashUnitState.f5915c;
            }
            return this.f5914b - clashUnitState.f5914b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ClashUnitState clashUnitState = (ClashUnitState) obj;
            if (this.f5913a.equals(clashUnitState.f5913a) && m7331a(clashUnitState) == 0) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.f5913a.hashCode();
        }
    }

    ClashSessionTracker(ClashLocation clashLocation) {
        this.f5916a = clashLocation;
    }

    final synchronized void m7334a(ClashUnitBase clashUnitBase, int i) {
        ClashUnitState clashUnitState = (ClashUnitState) this.f5918c.get(clashUnitBase);
        if (clashUnitState == null) {
            clashUnitState = new ClashUnitState(clashUnitBase, 0, i);
            this.f5917b.add(clashUnitState);
            this.f5918c.put(clashUnitBase, clashUnitState);
        } else if (clashUnitState.f5915c != i) {
            this.f5917b.remove(clashUnitState);
            clashUnitState.f5915c = i;
            this.f5917b.add(clashUnitState);
        }
    }

    final synchronized void m7333a(ClashUnitBase clashUnitBase) {
        ClashUnitState clashUnitState = (ClashUnitState) this.f5918c.get(clashUnitBase);
        if (clashUnitState != null) {
            this.f5917b.remove(clashUnitState);
            this.f5918c.remove(clashUnitBase);
        }
    }

    final synchronized Set<String> m7332a() {
        Set<String> hashSet;
        hashSet = new HashSet();
        for (ClashUnitState clashUnitState : this.f5918c.values()) {
            hashSet.add(clashUnitState.f5913a.a() + ":" + clashUnitState.f5915c);
        }
        return hashSet;
    }
}

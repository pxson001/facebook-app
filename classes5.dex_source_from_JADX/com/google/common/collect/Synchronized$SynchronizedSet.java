package com.google.common.collect;

import java.util.Collection;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: bug_report_retry_upload_success */
public class Synchronized$SynchronizedSet<E> extends Synchronized$SynchronizedCollection<E> implements Set<E> {
    /* synthetic */ Collection mo990b() {
        return mo1001a();
    }

    /* synthetic */ Object mo991c() {
        return mo1001a();
    }

    Synchronized$SynchronizedSet(Set<E> set, @Nullable Object obj) {
        super(set, obj);
    }

    Set<E> mo1001a() {
        return (Set) super.mo990b();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        boolean equals;
        synchronized (this.mutex) {
            equals = mo1001a().equals(obj);
        }
        return equals;
    }

    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = mo1001a().hashCode();
        }
        return hashCode;
    }
}

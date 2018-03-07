package com.google.common.collect;

import com.google.common.collect.Multiset.Entry;
import java.util.Collection;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: bug_report_retry_upload_success */
class Synchronized$SynchronizedMultiset<E> extends Synchronized$SynchronizedCollection<E> implements Multiset<E> {
    transient Set<E> f7573a;
    transient Set<Entry<E>> f7574b;

    final /* synthetic */ Collection mo990b() {
        return m13684e();
    }

    final /* synthetic */ Object mo991c() {
        return m13684e();
    }

    Synchronized$SynchronizedMultiset(Multiset<E> multiset, @Nullable Object obj) {
        super(multiset, obj);
    }

    private Multiset<E> m13684e() {
        return (Multiset) super.mo990b();
    }

    public final int m13685a(Object obj) {
        int a;
        synchronized (this.mutex) {
            a = m13684e().a(obj);
        }
        return a;
    }

    public final int m13686a(E e, int i) {
        int a;
        synchronized (this.mutex) {
            a = m13684e().a(e, i);
        }
        return a;
    }

    public final int m13689b(Object obj, int i) {
        int b;
        synchronized (this.mutex) {
            b = m13684e().b(obj, i);
        }
        return b;
    }

    public final int m13691c(E e, int i) {
        int c;
        synchronized (this.mutex) {
            c = m13684e().c(e, i);
        }
        return c;
    }

    public final boolean m13688a(E e, int i, int i2) {
        boolean a;
        synchronized (this.mutex) {
            a = m13684e().a(e, i, i2);
        }
        return a;
    }

    public final Set<E> m13693d() {
        Set<E> set;
        synchronized (this.mutex) {
            if (this.f7573a == null) {
                this.f7573a = Synchronized.c(m13684e().d(), this.mutex);
            }
            set = this.f7573a;
        }
        return set;
    }

    public final Set<Entry<E>> m13687a() {
        Set<Entry<E>> set;
        synchronized (this.mutex) {
            if (this.f7574b == null) {
                this.f7574b = Synchronized.c(m13684e().a(), this.mutex);
            }
            set = this.f7574b;
        }
        return set;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        boolean equals;
        synchronized (this.mutex) {
            equals = m13684e().equals(obj);
        }
        return equals;
    }

    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = m13684e().hashCode();
        }
        return hashCode;
    }
}

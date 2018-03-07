package com.google.protobuf;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;

/* compiled from: amountFBDiscount */
public class LazyField {
    private final MessageLite f20951a;
    private final ExtensionRegistryLite f20952b;
    public ByteString f20953c;
    public volatile MessageLite f20954d;
    public volatile boolean f20955e = false;

    /* compiled from: amountFBDiscount */
    public class LazyEntry<K> implements Entry<K, Object> {
        public Entry<K, LazyField> f20949a;

        public LazyEntry(Entry<K, LazyField> entry) {
            this.f20949a = entry;
        }

        public K getKey() {
            return this.f20949a.getKey();
        }

        public Object getValue() {
            LazyField lazyField = (LazyField) this.f20949a.getValue();
            if (lazyField == null) {
                return null;
            }
            return lazyField.m21377a();
        }

        public Object setValue(Object obj) {
            if (obj instanceof MessageLite) {
                LazyField lazyField = (LazyField) this.f20949a.getValue();
                MessageLite messageLite = (MessageLite) obj;
                MessageLite messageLite2 = lazyField.f20954d;
                lazyField.f20954d = messageLite;
                lazyField.f20953c = null;
                lazyField.f20955e = true;
                return messageLite2;
            }
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
    }

    /* compiled from: amountFBDiscount */
    public class LazyIterator<K> implements Iterator<Entry<K, Object>> {
        private Iterator<Entry<K, Object>> f20950a;

        public LazyIterator(Iterator<Entry<K, Object>> it) {
            this.f20950a = it;
        }

        public boolean hasNext() {
            return this.f20950a.hasNext();
        }

        public Object next() {
            Entry entry = (Entry) this.f20950a.next();
            if (entry.getValue() instanceof LazyField) {
                return new LazyEntry(entry);
            }
            return entry;
        }

        public void remove() {
            this.f20950a.remove();
        }
    }

    public LazyField(MessageLite messageLite, ExtensionRegistryLite extensionRegistryLite, ByteString byteString) {
        this.f20951a = messageLite;
        this.f20952b = extensionRegistryLite;
        this.f20953c = byteString;
    }

    public final MessageLite m21377a() {
        m21376d();
        return this.f20954d;
    }

    public final ByteString m21378c() {
        if (!this.f20955e) {
            return this.f20953c;
        }
        synchronized (this) {
            if (this.f20955e) {
                this.f20953c = this.f20954d.mo851d();
                this.f20955e = false;
                ByteString byteString = this.f20953c;
                return byteString;
            }
            byteString = this.f20953c;
            return byteString;
        }
    }

    public int hashCode() {
        m21376d();
        return this.f20954d.hashCode();
    }

    public boolean equals(Object obj) {
        m21376d();
        return this.f20954d.equals(obj);
    }

    public String toString() {
        m21376d();
        return this.f20954d.toString();
    }

    private void m21376d() {
        if (this.f20954d == null) {
            synchronized (this) {
                if (this.f20954d != null) {
                    return;
                }
                try {
                    if (this.f20953c != null) {
                        this.f20954d = (MessageLite) this.f20951a.mo857i().m20169b(this.f20953c, this.f20952b);
                    }
                } catch (IOException e) {
                }
            }
        }
    }
}

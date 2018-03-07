package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Sets.ImprovedAbstractSet;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: business_info */
public class LinkedListMultimap<K, V> extends AbstractMultimap<K, V> implements ListMultimap<K, V>, Serializable {
    public transient Node<K, V> f7416a;
    public transient Node<K, V> f7417b;
    public transient Map<K, KeyList<K, V>> f7418c = Maps.c();
    public transient int f7419d;
    public transient int f7420e;

    /* compiled from: business_info */
    class DistinctKeyIterator implements Iterator<K> {
        final Set<K> f7390a = Sets.a(this.f7394e.p().size());
        Node<K, V> f7391b = this.f7394e.f7416a;
        Node<K, V> f7392c;
        int f7393d = this.f7394e.f7420e;
        final /* synthetic */ LinkedListMultimap f7394e;

        public DistinctKeyIterator(LinkedListMultimap linkedListMultimap) {
            this.f7394e = linkedListMultimap;
        }

        private void m13476a() {
            if (this.f7394e.f7420e != this.f7393d) {
                throw new ConcurrentModificationException();
            }
        }

        public boolean hasNext() {
            m13476a();
            return this.f7391b != null;
        }

        public K next() {
            m13476a();
            LinkedListMultimap.m13486i(this.f7391b);
            this.f7392c = this.f7391b;
            this.f7390a.add(this.f7392c.f7398a);
            do {
                this.f7391b = this.f7391b.f7400c;
                if (this.f7391b == null) {
                    break;
                }
            } while (!this.f7390a.add(this.f7391b.f7398a));
            return this.f7392c.f7398a;
        }

        public void remove() {
            m13476a();
            CollectPreconditions.a(this.f7392c != null);
            LinkedListMultimap.m13485h(this.f7394e, this.f7392c.f7398a);
            this.f7392c = null;
            this.f7393d = this.f7394e.f7420e;
        }
    }

    /* compiled from: business_info */
    class KeyList<K, V> {
        Node<K, V> f7395a;
        Node<K, V> f7396b;
        int f7397c = 1;

        KeyList(Node<K, V> node) {
            this.f7395a = node;
            this.f7396b = node;
        }
    }

    /* compiled from: business_info */
    public final class Node<K, V> extends AbstractMapEntry<K, V> {
        final K f7398a;
        public V f7399b;
        Node<K, V> f7400c;
        Node<K, V> f7401d;
        Node<K, V> f7402e = null;
        Node<K, V> f7403f = null;

        Node(@Nullable K k, @Nullable V v) {
            this.f7398a = k;
            this.f7399b = v;
        }

        public final K getKey() {
            return this.f7398a;
        }

        public final V getValue() {
            return this.f7399b;
        }

        public final V setValue(@Nullable V v) {
            V v2 = this.f7399b;
            this.f7399b = v;
            return v2;
        }
    }

    /* compiled from: business_info */
    public class NodeIterator implements ListIterator<Entry<K, V>> {
        int f7404a;
        Node<K, V> f7405b;
        public Node<K, V> f7406c;
        Node<K, V> f7407d;
        int f7408e = this.f7409f.f7420e;
        final /* synthetic */ LinkedListMultimap f7409f;

        public /* synthetic */ Object next() {
            return m13478b();
        }

        public /* synthetic */ Object previous() {
            return m13479c();
        }

        NodeIterator(LinkedListMultimap linkedListMultimap, int i) {
            this.f7409f = linkedListMultimap;
            int f = linkedListMultimap.m13492f();
            Preconditions.checkPositionIndex(i, f);
            int i2;
            if (i < f / 2) {
                this.f7405b = linkedListMultimap.f7416a;
                while (true) {
                    i2 = i - 1;
                    if (i <= 0) {
                        break;
                    }
                    m13478b();
                    i = i2;
                }
            } else {
                this.f7407d = linkedListMultimap.f7417b;
                this.f7404a = f;
                while (true) {
                    i2 = i + 1;
                    if (i >= f) {
                        break;
                    }
                    m13479c();
                    i = i2;
                }
            }
            this.f7406c = null;
        }

        private void m13477a() {
            if (this.f7409f.f7420e != this.f7408e) {
                throw new ConcurrentModificationException();
            }
        }

        public boolean hasNext() {
            m13477a();
            return this.f7405b != null;
        }

        private Node<K, V> m13478b() {
            m13477a();
            LinkedListMultimap.m13486i(this.f7405b);
            Node node = this.f7405b;
            this.f7406c = node;
            this.f7407d = node;
            this.f7405b = this.f7405b.f7400c;
            this.f7404a++;
            return this.f7406c;
        }

        public void remove() {
            m13477a();
            CollectPreconditions.a(this.f7406c != null);
            if (this.f7406c != this.f7405b) {
                this.f7407d = this.f7406c.f7401d;
                this.f7404a--;
            } else {
                this.f7405b = this.f7406c.f7400c;
            }
            LinkedListMultimap.m13482a(this.f7409f, this.f7406c);
            this.f7406c = null;
            this.f7408e = this.f7409f.f7420e;
        }

        public boolean hasPrevious() {
            m13477a();
            return this.f7407d != null;
        }

        private Node<K, V> m13479c() {
            m13477a();
            LinkedListMultimap.m13486i(this.f7407d);
            Node node = this.f7407d;
            this.f7406c = node;
            this.f7405b = node;
            this.f7407d = this.f7407d.f7401d;
            this.f7404a--;
            return this.f7406c;
        }

        public int nextIndex() {
            return this.f7404a;
        }

        public int previousIndex() {
            return this.f7404a - 1;
        }

        public void set(Object obj) {
            throw new UnsupportedOperationException();
        }

        public void add(Object obj) {
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: business_info */
    public class ValueForKeyIterator implements ListIterator<V> {
        final Object f7410a;
        int f7411b;
        Node<K, V> f7412c;
        Node<K, V> f7413d;
        Node<K, V> f7414e;
        final /* synthetic */ LinkedListMultimap f7415f;

        public ValueForKeyIterator(LinkedListMultimap linkedListMultimap, @Nullable Object obj) {
            this.f7415f = linkedListMultimap;
            this.f7410a = obj;
            KeyList keyList = (KeyList) linkedListMultimap.f7418c.get(obj);
            this.f7412c = keyList == null ? null : keyList.f7395a;
        }

        public ValueForKeyIterator(LinkedListMultimap linkedListMultimap, @Nullable Object obj, int i) {
            this.f7415f = linkedListMultimap;
            KeyList keyList = (KeyList) linkedListMultimap.f7418c.get(obj);
            int i2 = keyList == null ? 0 : keyList.f7397c;
            Preconditions.checkPositionIndex(i, i2);
            int i3;
            if (i < i2 / 2) {
                this.f7412c = keyList == null ? null : keyList.f7395a;
                while (true) {
                    i3 = i - 1;
                    if (i <= 0) {
                        break;
                    }
                    next();
                    i = i3;
                }
            } else {
                this.f7414e = keyList == null ? null : keyList.f7396b;
                this.f7411b = i2;
                while (true) {
                    i3 = i + 1;
                    if (i >= i2) {
                        break;
                    }
                    previous();
                    i = i3;
                }
            }
            this.f7410a = obj;
            this.f7413d = null;
        }

        public boolean hasNext() {
            return this.f7412c != null;
        }

        public V next() {
            LinkedListMultimap.m13486i(this.f7412c);
            Node node = this.f7412c;
            this.f7413d = node;
            this.f7414e = node;
            this.f7412c = this.f7412c.f7402e;
            this.f7411b++;
            return this.f7413d.f7399b;
        }

        public boolean hasPrevious() {
            return this.f7414e != null;
        }

        public V previous() {
            LinkedListMultimap.m13486i(this.f7414e);
            Node node = this.f7414e;
            this.f7413d = node;
            this.f7412c = node;
            this.f7414e = this.f7414e.f7403f;
            this.f7411b--;
            return this.f7413d.f7399b;
        }

        public int nextIndex() {
            return this.f7411b;
        }

        public int previousIndex() {
            return this.f7411b - 1;
        }

        public void remove() {
            CollectPreconditions.a(this.f7413d != null);
            if (this.f7413d != this.f7412c) {
                this.f7414e = this.f7413d.f7403f;
                this.f7411b--;
            } else {
                this.f7412c = this.f7413d.f7402e;
            }
            LinkedListMultimap.m13482a(this.f7415f, this.f7413d);
            this.f7413d = null;
        }

        public void set(V v) {
            Preconditions.checkState(this.f7413d != null);
            this.f7413d.f7399b = v;
        }

        public void add(V v) {
            this.f7414e = LinkedListMultimap.m13480a(this.f7415f, this.f7410a, v, this.f7412c);
            this.f7411b++;
            this.f7413d = null;
        }
    }

    public final /* synthetic */ Collection m13490c(@Nullable Object obj) {
        return m13487a(obj);
    }

    public final /* synthetic */ Collection m13491d(@Nullable Object obj) {
        return m13489b(obj);
    }

    public final /* synthetic */ Collection m13497i() {
        return m13483c();
    }

    public final /* synthetic */ Collection m13498k() {
        return m13484e();
    }

    public static <K, V> LinkedListMultimap<K, V> m13481a() {
        return new LinkedListMultimap();
    }

    LinkedListMultimap() {
    }

    public static Node m13480a(@Nullable LinkedListMultimap linkedListMultimap, @Nullable Object obj, @Nullable Object obj2, Node node) {
        Node node2 = new Node(obj, obj2);
        if (linkedListMultimap.f7416a == null) {
            linkedListMultimap.f7417b = node2;
            linkedListMultimap.f7416a = node2;
            linkedListMultimap.f7418c.put(obj, new KeyList(node2));
            linkedListMultimap.f7420e++;
        } else if (node == null) {
            linkedListMultimap.f7417b.f7400c = node2;
            node2.f7401d = linkedListMultimap.f7417b;
            linkedListMultimap.f7417b = node2;
            r0 = (KeyList) linkedListMultimap.f7418c.get(obj);
            if (r0 == null) {
                linkedListMultimap.f7418c.put(obj, new KeyList(node2));
                linkedListMultimap.f7420e++;
            } else {
                r0.f7397c++;
                Node node3 = r0.f7396b;
                node3.f7402e = node2;
                node2.f7403f = node3;
                r0.f7396b = node2;
            }
        } else {
            r0 = (KeyList) linkedListMultimap.f7418c.get(obj);
            r0.f7397c++;
            node2.f7401d = node.f7401d;
            node2.f7403f = node.f7403f;
            node2.f7400c = node;
            node2.f7402e = node;
            if (node.f7403f == null) {
                ((KeyList) linkedListMultimap.f7418c.get(obj)).f7395a = node2;
            } else {
                node.f7403f.f7402e = node2;
            }
            if (node.f7401d == null) {
                linkedListMultimap.f7416a = node2;
            } else {
                node.f7401d.f7400c = node2;
            }
            node.f7401d = node2;
            node.f7403f = node2;
        }
        linkedListMultimap.f7419d++;
        return node2;
    }

    public static void m13482a(LinkedListMultimap linkedListMultimap, Node node) {
        if (node.f7401d != null) {
            node.f7401d.f7400c = node.f7400c;
        } else {
            linkedListMultimap.f7416a = node.f7400c;
        }
        if (node.f7400c != null) {
            node.f7400c.f7401d = node.f7401d;
        } else {
            linkedListMultimap.f7417b = node.f7401d;
        }
        if (node.f7403f == null && node.f7402e == null) {
            ((KeyList) linkedListMultimap.f7418c.remove(node.f7398a)).f7397c = 0;
            linkedListMultimap.f7420e++;
        } else {
            KeyList keyList = (KeyList) linkedListMultimap.f7418c.get(node.f7398a);
            keyList.f7397c--;
            if (node.f7403f == null) {
                keyList.f7395a = node.f7402e;
            } else {
                node.f7403f.f7402e = node.f7402e;
            }
            if (node.f7402e == null) {
                keyList.f7396b = node.f7403f;
            } else {
                node.f7402e.f7403f = node.f7403f;
            }
        }
        linkedListMultimap.f7419d--;
    }

    public static void m13485h(@Nullable LinkedListMultimap linkedListMultimap, Object obj) {
        Iterators.h(new ValueForKeyIterator(linkedListMultimap, obj));
    }

    public static void m13486i(@Nullable Object obj) {
        if (obj == null) {
            throw new NoSuchElementException();
        }
    }

    public final int m13492f() {
        return this.f7419d;
    }

    public final boolean m13501n() {
        return this.f7416a == null;
    }

    public final boolean m13493f(@Nullable Object obj) {
        return this.f7418c.containsKey(obj);
    }

    public final boolean m13495g(@Nullable Object obj) {
        return m13483c().contains(obj);
    }

    public final boolean m13488a(@Nullable K k, @Nullable V v) {
        m13480a(this, k, v, null);
        return true;
    }

    public final List<V> m13489b(@Nullable Object obj) {
        List<V> unmodifiableList = Collections.unmodifiableList(Lists.a(new ValueForKeyIterator(this, obj)));
        m13485h(this, obj);
        return unmodifiableList;
    }

    public final void m13494g() {
        this.f7416a = null;
        this.f7417b = null;
        this.f7418c.clear();
        this.f7419d = 0;
        this.f7420e++;
    }

    public final List<V> m13487a(@Nullable final K k) {
        return new AbstractSequentialList<V>(this) {
            final /* synthetic */ LinkedListMultimap f7384b;

            public int size() {
                KeyList keyList = (KeyList) this.f7384b.f7418c.get(k);
                return keyList == null ? 0 : keyList.f7397c;
            }

            public ListIterator<V> listIterator(int i) {
                return new ValueForKeyIterator(this.f7384b, k, i);
            }
        };
    }

    final Set<K> m13496h() {
        return new ImprovedAbstractSet<K>(this) {
            final /* synthetic */ LinkedListMultimap f7386a;

            {
                this.f7386a = r1;
            }

            public int size() {
                return this.f7386a.f7418c.size();
            }

            public Iterator<K> iterator() {
                return new DistinctKeyIterator(this.f7386a);
            }

            public boolean contains(Object obj) {
                return this.f7386a.m13493f(obj);
            }

            public boolean remove(Object obj) {
                return !this.f7386a.m13489b(obj).isEmpty();
            }
        };
    }

    private List<V> m13483c() {
        return (List) super.i();
    }

    final Collection m13503s() {
        return new AbstractSequentialList<V>(this) {
            final /* synthetic */ LinkedListMultimap f7389a;

            {
                this.f7389a = r1;
            }

            public int size() {
                return this.f7389a.f7419d;
            }

            public ListIterator<V> listIterator(int i) {
                final Object nodeIterator = new NodeIterator(this.f7389a, i);
                return new TransformedListIterator<Entry<K, V>, V>(this, nodeIterator) {
                    final /* synthetic */ AnonymousClass1ValuesImpl f7388b;

                    final Object m13475a(Object obj) {
                        return ((Entry) obj).getValue();
                    }

                    public void set(V v) {
                        NodeIterator nodeIterator = nodeIterator;
                        Preconditions.checkState(nodeIterator.f7406c != null);
                        nodeIterator.f7406c.f7399b = v;
                    }
                };
            }
        };
    }

    private List<Entry<K, V>> m13484e() {
        return (List) super.k();
    }

    final Collection m13502o() {
        return new AbstractSequentialList<Entry<K, V>>(this) {
            final /* synthetic */ LinkedListMultimap f7385a;

            {
                this.f7385a = r1;
            }

            public int size() {
                return this.f7385a.f7419d;
            }

            public ListIterator<Entry<K, V>> listIterator(int i) {
                return new NodeIterator(this.f7385a, i);
            }
        };
    }

    final Iterator<Entry<K, V>> m13499l() {
        throw new AssertionError("should never be called");
    }

    final Map<K, Collection<V>> m13500m() {
        return new Multimaps$AsMap(this);
    }

    @GwtIncompatible("java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(m13492f());
        for (Entry entry : m13484e()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    @GwtIncompatible("java.io.ObjectInputStream")
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.f7418c = Maps.d();
        int readInt = objectInputStream.readInt();
        for (int i = 0; i < readInt; i++) {
            a(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }
}

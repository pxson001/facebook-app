package com.google.protobuf;

import com.google.protobuf.GeneratedMessage.Builder;
import com.google.protobuf.GeneratedMessage.BuilderParent;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: already active */
public class RepeatedFieldBuilder<MType extends GeneratedMessage, BType extends Builder, IType extends MessageOrBuilder> implements BuilderParent {
    private BuilderParent f20966a;
    public List<MType> f20967b;
    private boolean f20968c;
    public List<SingleFieldBuilder<MType, BType, IType>> f20969d;
    public boolean f20970e;
    private MessageExternalList<MType, BType, IType> f20971f;
    private BuilderExternalList<MType, BType, IType> f20972g;
    private MessageOrBuilderExternalList<MType, BType, IType> f20973h;

    /* compiled from: already active */
    class BuilderExternalList<MType extends GeneratedMessage, BType extends Builder, IType extends MessageOrBuilder> extends AbstractList<BType> implements List<BType> {
        RepeatedFieldBuilder<MType, BType, IType> f20963a;

        public int size() {
            return this.f20963a.m21412c();
        }

        public Object get(int i) {
            Object obj = this.f20963a;
            if (obj.f20969d == null) {
                obj.f20969d = new ArrayList(obj.f20967b.size());
                for (int i2 = 0; i2 < obj.f20967b.size(); i2++) {
                    obj.f20969d.add(null);
                }
            }
            SingleFieldBuilder singleFieldBuilder = (SingleFieldBuilder) obj.f20969d.get(i);
            if (singleFieldBuilder == null) {
                SingleFieldBuilder singleFieldBuilder2 = new SingleFieldBuilder((GeneratedMessage) obj.f20967b.get(i), obj, obj.f20970e);
                obj.f20969d.set(i, singleFieldBuilder2);
                singleFieldBuilder = singleFieldBuilder2;
            }
            return singleFieldBuilder.m21443e();
        }

        final void m21399a() {
            this.modCount = this.modCount + 1;
        }
    }

    /* compiled from: already active */
    class MessageExternalList<MType extends GeneratedMessage, BType extends Builder, IType extends MessageOrBuilder> extends AbstractList<MType> implements List<MType> {
        RepeatedFieldBuilder<MType, BType, IType> f20964a;

        public int size() {
            return this.f20964a.m21412c();
        }

        public Object get(int i) {
            return this.f20964a.m21406a(i);
        }

        final void m21400a() {
            this.modCount = this.modCount + 1;
        }
    }

    /* compiled from: already active */
    class MessageOrBuilderExternalList<MType extends GeneratedMessage, BType extends Builder, IType extends MessageOrBuilder> extends AbstractList<IType> implements List<IType> {
        RepeatedFieldBuilder<MType, BType, IType> f20965a;

        public int size() {
            return this.f20965a.m21412c();
        }

        public Object get(int i) {
            MessageOrBuilder messageOrBuilder;
            RepeatedFieldBuilder repeatedFieldBuilder = this.f20965a;
            if (repeatedFieldBuilder.f20969d == null) {
                messageOrBuilder = (MessageOrBuilder) repeatedFieldBuilder.f20967b.get(i);
            } else {
                SingleFieldBuilder singleFieldBuilder = (SingleFieldBuilder) repeatedFieldBuilder.f20969d.get(i);
                if (singleFieldBuilder == null) {
                    messageOrBuilder = (MessageOrBuilder) repeatedFieldBuilder.f20967b.get(i);
                } else {
                    Builder builder;
                    if (singleFieldBuilder.f20994b != null) {
                        builder = singleFieldBuilder.f20994b;
                    } else {
                        builder = singleFieldBuilder.f20995c;
                    }
                    Object obj = builder;
                }
            }
            return messageOrBuilder;
        }

        final void m21401a() {
            this.modCount = this.modCount + 1;
        }
    }

    public RepeatedFieldBuilder(List<MType> list, boolean z, BuilderParent builderParent, boolean z2) {
        this.f20967b = list;
        this.f20968c = z;
        this.f20966a = builderParent;
        this.f20970e = z2;
    }

    public final void m21411b() {
        this.f20966a = null;
    }

    private void m21403g() {
        if (!this.f20968c) {
            this.f20967b = new ArrayList(this.f20967b);
            this.f20968c = true;
        }
    }

    public final int m21412c() {
        return this.f20967b.size();
    }

    public final boolean m21414d() {
        return this.f20967b.isEmpty();
    }

    public final MType m21406a(int i) {
        return m21402a(i, false);
    }

    private MType m21402a(int i, boolean z) {
        if (this.f20969d == null) {
            return (GeneratedMessage) this.f20967b.get(i);
        }
        SingleFieldBuilder singleFieldBuilder = (SingleFieldBuilder) this.f20969d.get(i);
        if (singleFieldBuilder == null) {
            return (GeneratedMessage) this.f20967b.get(i);
        }
        return z ? singleFieldBuilder.m21442d() : singleFieldBuilder.m21441c();
    }

    public final RepeatedFieldBuilder<MType, BType, IType> m21407a(int i, MType mType) {
        if (mType == null) {
            throw new NullPointerException();
        }
        m21403g();
        this.f20967b.set(i, mType);
        if (this.f20969d != null) {
            SingleFieldBuilder singleFieldBuilder = (SingleFieldBuilder) this.f20969d.set(i, null);
            if (singleFieldBuilder != null) {
                singleFieldBuilder.m21440b();
            }
        }
        m21404i();
        m21405j();
        return this;
    }

    public final RepeatedFieldBuilder<MType, BType, IType> m21408a(MType mType) {
        if (mType == null) {
            throw new NullPointerException();
        }
        m21403g();
        this.f20967b.add(mType);
        if (this.f20969d != null) {
            this.f20969d.add(null);
        }
        m21404i();
        m21405j();
        return this;
    }

    public final RepeatedFieldBuilder<MType, BType, IType> m21409a(Iterable<? extends MType> iterable) {
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            if (((GeneratedMessage) it.next()) == null) {
                throw new NullPointerException();
            }
        }
        if (!(iterable instanceof Collection)) {
            m21403g();
            it = iterable.iterator();
            while (it.hasNext()) {
                m21408a((GeneratedMessage) it.next());
            }
            m21404i();
            m21405j();
        } else if (((Collection) iterable).size() != 0) {
            m21403g();
            it = iterable.iterator();
            while (it.hasNext()) {
                m21408a((GeneratedMessage) it.next());
            }
            m21404i();
            m21405j();
        }
        return this;
    }

    public final void m21413d(int i) {
        m21403g();
        this.f20967b.remove(i);
        if (this.f20969d != null) {
            SingleFieldBuilder singleFieldBuilder = (SingleFieldBuilder) this.f20969d.remove(i);
            if (singleFieldBuilder != null) {
                singleFieldBuilder.m21440b();
            }
        }
        m21404i();
        m21405j();
    }

    public final void m21415e() {
        this.f20967b = Collections.emptyList();
        this.f20968c = false;
        if (this.f20969d != null) {
            for (SingleFieldBuilder singleFieldBuilder : this.f20969d) {
                if (singleFieldBuilder != null) {
                    singleFieldBuilder.m21440b();
                }
            }
            this.f20969d = null;
        }
        m21404i();
        m21405j();
    }

    public final List<MType> m21416f() {
        this.f20970e = true;
        if (!this.f20968c && this.f20969d == null) {
            return this.f20967b;
        }
        if (!this.f20968c) {
            boolean z;
            for (int i = 0; i < this.f20967b.size(); i++) {
                AbstractMessage abstractMessage = (AbstractMessage) this.f20967b.get(i);
                SingleFieldBuilder singleFieldBuilder = (SingleFieldBuilder) this.f20969d.get(i);
                if (singleFieldBuilder != null && singleFieldBuilder.m21442d() != abstractMessage) {
                    z = false;
                    break;
                }
            }
            z = true;
            if (z) {
                return this.f20967b;
            }
        }
        m21403g();
        for (int i2 = 0; i2 < this.f20967b.size(); i2++) {
            this.f20967b.set(i2, m21402a(i2, true));
        }
        this.f20967b = Collections.unmodifiableList(this.f20967b);
        this.f20968c = false;
        return this.f20967b;
    }

    private void m21404i() {
        if (this.f20970e && this.f20966a != null) {
            this.f20966a.mo897a();
            this.f20970e = false;
        }
    }

    public final void mo897a() {
        m21404i();
    }

    private void m21405j() {
        if (this.f20971f != null) {
            this.f20971f.m21400a();
        }
        if (this.f20972g != null) {
            this.f20972g.m21399a();
        }
        if (this.f20973h != null) {
            this.f20973h.m21401a();
        }
    }
}

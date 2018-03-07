package com.google.protobuf;

import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.FieldDescriptor.JavaType;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: amount_seen */
public final class DynamicMessage extends AbstractMessage {
    public final Descriptor f20896a;
    public final FieldSet<FieldDescriptor> f20897b;
    public final UnknownFieldSet f20898c;
    private int f20899d = -1;

    /* compiled from: amount_seen */
    class C24421 extends AbstractParser<DynamicMessage> {
        final /* synthetic */ DynamicMessage f20892a;

        C24421(DynamicMessage dynamicMessage) {
            this.f20892a = dynamicMessage;
        }

        public final Object mo859a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            com.google.protobuf.AbstractMessage.Builder b = DynamicMessage.m21293b(this.f20892a.f20896a);
            try {
                b.mo871a(codedInputStream, extensionRegistryLite);
                return b.m21284d();
            } catch (InvalidProtocolBufferException e) {
                throw e.m21374a(b.m21284d());
            } catch (IOException e2) {
                throw new InvalidProtocolBufferException(e2.getMessage()).m21374a(b.m21284d());
            }
        }
    }

    /* compiled from: amount_seen */
    public final class Builder extends com.google.protobuf.AbstractMessage.Builder<Builder> {
        private final Descriptor f20893a;
        private FieldSet<FieldDescriptor> f20894b = FieldSet.m21313a();
        private UnknownFieldSet f20895c = UnknownFieldSet.f21031a;

        public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo870a(AbstractMessage abstractMessage) {
            return m21283d(abstractMessage);
        }

        public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo860a(UnknownFieldSet unknownFieldSet) {
            return m21266d(unknownFieldSet);
        }

        public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo863b() {
            return m21269m();
        }

        public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo848c() {
            return m21269m();
        }

        public final /* synthetic */ Message$Builder mo849c(AbstractMessage abstractMessage) {
            return m21283d(abstractMessage);
        }

        public final /* synthetic */ Object clone() {
            return m21269m();
        }

        public final /* synthetic */ AbstractMessage mo874h() {
            return m21284d();
        }

        public final /* synthetic */ AbstractMessage mo875i() {
            return m21268l();
        }

        public final /* synthetic */ MessageLite mo876j() {
            return m21284d();
        }

        public final /* synthetic */ MessageLite mo877k() {
            return m21268l();
        }

        public Builder(Descriptor descriptor) {
            this.f20893a = descriptor;
        }

        public final Builder m21283d(AbstractMessage abstractMessage) {
            if (!(abstractMessage instanceof DynamicMessage)) {
                return (Builder) super.mo870a(abstractMessage);
            }
            DynamicMessage dynamicMessage = (DynamicMessage) abstractMessage;
            if (dynamicMessage.f20896a != this.f20893a) {
                throw new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
            }
            m21270o();
            this.f20894b.m21327a(dynamicMessage.f20897b);
            m21266d(dynamicMessage.f20898c);
            return this;
        }

        private DynamicMessage m21268l() {
            if (mo854a()) {
                return m21284d();
            }
            throw com.google.protobuf.AbstractMessage.Builder.m20123b(new DynamicMessage(this.f20893a, this.f20894b, this.f20895c));
        }

        public final DynamicMessage m21284d() {
            this.f20894b.m21331c();
            return new DynamicMessage(this.f20893a, this.f20894b, this.f20895c);
        }

        private Builder m21269m() {
            Builder builder = new Builder(this.f20893a);
            builder.f20894b.m21327a(this.f20894b);
            builder.m21266d(this.f20895c);
            return builder;
        }

        public final boolean mo854a() {
            return DynamicMessage.m21294b(this.f20893a, this.f20894b);
        }

        public final Descriptor mo841e() {
            return this.f20893a;
        }

        public final AbstractMessage mo878v() {
            return DynamicMessage.m21292a(this.f20893a);
        }

        public final Map<FieldDescriptor, Object> lR_() {
            return this.f20894b.m21333f();
        }

        public final Message$Builder mo867c(FieldDescriptor fieldDescriptor) {
            m21267e(fieldDescriptor);
            if (fieldDescriptor.m21232f() == JavaType.MESSAGE) {
                return new Builder(fieldDescriptor.m21246t());
            }
            throw new IllegalArgumentException("newBuilderForField is only valid for fields with message type.");
        }

        public final boolean mo862a(FieldDescriptor fieldDescriptor) {
            m21267e(fieldDescriptor);
            return this.f20894b.m21328a(fieldDescriptor);
        }

        public final Object mo866b(FieldDescriptor fieldDescriptor) {
            m21267e(fieldDescriptor);
            Object b = this.f20894b.m21329b(fieldDescriptor);
            if (b != null) {
                return b;
            }
            if (fieldDescriptor.m21232f() == JavaType.MESSAGE) {
                return DynamicMessage.m21292a(fieldDescriptor.m21246t());
            }
            return fieldDescriptor.m21242p();
        }

        public final Message$Builder mo864b(FieldDescriptor fieldDescriptor, Object obj) {
            m21267e(fieldDescriptor);
            m21270o();
            this.f20894b.m21326a(fieldDescriptor, obj);
            return this;
        }

        public final Message$Builder mo861a(FieldDescriptor fieldDescriptor, Object obj) {
            m21267e(fieldDescriptor);
            m21270o();
            this.f20894b.m21330b(fieldDescriptor, obj);
            return this;
        }

        public final UnknownFieldSet mo868g() {
            return this.f20895c;
        }

        public final Message$Builder mo865b(UnknownFieldSet unknownFieldSet) {
            this.f20895c = unknownFieldSet;
            return this;
        }

        private Builder m21266d(UnknownFieldSet unknownFieldSet) {
            this.f20895c = UnknownFieldSet.m21507a(this.f20895c).m21491a(unknownFieldSet).m21495b();
            return this;
        }

        private void m21270o() {
            if (this.f20894b.f20914b) {
                this.f20894b = this.f20894b.m21332e();
            }
        }

        private void m21267e(FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.f20868h != this.f20893a) {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            }
        }
    }

    public final /* synthetic */ Message$Builder mo881s() {
        return m21297k();
    }

    public final /* synthetic */ Message$Builder mo882t() {
        return m21296j();
    }

    public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo883u() {
        return m21297k();
    }

    public DynamicMessage(Descriptor descriptor, FieldSet<FieldDescriptor> fieldSet, UnknownFieldSet unknownFieldSet) {
        this.f20896a = descriptor;
        this.f20897b = fieldSet;
        this.f20898c = unknownFieldSet;
    }

    public static DynamicMessage m21292a(Descriptor descriptor) {
        return new DynamicMessage(descriptor, FieldSet.f20912d, UnknownFieldSet.f21031a);
    }

    public static Builder m21293b(Descriptor descriptor) {
        return new Builder(descriptor);
    }

    public final Descriptor mo841e() {
        return this.f20896a;
    }

    public final AbstractMessage mo878v() {
        return m21292a(this.f20896a);
    }

    public final Map<FieldDescriptor, Object> lR_() {
        return this.f20897b.m21333f();
    }

    public final boolean mo862a(FieldDescriptor fieldDescriptor) {
        m21295c(fieldDescriptor);
        return this.f20897b.m21328a(fieldDescriptor);
    }

    public final Object mo866b(FieldDescriptor fieldDescriptor) {
        m21295c(fieldDescriptor);
        Object b = this.f20897b.m21329b(fieldDescriptor);
        if (b != null) {
            return b;
        }
        if (fieldDescriptor.m21239m()) {
            return Collections.emptyList();
        }
        if (fieldDescriptor.m21232f() == JavaType.MESSAGE) {
            return m21292a(fieldDescriptor.m21246t());
        }
        return fieldDescriptor.m21242p();
    }

    public final UnknownFieldSet mo868g() {
        return this.f20898c;
    }

    public static boolean m21294b(Descriptor descriptor, FieldSet<FieldDescriptor> fieldSet) {
        for (FieldDescriptor fieldDescriptor : descriptor.m21196e()) {
            if (fieldDescriptor.m21237k() && !fieldSet.m21328a(fieldDescriptor)) {
                return false;
            }
        }
        return fieldSet.m21334h();
    }

    public final boolean mo854a() {
        return m21294b(this.f20896a, this.f20897b);
    }

    public final void mo853a(CodedOutputStream codedOutputStream) {
        FieldSet fieldSet;
        if (this.f20896a.m21195d().messageSetWireFormat_) {
            fieldSet = this.f20897b;
            for (int i = 0; i < fieldSet.f20913a.m21453c(); i++) {
                FieldSet.m21319a(fieldSet.f20913a.m21452b(i), codedOutputStream);
            }
            for (Entry a : fieldSet.f20913a.m21454d()) {
                FieldSet.m21319a(a, codedOutputStream);
            }
            this.f20898c.m21511b(codedOutputStream);
            return;
        }
        fieldSet = this.f20897b;
        for (int i2 = 0; i2 < fieldSet.f20913a.m21453c(); i2++) {
            Entry b = fieldSet.f20913a.m21452b(i2);
            FieldSet.m21317a((FieldDescriptor) b.getKey(), b.getValue(), codedOutputStream);
        }
        for (Entry a2 : fieldSet.f20913a.m21454d()) {
            FieldSet.m21317a((FieldDescriptor) a2.getKey(), a2.getValue(), codedOutputStream);
        }
        this.f20898c.mo853a(codedOutputStream);
    }

    public final int mo855b() {
        int i = this.f20899d;
        if (i == -1) {
            if (this.f20896a.m21195d().messageSetWireFormat_) {
                FieldSet fieldSet = this.f20897b;
                int i2 = 0;
                int i3 = 0;
                while (i2 < fieldSet.f20913a.m21453c()) {
                    i3 += FieldSet.m21325c(fieldSet.f20913a.m21452b(i2));
                    i2++;
                }
                for (Entry c : fieldSet.f20913a.m21454d()) {
                    i3 += FieldSet.m21325c(c);
                }
                i = i3 + this.f20898c.m21513g();
            } else {
                i = this.f20897b.m21335i() + this.f20898c.mo855b();
            }
            this.f20899d = i;
        }
        return i;
    }

    private Builder m21296j() {
        return new Builder(this.f20896a);
    }

    private Builder m21297k() {
        return m21296j().m21283d((AbstractMessage) this);
    }

    public final Parser<DynamicMessage> mo857i() {
        return new C24421(this);
    }

    private void m21295c(FieldDescriptor fieldDescriptor) {
        if (fieldDescriptor.f20868h != this.f20896a) {
            throw new IllegalArgumentException("FieldDescriptor does not match message type.");
        }
    }
}

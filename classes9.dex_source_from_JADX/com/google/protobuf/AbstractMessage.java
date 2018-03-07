package com.google.protobuf;

import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.FieldDescriptor.JavaType;
import com.google.protobuf.Descriptors.FieldDescriptor.Type;
import com.google.protobuf.ExtensionRegistry.ExtensionInfo;
import com.google.protobuf.GeneratedMessage.ExtendableBuilder;
import com.google.protobuf.Internal.EnumLite;
import com.google.protobuf.WireFormat.FieldType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: android.intent.action.CALL */
public abstract class AbstractMessage extends AbstractMessageLite implements MessageLite, MessageOrBuilder {
    private int memoizedSize = -1;

    /* compiled from: android.intent.action.CALL */
    public abstract class Builder<BuilderType extends Builder> extends com.google.protobuf.AbstractMessageLite.Builder<BuilderType> implements Message$Builder {
        public abstract BuilderType mo863b();

        public final com.google.protobuf.AbstractMessageLite.Builder mo843a(CodedInputStream codedInputStream) {
            return mo871a(codedInputStream, ExtensionRegistry.f20907c);
        }

        public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo842a(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return m20125c(byteString, extensionRegistryLite);
        }

        public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo844a(byte[] bArr) {
            return m20126c(bArr);
        }

        public /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo846b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return mo871a(codedInputStream, extensionRegistryLite);
        }

        public final /* synthetic */ Message$Builder mo847b(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return m20125c(byteString, extensionRegistryLite);
        }

        public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo839b(byte[] bArr) {
            return m20126c(bArr);
        }

        public /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo848c() {
            return mo863b();
        }

        public /* synthetic */ Message$Builder mo849c(AbstractMessage abstractMessage) {
            return mo870a(abstractMessage);
        }

        public /* synthetic */ com.google.protobuf.MessageLite.Builder mo840c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return mo871a(codedInputStream, extensionRegistryLite);
        }

        public /* synthetic */ Object clone() {
            return mo863b();
        }

        public BuilderType mo870a(Message message) {
            if (message.mo841e() != mo841e()) {
                throw new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
            }
            for (Entry entry : message.lR_().entrySet()) {
                FieldDescriptor fieldDescriptor = (FieldDescriptor) entry.getKey();
                if (fieldDescriptor.m21239m()) {
                    for (Object a : (List) entry.getValue()) {
                        mo861a(fieldDescriptor, a);
                    }
                } else if (fieldDescriptor.m21232f() == JavaType.MESSAGE) {
                    AbstractMessage abstractMessage = (AbstractMessage) mo866b(fieldDescriptor);
                    if (abstractMessage == abstractMessage.mo878v()) {
                        mo864b(fieldDescriptor, entry.getValue());
                    } else {
                        mo864b(fieldDescriptor, (Object) abstractMessage.mo882t().mo849c(abstractMessage).mo849c((AbstractMessage) entry.getValue()).mo875i());
                    }
                } else {
                    mo864b(fieldDescriptor, entry.getValue());
                }
            }
            mo860a(message.mo868g());
            return this;
        }

        public BuilderType mo871a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            com.google.protobuf.UnknownFieldSet.Builder a = UnknownFieldSet.m21507a(mo868g());
            int a2;
            do {
                a2 = codedInputStream.m20202a();
                if (a2 == 0) {
                    break;
                }
            } while (m20120a(codedInputStream, a, extensionRegistryLite, mo841e(), this, null, a2));
            mo865b(a.m21495b());
            return this;
        }

        private static void m20118a(Message$Builder message$Builder, FieldSet<FieldDescriptor> fieldSet, FieldDescriptor fieldDescriptor, Object obj) {
            if (message$Builder != null) {
                message$Builder.mo861a(fieldDescriptor, obj);
            } else {
                fieldSet.m21330b(fieldDescriptor, obj);
            }
        }

        private static void m20124b(Message$Builder message$Builder, FieldSet<FieldDescriptor> fieldSet, FieldDescriptor fieldDescriptor, Object obj) {
            if (message$Builder != null) {
                message$Builder.mo864b(fieldDescriptor, obj);
            } else {
                fieldSet.m21326a(fieldDescriptor, obj);
            }
        }

        public static boolean m20121a(Message$Builder message$Builder, FieldSet<FieldDescriptor> fieldSet, FieldDescriptor fieldDescriptor) {
            if (message$Builder != null) {
                return message$Builder.mo862a(fieldDescriptor);
            }
            return fieldSet.m21328a(fieldDescriptor);
        }

        public static Message m20122b(Message$Builder message$Builder, FieldSet<FieldDescriptor> fieldSet, FieldDescriptor fieldDescriptor) {
            if (message$Builder != null) {
                return (AbstractMessage) message$Builder.mo866b(fieldDescriptor);
            }
            return (AbstractMessage) fieldSet.m21329b(fieldDescriptor);
        }

        private static void m20117a(Message$Builder message$Builder, FieldSet<FieldDescriptor> fieldSet, FieldDescriptor fieldDescriptor, Message$Builder message$Builder2) {
            AbstractMessage b = m20122b(message$Builder, fieldSet, fieldDescriptor);
            if (b != null) {
                message$Builder2.mo849c(b);
            }
        }

        static boolean m20120a(CodedInputStream codedInputStream, com.google.protobuf.UnknownFieldSet.Builder builder, ExtensionRegistryLite extensionRegistryLite, Descriptor descriptor, Message$Builder message$Builder, FieldSet<FieldDescriptor> fieldSet, int i) {
            FieldDescriptor fieldDescriptor = null;
            boolean z = false;
            if (descriptor.m21195d().messageSetWireFormat_ && i == WireFormat.f21040a) {
                m20116a(codedInputStream, builder, extensionRegistryLite, descriptor, message$Builder, fieldSet);
                return true;
            }
            AbstractMessage abstractMessage;
            boolean z2;
            com.google.protobuf.MessageLite.Builder t;
            Object h;
            int m;
            Object a;
            int a2 = WireFormat.m21526a(i);
            int b = WireFormat.m21528b(i);
            if (descriptor.m21191a(b)) {
                if (extensionRegistryLite instanceof ExtensionRegistry) {
                    ExtensionInfo a3 = ((ExtensionRegistry) extensionRegistryLite).m21310a(descriptor, b);
                    if (a3 == null) {
                        abstractMessage = null;
                    } else {
                        FieldDescriptor fieldDescriptor2 = a3.f20902a;
                        AbstractMessage abstractMessage2 = a3.f20903b;
                        if (abstractMessage2 == null && fieldDescriptor2.m21232f() == JavaType.MESSAGE) {
                            throw new IllegalStateException("Message-typed extension lacked default instance: " + fieldDescriptor2.mo894b());
                        }
                        abstractMessage = abstractMessage2;
                        fieldDescriptor = fieldDescriptor2;
                    }
                } else {
                    abstractMessage = null;
                }
            } else if (message$Builder != null) {
                abstractMessage = null;
                fieldDescriptor = descriptor.m21192b(b);
            } else {
                abstractMessage = null;
            }
            if (fieldDescriptor != null) {
                if (a2 == FieldSet.m21312a(fieldDescriptor.m21236j(), false)) {
                    z2 = false;
                } else if (fieldDescriptor.m21241o() && a2 == FieldSet.m21312a(fieldDescriptor.m21236j(), true)) {
                    z2 = true;
                }
                if (z) {
                    return builder.m21493a(i, codedInputStream);
                }
                if (z2) {
                    switch (fieldDescriptor.m21235i()) {
                        case GROUP:
                            if (abstractMessage == null) {
                                t = abstractMessage.mo882t();
                            } else {
                                t = message$Builder.mo867c(fieldDescriptor);
                            }
                            if (!fieldDescriptor.m21239m()) {
                                m20117a(message$Builder, (FieldSet) fieldSet, fieldDescriptor, (Message$Builder) t);
                            }
                            codedInputStream.m20205a(fieldDescriptor.m21231e(), t, extensionRegistryLite);
                            h = t.mo874h();
                            break;
                        case MESSAGE:
                            if (abstractMessage == null) {
                                t = abstractMessage.mo882t();
                            } else {
                                t = message$Builder.mo867c(fieldDescriptor);
                            }
                            if (!fieldDescriptor.m21239m()) {
                                m20117a(message$Builder, (FieldSet) fieldSet, fieldDescriptor, (Message$Builder) t);
                            }
                            codedInputStream.m20206a(t, extensionRegistryLite);
                            h = t.mo874h();
                            break;
                        case ENUM:
                            m = codedInputStream.m20221m();
                            h = fieldDescriptor.m21247u().m21215a(m);
                            if (h == null) {
                                builder.m21488a(b, m);
                                return true;
                            }
                            break;
                        default:
                            h = FieldSet.m21314a(codedInputStream, fieldDescriptor.m21236j());
                            break;
                    }
                    if (fieldDescriptor.m21239m()) {
                        m20124b(message$Builder, fieldSet, fieldDescriptor, h);
                    } else {
                        m20118a(message$Builder, (FieldSet) fieldSet, fieldDescriptor, h);
                    }
                } else {
                    int c = codedInputStream.m20210c(codedInputStream.m20225r());
                    if (fieldDescriptor.m21236j() != FieldType.ENUM) {
                        while (codedInputStream.m20226s() > 0) {
                            a = fieldDescriptor.m21247u().m21215a(codedInputStream.m20221m());
                            if (a == null) {
                                return true;
                            }
                            m20118a(message$Builder, (FieldSet) fieldSet, fieldDescriptor, a);
                        }
                    } else {
                        while (codedInputStream.m20226s() > 0) {
                            m20118a(message$Builder, (FieldSet) fieldSet, fieldDescriptor, FieldSet.m21314a(codedInputStream, fieldDescriptor.m21236j()));
                        }
                    }
                    codedInputStream.m20212d(c);
                }
                return true;
            }
            z2 = false;
            z = true;
            if (z) {
                return builder.m21493a(i, codedInputStream);
            }
            if (z2) {
                switch (fieldDescriptor.m21235i()) {
                    case GROUP:
                        if (abstractMessage == null) {
                            t = message$Builder.mo867c(fieldDescriptor);
                        } else {
                            t = abstractMessage.mo882t();
                        }
                        if (fieldDescriptor.m21239m()) {
                            m20117a(message$Builder, (FieldSet) fieldSet, fieldDescriptor, (Message$Builder) t);
                        }
                        codedInputStream.m20205a(fieldDescriptor.m21231e(), t, extensionRegistryLite);
                        h = t.mo874h();
                        break;
                    case MESSAGE:
                        if (abstractMessage == null) {
                            t = message$Builder.mo867c(fieldDescriptor);
                        } else {
                            t = abstractMessage.mo882t();
                        }
                        if (fieldDescriptor.m21239m()) {
                            m20117a(message$Builder, (FieldSet) fieldSet, fieldDescriptor, (Message$Builder) t);
                        }
                        codedInputStream.m20206a(t, extensionRegistryLite);
                        h = t.mo874h();
                        break;
                    case ENUM:
                        m = codedInputStream.m20221m();
                        h = fieldDescriptor.m21247u().m21215a(m);
                        if (h == null) {
                            builder.m21488a(b, m);
                            return true;
                        }
                        break;
                    default:
                        h = FieldSet.m21314a(codedInputStream, fieldDescriptor.m21236j());
                        break;
                }
                if (fieldDescriptor.m21239m()) {
                    m20124b(message$Builder, fieldSet, fieldDescriptor, h);
                } else {
                    m20118a(message$Builder, (FieldSet) fieldSet, fieldDescriptor, h);
                }
            } else {
                int c2 = codedInputStream.m20210c(codedInputStream.m20225r());
                if (fieldDescriptor.m21236j() != FieldType.ENUM) {
                    while (codedInputStream.m20226s() > 0) {
                        m20118a(message$Builder, (FieldSet) fieldSet, fieldDescriptor, FieldSet.m21314a(codedInputStream, fieldDescriptor.m21236j()));
                    }
                } else {
                    while (codedInputStream.m20226s() > 0) {
                        a = fieldDescriptor.m21247u().m21215a(codedInputStream.m20221m());
                        if (a == null) {
                            return true;
                        }
                        m20118a(message$Builder, (FieldSet) fieldSet, fieldDescriptor, a);
                    }
                }
                codedInputStream.m20212d(c2);
            }
            return true;
        }

        private static void m20116a(CodedInputStream codedInputStream, com.google.protobuf.UnknownFieldSet.Builder builder, ExtensionRegistryLite extensionRegistryLite, Descriptor descriptor, Message$Builder message$Builder, FieldSet<FieldDescriptor> fieldSet) {
            ByteString byteString = null;
            int i = 0;
            ExtensionInfo extensionInfo = null;
            while (true) {
                int a = codedInputStream.m20202a();
                if (a == 0) {
                    break;
                } else if (a == WireFormat.f21042c) {
                    i = codedInputStream.m20220l();
                    if (i != 0 && (extensionRegistryLite instanceof ExtensionRegistry)) {
                        extensionInfo = ((ExtensionRegistry) extensionRegistryLite).m21310a(descriptor, i);
                    }
                } else if (a == WireFormat.f21043d) {
                    if (i == 0 || extensionInfo == null || !ExtensionRegistryLite.f20904a) {
                        byteString = codedInputStream.m20219k();
                    } else {
                        Object h;
                        FieldDescriptor fieldDescriptor = extensionInfo.f20902a;
                        if (m20121a(message$Builder, (FieldSet) fieldSet, fieldDescriptor)) {
                            com.google.protobuf.MessageLite.Builder s = m20122b(message$Builder, fieldSet, fieldDescriptor).mo881s();
                            codedInputStream.m20206a(s, extensionRegistryLite);
                            h = s.mo874h();
                        } else {
                            AbstractMessage abstractMessage = (AbstractMessage) codedInputStream.m20203a(extensionInfo.f20903b.mo857i(), extensionRegistryLite);
                        }
                        if (message$Builder != null) {
                            message$Builder.mo864b(fieldDescriptor, h);
                        } else {
                            fieldSet.m21326a(fieldDescriptor, h);
                        }
                        byteString = null;
                    }
                } else if (!codedInputStream.m20208b(a)) {
                    break;
                }
            }
            codedInputStream.m20204a(WireFormat.f21041b);
            if (byteString != null && i != 0) {
                if (extensionInfo != null) {
                    m20115a(byteString, extensionInfo, extensionRegistryLite, message$Builder, fieldSet);
                } else if (byteString != null) {
                    builder.m21489a(i, com.google.protobuf.UnknownFieldSet.Field.Builder.m21500c().m21502a(byteString).m21504a());
                }
            }
        }

        private static void m20115a(ByteString byteString, ExtensionInfo extensionInfo, ExtensionRegistryLite extensionRegistryLite, Message$Builder message$Builder, FieldSet<FieldDescriptor> fieldSet) {
            FieldDescriptor fieldDescriptor = extensionInfo.f20902a;
            boolean a = m20121a(message$Builder, (FieldSet) fieldSet, fieldDescriptor);
            Object h;
            if (a || ExtensionRegistryLite.f20904a) {
                if (a) {
                    Message$Builder s = m20122b(message$Builder, fieldSet, fieldDescriptor).mo881s();
                    s.mo847b(byteString, extensionRegistryLite);
                    h = s.mo874h();
                } else {
                    AbstractMessage abstractMessage = (AbstractMessage) extensionInfo.f20903b.mo857i().m20165a(byteString, extensionRegistryLite);
                }
                m20124b(message$Builder, fieldSet, fieldDescriptor, h);
                return;
            }
            h = new LazyField(extensionInfo.f20903b, extensionRegistryLite, byteString);
            if (message$Builder == null) {
                fieldSet.m21326a(fieldDescriptor, h);
            } else if (message$Builder instanceof ExtendableBuilder) {
                message$Builder.mo864b(fieldDescriptor, h);
            } else {
                message$Builder.mo864b(fieldDescriptor, h.m21377a());
            }
        }

        public BuilderType mo860a(UnknownFieldSet unknownFieldSet) {
            mo865b(UnknownFieldSet.m21507a(mo868g()).m21491a(unknownFieldSet).m21495b());
            return this;
        }

        protected static UninitializedMessageException m20123b(AbstractMessage abstractMessage) {
            List arrayList = new ArrayList();
            m20119a((MessageOrBuilder) abstractMessage, "", arrayList);
            return new UninitializedMessageException(arrayList);
        }

        public static void m20119a(MessageOrBuilder messageOrBuilder, String str, List<String> list) {
            for (FieldDescriptor fieldDescriptor : messageOrBuilder.mo841e().m21196e()) {
                if (fieldDescriptor.m21237k() && !messageOrBuilder.mo862a(fieldDescriptor)) {
                    list.add(str + fieldDescriptor.mo893a());
                }
            }
            for (Entry entry : messageOrBuilder.lR_().entrySet()) {
                FieldDescriptor fieldDescriptor2 = (FieldDescriptor) entry.getKey();
                Object value = entry.getValue();
                if (fieldDescriptor2.m21232f() == JavaType.MESSAGE) {
                    if (fieldDescriptor2.m21239m()) {
                        int i = 0;
                        for (MessageOrBuilder a : (List) value) {
                            int i2 = i + 1;
                            m20119a(a, m20114a(str, fieldDescriptor2, i), (List) list);
                            i = i2;
                        }
                    } else if (messageOrBuilder.mo862a(fieldDescriptor2)) {
                        m20119a((MessageOrBuilder) value, m20114a(str, fieldDescriptor2, -1), (List) list);
                    }
                }
            }
        }

        private static String m20114a(String str, FieldDescriptor fieldDescriptor, int i) {
            StringBuilder stringBuilder = new StringBuilder(str);
            if (fieldDescriptor.m21243q()) {
                stringBuilder.append('(').append(fieldDescriptor.mo894b()).append(')');
            } else {
                stringBuilder.append(fieldDescriptor.mo893a());
            }
            if (i != -1) {
                stringBuilder.append('[').append(i).append(']');
            }
            stringBuilder.append('.');
            return stringBuilder.toString();
        }

        private BuilderType m20125c(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (Builder) super.mo842a(byteString, extensionRegistryLite);
        }

        private BuilderType m20126c(byte[] bArr) {
            return (Builder) super.mo844a(bArr);
        }

        public final com.google.protobuf.AbstractMessageLite.Builder mo845a(byte[] bArr, int i, int i2) {
            return (Builder) super.mo845a(bArr, i, i2);
        }
    }

    public abstract Parser<? extends Message> mo857i();

    public abstract Message$Builder mo881s();

    public abstract Message$Builder mo882t();

    public boolean mo854a() {
        for (FieldDescriptor fieldDescriptor : mo841e().m21196e()) {
            if (fieldDescriptor.m21237k() && !mo862a(fieldDescriptor)) {
                return false;
            }
        }
        for (Entry entry : lR_().entrySet()) {
            FieldDescriptor fieldDescriptor2 = (FieldDescriptor) entry.getKey();
            if (fieldDescriptor2.m21232f() == JavaType.MESSAGE) {
                if (fieldDescriptor2.m21239m()) {
                    for (AbstractMessage a : (List) entry.getValue()) {
                        if (!a.mo854a()) {
                            return false;
                        }
                    }
                    continue;
                } else if (!((AbstractMessage) entry.getValue()).mo854a()) {
                    return false;
                }
            }
        }
        return true;
    }

    public final String toString() {
        return TextFormat.m21471a((MessageOrBuilder) this);
    }

    public void mo853a(CodedOutputStream codedOutputStream) {
        boolean z = mo841e().m21195d().messageSetWireFormat_;
        for (Entry entry : lR_().entrySet()) {
            FieldDescriptor fieldDescriptor = (FieldDescriptor) entry.getKey();
            Object value = entry.getValue();
            if (z && fieldDescriptor.m21243q() && fieldDescriptor.f20867g == Type.MESSAGE && !fieldDescriptor.m21239m()) {
                codedOutputStream.m20278c(fieldDescriptor.m21231e(), (AbstractMessage) value);
            } else {
                FieldSet.m21317a(fieldDescriptor, value, codedOutputStream);
            }
        }
        UnknownFieldSet g = mo868g();
        if (z) {
            g.m21511b(codedOutputStream);
        } else {
            g.mo853a(codedOutputStream);
        }
    }

    public int mo855b() {
        int i = this.memoizedSize;
        if (i == -1) {
            boolean z = mo841e().m21195d().messageSetWireFormat_;
            int i2 = 0;
            for (Entry entry : lR_().entrySet()) {
                FieldDescriptor fieldDescriptor = (FieldDescriptor) entry.getKey();
                Object value = entry.getValue();
                if (z && fieldDescriptor.m21243q() && fieldDescriptor.f20867g == Type.MESSAGE && !fieldDescriptor.m21239m()) {
                    i2 = CodedOutputStream.m20244f(fieldDescriptor.m21231e(), (AbstractMessage) value) + i2;
                } else {
                    i2 = FieldSet.m21324c(fieldDescriptor, value) + i2;
                }
            }
            UnknownFieldSet g = mo868g();
            if (z) {
                i = g.m21513g() + i2;
            } else {
                i = g.mo855b() + i2;
            }
            this.memoizedSize = i;
        }
        return i;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractMessage)) {
            return false;
        }
        AbstractMessage abstractMessage = (AbstractMessage) obj;
        if (mo841e() != abstractMessage.mo841e()) {
            return false;
        }
        if (lR_().equals(abstractMessage.lR_()) && mo868g().equals(abstractMessage.mo868g())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (m20148a(mo841e().hashCode() + 779, lR_()) * 29) + mo868g().hashCode();
    }

    private static int m20148a(int i, Map<FieldDescriptor, Object> map) {
        for (Entry entry : map.entrySet()) {
            FieldDescriptor fieldDescriptor = (FieldDescriptor) entry.getKey();
            Object value = entry.getValue();
            int e = (i * 37) + fieldDescriptor.m21231e();
            if (fieldDescriptor.f20867g != Type.ENUM) {
                i = (e * 53) + value.hashCode();
            } else if (fieldDescriptor.m21239m()) {
                int i2 = e * 53;
                int i3 = 1;
                for (EnumLite a : (List) value) {
                    i3 = m20149a(a) + (i3 * 31);
                }
                i = i2 + i3;
            } else {
                i = (e * 53) + m20149a((EnumLite) value);
            }
        }
        return i;
    }

    final UninitializedMessageException mo856c() {
        return Builder.m20123b(this);
    }

    public static int m20149a(EnumLite enumLite) {
        return enumLite.getNumber();
    }
}

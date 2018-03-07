package com.google.protobuf;

import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.EnumValueDescriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.FieldDescriptor.JavaType;
import com.google.protobuf.LazyField.LazyEntry;
import com.google.protobuf.LazyField.LazyIterator;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/* compiled from: analytics_caller_context */
public abstract class GeneratedMessage extends AbstractMessage implements Serializable {
    public static boolean f20638b = false;

    /* compiled from: analytics_caller_context */
    public abstract class Builder<BuilderType extends Builder> extends com.google.protobuf.AbstractMessage.Builder<BuilderType> {
        private BuilderParent f20617a;
        private BuilderParentImpl f20618b;
        public boolean f20619c;
        private UnknownFieldSet f20620d;

        /* compiled from: analytics_caller_context */
        class BuilderParentImpl implements BuilderParent {
            final /* synthetic */ Builder f20916a;

            public BuilderParentImpl(Builder builder) {
                this.f20916a = builder;
            }

            public final void mo897a() {
                this.f20916a.m20312t();
            }
        }

        protected abstract FieldAccessorTable mo872d();

        public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo860a(UnknownFieldSet unknownFieldSet) {
            return m20301c(unknownFieldSet);
        }

        public /* synthetic */ Message$Builder mo861a(FieldDescriptor fieldDescriptor, Object obj) {
            return mo885d(fieldDescriptor, obj);
        }

        public /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo863b() {
            return mo873f();
        }

        public /* synthetic */ Message$Builder mo864b(FieldDescriptor fieldDescriptor, Object obj) {
            return mo884c(fieldDescriptor, obj);
        }

        public /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo848c() {
            return mo873f();
        }

        public /* synthetic */ Object clone() {
            return mo873f();
        }

        protected Builder() {
            this(null);
        }

        protected Builder(BuilderParent builderParent) {
            this.f20620d = UnknownFieldSet.f21031a;
            this.f20617a = builderParent;
        }

        final void m20308o() {
            this.f20617a = null;
        }

        protected final void m20309p() {
            if (this.f20617a != null) {
                m20310q();
            }
        }

        protected final void m20310q() {
            this.f20619c = true;
        }

        public BuilderType mo873f() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }

        public Descriptor mo841e() {
            return mo872d().f20945a;
        }

        public Map<FieldDescriptor, Object> lR_() {
            return Collections.unmodifiableMap(m20290l(this));
        }

        public static Map m20290l(Builder builder) {
            Map treeMap = new TreeMap();
            for (FieldDescriptor fieldDescriptor : builder.mo872d().f20945a.m21196e()) {
                if (fieldDescriptor.m21239m()) {
                    List list = (List) builder.mo866b(fieldDescriptor);
                    if (!list.isEmpty()) {
                        treeMap.put(fieldDescriptor, list);
                    }
                } else if (builder.mo862a(fieldDescriptor)) {
                    treeMap.put(fieldDescriptor, builder.mo866b(fieldDescriptor));
                }
            }
            return treeMap;
        }

        public final Message$Builder mo867c(FieldDescriptor fieldDescriptor) {
            return FieldAccessorTable.m21367a(mo872d(), fieldDescriptor).newBuilder();
        }

        public boolean mo862a(FieldDescriptor fieldDescriptor) {
            return FieldAccessorTable.m21367a(mo872d(), fieldDescriptor).mo902b(this);
        }

        public Object mo866b(FieldDescriptor fieldDescriptor) {
            Object a = FieldAccessorTable.m21367a(mo872d(), fieldDescriptor).mo898a(this);
            if (fieldDescriptor.m21239m()) {
                return Collections.unmodifiableList((List) a);
            }
            return a;
        }

        public BuilderType mo884c(FieldDescriptor fieldDescriptor, Object obj) {
            FieldAccessorTable.m21367a(mo872d(), fieldDescriptor).mo900a(this, obj);
            return this;
        }

        public BuilderType mo885d(FieldDescriptor fieldDescriptor, Object obj) {
            FieldAccessorTable.m21367a(mo872d(), fieldDescriptor).mo901b(this, obj);
            return this;
        }

        public final Message$Builder mo865b(UnknownFieldSet unknownFieldSet) {
            this.f20620d = unknownFieldSet;
            m20312t();
            return this;
        }

        public final BuilderType m20301c(UnknownFieldSet unknownFieldSet) {
            this.f20620d = UnknownFieldSet.m21507a(this.f20620d).m21491a(unknownFieldSet).m21495b();
            m20312t();
            return this;
        }

        public boolean mo854a() {
            for (FieldDescriptor fieldDescriptor : mo841e().m21196e()) {
                if (fieldDescriptor.m21237k() && !mo862a(fieldDescriptor)) {
                    return false;
                }
                if (fieldDescriptor.m21232f() == JavaType.MESSAGE) {
                    if (fieldDescriptor.m21239m()) {
                        for (AbstractMessage a : (List) mo866b(fieldDescriptor)) {
                            if (!a.mo854a()) {
                                return false;
                            }
                        }
                        continue;
                    } else if (mo862a(fieldDescriptor) && !((AbstractMessage) mo866b(fieldDescriptor)).mo854a()) {
                        return false;
                    }
                }
            }
            return true;
        }

        public final UnknownFieldSet mo868g() {
            return this.f20620d;
        }

        public final BuilderParent m20311s() {
            if (this.f20618b == null) {
                this.f20618b = new BuilderParentImpl(this);
            }
            return this.f20618b;
        }

        public final void m20312t() {
            if (this.f20619c && this.f20617a != null) {
                this.f20617a.mo897a();
                this.f20619c = false;
            }
        }
    }

    public interface ExtendableMessageOrBuilder extends MessageOrBuilder {
    }

    /* compiled from: analytics_caller_context */
    public abstract class ExtendableBuilder<MessageType extends ExtendableMessage, BuilderType extends ExtendableBuilder> extends Builder<BuilderType> implements ExtendableMessageOrBuilder<MessageType> {
        public FieldSet<FieldDescriptor> f20651a = FieldSet.f20912d;

        private void m20462d(FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.f20868h != mo841e()) {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            }
        }

        public final /* synthetic */ Message$Builder mo861a(FieldDescriptor fieldDescriptor, Object obj) {
            return m20464f(fieldDescriptor, obj);
        }

        public /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo863b() {
            return mo887m();
        }

        public final /* synthetic */ Message$Builder mo864b(FieldDescriptor fieldDescriptor, Object obj) {
            return m20463e(fieldDescriptor, obj);
        }

        public /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo848c() {
            return mo887m();
        }

        public final /* synthetic */ Builder mo884c(FieldDescriptor fieldDescriptor, Object obj) {
            return m20463e(fieldDescriptor, obj);
        }

        public /* synthetic */ Object clone() {
            return mo887m();
        }

        public final /* synthetic */ Builder mo885d(FieldDescriptor fieldDescriptor, Object obj) {
            return m20464f(fieldDescriptor, obj);
        }

        public /* synthetic */ Builder mo873f() {
            return mo887m();
        }

        protected ExtendableBuilder() {
        }

        protected ExtendableBuilder(BuilderParent builderParent) {
            super(builderParent);
        }

        public BuilderType mo887m() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }

        private void mo886l() {
            if (this.f20651a.f20914b) {
                this.f20651a = this.f20651a.m21332e();
            }
        }

        protected final boolean m20478u() {
            return this.f20651a.m21334h();
        }

        public boolean mo854a() {
            return super.mo854a() && m20478u();
        }

        public final Map<FieldDescriptor, Object> lR_() {
            Map l = Builder.m20290l(this);
            l.putAll(this.f20651a.m21333f());
            return Collections.unmodifiableMap(l);
        }

        public final Object mo866b(FieldDescriptor fieldDescriptor) {
            if (!fieldDescriptor.m21243q()) {
                return super.mo866b(fieldDescriptor);
            }
            m20462d(fieldDescriptor);
            Object b = this.f20651a.m21329b(fieldDescriptor);
            if (b != null) {
                return b;
            }
            if (fieldDescriptor.m21232f() == JavaType.MESSAGE) {
                return DynamicMessage.m21292a(fieldDescriptor.m21246t());
            }
            return fieldDescriptor.m21242p();
        }

        public final boolean mo862a(FieldDescriptor fieldDescriptor) {
            if (!fieldDescriptor.m21243q()) {
                return super.mo862a(fieldDescriptor);
            }
            m20462d(fieldDescriptor);
            return this.f20651a.m21328a(fieldDescriptor);
        }

        private BuilderType m20463e(FieldDescriptor fieldDescriptor, Object obj) {
            if (!fieldDescriptor.m21243q()) {
                return (ExtendableBuilder) super.mo884c(fieldDescriptor, obj);
            }
            m20462d(fieldDescriptor);
            mo886l();
            this.f20651a.m21326a(fieldDescriptor, obj);
            m20312t();
            return this;
        }

        private BuilderType m20464f(FieldDescriptor fieldDescriptor, Object obj) {
            if (!fieldDescriptor.m21243q()) {
                return (ExtendableBuilder) super.mo885d(fieldDescriptor, obj);
            }
            m20462d(fieldDescriptor);
            mo886l();
            this.f20651a.m21330b(fieldDescriptor, obj);
            m20312t();
            return this;
        }

        protected final void m20467a(ExtendableMessage extendableMessage) {
            mo886l();
            this.f20651a.m21327a(extendableMessage.extensions);
            m20312t();
        }
    }

    /* compiled from: analytics_caller_context */
    public abstract class ExtendableMessage<MessageType extends ExtendableMessage> extends GeneratedMessage implements ExtendableMessageOrBuilder<MessageType> {
        public final FieldSet<FieldDescriptor> extensions;

        /* compiled from: analytics_caller_context */
        public class ExtensionWriter {
            final /* synthetic */ ExtendableMessage f20917a;
            private final Iterator<Entry<FieldDescriptor, Object>> f20918b;
            private Entry<FieldDescriptor, Object> f20919c;
            private final boolean f20920d;

            public ExtensionWriter(ExtendableMessage extendableMessage, boolean z) {
                LazyIterator lazyIterator;
                this.f20917a = extendableMessage;
                FieldSet fieldSet = this.f20917a.extensions;
                if (fieldSet.f20915c) {
                    lazyIterator = new LazyIterator(fieldSet.f20913a.entrySet().iterator());
                } else {
                    lazyIterator = fieldSet.f20913a.entrySet().iterator();
                }
                this.f20918b = lazyIterator;
                if (this.f20918b.hasNext()) {
                    this.f20919c = (Entry) this.f20918b.next();
                }
                this.f20920d = z;
            }

            public final void m21338a(int i, CodedOutputStream codedOutputStream) {
                while (this.f20919c != null && ((FieldDescriptor) this.f20919c.getKey()).m21231e() < i) {
                    FieldDescriptor fieldDescriptor = (FieldDescriptor) this.f20919c.getKey();
                    if (!this.f20920d || fieldDescriptor.m21233g() != WireFormat.JavaType.MESSAGE || fieldDescriptor.m21239m()) {
                        FieldSet.m21317a(fieldDescriptor, this.f20919c.getValue(), codedOutputStream);
                    } else if (this.f20919c instanceof LazyEntry) {
                        codedOutputStream.m20272b(fieldDescriptor.m21231e(), ((LazyField) ((LazyEntry) this.f20919c).f20949a.getValue()).m21378c());
                    } else {
                        codedOutputStream.m20278c(fieldDescriptor.m21231e(), (AbstractMessage) this.f20919c.getValue());
                    }
                    if (this.f20918b.hasNext()) {
                        this.f20919c = (Entry) this.f20918b.next();
                    } else {
                        this.f20919c = null;
                    }
                }
            }
        }

        protected ExtendableMessage() {
            this.extensions = FieldSet.m21313a();
        }

        protected ExtendableMessage(ExtendableBuilder<MessageType, ?> extendableBuilder) {
            super((byte) 0);
            extendableBuilder.f20651a.m21331c();
            this.extensions = extendableBuilder.f20651a;
        }

        protected final boolean m20507F() {
            return this.extensions.m21334h();
        }

        public boolean mo854a() {
            return super.mo854a() && m20507F();
        }

        protected final boolean mo889a(CodedInputStream codedInputStream, com.google.protobuf.UnknownFieldSet.Builder builder, ExtensionRegistryLite extensionRegistryLite, int i) {
            return com.google.protobuf.AbstractMessage.Builder.m20120a(codedInputStream, builder, extensionRegistryLite, mo841e(), null, this.extensions, i);
        }

        protected final void mo888E() {
            this.extensions.m21331c();
        }

        protected final ExtensionWriter m20508G() {
            return new ExtensionWriter(this, false);
        }

        protected final int m20509H() {
            return this.extensions.m21335i();
        }

        public final Map<FieldDescriptor, Object> lR_() {
            Map a = mo891j();
            a.putAll(this.extensions.m21333f());
            return Collections.unmodifiableMap(a);
        }

        public final boolean mo862a(FieldDescriptor fieldDescriptor) {
            if (!fieldDescriptor.m21243q()) {
                return super.mo862a(fieldDescriptor);
            }
            m20505c(fieldDescriptor);
            return this.extensions.m21328a(fieldDescriptor);
        }

        private void m20505c(FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.f20868h != mo841e()) {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            }
        }

        public final Object mo866b(FieldDescriptor fieldDescriptor) {
            if (!fieldDescriptor.m21243q()) {
                return super.mo866b(fieldDescriptor);
            }
            m20505c(fieldDescriptor);
            Object b = this.extensions.m21329b(fieldDescriptor);
            if (b != null) {
                return b;
            }
            if (fieldDescriptor.m21232f() == JavaType.MESSAGE) {
                return DynamicMessage.m21292a(fieldDescriptor.m21246t());
            }
            return fieldDescriptor.m21242p();
        }
    }

    /* compiled from: analytics_caller_context */
    public interface BuilderParent {
        void mo897a();
    }

    /* compiled from: analytics_caller_context */
    public final class FieldAccessorTable {
        public final Descriptor f20945a;
        private final FieldAccessor[] f20946b;
        private String[] f20947c;
        private volatile boolean f20948d = false;

        /* compiled from: analytics_caller_context */
        interface FieldAccessor {
            Object mo898a(Builder builder);

            Object mo899a(GeneratedMessage generatedMessage);

            void mo900a(Builder builder, Object obj);

            void mo901b(Builder builder, Object obj);

            boolean mo902b(Builder builder);

            boolean mo903b(GeneratedMessage generatedMessage);

            Message$Builder newBuilder();
        }

        /* compiled from: analytics_caller_context */
        public class RepeatedFieldAccessor implements FieldAccessor {
            protected final Class f20921a = this.f20924d.getReturnType();
            protected final Method f20922b;
            protected final Method f20923c;
            protected final Method f20924d;
            protected final Method f20925e;
            protected final Method f20926f;
            protected final Method f20927g;
            protected final Method f20928h;
            protected final Method f20929i;
            public final Method f20930j;

            RepeatedFieldAccessor(String str, Class<? extends GeneratedMessage> cls, Class<? extends Builder> cls2) {
                this.f20922b = GeneratedMessage.m20368b((Class) cls, "get" + str + "List", new Class[0]);
                this.f20923c = GeneratedMessage.m20368b((Class) cls2, "get" + str + "List", new Class[0]);
                this.f20924d = GeneratedMessage.m20368b((Class) cls, "get" + str, Integer.TYPE);
                this.f20925e = GeneratedMessage.m20368b((Class) cls2, "get" + str, Integer.TYPE);
                this.f20926f = GeneratedMessage.m20368b((Class) cls2, "set" + str, Integer.TYPE, this.f20921a);
                this.f20927g = GeneratedMessage.m20368b((Class) cls2, "add" + str, this.f20921a);
                this.f20928h = GeneratedMessage.m20368b((Class) cls, "get" + str + "Count", new Class[0]);
                this.f20929i = GeneratedMessage.m20368b((Class) cls2, "get" + str + "Count", new Class[0]);
                this.f20930j = GeneratedMessage.m20368b((Class) cls2, "clear" + str, new Class[0]);
            }

            public Object mo899a(GeneratedMessage generatedMessage) {
                return GeneratedMessage.m20367b(this.f20922b, (Object) generatedMessage, new Object[0]);
            }

            public Object mo898a(Builder builder) {
                return GeneratedMessage.m20367b(this.f20923c, (Object) builder, new Object[0]);
            }

            public void mo901b(Builder builder, Object obj) {
                GeneratedMessage.m20367b(this.f20927g, (Object) builder, obj);
            }

            public final boolean mo903b(GeneratedMessage generatedMessage) {
                throw new UnsupportedOperationException("hasField() called on a repeated field.");
            }

            public final boolean mo902b(Builder builder) {
                throw new UnsupportedOperationException("hasField() called on a repeated field.");
            }

            public final void mo900a(Builder builder, Object obj) {
                GeneratedMessage.m20367b(this.f20930j, (Object) builder, new Object[0]);
                for (Object b : (List) obj) {
                    mo901b(builder, b);
                }
            }

            public Message$Builder newBuilder() {
                throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
            }
        }

        /* compiled from: analytics_caller_context */
        final class RepeatedEnumFieldAccessor extends RepeatedFieldAccessor {
            private final Method f20931k = GeneratedMessage.m20368b(this.f20921a, "valueOf", EnumValueDescriptor.class);
            private final Method f20932l = GeneratedMessage.m20368b(this.f20921a, "getValueDescriptor", new Class[0]);

            RepeatedEnumFieldAccessor(FieldDescriptor fieldDescriptor, String str, Class<? extends GeneratedMessage> cls, Class<? extends Builder> cls2) {
                super(str, cls, cls2);
            }

            public final Object mo899a(GeneratedMessage generatedMessage) {
                List arrayList = new ArrayList();
                for (Object b : (List) super.mo899a(generatedMessage)) {
                    arrayList.add(GeneratedMessage.m20367b(this.f20932l, b, new Object[0]));
                }
                return Collections.unmodifiableList(arrayList);
            }

            public final Object mo898a(Builder builder) {
                List arrayList = new ArrayList();
                for (Object b : (List) super.mo898a(builder)) {
                    arrayList.add(GeneratedMessage.m20367b(this.f20932l, b, new Object[0]));
                }
                return Collections.unmodifiableList(arrayList);
            }

            public final void mo901b(Builder builder, Object obj) {
                super.mo901b(builder, GeneratedMessage.m20367b(this.f20931k, null, obj));
            }
        }

        /* compiled from: analytics_caller_context */
        final class RepeatedMessageFieldAccessor extends RepeatedFieldAccessor {
            private final Method f20933k = GeneratedMessage.m20368b(this.f20921a, "newBuilder", new Class[0]);

            RepeatedMessageFieldAccessor(FieldDescriptor fieldDescriptor, String str, Class<? extends GeneratedMessage> cls, Class<? extends Builder> cls2) {
                super(str, cls, cls2);
            }

            private Object m21354a(Object obj) {
                return this.f20921a.isInstance(obj) ? obj : ((Message$Builder) GeneratedMessage.m20367b(this.f20933k, null, new Object[0])).mo849c((AbstractMessage) obj).mo875i();
            }

            public final void mo901b(Builder builder, Object obj) {
                super.mo901b(builder, m21354a(obj));
            }

            public final Message$Builder newBuilder() {
                return (Message$Builder) GeneratedMessage.m20367b(this.f20933k, null, new Object[0]);
            }
        }

        /* compiled from: analytics_caller_context */
        public class SingularFieldAccessor implements FieldAccessor {
            protected final Class<?> f20934a = this.f20935b.getReturnType();
            protected final Method f20935b;
            protected final Method f20936c;
            protected final Method f20937d;
            protected final Method f20938e;
            protected final Method f20939f;
            protected final Method f20940g;

            SingularFieldAccessor(String str, Class<? extends GeneratedMessage> cls, Class<? extends Builder> cls2) {
                this.f20935b = GeneratedMessage.m20368b((Class) cls, "get" + str, new Class[0]);
                this.f20936c = GeneratedMessage.m20368b((Class) cls2, "get" + str, new Class[0]);
                this.f20937d = GeneratedMessage.m20368b((Class) cls2, "set" + str, this.f20934a);
                this.f20938e = GeneratedMessage.m20368b((Class) cls, "has" + str, new Class[0]);
                this.f20939f = GeneratedMessage.m20368b((Class) cls2, "has" + str, new Class[0]);
                this.f20940g = GeneratedMessage.m20368b((Class) cls2, "clear" + str, new Class[0]);
            }

            public Object mo899a(GeneratedMessage generatedMessage) {
                return GeneratedMessage.m20367b(this.f20935b, (Object) generatedMessage, new Object[0]);
            }

            public Object mo898a(Builder builder) {
                return GeneratedMessage.m20367b(this.f20936c, (Object) builder, new Object[0]);
            }

            public void mo900a(Builder builder, Object obj) {
                GeneratedMessage.m20367b(this.f20937d, (Object) builder, obj);
            }

            public final void mo901b(Builder builder, Object obj) {
                throw new UnsupportedOperationException("addRepeatedField() called on a singular field.");
            }

            public final boolean mo903b(GeneratedMessage generatedMessage) {
                return ((Boolean) GeneratedMessage.m20367b(this.f20938e, (Object) generatedMessage, new Object[0])).booleanValue();
            }

            public final boolean mo902b(Builder builder) {
                return ((Boolean) GeneratedMessage.m20367b(this.f20939f, (Object) builder, new Object[0])).booleanValue();
            }

            public Message$Builder newBuilder() {
                throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
            }
        }

        /* compiled from: analytics_caller_context */
        final class SingularEnumFieldAccessor extends SingularFieldAccessor {
            private Method f20941h = GeneratedMessage.m20368b(this.f20934a, "valueOf", EnumValueDescriptor.class);
            private Method f20942i = GeneratedMessage.m20368b(this.f20934a, "getValueDescriptor", new Class[0]);

            SingularEnumFieldAccessor(FieldDescriptor fieldDescriptor, String str, Class<? extends GeneratedMessage> cls, Class<? extends Builder> cls2) {
                super(str, cls, cls2);
            }

            public final Object mo899a(GeneratedMessage generatedMessage) {
                return GeneratedMessage.m20367b(this.f20942i, super.mo899a(generatedMessage), new Object[0]);
            }

            public final Object mo898a(Builder builder) {
                return GeneratedMessage.m20367b(this.f20942i, super.mo898a(builder), new Object[0]);
            }

            public final void mo900a(Builder builder, Object obj) {
                super.mo900a(builder, GeneratedMessage.m20367b(this.f20941h, null, obj));
            }
        }

        /* compiled from: analytics_caller_context */
        final class SingularMessageFieldAccessor extends SingularFieldAccessor {
            private final Method f20943h = GeneratedMessage.m20368b(this.f20934a, "newBuilder", new Class[0]);
            private final Method f20944i;

            SingularMessageFieldAccessor(FieldDescriptor fieldDescriptor, String str, Class<? extends GeneratedMessage> cls, Class<? extends Builder> cls2) {
                super(str, cls, cls2);
                this.f20944i = GeneratedMessage.m20368b((Class) cls2, "get" + str + "Builder", new Class[0]);
            }

            private Object m21365a(Object obj) {
                return this.f20934a.isInstance(obj) ? obj : ((Message$Builder) GeneratedMessage.m20367b(this.f20943h, null, new Object[0])).mo849c((AbstractMessage) obj).mo874h();
            }

            public final void mo900a(Builder builder, Object obj) {
                super.mo900a(builder, m21365a(obj));
            }

            public final Message$Builder newBuilder() {
                return (Message$Builder) GeneratedMessage.m20367b(this.f20943h, null, new Object[0]);
            }
        }

        public static FieldAccessor m21367a(FieldAccessorTable fieldAccessorTable, FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.f20868h != fieldAccessorTable.f20945a) {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            } else if (!fieldDescriptor.m21243q()) {
                return fieldAccessorTable.f20946b[fieldDescriptor.f20862b];
            } else {
                throw new IllegalArgumentException("This type does not have extensions.");
            }
        }

        public FieldAccessorTable(Descriptor descriptor, String[] strArr) {
            this.f20945a = descriptor;
            this.f20947c = strArr;
            this.f20946b = new FieldAccessor[descriptor.m21196e().size()];
        }

        public final FieldAccessorTable m21368a(Class<? extends GeneratedMessage> cls, Class<? extends Builder> cls2) {
            if (!this.f20948d) {
                synchronized (this) {
                    if (this.f20948d) {
                    } else {
                        for (int i = 0; i < this.f20946b.length; i++) {
                            FieldDescriptor fieldDescriptor = (FieldDescriptor) this.f20945a.m21196e().get(i);
                            if (fieldDescriptor.m21239m()) {
                                if (fieldDescriptor.m21232f() == JavaType.MESSAGE) {
                                    this.f20946b[i] = new RepeatedMessageFieldAccessor(fieldDescriptor, this.f20947c[i], cls, cls2);
                                } else if (fieldDescriptor.m21232f() == JavaType.ENUM) {
                                    this.f20946b[i] = new RepeatedEnumFieldAccessor(fieldDescriptor, this.f20947c[i], cls, cls2);
                                } else {
                                    this.f20946b[i] = new RepeatedFieldAccessor(this.f20947c[i], cls, cls2);
                                }
                            } else if (fieldDescriptor.m21232f() == JavaType.MESSAGE) {
                                this.f20946b[i] = new SingularMessageFieldAccessor(fieldDescriptor, this.f20947c[i], cls, cls2);
                            } else if (fieldDescriptor.m21232f() == JavaType.ENUM) {
                                this.f20946b[i] = new SingularEnumFieldAccessor(fieldDescriptor, this.f20947c[i], cls, cls2);
                            } else {
                                this.f20946b[i] = new SingularFieldAccessor(this.f20947c[i], cls, cls2);
                            }
                        }
                        this.f20948d = true;
                        this.f20947c = null;
                    }
                }
            }
            return this;
        }
    }

    protected abstract Message$Builder mo879a(BuilderParent builderParent);

    protected abstract FieldAccessorTable mo880h();

    protected GeneratedMessage() {
    }

    protected GeneratedMessage(byte b) {
    }

    public Parser<? extends Message> mo857i() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    public final Descriptor mo841e() {
        return mo880h().f20945a;
    }

    private Map<FieldDescriptor, Object> mo891j() {
        Map treeMap = new TreeMap();
        for (FieldDescriptor fieldDescriptor : mo880h().f20945a.m21196e()) {
            if (fieldDescriptor.m21239m()) {
                List list = (List) mo866b(fieldDescriptor);
                if (!list.isEmpty()) {
                    treeMap.put(fieldDescriptor, list);
                }
            } else if (mo862a(fieldDescriptor)) {
                treeMap.put(fieldDescriptor, mo866b(fieldDescriptor));
            }
        }
        return treeMap;
    }

    public boolean mo854a() {
        for (FieldDescriptor fieldDescriptor : mo841e().m21196e()) {
            if (fieldDescriptor.m21237k() && !mo862a(fieldDescriptor)) {
                return false;
            }
            if (fieldDescriptor.m21232f() == JavaType.MESSAGE) {
                if (fieldDescriptor.m21239m()) {
                    for (AbstractMessage a : (List) mo866b(fieldDescriptor)) {
                        if (!a.mo854a()) {
                            return false;
                        }
                    }
                    continue;
                } else if (mo862a(fieldDescriptor) && !((AbstractMessage) mo866b(fieldDescriptor)).mo854a()) {
                    return false;
                }
            }
        }
        return true;
    }

    public Map<FieldDescriptor, Object> lR_() {
        return Collections.unmodifiableMap(mo891j());
    }

    public boolean mo862a(FieldDescriptor fieldDescriptor) {
        return FieldAccessorTable.m21367a(mo880h(), fieldDescriptor).mo903b(this);
    }

    public Object mo866b(FieldDescriptor fieldDescriptor) {
        return FieldAccessorTable.m21367a(mo880h(), fieldDescriptor).mo899a(this);
    }

    public UnknownFieldSet mo868g() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    protected boolean mo889a(CodedInputStream codedInputStream, com.google.protobuf.UnknownFieldSet.Builder builder, ExtensionRegistryLite extensionRegistryLite, int i) {
        return builder.m21493a(i, codedInputStream);
    }

    protected void mo888E() {
    }

    public static Method m20368b(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (Throwable e) {
            throw new RuntimeException("Generated message class \"" + cls.getName() + "\" missing method \"" + str + "\".", e);
        }
    }

    public static Object m20367b(Method method, Object obj, Object... objArr) {
        Throwable e;
        try {
            return method.invoke(obj, objArr);
        } catch (Throwable e2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e2);
        } catch (InvocationTargetException e3) {
            e2 = e3.getCause();
            if (e2 instanceof RuntimeException) {
                throw ((RuntimeException) e2);
            } else if (e2 instanceof Error) {
                throw ((Error) e2);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", e2);
            }
        }
    }

    public Object writeReplace() {
        return new SerializedForm(this);
    }
}

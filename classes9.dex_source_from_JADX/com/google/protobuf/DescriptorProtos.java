package com.google.protobuf;

import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.EnumDescriptor;
import com.google.protobuf.Descriptors.EnumValueDescriptor;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner;
import com.google.protobuf.GeneratedMessage.BuilderParent;
import com.google.protobuf.GeneratedMessage.ExtendableBuilder;
import com.google.protobuf.GeneratedMessage.ExtendableMessage;
import com.google.protobuf.GeneratedMessage.ExtendableMessage.ExtensionWriter;
import com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder;
import com.google.protobuf.GeneratedMessage.FieldAccessorTable;
import com.google.protobuf.Internal.EnumLiteMap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: analytics_source */
public final class DescriptorProtos {
    public static Descriptor f20788A;
    public static FieldAccessorTable f20789B;
    public static Descriptor f20790C;
    public static FieldAccessorTable f20791D;
    public static Descriptor f20792E;
    public static FieldAccessorTable f20793F;
    public static Descriptor f20794G;
    public static FieldAccessorTable f20795H;
    public static Descriptor f20796I;
    public static FieldAccessorTable f20797J;
    public static Descriptor f20798K;
    public static FieldAccessorTable f20799L;
    public static Descriptor f20800M;
    public static FieldAccessorTable f20801N;
    public static FileDescriptor f20802O;
    public static Descriptor f20803a;
    public static FieldAccessorTable f20804b;
    public static Descriptor f20805c;
    public static FieldAccessorTable f20806d;
    public static Descriptor f20807e;
    public static FieldAccessorTable f20808f;
    public static Descriptor f20809g;
    public static FieldAccessorTable f20810h;
    public static Descriptor f20811i;
    public static FieldAccessorTable f20812j;
    public static Descriptor f20813k;
    public static FieldAccessorTable f20814l;
    public static Descriptor f20815m;
    public static FieldAccessorTable f20816n;
    public static Descriptor f20817o;
    public static FieldAccessorTable f20818p;
    public static Descriptor f20819q;
    public static FieldAccessorTable f20820r;
    public static Descriptor f20821s;
    public static FieldAccessorTable f20822t;
    public static Descriptor f20823u;
    public static FieldAccessorTable f20824v;
    public static Descriptor f20825w;
    public static FieldAccessorTable f20826x;
    public static Descriptor f20827y;
    public static FieldAccessorTable f20828z;

    /* compiled from: analytics_source */
    final class C24171 implements InternalDescriptorAssigner {
        C24171() {
        }

        public final ExtensionRegistry mo858a(FileDescriptor fileDescriptor) {
            DescriptorProtos.f20802O = fileDescriptor;
            DescriptorProtos.f20803a = (Descriptor) DescriptorProtos.f20802O.m21254d().get(0);
            DescriptorProtos.f20804b = new FieldAccessorTable(DescriptorProtos.f20803a, new String[]{"File"});
            DescriptorProtos.f20805c = (Descriptor) DescriptorProtos.f20802O.m21254d().get(1);
            DescriptorProtos.f20806d = new FieldAccessorTable(DescriptorProtos.f20805c, new String[]{"Name", "Package", "Dependency", "PublicDependency", "WeakDependency", "MessageType", "EnumType", "Service", "Extension", "Options", "SourceCodeInfo"});
            DescriptorProtos.f20807e = (Descriptor) DescriptorProtos.f20802O.m21254d().get(2);
            DescriptorProtos.f20808f = new FieldAccessorTable(DescriptorProtos.f20807e, new String[]{"Name", "Field", "Extension", "NestedType", "EnumType", "ExtensionRange", "Options"});
            DescriptorProtos.f20809g = (Descriptor) DescriptorProtos.f20807e.m21197f().get(0);
            DescriptorProtos.f20810h = new FieldAccessorTable(DescriptorProtos.f20809g, new String[]{"Start", "End"});
            DescriptorProtos.f20811i = (Descriptor) DescriptorProtos.f20802O.m21254d().get(3);
            DescriptorProtos.f20812j = new FieldAccessorTable(DescriptorProtos.f20811i, new String[]{"Name", "Number", "Label", "Type", "TypeName", "Extendee", "DefaultValue", "Options"});
            DescriptorProtos.f20813k = (Descriptor) DescriptorProtos.f20802O.m21254d().get(4);
            DescriptorProtos.f20814l = new FieldAccessorTable(DescriptorProtos.f20813k, new String[]{"Name", "Value", "Options"});
            DescriptorProtos.f20815m = (Descriptor) DescriptorProtos.f20802O.m21254d().get(5);
            DescriptorProtos.f20816n = new FieldAccessorTable(DescriptorProtos.f20815m, new String[]{"Name", "Number", "Options"});
            DescriptorProtos.f20817o = (Descriptor) DescriptorProtos.f20802O.m21254d().get(6);
            DescriptorProtos.f20818p = new FieldAccessorTable(DescriptorProtos.f20817o, new String[]{"Name", "Method", "Options"});
            DescriptorProtos.f20819q = (Descriptor) DescriptorProtos.f20802O.m21254d().get(7);
            DescriptorProtos.f20820r = new FieldAccessorTable(DescriptorProtos.f20819q, new String[]{"Name", "InputType", "OutputType", "Options"});
            DescriptorProtos.f20821s = (Descriptor) DescriptorProtos.f20802O.m21254d().get(8);
            DescriptorProtos.f20822t = new FieldAccessorTable(DescriptorProtos.f20821s, new String[]{"JavaPackage", "JavaOuterClassname", "JavaMultipleFiles", "JavaGenerateEqualsAndHash", "OptimizeFor", "GoPackage", "CcGenericServices", "JavaGenericServices", "PyGenericServices", "UninterpretedOption"});
            DescriptorProtos.f20823u = (Descriptor) DescriptorProtos.f20802O.m21254d().get(9);
            DescriptorProtos.f20824v = new FieldAccessorTable(DescriptorProtos.f20823u, new String[]{"MessageSetWireFormat", "NoStandardDescriptorAccessor", "UninterpretedOption"});
            DescriptorProtos.f20825w = (Descriptor) DescriptorProtos.f20802O.m21254d().get(10);
            DescriptorProtos.f20826x = new FieldAccessorTable(DescriptorProtos.f20825w, new String[]{"Ctype", "Packed", "Lazy", "Deprecated", "ExperimentalMapKey", "Weak", "UninterpretedOption"});
            DescriptorProtos.f20827y = (Descriptor) DescriptorProtos.f20802O.m21254d().get(11);
            DescriptorProtos.f20828z = new FieldAccessorTable(DescriptorProtos.f20827y, new String[]{"AllowAlias", "UninterpretedOption"});
            DescriptorProtos.f20788A = (Descriptor) DescriptorProtos.f20802O.m21254d().get(12);
            DescriptorProtos.f20789B = new FieldAccessorTable(DescriptorProtos.f20788A, new String[]{"UninterpretedOption"});
            DescriptorProtos.f20790C = (Descriptor) DescriptorProtos.f20802O.m21254d().get(13);
            DescriptorProtos.f20791D = new FieldAccessorTable(DescriptorProtos.f20790C, new String[]{"UninterpretedOption"});
            DescriptorProtos.f20792E = (Descriptor) DescriptorProtos.f20802O.m21254d().get(14);
            DescriptorProtos.f20793F = new FieldAccessorTable(DescriptorProtos.f20792E, new String[]{"UninterpretedOption"});
            DescriptorProtos.f20794G = (Descriptor) DescriptorProtos.f20802O.m21254d().get(15);
            DescriptorProtos.f20795H = new FieldAccessorTable(DescriptorProtos.f20794G, new String[]{"Name", "IdentifierValue", "PositiveIntValue", "NegativeIntValue", "DoubleValue", "StringValue", "AggregateValue"});
            DescriptorProtos.f20796I = (Descriptor) DescriptorProtos.f20794G.m21197f().get(0);
            DescriptorProtos.f20797J = new FieldAccessorTable(DescriptorProtos.f20796I, new String[]{"NamePart", "IsExtension"});
            DescriptorProtos.f20798K = (Descriptor) DescriptorProtos.f20802O.m21254d().get(16);
            DescriptorProtos.f20799L = new FieldAccessorTable(DescriptorProtos.f20798K, new String[]{"Location"});
            DescriptorProtos.f20800M = (Descriptor) DescriptorProtos.f20798K.m21197f().get(0);
            DescriptorProtos.f20801N = new FieldAccessorTable(DescriptorProtos.f20800M, new String[]{"Path", "Span", "LeadingComments", "TrailingComments"});
            return null;
        }
    }

    public interface DescriptorProtoOrBuilder extends MessageOrBuilder {
    }

    /* compiled from: analytics_source */
    public final class DescriptorProto extends GeneratedMessage implements DescriptorProtoOrBuilder {
        public static Parser<DescriptorProto> f20641a = new C24181();
        public static final DescriptorProto f20642c;
        public int bitField0_;
        public List<EnumDescriptorProto> enumType_;
        public List<ExtensionRange> extensionRange_;
        public List<FieldDescriptorProto> extension_;
        public List<FieldDescriptorProto> field_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        public Object name_;
        public List<DescriptorProto> nestedType_;
        public MessageOptions options_;
        private final UnknownFieldSet unknownFields;

        /* compiled from: analytics_source */
        final class C24181 extends AbstractParser<DescriptorProto> {
            C24181() {
            }

            public final Object mo859a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return new DescriptorProto(codedInputStream, extensionRegistryLite);
            }
        }

        /* compiled from: analytics_source */
        public final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> implements DescriptorProtoOrBuilder {
            public int f20621a;
            private Object f20622b = "";
            public List<FieldDescriptorProto> f20623c = Collections.emptyList();
            public RepeatedFieldBuilder<FieldDescriptorProto, Builder, FieldDescriptorProtoOrBuilder> f20624d;
            public List<FieldDescriptorProto> f20625e = Collections.emptyList();
            public RepeatedFieldBuilder<FieldDescriptorProto, Builder, FieldDescriptorProtoOrBuilder> f20626f;
            public List<DescriptorProto> f20627g = Collections.emptyList();
            public RepeatedFieldBuilder<DescriptorProto, Builder, DescriptorProtoOrBuilder> f20628h;
            public List<EnumDescriptorProto> f20629i = Collections.emptyList();
            public RepeatedFieldBuilder<EnumDescriptorProto, Builder, EnumDescriptorProtoOrBuilder> f20630j;
            public List<ExtensionRange> f20631k = Collections.emptyList();
            private RepeatedFieldBuilder<ExtensionRange, Builder, ExtensionRangeOrBuilder> f20632l;
            public MessageOptions f20633m = MessageOptions.f20733c;
            public SingleFieldBuilder<MessageOptions, Builder, MessageOptionsOrBuilder> f20634n;

            public final AbstractMessage mo878v() {
                return DescriptorProto.f20642c;
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo870a(AbstractMessage abstractMessage) {
                return m20318d(abstractMessage);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo871a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m20319d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo863b() {
                return m20322u();
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo846b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m20319d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo848c() {
                return m20322u();
            }

            public final /* synthetic */ Message$Builder mo849c(AbstractMessage abstractMessage) {
                return m20318d(abstractMessage);
            }

            public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo840c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m20319d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ Object clone() {
                return m20322u();
            }

            public final /* synthetic */ com.google.protobuf.GeneratedMessage.Builder mo873f() {
                return m20322u();
            }

            public final /* synthetic */ AbstractMessage mo874h() {
                return m20324y();
            }

            public final /* synthetic */ AbstractMessage mo875i() {
                return m20323x();
            }

            public final /* synthetic */ MessageLite mo876j() {
                return m20324y();
            }

            public final /* synthetic */ MessageLite mo877k() {
                return m20323x();
            }

            protected final FieldAccessorTable mo872d() {
                return DescriptorProtos.f20808f.m21368a(DescriptorProto.class, Builder.class);
            }

            private Builder() {
                m20320m();
            }

            public Builder(BuilderParent builderParent) {
                super(builderParent);
                m20320m();
            }

            private void m20320m() {
                if (GeneratedMessage.f20638b) {
                    m20313B();
                    m20314E();
                    m20315H();
                    m20316K();
                    m20317M();
                    if (this.f20634n == null) {
                        this.f20634n = new SingleFieldBuilder(this.f20633m, m20311s(), this.f20619c);
                        this.f20633m = null;
                    }
                    SingleFieldBuilder singleFieldBuilder = this.f20634n;
                }
            }

            public static Builder m20321n() {
                return new Builder();
            }

            private Builder m20322u() {
                return m20321n().m20327a(m20324y());
            }

            public final Descriptor mo841e() {
                return DescriptorProtos.f20807e;
            }

            private DescriptorProto m20323x() {
                AbstractMessage y = m20324y();
                if (y.mo854a()) {
                    return y;
                }
                throw com.google.protobuf.AbstractMessage.Builder.m20123b(y);
            }

            private DescriptorProto m20324y() {
                int i;
                int i2 = 1;
                DescriptorProto descriptorProto = new DescriptorProto(this);
                int i3 = this.f20621a;
                if ((i3 & 1) != 1) {
                    i2 = 0;
                }
                descriptorProto.name_ = this.f20622b;
                if (this.f20624d == null) {
                    if ((this.f20621a & 2) == 2) {
                        this.f20623c = Collections.unmodifiableList(this.f20623c);
                        this.f20621a &= -3;
                    }
                    descriptorProto.field_ = this.f20623c;
                } else {
                    descriptorProto.field_ = this.f20624d.m21416f();
                }
                if (this.f20626f == null) {
                    if ((this.f20621a & 4) == 4) {
                        this.f20625e = Collections.unmodifiableList(this.f20625e);
                        this.f20621a &= -5;
                    }
                    descriptorProto.extension_ = this.f20625e;
                } else {
                    descriptorProto.extension_ = this.f20626f.m21416f();
                }
                if (this.f20628h == null) {
                    if ((this.f20621a & 8) == 8) {
                        this.f20627g = Collections.unmodifiableList(this.f20627g);
                        this.f20621a &= -9;
                    }
                    descriptorProto.nestedType_ = this.f20627g;
                } else {
                    descriptorProto.nestedType_ = this.f20628h.m21416f();
                }
                if (this.f20630j == null) {
                    if ((this.f20621a & 16) == 16) {
                        this.f20629i = Collections.unmodifiableList(this.f20629i);
                        this.f20621a &= -17;
                    }
                    descriptorProto.enumType_ = this.f20629i;
                } else {
                    descriptorProto.enumType_ = this.f20630j.m21416f();
                }
                if (this.f20632l == null) {
                    if ((this.f20621a & 32) == 32) {
                        this.f20631k = Collections.unmodifiableList(this.f20631k);
                        this.f20621a &= -33;
                    }
                    descriptorProto.extensionRange_ = this.f20631k;
                } else {
                    descriptorProto.extensionRange_ = this.f20632l.m21416f();
                }
                if ((i3 & 64) == 64) {
                    i = i2 | 2;
                } else {
                    i = i2;
                }
                if (this.f20634n == null) {
                    descriptorProto.options_ = this.f20633m;
                } else {
                    descriptorProto.options_ = (MessageOptions) this.f20634n.m21442d();
                }
                descriptorProto.bitField0_ = i;
                m20309p();
                return descriptorProto;
            }

            private Builder m20318d(AbstractMessage abstractMessage) {
                if (abstractMessage instanceof DescriptorProto) {
                    return m20327a((DescriptorProto) abstractMessage);
                }
                super.mo870a(abstractMessage);
                return this;
            }

            public final Builder m20327a(DescriptorProto descriptorProto) {
                RepeatedFieldBuilder repeatedFieldBuilder = null;
                if (descriptorProto != DescriptorProto.f20642c) {
                    Object obj = 1;
                    if ((descriptorProto.bitField0_ & 1) != 1) {
                        obj = null;
                    }
                    if (obj != null) {
                        this.f20621a |= 1;
                        this.f20622b = descriptorProto.name_;
                        m20312t();
                    }
                    if (this.f20624d == null) {
                        if (!descriptorProto.field_.isEmpty()) {
                            if (this.f20623c.isEmpty()) {
                                this.f20623c = descriptorProto.field_;
                                this.f20621a &= -3;
                            } else {
                                if ((this.f20621a & 2) != 2) {
                                    this.f20623c = new ArrayList(this.f20623c);
                                    this.f20621a |= 2;
                                }
                                this.f20623c.addAll(descriptorProto.field_);
                            }
                            m20312t();
                        }
                    } else if (!descriptorProto.field_.isEmpty()) {
                        if (this.f20624d.m21414d()) {
                            this.f20624d.m21411b();
                            this.f20624d = null;
                            this.f20623c = descriptorProto.field_;
                            this.f20621a &= -3;
                            this.f20624d = GeneratedMessage.f20638b ? m20313B() : null;
                        } else {
                            this.f20624d.m21409a(descriptorProto.field_);
                        }
                    }
                    if (this.f20626f == null) {
                        if (!descriptorProto.extension_.isEmpty()) {
                            if (this.f20625e.isEmpty()) {
                                this.f20625e = descriptorProto.extension_;
                                this.f20621a &= -5;
                            } else {
                                if ((this.f20621a & 4) != 4) {
                                    this.f20625e = new ArrayList(this.f20625e);
                                    this.f20621a |= 4;
                                }
                                this.f20625e.addAll(descriptorProto.extension_);
                            }
                            m20312t();
                        }
                    } else if (!descriptorProto.extension_.isEmpty()) {
                        if (this.f20626f.m21414d()) {
                            this.f20626f.m21411b();
                            this.f20626f = null;
                            this.f20625e = descriptorProto.extension_;
                            this.f20621a &= -5;
                            this.f20626f = GeneratedMessage.f20638b ? m20314E() : null;
                        } else {
                            this.f20626f.m21409a(descriptorProto.extension_);
                        }
                    }
                    if (this.f20628h == null) {
                        if (!descriptorProto.nestedType_.isEmpty()) {
                            if (this.f20627g.isEmpty()) {
                                this.f20627g = descriptorProto.nestedType_;
                                this.f20621a &= -9;
                            } else {
                                if ((this.f20621a & 8) != 8) {
                                    this.f20627g = new ArrayList(this.f20627g);
                                    this.f20621a |= 8;
                                }
                                this.f20627g.addAll(descriptorProto.nestedType_);
                            }
                            m20312t();
                        }
                    } else if (!descriptorProto.nestedType_.isEmpty()) {
                        if (this.f20628h.m21414d()) {
                            this.f20628h.m21411b();
                            this.f20628h = null;
                            this.f20627g = descriptorProto.nestedType_;
                            this.f20621a &= -9;
                            this.f20628h = GeneratedMessage.f20638b ? m20315H() : null;
                        } else {
                            this.f20628h.m21409a(descriptorProto.nestedType_);
                        }
                    }
                    if (this.f20630j == null) {
                        if (!descriptorProto.enumType_.isEmpty()) {
                            if (this.f20629i.isEmpty()) {
                                this.f20629i = descriptorProto.enumType_;
                                this.f20621a &= -17;
                            } else {
                                if ((this.f20621a & 16) != 16) {
                                    this.f20629i = new ArrayList(this.f20629i);
                                    this.f20621a |= 16;
                                }
                                this.f20629i.addAll(descriptorProto.enumType_);
                            }
                            m20312t();
                        }
                    } else if (!descriptorProto.enumType_.isEmpty()) {
                        if (this.f20630j.m21414d()) {
                            this.f20630j.m21411b();
                            this.f20630j = null;
                            this.f20629i = descriptorProto.enumType_;
                            this.f20621a &= -17;
                            this.f20630j = GeneratedMessage.f20638b ? m20316K() : null;
                        } else {
                            this.f20630j.m21409a(descriptorProto.enumType_);
                        }
                    }
                    if (this.f20632l == null) {
                        if (!descriptorProto.extensionRange_.isEmpty()) {
                            if (this.f20631k.isEmpty()) {
                                this.f20631k = descriptorProto.extensionRange_;
                                this.f20621a &= -33;
                            } else {
                                if ((this.f20621a & 32) != 32) {
                                    this.f20631k = new ArrayList(this.f20631k);
                                    this.f20621a |= 32;
                                }
                                this.f20631k.addAll(descriptorProto.extensionRange_);
                            }
                            m20312t();
                        }
                    } else if (!descriptorProto.extensionRange_.isEmpty()) {
                        if (this.f20632l.m21414d()) {
                            this.f20632l.m21411b();
                            this.f20632l = null;
                            this.f20631k = descriptorProto.extensionRange_;
                            this.f20621a &= -33;
                            if (GeneratedMessage.f20638b) {
                                repeatedFieldBuilder = m20317M();
                            }
                            this.f20632l = repeatedFieldBuilder;
                        } else {
                            this.f20632l.m21409a(descriptorProto.extensionRange_);
                        }
                    }
                    if (descriptorProto.m20412q()) {
                        MessageOptions messageOptions = descriptorProto.options_;
                        if (this.f20634n == null) {
                            if ((this.f20621a & 64) != 64 || this.f20633m == MessageOptions.f20733c) {
                                this.f20633m = messageOptions;
                            } else {
                                this.f20633m = MessageOptions.m20837a(this.f20633m).m20820a(messageOptions).mo886l();
                            }
                            m20312t();
                        } else {
                            this.f20634n.m21439b(messageOptions);
                        }
                        this.f20621a |= 64;
                    }
                    m20301c(descriptorProto.mo868g());
                }
                return this;
            }

            public final boolean mo854a() {
                int size;
                Object obj;
                int i = 0;
                while (true) {
                    if (this.f20624d == null) {
                        size = this.f20623c.size();
                    } else {
                        size = this.f20624d.m21412c();
                    }
                    if (i >= size) {
                        break;
                    }
                    if (this.f20624d == null) {
                        AbstractMessage abstractMessage = (FieldDescriptorProto) this.f20623c.get(i);
                    } else {
                        FieldDescriptorProto fieldDescriptorProto = (FieldDescriptorProto) this.f20624d.m21406a(i);
                    }
                    if (!abstractMessage.mo854a()) {
                        return false;
                    }
                    i++;
                }
                i = 0;
                while (true) {
                    if (this.f20626f == null) {
                        size = this.f20625e.size();
                    } else {
                        size = this.f20626f.m21412c();
                    }
                    if (i >= size) {
                        break;
                    }
                    if (this.f20626f == null) {
                        abstractMessage = (FieldDescriptorProto) this.f20625e.get(i);
                    } else {
                        fieldDescriptorProto = (FieldDescriptorProto) this.f20626f.m21406a(i);
                    }
                    if (!abstractMessage.mo854a()) {
                        return false;
                    }
                    i++;
                }
                i = 0;
                while (true) {
                    if (this.f20628h == null) {
                        size = this.f20627g.size();
                    } else {
                        size = this.f20628h.m21412c();
                    }
                    if (i >= size) {
                        break;
                    }
                    if (this.f20628h == null) {
                        abstractMessage = (DescriptorProto) this.f20627g.get(i);
                    } else {
                        DescriptorProto descriptorProto = (DescriptorProto) this.f20628h.m21406a(i);
                    }
                    if (!abstractMessage.mo854a()) {
                        return false;
                    }
                    i++;
                }
                i = 0;
                while (true) {
                    if (this.f20630j == null) {
                        size = this.f20629i.size();
                    } else {
                        size = this.f20630j.m21412c();
                    }
                    if (i >= size) {
                        break;
                    }
                    if (this.f20630j == null) {
                        abstractMessage = (EnumDescriptorProto) this.f20629i.get(i);
                    } else {
                        EnumDescriptorProto enumDescriptorProto = (EnumDescriptorProto) this.f20630j.m21406a(i);
                    }
                    if (!abstractMessage.mo854a()) {
                        return false;
                    }
                    i++;
                }
                if ((this.f20621a & 64) == 64) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    if (this.f20634n == null) {
                        abstractMessage = this.f20633m;
                    } else {
                        MessageOptions messageOptions = (MessageOptions) this.f20634n.m21441c();
                    }
                    if (!abstractMessage.mo854a()) {
                        return false;
                    }
                }
                return true;
            }

            private Builder m20319d(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                Throwable th;
                DescriptorProto descriptorProto;
                DescriptorProto descriptorProto2;
                try {
                    descriptorProto2 = (DescriptorProto) DescriptorProto.f20641a.mo859a(codedInputStream, extensionRegistryLite);
                    if (descriptorProto2 != null) {
                        m20327a(descriptorProto2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    InvalidProtocolBufferException invalidProtocolBufferException = e;
                    descriptorProto2 = (DescriptorProto) invalidProtocolBufferException.m21375a();
                    throw invalidProtocolBufferException;
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    descriptorProto = descriptorProto2;
                    th = th3;
                }
                if (descriptorProto != null) {
                    m20327a(descriptorProto);
                }
                throw th;
            }

            private RepeatedFieldBuilder<FieldDescriptorProto, Builder, FieldDescriptorProtoOrBuilder> m20313B() {
                if (this.f20624d == null) {
                    this.f20624d = new RepeatedFieldBuilder(this.f20623c, (this.f20621a & 2) == 2, m20311s(), this.f20619c);
                    this.f20623c = null;
                }
                return this.f20624d;
            }

            private RepeatedFieldBuilder<FieldDescriptorProto, Builder, FieldDescriptorProtoOrBuilder> m20314E() {
                if (this.f20626f == null) {
                    this.f20626f = new RepeatedFieldBuilder(this.f20625e, (this.f20621a & 4) == 4, m20311s(), this.f20619c);
                    this.f20625e = null;
                }
                return this.f20626f;
            }

            private RepeatedFieldBuilder<DescriptorProto, Builder, DescriptorProtoOrBuilder> m20315H() {
                if (this.f20628h == null) {
                    this.f20628h = new RepeatedFieldBuilder(this.f20627g, (this.f20621a & 8) == 8, m20311s(), this.f20619c);
                    this.f20627g = null;
                }
                return this.f20628h;
            }

            private RepeatedFieldBuilder<EnumDescriptorProto, Builder, EnumDescriptorProtoOrBuilder> m20316K() {
                if (this.f20630j == null) {
                    this.f20630j = new RepeatedFieldBuilder(this.f20629i, (this.f20621a & 16) == 16, m20311s(), this.f20619c);
                    this.f20629i = null;
                }
                return this.f20630j;
            }

            private RepeatedFieldBuilder<ExtensionRange, Builder, ExtensionRangeOrBuilder> m20317M() {
                if (this.f20632l == null) {
                    this.f20632l = new RepeatedFieldBuilder(this.f20631k, (this.f20621a & 32) == 32, m20311s(), this.f20619c);
                    this.f20631k = null;
                }
                return this.f20632l;
            }
        }

        public interface ExtensionRangeOrBuilder extends MessageOrBuilder {
        }

        /* compiled from: analytics_source */
        public final class ExtensionRange extends GeneratedMessage implements ExtensionRangeOrBuilder {
            public static Parser<ExtensionRange> f20639a = new C24191();
            public static final ExtensionRange f20640c;
            public int bitField0_;
            public int end_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            public int start_;
            private final UnknownFieldSet unknownFields;

            /* compiled from: analytics_source */
            final class C24191 extends AbstractParser<ExtensionRange> {
                C24191() {
                }

                public final Object mo859a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                    return new ExtensionRange(codedInputStream, extensionRegistryLite);
                }
            }

            /* compiled from: analytics_source */
            public final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> implements ExtensionRangeOrBuilder {
                public int f20635a;
                public int f20636b;
                public int f20637c;

                public final Builder m20351a(ExtensionRange extensionRange) {
                    if (extensionRange != ExtensionRange.f20640c) {
                        int i;
                        Object obj = 1;
                        if ((extensionRange.bitField0_ & 1) != 1) {
                            obj = null;
                        }
                        if (obj != null) {
                            i = extensionRange.start_;
                            this.f20635a |= 1;
                            this.f20636b = i;
                            m20312t();
                        }
                        if ((extensionRange.bitField0_ & 2) == 2) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (obj != null) {
                            i = extensionRange.end_;
                            this.f20635a |= 2;
                            this.f20637c = i;
                            m20312t();
                        }
                        m20301c(extensionRange.mo868g());
                    }
                    return this;
                }

                public final AbstractMessage mo878v() {
                    return ExtensionRange.f20640c;
                }

                public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo870a(AbstractMessage abstractMessage) {
                    return m20343d(abstractMessage);
                }

                public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo871a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                    return m20344d(codedInputStream, extensionRegistryLite);
                }

                public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo863b() {
                    return m20346n();
                }

                public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo846b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                    return m20344d(codedInputStream, extensionRegistryLite);
                }

                public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo848c() {
                    return m20346n();
                }

                public final /* synthetic */ Message$Builder mo849c(AbstractMessage abstractMessage) {
                    return m20343d(abstractMessage);
                }

                public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo840c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                    return m20344d(codedInputStream, extensionRegistryLite);
                }

                public final /* synthetic */ Object clone() {
                    return m20346n();
                }

                public final /* synthetic */ com.google.protobuf.GeneratedMessage.Builder mo873f() {
                    return m20346n();
                }

                public final /* synthetic */ AbstractMessage mo874h() {
                    return m20348x();
                }

                public final /* synthetic */ AbstractMessage mo875i() {
                    return m20347w();
                }

                public final /* synthetic */ MessageLite mo876j() {
                    return m20348x();
                }

                public final /* synthetic */ MessageLite mo877k() {
                    return m20347w();
                }

                protected final FieldAccessorTable mo872d() {
                    return DescriptorProtos.f20810h.m21368a(ExtensionRange.class, Builder.class);
                }

                private Builder() {
                }

                public Builder(BuilderParent builderParent) {
                    super(builderParent);
                }

                public static Builder m20345m() {
                    return new Builder();
                }

                private Builder m20346n() {
                    return m20345m().m20351a(m20348x());
                }

                public final Descriptor mo841e() {
                    return DescriptorProtos.f20809g;
                }

                private ExtensionRange m20347w() {
                    AbstractMessage x = m20348x();
                    if (x.mo854a()) {
                        return x;
                    }
                    throw com.google.protobuf.AbstractMessage.Builder.m20123b(x);
                }

                private ExtensionRange m20348x() {
                    int i = 1;
                    ExtensionRange extensionRange = new ExtensionRange(this);
                    int i2 = this.f20635a;
                    if ((i2 & 1) != 1) {
                        i = 0;
                    }
                    extensionRange.start_ = this.f20636b;
                    if ((i2 & 2) == 2) {
                        i |= 2;
                    }
                    extensionRange.end_ = this.f20637c;
                    extensionRange.bitField0_ = i;
                    m20309p();
                    return extensionRange;
                }

                private Builder m20343d(AbstractMessage abstractMessage) {
                    if (abstractMessage instanceof ExtensionRange) {
                        return m20351a((ExtensionRange) abstractMessage);
                    }
                    super.mo870a(abstractMessage);
                    return this;
                }

                public final boolean mo854a() {
                    return true;
                }

                private Builder m20344d(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                    ExtensionRange extensionRange;
                    Throwable th;
                    ExtensionRange extensionRange2;
                    try {
                        extensionRange = (ExtensionRange) ExtensionRange.f20639a.mo859a(codedInputStream, extensionRegistryLite);
                        if (extensionRange != null) {
                            m20351a(extensionRange);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        InvalidProtocolBufferException invalidProtocolBufferException = e;
                        extensionRange = (ExtensionRange) invalidProtocolBufferException.m21375a();
                        throw invalidProtocolBufferException;
                    } catch (Throwable th2) {
                        Throwable th3 = th2;
                        extensionRange2 = extensionRange;
                        th = th3;
                    }
                    if (extensionRange2 != null) {
                        m20351a(extensionRange2);
                    }
                    throw th;
                }
            }

            public final /* synthetic */ Message$Builder mo881s() {
                return m20380a(this);
            }

            public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo883u() {
                return m20380a(this);
            }

            public ExtensionRange(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
                super((byte) 0);
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = builder.mo868g();
            }

            private ExtensionRange() {
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = UnknownFieldSet.f21031a;
            }

            public final AbstractMessage mo878v() {
                return f20640c;
            }

            public final UnknownFieldSet mo868g() {
                return this.unknownFields;
            }

            public ExtensionRange(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                m20381o();
                com.google.protobuf.UnknownFieldSet.Builder e = com.google.protobuf.UnknownFieldSet.Builder.m21487e();
                Object obj = null;
                while (obj == null) {
                    try {
                        int a = codedInputStream.m20202a();
                        switch (a) {
                            case 0:
                                obj = 1;
                                break;
                            case 8:
                                this.bitField0_ |= 1;
                                this.start_ = codedInputStream.m20214f();
                                break;
                            case 16:
                                this.bitField0_ |= 2;
                                this.end_ = codedInputStream.m20214f();
                                break;
                            default:
                                if (!mo889a(codedInputStream, e, extensionRegistryLite, a)) {
                                    obj = 1;
                                    break;
                                }
                                break;
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.m21374a(this);
                    } catch (IOException e3) {
                        throw new InvalidProtocolBufferException(e3.getMessage()).m21374a(this);
                    } catch (Throwable th) {
                        this.unknownFields = e.m21495b();
                        mo888E();
                    }
                }
                this.unknownFields = e.m21495b();
                mo888E();
            }

            protected final FieldAccessorTable mo880h() {
                return DescriptorProtos.f20810h.m21368a(ExtensionRange.class, Builder.class);
            }

            static {
                ExtensionRange extensionRange = new ExtensionRange();
                f20640c = extensionRange;
                extensionRange.m20381o();
            }

            public final Parser<ExtensionRange> mo857i() {
                return f20639a;
            }

            private void m20381o() {
                this.start_ = 0;
                this.end_ = 0;
            }

            public final boolean mo854a() {
                byte b = this.memoizedIsInitialized;
                if (b == (byte) -1) {
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                } else if (b == (byte) 1) {
                    return true;
                } else {
                    return false;
                }
            }

            public final void mo853a(CodedOutputStream codedOutputStream) {
                mo855b();
                if ((this.bitField0_ & 1) == 1) {
                    codedOutputStream.m20262a(1, this.start_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.m20262a(2, this.end_);
                }
                mo868g().mo853a(codedOutputStream);
            }

            public final int mo855b() {
                int i = this.memoizedSerializedSize;
                if (i != -1) {
                    return i;
                }
                i = 0;
                if ((this.bitField0_ & 1) == 1) {
                    i = CodedOutputStream.m20241e(1, this.start_) + 0;
                }
                if ((this.bitField0_ & 2) == 2) {
                    i += CodedOutputStream.m20241e(2, this.end_);
                }
                i += mo868g().mo855b();
                this.memoizedSerializedSize = i;
                return i;
            }

            public final Message$Builder mo882t() {
                return Builder.m20345m();
            }

            private static Builder m20380a(ExtensionRange extensionRange) {
                return Builder.m20345m().m20351a(extensionRange);
            }

            protected final Message$Builder mo879a(BuilderParent builderParent) {
                return new Builder(builderParent);
            }
        }

        public final /* synthetic */ Message$Builder mo881s() {
            return m20393g(this);
        }

        public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo883u() {
            return m20393g(this);
        }

        public DescriptorProto(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
            super((byte) 0);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.mo868g();
        }

        private DescriptorProto() {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.f21031a;
        }

        public final AbstractMessage mo878v() {
            return f20642c;
        }

        public final UnknownFieldSet mo868g() {
            return this.unknownFields;
        }

        public DescriptorProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            m20395y();
            int i = 0;
            com.google.protobuf.UnknownFieldSet.Builder e = com.google.protobuf.UnknownFieldSet.Builder.m21487e();
            Object obj = null;
            while (obj == null) {
                try {
                    int a = codedInputStream.m20202a();
                    switch (a) {
                        case 0:
                            obj = 1;
                            break;
                        case 10:
                            this.bitField0_ |= 1;
                            this.name_ = codedInputStream.m20219k();
                            break;
                        case 18:
                            if ((i & 2) != 2) {
                                this.field_ = new ArrayList();
                                i |= 2;
                            }
                            this.field_.add(codedInputStream.m20203a(FieldDescriptorProto.f20680a, extensionRegistryLite));
                            break;
                        case 26:
                            if ((i & 8) != 8) {
                                this.nestedType_ = new ArrayList();
                                i |= 8;
                            }
                            this.nestedType_.add(codedInputStream.m20203a(f20641a, extensionRegistryLite));
                            break;
                        case 34:
                            if ((i & 16) != 16) {
                                this.enumType_ = new ArrayList();
                                i |= 16;
                            }
                            this.enumType_.add(codedInputStream.m20203a(EnumDescriptorProto.f20649a, extensionRegistryLite));
                            break;
                        case 42:
                            if ((i & 32) != 32) {
                                this.extensionRange_ = new ArrayList();
                                i |= 32;
                            }
                            this.extensionRange_.add(codedInputStream.m20203a(ExtensionRange.f20639a, extensionRegistryLite));
                            break;
                        case 50:
                            if ((i & 4) != 4) {
                                this.extension_ = new ArrayList();
                                i |= 4;
                            }
                            this.extension_.add(codedInputStream.m20203a(FieldDescriptorProto.f20680a, extensionRegistryLite));
                            break;
                        case 58:
                            Builder n;
                            if ((this.bitField0_ & 2) == 2) {
                                n = this.options_.m20847n();
                            } else {
                                n = null;
                            }
                            this.options_ = (MessageOptions) codedInputStream.m20203a(MessageOptions.f20732a, extensionRegistryLite);
                            if (n != null) {
                                n.m20820a(this.options_);
                                this.options_ = n.mo886l();
                            }
                            this.bitField0_ |= 2;
                            break;
                        default:
                            if (!mo889a(codedInputStream, e, extensionRegistryLite, a)) {
                                obj = 1;
                                break;
                            }
                            break;
                    }
                } catch (InvalidProtocolBufferException e2) {
                    throw e2.m21374a(this);
                } catch (IOException e3) {
                    throw new InvalidProtocolBufferException(e3.getMessage()).m21374a(this);
                } catch (Throwable th) {
                    if ((i & 2) == 2) {
                        this.field_ = Collections.unmodifiableList(this.field_);
                    }
                    if ((i & 8) == 8) {
                        this.nestedType_ = Collections.unmodifiableList(this.nestedType_);
                    }
                    if ((i & 16) == 16) {
                        this.enumType_ = Collections.unmodifiableList(this.enumType_);
                    }
                    if ((i & 32) == 32) {
                        this.extensionRange_ = Collections.unmodifiableList(this.extensionRange_);
                    }
                    if ((i & 4) == 4) {
                        this.extension_ = Collections.unmodifiableList(this.extension_);
                    }
                    this.unknownFields = e.m21495b();
                    mo888E();
                }
            }
            if ((i & 2) == 2) {
                this.field_ = Collections.unmodifiableList(this.field_);
            }
            if ((i & 8) == 8) {
                this.nestedType_ = Collections.unmodifiableList(this.nestedType_);
            }
            if ((i & 16) == 16) {
                this.enumType_ = Collections.unmodifiableList(this.enumType_);
            }
            if ((i & 32) == 32) {
                this.extensionRange_ = Collections.unmodifiableList(this.extensionRange_);
            }
            if ((i & 4) == 4) {
                this.extension_ = Collections.unmodifiableList(this.extension_);
            }
            this.unknownFields = e.m21495b();
            mo888E();
        }

        protected final FieldAccessorTable mo880h() {
            return DescriptorProtos.f20808f.m21368a(DescriptorProto.class, Builder.class);
        }

        static {
            DescriptorProto descriptorProto = new DescriptorProto();
            f20642c = descriptorProto;
            descriptorProto.m20395y();
        }

        public final Parser<DescriptorProto> mo857i() {
            return f20641a;
        }

        public final String m20407k() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String e = byteString.m20186e();
            if (byteString.mo916f()) {
                this.name_ = e;
            }
            return e;
        }

        private ByteString m20394x() {
            Object obj = this.name_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString a = ByteString.m20173a((String) obj);
            this.name_ = a;
            return a;
        }

        public final int m20408l() {
            return this.field_.size();
        }

        public final FieldDescriptorProto m20396a(int i) {
            return (FieldDescriptorProto) this.field_.get(i);
        }

        public final int m20409m() {
            return this.extension_.size();
        }

        public final FieldDescriptorProto m20401b(int i) {
            return (FieldDescriptorProto) this.extension_.get(i);
        }

        public final int m20410n() {
            return this.nestedType_.size();
        }

        public final DescriptorProto m20402c(int i) {
            return (DescriptorProto) this.nestedType_.get(i);
        }

        public final int m20411o() {
            return this.enumType_.size();
        }

        public final EnumDescriptorProto m20403d(int i) {
            return (EnumDescriptorProto) this.enumType_.get(i);
        }

        public final boolean m20412q() {
            return (this.bitField0_ & 2) == 2;
        }

        private void m20395y() {
            this.name_ = "";
            this.field_ = Collections.emptyList();
            this.extension_ = Collections.emptyList();
            this.nestedType_ = Collections.emptyList();
            this.enumType_ = Collections.emptyList();
            this.extensionRange_ = Collections.emptyList();
            this.options_ = MessageOptions.f20733c;
        }

        public final boolean mo854a() {
            byte b = this.memoizedIsInitialized;
            if (b == (byte) -1) {
                int i = 0;
                while (i < m20408l()) {
                    if (m20396a(i).mo854a()) {
                        i++;
                    } else {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                i = 0;
                while (i < m20409m()) {
                    if (m20401b(i).mo854a()) {
                        i++;
                    } else {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                i = 0;
                while (i < m20410n()) {
                    if (m20402c(i).mo854a()) {
                        i++;
                    } else {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                i = 0;
                while (i < m20411o()) {
                    if (m20403d(i).mo854a()) {
                        i++;
                    } else {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                if (!m20412q() || this.options_.mo854a()) {
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                }
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (b == (byte) 1) {
                return true;
            } else {
                return false;
            }
        }

        public final void mo853a(CodedOutputStream codedOutputStream) {
            int i;
            int i2 = 0;
            mo855b();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.m20264a(1, m20394x());
            }
            for (i = 0; i < this.field_.size(); i++) {
                codedOutputStream.m20273b(2, (MessageLite) this.field_.get(i));
            }
            for (i = 0; i < this.nestedType_.size(); i++) {
                codedOutputStream.m20273b(3, (MessageLite) this.nestedType_.get(i));
            }
            for (i = 0; i < this.enumType_.size(); i++) {
                codedOutputStream.m20273b(4, (MessageLite) this.enumType_.get(i));
            }
            for (i = 0; i < this.extensionRange_.size(); i++) {
                codedOutputStream.m20273b(5, (MessageLite) this.extensionRange_.get(i));
            }
            while (i2 < this.extension_.size()) {
                codedOutputStream.m20273b(6, (MessageLite) this.extension_.get(i2));
                i2++;
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.m20273b(7, this.options_);
            }
            mo868g().mo853a(codedOutputStream);
        }

        public final int mo855b() {
            int i = 0;
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int i3;
            if ((this.bitField0_ & 1) == 1) {
                i2 = CodedOutputStream.m20236c(1, m20394x()) + 0;
            } else {
                i2 = 0;
            }
            int i4 = i2;
            for (i3 = 0; i3 < this.field_.size(); i3++) {
                i4 += CodedOutputStream.m20242e(2, (MessageLite) this.field_.get(i3));
            }
            for (i3 = 0; i3 < this.nestedType_.size(); i3++) {
                i4 += CodedOutputStream.m20242e(3, (MessageLite) this.nestedType_.get(i3));
            }
            for (i3 = 0; i3 < this.enumType_.size(); i3++) {
                i4 += CodedOutputStream.m20242e(4, (MessageLite) this.enumType_.get(i3));
            }
            for (i3 = 0; i3 < this.extensionRange_.size(); i3++) {
                i4 += CodedOutputStream.m20242e(5, (MessageLite) this.extensionRange_.get(i3));
            }
            while (i < this.extension_.size()) {
                i4 += CodedOutputStream.m20242e(6, (MessageLite) this.extension_.get(i));
                i++;
            }
            if ((this.bitField0_ & 2) == 2) {
                i4 += CodedOutputStream.m20242e(7, this.options_);
            }
            i2 = mo868g().mo855b() + i4;
            this.memoizedSerializedSize = i2;
            return i2;
        }

        public final Message$Builder mo882t() {
            return Builder.m20321n();
        }

        private static Builder m20393g(DescriptorProto descriptorProto) {
            return Builder.m20321n().m20327a(descriptorProto);
        }

        protected final Message$Builder mo879a(BuilderParent builderParent) {
            return new Builder(builderParent);
        }
    }

    public interface EnumDescriptorProtoOrBuilder extends MessageOrBuilder {
    }

    /* compiled from: analytics_source */
    public final class EnumDescriptorProto extends GeneratedMessage implements EnumDescriptorProtoOrBuilder {
        public static Parser<EnumDescriptorProto> f20649a = new C24201();
        public static final EnumDescriptorProto f20650c;
        public int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        public Object name_;
        public EnumOptions options_;
        private final UnknownFieldSet unknownFields;
        public List<EnumValueDescriptorProto> value_;

        /* compiled from: analytics_source */
        final class C24201 extends AbstractParser<EnumDescriptorProto> {
            C24201() {
            }

            public final Object mo859a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return new EnumDescriptorProto(codedInputStream, extensionRegistryLite);
            }
        }

        /* compiled from: analytics_source */
        public final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> implements EnumDescriptorProtoOrBuilder {
            public int f20643a;
            private Object f20644b = "";
            public List<EnumValueDescriptorProto> f20645c = Collections.emptyList();
            public RepeatedFieldBuilder<EnumValueDescriptorProto, Builder, EnumValueDescriptorProtoOrBuilder> f20646d;
            public EnumOptions f20647e = EnumOptions.f20657c;
            public SingleFieldBuilder<EnumOptions, Builder, EnumOptionsOrBuilder> f20648f;

            public final AbstractMessage mo878v() {
                return EnumDescriptorProto.f20650c;
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo870a(AbstractMessage abstractMessage) {
                return m20419d(abstractMessage);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo871a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m20420d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo863b() {
                return m20423u();
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo846b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m20420d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo848c() {
                return m20423u();
            }

            public final /* synthetic */ Message$Builder mo849c(AbstractMessage abstractMessage) {
                return m20419d(abstractMessage);
            }

            public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo840c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m20420d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ Object clone() {
                return m20423u();
            }

            public final /* synthetic */ com.google.protobuf.GeneratedMessage.Builder mo873f() {
                return m20423u();
            }

            public final /* synthetic */ AbstractMessage mo874h() {
                return m20425y();
            }

            public final /* synthetic */ AbstractMessage mo875i() {
                return m20424x();
            }

            public final /* synthetic */ MessageLite mo876j() {
                return m20425y();
            }

            public final /* synthetic */ MessageLite mo877k() {
                return m20424x();
            }

            protected final FieldAccessorTable mo872d() {
                return DescriptorProtos.f20814l.m21368a(EnumDescriptorProto.class, Builder.class);
            }

            private Builder() {
                m20421m();
            }

            public Builder(BuilderParent builderParent) {
                super(builderParent);
                m20421m();
            }

            private void m20421m() {
                if (GeneratedMessage.f20638b) {
                    m20418B();
                    if (this.f20648f == null) {
                        this.f20648f = new SingleFieldBuilder(this.f20647e, m20311s(), this.f20619c);
                        this.f20647e = null;
                    }
                    SingleFieldBuilder singleFieldBuilder = this.f20648f;
                }
            }

            public static Builder m20422n() {
                return new Builder();
            }

            private Builder m20423u() {
                return m20422n().m20428a(m20425y());
            }

            public final Descriptor mo841e() {
                return DescriptorProtos.f20813k;
            }

            private EnumDescriptorProto m20424x() {
                AbstractMessage y = m20425y();
                if (y.mo854a()) {
                    return y;
                }
                throw com.google.protobuf.AbstractMessage.Builder.m20123b(y);
            }

            private EnumDescriptorProto m20425y() {
                int i;
                int i2 = 1;
                EnumDescriptorProto enumDescriptorProto = new EnumDescriptorProto(this);
                int i3 = this.f20643a;
                if ((i3 & 1) != 1) {
                    i2 = 0;
                }
                enumDescriptorProto.name_ = this.f20644b;
                if (this.f20646d == null) {
                    if ((this.f20643a & 2) == 2) {
                        this.f20645c = Collections.unmodifiableList(this.f20645c);
                        this.f20643a &= -3;
                    }
                    enumDescriptorProto.value_ = this.f20645c;
                } else {
                    enumDescriptorProto.value_ = this.f20646d.m21416f();
                }
                if ((i3 & 4) == 4) {
                    i = i2 | 2;
                } else {
                    i = i2;
                }
                if (this.f20648f == null) {
                    enumDescriptorProto.options_ = this.f20647e;
                } else {
                    enumDescriptorProto.options_ = (EnumOptions) this.f20648f.m21442d();
                }
                enumDescriptorProto.bitField0_ = i;
                m20309p();
                return enumDescriptorProto;
            }

            private Builder m20419d(AbstractMessage abstractMessage) {
                if (abstractMessage instanceof EnumDescriptorProto) {
                    return m20428a((EnumDescriptorProto) abstractMessage);
                }
                super.mo870a(abstractMessage);
                return this;
            }

            public final Builder m20428a(EnumDescriptorProto enumDescriptorProto) {
                RepeatedFieldBuilder repeatedFieldBuilder = null;
                if (enumDescriptorProto != EnumDescriptorProto.f20650c) {
                    Object obj = 1;
                    if ((enumDescriptorProto.bitField0_ & 1) != 1) {
                        obj = null;
                    }
                    if (obj != null) {
                        this.f20643a |= 1;
                        this.f20644b = enumDescriptorProto.name_;
                        m20312t();
                    }
                    if (this.f20646d == null) {
                        if (!enumDescriptorProto.value_.isEmpty()) {
                            if (this.f20645c.isEmpty()) {
                                this.f20645c = enumDescriptorProto.value_;
                                this.f20643a &= -3;
                            } else {
                                if ((this.f20643a & 2) != 2) {
                                    this.f20645c = new ArrayList(this.f20645c);
                                    this.f20643a |= 2;
                                }
                                this.f20645c.addAll(enumDescriptorProto.value_);
                            }
                            m20312t();
                        }
                    } else if (!enumDescriptorProto.value_.isEmpty()) {
                        if (this.f20646d.m21414d()) {
                            this.f20646d.m21411b();
                            this.f20646d = null;
                            this.f20645c = enumDescriptorProto.value_;
                            this.f20643a &= -3;
                            if (GeneratedMessage.f20638b) {
                                repeatedFieldBuilder = m20418B();
                            }
                            this.f20646d = repeatedFieldBuilder;
                        } else {
                            this.f20646d.m21409a(enumDescriptorProto.value_);
                        }
                    }
                    if (enumDescriptorProto.m20456m()) {
                        EnumOptions enumOptions = enumDescriptorProto.options_;
                        if (this.f20648f == null) {
                            if ((this.f20643a & 4) != 4 || this.f20647e == EnumOptions.f20657c) {
                                this.f20647e = enumOptions;
                            } else {
                                this.f20647e = EnumOptions.m20514a(this.f20647e).m20488a(enumOptions).mo886l();
                            }
                            m20312t();
                        } else {
                            this.f20648f.m21439b(enumOptions);
                        }
                        this.f20643a |= 4;
                    }
                    m20301c(enumDescriptorProto.mo868g());
                }
                return this;
            }

            public final boolean mo854a() {
                Object obj;
                int i = 0;
                while (true) {
                    int size;
                    if (this.f20646d == null) {
                        size = this.f20645c.size();
                    } else {
                        size = this.f20646d.m21412c();
                    }
                    if (i >= size) {
                        break;
                    }
                    if (this.f20646d == null) {
                        AbstractMessage abstractMessage = (EnumValueDescriptorProto) this.f20645c.get(i);
                    } else {
                        EnumValueDescriptorProto enumValueDescriptorProto = (EnumValueDescriptorProto) this.f20646d.m21406a(i);
                    }
                    if (!abstractMessage.mo854a()) {
                        return false;
                    }
                    i++;
                }
                if ((this.f20643a & 4) == 4) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    if (this.f20648f == null) {
                        abstractMessage = this.f20647e;
                    } else {
                        EnumOptions enumOptions = (EnumOptions) this.f20648f.m21441c();
                    }
                    if (!abstractMessage.mo854a()) {
                        return false;
                    }
                }
                return true;
            }

            private Builder m20420d(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                Throwable th;
                EnumDescriptorProto enumDescriptorProto;
                EnumDescriptorProto enumDescriptorProto2;
                try {
                    enumDescriptorProto2 = (EnumDescriptorProto) EnumDescriptorProto.f20649a.mo859a(codedInputStream, extensionRegistryLite);
                    if (enumDescriptorProto2 != null) {
                        m20428a(enumDescriptorProto2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    InvalidProtocolBufferException invalidProtocolBufferException = e;
                    enumDescriptorProto2 = (EnumDescriptorProto) invalidProtocolBufferException.m21375a();
                    throw invalidProtocolBufferException;
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    enumDescriptorProto = enumDescriptorProto2;
                    th = th3;
                }
                if (enumDescriptorProto != null) {
                    m20428a(enumDescriptorProto);
                }
                throw th;
            }

            private RepeatedFieldBuilder<EnumValueDescriptorProto, Builder, EnumValueDescriptorProtoOrBuilder> m20418B() {
                if (this.f20646d == null) {
                    this.f20646d = new RepeatedFieldBuilder(this.f20645c, (this.f20643a & 2) == 2, m20311s(), this.f20619c);
                    this.f20645c = null;
                }
                return this.f20646d;
            }
        }

        public final /* synthetic */ Message$Builder mo881s() {
            return m20443c(this);
        }

        public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo883u() {
            return m20443c(this);
        }

        public EnumDescriptorProto(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
            super((byte) 0);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.mo868g();
        }

        private EnumDescriptorProto() {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.f21031a;
        }

        public final AbstractMessage mo878v() {
            return f20650c;
        }

        public final UnknownFieldSet mo868g() {
            return this.unknownFields;
        }

        public EnumDescriptorProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            m20445q();
            com.google.protobuf.UnknownFieldSet.Builder e = com.google.protobuf.UnknownFieldSet.Builder.m21487e();
            Object obj = null;
            int i = 0;
            while (obj == null) {
                try {
                    int a = codedInputStream.m20202a();
                    switch (a) {
                        case 0:
                            obj = 1;
                            break;
                        case 10:
                            this.bitField0_ |= 1;
                            this.name_ = codedInputStream.m20219k();
                            break;
                        case 18:
                            if ((i & 2) != 2) {
                                this.value_ = new ArrayList();
                                i |= 2;
                            }
                            this.value_.add(codedInputStream.m20203a(EnumValueDescriptorProto.f20663a, extensionRegistryLite));
                            break;
                        case 26:
                            Builder l;
                            if ((this.bitField0_ & 2) == 2) {
                                l = this.options_.m20523l();
                            } else {
                                l = null;
                            }
                            this.options_ = (EnumOptions) codedInputStream.m20203a(EnumOptions.f20656a, extensionRegistryLite);
                            if (l != null) {
                                l.m20488a(this.options_);
                                this.options_ = l.mo886l();
                            }
                            this.bitField0_ |= 2;
                            break;
                        default:
                            if (!mo889a(codedInputStream, e, extensionRegistryLite, a)) {
                                obj = 1;
                                break;
                            }
                            break;
                    }
                } catch (InvalidProtocolBufferException e2) {
                    throw e2.m21374a(this);
                } catch (IOException e3) {
                    throw new InvalidProtocolBufferException(e3.getMessage()).m21374a(this);
                } catch (Throwable th) {
                    if ((i & 2) == 2) {
                        this.value_ = Collections.unmodifiableList(this.value_);
                    }
                    this.unknownFields = e.m21495b();
                    mo888E();
                }
            }
            if ((i & 2) == 2) {
                this.value_ = Collections.unmodifiableList(this.value_);
            }
            this.unknownFields = e.m21495b();
            mo888E();
        }

        protected final FieldAccessorTable mo880h() {
            return DescriptorProtos.f20814l.m21368a(EnumDescriptorProto.class, Builder.class);
        }

        static {
            EnumDescriptorProto enumDescriptorProto = new EnumDescriptorProto();
            f20650c = enumDescriptorProto;
            enumDescriptorProto.m20445q();
        }

        public final Parser<EnumDescriptorProto> mo857i() {
            return f20649a;
        }

        public final String m20454k() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String e = byteString.m20186e();
            if (byteString.mo916f()) {
                this.name_ = e;
            }
            return e;
        }

        private ByteString m20444p() {
            Object obj = this.name_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString a = ByteString.m20173a((String) obj);
            this.name_ = a;
            return a;
        }

        public final int m20455l() {
            return this.value_.size();
        }

        public final EnumValueDescriptorProto m20446a(int i) {
            return (EnumValueDescriptorProto) this.value_.get(i);
        }

        public final boolean m20456m() {
            return (this.bitField0_ & 2) == 2;
        }

        private void m20445q() {
            this.name_ = "";
            this.value_ = Collections.emptyList();
            this.options_ = EnumOptions.f20657c;
        }

        public final boolean mo854a() {
            byte b = this.memoizedIsInitialized;
            if (b == (byte) -1) {
                int i = 0;
                while (i < m20455l()) {
                    if (m20446a(i).mo854a()) {
                        i++;
                    } else {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                if (!m20456m() || this.options_.mo854a()) {
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                }
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (b == (byte) 1) {
                return true;
            } else {
                return false;
            }
        }

        public final void mo853a(CodedOutputStream codedOutputStream) {
            mo855b();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.m20264a(1, m20444p());
            }
            for (int i = 0; i < this.value_.size(); i++) {
                codedOutputStream.m20273b(2, (MessageLite) this.value_.get(i));
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.m20273b(3, this.options_);
            }
            mo868g().mo853a(codedOutputStream);
        }

        public final int mo855b() {
            int i = 0;
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            if ((this.bitField0_ & 1) == 1) {
                i2 = CodedOutputStream.m20236c(1, m20444p()) + 0;
            } else {
                i2 = 0;
            }
            int i3 = i2;
            while (i < this.value_.size()) {
                i++;
                i3 = CodedOutputStream.m20242e(2, (MessageLite) this.value_.get(i)) + i3;
            }
            if ((this.bitField0_ & 2) == 2) {
                i3 += CodedOutputStream.m20242e(3, this.options_);
            }
            i2 = mo868g().mo855b() + i3;
            this.memoizedSerializedSize = i2;
            return i2;
        }

        public final Message$Builder mo882t() {
            return Builder.m20422n();
        }

        private static Builder m20443c(EnumDescriptorProto enumDescriptorProto) {
            return Builder.m20422n().m20428a(enumDescriptorProto);
        }

        protected final Message$Builder mo879a(BuilderParent builderParent) {
            return new Builder(builderParent);
        }
    }

    public interface EnumOptionsOrBuilder extends ExtendableMessageOrBuilder {
    }

    /* compiled from: analytics_source */
    public final class EnumOptions extends ExtendableMessage<EnumOptions> implements EnumOptionsOrBuilder {
        public static Parser<EnumOptions> f20656a = new C24211();
        public static final EnumOptions f20657c;
        public boolean allowAlias_;
        public int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        public List<UninterpretedOption> uninterpretedOption_;
        private final UnknownFieldSet unknownFields;

        /* compiled from: analytics_source */
        final class C24211 extends AbstractParser<EnumOptions> {
            C24211() {
            }

            public final Object mo859a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return new EnumOptions(codedInputStream, extensionRegistryLite);
            }
        }

        /* compiled from: analytics_source */
        public final class Builder extends ExtendableBuilder<EnumOptions, Builder> implements EnumOptionsOrBuilder {
            public int f20652a;
            public boolean f20653b = true;
            public List<UninterpretedOption> f20654c = Collections.emptyList();
            public RepeatedFieldBuilder<UninterpretedOption, Builder, UninterpretedOptionOrBuilder> f20655d;

            public final AbstractMessage mo878v() {
                return EnumOptions.f20657c;
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo870a(AbstractMessage abstractMessage) {
                return m20481d(abstractMessage);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo871a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m20482d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo863b() {
                return m20485y();
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo846b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m20482d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo848c() {
                return m20485y();
            }

            public final /* synthetic */ Message$Builder mo849c(AbstractMessage abstractMessage) {
                return m20481d(abstractMessage);
            }

            public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo840c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m20482d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ Object clone() {
                return m20485y();
            }

            public final /* synthetic */ com.google.protobuf.GeneratedMessage.Builder mo873f() {
                return m20485y();
            }

            public final /* synthetic */ AbstractMessage mo874h() {
                return mo886l();
            }

            public final /* synthetic */ AbstractMessage mo875i() {
                return m20479A();
            }

            public final /* synthetic */ MessageLite mo876j() {
                return mo886l();
            }

            public final /* synthetic */ MessageLite mo877k() {
                return m20479A();
            }

            public final /* synthetic */ ExtendableBuilder mo887m() {
                return m20485y();
            }

            protected final FieldAccessorTable mo872d() {
                return DescriptorProtos.f20828z.m21368a(EnumOptions.class, Builder.class);
            }

            private Builder() {
                m20483w();
            }

            public Builder(BuilderParent builderParent) {
                super(builderParent);
                m20483w();
            }

            private void m20483w() {
                if (GeneratedMessage.f20638b) {
                    m20480D();
                }
            }

            public static Builder m20484x() {
                return new Builder();
            }

            private Builder m20485y() {
                return m20484x().m20488a(mo886l());
            }

            public final Descriptor mo841e() {
                return DescriptorProtos.f20827y;
            }

            private EnumOptions m20479A() {
                AbstractMessage l = mo886l();
                if (l.mo854a()) {
                    return l;
                }
                throw com.google.protobuf.AbstractMessage.Builder.m20123b(l);
            }

            public final EnumOptions mo886l() {
                int i = 1;
                EnumOptions enumOptions = new EnumOptions(this);
                if ((this.f20652a & 1) != 1) {
                    i = 0;
                }
                enumOptions.allowAlias_ = this.f20653b;
                if (this.f20655d == null) {
                    if ((this.f20652a & 2) == 2) {
                        this.f20654c = Collections.unmodifiableList(this.f20654c);
                        this.f20652a &= -3;
                    }
                    enumOptions.uninterpretedOption_ = this.f20654c;
                } else {
                    enumOptions.uninterpretedOption_ = this.f20655d.m21416f();
                }
                enumOptions.bitField0_ = i;
                m20309p();
                return enumOptions;
            }

            private Builder m20481d(AbstractMessage abstractMessage) {
                if (abstractMessage instanceof EnumOptions) {
                    return m20488a((EnumOptions) abstractMessage);
                }
                super.mo870a(abstractMessage);
                return this;
            }

            public final Builder m20488a(EnumOptions enumOptions) {
                RepeatedFieldBuilder repeatedFieldBuilder = null;
                if (enumOptions != EnumOptions.f20657c) {
                    Object obj = 1;
                    if ((enumOptions.bitField0_ & 1) != 1) {
                        obj = null;
                    }
                    if (obj != null) {
                        boolean z = enumOptions.allowAlias_;
                        this.f20652a |= 1;
                        this.f20653b = z;
                        m20312t();
                    }
                    if (this.f20655d == null) {
                        if (!enumOptions.uninterpretedOption_.isEmpty()) {
                            if (this.f20654c.isEmpty()) {
                                this.f20654c = enumOptions.uninterpretedOption_;
                                this.f20652a &= -3;
                            } else {
                                if ((this.f20652a & 2) != 2) {
                                    this.f20654c = new ArrayList(this.f20654c);
                                    this.f20652a |= 2;
                                }
                                this.f20654c.addAll(enumOptions.uninterpretedOption_);
                            }
                            m20312t();
                        }
                    } else if (!enumOptions.uninterpretedOption_.isEmpty()) {
                        if (this.f20655d.m21414d()) {
                            this.f20655d.m21411b();
                            this.f20655d = null;
                            this.f20654c = enumOptions.uninterpretedOption_;
                            this.f20652a &= -3;
                            if (GeneratedMessage.f20638b) {
                                repeatedFieldBuilder = m20480D();
                            }
                            this.f20655d = repeatedFieldBuilder;
                        } else {
                            this.f20655d.m21409a(enumOptions.uninterpretedOption_);
                        }
                    }
                    m20467a((ExtendableMessage) enumOptions);
                    m20301c(enumOptions.mo868g());
                }
                return this;
            }

            public final boolean mo854a() {
                int i = 0;
                while (true) {
                    int size;
                    if (this.f20655d == null) {
                        size = this.f20654c.size();
                    } else {
                        size = this.f20655d.m21412c();
                    }
                    if (i >= size) {
                        break;
                    }
                    if (this.f20655d == null) {
                        AbstractMessage abstractMessage = (UninterpretedOption) this.f20654c.get(i);
                    } else {
                        UninterpretedOption uninterpretedOption = (UninterpretedOption) this.f20655d.m21406a(i);
                    }
                    if (!abstractMessage.mo854a()) {
                        return false;
                    }
                    i++;
                }
                if (m20478u()) {
                    return true;
                }
                return false;
            }

            private Builder m20482d(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                Throwable th;
                EnumOptions enumOptions;
                EnumOptions enumOptions2;
                try {
                    enumOptions2 = (EnumOptions) EnumOptions.f20656a.mo859a(codedInputStream, extensionRegistryLite);
                    if (enumOptions2 != null) {
                        m20488a(enumOptions2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    InvalidProtocolBufferException invalidProtocolBufferException = e;
                    enumOptions2 = (EnumOptions) invalidProtocolBufferException.m21375a();
                    throw invalidProtocolBufferException;
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    enumOptions = enumOptions2;
                    th = th3;
                }
                if (enumOptions != null) {
                    m20488a(enumOptions);
                }
                throw th;
            }

            private RepeatedFieldBuilder<UninterpretedOption, Builder, UninterpretedOptionOrBuilder> m20480D() {
                if (this.f20655d == null) {
                    this.f20655d = new RepeatedFieldBuilder(this.f20654c, (this.f20652a & 2) == 2, m20311s(), this.f20619c);
                    this.f20654c = null;
                }
                return this.f20655d;
            }
        }

        public final /* synthetic */ Message$Builder mo881s() {
            return m20523l();
        }

        public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo883u() {
            return m20523l();
        }

        public EnumOptions(ExtendableBuilder<EnumOptions, ?> extendableBuilder) {
            super(extendableBuilder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = extendableBuilder.mo868g();
        }

        private EnumOptions() {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.f21031a;
        }

        public final AbstractMessage mo878v() {
            return f20657c;
        }

        public final UnknownFieldSet mo868g() {
            return this.unknownFields;
        }

        public EnumOptions(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            Throwable th;
            int i = 0;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            m20515o();
            com.google.protobuf.UnknownFieldSet.Builder e = com.google.protobuf.UnknownFieldSet.Builder.m21487e();
            int i2 = 0;
            while (i2 == 0) {
                try {
                    int a = codedInputStream.m20202a();
                    switch (a) {
                        case 0:
                            i2 = 1;
                            break;
                        case 16:
                            this.bitField0_ |= 1;
                            this.allowAlias_ = codedInputStream.m20217i();
                            break;
                        case 7994:
                            if ((i & 2) != 2) {
                                this.uninterpretedOption_ = new ArrayList();
                                i |= 2;
                            }
                            this.uninterpretedOption_.add(codedInputStream.m20203a(UninterpretedOption.f20786a, extensionRegistryLite));
                            break;
                        default:
                            if (!mo889a(codedInputStream, e, extensionRegistryLite, a)) {
                                i2 = 1;
                                break;
                            }
                            break;
                    }
                } catch (InvalidProtocolBufferException e2) {
                    InvalidProtocolBufferException invalidProtocolBufferException = e2;
                    i2 = i;
                    throw invalidProtocolBufferException.m21374a(this);
                } catch (IOException e3) {
                    IOException iOException = e3;
                    i2 = i;
                    throw new InvalidProtocolBufferException(iOException.getMessage()).m21374a(this);
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if ((i & 2) == 2) {
                this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
            }
            this.unknownFields = e.m21495b();
            mo888E();
            return;
            if ((i2 & 2) == 2) {
                this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
            }
            this.unknownFields = e.m21495b();
            mo888E();
            throw th;
        }

        protected final FieldAccessorTable mo880h() {
            return DescriptorProtos.f20828z.m21368a(EnumOptions.class, Builder.class);
        }

        static {
            EnumOptions enumOptions = new EnumOptions();
            f20657c = enumOptions;
            enumOptions.m20515o();
        }

        public final Parser<EnumOptions> mo857i() {
            return f20656a;
        }

        private void m20515o() {
            this.allowAlias_ = true;
            this.uninterpretedOption_ = Collections.emptyList();
        }

        public final boolean mo854a() {
            byte b = this.memoizedIsInitialized;
            if (b == (byte) -1) {
                int i = 0;
                while (i < this.uninterpretedOption_.size()) {
                    if (((UninterpretedOption) this.uninterpretedOption_.get(i)).mo854a()) {
                        i++;
                    } else {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                if (m20507F()) {
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                }
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (b == (byte) 1) {
                return true;
            } else {
                return false;
            }
        }

        public final void mo853a(CodedOutputStream codedOutputStream) {
            mo855b();
            ExtensionWriter G = m20508G();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.m20266a(2, this.allowAlias_);
            }
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                codedOutputStream.m20273b(999, (MessageLite) this.uninterpretedOption_.get(i));
            }
            G.m21338a(536870912, codedOutputStream);
            mo868g().mo853a(codedOutputStream);
        }

        public final int mo855b() {
            int i = 0;
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            if ((this.bitField0_ & 1) == 1) {
                i2 = CodedOutputStream.m20231b(2, this.allowAlias_) + 0;
            } else {
                i2 = 0;
            }
            int i3 = i2;
            while (i < this.uninterpretedOption_.size()) {
                i++;
                i3 = CodedOutputStream.m20242e(999, (MessageLite) this.uninterpretedOption_.get(i)) + i3;
            }
            i2 = (m20509H() + i3) + mo868g().mo855b();
            this.memoizedSerializedSize = i2;
            return i2;
        }

        protected final Object writeReplace() {
            return super.writeReplace();
        }

        public final Message$Builder mo882t() {
            return Builder.m20484x();
        }

        public static Builder m20514a(EnumOptions enumOptions) {
            return Builder.m20484x().m20488a(enumOptions);
        }

        public final Builder m20523l() {
            return m20514a(this);
        }

        protected final Message$Builder mo879a(BuilderParent builderParent) {
            return new Builder(builderParent);
        }
    }

    public interface EnumValueDescriptorProtoOrBuilder extends MessageOrBuilder {
    }

    /* compiled from: analytics_source */
    public final class EnumValueDescriptorProto extends GeneratedMessage implements EnumValueDescriptorProtoOrBuilder {
        public static Parser<EnumValueDescriptorProto> f20663a = new C24221();
        public static final EnumValueDescriptorProto f20664c;
        public int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        public Object name_;
        public int number_;
        public EnumValueOptions options_;
        private final UnknownFieldSet unknownFields;

        /* compiled from: analytics_source */
        final class C24221 extends AbstractParser<EnumValueDescriptorProto> {
            C24221() {
            }

            public final Object mo859a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return new EnumValueDescriptorProto(codedInputStream, extensionRegistryLite);
            }
        }

        /* compiled from: analytics_source */
        public final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> implements EnumValueDescriptorProtoOrBuilder {
            public int f20658a;
            private Object f20659b = "";
            public int f20660c;
            public EnumValueOptions f20661d = EnumValueOptions.f20669c;
            public SingleFieldBuilder<EnumValueOptions, Builder, EnumValueOptionsOrBuilder> f20662e;

            public final Builder m20538a(EnumValueDescriptorProto enumValueDescriptorProto) {
                if (enumValueDescriptorProto != EnumValueDescriptorProto.f20664c) {
                    Object obj = 1;
                    if ((enumValueDescriptorProto.bitField0_ & 1) != 1) {
                        obj = null;
                    }
                    if (obj != null) {
                        this.f20658a |= 1;
                        this.f20659b = enumValueDescriptorProto.name_;
                        m20312t();
                    }
                    if ((enumValueDescriptorProto.bitField0_ & 2) == 2) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        int i = enumValueDescriptorProto.number_;
                        this.f20658a |= 2;
                        this.f20660c = i;
                        m20312t();
                    }
                    if (enumValueDescriptorProto.m20564n()) {
                        EnumValueOptions enumValueOptions = enumValueDescriptorProto.options_;
                        if (this.f20662e == null) {
                            if ((this.f20658a & 4) != 4 || this.f20661d == EnumValueOptions.f20669c) {
                                this.f20661d = enumValueOptions;
                            } else {
                                this.f20661d = EnumValueOptions.m20596a(this.f20661d).m20579a(enumValueOptions).mo886l();
                            }
                            m20312t();
                        } else {
                            this.f20662e.m21439b(enumValueOptions);
                        }
                        this.f20658a |= 4;
                    }
                    m20301c(enumValueDescriptorProto.mo868g());
                }
                return this;
            }

            public final AbstractMessage mo878v() {
                return EnumValueDescriptorProto.f20664c;
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo870a(AbstractMessage abstractMessage) {
                return m20529d(abstractMessage);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo871a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m20530d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo863b() {
                return m20533u();
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo846b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m20530d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo848c() {
                return m20533u();
            }

            public final /* synthetic */ Message$Builder mo849c(AbstractMessage abstractMessage) {
                return m20529d(abstractMessage);
            }

            public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo840c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m20530d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ Object clone() {
                return m20533u();
            }

            public final /* synthetic */ com.google.protobuf.GeneratedMessage.Builder mo873f() {
                return m20533u();
            }

            public final /* synthetic */ AbstractMessage mo874h() {
                return m20535y();
            }

            public final /* synthetic */ AbstractMessage mo875i() {
                return m20534x();
            }

            public final /* synthetic */ MessageLite mo876j() {
                return m20535y();
            }

            public final /* synthetic */ MessageLite mo877k() {
                return m20534x();
            }

            protected final FieldAccessorTable mo872d() {
                return DescriptorProtos.f20816n.m21368a(EnumValueDescriptorProto.class, Builder.class);
            }

            private Builder() {
                m20531m();
            }

            public Builder(BuilderParent builderParent) {
                super(builderParent);
                m20531m();
            }

            private void m20531m() {
                if (GeneratedMessage.f20638b) {
                    if (this.f20662e == null) {
                        this.f20662e = new SingleFieldBuilder(this.f20661d, m20311s(), this.f20619c);
                        this.f20661d = null;
                    }
                    SingleFieldBuilder singleFieldBuilder = this.f20662e;
                }
            }

            public static Builder m20532n() {
                return new Builder();
            }

            private Builder m20533u() {
                return m20532n().m20538a(m20535y());
            }

            public final Descriptor mo841e() {
                return DescriptorProtos.f20815m;
            }

            private EnumValueDescriptorProto m20534x() {
                AbstractMessage y = m20535y();
                if (y.mo854a()) {
                    return y;
                }
                throw com.google.protobuf.AbstractMessage.Builder.m20123b(y);
            }

            private EnumValueDescriptorProto m20535y() {
                int i;
                int i2 = 1;
                EnumValueDescriptorProto enumValueDescriptorProto = new EnumValueDescriptorProto(this);
                int i3 = this.f20658a;
                if ((i3 & 1) != 1) {
                    i2 = 0;
                }
                enumValueDescriptorProto.name_ = this.f20659b;
                if ((i3 & 2) == 2) {
                    i2 |= 2;
                }
                enumValueDescriptorProto.number_ = this.f20660c;
                if ((i3 & 4) == 4) {
                    i = i2 | 4;
                } else {
                    i = i2;
                }
                if (this.f20662e == null) {
                    enumValueDescriptorProto.options_ = this.f20661d;
                } else {
                    enumValueDescriptorProto.options_ = (EnumValueOptions) this.f20662e.m21442d();
                }
                enumValueDescriptorProto.bitField0_ = i;
                m20309p();
                return enumValueDescriptorProto;
            }

            private Builder m20529d(AbstractMessage abstractMessage) {
                if (abstractMessage instanceof EnumValueDescriptorProto) {
                    return m20538a((EnumValueDescriptorProto) abstractMessage);
                }
                super.mo870a(abstractMessage);
                return this;
            }

            private Builder m20530d(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                EnumValueDescriptorProto enumValueDescriptorProto;
                Throwable th;
                EnumValueDescriptorProto enumValueDescriptorProto2;
                try {
                    enumValueDescriptorProto = (EnumValueDescriptorProto) EnumValueDescriptorProto.f20663a.mo859a(codedInputStream, extensionRegistryLite);
                    if (enumValueDescriptorProto != null) {
                        m20538a(enumValueDescriptorProto);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    InvalidProtocolBufferException invalidProtocolBufferException = e;
                    enumValueDescriptorProto = (EnumValueDescriptorProto) invalidProtocolBufferException.m21375a();
                    throw invalidProtocolBufferException;
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    enumValueDescriptorProto2 = enumValueDescriptorProto;
                    th = th3;
                }
                if (enumValueDescriptorProto2 != null) {
                    m20538a(enumValueDescriptorProto2);
                }
                throw th;
            }

            public final boolean mo854a() {
                Object obj;
                if ((this.f20658a & 4) == 4) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    AbstractMessage abstractMessage;
                    if (this.f20662e == null) {
                        abstractMessage = this.f20661d;
                    } else {
                        EnumValueOptions enumValueOptions = (EnumValueOptions) this.f20662e.m21441c();
                    }
                    if (!abstractMessage.mo854a()) {
                        return false;
                    }
                }
                return true;
            }
        }

        public final /* synthetic */ Message$Builder mo881s() {
            return m20553b(this);
        }

        public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo883u() {
            return m20553b(this);
        }

        public EnumValueDescriptorProto(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
            super((byte) 0);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.mo868g();
        }

        private EnumValueDescriptorProto() {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.f21031a;
        }

        public final AbstractMessage mo878v() {
            return f20664c;
        }

        public final UnknownFieldSet mo868g() {
            return this.unknownFields;
        }

        public EnumValueDescriptorProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            m20555r();
            com.google.protobuf.UnknownFieldSet.Builder e = com.google.protobuf.UnknownFieldSet.Builder.m21487e();
            Object obj = null;
            while (obj == null) {
                try {
                    int a = codedInputStream.m20202a();
                    switch (a) {
                        case 0:
                            obj = 1;
                            break;
                        case 10:
                            this.bitField0_ |= 1;
                            this.name_ = codedInputStream.m20219k();
                            break;
                        case 16:
                            this.bitField0_ |= 2;
                            this.number_ = codedInputStream.m20214f();
                            break;
                        case 26:
                            Builder j;
                            if ((this.bitField0_ & 4) == 4) {
                                j = this.options_.mo891j();
                            } else {
                                j = null;
                            }
                            this.options_ = (EnumValueOptions) codedInputStream.m20203a(EnumValueOptions.f20668a, extensionRegistryLite);
                            if (j != null) {
                                j.m20579a(this.options_);
                                this.options_ = j.mo886l();
                            }
                            this.bitField0_ |= 4;
                            break;
                        default:
                            if (!mo889a(codedInputStream, e, extensionRegistryLite, a)) {
                                obj = 1;
                                break;
                            }
                            break;
                    }
                } catch (InvalidProtocolBufferException e2) {
                    throw e2.m21374a(this);
                } catch (IOException e3) {
                    throw new InvalidProtocolBufferException(e3.getMessage()).m21374a(this);
                } catch (Throwable th) {
                    this.unknownFields = e.m21495b();
                    mo888E();
                }
            }
            this.unknownFields = e.m21495b();
            mo888E();
        }

        protected final FieldAccessorTable mo880h() {
            return DescriptorProtos.f20816n.m21368a(EnumValueDescriptorProto.class, Builder.class);
        }

        static {
            EnumValueDescriptorProto enumValueDescriptorProto = new EnumValueDescriptorProto();
            f20664c = enumValueDescriptorProto;
            enumValueDescriptorProto.m20555r();
        }

        public final Parser<EnumValueDescriptorProto> mo857i() {
            return f20663a;
        }

        public final String m20563k() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String e = byteString.m20186e();
            if (byteString.mo916f()) {
                this.name_ = e;
            }
            return e;
        }

        private ByteString m20554q() {
            Object obj = this.name_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString a = ByteString.m20173a((String) obj);
            this.name_ = a;
            return a;
        }

        public final boolean m20564n() {
            return (this.bitField0_ & 4) == 4;
        }

        private void m20555r() {
            this.name_ = "";
            this.number_ = 0;
            this.options_ = EnumValueOptions.f20669c;
        }

        public final boolean mo854a() {
            byte b = this.memoizedIsInitialized;
            if (b != (byte) -1) {
                if (b == (byte) 1) {
                    return true;
                }
                return false;
            } else if (!m20564n() || this.options_.mo854a()) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            } else {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }

        public final void mo853a(CodedOutputStream codedOutputStream) {
            mo855b();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.m20264a(1, m20554q());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.m20262a(2, this.number_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.m20273b(3, this.options_);
            }
            mo868g().mo853a(codedOutputStream);
        }

        public final int mo855b() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            i = 0;
            if ((this.bitField0_ & 1) == 1) {
                i = CodedOutputStream.m20236c(1, m20554q()) + 0;
            }
            if ((this.bitField0_ & 2) == 2) {
                i += CodedOutputStream.m20241e(2, this.number_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i += CodedOutputStream.m20242e(3, this.options_);
            }
            i += mo868g().mo855b();
            this.memoizedSerializedSize = i;
            return i;
        }

        public final Message$Builder mo882t() {
            return Builder.m20532n();
        }

        private static Builder m20553b(EnumValueDescriptorProto enumValueDescriptorProto) {
            return Builder.m20532n().m20538a(enumValueDescriptorProto);
        }

        protected final Message$Builder mo879a(BuilderParent builderParent) {
            return new Builder(builderParent);
        }
    }

    public interface EnumValueOptionsOrBuilder extends ExtendableMessageOrBuilder {
    }

    /* compiled from: analytics_source */
    public final class EnumValueOptions extends ExtendableMessage<EnumValueOptions> implements EnumValueOptionsOrBuilder {
        public static Parser<EnumValueOptions> f20668a = new C24231();
        public static final EnumValueOptions f20669c;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        public List<UninterpretedOption> uninterpretedOption_;
        private final UnknownFieldSet unknownFields;

        /* compiled from: analytics_source */
        final class C24231 extends AbstractParser<EnumValueOptions> {
            C24231() {
            }

            public final Object mo859a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return new EnumValueOptions(codedInputStream, extensionRegistryLite);
            }
        }

        /* compiled from: analytics_source */
        public final class Builder extends ExtendableBuilder<EnumValueOptions, Builder> implements EnumValueOptionsOrBuilder {
            public int f20665a;
            public List<UninterpretedOption> f20666b = Collections.emptyList();
            public RepeatedFieldBuilder<UninterpretedOption, Builder, UninterpretedOptionOrBuilder> f20667c;

            public final AbstractMessage mo878v() {
                return EnumValueOptions.f20669c;
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo870a(AbstractMessage abstractMessage) {
                return m20572d(abstractMessage);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo871a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m20573d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo863b() {
                return m20576y();
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo846b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m20573d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo848c() {
                return m20576y();
            }

            public final /* synthetic */ Message$Builder mo849c(AbstractMessage abstractMessage) {
                return m20572d(abstractMessage);
            }

            public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo840c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m20573d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ Object clone() {
                return m20576y();
            }

            public final /* synthetic */ com.google.protobuf.GeneratedMessage.Builder mo873f() {
                return m20576y();
            }

            public final /* synthetic */ AbstractMessage mo874h() {
                return mo886l();
            }

            public final /* synthetic */ AbstractMessage mo875i() {
                return m20570A();
            }

            public final /* synthetic */ MessageLite mo876j() {
                return mo886l();
            }

            public final /* synthetic */ MessageLite mo877k() {
                return m20570A();
            }

            public final /* synthetic */ ExtendableBuilder mo887m() {
                return m20576y();
            }

            protected final FieldAccessorTable mo872d() {
                return DescriptorProtos.f20789B.m21368a(EnumValueOptions.class, Builder.class);
            }

            private Builder() {
                m20574w();
            }

            public Builder(BuilderParent builderParent) {
                super(builderParent);
                m20574w();
            }

            private void m20574w() {
                if (GeneratedMessage.f20638b) {
                    m20571D();
                }
            }

            public static Builder m20575x() {
                return new Builder();
            }

            private Builder m20576y() {
                return m20575x().m20579a(mo886l());
            }

            public final Descriptor mo841e() {
                return DescriptorProtos.f20788A;
            }

            private EnumValueOptions m20570A() {
                AbstractMessage l = mo886l();
                if (l.mo854a()) {
                    return l;
                }
                throw com.google.protobuf.AbstractMessage.Builder.m20123b(l);
            }

            public final EnumValueOptions mo886l() {
                EnumValueOptions enumValueOptions = new EnumValueOptions(this);
                if (this.f20667c == null) {
                    if ((this.f20665a & 1) == 1) {
                        this.f20666b = Collections.unmodifiableList(this.f20666b);
                        this.f20665a &= -2;
                    }
                    enumValueOptions.uninterpretedOption_ = this.f20666b;
                } else {
                    enumValueOptions.uninterpretedOption_ = this.f20667c.m21416f();
                }
                m20309p();
                return enumValueOptions;
            }

            private Builder m20572d(AbstractMessage abstractMessage) {
                if (abstractMessage instanceof EnumValueOptions) {
                    return m20579a((EnumValueOptions) abstractMessage);
                }
                super.mo870a(abstractMessage);
                return this;
            }

            public final Builder m20579a(EnumValueOptions enumValueOptions) {
                RepeatedFieldBuilder repeatedFieldBuilder = null;
                if (enumValueOptions != EnumValueOptions.f20669c) {
                    if (this.f20667c == null) {
                        if (!enumValueOptions.uninterpretedOption_.isEmpty()) {
                            if (this.f20666b.isEmpty()) {
                                this.f20666b = enumValueOptions.uninterpretedOption_;
                                this.f20665a &= -2;
                            } else {
                                if ((this.f20665a & 1) != 1) {
                                    this.f20666b = new ArrayList(this.f20666b);
                                    this.f20665a |= 1;
                                }
                                this.f20666b.addAll(enumValueOptions.uninterpretedOption_);
                            }
                            m20312t();
                        }
                    } else if (!enumValueOptions.uninterpretedOption_.isEmpty()) {
                        if (this.f20667c.m21414d()) {
                            this.f20667c.m21411b();
                            this.f20667c = null;
                            this.f20666b = enumValueOptions.uninterpretedOption_;
                            this.f20665a &= -2;
                            if (GeneratedMessage.f20638b) {
                                repeatedFieldBuilder = m20571D();
                            }
                            this.f20667c = repeatedFieldBuilder;
                        } else {
                            this.f20667c.m21409a(enumValueOptions.uninterpretedOption_);
                        }
                    }
                    m20467a((ExtendableMessage) enumValueOptions);
                    m20301c(enumValueOptions.mo868g());
                }
                return this;
            }

            public final boolean mo854a() {
                int i = 0;
                while (true) {
                    int size;
                    if (this.f20667c == null) {
                        size = this.f20666b.size();
                    } else {
                        size = this.f20667c.m21412c();
                    }
                    if (i >= size) {
                        break;
                    }
                    if (this.f20667c == null) {
                        AbstractMessage abstractMessage = (UninterpretedOption) this.f20666b.get(i);
                    } else {
                        UninterpretedOption uninterpretedOption = (UninterpretedOption) this.f20667c.m21406a(i);
                    }
                    if (!abstractMessage.mo854a()) {
                        return false;
                    }
                    i++;
                }
                if (m20478u()) {
                    return true;
                }
                return false;
            }

            private Builder m20573d(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                EnumValueOptions enumValueOptions;
                Throwable th;
                EnumValueOptions enumValueOptions2;
                try {
                    enumValueOptions = (EnumValueOptions) EnumValueOptions.f20668a.mo859a(codedInputStream, extensionRegistryLite);
                    if (enumValueOptions != null) {
                        m20579a(enumValueOptions);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    InvalidProtocolBufferException invalidProtocolBufferException = e;
                    enumValueOptions = (EnumValueOptions) invalidProtocolBufferException.m21375a();
                    throw invalidProtocolBufferException;
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    enumValueOptions2 = enumValueOptions;
                    th = th3;
                }
                if (enumValueOptions2 != null) {
                    m20579a(enumValueOptions2);
                }
                throw th;
            }

            private RepeatedFieldBuilder<UninterpretedOption, Builder, UninterpretedOptionOrBuilder> m20571D() {
                boolean z = true;
                if (this.f20667c == null) {
                    List list = this.f20666b;
                    if ((this.f20665a & 1) != 1) {
                        z = false;
                    }
                    this.f20667c = new RepeatedFieldBuilder(list, z, m20311s(), this.f20619c);
                    this.f20666b = null;
                }
                return this.f20667c;
            }
        }

        public final /* synthetic */ Message$Builder mo881s() {
            return mo891j();
        }

        public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo883u() {
            return mo891j();
        }

        public EnumValueOptions(ExtendableBuilder<EnumValueOptions, ?> extendableBuilder) {
            super(extendableBuilder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = extendableBuilder.mo868g();
        }

        private EnumValueOptions() {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.f21031a;
        }

        public final AbstractMessage mo878v() {
            return f20669c;
        }

        public final UnknownFieldSet mo868g() {
            return this.unknownFields;
        }

        public EnumValueOptions(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            Throwable th;
            int i = 0;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            m20597m();
            com.google.protobuf.UnknownFieldSet.Builder e = com.google.protobuf.UnknownFieldSet.Builder.m21487e();
            int i2 = 0;
            while (i2 == 0) {
                try {
                    int a = codedInputStream.m20202a();
                    switch (a) {
                        case 0:
                            i2 = 1;
                            break;
                        case 7994:
                            if ((i & 1) != 1) {
                                this.uninterpretedOption_ = new ArrayList();
                                i |= 1;
                            }
                            this.uninterpretedOption_.add(codedInputStream.m20203a(UninterpretedOption.f20786a, extensionRegistryLite));
                            break;
                        default:
                            if (!mo889a(codedInputStream, e, extensionRegistryLite, a)) {
                                i2 = 1;
                                break;
                            }
                            break;
                    }
                } catch (InvalidProtocolBufferException e2) {
                    InvalidProtocolBufferException invalidProtocolBufferException = e2;
                    i2 = i;
                    throw invalidProtocolBufferException.m21374a(this);
                } catch (IOException e3) {
                    IOException iOException = e3;
                    i2 = i;
                    throw new InvalidProtocolBufferException(iOException.getMessage()).m21374a(this);
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if ((i & 1) == 1) {
                this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
            }
            this.unknownFields = e.m21495b();
            mo888E();
            return;
            if ((i2 & 1) == 1) {
                this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
            }
            this.unknownFields = e.m21495b();
            mo888E();
            throw th;
        }

        protected final FieldAccessorTable mo880h() {
            return DescriptorProtos.f20789B.m21368a(EnumValueOptions.class, Builder.class);
        }

        static {
            EnumValueOptions enumValueOptions = new EnumValueOptions();
            f20669c = enumValueOptions;
            enumValueOptions.m20597m();
        }

        public final Parser<EnumValueOptions> mo857i() {
            return f20668a;
        }

        private void m20597m() {
            this.uninterpretedOption_ = Collections.emptyList();
        }

        public final boolean mo854a() {
            byte b = this.memoizedIsInitialized;
            if (b == (byte) -1) {
                int i = 0;
                while (i < this.uninterpretedOption_.size()) {
                    if (((UninterpretedOption) this.uninterpretedOption_.get(i)).mo854a()) {
                        i++;
                    } else {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                if (m20507F()) {
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                }
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (b == (byte) 1) {
                return true;
            } else {
                return false;
            }
        }

        public final void mo853a(CodedOutputStream codedOutputStream) {
            mo855b();
            ExtensionWriter G = m20508G();
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                codedOutputStream.m20273b(999, (MessageLite) this.uninterpretedOption_.get(i));
            }
            G.m21338a(536870912, codedOutputStream);
            mo868g().mo853a(codedOutputStream);
        }

        public final int mo855b() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (i = 0; i < this.uninterpretedOption_.size(); i++) {
                i2 += CodedOutputStream.m20242e(999, (MessageLite) this.uninterpretedOption_.get(i));
            }
            int H = (m20509H() + i2) + mo868g().mo855b();
            this.memoizedSerializedSize = H;
            return H;
        }

        protected final Object writeReplace() {
            return super.writeReplace();
        }

        public final Message$Builder mo882t() {
            return Builder.m20575x();
        }

        public static Builder m20596a(EnumValueOptions enumValueOptions) {
            return Builder.m20575x().m20579a(enumValueOptions);
        }

        public final Builder mo891j() {
            return m20596a(this);
        }

        protected final Message$Builder mo879a(BuilderParent builderParent) {
            return new Builder(builderParent);
        }
    }

    public interface FieldDescriptorProtoOrBuilder extends MessageOrBuilder {
    }

    /* compiled from: analytics_source */
    public final class FieldDescriptorProto extends GeneratedMessage implements FieldDescriptorProtoOrBuilder {
        public static Parser<FieldDescriptorProto> f20680a = new C24241();
        public static final FieldDescriptorProto f20681c;
        public int bitField0_;
        public Object defaultValue_;
        public Object extendee_;
        public Label label_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        public Object name_;
        public int number_;
        public FieldOptions options_;
        public Object typeName_;
        public Type type_;
        private final UnknownFieldSet unknownFields;

        /* compiled from: analytics_source */
        final class C24241 extends AbstractParser<FieldDescriptorProto> {
            C24241() {
            }

            public final Object mo859a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return new FieldDescriptorProto(codedInputStream, extensionRegistryLite);
            }
        }

        /* compiled from: analytics_source */
        public final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> implements FieldDescriptorProtoOrBuilder {
            public int f20670a;
            private Object f20671b = "";
            public int f20672c;
            private Label f20673d = Label.LABEL_OPTIONAL;
            private Type f20674e = Type.TYPE_DOUBLE;
            private Object f20675f = "";
            private Object f20676g = "";
            private Object f20677h = "";
            public FieldOptions f20678i = FieldOptions.f20692c;
            public SingleFieldBuilder<FieldOptions, Builder, FieldOptionsOrBuilder> f20679j;

            public final Builder m20622a(FieldDescriptorProto fieldDescriptorProto) {
                if (fieldDescriptorProto != FieldDescriptorProto.f20681c) {
                    Object obj = 1;
                    if ((fieldDescriptorProto.bitField0_ & 1) != 1) {
                        obj = null;
                    }
                    if (obj != null) {
                        this.f20670a |= 1;
                        this.f20671b = fieldDescriptorProto.name_;
                        m20312t();
                    }
                    if ((fieldDescriptorProto.bitField0_ & 2) == 2) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        int i = fieldDescriptorProto.number_;
                        this.f20670a |= 2;
                        this.f20672c = i;
                        m20312t();
                    }
                    if ((fieldDescriptorProto.bitField0_ & 4) == 4) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        m20611a(fieldDescriptorProto.label_);
                    }
                    if (fieldDescriptorProto.m20654q()) {
                        m20612a(fieldDescriptorProto.type_);
                    }
                    if (fieldDescriptorProto.m20659w()) {
                        this.f20670a |= 16;
                        this.f20675f = fieldDescriptorProto.typeName_;
                        m20312t();
                    }
                    if (fieldDescriptorProto.m20661y()) {
                        this.f20670a |= 32;
                        this.f20676g = fieldDescriptorProto.extendee_;
                        m20312t();
                    }
                    if (fieldDescriptorProto.m20643A()) {
                        this.f20670a |= 64;
                        this.f20677h = fieldDescriptorProto.defaultValue_;
                        m20312t();
                    }
                    if (fieldDescriptorProto.m20645C()) {
                        FieldOptions fieldOptions = fieldDescriptorProto.options_;
                        if (this.f20679j == null) {
                            if ((this.f20670a & 128) != 128 || this.f20678i == FieldOptions.f20692c) {
                                this.f20678i = fieldOptions;
                            } else {
                                this.f20678i = FieldOptions.m20693a(this.f20678i).m20674a(fieldOptions).mo886l();
                            }
                            m20312t();
                        } else {
                            this.f20679j.m21439b(fieldOptions);
                        }
                        this.f20670a |= 128;
                    }
                    m20301c(fieldDescriptorProto.mo868g());
                }
                return this;
            }

            public final AbstractMessage mo878v() {
                return FieldDescriptorProto.f20681c;
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo870a(AbstractMessage abstractMessage) {
                return m20613d(abstractMessage);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo871a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m20614d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo863b() {
                return m20617u();
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo846b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m20614d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo848c() {
                return m20617u();
            }

            public final /* synthetic */ Message$Builder mo849c(AbstractMessage abstractMessage) {
                return m20613d(abstractMessage);
            }

            public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo840c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m20614d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ Object clone() {
                return m20617u();
            }

            public final /* synthetic */ com.google.protobuf.GeneratedMessage.Builder mo873f() {
                return m20617u();
            }

            public final /* synthetic */ AbstractMessage mo874h() {
                return m20619y();
            }

            public final /* synthetic */ AbstractMessage mo875i() {
                return m20618x();
            }

            public final /* synthetic */ MessageLite mo876j() {
                return m20619y();
            }

            public final /* synthetic */ MessageLite mo877k() {
                return m20618x();
            }

            protected final FieldAccessorTable mo872d() {
                return DescriptorProtos.f20812j.m21368a(FieldDescriptorProto.class, Builder.class);
            }

            private Builder() {
                m20615m();
            }

            public Builder(BuilderParent builderParent) {
                super(builderParent);
                m20615m();
            }

            private void m20615m() {
                if (GeneratedMessage.f20638b) {
                    if (this.f20679j == null) {
                        this.f20679j = new SingleFieldBuilder(this.f20678i, m20311s(), this.f20619c);
                        this.f20678i = null;
                    }
                    SingleFieldBuilder singleFieldBuilder = this.f20679j;
                }
            }

            public static Builder m20616n() {
                return new Builder();
            }

            private Builder m20617u() {
                return m20616n().m20622a(m20619y());
            }

            public final Descriptor mo841e() {
                return DescriptorProtos.f20811i;
            }

            private FieldDescriptorProto m20618x() {
                AbstractMessage y = m20619y();
                if (y.mo854a()) {
                    return y;
                }
                throw com.google.protobuf.AbstractMessage.Builder.m20123b(y);
            }

            private FieldDescriptorProto m20619y() {
                int i;
                int i2 = 1;
                FieldDescriptorProto fieldDescriptorProto = new FieldDescriptorProto(this);
                int i3 = this.f20670a;
                if ((i3 & 1) != 1) {
                    i2 = 0;
                }
                fieldDescriptorProto.name_ = this.f20671b;
                if ((i3 & 2) == 2) {
                    i2 |= 2;
                }
                fieldDescriptorProto.number_ = this.f20672c;
                if ((i3 & 4) == 4) {
                    i2 |= 4;
                }
                fieldDescriptorProto.label_ = this.f20673d;
                if ((i3 & 8) == 8) {
                    i2 |= 8;
                }
                fieldDescriptorProto.type_ = this.f20674e;
                if ((i3 & 16) == 16) {
                    i2 |= 16;
                }
                fieldDescriptorProto.typeName_ = this.f20675f;
                if ((i3 & 32) == 32) {
                    i2 |= 32;
                }
                fieldDescriptorProto.extendee_ = this.f20676g;
                if ((i3 & 64) == 64) {
                    i2 |= 64;
                }
                fieldDescriptorProto.defaultValue_ = this.f20677h;
                if ((i3 & 128) == 128) {
                    i = i2 | 128;
                } else {
                    i = i2;
                }
                if (this.f20679j == null) {
                    fieldDescriptorProto.options_ = this.f20678i;
                } else {
                    fieldDescriptorProto.options_ = (FieldOptions) this.f20679j.m21442d();
                }
                fieldDescriptorProto.bitField0_ = i;
                m20309p();
                return fieldDescriptorProto;
            }

            private Builder m20613d(AbstractMessage abstractMessage) {
                if (abstractMessage instanceof FieldDescriptorProto) {
                    return m20622a((FieldDescriptorProto) abstractMessage);
                }
                super.mo870a(abstractMessage);
                return this;
            }

            private Builder m20614d(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                FieldDescriptorProto fieldDescriptorProto;
                Throwable th;
                FieldDescriptorProto fieldDescriptorProto2;
                try {
                    fieldDescriptorProto = (FieldDescriptorProto) FieldDescriptorProto.f20680a.mo859a(codedInputStream, extensionRegistryLite);
                    if (fieldDescriptorProto != null) {
                        m20622a(fieldDescriptorProto);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    InvalidProtocolBufferException invalidProtocolBufferException = e;
                    fieldDescriptorProto = (FieldDescriptorProto) invalidProtocolBufferException.m21375a();
                    throw invalidProtocolBufferException;
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    fieldDescriptorProto2 = fieldDescriptorProto;
                    th = th3;
                }
                if (fieldDescriptorProto2 != null) {
                    m20622a(fieldDescriptorProto2);
                }
                throw th;
            }

            private Builder m20611a(Label label) {
                if (label == null) {
                    throw new NullPointerException();
                }
                this.f20670a |= 4;
                this.f20673d = label;
                m20312t();
                return this;
            }

            private Builder m20612a(Type type) {
                if (type == null) {
                    throw new NullPointerException();
                }
                this.f20670a |= 8;
                this.f20674e = type;
                m20312t();
                return this;
            }

            public final boolean mo854a() {
                Object obj;
                if ((this.f20670a & 128) == 128) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    AbstractMessage abstractMessage;
                    if (this.f20679j == null) {
                        abstractMessage = this.f20678i;
                    } else {
                        FieldOptions fieldOptions = (FieldOptions) this.f20679j.m21441c();
                    }
                    if (!abstractMessage.mo854a()) {
                        return false;
                    }
                }
                return true;
            }
        }

        /* compiled from: analytics_source */
        public enum Label implements ProtocolMessageEnum {
            LABEL_OPTIONAL(0, 1),
            LABEL_REQUIRED(1, 2),
            LABEL_REPEATED(2, 3);
            
            private static final Label[] VALUES = null;
            private static EnumLiteMap<Label> internalValueMap;
            private final int index;
            private final int value;

            /* compiled from: analytics_source */
            final class C24251 implements EnumLiteMap<Label> {
                C24251() {
                }
            }

            public static Label valueOf(EnumValueDescriptor enumValueDescriptor) {
                if (enumValueDescriptor.f20860e == getDescriptor()) {
                    return VALUES[enumValueDescriptor.f20856a];
                }
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }

            static {
                internalValueMap = new C24251();
                VALUES = values();
            }

            public final int getNumber() {
                return this.value;
            }

            public static Label valueOf(int i) {
                switch (i) {
                    case 1:
                        return LABEL_OPTIONAL;
                    case 2:
                        return LABEL_REQUIRED;
                    case 3:
                        return LABEL_REPEATED;
                    default:
                        return null;
                }
            }

            public static EnumLiteMap<Label> internalGetValueMap() {
                return internalValueMap;
            }

            public final EnumValueDescriptor getValueDescriptor() {
                return (EnumValueDescriptor) getDescriptor().m21220d().get(this.index);
            }

            public final EnumDescriptor getDescriptorForType() {
                return getDescriptor();
            }

            public static final EnumDescriptor getDescriptor() {
                return (EnumDescriptor) DescriptorProtos.f20811i.m21198g().get(1);
            }

            private Label(int i, int i2) {
                this.index = i;
                this.value = i2;
            }
        }

        /* compiled from: analytics_source */
        public enum Type implements ProtocolMessageEnum {
            TYPE_DOUBLE(0, 1),
            TYPE_FLOAT(1, 2),
            TYPE_INT64(2, 3),
            TYPE_UINT64(3, 4),
            TYPE_INT32(4, 5),
            TYPE_FIXED64(5, 6),
            TYPE_FIXED32(6, 7),
            TYPE_BOOL(7, 8),
            TYPE_STRING(8, 9),
            TYPE_GROUP(9, 10),
            TYPE_MESSAGE(10, 11),
            TYPE_BYTES(11, 12),
            TYPE_UINT32(12, 13),
            TYPE_ENUM(13, 14),
            TYPE_SFIXED32(14, 15),
            TYPE_SFIXED64(15, 16),
            TYPE_SINT32(16, 17),
            TYPE_SINT64(17, 18);
            
            private static final Type[] VALUES = null;
            private static EnumLiteMap<Type> internalValueMap;
            private final int index;
            private final int value;

            /* compiled from: analytics_source */
            final class C24261 implements EnumLiteMap<Type> {
                C24261() {
                }
            }

            public static Type valueOf(EnumValueDescriptor enumValueDescriptor) {
                if (enumValueDescriptor.f20860e == getDescriptor()) {
                    return VALUES[enumValueDescriptor.f20856a];
                }
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }

            static {
                internalValueMap = new C24261();
                VALUES = values();
            }

            public final int getNumber() {
                return this.value;
            }

            public static Type valueOf(int i) {
                switch (i) {
                    case 1:
                        return TYPE_DOUBLE;
                    case 2:
                        return TYPE_FLOAT;
                    case 3:
                        return TYPE_INT64;
                    case 4:
                        return TYPE_UINT64;
                    case 5:
                        return TYPE_INT32;
                    case 6:
                        return TYPE_FIXED64;
                    case 7:
                        return TYPE_FIXED32;
                    case 8:
                        return TYPE_BOOL;
                    case 9:
                        return TYPE_STRING;
                    case 10:
                        return TYPE_GROUP;
                    case 11:
                        return TYPE_MESSAGE;
                    case 12:
                        return TYPE_BYTES;
                    case 13:
                        return TYPE_UINT32;
                    case 14:
                        return TYPE_ENUM;
                    case 15:
                        return TYPE_SFIXED32;
                    case 16:
                        return TYPE_SFIXED64;
                    case 17:
                        return TYPE_SINT32;
                    case 18:
                        return TYPE_SINT64;
                    default:
                        return null;
                }
            }

            public static EnumLiteMap<Type> internalGetValueMap() {
                return internalValueMap;
            }

            public final EnumValueDescriptor getValueDescriptor() {
                return (EnumValueDescriptor) getDescriptor().m21220d().get(this.index);
            }

            public final EnumDescriptor getDescriptorForType() {
                return getDescriptor();
            }

            public static final EnumDescriptor getDescriptor() {
                return (EnumDescriptor) DescriptorProtos.f20811i.m21198g().get(0);
            }

            private Type(int i, int i2) {
                this.index = i;
                this.value = i2;
            }
        }

        public final /* synthetic */ Message$Builder mo881s() {
            return m20642e(this);
        }

        public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo883u() {
            return m20642e(this);
        }

        public FieldDescriptorProto(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
            super((byte) 0);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.mo868g();
        }

        private FieldDescriptorProto() {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.f21031a;
        }

        public final AbstractMessage mo878v() {
            return f20681c;
        }

        public final UnknownFieldSet mo868g() {
            return this.unknownFields;
        }

        public FieldDescriptorProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            m20641K();
            com.google.protobuf.UnknownFieldSet.Builder e = com.google.protobuf.UnknownFieldSet.Builder.m21487e();
            Object obj = null;
            while (obj == null) {
                try {
                    int a = codedInputStream.m20202a();
                    switch (a) {
                        case 0:
                            obj = 1;
                            break;
                        case 10:
                            this.bitField0_ |= 1;
                            this.name_ = codedInputStream.m20219k();
                            break;
                        case 18:
                            this.bitField0_ |= 32;
                            this.extendee_ = codedInputStream.m20219k();
                            break;
                        case 24:
                            this.bitField0_ |= 2;
                            this.number_ = codedInputStream.m20214f();
                            break;
                        case 32:
                            a = codedInputStream.m20221m();
                            Label valueOf = Label.valueOf(a);
                            if (valueOf != null) {
                                this.bitField0_ |= 4;
                                this.label_ = valueOf;
                                break;
                            }
                            e.m21488a(4, a);
                            break;
                        case 40:
                            a = codedInputStream.m20221m();
                            Type valueOf2 = Type.valueOf(a);
                            if (valueOf2 != null) {
                                this.bitField0_ |= 8;
                                this.type_ = valueOf2;
                                break;
                            }
                            e.m21488a(5, a);
                            break;
                        case 50:
                            this.bitField0_ |= 16;
                            this.typeName_ = codedInputStream.m20219k();
                            break;
                        case 58:
                            this.bitField0_ |= 64;
                            this.defaultValue_ = codedInputStream.m20219k();
                            break;
                        case 66:
                            Builder z;
                            if ((this.bitField0_ & 128) == 128) {
                                z = this.options_.m20705z();
                            } else {
                                z = null;
                            }
                            this.options_ = (FieldOptions) codedInputStream.m20203a(FieldOptions.f20691a, extensionRegistryLite);
                            if (z != null) {
                                z.m20674a(this.options_);
                                this.options_ = z.mo886l();
                            }
                            this.bitField0_ |= 128;
                            break;
                        default:
                            if (!mo889a(codedInputStream, e, extensionRegistryLite, a)) {
                                obj = 1;
                                break;
                            }
                            break;
                    }
                } catch (InvalidProtocolBufferException e2) {
                    throw e2.m21374a(this);
                } catch (IOException e3) {
                    throw new InvalidProtocolBufferException(e3.getMessage()).m21374a(this);
                } catch (Throwable th) {
                    this.unknownFields = e.m21495b();
                    mo888E();
                }
            }
            this.unknownFields = e.m21495b();
            mo888E();
        }

        protected final FieldAccessorTable mo880h() {
            return DescriptorProtos.f20812j.m21368a(FieldDescriptorProto.class, Builder.class);
        }

        static {
            FieldDescriptorProto fieldDescriptorProto = new FieldDescriptorProto();
            f20681c = fieldDescriptorProto;
            fieldDescriptorProto.m20641K();
        }

        public final Parser<FieldDescriptorProto> mo857i() {
            return f20680a;
        }

        public final String m20653l() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String e = byteString.m20186e();
            if (byteString.mo916f()) {
                this.name_ = e;
            }
            return e;
        }

        private ByteString m20637G() {
            Object obj = this.name_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString a = ByteString.m20173a((String) obj);
            this.name_ = a;
            return a;
        }

        public final boolean m20654q() {
            return (this.bitField0_ & 8) == 8;
        }

        public final boolean m20659w() {
            return (this.bitField0_ & 16) == 16;
        }

        public final String m20660x() {
            Object obj = this.typeName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String e = byteString.m20186e();
            if (byteString.mo916f()) {
                this.typeName_ = e;
            }
            return e;
        }

        private ByteString m20638H() {
            Object obj = this.typeName_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString a = ByteString.m20173a((String) obj);
            this.typeName_ = a;
            return a;
        }

        public final boolean m20661y() {
            return (this.bitField0_ & 32) == 32;
        }

        public final String m20662z() {
            Object obj = this.extendee_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String e = byteString.m20186e();
            if (byteString.mo916f()) {
                this.extendee_ = e;
            }
            return e;
        }

        private ByteString m20639I() {
            Object obj = this.extendee_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString a = ByteString.m20173a((String) obj);
            this.extendee_ = a;
            return a;
        }

        public final boolean m20643A() {
            return (this.bitField0_ & 64) == 64;
        }

        public final String m20644B() {
            Object obj = this.defaultValue_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String e = byteString.m20186e();
            if (byteString.mo916f()) {
                this.defaultValue_ = e;
            }
            return e;
        }

        private ByteString m20640J() {
            Object obj = this.defaultValue_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString a = ByteString.m20173a((String) obj);
            this.defaultValue_ = a;
            return a;
        }

        public final boolean m20645C() {
            return (this.bitField0_ & 128) == 128;
        }

        private void m20641K() {
            this.name_ = "";
            this.number_ = 0;
            this.label_ = Label.LABEL_OPTIONAL;
            this.type_ = Type.TYPE_DOUBLE;
            this.typeName_ = "";
            this.extendee_ = "";
            this.defaultValue_ = "";
            this.options_ = FieldOptions.f20692c;
        }

        public final boolean mo854a() {
            byte b = this.memoizedIsInitialized;
            if (b != (byte) -1) {
                if (b == (byte) 1) {
                    return true;
                }
                return false;
            } else if (!m20645C() || this.options_.mo854a()) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            } else {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }

        public final void mo853a(CodedOutputStream codedOutputStream) {
            mo855b();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.m20264a(1, m20637G());
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.m20264a(2, m20639I());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.m20262a(3, this.number_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.m20280d(4, this.label_.getNumber());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.m20280d(5, this.type_.getNumber());
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.m20264a(6, m20638H());
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.m20264a(7, m20640J());
            }
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.m20273b(8, this.options_);
            }
            mo868g().mo853a(codedOutputStream);
        }

        public final int mo855b() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            i = 0;
            if ((this.bitField0_ & 1) == 1) {
                i = CodedOutputStream.m20236c(1, m20637G()) + 0;
            }
            if ((this.bitField0_ & 32) == 32) {
                i += CodedOutputStream.m20236c(2, m20639I());
            }
            if ((this.bitField0_ & 2) == 2) {
                i += CodedOutputStream.m20241e(3, this.number_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i += CodedOutputStream.m20247h(4, this.label_.getNumber());
            }
            if ((this.bitField0_ & 8) == 8) {
                i += CodedOutputStream.m20247h(5, this.type_.getNumber());
            }
            if ((this.bitField0_ & 16) == 16) {
                i += CodedOutputStream.m20236c(6, m20638H());
            }
            if ((this.bitField0_ & 64) == 64) {
                i += CodedOutputStream.m20236c(7, m20640J());
            }
            if ((this.bitField0_ & 128) == 128) {
                i += CodedOutputStream.m20242e(8, this.options_);
            }
            i += mo868g().mo855b();
            this.memoizedSerializedSize = i;
            return i;
        }

        public final Message$Builder mo882t() {
            return Builder.m20616n();
        }

        private static Builder m20642e(FieldDescriptorProto fieldDescriptorProto) {
            return Builder.m20616n().m20622a(fieldDescriptorProto);
        }

        protected final Message$Builder mo879a(BuilderParent builderParent) {
            return new Builder(builderParent);
        }
    }

    public interface FieldOptionsOrBuilder extends ExtendableMessageOrBuilder {
    }

    /* compiled from: analytics_source */
    public final class FieldOptions extends ExtendableMessage<FieldOptions> implements FieldOptionsOrBuilder {
        public static Parser<FieldOptions> f20691a = new C24271();
        public static final FieldOptions f20692c;
        public int bitField0_;
        public CType ctype_;
        public boolean deprecated_;
        public Object experimentalMapKey_;
        public boolean lazy_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        public boolean packed_;
        public List<UninterpretedOption> uninterpretedOption_;
        private final UnknownFieldSet unknownFields;
        public boolean weak_;

        /* compiled from: analytics_source */
        final class C24271 extends AbstractParser<FieldOptions> {
            C24271() {
            }

            public final Object mo859a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return new FieldOptions(codedInputStream, extensionRegistryLite);
            }
        }

        /* compiled from: analytics_source */
        public final class Builder extends ExtendableBuilder<FieldOptions, Builder> implements FieldOptionsOrBuilder {
            public int f20682a;
            private CType f20683b = CType.STRING;
            public boolean f20684c;
            public boolean f20685d;
            public boolean f20686e;
            private Object f20687f = "";
            public boolean f20688g;
            public List<UninterpretedOption> f20689h = Collections.emptyList();
            public RepeatedFieldBuilder<UninterpretedOption, Builder, UninterpretedOptionOrBuilder> f20690i;

            public final AbstractMessage mo878v() {
                return FieldOptions.f20692c;
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo870a(AbstractMessage abstractMessage) {
                return m20667d(abstractMessage);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo871a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m20668d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo863b() {
                return m20671y();
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo846b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m20668d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo848c() {
                return m20671y();
            }

            public final /* synthetic */ Message$Builder mo849c(AbstractMessage abstractMessage) {
                return m20667d(abstractMessage);
            }

            public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo840c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m20668d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ Object clone() {
                return m20671y();
            }

            public final /* synthetic */ com.google.protobuf.GeneratedMessage.Builder mo873f() {
                return m20671y();
            }

            public final /* synthetic */ AbstractMessage mo874h() {
                return mo886l();
            }

            public final /* synthetic */ AbstractMessage mo875i() {
                return m20664A();
            }

            public final /* synthetic */ MessageLite mo876j() {
                return mo886l();
            }

            public final /* synthetic */ MessageLite mo877k() {
                return m20664A();
            }

            public final /* synthetic */ ExtendableBuilder mo887m() {
                return m20671y();
            }

            protected final FieldAccessorTable mo872d() {
                return DescriptorProtos.f20826x.m21368a(FieldOptions.class, Builder.class);
            }

            private Builder() {
                m20669w();
            }

            public Builder(BuilderParent builderParent) {
                super(builderParent);
                m20669w();
            }

            private void m20669w() {
                if (GeneratedMessage.f20638b) {
                    m20665D();
                }
            }

            public static Builder m20670x() {
                return new Builder();
            }

            private Builder m20671y() {
                return m20670x().m20674a(mo886l());
            }

            public final Descriptor mo841e() {
                return DescriptorProtos.f20825w;
            }

            private FieldOptions m20664A() {
                AbstractMessage l = mo886l();
                if (l.mo854a()) {
                    return l;
                }
                throw com.google.protobuf.AbstractMessage.Builder.m20123b(l);
            }

            public final FieldOptions mo886l() {
                int i = 1;
                FieldOptions fieldOptions = new FieldOptions(this);
                int i2 = this.f20682a;
                if ((i2 & 1) != 1) {
                    i = 0;
                }
                fieldOptions.ctype_ = this.f20683b;
                if ((i2 & 2) == 2) {
                    i |= 2;
                }
                fieldOptions.packed_ = this.f20684c;
                if ((i2 & 4) == 4) {
                    i |= 4;
                }
                fieldOptions.lazy_ = this.f20685d;
                if ((i2 & 8) == 8) {
                    i |= 8;
                }
                fieldOptions.deprecated_ = this.f20686e;
                if ((i2 & 16) == 16) {
                    i |= 16;
                }
                fieldOptions.experimentalMapKey_ = this.f20687f;
                if ((i2 & 32) == 32) {
                    i |= 32;
                }
                fieldOptions.weak_ = this.f20688g;
                if (this.f20690i == null) {
                    if ((this.f20682a & 64) == 64) {
                        this.f20689h = Collections.unmodifiableList(this.f20689h);
                        this.f20682a &= -65;
                    }
                    fieldOptions.uninterpretedOption_ = this.f20689h;
                } else {
                    fieldOptions.uninterpretedOption_ = this.f20690i.m21416f();
                }
                fieldOptions.bitField0_ = i;
                m20309p();
                return fieldOptions;
            }

            private Builder m20667d(AbstractMessage abstractMessage) {
                if (abstractMessage instanceof FieldOptions) {
                    return m20674a((FieldOptions) abstractMessage);
                }
                super.mo870a(abstractMessage);
                return this;
            }

            public final Builder m20674a(FieldOptions fieldOptions) {
                RepeatedFieldBuilder repeatedFieldBuilder = null;
                if (fieldOptions != FieldOptions.f20692c) {
                    boolean z;
                    Object obj = 1;
                    if ((fieldOptions.bitField0_ & 1) != 1) {
                        obj = null;
                    }
                    if (obj != null) {
                        m20666a(fieldOptions.ctype_);
                    }
                    if ((fieldOptions.bitField0_ & 2) == 2) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        z = fieldOptions.packed_;
                        this.f20682a |= 2;
                        this.f20684c = z;
                        m20312t();
                    }
                    if ((fieldOptions.bitField0_ & 4) == 4) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        z = fieldOptions.lazy_;
                        this.f20682a |= 4;
                        this.f20685d = z;
                        m20312t();
                    }
                    if ((fieldOptions.bitField0_ & 8) == 8) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        z = fieldOptions.deprecated_;
                        this.f20682a |= 8;
                        this.f20686e = z;
                        m20312t();
                    }
                    if ((fieldOptions.bitField0_ & 16) == 16) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        this.f20682a |= 16;
                        this.f20687f = fieldOptions.experimentalMapKey_;
                        m20312t();
                    }
                    if ((fieldOptions.bitField0_ & 32) == 32) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        z = fieldOptions.weak_;
                        this.f20682a |= 32;
                        this.f20688g = z;
                        m20312t();
                    }
                    if (this.f20690i == null) {
                        if (!fieldOptions.uninterpretedOption_.isEmpty()) {
                            if (this.f20689h.isEmpty()) {
                                this.f20689h = fieldOptions.uninterpretedOption_;
                                this.f20682a &= -65;
                            } else {
                                if ((this.f20682a & 64) != 64) {
                                    this.f20689h = new ArrayList(this.f20689h);
                                    this.f20682a |= 64;
                                }
                                this.f20689h.addAll(fieldOptions.uninterpretedOption_);
                            }
                            m20312t();
                        }
                    } else if (!fieldOptions.uninterpretedOption_.isEmpty()) {
                        if (this.f20690i.m21414d()) {
                            this.f20690i.m21411b();
                            this.f20690i = null;
                            this.f20689h = fieldOptions.uninterpretedOption_;
                            this.f20682a &= -65;
                            if (GeneratedMessage.f20638b) {
                                repeatedFieldBuilder = m20665D();
                            }
                            this.f20690i = repeatedFieldBuilder;
                        } else {
                            this.f20690i.m21409a(fieldOptions.uninterpretedOption_);
                        }
                    }
                    m20467a((ExtendableMessage) fieldOptions);
                    m20301c(fieldOptions.mo868g());
                }
                return this;
            }

            public final boolean mo854a() {
                int i = 0;
                while (true) {
                    int size;
                    if (this.f20690i == null) {
                        size = this.f20689h.size();
                    } else {
                        size = this.f20690i.m21412c();
                    }
                    if (i >= size) {
                        break;
                    }
                    if (this.f20690i == null) {
                        AbstractMessage abstractMessage = (UninterpretedOption) this.f20689h.get(i);
                    } else {
                        UninterpretedOption uninterpretedOption = (UninterpretedOption) this.f20690i.m21406a(i);
                    }
                    if (!abstractMessage.mo854a()) {
                        return false;
                    }
                    i++;
                }
                if (m20478u()) {
                    return true;
                }
                return false;
            }

            private Builder m20668d(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                Throwable th;
                FieldOptions fieldOptions;
                FieldOptions fieldOptions2;
                try {
                    fieldOptions2 = (FieldOptions) FieldOptions.f20691a.mo859a(codedInputStream, extensionRegistryLite);
                    if (fieldOptions2 != null) {
                        m20674a(fieldOptions2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    InvalidProtocolBufferException invalidProtocolBufferException = e;
                    fieldOptions2 = (FieldOptions) invalidProtocolBufferException.m21375a();
                    throw invalidProtocolBufferException;
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    fieldOptions = fieldOptions2;
                    th = th3;
                }
                if (fieldOptions != null) {
                    m20674a(fieldOptions);
                }
                throw th;
            }

            private Builder m20666a(CType cType) {
                if (cType == null) {
                    throw new NullPointerException();
                }
                this.f20682a |= 1;
                this.f20683b = cType;
                m20312t();
                return this;
            }

            private RepeatedFieldBuilder<UninterpretedOption, Builder, UninterpretedOptionOrBuilder> m20665D() {
                if (this.f20690i == null) {
                    this.f20690i = new RepeatedFieldBuilder(this.f20689h, (this.f20682a & 64) == 64, m20311s(), this.f20619c);
                    this.f20689h = null;
                }
                return this.f20690i;
            }
        }

        /* compiled from: analytics_source */
        public enum CType implements ProtocolMessageEnum {
            STRING(0, 0),
            CORD(1, 1),
            STRING_PIECE(2, 2);
            
            private static final CType[] VALUES = null;
            private static EnumLiteMap<CType> internalValueMap;
            private final int index;
            private final int value;

            /* compiled from: analytics_source */
            final class C24281 implements EnumLiteMap<CType> {
                C24281() {
                }
            }

            public static CType valueOf(EnumValueDescriptor enumValueDescriptor) {
                if (enumValueDescriptor.f20860e == getDescriptor()) {
                    return VALUES[enumValueDescriptor.f20856a];
                }
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }

            static {
                internalValueMap = new C24281();
                VALUES = values();
            }

            public final int getNumber() {
                return this.value;
            }

            public static CType valueOf(int i) {
                switch (i) {
                    case 0:
                        return STRING;
                    case 1:
                        return CORD;
                    case 2:
                        return STRING_PIECE;
                    default:
                        return null;
                }
            }

            public static EnumLiteMap<CType> internalGetValueMap() {
                return internalValueMap;
            }

            public final EnumValueDescriptor getValueDescriptor() {
                return (EnumValueDescriptor) getDescriptor().m21220d().get(this.index);
            }

            public final EnumDescriptor getDescriptorForType() {
                return getDescriptor();
            }

            public static final EnumDescriptor getDescriptor() {
                return (EnumDescriptor) DescriptorProtos.f20825w.m21198g().get(0);
            }

            private CType(int i, int i2) {
                this.index = i;
                this.value = i2;
            }
        }

        public final /* synthetic */ Message$Builder mo881s() {
            return m20705z();
        }

        public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo883u() {
            return m20705z();
        }

        public FieldOptions(ExtendableBuilder<FieldOptions, ?> extendableBuilder) {
            super(extendableBuilder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = extendableBuilder.mo868g();
        }

        private FieldOptions() {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.f21031a;
        }

        public final AbstractMessage mo878v() {
            return f20692c;
        }

        public final UnknownFieldSet mo868g() {
            return this.unknownFields;
        }

        public FieldOptions(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            Throwable th;
            int i = 0;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            m20692D();
            com.google.protobuf.UnknownFieldSet.Builder e = com.google.protobuf.UnknownFieldSet.Builder.m21487e();
            int i2 = 0;
            while (i2 == 0) {
                try {
                    int a = codedInputStream.m20202a();
                    switch (a) {
                        case 0:
                            i2 = 1;
                            break;
                        case 8:
                            a = codedInputStream.m20221m();
                            CType valueOf = CType.valueOf(a);
                            if (valueOf != null) {
                                this.bitField0_ |= 1;
                                this.ctype_ = valueOf;
                                break;
                            }
                            e.m21488a(1, a);
                            break;
                        case 16:
                            this.bitField0_ |= 2;
                            this.packed_ = codedInputStream.m20217i();
                            break;
                        case 24:
                            this.bitField0_ |= 8;
                            this.deprecated_ = codedInputStream.m20217i();
                            break;
                        case 40:
                            this.bitField0_ |= 4;
                            this.lazy_ = codedInputStream.m20217i();
                            break;
                        case 74:
                            this.bitField0_ |= 16;
                            this.experimentalMapKey_ = codedInputStream.m20219k();
                            break;
                        case 80:
                            this.bitField0_ |= 32;
                            this.weak_ = codedInputStream.m20217i();
                            break;
                        case 7994:
                            if ((i & 64) != 64) {
                                this.uninterpretedOption_ = new ArrayList();
                                i |= 64;
                            }
                            this.uninterpretedOption_.add(codedInputStream.m20203a(UninterpretedOption.f20786a, extensionRegistryLite));
                            break;
                        default:
                            if (!mo889a(codedInputStream, e, extensionRegistryLite, a)) {
                                i2 = 1;
                                break;
                            }
                            break;
                    }
                } catch (InvalidProtocolBufferException e2) {
                    InvalidProtocolBufferException invalidProtocolBufferException = e2;
                    i2 = i;
                    throw invalidProtocolBufferException.m21374a(this);
                } catch (IOException e3) {
                    IOException iOException = e3;
                    i2 = i;
                    throw new InvalidProtocolBufferException(iOException.getMessage()).m21374a(this);
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if ((i & 64) == 64) {
                this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
            }
            this.unknownFields = e.m21495b();
            mo888E();
            return;
            if ((i2 & 64) == 64) {
                this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
            }
            this.unknownFields = e.m21495b();
            mo888E();
            throw th;
        }

        protected final FieldAccessorTable mo880h() {
            return DescriptorProtos.f20826x.m21368a(FieldOptions.class, Builder.class);
        }

        static {
            FieldOptions fieldOptions = new FieldOptions();
            f20692c = fieldOptions;
            fieldOptions.m20692D();
        }

        public final Parser<FieldOptions> mo857i() {
            return f20691a;
        }

        private ByteString m20691B() {
            Object obj = this.experimentalMapKey_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString a = ByteString.m20173a((String) obj);
            this.experimentalMapKey_ = a;
            return a;
        }

        private void m20692D() {
            this.ctype_ = CType.STRING;
            this.packed_ = false;
            this.lazy_ = false;
            this.deprecated_ = false;
            this.experimentalMapKey_ = "";
            this.weak_ = false;
            this.uninterpretedOption_ = Collections.emptyList();
        }

        public final boolean mo854a() {
            byte b = this.memoizedIsInitialized;
            if (b == (byte) -1) {
                int i = 0;
                while (i < this.uninterpretedOption_.size()) {
                    if (((UninterpretedOption) this.uninterpretedOption_.get(i)).mo854a()) {
                        i++;
                    } else {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                if (m20507F()) {
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                }
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (b == (byte) 1) {
                return true;
            } else {
                return false;
            }
        }

        public final void mo853a(CodedOutputStream codedOutputStream) {
            mo855b();
            ExtensionWriter G = m20508G();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.m20280d(1, this.ctype_.getNumber());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.m20266a(2, this.packed_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.m20266a(3, this.deprecated_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.m20266a(5, this.lazy_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.m20264a(9, m20691B());
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.m20266a(10, this.weak_);
            }
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                codedOutputStream.m20273b(999, (MessageLite) this.uninterpretedOption_.get(i));
            }
            G.m21338a(536870912, codedOutputStream);
            mo868g().mo853a(codedOutputStream);
        }

        public final int mo855b() {
            int i = 0;
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            if ((this.bitField0_ & 1) == 1) {
                i2 = CodedOutputStream.m20247h(1, this.ctype_.getNumber()) + 0;
            } else {
                i2 = 0;
            }
            if ((this.bitField0_ & 2) == 2) {
                i2 += CodedOutputStream.m20231b(2, this.packed_);
            }
            if ((this.bitField0_ & 8) == 8) {
                i2 += CodedOutputStream.m20231b(3, this.deprecated_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i2 += CodedOutputStream.m20231b(5, this.lazy_);
            }
            if ((this.bitField0_ & 16) == 16) {
                i2 += CodedOutputStream.m20236c(9, m20691B());
            }
            if ((this.bitField0_ & 32) == 32) {
                i2 += CodedOutputStream.m20231b(10, this.weak_);
            }
            int i3 = i2;
            while (i < this.uninterpretedOption_.size()) {
                i++;
                i3 = CodedOutputStream.m20242e(999, (MessageLite) this.uninterpretedOption_.get(i)) + i3;
            }
            i2 = (m20509H() + i3) + mo868g().mo855b();
            this.memoizedSerializedSize = i2;
            return i2;
        }

        protected final Object writeReplace() {
            return super.writeReplace();
        }

        public final Message$Builder mo882t() {
            return Builder.m20670x();
        }

        public static Builder m20693a(FieldOptions fieldOptions) {
            return Builder.m20670x().m20674a(fieldOptions);
        }

        public final Builder m20705z() {
            return m20693a(this);
        }

        protected final Message$Builder mo879a(BuilderParent builderParent) {
            return new Builder(builderParent);
        }
    }

    public interface FileDescriptorProtoOrBuilder extends MessageOrBuilder {
    }

    /* compiled from: analytics_source */
    public final class FileDescriptorProto extends GeneratedMessage implements FileDescriptorProtoOrBuilder {
        public static Parser<FileDescriptorProto> f20711a = new C24291();
        public static final FileDescriptorProto f20712c;
        public int bitField0_;
        public LazyStringList dependency_;
        public List<EnumDescriptorProto> enumType_;
        public List<FieldDescriptorProto> extension_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        public List<DescriptorProto> messageType_;
        public Object name_;
        public FileOptions options_;
        public Object package_;
        public List<Integer> publicDependency_;
        public List<ServiceDescriptorProto> service_;
        public SourceCodeInfo sourceCodeInfo_;
        private final UnknownFieldSet unknownFields;
        public List<Integer> weakDependency_;

        /* compiled from: analytics_source */
        final class C24291 extends AbstractParser<FileDescriptorProto> {
            C24291() {
            }

            public final Object mo859a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return new FileDescriptorProto(codedInputStream, extensionRegistryLite);
            }
        }

        /* compiled from: analytics_source */
        public final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> implements FileDescriptorProtoOrBuilder {
            public int f20693a;
            private Object f20694b = "";
            private Object f20695c = "";
            public LazyStringList f20696d = LazyStringArrayList.f20956a;
            public List<Integer> f20697e = Collections.emptyList();
            public List<Integer> f20698f = Collections.emptyList();
            public List<DescriptorProto> f20699g = Collections.emptyList();
            public RepeatedFieldBuilder<DescriptorProto, Builder, DescriptorProtoOrBuilder> f20700h;
            public List<EnumDescriptorProto> f20701i = Collections.emptyList();
            public RepeatedFieldBuilder<EnumDescriptorProto, Builder, EnumDescriptorProtoOrBuilder> f20702j;
            public List<ServiceDescriptorProto> f20703k = Collections.emptyList();
            public RepeatedFieldBuilder<ServiceDescriptorProto, Builder, ServiceDescriptorProtoOrBuilder> f20704l;
            public List<FieldDescriptorProto> f20705m = Collections.emptyList();
            public RepeatedFieldBuilder<FieldDescriptorProto, Builder, FieldDescriptorProtoOrBuilder> f20706n;
            public FileOptions f20707o = FileOptions.f20726c;
            public SingleFieldBuilder<FileOptions, Builder, FileOptionsOrBuilder> f20708p;
            public SourceCodeInfo f20709q = SourceCodeInfo.f20771c;
            public SingleFieldBuilder<SourceCodeInfo, Builder, SourceCodeInfoOrBuilder> f20710r;

            public final AbstractMessage mo878v() {
                return FileDescriptorProto.f20712c;
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo870a(AbstractMessage abstractMessage) {
                return m20711d(abstractMessage);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo871a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m20712d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo863b() {
                return m20715u();
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo846b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m20712d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo848c() {
                return m20715u();
            }

            public final /* synthetic */ Message$Builder mo849c(AbstractMessage abstractMessage) {
                return m20711d(abstractMessage);
            }

            public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo840c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m20712d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ Object clone() {
                return m20715u();
            }

            public final /* synthetic */ com.google.protobuf.GeneratedMessage.Builder mo873f() {
                return m20715u();
            }

            public final /* synthetic */ AbstractMessage mo874h() {
                return m20717y();
            }

            public final /* synthetic */ AbstractMessage mo875i() {
                return m20716x();
            }

            public final /* synthetic */ MessageLite mo876j() {
                return m20717y();
            }

            public final /* synthetic */ MessageLite mo877k() {
                return m20716x();
            }

            protected final FieldAccessorTable mo872d() {
                return DescriptorProtos.f20806d.m21368a(FileDescriptorProto.class, Builder.class);
            }

            private Builder() {
                m20713m();
            }

            public Builder(BuilderParent builderParent) {
                super(builderParent);
                m20713m();
            }

            private void m20713m() {
                if (GeneratedMessage.f20638b) {
                    m20707E();
                    m20708H();
                    m20709K();
                    m20710N();
                    if (this.f20708p == null) {
                        this.f20708p = new SingleFieldBuilder(this.f20707o, m20311s(), this.f20619c);
                        this.f20707o = null;
                    }
                    SingleFieldBuilder singleFieldBuilder = this.f20708p;
                    if (this.f20710r == null) {
                        this.f20710r = new SingleFieldBuilder(this.f20709q, m20311s(), this.f20619c);
                        this.f20709q = null;
                    }
                    singleFieldBuilder = this.f20710r;
                }
            }

            public static Builder m20714n() {
                return new Builder();
            }

            private Builder m20715u() {
                return m20714n().m20720a(m20717y());
            }

            public final Descriptor mo841e() {
                return DescriptorProtos.f20805c;
            }

            private FileDescriptorProto m20716x() {
                AbstractMessage y = m20717y();
                if (y.mo854a()) {
                    return y;
                }
                throw com.google.protobuf.AbstractMessage.Builder.m20123b(y);
            }

            private FileDescriptorProto m20717y() {
                int i;
                int i2 = 1;
                FileDescriptorProto fileDescriptorProto = new FileDescriptorProto(this);
                int i3 = this.f20693a;
                if ((i3 & 1) != 1) {
                    i2 = 0;
                }
                fileDescriptorProto.name_ = this.f20694b;
                if ((i3 & 2) == 2) {
                    i2 |= 2;
                }
                fileDescriptorProto.package_ = this.f20695c;
                if ((this.f20693a & 4) == 4) {
                    this.f20696d = new UnmodifiableLazyStringList(this.f20696d);
                    this.f20693a &= -5;
                }
                fileDescriptorProto.dependency_ = this.f20696d;
                if ((this.f20693a & 8) == 8) {
                    this.f20697e = Collections.unmodifiableList(this.f20697e);
                    this.f20693a &= -9;
                }
                fileDescriptorProto.publicDependency_ = this.f20697e;
                if ((this.f20693a & 16) == 16) {
                    this.f20698f = Collections.unmodifiableList(this.f20698f);
                    this.f20693a &= -17;
                }
                fileDescriptorProto.weakDependency_ = this.f20698f;
                if (this.f20700h == null) {
                    if ((this.f20693a & 32) == 32) {
                        this.f20699g = Collections.unmodifiableList(this.f20699g);
                        this.f20693a &= -33;
                    }
                    fileDescriptorProto.messageType_ = this.f20699g;
                } else {
                    fileDescriptorProto.messageType_ = this.f20700h.m21416f();
                }
                if (this.f20702j == null) {
                    if ((this.f20693a & 64) == 64) {
                        this.f20701i = Collections.unmodifiableList(this.f20701i);
                        this.f20693a &= -65;
                    }
                    fileDescriptorProto.enumType_ = this.f20701i;
                } else {
                    fileDescriptorProto.enumType_ = this.f20702j.m21416f();
                }
                if (this.f20704l == null) {
                    if ((this.f20693a & 128) == 128) {
                        this.f20703k = Collections.unmodifiableList(this.f20703k);
                        this.f20693a &= -129;
                    }
                    fileDescriptorProto.service_ = this.f20703k;
                } else {
                    fileDescriptorProto.service_ = this.f20704l.m21416f();
                }
                if (this.f20706n == null) {
                    if ((this.f20693a & 256) == 256) {
                        this.f20705m = Collections.unmodifiableList(this.f20705m);
                        this.f20693a &= -257;
                    }
                    fileDescriptorProto.extension_ = this.f20705m;
                } else {
                    fileDescriptorProto.extension_ = this.f20706n.m21416f();
                }
                if ((i3 & 512) == 512) {
                    i = i2 | 4;
                } else {
                    i = i2;
                }
                if (this.f20708p == null) {
                    fileDescriptorProto.options_ = this.f20707o;
                } else {
                    fileDescriptorProto.options_ = (FileOptions) this.f20708p.m21442d();
                }
                if ((i3 & 1024) == 1024) {
                    i |= 8;
                }
                if (this.f20710r == null) {
                    fileDescriptorProto.sourceCodeInfo_ = this.f20709q;
                } else {
                    fileDescriptorProto.sourceCodeInfo_ = (SourceCodeInfo) this.f20710r.m21442d();
                }
                fileDescriptorProto.bitField0_ = i;
                m20309p();
                return fileDescriptorProto;
            }

            private Builder m20711d(AbstractMessage abstractMessage) {
                if (abstractMessage instanceof FileDescriptorProto) {
                    return m20720a((FileDescriptorProto) abstractMessage);
                }
                super.mo870a(abstractMessage);
                return this;
            }

            public final Builder m20720a(FileDescriptorProto fileDescriptorProto) {
                RepeatedFieldBuilder repeatedFieldBuilder = null;
                if (fileDescriptorProto != FileDescriptorProto.f20712c) {
                    Object obj = 1;
                    if ((fileDescriptorProto.bitField0_ & 1) != 1) {
                        obj = null;
                    }
                    if (obj != null) {
                        this.f20693a |= 1;
                        this.f20694b = fileDescriptorProto.name_;
                        m20312t();
                    }
                    if ((fileDescriptorProto.bitField0_ & 2) == 2) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        this.f20693a |= 2;
                        this.f20695c = fileDescriptorProto.package_;
                        m20312t();
                    }
                    if (!fileDescriptorProto.dependency_.isEmpty()) {
                        if (this.f20696d.isEmpty()) {
                            this.f20696d = fileDescriptorProto.dependency_;
                            this.f20693a &= -5;
                        } else {
                            if ((this.f20693a & 4) != 4) {
                                this.f20696d = new LazyStringArrayList(this.f20696d);
                                this.f20693a |= 4;
                            }
                            this.f20696d.addAll(fileDescriptorProto.dependency_);
                        }
                        m20312t();
                    }
                    if (!fileDescriptorProto.publicDependency_.isEmpty()) {
                        if (this.f20697e.isEmpty()) {
                            this.f20697e = fileDescriptorProto.publicDependency_;
                            this.f20693a &= -9;
                        } else {
                            if ((this.f20693a & 8) != 8) {
                                this.f20697e = new ArrayList(this.f20697e);
                                this.f20693a |= 8;
                            }
                            this.f20697e.addAll(fileDescriptorProto.publicDependency_);
                        }
                        m20312t();
                    }
                    if (!fileDescriptorProto.weakDependency_.isEmpty()) {
                        if (this.f20698f.isEmpty()) {
                            this.f20698f = fileDescriptorProto.weakDependency_;
                            this.f20693a &= -17;
                        } else {
                            if ((this.f20693a & 16) != 16) {
                                this.f20698f = new ArrayList(this.f20698f);
                                this.f20693a |= 16;
                            }
                            this.f20698f.addAll(fileDescriptorProto.weakDependency_);
                        }
                        m20312t();
                    }
                    if (this.f20700h == null) {
                        if (!fileDescriptorProto.messageType_.isEmpty()) {
                            if (this.f20699g.isEmpty()) {
                                this.f20699g = fileDescriptorProto.messageType_;
                                this.f20693a &= -33;
                            } else {
                                if ((this.f20693a & 32) != 32) {
                                    this.f20699g = new ArrayList(this.f20699g);
                                    this.f20693a |= 32;
                                }
                                this.f20699g.addAll(fileDescriptorProto.messageType_);
                            }
                            m20312t();
                        }
                    } else if (!fileDescriptorProto.messageType_.isEmpty()) {
                        if (this.f20700h.m21414d()) {
                            this.f20700h.m21411b();
                            this.f20700h = null;
                            this.f20699g = fileDescriptorProto.messageType_;
                            this.f20693a &= -33;
                            this.f20700h = GeneratedMessage.f20638b ? m20707E() : null;
                        } else {
                            this.f20700h.m21409a(fileDescriptorProto.messageType_);
                        }
                    }
                    if (this.f20702j == null) {
                        if (!fileDescriptorProto.enumType_.isEmpty()) {
                            if (this.f20701i.isEmpty()) {
                                this.f20701i = fileDescriptorProto.enumType_;
                                this.f20693a &= -65;
                            } else {
                                if ((this.f20693a & 64) != 64) {
                                    this.f20701i = new ArrayList(this.f20701i);
                                    this.f20693a |= 64;
                                }
                                this.f20701i.addAll(fileDescriptorProto.enumType_);
                            }
                            m20312t();
                        }
                    } else if (!fileDescriptorProto.enumType_.isEmpty()) {
                        if (this.f20702j.m21414d()) {
                            this.f20702j.m21411b();
                            this.f20702j = null;
                            this.f20701i = fileDescriptorProto.enumType_;
                            this.f20693a &= -65;
                            this.f20702j = GeneratedMessage.f20638b ? m20708H() : null;
                        } else {
                            this.f20702j.m21409a(fileDescriptorProto.enumType_);
                        }
                    }
                    if (this.f20704l == null) {
                        if (!fileDescriptorProto.service_.isEmpty()) {
                            if (this.f20703k.isEmpty()) {
                                this.f20703k = fileDescriptorProto.service_;
                                this.f20693a &= -129;
                            } else {
                                if ((this.f20693a & 128) != 128) {
                                    this.f20703k = new ArrayList(this.f20703k);
                                    this.f20693a |= 128;
                                }
                                this.f20703k.addAll(fileDescriptorProto.service_);
                            }
                            m20312t();
                        }
                    } else if (!fileDescriptorProto.service_.isEmpty()) {
                        if (this.f20704l.m21414d()) {
                            this.f20704l.m21411b();
                            this.f20704l = null;
                            this.f20703k = fileDescriptorProto.service_;
                            this.f20693a &= -129;
                            this.f20704l = GeneratedMessage.f20638b ? m20709K() : null;
                        } else {
                            this.f20704l.m21409a(fileDescriptorProto.service_);
                        }
                    }
                    if (this.f20706n == null) {
                        if (!fileDescriptorProto.extension_.isEmpty()) {
                            if (this.f20705m.isEmpty()) {
                                this.f20705m = fileDescriptorProto.extension_;
                                this.f20693a &= -257;
                            } else {
                                if ((this.f20693a & 256) != 256) {
                                    this.f20705m = new ArrayList(this.f20705m);
                                    this.f20693a |= 256;
                                }
                                this.f20705m.addAll(fileDescriptorProto.extension_);
                            }
                            m20312t();
                        }
                    } else if (!fileDescriptorProto.extension_.isEmpty()) {
                        if (this.f20706n.m21414d()) {
                            this.f20706n.m21411b();
                            this.f20706n = null;
                            this.f20705m = fileDescriptorProto.extension_;
                            this.f20693a &= -257;
                            if (GeneratedMessage.f20638b) {
                                repeatedFieldBuilder = m20710N();
                            }
                            this.f20706n = repeatedFieldBuilder;
                        } else {
                            this.f20706n.m21409a(fileDescriptorProto.extension_);
                        }
                    }
                    if (fileDescriptorProto.m20764x()) {
                        FileOptions fileOptions = fileDescriptorProto.options_;
                        if (this.f20708p == null) {
                            if ((this.f20693a & 512) != 512 || this.f20707o == FileOptions.f20726c) {
                                this.f20707o = fileOptions;
                            } else {
                                this.f20707o = FileOptions.m20797a(this.f20707o).m20776a(fileOptions).mo886l();
                            }
                            m20312t();
                        } else {
                            this.f20708p.m21439b(fileOptions);
                        }
                        this.f20693a |= 512;
                    }
                    if ((fileDescriptorProto.bitField0_ & 8) == 8) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        SourceCodeInfo sourceCodeInfo = fileDescriptorProto.sourceCodeInfo_;
                        if (this.f20710r == null) {
                            if ((this.f20693a & 1024) != 1024 || this.f20709q == SourceCodeInfo.f20771c) {
                                this.f20709q = sourceCodeInfo;
                            } else {
                                this.f20709q = SourceCodeInfo.m21088a(this.f20709q).m21033a(sourceCodeInfo).m21047l();
                            }
                            m20312t();
                        } else {
                            this.f20710r.m21439b(sourceCodeInfo);
                        }
                        this.f20693a |= 1024;
                    }
                    m20301c(fileDescriptorProto.mo868g());
                }
                return this;
            }

            public final boolean mo854a() {
                int size;
                Object obj;
                int i = 0;
                while (true) {
                    if (this.f20700h == null) {
                        size = this.f20699g.size();
                    } else {
                        size = this.f20700h.m21412c();
                    }
                    if (i >= size) {
                        break;
                    }
                    if (this.f20700h == null) {
                        AbstractMessage abstractMessage = (DescriptorProto) this.f20699g.get(i);
                    } else {
                        DescriptorProto descriptorProto = (DescriptorProto) this.f20700h.m21406a(i);
                    }
                    if (!abstractMessage.mo854a()) {
                        return false;
                    }
                    i++;
                }
                i = 0;
                while (true) {
                    if (this.f20702j == null) {
                        size = this.f20701i.size();
                    } else {
                        size = this.f20702j.m21412c();
                    }
                    if (i >= size) {
                        break;
                    }
                    if (this.f20702j == null) {
                        abstractMessage = (EnumDescriptorProto) this.f20701i.get(i);
                    } else {
                        EnumDescriptorProto enumDescriptorProto = (EnumDescriptorProto) this.f20702j.m21406a(i);
                    }
                    if (!abstractMessage.mo854a()) {
                        return false;
                    }
                    i++;
                }
                i = 0;
                while (true) {
                    if (this.f20704l == null) {
                        size = this.f20703k.size();
                    } else {
                        size = this.f20704l.m21412c();
                    }
                    if (i >= size) {
                        break;
                    }
                    if (this.f20704l == null) {
                        abstractMessage = (ServiceDescriptorProto) this.f20703k.get(i);
                    } else {
                        ServiceDescriptorProto serviceDescriptorProto = (ServiceDescriptorProto) this.f20704l.m21406a(i);
                    }
                    if (!abstractMessage.mo854a()) {
                        return false;
                    }
                    i++;
                }
                i = 0;
                while (true) {
                    if (this.f20706n == null) {
                        size = this.f20705m.size();
                    } else {
                        size = this.f20706n.m21412c();
                    }
                    if (i >= size) {
                        break;
                    }
                    if (this.f20706n == null) {
                        abstractMessage = (FieldDescriptorProto) this.f20705m.get(i);
                    } else {
                        FieldDescriptorProto fieldDescriptorProto = (FieldDescriptorProto) this.f20706n.m21406a(i);
                    }
                    if (!abstractMessage.mo854a()) {
                        return false;
                    }
                    i++;
                }
                if ((this.f20693a & 512) == 512) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    if (this.f20708p == null) {
                        abstractMessage = this.f20707o;
                    } else {
                        FileOptions fileOptions = (FileOptions) this.f20708p.m21441c();
                    }
                    if (!abstractMessage.mo854a()) {
                        return false;
                    }
                }
                return true;
            }

            private Builder m20712d(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                Throwable th;
                FileDescriptorProto fileDescriptorProto;
                FileDescriptorProto fileDescriptorProto2;
                try {
                    fileDescriptorProto2 = (FileDescriptorProto) FileDescriptorProto.f20711a.mo859a(codedInputStream, extensionRegistryLite);
                    if (fileDescriptorProto2 != null) {
                        m20720a(fileDescriptorProto2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    InvalidProtocolBufferException invalidProtocolBufferException = e;
                    fileDescriptorProto2 = (FileDescriptorProto) invalidProtocolBufferException.m21375a();
                    throw invalidProtocolBufferException;
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    fileDescriptorProto = fileDescriptorProto2;
                    th = th3;
                }
                if (fileDescriptorProto != null) {
                    m20720a(fileDescriptorProto);
                }
                throw th;
            }

            private RepeatedFieldBuilder<DescriptorProto, Builder, DescriptorProtoOrBuilder> m20707E() {
                if (this.f20700h == null) {
                    this.f20700h = new RepeatedFieldBuilder(this.f20699g, (this.f20693a & 32) == 32, m20311s(), this.f20619c);
                    this.f20699g = null;
                }
                return this.f20700h;
            }

            private RepeatedFieldBuilder<EnumDescriptorProto, Builder, EnumDescriptorProtoOrBuilder> m20708H() {
                if (this.f20702j == null) {
                    this.f20702j = new RepeatedFieldBuilder(this.f20701i, (this.f20693a & 64) == 64, m20311s(), this.f20619c);
                    this.f20701i = null;
                }
                return this.f20702j;
            }

            private RepeatedFieldBuilder<ServiceDescriptorProto, Builder, ServiceDescriptorProtoOrBuilder> m20709K() {
                if (this.f20704l == null) {
                    this.f20704l = new RepeatedFieldBuilder(this.f20703k, (this.f20693a & 128) == 128, m20311s(), this.f20619c);
                    this.f20703k = null;
                }
                return this.f20704l;
            }

            private RepeatedFieldBuilder<FieldDescriptorProto, Builder, FieldDescriptorProtoOrBuilder> m20710N() {
                if (this.f20706n == null) {
                    this.f20706n = new RepeatedFieldBuilder(this.f20705m, (this.f20693a & 256) == 256, m20311s(), this.f20619c);
                    this.f20705m = null;
                }
                return this.f20706n;
            }
        }

        public final /* synthetic */ Message$Builder mo881s() {
            return m20740j(this);
        }

        public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo883u() {
            return m20740j(this);
        }

        public FileDescriptorProto(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
            super((byte) 0);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.mo868g();
        }

        private FileDescriptorProto() {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.f21031a;
        }

        public final AbstractMessage mo878v() {
            return f20712c;
        }

        public final UnknownFieldSet mo868g() {
            return this.unknownFields;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public FileDescriptorProto(com.google.protobuf.CodedInputStream r13, com.google.protobuf.ExtensionRegistryLite r14) {
            /*
            r12 = this;
            r10 = 64;
            r9 = 32;
            r8 = 16;
            r7 = 4;
            r6 = 8;
            r12.<init>();
            r0 = -1;
            r12.memoizedIsInitialized = r0;
            r0 = -1;
            r12.memoizedSerializedSize = r0;
            r12.m20737I();
            r1 = 0;
            r4 = com.google.protobuf.UnknownFieldSet.Builder.m21487e();
            r0 = 0;
            r3 = r0;
        L_0x001c:
            if (r3 != 0) goto L_0x024a;
        L_0x001e:
            r0 = r13.m20202a();	 Catch:{ InvalidProtocolBufferException -> 0x003e, IOException -> 0x00b6 }
            switch(r0) {
                case 0: goto L_0x002e;
                case 10: goto L_0x0031;
                case 18: goto L_0x00a8;
                case 26: goto L_0x00c5;
                case 34: goto L_0x00dd;
                case 42: goto L_0x00f7;
                case 50: goto L_0x0111;
                case 58: goto L_0x012d;
                case 66: goto L_0x0149;
                case 74: goto L_0x0176;
                case 80: goto L_0x01a3;
                case 82: goto L_0x01bf;
                case 88: goto L_0x01f3;
                case 90: goto L_0x020f;
                default: goto L_0x0025;
            };	 Catch:{ InvalidProtocolBufferException -> 0x003e, IOException -> 0x00b6 }
        L_0x0025:
            r0 = r12.mo889a(r13, r4, r14, r0);	 Catch:{ InvalidProtocolBufferException -> 0x003e, IOException -> 0x00b6 }
            if (r0 != 0) goto L_0x02c2;
        L_0x002b:
            r0 = 1;
            r3 = r0;
            goto L_0x001c;
        L_0x002e:
            r0 = 1;
            r3 = r0;
            goto L_0x001c;
        L_0x0031:
            r0 = r12.bitField0_;	 Catch:{ InvalidProtocolBufferException -> 0x003e, IOException -> 0x00b6 }
            r0 = r0 | 1;
            r12.bitField0_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x003e, IOException -> 0x00b6 }
            r0 = r13.m20219k();	 Catch:{ InvalidProtocolBufferException -> 0x003e, IOException -> 0x00b6 }
            r12.name_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x003e, IOException -> 0x00b6 }
            goto L_0x001c;
        L_0x003e:
            r0 = move-exception;
        L_0x003f:
            r0 = r0.m21374a(r12);	 Catch:{ all -> 0x0044 }
            throw r0;	 Catch:{ all -> 0x0044 }
        L_0x0044:
            r0 = move-exception;
        L_0x0045:
            r2 = r1 & 4;
            if (r2 != r7) goto L_0x0052;
        L_0x0049:
            r2 = new com.google.protobuf.UnmodifiableLazyStringList;
            r3 = r12.dependency_;
            r2.<init>(r3);
            r12.dependency_ = r2;
        L_0x0052:
            r2 = r1 & 32;
            if (r2 != r9) goto L_0x005e;
        L_0x0056:
            r2 = r12.messageType_;
            r2 = java.util.Collections.unmodifiableList(r2);
            r12.messageType_ = r2;
        L_0x005e:
            r2 = r1 & 64;
            if (r2 != r10) goto L_0x006a;
        L_0x0062:
            r2 = r12.enumType_;
            r2 = java.util.Collections.unmodifiableList(r2);
            r12.enumType_ = r2;
        L_0x006a:
            r2 = r1 & 128;
            r3 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
            if (r2 != r3) goto L_0x0078;
        L_0x0070:
            r2 = r12.service_;
            r2 = java.util.Collections.unmodifiableList(r2);
            r12.service_ = r2;
        L_0x0078:
            r2 = r1 & 256;
            r3 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
            if (r2 != r3) goto L_0x0086;
        L_0x007e:
            r2 = r12.extension_;
            r2 = java.util.Collections.unmodifiableList(r2);
            r12.extension_ = r2;
        L_0x0086:
            r2 = r1 & 8;
            if (r2 != r6) goto L_0x0092;
        L_0x008a:
            r2 = r12.publicDependency_;
            r2 = java.util.Collections.unmodifiableList(r2);
            r12.publicDependency_ = r2;
        L_0x0092:
            r1 = r1 & 16;
            if (r1 != r8) goto L_0x009e;
        L_0x0096:
            r1 = r12.weakDependency_;
            r1 = java.util.Collections.unmodifiableList(r1);
            r12.weakDependency_ = r1;
        L_0x009e:
            r1 = r4.m21495b();
            r12.unknownFields = r1;
            r12.mo888E();
            throw r0;
        L_0x00a8:
            r0 = r12.bitField0_;	 Catch:{  }
            r0 = r0 | 2;
            r12.bitField0_ = r0;	 Catch:{  }
            r0 = r13.m20219k();	 Catch:{  }
            r12.package_ = r0;	 Catch:{  }
            goto L_0x001c;
        L_0x00b6:
            r0 = move-exception;
        L_0x00b7:
            r2 = new com.google.protobuf.InvalidProtocolBufferException;	 Catch:{  }
            r0 = r0.getMessage();	 Catch:{  }
            r2.<init>(r0);	 Catch:{  }
            r0 = r2.m21374a(r12);	 Catch:{  }
            throw r0;	 Catch:{  }
        L_0x00c5:
            r0 = r1 & 4;
            if (r0 == r7) goto L_0x00d2;
        L_0x00c9:
            r0 = new com.google.protobuf.LazyStringArrayList;	 Catch:{  }
            r0.<init>();	 Catch:{  }
            r12.dependency_ = r0;	 Catch:{  }
            r1 = r1 | 4;
        L_0x00d2:
            r0 = r12.dependency_;	 Catch:{  }
            r2 = r13.m20219k();	 Catch:{  }
            r0.mo907a(r2);	 Catch:{  }
            goto L_0x001c;
        L_0x00dd:
            r0 = r1 & 32;
            if (r0 == r9) goto L_0x00ea;
        L_0x00e1:
            r0 = new java.util.ArrayList;	 Catch:{  }
            r0.<init>();	 Catch:{  }
            r12.messageType_ = r0;	 Catch:{  }
            r1 = r1 | 32;
        L_0x00ea:
            r0 = r12.messageType_;	 Catch:{  }
            r2 = com.google.protobuf.DescriptorProtos.DescriptorProto.f20641a;	 Catch:{  }
            r2 = r13.m20203a(r2, r14);	 Catch:{  }
            r0.add(r2);	 Catch:{  }
            goto L_0x001c;
        L_0x00f7:
            r0 = r1 & 64;
            if (r0 == r10) goto L_0x0104;
        L_0x00fb:
            r0 = new java.util.ArrayList;	 Catch:{  }
            r0.<init>();	 Catch:{  }
            r12.enumType_ = r0;	 Catch:{  }
            r1 = r1 | 64;
        L_0x0104:
            r0 = r12.enumType_;	 Catch:{  }
            r2 = com.google.protobuf.DescriptorProtos.EnumDescriptorProto.f20649a;	 Catch:{  }
            r2 = r13.m20203a(r2, r14);	 Catch:{  }
            r0.add(r2);	 Catch:{  }
            goto L_0x001c;
        L_0x0111:
            r0 = r1 & 128;
            r2 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
            if (r0 == r2) goto L_0x0120;
        L_0x0117:
            r0 = new java.util.ArrayList;	 Catch:{  }
            r0.<init>();	 Catch:{  }
            r12.service_ = r0;	 Catch:{  }
            r1 = r1 | 128;
        L_0x0120:
            r0 = r12.service_;	 Catch:{  }
            r2 = com.google.protobuf.DescriptorProtos.ServiceDescriptorProto.f20753a;	 Catch:{  }
            r2 = r13.m20203a(r2, r14);	 Catch:{  }
            r0.add(r2);	 Catch:{  }
            goto L_0x001c;
        L_0x012d:
            r0 = r1 & 256;
            r2 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
            if (r0 == r2) goto L_0x013c;
        L_0x0133:
            r0 = new java.util.ArrayList;	 Catch:{  }
            r0.<init>();	 Catch:{  }
            r12.extension_ = r0;	 Catch:{  }
            r1 = r1 | 256;
        L_0x013c:
            r0 = r12.extension_;	 Catch:{  }
            r2 = com.google.protobuf.DescriptorProtos.FieldDescriptorProto.f20680a;	 Catch:{  }
            r2 = r13.m20203a(r2, r14);	 Catch:{  }
            r0.add(r2);	 Catch:{  }
            goto L_0x001c;
        L_0x0149:
            r0 = 0;
            r2 = r12.bitField0_;	 Catch:{  }
            r2 = r2 & 4;
            if (r2 != r7) goto L_0x02bf;
        L_0x0150:
            r0 = r12.options_;	 Catch:{  }
            r0 = r0.m20798D();	 Catch:{  }
            r2 = r0;
        L_0x0157:
            r0 = com.google.protobuf.DescriptorProtos.FileOptions.f20725a;	 Catch:{  }
            r0 = r13.m20203a(r0, r14);	 Catch:{  }
            r0 = (com.google.protobuf.DescriptorProtos.FileOptions) r0;	 Catch:{  }
            r12.options_ = r0;	 Catch:{  }
            if (r2 == 0) goto L_0x016e;
        L_0x0163:
            r0 = r12.options_;	 Catch:{  }
            r2.m20776a(r0);	 Catch:{  }
            r0 = r2.mo886l();	 Catch:{  }
            r12.options_ = r0;	 Catch:{  }
        L_0x016e:
            r0 = r12.bitField0_;	 Catch:{  }
            r0 = r0 | 4;
            r12.bitField0_ = r0;	 Catch:{  }
            goto L_0x001c;
        L_0x0176:
            r0 = 0;
            r2 = r12.bitField0_;	 Catch:{  }
            r2 = r2 & 8;
            if (r2 != r6) goto L_0x02bc;
        L_0x017d:
            r0 = r12.sourceCodeInfo_;	 Catch:{  }
            r0 = r0.mo891j();	 Catch:{  }
            r2 = r0;
        L_0x0184:
            r0 = com.google.protobuf.DescriptorProtos.SourceCodeInfo.f20770a;	 Catch:{  }
            r0 = r13.m20203a(r0, r14);	 Catch:{  }
            r0 = (com.google.protobuf.DescriptorProtos.SourceCodeInfo) r0;	 Catch:{  }
            r12.sourceCodeInfo_ = r0;	 Catch:{  }
            if (r2 == 0) goto L_0x019b;
        L_0x0190:
            r0 = r12.sourceCodeInfo_;	 Catch:{  }
            r2.m21033a(r0);	 Catch:{  }
            r0 = r2.m21047l();	 Catch:{  }
            r12.sourceCodeInfo_ = r0;	 Catch:{  }
        L_0x019b:
            r0 = r12.bitField0_;	 Catch:{  }
            r0 = r0 | 8;
            r12.bitField0_ = r0;	 Catch:{  }
            goto L_0x001c;
        L_0x01a3:
            r0 = r1 & 8;
            if (r0 == r6) goto L_0x01b0;
        L_0x01a7:
            r0 = new java.util.ArrayList;	 Catch:{  }
            r0.<init>();	 Catch:{  }
            r12.publicDependency_ = r0;	 Catch:{  }
            r1 = r1 | 8;
        L_0x01b0:
            r0 = r12.publicDependency_;	 Catch:{  }
            r2 = r13.m20214f();	 Catch:{  }
            r2 = java.lang.Integer.valueOf(r2);	 Catch:{  }
            r0.add(r2);	 Catch:{  }
            goto L_0x001c;
        L_0x01bf:
            r0 = r13.m20225r();	 Catch:{  }
            r0 = r13.m20210c(r0);	 Catch:{  }
            r2 = r1 & 8;
            if (r2 == r6) goto L_0x01da;
        L_0x01cb:
            r2 = r13.m20226s();	 Catch:{  }
            if (r2 <= 0) goto L_0x01da;
        L_0x01d1:
            r2 = new java.util.ArrayList;	 Catch:{  }
            r2.<init>();	 Catch:{  }
            r12.publicDependency_ = r2;	 Catch:{  }
            r1 = r1 | 8;
        L_0x01da:
            r2 = r13.m20226s();	 Catch:{  }
            if (r2 <= 0) goto L_0x01ee;
        L_0x01e0:
            r2 = r12.publicDependency_;	 Catch:{  }
            r5 = r13.m20214f();	 Catch:{  }
            r5 = java.lang.Integer.valueOf(r5);	 Catch:{  }
            r2.add(r5);	 Catch:{  }
            goto L_0x01da;
        L_0x01ee:
            r13.m20212d(r0);	 Catch:{  }
            goto L_0x001c;
        L_0x01f3:
            r0 = r1 & 16;
            if (r0 == r8) goto L_0x0200;
        L_0x01f7:
            r0 = new java.util.ArrayList;	 Catch:{  }
            r0.<init>();	 Catch:{  }
            r12.weakDependency_ = r0;	 Catch:{  }
            r1 = r1 | 16;
        L_0x0200:
            r0 = r12.weakDependency_;	 Catch:{  }
            r2 = r13.m20214f();	 Catch:{  }
            r2 = java.lang.Integer.valueOf(r2);	 Catch:{  }
            r0.add(r2);	 Catch:{  }
            goto L_0x001c;
        L_0x020f:
            r0 = r13.m20225r();	 Catch:{  }
            r2 = r13.m20210c(r0);	 Catch:{  }
            r0 = r1 & 16;
            if (r0 == r8) goto L_0x02b9;
        L_0x021b:
            r0 = r13.m20226s();	 Catch:{  }
            if (r0 <= 0) goto L_0x02b9;
        L_0x0221:
            r0 = new java.util.ArrayList;	 Catch:{  }
            r0.<init>();	 Catch:{  }
            r12.weakDependency_ = r0;	 Catch:{  }
            r0 = r1 | 16;
        L_0x022a:
            r1 = r13.m20226s();	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02b3, all -> 0x02ad }
            if (r1 <= 0) goto L_0x0244;
        L_0x0230:
            r1 = r12.weakDependency_;	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02b3, all -> 0x02ad }
            r5 = r13.m20214f();	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02b3, all -> 0x02ad }
            r5 = java.lang.Integer.valueOf(r5);	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02b3, all -> 0x02ad }
            r1.add(r5);	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02b3, all -> 0x02ad }
            goto L_0x022a;
        L_0x023e:
            r1 = move-exception;
            r11 = r1;
            r1 = r0;
            r0 = r11;
            goto L_0x003f;
        L_0x0244:
            r13.m20212d(r2);	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02b3, all -> 0x02ad }
        L_0x0247:
            r1 = r0;
            goto L_0x001c;
        L_0x024a:
            r0 = r1 & 4;
            if (r0 != r7) goto L_0x0257;
        L_0x024e:
            r0 = new com.google.protobuf.UnmodifiableLazyStringList;
            r2 = r12.dependency_;
            r0.<init>(r2);
            r12.dependency_ = r0;
        L_0x0257:
            r0 = r1 & 32;
            if (r0 != r9) goto L_0x0263;
        L_0x025b:
            r0 = r12.messageType_;
            r0 = java.util.Collections.unmodifiableList(r0);
            r12.messageType_ = r0;
        L_0x0263:
            r0 = r1 & 64;
            if (r0 != r10) goto L_0x026f;
        L_0x0267:
            r0 = r12.enumType_;
            r0 = java.util.Collections.unmodifiableList(r0);
            r12.enumType_ = r0;
        L_0x026f:
            r0 = r1 & 128;
            r2 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
            if (r0 != r2) goto L_0x027d;
        L_0x0275:
            r0 = r12.service_;
            r0 = java.util.Collections.unmodifiableList(r0);
            r12.service_ = r0;
        L_0x027d:
            r0 = r1 & 256;
            r2 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
            if (r0 != r2) goto L_0x028b;
        L_0x0283:
            r0 = r12.extension_;
            r0 = java.util.Collections.unmodifiableList(r0);
            r12.extension_ = r0;
        L_0x028b:
            r0 = r1 & 8;
            if (r0 != r6) goto L_0x0297;
        L_0x028f:
            r0 = r12.publicDependency_;
            r0 = java.util.Collections.unmodifiableList(r0);
            r12.publicDependency_ = r0;
        L_0x0297:
            r0 = r1 & 16;
            if (r0 != r8) goto L_0x02a3;
        L_0x029b:
            r0 = r12.weakDependency_;
            r0 = java.util.Collections.unmodifiableList(r0);
            r12.weakDependency_ = r0;
        L_0x02a3:
            r0 = r4.m21495b();
            r12.unknownFields = r0;
            r12.mo888E();
            return;
        L_0x02ad:
            r1 = move-exception;
            r11 = r1;
            r1 = r0;
            r0 = r11;
            goto L_0x0045;
        L_0x02b3:
            r1 = move-exception;
            r11 = r1;
            r1 = r0;
            r0 = r11;
            goto L_0x00b7;
        L_0x02b9:
            r0 = r1;
            goto L_0x022a;
        L_0x02bc:
            r2 = r0;
            goto L_0x0184;
        L_0x02bf:
            r2 = r0;
            goto L_0x0157;
        L_0x02c2:
            r0 = r1;
            goto L_0x0247;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.DescriptorProtos.FileDescriptorProto.<init>(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):void");
        }

        protected final FieldAccessorTable mo880h() {
            return DescriptorProtos.f20806d.m21368a(FileDescriptorProto.class, Builder.class);
        }

        static {
            FileDescriptorProto fileDescriptorProto = new FileDescriptorProto();
            f20712c = fileDescriptorProto;
            fileDescriptorProto.m20737I();
        }

        public final Parser<FileDescriptorProto> mo857i() {
            return f20711a;
        }

        public final String m20753k() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String e = byteString.m20186e();
            if (byteString.mo916f()) {
                this.name_ = e;
            }
            return e;
        }

        private ByteString m20735C() {
            Object obj = this.name_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString a = ByteString.m20173a((String) obj);
            this.name_ = a;
            return a;
        }

        private ByteString m20736D() {
            Object obj = this.package_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString a = ByteString.m20173a((String) obj);
            this.package_ = a;
            return a;
        }

        public final int m20754n() {
            return this.dependency_.size();
        }

        public final int m20755o() {
            return this.publicDependency_.size();
        }

        public final int m20745b(int i) {
            return ((Integer) this.publicDependency_.get(i)).intValue();
        }

        public final int m20756p() {
            return this.messageType_.size();
        }

        public final DescriptorProto m20746c(int i) {
            return (DescriptorProto) this.messageType_.get(i);
        }

        public final int m20757q() {
            return this.enumType_.size();
        }

        public final EnumDescriptorProto m20747d(int i) {
            return (EnumDescriptorProto) this.enumType_.get(i);
        }

        public final int m20758r() {
            return this.service_.size();
        }

        public final ServiceDescriptorProto m20748e(int i) {
            return (ServiceDescriptorProto) this.service_.get(i);
        }

        public final int m20763w() {
            return this.extension_.size();
        }

        public final FieldDescriptorProto m20749f(int i) {
            return (FieldDescriptorProto) this.extension_.get(i);
        }

        public final boolean m20764x() {
            return (this.bitField0_ & 4) == 4;
        }

        private void m20737I() {
            this.name_ = "";
            this.package_ = "";
            this.dependency_ = LazyStringArrayList.f20956a;
            this.publicDependency_ = Collections.emptyList();
            this.weakDependency_ = Collections.emptyList();
            this.messageType_ = Collections.emptyList();
            this.enumType_ = Collections.emptyList();
            this.service_ = Collections.emptyList();
            this.extension_ = Collections.emptyList();
            this.options_ = FileOptions.f20726c;
            this.sourceCodeInfo_ = SourceCodeInfo.f20771c;
        }

        public final boolean mo854a() {
            byte b = this.memoizedIsInitialized;
            if (b == (byte) -1) {
                int i = 0;
                while (i < m20756p()) {
                    if (m20746c(i).mo854a()) {
                        i++;
                    } else {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                i = 0;
                while (i < m20757q()) {
                    if (m20747d(i).mo854a()) {
                        i++;
                    } else {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                i = 0;
                while (i < m20758r()) {
                    if (m20748e(i).mo854a()) {
                        i++;
                    } else {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                i = 0;
                while (i < m20763w()) {
                    if (m20749f(i).mo854a()) {
                        i++;
                    } else {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                if (!m20764x() || this.options_.mo854a()) {
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                }
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (b == (byte) 1) {
                return true;
            } else {
                return false;
            }
        }

        public final void mo853a(CodedOutputStream codedOutputStream) {
            int i;
            int i2 = 0;
            mo855b();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.m20264a(1, m20735C());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.m20264a(2, m20736D());
            }
            for (int i3 = 0; i3 < this.dependency_.size(); i3++) {
                codedOutputStream.m20264a(3, this.dependency_.mo905a(i3));
            }
            for (i = 0; i < this.messageType_.size(); i++) {
                codedOutputStream.m20273b(4, (MessageLite) this.messageType_.get(i));
            }
            for (i = 0; i < this.enumType_.size(); i++) {
                codedOutputStream.m20273b(5, (MessageLite) this.enumType_.get(i));
            }
            for (i = 0; i < this.service_.size(); i++) {
                codedOutputStream.m20273b(6, (MessageLite) this.service_.get(i));
            }
            for (i = 0; i < this.extension_.size(); i++) {
                codedOutputStream.m20273b(7, (MessageLite) this.extension_.get(i));
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.m20273b(8, this.options_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.m20273b(9, this.sourceCodeInfo_);
            }
            for (i = 0; i < this.publicDependency_.size(); i++) {
                codedOutputStream.m20262a(10, ((Integer) this.publicDependency_.get(i)).intValue());
            }
            while (i2 < this.weakDependency_.size()) {
                codedOutputStream.m20262a(11, ((Integer) this.weakDependency_.get(i2)).intValue());
                i2++;
            }
            mo868g().mo853a(codedOutputStream);
        }

        public final int mo855b() {
            int i = 0;
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int i3;
            if ((this.bitField0_ & 1) == 1) {
                i2 = CodedOutputStream.m20236c(1, m20735C()) + 0;
            } else {
                i2 = 0;
            }
            if ((this.bitField0_ & 2) == 2) {
                i2 += CodedOutputStream.m20236c(2, m20736D());
            }
            int i4 = 0;
            for (i3 = 0; i3 < this.dependency_.size(); i3++) {
                i4 += CodedOutputStream.m20232b(this.dependency_.mo905a(i3));
            }
            i4 = (i2 + i4) + (this.dependency_.size() * 1);
            for (i3 = 0; i3 < this.messageType_.size(); i3++) {
                i4 += CodedOutputStream.m20242e(4, (MessageLite) this.messageType_.get(i3));
            }
            for (i3 = 0; i3 < this.enumType_.size(); i3++) {
                i4 += CodedOutputStream.m20242e(5, (MessageLite) this.enumType_.get(i3));
            }
            for (i3 = 0; i3 < this.service_.size(); i3++) {
                i4 += CodedOutputStream.m20242e(6, (MessageLite) this.service_.get(i3));
            }
            for (i3 = 0; i3 < this.extension_.size(); i3++) {
                i4 += CodedOutputStream.m20242e(7, (MessageLite) this.extension_.get(i3));
            }
            if ((this.bitField0_ & 4) == 4) {
                i4 += CodedOutputStream.m20242e(8, this.options_);
            }
            if ((this.bitField0_ & 8) == 8) {
                i4 += CodedOutputStream.m20242e(9, this.sourceCodeInfo_);
            }
            int i5 = 0;
            for (i3 = 0; i3 < this.publicDependency_.size(); i3++) {
                i5 += CodedOutputStream.m20245g(((Integer) this.publicDependency_.get(i3)).intValue());
            }
            i4 = (i4 + i5) + (this.publicDependency_.size() * 1);
            i3 = 0;
            while (i < this.weakDependency_.size()) {
                i++;
                i3 = CodedOutputStream.m20245g(((Integer) this.weakDependency_.get(i)).intValue()) + i3;
            }
            i2 = ((i4 + i3) + (this.weakDependency_.size() * 1)) + mo868g().mo855b();
            this.memoizedSerializedSize = i2;
            return i2;
        }

        public static FileDescriptorProto m20738a(byte[] bArr) {
            return (FileDescriptorProto) f20711a.m20167a(bArr);
        }

        public static FileDescriptorProto m20739a(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (FileDescriptorProto) f20711a.m20168a(bArr, extensionRegistryLite);
        }

        public final Message$Builder mo882t() {
            return Builder.m20714n();
        }

        private static Builder m20740j(FileDescriptorProto fileDescriptorProto) {
            return Builder.m20714n().m20720a(fileDescriptorProto);
        }

        protected final Message$Builder mo879a(BuilderParent builderParent) {
            return new Builder(builderParent);
        }
    }

    public interface FileOptionsOrBuilder extends ExtendableMessageOrBuilder {
    }

    /* compiled from: analytics_source */
    public final class FileOptions extends ExtendableMessage<FileOptions> implements FileOptionsOrBuilder {
        public static Parser<FileOptions> f20725a = new C24301();
        public static final FileOptions f20726c;
        public int bitField0_;
        public boolean ccGenericServices_;
        public Object goPackage_;
        public boolean javaGenerateEqualsAndHash_;
        public boolean javaGenericServices_;
        public boolean javaMultipleFiles_;
        public Object javaOuterClassname_;
        public Object javaPackage_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        public OptimizeMode optimizeFor_;
        public boolean pyGenericServices_;
        public List<UninterpretedOption> uninterpretedOption_;
        private final UnknownFieldSet unknownFields;

        /* compiled from: analytics_source */
        final class C24301 extends AbstractParser<FileOptions> {
            C24301() {
            }

            public final Object mo859a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return new FileOptions(codedInputStream, extensionRegistryLite);
            }
        }

        /* compiled from: analytics_source */
        public final class Builder extends ExtendableBuilder<FileOptions, Builder> implements FileOptionsOrBuilder {
            public int f20713a;
            private Object f20714b = "";
            private Object f20715c = "";
            public boolean f20716d;
            public boolean f20717e;
            private OptimizeMode f20718f = OptimizeMode.SPEED;
            private Object f20719g = "";
            public boolean f20720h;
            public boolean f20721i;
            public boolean f20722j;
            public List<UninterpretedOption> f20723k = Collections.emptyList();
            public RepeatedFieldBuilder<UninterpretedOption, Builder, UninterpretedOptionOrBuilder> f20724l;

            public final AbstractMessage mo878v() {
                return FileOptions.f20726c;
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo870a(AbstractMessage abstractMessage) {
                return m20769d(abstractMessage);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo871a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m20770d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo863b() {
                return m20773y();
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo846b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m20770d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo848c() {
                return m20773y();
            }

            public final /* synthetic */ Message$Builder mo849c(AbstractMessage abstractMessage) {
                return m20769d(abstractMessage);
            }

            public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo840c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m20770d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ Object clone() {
                return m20773y();
            }

            public final /* synthetic */ com.google.protobuf.GeneratedMessage.Builder mo873f() {
                return m20773y();
            }

            public final /* synthetic */ AbstractMessage mo874h() {
                return mo886l();
            }

            public final /* synthetic */ AbstractMessage mo875i() {
                return m20766A();
            }

            public final /* synthetic */ MessageLite mo876j() {
                return mo886l();
            }

            public final /* synthetic */ MessageLite mo877k() {
                return m20766A();
            }

            public final /* synthetic */ ExtendableBuilder mo887m() {
                return m20773y();
            }

            protected final FieldAccessorTable mo872d() {
                return DescriptorProtos.f20822t.m21368a(FileOptions.class, Builder.class);
            }

            private Builder() {
                m20771w();
            }

            public Builder(BuilderParent builderParent) {
                super(builderParent);
                m20771w();
            }

            private void m20771w() {
                if (GeneratedMessage.f20638b) {
                    m20767D();
                }
            }

            public static Builder m20772x() {
                return new Builder();
            }

            private Builder m20773y() {
                return m20772x().m20776a(mo886l());
            }

            public final Descriptor mo841e() {
                return DescriptorProtos.f20821s;
            }

            private FileOptions m20766A() {
                AbstractMessage l = mo886l();
                if (l.mo854a()) {
                    return l;
                }
                throw com.google.protobuf.AbstractMessage.Builder.m20123b(l);
            }

            public final FileOptions mo886l() {
                int i = 1;
                FileOptions fileOptions = new FileOptions(this);
                int i2 = this.f20713a;
                if ((i2 & 1) != 1) {
                    i = 0;
                }
                fileOptions.javaPackage_ = this.f20714b;
                if ((i2 & 2) == 2) {
                    i |= 2;
                }
                fileOptions.javaOuterClassname_ = this.f20715c;
                if ((i2 & 4) == 4) {
                    i |= 4;
                }
                fileOptions.javaMultipleFiles_ = this.f20716d;
                if ((i2 & 8) == 8) {
                    i |= 8;
                }
                fileOptions.javaGenerateEqualsAndHash_ = this.f20717e;
                if ((i2 & 16) == 16) {
                    i |= 16;
                }
                fileOptions.optimizeFor_ = this.f20718f;
                if ((i2 & 32) == 32) {
                    i |= 32;
                }
                fileOptions.goPackage_ = this.f20719g;
                if ((i2 & 64) == 64) {
                    i |= 64;
                }
                fileOptions.ccGenericServices_ = this.f20720h;
                if ((i2 & 128) == 128) {
                    i |= 128;
                }
                fileOptions.javaGenericServices_ = this.f20721i;
                if ((i2 & 256) == 256) {
                    i |= 256;
                }
                fileOptions.pyGenericServices_ = this.f20722j;
                if (this.f20724l == null) {
                    if ((this.f20713a & 512) == 512) {
                        this.f20723k = Collections.unmodifiableList(this.f20723k);
                        this.f20713a &= -513;
                    }
                    fileOptions.uninterpretedOption_ = this.f20723k;
                } else {
                    fileOptions.uninterpretedOption_ = this.f20724l.m21416f();
                }
                fileOptions.bitField0_ = i;
                m20309p();
                return fileOptions;
            }

            private Builder m20769d(AbstractMessage abstractMessage) {
                if (abstractMessage instanceof FileOptions) {
                    return m20776a((FileOptions) abstractMessage);
                }
                super.mo870a(abstractMessage);
                return this;
            }

            public final Builder m20776a(FileOptions fileOptions) {
                RepeatedFieldBuilder repeatedFieldBuilder = null;
                if (fileOptions != FileOptions.f20726c) {
                    boolean z;
                    Object obj = 1;
                    if ((fileOptions.bitField0_ & 1) != 1) {
                        obj = null;
                    }
                    if (obj != null) {
                        this.f20713a |= 1;
                        this.f20714b = fileOptions.javaPackage_;
                        m20312t();
                    }
                    if ((fileOptions.bitField0_ & 2) == 2) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        this.f20713a |= 2;
                        this.f20715c = fileOptions.javaOuterClassname_;
                        m20312t();
                    }
                    if ((fileOptions.bitField0_ & 4) == 4) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        z = fileOptions.javaMultipleFiles_;
                        this.f20713a |= 4;
                        this.f20716d = z;
                        m20312t();
                    }
                    if ((fileOptions.bitField0_ & 8) == 8) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        z = fileOptions.javaGenerateEqualsAndHash_;
                        this.f20713a |= 8;
                        this.f20717e = z;
                        m20312t();
                    }
                    if ((fileOptions.bitField0_ & 16) == 16) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        m20768a(fileOptions.optimizeFor_);
                    }
                    if ((fileOptions.bitField0_ & 32) == 32) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        this.f20713a |= 32;
                        this.f20719g = fileOptions.goPackage_;
                        m20312t();
                    }
                    if ((fileOptions.bitField0_ & 64) == 64) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        z = fileOptions.ccGenericServices_;
                        this.f20713a |= 64;
                        this.f20720h = z;
                        m20312t();
                    }
                    if ((fileOptions.bitField0_ & 128) == 128) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        z = fileOptions.javaGenericServices_;
                        this.f20713a |= 128;
                        this.f20721i = z;
                        m20312t();
                    }
                    if ((fileOptions.bitField0_ & 256) == 256) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        z = fileOptions.pyGenericServices_;
                        this.f20713a |= 256;
                        this.f20722j = z;
                        m20312t();
                    }
                    if (this.f20724l == null) {
                        if (!fileOptions.uninterpretedOption_.isEmpty()) {
                            if (this.f20723k.isEmpty()) {
                                this.f20723k = fileOptions.uninterpretedOption_;
                                this.f20713a &= -513;
                            } else {
                                if ((this.f20713a & 512) != 512) {
                                    this.f20723k = new ArrayList(this.f20723k);
                                    this.f20713a |= 512;
                                }
                                this.f20723k.addAll(fileOptions.uninterpretedOption_);
                            }
                            m20312t();
                        }
                    } else if (!fileOptions.uninterpretedOption_.isEmpty()) {
                        if (this.f20724l.m21414d()) {
                            this.f20724l.m21411b();
                            this.f20724l = null;
                            this.f20723k = fileOptions.uninterpretedOption_;
                            this.f20713a &= -513;
                            if (GeneratedMessage.f20638b) {
                                repeatedFieldBuilder = m20767D();
                            }
                            this.f20724l = repeatedFieldBuilder;
                        } else {
                            this.f20724l.m21409a(fileOptions.uninterpretedOption_);
                        }
                    }
                    m20467a((ExtendableMessage) fileOptions);
                    m20301c(fileOptions.mo868g());
                }
                return this;
            }

            public final boolean mo854a() {
                int i = 0;
                while (true) {
                    int size;
                    if (this.f20724l == null) {
                        size = this.f20723k.size();
                    } else {
                        size = this.f20724l.m21412c();
                    }
                    if (i >= size) {
                        break;
                    }
                    if (this.f20724l == null) {
                        AbstractMessage abstractMessage = (UninterpretedOption) this.f20723k.get(i);
                    } else {
                        UninterpretedOption uninterpretedOption = (UninterpretedOption) this.f20724l.m21406a(i);
                    }
                    if (!abstractMessage.mo854a()) {
                        return false;
                    }
                    i++;
                }
                if (m20478u()) {
                    return true;
                }
                return false;
            }

            private Builder m20770d(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                Throwable th;
                FileOptions fileOptions;
                FileOptions fileOptions2;
                try {
                    fileOptions2 = (FileOptions) FileOptions.f20725a.mo859a(codedInputStream, extensionRegistryLite);
                    if (fileOptions2 != null) {
                        m20776a(fileOptions2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    InvalidProtocolBufferException invalidProtocolBufferException = e;
                    fileOptions2 = (FileOptions) invalidProtocolBufferException.m21375a();
                    throw invalidProtocolBufferException;
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    fileOptions = fileOptions2;
                    th = th3;
                }
                if (fileOptions != null) {
                    m20776a(fileOptions);
                }
                throw th;
            }

            private Builder m20768a(OptimizeMode optimizeMode) {
                if (optimizeMode == null) {
                    throw new NullPointerException();
                }
                this.f20713a |= 16;
                this.f20718f = optimizeMode;
                m20312t();
                return this;
            }

            private RepeatedFieldBuilder<UninterpretedOption, Builder, UninterpretedOptionOrBuilder> m20767D() {
                if (this.f20724l == null) {
                    this.f20724l = new RepeatedFieldBuilder(this.f20723k, (this.f20713a & 512) == 512, m20311s(), this.f20619c);
                    this.f20723k = null;
                }
                return this.f20724l;
            }
        }

        /* compiled from: analytics_source */
        public enum OptimizeMode implements ProtocolMessageEnum {
            SPEED(0, 1),
            CODE_SIZE(1, 2),
            LITE_RUNTIME(2, 3);
            
            private static final OptimizeMode[] VALUES = null;
            private static EnumLiteMap<OptimizeMode> internalValueMap;
            private final int index;
            private final int value;

            /* compiled from: analytics_source */
            final class C24311 implements EnumLiteMap<OptimizeMode> {
                C24311() {
                }
            }

            public static OptimizeMode valueOf(EnumValueDescriptor enumValueDescriptor) {
                if (enumValueDescriptor.f20860e == getDescriptor()) {
                    return VALUES[enumValueDescriptor.f20856a];
                }
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }

            static {
                internalValueMap = new C24311();
                VALUES = values();
            }

            public final int getNumber() {
                return this.value;
            }

            public static OptimizeMode valueOf(int i) {
                switch (i) {
                    case 1:
                        return SPEED;
                    case 2:
                        return CODE_SIZE;
                    case 3:
                        return LITE_RUNTIME;
                    default:
                        return null;
                }
            }

            public static EnumLiteMap<OptimizeMode> internalGetValueMap() {
                return internalValueMap;
            }

            public final EnumValueDescriptor getValueDescriptor() {
                return (EnumValueDescriptor) getDescriptor().m21220d().get(this.index);
            }

            public final EnumDescriptor getDescriptorForType() {
                return getDescriptor();
            }

            public static final EnumDescriptor getDescriptor() {
                return (EnumDescriptor) DescriptorProtos.f20821s.m21198g().get(0);
            }

            private OptimizeMode(int i, int i2) {
                this.index = i;
                this.value = i2;
            }
        }

        public final /* synthetic */ Message$Builder mo881s() {
            return m20798D();
        }

        public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo883u() {
            return m20798D();
        }

        public FileOptions(ExtendableBuilder<FileOptions, ?> extendableBuilder) {
            super(extendableBuilder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = extendableBuilder.mo868g();
        }

        private FileOptions() {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.f21031a;
        }

        public final AbstractMessage mo878v() {
            return f20726c;
        }

        public final UnknownFieldSet mo868g() {
            return this.unknownFields;
        }

        public FileOptions(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            Throwable th;
            int i = 0;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            m20796N();
            com.google.protobuf.UnknownFieldSet.Builder e = com.google.protobuf.UnknownFieldSet.Builder.m21487e();
            int i2 = 0;
            while (i2 == 0) {
                try {
                    int a = codedInputStream.m20202a();
                    switch (a) {
                        case 0:
                            i2 = 1;
                            break;
                        case 10:
                            this.bitField0_ |= 1;
                            this.javaPackage_ = codedInputStream.m20219k();
                            break;
                        case 66:
                            this.bitField0_ |= 2;
                            this.javaOuterClassname_ = codedInputStream.m20219k();
                            break;
                        case 72:
                            a = codedInputStream.m20221m();
                            OptimizeMode valueOf = OptimizeMode.valueOf(a);
                            if (valueOf != null) {
                                this.bitField0_ |= 16;
                                this.optimizeFor_ = valueOf;
                                break;
                            }
                            e.m21488a(9, a);
                            break;
                        case 80:
                            this.bitField0_ |= 4;
                            this.javaMultipleFiles_ = codedInputStream.m20217i();
                            break;
                        case 90:
                            this.bitField0_ |= 32;
                            this.goPackage_ = codedInputStream.m20219k();
                            break;
                        case 128:
                            this.bitField0_ |= 64;
                            this.ccGenericServices_ = codedInputStream.m20217i();
                            break;
                        case 136:
                            this.bitField0_ |= 128;
                            this.javaGenericServices_ = codedInputStream.m20217i();
                            break;
                        case 144:
                            this.bitField0_ |= 256;
                            this.pyGenericServices_ = codedInputStream.m20217i();
                            break;
                        case 160:
                            this.bitField0_ |= 8;
                            this.javaGenerateEqualsAndHash_ = codedInputStream.m20217i();
                            break;
                        case 7994:
                            if ((i & 512) != 512) {
                                this.uninterpretedOption_ = new ArrayList();
                                i |= 512;
                            }
                            this.uninterpretedOption_.add(codedInputStream.m20203a(UninterpretedOption.f20786a, extensionRegistryLite));
                            break;
                        default:
                            if (!mo889a(codedInputStream, e, extensionRegistryLite, a)) {
                                i2 = 1;
                                break;
                            }
                            break;
                    }
                } catch (InvalidProtocolBufferException e2) {
                    InvalidProtocolBufferException invalidProtocolBufferException = e2;
                    i2 = i;
                    throw invalidProtocolBufferException.m21374a(this);
                } catch (IOException e3) {
                    IOException iOException = e3;
                    i2 = i;
                    throw new InvalidProtocolBufferException(iOException.getMessage()).m21374a(this);
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if ((i & 512) == 512) {
                this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
            }
            this.unknownFields = e.m21495b();
            mo888E();
            return;
            if ((i2 & 512) == 512) {
                this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
            }
            this.unknownFields = e.m21495b();
            mo888E();
            throw th;
        }

        protected final FieldAccessorTable mo880h() {
            return DescriptorProtos.f20822t.m21368a(FileOptions.class, Builder.class);
        }

        static {
            FileOptions fileOptions = new FileOptions();
            f20726c = fileOptions;
            fileOptions.m20796N();
        }

        public final Parser<FileOptions> mo857i() {
            return f20725a;
        }

        private ByteString m20793J() {
            Object obj = this.javaPackage_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString a = ByteString.m20173a((String) obj);
            this.javaPackage_ = a;
            return a;
        }

        private ByteString m20794K() {
            Object obj = this.javaOuterClassname_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString a = ByteString.m20173a((String) obj);
            this.javaOuterClassname_ = a;
            return a;
        }

        private ByteString m20795L() {
            Object obj = this.goPackage_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString a = ByteString.m20173a((String) obj);
            this.goPackage_ = a;
            return a;
        }

        private void m20796N() {
            this.javaPackage_ = "";
            this.javaOuterClassname_ = "";
            this.javaMultipleFiles_ = false;
            this.javaGenerateEqualsAndHash_ = false;
            this.optimizeFor_ = OptimizeMode.SPEED;
            this.goPackage_ = "";
            this.ccGenericServices_ = false;
            this.javaGenericServices_ = false;
            this.pyGenericServices_ = false;
            this.uninterpretedOption_ = Collections.emptyList();
        }

        public final boolean mo854a() {
            byte b = this.memoizedIsInitialized;
            if (b == (byte) -1) {
                int i = 0;
                while (i < this.uninterpretedOption_.size()) {
                    if (((UninterpretedOption) this.uninterpretedOption_.get(i)).mo854a()) {
                        i++;
                    } else {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                if (m20507F()) {
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                }
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (b == (byte) 1) {
                return true;
            } else {
                return false;
            }
        }

        public final void mo853a(CodedOutputStream codedOutputStream) {
            mo855b();
            ExtensionWriter G = m20508G();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.m20264a(1, m20793J());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.m20264a(8, m20794K());
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.m20280d(9, this.optimizeFor_.getNumber());
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.m20266a(10, this.javaMultipleFiles_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.m20264a(11, m20795L());
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.m20266a(16, this.ccGenericServices_);
            }
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.m20266a(17, this.javaGenericServices_);
            }
            if ((this.bitField0_ & 256) == 256) {
                codedOutputStream.m20266a(18, this.pyGenericServices_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.m20266a(20, this.javaGenerateEqualsAndHash_);
            }
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                codedOutputStream.m20273b(999, (MessageLite) this.uninterpretedOption_.get(i));
            }
            G.m21338a(536870912, codedOutputStream);
            mo868g().mo853a(codedOutputStream);
        }

        public final int mo855b() {
            int i = 0;
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            if ((this.bitField0_ & 1) == 1) {
                i2 = CodedOutputStream.m20236c(1, m20793J()) + 0;
            } else {
                i2 = 0;
            }
            if ((this.bitField0_ & 2) == 2) {
                i2 += CodedOutputStream.m20236c(8, m20794K());
            }
            if ((this.bitField0_ & 16) == 16) {
                i2 += CodedOutputStream.m20247h(9, this.optimizeFor_.getNumber());
            }
            if ((this.bitField0_ & 4) == 4) {
                i2 += CodedOutputStream.m20231b(10, this.javaMultipleFiles_);
            }
            if ((this.bitField0_ & 32) == 32) {
                i2 += CodedOutputStream.m20236c(11, m20795L());
            }
            if ((this.bitField0_ & 64) == 64) {
                i2 += CodedOutputStream.m20231b(16, this.ccGenericServices_);
            }
            if ((this.bitField0_ & 128) == 128) {
                i2 += CodedOutputStream.m20231b(17, this.javaGenericServices_);
            }
            if ((this.bitField0_ & 256) == 256) {
                i2 += CodedOutputStream.m20231b(18, this.pyGenericServices_);
            }
            if ((this.bitField0_ & 8) == 8) {
                i2 += CodedOutputStream.m20231b(20, this.javaGenerateEqualsAndHash_);
            }
            int i3 = i2;
            while (i < this.uninterpretedOption_.size()) {
                i++;
                i3 = CodedOutputStream.m20242e(999, (MessageLite) this.uninterpretedOption_.get(i)) + i3;
            }
            i2 = (m20509H() + i3) + mo868g().mo855b();
            this.memoizedSerializedSize = i2;
            return i2;
        }

        protected final Object writeReplace() {
            return super.writeReplace();
        }

        public final Message$Builder mo882t() {
            return Builder.m20772x();
        }

        public static Builder m20797a(FileOptions fileOptions) {
            return Builder.m20772x().m20776a(fileOptions);
        }

        public final Builder m20798D() {
            return m20797a(this);
        }

        protected final Message$Builder mo879a(BuilderParent builderParent) {
            return new Builder(builderParent);
        }
    }

    public interface MessageOptionsOrBuilder extends ExtendableMessageOrBuilder {
    }

    /* compiled from: analytics_source */
    public final class MessageOptions extends ExtendableMessage<MessageOptions> implements MessageOptionsOrBuilder {
        public static Parser<MessageOptions> f20732a = new C24321();
        public static final MessageOptions f20733c;
        public int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        public boolean messageSetWireFormat_;
        public boolean noStandardDescriptorAccessor_;
        public List<UninterpretedOption> uninterpretedOption_;
        private final UnknownFieldSet unknownFields;

        /* compiled from: analytics_source */
        final class C24321 extends AbstractParser<MessageOptions> {
            C24321() {
            }

            public final Object mo859a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return new MessageOptions(codedInputStream, extensionRegistryLite);
            }
        }

        /* compiled from: analytics_source */
        public final class Builder extends ExtendableBuilder<MessageOptions, Builder> implements MessageOptionsOrBuilder {
            public int f20727a;
            public boolean f20728b;
            public boolean f20729c;
            public List<UninterpretedOption> f20730d = Collections.emptyList();
            public RepeatedFieldBuilder<UninterpretedOption, Builder, UninterpretedOptionOrBuilder> f20731e;

            public final AbstractMessage mo878v() {
                return MessageOptions.f20733c;
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo870a(AbstractMessage abstractMessage) {
                return m20813d(abstractMessage);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo871a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m20814d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo863b() {
                return m20817y();
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo846b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m20814d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo848c() {
                return m20817y();
            }

            public final /* synthetic */ Message$Builder mo849c(AbstractMessage abstractMessage) {
                return m20813d(abstractMessage);
            }

            public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo840c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m20814d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ Object clone() {
                return m20817y();
            }

            public final /* synthetic */ com.google.protobuf.GeneratedMessage.Builder mo873f() {
                return m20817y();
            }

            public final /* synthetic */ AbstractMessage mo874h() {
                return mo886l();
            }

            public final /* synthetic */ AbstractMessage mo875i() {
                return m20811A();
            }

            public final /* synthetic */ MessageLite mo876j() {
                return mo886l();
            }

            public final /* synthetic */ MessageLite mo877k() {
                return m20811A();
            }

            public final /* synthetic */ ExtendableBuilder mo887m() {
                return m20817y();
            }

            protected final FieldAccessorTable mo872d() {
                return DescriptorProtos.f20824v.m21368a(MessageOptions.class, Builder.class);
            }

            private Builder() {
                m20815w();
            }

            public Builder(BuilderParent builderParent) {
                super(builderParent);
                m20815w();
            }

            private void m20815w() {
                if (GeneratedMessage.f20638b) {
                    m20812D();
                }
            }

            public static Builder m20816x() {
                return new Builder();
            }

            private Builder m20817y() {
                return m20816x().m20820a(mo886l());
            }

            public final Descriptor mo841e() {
                return DescriptorProtos.f20823u;
            }

            private MessageOptions m20811A() {
                AbstractMessage l = mo886l();
                if (l.mo854a()) {
                    return l;
                }
                throw com.google.protobuf.AbstractMessage.Builder.m20123b(l);
            }

            public final MessageOptions mo886l() {
                int i = 1;
                MessageOptions messageOptions = new MessageOptions(this);
                int i2 = this.f20727a;
                if ((i2 & 1) != 1) {
                    i = 0;
                }
                messageOptions.messageSetWireFormat_ = this.f20728b;
                if ((i2 & 2) == 2) {
                    i |= 2;
                }
                messageOptions.noStandardDescriptorAccessor_ = this.f20729c;
                if (this.f20731e == null) {
                    if ((this.f20727a & 4) == 4) {
                        this.f20730d = Collections.unmodifiableList(this.f20730d);
                        this.f20727a &= -5;
                    }
                    messageOptions.uninterpretedOption_ = this.f20730d;
                } else {
                    messageOptions.uninterpretedOption_ = this.f20731e.m21416f();
                }
                messageOptions.bitField0_ = i;
                m20309p();
                return messageOptions;
            }

            private Builder m20813d(AbstractMessage abstractMessage) {
                if (abstractMessage instanceof MessageOptions) {
                    return m20820a((MessageOptions) abstractMessage);
                }
                super.mo870a(abstractMessage);
                return this;
            }

            public final Builder m20820a(MessageOptions messageOptions) {
                RepeatedFieldBuilder repeatedFieldBuilder = null;
                if (messageOptions != MessageOptions.f20733c) {
                    boolean z;
                    Object obj = 1;
                    if ((messageOptions.bitField0_ & 1) != 1) {
                        obj = null;
                    }
                    if (obj != null) {
                        z = messageOptions.messageSetWireFormat_;
                        this.f20727a |= 1;
                        this.f20728b = z;
                        m20312t();
                    }
                    if ((messageOptions.bitField0_ & 2) == 2) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        z = messageOptions.noStandardDescriptorAccessor_;
                        this.f20727a |= 2;
                        this.f20729c = z;
                        m20312t();
                    }
                    if (this.f20731e == null) {
                        if (!messageOptions.uninterpretedOption_.isEmpty()) {
                            if (this.f20730d.isEmpty()) {
                                this.f20730d = messageOptions.uninterpretedOption_;
                                this.f20727a &= -5;
                            } else {
                                if ((this.f20727a & 4) != 4) {
                                    this.f20730d = new ArrayList(this.f20730d);
                                    this.f20727a |= 4;
                                }
                                this.f20730d.addAll(messageOptions.uninterpretedOption_);
                            }
                            m20312t();
                        }
                    } else if (!messageOptions.uninterpretedOption_.isEmpty()) {
                        if (this.f20731e.m21414d()) {
                            this.f20731e.m21411b();
                            this.f20731e = null;
                            this.f20730d = messageOptions.uninterpretedOption_;
                            this.f20727a &= -5;
                            if (GeneratedMessage.f20638b) {
                                repeatedFieldBuilder = m20812D();
                            }
                            this.f20731e = repeatedFieldBuilder;
                        } else {
                            this.f20731e.m21409a(messageOptions.uninterpretedOption_);
                        }
                    }
                    m20467a((ExtendableMessage) messageOptions);
                    m20301c(messageOptions.mo868g());
                }
                return this;
            }

            public final boolean mo854a() {
                int i = 0;
                while (true) {
                    int size;
                    if (this.f20731e == null) {
                        size = this.f20730d.size();
                    } else {
                        size = this.f20731e.m21412c();
                    }
                    if (i >= size) {
                        break;
                    }
                    if (this.f20731e == null) {
                        AbstractMessage abstractMessage = (UninterpretedOption) this.f20730d.get(i);
                    } else {
                        UninterpretedOption uninterpretedOption = (UninterpretedOption) this.f20731e.m21406a(i);
                    }
                    if (!abstractMessage.mo854a()) {
                        return false;
                    }
                    i++;
                }
                if (m20478u()) {
                    return true;
                }
                return false;
            }

            private Builder m20814d(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                MessageOptions messageOptions;
                Throwable th;
                MessageOptions messageOptions2;
                try {
                    messageOptions = (MessageOptions) MessageOptions.f20732a.mo859a(codedInputStream, extensionRegistryLite);
                    if (messageOptions != null) {
                        m20820a(messageOptions);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    InvalidProtocolBufferException invalidProtocolBufferException = e;
                    messageOptions = (MessageOptions) invalidProtocolBufferException.m21375a();
                    throw invalidProtocolBufferException;
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    messageOptions2 = messageOptions;
                    th = th3;
                }
                if (messageOptions2 != null) {
                    m20820a(messageOptions2);
                }
                throw th;
            }

            private RepeatedFieldBuilder<UninterpretedOption, Builder, UninterpretedOptionOrBuilder> m20812D() {
                if (this.f20731e == null) {
                    this.f20731e = new RepeatedFieldBuilder(this.f20730d, (this.f20727a & 4) == 4, m20311s(), this.f20619c);
                    this.f20730d = null;
                }
                return this.f20731e;
            }
        }

        public final /* synthetic */ Message$Builder mo881s() {
            return m20847n();
        }

        public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo883u() {
            return m20847n();
        }

        public MessageOptions(ExtendableBuilder<MessageOptions, ?> extendableBuilder) {
            super(extendableBuilder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = extendableBuilder.mo868g();
        }

        private MessageOptions() {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.f21031a;
        }

        public final AbstractMessage mo878v() {
            return f20733c;
        }

        public final UnknownFieldSet mo868g() {
            return this.unknownFields;
        }

        public MessageOptions(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            Throwable th;
            int i = 0;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            m20838q();
            com.google.protobuf.UnknownFieldSet.Builder e = com.google.protobuf.UnknownFieldSet.Builder.m21487e();
            int i2 = 0;
            while (i2 == 0) {
                try {
                    int a = codedInputStream.m20202a();
                    switch (a) {
                        case 0:
                            i2 = 1;
                            break;
                        case 8:
                            this.bitField0_ |= 1;
                            this.messageSetWireFormat_ = codedInputStream.m20217i();
                            break;
                        case 16:
                            this.bitField0_ |= 2;
                            this.noStandardDescriptorAccessor_ = codedInputStream.m20217i();
                            break;
                        case 7994:
                            if ((i & 4) != 4) {
                                this.uninterpretedOption_ = new ArrayList();
                                i |= 4;
                            }
                            this.uninterpretedOption_.add(codedInputStream.m20203a(UninterpretedOption.f20786a, extensionRegistryLite));
                            break;
                        default:
                            if (!mo889a(codedInputStream, e, extensionRegistryLite, a)) {
                                i2 = 1;
                                break;
                            }
                            break;
                    }
                } catch (InvalidProtocolBufferException e2) {
                    InvalidProtocolBufferException invalidProtocolBufferException = e2;
                    i2 = i;
                    throw invalidProtocolBufferException.m21374a(this);
                } catch (IOException e3) {
                    IOException iOException = e3;
                    i2 = i;
                    throw new InvalidProtocolBufferException(iOException.getMessage()).m21374a(this);
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if ((i & 4) == 4) {
                this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
            }
            this.unknownFields = e.m21495b();
            mo888E();
            return;
            if ((i2 & 4) == 4) {
                this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
            }
            this.unknownFields = e.m21495b();
            mo888E();
            throw th;
        }

        protected final FieldAccessorTable mo880h() {
            return DescriptorProtos.f20824v.m21368a(MessageOptions.class, Builder.class);
        }

        static {
            MessageOptions messageOptions = new MessageOptions();
            f20733c = messageOptions;
            messageOptions.m20838q();
        }

        public final Parser<MessageOptions> mo857i() {
            return f20732a;
        }

        public final boolean m20846k() {
            return this.messageSetWireFormat_;
        }

        private void m20838q() {
            this.messageSetWireFormat_ = false;
            this.noStandardDescriptorAccessor_ = false;
            this.uninterpretedOption_ = Collections.emptyList();
        }

        public final boolean mo854a() {
            byte b = this.memoizedIsInitialized;
            if (b == (byte) -1) {
                int i = 0;
                while (i < this.uninterpretedOption_.size()) {
                    if (((UninterpretedOption) this.uninterpretedOption_.get(i)).mo854a()) {
                        i++;
                    } else {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                if (m20507F()) {
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                }
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (b == (byte) 1) {
                return true;
            } else {
                return false;
            }
        }

        public final void mo853a(CodedOutputStream codedOutputStream) {
            mo855b();
            ExtensionWriter G = m20508G();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.m20266a(1, this.messageSetWireFormat_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.m20266a(2, this.noStandardDescriptorAccessor_);
            }
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                codedOutputStream.m20273b(999, (MessageLite) this.uninterpretedOption_.get(i));
            }
            G.m21338a(536870912, codedOutputStream);
            mo868g().mo853a(codedOutputStream);
        }

        public final int mo855b() {
            int i = 0;
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            if ((this.bitField0_ & 1) == 1) {
                i2 = CodedOutputStream.m20231b(1, this.messageSetWireFormat_) + 0;
            } else {
                i2 = 0;
            }
            if ((this.bitField0_ & 2) == 2) {
                i2 += CodedOutputStream.m20231b(2, this.noStandardDescriptorAccessor_);
            }
            int i3 = i2;
            while (i < this.uninterpretedOption_.size()) {
                i++;
                i3 = CodedOutputStream.m20242e(999, (MessageLite) this.uninterpretedOption_.get(i)) + i3;
            }
            i2 = (m20509H() + i3) + mo868g().mo855b();
            this.memoizedSerializedSize = i2;
            return i2;
        }

        protected final Object writeReplace() {
            return super.writeReplace();
        }

        public final Message$Builder mo882t() {
            return Builder.m20816x();
        }

        public static Builder m20837a(MessageOptions messageOptions) {
            return Builder.m20816x().m20820a(messageOptions);
        }

        public final Builder m20847n() {
            return m20837a(this);
        }

        protected final Message$Builder mo879a(BuilderParent builderParent) {
            return new Builder(builderParent);
        }
    }

    public interface MethodDescriptorProtoOrBuilder extends MessageOrBuilder {
    }

    /* compiled from: analytics_source */
    public final class MethodDescriptorProto extends GeneratedMessage implements MethodDescriptorProtoOrBuilder {
        public static Parser<MethodDescriptorProto> f20740a = new C24331();
        public static final MethodDescriptorProto f20741c;
        public int bitField0_;
        public Object inputType_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        public Object name_;
        public MethodOptions options_;
        public Object outputType_;
        private final UnknownFieldSet unknownFields;

        /* compiled from: analytics_source */
        final class C24331 extends AbstractParser<MethodDescriptorProto> {
            C24331() {
            }

            public final Object mo859a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return new MethodDescriptorProto(codedInputStream, extensionRegistryLite);
            }
        }

        /* compiled from: analytics_source */
        public final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> implements MethodDescriptorProtoOrBuilder {
            public int f20734a;
            private Object f20735b = "";
            private Object f20736c = "";
            private Object f20737d = "";
            public MethodOptions f20738e = MethodOptions.f20746c;
            public SingleFieldBuilder<MethodOptions, Builder, MethodOptionsOrBuilder> f20739f;

            public final Builder m20862a(MethodDescriptorProto methodDescriptorProto) {
                if (methodDescriptorProto != MethodDescriptorProto.f20741c) {
                    Object obj = 1;
                    if ((methodDescriptorProto.bitField0_ & 1) != 1) {
                        obj = null;
                    }
                    if (obj != null) {
                        this.f20734a |= 1;
                        this.f20735b = methodDescriptorProto.name_;
                        m20312t();
                    }
                    if ((methodDescriptorProto.bitField0_ & 2) == 2) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        this.f20734a |= 2;
                        this.f20736c = methodDescriptorProto.inputType_;
                        m20312t();
                    }
                    if ((methodDescriptorProto.bitField0_ & 4) == 4) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        this.f20734a |= 4;
                        this.f20737d = methodDescriptorProto.outputType_;
                        m20312t();
                    }
                    if (methodDescriptorProto.m20892p()) {
                        MethodOptions methodOptions = methodDescriptorProto.options_;
                        if (this.f20739f == null) {
                            if ((this.f20734a & 8) != 8 || this.f20738e == MethodOptions.f20746c) {
                                this.f20738e = methodOptions;
                            } else {
                                this.f20738e = MethodOptions.m20924a(this.f20738e).m20907a(methodOptions).mo886l();
                            }
                            m20312t();
                        } else {
                            this.f20739f.m21439b(methodOptions);
                        }
                        this.f20734a |= 8;
                    }
                    m20301c(methodDescriptorProto.mo868g());
                }
                return this;
            }

            public final AbstractMessage mo878v() {
                return MethodDescriptorProto.f20741c;
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo870a(AbstractMessage abstractMessage) {
                return m20853d(abstractMessage);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo871a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m20854d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo863b() {
                return m20857u();
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo846b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m20854d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo848c() {
                return m20857u();
            }

            public final /* synthetic */ Message$Builder mo849c(AbstractMessage abstractMessage) {
                return m20853d(abstractMessage);
            }

            public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo840c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m20854d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ Object clone() {
                return m20857u();
            }

            public final /* synthetic */ com.google.protobuf.GeneratedMessage.Builder mo873f() {
                return m20857u();
            }

            public final /* synthetic */ AbstractMessage mo874h() {
                return m20859y();
            }

            public final /* synthetic */ AbstractMessage mo875i() {
                return m20858x();
            }

            public final /* synthetic */ MessageLite mo876j() {
                return m20859y();
            }

            public final /* synthetic */ MessageLite mo877k() {
                return m20858x();
            }

            protected final FieldAccessorTable mo872d() {
                return DescriptorProtos.f20820r.m21368a(MethodDescriptorProto.class, Builder.class);
            }

            private Builder() {
                m20855m();
            }

            public Builder(BuilderParent builderParent) {
                super(builderParent);
                m20855m();
            }

            private void m20855m() {
                if (GeneratedMessage.f20638b) {
                    if (this.f20739f == null) {
                        this.f20739f = new SingleFieldBuilder(this.f20738e, m20311s(), this.f20619c);
                        this.f20738e = null;
                    }
                    SingleFieldBuilder singleFieldBuilder = this.f20739f;
                }
            }

            public static Builder m20856n() {
                return new Builder();
            }

            private Builder m20857u() {
                return m20856n().m20862a(m20859y());
            }

            public final Descriptor mo841e() {
                return DescriptorProtos.f20819q;
            }

            private MethodDescriptorProto m20858x() {
                AbstractMessage y = m20859y();
                if (y.mo854a()) {
                    return y;
                }
                throw com.google.protobuf.AbstractMessage.Builder.m20123b(y);
            }

            private MethodDescriptorProto m20859y() {
                int i;
                int i2 = 1;
                MethodDescriptorProto methodDescriptorProto = new MethodDescriptorProto(this);
                int i3 = this.f20734a;
                if ((i3 & 1) != 1) {
                    i2 = 0;
                }
                methodDescriptorProto.name_ = this.f20735b;
                if ((i3 & 2) == 2) {
                    i2 |= 2;
                }
                methodDescriptorProto.inputType_ = this.f20736c;
                if ((i3 & 4) == 4) {
                    i2 |= 4;
                }
                methodDescriptorProto.outputType_ = this.f20737d;
                if ((i3 & 8) == 8) {
                    i = i2 | 8;
                } else {
                    i = i2;
                }
                if (this.f20739f == null) {
                    methodDescriptorProto.options_ = this.f20738e;
                } else {
                    methodDescriptorProto.options_ = (MethodOptions) this.f20739f.m21442d();
                }
                methodDescriptorProto.bitField0_ = i;
                m20309p();
                return methodDescriptorProto;
            }

            private Builder m20853d(AbstractMessage abstractMessage) {
                if (abstractMessage instanceof MethodDescriptorProto) {
                    return m20862a((MethodDescriptorProto) abstractMessage);
                }
                super.mo870a(abstractMessage);
                return this;
            }

            private Builder m20854d(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                Throwable th;
                MethodDescriptorProto methodDescriptorProto;
                MethodDescriptorProto methodDescriptorProto2;
                try {
                    methodDescriptorProto2 = (MethodDescriptorProto) MethodDescriptorProto.f20740a.mo859a(codedInputStream, extensionRegistryLite);
                    if (methodDescriptorProto2 != null) {
                        m20862a(methodDescriptorProto2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    InvalidProtocolBufferException invalidProtocolBufferException = e;
                    methodDescriptorProto2 = (MethodDescriptorProto) invalidProtocolBufferException.m21375a();
                    throw invalidProtocolBufferException;
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    methodDescriptorProto = methodDescriptorProto2;
                    th = th3;
                }
                if (methodDescriptorProto != null) {
                    m20862a(methodDescriptorProto);
                }
                throw th;
            }

            public final boolean mo854a() {
                Object obj;
                if ((this.f20734a & 8) == 8) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    AbstractMessage abstractMessage;
                    if (this.f20739f == null) {
                        abstractMessage = this.f20738e;
                    } else {
                        MethodOptions methodOptions = (MethodOptions) this.f20739f.m21441c();
                    }
                    if (!abstractMessage.mo854a()) {
                        return false;
                    }
                }
                return true;
            }
        }

        public final /* synthetic */ Message$Builder mo881s() {
            return m20877d(this);
        }

        public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo883u() {
            return m20877d(this);
        }

        public MethodDescriptorProto(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
            super((byte) 0);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.mo868g();
        }

        private MethodDescriptorProto() {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.f21031a;
        }

        public final AbstractMessage mo878v() {
            return f20741c;
        }

        public final UnknownFieldSet mo868g() {
            return this.unknownFields;
        }

        public MethodDescriptorProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            m20881z();
            com.google.protobuf.UnknownFieldSet.Builder e = com.google.protobuf.UnknownFieldSet.Builder.m21487e();
            Object obj = null;
            while (obj == null) {
                try {
                    int a = codedInputStream.m20202a();
                    switch (a) {
                        case 0:
                            obj = 1;
                            break;
                        case 10:
                            this.bitField0_ |= 1;
                            this.name_ = codedInputStream.m20219k();
                            break;
                        case 18:
                            this.bitField0_ |= 2;
                            this.inputType_ = codedInputStream.m20219k();
                            break;
                        case 26:
                            this.bitField0_ |= 4;
                            this.outputType_ = codedInputStream.m20219k();
                            break;
                        case 34:
                            Builder j;
                            if ((this.bitField0_ & 8) == 8) {
                                j = this.options_.mo891j();
                            } else {
                                j = null;
                            }
                            this.options_ = (MethodOptions) codedInputStream.m20203a(MethodOptions.f20745a, extensionRegistryLite);
                            if (j != null) {
                                j.m20907a(this.options_);
                                this.options_ = j.mo886l();
                            }
                            this.bitField0_ |= 8;
                            break;
                        default:
                            if (!mo889a(codedInputStream, e, extensionRegistryLite, a)) {
                                obj = 1;
                                break;
                            }
                            break;
                    }
                } catch (InvalidProtocolBufferException e2) {
                    throw e2.m21374a(this);
                } catch (IOException e3) {
                    throw new InvalidProtocolBufferException(e3.getMessage()).m21374a(this);
                } catch (Throwable th) {
                    this.unknownFields = e.m21495b();
                    mo888E();
                }
            }
            this.unknownFields = e.m21495b();
            mo888E();
        }

        protected final FieldAccessorTable mo880h() {
            return DescriptorProtos.f20820r.m21368a(MethodDescriptorProto.class, Builder.class);
        }

        static {
            MethodDescriptorProto methodDescriptorProto = new MethodDescriptorProto();
            f20741c = methodDescriptorProto;
            methodDescriptorProto.m20881z();
        }

        public final Parser<MethodDescriptorProto> mo857i() {
            return f20740a;
        }

        public final String m20889k() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String e = byteString.m20186e();
            if (byteString.mo916f()) {
                this.name_ = e;
            }
            return e;
        }

        private ByteString m20878w() {
            Object obj = this.name_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString a = ByteString.m20173a((String) obj);
            this.name_ = a;
            return a;
        }

        public final String m20890m() {
            Object obj = this.inputType_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String e = byteString.m20186e();
            if (byteString.mo916f()) {
                this.inputType_ = e;
            }
            return e;
        }

        private ByteString m20879x() {
            Object obj = this.inputType_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString a = ByteString.m20173a((String) obj);
            this.inputType_ = a;
            return a;
        }

        public final String m20891o() {
            Object obj = this.outputType_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String e = byteString.m20186e();
            if (byteString.mo916f()) {
                this.outputType_ = e;
            }
            return e;
        }

        private ByteString m20880y() {
            Object obj = this.outputType_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString a = ByteString.m20173a((String) obj);
            this.outputType_ = a;
            return a;
        }

        public final boolean m20892p() {
            return (this.bitField0_ & 8) == 8;
        }

        private void m20881z() {
            this.name_ = "";
            this.inputType_ = "";
            this.outputType_ = "";
            this.options_ = MethodOptions.f20746c;
        }

        public final boolean mo854a() {
            byte b = this.memoizedIsInitialized;
            if (b != (byte) -1) {
                if (b == (byte) 1) {
                    return true;
                }
                return false;
            } else if (!m20892p() || this.options_.mo854a()) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            } else {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }

        public final void mo853a(CodedOutputStream codedOutputStream) {
            mo855b();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.m20264a(1, m20878w());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.m20264a(2, m20879x());
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.m20264a(3, m20880y());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.m20273b(4, this.options_);
            }
            mo868g().mo853a(codedOutputStream);
        }

        public final int mo855b() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            i = 0;
            if ((this.bitField0_ & 1) == 1) {
                i = CodedOutputStream.m20236c(1, m20878w()) + 0;
            }
            if ((this.bitField0_ & 2) == 2) {
                i += CodedOutputStream.m20236c(2, m20879x());
            }
            if ((this.bitField0_ & 4) == 4) {
                i += CodedOutputStream.m20236c(3, m20880y());
            }
            if ((this.bitField0_ & 8) == 8) {
                i += CodedOutputStream.m20242e(4, this.options_);
            }
            i += mo868g().mo855b();
            this.memoizedSerializedSize = i;
            return i;
        }

        public final Message$Builder mo882t() {
            return Builder.m20856n();
        }

        private static Builder m20877d(MethodDescriptorProto methodDescriptorProto) {
            return Builder.m20856n().m20862a(methodDescriptorProto);
        }

        protected final Message$Builder mo879a(BuilderParent builderParent) {
            return new Builder(builderParent);
        }
    }

    public interface MethodOptionsOrBuilder extends ExtendableMessageOrBuilder {
    }

    /* compiled from: analytics_source */
    public final class MethodOptions extends ExtendableMessage<MethodOptions> implements MethodOptionsOrBuilder {
        public static Parser<MethodOptions> f20745a = new C24341();
        public static final MethodOptions f20746c;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        public List<UninterpretedOption> uninterpretedOption_;
        private final UnknownFieldSet unknownFields;

        /* compiled from: analytics_source */
        final class C24341 extends AbstractParser<MethodOptions> {
            C24341() {
            }

            public final Object mo859a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return new MethodOptions(codedInputStream, extensionRegistryLite);
            }
        }

        /* compiled from: analytics_source */
        public final class Builder extends ExtendableBuilder<MethodOptions, Builder> implements MethodOptionsOrBuilder {
            public int f20742a;
            public List<UninterpretedOption> f20743b = Collections.emptyList();
            public RepeatedFieldBuilder<UninterpretedOption, Builder, UninterpretedOptionOrBuilder> f20744c;

            public final AbstractMessage mo878v() {
                return MethodOptions.f20746c;
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo870a(AbstractMessage abstractMessage) {
                return m20900d(abstractMessage);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo871a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m20901d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo863b() {
                return m20904y();
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo846b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m20901d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo848c() {
                return m20904y();
            }

            public final /* synthetic */ Message$Builder mo849c(AbstractMessage abstractMessage) {
                return m20900d(abstractMessage);
            }

            public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo840c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m20901d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ Object clone() {
                return m20904y();
            }

            public final /* synthetic */ com.google.protobuf.GeneratedMessage.Builder mo873f() {
                return m20904y();
            }

            public final /* synthetic */ AbstractMessage mo874h() {
                return mo886l();
            }

            public final /* synthetic */ AbstractMessage mo875i() {
                return m20898A();
            }

            public final /* synthetic */ MessageLite mo876j() {
                return mo886l();
            }

            public final /* synthetic */ MessageLite mo877k() {
                return m20898A();
            }

            public final /* synthetic */ ExtendableBuilder mo887m() {
                return m20904y();
            }

            protected final FieldAccessorTable mo872d() {
                return DescriptorProtos.f20793F.m21368a(MethodOptions.class, Builder.class);
            }

            private Builder() {
                m20902w();
            }

            public Builder(BuilderParent builderParent) {
                super(builderParent);
                m20902w();
            }

            private void m20902w() {
                if (GeneratedMessage.f20638b) {
                    m20899D();
                }
            }

            public static Builder m20903x() {
                return new Builder();
            }

            private Builder m20904y() {
                return m20903x().m20907a(mo886l());
            }

            public final Descriptor mo841e() {
                return DescriptorProtos.f20792E;
            }

            private MethodOptions m20898A() {
                AbstractMessage l = mo886l();
                if (l.mo854a()) {
                    return l;
                }
                throw com.google.protobuf.AbstractMessage.Builder.m20123b(l);
            }

            public final MethodOptions mo886l() {
                MethodOptions methodOptions = new MethodOptions(this);
                if (this.f20744c == null) {
                    if ((this.f20742a & 1) == 1) {
                        this.f20743b = Collections.unmodifiableList(this.f20743b);
                        this.f20742a &= -2;
                    }
                    methodOptions.uninterpretedOption_ = this.f20743b;
                } else {
                    methodOptions.uninterpretedOption_ = this.f20744c.m21416f();
                }
                m20309p();
                return methodOptions;
            }

            private Builder m20900d(AbstractMessage abstractMessage) {
                if (abstractMessage instanceof MethodOptions) {
                    return m20907a((MethodOptions) abstractMessage);
                }
                super.mo870a(abstractMessage);
                return this;
            }

            public final Builder m20907a(MethodOptions methodOptions) {
                RepeatedFieldBuilder repeatedFieldBuilder = null;
                if (methodOptions != MethodOptions.f20746c) {
                    if (this.f20744c == null) {
                        if (!methodOptions.uninterpretedOption_.isEmpty()) {
                            if (this.f20743b.isEmpty()) {
                                this.f20743b = methodOptions.uninterpretedOption_;
                                this.f20742a &= -2;
                            } else {
                                if ((this.f20742a & 1) != 1) {
                                    this.f20743b = new ArrayList(this.f20743b);
                                    this.f20742a |= 1;
                                }
                                this.f20743b.addAll(methodOptions.uninterpretedOption_);
                            }
                            m20312t();
                        }
                    } else if (!methodOptions.uninterpretedOption_.isEmpty()) {
                        if (this.f20744c.m21414d()) {
                            this.f20744c.m21411b();
                            this.f20744c = null;
                            this.f20743b = methodOptions.uninterpretedOption_;
                            this.f20742a &= -2;
                            if (GeneratedMessage.f20638b) {
                                repeatedFieldBuilder = m20899D();
                            }
                            this.f20744c = repeatedFieldBuilder;
                        } else {
                            this.f20744c.m21409a(methodOptions.uninterpretedOption_);
                        }
                    }
                    m20467a((ExtendableMessage) methodOptions);
                    m20301c(methodOptions.mo868g());
                }
                return this;
            }

            public final boolean mo854a() {
                int i = 0;
                while (true) {
                    int size;
                    if (this.f20744c == null) {
                        size = this.f20743b.size();
                    } else {
                        size = this.f20744c.m21412c();
                    }
                    if (i >= size) {
                        break;
                    }
                    if (this.f20744c == null) {
                        AbstractMessage abstractMessage = (UninterpretedOption) this.f20743b.get(i);
                    } else {
                        UninterpretedOption uninterpretedOption = (UninterpretedOption) this.f20744c.m21406a(i);
                    }
                    if (!abstractMessage.mo854a()) {
                        return false;
                    }
                    i++;
                }
                if (m20478u()) {
                    return true;
                }
                return false;
            }

            private Builder m20901d(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                Throwable th;
                MethodOptions methodOptions;
                MethodOptions methodOptions2;
                try {
                    methodOptions2 = (MethodOptions) MethodOptions.f20745a.mo859a(codedInputStream, extensionRegistryLite);
                    if (methodOptions2 != null) {
                        m20907a(methodOptions2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    InvalidProtocolBufferException invalidProtocolBufferException = e;
                    methodOptions2 = (MethodOptions) invalidProtocolBufferException.m21375a();
                    throw invalidProtocolBufferException;
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    methodOptions = methodOptions2;
                    th = th3;
                }
                if (methodOptions != null) {
                    m20907a(methodOptions);
                }
                throw th;
            }

            private RepeatedFieldBuilder<UninterpretedOption, Builder, UninterpretedOptionOrBuilder> m20899D() {
                boolean z = true;
                if (this.f20744c == null) {
                    List list = this.f20743b;
                    if ((this.f20742a & 1) != 1) {
                        z = false;
                    }
                    this.f20744c = new RepeatedFieldBuilder(list, z, m20311s(), this.f20619c);
                    this.f20743b = null;
                }
                return this.f20744c;
            }
        }

        public final /* synthetic */ Message$Builder mo881s() {
            return mo891j();
        }

        public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo883u() {
            return mo891j();
        }

        public MethodOptions(ExtendableBuilder<MethodOptions, ?> extendableBuilder) {
            super(extendableBuilder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = extendableBuilder.mo868g();
        }

        private MethodOptions() {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.f21031a;
        }

        public final AbstractMessage mo878v() {
            return f20746c;
        }

        public final UnknownFieldSet mo868g() {
            return this.unknownFields;
        }

        public MethodOptions(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            Throwable th;
            int i = 0;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            m20925m();
            com.google.protobuf.UnknownFieldSet.Builder e = com.google.protobuf.UnknownFieldSet.Builder.m21487e();
            int i2 = 0;
            while (i2 == 0) {
                try {
                    int a = codedInputStream.m20202a();
                    switch (a) {
                        case 0:
                            i2 = 1;
                            break;
                        case 7994:
                            if ((i & 1) != 1) {
                                this.uninterpretedOption_ = new ArrayList();
                                i |= 1;
                            }
                            this.uninterpretedOption_.add(codedInputStream.m20203a(UninterpretedOption.f20786a, extensionRegistryLite));
                            break;
                        default:
                            if (!mo889a(codedInputStream, e, extensionRegistryLite, a)) {
                                i2 = 1;
                                break;
                            }
                            break;
                    }
                } catch (InvalidProtocolBufferException e2) {
                    InvalidProtocolBufferException invalidProtocolBufferException = e2;
                    i2 = i;
                    throw invalidProtocolBufferException.m21374a(this);
                } catch (IOException e3) {
                    IOException iOException = e3;
                    i2 = i;
                    throw new InvalidProtocolBufferException(iOException.getMessage()).m21374a(this);
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if ((i & 1) == 1) {
                this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
            }
            this.unknownFields = e.m21495b();
            mo888E();
            return;
            if ((i2 & 1) == 1) {
                this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
            }
            this.unknownFields = e.m21495b();
            mo888E();
            throw th;
        }

        protected final FieldAccessorTable mo880h() {
            return DescriptorProtos.f20793F.m21368a(MethodOptions.class, Builder.class);
        }

        static {
            MethodOptions methodOptions = new MethodOptions();
            f20746c = methodOptions;
            methodOptions.m20925m();
        }

        public final Parser<MethodOptions> mo857i() {
            return f20745a;
        }

        private void m20925m() {
            this.uninterpretedOption_ = Collections.emptyList();
        }

        public final boolean mo854a() {
            byte b = this.memoizedIsInitialized;
            if (b == (byte) -1) {
                int i = 0;
                while (i < this.uninterpretedOption_.size()) {
                    if (((UninterpretedOption) this.uninterpretedOption_.get(i)).mo854a()) {
                        i++;
                    } else {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                if (m20507F()) {
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                }
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (b == (byte) 1) {
                return true;
            } else {
                return false;
            }
        }

        public final void mo853a(CodedOutputStream codedOutputStream) {
            mo855b();
            ExtensionWriter G = m20508G();
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                codedOutputStream.m20273b(999, (MessageLite) this.uninterpretedOption_.get(i));
            }
            G.m21338a(536870912, codedOutputStream);
            mo868g().mo853a(codedOutputStream);
        }

        public final int mo855b() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (i = 0; i < this.uninterpretedOption_.size(); i++) {
                i2 += CodedOutputStream.m20242e(999, (MessageLite) this.uninterpretedOption_.get(i));
            }
            int H = (m20509H() + i2) + mo868g().mo855b();
            this.memoizedSerializedSize = H;
            return H;
        }

        protected final Object writeReplace() {
            return super.writeReplace();
        }

        public final Message$Builder mo882t() {
            return Builder.m20903x();
        }

        public static Builder m20924a(MethodOptions methodOptions) {
            return Builder.m20903x().m20907a(methodOptions);
        }

        public final Builder mo891j() {
            return m20924a(this);
        }

        protected final Message$Builder mo879a(BuilderParent builderParent) {
            return new Builder(builderParent);
        }
    }

    public interface ServiceDescriptorProtoOrBuilder extends MessageOrBuilder {
    }

    /* compiled from: analytics_source */
    public final class ServiceDescriptorProto extends GeneratedMessage implements ServiceDescriptorProtoOrBuilder {
        public static Parser<ServiceDescriptorProto> f20753a = new C24351();
        public static final ServiceDescriptorProto f20754c;
        public int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        public List<MethodDescriptorProto> method_;
        public Object name_;
        public ServiceOptions options_;
        private final UnknownFieldSet unknownFields;

        /* compiled from: analytics_source */
        final class C24351 extends AbstractParser<ServiceDescriptorProto> {
            C24351() {
            }

            public final Object mo859a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return new ServiceDescriptorProto(codedInputStream, extensionRegistryLite);
            }
        }

        /* compiled from: analytics_source */
        public final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> implements ServiceDescriptorProtoOrBuilder {
            public int f20747a;
            private Object f20748b = "";
            public List<MethodDescriptorProto> f20749c = Collections.emptyList();
            public RepeatedFieldBuilder<MethodDescriptorProto, Builder, MethodDescriptorProtoOrBuilder> f20750d;
            public ServiceOptions f20751e = ServiceOptions.f20759c;
            public SingleFieldBuilder<ServiceOptions, Builder, ServiceOptionsOrBuilder> f20752f;

            public final AbstractMessage mo878v() {
                return ServiceDescriptorProto.f20754c;
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo870a(AbstractMessage abstractMessage) {
                return m20940d(abstractMessage);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo871a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m20941d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo863b() {
                return m20944u();
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo846b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m20941d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo848c() {
                return m20944u();
            }

            public final /* synthetic */ Message$Builder mo849c(AbstractMessage abstractMessage) {
                return m20940d(abstractMessage);
            }

            public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo840c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m20941d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ Object clone() {
                return m20944u();
            }

            public final /* synthetic */ com.google.protobuf.GeneratedMessage.Builder mo873f() {
                return m20944u();
            }

            public final /* synthetic */ AbstractMessage mo874h() {
                return m20946y();
            }

            public final /* synthetic */ AbstractMessage mo875i() {
                return m20945x();
            }

            public final /* synthetic */ MessageLite mo876j() {
                return m20946y();
            }

            public final /* synthetic */ MessageLite mo877k() {
                return m20945x();
            }

            protected final FieldAccessorTable mo872d() {
                return DescriptorProtos.f20818p.m21368a(ServiceDescriptorProto.class, Builder.class);
            }

            private Builder() {
                m20942m();
            }

            public Builder(BuilderParent builderParent) {
                super(builderParent);
                m20942m();
            }

            private void m20942m() {
                if (GeneratedMessage.f20638b) {
                    m20939B();
                    if (this.f20752f == null) {
                        this.f20752f = new SingleFieldBuilder(this.f20751e, m20311s(), this.f20619c);
                        this.f20751e = null;
                    }
                    SingleFieldBuilder singleFieldBuilder = this.f20752f;
                }
            }

            public static Builder m20943n() {
                return new Builder();
            }

            private Builder m20944u() {
                return m20943n().m20949a(m20946y());
            }

            public final Descriptor mo841e() {
                return DescriptorProtos.f20817o;
            }

            private ServiceDescriptorProto m20945x() {
                AbstractMessage y = m20946y();
                if (y.mo854a()) {
                    return y;
                }
                throw com.google.protobuf.AbstractMessage.Builder.m20123b(y);
            }

            private ServiceDescriptorProto m20946y() {
                int i;
                int i2 = 1;
                ServiceDescriptorProto serviceDescriptorProto = new ServiceDescriptorProto(this);
                int i3 = this.f20747a;
                if ((i3 & 1) != 1) {
                    i2 = 0;
                }
                serviceDescriptorProto.name_ = this.f20748b;
                if (this.f20750d == null) {
                    if ((this.f20747a & 2) == 2) {
                        this.f20749c = Collections.unmodifiableList(this.f20749c);
                        this.f20747a &= -3;
                    }
                    serviceDescriptorProto.method_ = this.f20749c;
                } else {
                    serviceDescriptorProto.method_ = this.f20750d.m21416f();
                }
                if ((i3 & 4) == 4) {
                    i = i2 | 2;
                } else {
                    i = i2;
                }
                if (this.f20752f == null) {
                    serviceDescriptorProto.options_ = this.f20751e;
                } else {
                    serviceDescriptorProto.options_ = (ServiceOptions) this.f20752f.m21442d();
                }
                serviceDescriptorProto.bitField0_ = i;
                m20309p();
                return serviceDescriptorProto;
            }

            private Builder m20940d(AbstractMessage abstractMessage) {
                if (abstractMessage instanceof ServiceDescriptorProto) {
                    return m20949a((ServiceDescriptorProto) abstractMessage);
                }
                super.mo870a(abstractMessage);
                return this;
            }

            public final Builder m20949a(ServiceDescriptorProto serviceDescriptorProto) {
                RepeatedFieldBuilder repeatedFieldBuilder = null;
                if (serviceDescriptorProto != ServiceDescriptorProto.f20754c) {
                    Object obj = 1;
                    if ((serviceDescriptorProto.bitField0_ & 1) != 1) {
                        obj = null;
                    }
                    if (obj != null) {
                        this.f20747a |= 1;
                        this.f20748b = serviceDescriptorProto.name_;
                        m20312t();
                    }
                    if (this.f20750d == null) {
                        if (!serviceDescriptorProto.method_.isEmpty()) {
                            if (this.f20749c.isEmpty()) {
                                this.f20749c = serviceDescriptorProto.method_;
                                this.f20747a &= -3;
                            } else {
                                if ((this.f20747a & 2) != 2) {
                                    this.f20749c = new ArrayList(this.f20749c);
                                    this.f20747a |= 2;
                                }
                                this.f20749c.addAll(serviceDescriptorProto.method_);
                            }
                            m20312t();
                        }
                    } else if (!serviceDescriptorProto.method_.isEmpty()) {
                        if (this.f20750d.m21414d()) {
                            this.f20750d.m21411b();
                            this.f20750d = null;
                            this.f20749c = serviceDescriptorProto.method_;
                            this.f20747a &= -3;
                            if (GeneratedMessage.f20638b) {
                                repeatedFieldBuilder = m20939B();
                            }
                            this.f20750d = repeatedFieldBuilder;
                        } else {
                            this.f20750d.m21409a(serviceDescriptorProto.method_);
                        }
                    }
                    if (serviceDescriptorProto.m20977m()) {
                        ServiceOptions serviceOptions = serviceDescriptorProto.options_;
                        if (this.f20752f == null) {
                            if ((this.f20747a & 4) != 4 || this.f20751e == ServiceOptions.f20759c) {
                                this.f20751e = serviceOptions;
                            } else {
                                this.f20751e = ServiceOptions.m21009a(this.f20751e).m20992a(serviceOptions).mo886l();
                            }
                            m20312t();
                        } else {
                            this.f20752f.m21439b(serviceOptions);
                        }
                        this.f20747a |= 4;
                    }
                    m20301c(serviceDescriptorProto.mo868g());
                }
                return this;
            }

            public final boolean mo854a() {
                Object obj;
                int i = 0;
                while (true) {
                    int size;
                    if (this.f20750d == null) {
                        size = this.f20749c.size();
                    } else {
                        size = this.f20750d.m21412c();
                    }
                    if (i >= size) {
                        break;
                    }
                    if (this.f20750d == null) {
                        AbstractMessage abstractMessage = (MethodDescriptorProto) this.f20749c.get(i);
                    } else {
                        MethodDescriptorProto methodDescriptorProto = (MethodDescriptorProto) this.f20750d.m21406a(i);
                    }
                    if (!abstractMessage.mo854a()) {
                        return false;
                    }
                    i++;
                }
                if ((this.f20747a & 4) == 4) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    if (this.f20752f == null) {
                        abstractMessage = this.f20751e;
                    } else {
                        ServiceOptions serviceOptions = (ServiceOptions) this.f20752f.m21441c();
                    }
                    if (!abstractMessage.mo854a()) {
                        return false;
                    }
                }
                return true;
            }

            private Builder m20941d(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                Throwable th;
                ServiceDescriptorProto serviceDescriptorProto;
                ServiceDescriptorProto serviceDescriptorProto2;
                try {
                    serviceDescriptorProto2 = (ServiceDescriptorProto) ServiceDescriptorProto.f20753a.mo859a(codedInputStream, extensionRegistryLite);
                    if (serviceDescriptorProto2 != null) {
                        m20949a(serviceDescriptorProto2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    InvalidProtocolBufferException invalidProtocolBufferException = e;
                    serviceDescriptorProto2 = (ServiceDescriptorProto) invalidProtocolBufferException.m21375a();
                    throw invalidProtocolBufferException;
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    serviceDescriptorProto = serviceDescriptorProto2;
                    th = th3;
                }
                if (serviceDescriptorProto != null) {
                    m20949a(serviceDescriptorProto);
                }
                throw th;
            }

            private RepeatedFieldBuilder<MethodDescriptorProto, Builder, MethodDescriptorProtoOrBuilder> m20939B() {
                if (this.f20750d == null) {
                    this.f20750d = new RepeatedFieldBuilder(this.f20749c, (this.f20747a & 2) == 2, m20311s(), this.f20619c);
                    this.f20749c = null;
                }
                return this.f20750d;
            }
        }

        public final /* synthetic */ Message$Builder mo881s() {
            return m20964c(this);
        }

        public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo883u() {
            return m20964c(this);
        }

        public ServiceDescriptorProto(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
            super((byte) 0);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.mo868g();
        }

        private ServiceDescriptorProto() {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.f21031a;
        }

        public final AbstractMessage mo878v() {
            return f20754c;
        }

        public final UnknownFieldSet mo868g() {
            return this.unknownFields;
        }

        public ServiceDescriptorProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            m20966q();
            com.google.protobuf.UnknownFieldSet.Builder e = com.google.protobuf.UnknownFieldSet.Builder.m21487e();
            Object obj = null;
            int i = 0;
            while (obj == null) {
                try {
                    int a = codedInputStream.m20202a();
                    switch (a) {
                        case 0:
                            obj = 1;
                            break;
                        case 10:
                            this.bitField0_ |= 1;
                            this.name_ = codedInputStream.m20219k();
                            break;
                        case 18:
                            if ((i & 2) != 2) {
                                this.method_ = new ArrayList();
                                i |= 2;
                            }
                            this.method_.add(codedInputStream.m20203a(MethodDescriptorProto.f20740a, extensionRegistryLite));
                            break;
                        case 26:
                            Builder j;
                            if ((this.bitField0_ & 2) == 2) {
                                j = this.options_.mo891j();
                            } else {
                                j = null;
                            }
                            this.options_ = (ServiceOptions) codedInputStream.m20203a(ServiceOptions.f20758a, extensionRegistryLite);
                            if (j != null) {
                                j.m20992a(this.options_);
                                this.options_ = j.mo886l();
                            }
                            this.bitField0_ |= 2;
                            break;
                        default:
                            if (!mo889a(codedInputStream, e, extensionRegistryLite, a)) {
                                obj = 1;
                                break;
                            }
                            break;
                    }
                } catch (InvalidProtocolBufferException e2) {
                    throw e2.m21374a(this);
                } catch (IOException e3) {
                    throw new InvalidProtocolBufferException(e3.getMessage()).m21374a(this);
                } catch (Throwable th) {
                    if ((i & 2) == 2) {
                        this.method_ = Collections.unmodifiableList(this.method_);
                    }
                    this.unknownFields = e.m21495b();
                    mo888E();
                }
            }
            if ((i & 2) == 2) {
                this.method_ = Collections.unmodifiableList(this.method_);
            }
            this.unknownFields = e.m21495b();
            mo888E();
        }

        protected final FieldAccessorTable mo880h() {
            return DescriptorProtos.f20818p.m21368a(ServiceDescriptorProto.class, Builder.class);
        }

        static {
            ServiceDescriptorProto serviceDescriptorProto = new ServiceDescriptorProto();
            f20754c = serviceDescriptorProto;
            serviceDescriptorProto.m20966q();
        }

        public final Parser<ServiceDescriptorProto> mo857i() {
            return f20753a;
        }

        public final String m20975k() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String e = byteString.m20186e();
            if (byteString.mo916f()) {
                this.name_ = e;
            }
            return e;
        }

        private ByteString m20965p() {
            Object obj = this.name_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString a = ByteString.m20173a((String) obj);
            this.name_ = a;
            return a;
        }

        public final int m20976l() {
            return this.method_.size();
        }

        public final MethodDescriptorProto m20967a(int i) {
            return (MethodDescriptorProto) this.method_.get(i);
        }

        public final boolean m20977m() {
            return (this.bitField0_ & 2) == 2;
        }

        private void m20966q() {
            this.name_ = "";
            this.method_ = Collections.emptyList();
            this.options_ = ServiceOptions.f20759c;
        }

        public final boolean mo854a() {
            byte b = this.memoizedIsInitialized;
            if (b == (byte) -1) {
                int i = 0;
                while (i < m20976l()) {
                    if (m20967a(i).mo854a()) {
                        i++;
                    } else {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                if (!m20977m() || this.options_.mo854a()) {
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                }
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (b == (byte) 1) {
                return true;
            } else {
                return false;
            }
        }

        public final void mo853a(CodedOutputStream codedOutputStream) {
            mo855b();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.m20264a(1, m20965p());
            }
            for (int i = 0; i < this.method_.size(); i++) {
                codedOutputStream.m20273b(2, (MessageLite) this.method_.get(i));
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.m20273b(3, this.options_);
            }
            mo868g().mo853a(codedOutputStream);
        }

        public final int mo855b() {
            int i = 0;
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            if ((this.bitField0_ & 1) == 1) {
                i2 = CodedOutputStream.m20236c(1, m20965p()) + 0;
            } else {
                i2 = 0;
            }
            int i3 = i2;
            while (i < this.method_.size()) {
                i++;
                i3 = CodedOutputStream.m20242e(2, (MessageLite) this.method_.get(i)) + i3;
            }
            if ((this.bitField0_ & 2) == 2) {
                i3 += CodedOutputStream.m20242e(3, this.options_);
            }
            i2 = mo868g().mo855b() + i3;
            this.memoizedSerializedSize = i2;
            return i2;
        }

        public final Message$Builder mo882t() {
            return Builder.m20943n();
        }

        private static Builder m20964c(ServiceDescriptorProto serviceDescriptorProto) {
            return Builder.m20943n().m20949a(serviceDescriptorProto);
        }

        protected final Message$Builder mo879a(BuilderParent builderParent) {
            return new Builder(builderParent);
        }
    }

    public interface ServiceOptionsOrBuilder extends ExtendableMessageOrBuilder {
    }

    /* compiled from: analytics_source */
    public final class ServiceOptions extends ExtendableMessage<ServiceOptions> implements ServiceOptionsOrBuilder {
        public static Parser<ServiceOptions> f20758a = new C24361();
        public static final ServiceOptions f20759c;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        public List<UninterpretedOption> uninterpretedOption_;
        private final UnknownFieldSet unknownFields;

        /* compiled from: analytics_source */
        final class C24361 extends AbstractParser<ServiceOptions> {
            C24361() {
            }

            public final Object mo859a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return new ServiceOptions(codedInputStream, extensionRegistryLite);
            }
        }

        /* compiled from: analytics_source */
        public final class Builder extends ExtendableBuilder<ServiceOptions, Builder> implements ServiceOptionsOrBuilder {
            public int f20755a;
            public List<UninterpretedOption> f20756b = Collections.emptyList();
            public RepeatedFieldBuilder<UninterpretedOption, Builder, UninterpretedOptionOrBuilder> f20757c;

            public final AbstractMessage mo878v() {
                return ServiceOptions.f20759c;
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo870a(AbstractMessage abstractMessage) {
                return m20985d(abstractMessage);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo871a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m20986d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo863b() {
                return m20989y();
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo846b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m20986d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo848c() {
                return m20989y();
            }

            public final /* synthetic */ Message$Builder mo849c(AbstractMessage abstractMessage) {
                return m20985d(abstractMessage);
            }

            public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo840c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m20986d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ Object clone() {
                return m20989y();
            }

            public final /* synthetic */ com.google.protobuf.GeneratedMessage.Builder mo873f() {
                return m20989y();
            }

            public final /* synthetic */ AbstractMessage mo874h() {
                return mo886l();
            }

            public final /* synthetic */ AbstractMessage mo875i() {
                return m20983A();
            }

            public final /* synthetic */ MessageLite mo876j() {
                return mo886l();
            }

            public final /* synthetic */ MessageLite mo877k() {
                return m20983A();
            }

            public final /* synthetic */ ExtendableBuilder mo887m() {
                return m20989y();
            }

            protected final FieldAccessorTable mo872d() {
                return DescriptorProtos.f20791D.m21368a(ServiceOptions.class, Builder.class);
            }

            private Builder() {
                m20987w();
            }

            public Builder(BuilderParent builderParent) {
                super(builderParent);
                m20987w();
            }

            private void m20987w() {
                if (GeneratedMessage.f20638b) {
                    m20984D();
                }
            }

            public static Builder m20988x() {
                return new Builder();
            }

            private Builder m20989y() {
                return m20988x().m20992a(mo886l());
            }

            public final Descriptor mo841e() {
                return DescriptorProtos.f20790C;
            }

            private ServiceOptions m20983A() {
                AbstractMessage l = mo886l();
                if (l.mo854a()) {
                    return l;
                }
                throw com.google.protobuf.AbstractMessage.Builder.m20123b(l);
            }

            public final ServiceOptions mo886l() {
                ServiceOptions serviceOptions = new ServiceOptions(this);
                if (this.f20757c == null) {
                    if ((this.f20755a & 1) == 1) {
                        this.f20756b = Collections.unmodifiableList(this.f20756b);
                        this.f20755a &= -2;
                    }
                    serviceOptions.uninterpretedOption_ = this.f20756b;
                } else {
                    serviceOptions.uninterpretedOption_ = this.f20757c.m21416f();
                }
                m20309p();
                return serviceOptions;
            }

            private Builder m20985d(AbstractMessage abstractMessage) {
                if (abstractMessage instanceof ServiceOptions) {
                    return m20992a((ServiceOptions) abstractMessage);
                }
                super.mo870a(abstractMessage);
                return this;
            }

            public final Builder m20992a(ServiceOptions serviceOptions) {
                RepeatedFieldBuilder repeatedFieldBuilder = null;
                if (serviceOptions != ServiceOptions.f20759c) {
                    if (this.f20757c == null) {
                        if (!serviceOptions.uninterpretedOption_.isEmpty()) {
                            if (this.f20756b.isEmpty()) {
                                this.f20756b = serviceOptions.uninterpretedOption_;
                                this.f20755a &= -2;
                            } else {
                                if ((this.f20755a & 1) != 1) {
                                    this.f20756b = new ArrayList(this.f20756b);
                                    this.f20755a |= 1;
                                }
                                this.f20756b.addAll(serviceOptions.uninterpretedOption_);
                            }
                            m20312t();
                        }
                    } else if (!serviceOptions.uninterpretedOption_.isEmpty()) {
                        if (this.f20757c.m21414d()) {
                            this.f20757c.m21411b();
                            this.f20757c = null;
                            this.f20756b = serviceOptions.uninterpretedOption_;
                            this.f20755a &= -2;
                            if (GeneratedMessage.f20638b) {
                                repeatedFieldBuilder = m20984D();
                            }
                            this.f20757c = repeatedFieldBuilder;
                        } else {
                            this.f20757c.m21409a(serviceOptions.uninterpretedOption_);
                        }
                    }
                    m20467a((ExtendableMessage) serviceOptions);
                    m20301c(serviceOptions.mo868g());
                }
                return this;
            }

            public final boolean mo854a() {
                int i = 0;
                while (true) {
                    int size;
                    if (this.f20757c == null) {
                        size = this.f20756b.size();
                    } else {
                        size = this.f20757c.m21412c();
                    }
                    if (i >= size) {
                        break;
                    }
                    if (this.f20757c == null) {
                        AbstractMessage abstractMessage = (UninterpretedOption) this.f20756b.get(i);
                    } else {
                        UninterpretedOption uninterpretedOption = (UninterpretedOption) this.f20757c.m21406a(i);
                    }
                    if (!abstractMessage.mo854a()) {
                        return false;
                    }
                    i++;
                }
                if (m20478u()) {
                    return true;
                }
                return false;
            }

            private Builder m20986d(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                Throwable th;
                ServiceOptions serviceOptions;
                ServiceOptions serviceOptions2;
                try {
                    serviceOptions2 = (ServiceOptions) ServiceOptions.f20758a.mo859a(codedInputStream, extensionRegistryLite);
                    if (serviceOptions2 != null) {
                        m20992a(serviceOptions2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    InvalidProtocolBufferException invalidProtocolBufferException = e;
                    serviceOptions2 = (ServiceOptions) invalidProtocolBufferException.m21375a();
                    throw invalidProtocolBufferException;
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    serviceOptions = serviceOptions2;
                    th = th3;
                }
                if (serviceOptions != null) {
                    m20992a(serviceOptions);
                }
                throw th;
            }

            private RepeatedFieldBuilder<UninterpretedOption, Builder, UninterpretedOptionOrBuilder> m20984D() {
                boolean z = true;
                if (this.f20757c == null) {
                    List list = this.f20756b;
                    if ((this.f20755a & 1) != 1) {
                        z = false;
                    }
                    this.f20757c = new RepeatedFieldBuilder(list, z, m20311s(), this.f20619c);
                    this.f20756b = null;
                }
                return this.f20757c;
            }
        }

        public final /* synthetic */ Message$Builder mo881s() {
            return mo891j();
        }

        public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo883u() {
            return mo891j();
        }

        public ServiceOptions(ExtendableBuilder<ServiceOptions, ?> extendableBuilder) {
            super(extendableBuilder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = extendableBuilder.mo868g();
        }

        private ServiceOptions() {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.f21031a;
        }

        public final AbstractMessage mo878v() {
            return f20759c;
        }

        public final UnknownFieldSet mo868g() {
            return this.unknownFields;
        }

        public ServiceOptions(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            Throwable th;
            int i = 0;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            m21010m();
            com.google.protobuf.UnknownFieldSet.Builder e = com.google.protobuf.UnknownFieldSet.Builder.m21487e();
            int i2 = 0;
            while (i2 == 0) {
                try {
                    int a = codedInputStream.m20202a();
                    switch (a) {
                        case 0:
                            i2 = 1;
                            break;
                        case 7994:
                            if ((i & 1) != 1) {
                                this.uninterpretedOption_ = new ArrayList();
                                i |= 1;
                            }
                            this.uninterpretedOption_.add(codedInputStream.m20203a(UninterpretedOption.f20786a, extensionRegistryLite));
                            break;
                        default:
                            if (!mo889a(codedInputStream, e, extensionRegistryLite, a)) {
                                i2 = 1;
                                break;
                            }
                            break;
                    }
                } catch (InvalidProtocolBufferException e2) {
                    InvalidProtocolBufferException invalidProtocolBufferException = e2;
                    i2 = i;
                    throw invalidProtocolBufferException.m21374a(this);
                } catch (IOException e3) {
                    IOException iOException = e3;
                    i2 = i;
                    throw new InvalidProtocolBufferException(iOException.getMessage()).m21374a(this);
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if ((i & 1) == 1) {
                this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
            }
            this.unknownFields = e.m21495b();
            mo888E();
            return;
            if ((i2 & 1) == 1) {
                this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
            }
            this.unknownFields = e.m21495b();
            mo888E();
            throw th;
        }

        protected final FieldAccessorTable mo880h() {
            return DescriptorProtos.f20791D.m21368a(ServiceOptions.class, Builder.class);
        }

        static {
            ServiceOptions serviceOptions = new ServiceOptions();
            f20759c = serviceOptions;
            serviceOptions.m21010m();
        }

        public final Parser<ServiceOptions> mo857i() {
            return f20758a;
        }

        private void m21010m() {
            this.uninterpretedOption_ = Collections.emptyList();
        }

        public final boolean mo854a() {
            byte b = this.memoizedIsInitialized;
            if (b == (byte) -1) {
                int i = 0;
                while (i < this.uninterpretedOption_.size()) {
                    if (((UninterpretedOption) this.uninterpretedOption_.get(i)).mo854a()) {
                        i++;
                    } else {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                if (m20507F()) {
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                }
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (b == (byte) 1) {
                return true;
            } else {
                return false;
            }
        }

        public final void mo853a(CodedOutputStream codedOutputStream) {
            mo855b();
            ExtensionWriter G = m20508G();
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                codedOutputStream.m20273b(999, (MessageLite) this.uninterpretedOption_.get(i));
            }
            G.m21338a(536870912, codedOutputStream);
            mo868g().mo853a(codedOutputStream);
        }

        public final int mo855b() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (i = 0; i < this.uninterpretedOption_.size(); i++) {
                i2 += CodedOutputStream.m20242e(999, (MessageLite) this.uninterpretedOption_.get(i));
            }
            int H = (m20509H() + i2) + mo868g().mo855b();
            this.memoizedSerializedSize = H;
            return H;
        }

        protected final Object writeReplace() {
            return super.writeReplace();
        }

        public final Message$Builder mo882t() {
            return Builder.m20988x();
        }

        public static Builder m21009a(ServiceOptions serviceOptions) {
            return Builder.m20988x().m20992a(serviceOptions);
        }

        public final Builder mo891j() {
            return m21009a(this);
        }

        protected final Message$Builder mo879a(BuilderParent builderParent) {
            return new Builder(builderParent);
        }
    }

    public interface SourceCodeInfoOrBuilder extends MessageOrBuilder {
    }

    /* compiled from: analytics_source */
    public final class SourceCodeInfo extends GeneratedMessage implements SourceCodeInfoOrBuilder {
        public static Parser<SourceCodeInfo> f20770a = new C24371();
        public static final SourceCodeInfo f20771c;
        public List<Location> location_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private final UnknownFieldSet unknownFields;

        /* compiled from: analytics_source */
        final class C24371 extends AbstractParser<SourceCodeInfo> {
            C24371() {
            }

            public final Object mo859a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return new SourceCodeInfo(codedInputStream, extensionRegistryLite);
            }
        }

        /* compiled from: analytics_source */
        public final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> implements SourceCodeInfoOrBuilder {
            public int f20760a;
            public List<Location> f20761b = Collections.emptyList();
            private RepeatedFieldBuilder<Location, Builder, LocationOrBuilder> f20762c;

            public final AbstractMessage mo878v() {
                return SourceCodeInfo.f20771c;
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo870a(AbstractMessage abstractMessage) {
                return m21025d(abstractMessage);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo871a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m21026d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo863b() {
                return m21029w();
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo846b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m21026d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo848c() {
                return m21029w();
            }

            public final /* synthetic */ Message$Builder mo849c(AbstractMessage abstractMessage) {
                return m21025d(abstractMessage);
            }

            public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo840c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m21026d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ Object clone() {
                return m21029w();
            }

            public final /* synthetic */ com.google.protobuf.GeneratedMessage.Builder mo873f() {
                return m21029w();
            }

            public final /* synthetic */ AbstractMessage mo874h() {
                return m21047l();
            }

            public final /* synthetic */ AbstractMessage mo875i() {
                return m21030y();
            }

            public final /* synthetic */ MessageLite mo876j() {
                return m21047l();
            }

            public final /* synthetic */ MessageLite mo877k() {
                return m21030y();
            }

            protected final FieldAccessorTable mo872d() {
                return DescriptorProtos.f20799L.m21368a(SourceCodeInfo.class, Builder.class);
            }

            private Builder() {
                m21027n();
            }

            public Builder(BuilderParent builderParent) {
                super(builderParent);
                m21027n();
            }

            private void m21027n() {
                if (GeneratedMessage.f20638b) {
                    m21024A();
                }
            }

            public static Builder m21028u() {
                return new Builder();
            }

            private Builder m21029w() {
                return m21028u().m21033a(m21047l());
            }

            public final Descriptor mo841e() {
                return DescriptorProtos.f20798K;
            }

            private SourceCodeInfo m21030y() {
                AbstractMessage l = m21047l();
                if (l.mo854a()) {
                    return l;
                }
                throw com.google.protobuf.AbstractMessage.Builder.m20123b(l);
            }

            public final SourceCodeInfo m21047l() {
                SourceCodeInfo sourceCodeInfo = new SourceCodeInfo(this);
                if (this.f20762c == null) {
                    if ((this.f20760a & 1) == 1) {
                        this.f20761b = Collections.unmodifiableList(this.f20761b);
                        this.f20760a &= -2;
                    }
                    sourceCodeInfo.location_ = this.f20761b;
                } else {
                    sourceCodeInfo.location_ = this.f20762c.m21416f();
                }
                m20309p();
                return sourceCodeInfo;
            }

            private Builder m21025d(AbstractMessage abstractMessage) {
                if (abstractMessage instanceof SourceCodeInfo) {
                    return m21033a((SourceCodeInfo) abstractMessage);
                }
                super.mo870a(abstractMessage);
                return this;
            }

            public final Builder m21033a(SourceCodeInfo sourceCodeInfo) {
                RepeatedFieldBuilder repeatedFieldBuilder = null;
                if (sourceCodeInfo != SourceCodeInfo.f20771c) {
                    if (this.f20762c == null) {
                        if (!sourceCodeInfo.location_.isEmpty()) {
                            if (this.f20761b.isEmpty()) {
                                this.f20761b = sourceCodeInfo.location_;
                                this.f20760a &= -2;
                            } else {
                                if ((this.f20760a & 1) != 1) {
                                    this.f20761b = new ArrayList(this.f20761b);
                                    this.f20760a |= 1;
                                }
                                this.f20761b.addAll(sourceCodeInfo.location_);
                            }
                            m20312t();
                        }
                    } else if (!sourceCodeInfo.location_.isEmpty()) {
                        if (this.f20762c.m21414d()) {
                            this.f20762c.m21411b();
                            this.f20762c = null;
                            this.f20761b = sourceCodeInfo.location_;
                            this.f20760a &= -2;
                            if (GeneratedMessage.f20638b) {
                                repeatedFieldBuilder = m21024A();
                            }
                            this.f20762c = repeatedFieldBuilder;
                        } else {
                            this.f20762c.m21409a(sourceCodeInfo.location_);
                        }
                    }
                    m20301c(sourceCodeInfo.mo868g());
                }
                return this;
            }

            public final boolean mo854a() {
                return true;
            }

            private Builder m21026d(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                Throwable th;
                SourceCodeInfo sourceCodeInfo;
                SourceCodeInfo sourceCodeInfo2;
                try {
                    sourceCodeInfo2 = (SourceCodeInfo) SourceCodeInfo.f20770a.mo859a(codedInputStream, extensionRegistryLite);
                    if (sourceCodeInfo2 != null) {
                        m21033a(sourceCodeInfo2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    InvalidProtocolBufferException invalidProtocolBufferException = e;
                    sourceCodeInfo2 = (SourceCodeInfo) invalidProtocolBufferException.m21375a();
                    throw invalidProtocolBufferException;
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    sourceCodeInfo = sourceCodeInfo2;
                    th = th3;
                }
                if (sourceCodeInfo != null) {
                    m21033a(sourceCodeInfo);
                }
                throw th;
            }

            private RepeatedFieldBuilder<Location, Builder, LocationOrBuilder> m21024A() {
                boolean z = true;
                if (this.f20762c == null) {
                    List list = this.f20761b;
                    if ((this.f20760a & 1) != 1) {
                        z = false;
                    }
                    this.f20762c = new RepeatedFieldBuilder(list, z, m20311s(), this.f20619c);
                    this.f20761b = null;
                }
                return this.f20762c;
            }
        }

        public interface LocationOrBuilder extends MessageOrBuilder {
        }

        /* compiled from: analytics_source */
        public final class Location extends GeneratedMessage implements LocationOrBuilder {
            public static Parser<Location> f20768a = new C24381();
            public static final Location f20769c;
            public int bitField0_;
            public Object leadingComments_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            private int pathMemoizedSerializedSize;
            public List<Integer> path_;
            private int spanMemoizedSerializedSize;
            public List<Integer> span_;
            public Object trailingComments_;
            private final UnknownFieldSet unknownFields;

            /* compiled from: analytics_source */
            final class C24381 extends AbstractParser<Location> {
                C24381() {
                }

                public final Object mo859a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                    return new Location(codedInputStream, extensionRegistryLite);
                }
            }

            /* compiled from: analytics_source */
            public final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> implements LocationOrBuilder {
                public int f20763a;
                public List<Integer> f20764b = Collections.emptyList();
                public List<Integer> f20765c = Collections.emptyList();
                private Object f20766d = "";
                private Object f20767e = "";

                public final Builder m21058a(Location location) {
                    if (location != Location.f20769c) {
                        if (!location.path_.isEmpty()) {
                            if (this.f20764b.isEmpty()) {
                                this.f20764b = location.path_;
                                this.f20763a &= -2;
                            } else {
                                if ((this.f20763a & 1) != 1) {
                                    this.f20764b = new ArrayList(this.f20764b);
                                    this.f20763a |= 1;
                                }
                                this.f20764b.addAll(location.path_);
                            }
                            m20312t();
                        }
                        if (!location.span_.isEmpty()) {
                            if (this.f20765c.isEmpty()) {
                                this.f20765c = location.span_;
                                this.f20763a &= -3;
                            } else {
                                if ((this.f20763a & 2) != 2) {
                                    this.f20765c = new ArrayList(this.f20765c);
                                    this.f20763a |= 2;
                                }
                                this.f20765c.addAll(location.span_);
                            }
                            m20312t();
                        }
                        Object obj = 1;
                        if ((location.bitField0_ & 1) != 1) {
                            obj = null;
                        }
                        if (obj != null) {
                            this.f20763a |= 4;
                            this.f20766d = location.leadingComments_;
                            m20312t();
                        }
                        if ((location.bitField0_ & 2) == 2) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (obj != null) {
                            this.f20763a |= 8;
                            this.f20767e = location.trailingComments_;
                            m20312t();
                        }
                        m20301c(location.mo868g());
                    }
                    return this;
                }

                public final AbstractMessage mo878v() {
                    return Location.f20769c;
                }

                public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo870a(AbstractMessage abstractMessage) {
                    return m21050d(abstractMessage);
                }

                public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo871a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                    return m21051d(codedInputStream, extensionRegistryLite);
                }

                public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo863b() {
                    return m21053n();
                }

                public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo846b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                    return m21051d(codedInputStream, extensionRegistryLite);
                }

                public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo848c() {
                    return m21053n();
                }

                public final /* synthetic */ Message$Builder mo849c(AbstractMessage abstractMessage) {
                    return m21050d(abstractMessage);
                }

                public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo840c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                    return m21051d(codedInputStream, extensionRegistryLite);
                }

                public final /* synthetic */ Object clone() {
                    return m21053n();
                }

                public final /* synthetic */ com.google.protobuf.GeneratedMessage.Builder mo873f() {
                    return m21053n();
                }

                public final /* synthetic */ AbstractMessage mo874h() {
                    return m21055x();
                }

                public final /* synthetic */ AbstractMessage mo875i() {
                    return m21054w();
                }

                public final /* synthetic */ MessageLite mo876j() {
                    return m21055x();
                }

                public final /* synthetic */ MessageLite mo877k() {
                    return m21054w();
                }

                protected final FieldAccessorTable mo872d() {
                    return DescriptorProtos.f20801N.m21368a(Location.class, Builder.class);
                }

                private Builder() {
                }

                public Builder(BuilderParent builderParent) {
                    super(builderParent);
                }

                public static Builder m21052m() {
                    return new Builder();
                }

                private Builder m21053n() {
                    return m21052m().m21058a(m21055x());
                }

                public final Descriptor mo841e() {
                    return DescriptorProtos.f20800M;
                }

                private Location m21054w() {
                    AbstractMessage x = m21055x();
                    if (x.mo854a()) {
                        return x;
                    }
                    throw com.google.protobuf.AbstractMessage.Builder.m20123b(x);
                }

                private Location m21055x() {
                    int i = 1;
                    Location location = new Location(this);
                    int i2 = this.f20763a;
                    if ((this.f20763a & 1) == 1) {
                        this.f20764b = Collections.unmodifiableList(this.f20764b);
                        this.f20763a &= -2;
                    }
                    location.path_ = this.f20764b;
                    if ((this.f20763a & 2) == 2) {
                        this.f20765c = Collections.unmodifiableList(this.f20765c);
                        this.f20763a &= -3;
                    }
                    location.span_ = this.f20765c;
                    if ((i2 & 4) != 4) {
                        i = 0;
                    }
                    location.leadingComments_ = this.f20766d;
                    if ((i2 & 8) == 8) {
                        i |= 2;
                    }
                    location.trailingComments_ = this.f20767e;
                    location.bitField0_ = i;
                    m20309p();
                    return location;
                }

                private Builder m21050d(AbstractMessage abstractMessage) {
                    if (abstractMessage instanceof Location) {
                        return m21058a((Location) abstractMessage);
                    }
                    super.mo870a(abstractMessage);
                    return this;
                }

                public final boolean mo854a() {
                    return true;
                }

                private Builder m21051d(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                    Throwable th;
                    Location location;
                    Location location2;
                    try {
                        location2 = (Location) Location.f20768a.mo859a(codedInputStream, extensionRegistryLite);
                        if (location2 != null) {
                            m21058a(location2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        InvalidProtocolBufferException invalidProtocolBufferException = e;
                        location2 = (Location) invalidProtocolBufferException.m21375a();
                        throw invalidProtocolBufferException;
                    } catch (Throwable th2) {
                        Throwable th3 = th2;
                        location = location2;
                        th = th3;
                    }
                    if (location != null) {
                        m21058a(location);
                    }
                    throw th;
                }
            }

            public final /* synthetic */ Message$Builder mo881s() {
                return m21073e(this);
            }

            public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo883u() {
                return m21073e(this);
            }

            public Location(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
                super((byte) 0);
                this.pathMemoizedSerializedSize = -1;
                this.spanMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = builder.mo868g();
            }

            private Location() {
                this.pathMemoizedSerializedSize = -1;
                this.spanMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = UnknownFieldSet.f21031a;
            }

            public final AbstractMessage mo878v() {
                return f20769c;
            }

            public final UnknownFieldSet mo868g() {
                return this.unknownFields;
            }

            public Location(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                Object obj = null;
                this.pathMemoizedSerializedSize = -1;
                this.spanMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                m21076q();
                com.google.protobuf.UnknownFieldSet.Builder e = com.google.protobuf.UnknownFieldSet.Builder.m21487e();
                int i = 0;
                while (obj == null) {
                    try {
                        int a = codedInputStream.m20202a();
                        switch (a) {
                            case 0:
                                obj = 1;
                                break;
                            case 8:
                                if ((i & 1) != 1) {
                                    this.path_ = new ArrayList();
                                    i |= 1;
                                }
                                this.path_.add(Integer.valueOf(codedInputStream.m20214f()));
                                break;
                            case 10:
                                a = codedInputStream.m20210c(codedInputStream.m20225r());
                                if ((i & 1) != 1 && codedInputStream.m20226s() > 0) {
                                    this.path_ = new ArrayList();
                                    i |= 1;
                                }
                                while (codedInputStream.m20226s() > 0) {
                                    this.path_.add(Integer.valueOf(codedInputStream.m20214f()));
                                }
                                codedInputStream.m20212d(a);
                                break;
                            case 16:
                                if ((i & 2) != 2) {
                                    this.span_ = new ArrayList();
                                    i |= 2;
                                }
                                this.span_.add(Integer.valueOf(codedInputStream.m20214f()));
                                break;
                            case 18:
                                a = codedInputStream.m20210c(codedInputStream.m20225r());
                                if ((i & 2) != 2 && codedInputStream.m20226s() > 0) {
                                    this.span_ = new ArrayList();
                                    i |= 2;
                                }
                                while (codedInputStream.m20226s() > 0) {
                                    this.span_.add(Integer.valueOf(codedInputStream.m20214f()));
                                }
                                codedInputStream.m20212d(a);
                                break;
                            case 26:
                                this.bitField0_ |= 1;
                                this.leadingComments_ = codedInputStream.m20219k();
                                break;
                            case 34:
                                this.bitField0_ |= 2;
                                this.trailingComments_ = codedInputStream.m20219k();
                                break;
                            default:
                                if (!mo889a(codedInputStream, e, extensionRegistryLite, a)) {
                                    obj = 1;
                                    break;
                                }
                                break;
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.m21374a(this);
                    } catch (IOException e3) {
                        throw new InvalidProtocolBufferException(e3.getMessage()).m21374a(this);
                    } catch (Throwable th) {
                        if ((i & 1) == 1) {
                            this.path_ = Collections.unmodifiableList(this.path_);
                        }
                        if ((i & 2) == 2) {
                            this.span_ = Collections.unmodifiableList(this.span_);
                        }
                        this.unknownFields = e.m21495b();
                        mo888E();
                    }
                }
                if ((i & 1) == 1) {
                    this.path_ = Collections.unmodifiableList(this.path_);
                }
                if ((i & 2) == 2) {
                    this.span_ = Collections.unmodifiableList(this.span_);
                }
                this.unknownFields = e.m21495b();
                mo888E();
            }

            protected final FieldAccessorTable mo880h() {
                return DescriptorProtos.f20801N.m21368a(Location.class, Builder.class);
            }

            static {
                Location location = new Location();
                f20769c = location;
                location.m21076q();
            }

            public final Parser<Location> mo857i() {
                return f20768a;
            }

            private ByteString m21074o() {
                Object obj = this.leadingComments_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString a = ByteString.m20173a((String) obj);
                this.leadingComments_ = a;
                return a;
            }

            private ByteString m21075p() {
                Object obj = this.trailingComments_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString a = ByteString.m20173a((String) obj);
                this.trailingComments_ = a;
                return a;
            }

            private void m21076q() {
                this.path_ = Collections.emptyList();
                this.span_ = Collections.emptyList();
                this.leadingComments_ = "";
                this.trailingComments_ = "";
            }

            public final boolean mo854a() {
                byte b = this.memoizedIsInitialized;
                if (b == (byte) -1) {
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                } else if (b == (byte) 1) {
                    return true;
                } else {
                    return false;
                }
            }

            public final void mo853a(CodedOutputStream codedOutputStream) {
                int i = 0;
                mo855b();
                if (this.path_.size() > 0) {
                    codedOutputStream.m20286l(10);
                    codedOutputStream.m20286l(this.pathMemoizedSerializedSize);
                }
                for (int i2 = 0; i2 < this.path_.size(); i2++) {
                    codedOutputStream.m20261a(((Integer) this.path_.get(i2)).intValue());
                }
                if (this.span_.size() > 0) {
                    codedOutputStream.m20286l(18);
                    codedOutputStream.m20286l(this.spanMemoizedSerializedSize);
                }
                while (i < this.span_.size()) {
                    codedOutputStream.m20261a(((Integer) this.span_.get(i)).intValue());
                    i++;
                }
                if ((this.bitField0_ & 1) == 1) {
                    codedOutputStream.m20264a(3, m21074o());
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.m20264a(4, m21075p());
                }
                mo868g().mo853a(codedOutputStream);
            }

            public final int mo855b() {
                int i = 0;
                int i2 = this.memoizedSerializedSize;
                if (i2 != -1) {
                    return i2;
                }
                int i3;
                int i4 = 0;
                for (i3 = 0; i3 < this.path_.size(); i3++) {
                    i4 += CodedOutputStream.m20245g(((Integer) this.path_.get(i3)).intValue());
                }
                i2 = i4 + 0;
                if (this.path_.isEmpty()) {
                    i3 = i2;
                } else {
                    i3 = (i2 + 1) + CodedOutputStream.m20245g(i4);
                }
                this.pathMemoizedSerializedSize = i4;
                i4 = 0;
                while (i < this.span_.size()) {
                    i++;
                    i4 = CodedOutputStream.m20245g(((Integer) this.span_.get(i)).intValue()) + i4;
                }
                i2 = i3 + i4;
                if (!this.span_.isEmpty()) {
                    i2 = (i2 + 1) + CodedOutputStream.m20245g(i4);
                }
                this.spanMemoizedSerializedSize = i4;
                if ((this.bitField0_ & 1) == 1) {
                    i2 += CodedOutputStream.m20236c(3, m21074o());
                }
                if ((this.bitField0_ & 2) == 2) {
                    i2 += CodedOutputStream.m20236c(4, m21075p());
                }
                i2 += mo868g().mo855b();
                this.memoizedSerializedSize = i2;
                return i2;
            }

            public final Message$Builder mo882t() {
                return Builder.m21052m();
            }

            private static Builder m21073e(Location location) {
                return Builder.m21052m().m21058a(location);
            }

            protected final Message$Builder mo879a(BuilderParent builderParent) {
                return new Builder(builderParent);
            }
        }

        public final /* synthetic */ Message$Builder mo881s() {
            return mo891j();
        }

        public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo883u() {
            return mo891j();
        }

        public SourceCodeInfo(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
            super((byte) 0);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.mo868g();
        }

        private SourceCodeInfo() {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.f21031a;
        }

        public final AbstractMessage mo878v() {
            return f20771c;
        }

        public final UnknownFieldSet mo868g() {
            return this.unknownFields;
        }

        public SourceCodeInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            Throwable th;
            int i = 0;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            m21089l();
            com.google.protobuf.UnknownFieldSet.Builder e = com.google.protobuf.UnknownFieldSet.Builder.m21487e();
            int i2 = 0;
            while (i2 == 0) {
                try {
                    int a = codedInputStream.m20202a();
                    switch (a) {
                        case 0:
                            i2 = 1;
                            break;
                        case 10:
                            if ((i & 1) != 1) {
                                this.location_ = new ArrayList();
                                i |= 1;
                            }
                            this.location_.add(codedInputStream.m20203a(Location.f20768a, extensionRegistryLite));
                            break;
                        default:
                            if (!mo889a(codedInputStream, e, extensionRegistryLite, a)) {
                                i2 = 1;
                                break;
                            }
                            break;
                    }
                } catch (InvalidProtocolBufferException e2) {
                    InvalidProtocolBufferException invalidProtocolBufferException = e2;
                    i2 = i;
                    throw invalidProtocolBufferException.m21374a(this);
                } catch (IOException e3) {
                    IOException iOException = e3;
                    i2 = i;
                    throw new InvalidProtocolBufferException(iOException.getMessage()).m21374a(this);
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if ((i & 1) == 1) {
                this.location_ = Collections.unmodifiableList(this.location_);
            }
            this.unknownFields = e.m21495b();
            mo888E();
            return;
            if ((i2 & 1) == 1) {
                this.location_ = Collections.unmodifiableList(this.location_);
            }
            this.unknownFields = e.m21495b();
            mo888E();
            throw th;
        }

        protected final FieldAccessorTable mo880h() {
            return DescriptorProtos.f20799L.m21368a(SourceCodeInfo.class, Builder.class);
        }

        static {
            SourceCodeInfo sourceCodeInfo = new SourceCodeInfo();
            f20771c = sourceCodeInfo;
            sourceCodeInfo.m21089l();
        }

        public final Parser<SourceCodeInfo> mo857i() {
            return f20770a;
        }

        private void m21089l() {
            this.location_ = Collections.emptyList();
        }

        public final boolean mo854a() {
            byte b = this.memoizedIsInitialized;
            if (b == (byte) -1) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            } else if (b == (byte) 1) {
                return true;
            } else {
                return false;
            }
        }

        public final void mo853a(CodedOutputStream codedOutputStream) {
            mo855b();
            for (int i = 0; i < this.location_.size(); i++) {
                codedOutputStream.m20273b(1, (MessageLite) this.location_.get(i));
            }
            mo868g().mo853a(codedOutputStream);
        }

        public final int mo855b() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (i = 0; i < this.location_.size(); i++) {
                i2 += CodedOutputStream.m20242e(1, (MessageLite) this.location_.get(i));
            }
            int b = mo868g().mo855b() + i2;
            this.memoizedSerializedSize = b;
            return b;
        }

        public final Message$Builder mo882t() {
            return Builder.m21028u();
        }

        public static Builder m21088a(SourceCodeInfo sourceCodeInfo) {
            return Builder.m21028u().m21033a(sourceCodeInfo);
        }

        public final Builder mo891j() {
            return m21088a(this);
        }

        protected final Message$Builder mo879a(BuilderParent builderParent) {
            return new Builder(builderParent);
        }
    }

    public interface UninterpretedOptionOrBuilder extends MessageOrBuilder {
    }

    /* compiled from: analytics_source */
    public final class UninterpretedOption extends GeneratedMessage implements UninterpretedOptionOrBuilder {
        public static Parser<UninterpretedOption> f20786a = new C24391();
        public static final UninterpretedOption f20787c;
        public Object aggregateValue_;
        public int bitField0_;
        public double doubleValue_;
        public Object identifierValue_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        public List<NamePart> name_;
        public long negativeIntValue_;
        public long positiveIntValue_;
        public ByteString stringValue_;
        private final UnknownFieldSet unknownFields;

        /* compiled from: analytics_source */
        final class C24391 extends AbstractParser<UninterpretedOption> {
            C24391() {
            }

            public final Object mo859a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return new UninterpretedOption(codedInputStream, extensionRegistryLite);
            }
        }

        /* compiled from: analytics_source */
        public final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> implements UninterpretedOptionOrBuilder {
            public int f20772a;
            public List<NamePart> f20773b = Collections.emptyList();
            public RepeatedFieldBuilder<NamePart, Builder, NamePartOrBuilder> f20774c;
            private Object f20775d = "";
            public long f20776e;
            public long f20777f;
            public double f20778g;
            private ByteString f20779h = ByteString.f20600a;
            private Object f20780i = "";

            public final AbstractMessage mo878v() {
                return UninterpretedOption.f20787c;
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo870a(AbstractMessage abstractMessage) {
                return m21105d(abstractMessage);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo871a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m21106d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo863b() {
                return m21109u();
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo846b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m21106d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo848c() {
                return m21109u();
            }

            public final /* synthetic */ Message$Builder mo849c(AbstractMessage abstractMessage) {
                return m21105d(abstractMessage);
            }

            public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo840c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return m21106d(codedInputStream, extensionRegistryLite);
            }

            public final /* synthetic */ Object clone() {
                return m21109u();
            }

            public final /* synthetic */ com.google.protobuf.GeneratedMessage.Builder mo873f() {
                return m21109u();
            }

            public final /* synthetic */ AbstractMessage mo874h() {
                return m21111y();
            }

            public final /* synthetic */ AbstractMessage mo875i() {
                return m21110x();
            }

            public final /* synthetic */ MessageLite mo876j() {
                return m21111y();
            }

            public final /* synthetic */ MessageLite mo877k() {
                return m21110x();
            }

            protected final FieldAccessorTable mo872d() {
                return DescriptorProtos.f20795H.m21368a(UninterpretedOption.class, Builder.class);
            }

            private Builder() {
                m21107m();
            }

            public Builder(BuilderParent builderParent) {
                super(builderParent);
                m21107m();
            }

            private void m21107m() {
                if (GeneratedMessage.f20638b) {
                    m21103B();
                }
            }

            public static Builder m21108n() {
                return new Builder();
            }

            private Builder m21109u() {
                return m21108n().m21114a(m21111y());
            }

            public final Descriptor mo841e() {
                return DescriptorProtos.f20794G;
            }

            private UninterpretedOption m21110x() {
                AbstractMessage y = m21111y();
                if (y.mo854a()) {
                    return y;
                }
                throw com.google.protobuf.AbstractMessage.Builder.m20123b(y);
            }

            private UninterpretedOption m21111y() {
                int i = 1;
                UninterpretedOption uninterpretedOption = new UninterpretedOption(this);
                int i2 = this.f20772a;
                if (this.f20774c == null) {
                    if ((this.f20772a & 1) == 1) {
                        this.f20773b = Collections.unmodifiableList(this.f20773b);
                        this.f20772a &= -2;
                    }
                    uninterpretedOption.name_ = this.f20773b;
                } else {
                    uninterpretedOption.name_ = this.f20774c.m21416f();
                }
                if ((i2 & 2) != 2) {
                    i = 0;
                }
                uninterpretedOption.identifierValue_ = this.f20775d;
                if ((i2 & 4) == 4) {
                    i |= 2;
                }
                uninterpretedOption.positiveIntValue_ = this.f20776e;
                if ((i2 & 8) == 8) {
                    i |= 4;
                }
                uninterpretedOption.negativeIntValue_ = this.f20777f;
                if ((i2 & 16) == 16) {
                    i |= 8;
                }
                uninterpretedOption.doubleValue_ = this.f20778g;
                if ((i2 & 32) == 32) {
                    i |= 16;
                }
                uninterpretedOption.stringValue_ = this.f20779h;
                if ((i2 & 64) == 64) {
                    i |= 32;
                }
                uninterpretedOption.aggregateValue_ = this.f20780i;
                uninterpretedOption.bitField0_ = i;
                m20309p();
                return uninterpretedOption;
            }

            private Builder m21105d(AbstractMessage abstractMessage) {
                if (abstractMessage instanceof UninterpretedOption) {
                    return m21114a((UninterpretedOption) abstractMessage);
                }
                super.mo870a(abstractMessage);
                return this;
            }

            public final Builder m21114a(UninterpretedOption uninterpretedOption) {
                RepeatedFieldBuilder repeatedFieldBuilder = null;
                if (uninterpretedOption != UninterpretedOption.f20787c) {
                    long j;
                    if (this.f20774c == null) {
                        if (!uninterpretedOption.name_.isEmpty()) {
                            if (this.f20773b.isEmpty()) {
                                this.f20773b = uninterpretedOption.name_;
                                this.f20772a &= -2;
                            } else {
                                if ((this.f20772a & 1) != 1) {
                                    this.f20773b = new ArrayList(this.f20773b);
                                    this.f20772a |= 1;
                                }
                                this.f20773b.addAll(uninterpretedOption.name_);
                            }
                            m20312t();
                        }
                    } else if (!uninterpretedOption.name_.isEmpty()) {
                        if (this.f20774c.m21414d()) {
                            this.f20774c.m21411b();
                            this.f20774c = null;
                            this.f20773b = uninterpretedOption.name_;
                            this.f20772a &= -2;
                            if (GeneratedMessage.f20638b) {
                                repeatedFieldBuilder = m21103B();
                            }
                            this.f20774c = repeatedFieldBuilder;
                        } else {
                            this.f20774c.m21409a(uninterpretedOption.name_);
                        }
                    }
                    Object obj = 1;
                    if ((uninterpretedOption.bitField0_ & 1) != 1) {
                        obj = null;
                    }
                    if (obj != null) {
                        this.f20772a |= 2;
                        this.f20775d = uninterpretedOption.identifierValue_;
                        m20312t();
                    }
                    if ((uninterpretedOption.bitField0_ & 2) == 2) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        j = uninterpretedOption.positiveIntValue_;
                        this.f20772a |= 4;
                        this.f20776e = j;
                        m20312t();
                    }
                    if ((uninterpretedOption.bitField0_ & 4) == 4) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        j = uninterpretedOption.negativeIntValue_;
                        this.f20772a |= 8;
                        this.f20777f = j;
                        m20312t();
                    }
                    if ((uninterpretedOption.bitField0_ & 8) == 8) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        double d = uninterpretedOption.doubleValue_;
                        this.f20772a |= 16;
                        this.f20778g = d;
                        m20312t();
                    }
                    if ((uninterpretedOption.bitField0_ & 16) == 16) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        m21104a(uninterpretedOption.stringValue_);
                    }
                    if ((uninterpretedOption.bitField0_ & 32) == 32) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        this.f20772a |= 64;
                        this.f20780i = uninterpretedOption.aggregateValue_;
                        m20312t();
                    }
                    m20301c(uninterpretedOption.mo868g());
                }
                return this;
            }

            public final boolean mo854a() {
                int i = 0;
                while (true) {
                    int size;
                    if (this.f20774c == null) {
                        size = this.f20773b.size();
                    } else {
                        size = this.f20774c.m21412c();
                    }
                    if (i >= size) {
                        return true;
                    }
                    if (this.f20774c == null) {
                        AbstractMessage abstractMessage = (NamePart) this.f20773b.get(i);
                    } else {
                        NamePart namePart = (NamePart) this.f20774c.m21406a(i);
                    }
                    if (!abstractMessage.mo854a()) {
                        return false;
                    }
                    i++;
                }
            }

            private Builder m21106d(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                UninterpretedOption uninterpretedOption;
                Throwable th;
                UninterpretedOption uninterpretedOption2;
                try {
                    uninterpretedOption = (UninterpretedOption) UninterpretedOption.f20786a.mo859a(codedInputStream, extensionRegistryLite);
                    if (uninterpretedOption != null) {
                        m21114a(uninterpretedOption);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    InvalidProtocolBufferException invalidProtocolBufferException = e;
                    uninterpretedOption = (UninterpretedOption) invalidProtocolBufferException.m21375a();
                    throw invalidProtocolBufferException;
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    uninterpretedOption2 = uninterpretedOption;
                    th = th3;
                }
                if (uninterpretedOption2 != null) {
                    m21114a(uninterpretedOption2);
                }
                throw th;
            }

            private RepeatedFieldBuilder<NamePart, Builder, NamePartOrBuilder> m21103B() {
                boolean z = true;
                if (this.f20774c == null) {
                    List list = this.f20773b;
                    if ((this.f20772a & 1) != 1) {
                        z = false;
                    }
                    this.f20774c = new RepeatedFieldBuilder(list, z, m20311s(), this.f20619c);
                    this.f20773b = null;
                }
                return this.f20774c;
            }

            private Builder m21104a(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.f20772a |= 32;
                this.f20779h = byteString;
                m20312t();
                return this;
            }
        }

        public interface NamePartOrBuilder extends MessageOrBuilder {
        }

        /* compiled from: analytics_source */
        public final class NamePart extends GeneratedMessage implements NamePartOrBuilder {
            public static Parser<NamePart> f20784a = new C24401();
            public static final NamePart f20785c;
            public int bitField0_;
            public boolean isExtension_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            public Object namePart_;
            private final UnknownFieldSet unknownFields;

            /* compiled from: analytics_source */
            final class C24401 extends AbstractParser<NamePart> {
                C24401() {
                }

                public final Object mo859a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                    return new NamePart(codedInputStream, extensionRegistryLite);
                }
            }

            /* compiled from: analytics_source */
            public final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> implements NamePartOrBuilder {
                public int f20781a;
                private Object f20782b = "";
                public boolean f20783c;

                public final Builder m21138a(NamePart namePart) {
                    if (namePart != NamePart.f20785c) {
                        if (namePart.mo891j()) {
                            this.f20781a |= 1;
                            this.f20782b = namePart.namePart_;
                            m20312t();
                        }
                        if (namePart.m21164k()) {
                            boolean z = namePart.isExtension_;
                            this.f20781a |= 2;
                            this.f20783c = z;
                            m20312t();
                        }
                        m20301c(namePart.mo868g());
                    }
                    return this;
                }

                public final AbstractMessage mo878v() {
                    return NamePart.f20785c;
                }

                public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo870a(AbstractMessage abstractMessage) {
                    return m21130d(abstractMessage);
                }

                public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo871a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                    return m21131d(codedInputStream, extensionRegistryLite);
                }

                public final /* synthetic */ com.google.protobuf.AbstractMessage.Builder mo863b() {
                    return m21133n();
                }

                public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo846b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                    return m21131d(codedInputStream, extensionRegistryLite);
                }

                public final /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder mo848c() {
                    return m21133n();
                }

                public final /* synthetic */ Message$Builder mo849c(AbstractMessage abstractMessage) {
                    return m21130d(abstractMessage);
                }

                public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo840c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                    return m21131d(codedInputStream, extensionRegistryLite);
                }

                public final /* synthetic */ Object clone() {
                    return m21133n();
                }

                public final /* synthetic */ com.google.protobuf.GeneratedMessage.Builder mo873f() {
                    return m21133n();
                }

                public final /* synthetic */ AbstractMessage mo874h() {
                    return m21135x();
                }

                public final /* synthetic */ AbstractMessage mo875i() {
                    return m21134w();
                }

                public final /* synthetic */ MessageLite mo876j() {
                    return m21135x();
                }

                public final /* synthetic */ MessageLite mo877k() {
                    return m21134w();
                }

                protected final FieldAccessorTable mo872d() {
                    return DescriptorProtos.f20797J.m21368a(NamePart.class, Builder.class);
                }

                private Builder() {
                }

                public Builder(BuilderParent builderParent) {
                    super(builderParent);
                }

                public static Builder m21132m() {
                    return new Builder();
                }

                private Builder m21133n() {
                    return m21132m().m21138a(m21135x());
                }

                public final Descriptor mo841e() {
                    return DescriptorProtos.f20796I;
                }

                private NamePart m21134w() {
                    AbstractMessage x = m21135x();
                    if (x.mo854a()) {
                        return x;
                    }
                    throw com.google.protobuf.AbstractMessage.Builder.m20123b(x);
                }

                private NamePart m21135x() {
                    int i = 1;
                    NamePart namePart = new NamePart(this);
                    int i2 = this.f20781a;
                    if ((i2 & 1) != 1) {
                        i = 0;
                    }
                    namePart.namePart_ = this.f20782b;
                    if ((i2 & 2) == 2) {
                        i |= 2;
                    }
                    namePart.isExtension_ = this.f20783c;
                    namePart.bitField0_ = i;
                    m20309p();
                    return namePart;
                }

                private Builder m21130d(AbstractMessage abstractMessage) {
                    if (abstractMessage instanceof NamePart) {
                        return m21138a((NamePart) abstractMessage);
                    }
                    super.mo870a(abstractMessage);
                    return this;
                }

                public final boolean mo854a() {
                    Object obj = 1;
                    if ((this.f20781a & 1) != 1) {
                        obj = null;
                    }
                    if (obj == null) {
                        return false;
                    }
                    if (((this.f20781a & 2) == 2 ? 1 : null) != null) {
                        return true;
                    }
                    return false;
                }

                private Builder m21131d(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                    Throwable th;
                    NamePart namePart;
                    NamePart namePart2;
                    try {
                        namePart2 = (NamePart) NamePart.f20784a.mo859a(codedInputStream, extensionRegistryLite);
                        if (namePart2 != null) {
                            m21138a(namePart2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        InvalidProtocolBufferException invalidProtocolBufferException = e;
                        namePart2 = (NamePart) invalidProtocolBufferException.m21375a();
                        throw invalidProtocolBufferException;
                    } catch (Throwable th2) {
                        Throwable th3 = th2;
                        namePart = namePart2;
                        th = th3;
                    }
                    if (namePart != null) {
                        m21138a(namePart);
                    }
                    throw th;
                }
            }

            public final /* synthetic */ Message$Builder mo881s() {
                return m21153b(this);
            }

            public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo883u() {
                return m21153b(this);
            }

            public NamePart(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
                super((byte) 0);
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = builder.mo868g();
            }

            private NamePart() {
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = UnknownFieldSet.f21031a;
            }

            public final AbstractMessage mo878v() {
                return f20785c;
            }

            public final UnknownFieldSet mo868g() {
                return this.unknownFields;
            }

            public NamePart(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                m21155o();
                com.google.protobuf.UnknownFieldSet.Builder e = com.google.protobuf.UnknownFieldSet.Builder.m21487e();
                Object obj = null;
                while (obj == null) {
                    try {
                        int a = codedInputStream.m20202a();
                        switch (a) {
                            case 0:
                                obj = 1;
                                break;
                            case 10:
                                this.bitField0_ |= 1;
                                this.namePart_ = codedInputStream.m20219k();
                                break;
                            case 16:
                                this.bitField0_ |= 2;
                                this.isExtension_ = codedInputStream.m20217i();
                                break;
                            default:
                                if (!mo889a(codedInputStream, e, extensionRegistryLite, a)) {
                                    obj = 1;
                                    break;
                                }
                                break;
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.m21374a(this);
                    } catch (IOException e3) {
                        throw new InvalidProtocolBufferException(e3.getMessage()).m21374a(this);
                    } catch (Throwable th) {
                        this.unknownFields = e.m21495b();
                        mo888E();
                    }
                }
                this.unknownFields = e.m21495b();
                mo888E();
            }

            protected final FieldAccessorTable mo880h() {
                return DescriptorProtos.f20797J.m21368a(NamePart.class, Builder.class);
            }

            static {
                NamePart namePart = new NamePart();
                f20785c = namePart;
                namePart.m21155o();
            }

            public final Parser<NamePart> mo857i() {
                return f20784a;
            }

            public final boolean mo891j() {
                return (this.bitField0_ & 1) == 1;
            }

            private ByteString m21154n() {
                Object obj = this.namePart_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString a = ByteString.m20173a((String) obj);
                this.namePart_ = a;
                return a;
            }

            public final boolean m21164k() {
                return (this.bitField0_ & 2) == 2;
            }

            private void m21155o() {
                this.namePart_ = "";
                this.isExtension_ = false;
            }

            public final boolean mo854a() {
                byte b = this.memoizedIsInitialized;
                if (b != (byte) -1) {
                    if (b == (byte) 1) {
                        return true;
                    }
                    return false;
                } else if (!mo891j()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                } else if (m21164k()) {
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                } else {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }

            public final void mo853a(CodedOutputStream codedOutputStream) {
                mo855b();
                if ((this.bitField0_ & 1) == 1) {
                    codedOutputStream.m20264a(1, m21154n());
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.m20266a(2, this.isExtension_);
                }
                mo868g().mo853a(codedOutputStream);
            }

            public final int mo855b() {
                int i = this.memoizedSerializedSize;
                if (i != -1) {
                    return i;
                }
                i = 0;
                if ((this.bitField0_ & 1) == 1) {
                    i = CodedOutputStream.m20236c(1, m21154n()) + 0;
                }
                if ((this.bitField0_ & 2) == 2) {
                    i += CodedOutputStream.m20231b(2, this.isExtension_);
                }
                i += mo868g().mo855b();
                this.memoizedSerializedSize = i;
                return i;
            }

            public final Message$Builder mo882t() {
                return Builder.m21132m();
            }

            private static Builder m21153b(NamePart namePart) {
                return Builder.m21132m().m21138a(namePart);
            }

            protected final Message$Builder mo879a(BuilderParent builderParent) {
                return new Builder(builderParent);
            }
        }

        public final /* synthetic */ Message$Builder mo881s() {
            return m21171d(this);
        }

        public final /* synthetic */ com.google.protobuf.MessageLite.Builder mo883u() {
            return m21171d(this);
        }

        public UninterpretedOption(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
            super((byte) 0);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.mo868g();
        }

        private UninterpretedOption() {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.f21031a;
        }

        public final AbstractMessage mo878v() {
            return f20787c;
        }

        public final UnknownFieldSet mo868g() {
            return this.unknownFields;
        }

        public UninterpretedOption(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            Object obj = null;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            m21170B();
            com.google.protobuf.UnknownFieldSet.Builder e = com.google.protobuf.UnknownFieldSet.Builder.m21487e();
            int i = 0;
            while (obj == null) {
                try {
                    int a = codedInputStream.m20202a();
                    switch (a) {
                        case 0:
                            obj = 1;
                            break;
                        case 18:
                            if ((i & 1) != 1) {
                                this.name_ = new ArrayList();
                                i |= 1;
                            }
                            this.name_.add(codedInputStream.m20203a(NamePart.f20784a, extensionRegistryLite));
                            break;
                        case 26:
                            this.bitField0_ |= 1;
                            this.identifierValue_ = codedInputStream.m20219k();
                            break;
                        case 32:
                            this.bitField0_ |= 2;
                            this.positiveIntValue_ = codedInputStream.m20211d();
                            break;
                        case 40:
                            this.bitField0_ |= 4;
                            this.negativeIntValue_ = codedInputStream.m20213e();
                            break;
                        case 49:
                            this.bitField0_ |= 8;
                            this.doubleValue_ = codedInputStream.m20207b();
                            break;
                        case 58:
                            this.bitField0_ |= 16;
                            this.stringValue_ = codedInputStream.m20219k();
                            break;
                        case 66:
                            this.bitField0_ |= 32;
                            this.aggregateValue_ = codedInputStream.m20219k();
                            break;
                        default:
                            if (!mo889a(codedInputStream, e, extensionRegistryLite, a)) {
                                obj = 1;
                                break;
                            }
                            break;
                    }
                } catch (InvalidProtocolBufferException e2) {
                    throw e2.m21374a(this);
                } catch (IOException e3) {
                    throw new InvalidProtocolBufferException(e3.getMessage()).m21374a(this);
                } catch (Throwable th) {
                    if ((i & 1) == 1) {
                        this.name_ = Collections.unmodifiableList(this.name_);
                    }
                    this.unknownFields = e.m21495b();
                    mo888E();
                }
            }
            if ((i & 1) == 1) {
                this.name_ = Collections.unmodifiableList(this.name_);
            }
            this.unknownFields = e.m21495b();
            mo888E();
        }

        protected final FieldAccessorTable mo880h() {
            return DescriptorProtos.f20795H.m21368a(UninterpretedOption.class, Builder.class);
        }

        static {
            UninterpretedOption uninterpretedOption = new UninterpretedOption();
            f20787c = uninterpretedOption;
            uninterpretedOption.m21170B();
        }

        public final Parser<UninterpretedOption> mo857i() {
            return f20786a;
        }

        private ByteString m21172z() {
            Object obj = this.identifierValue_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString a = ByteString.m20173a((String) obj);
            this.identifierValue_ = a;
            return a;
        }

        private ByteString m21169A() {
            Object obj = this.aggregateValue_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString a = ByteString.m20173a((String) obj);
            this.aggregateValue_ = a;
            return a;
        }

        private void m21170B() {
            this.name_ = Collections.emptyList();
            this.identifierValue_ = "";
            this.positiveIntValue_ = 0;
            this.negativeIntValue_ = 0;
            this.doubleValue_ = 0.0d;
            this.stringValue_ = ByteString.f20600a;
            this.aggregateValue_ = "";
        }

        public final boolean mo854a() {
            byte b = this.memoizedIsInitialized;
            if (b == (byte) -1) {
                int i = 0;
                while (i < this.name_.size()) {
                    if (((NamePart) this.name_.get(i)).mo854a()) {
                        i++;
                    } else {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            } else if (b == (byte) 1) {
                return true;
            } else {
                return false;
            }
        }

        public final void mo853a(CodedOutputStream codedOutputStream) {
            mo855b();
            for (int i = 0; i < this.name_.size(); i++) {
                codedOutputStream.m20273b(2, (MessageLite) this.name_.get(i));
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.m20264a(3, m21172z());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.m20263a(4, this.positiveIntValue_);
            }
            if ((this.bitField0_ & 4) == 4) {
                long j = this.negativeIntValue_;
                codedOutputStream.m20285i(5, 0);
                codedOutputStream.m20274b(j);
            }
            if ((this.bitField0_ & 8) == 8) {
                double d = this.doubleValue_;
                codedOutputStream.m20285i(6, 1);
                codedOutputStream.m20259a(d);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.m20264a(7, this.stringValue_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.m20264a(8, m21169A());
            }
            mo868g().mo853a(codedOutputStream);
        }

        public final int mo855b() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (i = 0; i < this.name_.size(); i++) {
                i2 += CodedOutputStream.m20242e(2, (MessageLite) this.name_.get(i));
            }
            if ((this.bitField0_ & 1) == 1) {
                i2 += CodedOutputStream.m20236c(3, m21172z());
            }
            if ((this.bitField0_ & 2) == 2) {
                i2 += CodedOutputStream.m20239d(4, this.positiveIntValue_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i2 += CodedOutputStream.m20252k(5) + CodedOutputStream.m20251j(this.negativeIntValue_);
            }
            if ((this.bitField0_ & 8) == 8) {
                double d = this.doubleValue_;
                i2 += CodedOutputStream.m20252k(6) + 8;
            }
            if ((this.bitField0_ & 16) == 16) {
                i2 += CodedOutputStream.m20236c(7, this.stringValue_);
            }
            if ((this.bitField0_ & 32) == 32) {
                i2 += CodedOutputStream.m20236c(8, m21169A());
            }
            int b = mo868g().mo855b() + i2;
            this.memoizedSerializedSize = b;
            return b;
        }

        public final Message$Builder mo882t() {
            return Builder.m21108n();
        }

        private static Builder m21171d(UninterpretedOption uninterpretedOption) {
            return Builder.m21108n().m21114a(uninterpretedOption);
        }

        protected final Message$Builder mo879a(BuilderParent builderParent) {
            return new Builder(builderParent);
        }
    }

    private DescriptorProtos() {
    }

    static {
        FileDescriptor.m21250a(new String[]{"\n google/protobuf/descriptor.proto\u0012\u000fgoogle.protobuf\"G\n\u0011FileDescriptorSet\u00122\n\u0004file\u0018\u0001 \u0003(\u000b2$.google.protobuf.FileDescriptorProto\"Ë\u0003\n\u0013FileDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u000f\n\u0007package\u0018\u0002 \u0001(\t\u0012\u0012\n\ndependency\u0018\u0003 \u0003(\t\u0012\u0019\n\u0011public_dependency\u0018\n \u0003(\u0005\u0012\u0017\n\u000fweak_dependency\u0018\u000b \u0003(\u0005\u00126\n\fmessage_type\u0018\u0004 \u0003(\u000b2 .google.protobuf.DescriptorProto\u00127\n\tenum_type\u0018\u0005 \u0003(\u000b2$.google.protobuf.EnumDescriptorProto\u00128\n\u0007service\u0018\u0006 \u0003(\u000b2'.google.protobuf.", "ServiceDescriptorProto\u00128\n\textension\u0018\u0007 \u0003(\u000b2%.google.protobuf.FieldDescriptorProto\u0012-\n\u0007options\u0018\b \u0001(\u000b2\u001c.google.protobuf.FileOptions\u00129\n\u0010source_code_info\u0018\t \u0001(\u000b2\u001f.google.protobuf.SourceCodeInfo\"©\u0003\n\u000fDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u00124\n\u0005field\u0018\u0002 \u0003(\u000b2%.google.protobuf.FieldDescriptorProto\u00128\n\textension\u0018\u0006 \u0003(\u000b2%.google.protobuf.FieldDescriptorProto\u00125\n\u000bnested_type\u0018\u0003 \u0003(\u000b2 .google.protobuf.DescriptorProto\u00127\n\tenum_type", "\u0018\u0004 \u0003(\u000b2$.google.protobuf.EnumDescriptorProto\u0012H\n\u000fextension_range\u0018\u0005 \u0003(\u000b2/.google.protobuf.DescriptorProto.ExtensionRange\u00120\n\u0007options\u0018\u0007 \u0001(\u000b2\u001f.google.protobuf.MessageOptions\u001a,\n\u000eExtensionRange\u0012\r\n\u0005start\u0018\u0001 \u0001(\u0005\u0012\u000b\n\u0003end\u0018\u0002 \u0001(\u0005\"\u0005\n\u0014FieldDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u000e\n\u0006number\u0018\u0003 \u0001(\u0005\u0012:\n\u0005label\u0018\u0004 \u0001(\u000e2+.google.protobuf.FieldDescriptorProto.Label\u00128\n\u0004type\u0018\u0005 \u0001(\u000e2*.google.protobuf.FieldDescriptorProto.Type\u0012\u0011\n\ttype_name", "\u0018\u0006 \u0001(\t\u0012\u0010\n\bextendee\u0018\u0002 \u0001(\t\u0012\u0015\n\rdefault_value\u0018\u0007 \u0001(\t\u0012.\n\u0007options\u0018\b \u0001(\u000b2\u001d.google.protobuf.FieldOptions\"¶\u0002\n\u0004Type\u0012\u000f\n\u000bTYPE_DOUBLE\u0010\u0001\u0012\u000e\n\nTYPE_FLOAT\u0010\u0002\u0012\u000e\n\nTYPE_INT64\u0010\u0003\u0012\u000f\n\u000bTYPE_UINT64\u0010\u0004\u0012\u000e\n\nTYPE_INT32\u0010\u0005\u0012\u0010\n\fTYPE_FIXED64\u0010\u0006\u0012\u0010\n\fTYPE_FIXED32\u0010\u0007\u0012\r\n\tTYPE_BOOL\u0010\b\u0012\u000f\n\u000bTYPE_STRING\u0010\t\u0012\u000e\n\nTYPE_GROUP\u0010\n\u0012\u0010\n\fTYPE_MESSAGE\u0010\u000b\u0012\u000e\n\nTYPE_BYTES\u0010\f\u0012\u000f\n\u000bTYPE_UINT32\u0010\r\u0012\r\n\tTYPE_ENUM\u0010\u000e\u0012\u0011\n\rTYPE_SFIXED32\u0010\u000f\u0012\u0011\n\rTYPE_SFIXED64\u0010\u0010\u0012\u000f\n\u000bTYPE_SINT32\u0010\u0011\u0012\u000f\n\u000bTYPE_", "SINT64\u0010\u0012\"C\n\u0005Label\u0012\u0012\n\u000eLABEL_OPTIONAL\u0010\u0001\u0012\u0012\n\u000eLABEL_REQUIRED\u0010\u0002\u0012\u0012\n\u000eLABEL_REPEATED\u0010\u0003\"\u0001\n\u0013EnumDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u00128\n\u0005value\u0018\u0002 \u0003(\u000b2).google.protobuf.EnumValueDescriptorProto\u0012-\n\u0007options\u0018\u0003 \u0001(\u000b2\u001c.google.protobuf.EnumOptions\"l\n\u0018EnumValueDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u000e\n\u0006number\u0018\u0002 \u0001(\u0005\u00122\n\u0007options\u0018\u0003 \u0001(\u000b2!.google.protobuf.EnumValueOptions\"\u0001\n\u0016ServiceDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u00126\n\u0006method\u0018\u0002 \u0003(\u000b2&.google.pro", "tobuf.MethodDescriptorProto\u00120\n\u0007options\u0018\u0003 \u0001(\u000b2\u001f.google.protobuf.ServiceOptions\"\n\u0015MethodDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u0012\n\ninput_type\u0018\u0002 \u0001(\t\u0012\u0013\n\u000boutput_type\u0018\u0003 \u0001(\t\u0012/\n\u0007options\u0018\u0004 \u0001(\u000b2\u001e.google.protobuf.MethodOptions\"é\u0003\n\u000bFileOptions\u0012\u0014\n\fjava_package\u0018\u0001 \u0001(\t\u0012\u001c\n\u0014java_outer_classname\u0018\b \u0001(\t\u0012\"\n\u0013java_multiple_files\u0018\n \u0001(\b:\u0005false\u0012,\n\u001djava_generate_equals_and_hash\u0018\u0014 \u0001(\b:\u0005false\u0012F\n\foptimize_for\u0018\t \u0001(\u000e2).google.protobuf.Fil", "eOptions.OptimizeMode:\u0005SPEED\u0012\u0012\n\ngo_package\u0018\u000b \u0001(\t\u0012\"\n\u0013cc_generic_services\u0018\u0010 \u0001(\b:\u0005false\u0012$\n\u0015java_generic_services\u0018\u0011 \u0001(\b:\u0005false\u0012\"\n\u0013py_generic_services\u0018\u0012 \u0001(\b:\u0005false\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption\":\n\fOptimizeMode\u0012\t\n\u0005SPEED\u0010\u0001\u0012\r\n\tCODE_SIZE\u0010\u0002\u0012\u0010\n\fLITE_RUNTIME\u0010\u0003*\t\bè\u0007\u0010\u0002\"¸\u0001\n\u000eMessageOptions\u0012&\n\u0017message_set_wire_format\u0018\u0001 \u0001(\b:\u0005false\u0012.\n\u001fno_standard_descriptor_accessor\u0018\u0002 \u0001(\b:\u0005", "false\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\bè\u0007\u0010\u0002\"¾\u0002\n\fFieldOptions\u0012:\n\u0005ctype\u0018\u0001 \u0001(\u000e2#.google.protobuf.FieldOptions.CType:\u0006STRING\u0012\u000e\n\u0006packed\u0018\u0002 \u0001(\b\u0012\u0013\n\u0004lazy\u0018\u0005 \u0001(\b:\u0005false\u0012\u0019\n\ndeprecated\u0018\u0003 \u0001(\b:\u0005false\u0012\u001c\n\u0014experimental_map_key\u0018\t \u0001(\t\u0012\u0013\n\u0004weak\u0018\n \u0001(\b:\u0005false\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption\"/\n\u0005CType\u0012\n\n\u0006STRING\u0010\u0000\u0012\b\n\u0004CORD\u0010\u0001\u0012\u0010\n\fSTRING_PIECE\u0010\u0002*\t\bè\u0007", "\u0010\u0002\"x\n\u000bEnumOptions\u0012\u0019\n\u000ballow_alias\u0018\u0002 \u0001(\b:\u0004true\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\bè\u0007\u0010\u0002\"b\n\u0010EnumValueOptions\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\bè\u0007\u0010\u0002\"`\n\u000eServiceOptions\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\bè\u0007\u0010\u0002\"_\n\rMethodOptions\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.Uninter", "pretedOption*\t\bè\u0007\u0010\u0002\"\u0002\n\u0013UninterpretedOption\u0012;\n\u0004name\u0018\u0002 \u0003(\u000b2-.google.protobuf.UninterpretedOption.NamePart\u0012\u0018\n\u0010identifier_value\u0018\u0003 \u0001(\t\u0012\u001a\n\u0012positive_int_value\u0018\u0004 \u0001(\u0004\u0012\u001a\n\u0012negative_int_value\u0018\u0005 \u0001(\u0003\u0012\u0014\n\fdouble_value\u0018\u0006 \u0001(\u0001\u0012\u0014\n\fstring_value\u0018\u0007 \u0001(\f\u0012\u0017\n\u000faggregate_value\u0018\b \u0001(\t\u001a3\n\bNamePart\u0012\u0011\n\tname_part\u0018\u0001 \u0002(\t\u0012\u0014\n\fis_extension\u0018\u0002 \u0002(\b\"±\u0001\n\u000eSourceCodeInfo\u0012:\n\blocation\u0018\u0001 \u0003(\u000b2(.google.protobuf.SourceCodeInfo.Location\u001ac\n\bLocat", "ion\u0012\u0010\n\u0004path\u0018\u0001 \u0003(\u0005B\u0002\u0010\u0001\u0012\u0010\n\u0004span\u0018\u0002 \u0003(\u0005B\u0002\u0010\u0001\u0012\u0018\n\u0010leading_comments\u0018\u0003 \u0001(\t\u0012\u0019\n\u0011trailing_comments\u0018\u0004 \u0001(\tB)\n\u0013com.google.protobufB\u0010DescriptorProtosH\u0001"}, new FileDescriptor[0], new C24171());
    }
}

package com.google.protobuf;

import com.google.protobuf.DescriptorProtos.DescriptorProto;
import com.google.protobuf.DescriptorProtos.DescriptorProto.ExtensionRange;
import com.google.protobuf.DescriptorProtos.EnumDescriptorProto;
import com.google.protobuf.DescriptorProtos.EnumValueDescriptorProto;
import com.google.protobuf.DescriptorProtos.FieldDescriptorProto;
import com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Label;
import com.google.protobuf.DescriptorProtos.FileDescriptorProto;
import com.google.protobuf.DescriptorProtos.MessageOptions;
import com.google.protobuf.DescriptorProtos.MethodDescriptorProto;
import com.google.protobuf.DescriptorProtos.ServiceDescriptorProto;
import com.google.protobuf.FieldSet.FieldDescriptorLite;
import com.google.protobuf.Internal.EnumLite;
import com.google.protobuf.Internal.EnumLiteMap;
import com.google.protobuf.MessageLite.Builder;
import com.google.protobuf.WireFormat.FieldType;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: analytics_source_arg */
public final class Descriptors {

    /* compiled from: analytics_source_arg */
    interface GenericDescriptor {
        String mo893a();

        String mo894b();

        FileDescriptor mo895c();

        AbstractMessage mo896h();
    }

    /* compiled from: analytics_source_arg */
    public final class Descriptor implements GenericDescriptor {
        private final int f20831a;
        private DescriptorProto f20832b;
        private final String f20833c;
        private final FileDescriptor f20834d;
        private final Descriptor f20835e;
        private final Descriptor[] f20836f;
        private final EnumDescriptor[] f20837g;
        private final FieldDescriptor[] f20838h;
        private final FieldDescriptor[] f20839i;

        public final AbstractMessage mo896h() {
            return this.f20832b;
        }

        public final String mo893a() {
            return this.f20832b.m20407k();
        }

        public final String mo894b() {
            return this.f20833c;
        }

        public final FileDescriptor mo895c() {
            return this.f20834d;
        }

        public final MessageOptions m21195d() {
            return this.f20832b.options_;
        }

        public final List<FieldDescriptor> m21196e() {
            return Collections.unmodifiableList(Arrays.asList(this.f20838h));
        }

        public final List<Descriptor> m21197f() {
            return Collections.unmodifiableList(Arrays.asList(this.f20836f));
        }

        public final List<EnumDescriptor> m21198g() {
            return Collections.unmodifiableList(Arrays.asList(this.f20837g));
        }

        public final boolean m21191a(int i) {
            for (ExtensionRange extensionRange : this.f20832b.extensionRange_) {
                if (extensionRange.start_ <= i && i < extensionRange.end_) {
                    return true;
                }
            }
            return false;
        }

        public final FieldDescriptor m21192b(int i) {
            return (FieldDescriptor) this.f20834d.f20879h.f20848d.get(new DescriptorIntPair(this, i));
        }

        public Descriptor(DescriptorProto descriptorProto, FileDescriptor fileDescriptor, Descriptor descriptor, int i) {
            int i2;
            this.f20831a = i;
            this.f20832b = descriptorProto;
            this.f20833c = Descriptors.m21264b(fileDescriptor, descriptor, descriptorProto.m20407k());
            this.f20834d = fileDescriptor;
            this.f20835e = descriptor;
            this.f20836f = new Descriptor[descriptorProto.m20410n()];
            for (int i3 = 0; i3 < descriptorProto.m20410n(); i3++) {
                this.f20836f[i3] = new Descriptor(descriptorProto.m20402c(i3), fileDescriptor, this, i3);
            }
            this.f20837g = new EnumDescriptor[descriptorProto.m20411o()];
            for (i2 = 0; i2 < descriptorProto.m20411o(); i2++) {
                this.f20837g[i2] = new EnumDescriptor(descriptorProto.m20403d(i2), fileDescriptor, this, i2);
            }
            this.f20838h = new FieldDescriptor[descriptorProto.m20408l()];
            for (i2 = 0; i2 < descriptorProto.m20408l(); i2++) {
                this.f20838h[i2] = new FieldDescriptor(descriptorProto.m20396a(i2), fileDescriptor, this, i2, false);
            }
            this.f20839i = new FieldDescriptor[descriptorProto.m20409m()];
            for (i2 = 0; i2 < descriptorProto.m20409m(); i2++) {
                this.f20839i[i2] = new FieldDescriptor(descriptorProto.m20401b(i2), fileDescriptor, this, i2, true);
            }
            fileDescriptor.f20879h.m21212a((GenericDescriptor) this);
        }

        public static void m21189j(Descriptor descriptor) {
            int i = 0;
            for (Descriptor j : descriptor.f20836f) {
                m21189j(j);
            }
            for (FieldDescriptor x : descriptor.f20838h) {
                FieldDescriptor.m21226x(x);
            }
            FieldDescriptor[] fieldDescriptorArr = descriptor.f20839i;
            int length = fieldDescriptorArr.length;
            while (i < length) {
                FieldDescriptor.m21226x(fieldDescriptorArr[i]);
                i++;
            }
        }

        public static void m21188a(Descriptor descriptor, DescriptorProto descriptorProto) {
            int i;
            int i2 = 0;
            descriptor.f20832b = descriptorProto;
            for (i = 0; i < descriptor.f20836f.length; i++) {
                m21188a(descriptor.f20836f[i], descriptorProto.m20402c(i));
            }
            for (i = 0; i < descriptor.f20837g.length; i++) {
                EnumDescriptor.m21214a(descriptor.f20837g[i], descriptorProto.m20403d(i));
            }
            for (i = 0; i < descriptor.f20838h.length; i++) {
                descriptor.f20838h[i].f20863c = descriptorProto.m20396a(i);
            }
            while (i2 < descriptor.f20839i.length) {
                descriptor.f20839i[i2].f20863c = descriptorProto.m20401b(i2);
                i2++;
            }
        }
    }

    /* compiled from: analytics_source_arg */
    public final class DescriptorPool {
        static final /* synthetic */ boolean f20845a = (!Descriptors.class.desiredAssertionStatus());
        private final Set<FileDescriptor> f20846b = new HashSet();
        private final Map<String, GenericDescriptor> f20847c = new HashMap();
        public final Map<DescriptorIntPair, FieldDescriptor> f20848d = new HashMap();
        public final Map<DescriptorIntPair, EnumValueDescriptor> f20849e = new HashMap();

        /* compiled from: analytics_source_arg */
        public final class DescriptorIntPair {
            private final GenericDescriptor f20840a;
            private final int f20841b;

            public DescriptorIntPair(GenericDescriptor genericDescriptor, int i) {
                this.f20840a = genericDescriptor;
                this.f20841b = i;
            }

            public final int hashCode() {
                return (this.f20840a.hashCode() * 65535) + this.f20841b;
            }

            public final boolean equals(Object obj) {
                if (!(obj instanceof DescriptorIntPair)) {
                    return false;
                }
                DescriptorIntPair descriptorIntPair = (DescriptorIntPair) obj;
                if (this.f20840a == descriptorIntPair.f20840a && this.f20841b == descriptorIntPair.f20841b) {
                    return true;
                }
                return false;
            }
        }

        /* compiled from: analytics_source_arg */
        final class PackageDescriptor implements GenericDescriptor {
            private final String f20842a;
            private final String f20843b;
            private final FileDescriptor f20844c;

            public final AbstractMessage mo896h() {
                return this.f20844c.f20872a;
            }

            public final String mo893a() {
                return this.f20842a;
            }

            public final String mo894b() {
                return this.f20843b;
            }

            public final FileDescriptor mo895c() {
                return this.f20844c;
            }

            PackageDescriptor(String str, String str2, FileDescriptor fileDescriptor) {
                this.f20844c = fileDescriptor;
                this.f20843b = str2;
                this.f20842a = str;
            }
        }

        /* compiled from: analytics_source_arg */
        enum SearchFilter {
            TYPES_ONLY,
            AGGREGATES_ONLY,
            ALL_SYMBOLS
        }

        private void m21205a(FileDescriptor fileDescriptor) {
            for (FileDescriptor fileDescriptor2 : Collections.unmodifiableList(Arrays.asList(fileDescriptor.f20878g))) {
                if (this.f20846b.add(fileDescriptor2)) {
                    m21205a(fileDescriptor2);
                }
            }
        }

        DescriptorPool(FileDescriptor[] fileDescriptorArr) {
            for (int i = 0; i < fileDescriptorArr.length; i++) {
                this.f20846b.add(fileDescriptorArr[i]);
                m21205a(fileDescriptorArr[i]);
            }
            for (FileDescriptor fileDescriptor : this.f20846b) {
                try {
                    m21213a(fileDescriptor.m21253c(), fileDescriptor);
                } catch (DescriptorValidationException e) {
                    if (!f20845a) {
                        throw new AssertionError();
                    }
                }
            }
        }

        final GenericDescriptor m21209a(String str) {
            return m21204a(str, SearchFilter.ALL_SYMBOLS);
        }

        private GenericDescriptor m21204a(String str, SearchFilter searchFilter) {
            GenericDescriptor genericDescriptor = (GenericDescriptor) this.f20847c.get(str);
            if (genericDescriptor != null) {
                if (searchFilter == SearchFilter.ALL_SYMBOLS) {
                    return genericDescriptor;
                }
                if (searchFilter == SearchFilter.TYPES_ONLY && m21206b(genericDescriptor)) {
                    return genericDescriptor;
                }
                if (searchFilter == SearchFilter.AGGREGATES_ONLY && m21207c(genericDescriptor)) {
                    return genericDescriptor;
                }
            }
            for (FileDescriptor fileDescriptor : this.f20846b) {
                genericDescriptor = (GenericDescriptor) fileDescriptor.f20879h.f20847c.get(str);
                if (genericDescriptor != null) {
                    if (searchFilter == SearchFilter.ALL_SYMBOLS) {
                        return genericDescriptor;
                    }
                    if (searchFilter == SearchFilter.TYPES_ONLY && m21206b(genericDescriptor)) {
                        return genericDescriptor;
                    }
                    if (searchFilter == SearchFilter.AGGREGATES_ONLY && m21207c(genericDescriptor)) {
                        return genericDescriptor;
                    }
                }
            }
            return null;
        }

        private static boolean m21206b(GenericDescriptor genericDescriptor) {
            return (genericDescriptor instanceof Descriptor) || (genericDescriptor instanceof EnumDescriptor);
        }

        private static boolean m21207c(GenericDescriptor genericDescriptor) {
            return (genericDescriptor instanceof Descriptor) || (genericDescriptor instanceof EnumDescriptor) || (genericDescriptor instanceof PackageDescriptor) || (genericDescriptor instanceof ServiceDescriptor);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        final com.google.protobuf.Descriptors.GenericDescriptor m21210a(java.lang.String r9, com.google.protobuf.Descriptors.GenericDescriptor r10, com.google.protobuf.Descriptors.DescriptorPool.SearchFilter r11) {
            /*
            r8 = this;
            r7 = 0;
            r6 = -1;
            r0 = ".";
            r0 = r9.startsWith(r0);
            if (r0 == 0) goto L_0x0030;
        L_0x000a:
            r0 = 1;
            r0 = r9.substring(r0);
            r0 = r8.m21204a(r0, r11);
        L_0x0013:
            if (r0 != 0) goto L_0x007f;
        L_0x0015:
            r0 = new com.google.protobuf.Descriptors$DescriptorValidationException;
            r1 = new java.lang.StringBuilder;
            r2 = "\"";
            r1.<init>(r2);
            r1 = r1.append(r9);
            r2 = "\" is not defined.";
            r1 = r1.append(r2);
            r1 = r1.toString();
            r0.<init>(r10, r1);
            throw r0;
        L_0x0030:
            r0 = 46;
            r2 = r9.indexOf(r0);
            if (r2 != r6) goto L_0x004f;
        L_0x0038:
            r0 = r9;
        L_0x0039:
            r3 = new java.lang.StringBuilder;
            r1 = r10.mo894b();
            r3.<init>(r1);
        L_0x0042:
            r1 = ".";
            r4 = r3.lastIndexOf(r1);
            if (r4 != r6) goto L_0x0054;
        L_0x004a:
            r0 = r8.m21204a(r9, r11);
            goto L_0x0013;
        L_0x004f:
            r0 = r9.substring(r7, r2);
            goto L_0x0039;
        L_0x0054:
            r1 = r4 + 1;
            r3.setLength(r1);
            r3.append(r0);
            r1 = r3.toString();
            r5 = com.google.protobuf.Descriptors.DescriptorPool.SearchFilter.AGGREGATES_ONLY;
            r1 = r8.m21204a(r1, r5);
            if (r1 == 0) goto L_0x007b;
        L_0x0068:
            if (r2 == r6) goto L_0x0080;
        L_0x006a:
            r0 = r4 + 1;
            r3.setLength(r0);
            r3.append(r9);
            r0 = r3.toString();
            r0 = r8.m21204a(r0, r11);
            goto L_0x0013;
        L_0x007b:
            r3.setLength(r4);
            goto L_0x0042;
        L_0x007f:
            return r0;
        L_0x0080:
            r0 = r1;
            goto L_0x0013;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Descriptors.DescriptorPool.a(java.lang.String, com.google.protobuf.Descriptors$GenericDescriptor, com.google.protobuf.Descriptors$DescriptorPool$SearchFilter):com.google.protobuf.Descriptors$GenericDescriptor");
        }

        final void m21212a(GenericDescriptor genericDescriptor) {
            m21208d(genericDescriptor);
            String b = genericDescriptor.mo894b();
            int lastIndexOf = b.lastIndexOf(46);
            GenericDescriptor genericDescriptor2 = (GenericDescriptor) this.f20847c.put(b, genericDescriptor);
            if (genericDescriptor2 != null) {
                this.f20847c.put(b, genericDescriptor2);
                if (genericDescriptor.mo895c() != genericDescriptor2.mo895c()) {
                    throw new DescriptorValidationException(genericDescriptor, "\"" + b + "\" is already defined in file \"" + genericDescriptor2.mo895c().m21252b() + "\".");
                } else if (lastIndexOf == -1) {
                    throw new DescriptorValidationException(genericDescriptor, "\"" + b + "\" is already defined.");
                } else {
                    throw new DescriptorValidationException(genericDescriptor, "\"" + b.substring(lastIndexOf + 1) + "\" is already defined in \"" + b.substring(0, lastIndexOf) + "\".");
                }
            }
        }

        final void m21213a(String str, FileDescriptor fileDescriptor) {
            String str2;
            int lastIndexOf = str.lastIndexOf(46);
            if (lastIndexOf == -1) {
                str2 = str;
            } else {
                m21213a(str.substring(0, lastIndexOf), fileDescriptor);
                str2 = str.substring(lastIndexOf + 1);
            }
            GenericDescriptor genericDescriptor = (GenericDescriptor) this.f20847c.put(str, new PackageDescriptor(str2, str, fileDescriptor));
            if (genericDescriptor != null) {
                this.f20847c.put(str, genericDescriptor);
                if (!(genericDescriptor instanceof PackageDescriptor)) {
                    throw new DescriptorValidationException(fileDescriptor, "\"" + str2 + "\" is already defined (as something other than a package) in file \"" + genericDescriptor.mo895c().m21252b() + "\".");
                }
            }
        }

        final void m21211a(FieldDescriptor fieldDescriptor) {
            DescriptorIntPair descriptorIntPair = new DescriptorIntPair(fieldDescriptor.f20868h, fieldDescriptor.m21231e());
            FieldDescriptor fieldDescriptor2 = (FieldDescriptor) this.f20848d.put(descriptorIntPair, fieldDescriptor);
            if (fieldDescriptor2 != null) {
                this.f20848d.put(descriptorIntPair, fieldDescriptor2);
                throw new DescriptorValidationException((GenericDescriptor) fieldDescriptor, "Field number " + fieldDescriptor.m21231e() + "has already been used in \"" + fieldDescriptor.f20868h.mo894b() + "\" by field \"" + fieldDescriptor2.mo893a() + "\".");
            }
        }

        private static void m21208d(GenericDescriptor genericDescriptor) {
            String a = genericDescriptor.mo893a();
            if (a.length() == 0) {
                throw new DescriptorValidationException(genericDescriptor, "Missing name.");
            }
            Object obj = 1;
            int i = 0;
            while (i < a.length()) {
                char charAt = a.charAt(i);
                if (charAt >= '') {
                    obj = null;
                }
                if (!(Character.isLetter(charAt) || charAt == '_' || (Character.isDigit(charAt) && i > 0))) {
                    obj = null;
                }
                i++;
            }
            if (obj == null) {
                throw new DescriptorValidationException(genericDescriptor, "\"" + a + "\" is not a valid identifier.");
            }
        }
    }

    /* compiled from: analytics_source_arg */
    public class DescriptorValidationException extends Exception {
        private final String description;
        private final String name;
        private final AbstractMessage proto;

        public DescriptorValidationException(GenericDescriptor genericDescriptor, String str) {
            super(genericDescriptor.mo894b() + ": " + str);
            this.name = genericDescriptor.mo894b();
            this.proto = genericDescriptor.mo896h();
            this.description = str;
        }

        public DescriptorValidationException(GenericDescriptor genericDescriptor, String str, Throwable th) {
            this(genericDescriptor, str);
            initCause(th);
        }

        public DescriptorValidationException(FileDescriptor fileDescriptor, String str) {
            super(fileDescriptor.m21252b() + ": " + str);
            this.name = fileDescriptor.m21252b();
            this.proto = fileDescriptor.f20872a;
            this.description = str;
        }
    }

    /* compiled from: analytics_source_arg */
    public final class EnumDescriptor implements GenericDescriptor, EnumLiteMap<EnumValueDescriptor> {
        private final int f20850a;
        private EnumDescriptorProto f20851b;
        private final String f20852c;
        private final FileDescriptor f20853d;
        private final Descriptor f20854e;
        private EnumValueDescriptor[] f20855f;

        public final AbstractMessage mo896h() {
            return this.f20851b;
        }

        public final String mo893a() {
            return this.f20851b.m20454k();
        }

        public final String mo894b() {
            return this.f20852c;
        }

        public final FileDescriptor mo895c() {
            return this.f20853d;
        }

        public final List<EnumValueDescriptor> m21220d() {
            return Collections.unmodifiableList(Arrays.asList(this.f20855f));
        }

        public final EnumValueDescriptor m21216a(String str) {
            GenericDescriptor a = this.f20853d.f20879h.m21209a(this.f20852c + '.' + str);
            if (a == null || !(a instanceof EnumValueDescriptor)) {
                return null;
            }
            return (EnumValueDescriptor) a;
        }

        public final EnumValueDescriptor m21215a(int i) {
            return (EnumValueDescriptor) this.f20853d.f20879h.f20849e.get(new DescriptorIntPair(this, i));
        }

        public EnumDescriptor(EnumDescriptorProto enumDescriptorProto, FileDescriptor fileDescriptor, Descriptor descriptor, int i) {
            this.f20850a = i;
            this.f20851b = enumDescriptorProto;
            this.f20852c = Descriptors.m21264b(fileDescriptor, descriptor, enumDescriptorProto.m20454k());
            this.f20853d = fileDescriptor;
            this.f20854e = descriptor;
            if (enumDescriptorProto.m20455l() == 0) {
                throw new DescriptorValidationException((GenericDescriptor) this, "Enums must contain at least one value.");
            }
            this.f20855f = new EnumValueDescriptor[enumDescriptorProto.m20455l()];
            for (int i2 = 0; i2 < enumDescriptorProto.m20455l(); i2++) {
                this.f20855f[i2] = new EnumValueDescriptor(enumDescriptorProto.m20446a(i2), fileDescriptor, this, i2);
            }
            fileDescriptor.f20879h.m21212a((GenericDescriptor) this);
        }

        public static void m21214a(EnumDescriptor enumDescriptor, EnumDescriptorProto enumDescriptorProto) {
            enumDescriptor.f20851b = enumDescriptorProto;
            for (int i = 0; i < enumDescriptor.f20855f.length; i++) {
                enumDescriptor.f20855f[i].f20857b = enumDescriptorProto.m20446a(i);
            }
        }
    }

    /* compiled from: analytics_source_arg */
    public final class EnumValueDescriptor implements GenericDescriptor, EnumLite {
        public final int f20856a;
        public EnumValueDescriptorProto f20857b;
        private final String f20858c;
        private final FileDescriptor f20859d;
        public final EnumDescriptor f20860e;

        public final AbstractMessage mo896h() {
            return this.f20857b;
        }

        public final String mo893a() {
            return this.f20857b.m20563k();
        }

        public final int getNumber() {
            return this.f20857b.number_;
        }

        public final String mo894b() {
            return this.f20858c;
        }

        public final FileDescriptor mo895c() {
            return this.f20859d;
        }

        public EnumValueDescriptor(EnumValueDescriptorProto enumValueDescriptorProto, FileDescriptor fileDescriptor, EnumDescriptor enumDescriptor, int i) {
            this.f20856a = i;
            this.f20857b = enumValueDescriptorProto;
            this.f20859d = fileDescriptor;
            this.f20860e = enumDescriptor;
            this.f20858c = enumDescriptor.mo894b() + '.' + enumValueDescriptorProto.m20563k();
            fileDescriptor.f20879h.m21212a((GenericDescriptor) this);
            DescriptorPool descriptorPool = fileDescriptor.f20879h;
            DescriptorIntPair descriptorIntPair = new DescriptorIntPair(this.f20860e, getNumber());
            EnumValueDescriptor enumValueDescriptor = (EnumValueDescriptor) descriptorPool.f20849e.put(descriptorIntPair, this);
            if (enumValueDescriptor != null) {
                descriptorPool.f20849e.put(descriptorIntPair, enumValueDescriptor);
            }
        }
    }

    /* compiled from: analytics_source_arg */
    public final class FieldDescriptor implements GenericDescriptor, FieldDescriptorLite<FieldDescriptor> {
        private static final FieldType[] f20861a = FieldType.values();
        public final int f20862b;
        public FieldDescriptorProto f20863c;
        private final String f20864d;
        private final FileDescriptor f20865e;
        private final Descriptor f20866f;
        public Type f20867g;
        public Descriptor f20868h;
        private Descriptor f20869i;
        private EnumDescriptor f20870j;
        private Object f20871k;

        /* compiled from: analytics_source_arg */
        public enum JavaType {
            INT(Integer.valueOf(0)),
            LONG(Long.valueOf(0)),
            FLOAT(Float.valueOf(0.0f)),
            DOUBLE(Double.valueOf(0.0d)),
            BOOLEAN(Boolean.valueOf(false)),
            STRING(""),
            BYTE_STRING(ByteString.f20600a),
            ENUM(null),
            MESSAGE(null);
            
            public final Object defaultDefault;

            private JavaType(Object obj) {
                this.defaultDefault = obj;
            }
        }

        /* compiled from: analytics_source_arg */
        public enum Type {
            DOUBLE(JavaType.DOUBLE),
            FLOAT(JavaType.FLOAT),
            INT64(JavaType.LONG),
            UINT64(JavaType.LONG),
            INT32(JavaType.INT),
            FIXED64(JavaType.LONG),
            FIXED32(JavaType.INT),
            BOOL(JavaType.BOOLEAN),
            STRING(JavaType.STRING),
            GROUP(JavaType.MESSAGE),
            MESSAGE(JavaType.MESSAGE),
            BYTES(JavaType.BYTE_STRING),
            UINT32(JavaType.INT),
            ENUM(JavaType.ENUM),
            SFIXED32(JavaType.INT),
            SFIXED64(JavaType.LONG),
            SINT32(JavaType.INT),
            SINT64(JavaType.LONG);
            
            private JavaType javaType;

            private Type(JavaType javaType) {
                this.javaType = javaType;
            }

            public final com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type toProto() {
                return com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type.valueOf(ordinal() + 1);
            }

            public final JavaType getJavaType() {
                return this.javaType;
            }

            public static Type valueOf(com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type type) {
                return values()[type.getNumber() - 1];
            }
        }

        public final int compareTo(Object obj) {
            FieldDescriptor fieldDescriptor = (FieldDescriptor) obj;
            if (fieldDescriptor.f20868h == this.f20868h) {
                return m21231e() - fieldDescriptor.m21231e();
            }
            throw new IllegalArgumentException("FieldDescriptors can only be compared to other FieldDescriptors for fields of the same message type.");
        }

        public final AbstractMessage mo896h() {
            return this.f20863c;
        }

        public final String mo893a() {
            return this.f20863c.m20653l();
        }

        public final int m21231e() {
            return this.f20863c.number_;
        }

        public final String mo894b() {
            return this.f20864d;
        }

        public final JavaType m21232f() {
            return this.f20867g.getJavaType();
        }

        public final com.google.protobuf.WireFormat.JavaType m21233g() {
            return m21236j().getJavaType();
        }

        public final FileDescriptor mo895c() {
            return this.f20865e;
        }

        public final Type m21235i() {
            return this.f20867g;
        }

        public final FieldType m21236j() {
            return f20861a[this.f20867g.ordinal()];
        }

        static {
            if (Type.values().length != com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type.values().length) {
                throw new RuntimeException("descriptor.proto has a new declared type but Desrciptors.java wasn't updated.");
            }
        }

        public final boolean m21237k() {
            return this.f20863c.label_ == Label.LABEL_REQUIRED;
        }

        public final boolean m21238l() {
            return this.f20863c.label_ == Label.LABEL_OPTIONAL;
        }

        public final boolean m21239m() {
            return this.f20863c.label_ == Label.LABEL_REPEATED;
        }

        public final boolean m21241o() {
            return m21239m() && m21236j().isPackable();
        }

        public final Object m21242p() {
            if (m21232f() != JavaType.MESSAGE) {
                return this.f20871k;
            }
            throw new UnsupportedOperationException("FieldDescriptor.getDefaultValue() called on an embedded message field.");
        }

        public final boolean m21240n() {
            return this.f20863c.options_.packed_;
        }

        public final boolean m21243q() {
            return this.f20863c.m20661y();
        }

        public final Descriptor m21244r() {
            return this.f20868h;
        }

        public final Descriptor m21245s() {
            if (m21243q()) {
                return this.f20866f;
            }
            throw new UnsupportedOperationException("This field is not an extension.");
        }

        public final Descriptor m21246t() {
            if (m21232f() == JavaType.MESSAGE) {
                return this.f20869i;
            }
            throw new UnsupportedOperationException("This field is not of message type.");
        }

        public final EnumDescriptor m21247u() {
            if (m21232f() == JavaType.ENUM) {
                return this.f20870j;
            }
            throw new UnsupportedOperationException("This field is not of enum type.");
        }

        private FieldDescriptor(FieldDescriptorProto fieldDescriptorProto, FileDescriptor fileDescriptor, Descriptor descriptor, int i, boolean z) {
            this.f20862b = i;
            this.f20863c = fieldDescriptorProto;
            this.f20864d = Descriptors.m21264b(fileDescriptor, descriptor, fieldDescriptorProto.m20653l());
            this.f20865e = fileDescriptor;
            if (fieldDescriptorProto.m20654q()) {
                this.f20867g = Type.valueOf(fieldDescriptorProto.type_);
            }
            if (m21231e() <= 0) {
                throw new DescriptorValidationException((GenericDescriptor) this, "Field numbers must be positive integers.");
            } else if (!fieldDescriptorProto.options_.packed_ || m21241o()) {
                if (z) {
                    if (fieldDescriptorProto.m20661y()) {
                        this.f20868h = null;
                        if (descriptor != null) {
                            this.f20866f = descriptor;
                        } else {
                            this.f20866f = null;
                        }
                    } else {
                        throw new DescriptorValidationException((GenericDescriptor) this, "FieldDescriptorProto.extendee not set for extension field.");
                    }
                } else if (fieldDescriptorProto.m20661y()) {
                    throw new DescriptorValidationException((GenericDescriptor) this, "FieldDescriptorProto.extendee set for non-extension field.");
                } else {
                    this.f20868h = descriptor;
                    this.f20866f = null;
                }
                fileDescriptor.f20879h.m21212a((GenericDescriptor) this);
            } else {
                throw new DescriptorValidationException((GenericDescriptor) this, "[packed = true] can only be specified for repeated primitive fields.");
            }
        }

        public static void m21226x(FieldDescriptor fieldDescriptor) {
            GenericDescriptor a;
            if (fieldDescriptor.f20863c.m20661y()) {
                a = fieldDescriptor.f20865e.f20879h.m21210a(fieldDescriptor.f20863c.m20662z(), fieldDescriptor, SearchFilter.TYPES_ONLY);
                if (a instanceof Descriptor) {
                    fieldDescriptor.f20868h = (Descriptor) a;
                    if (!fieldDescriptor.m21244r().m21191a(fieldDescriptor.m21231e())) {
                        throw new DescriptorValidationException((GenericDescriptor) fieldDescriptor, "\"" + fieldDescriptor.m21244r().mo894b() + "\" does not declare " + fieldDescriptor.m21231e() + " as an extension number.");
                    }
                }
                throw new DescriptorValidationException((GenericDescriptor) fieldDescriptor, "\"" + fieldDescriptor.f20863c.m20662z() + "\" is not a message type.");
            }
            if (fieldDescriptor.f20863c.m20659w()) {
                a = fieldDescriptor.f20865e.f20879h.m21210a(fieldDescriptor.f20863c.m20660x(), fieldDescriptor, SearchFilter.TYPES_ONLY);
                if (!fieldDescriptor.f20863c.m20654q()) {
                    if (a instanceof Descriptor) {
                        fieldDescriptor.f20867g = Type.MESSAGE;
                    } else if (a instanceof EnumDescriptor) {
                        fieldDescriptor.f20867g = Type.ENUM;
                    } else {
                        throw new DescriptorValidationException((GenericDescriptor) fieldDescriptor, "\"" + fieldDescriptor.f20863c.m20660x() + "\" is not a type.");
                    }
                }
                if (fieldDescriptor.m21232f() == JavaType.MESSAGE) {
                    if (a instanceof Descriptor) {
                        fieldDescriptor.f20869i = (Descriptor) a;
                        if (fieldDescriptor.f20863c.m20643A()) {
                            throw new DescriptorValidationException((GenericDescriptor) fieldDescriptor, "Messages can't have default values.");
                        }
                    }
                    throw new DescriptorValidationException((GenericDescriptor) fieldDescriptor, "\"" + fieldDescriptor.f20863c.m20660x() + "\" is not a message type.");
                } else if (fieldDescriptor.m21232f() != JavaType.ENUM) {
                    throw new DescriptorValidationException((GenericDescriptor) fieldDescriptor, "Field with primitive type has type_name.");
                } else if (a instanceof EnumDescriptor) {
                    fieldDescriptor.f20870j = (EnumDescriptor) a;
                } else {
                    throw new DescriptorValidationException((GenericDescriptor) fieldDescriptor, "\"" + fieldDescriptor.f20863c.m20660x() + "\" is not an enum type.");
                }
            } else if (fieldDescriptor.m21232f() == JavaType.MESSAGE || fieldDescriptor.m21232f() == JavaType.ENUM) {
                throw new DescriptorValidationException((GenericDescriptor) fieldDescriptor, "Field with message or enum type missing type_name.");
            }
            if (!fieldDescriptor.f20863c.m20643A()) {
                if (!fieldDescriptor.m21239m()) {
                    switch (fieldDescriptor.m21232f()) {
                        case ENUM:
                            fieldDescriptor.f20871k = fieldDescriptor.f20870j.m21220d().get(0);
                            break;
                        case MESSAGE:
                            fieldDescriptor.f20871k = null;
                            break;
                        default:
                            fieldDescriptor.f20871k = fieldDescriptor.m21232f().defaultDefault;
                            break;
                    }
                }
                fieldDescriptor.f20871k = Collections.emptyList();
            } else if (fieldDescriptor.m21239m()) {
                throw new DescriptorValidationException((GenericDescriptor) fieldDescriptor, "Repeated fields cannot have default values.");
            } else {
                try {
                    switch (fieldDescriptor.m21235i()) {
                        case INT32:
                        case SINT32:
                        case SFIXED32:
                            fieldDescriptor.f20871k = Integer.valueOf(TextFormat.m21476b(fieldDescriptor.f20863c.m20644B()));
                            break;
                        case UINT32:
                        case FIXED32:
                            fieldDescriptor.f20871k = Integer.valueOf(TextFormat.m21481c(fieldDescriptor.f20863c.m20644B()));
                            break;
                        case INT64:
                        case SINT64:
                        case SFIXED64:
                            fieldDescriptor.f20871k = Long.valueOf(TextFormat.m21482d(fieldDescriptor.f20863c.m20644B()));
                            break;
                        case UINT64:
                        case FIXED64:
                            fieldDescriptor.f20871k = Long.valueOf(TextFormat.m21483e(fieldDescriptor.f20863c.m20644B()));
                            break;
                        case FLOAT:
                            if (!fieldDescriptor.f20863c.m20644B().equals("inf")) {
                                if (!fieldDescriptor.f20863c.m20644B().equals("-inf")) {
                                    if (!fieldDescriptor.f20863c.m20644B().equals("nan")) {
                                        fieldDescriptor.f20871k = Float.valueOf(fieldDescriptor.f20863c.m20644B());
                                        break;
                                    } else {
                                        fieldDescriptor.f20871k = Float.valueOf(Float.NaN);
                                        break;
                                    }
                                }
                                fieldDescriptor.f20871k = Float.valueOf(Float.NEGATIVE_INFINITY);
                                break;
                            }
                            fieldDescriptor.f20871k = Float.valueOf(Float.POSITIVE_INFINITY);
                            break;
                        case DOUBLE:
                            if (!fieldDescriptor.f20863c.m20644B().equals("inf")) {
                                if (!fieldDescriptor.f20863c.m20644B().equals("-inf")) {
                                    if (!fieldDescriptor.f20863c.m20644B().equals("nan")) {
                                        fieldDescriptor.f20871k = Double.valueOf(fieldDescriptor.f20863c.m20644B());
                                        break;
                                    } else {
                                        fieldDescriptor.f20871k = Double.valueOf(Double.NaN);
                                        break;
                                    }
                                }
                                fieldDescriptor.f20871k = Double.valueOf(Double.NEGATIVE_INFINITY);
                                break;
                            }
                            fieldDescriptor.f20871k = Double.valueOf(Double.POSITIVE_INFINITY);
                            break;
                        case BOOL:
                            fieldDescriptor.f20871k = Boolean.valueOf(fieldDescriptor.f20863c.m20644B());
                            break;
                        case STRING:
                            fieldDescriptor.f20871k = fieldDescriptor.f20863c.m20644B();
                            break;
                        case BYTES:
                            try {
                                fieldDescriptor.f20871k = TextFormat.m21469a(fieldDescriptor.f20863c.m20644B());
                                break;
                            } catch (Throwable e) {
                                throw new DescriptorValidationException(fieldDescriptor, "Couldn't parse default value: " + e.getMessage(), e);
                            }
                        case ENUM:
                            fieldDescriptor.f20871k = fieldDescriptor.f20870j.m21216a(fieldDescriptor.f20863c.m20644B());
                            if (fieldDescriptor.f20871k == null) {
                                throw new DescriptorValidationException((GenericDescriptor) fieldDescriptor, "Unknown enum default value: \"" + fieldDescriptor.f20863c.m20644B() + '\"');
                            }
                            break;
                        case MESSAGE:
                        case GROUP:
                            throw new DescriptorValidationException((GenericDescriptor) fieldDescriptor, "Message type had default value.");
                    }
                } catch (Throwable e2) {
                    throw new DescriptorValidationException(fieldDescriptor, "Could not parse default value: \"" + fieldDescriptor.f20863c.m20644B() + '\"', e2);
                }
            }
            if (!fieldDescriptor.m21243q()) {
                fieldDescriptor.f20865e.f20879h.m21211a(fieldDescriptor);
            }
            if (fieldDescriptor.f20868h != null && fieldDescriptor.f20868h.m21195d().m20846k()) {
                if (!fieldDescriptor.m21243q()) {
                    throw new DescriptorValidationException((GenericDescriptor) fieldDescriptor, "MessageSets cannot have fields, only extensions.");
                } else if (!fieldDescriptor.m21238l() || fieldDescriptor.m21235i() != Type.MESSAGE) {
                    throw new DescriptorValidationException((GenericDescriptor) fieldDescriptor, "Extensions of MessageSets must be optional messages.");
                }
            }
        }

        public final Builder m21227a(Builder builder, MessageLite messageLite) {
            return ((Message$Builder) builder).mo849c((AbstractMessage) messageLite);
        }
    }

    /* compiled from: analytics_source_arg */
    public final class FileDescriptor {
        public FileDescriptorProto f20872a;
        private final Descriptor[] f20873b;
        private final EnumDescriptor[] f20874c;
        private final ServiceDescriptor[] f20875d;
        private final FieldDescriptor[] f20876e;
        private final FileDescriptor[] f20877f;
        public final FileDescriptor[] f20878g;
        public final DescriptorPool f20879h;

        /* compiled from: analytics_source_arg */
        public interface InternalDescriptorAssigner {
            ExtensionRegistry mo858a(FileDescriptor fileDescriptor);
        }

        public final String m21252b() {
            return this.f20872a.m20753k();
        }

        public final String m21253c() {
            String str;
            FileDescriptorProto fileDescriptorProto = this.f20872a;
            Object obj = fileDescriptorProto.package_;
            if (obj instanceof String) {
                str = (String) obj;
            } else {
                ByteString byteString = (ByteString) obj;
                String e = byteString.m20186e();
                if (byteString.mo916f()) {
                    fileDescriptorProto.package_ = e;
                }
                str = e;
            }
            return str;
        }

        public final List<Descriptor> m21254d() {
            return Collections.unmodifiableList(Arrays.asList(this.f20873b));
        }

        private static FileDescriptor m21248a(FileDescriptorProto fileDescriptorProto, FileDescriptor[] fileDescriptorArr) {
            FileDescriptor fileDescriptor = new FileDescriptor(fileDescriptorProto, fileDescriptorArr, new DescriptorPool(fileDescriptorArr));
            if (fileDescriptorArr.length != fileDescriptorProto.m20754n()) {
                throw new DescriptorValidationException(fileDescriptor, "Dependencies passed to FileDescriptor.buildFrom() don't match those listed in the FileDescriptorProto.");
            }
            int i = 0;
            while (i < fileDescriptorProto.m20754n()) {
                if (fileDescriptorArr[i].m21252b().equals((String) fileDescriptorProto.dependency_.get(i))) {
                    i++;
                } else {
                    throw new DescriptorValidationException(fileDescriptor, "Dependencies passed to FileDescriptor.buildFrom() don't match those listed in the FileDescriptorProto.");
                }
            }
            fileDescriptor.m21251f();
            return fileDescriptor;
        }

        public static void m21250a(String[] strArr, FileDescriptor[] fileDescriptorArr, InternalDescriptorAssigner internalDescriptorAssigner) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String append : strArr) {
                stringBuilder.append(append);
            }
            try {
                byte[] bytes = stringBuilder.toString().getBytes("ISO-8859-1");
                try {
                    try {
                        FileDescriptor a = m21248a(FileDescriptorProto.m20738a(bytes), fileDescriptorArr);
                        ExtensionRegistryLite a2 = internalDescriptorAssigner.mo858a(a);
                        if (a2 != null) {
                            try {
                                a.m21249a(FileDescriptorProto.m20739a(bytes, a2));
                            } catch (Throwable e) {
                                throw new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", e);
                            }
                        }
                    } catch (Throwable e2) {
                        throw new IllegalArgumentException("Invalid embedded descriptor for \"" + r1.m20753k() + "\".", e2);
                    }
                } catch (Throwable e22) {
                    throw new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", e22);
                }
            } catch (Throwable e222) {
                throw new RuntimeException("Standard encoding ISO-8859-1 not supported by JVM.", e222);
            }
        }

        private FileDescriptor(FileDescriptorProto fileDescriptorProto, FileDescriptor[] fileDescriptorArr, DescriptorPool descriptorPool) {
            int i;
            int i2;
            this.f20879h = descriptorPool;
            this.f20872a = fileDescriptorProto;
            this.f20877f = (FileDescriptor[]) fileDescriptorArr.clone();
            this.f20878g = new FileDescriptor[fileDescriptorProto.m20755o()];
            for (i = 0; i < fileDescriptorProto.m20755o(); i++) {
                int b = fileDescriptorProto.m20745b(i);
                if (b < 0 || b >= this.f20877f.length) {
                    throw new DescriptorValidationException(this, "Invalid public dependency index.");
                }
                this.f20878g[i] = this.f20877f[fileDescriptorProto.m20745b(i)];
            }
            descriptorPool.m21213a(m21253c(), this);
            this.f20873b = new Descriptor[fileDescriptorProto.m20756p()];
            for (i2 = 0; i2 < fileDescriptorProto.m20756p(); i2++) {
                this.f20873b[i2] = new Descriptor(fileDescriptorProto.m20746c(i2), this, null, i2);
            }
            this.f20874c = new EnumDescriptor[fileDescriptorProto.m20757q()];
            for (i2 = 0; i2 < fileDescriptorProto.m20757q(); i2++) {
                this.f20874c[i2] = new EnumDescriptor(fileDescriptorProto.m20747d(i2), this, null, i2);
            }
            this.f20875d = new ServiceDescriptor[fileDescriptorProto.m20758r()];
            for (i = 0; i < fileDescriptorProto.m20758r(); i++) {
                this.f20875d[i] = new ServiceDescriptor(fileDescriptorProto.m20748e(i), this, i);
            }
            this.f20876e = new FieldDescriptor[fileDescriptorProto.m20763w()];
            for (i2 = 0; i2 < fileDescriptorProto.m20763w(); i2++) {
                this.f20876e[i2] = new FieldDescriptor(fileDescriptorProto.m20749f(i2), this, null, i2, true);
            }
        }

        private void m21251f() {
            int i = 0;
            for (Descriptor j : this.f20873b) {
                Descriptor.m21189j(j);
            }
            for (ServiceDescriptor serviceDescriptor : this.f20875d) {
                for (MethodDescriptor e : serviceDescriptor.f20891e) {
                    MethodDescriptor.m21255e(e);
                }
            }
            FieldDescriptor[] fieldDescriptorArr = this.f20876e;
            int length = fieldDescriptorArr.length;
            while (i < length) {
                FieldDescriptor.m21226x(fieldDescriptorArr[i]);
                i++;
            }
        }

        private void m21249a(FileDescriptorProto fileDescriptorProto) {
            int i;
            int i2 = 0;
            this.f20872a = fileDescriptorProto;
            for (i = 0; i < this.f20873b.length; i++) {
                Descriptor.m21188a(this.f20873b[i], fileDescriptorProto.m20746c(i));
            }
            for (i = 0; i < this.f20874c.length; i++) {
                EnumDescriptor.m21214a(this.f20874c[i], fileDescriptorProto.m20747d(i));
            }
            for (i = 0; i < this.f20875d.length; i++) {
                ServiceDescriptor serviceDescriptor = this.f20875d[i];
                ServiceDescriptorProto e = fileDescriptorProto.m20748e(i);
                serviceDescriptor.f20888b = e;
                for (int i3 = 0; i3 < serviceDescriptor.f20891e.length; i3++) {
                    serviceDescriptor.f20891e[i3].f20881b = e.m20967a(i3);
                }
            }
            while (i2 < this.f20876e.length) {
                this.f20876e[i2].f20863c = fileDescriptorProto.m20749f(i2);
                i2++;
            }
        }
    }

    /* compiled from: analytics_source_arg */
    public final class MethodDescriptor implements GenericDescriptor {
        private final int f20880a;
        public MethodDescriptorProto f20881b;
        private final String f20882c;
        private final FileDescriptor f20883d;
        private final ServiceDescriptor f20884e;
        private Descriptor f20885f;
        private Descriptor f20886g;

        public final AbstractMessage mo896h() {
            return this.f20881b;
        }

        public final String mo893a() {
            return this.f20881b.m20889k();
        }

        public final String mo894b() {
            return this.f20882c;
        }

        public final FileDescriptor mo895c() {
            return this.f20883d;
        }

        public MethodDescriptor(MethodDescriptorProto methodDescriptorProto, FileDescriptor fileDescriptor, ServiceDescriptor serviceDescriptor, int i) {
            this.f20880a = i;
            this.f20881b = methodDescriptorProto;
            this.f20883d = fileDescriptor;
            this.f20884e = serviceDescriptor;
            this.f20882c = serviceDescriptor.mo894b() + '.' + methodDescriptorProto.m20889k();
            fileDescriptor.f20879h.m21212a((GenericDescriptor) this);
        }

        public static void m21255e(MethodDescriptor methodDescriptor) {
            GenericDescriptor a = methodDescriptor.f20883d.f20879h.m21210a(methodDescriptor.f20881b.m20890m(), methodDescriptor, SearchFilter.TYPES_ONLY);
            if (a instanceof Descriptor) {
                methodDescriptor.f20885f = (Descriptor) a;
                a = methodDescriptor.f20883d.f20879h.m21210a(methodDescriptor.f20881b.m20891o(), methodDescriptor, SearchFilter.TYPES_ONLY);
                if (a instanceof Descriptor) {
                    methodDescriptor.f20886g = (Descriptor) a;
                    return;
                }
                throw new DescriptorValidationException((GenericDescriptor) methodDescriptor, "\"" + methodDescriptor.f20881b.m20891o() + "\" is not a message type.");
            }
            throw new DescriptorValidationException((GenericDescriptor) methodDescriptor, "\"" + methodDescriptor.f20881b.m20890m() + "\" is not a message type.");
        }
    }

    /* compiled from: analytics_source_arg */
    public final class ServiceDescriptor implements GenericDescriptor {
        private final int f20887a;
        public ServiceDescriptorProto f20888b;
        private final String f20889c;
        private final FileDescriptor f20890d;
        public MethodDescriptor[] f20891e;

        public final AbstractMessage mo896h() {
            return this.f20888b;
        }

        public final String mo893a() {
            return this.f20888b.m20975k();
        }

        public final String mo894b() {
            return this.f20889c;
        }

        public final FileDescriptor mo895c() {
            return this.f20890d;
        }

        public ServiceDescriptor(ServiceDescriptorProto serviceDescriptorProto, FileDescriptor fileDescriptor, int i) {
            this.f20887a = i;
            this.f20888b = serviceDescriptorProto;
            this.f20889c = Descriptors.m21264b(fileDescriptor, null, serviceDescriptorProto.m20975k());
            this.f20890d = fileDescriptor;
            this.f20891e = new MethodDescriptor[serviceDescriptorProto.m20976l()];
            for (int i2 = 0; i2 < serviceDescriptorProto.m20976l(); i2++) {
                this.f20891e[i2] = new MethodDescriptor(serviceDescriptorProto.m20967a(i2), fileDescriptor, this, i2);
            }
            fileDescriptor.f20879h.m21212a((GenericDescriptor) this);
        }
    }

    public static String m21264b(FileDescriptor fileDescriptor, Descriptor descriptor, String str) {
        if (descriptor != null) {
            return descriptor.mo894b() + '.' + str;
        }
        if (fileDescriptor.m21253c().length() > 0) {
            return fileDescriptor.m21253c() + '.' + str;
        }
        return str;
    }
}

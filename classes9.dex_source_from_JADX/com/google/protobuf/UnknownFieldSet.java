package com.google.protobuf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/* compiled from: all_tab */
public final class UnknownFieldSet implements MessageLite {
    public static final UnknownFieldSet f21031a = new UnknownFieldSet(Collections.emptyMap());
    private static final Parser f21032c = new Parser();
    public Map<Integer, Field> f21033b;

    /* compiled from: all_tab */
    public final class Builder implements com.google.protobuf.MessageLite.Builder {
        public Map<Integer, Field> f21021a;
        public int f21022b;
        public Builder f21023c;

        public final Builder m21491a(UnknownFieldSet unknownFieldSet) {
            if (unknownFieldSet != UnknownFieldSet.f21031a) {
                for (Entry entry : unknownFieldSet.f21033b.entrySet()) {
                    m21489a(((Integer) entry.getKey()).intValue(), (Field) entry.getValue());
                }
            }
            return this;
        }

        public final Object clone() {
            m21484a(0);
            return m21487e().m21491a(new UnknownFieldSet(this.f21021a));
        }

        public final /* synthetic */ MessageLite mo876j() {
            return m21497c();
        }

        public final /* synthetic */ MessageLite mo877k() {
            return m21495b();
        }

        private Builder() {
        }

        public static Builder m21487e() {
            Builder builder = new Builder();
            builder.f21021a = Collections.emptyMap();
            builder.f21022b = 0;
            builder.f21023c = null;
            return builder;
        }

        private Builder m21484a(int i) {
            if (this.f21023c != null) {
                if (i == this.f21022b) {
                    return this.f21023c;
                }
                m21485b(this.f21022b, this.f21023c.m21504a());
            }
            if (i == 0) {
                return null;
            }
            Field field = (Field) this.f21021a.get(Integer.valueOf(i));
            this.f21022b = i;
            this.f21023c = Builder.m21500c();
            if (field != null) {
                this.f21023c.m21503a(field);
            }
            return this.f21023c;
        }

        public final UnknownFieldSet m21495b() {
            UnknownFieldSet unknownFieldSet;
            m21484a(0);
            if (this.f21021a.isEmpty()) {
                unknownFieldSet = UnknownFieldSet.f21031a;
            } else {
                unknownFieldSet = new UnknownFieldSet(Collections.unmodifiableMap(this.f21021a));
            }
            this.f21021a = null;
            return unknownFieldSet;
        }

        public final UnknownFieldSet m21497c() {
            return m21495b();
        }

        public final Builder m21489a(int i, Field field) {
            if (i == 0) {
                throw new IllegalArgumentException("Zero is not a valid field number.");
            }
            if (m21486b(i)) {
                m21484a(i).m21503a(field);
            } else {
                m21485b(i, field);
            }
            return this;
        }

        public final Builder m21488a(int i, int i2) {
            if (i == 0) {
                throw new IllegalArgumentException("Zero is not a valid field number.");
            }
            m21484a(i).m21501a((long) i2);
            return this;
        }

        private boolean m21486b(int i) {
            if (i != 0) {
                return i == this.f21022b || this.f21021a.containsKey(Integer.valueOf(i));
            } else {
                throw new IllegalArgumentException("Zero is not a valid field number.");
            }
        }

        private Builder m21485b(int i, Field field) {
            if (i == 0) {
                throw new IllegalArgumentException("Zero is not a valid field number.");
            }
            if (this.f21023c != null && this.f21022b == i) {
                this.f21023c = null;
                this.f21022b = 0;
            }
            if (this.f21021a.isEmpty()) {
                this.f21021a = new TreeMap();
            }
            this.f21021a.put(Integer.valueOf(i), field);
            return this;
        }

        public final Builder m21490a(CodedInputStream codedInputStream) {
            int a;
            do {
                a = codedInputStream.m20202a();
                if (a == 0) {
                    break;
                }
            } while (m21493a(a, codedInputStream));
            return this;
        }

        public final boolean m21493a(int i, CodedInputStream codedInputStream) {
            int i2 = i >>> 3;
            Builder a;
            switch (i & 7) {
                case 0:
                    m21484a(i2).m21501a(codedInputStream.m20213e());
                    return true;
                case 1:
                    a = m21484a(i2);
                    long g = codedInputStream.m20215g();
                    if (a.f21024a.f21028d == null) {
                        a.f21024a.f21028d = new ArrayList();
                    }
                    a.f21024a.f21028d.add(Long.valueOf(g));
                    return true;
                case 2:
                    m21484a(i2).m21502a(codedInputStream.m20219k());
                    return true;
                case 3:
                    com.google.protobuf.MessageLite.Builder e = m21487e();
                    codedInputStream.m20205a(i2, e, ExtensionRegistry.f20907c);
                    a = m21484a(i2);
                    UnknownFieldSet b = e.m21495b();
                    if (a.f21024a.f21030f == null) {
                        a.f21024a.f21030f = new ArrayList();
                    }
                    a.f21024a.f21030f.add(b);
                    return true;
                case 4:
                    return false;
                case 5:
                    a = m21484a(i2);
                    int h = codedInputStream.m20216h();
                    if (a.f21024a.f21027c == null) {
                        a.f21024a.f21027c = new ArrayList();
                    }
                    a.f21024a.f21027c.add(Integer.valueOf(h));
                    return true;
                default:
                    throw InvalidProtocolBufferException.m21372g();
            }
        }

        public final com.google.protobuf.MessageLite.Builder mo839b(byte[] bArr) {
            try {
                CodedInputStream a = CodedInputStream.m20191a(bArr);
                m21490a(a);
                a.m20204a(0);
                return this;
            } catch (InvalidProtocolBufferException e) {
                throw e;
            } catch (Throwable e2) {
                throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e2);
            }
        }

        public final com.google.protobuf.MessageLite.Builder mo840c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return m21490a(codedInputStream);
        }

        public final boolean mo854a() {
            return true;
        }
    }

    /* compiled from: all_tab */
    public final class Field {
        private static final Field f21025a = Builder.m21500c().m21504a();
        public List<Long> f21026b;
        public List<Integer> f21027c;
        public List<Long> f21028d;
        public List<ByteString> f21029e;
        public List<UnknownFieldSet> f21030f;

        /* compiled from: all_tab */
        public final class Builder {
            public Field f21024a;

            private Builder() {
            }

            public static Builder m21500c() {
                Builder builder = new Builder();
                builder.f21024a = new Field();
                return builder;
            }

            public final Field m21504a() {
                if (this.f21024a.f21026b == null) {
                    this.f21024a.f21026b = Collections.emptyList();
                } else {
                    this.f21024a.f21026b = Collections.unmodifiableList(this.f21024a.f21026b);
                }
                if (this.f21024a.f21027c == null) {
                    this.f21024a.f21027c = Collections.emptyList();
                } else {
                    this.f21024a.f21027c = Collections.unmodifiableList(this.f21024a.f21027c);
                }
                if (this.f21024a.f21028d == null) {
                    this.f21024a.f21028d = Collections.emptyList();
                } else {
                    this.f21024a.f21028d = Collections.unmodifiableList(this.f21024a.f21028d);
                }
                if (this.f21024a.f21029e == null) {
                    this.f21024a.f21029e = Collections.emptyList();
                } else {
                    this.f21024a.f21029e = Collections.unmodifiableList(this.f21024a.f21029e);
                }
                if (this.f21024a.f21030f == null) {
                    this.f21024a.f21030f = Collections.emptyList();
                } else {
                    this.f21024a.f21030f = Collections.unmodifiableList(this.f21024a.f21030f);
                }
                Field field = this.f21024a;
                this.f21024a = null;
                return field;
            }

            public final Builder m21503a(Field field) {
                if (!field.f21026b.isEmpty()) {
                    if (this.f21024a.f21026b == null) {
                        this.f21024a.f21026b = new ArrayList();
                    }
                    this.f21024a.f21026b.addAll(field.f21026b);
                }
                if (!field.f21027c.isEmpty()) {
                    if (this.f21024a.f21027c == null) {
                        this.f21024a.f21027c = new ArrayList();
                    }
                    this.f21024a.f21027c.addAll(field.f21027c);
                }
                if (!field.f21028d.isEmpty()) {
                    if (this.f21024a.f21028d == null) {
                        this.f21024a.f21028d = new ArrayList();
                    }
                    this.f21024a.f21028d.addAll(field.f21028d);
                }
                if (!field.f21029e.isEmpty()) {
                    if (this.f21024a.f21029e == null) {
                        this.f21024a.f21029e = new ArrayList();
                    }
                    this.f21024a.f21029e.addAll(field.f21029e);
                }
                if (!field.f21030f.isEmpty()) {
                    if (this.f21024a.f21030f == null) {
                        this.f21024a.f21030f = new ArrayList();
                    }
                    this.f21024a.f21030f.addAll(field.f21030f);
                }
                return this;
            }

            public final Builder m21501a(long j) {
                if (this.f21024a.f21026b == null) {
                    this.f21024a.f21026b = new ArrayList();
                }
                this.f21024a.f21026b.add(Long.valueOf(j));
                return this;
            }

            public final Builder m21502a(ByteString byteString) {
                if (this.f21024a.f21029e == null) {
                    this.f21024a.f21029e = new ArrayList();
                }
                this.f21024a.f21029e.add(byteString);
                return this;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Field) {
                return Arrays.equals(m21505f(), ((Field) obj).m21505f());
            }
            return false;
        }

        public final int hashCode() {
            return Arrays.hashCode(m21505f());
        }

        private Object[] m21505f() {
            return new Object[]{this.f21026b, this.f21027c, this.f21028d, this.f21029e, this.f21030f};
        }
    }

    /* compiled from: all_tab */
    public final class Parser extends AbstractParser<UnknownFieldSet> {
        public final Object mo859a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            Builder e = Builder.m21487e();
            try {
                e.m21490a(codedInputStream);
                return e.m21497c();
            } catch (InvalidProtocolBufferException e2) {
                throw e2.m21374a(e.m21497c());
            } catch (IOException e3) {
                throw new InvalidProtocolBufferException(e3.getMessage()).m21374a(e.m21497c());
            }
        }
    }

    private UnknownFieldSet() {
    }

    public static Builder m21507a(UnknownFieldSet unknownFieldSet) {
        return Builder.m21487e().m21491a(unknownFieldSet);
    }

    public UnknownFieldSet(Map<Integer, Field> map) {
        this.f21033b = map;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof UnknownFieldSet) && this.f21033b.equals(((UnknownFieldSet) obj).f21033b)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f21033b.hashCode();
    }

    public final void mo853a(CodedOutputStream codedOutputStream) {
        for (Entry entry : this.f21033b.entrySet()) {
            Field field = (Field) entry.getValue();
            int intValue = ((Integer) entry.getKey()).intValue();
            for (Long longValue : field.f21026b) {
                codedOutputStream.m20263a(intValue, longValue.longValue());
            }
            for (Integer intValue2 : field.f21027c) {
                int intValue3 = intValue2.intValue();
                codedOutputStream.m20285i(intValue, 5);
                codedOutputStream.m20271b(intValue3);
            }
            for (Long longValue2 : field.f21028d) {
                codedOutputStream.m20277c(intValue, longValue2.longValue());
            }
            for (ByteString a : field.f21029e) {
                codedOutputStream.m20264a(intValue, a);
            }
            for (MessageLite a2 : field.f21030f) {
                codedOutputStream.m20265a(intValue, a2);
            }
        }
    }

    public final String toString() {
        return TextFormat.m21472a(this);
    }

    public final ByteString mo851d() {
        try {
            CodedBuilder b = ByteString.m20176b(mo855b());
            mo853a(b.m20172b());
            return b.m20171a();
        } catch (Throwable e) {
            throw new RuntimeException("Serializing to a ByteString threw an IOException (should never happen).", e);
        }
    }

    public final byte[] lP_() {
        try {
            byte[] bArr = new byte[mo855b()];
            CodedOutputStream a = CodedOutputStream.m20228a(bArr);
            mo853a(a);
            a.m20284h();
            return bArr;
        } catch (Throwable e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    public final int mo855b() {
        int i = 0;
        for (Entry entry : this.f21033b.entrySet()) {
            Field field = (Field) entry.getValue();
            int intValue = ((Integer) entry.getKey()).intValue();
            int i2 = 0;
            for (Long longValue : field.f21026b) {
                i2 = CodedOutputStream.m20239d(intValue, longValue.longValue()) + i2;
            }
            for (Integer intValue2 : field.f21027c) {
                int intValue3 = intValue2.intValue();
                i2 += CodedOutputStream.m20252k(intValue) + 4;
            }
            for (Long longValue2 : field.f21028d) {
                i2 += CodedOutputStream.m20243f(intValue, longValue2.longValue());
            }
            for (ByteString c : field.f21029e) {
                i2 += CodedOutputStream.m20236c(intValue, c);
            }
            for (MessageLite c2 : field.f21030f) {
                i2 += (CodedOutputStream.m20252k(intValue) * 2) + CodedOutputStream.m20237c(c2);
            }
            i = i2 + i;
        }
        return i;
    }

    public final void m21511b(CodedOutputStream codedOutputStream) {
        for (Entry entry : this.f21033b.entrySet()) {
            Field field = (Field) entry.getValue();
            int intValue = ((Integer) entry.getKey()).intValue();
            for (ByteString b : field.f21029e) {
                codedOutputStream.m20272b(intValue, b);
            }
        }
    }

    public final int m21513g() {
        int i = 0;
        for (Entry entry : this.f21033b.entrySet()) {
            Field field = (Field) entry.getValue();
            int intValue = ((Integer) entry.getKey()).intValue();
            int i2 = 0;
            for (ByteString c : field.f21029e) {
                i2 = (((CodedOutputStream.m20252k(1) * 2) + CodedOutputStream.m20246g(2, intValue)) + CodedOutputStream.m20236c(3, c)) + i2;
            }
            i = i2 + i;
        }
        return i;
    }

    public final boolean mo854a() {
        return true;
    }

    public final com.google.protobuf.MessageLite.Builder mo883u() {
        return Builder.m21487e().m21491a(this);
    }

    public final AbstractParser mo857i() {
        return f21032c;
    }
}

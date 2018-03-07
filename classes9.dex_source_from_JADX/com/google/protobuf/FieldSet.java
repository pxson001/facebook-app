package com.google.protobuf;

import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Internal.EnumLite;
import com.google.protobuf.WireFormat.FieldType;
import com.google.protobuf.WireFormat.JavaType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: amount_in_cents */
public final class FieldSet<FieldDescriptorType extends FieldDescriptorLite<FieldDescriptorType>> {
    public static final FieldSet f20912d = new FieldSet((byte) 0);
    public final SmallSortedMap<FieldDescriptorType, Object> f20913a = SmallSortedMap.m21446a(16);
    public boolean f20914b;
    public boolean f20915c = false;

    public final /* synthetic */ Object clone() {
        return m21332e();
    }

    private FieldSet() {
    }

    private FieldSet(byte b) {
        m21331c();
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> m21313a() {
        return new FieldSet();
    }

    public final void m21331c() {
        if (!this.f20914b) {
            this.f20913a.mo921a();
            this.f20914b = true;
        }
    }

    public final FieldSet<FieldDescriptorType> m21332e() {
        FieldSet<FieldDescriptorType> a = m21313a();
        for (int i = 0; i < this.f20913a.m21453c(); i++) {
            Entry b = this.f20913a.m21452b(i);
            a.m21326a((FieldDescriptor) b.getKey(), b.getValue());
        }
        for (Entry entry : this.f20913a.m21454d()) {
            a.m21326a((FieldDescriptor) entry.getKey(), entry.getValue());
        }
        a.f20915c = this.f20915c;
        return a;
    }

    public final Map<FieldDescriptorType, Object> m21333f() {
        if (!this.f20915c) {
            return this.f20913a.f21000d ? this.f20913a : Collections.unmodifiableMap(this.f20913a);
        } else {
            Map<FieldDescriptorType, Object> a = SmallSortedMap.m21446a(16);
            for (int i = 0; i < this.f20913a.m21453c(); i++) {
                m21320a((Map) a, this.f20913a.m21452b(i));
            }
            for (Entry a2 : this.f20913a.m21454d()) {
                m21320a((Map) a, a2);
            }
            if (this.f20913a.f21000d) {
                a.mo921a();
            }
            return a;
        }
    }

    private static void m21320a(Map<FieldDescriptorType, Object> map, Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptor fieldDescriptor = (FieldDescriptor) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof LazyField) {
            map.put(fieldDescriptor, ((LazyField) value).m21377a());
        } else {
            map.put(fieldDescriptor, value);
        }
    }

    public final boolean m21328a(FieldDescriptorType fieldDescriptorType) {
        if (!fieldDescriptorType.m21239m()) {
            return this.f20913a.get(fieldDescriptorType) != null;
        } else {
            throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
        }
    }

    public final Object m21329b(FieldDescriptorType fieldDescriptorType) {
        Object obj = this.f20913a.get(fieldDescriptorType);
        if (obj instanceof LazyField) {
            return ((LazyField) obj).m21377a();
        }
        return obj;
    }

    public final void m21326a(FieldDescriptorType fieldDescriptorType, Object obj) {
        if (!fieldDescriptorType.m21239m()) {
            m21318a(fieldDescriptorType.m21236j(), obj);
        } else if (obj instanceof List) {
            List<Object> arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            for (Object a : arrayList) {
                m21318a(fieldDescriptorType.m21236j(), a);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof LazyField) {
            this.f20915c = true;
        }
        this.f20913a.m21450a(fieldDescriptorType, obj);
    }

    public final void m21330b(FieldDescriptorType fieldDescriptorType, Object obj) {
        if (fieldDescriptorType.m21239m()) {
            List arrayList;
            m21318a(fieldDescriptorType.m21236j(), obj);
            Object b = m21329b((FieldDescriptor) fieldDescriptorType);
            if (b == null) {
                arrayList = new ArrayList();
                this.f20913a.m21450a(fieldDescriptorType, arrayList);
            } else {
                arrayList = (List) b;
            }
            arrayList.add(obj);
            return;
        }
        throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }

    private static void m21318a(FieldType fieldType, Object obj) {
        boolean z = false;
        if (obj == null) {
            throw new NullPointerException();
        }
        switch (fieldType.getJavaType()) {
            case INT:
                z = obj instanceof Integer;
                break;
            case LONG:
                z = obj instanceof Long;
                break;
            case FLOAT:
                z = obj instanceof Float;
                break;
            case DOUBLE:
                z = obj instanceof Double;
                break;
            case BOOLEAN:
                z = obj instanceof Boolean;
                break;
            case STRING:
                z = obj instanceof String;
                break;
            case BYTE_STRING:
                z = obj instanceof ByteString;
                break;
            case ENUM:
                z = obj instanceof EnumLite;
                break;
            case MESSAGE:
                if ((obj instanceof MessageLite) || (obj instanceof LazyField)) {
                    z = true;
                    break;
                }
        }
        if (!z) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    public final boolean m21334h() {
        for (int i = 0; i < this.f20913a.m21453c(); i++) {
            if (!m21321a(this.f20913a.m21452b(i))) {
                return false;
            }
        }
        for (Entry a : this.f20913a.m21454d()) {
            if (!m21321a(a)) {
                return false;
            }
        }
        return true;
    }

    private static boolean m21321a(Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptor fieldDescriptor = (FieldDescriptor) entry.getKey();
        if (fieldDescriptor.m21233g() == JavaType.MESSAGE) {
            if (fieldDescriptor.m21239m()) {
                for (MessageLite a : (List) entry.getValue()) {
                    if (!a.mo854a()) {
                        return false;
                    }
                }
            }
            Object value = entry.getValue();
            if (value instanceof MessageLite) {
                if (!((MessageLite) value).mo854a()) {
                    return false;
                }
            } else if (value instanceof LazyField) {
                return true;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        }
        return true;
    }

    static int m21312a(FieldType fieldType, boolean z) {
        if (z) {
            return 2;
        }
        return fieldType.getWireType();
    }

    public final void m21327a(FieldSet<FieldDescriptorType> fieldSet) {
        for (int i = 0; i < fieldSet.f20913a.m21453c(); i++) {
            m21323b(fieldSet.f20913a.m21452b(i));
        }
        for (Entry b : fieldSet.f20913a.m21454d()) {
            m21323b(b);
        }
    }

    private void m21323b(Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptor fieldDescriptor = (FieldDescriptor) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof LazyField) {
            value = ((LazyField) value).m21377a();
        }
        Object b;
        if (fieldDescriptor.m21239m()) {
            b = m21329b(fieldDescriptor);
            if (b == null) {
                this.f20913a.m21450a(fieldDescriptor, new ArrayList((List) value));
            } else {
                ((List) b).addAll((List) value);
            }
        } else if (fieldDescriptor.m21233g() == JavaType.MESSAGE) {
            b = m21329b(fieldDescriptor);
            if (b == null) {
                this.f20913a.m21450a(fieldDescriptor, value);
            } else {
                this.f20913a.m21450a(fieldDescriptor, fieldDescriptor.m21227a(((MessageLite) b).mo883u(), (MessageLite) value).mo877k());
            }
        } else {
            this.f20913a.m21450a(fieldDescriptor, value);
        }
    }

    public static Object m21314a(CodedInputStream codedInputStream, FieldType fieldType) {
        switch (fieldType) {
            case DOUBLE:
                return Double.valueOf(codedInputStream.m20207b());
            case FLOAT:
                return Float.valueOf(codedInputStream.m20209c());
            case INT64:
                return Long.valueOf(codedInputStream.m20213e());
            case UINT64:
                return Long.valueOf(codedInputStream.m20211d());
            case INT32:
                return Integer.valueOf(codedInputStream.m20214f());
            case FIXED64:
                return Long.valueOf(codedInputStream.m20215g());
            case FIXED32:
                return Integer.valueOf(codedInputStream.m20216h());
            case BOOL:
                return Boolean.valueOf(codedInputStream.m20217i());
            case STRING:
                return codedInputStream.m20218j();
            case BYTES:
                return codedInputStream.m20219k();
            case UINT32:
                return Integer.valueOf(codedInputStream.m20220l());
            case SFIXED32:
                return Integer.valueOf(codedInputStream.m20222n());
            case SFIXED64:
                return Long.valueOf(codedInputStream.m20223o());
            case SINT32:
                int r = codedInputStream.m20225r();
                return Integer.valueOf((r >>> 1) ^ (-(r & 1)));
            case SINT64:
                return Long.valueOf(codedInputStream.m20224q());
            case GROUP:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
            case MESSAGE:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
            case ENUM:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static void m21319a(Entry<FieldDescriptorType, Object> entry, CodedOutputStream codedOutputStream) {
        FieldDescriptor fieldDescriptor = (FieldDescriptor) entry.getKey();
        if (fieldDescriptor.m21233g() != JavaType.MESSAGE || fieldDescriptor.m21239m() || fieldDescriptor.m21240n()) {
            m21317a(fieldDescriptor, entry.getValue(), codedOutputStream);
        } else {
            codedOutputStream.m20278c(((FieldDescriptor) entry.getKey()).m21231e(), (MessageLite) entry.getValue());
        }
    }

    private static void m21315a(CodedOutputStream codedOutputStream, FieldType fieldType, int i, Object obj) {
        if (fieldType == FieldType.GROUP) {
            codedOutputStream.m20265a(i, (MessageLite) obj);
            return;
        }
        codedOutputStream.m20285i(i, m21312a(fieldType, false));
        m21316a(codedOutputStream, fieldType, obj);
    }

    private static void m21316a(CodedOutputStream codedOutputStream, FieldType fieldType, Object obj) {
        switch (fieldType) {
            case DOUBLE:
                codedOutputStream.m20259a(((Double) obj).doubleValue());
                return;
            case FLOAT:
                codedOutputStream.m20260a(((Float) obj).floatValue());
                return;
            case INT64:
                codedOutputStream.m20274b(((Long) obj).longValue());
                return;
            case UINT64:
                codedOutputStream.m20267a(((Long) obj).longValue());
                return;
            case INT32:
                codedOutputStream.m20261a(((Integer) obj).intValue());
                return;
            case FIXED64:
                codedOutputStream.m20279c(((Long) obj).longValue());
                return;
            case FIXED32:
                codedOutputStream.m20271b(((Integer) obj).intValue());
                return;
            case BOOL:
                codedOutputStream.m20270a(((Boolean) obj).booleanValue());
                return;
            case STRING:
                codedOutputStream.m20269a((String) obj);
                return;
            case BYTES:
                codedOutputStream.m20268a((ByteString) obj);
                return;
            case UINT32:
                codedOutputStream.m20286l(((Integer) obj).intValue());
                return;
            case SFIXED32:
                codedOutputStream.m20282e(((Integer) obj).intValue());
                return;
            case SFIXED64:
                codedOutputStream.m20281d(((Long) obj).longValue());
                return;
            case SINT32:
                codedOutputStream.m20286l(CodedOutputStream.m20258p(((Integer) obj).intValue()));
                return;
            case SINT64:
                codedOutputStream.m20283e(((Long) obj).longValue());
                return;
            case GROUP:
                ((MessageLite) obj).mo853a(codedOutputStream);
                return;
            case MESSAGE:
                codedOutputStream.m20275b((MessageLite) obj);
                return;
            case ENUM:
                codedOutputStream.m20261a(((EnumLite) obj).getNumber());
                return;
            default:
                return;
        }
    }

    public static void m21317a(FieldDescriptorLite<?> fieldDescriptorLite, Object obj, CodedOutputStream codedOutputStream) {
        FieldType j = fieldDescriptorLite.m21236j();
        int e = fieldDescriptorLite.m21231e();
        if (fieldDescriptorLite.m21239m()) {
            List<Object> list = (List) obj;
            if (fieldDescriptorLite.m21240n()) {
                codedOutputStream.m20285i(e, 2);
                e = 0;
                for (Object b : list) {
                    e += m21322b(j, b);
                }
                codedOutputStream.m20286l(e);
                for (Object a : list) {
                    m21316a(codedOutputStream, j, a);
                }
                return;
            }
            for (Object b2 : list) {
                m21315a(codedOutputStream, j, e, b2);
            }
        } else if (obj instanceof LazyField) {
            m21315a(codedOutputStream, j, e, ((LazyField) obj).m21377a());
        } else {
            m21315a(codedOutputStream, j, e, obj);
        }
    }

    public final int m21335i() {
        int i = 0;
        for (int i2 = 0; i2 < this.f20913a.m21453c(); i2++) {
            Entry b = this.f20913a.m21452b(i2);
            i += m21324c((FieldDescriptor) b.getKey(), b.getValue());
        }
        for (Entry entry : this.f20913a.m21454d()) {
            i += m21324c((FieldDescriptor) entry.getKey(), entry.getValue());
        }
        return i;
    }

    public static int m21325c(Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptor fieldDescriptor = (FieldDescriptor) entry.getKey();
        Object value = entry.getValue();
        if (fieldDescriptor.m21233g() != JavaType.MESSAGE || fieldDescriptor.m21239m() || fieldDescriptor.m21240n()) {
            return m21324c(fieldDescriptor, value);
        }
        if (!(value instanceof LazyField)) {
            return CodedOutputStream.m20244f(((FieldDescriptor) entry.getKey()).m21231e(), (MessageLite) value);
        }
        return ((CodedOutputStream.m20252k(1) * 2) + CodedOutputStream.m20246g(2, ((FieldDescriptor) entry.getKey()).m21231e())) + (CodedOutputStream.m20252k(3) + CodedOutputStream.m20227a((LazyField) value));
    }

    private static int m21311a(FieldType fieldType, int i, Object obj) {
        int k = CodedOutputStream.m20252k(i);
        if (fieldType == FieldType.GROUP) {
            k *= 2;
        }
        return k + m21322b(fieldType, obj);
    }

    private static int m21322b(FieldType fieldType, Object obj) {
        switch (fieldType) {
            case DOUBLE:
                ((Double) obj).doubleValue();
                return 8;
            case FLOAT:
                ((Float) obj).floatValue();
                return 4;
            case INT64:
                return CodedOutputStream.m20251j(((Long) obj).longValue());
            case UINT64:
                return CodedOutputStream.m20251j(((Long) obj).longValue());
            case INT32:
                return CodedOutputStream.m20245g(((Integer) obj).intValue());
            case FIXED64:
                ((Long) obj).longValue();
                return 8;
            case FIXED32:
                ((Integer) obj).intValue();
                return 4;
            case BOOL:
                ((Boolean) obj).booleanValue();
                return 1;
            case STRING:
                return CodedOutputStream.m20233b((String) obj);
            case BYTES:
                return CodedOutputStream.m20232b((ByteString) obj);
            case UINT32:
                return CodedOutputStream.m20255m(((Integer) obj).intValue());
            case SFIXED32:
                ((Integer) obj).intValue();
                return 4;
            case SFIXED64:
                ((Long) obj).longValue();
                return 8;
            case SINT32:
                return CodedOutputStream.m20255m(CodedOutputStream.m20258p(((Integer) obj).intValue()));
            case SINT64:
                return CodedOutputStream.m20251j(CodedOutputStream.m20254l(((Long) obj).longValue()));
            case GROUP:
                return CodedOutputStream.m20237c((MessageLite) obj);
            case MESSAGE:
                if (obj instanceof LazyField) {
                    return CodedOutputStream.m20227a((LazyField) obj);
                }
                return CodedOutputStream.m20240d((MessageLite) obj);
            case ENUM:
                return CodedOutputStream.m20245g(((EnumLite) obj).getNumber());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int m21324c(FieldDescriptorLite<?> fieldDescriptorLite, Object obj) {
        int i = 0;
        FieldType j = fieldDescriptorLite.m21236j();
        int e = fieldDescriptorLite.m21231e();
        if (!fieldDescriptorLite.m21239m()) {
            return m21311a(j, e, obj);
        }
        if (fieldDescriptorLite.m21240n()) {
            for (Object b : (List) obj) {
                i += m21322b(j, b);
            }
            return CodedOutputStream.m20255m(i) + (CodedOutputStream.m20252k(e) + i);
        }
        for (Object b2 : (List) obj) {
            i += m21311a(j, e, b2);
        }
        return i;
    }
}

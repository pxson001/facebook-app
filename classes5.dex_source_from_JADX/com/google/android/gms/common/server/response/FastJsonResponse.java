package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.server.converter.ConverterWrapper;
import com.google.android.gms.internal.zzni;
import com.google.android.gms.internal.zznu;
import com.google.android.gms.internal.zznv;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class FastJsonResponse {

    public interface zza<I, O> {
        I mo796a(O o);
    }

    public class Field<I, O> implements SafeParcelable {
        public static final zza CREATOR = new zza();
        public final int f6604a;
        public final boolean f6605b;
        public final int f6606c;
        public final boolean f6607d;
        public final String f6608e;
        public final int f6609f;
        public final Class<? extends FastJsonResponse> f6610g;
        protected final String f6611h;
        public final int f6612i;
        public FieldMappingDictionary f6613j;
        public zza<I, O> f6614k;

        Field(int i, int i2, boolean z, int i3, boolean z2, String str, int i4, String str2, ConverterWrapper converterWrapper) {
            this.f6612i = i;
            this.f6604a = i2;
            this.f6605b = z;
            this.f6606c = i3;
            this.f6607d = z2;
            this.f6608e = str;
            this.f6609f = i4;
            if (str2 == null) {
                this.f6610g = null;
                this.f6611h = null;
            } else {
                this.f6610g = SafeParcelResponse.class;
                this.f6611h = str2;
            }
            if (converterWrapper == null) {
                this.f6614k = null;
            } else {
                this.f6614k = converterWrapper.m12404c();
            }
        }

        public int describeContents() {
            return 0;
        }

        public final boolean m12407e() {
            return this.f6607d;
        }

        public final String m12408f() {
            return this.f6608e;
        }

        public final Class<? extends FastJsonResponse> m12409h() {
            return this.f6610g;
        }

        public final String m12410i() {
            return this.f6611h == null ? null : this.f6611h;
        }

        public final Map<String, Field<?, ?>> m12411l() {
            zzx.a(this.f6611h);
            zzx.a(this.f6613j);
            return this.f6613j.m12423a(this.f6611h);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Field\n");
            stringBuilder.append("            versionCode=").append(this.f6612i).append('\n');
            stringBuilder.append("                 typeIn=").append(this.f6604a).append('\n');
            stringBuilder.append("            typeInArray=").append(this.f6605b).append('\n');
            stringBuilder.append("                typeOut=").append(this.f6606c).append('\n');
            stringBuilder.append("           typeOutArray=").append(this.f6607d).append('\n');
            stringBuilder.append("        outputFieldName=").append(this.f6608e).append('\n');
            stringBuilder.append("      safeParcelFieldId=").append(this.f6609f).append('\n');
            stringBuilder.append("       concreteTypeName=").append(m12410i()).append('\n');
            if (this.f6610g != null) {
                stringBuilder.append("     concreteType.class=").append(this.f6610g.getCanonicalName()).append('\n');
            }
            stringBuilder.append("          converterName=").append(this.f6614k == null ? "null" : this.f6614k.getClass().getCanonicalName()).append('\n');
            return stringBuilder.toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            int a = zzb.m12237a(parcel);
            zzb.m12241a(parcel, 1, this.f6612i);
            zzb.m12241a(parcel, 2, this.f6604a);
            zzb.m12249a(parcel, 3, this.f6605b);
            zzb.m12241a(parcel, 4, this.f6606c);
            zzb.m12249a(parcel, 5, this.f6607d);
            zzb.m12247a(parcel, 6, this.f6608e, false);
            zzb.m12241a(parcel, 7, this.f6609f);
            zzb.m12247a(parcel, 8, m12410i(), false);
            zzb.m12245a(parcel, 9, (Parcelable) this.f6614k == null ? null : ConverterWrapper.m12403a(this.f6614k), i, false);
            zzb.m12258c(parcel, a);
        }
    }

    protected static <O, I> I m12412a(Field<I, O> field, Object obj) {
        return field.f6614k != null ? field.f6614k.mo796a(obj) : obj;
    }

    public static void m12413a(StringBuilder stringBuilder, Field field, Object obj) {
        if (field.f6604a == 11) {
            stringBuilder.append(((FastJsonResponse) field.f6610g.cast(obj)).toString());
        } else if (field.f6604a == 7) {
            stringBuilder.append("\"");
            stringBuilder.append(zznu.m12892a((String) obj));
            stringBuilder.append("\"");
        } else {
            stringBuilder.append(obj);
        }
    }

    private Object m12414b(Field field) {
        String f = field.m12408f();
        if (field.m12409h() != null) {
            field.m12408f();
            zzx.a(mo798b() == null, "Concrete field shouldn't be value object: %s", new Object[]{field.m12408f()});
            Map g = field.m12407e() ? m12418g() : mo801f();
            if (g != null) {
                return g.get(f);
            }
            try {
                return getClass().getMethod("get" + Character.toUpperCase(f.charAt(0)) + f.substring(1), new Class[0]).invoke(this, new Object[0]);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
        field.m12408f();
        return mo798b();
    }

    public static boolean m12415d() {
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    public static boolean mo800e() {
        throw new UnsupportedOperationException("Concrete type arrays not supported");
    }

    private static HashMap<String, Object> mo801f() {
        return null;
    }

    private static HashMap<String, Object> m12418g() {
        return null;
    }

    public abstract Map<String, Field<?, ?>> mo797a();

    protected abstract Object mo798b();

    public abstract boolean mo799c();

    public String toString() {
        Map a = mo797a();
        StringBuilder stringBuilder = new StringBuilder(100);
        for (String str : a.keySet()) {
            boolean c;
            Field field = (Field) a.get(str);
            String str2;
            if (field.f6606c != 11) {
                str2 = field.f6608e;
                c = mo799c();
            } else if (field.f6607d) {
                str2 = field.f6608e;
                c = mo800e();
            } else {
                str2 = field.f6608e;
                c = m12415d();
            }
            if (c) {
                Object a2 = m12412a(field, m12414b(field));
                if (stringBuilder.length() == 0) {
                    stringBuilder.append("{");
                } else {
                    stringBuilder.append(",");
                }
                stringBuilder.append("\"").append(str).append("\":");
                if (a2 != null) {
                    switch (field.f6606c) {
                        case 8:
                            stringBuilder.append("\"").append(zzni.m12889a((byte[]) a2)).append("\"");
                            break;
                        case 9:
                            stringBuilder.append("\"").append(zzni.m12890b((byte[]) a2)).append("\"");
                            break;
                        case 10:
                            zznv.m12894a(stringBuilder, (HashMap) a2);
                            break;
                        default:
                            if (!field.f6605b) {
                                m12413a(stringBuilder, field, a2);
                                break;
                            }
                            ArrayList arrayList = (ArrayList) a2;
                            stringBuilder.append("[");
                            int size = arrayList.size();
                            for (int i = 0; i < size; i++) {
                                if (i > 0) {
                                    stringBuilder.append(",");
                                }
                                Object obj = arrayList.get(i);
                                if (obj != null) {
                                    m12413a(stringBuilder, field, obj);
                                }
                            }
                            stringBuilder.append("]");
                            break;
                    }
                }
                stringBuilder.append("null");
            }
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.append("}");
        } else {
            stringBuilder.append("{}");
        }
        return stringBuilder.toString();
    }
}

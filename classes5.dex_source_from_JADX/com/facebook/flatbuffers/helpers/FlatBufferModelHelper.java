package com.facebook.flatbuffers.helpers;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.flatbuffers.MutableFlattenable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: removed_bookmark_id */
public class FlatBufferModelHelper {

    /* compiled from: removed_bookmark_id */
    public class LazyHolder implements Parcelable {
        public static final Creator<LazyHolder> CREATOR = new C02351();
        public final int f3162a;
        @Nullable
        public final Flattenable f3163b;
        @Nullable
        public final Parcelable f3164c;

        /* compiled from: removed_bookmark_id */
        final class C02351 implements Creator<LazyHolder> {
            C02351() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new LazyHolder(parcel);
            }

            public final Object[] newArray(int i) {
                return new LazyHolder[i];
            }
        }

        LazyHolder(Object obj) {
            if (obj instanceof Flattenable) {
                this.f3163b = (Flattenable) obj;
                this.f3162a = 1;
                this.f3164c = null;
            } else if (obj instanceof Parcelable) {
                this.f3164c = (Parcelable) obj;
                this.f3162a = 2;
                this.f3163b = null;
            } else {
                throw new IllegalArgumentException("Object param must implement a serialization format");
            }
        }

        LazyHolder(Parcel parcel) {
            this.f3162a = parcel.readInt();
            if (this.f3162a == 1) {
                this.f3164c = null;
                this.f3163b = FlatBufferModelHelper.m4278a(parcel);
                return;
            }
            this.f3163b = null;
            this.f3164c = parcel.readParcelable(FlatBufferModelHelper.class.getClassLoader());
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f3162a);
            if (this.f3162a == 1) {
                FlatBufferModelHelper.m4288a(parcel, this.f3163b);
            } else {
                parcel.writeParcelable(this.f3164c, 0);
            }
        }

        @Nullable
        final Object m4277a() {
            Flattenable flattenable;
            Class cls = Object.class;
            if (this.f3162a == 1) {
                m4276a(this.f3163b, cls);
                flattenable = this.f3163b;
            } else {
                m4276a(this.f3164c, cls);
                flattenable = this.f3164c;
            }
            return flattenable;
        }

        public static void m4276a(@Nullable Object obj, Class cls) {
            if (obj != null) {
                Class cls2 = obj.getClass();
                if (!cls.isAssignableFrom(cls2)) {
                    throw new IllegalArgumentException("Type mismatch. Expected " + cls.getName() + ", got " + cls2.getName());
                }
            }
        }
    }

    public static void m4288a(Parcel parcel, @Nullable Flattenable flattenable) {
        byte[] b = flattenable == null ? null : FlatBufferBuilder.b(flattenable);
        if (b == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(b.length);
        parcel.writeString(flattenable.getClass().getName());
        parcel.writeByte((byte) (m4291a(flattenable) ? 1 : 0));
        parcel.writeByteArray(b);
        byte[] b2 = m4295b(flattenable);
        if (b2 == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(b2.length);
        parcel.writeByteArray(b2);
    }

    @Nullable
    public static Flattenable m4278a(Parcel parcel) {
        byte[] bArr = null;
        int readInt = parcel.readInt();
        if (readInt == -1) {
            return null;
        }
        String readString = parcel.readString();
        boolean z = parcel.readByte() != (byte) 0;
        byte[] bArr2 = new byte[readInt];
        parcel.readByteArray(bArr2);
        int readInt2 = parcel.readInt();
        if (readInt2 != -1) {
            bArr = new byte[readInt2];
            parcel.readByteArray(bArr);
        }
        return m4279a(readString, bArr2, z, bArr);
    }

    @Nullable
    public static List m4294b(Parcel parcel) {
        int readInt = parcel.readInt();
        if (readInt == -1) {
            return null;
        }
        List arrayList = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            arrayList.add(m4278a(parcel));
        }
        return arrayList;
    }

    public static void m4289a(Parcel parcel, List list) {
        parcel.writeInt(list == null ? -1 : list.size());
        if (list != null) {
            for (Flattenable a : list) {
                m4288a(parcel, a);
            }
        }
    }

    @Nullable
    public static Map m4296c(Parcel parcel) {
        int readInt = parcel.readInt();
        if (readInt == -1) {
            return null;
        }
        Map hashMap = new HashMap(readInt);
        for (int i = 0; i < readInt; i++) {
            hashMap.put(parcel.readString(), m4278a(parcel));
        }
        return hashMap;
    }

    public static void m4290a(Parcel parcel, Map map) {
        parcel.writeInt(map == null ? -1 : map.size());
        if (map != null) {
            for (Object next : map.keySet()) {
                parcel.writeString((String) next);
                m4288a(parcel, (Flattenable) map.get(next));
            }
        }
    }

    public static void m4284a(Intent intent, String str, Object obj) {
        if (intent != null) {
            intent.putExtra(str, obj == null ? null : new LazyHolder(obj));
        }
    }

    @Nullable
    public static Object m4280a(Intent intent, String str) {
        if (intent == null) {
            return null;
        }
        LazyHolder lazyHolder = (LazyHolder) intent.getParcelableExtra(str);
        return lazyHolder != null ? lazyHolder.m4277a() : null;
    }

    public static void m4285a(Intent intent, String str, List list) {
        if (intent != null) {
            intent.putParcelableArrayListExtra(str, m4282a(list));
        }
    }

    @Nullable
    public static List m4292b(Intent intent, String str) {
        if (intent == null) {
            return null;
        }
        return m4283a(intent.getParcelableArrayListExtra(str));
    }

    public static void m4286a(Bundle bundle, String str, Object obj) {
        if (bundle != null) {
            bundle.putParcelable(str, obj == null ? null : new LazyHolder(obj));
        }
    }

    @Nullable
    public static Object m4281a(Bundle bundle, String str) {
        if (bundle == null) {
            return null;
        }
        LazyHolder lazyHolder = (LazyHolder) bundle.getParcelable(str);
        return lazyHolder != null ? lazyHolder.m4277a() : null;
    }

    public static void m4287a(Bundle bundle, String str, List list) {
        if (bundle != null) {
            bundle.putParcelableArrayList(str, m4282a(list));
        }
    }

    @Nullable
    public static List m4293b(Bundle bundle, String str) {
        if (bundle == null) {
            return null;
        }
        return m4283a(bundle.getParcelableArrayList(str));
    }

    @Nullable
    private static ArrayList<LazyHolder> m4282a(List<Object> list) {
        if (list == null) {
            return null;
        }
        ArrayList<LazyHolder> arrayList = new ArrayList(list.size());
        for (Object next : list) {
            arrayList.add(next == null ? null : new LazyHolder(next));
        }
        return arrayList;
    }

    @Nullable
    private static <T> List<T> m4283a(ArrayList<LazyHolder> arrayList) {
        if (arrayList == null) {
            return null;
        }
        List<T> arrayList2 = new ArrayList(arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            LazyHolder lazyHolder = (LazyHolder) it.next();
            if (lazyHolder != null) {
                arrayList2.add(lazyHolder.m4277a());
            } else {
                arrayList2.add(null);
            }
        }
        return arrayList2;
    }

    private static boolean m4291a(Flattenable flattenable) {
        if (flattenable instanceof MutableFlattenable) {
            MutableFlatBuffer w_ = ((MutableFlattenable) flattenable).w_();
            if (w_ != null) {
                return w_.d;
            }
        }
        return false;
    }

    @Nullable
    private static byte[] m4295b(Flattenable flattenable) {
        if (flattenable instanceof MutableFlattenable) {
            MutableFlatBuffer w_ = ((MutableFlattenable) flattenable).w_();
            if (w_ != null) {
                ByteBuffer e = w_.e();
                if (e != null) {
                    return e.array();
                }
            }
        }
        return null;
    }

    private static Flattenable m4279a(String str, byte[] bArr, boolean z, @Nullable byte[] bArr2) {
        Throwable e;
        ByteBuffer byteBuffer = null;
        try {
            Flattenable flattenable = (Flattenable) Class.forName(str).newInstance();
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            if (bArr2 != null) {
                byteBuffer = ByteBuffer.wrap(bArr2);
            }
            flattenable.a(new MutableFlatBuffer(wrap, null, byteBuffer, z, null), FlatBuffer.a(wrap));
            return flattenable;
        } catch (InstantiationException e2) {
            e = e2;
            throw new RuntimeException("Can't init flattenable object", e);
        } catch (IllegalAccessException e3) {
            e = e3;
            throw new RuntimeException("Can't init flattenable object", e);
        } catch (ClassNotFoundException e4) {
            e = e4;
            throw new RuntimeException("Can't init flattenable object", e);
        }
    }
}

package com.facebook.fbservice.service;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Pair;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: glyph_pile */
public class OperationResult implements Parcelable {
    public static final Creator<OperationResult> CREATOR = new C08991();
    public static final OperationResult f22219a = new OperationResult();
    public final boolean f22220b;
    @Nullable
    public final String f22221c;
    @Nullable
    public final Bundle f22222d;
    @Nullable
    public final ErrorCode f22223e;
    @Nullable
    public final String f22224f;
    @Nullable
    public final Throwable f22225g;

    /* compiled from: glyph_pile */
    final class C08991 implements Creator<OperationResult> {
        C08991() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new OperationResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new OperationResult[i];
        }
    }

    /* compiled from: glyph_pile */
    enum OperationResultType {
        NULL,
        PARCELABLE,
        FLATTENABLE;

        public static OperationResultType fromObject(Object obj) {
            if (obj == null) {
                return NULL;
            }
            if (obj instanceof Parcelable) {
                return PARCELABLE;
            }
            return FLATTENABLE;
        }
    }

    OperationResult() {
        this.f22220b = true;
        this.f22221c = null;
        this.f22222d = null;
        this.f22223e = ErrorCode.NO_ERROR;
        this.f22224f = null;
        this.f22225g = null;
    }

    private OperationResult(@Nullable String str, @Nullable Bundle bundle) {
        this.f22220b = true;
        this.f22221c = str;
        this.f22222d = bundle;
        this.f22223e = ErrorCode.NO_ERROR;
        this.f22224f = null;
        this.f22225g = null;
    }

    private OperationResult(ErrorCode errorCode, String str, @Nullable Bundle bundle, @Nullable Throwable th) {
        this.f22220b = false;
        this.f22221c = null;
        this.f22222d = bundle;
        this.f22223e = errorCode;
        this.f22224f = str;
        this.f22225g = th;
    }

    private OperationResult(Throwable th) {
        this.f22220b = false;
        this.f22221c = null;
        this.f22223e = null;
        this.f22224f = null;
        this.f22225g = th;
        this.f22222d = new Bundle();
        this.f22222d.putInt("resultType", OperationResultType.PARCELABLE.ordinal());
    }

    public OperationResult(Parcel parcel) {
        this.f22220b = parcel.readInt() != 0;
        this.f22221c = parcel.readString();
        this.f22222d = parcel.readBundle(getClass().getClassLoader());
        this.f22223e = ErrorCode.valueOf(parcel.readString());
        this.f22224f = parcel.readString();
        this.f22225g = (Throwable) parcel.readSerializable();
    }

    public static OperationResult m30109a() {
        return f22219a;
    }

    public static OperationResult m30116a(String str) {
        return new OperationResult(str, null);
    }

    public static OperationResult m30115a(Object obj) {
        if (obj instanceof String) {
            return m30116a((String) obj);
        }
        Bundle bundle = new Bundle();
        bundle.putInt("resultType", OperationResultType.fromObject(obj).ordinal());
        if (obj instanceof Parcelable) {
            bundle.putParcelable("result", (Parcelable) obj);
        } else if (obj instanceof Flattenable) {
            FlatBufferModelHelper.a(bundle, "result", obj);
        } else if (obj != null) {
            throw new UnsupportedOperationException("Can not create result for object " + obj);
        }
        return new OperationResult(null, bundle);
    }

    public static OperationResult m30119a(ArrayList<?> arrayList) {
        int i = 0;
        Bundle bundle = new Bundle();
        bundle.putSerializable("resultNull", Boolean.valueOf(arrayList == null));
        if (arrayList != null) {
            bundle.putInt("resultSize", arrayList.size());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                bundle.putInt("resultType" + i, OperationResultType.fromObject(next).ordinal());
                if (next instanceof Parcelable) {
                    bundle.putParcelable("result" + i, (Parcelable) next);
                } else if (next instanceof Flattenable) {
                    FlatBufferModelHelper.a(bundle, "result" + i, next);
                } else {
                    throw new UnsupportedOperationException("Can not create result for object " + next);
                }
                i++;
            }
        }
        return new OperationResult(null, bundle);
    }

    public static OperationResult m30120a(HashMap<String, ? extends Parcelable> hashMap) {
        Bundle bundle = new Bundle();
        bundle.putInt("resultType", OperationResultType.PARCELABLE.ordinal());
        bundle.putSerializable("result", Maps.m813a((Map) hashMap));
        return new OperationResult(null, bundle);
    }

    public static OperationResult m30110a(Parcelable parcelable, Pair<String, Parcelable>... pairArr) {
        Bundle bundle = new Bundle();
        bundle.putInt("resultType", OperationResultType.PARCELABLE.ordinal());
        bundle.putParcelable("result", parcelable);
        for (Pair pair : pairArr) {
            bundle.putParcelable((String) pair.first, (Parcelable) pair.second);
        }
        return new OperationResult(null, bundle);
    }

    public static OperationResult m30117a(String str, Pair<String, Parcelable>... pairArr) {
        Bundle bundle = new Bundle();
        for (Pair pair : pairArr) {
            bundle.putParcelable((String) pair.first, (Parcelable) pair.second);
        }
        return new OperationResult(str, bundle);
    }

    public static OperationResult m30111a(ErrorCode errorCode) {
        Bundle bundle = new Bundle();
        bundle.putInt("resultType", OperationResultType.PARCELABLE.ordinal());
        return new OperationResult(errorCode, errorCode.toString(), bundle, null);
    }

    public static OperationResult m30114a(ErrorCode errorCode, Throwable th) {
        Bundle bundle = new Bundle();
        bundle.putInt("resultType", OperationResultType.PARCELABLE.ordinal());
        return new OperationResult(errorCode, errorCode.toString(), bundle, th);
    }

    public static OperationResult m30112a(ErrorCode errorCode, Bundle bundle, Throwable th) {
        bundle.putInt("resultType", OperationResultType.PARCELABLE.ordinal());
        return new OperationResult(errorCode, errorCode.toString(), bundle, th);
    }

    public static OperationResult m30113a(ErrorCode errorCode, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("resultType", OperationResultType.PARCELABLE.ordinal());
        return new OperationResult(errorCode, str, bundle, null);
    }

    public static OperationResult m30118a(Throwable th) {
        return new OperationResult(th);
    }

    public final boolean m30123b() {
        return this.f22220b;
    }

    public final ErrorCode m30124c() {
        return this.f22223e;
    }

    public final String m30126d() {
        return this.f22224f;
    }

    public final Throwable m30127e() {
        return this.f22225g;
    }

    public final String m30128f() {
        return this.f22221c;
    }

    public final Bundle m30129g() {
        if (this.f22222d != null) {
            this.f22222d.setClassLoader(getClass().getClassLoader());
        }
        return this.f22222d;
    }

    public final <T> T m30121a(Class<T> cls) {
        if (Parcelable.class.isAssignableFrom(cls)) {
            return m30130h();
        }
        if (Bundle.class.equals(cls)) {
            return this.f22222d;
        }
        if (CharSequence.class.isAssignableFrom(cls)) {
            return this.f22221c;
        }
        if (List.class.isAssignableFrom(cls)) {
            return m30131i();
        }
        if (Map.class.isAssignableFrom(cls)) {
            return m30132j();
        }
        throw new IllegalArgumentException("Invalid result data type: " + cls);
    }

    public final <T> T m30130h() {
        T k = m30133k();
        if (k != null) {
            return k;
        }
        throw new NoResultDataParcelableException();
    }

    public final <T> ArrayList<T> m30131i() {
        ArrayList<T> l = m30134l();
        if (l != null) {
            return l;
        }
        throw new NoResultDataParcelableException();
    }

    public final <T> T m30122b(String str) {
        T c = m30125c(str);
        if (c != null) {
            return c;
        }
        throw new NoResultDataParcelableException();
    }

    public final <T> T m30133k() {
        if (this.f22222d == null) {
            return null;
        }
        Object obj = OperationResultType.values()[this.f22222d.getInt("resultType")];
        if (OperationResultType.NULL.equals(obj)) {
            return null;
        }
        if (OperationResultType.FLATTENABLE.equals(obj)) {
            return FlatBufferModelHelper.a(this.f22222d, "result");
        }
        this.f22222d.setClassLoader(getClass().getClassLoader());
        return this.f22222d.get("result");
    }

    public final <T> ArrayList<T> m30134l() {
        if (this.f22222d == null || this.f22222d.getBoolean("resultNull")) {
            return null;
        }
        int i = this.f22222d.getInt("resultSize");
        ArrayList<T> arrayList = new ArrayList();
        OperationResultType[] values = OperationResultType.values();
        for (int i2 = 0; i2 < i; i2++) {
            Object obj = values[this.f22222d.getInt("resultType" + i2)];
            if (OperationResultType.NULL.equals(obj)) {
                arrayList.add(null);
            } else if (OperationResultType.FLATTENABLE.equals(obj)) {
                arrayList.add(FlatBufferModelHelper.a(this.f22222d, "result" + i2));
            } else {
                arrayList.add(m30122b("result" + i2));
            }
        }
        return arrayList;
    }

    public final <T> HashMap<String, T> m30132j() {
        HashMap<String, T> hashMap;
        if (this.f22222d != null) {
            hashMap = (HashMap) this.f22222d.getSerializable("result");
        } else {
            hashMap = null;
        }
        HashMap<String, T> hashMap2 = hashMap;
        if (hashMap2 != null) {
            return hashMap2;
        }
        throw new NoResultDataParcelableException();
    }

    public final <T> T m30125c(String str) {
        if (this.f22222d != null) {
            this.f22222d.setClassLoader(getClass().getClassLoader());
        }
        return this.f22222d != null ? this.f22222d.get(str) : null;
    }

    public final Bundle m30135m() {
        return this.f22222d;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f22220b ? 1 : 0);
        parcel.writeString(this.f22221c);
        parcel.writeBundle(this.f22222d);
        parcel.writeString(this.f22223e.toString());
        parcel.writeString(this.f22224f);
        parcel.writeSerializable(this.f22225g);
    }
}

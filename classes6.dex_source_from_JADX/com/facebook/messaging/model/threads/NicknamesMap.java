package com.facebook.messaging.model.threads;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.common.util.JSONUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.RegularImmutableBiMap;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: update_relationship_status */
public class NicknamesMap implements Parcelable {
    public static final Creator<NicknamesMap> CREATOR = new C01162();
    @Nullable
    private String f2236a;
    @Nullable
    private ImmutableMap<String, String> f2237b;

    /* compiled from: update_relationship_status */
    class C01151 extends TypeReference<ImmutableMap<String, String>> {
        final /* synthetic */ NicknamesMap f2235b;

        C01151(NicknamesMap nicknamesMap) {
            this.f2235b = nicknamesMap;
        }
    }

    /* compiled from: update_relationship_status */
    final class C01162 implements Creator<NicknamesMap> {
        C01162() {
        }

        public final Object createFromParcel(Parcel parcel) {
            ImmutableMap immutableMap = null;
            String readString = parcel.readInt() != 0 ? parcel.readString() : null;
            if (parcel.readInt() != 0) {
                Map hashMap = new HashMap();
                ParcelUtil.b(parcel, hashMap);
                immutableMap = ImmutableMap.copyOf(hashMap);
            }
            return new NicknamesMap(readString, immutableMap);
        }

        public final Object[] newArray(int i) {
            return new NicknamesMap[i];
        }
    }

    public NicknamesMap() {
        this.f2237b = RegularImmutableBiMap.a;
    }

    public NicknamesMap(@Nullable String str) {
        if ("{}".equals(str)) {
            this.f2236a = null;
        } else {
            this.f2236a = str;
        }
    }

    public NicknamesMap(Map<String, String> map) {
        this.f2237b = map != null ? ImmutableMap.copyOf(map) : null;
    }

    public NicknamesMap(@Nullable String str, @Nullable ImmutableMap<String, String> immutableMap) {
        this.f2236a = str;
        this.f2237b = immutableMap;
    }

    @Nullable
    public final String m3519a(String str, ObjectMapper objectMapper) {
        return (String) m3516b(objectMapper).get(str);
    }

    public final ImmutableMap<String, String> m3517a(ObjectMapper objectMapper) {
        return m3516b(objectMapper);
    }

    @Nullable
    public final String m3518a() {
        if (!(this.f2236a != null || this.f2237b == null || this.f2237b.isEmpty())) {
            this.f2236a = JSONUtil.a(this.f2237b).toString();
        }
        return this.f2236a;
    }

    private ImmutableMap<String, String> m3516b(ObjectMapper objectMapper) {
        if (this.f2237b == null) {
            if (this.f2236a == null) {
                this.f2237b = ImmutableBiMap.a();
            } else {
                try {
                    this.f2237b = (ImmutableMap) objectMapper.a(this.f2236a, new C01151(this));
                } catch (IOException e) {
                    this.f2237b = ImmutableBiMap.a();
                }
            }
        }
        return this.f2237b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof NicknamesMap)) {
            return false;
        }
        NicknamesMap nicknamesMap = (NicknamesMap) obj;
        if ((this.f2236a == null || !this.f2236a.equals(nicknamesMap.f2236a)) && !Objects.equal(this.f2237b, nicknamesMap.f2237b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode;
        int i = 0;
        if (this.f2236a != null) {
            hashCode = this.f2236a.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode *= 31;
        if (this.f2237b != null) {
            i = this.f2237b.hashCode();
        }
        return hashCode + i;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeInt(this.f2236a != null ? 1 : 0);
        if (this.f2236a != null) {
            parcel.writeString(this.f2236a);
        }
        if (this.f2237b == null) {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.f2237b != null) {
            ParcelUtil.a(parcel, this.f2237b);
        }
    }
}

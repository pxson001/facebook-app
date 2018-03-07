package com.facebook.livephotos.exoplayer.drm;

import com.facebook.livephotos.exoplayer.util.Assertions;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* compiled from: page_unlike_error */
public interface DrmInitData {

    /* compiled from: page_unlike_error */
    public final class Mapped implements DrmInitData {
        public final Map<UUID, SchemeInitData> f6951a = new HashMap();
    }

    /* compiled from: page_unlike_error */
    public final class SchemeInitData {
        public final String f6952a;
        public final byte[] f6953b;

        public SchemeInitData(String str, byte[] bArr) {
            this.f6952a = (String) Assertions.m9293a((Object) str);
            this.f6953b = (byte[]) Assertions.m9293a((Object) bArr);
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof SchemeInitData)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            SchemeInitData schemeInitData = (SchemeInitData) obj;
            if (this.f6952a.equals(schemeInitData.f6952a) && Arrays.equals(this.f6953b, schemeInitData.f6953b)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return this.f6952a.hashCode() + (Arrays.hashCode(this.f6953b) * 31);
        }
    }

    /* compiled from: page_unlike_error */
    public final class Universal implements DrmInitData {
        private SchemeInitData f6954a;

        public Universal(SchemeInitData schemeInitData) {
            this.f6954a = schemeInitData;
        }
    }
}

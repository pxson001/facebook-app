package com.google.android.gms.cast;

import android.util.SparseArray;
import com.google.android.gms.cast.internal.zzf;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class MediaStatus {
    public int f10018a = 0;
    public long f10019b;
    public MediaInfo f10020c;
    private double f10021d;
    public int f10022e;
    public int f10023f;
    private long f10024g;
    private long f10025h;
    private double f10026i;
    private boolean f10027j;
    private long[] f10028k;
    private JSONObject f10029l;
    private int f10030m = 0;
    private int f10031n = 0;
    private final zza f10032o = new zza(this);

    public class zza {
        final /* synthetic */ MediaStatus f10014a;
        private int f10015b = 0;
        public List<MediaQueueItem> f10016c = new ArrayList();
        public SparseArray<Integer> f10017d = new SparseArray();

        zza(MediaStatus mediaStatus) {
            this.f10014a = mediaStatus;
        }

        private void m11789a(MediaQueueItem[] mediaQueueItemArr) {
            this.f10016c.clear();
            this.f10017d.clear();
            for (int i = 0; i < mediaQueueItemArr.length; i++) {
                MediaQueueItem mediaQueueItem = mediaQueueItemArr[i];
                this.f10016c.add(mediaQueueItem);
                this.f10017d.put(mediaQueueItem.f10007b, Integer.valueOf(i));
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static boolean m11790a(com.google.android.gms.cast.MediaStatus.zza r12, org.json.JSONObject r13) {
            /*
            r3 = 3;
            r0 = 2;
            r1 = 0;
            r2 = 1;
            r4 = "repeatMode";
            r4 = r13.has(r4);
            if (r4 == 0) goto L_0x0104;
        L_0x000c:
            r4 = r12.f10015b;
            r5 = "repeatMode";
            r6 = r13.getString(r5);
            r5 = -1;
            r7 = r6.hashCode();
            switch(r7) {
                case -1118317585: goto L_0x0073;
                case -962896020: goto L_0x0069;
                case 1645938909: goto L_0x005f;
                case 1645952171: goto L_0x0055;
                default: goto L_0x001c;
            };
        L_0x001c:
            switch(r5) {
                case 0: goto L_0x007d;
                case 1: goto L_0x007f;
                case 2: goto L_0x0020;
                case 3: goto L_0x0081;
                default: goto L_0x001f;
            };
        L_0x001f:
            r0 = r4;
        L_0x0020:
            r3 = r12.f10015b;
            if (r3 == r0) goto L_0x0104;
        L_0x0024:
            r12.f10015b = r0;
            r0 = r2;
        L_0x0027:
            r3 = "items";
            r3 = r13.has(r3);
            if (r3 == 0) goto L_0x0102;
        L_0x002f:
            r3 = "items";
            r4 = r13.getJSONArray(r3);
            r5 = r4.length();
            r6 = new android.util.SparseArray;
            r6.<init>();
            r3 = r1;
        L_0x003f:
            if (r3 >= r5) goto L_0x0083;
        L_0x0041:
            r7 = r4.getJSONObject(r3);
            r8 = "itemId";
            r7 = r7.getInt(r8);
            r7 = java.lang.Integer.valueOf(r7);
            r6.put(r3, r7);
            r3 = r3 + 1;
            goto L_0x003f;
        L_0x0055:
            r7 = "REPEAT_OFF";
            r6 = r6.equals(r7);
            if (r6 == 0) goto L_0x001c;
        L_0x005d:
            r5 = r1;
            goto L_0x001c;
        L_0x005f:
            r7 = "REPEAT_ALL";
            r6 = r6.equals(r7);
            if (r6 == 0) goto L_0x001c;
        L_0x0067:
            r5 = r2;
            goto L_0x001c;
        L_0x0069:
            r7 = "REPEAT_SINGLE";
            r6 = r6.equals(r7);
            if (r6 == 0) goto L_0x001c;
        L_0x0071:
            r5 = r0;
            goto L_0x001c;
        L_0x0073:
            r7 = "REPEAT_ALL_AND_SHUFFLE";
            r6 = r6.equals(r7);
            if (r6 == 0) goto L_0x001c;
        L_0x007b:
            r5 = r3;
            goto L_0x001c;
        L_0x007d:
            r0 = r1;
            goto L_0x0020;
        L_0x007f:
            r0 = r2;
            goto L_0x0020;
        L_0x0081:
            r0 = r3;
            goto L_0x0020;
        L_0x0083:
            r7 = new com.google.android.gms.cast.MediaQueueItem[r5];
            r3 = r1;
            r1 = r0;
        L_0x0087:
            if (r3 >= r5) goto L_0x00f2;
        L_0x0089:
            r0 = r6.get(r3);
            r0 = (java.lang.Integer) r0;
            r8 = r4.getJSONObject(r3);
            r9 = r0.intValue();
            r10 = r12.f10017d;
            r10 = r10.get(r9);
            r10 = (java.lang.Integer) r10;
            if (r10 != 0) goto L_0x0107;
        L_0x00a1:
            r10 = 0;
        L_0x00a2:
            r9 = r10;
            if (r9 == 0) goto L_0x00c5;
        L_0x00a5:
            r8 = r9.m11787a(r8);
            r1 = r1 | r8;
            r7[r3] = r9;
            r0 = r0.intValue();
            r10 = r12.f10017d;
            r10 = r10.get(r0);
            r10 = (java.lang.Integer) r10;
            r0 = r10;
            r0 = r0.intValue();
            if (r3 == r0) goto L_0x0100;
        L_0x00bf:
            r0 = r2;
        L_0x00c0:
            r1 = r3 + 1;
            r3 = r1;
            r1 = r0;
            goto L_0x0087;
        L_0x00c5:
            r0 = r0.intValue();
            r1 = r12.f10014a;
            r1 = r1.f10018a;
            if (r0 != r1) goto L_0x00e9;
        L_0x00cf:
            r0 = new com.google.android.gms.cast.MediaQueueItem$Builder;
            r1 = r12.f10014a;
            r1 = r1.f10020c;
            r0.<init>(r1);
            r10 = r0.f10005a;
            r10.m11788b();
            r10 = r0.f10005a;
            r0 = r10;
            r7[r3] = r0;
            r0 = r7[r3];
            r0.m11787a(r8);
            r0 = r2;
            goto L_0x00c0;
        L_0x00e9:
            r0 = new com.google.android.gms.cast.MediaQueueItem;
            r0.<init>(r8);
            r7[r3] = r0;
            r0 = r2;
            goto L_0x00c0;
        L_0x00f2:
            r0 = r12.f10016c;
            r0 = r0.size();
            if (r0 == r5) goto L_0x00fe;
        L_0x00fa:
            r12.m11789a(r7);
        L_0x00fd:
            return r2;
        L_0x00fe:
            r2 = r1;
            goto L_0x00fa;
        L_0x0100:
            r0 = r1;
            goto L_0x00c0;
        L_0x0102:
            r2 = r0;
            goto L_0x00fd;
        L_0x0104:
            r0 = r1;
            goto L_0x0027;
        L_0x0107:
            r11 = r12.f10016c;
            r10 = r10.intValue();
            r10 = r11.get(r10);
            r10 = (com.google.android.gms.cast.MediaQueueItem) r10;
            goto L_0x00a2;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.MediaStatus.zza.a(com.google.android.gms.cast.MediaStatus$zza, org.json.JSONObject):boolean");
        }

        public static void m11791b(zza com_google_android_gms_cast_MediaStatus_zza) {
            com_google_android_gms_cast_MediaStatus_zza.f10015b = 0;
            com_google_android_gms_cast_MediaStatus_zza.f10016c.clear();
            com_google_android_gms_cast_MediaStatus_zza.f10017d.clear();
        }

        public final int m11792a() {
            return this.f10016c.size();
        }
    }

    public MediaStatus(JSONObject jSONObject) {
        m11794a(jSONObject, 0);
    }

    private static boolean m11793a(int i, int i2) {
        return i == 1 && i2 == 0;
    }

    public final int m11794a(JSONObject jSONObject, int i) {
        int i2;
        int i3;
        double d;
        long a;
        long[] jArr;
        int i4 = 2;
        int i5 = 1;
        long j = jSONObject.getLong("mediaSessionId");
        if (j != this.f10019b) {
            this.f10019b = j;
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (jSONObject.has("playerState")) {
            String string = jSONObject.getString("playerState");
            i3 = string.equals("IDLE") ? 1 : string.equals("PLAYING") ? 2 : string.equals("PAUSED") ? 3 : string.equals("BUFFERING") ? 4 : 0;
            if (i3 != this.f10022e) {
                this.f10022e = i3;
                i2 |= 2;
            }
            if (i3 == 1 && jSONObject.has("idleReason")) {
                string = jSONObject.getString("idleReason");
                if (!string.equals("CANCELLED")) {
                    i4 = string.equals("INTERRUPTED") ? 3 : string.equals("FINISHED") ? 1 : string.equals("ERROR") ? 4 : 0;
                }
                if (i4 != this.f10023f) {
                    this.f10023f = i4;
                    i2 |= 2;
                }
            }
        }
        if (jSONObject.has("playbackRate")) {
            d = jSONObject.getDouble("playbackRate");
            if (this.f10021d != d) {
                this.f10021d = d;
                i2 |= 2;
            }
        }
        if (jSONObject.has("currentTime") && (i & 2) == 0) {
            a = zzf.m11920a(jSONObject.getDouble("currentTime"));
            if (a != this.f10024g) {
                this.f10024g = a;
                i2 |= 2;
            }
        }
        if (jSONObject.has("supportedMediaCommands")) {
            a = jSONObject.getLong("supportedMediaCommands");
            if (a != this.f10025h) {
                this.f10025h = a;
                i2 |= 2;
            }
        }
        if (jSONObject.has("volume") && (i & 1) == 0) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("volume");
            d = jSONObject2.getDouble("level");
            if (d != this.f10026i) {
                this.f10026i = d;
                i2 |= 2;
            }
            boolean z = jSONObject2.getBoolean("muted");
            if (z != this.f10027j) {
                this.f10027j = z;
                i2 |= 2;
            }
        }
        if (jSONObject.has("activeTrackIds")) {
            JSONArray jSONArray = jSONObject.getJSONArray("activeTrackIds");
            int length = jSONArray.length();
            long[] jArr2 = new long[length];
            for (i4 = 0; i4 < length; i4++) {
                jArr2[i4] = jSONArray.getLong(i4);
            }
            if (this.f10028k != null && this.f10028k.length == length) {
                for (i4 = 0; i4 < length; i4++) {
                    if (this.f10028k[i4] != jArr2[i4]) {
                        break;
                    }
                }
                i5 = 0;
            }
            if (i5 != 0) {
                this.f10028k = jArr2;
            }
            long[] jArr3 = jArr2;
            i3 = i5;
            jArr = jArr3;
        } else if (this.f10028k != null) {
            i3 = 1;
            jArr = null;
        } else {
            jArr = null;
            i3 = 0;
        }
        if (i3 != 0) {
            this.f10028k = jArr;
            i2 |= 2;
        }
        if (jSONObject.has("customData")) {
            this.f10029l = jSONObject.getJSONObject("customData");
            i2 |= 2;
        }
        if (jSONObject.has("media")) {
            JSONObject jSONObject3 = jSONObject.getJSONObject("media");
            this.f10020c = new MediaInfo(jSONObject3);
            i2 |= 2;
            if (jSONObject3.has("metadata")) {
                i2 |= 4;
            }
        }
        if (jSONObject.has("currentItemId")) {
            i5 = jSONObject.getInt("currentItemId");
            if (this.f10018a != i5) {
                this.f10018a = i5;
                i2 |= 2;
            }
        }
        i5 = jSONObject.optInt("preloadedItemId", 0);
        if (this.f10031n != i5) {
            this.f10031n = i5;
            i2 |= 16;
        }
        i5 = jSONObject.optInt("loadingItemId", 0);
        if (this.f10030m != i5) {
            this.f10030m = i5;
            i2 |= 2;
        }
        if (!m11793a(this.f10022e, this.f10030m)) {
            return zza.m11790a(this.f10032o, jSONObject) ? i2 | 8 : i2;
        } else {
            this.f10018a = 0;
            this.f10030m = 0;
            this.f10031n = 0;
            if (this.f10032o.m11792a() <= 0) {
                return i2;
            }
            zza.m11791b(this.f10032o);
            return i2 | 8;
        }
    }

    public final long m11795a() {
        return this.f10019b;
    }

    public final double m11796d() {
        return this.f10021d;
    }

    public final long m11797f() {
        return this.f10024g;
    }
}

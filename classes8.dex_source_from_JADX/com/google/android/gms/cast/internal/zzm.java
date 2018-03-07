package com.google.android.gms.cast.internal;

import android.os.SystemClock;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaStatus;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class zzm extends zzc {
    private static final String f10065a = ("urn:x-cast:" + "com.google.cast.media");
    private long f10066g;
    public MediaStatus f10067h;
    private final List<zzp> f10068i = new ArrayList();
    private final zzp f10069j = new zzp(86400000);
    private final zzp f10070k = new zzp(86400000);
    private final zzp f10071l = new zzp(86400000);
    private final zzp f10072m = new zzp(86400000);
    private final zzp f10073n = new zzp(86400000);
    private final zzp f10074o = new zzp(86400000);
    private final zzp f10075p = new zzp(86400000);
    private final zzp f10076q = new zzp(86400000);
    private final zzp f10077r = new zzp(86400000);
    private final zzp f10078s = new zzp(86400000);
    private final zzp f10079t = new zzp(86400000);
    private final zzp f10080u = new zzp(86400000);
    private final zzp f10081v = new zzp(86400000);
    private final zzp f10082w = new zzp(86400000);

    public zzm(String str) {
        super(f10065a, "MediaControlChannel", str, 1000);
        this.f10068i.add(this.f10069j);
        this.f10068i.add(this.f10070k);
        this.f10068i.add(this.f10071l);
        this.f10068i.add(this.f10072m);
        this.f10068i.add(this.f10073n);
        this.f10068i.add(this.f10074o);
        this.f10068i.add(this.f10075p);
        this.f10068i.add(this.f10076q);
        this.f10068i.add(this.f10077r);
        this.f10068i.add(this.f10078s);
        this.f10068i.add(this.f10079t);
        this.f10068i.add(this.f10080u);
        this.f10068i.add(this.f10081v);
        this.f10068i.add(this.f10082w);
        m11816j();
    }

    private void m11814a(long j, JSONObject jSONObject) {
        int i = 1;
        boolean a = this.f10069j.m11962a(j);
        int i2 = (!this.f10073n.m11965b() || this.f10073n.m11962a(j)) ? 0 : 1;
        if ((!this.f10074o.m11965b() || this.f10074o.m11962a(j)) && (!this.f10075p.m11965b() || this.f10075p.m11962a(j))) {
            i = 0;
        }
        i2 = i2 != 0 ? 2 : 0;
        if (i != 0) {
            i2 |= 1;
        }
        if (a || this.f10067h == null) {
            this.f10067h = new MediaStatus(jSONObject);
            this.f10066g = SystemClock.elapsedRealtime();
            i2 = 31;
        } else {
            i2 = this.f10067h.m11794a(jSONObject, i2);
        }
        if ((i2 & 1) != 0) {
            this.f10066g = SystemClock.elapsedRealtime();
            mo643a();
        }
        if ((i2 & 2) != 0) {
            this.f10066g = SystemClock.elapsedRealtime();
            mo643a();
        }
        if ((i2 & 4) != 0) {
            mo644b();
        }
        for (zzp a2 : this.f10068i) {
            a2.m11963a(j, 0);
        }
    }

    private long m11815i() {
        if (this.f10067h != null) {
            return this.f10067h.f10019b;
        }
        throw new IllegalStateException("No current media session");
    }

    private void m11816j() {
        this.f10066g = 0;
        this.f10067h = null;
        for (zzp a : this.f10068i) {
            a.m11960a();
        }
    }

    public final long m11817a(zzo com_google_android_gms_cast_internal_zzo) {
        JSONObject jSONObject = new JSONObject();
        long e = m11810e();
        this.f10076q.m11961a(e, com_google_android_gms_cast_internal_zzo);
        m11811a(true);
        try {
            jSONObject.put("requestId", e);
            jSONObject.put("type", "GET_STATUS");
            if (this.f10067h != null) {
                jSONObject.put("mediaSessionId", this.f10067h.m11795a());
            }
        } catch (JSONException e2) {
        }
        m11808a(jSONObject.toString(), e, null);
        return e;
    }

    public final long m11818a(zzo com_google_android_gms_cast_internal_zzo, long j, int i, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        long e = m11810e();
        this.f10073n.m11961a(e, com_google_android_gms_cast_internal_zzo);
        m11811a(true);
        try {
            jSONObject2.put("requestId", e);
            jSONObject2.put("type", "SEEK");
            jSONObject2.put("mediaSessionId", m11815i());
            jSONObject2.put("currentTime", zzf.m11919a(j));
            if (i == 1) {
                jSONObject2.put("resumeState", "PLAYBACK_START");
            } else if (i == 2) {
                jSONObject2.put("resumeState", "PLAYBACK_PAUSE");
            }
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e2) {
        }
        m11808a(jSONObject2.toString(), e, null);
        return e;
    }

    public final long m11819a(zzo com_google_android_gms_cast_internal_zzo, MediaInfo mediaInfo, boolean z, long j, long[] jArr, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        long e = m11810e();
        this.f10069j.m11961a(e, com_google_android_gms_cast_internal_zzo);
        m11811a(true);
        try {
            jSONObject2.put("requestId", e);
            jSONObject2.put("type", "LOAD");
            jSONObject2.put("media", mediaInfo.m11774c());
            jSONObject2.put("autoplay", z);
            jSONObject2.put("currentTime", zzf.m11919a(j));
            if (jArr != null) {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < jArr.length; i++) {
                    jSONArray.put(i, jArr[i]);
                }
                jSONObject2.put("activeTrackIds", jSONArray);
            }
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e2) {
        }
        m11808a(jSONObject2.toString(), e, null);
        return e;
    }

    public final long m11820a(zzo com_google_android_gms_cast_internal_zzo, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        long e = m11810e();
        this.f10070k.m11961a(e, com_google_android_gms_cast_internal_zzo);
        m11811a(true);
        try {
            jSONObject2.put("requestId", e);
            jSONObject2.put("type", "PAUSE");
            jSONObject2.put("mediaSessionId", m11815i());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e2) {
        }
        m11808a(jSONObject2.toString(), e, null);
        return e;
    }

    protected void mo643a() {
    }

    public final void mo640a(long j, int i) {
        for (zzp a : this.f10068i) {
            a.m11963a(j, i);
        }
    }

    public final void mo641a(String str) {
        this.f10060f.m11956b("message received: %s", str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("type");
            long optLong = jSONObject.optLong("requestId", -1);
            if (string.equals("MEDIA_STATUS")) {
                JSONArray jSONArray = jSONObject.getJSONArray("status");
                if (jSONArray.length() > 0) {
                    m11814a(optLong, jSONArray.getJSONObject(0));
                    return;
                }
                this.f10067h = null;
                mo643a();
                mo644b();
                this.f10076q.m11963a(optLong, 0);
            } else if (string.equals("INVALID_PLAYER_STATE")) {
                this.f10060f.m11958d("received unexpected error: Invalid Player State.", new Object[0]);
                r1 = jSONObject.optJSONObject("customData");
                for (zzp a : this.f10068i) {
                    a.m11964a(optLong, 2100, r1);
                }
            } else if (string.equals("LOAD_FAILED")) {
                this.f10069j.m11964a(optLong, 2100, jSONObject.optJSONObject("customData"));
            } else if (string.equals("LOAD_CANCELLED")) {
                this.f10069j.m11964a(optLong, 2101, jSONObject.optJSONObject("customData"));
            } else if (string.equals("INVALID_REQUEST")) {
                this.f10060f.m11958d("received unexpected error: Invalid Request.", new Object[0]);
                r1 = jSONObject.optJSONObject("customData");
                for (zzp a2 : this.f10068i) {
                    a2.m11964a(optLong, 2100, r1);
                }
            }
        } catch (JSONException e) {
            this.f10060f.m11958d("Message is malformed (%s); ignoring: %s", e.getMessage(), str);
        }
    }

    protected final boolean mo642a(long j) {
        boolean z;
        for (zzp b : this.f10068i) {
            b.m11966b(j, 2102);
        }
        synchronized (zzp.f10181a) {
            for (zzp b2 : this.f10068i) {
                if (b2.m11965b()) {
                    z = true;
                    break;
                }
            }
            z = false;
        }
        return z;
    }

    public final long m11825b(zzo com_google_android_gms_cast_internal_zzo, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        long e = m11810e();
        this.f10072m.m11961a(e, com_google_android_gms_cast_internal_zzo);
        m11811a(true);
        try {
            jSONObject2.put("requestId", e);
            jSONObject2.put("type", "STOP");
            jSONObject2.put("mediaSessionId", m11815i());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e2) {
        }
        m11808a(jSONObject2.toString(), e, null);
        return e;
    }

    protected void mo644b() {
    }

    public final long m11827c(zzo com_google_android_gms_cast_internal_zzo, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        long e = m11810e();
        this.f10071l.m11961a(e, com_google_android_gms_cast_internal_zzo);
        m11811a(true);
        try {
            jSONObject2.put("requestId", e);
            jSONObject2.put("type", "PLAY");
            jSONObject2.put("mediaSessionId", m11815i());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e2) {
        }
        m11808a(jSONObject2.toString(), e, null);
        return e;
    }

    public final void mo639c() {
        super.mo639c();
        m11816j();
    }

    public final long m11829f() {
        MediaInfo mediaInfo = this.f10067h == null ? null : this.f10067h.f10020c;
        if (mediaInfo == null || this.f10066g == 0) {
            return 0;
        }
        double d = this.f10067h.m11796d();
        long f = this.f10067h.m11797f();
        int i = this.f10067h.f10022e;
        if (d == 0.0d || i != 2) {
            return f;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f10066g;
        long j = elapsedRealtime < 0 ? 0 : elapsedRealtime;
        if (j == 0) {
            return f;
        }
        elapsedRealtime = mediaInfo.m11770a();
        f += (long) (((double) j) * d);
        if (elapsedRealtime <= 0 || f <= elapsedRealtime) {
            elapsedRealtime = f < 0 ? 0 : f;
        }
        return elapsedRealtime;
    }

    public final MediaStatus m11830g() {
        return this.f10067h;
    }
}

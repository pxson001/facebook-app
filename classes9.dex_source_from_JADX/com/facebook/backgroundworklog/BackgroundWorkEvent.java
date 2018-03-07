package com.facebook.backgroundworklog;

import android.os.Process;
import com.google.common.base.Preconditions;
import java.util.EnumSet;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* compiled from: selectedBudget */
public class BackgroundWorkEvent {
    public final String f4222a;
    public final String f4223b;
    public final int f4224c;
    public final String f4225d;
    public final int f4226e;
    public final long f4227f;
    public final long f4228g;
    public final long f4229h;
    public final boolean f4230i;
    public final long f4231j;
    private final EnumSet<BackgroundWorkAppState> f4232k;

    /* compiled from: selectedBudget */
    public class Builder {
        public String f4210a;
        public String f4211b;
        public int f4212c;
        public String f4213d;
        public int f4214e;
        public long f4215f;
        public long f4216g;
        public long f4217h;
        public EnumSet<BackgroundWorkAppState> f4218i;
        public boolean f4219j;
        public long f4220k;
        public long f4221l;

        public final BackgroundWorkEvent m4240a() {
            Preconditions.checkState(this.f4216g >= this.f4215f, "task started before it was queued?");
            Preconditions.checkState(this.f4217h >= this.f4216g, "task finished before it started?");
            Preconditions.checkState(this.f4221l >= this.f4220k, "CPU usage must increase");
            long j = 0;
            if (this.f4220k > 0 && this.f4221l > 0) {
                j = this.f4221l - this.f4220k;
            }
            return new BackgroundWorkEvent(this.f4210a, this.f4211b, this.f4212c, this.f4213d, this.f4214e, this.f4215f, this.f4216g, this.f4217h, this.f4218i, this.f4219j, j);
        }
    }

    public final EnumSet<BackgroundWorkAppState> m4242b() {
        return EnumSet.copyOf(this.f4232k);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("type: ").append(this.f4222a).append(", name: ").append(this.f4223b).append(", tid: ").append(Integer.toHexString(this.f4224c)).append(", prio: ").append(this.f4226e).append(", waitTime: ").append(this.f4228g - this.f4227f).append(", execTime: ").append(this.f4229h - this.f4228g).append(", cpuTime: ").append(this.f4231j).append(", state: ").append(BackgroundWorkAppState.statesToString(this.f4232k));
        return stringBuilder.toString();
    }

    private BackgroundWorkEvent(String str, String str2, int i, String str3, int i2, long j, long j2, long j3, EnumSet<BackgroundWorkAppState> enumSet, boolean z, long j4) {
        this.f4222a = (String) Preconditions.checkNotNull(str);
        this.f4223b = (String) Preconditions.checkNotNull(str2);
        this.f4224c = i;
        this.f4225d = (String) Preconditions.checkNotNull(str3);
        this.f4226e = i2;
        this.f4227f = j;
        this.f4228g = j2;
        this.f4229h = j3;
        this.f4232k = (EnumSet) Preconditions.checkNotNull(enumSet);
        this.f4230i = z;
        this.f4231j = j4;
    }

    public final JSONObject m4243d() {
        JSONObject f = m4241f();
        f.put("ph", "B");
        f.put("ts", TimeUnit.MILLISECONDS.toMicros(this.f4228g));
        return f;
    }

    public final JSONObject m4244e() {
        JSONObject f = m4241f();
        f.put("ph", "E");
        f.put("ts", TimeUnit.MILLISECONDS.toMicros(this.f4229h));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("Thread Priority", this.f4226e);
        jSONObject.put("Elapsed CPU ms", TimeUnit.NANOSECONDS.toMillis(this.f4231j));
        f.put("args", jSONObject);
        return f;
    }

    private JSONObject m4241f() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cat", this.f4222a);
        jSONObject.put("name", this.f4223b);
        jSONObject.put("pid", Process.myPid());
        jSONObject.put("tid", this.f4225d + " " + this.f4224c);
        return jSONObject;
    }
}

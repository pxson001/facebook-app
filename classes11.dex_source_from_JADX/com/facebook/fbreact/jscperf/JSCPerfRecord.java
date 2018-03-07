package com.facebook.fbreact.jscperf;

import com.facebook.react.bridge.ReadableMap;

/* compiled from: extra_notes_id */
public class JSCPerfRecord {
    public final int f7339a;
    public int f7340b;
    public int f7341c;
    public int f7342d;
    public double f7343e;
    public double f7344f;

    public JSCPerfRecord(ReadableMap readableMap) {
        ReadableMap b = readableMap.b("heap_stats");
        this.f7339a = b.getInt("size");
        this.f7340b = b.getInt("extra_size");
        this.f7341c = b.getInt("capacity");
        this.f7342d = b.getInt("object_count");
        b = readableMap.b("gc_stats");
        this.f7343e = b.getDouble("last_eden_gc_length");
        this.f7344f = b.getDouble("last_full_gc_length");
    }
}

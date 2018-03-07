package com.facebook.analytics2.logger;

/* compiled from: tap_search_bar */
public class UploadSchedulerParams {
    public final long f3208a;
    public final long f3209b;
    public final long f3210c;
    public final long f3211d;

    public UploadSchedulerParams(long j, long j2, long j3, long j4) {
        this.f3208a = j;
        this.f3209b = j2;
        this.f3210c = j3;
        this.f3211d = j4;
    }

    public String toString() {
        return "{single=(" + this.f3208a + "," + this.f3209b + "), batch=(" + this.f3210c + "," + this.f3211d + ")}";
    }
}

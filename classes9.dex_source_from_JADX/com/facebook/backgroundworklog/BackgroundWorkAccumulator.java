package com.facebook.backgroundworklog;

import com.google.common.base.Preconditions;
import java.util.EnumSet;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: selectedPhotoIdParam */
public class BackgroundWorkAccumulator {
    public final String f4200a;
    public final String f4201b;
    @GuardedBy("this")
    private long f4202c;
    @GuardedBy("this")
    private long f4203d;
    @GuardedBy("this")
    private long f4204e;
    @GuardedBy("this")
    private long f4205f;
    @GuardedBy("this")
    private long f4206g;
    @GuardedBy("this")
    private long f4207h;
    @GuardedBy("this")
    private long f4208i;
    @GuardedBy("this")
    private long f4209j;

    public BackgroundWorkAccumulator(String str, String str2) {
        this.f4200a = str;
        this.f4201b = str2;
    }

    public final synchronized void m4239a(BackgroundWorkEvent backgroundWorkEvent) {
        Preconditions.checkArgument(this.f4200a.equals(backgroundWorkEvent.f4222a), "event type must match accumulator type");
        Preconditions.checkArgument(this.f4201b.equals(backgroundWorkEvent.f4223b), "event name must match accumulator name");
        long j = backgroundWorkEvent.f4229h - backgroundWorkEvent.f4228g;
        long j2 = backgroundWorkEvent.f4228g - backgroundWorkEvent.f4227f;
        this.f4202c++;
        this.f4206g += j;
        this.f4207h = j2 + this.f4207h;
        this.f4209j += backgroundWorkEvent.f4231j;
        this.f4208i = backgroundWorkEvent.f4229h;
        EnumSet b = backgroundWorkEvent.m4242b();
        if (b.contains(BackgroundWorkAppState.INITIALIZING) || b.contains(BackgroundWorkAppState.LOADING)) {
            this.f4203d += j;
        }
        if (b.contains(BackgroundWorkAppState.LOADING_UI) || b.contains(BackgroundWorkAppState.INTERACTIVE)) {
            this.f4204e += j;
        }
        if (b.contains(BackgroundWorkAppState.BACKGROUND)) {
            this.f4205f = j + this.f4205f;
        }
    }
}

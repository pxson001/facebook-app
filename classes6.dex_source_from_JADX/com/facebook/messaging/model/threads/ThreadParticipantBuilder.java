package com.facebook.messaging.model.threads;

import com.facebook.messaging.model.messages.ParticipantInfo;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: updateAlbumParams */
public class ThreadParticipantBuilder {
    @Nullable
    public ParticipantInfo f2282a;
    public long f2283b;
    @Nullable
    public String f2284c;
    public long f2285d;
    public boolean f2286e;

    public final ThreadParticipantBuilder m3556a(ThreadParticipant threadParticipant) {
        this.f2282a = threadParticipant.f2277a;
        this.f2283b = threadParticipant.f2278b;
        this.f2284c = threadParticipant.f2279c;
        this.f2285d = threadParticipant.f2280d;
        this.f2286e = threadParticipant.f2281e;
        return this;
    }

    public final ThreadParticipantBuilder m3555a(ParticipantInfo participantInfo) {
        this.f2282a = participantInfo;
        return this;
    }

    public final long m3557b() {
        return this.f2283b;
    }

    public final ThreadParticipantBuilder m3554a(long j) {
        this.f2283b = j;
        return this;
    }

    public final ThreadParticipantBuilder m3558b(long j) {
        this.f2285d = j;
        return this;
    }

    public final ThreadParticipant m3559f() {
        return new ThreadParticipant(this);
    }
}

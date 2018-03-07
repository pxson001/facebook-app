package com.facebook.qe.api;

import android.content.res.Resources;
import javax.annotation.Nullable;

/* compiled from: unfriended_user_id */
public interface QeAccessor {
    float mo571a(float f, float f2);

    int mo572a(int i, int i2);

    int mo573a(Liveness liveness, int i, int i2);

    int mo574a(Liveness liveness, ExposureLogging exposureLogging, int i, int i2);

    long mo575a(long j, long j2);

    long mo576a(Liveness liveness, long j, long j2);

    long mo577a(Liveness liveness, ExposureLogging exposureLogging, long j, long j2);

    @Nullable
    <T extends Enum> T mo578a(double d, Class<T> cls, T t);

    @Nullable
    <T extends Enum> T mo579a(Liveness liveness, ExposureLogging exposureLogging, double d, Class<T> cls, T t);

    @Nullable
    String mo580a(char c, int i, Resources resources);

    @Nullable
    String mo581a(char c, String str);

    @Nullable
    String mo582a(Liveness liveness, char c, int i, Resources resources);

    @Nullable
    String mo583a(Liveness liveness, char c, String str);

    @Nullable
    String mo584a(Liveness liveness, ExposureLogging exposureLogging, char c, int i, Resources resources);

    @Nullable
    String mo585a(Liveness liveness, ExposureLogging exposureLogging, char c, String str);

    void mo588a(Liveness liveness, char c);

    void mo589a(Liveness liveness, int i);

    void mo590a(Liveness liveness, short s);

    boolean mo593a(Liveness liveness, ExposureLogging exposureLogging, short s, boolean z);

    boolean mo594a(Liveness liveness, short s, boolean z);

    boolean mo596a(short s, boolean z);
}

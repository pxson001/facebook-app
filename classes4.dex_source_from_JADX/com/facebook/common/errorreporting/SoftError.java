package com.facebook.common.errorreporting;

import java.util.Arrays;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: privacy/ */
public class SoftError {
    public final String f4218a;
    public final String f4219b;
    public final Throwable f4220c;
    public final boolean f4221d;
    public final int f4222e;
    public final boolean f4223f;

    SoftError(SoftErrorBuilder softErrorBuilder) {
        this.f4218a = softErrorBuilder.f4224a;
        this.f4219b = softErrorBuilder.f4225b;
        this.f4220c = softErrorBuilder.f4226c;
        this.f4221d = softErrorBuilder.f4227d;
        this.f4222e = softErrorBuilder.f4228e;
        this.f4223f = softErrorBuilder.f4229f;
    }

    public static SoftErrorBuilder m4758a(String str, String str2) {
        SoftErrorBuilder softErrorBuilder = new SoftErrorBuilder();
        softErrorBuilder.f4224a = str;
        softErrorBuilder = softErrorBuilder;
        softErrorBuilder.f4225b = str2;
        return softErrorBuilder;
    }

    public static SoftError m4760b(String str, String str2) {
        SoftErrorBuilder softErrorBuilder = new SoftErrorBuilder();
        softErrorBuilder.f4224a = str;
        softErrorBuilder = softErrorBuilder;
        softErrorBuilder.f4225b = str2;
        return softErrorBuilder.m4765g();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SoftError softError = (SoftError) obj;
        if (this.f4221d != softError.f4221d) {
            return false;
        }
        if (this.f4223f != softError.f4223f) {
            return false;
        }
        if (this.f4222e != softError.f4222e) {
            return false;
        }
        if (!m4759a(this.f4218a, softError.f4218a)) {
            return false;
        }
        if (!m4759a(this.f4220c, softError.f4220c)) {
            return false;
        }
        if (m4759a(this.f4219b, softError.f4219b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f4218a, this.f4219b, Boolean.valueOf(this.f4221d), Integer.valueOf(this.f4222e)});
    }

    private static boolean m4759a(@Nullable Object obj, @Nullable Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}

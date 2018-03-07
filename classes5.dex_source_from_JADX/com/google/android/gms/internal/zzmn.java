package com.google.android.gms.internal;

import android.os.Handler;
import com.facebook.abtest.qe.protocol.sync.full.ViewerConfigurationQueryParsers.ConfigurationParser;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.android.gms.common.internal.zzx;

public final class zzmn<L> {
    private final zza f6886a;
    private volatile L f6887b;

    public final class zza extends Handler {
        public static void m12852b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("node");
                ConfigurationParser.m2448a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            jsonGenerator.g();
        }

        public static void m12851a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("description");
                jsonGenerator.b(mutableFlatBuffer.c(i, 0));
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("name");
                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
            }
            int g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("parameters");
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                    m12850a(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator);
                }
                jsonGenerator.e();
            }
            jsonGenerator.g();
        }

        public static void m12850a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("name");
                jsonGenerator.b(mutableFlatBuffer.c(i, 0));
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("string_value");
                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
            }
            jsonGenerator.g();
        }
    }

    public interface zzb<L> {
        void m12853a();

        void m12854a(L l);
    }

    public final void m12855a() {
        this.f6887b = null;
    }

    public final void m12856a(zzb<? super L> com_google_android_gms_internal_zzmn_zzb__super_L) {
        zzx.a(com_google_android_gms_internal_zzmn_zzb__super_L, "Notifier must not be null");
        this.f6886a.sendMessage(this.f6886a.obtainMessage(1, com_google_android_gms_internal_zzmn_zzb__super_L));
    }

    final void m12857b(zzb<? super L> com_google_android_gms_internal_zzmn_zzb__super_L) {
        Object obj = this.f6887b;
        if (obj == null) {
            com_google_android_gms_internal_zzmn_zzb__super_L.m12853a();
            return;
        }
        try {
            com_google_android_gms_internal_zzmn_zzb__super_L.m12854a(obj);
        } catch (RuntimeException e) {
            com_google_android_gms_internal_zzmn_zzb__super_L.m12853a();
            throw e;
        }
    }
}

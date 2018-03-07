package com.facebook.facedetection.detector;

import com.facebook.debug.log.BLog;
import com.facebook.device.CpuCapabilities;
import com.facebook.facedetection.models.Config;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: numAppearances */
public class MacerFaceDetectorConfiguration {
    private static final String f9809a = MacerFaceDetectorConfiguration.class.getSimpleName();
    private final CpuCapabilities f9810b;
    @Nullable
    private byte[] f9811c;

    @Inject
    public MacerFaceDetectorConfiguration(CpuCapabilities cpuCapabilities) {
        this.f9810b = cpuCapabilities;
    }

    public final synchronized byte[] m15559a() {
        byte[] bArr;
        if (this.f9811c != null) {
            bArr = this.f9811c;
        } else {
            boolean z = this.f9810b.a() || this.f9810b.b();
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            Config.m15575a(flatBufferBuilder, Config.m15574a(flatBufferBuilder, 1000, z));
            this.f9811c = flatBufferBuilder.m9975e();
            if (BLog.b(3)) {
                m15558a(this.f9811c);
            }
            bArr = this.f9811c;
        }
        return bArr;
    }

    private static void m15558a(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        Config config = new Config();
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        config.a = wrap.getInt(wrap.position()) + wrap.position();
        config.b = wrap;
        Table table = config;
        StringBuilder stringBuilder = new StringBuilder("MacerFaceDetector configuration: \n");
        StringBuilder append = stringBuilder.append("\t maxDetectionDim: ");
        int a = table.a(4);
        if (a != 0) {
            a = table.b.getInt(a + table.a);
        } else {
            a = 0;
        }
        append.append(a).append("\n");
        append = stringBuilder.append("\t neonEnabled: ");
        boolean z = false;
        int a2 = table.a(6);
        if (!(a2 == 0 || table.b.get(a2 + table.a) == (byte) 0)) {
            z = true;
        }
        append.append(z).append("\n");
        stringBuilder.append("\t total byte size: ").append(bArr.length).append("\n");
    }
}

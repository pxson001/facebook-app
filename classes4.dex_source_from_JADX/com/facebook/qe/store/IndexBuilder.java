package com.facebook.qe.store;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.qe.model.Experiment;
import com.facebook.qe.model.Parameter;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: updateDeviceEnabledOnServer */
public class IndexBuilder {
    public static byte[] m811a(Iterable<Experiment> iterable, boolean z) {
        int i;
        int i2;
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(2048);
        ArrayList arrayList = new ArrayList();
        for (Experiment experiment : iterable) {
            if (experiment.c == z) {
                arrayList.add(experiment.a);
            }
        }
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        int[] iArr = new int[strArr.length];
        int[] iArr2 = new int[strArr.length];
        int[] iArr3 = new int[m812b(iterable, z)];
        int i3 = 0;
        for (Experiment experiment2 : iterable) {
            if (experiment2.c == z) {
                Collection<Parameter> values = experiment2.b.values();
                String[] strArr2 = new String[values.size()];
                int[] iArr4 = new int[strArr2.length];
                i = 0;
                for (Parameter parameter : values) {
                    strArr2[i] = parameter.a();
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.a(1, parameter.c(), -1);
                    flatBufferBuilder.a(2, parameter.b(), -1);
                    iArr3[parameter.c()] = i3;
                    if (i == 0) {
                        iArr2[i3] = parameter.c();
                    }
                    i2 = i + 1;
                    iArr4[i] = flatBufferBuilder.d();
                    i = i2;
                }
                i2 = flatBufferBuilder.a(strArr2);
                i = flatBufferBuilder.a(iArr4, false);
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(1, i2);
                flatBufferBuilder.b(2, i);
                i2 = i3 + 1;
                iArr[i3] = flatBufferBuilder.d();
                i3 = i2;
            }
        }
        int a = flatBufferBuilder.a(strArr);
        i2 = flatBufferBuilder.a(iArr, false);
        i3 = flatBufferBuilder.a(iArr3);
        i = flatBufferBuilder.a(iArr2);
        flatBufferBuilder.c(5);
        flatBufferBuilder.b(1, a);
        flatBufferBuilder.b(2, i2);
        flatBufferBuilder.b(3, i3);
        flatBufferBuilder.b(4, i);
        flatBufferBuilder.d(flatBufferBuilder.d());
        byte[] e = flatBufferBuilder.e();
        i2 = e.length + 12;
        ByteBuffer allocate = ByteBuffer.allocate(e.length + 12);
        allocate.putInt(0, -87117812);
        allocate.putInt(4, 538251273);
        allocate.putInt(8, i2);
        allocate.position(12);
        allocate.put(e);
        return allocate.array();
    }

    private static int m812b(Iterable<Experiment> iterable, boolean z) {
        int i = 0;
        for (Experiment experiment : iterable) {
            if (experiment.c == z) {
                i = experiment.b.size() + i;
            }
        }
        return i;
    }
}

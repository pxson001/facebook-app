package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryContext;
import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.debug.fieldusage.FieldAccessTracker;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import java.nio.ByteBuffer;

/* compiled from: facebox_center */
public class GraphQLModelFlatbufferHelper {
    public static <T> T m9141a(T t) {
        if (!(t instanceof Flattenable)) {
            return t;
        }
        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(ByteBuffer.wrap(FlatBufferBuilder.b((Flattenable) t, VirtualFlattenableResolverImpl.a)), null, null, true, null);
        if (t instanceof BaseModel) {
            FieldAccessTracker fieldAccessTracker = ((BaseModel) t).a_;
            if (fieldAccessTracker != null) {
                FieldAccessQueryTracker fieldAccessQueryTracker = fieldAccessTracker.f2897j;
                if (fieldAccessQueryTracker != null) {
                    fieldAccessQueryTracker.a(fieldAccessTracker.m4035a());
                    FieldAccessQueryContext.a(mutableFlatBuffer, fieldAccessQueryTracker);
                }
            }
        }
        return m9140a(mutableFlatBuffer);
    }

    public static Flattenable m9140a(MutableFlatBuffer mutableFlatBuffer) {
        return mutableFlatBuffer.a(VirtualFlattenableResolverImpl.a);
    }
}

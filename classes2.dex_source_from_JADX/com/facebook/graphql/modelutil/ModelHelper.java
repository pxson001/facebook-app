package com.facebook.graphql.modelutil;

import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.flatbuffers.MutableFlattenable;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: logVideoStartEvent */
public final class ModelHelper {
    public static <T extends GraphQLVisitableModel> T m23095a(T t, T t2) {
        if (t != null) {
            return t;
        }
        try {
            return (GraphQLVisitableModel) t2.clone();
        } catch (Throwable e) {
            throw new RuntimeException("Couldn't clone object " + t, e);
        }
    }

    public static <T extends GraphQLVisitableModel> Builder<T> m23097a(ImmutableList<T> immutableList, GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        int size = immutableList.size();
        int i = 0;
        Builder<T> builder = null;
        int i2 = 0;
        while (i2 < size) {
            GraphQLVisitableModel graphQLVisitableModel = (GraphQLVisitableModel) immutableList.get(i2);
            int i3 = i + 1;
            i2++;
            builder = m23096a(immutableList, i, graphQLVisitableModel, graphQLModelMutatingVisitor.mo2928b(graphQLVisitableModel), builder);
            i = i3;
        }
        return builder;
    }

    private static <T> Builder<T> m23096a(ImmutableList<T> immutableList, int i, T t, T t2, Builder<T> builder) {
        int i2 = 0;
        if (t != t2 && builder == null) {
            builder = new Builder();
            ImmutableList subList = immutableList.subList(0, i);
            int size = subList.size();
            while (i2 < size) {
                builder.m1069c(subList.get(i2));
                i2++;
            }
        }
        if (!(builder == null || t2 == null)) {
            builder.m1069c(t2);
        }
        return builder;
    }

    public static int m23093a(FlatBufferBuilder flatBufferBuilder, @Nullable MutableFlattenable mutableFlattenable) {
        if (mutableFlattenable == null) {
            return 0;
        }
        if (mutableFlattenable.w_() == null || mutableFlattenable.w_().f15021a == null || mutableFlattenable.w_().m21545b()) {
            return flatBufferBuilder.m21475a((Flattenable) mutableFlattenable);
        }
        ByteBuffer byteBuffer = mutableFlattenable.w_().f15021a;
        int a = FlatBuffer.m4026a(byteBuffer);
        if (mutableFlattenable.u_() != a) {
            return flatBufferBuilder.m21475a((Flattenable) mutableFlattenable);
        }
        return flatBufferBuilder.m21480a(byteBuffer, a);
    }

    public static <T extends MutableFlattenable> int m23094a(FlatBufferBuilder flatBufferBuilder, List<T> list) {
        if (list == null || list.size() == 0) {
            return 0;
        }
        int[] iArr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            iArr[i] = flatBufferBuilder.m21475a((Flattenable) list.get(i));
        }
        return flatBufferBuilder.m21487a(iArr, true);
    }
}

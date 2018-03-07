package com.facebook.gl;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: WWW_GUI */
public class Geometry {
    public final ImmutableMap<String, VertexData> f12333a;
    @Nullable
    public final IndexArray f12334b;
    public final int f12335c;
    public int f12336d;

    /* compiled from: WWW_GUI */
    public class Builder {
        public int f12329a = 4;
        public final int f12330b;
        public final Map<String, VertexData> f12331c = Maps.c();
        @Nullable
        public IndexArray f12332d;

        public Builder(int i) {
            this.f12330b = i;
        }

        public final Builder m20409a(String str, VertexData vertexData) {
            this.f12331c.put(str, vertexData);
            return this;
        }

        public final Geometry m20410a() {
            return new Geometry(this);
        }
    }

    public Geometry(Builder builder) {
        this.f12333a = ImmutableMap.copyOf(builder.f12331c);
        this.f12334b = builder.f12332d;
        this.f12335c = builder.f12329a;
        this.f12336d = builder.f12330b;
    }
}

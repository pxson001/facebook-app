package com.facebook.pages.adminedpages.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.pages.adminedpages.protocol.C1789x4f009d7.AdminInfoParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;

@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = -1594547285)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: currentEntityId must be in initialEntityIds */
public final class C1781x1fdd1cf extends BaseModel implements GraphQLVisitableModel {
    private boolean f16540d;

    /* compiled from: currentEntityId must be in initialEntityIds */
    public final class Builder {
        public boolean f16539a;

        public final Builder m19492a(boolean z) {
            this.f16539a = z;
            return this;
        }

        public final C1781x1fdd1cf m19493a() {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.c(1);
            flatBufferBuilder.a(0, this.f16539a);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new C1781x1fdd1cf(new MutableFlatBuffer(wrap, null, null, true, null));
        }
    }

    /* compiled from: currentEntityId must be in initialEntityIds */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(C1781x1fdd1cf.class, new Deserializer());
        }

        public Object m19494a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(AdminInfoParser.m19520a(jsonParser, flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
            Object c1781x1fdd1cf = new C1781x1fdd1cf();
            ((BaseModel) c1781x1fdd1cf).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
            if (c1781x1fdd1cf instanceof Postprocessable) {
                return ((Postprocessable) c1781x1fdd1cf).a();
            }
            return c1781x1fdd1cf;
        }
    }

    /* compiled from: currentEntityId must be in initialEntityIds */
    public class Serializer extends JsonSerializer<C1781x1fdd1cf> {
        public final void m19495a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            C1781x1fdd1cf c1781x1fdd1cf = (C1781x1fdd1cf) obj;
            if (c1781x1fdd1cf.w_() == null) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(c1781x1fdd1cf.m19496a(flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                c1781x1fdd1cf.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }
            AdminInfoParser.m19521a(c1781x1fdd1cf.w_(), c1781x1fdd1cf.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(C1781x1fdd1cf.class, new Serializer());
        }
    }

    public C1781x1fdd1cf() {
        super(1);
    }

    public C1781x1fdd1cf(MutableFlatBuffer mutableFlatBuffer) {
        super(1);
        a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
    }

    public final boolean m19499a() {
        a(0, 0);
        return this.f16540d;
    }

    public final int jK_() {
        return 888797870;
    }

    public final GraphQLVisitableModel m19497a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public final int m19496a(FlatBufferBuilder flatBufferBuilder) {
        h();
        flatBufferBuilder.c(1);
        flatBufferBuilder.a(0, this.f16540d);
        i();
        return flatBufferBuilder.d();
    }

    public final void m19498a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f16540d = mutableFlatBuffer.a(i, 0);
    }
}

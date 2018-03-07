package com.facebook.clashmanagement.api;

import com.facebook.clashmanagement.api.C0746x2c16c1b0.NodeParser;
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
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = -620368608)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: key_submit_answer */
public final class C0743x6295f1f extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
    @Nullable
    private String f5910d;
    @Nullable
    private String f5911e;
    private int f5912f;

    /* compiled from: key_submit_answer */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(C0743x6295f1f.class, new Deserializer());
        }

        public Object m7315a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(NodeParser.m7327a(jsonParser, flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
            Object c0743x6295f1f = new C0743x6295f1f();
            ((BaseModel) c0743x6295f1f).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
            if (c0743x6295f1f instanceof Postprocessable) {
                return ((Postprocessable) c0743x6295f1f).a();
            }
            return c0743x6295f1f;
        }
    }

    /* compiled from: key_submit_answer */
    public class Serializer extends JsonSerializer<C0743x6295f1f> {
        public final void m7316a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            C0743x6295f1f c0743x6295f1f = (C0743x6295f1f) obj;
            if (c0743x6295f1f.w_() == null) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(c0743x6295f1f.m7318a(flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                c0743x6295f1f.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }
            NodeParser.m7328a(c0743x6295f1f.w_(), c0743x6295f1f.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(C0743x6295f1f.class, new Serializer());
        }
    }

    public C0743x6295f1f() {
        super(3);
    }

    @Nullable
    private String m7317l() {
        this.f5910d = super.a(this.f5910d, 0);
        return this.f5910d;
    }

    @Nullable
    public final String m7322j() {
        this.f5911e = super.a(this.f5911e, 1);
        return this.f5911e;
    }

    public final int m7323k() {
        a(0, 2);
        return this.f5912f;
    }

    @Nullable
    public final String m7320a() {
        return m7317l();
    }

    public final int jK_() {
        return 1984141425;
    }

    public final GraphQLVisitableModel m7319a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public final int m7318a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m7317l());
        int b2 = flatBufferBuilder.b(m7322j());
        flatBufferBuilder.c(3);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, b2);
        flatBufferBuilder.a(2, this.f5912f, 0);
        i();
        return flatBufferBuilder.d();
    }

    public final void m7321a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f5912f = mutableFlatBuffer.a(i, 2, 0);
    }
}

package com.facebook.directinstall.util;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.directinstall.util.DirectInstallApplicationUtilsGraphQLParsers.GetNativeAppDetailsActorGraphQLParser.ProfilePictureParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
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
@ModelWithFlatBufferFormatHash(a = 842551240)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: ogActionType */
public final class C0591xa9e2267b extends BaseModel implements C0589xd643bf8b, GraphQLVisitableModel {
    @Nullable
    private String f8818d;

    /* compiled from: ogActionType */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(C0591xa9e2267b.class, new Deserializer());
        }

        public Object m12565a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(ProfilePictureParser.m12659a(jsonParser, flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
            Object c0591xa9e2267b = new C0591xa9e2267b();
            ((BaseModel) c0591xa9e2267b).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
            if (c0591xa9e2267b instanceof Postprocessable) {
                return ((Postprocessable) c0591xa9e2267b).a();
            }
            return c0591xa9e2267b;
        }
    }

    /* compiled from: ogActionType */
    public class Serializer extends JsonSerializer<C0591xa9e2267b> {
        public final void m12566a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            C0591xa9e2267b c0591xa9e2267b = (C0591xa9e2267b) obj;
            if (c0591xa9e2267b.w_() == null) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(c0591xa9e2267b.m12567a(flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                c0591xa9e2267b.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }
            ProfilePictureParser.m12660a(c0591xa9e2267b.w_(), c0591xa9e2267b.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(C0591xa9e2267b.class, new Serializer());
        }
    }

    public C0591xa9e2267b() {
        super(1);
    }

    @Nullable
    public final String mo962b() {
        this.f8818d = super.a(this.f8818d, 0);
        return this.f8818d;
    }

    public final int jK_() {
        return 70760763;
    }

    public final GraphQLVisitableModel m12568a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public final int m12567a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(mo962b());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, b);
        i();
        return flatBufferBuilder.d();
    }
}

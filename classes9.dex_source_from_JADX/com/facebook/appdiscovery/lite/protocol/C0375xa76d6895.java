package com.facebook.appdiscovery.lite.protocol;

import com.facebook.appdiscovery.lite.protocol.AppFragmentsGraphQLParsers.PlatformApplicationFragmentParser.NativeStoreObjectParser;
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
import com.facebook.graphql.modelutil.ModelHelper;
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
@ModelWithFlatBufferFormatHash(a = -1840009475)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: sendInstantly */
public final class C0375xa76d6895 extends BaseModel implements GraphQLVisitableModel {
    @Nullable
    private String f4057d;
    @Nullable
    private String f4058e;
    @Nullable
    private AppFragmentsGraphQLModels$StarRatingFragmentModel f4059f;
    @Nullable
    private String f4060g;

    /* compiled from: sendInstantly */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(C0375xa76d6895.class, new Deserializer());
        }

        public Object m3953a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(NativeStoreObjectParser.m4027a(jsonParser, flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
            Object c0375xa76d6895 = new C0375xa76d6895();
            ((BaseModel) c0375xa76d6895).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
            if (c0375xa76d6895 instanceof Postprocessable) {
                return ((Postprocessable) c0375xa76d6895).a();
            }
            return c0375xa76d6895;
        }
    }

    /* compiled from: sendInstantly */
    public class Serializer extends JsonSerializer<C0375xa76d6895> {
        public final void m3954a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            C0375xa76d6895 c0375xa76d6895 = (C0375xa76d6895) obj;
            if (c0375xa76d6895.w_() == null) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(c0375xa76d6895.m3959a(flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                c0375xa76d6895.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }
            NativeStoreObjectParser.m4028a(c0375xa76d6895.w_(), c0375xa76d6895.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(C0375xa76d6895.class, new Serializer());
        }
    }

    public C0375xa76d6895() {
        super(4);
    }

    @Nullable
    private String m3955a() {
        this.f4057d = super.a(this.f4057d, 0);
        return this.f4057d;
    }

    @Nullable
    private String m3956j() {
        this.f4058e = super.a(this.f4058e, 1);
        return this.f4058e;
    }

    @Nullable
    private AppFragmentsGraphQLModels$StarRatingFragmentModel m3957k() {
        this.f4059f = (AppFragmentsGraphQLModels$StarRatingFragmentModel) super.a(this.f4059f, 2, AppFragmentsGraphQLModels$StarRatingFragmentModel.class);
        return this.f4059f;
    }

    @Nullable
    private String m3958l() {
        this.f4060g = super.a(this.f4060g, 3);
        return this.f4060g;
    }

    public final int jK_() {
        return -1304127138;
    }

    public final GraphQLVisitableModel m3960a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m3957k() != null) {
            AppFragmentsGraphQLModels$StarRatingFragmentModel appFragmentsGraphQLModels$StarRatingFragmentModel = (AppFragmentsGraphQLModels$StarRatingFragmentModel) graphQLModelMutatingVisitor.b(m3957k());
            if (m3957k() != appFragmentsGraphQLModels$StarRatingFragmentModel) {
                graphQLVisitableModel = (C0375xa76d6895) ModelHelper.a(null, this);
                graphQLVisitableModel.f4059f = appFragmentsGraphQLModels$StarRatingFragmentModel;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final int m3959a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m3955a());
        int b2 = flatBufferBuilder.b(m3956j());
        int a = ModelHelper.a(flatBufferBuilder, m3957k());
        int b3 = flatBufferBuilder.b(m3958l());
        flatBufferBuilder.c(4);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, b2);
        flatBufferBuilder.b(2, a);
        flatBufferBuilder.b(3, b3);
        i();
        return flatBufferBuilder.d();
    }
}

package com.facebook.appdiscovery.lite.protocol;

import com.facebook.appdiscovery.lite.protocol.AppFragmentsGraphQLParsers.PlatformApplicationFragmentParser.FriendsWhoUsedParser;
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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = 1104725682)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: sendInstantly */
public final class C0373xf55f32ce extends BaseModel implements GraphQLVisitableModel {
    @Nullable
    private List<AppFragmentsGraphQLModels$UserFacePileFragmentModel> f4055d;

    /* compiled from: sendInstantly */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(C0373xf55f32ce.class, new Deserializer());
        }

        public Object m3943a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(FriendsWhoUsedParser.m4023a(jsonParser, flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
            Object c0373xf55f32ce = new C0373xf55f32ce();
            ((BaseModel) c0373xf55f32ce).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
            if (c0373xf55f32ce instanceof Postprocessable) {
                return ((Postprocessable) c0373xf55f32ce).a();
            }
            return c0373xf55f32ce;
        }
    }

    /* compiled from: sendInstantly */
    public class Serializer extends JsonSerializer<C0373xf55f32ce> {
        public final void m3944a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            C0373xf55f32ce c0373xf55f32ce = (C0373xf55f32ce) obj;
            if (c0373xf55f32ce.w_() == null) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(c0373xf55f32ce.m3946a(flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                c0373xf55f32ce.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }
            FriendsWhoUsedParser.m4024a(c0373xf55f32ce.w_(), c0373xf55f32ce.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(C0373xf55f32ce.class, new Serializer());
        }
    }

    public C0373xf55f32ce() {
        super(1);
    }

    @Nonnull
    private ImmutableList<AppFragmentsGraphQLModels$UserFacePileFragmentModel> m3945a() {
        this.f4055d = super.a(this.f4055d, 0, AppFragmentsGraphQLModels$UserFacePileFragmentModel.class);
        return (ImmutableList) this.f4055d;
    }

    public final int jK_() {
        return -555954151;
    }

    public final GraphQLVisitableModel m3947a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m3945a() != null) {
            Builder a = ModelHelper.a(m3945a(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (C0373xf55f32ce) ModelHelper.a(null, this);
                graphQLVisitableModel.f4055d = a.b();
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final int m3946a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m3945a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }
}

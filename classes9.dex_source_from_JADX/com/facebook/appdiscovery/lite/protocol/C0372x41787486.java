package com.facebook.appdiscovery.lite.protocol;

import com.facebook.appdiscovery.lite.protocol.AppFragmentsGraphQLParsers.PlatformApplicationFragmentParser.FriendsWhoRecentlyUsedParser;
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
public final class C0372x41787486 extends BaseModel implements GraphQLVisitableModel {
    @Nullable
    private List<AppFragmentsGraphQLModels$UserFacePileFragmentModel> f4054d;

    /* compiled from: sendInstantly */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(C0372x41787486.class, new Deserializer());
        }

        public Object m3938a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(FriendsWhoRecentlyUsedParser.m4021a(jsonParser, flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
            Object c0372x41787486 = new C0372x41787486();
            ((BaseModel) c0372x41787486).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
            if (c0372x41787486 instanceof Postprocessable) {
                return ((Postprocessable) c0372x41787486).a();
            }
            return c0372x41787486;
        }
    }

    /* compiled from: sendInstantly */
    public class Serializer extends JsonSerializer<C0372x41787486> {
        public final void m3939a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            C0372x41787486 c0372x41787486 = (C0372x41787486) obj;
            if (c0372x41787486.w_() == null) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(c0372x41787486.m3941a(flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                c0372x41787486.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }
            FriendsWhoRecentlyUsedParser.m4022a(c0372x41787486.w_(), c0372x41787486.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(C0372x41787486.class, new Serializer());
        }
    }

    public C0372x41787486() {
        super(1);
    }

    @Nonnull
    private ImmutableList<AppFragmentsGraphQLModels$UserFacePileFragmentModel> m3940a() {
        this.f4054d = super.a(this.f4054d, 0, AppFragmentsGraphQLModels$UserFacePileFragmentModel.class);
        return (ImmutableList) this.f4054d;
    }

    public final int jK_() {
        return 606893265;
    }

    public final GraphQLVisitableModel m3942a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m3940a() != null) {
            Builder a = ModelHelper.a(m3940a(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (C0372x41787486) ModelHelper.a(null, this);
                graphQLVisitableModel.f4054d = a.b();
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final int m3941a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m3940a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }
}

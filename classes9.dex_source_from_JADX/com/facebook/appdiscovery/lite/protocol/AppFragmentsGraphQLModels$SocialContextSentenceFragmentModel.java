package com.facebook.appdiscovery.lite.protocol;

import com.facebook.appdiscovery.lite.protocol.AppFragmentsGraphQLParsers.SocialContextSentenceFragmentParser;
import com.facebook.appdiscovery.lite.protocol.AppFragmentsGraphQLParsers.SocialContextSentenceFragmentParser.RangesParser;
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
@ModelWithFlatBufferFormatHash(a = -1671204937)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: sendInstantly */
public final class AppFragmentsGraphQLModels$SocialContextSentenceFragmentModel extends BaseModel implements GraphQLVisitableModel {
    @Nullable
    private List<RangesModel> f4066d;
    @Nullable
    private String f4067e;

    /* compiled from: sendInstantly */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(AppFragmentsGraphQLModels$SocialContextSentenceFragmentModel.class, new Deserializer());
        }

        public Object m3972a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(SocialContextSentenceFragmentParser.m4037a(jsonParser, flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
            Object appFragmentsGraphQLModels$SocialContextSentenceFragmentModel = new AppFragmentsGraphQLModels$SocialContextSentenceFragmentModel();
            ((BaseModel) appFragmentsGraphQLModels$SocialContextSentenceFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
            if (appFragmentsGraphQLModels$SocialContextSentenceFragmentModel instanceof Postprocessable) {
                return ((Postprocessable) appFragmentsGraphQLModels$SocialContextSentenceFragmentModel).a();
            }
            return appFragmentsGraphQLModels$SocialContextSentenceFragmentModel;
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2101181991)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: sendInstantly */
    public final class RangesModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private AppFragmentsGraphQLModels$UserFacePileFragmentModel f4063d;
        private int f4064e;
        private int f4065f;

        /* compiled from: sendInstantly */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RangesModel.class, new Deserializer());
            }

            public Object m3973a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(RangesParser.m4035b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object rangesModel = new RangesModel();
                ((BaseModel) rangesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (rangesModel instanceof Postprocessable) {
                    return ((Postprocessable) rangesModel).a();
                }
                return rangesModel;
            }
        }

        /* compiled from: sendInstantly */
        public class Serializer extends JsonSerializer<RangesModel> {
            public final void m3974a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                RangesModel rangesModel = (RangesModel) obj;
                if (rangesModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(rangesModel.m3976a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    rangesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                RangesParser.m4036b(rangesModel.w_(), rangesModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(RangesModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ AppFragmentsGraphQLModels$UserFacePileFragmentModel m3977a() {
            return m3975j();
        }

        public RangesModel() {
            super(3);
        }

        @Nullable
        private AppFragmentsGraphQLModels$UserFacePileFragmentModel m3975j() {
            this.f4063d = (AppFragmentsGraphQLModels$UserFacePileFragmentModel) super.a(this.f4063d, 0, AppFragmentsGraphQLModels$UserFacePileFragmentModel.class);
            return this.f4063d;
        }

        public final int jK_() {
            return -1024511161;
        }

        public final GraphQLVisitableModel m3978a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m3975j() != null) {
                AppFragmentsGraphQLModels$UserFacePileFragmentModel appFragmentsGraphQLModels$UserFacePileFragmentModel = (AppFragmentsGraphQLModels$UserFacePileFragmentModel) graphQLModelMutatingVisitor.b(m3975j());
                if (m3975j() != appFragmentsGraphQLModels$UserFacePileFragmentModel) {
                    graphQLVisitableModel = (RangesModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f4063d = appFragmentsGraphQLModels$UserFacePileFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m3976a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m3975j());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.a(1, this.f4064e, 0);
            flatBufferBuilder.a(2, this.f4065f, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m3979a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f4064e = mutableFlatBuffer.a(i, 1, 0);
            this.f4065f = mutableFlatBuffer.a(i, 2, 0);
        }
    }

    /* compiled from: sendInstantly */
    public class Serializer extends JsonSerializer<AppFragmentsGraphQLModels$SocialContextSentenceFragmentModel> {
        public final void m3980a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            AppFragmentsGraphQLModels$SocialContextSentenceFragmentModel appFragmentsGraphQLModels$SocialContextSentenceFragmentModel = (AppFragmentsGraphQLModels$SocialContextSentenceFragmentModel) obj;
            if (appFragmentsGraphQLModels$SocialContextSentenceFragmentModel.w_() == null) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(appFragmentsGraphQLModels$SocialContextSentenceFragmentModel.m3981a(flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                appFragmentsGraphQLModels$SocialContextSentenceFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }
            SocialContextSentenceFragmentParser.m4038a(appFragmentsGraphQLModels$SocialContextSentenceFragmentModel.w_(), appFragmentsGraphQLModels$SocialContextSentenceFragmentModel.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(AppFragmentsGraphQLModels$SocialContextSentenceFragmentModel.class, new Serializer());
        }
    }

    public AppFragmentsGraphQLModels$SocialContextSentenceFragmentModel() {
        super(2);
    }

    @Nonnull
    public final ImmutableList<RangesModel> m3983a() {
        this.f4066d = super.a(this.f4066d, 0, RangesModel.class);
        return (ImmutableList) this.f4066d;
    }

    @Nullable
    public final String m3984b() {
        this.f4067e = super.a(this.f4067e, 1);
        return this.f4067e;
    }

    public final int jK_() {
        return -1919764332;
    }

    public final GraphQLVisitableModel m3982a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m3983a() != null) {
            Builder a = ModelHelper.a(m3983a(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (AppFragmentsGraphQLModels$SocialContextSentenceFragmentModel) ModelHelper.a(null, this);
                graphQLVisitableModel.f4066d = a.b();
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final int m3981a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m3983a());
        int b = flatBufferBuilder.b(m3984b());
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, b);
        i();
        return flatBufferBuilder.d();
    }
}

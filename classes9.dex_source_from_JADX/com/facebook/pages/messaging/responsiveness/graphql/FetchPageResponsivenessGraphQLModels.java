package com.facebook.pages.messaging.responsiveness.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLTimespanCategory;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.pages.messaging.responsiveness.graphql.FetchPageResponsivenessGraphQLParsers.PageResponsivenessContextParser;
import com.facebook.pages.messaging.responsiveness.graphql.FetchPageResponsivenessGraphQLParsers.PageResponsivenessContextParser.ResponsivenessContextParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: caught_on_idle */
public class FetchPageResponsivenessGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 2051563869)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: caught_on_idle */
    public final class PageResponsivenessContextModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private ResponsivenessContextModel f18450d;

        /* compiled from: caught_on_idle */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PageResponsivenessContextModel.class, new Deserializer());
            }

            public Object m18434a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PageResponsivenessContextParser.m18451a(jsonParser);
                Object pageResponsivenessContextModel = new PageResponsivenessContextModel();
                ((BaseModel) pageResponsivenessContextModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (pageResponsivenessContextModel instanceof Postprocessable) {
                    return ((Postprocessable) pageResponsivenessContextModel).a();
                }
                return pageResponsivenessContextModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1302277855)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: caught_on_idle */
        public final class ResponsivenessContextModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private GraphQLTimespanCategory f18448d;
            private boolean f18449e;

            /* compiled from: caught_on_idle */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ResponsivenessContextModel.class, new Deserializer());
                }

                public Object m18435a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ResponsivenessContextParser.m18449a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object responsivenessContextModel = new ResponsivenessContextModel();
                    ((BaseModel) responsivenessContextModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (responsivenessContextModel instanceof Postprocessable) {
                        return ((Postprocessable) responsivenessContextModel).a();
                    }
                    return responsivenessContextModel;
                }
            }

            /* compiled from: caught_on_idle */
            public class Serializer extends JsonSerializer<ResponsivenessContextModel> {
                public final void m18436a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ResponsivenessContextModel responsivenessContextModel = (ResponsivenessContextModel) obj;
                    if (responsivenessContextModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(responsivenessContextModel.m18437a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        responsivenessContextModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ResponsivenessContextParser.m18450a(responsivenessContextModel.w_(), responsivenessContextModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ResponsivenessContextModel.class, new Serializer());
                }
            }

            public ResponsivenessContextModel() {
                super(2);
            }

            @Nullable
            public final GraphQLTimespanCategory m18438a() {
                this.f18448d = (GraphQLTimespanCategory) super.b(this.f18448d, 0, GraphQLTimespanCategory.class, GraphQLTimespanCategory.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f18448d;
            }

            public final boolean m18441b() {
                a(0, 1);
                return this.f18449e;
            }

            public final int jK_() {
                return -325020412;
            }

            public final GraphQLVisitableModel m18439a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m18437a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = flatBufferBuilder.a(m18438a());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.a(1, this.f18449e);
                i();
                return flatBufferBuilder.d();
            }

            public final void m18440a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f18449e = mutableFlatBuffer.a(i, 1);
            }
        }

        /* compiled from: caught_on_idle */
        public class Serializer extends JsonSerializer<PageResponsivenessContextModel> {
            public final void m18442a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PageResponsivenessContextModel pageResponsivenessContextModel = (PageResponsivenessContextModel) obj;
                if (pageResponsivenessContextModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pageResponsivenessContextModel.m18444a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pageResponsivenessContextModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = pageResponsivenessContextModel.w_();
                int u_ = pageResponsivenessContextModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("responsiveness_context");
                    ResponsivenessContextParser.m18450a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PageResponsivenessContextModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ ResponsivenessContextModel m18446a() {
            return m18443j();
        }

        public PageResponsivenessContextModel() {
            super(1);
        }

        public final void m18447a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m18448a(String str, Object obj, boolean z) {
        }

        @Nullable
        private ResponsivenessContextModel m18443j() {
            this.f18450d = (ResponsivenessContextModel) super.a(this.f18450d, 0, ResponsivenessContextModel.class);
            return this.f18450d;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m18445a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m18443j() != null) {
                ResponsivenessContextModel responsivenessContextModel = (ResponsivenessContextModel) graphQLModelMutatingVisitor.b(m18443j());
                if (m18443j() != responsivenessContextModel) {
                    graphQLVisitableModel = (PageResponsivenessContextModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f18450d = responsivenessContextModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m18444a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m18443j());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}

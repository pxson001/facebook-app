package com.facebook.pages.common.surface.calltoaction.graphql;

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
import com.facebook.pages.common.surface.calltoaction.graphql.PageCallToActionAutoFillGraphQLParsers.PageCallToActionAutoFillQueryParser;
import com.facebook.pages.common.surface.calltoaction.graphql.PageCallToActionAutoFillGraphQLParsers.PageCallToActionAutoFillQueryParser.AllAutofillValuesParser;
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

/* compiled from: crash */
public class PageCallToActionAutoFillGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 2026224775)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: crash */
    public final class PageCallToActionAutoFillQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<AllAutofillValuesModel> f16784d;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1109181786)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: crash */
        public final class AllAutofillValuesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f16781d;
            @Nullable
            private String f16782e;
            @Nullable
            private List<String> f16783f;

            /* compiled from: crash */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AllAutofillValuesModel.class, new Deserializer());
                }

                public Object m19957a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AllAutofillValuesParser.m19970b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object allAutofillValuesModel = new AllAutofillValuesModel();
                    ((BaseModel) allAutofillValuesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (allAutofillValuesModel instanceof Postprocessable) {
                        return ((Postprocessable) allAutofillValuesModel).a();
                    }
                    return allAutofillValuesModel;
                }
            }

            /* compiled from: crash */
            public class Serializer extends JsonSerializer<AllAutofillValuesModel> {
                public final void m19958a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AllAutofillValuesModel allAutofillValuesModel = (AllAutofillValuesModel) obj;
                    if (allAutofillValuesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(allAutofillValuesModel.m19962a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        allAutofillValuesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AllAutofillValuesParser.m19969a(allAutofillValuesModel.w_(), allAutofillValuesModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AllAutofillValuesModel.class, new Serializer());
                }
            }

            public AllAutofillValuesModel() {
                super(3);
            }

            @Nullable
            private String m19959a() {
                this.f16781d = super.a(this.f16781d, 0);
                return this.f16781d;
            }

            @Nullable
            private String m19960j() {
                this.f16782e = super.a(this.f16782e, 1);
                return this.f16782e;
            }

            @Nonnull
            private ImmutableList<String> m19961k() {
                this.f16783f = super.a(this.f16783f, 2);
                return (ImmutableList) this.f16783f;
            }

            public final int jK_() {
                return 1542052930;
            }

            public final GraphQLVisitableModel m19963a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m19962a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m19959a());
                int b2 = flatBufferBuilder.b(m19960j());
                int c = flatBufferBuilder.c(m19961k());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.b(2, c);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: crash */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PageCallToActionAutoFillQueryModel.class, new Deserializer());
            }

            public Object m19964a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PageCallToActionAutoFillQueryParser.m19971a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object pageCallToActionAutoFillQueryModel = new PageCallToActionAutoFillQueryModel();
                ((BaseModel) pageCallToActionAutoFillQueryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (pageCallToActionAutoFillQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) pageCallToActionAutoFillQueryModel).a();
                }
                return pageCallToActionAutoFillQueryModel;
            }
        }

        /* compiled from: crash */
        public class Serializer extends JsonSerializer<PageCallToActionAutoFillQueryModel> {
            public final void m19965a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PageCallToActionAutoFillQueryModel pageCallToActionAutoFillQueryModel = (PageCallToActionAutoFillQueryModel) obj;
                if (pageCallToActionAutoFillQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pageCallToActionAutoFillQueryModel.m19967a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pageCallToActionAutoFillQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = pageCallToActionAutoFillQueryModel.w_();
                int u_ = pageCallToActionAutoFillQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("all_autofill_values");
                    jsonGenerator.d();
                    for (int i = 0; i < mutableFlatBuffer.c(g); i++) {
                        AllAutofillValuesParser.m19969a(mutableFlatBuffer, mutableFlatBuffer.m(g, i), jsonGenerator);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PageCallToActionAutoFillQueryModel.class, new Serializer());
            }
        }

        public PageCallToActionAutoFillQueryModel() {
            super(1);
        }

        @Nonnull
        private ImmutableList<AllAutofillValuesModel> m19966a() {
            this.f16784d = super.a(this.f16784d, 0, AllAutofillValuesModel.class);
            return (ImmutableList) this.f16784d;
        }

        public final int jK_() {
            return 797214985;
        }

        public final GraphQLVisitableModel m19968a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m19966a() != null) {
                Builder a = ModelHelper.a(m19966a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (PageCallToActionAutoFillQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f16784d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m19967a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m19966a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}

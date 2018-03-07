package com.facebook.aldrin.graphql;

import com.facebook.aldrin.graphql.AldrinGraphQLParsers.RegionTosRespondMutationParser;
import com.facebook.aldrin.graphql.AldrinGraphQLParsers.RegionTosStatusFragmentParser;
import com.facebook.aldrin.graphql.AldrinGraphQLParsers.RegionTosStatusFragmentParser.CurrentRegionTosLinksParser;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLTosRegionCodeEnum;
import com.facebook.graphql.enums.GraphQLTosTransitionTypeEnum;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.vault.momentsupsell.graphql.MomentsUpsellQueryParsers.MomentsAppPromotionQueryParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: link_ipb */
public class AldrinGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2140647742)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: link_ipb */
    public final class RegionTosRespondMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private RegionTosStatusFragmentModel f10333d;

        /* compiled from: link_ipb */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RegionTosRespondMutationModel.class, new Deserializer());
            }

            public Object m12132a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = RegionTosRespondMutationParser.m12153a(jsonParser);
                Object regionTosRespondMutationModel = new RegionTosRespondMutationModel();
                ((BaseModel) regionTosRespondMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (regionTosRespondMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) regionTosRespondMutationModel).a();
                }
                return regionTosRespondMutationModel;
            }
        }

        /* compiled from: link_ipb */
        public class Serializer extends JsonSerializer<RegionTosRespondMutationModel> {
            public final void m12133a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                RegionTosRespondMutationModel regionTosRespondMutationModel = (RegionTosRespondMutationModel) obj;
                if (regionTosRespondMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(regionTosRespondMutationModel.m12134a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    regionTosRespondMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = regionTosRespondMutationModel.w_();
                int u_ = regionTosRespondMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("region_tos_status");
                    MomentsAppPromotionQueryParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(RegionTosRespondMutationModel.class, new Serializer());
            }
        }

        public RegionTosRespondMutationModel() {
            super(1);
        }

        @Nullable
        public final RegionTosStatusFragmentModel m12135a() {
            this.f10333d = (RegionTosStatusFragmentModel) super.a(this.f10333d, 0, RegionTosStatusFragmentModel.class);
            return this.f10333d;
        }

        public final int jK_() {
            return -880104580;
        }

        public final GraphQLVisitableModel m12136a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m12135a() != null) {
                RegionTosStatusFragmentModel regionTosStatusFragmentModel = (RegionTosStatusFragmentModel) graphQLModelMutatingVisitor.b(m12135a());
                if (m12135a() != regionTosStatusFragmentModel) {
                    graphQLVisitableModel = (RegionTosRespondMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10333d = regionTosStatusFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m12134a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m12135a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1089708210)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: link_ipb */
    public final class RegionTosStatusFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GraphQLTosRegionCodeEnum f10338d;
        @Nullable
        private CurrentRegionTosLinksModel f10339e;
        @Nullable
        private GraphQLTosRegionCodeEnum f10340f;
        @Nullable
        private GraphQLTosTransitionTypeEnum f10341g;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1039439525)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: link_ipb */
        public final class CurrentRegionTosLinksModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f10334d;
            @Nullable
            private String f10335e;
            @Nullable
            private String f10336f;
            @Nullable
            private String f10337g;

            /* compiled from: link_ipb */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CurrentRegionTosLinksModel.class, new Deserializer());
                }

                public Object m12137a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CurrentRegionTosLinksParser.m12154a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object currentRegionTosLinksModel = new CurrentRegionTosLinksModel();
                    ((BaseModel) currentRegionTosLinksModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (currentRegionTosLinksModel instanceof Postprocessable) {
                        return ((Postprocessable) currentRegionTosLinksModel).a();
                    }
                    return currentRegionTosLinksModel;
                }
            }

            /* compiled from: link_ipb */
            public class Serializer extends JsonSerializer<CurrentRegionTosLinksModel> {
                public final void m12138a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CurrentRegionTosLinksModel currentRegionTosLinksModel = (CurrentRegionTosLinksModel) obj;
                    if (currentRegionTosLinksModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(currentRegionTosLinksModel.m12143a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        currentRegionTosLinksModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MomentsAppPromotionQueryParser.a(currentRegionTosLinksModel.w_(), currentRegionTosLinksModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(CurrentRegionTosLinksModel.class, new Serializer());
                }
            }

            public CurrentRegionTosLinksModel() {
                super(4);
            }

            @Nullable
            private String m12139a() {
                this.f10334d = super.a(this.f10334d, 0);
                return this.f10334d;
            }

            @Nullable
            private String m12140j() {
                this.f10335e = super.a(this.f10335e, 1);
                return this.f10335e;
            }

            @Nullable
            private String m12141k() {
                this.f10336f = super.a(this.f10336f, 2);
                return this.f10336f;
            }

            @Nullable
            private String m12142l() {
                this.f10337g = super.a(this.f10337g, 3);
                return this.f10337g;
            }

            public final int jK_() {
                return -1140953405;
            }

            public final GraphQLVisitableModel m12144a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m12143a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m12139a());
                int b2 = flatBufferBuilder.b(m12140j());
                int b3 = flatBufferBuilder.b(m12141k());
                int b4 = flatBufferBuilder.b(m12142l());
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.b(2, b3);
                flatBufferBuilder.b(3, b4);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: link_ipb */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RegionTosStatusFragmentModel.class, new Deserializer());
            }

            public Object m12145a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(RegionTosStatusFragmentParser.m12155a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object regionTosStatusFragmentModel = new RegionTosStatusFragmentModel();
                ((BaseModel) regionTosStatusFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (regionTosStatusFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) regionTosStatusFragmentModel).a();
                }
                return regionTosStatusFragmentModel;
            }
        }

        /* compiled from: link_ipb */
        public class Serializer extends JsonSerializer<RegionTosStatusFragmentModel> {
            public final void m12146a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                RegionTosStatusFragmentModel regionTosStatusFragmentModel = (RegionTosStatusFragmentModel) obj;
                if (regionTosStatusFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(regionTosStatusFragmentModel.m12148a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    regionTosStatusFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                MomentsAppPromotionQueryParser.a(regionTosStatusFragmentModel.w_(), regionTosStatusFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(RegionTosStatusFragmentModel.class, new Serializer());
            }
        }

        public RegionTosStatusFragmentModel() {
            super(4);
        }

        @Nullable
        public final GraphQLTosRegionCodeEnum m12149a() {
            this.f10338d = (GraphQLTosRegionCodeEnum) super.b(this.f10338d, 0, GraphQLTosRegionCodeEnum.class, GraphQLTosRegionCodeEnum.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f10338d;
        }

        @Nullable
        private CurrentRegionTosLinksModel m12147l() {
            this.f10339e = (CurrentRegionTosLinksModel) super.a(this.f10339e, 1, CurrentRegionTosLinksModel.class);
            return this.f10339e;
        }

        @Nullable
        public final GraphQLTosRegionCodeEnum m12151j() {
            this.f10340f = (GraphQLTosRegionCodeEnum) super.b(this.f10340f, 2, GraphQLTosRegionCodeEnum.class, GraphQLTosRegionCodeEnum.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f10340f;
        }

        @Nullable
        public final GraphQLTosTransitionTypeEnum m12152k() {
            this.f10341g = (GraphQLTosTransitionTypeEnum) super.b(this.f10341g, 3, GraphQLTosTransitionTypeEnum.class, GraphQLTosTransitionTypeEnum.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f10341g;
        }

        public final int jK_() {
            return -1832165706;
        }

        public final GraphQLVisitableModel m12150a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m12147l() != null) {
                CurrentRegionTosLinksModel currentRegionTosLinksModel = (CurrentRegionTosLinksModel) graphQLModelMutatingVisitor.b(m12147l());
                if (m12147l() != currentRegionTosLinksModel) {
                    graphQLVisitableModel = (RegionTosStatusFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10339e = currentRegionTosLinksModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m12148a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = flatBufferBuilder.a(m12149a());
            int a2 = ModelHelper.a(flatBufferBuilder, m12147l());
            int a3 = flatBufferBuilder.a(m12151j());
            int a4 = flatBufferBuilder.a(m12152k());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, a4);
            i();
            return flatBufferBuilder.d();
        }
    }
}

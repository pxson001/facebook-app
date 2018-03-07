package com.facebook.directinstall.util;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.directinstall.util.DirectInstallApplicationUtilsGraphQLInterfaces.GetNativeAppDetailsFromActorGraphQL;
import com.facebook.directinstall.util.DirectInstallApplicationUtilsGraphQLParsers.GetNativeAppDetailsActorGraphQLParser.ProfilePictureParser;
import com.facebook.directinstall.util.DirectInstallApplicationUtilsGraphQLParsers.GetNativeAppDetailsAppStoreApplicationGraphQLParser;
import com.facebook.directinstall.util.DirectInstallApplicationUtilsGraphQLParsers.GetNativeAppDetailsAppStoreApplicationGraphQLParser.DescriptionParser;
import com.facebook.directinstall.util.DirectInstallApplicationUtilsGraphQLParsers.GetNativeAppDetailsAppStoreApplicationGraphQLParser.PlatformApplicationParser;
import com.facebook.directinstall.util.DirectInstallApplicationUtilsGraphQLParsers.GetNativeAppDetailsFromActorGraphQLParser;
import com.facebook.directinstall.util.DirectInstallApplicationUtilsGraphQLParsers.GetNativeAppDetailsImageGraphQLParser;
import com.facebook.directinstall.util.DirectInstallApplicationUtilsGraphQLParsers.GetNativeAppDetailsTextWithEntitiesGraphQLParser;
import com.facebook.directinstall.util.DirectInstallApplicationUtilsGraphQLParsers.GetNativeAppDetailsTextWithEntitiesGraphQLParser.RangesParser;
import com.facebook.directinstall.util.DirectInstallApplicationUtilsGraphQLParsers.GetNativeAppDetailsTextWithEntitiesGraphQLParser.RangesParser.EntityParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLAppStoreApplicationInstallState;
import com.facebook.graphql.enums.GraphQLAppStoreDownloadConnectivityPolicy;
import com.facebook.graphql.enums.GraphQLDigitalGoodStoreType;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: ogActionType */
public class DirectInstallApplicationUtilsGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 2144549494)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: ogActionType */
    public final class GetNativeAppDetailsAppStoreApplicationGraphQLModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f8843d;
        @Nullable
        private String f8844e;
        @Nullable
        private List<GetNativeAppDetailsImageGraphQLModel> f8845f;
        @Nullable
        private DescriptionModel f8846g;
        @Nullable
        private GraphQLAppStoreDownloadConnectivityPolicy f8847h;
        @Nullable
        private String f8848i;
        @Nullable
        private GraphQLAppStoreApplicationInstallState f8849j;
        @Nullable
        private GetNativeAppDetailsTextWithEntitiesGraphQLModel f8850k;
        @Nullable
        private List<String> f8851l;
        @Nullable
        private List<GetNativeAppDetailsImageGraphQLModel> f8852m;
        @Nullable
        private PlatformApplicationModel f8853n;
        @Nullable
        private String f8854o;
        @Nullable
        private List<GraphQLDigitalGoodStoreType> f8855p;
        @Nullable
        private GetNativeAppDetailsTextWithEntitiesGraphQLModel f8856q;
        private int f8857r;
        @Nullable
        private String f8858s;

        /* compiled from: ogActionType */
        public final class Builder {
            @Nullable
            public String f8819a;
            @Nullable
            public String f8820b;
            @Nullable
            public ImmutableList<GetNativeAppDetailsImageGraphQLModel> f8821c;
            @Nullable
            public DescriptionModel f8822d;
            @Nullable
            public GraphQLAppStoreDownloadConnectivityPolicy f8823e;
            @Nullable
            public String f8824f;
            @Nullable
            public GraphQLAppStoreApplicationInstallState f8825g;
            @Nullable
            public GetNativeAppDetailsTextWithEntitiesGraphQLModel f8826h;
            @Nullable
            public ImmutableList<String> f8827i;
            @Nullable
            public ImmutableList<GetNativeAppDetailsImageGraphQLModel> f8828j;
            @Nullable
            public PlatformApplicationModel f8829k;
            @Nullable
            public String f8830l;
            @Nullable
            public ImmutableList<GraphQLDigitalGoodStoreType> f8831m;
            @Nullable
            public GetNativeAppDetailsTextWithEntitiesGraphQLModel f8832n;
            public int f8833o;
            @Nullable
            public String f8834p;

            public final GetNativeAppDetailsAppStoreApplicationGraphQLModel m12571a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(this.f8819a);
                int b2 = flatBufferBuilder.b(this.f8820b);
                int a = ModelHelper.a(flatBufferBuilder, this.f8821c);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f8822d);
                int a3 = flatBufferBuilder.a(this.f8823e);
                int b3 = flatBufferBuilder.b(this.f8824f);
                int a4 = flatBufferBuilder.a(this.f8825g);
                int a5 = ModelHelper.a(flatBufferBuilder, this.f8826h);
                int c = flatBufferBuilder.c(this.f8827i);
                int a6 = ModelHelper.a(flatBufferBuilder, this.f8828j);
                int a7 = ModelHelper.a(flatBufferBuilder, this.f8829k);
                int b4 = flatBufferBuilder.b(this.f8830l);
                int d = flatBufferBuilder.d(this.f8831m);
                int a8 = ModelHelper.a(flatBufferBuilder, this.f8832n);
                int b5 = flatBufferBuilder.b(this.f8834p);
                flatBufferBuilder.c(16);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.b(2, a);
                flatBufferBuilder.b(3, a2);
                flatBufferBuilder.b(4, a3);
                flatBufferBuilder.b(5, b3);
                flatBufferBuilder.b(6, a4);
                flatBufferBuilder.b(7, a5);
                flatBufferBuilder.b(8, c);
                flatBufferBuilder.b(9, a6);
                flatBufferBuilder.b(10, a7);
                flatBufferBuilder.b(11, b4);
                flatBufferBuilder.b(12, d);
                flatBufferBuilder.b(13, a8);
                flatBufferBuilder.a(14, this.f8833o, 0);
                flatBufferBuilder.b(15, b5);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new GetNativeAppDetailsAppStoreApplicationGraphQLModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: ogActionType */
        public final class DescriptionModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f8836d;

            /* compiled from: ogActionType */
            public final class Builder {
                @Nullable
                public String f8835a;
            }

            /* compiled from: ogActionType */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(DescriptionModel.class, new Deserializer());
                }

                public Object m12572a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(DescriptionParser.m12662a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object descriptionModel = new DescriptionModel();
                    ((BaseModel) descriptionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (descriptionModel instanceof Postprocessable) {
                        return ((Postprocessable) descriptionModel).a();
                    }
                    return descriptionModel;
                }
            }

            /* compiled from: ogActionType */
            public class Serializer extends JsonSerializer<DescriptionModel> {
                public final void m12573a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    DescriptionModel descriptionModel = (DescriptionModel) obj;
                    if (descriptionModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(descriptionModel.m12575a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        descriptionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    DescriptionParser.m12663a(descriptionModel.w_(), descriptionModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(DescriptionModel.class, new Serializer());
                }
            }

            public DescriptionModel() {
                super(1);
            }

            public DescriptionModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m12577a() {
                this.f8836d = super.a(this.f8836d, 0);
                return this.f8836d;
            }

            public static DescriptionModel m12574a(DescriptionModel descriptionModel) {
                if (descriptionModel == null) {
                    return null;
                }
                if (descriptionModel instanceof DescriptionModel) {
                    return descriptionModel;
                }
                Builder builder = new Builder();
                builder.f8835a = descriptionModel.m12577a();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f8835a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new DescriptionModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m12576a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m12575a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m12577a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: ogActionType */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GetNativeAppDetailsAppStoreApplicationGraphQLModel.class, new Deserializer());
            }

            public Object m12578a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(GetNativeAppDetailsAppStoreApplicationGraphQLParser.m12666a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object getNativeAppDetailsAppStoreApplicationGraphQLModel = new GetNativeAppDetailsAppStoreApplicationGraphQLModel();
                ((BaseModel) getNativeAppDetailsAppStoreApplicationGraphQLModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (getNativeAppDetailsAppStoreApplicationGraphQLModel instanceof Postprocessable) {
                    return ((Postprocessable) getNativeAppDetailsAppStoreApplicationGraphQLModel).a();
                }
                return getNativeAppDetailsAppStoreApplicationGraphQLModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1025165708)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: ogActionType */
        public final class PlatformApplicationModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f8840d;
            @Nullable
            private String f8841e;
            @Nullable
            private String f8842f;

            /* compiled from: ogActionType */
            public final class Builder {
                @Nullable
                public String f8837a;
                @Nullable
                public String f8838b;
                @Nullable
                public String f8839c;
            }

            /* compiled from: ogActionType */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PlatformApplicationModel.class, new Deserializer());
                }

                public Object m12579a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PlatformApplicationParser.m12664a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object platformApplicationModel = new PlatformApplicationModel();
                    ((BaseModel) platformApplicationModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (platformApplicationModel instanceof Postprocessable) {
                        return ((Postprocessable) platformApplicationModel).a();
                    }
                    return platformApplicationModel;
                }
            }

            /* compiled from: ogActionType */
            public class Serializer extends JsonSerializer<PlatformApplicationModel> {
                public final void m12580a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PlatformApplicationModel platformApplicationModel = (PlatformApplicationModel) obj;
                    if (platformApplicationModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(platformApplicationModel.m12582a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        platformApplicationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PlatformApplicationParser.m12665a(platformApplicationModel.w_(), platformApplicationModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PlatformApplicationModel.class, new Serializer());
                }
            }

            public PlatformApplicationModel() {
                super(3);
            }

            public PlatformApplicationModel(MutableFlatBuffer mutableFlatBuffer) {
                super(3);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m12585b() {
                this.f8840d = super.a(this.f8840d, 0);
                return this.f8840d;
            }

            @Nullable
            public final String m12586c() {
                this.f8841e = super.a(this.f8841e, 1);
                return this.f8841e;
            }

            @Nullable
            public final String m12587d() {
                this.f8842f = super.a(this.f8842f, 2);
                return this.f8842f;
            }

            public static PlatformApplicationModel m12581a(PlatformApplicationModel platformApplicationModel) {
                if (platformApplicationModel == null) {
                    return null;
                }
                if (platformApplicationModel instanceof PlatformApplicationModel) {
                    return platformApplicationModel;
                }
                Builder builder = new Builder();
                builder.f8837a = platformApplicationModel.m12585b();
                builder.f8838b = platformApplicationModel.m12586c();
                builder.f8839c = platformApplicationModel.m12587d();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f8837a);
                int b2 = flatBufferBuilder.b(builder.f8838b);
                int b3 = flatBufferBuilder.b(builder.f8839c);
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.b(2, b3);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new PlatformApplicationModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            @Nullable
            public final String m12584a() {
                return m12585b();
            }

            public final int jK_() {
                return -1072845520;
            }

            public final GraphQLVisitableModel m12583a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m12582a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m12585b());
                int b2 = flatBufferBuilder.b(m12586c());
                int b3 = flatBufferBuilder.b(m12587d());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.b(2, b3);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: ogActionType */
        public class Serializer extends JsonSerializer<GetNativeAppDetailsAppStoreApplicationGraphQLModel> {
            public final void m12588a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                GetNativeAppDetailsAppStoreApplicationGraphQLModel getNativeAppDetailsAppStoreApplicationGraphQLModel = (GetNativeAppDetailsAppStoreApplicationGraphQLModel) obj;
                if (getNativeAppDetailsAppStoreApplicationGraphQLModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(getNativeAppDetailsAppStoreApplicationGraphQLModel.m12594a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    getNativeAppDetailsAppStoreApplicationGraphQLModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                GetNativeAppDetailsAppStoreApplicationGraphQLParser.m12667a(getNativeAppDetailsAppStoreApplicationGraphQLModel.w_(), getNativeAppDetailsAppStoreApplicationGraphQLModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(GetNativeAppDetailsAppStoreApplicationGraphQLModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ GetNativeAppDetailsTextWithEntitiesGraphQLModel cs_() {
            return m12591s();
        }

        @Nullable
        public final /* synthetic */ DescriptionModel m12600d() {
            return m12590r();
        }

        @Nullable
        public final /* synthetic */ PlatformApplicationModel m12604l() {
            return m12592t();
        }

        @Nullable
        public final /* synthetic */ GetNativeAppDetailsTextWithEntitiesGraphQLModel m12607o() {
            return m12593u();
        }

        public GetNativeAppDetailsAppStoreApplicationGraphQLModel() {
            super(16);
        }

        public GetNativeAppDetailsAppStoreApplicationGraphQLModel(MutableFlatBuffer mutableFlatBuffer) {
            super(16);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final String m12596a() {
            this.f8843d = super.a(this.f8843d, 0);
            return this.f8843d;
        }

        @Nullable
        public final String m12598b() {
            this.f8844e = super.a(this.f8844e, 1);
            return this.f8844e;
        }

        @Nonnull
        public final ImmutableList<GetNativeAppDetailsImageGraphQLModel> m12599c() {
            this.f8845f = super.a(this.f8845f, 2, GetNativeAppDetailsImageGraphQLModel.class);
            return (ImmutableList) this.f8845f;
        }

        @Nullable
        private DescriptionModel m12590r() {
            this.f8846g = (DescriptionModel) super.a(this.f8846g, 3, DescriptionModel.class);
            return this.f8846g;
        }

        @Nullable
        public final GraphQLAppStoreDownloadConnectivityPolicy cq_() {
            this.f8847h = (GraphQLAppStoreDownloadConnectivityPolicy) super.b(this.f8847h, 4, GraphQLAppStoreDownloadConnectivityPolicy.class, GraphQLAppStoreDownloadConnectivityPolicy.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f8847h;
        }

        @Nullable
        public final String m12601g() {
            this.f8848i = super.a(this.f8848i, 5);
            return this.f8848i;
        }

        @Nullable
        public final GraphQLAppStoreApplicationInstallState cr_() {
            this.f8849j = (GraphQLAppStoreApplicationInstallState) super.b(this.f8849j, 6, GraphQLAppStoreApplicationInstallState.class, GraphQLAppStoreApplicationInstallState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f8849j;
        }

        @Nullable
        private GetNativeAppDetailsTextWithEntitiesGraphQLModel m12591s() {
            this.f8850k = (GetNativeAppDetailsTextWithEntitiesGraphQLModel) super.a(this.f8850k, 7, GetNativeAppDetailsTextWithEntitiesGraphQLModel.class);
            return this.f8850k;
        }

        @Nonnull
        public final ImmutableList<String> m12602j() {
            this.f8851l = super.a(this.f8851l, 8);
            return (ImmutableList) this.f8851l;
        }

        @Nonnull
        public final ImmutableList<GetNativeAppDetailsImageGraphQLModel> m12603k() {
            this.f8852m = super.a(this.f8852m, 9, GetNativeAppDetailsImageGraphQLModel.class);
            return (ImmutableList) this.f8852m;
        }

        @Nullable
        private PlatformApplicationModel m12592t() {
            this.f8853n = (PlatformApplicationModel) super.a(this.f8853n, 10, PlatformApplicationModel.class);
            return this.f8853n;
        }

        @Nullable
        public final String m12605m() {
            this.f8854o = super.a(this.f8854o, 11);
            return this.f8854o;
        }

        @Nonnull
        public final ImmutableList<GraphQLDigitalGoodStoreType> m12606n() {
            this.f8855p = super.c(this.f8855p, 12, GraphQLDigitalGoodStoreType.class);
            return (ImmutableList) this.f8855p;
        }

        @Nullable
        private GetNativeAppDetailsTextWithEntitiesGraphQLModel m12593u() {
            this.f8856q = (GetNativeAppDetailsTextWithEntitiesGraphQLModel) super.a(this.f8856q, 13, GetNativeAppDetailsTextWithEntitiesGraphQLModel.class);
            return this.f8856q;
        }

        public final int m12608p() {
            a(1, 6);
            return this.f8857r;
        }

        @Nullable
        public final String m12609q() {
            this.f8858s = super.a(this.f8858s, 15);
            return this.f8858s;
        }

        public static GetNativeAppDetailsAppStoreApplicationGraphQLModel m12589a(GetNativeAppDetailsAppStoreApplicationGraphQLModel getNativeAppDetailsAppStoreApplicationGraphQLModel) {
            int i = 0;
            if (getNativeAppDetailsAppStoreApplicationGraphQLModel == null) {
                return null;
            }
            if (getNativeAppDetailsAppStoreApplicationGraphQLModel instanceof GetNativeAppDetailsAppStoreApplicationGraphQLModel) {
                return getNativeAppDetailsAppStoreApplicationGraphQLModel;
            }
            int i2;
            Builder builder = new Builder();
            builder.f8819a = getNativeAppDetailsAppStoreApplicationGraphQLModel.m12596a();
            builder.f8820b = getNativeAppDetailsAppStoreApplicationGraphQLModel.m12598b();
            com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
            for (i2 = 0; i2 < getNativeAppDetailsAppStoreApplicationGraphQLModel.m12599c().size(); i2++) {
                builder2.c(GetNativeAppDetailsImageGraphQLModel.m12623a((GetNativeAppDetailsImageGraphQLModel) getNativeAppDetailsAppStoreApplicationGraphQLModel.m12599c().get(i2)));
            }
            builder.f8821c = builder2.b();
            builder.f8822d = DescriptionModel.m12574a(getNativeAppDetailsAppStoreApplicationGraphQLModel.m12600d());
            builder.f8823e = getNativeAppDetailsAppStoreApplicationGraphQLModel.cq_();
            builder.f8824f = getNativeAppDetailsAppStoreApplicationGraphQLModel.m12601g();
            builder.f8825g = getNativeAppDetailsAppStoreApplicationGraphQLModel.cr_();
            builder.f8826h = GetNativeAppDetailsTextWithEntitiesGraphQLModel.m12654a(getNativeAppDetailsAppStoreApplicationGraphQLModel.cs_());
            com.google.common.collect.ImmutableList.Builder builder3 = ImmutableList.builder();
            for (int i3 = 0; i3 < getNativeAppDetailsAppStoreApplicationGraphQLModel.m12602j().size(); i3++) {
                builder3.c(getNativeAppDetailsAppStoreApplicationGraphQLModel.m12602j().get(i3));
            }
            builder.f8827i = builder3.b();
            builder2 = ImmutableList.builder();
            for (i2 = 0; i2 < getNativeAppDetailsAppStoreApplicationGraphQLModel.m12603k().size(); i2++) {
                builder2.c(GetNativeAppDetailsImageGraphQLModel.m12623a((GetNativeAppDetailsImageGraphQLModel) getNativeAppDetailsAppStoreApplicationGraphQLModel.m12603k().get(i2)));
            }
            builder.f8828j = builder2.b();
            builder.f8829k = PlatformApplicationModel.m12581a(getNativeAppDetailsAppStoreApplicationGraphQLModel.m12604l());
            builder.f8830l = getNativeAppDetailsAppStoreApplicationGraphQLModel.m12605m();
            com.google.common.collect.ImmutableList.Builder builder4 = ImmutableList.builder();
            while (i < getNativeAppDetailsAppStoreApplicationGraphQLModel.m12606n().size()) {
                builder4.c(getNativeAppDetailsAppStoreApplicationGraphQLModel.m12606n().get(i));
                i++;
            }
            builder.f8831m = builder4.b();
            builder.f8832n = GetNativeAppDetailsTextWithEntitiesGraphQLModel.m12654a(getNativeAppDetailsAppStoreApplicationGraphQLModel.m12607o());
            builder.f8833o = getNativeAppDetailsAppStoreApplicationGraphQLModel.m12608p();
            builder.f8834p = getNativeAppDetailsAppStoreApplicationGraphQLModel.m12609q();
            return builder.m12571a();
        }

        public final int jK_() {
            return 1254437328;
        }

        public final GraphQLVisitableModel m12595a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GetNativeAppDetailsAppStoreApplicationGraphQLModel getNativeAppDetailsAppStoreApplicationGraphQLModel;
            GraphQLVisitableModel graphQLVisitableModel;
            DescriptionModel descriptionModel;
            GetNativeAppDetailsTextWithEntitiesGraphQLModel getNativeAppDetailsTextWithEntitiesGraphQLModel;
            com.google.common.collect.ImmutableList.Builder a;
            PlatformApplicationModel platformApplicationModel;
            h();
            if (m12599c() != null) {
                com.google.common.collect.ImmutableList.Builder a2 = ModelHelper.a(m12599c(), graphQLModelMutatingVisitor);
                if (a2 != null) {
                    getNativeAppDetailsAppStoreApplicationGraphQLModel = (GetNativeAppDetailsAppStoreApplicationGraphQLModel) ModelHelper.a(null, this);
                    getNativeAppDetailsAppStoreApplicationGraphQLModel.f8845f = a2.b();
                    graphQLVisitableModel = getNativeAppDetailsAppStoreApplicationGraphQLModel;
                    if (m12590r() != null) {
                        descriptionModel = (DescriptionModel) graphQLModelMutatingVisitor.b(m12590r());
                        if (m12590r() != descriptionModel) {
                            graphQLVisitableModel = (GetNativeAppDetailsAppStoreApplicationGraphQLModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f8846g = descriptionModel;
                        }
                    }
                    if (m12591s() != null) {
                        getNativeAppDetailsTextWithEntitiesGraphQLModel = (GetNativeAppDetailsTextWithEntitiesGraphQLModel) graphQLModelMutatingVisitor.b(m12591s());
                        if (m12591s() != getNativeAppDetailsTextWithEntitiesGraphQLModel) {
                            graphQLVisitableModel = (GetNativeAppDetailsAppStoreApplicationGraphQLModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f8850k = getNativeAppDetailsTextWithEntitiesGraphQLModel;
                        }
                    }
                    if (m12603k() != null) {
                        a = ModelHelper.a(m12603k(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            getNativeAppDetailsAppStoreApplicationGraphQLModel = (GetNativeAppDetailsAppStoreApplicationGraphQLModel) ModelHelper.a(graphQLVisitableModel, this);
                            getNativeAppDetailsAppStoreApplicationGraphQLModel.f8852m = a.b();
                            graphQLVisitableModel = getNativeAppDetailsAppStoreApplicationGraphQLModel;
                        }
                    }
                    if (m12592t() != null) {
                        platformApplicationModel = (PlatformApplicationModel) graphQLModelMutatingVisitor.b(m12592t());
                        if (m12592t() != platformApplicationModel) {
                            graphQLVisitableModel = (GetNativeAppDetailsAppStoreApplicationGraphQLModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f8853n = platformApplicationModel;
                        }
                    }
                    if (m12593u() != null) {
                        getNativeAppDetailsTextWithEntitiesGraphQLModel = (GetNativeAppDetailsTextWithEntitiesGraphQLModel) graphQLModelMutatingVisitor.b(m12593u());
                        if (m12593u() != getNativeAppDetailsTextWithEntitiesGraphQLModel) {
                            graphQLVisitableModel = (GetNativeAppDetailsAppStoreApplicationGraphQLModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f8856q = getNativeAppDetailsTextWithEntitiesGraphQLModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m12590r() != null) {
                descriptionModel = (DescriptionModel) graphQLModelMutatingVisitor.b(m12590r());
                if (m12590r() != descriptionModel) {
                    graphQLVisitableModel = (GetNativeAppDetailsAppStoreApplicationGraphQLModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8846g = descriptionModel;
                }
            }
            if (m12591s() != null) {
                getNativeAppDetailsTextWithEntitiesGraphQLModel = (GetNativeAppDetailsTextWithEntitiesGraphQLModel) graphQLModelMutatingVisitor.b(m12591s());
                if (m12591s() != getNativeAppDetailsTextWithEntitiesGraphQLModel) {
                    graphQLVisitableModel = (GetNativeAppDetailsAppStoreApplicationGraphQLModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8850k = getNativeAppDetailsTextWithEntitiesGraphQLModel;
                }
            }
            if (m12603k() != null) {
                a = ModelHelper.a(m12603k(), graphQLModelMutatingVisitor);
                if (a != null) {
                    getNativeAppDetailsAppStoreApplicationGraphQLModel = (GetNativeAppDetailsAppStoreApplicationGraphQLModel) ModelHelper.a(graphQLVisitableModel, this);
                    getNativeAppDetailsAppStoreApplicationGraphQLModel.f8852m = a.b();
                    graphQLVisitableModel = getNativeAppDetailsAppStoreApplicationGraphQLModel;
                }
            }
            if (m12592t() != null) {
                platformApplicationModel = (PlatformApplicationModel) graphQLModelMutatingVisitor.b(m12592t());
                if (m12592t() != platformApplicationModel) {
                    graphQLVisitableModel = (GetNativeAppDetailsAppStoreApplicationGraphQLModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8853n = platformApplicationModel;
                }
            }
            if (m12593u() != null) {
                getNativeAppDetailsTextWithEntitiesGraphQLModel = (GetNativeAppDetailsTextWithEntitiesGraphQLModel) graphQLModelMutatingVisitor.b(m12593u());
                if (m12593u() != getNativeAppDetailsTextWithEntitiesGraphQLModel) {
                    graphQLVisitableModel = (GetNativeAppDetailsAppStoreApplicationGraphQLModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8856q = getNativeAppDetailsTextWithEntitiesGraphQLModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m12594a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m12596a());
            int b2 = flatBufferBuilder.b(m12598b());
            int a = ModelHelper.a(flatBufferBuilder, m12599c());
            int a2 = ModelHelper.a(flatBufferBuilder, m12590r());
            int a3 = flatBufferBuilder.a(cq_());
            int b3 = flatBufferBuilder.b(m12601g());
            int a4 = flatBufferBuilder.a(cr_());
            int a5 = ModelHelper.a(flatBufferBuilder, m12591s());
            int c = flatBufferBuilder.c(m12602j());
            int a6 = ModelHelper.a(flatBufferBuilder, m12603k());
            int a7 = ModelHelper.a(flatBufferBuilder, m12592t());
            int b4 = flatBufferBuilder.b(m12605m());
            int d = flatBufferBuilder.d(m12606n());
            int a8 = ModelHelper.a(flatBufferBuilder, m12593u());
            int b5 = flatBufferBuilder.b(m12609q());
            flatBufferBuilder.c(16);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, a);
            flatBufferBuilder.b(3, a2);
            flatBufferBuilder.b(4, a3);
            flatBufferBuilder.b(5, b3);
            flatBufferBuilder.b(6, a4);
            flatBufferBuilder.b(7, a5);
            flatBufferBuilder.b(8, c);
            flatBufferBuilder.b(9, a6);
            flatBufferBuilder.b(10, a7);
            flatBufferBuilder.b(11, b4);
            flatBufferBuilder.b(12, d);
            flatBufferBuilder.b(13, a8);
            flatBufferBuilder.a(14, this.f8857r, 0);
            flatBufferBuilder.b(15, b5);
            i();
            return flatBufferBuilder.d();
        }

        public final void m12597a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f8857r = mutableFlatBuffer.a(i, 14, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1682936652)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: ogActionType */
    public final class GetNativeAppDetailsFromActorGraphQLModel extends BaseModel implements GetNativeAppDetailsFromActorGraphQL, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f8859d;
        @Nullable
        private GetNativeAppDetailsAppStoreApplicationGraphQLModel f8860e;
        @Nullable
        private String f8861f;
        @Nullable
        private C0591xa9e2267b f8862g;

        /* compiled from: ogActionType */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GetNativeAppDetailsFromActorGraphQLModel.class, new Deserializer());
            }

            public Object m12610a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GetNativeAppDetailsFromActorGraphQLParser.m12668a(jsonParser);
                Object getNativeAppDetailsFromActorGraphQLModel = new GetNativeAppDetailsFromActorGraphQLModel();
                ((BaseModel) getNativeAppDetailsFromActorGraphQLModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (getNativeAppDetailsFromActorGraphQLModel instanceof Postprocessable) {
                    return ((Postprocessable) getNativeAppDetailsFromActorGraphQLModel).a();
                }
                return getNativeAppDetailsFromActorGraphQLModel;
            }
        }

        /* compiled from: ogActionType */
        public class Serializer extends JsonSerializer<GetNativeAppDetailsFromActorGraphQLModel> {
            public final void m12611a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GetNativeAppDetailsFromActorGraphQLModel getNativeAppDetailsFromActorGraphQLModel = (GetNativeAppDetailsFromActorGraphQLModel) obj;
                if (getNativeAppDetailsFromActorGraphQLModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(getNativeAppDetailsFromActorGraphQLModel.m12615a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    getNativeAppDetailsFromActorGraphQLModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = getNativeAppDetailsFromActorGraphQLModel.w_();
                int u_ = getNativeAppDetailsFromActorGraphQLModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("backing_application");
                    GetNativeAppDetailsAppStoreApplicationGraphQLParser.m12667a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 2));
                }
                g = mutableFlatBuffer.g(u_, 3);
                if (g != 0) {
                    jsonGenerator.a("profile_picture");
                    ProfilePictureParser.m12660a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GetNativeAppDetailsFromActorGraphQLModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ C0589xd643bf8b m12619l() {
            return m12614k();
        }

        @Nullable
        public final /* synthetic */ GetNativeAppDetailsAppStoreApplicationGraphQLModel m12620m() {
            return m12613j();
        }

        public GetNativeAppDetailsFromActorGraphQLModel() {
            super(4);
        }

        public final void m12617a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m12618a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m12612a() {
            if (this.b != null && this.f8859d == null) {
                this.f8859d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f8859d;
        }

        @Nullable
        private GetNativeAppDetailsAppStoreApplicationGraphQLModel m12613j() {
            this.f8860e = (GetNativeAppDetailsAppStoreApplicationGraphQLModel) super.a(this.f8860e, 1, GetNativeAppDetailsAppStoreApplicationGraphQLModel.class);
            return this.f8860e;
        }

        @Nullable
        public final String C_() {
            this.f8861f = super.a(this.f8861f, 2);
            return this.f8861f;
        }

        @Nullable
        private C0591xa9e2267b m12614k() {
            this.f8862g = (C0591xa9e2267b) super.a(this.f8862g, 3, C0591xa9e2267b.class);
            return this.f8862g;
        }

        public final int jK_() {
            return 63093205;
        }

        public final GraphQLVisitableModel m12616a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m12613j() != null) {
                GetNativeAppDetailsAppStoreApplicationGraphQLModel getNativeAppDetailsAppStoreApplicationGraphQLModel = (GetNativeAppDetailsAppStoreApplicationGraphQLModel) graphQLModelMutatingVisitor.b(m12613j());
                if (m12613j() != getNativeAppDetailsAppStoreApplicationGraphQLModel) {
                    graphQLVisitableModel = (GetNativeAppDetailsFromActorGraphQLModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8860e = getNativeAppDetailsAppStoreApplicationGraphQLModel;
                }
            }
            if (m12614k() != null) {
                C0591xa9e2267b c0591xa9e2267b = (C0591xa9e2267b) graphQLModelMutatingVisitor.b(m12614k());
                if (m12614k() != c0591xa9e2267b) {
                    graphQLVisitableModel = (GetNativeAppDetailsFromActorGraphQLModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8862g = c0591xa9e2267b;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m12615a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m12612a());
            int a2 = ModelHelper.a(flatBufferBuilder, m12613j());
            int b = flatBufferBuilder.b(C_());
            int a3 = ModelHelper.a(flatBufferBuilder, m12614k());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, a3);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 729935302)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: ogActionType */
    public final class GetNativeAppDetailsImageGraphQLModel extends BaseModel implements GraphQLVisitableModel {
        private int f8866d;
        @Nullable
        private String f8867e;
        private int f8868f;

        /* compiled from: ogActionType */
        public final class Builder {
            public int f8863a;
            @Nullable
            public String f8864b;
            public int f8865c;
        }

        /* compiled from: ogActionType */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GetNativeAppDetailsImageGraphQLModel.class, new Deserializer());
            }

            public Object m12621a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(GetNativeAppDetailsImageGraphQLParser.m12672b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object getNativeAppDetailsImageGraphQLModel = new GetNativeAppDetailsImageGraphQLModel();
                ((BaseModel) getNativeAppDetailsImageGraphQLModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (getNativeAppDetailsImageGraphQLModel instanceof Postprocessable) {
                    return ((Postprocessable) getNativeAppDetailsImageGraphQLModel).a();
                }
                return getNativeAppDetailsImageGraphQLModel;
            }
        }

        /* compiled from: ogActionType */
        public class Serializer extends JsonSerializer<GetNativeAppDetailsImageGraphQLModel> {
            public final void m12622a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                GetNativeAppDetailsImageGraphQLModel getNativeAppDetailsImageGraphQLModel = (GetNativeAppDetailsImageGraphQLModel) obj;
                if (getNativeAppDetailsImageGraphQLModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(getNativeAppDetailsImageGraphQLModel.m12625a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    getNativeAppDetailsImageGraphQLModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                GetNativeAppDetailsImageGraphQLParser.m12670a(getNativeAppDetailsImageGraphQLModel.w_(), getNativeAppDetailsImageGraphQLModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(GetNativeAppDetailsImageGraphQLModel.class, new Serializer());
            }
        }

        public GetNativeAppDetailsImageGraphQLModel() {
            super(3);
        }

        public GetNativeAppDetailsImageGraphQLModel(MutableFlatBuffer mutableFlatBuffer) {
            super(3);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final int m12624a() {
            a(0, 0);
            return this.f8866d;
        }

        @Nullable
        public final String m12628b() {
            this.f8867e = super.a(this.f8867e, 1);
            return this.f8867e;
        }

        public final int m12629c() {
            a(0, 2);
            return this.f8868f;
        }

        public static GetNativeAppDetailsImageGraphQLModel m12623a(GetNativeAppDetailsImageGraphQLModel getNativeAppDetailsImageGraphQLModel) {
            if (getNativeAppDetailsImageGraphQLModel == null) {
                return null;
            }
            if (getNativeAppDetailsImageGraphQLModel instanceof GetNativeAppDetailsImageGraphQLModel) {
                return getNativeAppDetailsImageGraphQLModel;
            }
            Builder builder = new Builder();
            builder.f8863a = getNativeAppDetailsImageGraphQLModel.m12624a();
            builder.f8864b = getNativeAppDetailsImageGraphQLModel.m12628b();
            builder.f8865c = getNativeAppDetailsImageGraphQLModel.m12629c();
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int b = flatBufferBuilder.b(builder.f8864b);
            flatBufferBuilder.c(3);
            flatBufferBuilder.a(0, builder.f8863a, 0);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.a(2, builder.f8865c, 0);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new GetNativeAppDetailsImageGraphQLModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        public final int jK_() {
            return 70760763;
        }

        public final GraphQLVisitableModel m12626a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m12625a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m12628b());
            flatBufferBuilder.c(3);
            flatBufferBuilder.a(0, this.f8866d, 0);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.a(2, this.f8868f, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m12627a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f8866d = mutableFlatBuffer.a(i, 0, 0);
            this.f8868f = mutableFlatBuffer.a(i, 2, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1844851769)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: ogActionType */
    public final class GetNativeAppDetailsTextWithEntitiesGraphQLModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<RangesModel> f8881d;
        @Nullable
        private String f8882e;

        /* compiled from: ogActionType */
        public final class Builder {
            @Nullable
            public ImmutableList<RangesModel> f8869a;
            @Nullable
            public String f8870b;
        }

        /* compiled from: ogActionType */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GetNativeAppDetailsTextWithEntitiesGraphQLModel.class, new Deserializer());
            }

            public Object m12630a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(GetNativeAppDetailsTextWithEntitiesGraphQLParser.m12679a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object getNativeAppDetailsTextWithEntitiesGraphQLModel = new GetNativeAppDetailsTextWithEntitiesGraphQLModel();
                ((BaseModel) getNativeAppDetailsTextWithEntitiesGraphQLModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (getNativeAppDetailsTextWithEntitiesGraphQLModel instanceof Postprocessable) {
                    return ((Postprocessable) getNativeAppDetailsTextWithEntitiesGraphQLModel).a();
                }
                return getNativeAppDetailsTextWithEntitiesGraphQLModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1214465222)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: ogActionType */
        public final class RangesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private EntityModel f8880d;

            /* compiled from: ogActionType */
            public final class Builder {
                @Nullable
                public EntityModel f8871a;
            }

            /* compiled from: ogActionType */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(RangesModel.class, new Deserializer());
                }

                public Object m12631a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(RangesParser.m12677b(jsonParser, flatBufferBuilder));
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

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1971979045)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: ogActionType */
            public final class EntityModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private GraphQLObjectType f8877d;
                @Nullable
                private String f8878e;
                @Nullable
                private ProfilePictureModel f8879f;

                /* compiled from: ogActionType */
                public final class Builder {
                    @Nullable
                    public GraphQLObjectType f8872a;
                    @Nullable
                    public String f8873b;
                    @Nullable
                    public ProfilePictureModel f8874c;
                }

                /* compiled from: ogActionType */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EntityModel.class, new Deserializer());
                    }

                    public Object m12632a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EntityParser.m12675a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object entityModel = new EntityModel();
                        ((BaseModel) entityModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (entityModel instanceof Postprocessable) {
                            return ((Postprocessable) entityModel).a();
                        }
                        return entityModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 842551240)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: ogActionType */
                public final class ProfilePictureModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f8876d;

                    /* compiled from: ogActionType */
                    public final class Builder {
                        @Nullable
                        public String f8875a;
                    }

                    /* compiled from: ogActionType */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(ProfilePictureModel.class, new Deserializer());
                        }

                        public Object m12633a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(EntityParser.ProfilePictureParser.m12673a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object profilePictureModel = new ProfilePictureModel();
                            ((BaseModel) profilePictureModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (profilePictureModel instanceof Postprocessable) {
                                return ((Postprocessable) profilePictureModel).a();
                            }
                            return profilePictureModel;
                        }
                    }

                    /* compiled from: ogActionType */
                    public class Serializer extends JsonSerializer<ProfilePictureModel> {
                        public final void m12634a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            ProfilePictureModel profilePictureModel = (ProfilePictureModel) obj;
                            if (profilePictureModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(profilePictureModel.m12636a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                profilePictureModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            EntityParser.ProfilePictureParser.m12674a(profilePictureModel.w_(), profilePictureModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(ProfilePictureModel.class, new Serializer());
                        }
                    }

                    public ProfilePictureModel() {
                        super(1);
                    }

                    public ProfilePictureModel(MutableFlatBuffer mutableFlatBuffer) {
                        super(1);
                        a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }

                    @Nullable
                    public final String m12638a() {
                        this.f8876d = super.a(this.f8876d, 0);
                        return this.f8876d;
                    }

                    public static ProfilePictureModel m12635a(ProfilePictureModel profilePictureModel) {
                        if (profilePictureModel == null) {
                            return null;
                        }
                        if (profilePictureModel instanceof ProfilePictureModel) {
                            return profilePictureModel;
                        }
                        Builder builder = new Builder();
                        builder.f8875a = profilePictureModel.m12638a();
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        int b = flatBufferBuilder.b(builder.f8875a);
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        flatBufferBuilder.d(flatBufferBuilder.d());
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        return new ProfilePictureModel(new MutableFlatBuffer(wrap, null, null, true, null));
                    }

                    public final int jK_() {
                        return 70760763;
                    }

                    public final GraphQLVisitableModel m12637a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m12636a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m12638a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: ogActionType */
                public class Serializer extends JsonSerializer<EntityModel> {
                    public final void m12639a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EntityModel entityModel = (EntityModel) obj;
                        if (entityModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(entityModel.m12642a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            entityModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EntityParser.m12676a(entityModel.w_(), entityModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EntityModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ ProfilePictureModel m12646c() {
                    return m12641j();
                }

                public EntityModel() {
                    super(3);
                }

                public EntityModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(3);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                @Nullable
                public final GraphQLObjectType m12643a() {
                    if (this.b != null && this.f8877d == null) {
                        this.f8877d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f8877d;
                }

                @Nullable
                public final String m12645b() {
                    this.f8878e = super.a(this.f8878e, 1);
                    return this.f8878e;
                }

                @Nullable
                private ProfilePictureModel m12641j() {
                    this.f8879f = (ProfilePictureModel) super.a(this.f8879f, 2, ProfilePictureModel.class);
                    return this.f8879f;
                }

                public static EntityModel m12640a(EntityModel entityModel) {
                    if (entityModel == null) {
                        return null;
                    }
                    if (entityModel instanceof EntityModel) {
                        return entityModel;
                    }
                    Builder builder = new Builder();
                    builder.f8872a = entityModel.m12643a();
                    builder.f8873b = entityModel.m12645b();
                    builder.f8874c = ProfilePictureModel.m12635a(entityModel.m12646c());
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, builder.f8872a);
                    int b = flatBufferBuilder.b(builder.f8873b);
                    int a2 = ModelHelper.a(flatBufferBuilder, builder.f8874c);
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.b(2, a2);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new EntityModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                public final int jK_() {
                    return 2080559107;
                }

                public final GraphQLVisitableModel m12644a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m12641j() != null) {
                        ProfilePictureModel profilePictureModel = (ProfilePictureModel) graphQLModelMutatingVisitor.b(m12641j());
                        if (m12641j() != profilePictureModel) {
                            graphQLVisitableModel = (EntityModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f8879f = profilePictureModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m12642a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m12643a());
                    int b = flatBufferBuilder.b(m12645b());
                    int a2 = ModelHelper.a(flatBufferBuilder, m12641j());
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.b(2, a2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: ogActionType */
            public class Serializer extends JsonSerializer<RangesModel> {
                public final void m12647a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    RangesModel rangesModel = (RangesModel) obj;
                    if (rangesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(rangesModel.m12650a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        rangesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    RangesParser.m12678b(rangesModel.w_(), rangesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(RangesModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ EntityModel m12651a() {
                return m12649j();
            }

            public RangesModel() {
                super(1);
            }

            public RangesModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            private EntityModel m12649j() {
                this.f8880d = (EntityModel) super.a(this.f8880d, 0, EntityModel.class);
                return this.f8880d;
            }

            public static RangesModel m12648a(RangesModel rangesModel) {
                if (rangesModel == null) {
                    return null;
                }
                if (rangesModel instanceof RangesModel) {
                    return rangesModel;
                }
                Builder builder = new Builder();
                builder.f8871a = EntityModel.m12640a(rangesModel.m12651a());
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f8871a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new RangesModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return -1024511161;
            }

            public final GraphQLVisitableModel m12652a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m12649j() != null) {
                    EntityModel entityModel = (EntityModel) graphQLModelMutatingVisitor.b(m12649j());
                    if (m12649j() != entityModel) {
                        graphQLVisitableModel = (RangesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f8880d = entityModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m12650a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m12649j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: ogActionType */
        public class Serializer extends JsonSerializer<GetNativeAppDetailsTextWithEntitiesGraphQLModel> {
            public final void m12653a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                GetNativeAppDetailsTextWithEntitiesGraphQLModel getNativeAppDetailsTextWithEntitiesGraphQLModel = (GetNativeAppDetailsTextWithEntitiesGraphQLModel) obj;
                if (getNativeAppDetailsTextWithEntitiesGraphQLModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(getNativeAppDetailsTextWithEntitiesGraphQLModel.m12655a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    getNativeAppDetailsTextWithEntitiesGraphQLModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                GetNativeAppDetailsTextWithEntitiesGraphQLParser.m12680a(getNativeAppDetailsTextWithEntitiesGraphQLModel.w_(), getNativeAppDetailsTextWithEntitiesGraphQLModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(GetNativeAppDetailsTextWithEntitiesGraphQLModel.class, new Serializer());
            }
        }

        public GetNativeAppDetailsTextWithEntitiesGraphQLModel() {
            super(2);
        }

        public GetNativeAppDetailsTextWithEntitiesGraphQLModel(MutableFlatBuffer mutableFlatBuffer) {
            super(2);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nonnull
        public final ImmutableList<RangesModel> m12657a() {
            this.f8881d = super.a(this.f8881d, 0, RangesModel.class);
            return (ImmutableList) this.f8881d;
        }

        @Nullable
        public final String m12658b() {
            this.f8882e = super.a(this.f8882e, 1);
            return this.f8882e;
        }

        public static GetNativeAppDetailsTextWithEntitiesGraphQLModel m12654a(GetNativeAppDetailsTextWithEntitiesGraphQLModel getNativeAppDetailsTextWithEntitiesGraphQLModel) {
            if (getNativeAppDetailsTextWithEntitiesGraphQLModel == null) {
                return null;
            }
            if (getNativeAppDetailsTextWithEntitiesGraphQLModel instanceof GetNativeAppDetailsTextWithEntitiesGraphQLModel) {
                return getNativeAppDetailsTextWithEntitiesGraphQLModel;
            }
            Builder builder = new Builder();
            com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < getNativeAppDetailsTextWithEntitiesGraphQLModel.m12657a().size(); i++) {
                builder2.c(RangesModel.m12648a((RangesModel) getNativeAppDetailsTextWithEntitiesGraphQLModel.m12657a().get(i)));
            }
            builder.f8869a = builder2.b();
            builder.f8870b = getNativeAppDetailsTextWithEntitiesGraphQLModel.m12658b();
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int a = ModelHelper.a(flatBufferBuilder, builder.f8869a);
            int b = flatBufferBuilder.b(builder.f8870b);
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new GetNativeAppDetailsTextWithEntitiesGraphQLModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        public final int jK_() {
            return -1919764332;
        }

        public final GraphQLVisitableModel m12656a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m12657a() != null) {
                com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m12657a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (GetNativeAppDetailsTextWithEntitiesGraphQLModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8881d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m12655a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m12657a());
            int b = flatBufferBuilder.b(m12658b());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}

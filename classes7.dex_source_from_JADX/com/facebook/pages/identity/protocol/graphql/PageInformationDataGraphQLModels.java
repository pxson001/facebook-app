package com.facebook.pages.identity.protocol.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLAttributionSource;
import com.facebook.graphql.enums.GraphQLBusinessInfoType;
import com.facebook.graphql.enums.GraphQLPageInfoFieldStyle;
import com.facebook.graphql.enums.GraphQLPageInfoFieldType;
import com.facebook.graphql.enums.GraphQLPagePaymentOption;
import com.facebook.graphql.enums.GraphQLPermanentlyClosedStatus;
import com.facebook.graphql.enums.GraphQLPlaceType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultLocationFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultTimeRangeFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.pages.identity.protocol.graphql.PageInformationDataGraphQLParsers.FeaturedAdminInfoFragmentParser;
import com.facebook.pages.identity.protocol.graphql.PageInformationDataGraphQLParsers.FeaturedAdminInfoFragmentParser.UserParser;
import com.facebook.pages.identity.protocol.graphql.PageInformationDataGraphQLParsers.FeaturedAdminInfoFragmentParser.UserParser.AdminProfilePicParser;
import com.facebook.pages.identity.protocol.graphql.PageInformationDataGraphQLParsers.PageAttributionParser;
import com.facebook.pages.identity.protocol.graphql.PageInformationDataGraphQLParsers.PageInfoSectionFieldsParser;
import com.facebook.pages.identity.protocol.graphql.PageInformationDataGraphQLParsers.PageInformationDataParser;
import com.facebook.pages.identity.protocol.graphql.PageInformationDataGraphQLParsers.PageInformationDataParser.BusinessInfoParser;
import com.facebook.pages.identity.protocol.graphql.PageInformationDataGraphQLParsers.PageInformationDataParser.BusinessInfoParser.ValueParser;
import com.facebook.pages.identity.protocol.graphql.PageInformationDataGraphQLParsers.PageInformationDataParser.BusinessInfoParser.ValueParser.RangesParser;
import com.facebook.pages.identity.protocol.graphql.PageInformationDataGraphQLParsers.PageInformationDataParser.LocationParser;
import com.facebook.pages.identity.protocol.graphql.PageInformationDataGraphQLParsers.PageInformationDataParser.PageFeaturedAdminInfoParser;
import com.facebook.pages.identity.protocol.graphql.PageInformationDataGraphQLParsers.PageInformationDataParser.PageFeaturedAdminInfoParser.EdgesParser;
import com.facebook.pages.identity.protocol.graphql.PageInformationDataGraphQLParsers.PageInformationDataParser.PageInfoSectionsParser;
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

/* compiled from: measured_width */
public class PageInformationDataGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2030449296)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: measured_width */
    public final class FeaturedAdminInfoFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        private long f9119d;
        @Nullable
        private String f9120e;
        @Nullable
        private String f9121f;
        @Nullable
        private String f9122g;
        private int f9123h;
        private int f9124i;
        @Nullable
        private UserModel f9125j;

        /* compiled from: measured_width */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FeaturedAdminInfoFragmentModel.class, new Deserializer());
            }

            public Object m10961a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FeaturedAdminInfoFragmentParser.m11076a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object featuredAdminInfoFragmentModel = new FeaturedAdminInfoFragmentModel();
                ((BaseModel) featuredAdminInfoFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (featuredAdminInfoFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) featuredAdminInfoFragmentModel).a();
                }
                return featuredAdminInfoFragmentModel;
            }
        }

        /* compiled from: measured_width */
        public class Serializer extends JsonSerializer<FeaturedAdminInfoFragmentModel> {
            public final void m10962a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FeaturedAdminInfoFragmentModel featuredAdminInfoFragmentModel = (FeaturedAdminInfoFragmentModel) obj;
                if (featuredAdminInfoFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(featuredAdminInfoFragmentModel.m10979a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    featuredAdminInfoFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FeaturedAdminInfoFragmentParser.m11077a(featuredAdminInfoFragmentModel.w_(), featuredAdminInfoFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FeaturedAdminInfoFragmentModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1717382287)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: measured_width */
        public final class UserModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private AdminProfilePicModel f9116d;
            @Nullable
            private String f9117e;
            @Nullable
            private String f9118f;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 842551240)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: measured_width */
            public final class AdminProfilePicModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f9115d;

                /* compiled from: measured_width */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(AdminProfilePicModel.class, new Deserializer());
                    }

                    public Object m10963a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(AdminProfilePicParser.m11072a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object adminProfilePicModel = new AdminProfilePicModel();
                        ((BaseModel) adminProfilePicModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (adminProfilePicModel instanceof Postprocessable) {
                            return ((Postprocessable) adminProfilePicModel).a();
                        }
                        return adminProfilePicModel;
                    }
                }

                /* compiled from: measured_width */
                public class Serializer extends JsonSerializer<AdminProfilePicModel> {
                    public final void m10964a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        AdminProfilePicModel adminProfilePicModel = (AdminProfilePicModel) obj;
                        if (adminProfilePicModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(adminProfilePicModel.m10965a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            adminProfilePicModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        AdminProfilePicParser.m11073a(adminProfilePicModel.w_(), adminProfilePicModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(AdminProfilePicModel.class, new Serializer());
                    }
                }

                public AdminProfilePicModel() {
                    super(1);
                }

                @Nullable
                public final String m10967a() {
                    this.f9115d = super.a(this.f9115d, 0);
                    return this.f9115d;
                }

                public final int jK_() {
                    return 70760763;
                }

                public final GraphQLVisitableModel m10966a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m10965a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m10967a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: measured_width */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(UserModel.class, new Deserializer());
                }

                public Object m10968a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(UserParser.m11074a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object userModel = new UserModel();
                    ((BaseModel) userModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (userModel instanceof Postprocessable) {
                        return ((Postprocessable) userModel).a();
                    }
                    return userModel;
                }
            }

            /* compiled from: measured_width */
            public class Serializer extends JsonSerializer<UserModel> {
                public final void m10969a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    UserModel userModel = (UserModel) obj;
                    if (userModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(userModel.m10970a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        userModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    UserParser.m11075a(userModel.w_(), userModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(UserModel.class, new Serializer());
                }
            }

            public UserModel() {
                super(3);
            }

            public final void m10973a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m10974a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final AdminProfilePicModel m10975j() {
                this.f9116d = (AdminProfilePicModel) super.a(this.f9116d, 0, AdminProfilePicModel.class);
                return this.f9116d;
            }

            @Nullable
            public final String m10976k() {
                this.f9117e = super.a(this.f9117e, 1);
                return this.f9117e;
            }

            @Nullable
            public final String m10977l() {
                this.f9118f = super.a(this.f9118f, 2);
                return this.f9118f;
            }

            @Nullable
            public final String m10972a() {
                return m10976k();
            }

            public final int jK_() {
                return 2645995;
            }

            public final GraphQLVisitableModel m10971a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m10975j() != null) {
                    AdminProfilePicModel adminProfilePicModel = (AdminProfilePicModel) graphQLModelMutatingVisitor.b(m10975j());
                    if (m10975j() != adminProfilePicModel) {
                        graphQLVisitableModel = (UserModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f9116d = adminProfilePicModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m10970a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m10975j());
                int b = flatBufferBuilder.b(m10976k());
                int b2 = flatBufferBuilder.b(m10977l());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        public FeaturedAdminInfoFragmentModel() {
            super(7);
        }

        public final long m10983j() {
            a(0, 0);
            return this.f9119d;
        }

        @Nullable
        public final String m10984k() {
            this.f9120e = super.a(this.f9120e, 1);
            return this.f9120e;
        }

        @Nullable
        private String m10978p() {
            this.f9121f = super.a(this.f9121f, 2);
            return this.f9121f;
        }

        @Nullable
        public final String m10985l() {
            this.f9122g = super.a(this.f9122g, 3);
            return this.f9122g;
        }

        public final int m10986m() {
            a(0, 4);
            return this.f9123h;
        }

        public final int m10987n() {
            a(0, 5);
            return this.f9124i;
        }

        @Nullable
        public final UserModel m10988o() {
            this.f9125j = (UserModel) super.a(this.f9125j, 6, UserModel.class);
            return this.f9125j;
        }

        @Nullable
        public final String m10981a() {
            return m10978p();
        }

        public final int jK_() {
            return -2075857937;
        }

        public final GraphQLVisitableModel m10980a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10988o() != null) {
                UserModel userModel = (UserModel) graphQLModelMutatingVisitor.b(m10988o());
                if (m10988o() != userModel) {
                    graphQLVisitableModel = (FeaturedAdminInfoFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9125j = userModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10979a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m10984k());
            int b2 = flatBufferBuilder.b(m10978p());
            int b3 = flatBufferBuilder.b(m10985l());
            int a = ModelHelper.a(flatBufferBuilder, m10988o());
            flatBufferBuilder.c(7);
            flatBufferBuilder.a(0, this.f9119d, 0);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, b3);
            flatBufferBuilder.a(4, this.f9123h, 0);
            flatBufferBuilder.a(5, this.f9124i, 0);
            flatBufferBuilder.b(6, a);
            i();
            return flatBufferBuilder.d();
        }

        public final void m10982a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f9119d = mutableFlatBuffer.a(i, 0, 0);
            this.f9123h = mutableFlatBuffer.a(i, 4, 0);
            this.f9124i = mutableFlatBuffer.a(i, 5, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -156560049)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: measured_width */
    public final class PageAttributionModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private DefaultTextWithEntitiesLongFieldsModel f9126d;
        @Nullable
        private String f9127e;
        @Nullable
        private GraphQLAttributionSource f9128f;

        /* compiled from: measured_width */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PageAttributionModel.class, new Deserializer());
            }

            public Object m10989a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PageAttributionParser.m11079b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object pageAttributionModel = new PageAttributionModel();
                ((BaseModel) pageAttributionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (pageAttributionModel instanceof Postprocessable) {
                    return ((Postprocessable) pageAttributionModel).a();
                }
                return pageAttributionModel;
            }
        }

        /* compiled from: measured_width */
        public class Serializer extends JsonSerializer<PageAttributionModel> {
            public final void m10990a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PageAttributionModel pageAttributionModel = (PageAttributionModel) obj;
                if (pageAttributionModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pageAttributionModel.m10992a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pageAttributionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PageAttributionParser.m11080b(pageAttributionModel.w_(), pageAttributionModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PageAttributionModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesLongFields m10993a() {
            return m10991j();
        }

        public PageAttributionModel() {
            super(3);
        }

        @Nullable
        private DefaultTextWithEntitiesLongFieldsModel m10991j() {
            this.f9126d = (DefaultTextWithEntitiesLongFieldsModel) super.a(this.f9126d, 0, DefaultTextWithEntitiesLongFieldsModel.class);
            return this.f9126d;
        }

        @Nullable
        public final String m10995b() {
            this.f9127e = super.a(this.f9127e, 1);
            return this.f9127e;
        }

        @Nullable
        public final GraphQLAttributionSource m10996c() {
            this.f9128f = (GraphQLAttributionSource) super.b(this.f9128f, 2, GraphQLAttributionSource.class, GraphQLAttributionSource.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f9128f;
        }

        public final int jK_() {
            return -751942829;
        }

        public final GraphQLVisitableModel m10994a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10991j() != null) {
                DefaultTextWithEntitiesLongFieldsModel defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) graphQLModelMutatingVisitor.b(m10991j());
                if (m10991j() != defaultTextWithEntitiesLongFieldsModel) {
                    graphQLVisitableModel = (PageAttributionModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9126d = defaultTextWithEntitiesLongFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10992a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m10991j());
            int b = flatBufferBuilder.b(m10995b());
            int a2 = flatBufferBuilder.a(m10996c());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -887416068)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: measured_width */
    public final class PageInfoSectionFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GraphQLPageInfoFieldType f9129d;
        @Nullable
        private String f9130e;
        @Nullable
        private List<GraphQLPageInfoFieldStyle> f9131f;
        @Nullable
        private DefaultTextWithEntitiesLongFieldsModel f9132g;

        /* compiled from: measured_width */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PageInfoSectionFieldsModel.class, new Deserializer());
            }

            public Object m10997a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PageInfoSectionFieldsParser.m11081b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object pageInfoSectionFieldsModel = new PageInfoSectionFieldsModel();
                ((BaseModel) pageInfoSectionFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (pageInfoSectionFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) pageInfoSectionFieldsModel).a();
                }
                return pageInfoSectionFieldsModel;
            }
        }

        /* compiled from: measured_width */
        public class Serializer extends JsonSerializer<PageInfoSectionFieldsModel> {
            public final void m10998a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PageInfoSectionFieldsModel pageInfoSectionFieldsModel = (PageInfoSectionFieldsModel) obj;
                if (pageInfoSectionFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pageInfoSectionFieldsModel.m11000a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pageInfoSectionFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PageInfoSectionFieldsParser.m11082b(pageInfoSectionFieldsModel.w_(), pageInfoSectionFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PageInfoSectionFieldsModel.class, new Serializer());
            }
        }

        public PageInfoSectionFieldsModel() {
            super(4);
        }

        @Nullable
        private GraphQLPageInfoFieldType m10999l() {
            this.f9129d = (GraphQLPageInfoFieldType) super.b(this.f9129d, 0, GraphQLPageInfoFieldType.class, GraphQLPageInfoFieldType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f9129d;
        }

        @Nullable
        public final String m11002a() {
            this.f9130e = super.a(this.f9130e, 1);
            return this.f9130e;
        }

        @Nonnull
        public final ImmutableList<GraphQLPageInfoFieldStyle> m11003j() {
            this.f9131f = super.c(this.f9131f, 2, GraphQLPageInfoFieldStyle.class);
            return (ImmutableList) this.f9131f;
        }

        @Nullable
        public final DefaultTextWithEntitiesLongFieldsModel m11004k() {
            this.f9132g = (DefaultTextWithEntitiesLongFieldsModel) super.a(this.f9132g, 3, DefaultTextWithEntitiesLongFieldsModel.class);
            return this.f9132g;
        }

        public final int jK_() {
            return 2075485949;
        }

        public final GraphQLVisitableModel m11001a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m11004k() != null) {
                DefaultTextWithEntitiesLongFieldsModel defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) graphQLModelMutatingVisitor.b(m11004k());
                if (m11004k() != defaultTextWithEntitiesLongFieldsModel) {
                    graphQLVisitableModel = (PageInfoSectionFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9132g = defaultTextWithEntitiesLongFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m11000a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = flatBufferBuilder.a(m10999l());
            int b = flatBufferBuilder.b(m11002a());
            int d = flatBufferBuilder.d(m11003j());
            int a2 = ModelHelper.a(flatBufferBuilder, m11004k());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, d);
            flatBufferBuilder.b(3, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1407445079)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: measured_width */
    public final class PageInformationDataModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private List<PageAttributionModel> f9146d;
        @Nullable
        private List<BusinessInfoModel> f9147e;
        @Nullable
        private List<String> f9148f;
        private boolean f9149g;
        @Nullable
        private List<DefaultTimeRangeFieldsModel> f9150h;
        @Nullable
        private String f9151i;
        private boolean f9152j;
        private boolean f9153k;
        private boolean f9154l;
        @Nullable
        private LocationModel f9155m;
        @Nullable
        private String f9156n;
        @Nullable
        private PageFeaturedAdminInfoModel f9157o;
        @Nullable
        private List<PageInfoSectionsModel> f9158p;
        @Nullable
        private List<GraphQLPagePaymentOption> f9159q;
        @Nullable
        private GraphQLPermanentlyClosedStatus f9160r;
        @Nullable
        private GraphQLPlaceType f9161s;
        @Nullable
        private List<String> f9162t;
        @Nullable
        private List<String> f9163u;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -78647654)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: measured_width */
        public final class BusinessInfoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f9137d;
            @Nullable
            private GraphQLBusinessInfoType f9138e;
            @Nullable
            private ValueModel f9139f;

            /* compiled from: measured_width */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(BusinessInfoModel.class, new Deserializer());
                }

                public Object m11005a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(BusinessInfoParser.m11088b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object businessInfoModel = new BusinessInfoModel();
                    ((BaseModel) businessInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (businessInfoModel instanceof Postprocessable) {
                        return ((Postprocessable) businessInfoModel).a();
                    }
                    return businessInfoModel;
                }
            }

            /* compiled from: measured_width */
            public class Serializer extends JsonSerializer<BusinessInfoModel> {
                public final void m11006a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    BusinessInfoModel businessInfoModel = (BusinessInfoModel) obj;
                    if (businessInfoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(businessInfoModel.m11021a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        businessInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    BusinessInfoParser.m11089b(businessInfoModel.w_(), businessInfoModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(BusinessInfoModel.class, new Serializer());
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1755112350)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: measured_width */
            public final class ValueModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private List<RangesModel> f9135d;
                @Nullable
                private String f9136e;

                /* compiled from: measured_width */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ValueModel.class, new Deserializer());
                    }

                    public Object m11007a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ValueParser.m11085a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object valueModel = new ValueModel();
                        ((BaseModel) valueModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (valueModel instanceof Postprocessable) {
                            return ((Postprocessable) valueModel).a();
                        }
                        return valueModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 732242581)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: measured_width */
                public final class RangesModel extends BaseModel implements GraphQLVisitableModel {
                    private int f9133d;
                    private int f9134e;

                    /* compiled from: measured_width */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(RangesModel.class, new Deserializer());
                        }

                        public Object m11008a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(RangesParser.m11084b(jsonParser, flatBufferBuilder));
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

                    /* compiled from: measured_width */
                    public class Serializer extends JsonSerializer<RangesModel> {
                        public final void m11009a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            RangesModel rangesModel = (RangesModel) obj;
                            if (rangesModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(rangesModel.m11011a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                rangesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            RangesParser.m11083a(rangesModel.w_(), rangesModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(RangesModel.class, new Serializer());
                        }
                    }

                    public RangesModel() {
                        super(2);
                    }

                    public final int m11010a() {
                        a(0, 0);
                        return this.f9133d;
                    }

                    public final int m11014j() {
                        a(0, 1);
                        return this.f9134e;
                    }

                    public final int jK_() {
                        return -1024511161;
                    }

                    public final GraphQLVisitableModel m11012a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m11011a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        flatBufferBuilder.c(2);
                        flatBufferBuilder.a(0, this.f9133d, 0);
                        flatBufferBuilder.a(1, this.f9134e, 0);
                        i();
                        return flatBufferBuilder.d();
                    }

                    public final void m11013a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                        super.a(mutableFlatBuffer, i, obj);
                        this.f9133d = mutableFlatBuffer.a(i, 0, 0);
                        this.f9134e = mutableFlatBuffer.a(i, 1, 0);
                    }
                }

                /* compiled from: measured_width */
                public class Serializer extends JsonSerializer<ValueModel> {
                    public final void m11015a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ValueModel valueModel = (ValueModel) obj;
                        if (valueModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(valueModel.m11016a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            valueModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ValueParser.m11086a(valueModel.w_(), valueModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(ValueModel.class, new Serializer());
                    }
                }

                public ValueModel() {
                    super(2);
                }

                @Nonnull
                public final ImmutableList<RangesModel> m11018a() {
                    this.f9135d = super.a(this.f9135d, 0, RangesModel.class);
                    return (ImmutableList) this.f9135d;
                }

                @Nullable
                public final String m11019j() {
                    this.f9136e = super.a(this.f9136e, 1);
                    return this.f9136e;
                }

                public final int jK_() {
                    return -1919764332;
                }

                public final GraphQLVisitableModel m11017a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m11018a() != null) {
                        Builder a = ModelHelper.a(m11018a(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            graphQLVisitableModel = (ValueModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f9135d = a.b();
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m11016a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m11018a());
                    int b = flatBufferBuilder.b(m11019j());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            public BusinessInfoModel() {
                super(3);
            }

            @Nullable
            private String m11020k() {
                this.f9137d = super.a(this.f9137d, 0);
                return this.f9137d;
            }

            @Nullable
            public final GraphQLBusinessInfoType m11022a() {
                this.f9138e = (GraphQLBusinessInfoType) super.b(this.f9138e, 1, GraphQLBusinessInfoType.class, GraphQLBusinessInfoType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f9138e;
            }

            @Nullable
            public final ValueModel m11024j() {
                this.f9139f = (ValueModel) super.a(this.f9139f, 2, ValueModel.class);
                return this.f9139f;
            }

            public final int jK_() {
                return -508752722;
            }

            public final GraphQLVisitableModel m11023a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m11024j() != null) {
                    ValueModel valueModel = (ValueModel) graphQLModelMutatingVisitor.b(m11024j());
                    if (m11024j() != valueModel) {
                        graphQLVisitableModel = (BusinessInfoModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f9139f = valueModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m11021a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m11020k());
                int a = flatBufferBuilder.a(m11022a());
                int a2 = ModelHelper.a(flatBufferBuilder, m11024j());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.b(2, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: measured_width */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PageInformationDataModel.class, new Deserializer());
            }

            public Object m11025a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PageInformationDataParser.m11099a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object pageInformationDataModel = new PageInformationDataModel();
                ((BaseModel) pageInformationDataModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (pageInformationDataModel instanceof Postprocessable) {
                    return ((Postprocessable) pageInformationDataModel).a();
                }
                return pageInformationDataModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -529014945)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: measured_width */
        public final class LocationModel extends BaseModel implements DefaultLocationFields, GraphQLVisitableModel {
            private double f9140d;
            private double f9141e;
            @Nullable
            private String f9142f;

            /* compiled from: measured_width */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(LocationModel.class, new Deserializer());
                }

                public Object m11026a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(LocationParser.m11090a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object locationModel = new LocationModel();
                    ((BaseModel) locationModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (locationModel instanceof Postprocessable) {
                        return ((Postprocessable) locationModel).a();
                    }
                    return locationModel;
                }
            }

            /* compiled from: measured_width */
            public class Serializer extends JsonSerializer<LocationModel> {
                public final void m11027a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    LocationModel locationModel = (LocationModel) obj;
                    if (locationModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(locationModel.m11029a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        locationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    LocationParser.m11091a(locationModel.w_(), locationModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(LocationModel.class, new Serializer());
                }
            }

            public LocationModel() {
                super(3);
            }

            public final double m11028a() {
                a(0, 0);
                return this.f9140d;
            }

            public final double m11032b() {
                a(0, 1);
                return this.f9141e;
            }

            @Nullable
            public final String m11033j() {
                this.f9142f = super.a(this.f9142f, 2);
                return this.f9142f;
            }

            public final int jK_() {
                return 1965687765;
            }

            public final GraphQLVisitableModel m11030a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m11029a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m11033j());
                flatBufferBuilder.c(3);
                flatBufferBuilder.a(0, this.f9140d, 0.0d);
                flatBufferBuilder.a(1, this.f9141e, 0.0d);
                flatBufferBuilder.b(2, b);
                i();
                return flatBufferBuilder.d();
            }

            public final void m11031a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f9140d = mutableFlatBuffer.a(i, 0, 0.0d);
                this.f9141e = mutableFlatBuffer.a(i, 1, 0.0d);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1937642722)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: measured_width */
        public final class PageFeaturedAdminInfoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f9144d;

            /* compiled from: measured_width */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PageFeaturedAdminInfoModel.class, new Deserializer());
                }

                public Object m11034a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PageFeaturedAdminInfoParser.m11094a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object pageFeaturedAdminInfoModel = new PageFeaturedAdminInfoModel();
                    ((BaseModel) pageFeaturedAdminInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (pageFeaturedAdminInfoModel instanceof Postprocessable) {
                        return ((Postprocessable) pageFeaturedAdminInfoModel).a();
                    }
                    return pageFeaturedAdminInfoModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 964949270)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: measured_width */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private FeaturedAdminInfoFragmentModel f9143d;

                /* compiled from: measured_width */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m11035a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EdgesParser.m11092b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object edgesModel = new EdgesModel();
                        ((BaseModel) edgesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (edgesModel instanceof Postprocessable) {
                            return ((Postprocessable) edgesModel).a();
                        }
                        return edgesModel;
                    }
                }

                /* compiled from: measured_width */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m11036a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m11037a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EdgesParser.m11093b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                public EdgesModel() {
                    super(1);
                }

                @Nullable
                public final FeaturedAdminInfoFragmentModel m11039a() {
                    this.f9143d = (FeaturedAdminInfoFragmentModel) super.a(this.f9143d, 0, FeaturedAdminInfoFragmentModel.class);
                    return this.f9143d;
                }

                public final int jK_() {
                    return -1541634302;
                }

                public final GraphQLVisitableModel m11038a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m11039a() != null) {
                        FeaturedAdminInfoFragmentModel featuredAdminInfoFragmentModel = (FeaturedAdminInfoFragmentModel) graphQLModelMutatingVisitor.b(m11039a());
                        if (m11039a() != featuredAdminInfoFragmentModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f9143d = featuredAdminInfoFragmentModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m11037a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m11039a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: measured_width */
            public class Serializer extends JsonSerializer<PageFeaturedAdminInfoModel> {
                public final void m11040a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PageFeaturedAdminInfoModel pageFeaturedAdminInfoModel = (PageFeaturedAdminInfoModel) obj;
                    if (pageFeaturedAdminInfoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pageFeaturedAdminInfoModel.m11041a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pageFeaturedAdminInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PageFeaturedAdminInfoParser.m11095a(pageFeaturedAdminInfoModel.w_(), pageFeaturedAdminInfoModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PageFeaturedAdminInfoModel.class, new Serializer());
                }
            }

            public PageFeaturedAdminInfoModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<EdgesModel> m11043a() {
                this.f9144d = super.a(this.f9144d, 0, EdgesModel.class);
                return (ImmutableList) this.f9144d;
            }

            public final int jK_() {
                return -842477469;
            }

            public final GraphQLVisitableModel m11042a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m11043a() != null) {
                    Builder a = ModelHelper.a(m11043a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (PageFeaturedAdminInfoModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f9144d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m11041a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m11043a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1513902754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: measured_width */
        public final class PageInfoSectionsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<PageInfoSectionFieldsModel> f9145d;

            /* compiled from: measured_width */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PageInfoSectionsModel.class, new Deserializer());
                }

                public Object m11044a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PageInfoSectionsParser.m11097b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object pageInfoSectionsModel = new PageInfoSectionsModel();
                    ((BaseModel) pageInfoSectionsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (pageInfoSectionsModel instanceof Postprocessable) {
                        return ((Postprocessable) pageInfoSectionsModel).a();
                    }
                    return pageInfoSectionsModel;
                }
            }

            /* compiled from: measured_width */
            public class Serializer extends JsonSerializer<PageInfoSectionsModel> {
                public final void m11045a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PageInfoSectionsModel pageInfoSectionsModel = (PageInfoSectionsModel) obj;
                    if (pageInfoSectionsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pageInfoSectionsModel.m11046a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pageInfoSectionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PageInfoSectionsParser.m11098b(pageInfoSectionsModel.w_(), pageInfoSectionsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PageInfoSectionsModel.class, new Serializer());
                }
            }

            public PageInfoSectionsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<PageInfoSectionFieldsModel> m11048a() {
                this.f9145d = super.a(this.f9145d, 0, PageInfoSectionFieldsModel.class);
                return (ImmutableList) this.f9145d;
            }

            public final int jK_() {
                return 213700648;
            }

            public final GraphQLVisitableModel m11047a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m11048a() != null) {
                    Builder a = ModelHelper.a(m11048a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (PageInfoSectionsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f9145d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m11046a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m11048a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: measured_width */
        public class Serializer extends JsonSerializer<PageInformationDataModel> {
            public final void m11049a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PageInformationDataModel pageInformationDataModel = (PageInformationDataModel) obj;
                if (pageInformationDataModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pageInformationDataModel.m11050a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pageInformationDataModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PageInformationDataParser.m11100a(pageInformationDataModel.w_(), pageInformationDataModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PageInformationDataModel.class, new Serializer());
            }
        }

        public PageInformationDataModel() {
            super(18);
        }

        public final void m11054a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m11055a(String str, Object obj, boolean z) {
        }

        @Nonnull
        public final ImmutableList<PageAttributionModel> m11056j() {
            this.f9146d = super.a(this.f9146d, 0, PageAttributionModel.class);
            return (ImmutableList) this.f9146d;
        }

        @Nonnull
        public final ImmutableList<BusinessInfoModel> m11057k() {
            this.f9147e = super.a(this.f9147e, 1, BusinessInfoModel.class);
            return (ImmutableList) this.f9147e;
        }

        @Nonnull
        public final ImmutableList<String> m11058l() {
            this.f9148f = super.a(this.f9148f, 2);
            return (ImmutableList) this.f9148f;
        }

        public final boolean m11059m() {
            a(0, 3);
            return this.f9149g;
        }

        @Nonnull
        public final ImmutableList<DefaultTimeRangeFieldsModel> m11060n() {
            this.f9150h = super.a(this.f9150h, 4, DefaultTimeRangeFieldsModel.class);
            return (ImmutableList) this.f9150h;
        }

        @Nullable
        public final String m11061o() {
            this.f9151i = super.a(this.f9151i, 5);
            return this.f9151i;
        }

        public final boolean m11062p() {
            a(0, 7);
            return this.f9153k;
        }

        @Nullable
        public final LocationModel m11063q() {
            this.f9155m = (LocationModel) super.a(this.f9155m, 9, LocationModel.class);
            return this.f9155m;
        }

        @Nullable
        public final String m11064r() {
            this.f9156n = super.a(this.f9156n, 10);
            return this.f9156n;
        }

        @Nullable
        public final PageFeaturedAdminInfoModel m11065s() {
            this.f9157o = (PageFeaturedAdminInfoModel) super.a(this.f9157o, 11, PageFeaturedAdminInfoModel.class);
            return this.f9157o;
        }

        @Nonnull
        public final ImmutableList<PageInfoSectionsModel> m11066t() {
            this.f9158p = super.a(this.f9158p, 12, PageInfoSectionsModel.class);
            return (ImmutableList) this.f9158p;
        }

        @Nonnull
        public final ImmutableList<GraphQLPagePaymentOption> m11067u() {
            this.f9159q = super.c(this.f9159q, 13, GraphQLPagePaymentOption.class);
            return (ImmutableList) this.f9159q;
        }

        @Nullable
        public final GraphQLPermanentlyClosedStatus m11068v() {
            this.f9160r = (GraphQLPermanentlyClosedStatus) super.b(this.f9160r, 14, GraphQLPermanentlyClosedStatus.class, GraphQLPermanentlyClosedStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f9160r;
        }

        @Nullable
        public final GraphQLPlaceType m11069w() {
            this.f9161s = (GraphQLPlaceType) super.b(this.f9161s, 15, GraphQLPlaceType.class, GraphQLPlaceType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f9161s;
        }

        @Nonnull
        public final ImmutableList<String> m11070x() {
            this.f9162t = super.a(this.f9162t, 16);
            return (ImmutableList) this.f9162t;
        }

        @Nonnull
        public final ImmutableList<String> m11071y() {
            this.f9163u = super.a(this.f9163u, 17);
            return (ImmutableList) this.f9163u;
        }

        @Nullable
        public final String m11052a() {
            return m11061o();
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m11051a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            Builder a;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m11056j() != null) {
                a = ModelHelper.a(m11056j(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (PageInformationDataModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9146d = a.b();
                }
            }
            if (m11057k() != null) {
                a = ModelHelper.a(m11057k(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (PageInformationDataModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9147e = a.b();
                }
            }
            if (m11060n() != null) {
                a = ModelHelper.a(m11060n(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (PageInformationDataModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9150h = a.b();
                }
            }
            GraphQLVisitableModel graphQLVisitableModel2 = graphQLVisitableModel;
            if (m11063q() != null) {
                LocationModel locationModel = (LocationModel) graphQLModelMutatingVisitor.b(m11063q());
                if (m11063q() != locationModel) {
                    graphQLVisitableModel2 = (PageInformationDataModel) ModelHelper.a(graphQLVisitableModel2, this);
                    graphQLVisitableModel2.f9155m = locationModel;
                }
            }
            if (m11065s() != null) {
                PageFeaturedAdminInfoModel pageFeaturedAdminInfoModel = (PageFeaturedAdminInfoModel) graphQLModelMutatingVisitor.b(m11065s());
                if (m11065s() != pageFeaturedAdminInfoModel) {
                    graphQLVisitableModel2 = (PageInformationDataModel) ModelHelper.a(graphQLVisitableModel2, this);
                    graphQLVisitableModel2.f9157o = pageFeaturedAdminInfoModel;
                }
            }
            if (m11066t() != null) {
                Builder a2 = ModelHelper.a(m11066t(), graphQLModelMutatingVisitor);
                if (a2 != null) {
                    PageInformationDataModel pageInformationDataModel = (PageInformationDataModel) ModelHelper.a(graphQLVisitableModel2, this);
                    pageInformationDataModel.f9158p = a2.b();
                    graphQLVisitableModel2 = pageInformationDataModel;
                }
            }
            i();
            return graphQLVisitableModel2 == null ? this : graphQLVisitableModel2;
        }

        public final int m11050a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m11056j());
            int a2 = ModelHelper.a(flatBufferBuilder, m11057k());
            int c = flatBufferBuilder.c(m11058l());
            int a3 = ModelHelper.a(flatBufferBuilder, m11060n());
            int b = flatBufferBuilder.b(m11061o());
            int a4 = ModelHelper.a(flatBufferBuilder, m11063q());
            int b2 = flatBufferBuilder.b(m11064r());
            int a5 = ModelHelper.a(flatBufferBuilder, m11065s());
            int a6 = ModelHelper.a(flatBufferBuilder, m11066t());
            int d = flatBufferBuilder.d(m11067u());
            int a7 = flatBufferBuilder.a(m11068v());
            int a8 = flatBufferBuilder.a(m11069w());
            int c2 = flatBufferBuilder.c(m11070x());
            int c3 = flatBufferBuilder.c(m11071y());
            flatBufferBuilder.c(18);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, c);
            flatBufferBuilder.a(3, this.f9149g);
            flatBufferBuilder.b(4, a3);
            flatBufferBuilder.b(5, b);
            flatBufferBuilder.a(6, this.f9152j);
            flatBufferBuilder.a(7, this.f9153k);
            flatBufferBuilder.a(8, this.f9154l);
            flatBufferBuilder.b(9, a4);
            flatBufferBuilder.b(10, b2);
            flatBufferBuilder.b(11, a5);
            flatBufferBuilder.b(12, a6);
            flatBufferBuilder.b(13, d);
            flatBufferBuilder.b(14, a7);
            flatBufferBuilder.b(15, a8);
            flatBufferBuilder.b(16, c2);
            flatBufferBuilder.b(17, c3);
            i();
            return flatBufferBuilder.d();
        }

        public final void m11053a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f9149g = mutableFlatBuffer.a(i, 3);
            this.f9152j = mutableFlatBuffer.a(i, 6);
            this.f9153k = mutableFlatBuffer.a(i, 7);
            this.f9154l = mutableFlatBuffer.a(i, 8);
        }
    }
}

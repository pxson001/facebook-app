package com.facebook.privacy.protocol.options;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLPrivacyBaseState;
import com.facebook.graphql.enums.GraphQLPrivacyOptionTagExpansionType;
import com.facebook.graphql.enums.GraphQLPrivacyTagExpansionState;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyAudienceMember;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyIconFields;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyOptionFields;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyOptionFieldsForComposer;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLParsers.PrivacyAudienceMemberParser;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLParsers.PrivacyIconFieldsParser;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLParsers.PrivacyOptionFieldsForComposerParser;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLParsers.PrivacyOptionFieldsParser;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLParsers.PrivacyRowInputFieldsParser;
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

/* compiled from: data_power */
public class PrivacyOptionsGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1255661007)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: data_power */
    public final class PrivacyAudienceMemberModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, PrivacyAudienceMember {
        @Nullable
        private GraphQLObjectType f5218d;
        @Nullable
        private String f5219e;
        @Nullable
        private String f5220f;

        /* compiled from: data_power */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PrivacyAudienceMemberModel.class, new Deserializer());
            }

            public Object m10080a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PrivacyAudienceMemberParser.m10125b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object privacyAudienceMemberModel = new PrivacyAudienceMemberModel();
                ((BaseModel) privacyAudienceMemberModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (privacyAudienceMemberModel instanceof Postprocessable) {
                    return ((Postprocessable) privacyAudienceMemberModel).a();
                }
                return privacyAudienceMemberModel;
            }
        }

        /* compiled from: data_power */
        public class Serializer extends JsonSerializer<PrivacyAudienceMemberModel> {
            public final void m10081a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PrivacyAudienceMemberModel privacyAudienceMemberModel = (PrivacyAudienceMemberModel) obj;
                if (privacyAudienceMemberModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(privacyAudienceMemberModel.m10082a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    privacyAudienceMemberModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PrivacyAudienceMemberParser.m10123a(privacyAudienceMemberModel.w_(), privacyAudienceMemberModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(PrivacyAudienceMemberModel.class, new Serializer());
            }
        }

        public PrivacyAudienceMemberModel() {
            super(3);
        }

        @Nullable
        public final GraphQLObjectType m10085b() {
            if (this.b != null && this.f5218d == null) {
                this.f5218d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f5218d;
        }

        @Nullable
        public final String m10086c() {
            this.f5219e = super.a(this.f5219e, 1);
            return this.f5219e;
        }

        @Nullable
        public final String m10087d() {
            this.f5220f = super.a(this.f5220f, 2);
            return this.f5220f;
        }

        @Nullable
        public final String m10084a() {
            return m10086c();
        }

        public final int jK_() {
            return 1766866758;
        }

        public final GraphQLVisitableModel m10083a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m10082a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m10085b());
            int b = flatBufferBuilder.b(m10086c());
            int b2 = flatBufferBuilder.b(m10087d());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 273304230)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: data_power */
    public final class PrivacyIconFieldsModel extends BaseModel implements GraphQLVisitableModel, PrivacyIconFields {
        @Nullable
        private String f5222d;

        /* compiled from: data_power */
        public final class Builder {
            @Nullable
            public String f5221a;
        }

        /* compiled from: data_power */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PrivacyIconFieldsModel.class, new Deserializer());
            }

            public Object m10088a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PrivacyIconFieldsParser.m10126a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object privacyIconFieldsModel = new PrivacyIconFieldsModel();
                ((BaseModel) privacyIconFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (privacyIconFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) privacyIconFieldsModel).a();
                }
                return privacyIconFieldsModel;
            }
        }

        /* compiled from: data_power */
        public class Serializer extends JsonSerializer<PrivacyIconFieldsModel> {
            public final void m10089a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PrivacyIconFieldsModel privacyIconFieldsModel = (PrivacyIconFieldsModel) obj;
                if (privacyIconFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(privacyIconFieldsModel.m10091a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    privacyIconFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PrivacyIconFieldsParser.m10127a(privacyIconFieldsModel.w_(), privacyIconFieldsModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(PrivacyIconFieldsModel.class, new Serializer());
            }
        }

        public PrivacyIconFieldsModel() {
            super(1);
        }

        public PrivacyIconFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(1);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final String m10093d() {
            this.f5222d = super.a(this.f5222d, 0);
            return this.f5222d;
        }

        public static PrivacyIconFieldsModel m10090a(PrivacyIconFields privacyIconFields) {
            if (privacyIconFields == null) {
                return null;
            }
            if (privacyIconFields instanceof PrivacyIconFieldsModel) {
                return (PrivacyIconFieldsModel) privacyIconFields;
            }
            Builder builder = new Builder();
            builder.f5221a = privacyIconFields.d();
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int b = flatBufferBuilder.b(builder.f5221a);
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new PrivacyIconFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        public final int jK_() {
            return 70760763;
        }

        public final GraphQLVisitableModel m10092a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m10091a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m10093d());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1672550724)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: data_power */
    public final class PrivacyOptionFieldsForComposerModel extends BaseModel implements GraphQLVisitableModel, PrivacyOptionFieldsForComposer {
        @Nullable
        private GraphQLPrivacyOptionTagExpansionType f5223d;
        @Nullable
        private List<PrivacyAudienceMemberModel> f5224e;
        @Nullable
        private String f5225f;
        @Nullable
        private PrivacyIconFieldsModel f5226g;
        @Nullable
        private List<PrivacyAudienceMemberModel> f5227h;
        @Nullable
        private String f5228i;
        @Nullable
        private String f5229j;
        @Nullable
        private PrivacyRowInputFieldsModel f5230k;
        @Nullable
        private List<GraphQLPrivacyOptionTagExpansionType> f5231l;

        /* compiled from: data_power */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PrivacyOptionFieldsForComposerModel.class, new Deserializer());
            }

            public Object m10094a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PrivacyOptionFieldsForComposerParser.m10128a(jsonParser);
                Object privacyOptionFieldsForComposerModel = new PrivacyOptionFieldsForComposerModel();
                ((BaseModel) privacyOptionFieldsForComposerModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (privacyOptionFieldsForComposerModel instanceof Postprocessable) {
                    return ((Postprocessable) privacyOptionFieldsForComposerModel).a();
                }
                return privacyOptionFieldsForComposerModel;
            }
        }

        /* compiled from: data_power */
        public class Serializer extends JsonSerializer<PrivacyOptionFieldsForComposerModel> {
            public final void m10095a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PrivacyOptionFieldsForComposerModel privacyOptionFieldsForComposerModel = (PrivacyOptionFieldsForComposerModel) obj;
                if (privacyOptionFieldsForComposerModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(privacyOptionFieldsForComposerModel.m10098a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    privacyOptionFieldsForComposerModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PrivacyOptionFieldsForComposerParser.m10129a(privacyOptionFieldsForComposerModel.w_(), privacyOptionFieldsForComposerModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PrivacyOptionFieldsForComposerModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ PrivacyIconFields m10100b() {
            return m10096a();
        }

        public PrivacyOptionFieldsForComposerModel() {
            super(9);
        }

        @Nullable
        public final GraphQLPrivacyOptionTagExpansionType E_() {
            this.f5223d = (GraphQLPrivacyOptionTagExpansionType) super.b(this.f5223d, 0, GraphQLPrivacyOptionTagExpansionType.class, GraphQLPrivacyOptionTagExpansionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f5223d;
        }

        @Nonnull
        public final ImmutableList<PrivacyAudienceMemberModel> m10103g() {
            this.f5224e = super.a(this.f5224e, 1, PrivacyAudienceMemberModel.class);
            return (ImmutableList) this.f5224e;
        }

        @Nullable
        public final String m10104j() {
            this.f5225f = super.a(this.f5225f, 2);
            return this.f5225f;
        }

        @Nullable
        private PrivacyIconFieldsModel m10096a() {
            this.f5226g = (PrivacyIconFieldsModel) super.a(this.f5226g, 3, PrivacyIconFieldsModel.class);
            return this.f5226g;
        }

        @Nonnull
        public final ImmutableList<PrivacyAudienceMemberModel> F_() {
            this.f5227h = super.a(this.f5227h, 4, PrivacyAudienceMemberModel.class);
            return (ImmutableList) this.f5227h;
        }

        @Nullable
        public final String m10101c() {
            this.f5228i = super.a(this.f5228i, 5);
            return this.f5228i;
        }

        @Nullable
        public final String m10102d() {
            this.f5229j = super.a(this.f5229j, 6);
            return this.f5229j;
        }

        @Nullable
        private PrivacyRowInputFieldsModel m10097k() {
            this.f5230k = (PrivacyRowInputFieldsModel) super.a(this.f5230k, 7, PrivacyRowInputFieldsModel.class);
            return this.f5230k;
        }

        @Nonnull
        public final ImmutableList<GraphQLPrivacyOptionTagExpansionType> G_() {
            this.f5231l = super.c(this.f5231l, 8, GraphQLPrivacyOptionTagExpansionType.class);
            return (ImmutableList) this.f5231l;
        }

        public final int jK_() {
            return -1984364035;
        }

        public final GraphQLVisitableModel m10099a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            PrivacyOptionFieldsForComposerModel privacyOptionFieldsForComposerModel;
            GraphQLVisitableModel graphQLVisitableModel;
            PrivacyIconFieldsModel privacyIconFieldsModel;
            Builder a;
            PrivacyRowInputFieldsModel privacyRowInputFieldsModel;
            h();
            if (m10103g() != null) {
                Builder a2 = ModelHelper.a(m10103g(), graphQLModelMutatingVisitor);
                if (a2 != null) {
                    privacyOptionFieldsForComposerModel = (PrivacyOptionFieldsForComposerModel) ModelHelper.a(null, this);
                    privacyOptionFieldsForComposerModel.f5224e = a2.b();
                    graphQLVisitableModel = privacyOptionFieldsForComposerModel;
                    if (m10096a() != null) {
                        privacyIconFieldsModel = (PrivacyIconFieldsModel) graphQLModelMutatingVisitor.b(m10096a());
                        if (m10096a() != privacyIconFieldsModel) {
                            graphQLVisitableModel = (PrivacyOptionFieldsForComposerModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f5226g = privacyIconFieldsModel;
                        }
                    }
                    if (F_() != null) {
                        a = ModelHelper.a(F_(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            privacyOptionFieldsForComposerModel = (PrivacyOptionFieldsForComposerModel) ModelHelper.a(graphQLVisitableModel, this);
                            privacyOptionFieldsForComposerModel.f5227h = a.b();
                            graphQLVisitableModel = privacyOptionFieldsForComposerModel;
                        }
                    }
                    if (m10097k() != null) {
                        privacyRowInputFieldsModel = (PrivacyRowInputFieldsModel) graphQLModelMutatingVisitor.b(m10097k());
                        if (m10097k() != privacyRowInputFieldsModel) {
                            graphQLVisitableModel = (PrivacyOptionFieldsForComposerModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f5230k = privacyRowInputFieldsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m10096a() != null) {
                privacyIconFieldsModel = (PrivacyIconFieldsModel) graphQLModelMutatingVisitor.b(m10096a());
                if (m10096a() != privacyIconFieldsModel) {
                    graphQLVisitableModel = (PrivacyOptionFieldsForComposerModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f5226g = privacyIconFieldsModel;
                }
            }
            if (F_() != null) {
                a = ModelHelper.a(F_(), graphQLModelMutatingVisitor);
                if (a != null) {
                    privacyOptionFieldsForComposerModel = (PrivacyOptionFieldsForComposerModel) ModelHelper.a(graphQLVisitableModel, this);
                    privacyOptionFieldsForComposerModel.f5227h = a.b();
                    graphQLVisitableModel = privacyOptionFieldsForComposerModel;
                }
            }
            if (m10097k() != null) {
                privacyRowInputFieldsModel = (PrivacyRowInputFieldsModel) graphQLModelMutatingVisitor.b(m10097k());
                if (m10097k() != privacyRowInputFieldsModel) {
                    graphQLVisitableModel = (PrivacyOptionFieldsForComposerModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f5230k = privacyRowInputFieldsModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m10098a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = flatBufferBuilder.a(E_());
            int a2 = ModelHelper.a(flatBufferBuilder, m10103g());
            int b = flatBufferBuilder.b(m10104j());
            int a3 = ModelHelper.a(flatBufferBuilder, m10096a());
            int a4 = ModelHelper.a(flatBufferBuilder, F_());
            int b2 = flatBufferBuilder.b(m10101c());
            int b3 = flatBufferBuilder.b(m10102d());
            int a5 = ModelHelper.a(flatBufferBuilder, m10097k());
            int d = flatBufferBuilder.d(G_());
            flatBufferBuilder.c(9);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.b(4, a4);
            flatBufferBuilder.b(5, b2);
            flatBufferBuilder.b(6, b3);
            flatBufferBuilder.b(7, a5);
            flatBufferBuilder.b(8, d);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1843544604)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: data_power */
    public final class PrivacyOptionFieldsModel extends BaseModel implements GraphQLVisitableModel, PrivacyOptionFields {
        @Nullable
        private PrivacyIconFieldsModel f5232d;
        @Nullable
        private String f5233e;
        @Nullable
        private String f5234f;
        @Nullable
        private PrivacyRowInputFieldsModel f5235g;

        /* compiled from: data_power */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PrivacyOptionFieldsModel.class, new Deserializer());
            }

            public Object m10105a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PrivacyOptionFieldsParser.m10130a(jsonParser);
                Object privacyOptionFieldsModel = new PrivacyOptionFieldsModel();
                ((BaseModel) privacyOptionFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (privacyOptionFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) privacyOptionFieldsModel).a();
                }
                return privacyOptionFieldsModel;
            }
        }

        /* compiled from: data_power */
        public class Serializer extends JsonSerializer<PrivacyOptionFieldsModel> {
            public final void m10106a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PrivacyOptionFieldsModel privacyOptionFieldsModel = (PrivacyOptionFieldsModel) obj;
                if (privacyOptionFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(privacyOptionFieldsModel.m10109a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    privacyOptionFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = privacyOptionFieldsModel.w_();
                int u_ = privacyOptionFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("icon_image");
                    PrivacyIconFieldsParser.m10127a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("legacy_graph_api_privacy_json");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 2));
                }
                g = mutableFlatBuffer.g(u_, 3);
                if (g != 0) {
                    jsonGenerator.a("privacy_row_input");
                    PrivacyRowInputFieldsParser.m10132a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PrivacyOptionFieldsModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ PrivacyIconFields m10111b() {
            return m10107a();
        }

        public PrivacyOptionFieldsModel() {
            super(4);
        }

        @Nullable
        private PrivacyIconFieldsModel m10107a() {
            this.f5232d = (PrivacyIconFieldsModel) super.a(this.f5232d, 0, PrivacyIconFieldsModel.class);
            return this.f5232d;
        }

        @Nullable
        public final String m10112c() {
            this.f5233e = super.a(this.f5233e, 1);
            return this.f5233e;
        }

        @Nullable
        public final String m10113d() {
            this.f5234f = super.a(this.f5234f, 2);
            return this.f5234f;
        }

        @Nullable
        private PrivacyRowInputFieldsModel m10108j() {
            this.f5235g = (PrivacyRowInputFieldsModel) super.a(this.f5235g, 3, PrivacyRowInputFieldsModel.class);
            return this.f5235g;
        }

        public final int jK_() {
            return -1984364035;
        }

        public final GraphQLVisitableModel m10110a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10107a() != null) {
                PrivacyIconFieldsModel privacyIconFieldsModel = (PrivacyIconFieldsModel) graphQLModelMutatingVisitor.b(m10107a());
                if (m10107a() != privacyIconFieldsModel) {
                    graphQLVisitableModel = (PrivacyOptionFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5232d = privacyIconFieldsModel;
                }
            }
            if (m10108j() != null) {
                PrivacyRowInputFieldsModel privacyRowInputFieldsModel = (PrivacyRowInputFieldsModel) graphQLModelMutatingVisitor.b(m10108j());
                if (m10108j() != privacyRowInputFieldsModel) {
                    graphQLVisitableModel = (PrivacyOptionFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f5235g = privacyRowInputFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10109a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m10107a());
            int b = flatBufferBuilder.b(m10112c());
            int b2 = flatBufferBuilder.b(m10113d());
            int a2 = ModelHelper.a(flatBufferBuilder, m10108j());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 907475311)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: data_power */
    public final class PrivacyRowInputFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<String> f5236d;
        @Nullable
        private GraphQLPrivacyBaseState f5237e;
        @Nullable
        private List<String> f5238f;
        @Nullable
        private GraphQLPrivacyTagExpansionState f5239g;

        /* compiled from: data_power */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PrivacyRowInputFieldsModel.class, new Deserializer());
            }

            public Object m10114a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PrivacyRowInputFieldsParser.m10131a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object privacyRowInputFieldsModel = new PrivacyRowInputFieldsModel();
                ((BaseModel) privacyRowInputFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (privacyRowInputFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) privacyRowInputFieldsModel).a();
                }
                return privacyRowInputFieldsModel;
            }
        }

        /* compiled from: data_power */
        public class Serializer extends JsonSerializer<PrivacyRowInputFieldsModel> {
            public final void m10115a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PrivacyRowInputFieldsModel privacyRowInputFieldsModel = (PrivacyRowInputFieldsModel) obj;
                if (privacyRowInputFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(privacyRowInputFieldsModel.m10120a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    privacyRowInputFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PrivacyRowInputFieldsParser.m10132a(privacyRowInputFieldsModel.w_(), privacyRowInputFieldsModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(PrivacyRowInputFieldsModel.class, new Serializer());
            }
        }

        public PrivacyRowInputFieldsModel() {
            super(4);
        }

        @Nonnull
        private ImmutableList<String> m10116a() {
            this.f5236d = super.a(this.f5236d, 0);
            return (ImmutableList) this.f5236d;
        }

        @Nullable
        private GraphQLPrivacyBaseState m10117j() {
            this.f5237e = (GraphQLPrivacyBaseState) super.b(this.f5237e, 1, GraphQLPrivacyBaseState.class, GraphQLPrivacyBaseState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f5237e;
        }

        @Nonnull
        private ImmutableList<String> m10118k() {
            this.f5238f = super.a(this.f5238f, 2);
            return (ImmutableList) this.f5238f;
        }

        @Nullable
        private GraphQLPrivacyTagExpansionState m10119l() {
            this.f5239g = (GraphQLPrivacyTagExpansionState) super.b(this.f5239g, 3, GraphQLPrivacyTagExpansionState.class, GraphQLPrivacyTagExpansionState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f5239g;
        }

        public final int jK_() {
            return 93912472;
        }

        public final GraphQLVisitableModel m10121a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m10120a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int c = flatBufferBuilder.c(m10116a());
            int a = flatBufferBuilder.a(m10117j());
            int c2 = flatBufferBuilder.c(m10118k());
            int a2 = flatBufferBuilder.a(m10119l());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, c);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, c2);
            flatBufferBuilder.b(3, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}

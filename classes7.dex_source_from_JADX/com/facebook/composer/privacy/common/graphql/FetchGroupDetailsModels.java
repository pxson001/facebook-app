package com.facebook.composer.privacy.common.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.composer.privacy.common.graphql.FetchGroupDetailsParsers.GroupDetailsQueryParser;
import com.facebook.composer.privacy.common.graphql.FetchGroupDetailsParsers.GroupDetailsQueryParser.ParentGroupParser;
import com.facebook.composer.privacy.common.graphql.FetchGroupDetailsParsers.GroupDetailsQueryParser.PostedItemPrivacyScopeParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.ipc.composer.intent.graphql.FetchComposerTargetDataPrivacyScopeInterfaces.ComposerTargetDataPrivacyScopeFields;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyIconFields;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLModels.PrivacyIconFieldsModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: tapped_page_photos */
public class FetchGroupDetailsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 168040119)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: tapped_page_photos */
    public final class GroupDetailsQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private String f2064d;
        @Nullable
        private String f2065e;
        @Nullable
        private ParentGroupModel f2066f;
        @Nullable
        private PostedItemPrivacyScopeModel f2067g;
        @Nullable
        private GraphQLGroupVisibility f2068h;

        /* compiled from: tapped_page_photos */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupDetailsQueryModel.class, new Deserializer());
            }

            public Object m2007a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GroupDetailsQueryParser.m2043a(jsonParser);
                Object groupDetailsQueryModel = new GroupDetailsQueryModel();
                ((BaseModel) groupDetailsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (groupDetailsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) groupDetailsQueryModel).a();
                }
                return groupDetailsQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1185712657)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: tapped_page_photos */
        public final class ParentGroupModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f2059d;
            @Nullable
            private String f2060e;

            /* compiled from: tapped_page_photos */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ParentGroupModel.class, new Deserializer());
                }

                public Object m2008a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ParentGroupParser.m2039a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object parentGroupModel = new ParentGroupModel();
                    ((BaseModel) parentGroupModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (parentGroupModel instanceof Postprocessable) {
                        return ((Postprocessable) parentGroupModel).a();
                    }
                    return parentGroupModel;
                }
            }

            /* compiled from: tapped_page_photos */
            public class Serializer extends JsonSerializer<ParentGroupModel> {
                public final void m2009a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ParentGroupModel parentGroupModel = (ParentGroupModel) obj;
                    if (parentGroupModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(parentGroupModel.m2011a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        parentGroupModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ParentGroupParser.m2040a(parentGroupModel.w_(), parentGroupModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ParentGroupModel.class, new Serializer());
                }
            }

            public ParentGroupModel() {
                super(2);
            }

            public final void m2014a(String str, ConsistencyTuple consistencyTuple) {
                if ("name".equals(str)) {
                    consistencyTuple.a = m2017c();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 1;
                    return;
                }
                consistencyTuple.a();
            }

            public final void m2015a(String str, Object obj, boolean z) {
                if ("name".equals(str)) {
                    m2010a((String) obj);
                }
            }

            @Nullable
            public final String m2016b() {
                this.f2059d = super.a(this.f2059d, 0);
                return this.f2059d;
            }

            @Nullable
            public final String m2017c() {
                this.f2060e = super.a(this.f2060e, 1);
                return this.f2060e;
            }

            private void m2010a(@Nullable String str) {
                this.f2060e = str;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 1, str);
                }
            }

            @Nullable
            public final String m2013a() {
                return m2016b();
            }

            public final int jK_() {
                return 69076575;
            }

            public final GraphQLVisitableModel m2012a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m2011a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m2016b());
                int b2 = flatBufferBuilder.b(m2017c());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 6675520)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: tapped_page_photos */
        public final class PostedItemPrivacyScopeModel extends BaseModel implements GraphQLVisitableModel, ComposerTargetDataPrivacyScopeFields {
            @Nullable
            private String f2061d;
            @Nullable
            private PrivacyIconFieldsModel f2062e;
            @Nullable
            private String f2063f;

            /* compiled from: tapped_page_photos */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PostedItemPrivacyScopeModel.class, new Deserializer());
                }

                public Object m2018a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PostedItemPrivacyScopeParser.m2041a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object postedItemPrivacyScopeModel = new PostedItemPrivacyScopeModel();
                    ((BaseModel) postedItemPrivacyScopeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (postedItemPrivacyScopeModel instanceof Postprocessable) {
                        return ((Postprocessable) postedItemPrivacyScopeModel).a();
                    }
                    return postedItemPrivacyScopeModel;
                }
            }

            /* compiled from: tapped_page_photos */
            public class Serializer extends JsonSerializer<PostedItemPrivacyScopeModel> {
                public final void m2019a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PostedItemPrivacyScopeModel postedItemPrivacyScopeModel = (PostedItemPrivacyScopeModel) obj;
                    if (postedItemPrivacyScopeModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(postedItemPrivacyScopeModel.m2022a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        postedItemPrivacyScopeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PostedItemPrivacyScopeParser.m2042a(postedItemPrivacyScopeModel.w_(), postedItemPrivacyScopeModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PostedItemPrivacyScopeModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ PrivacyIconFields m2024a() {
                return m2021k();
            }

            public PostedItemPrivacyScopeModel() {
                super(3);
            }

            @Nullable
            private String m2020j() {
                this.f2061d = super.a(this.f2061d, 0);
                return this.f2061d;
            }

            @Nullable
            private PrivacyIconFieldsModel m2021k() {
                this.f2062e = (PrivacyIconFieldsModel) super.a(this.f2062e, 1, PrivacyIconFieldsModel.class);
                return this.f2062e;
            }

            @Nullable
            public final String m2025b() {
                this.f2063f = super.a(this.f2063f, 2);
                return this.f2063f;
            }

            public final int jK_() {
                return -476351540;
            }

            public final GraphQLVisitableModel m2023a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m2021k() != null) {
                    PrivacyIconFieldsModel privacyIconFieldsModel = (PrivacyIconFieldsModel) graphQLModelMutatingVisitor.b(m2021k());
                    if (m2021k() != privacyIconFieldsModel) {
                        graphQLVisitableModel = (PostedItemPrivacyScopeModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f2062e = privacyIconFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m2022a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m2020j());
                int a = ModelHelper.a(flatBufferBuilder, m2021k());
                int b2 = flatBufferBuilder.b(m2025b());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.b(2, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: tapped_page_photos */
        public class Serializer extends JsonSerializer<GroupDetailsQueryModel> {
            public final void m2026a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GroupDetailsQueryModel groupDetailsQueryModel = (GroupDetailsQueryModel) obj;
                if (groupDetailsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupDetailsQueryModel.m2032a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupDetailsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = groupDetailsQueryModel.w_();
                int u_ = groupDetailsQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("full_name");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                int g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("parent_group");
                    ParentGroupParser.m2040a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 3);
                if (g != 0) {
                    jsonGenerator.a("posted_item_privacy_scope");
                    PostedItemPrivacyScopeParser.m2042a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 4) != 0) {
                    jsonGenerator.a("visibility");
                    jsonGenerator.b(mutableFlatBuffer.b(u_, 4));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GroupDetailsQueryModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ ParentGroupModel m2037b() {
            return m2030l();
        }

        public GroupDetailsQueryModel() {
            super(5);
        }

        public final void m2035a(String str, ConsistencyTuple consistencyTuple) {
            if ("visibility".equals(str)) {
                consistencyTuple.a = m2038c();
                consistencyTuple.b = u_();
                consistencyTuple.c = 4;
                return;
            }
            consistencyTuple.a();
        }

        public final void m2036a(String str, Object obj, boolean z) {
            if ("visibility".equals(str)) {
                m2027a((GraphQLGroupVisibility) obj);
            }
        }

        @Nullable
        private String m2028j() {
            this.f2064d = super.a(this.f2064d, 0);
            return this.f2064d;
        }

        @Nullable
        private String m2029k() {
            this.f2065e = super.a(this.f2065e, 1);
            return this.f2065e;
        }

        @Nullable
        private ParentGroupModel m2030l() {
            this.f2066f = (ParentGroupModel) super.a(this.f2066f, 2, ParentGroupModel.class);
            return this.f2066f;
        }

        @Nullable
        private PostedItemPrivacyScopeModel m2031m() {
            this.f2067g = (PostedItemPrivacyScopeModel) super.a(this.f2067g, 3, PostedItemPrivacyScopeModel.class);
            return this.f2067g;
        }

        @Nullable
        public final GraphQLGroupVisibility m2038c() {
            this.f2068h = (GraphQLGroupVisibility) super.b(this.f2068h, 4, GraphQLGroupVisibility.class, GraphQLGroupVisibility.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f2068h;
        }

        private void m2027a(GraphQLGroupVisibility graphQLGroupVisibility) {
            this.f2068h = graphQLGroupVisibility;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 4, graphQLGroupVisibility != null ? graphQLGroupVisibility.name() : null);
            }
        }

        @Nullable
        public final String m2034a() {
            return m2029k();
        }

        public final int jK_() {
            return 69076575;
        }

        public final GraphQLVisitableModel m2033a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2030l() != null) {
                ParentGroupModel parentGroupModel = (ParentGroupModel) graphQLModelMutatingVisitor.b(m2030l());
                if (m2030l() != parentGroupModel) {
                    graphQLVisitableModel = (GroupDetailsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f2066f = parentGroupModel;
                }
            }
            if (m2031m() != null) {
                PostedItemPrivacyScopeModel postedItemPrivacyScopeModel = (PostedItemPrivacyScopeModel) graphQLModelMutatingVisitor.b(m2031m());
                if (m2031m() != postedItemPrivacyScopeModel) {
                    graphQLVisitableModel = (GroupDetailsQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f2067g = postedItemPrivacyScopeModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2032a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m2028j());
            int b2 = flatBufferBuilder.b(m2029k());
            int a = ModelHelper.a(flatBufferBuilder, m2030l());
            int a2 = ModelHelper.a(flatBufferBuilder, m2031m());
            int a3 = flatBufferBuilder.a(m2038c());
            flatBufferBuilder.c(5);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, a);
            flatBufferBuilder.b(3, a2);
            flatBufferBuilder.b(4, a3);
            i();
            return flatBufferBuilder.d();
        }
    }
}

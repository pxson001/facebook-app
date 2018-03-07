package com.facebook.timeline.intent;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultImageFieldsParser;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.timeline.intent.ModelBundleGraphQLInterfaces.ModelBundleProfileGraphQL;
import com.facebook.timeline.intent.ModelBundleGraphQLParsers.ModelBundleExtendedGraphQLParser;
import com.facebook.timeline.intent.ModelBundleGraphQLParsers.ModelBundleProfileGraphQLParser;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.TimelineHeaderFocusedCoverPhotoFieldsModel;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLParsers.TimelineHeaderFocusedCoverPhotoFieldsParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: deltaGenieMessage */
public class ModelBundleGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 2134068595)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: deltaGenieMessage */
    public final class ModelBundleExtendedGraphQLModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, ModelBundleProfileGraphQL {
        @Nullable
        private GraphQLObjectType f17617d;
        @Nullable
        private TimelineHeaderFocusedCoverPhotoFieldsModel f17618e;
        @Nullable
        private GraphQLFriendshipStatus f17619f;
        @Nullable
        private String f17620g;
        @Nullable
        private String f17621h;
        @Nullable
        private DefaultImageFieldsModel f17622i;

        /* compiled from: deltaGenieMessage */
        public final class Builder {
            @Nullable
            public GraphQLObjectType f17611a;
            @Nullable
            public TimelineHeaderFocusedCoverPhotoFieldsModel f17612b;
            @Nullable
            public GraphQLFriendshipStatus f17613c;
            @Nullable
            public String f17614d;
            @Nullable
            public String f17615e;
            @Nullable
            public DefaultImageFieldsModel f17616f;

            public final ModelBundleExtendedGraphQLModel m25602a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f17611a);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f17612b);
                int a3 = flatBufferBuilder.a(this.f17613c);
                int b = flatBufferBuilder.b(this.f17614d);
                int b2 = flatBufferBuilder.b(this.f17615e);
                int a4 = ModelHelper.a(flatBufferBuilder, this.f17616f);
                flatBufferBuilder.c(6);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                flatBufferBuilder.b(3, b);
                flatBufferBuilder.b(4, b2);
                flatBufferBuilder.b(5, a4);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new ModelBundleExtendedGraphQLModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: deltaGenieMessage */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ModelBundleExtendedGraphQLModel.class, new Deserializer());
            }

            public Object m25603a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ModelBundleExtendedGraphQLParser.m25630a(jsonParser);
                Object modelBundleExtendedGraphQLModel = new ModelBundleExtendedGraphQLModel();
                ((BaseModel) modelBundleExtendedGraphQLModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (modelBundleExtendedGraphQLModel instanceof Postprocessable) {
                    return ((Postprocessable) modelBundleExtendedGraphQLModel).a();
                }
                return modelBundleExtendedGraphQLModel;
            }
        }

        /* compiled from: deltaGenieMessage */
        public class Serializer extends JsonSerializer<ModelBundleExtendedGraphQLModel> {
            public final void m25604a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ModelBundleExtendedGraphQLModel modelBundleExtendedGraphQLModel = (ModelBundleExtendedGraphQLModel) obj;
                if (modelBundleExtendedGraphQLModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(modelBundleExtendedGraphQLModel.m25608a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    modelBundleExtendedGraphQLModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = modelBundleExtendedGraphQLModel.w_();
                int u_ = modelBundleExtendedGraphQLModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("cover_photo");
                    TimelineHeaderFocusedCoverPhotoFieldsParser.m26089a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("friendship_status");
                    jsonGenerator.b(mutableFlatBuffer.b(u_, 2));
                }
                if (mutableFlatBuffer.g(u_, 3) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 3));
                }
                if (mutableFlatBuffer.g(u_, 4) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 4));
                }
                g = mutableFlatBuffer.g(u_, 5);
                if (g != 0) {
                    jsonGenerator.a("profile_picture");
                    DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ModelBundleExtendedGraphQLModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ TimelineHeaderFocusedCoverPhotoFieldsModel m25613b() {
            return m25606j();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields dB_() {
            return m25607k();
        }

        public ModelBundleExtendedGraphQLModel() {
            super(6);
        }

        public ModelBundleExtendedGraphQLModel(MutableFlatBuffer mutableFlatBuffer) {
            super(6);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final void m25611a(String str, ConsistencyTuple consistencyTuple) {
            if ("friendship_status".equals(str)) {
                consistencyTuple.a = m25615d();
                consistencyTuple.b = u_();
                consistencyTuple.c = 2;
                return;
            }
            consistencyTuple.a();
        }

        public final void m25612a(String str, Object obj, boolean z) {
            if ("friendship_status".equals(str)) {
                m25605a((GraphQLFriendshipStatus) obj);
            }
        }

        @Nullable
        public final GraphQLObjectType m25614c() {
            if (this.b != null && this.f17617d == null) {
                this.f17617d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f17617d;
        }

        @Nullable
        private TimelineHeaderFocusedCoverPhotoFieldsModel m25606j() {
            this.f17618e = (TimelineHeaderFocusedCoverPhotoFieldsModel) super.a(this.f17618e, 1, TimelineHeaderFocusedCoverPhotoFieldsModel.class);
            return this.f17618e;
        }

        @Nullable
        public final GraphQLFriendshipStatus m25615d() {
            this.f17619f = (GraphQLFriendshipStatus) super.b(this.f17619f, 2, GraphQLFriendshipStatus.class, GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f17619f;
        }

        private void m25605a(GraphQLFriendshipStatus graphQLFriendshipStatus) {
            this.f17619f = graphQLFriendshipStatus;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 2, graphQLFriendshipStatus != null ? graphQLFriendshipStatus.name() : null);
            }
        }

        @Nullable
        public final String m25616g() {
            this.f17620g = super.a(this.f17620g, 3);
            return this.f17620g;
        }

        @Nullable
        public final String C_() {
            this.f17621h = super.a(this.f17621h, 4);
            return this.f17621h;
        }

        @Nullable
        private DefaultImageFieldsModel m25607k() {
            this.f17622i = (DefaultImageFieldsModel) super.a(this.f17622i, 5, DefaultImageFieldsModel.class);
            return this.f17622i;
        }

        @Nullable
        public final String m25610a() {
            return m25616g();
        }

        public final int jK_() {
            return 1355227529;
        }

        public final GraphQLVisitableModel m25609a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m25606j() != null) {
                TimelineHeaderFocusedCoverPhotoFieldsModel timelineHeaderFocusedCoverPhotoFieldsModel = (TimelineHeaderFocusedCoverPhotoFieldsModel) graphQLModelMutatingVisitor.b(m25606j());
                if (m25606j() != timelineHeaderFocusedCoverPhotoFieldsModel) {
                    graphQLVisitableModel = (ModelBundleExtendedGraphQLModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17618e = timelineHeaderFocusedCoverPhotoFieldsModel;
                }
            }
            if (m25607k() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m25607k());
                if (m25607k() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (ModelBundleExtendedGraphQLModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17622i = defaultImageFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m25608a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m25614c());
            int a2 = ModelHelper.a(flatBufferBuilder, m25606j());
            int a3 = flatBufferBuilder.a(m25615d());
            int b = flatBufferBuilder.b(m25616g());
            int b2 = flatBufferBuilder.b(C_());
            int a4 = ModelHelper.a(flatBufferBuilder, m25607k());
            flatBufferBuilder.c(6);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, b);
            flatBufferBuilder.b(4, b2);
            flatBufferBuilder.b(5, a4);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1193117627)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: deltaGenieMessage */
    public final class ModelBundleProfileGraphQLModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, ModelBundleProfileGraphQL {
        @Nullable
        private GraphQLObjectType f17628d;
        @Nullable
        private GraphQLFriendshipStatus f17629e;
        @Nullable
        private String f17630f;
        @Nullable
        private String f17631g;
        @Nullable
        private DefaultImageFieldsModel f17632h;

        /* compiled from: deltaGenieMessage */
        public final class Builder {
            @Nullable
            public GraphQLObjectType f17623a;
            @Nullable
            public GraphQLFriendshipStatus f17624b;
            @Nullable
            public String f17625c;
            @Nullable
            public String f17626d;
            @Nullable
            public DefaultImageFieldsModel f17627e;

            public final ModelBundleProfileGraphQLModel m25617a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f17623a);
                int a2 = flatBufferBuilder.a(this.f17624b);
                int b = flatBufferBuilder.b(this.f17625c);
                int b2 = flatBufferBuilder.b(this.f17626d);
                int a3 = ModelHelper.a(flatBufferBuilder, this.f17627e);
                flatBufferBuilder.c(5);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, b);
                flatBufferBuilder.b(3, b2);
                flatBufferBuilder.b(4, a3);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new ModelBundleProfileGraphQLModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: deltaGenieMessage */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ModelBundleProfileGraphQLModel.class, new Deserializer());
            }

            public Object m25618a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ModelBundleProfileGraphQLParser.m25631a(jsonParser);
                Object modelBundleProfileGraphQLModel = new ModelBundleProfileGraphQLModel();
                ((BaseModel) modelBundleProfileGraphQLModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (modelBundleProfileGraphQLModel instanceof Postprocessable) {
                    return ((Postprocessable) modelBundleProfileGraphQLModel).a();
                }
                return modelBundleProfileGraphQLModel;
            }
        }

        /* compiled from: deltaGenieMessage */
        public class Serializer extends JsonSerializer<ModelBundleProfileGraphQLModel> {
            public final void m25619a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ModelBundleProfileGraphQLModel modelBundleProfileGraphQLModel = (ModelBundleProfileGraphQLModel) obj;
                if (modelBundleProfileGraphQLModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(modelBundleProfileGraphQLModel.m25622a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    modelBundleProfileGraphQLModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = modelBundleProfileGraphQLModel.w_();
                int u_ = modelBundleProfileGraphQLModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("friendship_status");
                    jsonGenerator.b(mutableFlatBuffer.b(u_, 1));
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 2));
                }
                if (mutableFlatBuffer.g(u_, 3) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 3));
                }
                int g = mutableFlatBuffer.g(u_, 4);
                if (g != 0) {
                    jsonGenerator.a("profile_picture");
                    DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ModelBundleProfileGraphQLModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields dB_() {
            return m25621j();
        }

        public ModelBundleProfileGraphQLModel() {
            super(5);
        }

        public ModelBundleProfileGraphQLModel(MutableFlatBuffer mutableFlatBuffer) {
            super(5);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final void m25625a(String str, ConsistencyTuple consistencyTuple) {
            if ("friendship_status".equals(str)) {
                consistencyTuple.a = m25628d();
                consistencyTuple.b = u_();
                consistencyTuple.c = 1;
                return;
            }
            consistencyTuple.a();
        }

        public final void m25626a(String str, Object obj, boolean z) {
            if ("friendship_status".equals(str)) {
                m25620a((GraphQLFriendshipStatus) obj);
            }
        }

        @Nullable
        public final GraphQLObjectType m25627c() {
            if (this.b != null && this.f17628d == null) {
                this.f17628d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f17628d;
        }

        @Nullable
        public final GraphQLFriendshipStatus m25628d() {
            this.f17629e = (GraphQLFriendshipStatus) super.b(this.f17629e, 1, GraphQLFriendshipStatus.class, GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f17629e;
        }

        private void m25620a(GraphQLFriendshipStatus graphQLFriendshipStatus) {
            this.f17629e = graphQLFriendshipStatus;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 1, graphQLFriendshipStatus != null ? graphQLFriendshipStatus.name() : null);
            }
        }

        @Nullable
        public final String m25629g() {
            this.f17630f = super.a(this.f17630f, 2);
            return this.f17630f;
        }

        @Nullable
        public final String C_() {
            this.f17631g = super.a(this.f17631g, 3);
            return this.f17631g;
        }

        @Nullable
        private DefaultImageFieldsModel m25621j() {
            this.f17632h = (DefaultImageFieldsModel) super.a(this.f17632h, 4, DefaultImageFieldsModel.class);
            return this.f17632h;
        }

        @Nullable
        public final String m25624a() {
            return m25629g();
        }

        public final int jK_() {
            return 1355227529;
        }

        public final GraphQLVisitableModel m25623a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m25621j() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m25621j());
                if (m25621j() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (ModelBundleProfileGraphQLModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17632h = defaultImageFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m25622a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m25627c());
            int a2 = flatBufferBuilder.a(m25628d());
            int b = flatBufferBuilder.b(m25629g());
            int b2 = flatBufferBuilder.b(C_());
            int a3 = ModelHelper.a(flatBufferBuilder, m25621j());
            flatBufferBuilder.c(5);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, b2);
            flatBufferBuilder.b(4, a3);
            i();
            return flatBufferBuilder.d();
        }
    }
}

package com.facebook.pages.data.graphql.cards;

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
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.pages.data.graphql.cards.PostsByOthersCardGraphQLParsers.PostsByOthersCardQueryParser;
import com.facebook.pages.data.graphql.cards.PostsByOthersCardGraphQLParsers.PostsByOthersCardQueryParser.AdminDisplayPreferenceParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: contactPoints */
public class PostsByOthersCardGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 319143453)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: contactPoints */
    public final class PostsByOthersCardQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private AdminDisplayPreferenceModel f17042d;
        private boolean f17043e;
        private boolean f17044f;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1905074626)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: contactPoints */
        public final class AdminDisplayPreferenceModel extends BaseModel implements GraphQLVisitableModel {
            private boolean f17041d;

            /* compiled from: contactPoints */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AdminDisplayPreferenceModel.class, new Deserializer());
                }

                public Object m20689a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AdminDisplayPreferenceParser.m20705a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object adminDisplayPreferenceModel = new AdminDisplayPreferenceModel();
                    ((BaseModel) adminDisplayPreferenceModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (adminDisplayPreferenceModel instanceof Postprocessable) {
                        return ((Postprocessable) adminDisplayPreferenceModel).a();
                    }
                    return adminDisplayPreferenceModel;
                }
            }

            /* compiled from: contactPoints */
            public class Serializer extends JsonSerializer<AdminDisplayPreferenceModel> {
                public final void m20690a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AdminDisplayPreferenceModel adminDisplayPreferenceModel = (AdminDisplayPreferenceModel) obj;
                    if (adminDisplayPreferenceModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(adminDisplayPreferenceModel.m20691a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        adminDisplayPreferenceModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AdminDisplayPreferenceParser.m20706a(adminDisplayPreferenceModel.w_(), adminDisplayPreferenceModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AdminDisplayPreferenceModel.class, new Serializer());
                }
            }

            public AdminDisplayPreferenceModel() {
                super(1);
            }

            public final boolean m20694a() {
                a(0, 0);
                return this.f17041d;
            }

            public final int jK_() {
                return 60838205;
            }

            public final GraphQLVisitableModel m20692a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m20691a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f17041d);
                i();
                return flatBufferBuilder.d();
            }

            public final void m20693a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f17041d = mutableFlatBuffer.a(i, 0);
            }
        }

        /* compiled from: contactPoints */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PostsByOthersCardQueryModel.class, new Deserializer());
            }

            public Object m20695a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PostsByOthersCardQueryParser.m20707a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object postsByOthersCardQueryModel = new PostsByOthersCardQueryModel();
                ((BaseModel) postsByOthersCardQueryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (postsByOthersCardQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) postsByOthersCardQueryModel).a();
                }
                return postsByOthersCardQueryModel;
            }
        }

        /* compiled from: contactPoints */
        public class Serializer extends JsonSerializer<PostsByOthersCardQueryModel> {
            public final void m20696a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PostsByOthersCardQueryModel postsByOthersCardQueryModel = (PostsByOthersCardQueryModel) obj;
                if (postsByOthersCardQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(postsByOthersCardQueryModel.m20697a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    postsByOthersCardQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = postsByOthersCardQueryModel.w_();
                int u_ = postsByOthersCardQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("admin_display_preference");
                    AdminDisplayPreferenceParser.m20706a(mutableFlatBuffer, g, jsonGenerator);
                }
                boolean a = mutableFlatBuffer.a(u_, 1);
                if (a) {
                    jsonGenerator.a("can_viewer_post");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(u_, 2);
                if (a) {
                    jsonGenerator.a("can_viewer_post_photo_to_timeline");
                    jsonGenerator.a(a);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PostsByOthersCardQueryModel.class, new Serializer());
            }
        }

        public PostsByOthersCardQueryModel() {
            super(3);
        }

        public final void m20701a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m20702a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final AdminDisplayPreferenceModel m20699a() {
            this.f17042d = (AdminDisplayPreferenceModel) super.a(this.f17042d, 0, AdminDisplayPreferenceModel.class);
            return this.f17042d;
        }

        public final boolean m20703j() {
            a(0, 1);
            return this.f17043e;
        }

        public final boolean m20704k() {
            a(0, 2);
            return this.f17044f;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m20698a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m20699a() != null) {
                AdminDisplayPreferenceModel adminDisplayPreferenceModel = (AdminDisplayPreferenceModel) graphQLModelMutatingVisitor.b(m20699a());
                if (m20699a() != adminDisplayPreferenceModel) {
                    graphQLVisitableModel = (PostsByOthersCardQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17042d = adminDisplayPreferenceModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m20697a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m20699a());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.a(1, this.f17043e);
            flatBufferBuilder.a(2, this.f17044f);
            i();
            return flatBufferBuilder.d();
        }

        public final void m20700a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f17043e = mutableFlatBuffer.a(i, 1);
            this.f17044f = mutableFlatBuffer.a(i, 2);
        }
    }
}

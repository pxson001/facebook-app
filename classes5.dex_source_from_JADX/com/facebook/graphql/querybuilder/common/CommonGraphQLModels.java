package com.facebook.graphql.querybuilder.common;

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
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultFeedbackFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultFeedbackFields.Likers;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultFeedbackFields.TopLevelComments;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageUriFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultLocationFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultAddressFieldsParser;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultBigProfilePictureFieldsParser;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultFeedbackFieldsParser;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultFeedbackFieldsParser.LikersParser;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultFeedbackFieldsParser.TopLevelCommentsParser;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultImageFieldsParser;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultImageUriFieldsParser;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultLocationFieldsParser;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultSmallProfilePictureFieldsParser;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultTimeRangeFieldsParser;
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
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: editCommentParams */
public class CommonGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1000273915)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: editCommentParams */
    public final class DefaultAddressFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f4840d;
        @Nullable
        private String f4841e;
        @Nullable
        private String f4842f;

        /* compiled from: editCommentParams */
        public final class Builder {
            @Nullable
            public String f4837a;
            @Nullable
            public String f4838b;
            @Nullable
            public String f4839c;
        }

        /* compiled from: editCommentParams */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(DefaultAddressFieldsModel.class, new Deserializer());
            }

            public Object m9660a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(DefaultAddressFieldsParser.m9749a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object defaultAddressFieldsModel = new DefaultAddressFieldsModel();
                ((BaseModel) defaultAddressFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (defaultAddressFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) defaultAddressFieldsModel).a();
                }
                return defaultAddressFieldsModel;
            }
        }

        /* compiled from: editCommentParams */
        public class Serializer extends JsonSerializer<DefaultAddressFieldsModel> {
            public final void m9661a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                DefaultAddressFieldsModel defaultAddressFieldsModel = (DefaultAddressFieldsModel) obj;
                if (defaultAddressFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(defaultAddressFieldsModel.m9663a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    defaultAddressFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                DefaultAddressFieldsParser.m9750a(defaultAddressFieldsModel.w_(), defaultAddressFieldsModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(DefaultAddressFieldsModel.class, new Serializer());
            }
        }

        public DefaultAddressFieldsModel() {
            super(3);
        }

        public DefaultAddressFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(3);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final String m9665a() {
            this.f4840d = super.a(this.f4840d, 0);
            return this.f4840d;
        }

        @Nullable
        public final String m9666b() {
            this.f4841e = super.a(this.f4841e, 1);
            return this.f4841e;
        }

        @Nullable
        public final String m9667c() {
            this.f4842f = super.a(this.f4842f, 2);
            return this.f4842f;
        }

        public static DefaultAddressFieldsModel m9662a(DefaultAddressFieldsModel defaultAddressFieldsModel) {
            if (defaultAddressFieldsModel == null) {
                return null;
            }
            if (defaultAddressFieldsModel instanceof DefaultAddressFieldsModel) {
                return defaultAddressFieldsModel;
            }
            Builder builder = new Builder();
            builder.f4837a = defaultAddressFieldsModel.m9665a();
            builder.f4838b = defaultAddressFieldsModel.m9666b();
            builder.f4839c = defaultAddressFieldsModel.m9667c();
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int b = flatBufferBuilder.b(builder.f4837a);
            int b2 = flatBufferBuilder.b(builder.f4838b);
            int b3 = flatBufferBuilder.b(builder.f4839c);
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, b3);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new DefaultAddressFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        public final int jK_() {
            return 799251025;
        }

        public final GraphQLVisitableModel m9664a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m9663a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m9665a());
            int b2 = flatBufferBuilder.b(m9666b());
            int b3 = flatBufferBuilder.b(m9667c());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, b3);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1097398158)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: editCommentParams */
    public final class DefaultBigProfilePictureFieldsModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private DefaultImageFieldsModel f4843d;

        /* compiled from: editCommentParams */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(DefaultBigProfilePictureFieldsModel.class, new Deserializer());
            }

            public Object m9668a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = DefaultBigProfilePictureFieldsParser.m9751a(jsonParser);
                Object defaultBigProfilePictureFieldsModel = new DefaultBigProfilePictureFieldsModel();
                ((BaseModel) defaultBigProfilePictureFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (defaultBigProfilePictureFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) defaultBigProfilePictureFieldsModel).a();
                }
                return defaultBigProfilePictureFieldsModel;
            }
        }

        /* compiled from: editCommentParams */
        public class Serializer extends JsonSerializer<DefaultBigProfilePictureFieldsModel> {
            public final void m9669a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                DefaultBigProfilePictureFieldsModel defaultBigProfilePictureFieldsModel = (DefaultBigProfilePictureFieldsModel) obj;
                if (defaultBigProfilePictureFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(defaultBigProfilePictureFieldsModel.m9670a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    defaultBigProfilePictureFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = defaultBigProfilePictureFieldsModel.w_();
                int u_ = defaultBigProfilePictureFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("profile_picture");
                    DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(DefaultBigProfilePictureFieldsModel.class, new Serializer());
            }
        }

        public DefaultBigProfilePictureFieldsModel() {
            super(1);
        }

        public final void m9673a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m9674a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final DefaultImageFieldsModel m9671a() {
            this.f4843d = (DefaultImageFieldsModel) super.a(this.f4843d, 0, DefaultImageFieldsModel.class);
            return this.f4843d;
        }

        public final int jK_() {
            return 2645995;
        }

        public final GraphQLVisitableModel m9672a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m9671a() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m9671a());
                if (m9671a() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (DefaultBigProfilePictureFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f4843d = defaultImageFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m9670a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m9671a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1063993457)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: editCommentParams */
    public final class DefaultFeedbackFieldsModel extends BaseModel implements DefaultFeedbackFields, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        private boolean f4860d;
        private boolean f4861e;
        private boolean f4862f;
        private boolean f4863g;
        private boolean f4864h;
        private boolean f4865i;
        @Nullable
        private String f4866j;
        @Nullable
        private String f4867k;
        @Nullable
        private LikersModel f4868l;
        @Nullable
        private TopLevelCommentsModel f4869m;

        /* compiled from: editCommentParams */
        public final class Builder {
            public boolean f4844a;
            public boolean f4845b;
            public boolean f4846c;
            public boolean f4847d;
            public boolean f4848e;
            public boolean f4849f;
            @Nullable
            public String f4850g;
            @Nullable
            public String f4851h;
            @Nullable
            public LikersModel f4852i;
            @Nullable
            public TopLevelCommentsModel f4853j;

            public final DefaultFeedbackFieldsModel m9675a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(this.f4850g);
                int b2 = flatBufferBuilder.b(this.f4851h);
                int a = ModelHelper.a(flatBufferBuilder, this.f4852i);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f4853j);
                flatBufferBuilder.c(10);
                flatBufferBuilder.a(0, this.f4844a);
                flatBufferBuilder.a(1, this.f4845b);
                flatBufferBuilder.a(2, this.f4846c);
                flatBufferBuilder.a(3, this.f4847d);
                flatBufferBuilder.a(4, this.f4848e);
                flatBufferBuilder.a(5, this.f4849f);
                flatBufferBuilder.b(6, b);
                flatBufferBuilder.b(7, b2);
                flatBufferBuilder.b(8, a);
                flatBufferBuilder.b(9, a2);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new DefaultFeedbackFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: editCommentParams */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(DefaultFeedbackFieldsModel.class, new Deserializer());
            }

            public Object m9676a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(DefaultFeedbackFieldsParser.m9756a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object defaultFeedbackFieldsModel = new DefaultFeedbackFieldsModel();
                ((BaseModel) defaultFeedbackFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (defaultFeedbackFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) defaultFeedbackFieldsModel).a();
                }
                return defaultFeedbackFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: editCommentParams */
        public final class LikersModel extends BaseModel implements Likers, GraphQLVisitableModel {
            private int f4855d;

            /* compiled from: editCommentParams */
            public final class Builder {
                public int f4854a;

                public final LikersModel m9677a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, this.f4854a, 0);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new LikersModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: editCommentParams */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(LikersModel.class, new Deserializer());
                }

                public Object m9678a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(LikersParser.m9752a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object likersModel = new LikersModel();
                    ((BaseModel) likersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (likersModel instanceof Postprocessable) {
                        return ((Postprocessable) likersModel).a();
                    }
                    return likersModel;
                }
            }

            /* compiled from: editCommentParams */
            public class Serializer extends JsonSerializer<LikersModel> {
                public final void m9679a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    LikersModel likersModel = (LikersModel) obj;
                    if (likersModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(likersModel.m9682a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        likersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    LikersParser.m9753a(likersModel.w_(), likersModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(LikersModel.class, new Serializer());
                }
            }

            public LikersModel() {
                super(1);
            }

            public LikersModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final int m9681a() {
                a(0, 0);
                return this.f4855d;
            }

            public final void m9684a(int i) {
                this.f4855d = i;
                if (this.b != null && this.b.d) {
                    this.b.b(this.c, 0, i);
                }
            }

            public static LikersModel m9680a(Likers likers) {
                if (likers == null) {
                    return null;
                }
                if (likers instanceof LikersModel) {
                    return (LikersModel) likers;
                }
                Builder builder = new Builder();
                builder.f4854a = likers.a();
                return builder.m9677a();
            }

            public final int jK_() {
                return 733369288;
            }

            public final GraphQLVisitableModel m9683a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m9682a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f4855d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m9685a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f4855d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: editCommentParams */
        public class Serializer extends JsonSerializer<DefaultFeedbackFieldsModel> {
            public final void m9686a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                DefaultFeedbackFieldsModel defaultFeedbackFieldsModel = (DefaultFeedbackFieldsModel) obj;
                if (defaultFeedbackFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(defaultFeedbackFieldsModel.m9701a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    defaultFeedbackFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                DefaultFeedbackFieldsParser.m9757a(defaultFeedbackFieldsModel.w_(), defaultFeedbackFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(DefaultFeedbackFieldsModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -2056444745)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: editCommentParams */
        public final class TopLevelCommentsModel extends BaseModel implements TopLevelComments, GraphQLVisitableModel {
            private int f4858d;
            private int f4859e;

            /* compiled from: editCommentParams */
            public final class Builder {
                public int f4856a;
                public int f4857b;
            }

            /* compiled from: editCommentParams */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TopLevelCommentsModel.class, new Deserializer());
                }

                public Object m9687a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TopLevelCommentsParser.m9754a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object topLevelCommentsModel = new TopLevelCommentsModel();
                    ((BaseModel) topLevelCommentsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (topLevelCommentsModel instanceof Postprocessable) {
                        return ((Postprocessable) topLevelCommentsModel).a();
                    }
                    return topLevelCommentsModel;
                }
            }

            /* compiled from: editCommentParams */
            public class Serializer extends JsonSerializer<TopLevelCommentsModel> {
                public final void m9688a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TopLevelCommentsModel topLevelCommentsModel = (TopLevelCommentsModel) obj;
                    if (topLevelCommentsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(topLevelCommentsModel.m9691a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        topLevelCommentsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TopLevelCommentsParser.m9755a(topLevelCommentsModel.w_(), topLevelCommentsModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(TopLevelCommentsModel.class, new Serializer());
                }
            }

            public TopLevelCommentsModel() {
                super(2);
            }

            public TopLevelCommentsModel(MutableFlatBuffer mutableFlatBuffer) {
                super(2);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final int m9690a() {
                a(0, 0);
                return this.f4858d;
            }

            public final void m9693a(int i) {
                this.f4858d = i;
                if (this.b != null && this.b.d) {
                    this.b.b(this.c, 0, i);
                }
            }

            public final int m9695b() {
                a(0, 1);
                return this.f4859e;
            }

            public final void m9696b(int i) {
                this.f4859e = i;
                if (this.b != null && this.b.d) {
                    this.b.b(this.c, 1, i);
                }
            }

            public static TopLevelCommentsModel m9689a(TopLevelComments topLevelComments) {
                if (topLevelComments == null) {
                    return null;
                }
                if (topLevelComments instanceof TopLevelCommentsModel) {
                    return (TopLevelCommentsModel) topLevelComments;
                }
                Builder builder = new Builder();
                builder.f4856a = topLevelComments.a();
                builder.f4857b = topLevelComments.b();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, builder.f4856a, 0);
                flatBufferBuilder.a(1, builder.f4857b, 0);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new TopLevelCommentsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 899897761;
            }

            public final GraphQLVisitableModel m9692a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m9691a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f4858d, 0);
                flatBufferBuilder.a(1, this.f4859e, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m9694a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f4858d = mutableFlatBuffer.a(i, 0, 0);
                this.f4859e = mutableFlatBuffer.a(i, 1, 0);
            }
        }

        @Nullable
        public final /* synthetic */ Likers m9712k() {
            return m9714m();
        }

        @Nullable
        public final /* synthetic */ TopLevelComments m9713l() {
            return m9715n();
        }

        public DefaultFeedbackFieldsModel() {
            super(10);
        }

        public DefaultFeedbackFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(10);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final void m9705a(String str, ConsistencyTuple consistencyTuple) {
            if ("can_viewer_comment".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m9708c());
                consistencyTuple.b = u_();
                consistencyTuple.c = 1;
            } else if ("can_viewer_like".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m9710g());
                consistencyTuple.b = u_();
                consistencyTuple.c = 4;
            } else if ("does_viewer_like".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(y_());
                consistencyTuple.b = u_();
                consistencyTuple.c = 5;
            } else {
                if ("likers.count".equals(str)) {
                    LikersModel m = m9714m();
                    if (m != null) {
                        consistencyTuple.a = Integer.valueOf(m.m9681a());
                        consistencyTuple.b = m.u_();
                        consistencyTuple.c = 0;
                        return;
                    }
                } else if ("top_level_comments.count".equals(str)) {
                    r0 = m9715n();
                    if (r0 != null) {
                        consistencyTuple.a = Integer.valueOf(r0.m9690a());
                        consistencyTuple.b = r0.u_();
                        consistencyTuple.c = 0;
                        return;
                    }
                } else if ("top_level_comments.total_count".equals(str)) {
                    r0 = m9715n();
                    if (r0 != null) {
                        consistencyTuple.a = Integer.valueOf(r0.m9695b());
                        consistencyTuple.b = r0.u_();
                        consistencyTuple.c = 1;
                        return;
                    }
                }
                consistencyTuple.a();
            }
        }

        public final void m9706a(String str, Object obj, boolean z) {
            if ("can_viewer_comment".equals(str)) {
                m9698a(((Boolean) obj).booleanValue());
            } else if ("can_viewer_like".equals(str)) {
                m9699b(((Boolean) obj).booleanValue());
            } else if ("does_viewer_like".equals(str)) {
                m9700c(((Boolean) obj).booleanValue());
            } else if ("likers.count".equals(str)) {
                LikersModel m = m9714m();
                if (m == null) {
                    return;
                }
                if (z) {
                    m = (LikersModel) m.clone();
                    m.m9684a(((Integer) obj).intValue());
                    this.f4868l = m;
                    return;
                }
                m.m9684a(((Integer) obj).intValue());
            } else if ("top_level_comments.count".equals(str)) {
                r0 = m9715n();
                if (r0 == null) {
                    return;
                }
                if (z) {
                    r0 = (TopLevelCommentsModel) r0.clone();
                    r0.m9693a(((Integer) obj).intValue());
                    this.f4869m = r0;
                    return;
                }
                r0.m9693a(((Integer) obj).intValue());
            } else if ("top_level_comments.total_count".equals(str)) {
                r0 = m9715n();
                if (r0 == null) {
                    return;
                }
                if (z) {
                    r0 = (TopLevelCommentsModel) r0.clone();
                    r0.m9696b(((Integer) obj).intValue());
                    this.f4869m = r0;
                    return;
                }
                r0.m9696b(((Integer) obj).intValue());
            }
        }

        public final boolean m9707b() {
            a(0, 0);
            return this.f4860d;
        }

        public final boolean m9708c() {
            a(0, 1);
            return this.f4861e;
        }

        private void m9698a(boolean z) {
            this.f4861e = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 1, z);
            }
        }

        public final boolean m9709d() {
            a(0, 2);
            return this.f4862f;
        }

        public final boolean x_() {
            a(0, 3);
            return this.f4863g;
        }

        public final boolean m9710g() {
            a(0, 4);
            return this.f4864h;
        }

        private void m9699b(boolean z) {
            this.f4864h = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 4, z);
            }
        }

        public final boolean y_() {
            a(0, 5);
            return this.f4865i;
        }

        private void m9700c(boolean z) {
            this.f4865i = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 5, z);
            }
        }

        @Nullable
        public final String z_() {
            this.f4866j = super.a(this.f4866j, 6);
            return this.f4866j;
        }

        @Nullable
        public final String m9711j() {
            this.f4867k = super.a(this.f4867k, 7);
            return this.f4867k;
        }

        @Nullable
        public final LikersModel m9714m() {
            this.f4868l = (LikersModel) super.a(this.f4868l, 8, LikersModel.class);
            return this.f4868l;
        }

        @Nullable
        public final TopLevelCommentsModel m9715n() {
            this.f4869m = (TopLevelCommentsModel) super.a(this.f4869m, 9, TopLevelCommentsModel.class);
            return this.f4869m;
        }

        public static DefaultFeedbackFieldsModel m9697a(DefaultFeedbackFields defaultFeedbackFields) {
            if (defaultFeedbackFields == null) {
                return null;
            }
            if (defaultFeedbackFields instanceof DefaultFeedbackFieldsModel) {
                return (DefaultFeedbackFieldsModel) defaultFeedbackFields;
            }
            Builder builder = new Builder();
            builder.f4844a = defaultFeedbackFields.b();
            builder.f4845b = defaultFeedbackFields.c();
            builder.f4846c = defaultFeedbackFields.d();
            builder.f4847d = defaultFeedbackFields.x_();
            builder.f4848e = defaultFeedbackFields.g();
            builder.f4849f = defaultFeedbackFields.y_();
            builder.f4850g = defaultFeedbackFields.z_();
            builder.f4851h = defaultFeedbackFields.j();
            builder.f4852i = LikersModel.m9680a(defaultFeedbackFields.k());
            builder.f4853j = TopLevelCommentsModel.m9689a(defaultFeedbackFields.l());
            return builder.m9675a();
        }

        @Nullable
        public final String m9703a() {
            return m9711j();
        }

        public final int jK_() {
            return -126857307;
        }

        public final GraphQLVisitableModel m9702a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m9714m() != null) {
                LikersModel likersModel = (LikersModel) graphQLModelMutatingVisitor.b(m9714m());
                if (m9714m() != likersModel) {
                    graphQLVisitableModel = (DefaultFeedbackFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f4868l = likersModel;
                }
            }
            if (m9715n() != null) {
                TopLevelCommentsModel topLevelCommentsModel = (TopLevelCommentsModel) graphQLModelMutatingVisitor.b(m9715n());
                if (m9715n() != topLevelCommentsModel) {
                    graphQLVisitableModel = (DefaultFeedbackFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f4869m = topLevelCommentsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m9701a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(z_());
            int b2 = flatBufferBuilder.b(m9711j());
            int a = ModelHelper.a(flatBufferBuilder, m9714m());
            int a2 = ModelHelper.a(flatBufferBuilder, m9715n());
            flatBufferBuilder.c(10);
            flatBufferBuilder.a(0, this.f4860d);
            flatBufferBuilder.a(1, this.f4861e);
            flatBufferBuilder.a(2, this.f4862f);
            flatBufferBuilder.a(3, this.f4863g);
            flatBufferBuilder.a(4, this.f4864h);
            flatBufferBuilder.a(5, this.f4865i);
            flatBufferBuilder.b(6, b);
            flatBufferBuilder.b(7, b2);
            flatBufferBuilder.b(8, a);
            flatBufferBuilder.b(9, a2);
            i();
            return flatBufferBuilder.d();
        }

        public final void m9704a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f4860d = mutableFlatBuffer.a(i, 0);
            this.f4861e = mutableFlatBuffer.a(i, 1);
            this.f4862f = mutableFlatBuffer.a(i, 2);
            this.f4863g = mutableFlatBuffer.a(i, 3);
            this.f4864h = mutableFlatBuffer.a(i, 4);
            this.f4865i = mutableFlatBuffer.a(i, 5);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 842551240)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: editCommentParams */
    public final class DefaultImageUriFieldsModel extends BaseModel implements DefaultImageUriFields, GraphQLVisitableModel {
        @Nullable
        private String f4873d;

        /* compiled from: editCommentParams */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(DefaultImageUriFieldsModel.class, new Deserializer());
            }

            public Object m9719a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(DefaultImageUriFieldsParser.m9758a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object defaultImageUriFieldsModel = new DefaultImageUriFieldsModel();
                ((BaseModel) defaultImageUriFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (defaultImageUriFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) defaultImageUriFieldsModel).a();
                }
                return defaultImageUriFieldsModel;
            }
        }

        /* compiled from: editCommentParams */
        public class Serializer extends JsonSerializer<DefaultImageUriFieldsModel> {
            public final void m9720a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                DefaultImageUriFieldsModel defaultImageUriFieldsModel = (DefaultImageUriFieldsModel) obj;
                if (defaultImageUriFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(defaultImageUriFieldsModel.m9721a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    defaultImageUriFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                DefaultImageUriFieldsParser.m9759a(defaultImageUriFieldsModel.w_(), defaultImageUriFieldsModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(DefaultImageUriFieldsModel.class, new Serializer());
            }
        }

        public DefaultImageUriFieldsModel() {
            super(1);
        }

        @Nullable
        public final String m9723b() {
            this.f4873d = super.a(this.f4873d, 0);
            return this.f4873d;
        }

        public final int jK_() {
            return 70760763;
        }

        public final GraphQLVisitableModel m9722a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m9721a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m9723b());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 918622653)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: editCommentParams */
    public final class DefaultLocationFieldsModel extends BaseModel implements DefaultLocationFields, GraphQLVisitableModel {
        private double f4876d;
        private double f4877e;

        /* compiled from: editCommentParams */
        public final class Builder {
            public double f4874a;
            public double f4875b;

            public final DefaultLocationFieldsModel m9724a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f4874a, 0.0d);
                flatBufferBuilder.a(1, this.f4875b, 0.0d);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new DefaultLocationFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: editCommentParams */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(DefaultLocationFieldsModel.class, new Deserializer());
            }

            public Object m9725a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(DefaultLocationFieldsParser.m9760a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object defaultLocationFieldsModel = new DefaultLocationFieldsModel();
                ((BaseModel) defaultLocationFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (defaultLocationFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) defaultLocationFieldsModel).a();
                }
                return defaultLocationFieldsModel;
            }
        }

        /* compiled from: editCommentParams */
        public class Serializer extends JsonSerializer<DefaultLocationFieldsModel> {
            public final void m9726a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                DefaultLocationFieldsModel defaultLocationFieldsModel = (DefaultLocationFieldsModel) obj;
                if (defaultLocationFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(defaultLocationFieldsModel.m9729a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    defaultLocationFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                DefaultLocationFieldsParser.m9761a(defaultLocationFieldsModel.w_(), defaultLocationFieldsModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(DefaultLocationFieldsModel.class, new Serializer());
            }
        }

        public DefaultLocationFieldsModel() {
            super(2);
        }

        public DefaultLocationFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(2);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final double m9728a() {
            a(0, 0);
            return this.f4876d;
        }

        public final double m9732b() {
            a(0, 1);
            return this.f4877e;
        }

        public static DefaultLocationFieldsModel m9727a(DefaultLocationFields defaultLocationFields) {
            if (defaultLocationFields == null) {
                return null;
            }
            if (defaultLocationFields instanceof DefaultLocationFieldsModel) {
                return (DefaultLocationFieldsModel) defaultLocationFields;
            }
            Builder builder = new Builder();
            builder.f4874a = defaultLocationFields.a();
            builder.f4875b = defaultLocationFields.b();
            return builder.m9724a();
        }

        public final int jK_() {
            return 1965687765;
        }

        public final GraphQLVisitableModel m9730a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m9729a(FlatBufferBuilder flatBufferBuilder) {
            h();
            flatBufferBuilder.c(2);
            flatBufferBuilder.a(0, this.f4876d, 0.0d);
            flatBufferBuilder.a(1, this.f4877e, 0.0d);
            i();
            return flatBufferBuilder.d();
        }

        public final void m9731a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f4876d = mutableFlatBuffer.a(i, 0, 0.0d);
            this.f4877e = mutableFlatBuffer.a(i, 1, 0.0d);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1097398158)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: editCommentParams */
    public final class DefaultSmallProfilePictureFieldsModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private DefaultImageFieldsModel f4878d;

        /* compiled from: editCommentParams */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(DefaultSmallProfilePictureFieldsModel.class, new Deserializer());
            }

            public Object m9733a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = DefaultSmallProfilePictureFieldsParser.m9764a(jsonParser);
                Object defaultSmallProfilePictureFieldsModel = new DefaultSmallProfilePictureFieldsModel();
                ((BaseModel) defaultSmallProfilePictureFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (defaultSmallProfilePictureFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) defaultSmallProfilePictureFieldsModel).a();
                }
                return defaultSmallProfilePictureFieldsModel;
            }
        }

        /* compiled from: editCommentParams */
        public class Serializer extends JsonSerializer<DefaultSmallProfilePictureFieldsModel> {
            public final void m9734a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                DefaultSmallProfilePictureFieldsModel defaultSmallProfilePictureFieldsModel = (DefaultSmallProfilePictureFieldsModel) obj;
                if (defaultSmallProfilePictureFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(defaultSmallProfilePictureFieldsModel.m9736a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    defaultSmallProfilePictureFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = defaultSmallProfilePictureFieldsModel.w_();
                int u_ = defaultSmallProfilePictureFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("profile_picture");
                    DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(DefaultSmallProfilePictureFieldsModel.class, new Serializer());
            }
        }

        public DefaultSmallProfilePictureFieldsModel() {
            super(1);
        }

        public final void m9738a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m9739a(String str, Object obj, boolean z) {
        }

        @Nullable
        private DefaultImageFieldsModel m9735a() {
            this.f4878d = (DefaultImageFieldsModel) super.a(this.f4878d, 0, DefaultImageFieldsModel.class);
            return this.f4878d;
        }

        public final int jK_() {
            return 2645995;
        }

        public final GraphQLVisitableModel m9737a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m9735a() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m9735a());
                if (m9735a() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (DefaultSmallProfilePictureFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f4878d = defaultImageFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m9736a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m9735a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1244528557)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: editCommentParams */
    public final class DefaultTimeRangeFieldsModel extends BaseModel implements GraphQLVisitableModel {
        private long f4881d;
        private long f4882e;

        /* compiled from: editCommentParams */
        public final class Builder {
            public long f4879a;
            public long f4880b;

            public final DefaultTimeRangeFieldsModel m9740a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f4879a, 0);
                flatBufferBuilder.a(1, this.f4880b, 0);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new DefaultTimeRangeFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: editCommentParams */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(DefaultTimeRangeFieldsModel.class, new Deserializer());
            }

            public Object m9741a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(DefaultTimeRangeFieldsParser.m9768b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object defaultTimeRangeFieldsModel = new DefaultTimeRangeFieldsModel();
                ((BaseModel) defaultTimeRangeFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (defaultTimeRangeFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) defaultTimeRangeFieldsModel).a();
                }
                return defaultTimeRangeFieldsModel;
            }
        }

        /* compiled from: editCommentParams */
        public class Serializer extends JsonSerializer<DefaultTimeRangeFieldsModel> {
            public final void m9742a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                DefaultTimeRangeFieldsModel defaultTimeRangeFieldsModel = (DefaultTimeRangeFieldsModel) obj;
                if (defaultTimeRangeFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(defaultTimeRangeFieldsModel.m9744a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    defaultTimeRangeFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                DefaultTimeRangeFieldsParser.m9766a(defaultTimeRangeFieldsModel.w_(), defaultTimeRangeFieldsModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(DefaultTimeRangeFieldsModel.class, new Serializer());
            }
        }

        public DefaultTimeRangeFieldsModel() {
            super(2);
        }

        public DefaultTimeRangeFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(2);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final long m9745a() {
            a(0, 0);
            return this.f4881d;
        }

        public final long m9748b() {
            a(0, 1);
            return this.f4882e;
        }

        public static DefaultTimeRangeFieldsModel m9743a(DefaultTimeRangeFieldsModel defaultTimeRangeFieldsModel) {
            if (defaultTimeRangeFieldsModel == null) {
                return null;
            }
            if (defaultTimeRangeFieldsModel instanceof DefaultTimeRangeFieldsModel) {
                return defaultTimeRangeFieldsModel;
            }
            Builder builder = new Builder();
            builder.f4879a = defaultTimeRangeFieldsModel.m9745a();
            builder.f4880b = defaultTimeRangeFieldsModel.m9748b();
            return builder.m9740a();
        }

        public final int jK_() {
            return 2028064336;
        }

        public final GraphQLVisitableModel m9746a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m9744a(FlatBufferBuilder flatBufferBuilder) {
            h();
            flatBufferBuilder.c(2);
            flatBufferBuilder.a(0, this.f4881d, 0);
            flatBufferBuilder.a(1, this.f4882e, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m9747a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f4881d = mutableFlatBuffer.a(i, 0, 0);
            this.f4882e = mutableFlatBuffer.a(i, 1, 0);
        }
    }
}

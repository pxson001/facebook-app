package com.facebook.messaging.graphql.threads;

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
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.messaging.graphql.threads.AppAttributionQueriesInterfaces.AttachmentAttribution;
import com.facebook.messaging.graphql.threads.AppAttributionQueriesParsers.AppAttributionInfoParser;
import com.facebook.messaging.graphql.threads.AppAttributionQueriesParsers.AppAttributionInfoParser.AndroidAppConfigParser;
import com.facebook.messaging.graphql.threads.AppAttributionQueriesParsers.AppAttributionInfoParser.MessengerAppAttributionVisibilityParser;
import com.facebook.messaging.graphql.threads.AppAttributionQueriesParsers.AppAttributionInfoParser.SquareLogoParser;
import com.facebook.messaging.graphql.threads.AppAttributionQueriesParsers.AttachmentAttributionParser;
import com.facebook.messaging.graphql.threads.AppAttributionQueriesParsers.AttachmentAttributionParser.AttributionAppScopedIdsParser;
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

/* compiled from: video_encoding_profile */
public class AppAttributionQueriesModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -919843189)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: video_encoding_profile */
    public final class AppAttributionInfoModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private AndroidAppConfigModel f752d;
        @Nullable
        private String f753e;
        @Nullable
        private MessengerAppAttributionVisibilityModel f754f;
        @Nullable
        private String f755g;
        @Nullable
        private SquareLogoModel f756h;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 403941021)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: video_encoding_profile */
        public final class AndroidAppConfigModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<String> f746d;
            @Nullable
            private String f747e;

            /* compiled from: video_encoding_profile */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AndroidAppConfigModel.class, new Deserializer());
                }

                public Object m759a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AndroidAppConfigParser.m802a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object androidAppConfigModel = new AndroidAppConfigModel();
                    ((BaseModel) androidAppConfigModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (androidAppConfigModel instanceof Postprocessable) {
                        return ((Postprocessable) androidAppConfigModel).a();
                    }
                    return androidAppConfigModel;
                }
            }

            /* compiled from: video_encoding_profile */
            public class Serializer extends JsonSerializer<AndroidAppConfigModel> {
                public final void m760a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AndroidAppConfigModel androidAppConfigModel = (AndroidAppConfigModel) obj;
                    if (androidAppConfigModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(androidAppConfigModel.m762a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        androidAppConfigModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AndroidAppConfigParser.m803a(androidAppConfigModel.w_(), androidAppConfigModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AndroidAppConfigModel.class, new Serializer());
                }
            }

            public AndroidAppConfigModel() {
                super(2);
            }

            @Nonnull
            private ImmutableList<String> m761j() {
                this.f746d = super.a(this.f746d, 0);
                return (ImmutableList) this.f746d;
            }

            @Nullable
            public final String m764a() {
                this.f747e = super.a(this.f747e, 1);
                return this.f747e;
            }

            public final int jK_() {
                return -585955532;
            }

            public final GraphQLVisitableModel m763a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m762a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int c = flatBufferBuilder.c(m761j());
                int b = flatBufferBuilder.b(m764a());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, c);
                flatBufferBuilder.b(1, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: video_encoding_profile */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AppAttributionInfoModel.class, new Deserializer());
            }

            public Object m765a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(AppAttributionInfoParser.m808a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object appAttributionInfoModel = new AppAttributionInfoModel();
                ((BaseModel) appAttributionInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (appAttributionInfoModel instanceof Postprocessable) {
                    return ((Postprocessable) appAttributionInfoModel).a();
                }
                return appAttributionInfoModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 660454262)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: video_encoding_profile */
        public final class MessengerAppAttributionVisibilityModel extends BaseModel implements GraphQLVisitableModel {
            private boolean f748d;
            private boolean f749e;
            private boolean f750f;

            /* compiled from: video_encoding_profile */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MessengerAppAttributionVisibilityModel.class, new Deserializer());
                }

                public Object m766a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MessengerAppAttributionVisibilityParser.m804a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object messengerAppAttributionVisibilityModel = new MessengerAppAttributionVisibilityModel();
                    ((BaseModel) messengerAppAttributionVisibilityModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (messengerAppAttributionVisibilityModel instanceof Postprocessable) {
                        return ((Postprocessable) messengerAppAttributionVisibilityModel).a();
                    }
                    return messengerAppAttributionVisibilityModel;
                }
            }

            /* compiled from: video_encoding_profile */
            public class Serializer extends JsonSerializer<MessengerAppAttributionVisibilityModel> {
                public final void m767a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MessengerAppAttributionVisibilityModel messengerAppAttributionVisibilityModel = (MessengerAppAttributionVisibilityModel) obj;
                    if (messengerAppAttributionVisibilityModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(messengerAppAttributionVisibilityModel.m768a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        messengerAppAttributionVisibilityModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MessengerAppAttributionVisibilityParser.m805a(messengerAppAttributionVisibilityModel.w_(), messengerAppAttributionVisibilityModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(MessengerAppAttributionVisibilityModel.class, new Serializer());
                }
            }

            public MessengerAppAttributionVisibilityModel() {
                super(3);
            }

            public final boolean m771a() {
                a(0, 0);
                return this.f748d;
            }

            public final boolean m772j() {
                a(0, 1);
                return this.f749e;
            }

            public final boolean m773k() {
                a(0, 2);
                return this.f750f;
            }

            public final int jK_() {
                return -871385245;
            }

            public final GraphQLVisitableModel m769a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m768a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(3);
                flatBufferBuilder.a(0, this.f748d);
                flatBufferBuilder.a(1, this.f749e);
                flatBufferBuilder.a(2, this.f750f);
                i();
                return flatBufferBuilder.d();
            }

            public final void m770a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f748d = mutableFlatBuffer.a(i, 0);
                this.f749e = mutableFlatBuffer.a(i, 1);
                this.f750f = mutableFlatBuffer.a(i, 2);
            }
        }

        /* compiled from: video_encoding_profile */
        public class Serializer extends JsonSerializer<AppAttributionInfoModel> {
            public final void m774a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                AppAttributionInfoModel appAttributionInfoModel = (AppAttributionInfoModel) obj;
                if (appAttributionInfoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(appAttributionInfoModel.m781a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    appAttributionInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                AppAttributionInfoParser.m809a(appAttributionInfoModel.w_(), appAttributionInfoModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(AppAttributionInfoModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: video_encoding_profile */
        public final class SquareLogoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f751d;

            /* compiled from: video_encoding_profile */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SquareLogoModel.class, new Deserializer());
                }

                public Object m775a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SquareLogoParser.m806a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object squareLogoModel = new SquareLogoModel();
                    ((BaseModel) squareLogoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (squareLogoModel instanceof Postprocessable) {
                        return ((Postprocessable) squareLogoModel).a();
                    }
                    return squareLogoModel;
                }
            }

            /* compiled from: video_encoding_profile */
            public class Serializer extends JsonSerializer<SquareLogoModel> {
                public final void m776a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SquareLogoModel squareLogoModel = (SquareLogoModel) obj;
                    if (squareLogoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(squareLogoModel.m778a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        squareLogoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SquareLogoParser.m807a(squareLogoModel.w_(), squareLogoModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(SquareLogoModel.class, new Serializer());
                }
            }

            public SquareLogoModel() {
                super(1);
            }

            @Nullable
            private String m777a() {
                this.f751d = super.a(this.f751d, 0);
                return this.f751d;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m779a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m778a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m777a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        public AppAttributionInfoModel() {
            super(5);
        }

        @Nullable
        public final AndroidAppConfigModel m784j() {
            this.f752d = (AndroidAppConfigModel) super.a(this.f752d, 0, AndroidAppConfigModel.class);
            return this.f752d;
        }

        @Nullable
        public final String m785k() {
            this.f753e = super.a(this.f753e, 1);
            return this.f753e;
        }

        @Nullable
        public final MessengerAppAttributionVisibilityModel m786l() {
            this.f754f = (MessengerAppAttributionVisibilityModel) super.a(this.f754f, 2, MessengerAppAttributionVisibilityModel.class);
            return this.f754f;
        }

        @Nullable
        public final String m787m() {
            this.f755g = super.a(this.f755g, 3);
            return this.f755g;
        }

        @Nullable
        private SquareLogoModel m780n() {
            this.f756h = (SquareLogoModel) super.a(this.f756h, 4, SquareLogoModel.class);
            return this.f756h;
        }

        @Nullable
        public final String m783a() {
            return m785k();
        }

        public final int jK_() {
            return -1072845520;
        }

        public final GraphQLVisitableModel m782a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m784j() != null) {
                AndroidAppConfigModel androidAppConfigModel = (AndroidAppConfigModel) graphQLModelMutatingVisitor.b(m784j());
                if (m784j() != androidAppConfigModel) {
                    graphQLVisitableModel = (AppAttributionInfoModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f752d = androidAppConfigModel;
                }
            }
            if (m786l() != null) {
                MessengerAppAttributionVisibilityModel messengerAppAttributionVisibilityModel = (MessengerAppAttributionVisibilityModel) graphQLModelMutatingVisitor.b(m786l());
                if (m786l() != messengerAppAttributionVisibilityModel) {
                    graphQLVisitableModel = (AppAttributionInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f754f = messengerAppAttributionVisibilityModel;
                }
            }
            if (m780n() != null) {
                SquareLogoModel squareLogoModel = (SquareLogoModel) graphQLModelMutatingVisitor.b(m780n());
                if (m780n() != squareLogoModel) {
                    graphQLVisitableModel = (AppAttributionInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f756h = squareLogoModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m781a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m784j());
            int b = flatBufferBuilder.b(m785k());
            int a2 = ModelHelper.a(flatBufferBuilder, m786l());
            int b2 = flatBufferBuilder.b(m787m());
            int a3 = ModelHelper.a(flatBufferBuilder, m780n());
            flatBufferBuilder.c(5);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, b2);
            flatBufferBuilder.b(4, a3);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1363389455)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: video_encoding_profile */
    public final class AttachmentAttributionModel extends BaseModel implements GraphQLVisitableModel, AttachmentAttribution {
        @Nullable
        private GraphQLObjectType f759d;
        @Nullable
        private AppAttributionInfoModel f760e;
        @Nullable
        private List<AttributionAppScopedIdsModel> f761f;
        @Nullable
        private String f762g;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1752252147)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: video_encoding_profile */
        public final class AttributionAppScopedIdsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f757d;
            @Nullable
            private String f758e;

            /* compiled from: video_encoding_profile */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AttributionAppScopedIdsModel.class, new Deserializer());
                }

                public Object m788a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AttributionAppScopedIdsParser.m813b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object attributionAppScopedIdsModel = new AttributionAppScopedIdsModel();
                    ((BaseModel) attributionAppScopedIdsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (attributionAppScopedIdsModel instanceof Postprocessable) {
                        return ((Postprocessable) attributionAppScopedIdsModel).a();
                    }
                    return attributionAppScopedIdsModel;
                }
            }

            /* compiled from: video_encoding_profile */
            public class Serializer extends JsonSerializer<AttributionAppScopedIdsModel> {
                public final void m789a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AttributionAppScopedIdsModel attributionAppScopedIdsModel = (AttributionAppScopedIdsModel) obj;
                    if (attributionAppScopedIdsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(attributionAppScopedIdsModel.m790a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        attributionAppScopedIdsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AttributionAppScopedIdsParser.m811a(attributionAppScopedIdsModel.w_(), attributionAppScopedIdsModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AttributionAppScopedIdsModel.class, new Serializer());
                }
            }

            public AttributionAppScopedIdsModel() {
                super(2);
            }

            @Nullable
            public final String m792a() {
                this.f757d = super.a(this.f757d, 0);
                return this.f757d;
            }

            @Nullable
            public final String m793b() {
                this.f758e = super.a(this.f758e, 1);
                return this.f758e;
            }

            public final int jK_() {
                return -1631095110;
            }

            public final GraphQLVisitableModel m791a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m790a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m792a());
                int b2 = flatBufferBuilder.b(m793b());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: video_encoding_profile */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AttachmentAttributionModel.class, new Deserializer());
            }

            public Object m794a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = AttachmentAttributionParser.m814a(jsonParser);
                Object attachmentAttributionModel = new AttachmentAttributionModel();
                ((BaseModel) attachmentAttributionModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (attachmentAttributionModel instanceof Postprocessable) {
                    return ((Postprocessable) attachmentAttributionModel).a();
                }
                return attachmentAttributionModel;
            }
        }

        /* compiled from: video_encoding_profile */
        public class Serializer extends JsonSerializer<AttachmentAttributionModel> {
            public final void m795a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                AttachmentAttributionModel attachmentAttributionModel = (AttachmentAttributionModel) obj;
                if (attachmentAttributionModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(attachmentAttributionModel.m800a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    attachmentAttributionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = attachmentAttributionModel.w_();
                int u_ = attachmentAttributionModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("attribution_app");
                    AppAttributionInfoParser.m809a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("attribution_app_scoped_ids");
                    AttributionAppScopedIdsParser.m812a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 3) != 0) {
                    jsonGenerator.a("attribution_metadata");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 3));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(AttachmentAttributionModel.class, new Serializer());
            }
        }

        public AttachmentAttributionModel() {
            super(4);
        }

        @Nullable
        private GraphQLObjectType m796a() {
            if (this.b != null && this.f759d == null) {
                this.f759d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f759d;
        }

        @Nullable
        private AppAttributionInfoModel m797j() {
            this.f760e = (AppAttributionInfoModel) super.a(this.f760e, 1, AppAttributionInfoModel.class);
            return this.f760e;
        }

        @Nonnull
        private ImmutableList<AttributionAppScopedIdsModel> m798k() {
            this.f761f = super.a(this.f761f, 2, AttributionAppScopedIdsModel.class);
            return (ImmutableList) this.f761f;
        }

        @Nullable
        private String m799l() {
            this.f762g = super.a(this.f762g, 3);
            return this.f762g;
        }

        public final int jK_() {
            return -715306905;
        }

        public final GraphQLVisitableModel m801a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m797j() != null) {
                AppAttributionInfoModel appAttributionInfoModel = (AppAttributionInfoModel) graphQLModelMutatingVisitor.b(m797j());
                if (m797j() != appAttributionInfoModel) {
                    graphQLVisitableModel = (AttachmentAttributionModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f760e = appAttributionInfoModel;
                }
            }
            if (m798k() != null) {
                Builder a = ModelHelper.a(m798k(), graphQLModelMutatingVisitor);
                if (a != null) {
                    AttachmentAttributionModel attachmentAttributionModel = (AttachmentAttributionModel) ModelHelper.a(graphQLVisitableModel, this);
                    attachmentAttributionModel.f761f = a.b();
                    graphQLVisitableModel = attachmentAttributionModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m800a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m796a());
            int a2 = ModelHelper.a(flatBufferBuilder, m797j());
            int a3 = ModelHelper.a(flatBufferBuilder, m798k());
            int b = flatBufferBuilder.b(m799l());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}

package com.facebook.appinvites.protocol;

import com.facebook.appinvites.protocol.AppInvitesMutationsParsers.AppInviteSettingsMutationFieldsParser;
import com.facebook.appinvites.protocol.AppInvitesMutationsParsers.AppInviteSettingsMutationFieldsParser.UserApplicationInviteSettingsParser;
import com.facebook.appinvites.protocol.AppInvitesMutationsParsers.AppRequestAcceptCoreMutationFieldsParser;
import com.facebook.appinvites.protocol.AppInvitesMutationsParsers.AppRequestBlockApplicationCoreMutationFieldsParser;
import com.facebook.appinvites.protocol.AppInvitesMutationsParsers.AppRequestBlockApplicationCoreMutationFieldsParser.ApplicationParser;
import com.facebook.appinvites.protocol.AppInvitesMutationsParsers.AppRequestBlockUserCoreMutationFieldsParser;
import com.facebook.appinvites.protocol.AppInvitesMutationsParsers.AppRequestBlockUserCoreMutationFieldsParser.UserParser;
import com.facebook.appinvites.protocol.AppInvitesMutationsParsers.AppRequestDeleteAllCoreMutationFieldsParser;
import com.facebook.appinvites.protocol.AppInvitesMutationsParsers.AppRequestDeleteCoreMutationFieldsParser;
import com.facebook.appinvites.protocol.AppInvitesMutationsParsers.AppRequestUnblockApplicationCoreMutationFieldsParser;
import com.facebook.appinvites.protocol.AppInvitesMutationsParsers.AppRequestUnblockUserCoreMutationFragmentParser;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLAppInviteSettingsForSenderNotification;
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

/* compiled from: eaten_fb4a */
public class AppInvitesMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1728383040)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: eaten_fb4a */
    public final class AppInviteSettingsMutationFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private UserApplicationInviteSettingsModel f14616d;

        /* compiled from: eaten_fb4a */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AppInviteSettingsMutationFieldsModel.class, new Deserializer());
            }

            public Object m14778a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = AppInviteSettingsMutationFieldsParser.m14855a(jsonParser);
                Object appInviteSettingsMutationFieldsModel = new AppInviteSettingsMutationFieldsModel();
                ((BaseModel) appInviteSettingsMutationFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (appInviteSettingsMutationFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) appInviteSettingsMutationFieldsModel).a();
                }
                return appInviteSettingsMutationFieldsModel;
            }
        }

        /* compiled from: eaten_fb4a */
        public class Serializer extends JsonSerializer<AppInviteSettingsMutationFieldsModel> {
            public final void m14779a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                AppInviteSettingsMutationFieldsModel appInviteSettingsMutationFieldsModel = (AppInviteSettingsMutationFieldsModel) obj;
                if (appInviteSettingsMutationFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(appInviteSettingsMutationFieldsModel.m14788a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    appInviteSettingsMutationFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = appInviteSettingsMutationFieldsModel.w_();
                int u_ = appInviteSettingsMutationFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("user_application_invite_settings");
                    UserApplicationInviteSettingsParser.m14854a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(AppInviteSettingsMutationFieldsModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1392585875)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: eaten_fb4a */
        public final class UserApplicationInviteSettingsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f14614d;
            @Nullable
            private GraphQLAppInviteSettingsForSenderNotification f14615e;

            /* compiled from: eaten_fb4a */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(UserApplicationInviteSettingsModel.class, new Deserializer());
                }

                public Object m14780a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(UserApplicationInviteSettingsParser.m14853a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object userApplicationInviteSettingsModel = new UserApplicationInviteSettingsModel();
                    ((BaseModel) userApplicationInviteSettingsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (userApplicationInviteSettingsModel instanceof Postprocessable) {
                        return ((Postprocessable) userApplicationInviteSettingsModel).a();
                    }
                    return userApplicationInviteSettingsModel;
                }
            }

            /* compiled from: eaten_fb4a */
            public class Serializer extends JsonSerializer<UserApplicationInviteSettingsModel> {
                public final void m14781a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    UserApplicationInviteSettingsModel userApplicationInviteSettingsModel = (UserApplicationInviteSettingsModel) obj;
                    if (userApplicationInviteSettingsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(userApplicationInviteSettingsModel.m14784a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        userApplicationInviteSettingsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    UserApplicationInviteSettingsParser.m14854a(userApplicationInviteSettingsModel.w_(), userApplicationInviteSettingsModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(UserApplicationInviteSettingsModel.class, new Serializer());
                }
            }

            public UserApplicationInviteSettingsModel() {
                super(2);
            }

            @Nullable
            private String m14782j() {
                this.f14614d = super.a(this.f14614d, 0);
                return this.f14614d;
            }

            @Nullable
            private GraphQLAppInviteSettingsForSenderNotification m14783k() {
                this.f14615e = (GraphQLAppInviteSettingsForSenderNotification) super.b(this.f14615e, 1, GraphQLAppInviteSettingsForSenderNotification.class, GraphQLAppInviteSettingsForSenderNotification.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f14615e;
            }

            @Nullable
            public final String m14786a() {
                return m14782j();
            }

            public final int jK_() {
                return -1504859631;
            }

            public final GraphQLVisitableModel m14785a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m14784a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m14782j());
                int a = flatBufferBuilder.a(m14783k());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public AppInviteSettingsMutationFieldsModel() {
            super(1);
        }

        @Nullable
        private UserApplicationInviteSettingsModel m14787a() {
            this.f14616d = (UserApplicationInviteSettingsModel) super.a(this.f14616d, 0, UserApplicationInviteSettingsModel.class);
            return this.f14616d;
        }

        public final int jK_() {
            return 1863715784;
        }

        public final GraphQLVisitableModel m14789a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m14787a() != null) {
                UserApplicationInviteSettingsModel userApplicationInviteSettingsModel = (UserApplicationInviteSettingsModel) graphQLModelMutatingVisitor.b(m14787a());
                if (m14787a() != userApplicationInviteSettingsModel) {
                    graphQLVisitableModel = (AppInviteSettingsMutationFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f14616d = userApplicationInviteSettingsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m14788a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m14787a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1967738475)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: eaten_fb4a */
    public final class AppRequestAcceptCoreMutationFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<String> f14617d;

        /* compiled from: eaten_fb4a */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AppRequestAcceptCoreMutationFieldsModel.class, new Deserializer());
            }

            public Object m14790a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = AppRequestAcceptCoreMutationFieldsParser.m14856a(jsonParser);
                Object appRequestAcceptCoreMutationFieldsModel = new AppRequestAcceptCoreMutationFieldsModel();
                ((BaseModel) appRequestAcceptCoreMutationFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (appRequestAcceptCoreMutationFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) appRequestAcceptCoreMutationFieldsModel).a();
                }
                return appRequestAcceptCoreMutationFieldsModel;
            }
        }

        /* compiled from: eaten_fb4a */
        public class Serializer extends JsonSerializer<AppRequestAcceptCoreMutationFieldsModel> {
            public final void m14791a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                AppRequestAcceptCoreMutationFieldsModel appRequestAcceptCoreMutationFieldsModel = (AppRequestAcceptCoreMutationFieldsModel) obj;
                if (appRequestAcceptCoreMutationFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(appRequestAcceptCoreMutationFieldsModel.m14793a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    appRequestAcceptCoreMutationFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = appRequestAcceptCoreMutationFieldsModel.w_();
                int u_ = appRequestAcceptCoreMutationFieldsModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("accepted_request_ids");
                    SerializerHelpers.a(mutableFlatBuffer.f(u_, 0), jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(AppRequestAcceptCoreMutationFieldsModel.class, new Serializer());
            }
        }

        public AppRequestAcceptCoreMutationFieldsModel() {
            super(1);
        }

        @Nonnull
        private ImmutableList<String> m14792a() {
            this.f14617d = super.a(this.f14617d, 0);
            return (ImmutableList) this.f14617d;
        }

        public final int jK_() {
            return -576220698;
        }

        public final GraphQLVisitableModel m14794a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m14793a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int c = flatBufferBuilder.c(m14792a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, c);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1618096586)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: eaten_fb4a */
    public final class AppRequestBlockApplicationCoreMutationFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ApplicationModel f14619d;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: eaten_fb4a */
        public final class ApplicationModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f14618d;

            /* compiled from: eaten_fb4a */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ApplicationModel.class, new Deserializer());
                }

                public Object m14795a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ApplicationParser.m14857a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object applicationModel = new ApplicationModel();
                    ((BaseModel) applicationModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (applicationModel instanceof Postprocessable) {
                        return ((Postprocessable) applicationModel).a();
                    }
                    return applicationModel;
                }
            }

            /* compiled from: eaten_fb4a */
            public class Serializer extends JsonSerializer<ApplicationModel> {
                public final void m14796a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ApplicationModel applicationModel = (ApplicationModel) obj;
                    if (applicationModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(applicationModel.m14798a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        applicationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ApplicationParser.m14858a(applicationModel.w_(), applicationModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ApplicationModel.class, new Serializer());
                }
            }

            public ApplicationModel() {
                super(1);
            }

            @Nullable
            private String m14797j() {
                this.f14618d = super.a(this.f14618d, 0);
                return this.f14618d;
            }

            @Nullable
            public final String m14800a() {
                return m14797j();
            }

            public final int jK_() {
                return -1072845520;
            }

            public final GraphQLVisitableModel m14799a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m14798a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m14797j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: eaten_fb4a */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AppRequestBlockApplicationCoreMutationFieldsModel.class, new Deserializer());
            }

            public Object m14801a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = AppRequestBlockApplicationCoreMutationFieldsParser.m14859a(jsonParser);
                Object appRequestBlockApplicationCoreMutationFieldsModel = new AppRequestBlockApplicationCoreMutationFieldsModel();
                ((BaseModel) appRequestBlockApplicationCoreMutationFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (appRequestBlockApplicationCoreMutationFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) appRequestBlockApplicationCoreMutationFieldsModel).a();
                }
                return appRequestBlockApplicationCoreMutationFieldsModel;
            }
        }

        /* compiled from: eaten_fb4a */
        public class Serializer extends JsonSerializer<AppRequestBlockApplicationCoreMutationFieldsModel> {
            public final void m14802a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                AppRequestBlockApplicationCoreMutationFieldsModel appRequestBlockApplicationCoreMutationFieldsModel = (AppRequestBlockApplicationCoreMutationFieldsModel) obj;
                if (appRequestBlockApplicationCoreMutationFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(appRequestBlockApplicationCoreMutationFieldsModel.m14804a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    appRequestBlockApplicationCoreMutationFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = appRequestBlockApplicationCoreMutationFieldsModel.w_();
                int u_ = appRequestBlockApplicationCoreMutationFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("application");
                    ApplicationParser.m14858a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(AppRequestBlockApplicationCoreMutationFieldsModel.class, new Serializer());
            }
        }

        public AppRequestBlockApplicationCoreMutationFieldsModel() {
            super(1);
        }

        @Nullable
        private ApplicationModel m14803a() {
            this.f14619d = (ApplicationModel) super.a(this.f14619d, 0, ApplicationModel.class);
            return this.f14619d;
        }

        public final int jK_() {
            return 123172299;
        }

        public final GraphQLVisitableModel m14805a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m14803a() != null) {
                ApplicationModel applicationModel = (ApplicationModel) graphQLModelMutatingVisitor.b(m14803a());
                if (m14803a() != applicationModel) {
                    graphQLVisitableModel = (AppRequestBlockApplicationCoreMutationFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f14619d = applicationModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m14804a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m14803a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1187499961)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: eaten_fb4a */
    public final class AppRequestBlockUserCoreMutationFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private UserModel f14621d;

        /* compiled from: eaten_fb4a */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AppRequestBlockUserCoreMutationFieldsModel.class, new Deserializer());
            }

            public Object m14806a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = AppRequestBlockUserCoreMutationFieldsParser.m14862a(jsonParser);
                Object appRequestBlockUserCoreMutationFieldsModel = new AppRequestBlockUserCoreMutationFieldsModel();
                ((BaseModel) appRequestBlockUserCoreMutationFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (appRequestBlockUserCoreMutationFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) appRequestBlockUserCoreMutationFieldsModel).a();
                }
                return appRequestBlockUserCoreMutationFieldsModel;
            }
        }

        /* compiled from: eaten_fb4a */
        public class Serializer extends JsonSerializer<AppRequestBlockUserCoreMutationFieldsModel> {
            public final void m14807a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                AppRequestBlockUserCoreMutationFieldsModel appRequestBlockUserCoreMutationFieldsModel = (AppRequestBlockUserCoreMutationFieldsModel) obj;
                if (appRequestBlockUserCoreMutationFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(appRequestBlockUserCoreMutationFieldsModel.m14817a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    appRequestBlockUserCoreMutationFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = appRequestBlockUserCoreMutationFieldsModel.w_();
                int u_ = appRequestBlockUserCoreMutationFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("user");
                    UserParser.m14861a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(AppRequestBlockUserCoreMutationFieldsModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: eaten_fb4a */
        public final class UserModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f14620d;

            /* compiled from: eaten_fb4a */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(UserModel.class, new Deserializer());
                }

                public Object m14808a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(UserParser.m14860a(jsonParser, flatBufferBuilder));
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

            /* compiled from: eaten_fb4a */
            public class Serializer extends JsonSerializer<UserModel> {
                public final void m14809a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    UserModel userModel = (UserModel) obj;
                    if (userModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(userModel.m14811a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        userModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    UserParser.m14861a(userModel.w_(), userModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(UserModel.class, new Serializer());
                }
            }

            public UserModel() {
                super(1);
            }

            public final void m14814a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m14815a(String str, Object obj, boolean z) {
            }

            @Nullable
            private String m14810j() {
                this.f14620d = super.a(this.f14620d, 0);
                return this.f14620d;
            }

            @Nullable
            public final String m14813a() {
                return m14810j();
            }

            public final int jK_() {
                return 2645995;
            }

            public final GraphQLVisitableModel m14812a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m14811a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m14810j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        public AppRequestBlockUserCoreMutationFieldsModel() {
            super(1);
        }

        @Nullable
        private UserModel m14816a() {
            this.f14621d = (UserModel) super.a(this.f14621d, 0, UserModel.class);
            return this.f14621d;
        }

        public final int jK_() {
            return 464583508;
        }

        public final GraphQLVisitableModel m14818a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m14816a() != null) {
                UserModel userModel = (UserModel) graphQLModelMutatingVisitor.b(m14816a());
                if (m14816a() != userModel) {
                    graphQLVisitableModel = (AppRequestBlockUserCoreMutationFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f14621d = userModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m14817a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m14816a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1557877426)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: eaten_fb4a */
    public final class AppRequestDeleteAllCoreMutationFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<String> f14622d;

        /* compiled from: eaten_fb4a */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AppRequestDeleteAllCoreMutationFieldsModel.class, new Deserializer());
            }

            public Object m14819a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = AppRequestDeleteAllCoreMutationFieldsParser.m14863a(jsonParser);
                Object appRequestDeleteAllCoreMutationFieldsModel = new AppRequestDeleteAllCoreMutationFieldsModel();
                ((BaseModel) appRequestDeleteAllCoreMutationFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (appRequestDeleteAllCoreMutationFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) appRequestDeleteAllCoreMutationFieldsModel).a();
                }
                return appRequestDeleteAllCoreMutationFieldsModel;
            }
        }

        /* compiled from: eaten_fb4a */
        public class Serializer extends JsonSerializer<AppRequestDeleteAllCoreMutationFieldsModel> {
            public final void m14820a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                AppRequestDeleteAllCoreMutationFieldsModel appRequestDeleteAllCoreMutationFieldsModel = (AppRequestDeleteAllCoreMutationFieldsModel) obj;
                if (appRequestDeleteAllCoreMutationFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(appRequestDeleteAllCoreMutationFieldsModel.m14822a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    appRequestDeleteAllCoreMutationFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = appRequestDeleteAllCoreMutationFieldsModel.w_();
                int u_ = appRequestDeleteAllCoreMutationFieldsModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("deleted_request_ids");
                    SerializerHelpers.a(mutableFlatBuffer.f(u_, 0), jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(AppRequestDeleteAllCoreMutationFieldsModel.class, new Serializer());
            }
        }

        public AppRequestDeleteAllCoreMutationFieldsModel() {
            super(1);
        }

        @Nonnull
        private ImmutableList<String> m14821a() {
            this.f14622d = super.a(this.f14622d, 0);
            return (ImmutableList) this.f14622d;
        }

        public final int jK_() {
            return 403438998;
        }

        public final GraphQLVisitableModel m14823a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m14822a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int c = flatBufferBuilder.c(m14821a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, c);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1557877426)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: eaten_fb4a */
    public final class AppRequestDeleteCoreMutationFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<String> f14623d;

        /* compiled from: eaten_fb4a */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AppRequestDeleteCoreMutationFieldsModel.class, new Deserializer());
            }

            public Object m14824a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = AppRequestDeleteCoreMutationFieldsParser.m14864a(jsonParser);
                Object appRequestDeleteCoreMutationFieldsModel = new AppRequestDeleteCoreMutationFieldsModel();
                ((BaseModel) appRequestDeleteCoreMutationFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (appRequestDeleteCoreMutationFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) appRequestDeleteCoreMutationFieldsModel).a();
                }
                return appRequestDeleteCoreMutationFieldsModel;
            }
        }

        /* compiled from: eaten_fb4a */
        public class Serializer extends JsonSerializer<AppRequestDeleteCoreMutationFieldsModel> {
            public final void m14825a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                AppRequestDeleteCoreMutationFieldsModel appRequestDeleteCoreMutationFieldsModel = (AppRequestDeleteCoreMutationFieldsModel) obj;
                if (appRequestDeleteCoreMutationFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(appRequestDeleteCoreMutationFieldsModel.m14827a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    appRequestDeleteCoreMutationFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = appRequestDeleteCoreMutationFieldsModel.w_();
                int u_ = appRequestDeleteCoreMutationFieldsModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("deleted_request_ids");
                    SerializerHelpers.a(mutableFlatBuffer.f(u_, 0), jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(AppRequestDeleteCoreMutationFieldsModel.class, new Serializer());
            }
        }

        public AppRequestDeleteCoreMutationFieldsModel() {
            super(1);
        }

        @Nonnull
        private ImmutableList<String> m14826a() {
            this.f14623d = super.a(this.f14623d, 0);
            return (ImmutableList) this.f14623d;
        }

        public final int jK_() {
            return 416220899;
        }

        public final GraphQLVisitableModel m14828a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m14827a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int c = flatBufferBuilder.c(m14826a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, c);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1303818341)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: eaten_fb4a */
    public final class AppRequestUnblockApplicationCoreMutationFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ApplicationModel f14625d;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: eaten_fb4a */
        public final class ApplicationModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f14624d;

            /* compiled from: eaten_fb4a */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ApplicationModel.class, new Deserializer());
                }

                public Object m14829a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AppRequestUnblockApplicationCoreMutationFieldsParser.ApplicationParser.m14865a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object applicationModel = new ApplicationModel();
                    ((BaseModel) applicationModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (applicationModel instanceof Postprocessable) {
                        return ((Postprocessable) applicationModel).a();
                    }
                    return applicationModel;
                }
            }

            /* compiled from: eaten_fb4a */
            public class Serializer extends JsonSerializer<ApplicationModel> {
                public final void m14830a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ApplicationModel applicationModel = (ApplicationModel) obj;
                    if (applicationModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(applicationModel.m14832a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        applicationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AppRequestUnblockApplicationCoreMutationFieldsParser.ApplicationParser.m14866a(applicationModel.w_(), applicationModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ApplicationModel.class, new Serializer());
                }
            }

            public ApplicationModel() {
                super(1);
            }

            @Nullable
            private String m14831j() {
                this.f14624d = super.a(this.f14624d, 0);
                return this.f14624d;
            }

            @Nullable
            public final String m14834a() {
                return m14831j();
            }

            public final int jK_() {
                return -1072845520;
            }

            public final GraphQLVisitableModel m14833a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m14832a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m14831j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: eaten_fb4a */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AppRequestUnblockApplicationCoreMutationFieldsModel.class, new Deserializer());
            }

            public Object m14835a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = AppRequestUnblockApplicationCoreMutationFieldsParser.m14867a(jsonParser);
                Object appRequestUnblockApplicationCoreMutationFieldsModel = new AppRequestUnblockApplicationCoreMutationFieldsModel();
                ((BaseModel) appRequestUnblockApplicationCoreMutationFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (appRequestUnblockApplicationCoreMutationFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) appRequestUnblockApplicationCoreMutationFieldsModel).a();
                }
                return appRequestUnblockApplicationCoreMutationFieldsModel;
            }
        }

        /* compiled from: eaten_fb4a */
        public class Serializer extends JsonSerializer<AppRequestUnblockApplicationCoreMutationFieldsModel> {
            public final void m14836a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                AppRequestUnblockApplicationCoreMutationFieldsModel appRequestUnblockApplicationCoreMutationFieldsModel = (AppRequestUnblockApplicationCoreMutationFieldsModel) obj;
                if (appRequestUnblockApplicationCoreMutationFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(appRequestUnblockApplicationCoreMutationFieldsModel.m14838a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    appRequestUnblockApplicationCoreMutationFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = appRequestUnblockApplicationCoreMutationFieldsModel.w_();
                int u_ = appRequestUnblockApplicationCoreMutationFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("application");
                    AppRequestUnblockApplicationCoreMutationFieldsParser.ApplicationParser.m14866a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(AppRequestUnblockApplicationCoreMutationFieldsModel.class, new Serializer());
            }
        }

        public AppRequestUnblockApplicationCoreMutationFieldsModel() {
            super(1);
        }

        @Nullable
        private ApplicationModel m14837a() {
            this.f14625d = (ApplicationModel) super.a(this.f14625d, 0, ApplicationModel.class);
            return this.f14625d;
        }

        public final int jK_() {
            return 625256402;
        }

        public final GraphQLVisitableModel m14839a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m14837a() != null) {
                ApplicationModel applicationModel = (ApplicationModel) graphQLModelMutatingVisitor.b(m14837a());
                if (m14837a() != applicationModel) {
                    graphQLVisitableModel = (AppRequestUnblockApplicationCoreMutationFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f14625d = applicationModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m14838a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m14837a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -423801099)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: eaten_fb4a */
    public final class AppRequestUnblockUserCoreMutationFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private UserModel f14627d;

        /* compiled from: eaten_fb4a */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AppRequestUnblockUserCoreMutationFragmentModel.class, new Deserializer());
            }

            public Object m14840a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = AppRequestUnblockUserCoreMutationFragmentParser.m14870a(jsonParser);
                Object appRequestUnblockUserCoreMutationFragmentModel = new AppRequestUnblockUserCoreMutationFragmentModel();
                ((BaseModel) appRequestUnblockUserCoreMutationFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (appRequestUnblockUserCoreMutationFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) appRequestUnblockUserCoreMutationFragmentModel).a();
                }
                return appRequestUnblockUserCoreMutationFragmentModel;
            }
        }

        /* compiled from: eaten_fb4a */
        public class Serializer extends JsonSerializer<AppRequestUnblockUserCoreMutationFragmentModel> {
            public final void m14841a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                AppRequestUnblockUserCoreMutationFragmentModel appRequestUnblockUserCoreMutationFragmentModel = (AppRequestUnblockUserCoreMutationFragmentModel) obj;
                if (appRequestUnblockUserCoreMutationFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(appRequestUnblockUserCoreMutationFragmentModel.m14851a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    appRequestUnblockUserCoreMutationFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = appRequestUnblockUserCoreMutationFragmentModel.w_();
                int u_ = appRequestUnblockUserCoreMutationFragmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("user");
                    AppRequestUnblockUserCoreMutationFragmentParser.UserParser.m14869a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(AppRequestUnblockUserCoreMutationFragmentModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: eaten_fb4a */
        public final class UserModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f14626d;

            /* compiled from: eaten_fb4a */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(UserModel.class, new Deserializer());
                }

                public Object m14842a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AppRequestUnblockUserCoreMutationFragmentParser.UserParser.m14868a(jsonParser, flatBufferBuilder));
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

            /* compiled from: eaten_fb4a */
            public class Serializer extends JsonSerializer<UserModel> {
                public final void m14843a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    UserModel userModel = (UserModel) obj;
                    if (userModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(userModel.m14845a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        userModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AppRequestUnblockUserCoreMutationFragmentParser.UserParser.m14869a(userModel.w_(), userModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(UserModel.class, new Serializer());
                }
            }

            public UserModel() {
                super(1);
            }

            public final void m14848a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m14849a(String str, Object obj, boolean z) {
            }

            @Nullable
            private String m14844j() {
                this.f14626d = super.a(this.f14626d, 0);
                return this.f14626d;
            }

            @Nullable
            public final String m14847a() {
                return m14844j();
            }

            public final int jK_() {
                return 2645995;
            }

            public final GraphQLVisitableModel m14846a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m14845a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m14844j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        public AppRequestUnblockUserCoreMutationFragmentModel() {
            super(1);
        }

        @Nullable
        private UserModel m14850a() {
            this.f14627d = (UserModel) super.a(this.f14627d, 0, UserModel.class);
            return this.f14627d;
        }

        public final int jK_() {
            return -212929747;
        }

        public final GraphQLVisitableModel m14852a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m14850a() != null) {
                UserModel userModel = (UserModel) graphQLModelMutatingVisitor.b(m14850a());
                if (m14850a() != userModel) {
                    graphQLVisitableModel = (AppRequestUnblockUserCoreMutationFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f14627d = userModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m14851a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m14850a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}

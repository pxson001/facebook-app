package com.facebook.messaging.business.nativesignup.graphql;

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
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.messaging.business.nativesignup.graphql.NativeSignUpQueryParsers.NativeSignUpNewUserSignUpQueryParser;
import com.facebook.messaging.business.nativesignup.graphql.NativeSignUpQueryParsers.NativeSignUpNewUserSignUpQueryParser.MessengerCommerceParser;
import com.facebook.messaging.business.nativesignup.graphql.NativeSignUpQueryParsers.NativeSignUpNewUserSignUpQueryParser.MessengerCommerceParser.NewUserSignupParser;
import com.facebook.messaging.business.nativesignup.graphql.NativeSignUpQueryParsers.NativeSignUpNewUserSignUpQueryParser.MessengerCommerceParser.NewUserSignupParser.PermissionsAvatarParser;
import com.facebook.messaging.business.nativesignup.graphql.NativeSignUpQueryParsers.NativeSignUpNewUserSignUpQueryParser.MessengerCommerceParser.NewUserSignupParser.ServiceIntroImageParser;
import com.facebook.messaging.business.nativesignup.graphql.NativeSignUpQueryParsers.NativeSignUpNewUserSignUpQueryParser.MessengerCommerceParser.NewUserSignupParser.ServiceIntroLogoParser;
import com.facebook.messaging.business.nativesignup.graphql.NativeSignUpQueryParsers.PhoneNumberInfoParser;
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

/* compiled from: naiSuffix */
public class NativeSignUpQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1136770851)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: naiSuffix */
    public final class NativeSignUpNewUserSignUpQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f8857d;
        @Nullable
        private MessengerCommerceModel f8858e;

        /* compiled from: naiSuffix */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(NativeSignUpNewUserSignUpQueryModel.class, new Deserializer());
            }

            public Object m9056a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = NativeSignUpNewUserSignUpQueryParser.m9140a(jsonParser);
                Object nativeSignUpNewUserSignUpQueryModel = new NativeSignUpNewUserSignUpQueryModel();
                ((BaseModel) nativeSignUpNewUserSignUpQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (nativeSignUpNewUserSignUpQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) nativeSignUpNewUserSignUpQueryModel).a();
                }
                return nativeSignUpNewUserSignUpQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 365135305)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: naiSuffix */
        public final class MessengerCommerceModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private NewUserSignupModel f8856d;

            /* compiled from: naiSuffix */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MessengerCommerceModel.class, new Deserializer());
                }

                public Object m9057a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MessengerCommerceParser.m9138a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object messengerCommerceModel = new MessengerCommerceModel();
                    ((BaseModel) messengerCommerceModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (messengerCommerceModel instanceof Postprocessable) {
                        return ((Postprocessable) messengerCommerceModel).a();
                    }
                    return messengerCommerceModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1093760140)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: naiSuffix */
            public final class NewUserSignupModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f8827A;
                @Nullable
                private String f8828B;
                @Nullable
                private String f8829C;
                @Nullable
                private String f8830D;
                @Nullable
                private String f8831E;
                @Nullable
                private PhoneNumberInfoModel f8832F;
                @Nullable
                private String f8833d;
                @Nullable
                private String f8834e;
                @Nullable
                private String f8835f;
                private boolean f8836g;
                @Nullable
                private PermissionsAvatarModel f8837h;
                @Nullable
                private String f8838i;
                @Nullable
                private List<String> f8839j;
                @Nullable
                private String f8840k;
                @Nullable
                private List<String> f8841l;
                @Nullable
                private String f8842m;
                @Nullable
                private List<String> f8843n;
                @Nullable
                private String f8844o;
                @Nullable
                private List<String> f8845p;
                @Nullable
                private String f8846q;
                @Nullable
                private List<String> f8847r;
                @Nullable
                private String f8848s;
                @Nullable
                private String f8849t;
                @Nullable
                private String f8850u;
                @Nullable
                private String f8851v;
                @Nullable
                private String f8852w;
                @Nullable
                private ServiceIntroImageModel f8853x;
                @Nullable
                private ServiceIntroLogoModel f8854y;
                @Nullable
                private String f8855z;

                /* compiled from: naiSuffix */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NewUserSignupModel.class, new Deserializer());
                    }

                    public Object m9058a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NewUserSignupParser.m9136a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object newUserSignupModel = new NewUserSignupModel();
                        ((BaseModel) newUserSignupModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (newUserSignupModel instanceof Postprocessable) {
                            return ((Postprocessable) newUserSignupModel).a();
                        }
                        return newUserSignupModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 842551240)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: naiSuffix */
                public final class PermissionsAvatarModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f8822d;

                    /* compiled from: naiSuffix */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(PermissionsAvatarModel.class, new Deserializer());
                        }

                        public Object m9059a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(PermissionsAvatarParser.m9130a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object permissionsAvatarModel = new PermissionsAvatarModel();
                            ((BaseModel) permissionsAvatarModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (permissionsAvatarModel instanceof Postprocessable) {
                                return ((Postprocessable) permissionsAvatarModel).a();
                            }
                            return permissionsAvatarModel;
                        }
                    }

                    /* compiled from: naiSuffix */
                    public class Serializer extends JsonSerializer<PermissionsAvatarModel> {
                        public final void m9060a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            PermissionsAvatarModel permissionsAvatarModel = (PermissionsAvatarModel) obj;
                            if (permissionsAvatarModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(permissionsAvatarModel.m9061a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                permissionsAvatarModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            PermissionsAvatarParser.m9131a(permissionsAvatarModel.w_(), permissionsAvatarModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(PermissionsAvatarModel.class, new Serializer());
                        }
                    }

                    public PermissionsAvatarModel() {
                        super(1);
                    }

                    @Nullable
                    public final String m9063a() {
                        this.f8822d = super.a(this.f8822d, 0);
                        return this.f8822d;
                    }

                    public final int jK_() {
                        return 70760763;
                    }

                    public final GraphQLVisitableModel m9062a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m9061a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m9063a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: naiSuffix */
                public class Serializer extends JsonSerializer<NewUserSignupModel> {
                    public final void m9064a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NewUserSignupModel newUserSignupModel = (NewUserSignupModel) obj;
                        if (newUserSignupModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(newUserSignupModel.m9086a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            newUserSignupModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NewUserSignupParser.m9137a(newUserSignupModel.w_(), newUserSignupModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NewUserSignupModel.class, new Serializer());
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 729935302)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: naiSuffix */
                public final class ServiceIntroImageModel extends BaseModel implements GraphQLVisitableModel {
                    private int f8823d;
                    @Nullable
                    private String f8824e;
                    private int f8825f;

                    /* compiled from: naiSuffix */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(ServiceIntroImageModel.class, new Deserializer());
                        }

                        public Object m9065a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(ServiceIntroImageParser.m9132a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object serviceIntroImageModel = new ServiceIntroImageModel();
                            ((BaseModel) serviceIntroImageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (serviceIntroImageModel instanceof Postprocessable) {
                                return ((Postprocessable) serviceIntroImageModel).a();
                            }
                            return serviceIntroImageModel;
                        }
                    }

                    /* compiled from: naiSuffix */
                    public class Serializer extends JsonSerializer<ServiceIntroImageModel> {
                        public final void m9066a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            ServiceIntroImageModel serviceIntroImageModel = (ServiceIntroImageModel) obj;
                            if (serviceIntroImageModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(serviceIntroImageModel.m9068a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                serviceIntroImageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            ServiceIntroImageParser.m9133a(serviceIntroImageModel.w_(), serviceIntroImageModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(ServiceIntroImageModel.class, new Serializer());
                        }
                    }

                    public ServiceIntroImageModel() {
                        super(3);
                    }

                    public final int m9067a() {
                        a(0, 0);
                        return this.f8823d;
                    }

                    @Nullable
                    public final String m9071b() {
                        this.f8824e = super.a(this.f8824e, 1);
                        return this.f8824e;
                    }

                    public final int m9072c() {
                        a(0, 2);
                        return this.f8825f;
                    }

                    public final int jK_() {
                        return 70760763;
                    }

                    public final GraphQLVisitableModel m9069a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m9068a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m9071b());
                        flatBufferBuilder.c(3);
                        flatBufferBuilder.a(0, this.f8823d, 0);
                        flatBufferBuilder.b(1, b);
                        flatBufferBuilder.a(2, this.f8825f, 0);
                        i();
                        return flatBufferBuilder.d();
                    }

                    public final void m9070a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                        super.a(mutableFlatBuffer, i, obj);
                        this.f8823d = mutableFlatBuffer.a(i, 0, 0);
                        this.f8825f = mutableFlatBuffer.a(i, 2, 0);
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 842551240)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: naiSuffix */
                public final class ServiceIntroLogoModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f8826d;

                    /* compiled from: naiSuffix */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(ServiceIntroLogoModel.class, new Deserializer());
                        }

                        public Object m9073a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(ServiceIntroLogoParser.m9134a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object serviceIntroLogoModel = new ServiceIntroLogoModel();
                            ((BaseModel) serviceIntroLogoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (serviceIntroLogoModel instanceof Postprocessable) {
                                return ((Postprocessable) serviceIntroLogoModel).a();
                            }
                            return serviceIntroLogoModel;
                        }
                    }

                    /* compiled from: naiSuffix */
                    public class Serializer extends JsonSerializer<ServiceIntroLogoModel> {
                        public final void m9074a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            ServiceIntroLogoModel serviceIntroLogoModel = (ServiceIntroLogoModel) obj;
                            if (serviceIntroLogoModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(serviceIntroLogoModel.m9075a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                serviceIntroLogoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            ServiceIntroLogoParser.m9135a(serviceIntroLogoModel.w_(), serviceIntroLogoModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(ServiceIntroLogoModel.class, new Serializer());
                        }
                    }

                    public ServiceIntroLogoModel() {
                        super(1);
                    }

                    @Nullable
                    public final String m9077a() {
                        this.f8826d = super.a(this.f8826d, 0);
                        return this.f8826d;
                    }

                    public final int jK_() {
                        return 70760763;
                    }

                    public final GraphQLVisitableModel m9076a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m9075a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m9077a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                @Nullable
                public final /* synthetic */ PermissionsAvatarModel m9092d() {
                    return m9079B();
                }

                @Nullable
                public final /* synthetic */ ServiceIntroImageModel m9103s() {
                    return m9082E();
                }

                @Nullable
                public final /* synthetic */ ServiceIntroLogoModel m9104t() {
                    return m9083F();
                }

                @Nullable
                public final /* synthetic */ PhoneNumberInfoModel m9110z() {
                    return m9085H();
                }

                public NewUserSignupModel() {
                    super(29);
                }

                @Nullable
                private String m9078A() {
                    this.f8833d = super.a(this.f8833d, 0);
                    return this.f8833d;
                }

                @Nullable
                public final String m9088a() {
                    this.f8834e = super.a(this.f8834e, 1);
                    return this.f8834e;
                }

                @Nullable
                public final String m9090b() {
                    this.f8835f = super.a(this.f8835f, 2);
                    return this.f8835f;
                }

                public final boolean m9091c() {
                    a(0, 3);
                    return this.f8836g;
                }

                @Nullable
                private PermissionsAvatarModel m9079B() {
                    this.f8837h = (PermissionsAvatarModel) super.a(this.f8837h, 4, PermissionsAvatarModel.class);
                    return this.f8837h;
                }

                @Nullable
                private String m9080C() {
                    this.f8838i = super.a(this.f8838i, 5);
                    return this.f8838i;
                }

                @Nonnull
                public final ImmutableList<String> lS_() {
                    this.f8839j = super.a(this.f8839j, 6);
                    return (ImmutableList) this.f8839j;
                }

                @Nullable
                public final String m9093g() {
                    this.f8840k = super.a(this.f8840k, 7);
                    return this.f8840k;
                }

                @Nonnull
                public final ImmutableList<String> lT_() {
                    this.f8841l = super.a(this.f8841l, 8);
                    return (ImmutableList) this.f8841l;
                }

                @Nullable
                public final String lU_() {
                    this.f8842m = super.a(this.f8842m, 9);
                    return this.f8842m;
                }

                @Nonnull
                public final ImmutableList<String> m9094j() {
                    this.f8843n = super.a(this.f8843n, 10);
                    return (ImmutableList) this.f8843n;
                }

                @Nullable
                public final String m9095k() {
                    this.f8844o = super.a(this.f8844o, 11);
                    return this.f8844o;
                }

                @Nonnull
                public final ImmutableList<String> m9096l() {
                    this.f8845p = super.a(this.f8845p, 12);
                    return (ImmutableList) this.f8845p;
                }

                @Nullable
                public final String m9097m() {
                    this.f8846q = super.a(this.f8846q, 13);
                    return this.f8846q;
                }

                @Nonnull
                public final ImmutableList<String> m9098n() {
                    this.f8847r = super.a(this.f8847r, 14);
                    return (ImmutableList) this.f8847r;
                }

                @Nullable
                private String m9081D() {
                    this.f8848s = super.a(this.f8848s, 15);
                    return this.f8848s;
                }

                @Nullable
                public final String m9099o() {
                    this.f8849t = super.a(this.f8849t, 16);
                    return this.f8849t;
                }

                @Nullable
                public final String m9100p() {
                    this.f8850u = super.a(this.f8850u, 17);
                    return this.f8850u;
                }

                @Nullable
                public final String m9101q() {
                    this.f8851v = super.a(this.f8851v, 18);
                    return this.f8851v;
                }

                @Nullable
                public final String m9102r() {
                    this.f8852w = super.a(this.f8852w, 19);
                    return this.f8852w;
                }

                @Nullable
                private ServiceIntroImageModel m9082E() {
                    this.f8853x = (ServiceIntroImageModel) super.a(this.f8853x, 20, ServiceIntroImageModel.class);
                    return this.f8853x;
                }

                @Nullable
                private ServiceIntroLogoModel m9083F() {
                    this.f8854y = (ServiceIntroLogoModel) super.a(this.f8854y, 21, ServiceIntroLogoModel.class);
                    return this.f8854y;
                }

                @Nullable
                public final String m9105u() {
                    this.f8855z = super.a(this.f8855z, 22);
                    return this.f8855z;
                }

                @Nullable
                public final String m9106v() {
                    this.f8827A = super.a(this.f8827A, 23);
                    return this.f8827A;
                }

                @Nullable
                public final String m9107w() {
                    this.f8828B = super.a(this.f8828B, 24);
                    return this.f8828B;
                }

                @Nullable
                public final String m9108x() {
                    this.f8829C = super.a(this.f8829C, 25);
                    return this.f8829C;
                }

                @Nullable
                public final String m9109y() {
                    this.f8830D = super.a(this.f8830D, 26);
                    return this.f8830D;
                }

                @Nullable
                private String m9084G() {
                    this.f8831E = super.a(this.f8831E, 27);
                    return this.f8831E;
                }

                @Nullable
                private PhoneNumberInfoModel m9085H() {
                    this.f8832F = (PhoneNumberInfoModel) super.a(this.f8832F, 28, PhoneNumberInfoModel.class);
                    return this.f8832F;
                }

                public final int jK_() {
                    return 793004103;
                }

                public final GraphQLVisitableModel m9087a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m9079B() != null) {
                        PermissionsAvatarModel permissionsAvatarModel = (PermissionsAvatarModel) graphQLModelMutatingVisitor.b(m9079B());
                        if (m9079B() != permissionsAvatarModel) {
                            graphQLVisitableModel = (NewUserSignupModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f8837h = permissionsAvatarModel;
                        }
                    }
                    if (m9082E() != null) {
                        ServiceIntroImageModel serviceIntroImageModel = (ServiceIntroImageModel) graphQLModelMutatingVisitor.b(m9082E());
                        if (m9082E() != serviceIntroImageModel) {
                            graphQLVisitableModel = (NewUserSignupModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f8853x = serviceIntroImageModel;
                        }
                    }
                    if (m9083F() != null) {
                        ServiceIntroLogoModel serviceIntroLogoModel = (ServiceIntroLogoModel) graphQLModelMutatingVisitor.b(m9083F());
                        if (m9083F() != serviceIntroLogoModel) {
                            graphQLVisitableModel = (NewUserSignupModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f8854y = serviceIntroLogoModel;
                        }
                    }
                    if (m9085H() != null) {
                        PhoneNumberInfoModel phoneNumberInfoModel = (PhoneNumberInfoModel) graphQLModelMutatingVisitor.b(m9085H());
                        if (m9085H() != phoneNumberInfoModel) {
                            graphQLVisitableModel = (NewUserSignupModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f8832F = phoneNumberInfoModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m9086a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m9078A());
                    int b2 = flatBufferBuilder.b(m9088a());
                    int b3 = flatBufferBuilder.b(m9090b());
                    int a = ModelHelper.a(flatBufferBuilder, m9079B());
                    int b4 = flatBufferBuilder.b(m9080C());
                    int c = flatBufferBuilder.c(lS_());
                    int b5 = flatBufferBuilder.b(m9093g());
                    int c2 = flatBufferBuilder.c(lT_());
                    int b6 = flatBufferBuilder.b(lU_());
                    int c3 = flatBufferBuilder.c(m9094j());
                    int b7 = flatBufferBuilder.b(m9095k());
                    int c4 = flatBufferBuilder.c(m9096l());
                    int b8 = flatBufferBuilder.b(m9097m());
                    int c5 = flatBufferBuilder.c(m9098n());
                    int b9 = flatBufferBuilder.b(m9081D());
                    int b10 = flatBufferBuilder.b(m9099o());
                    int b11 = flatBufferBuilder.b(m9100p());
                    int b12 = flatBufferBuilder.b(m9101q());
                    int b13 = flatBufferBuilder.b(m9102r());
                    int a2 = ModelHelper.a(flatBufferBuilder, m9082E());
                    int a3 = ModelHelper.a(flatBufferBuilder, m9083F());
                    int b14 = flatBufferBuilder.b(m9105u());
                    int b15 = flatBufferBuilder.b(m9106v());
                    int b16 = flatBufferBuilder.b(m9107w());
                    int b17 = flatBufferBuilder.b(m9108x());
                    int b18 = flatBufferBuilder.b(m9109y());
                    int b19 = flatBufferBuilder.b(m9084G());
                    int a4 = ModelHelper.a(flatBufferBuilder, m9085H());
                    flatBufferBuilder.c(29);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, b2);
                    flatBufferBuilder.b(2, b3);
                    flatBufferBuilder.a(3, this.f8836g);
                    flatBufferBuilder.b(4, a);
                    flatBufferBuilder.b(5, b4);
                    flatBufferBuilder.b(6, c);
                    flatBufferBuilder.b(7, b5);
                    flatBufferBuilder.b(8, c2);
                    flatBufferBuilder.b(9, b6);
                    flatBufferBuilder.b(10, c3);
                    flatBufferBuilder.b(11, b7);
                    flatBufferBuilder.b(12, c4);
                    flatBufferBuilder.b(13, b8);
                    flatBufferBuilder.b(14, c5);
                    flatBufferBuilder.b(15, b9);
                    flatBufferBuilder.b(16, b10);
                    flatBufferBuilder.b(17, b11);
                    flatBufferBuilder.b(18, b12);
                    flatBufferBuilder.b(19, b13);
                    flatBufferBuilder.b(20, a2);
                    flatBufferBuilder.b(21, a3);
                    flatBufferBuilder.b(22, b14);
                    flatBufferBuilder.b(23, b15);
                    flatBufferBuilder.b(24, b16);
                    flatBufferBuilder.b(25, b17);
                    flatBufferBuilder.b(26, b18);
                    flatBufferBuilder.b(27, b19);
                    flatBufferBuilder.b(28, a4);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m9089a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f8836g = mutableFlatBuffer.a(i, 3);
                }
            }

            /* compiled from: naiSuffix */
            public class Serializer extends JsonSerializer<MessengerCommerceModel> {
                public final void m9111a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MessengerCommerceModel messengerCommerceModel = (MessengerCommerceModel) obj;
                    if (messengerCommerceModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(messengerCommerceModel.m9112a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        messengerCommerceModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MessengerCommerceParser.m9139a(messengerCommerceModel.w_(), messengerCommerceModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(MessengerCommerceModel.class, new Serializer());
                }
            }

            public MessengerCommerceModel() {
                super(1);
            }

            @Nullable
            public final NewUserSignupModel m9114a() {
                this.f8856d = (NewUserSignupModel) super.a(this.f8856d, 0, NewUserSignupModel.class);
                return this.f8856d;
            }

            public final int jK_() {
                return -1387886866;
            }

            public final GraphQLVisitableModel m9113a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m9114a() != null) {
                    NewUserSignupModel newUserSignupModel = (NewUserSignupModel) graphQLModelMutatingVisitor.b(m9114a());
                    if (m9114a() != newUserSignupModel) {
                        graphQLVisitableModel = (MessengerCommerceModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f8856d = newUserSignupModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m9112a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m9114a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: naiSuffix */
        public class Serializer extends JsonSerializer<NativeSignUpNewUserSignUpQueryModel> {
            public final void m9115a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                NativeSignUpNewUserSignUpQueryModel nativeSignUpNewUserSignUpQueryModel = (NativeSignUpNewUserSignUpQueryModel) obj;
                if (nativeSignUpNewUserSignUpQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(nativeSignUpNewUserSignUpQueryModel.m9117a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    nativeSignUpNewUserSignUpQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = nativeSignUpNewUserSignUpQueryModel.w_();
                int u_ = nativeSignUpNewUserSignUpQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("messenger_commerce");
                    MessengerCommerceParser.m9139a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(NativeSignUpNewUserSignUpQueryModel.class, new Serializer());
            }
        }

        public NativeSignUpNewUserSignUpQueryModel() {
            super(2);
        }

        public final void m9120a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m9121a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m9116j() {
            if (this.b != null && this.f8857d == null) {
                this.f8857d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f8857d;
        }

        @Nullable
        public final MessengerCommerceModel m9119a() {
            this.f8858e = (MessengerCommerceModel) super.a(this.f8858e, 1, MessengerCommerceModel.class);
            return this.f8858e;
        }

        public final int jK_() {
            return 63093205;
        }

        public final GraphQLVisitableModel m9118a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m9119a() != null) {
                MessengerCommerceModel messengerCommerceModel = (MessengerCommerceModel) graphQLModelMutatingVisitor.b(m9119a());
                if (m9119a() != messengerCommerceModel) {
                    graphQLVisitableModel = (NativeSignUpNewUserSignUpQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8858e = messengerCommerceModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m9117a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m9116j());
            int a2 = ModelHelper.a(flatBufferBuilder, m9119a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 2133079558)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: naiSuffix */
    public final class PhoneNumberInfoModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f8863d;
        @Nullable
        private String f8864e;
        @Nullable
        private String f8865f;
        @Nullable
        private String f8866g;

        /* compiled from: naiSuffix */
        public final class Builder {
            @Nullable
            public String f8859a;
            @Nullable
            public String f8860b;
            @Nullable
            public String f8861c;
            @Nullable
            public String f8862d;
        }

        /* compiled from: naiSuffix */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PhoneNumberInfoModel.class, new Deserializer());
            }

            public Object m9122a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PhoneNumberInfoParser.m9141a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object phoneNumberInfoModel = new PhoneNumberInfoModel();
                ((BaseModel) phoneNumberInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (phoneNumberInfoModel instanceof Postprocessable) {
                    return ((Postprocessable) phoneNumberInfoModel).a();
                }
                return phoneNumberInfoModel;
            }
        }

        /* compiled from: naiSuffix */
        public class Serializer extends JsonSerializer<PhoneNumberInfoModel> {
            public final void m9123a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PhoneNumberInfoModel phoneNumberInfoModel = (PhoneNumberInfoModel) obj;
                if (phoneNumberInfoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(phoneNumberInfoModel.m9126a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    phoneNumberInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PhoneNumberInfoParser.m9142a(phoneNumberInfoModel.w_(), phoneNumberInfoModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(PhoneNumberInfoModel.class, new Serializer());
            }
        }

        public PhoneNumberInfoModel() {
            super(4);
        }

        public PhoneNumberInfoModel(MutableFlatBuffer mutableFlatBuffer) {
            super(4);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        private String m9124j() {
            this.f8863d = super.a(this.f8863d, 0);
            return this.f8863d;
        }

        @Nullable
        public final String m9128a() {
            this.f8864e = super.a(this.f8864e, 1);
            return this.f8864e;
        }

        @Nullable
        private String m9125k() {
            this.f8865f = super.a(this.f8865f, 2);
            return this.f8865f;
        }

        @Nullable
        public final String m9129b() {
            this.f8866g = super.a(this.f8866g, 3);
            return this.f8866g;
        }

        public final int jK_() {
            return 474898999;
        }

        public final GraphQLVisitableModel m9127a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m9126a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m9124j());
            int b2 = flatBufferBuilder.b(m9128a());
            int b3 = flatBufferBuilder.b(m9125k());
            int b4 = flatBufferBuilder.b(m9129b());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, b3);
            flatBufferBuilder.b(3, b4);
            i();
            return flatBufferBuilder.d();
        }
    }
}

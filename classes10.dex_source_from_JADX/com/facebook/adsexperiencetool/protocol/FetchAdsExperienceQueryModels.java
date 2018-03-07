package com.facebook.adsexperiencetool.protocol;

import com.facebook.adsexperiencetool.protocol.FetchAdsExperienceQueryParsers.AdsExperienceFragmentParser;
import com.facebook.adsexperiencetool.protocol.FetchAdsExperienceQueryParsers.AdsExperienceFragmentParser.AdSharedByParser;
import com.facebook.adsexperiencetool.protocol.FetchAdsExperienceQueryParsers.AdsExperienceFragmentParser.AdSharedByParser.ProfilePictureParser;
import com.facebook.adsexperiencetool.protocol.FetchAdsExperienceQueryParsers.AdsExperienceFragmentParser.AdgroupParser;
import com.facebook.adsexperiencetool.protocol.FetchAdsExperienceQueryParsers.AdsExperienceFragmentParser.PageParser;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLAdsExperienceStatusEnum;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
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

/* compiled from: end_age_ms */
public class FetchAdsExperienceQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1962968589)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: end_age_ms */
    public final class AdsExperienceFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private String f14462d;
        @Nullable
        private AdSharedByModel f14463e;
        @Nullable
        private GraphQLAdsExperienceStatusEnum f14464f;
        @Nullable
        private AdgroupModel f14465g;
        @Nullable
        private String f14466h;
        @Nullable
        private PageModel f14467i;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1252161553)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: end_age_ms */
        public final class AdSharedByModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private GraphQLObjectType f14452d;
            @Nullable
            private String f14453e;
            @Nullable
            private String f14454f;
            @Nullable
            private ProfilePictureModel f14455g;

            /* compiled from: end_age_ms */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AdSharedByModel.class, new Deserializer());
                }

                public Object m14597a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AdSharedByParser.m14646a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object adSharedByModel = new AdSharedByModel();
                    ((BaseModel) adSharedByModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (adSharedByModel instanceof Postprocessable) {
                        return ((Postprocessable) adSharedByModel).a();
                    }
                    return adSharedByModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 842551240)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: end_age_ms */
            public final class ProfilePictureModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f14451d;

                /* compiled from: end_age_ms */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ProfilePictureModel.class, new Deserializer());
                    }

                    public Object m14598a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ProfilePictureParser.m14644a(jsonParser, flatBufferBuilder));
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

                /* compiled from: end_age_ms */
                public class Serializer extends JsonSerializer<ProfilePictureModel> {
                    public final void m14599a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ProfilePictureModel profilePictureModel = (ProfilePictureModel) obj;
                        if (profilePictureModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(profilePictureModel.m14601a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            profilePictureModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ProfilePictureParser.m14645a(profilePictureModel.w_(), profilePictureModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(ProfilePictureModel.class, new Serializer());
                    }
                }

                public ProfilePictureModel() {
                    super(1);
                }

                @Nullable
                private String m14600a() {
                    this.f14451d = super.a(this.f14451d, 0);
                    return this.f14451d;
                }

                public final int jK_() {
                    return 70760763;
                }

                public final GraphQLVisitableModel m14602a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m14601a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m14600a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: end_age_ms */
            public class Serializer extends JsonSerializer<AdSharedByModel> {
                public final void m14603a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AdSharedByModel adSharedByModel = (AdSharedByModel) obj;
                    if (adSharedByModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(adSharedByModel.m14608a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        adSharedByModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AdSharedByParser.m14647a(adSharedByModel.w_(), adSharedByModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(AdSharedByModel.class, new Serializer());
                }
            }

            public AdSharedByModel() {
                super(4);
            }

            @Nullable
            private GraphQLObjectType m14604j() {
                if (this.b != null && this.f14452d == null) {
                    this.f14452d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f14452d;
            }

            @Nullable
            private String m14605k() {
                this.f14453e = super.a(this.f14453e, 1);
                return this.f14453e;
            }

            @Nullable
            private String m14606l() {
                this.f14454f = super.a(this.f14454f, 2);
                return this.f14454f;
            }

            @Nullable
            private ProfilePictureModel m14607m() {
                this.f14455g = (ProfilePictureModel) super.a(this.f14455g, 3, ProfilePictureModel.class);
                return this.f14455g;
            }

            @Nullable
            public final String m14610a() {
                return m14605k();
            }

            public final int jK_() {
                return 70063028;
            }

            public final GraphQLVisitableModel m14609a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m14607m() != null) {
                    ProfilePictureModel profilePictureModel = (ProfilePictureModel) graphQLModelMutatingVisitor.b(m14607m());
                    if (m14607m() != profilePictureModel) {
                        graphQLVisitableModel = (AdSharedByModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f14455g = profilePictureModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m14608a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m14604j());
                int b = flatBufferBuilder.b(m14605k());
                int b2 = flatBufferBuilder.b(m14606l());
                int a2 = ModelHelper.a(flatBufferBuilder, m14607m());
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
        @ModelWithFlatBufferFormatHash(a = -1185712657)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: end_age_ms */
        public final class AdgroupModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f14456d;
            @Nullable
            private String f14457e;

            /* compiled from: end_age_ms */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AdgroupModel.class, new Deserializer());
                }

                public Object m14611a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AdgroupParser.m14648a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object adgroupModel = new AdgroupModel();
                    ((BaseModel) adgroupModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (adgroupModel instanceof Postprocessable) {
                        return ((Postprocessable) adgroupModel).a();
                    }
                    return adgroupModel;
                }
            }

            /* compiled from: end_age_ms */
            public class Serializer extends JsonSerializer<AdgroupModel> {
                public final void m14612a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AdgroupModel adgroupModel = (AdgroupModel) obj;
                    if (adgroupModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(adgroupModel.m14615a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        adgroupModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AdgroupParser.m14649a(adgroupModel.w_(), adgroupModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AdgroupModel.class, new Serializer());
                }
            }

            public AdgroupModel() {
                super(2);
            }

            @Nullable
            private String m14613j() {
                this.f14456d = super.a(this.f14456d, 0);
                return this.f14456d;
            }

            @Nullable
            private String m14614k() {
                this.f14457e = super.a(this.f14457e, 1);
                return this.f14457e;
            }

            @Nullable
            public final String m14617a() {
                return m14613j();
            }

            public final int jK_() {
                return 519741468;
            }

            public final GraphQLVisitableModel m14616a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m14615a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m14613j());
                int b2 = flatBufferBuilder.b(m14614k());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: end_age_ms */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AdsExperienceFragmentModel.class, new Deserializer());
            }

            public Object m14618a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = AdsExperienceFragmentParser.m14654a(jsonParser);
                Object adsExperienceFragmentModel = new AdsExperienceFragmentModel();
                ((BaseModel) adsExperienceFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (adsExperienceFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) adsExperienceFragmentModel).a();
                }
                return adsExperienceFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -289673711)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: end_age_ms */
        public final class PageModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f14459d;
            @Nullable
            private String f14460e;
            @Nullable
            private ProfilePictureModel f14461f;

            /* compiled from: end_age_ms */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PageModel.class, new Deserializer());
                }

                public Object m14619a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PageParser.m14652a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object pageModel = new PageModel();
                    ((BaseModel) pageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (pageModel instanceof Postprocessable) {
                        return ((Postprocessable) pageModel).a();
                    }
                    return pageModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 842551240)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: end_age_ms */
            public final class ProfilePictureModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f14458d;

                /* compiled from: end_age_ms */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ProfilePictureModel.class, new Deserializer());
                    }

                    public Object m14620a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(PageParser.ProfilePictureParser.m14650a(jsonParser, flatBufferBuilder));
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

                /* compiled from: end_age_ms */
                public class Serializer extends JsonSerializer<ProfilePictureModel> {
                    public final void m14621a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ProfilePictureModel profilePictureModel = (ProfilePictureModel) obj;
                        if (profilePictureModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(profilePictureModel.m14622a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            profilePictureModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        PageParser.ProfilePictureParser.m14651a(profilePictureModel.w_(), profilePictureModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(ProfilePictureModel.class, new Serializer());
                    }
                }

                public ProfilePictureModel() {
                    super(1);
                }

                @Nullable
                public final String m14624a() {
                    this.f14458d = super.a(this.f14458d, 0);
                    return this.f14458d;
                }

                public final int jK_() {
                    return 70760763;
                }

                public final GraphQLVisitableModel m14623a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m14622a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m14624a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: end_age_ms */
            public class Serializer extends JsonSerializer<PageModel> {
                public final void m14625a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PageModel pageModel = (PageModel) obj;
                    if (pageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pageModel.m14627a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PageParser.m14653a(pageModel.w_(), pageModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PageModel.class, new Serializer());
                }
            }

            public PageModel() {
                super(3);
            }

            public final void m14630a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m14631a(String str, Object obj, boolean z) {
            }

            @Nullable
            private String m14626l() {
                this.f14459d = super.a(this.f14459d, 0);
                return this.f14459d;
            }

            @Nullable
            public final String m14632j() {
                this.f14460e = super.a(this.f14460e, 1);
                return this.f14460e;
            }

            @Nullable
            public final ProfilePictureModel m14633k() {
                this.f14461f = (ProfilePictureModel) super.a(this.f14461f, 2, ProfilePictureModel.class);
                return this.f14461f;
            }

            @Nullable
            public final String m14629a() {
                return m14626l();
            }

            public final int jK_() {
                return 2479791;
            }

            public final GraphQLVisitableModel m14628a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m14633k() != null) {
                    ProfilePictureModel profilePictureModel = (ProfilePictureModel) graphQLModelMutatingVisitor.b(m14633k());
                    if (m14633k() != profilePictureModel) {
                        graphQLVisitableModel = (PageModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f14461f = profilePictureModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m14627a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m14626l());
                int b2 = flatBufferBuilder.b(m14632j());
                int a = ModelHelper.a(flatBufferBuilder, m14633k());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.b(2, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: end_age_ms */
        public class Serializer extends JsonSerializer<AdsExperienceFragmentModel> {
            public final void m14634a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                AdsExperienceFragmentModel adsExperienceFragmentModel = (AdsExperienceFragmentModel) obj;
                if (adsExperienceFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(adsExperienceFragmentModel.m14637a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    adsExperienceFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = adsExperienceFragmentModel.w_();
                int u_ = adsExperienceFragmentModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("ad_preview_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("ad_shared_by");
                    AdSharedByParser.m14647a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("ad_sharing_status");
                    jsonGenerator.b(mutableFlatBuffer.b(u_, 2));
                }
                g = mutableFlatBuffer.g(u_, 3);
                if (g != 0) {
                    jsonGenerator.a("adgroup");
                    AdgroupParser.m14649a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 4) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 4));
                }
                g = mutableFlatBuffer.g(u_, 5);
                if (g != 0) {
                    jsonGenerator.a("page");
                    PageParser.m14653a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(AdsExperienceFragmentModel.class, new Serializer());
            }
        }

        public AdsExperienceFragmentModel() {
            super(6);
        }

        @Nullable
        public final String m14640j() {
            this.f14462d = super.a(this.f14462d, 0);
            return this.f14462d;
        }

        @Nullable
        private AdSharedByModel m14635n() {
            this.f14463e = (AdSharedByModel) super.a(this.f14463e, 1, AdSharedByModel.class);
            return this.f14463e;
        }

        @Nullable
        public final GraphQLAdsExperienceStatusEnum m14641k() {
            this.f14464f = (GraphQLAdsExperienceStatusEnum) super.b(this.f14464f, 2, GraphQLAdsExperienceStatusEnum.class, GraphQLAdsExperienceStatusEnum.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f14464f;
        }

        @Nullable
        private AdgroupModel m14636o() {
            this.f14465g = (AdgroupModel) super.a(this.f14465g, 3, AdgroupModel.class);
            return this.f14465g;
        }

        @Nullable
        public final String m14642l() {
            this.f14466h = super.a(this.f14466h, 4);
            return this.f14466h;
        }

        @Nullable
        public final PageModel m14643m() {
            this.f14467i = (PageModel) super.a(this.f14467i, 5, PageModel.class);
            return this.f14467i;
        }

        @Nullable
        public final String m14639a() {
            return m14642l();
        }

        public final int jK_() {
            return -451034598;
        }

        public final GraphQLVisitableModel m14638a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m14635n() != null) {
                AdSharedByModel adSharedByModel = (AdSharedByModel) graphQLModelMutatingVisitor.b(m14635n());
                if (m14635n() != adSharedByModel) {
                    graphQLVisitableModel = (AdsExperienceFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f14463e = adSharedByModel;
                }
            }
            if (m14636o() != null) {
                AdgroupModel adgroupModel = (AdgroupModel) graphQLModelMutatingVisitor.b(m14636o());
                if (m14636o() != adgroupModel) {
                    graphQLVisitableModel = (AdsExperienceFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f14465g = adgroupModel;
                }
            }
            if (m14643m() != null) {
                PageModel pageModel = (PageModel) graphQLModelMutatingVisitor.b(m14643m());
                if (m14643m() != pageModel) {
                    graphQLVisitableModel = (AdsExperienceFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f14467i = pageModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m14637a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m14640j());
            int a = ModelHelper.a(flatBufferBuilder, m14635n());
            int a2 = flatBufferBuilder.a(m14641k());
            int a3 = ModelHelper.a(flatBufferBuilder, m14636o());
            int b2 = flatBufferBuilder.b(m14642l());
            int a4 = ModelHelper.a(flatBufferBuilder, m14643m());
            flatBufferBuilder.c(6);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.b(4, b2);
            flatBufferBuilder.b(5, a4);
            i();
            return flatBufferBuilder.d();
        }
    }
}

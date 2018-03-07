package com.facebook.vault.momentsupsell.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.FBFullImageFragmentModel;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.vault.momentsupsell.graphql.MomentsUpsellQueryParsers.MomentsAppPhotoFragmentParser;
import com.facebook.vault.momentsupsell.graphql.MomentsUpsellQueryParsers.MomentsAppPromotionFragmentParser;
import com.facebook.vault.momentsupsell.graphql.MomentsUpsellQueryParsers.MomentsAppPromotionFragmentParser.ActionLinkIfMomentsInstalledParser;
import com.facebook.vault.momentsupsell.graphql.MomentsUpsellQueryParsers.MomentsAppPromotionFragmentParser.ActionLinkParser;
import com.facebook.vault.momentsupsell.graphql.MomentsUpsellQueryParsers.MomentsAppPromotionFragmentParser.FacepileUsersParser;
import com.facebook.vault.momentsupsell.graphql.MomentsUpsellQueryParsers.MomentsAppPromotionFragmentParser.FacepileUsersParser.ProfilePictureParser;
import com.facebook.vault.momentsupsell.graphql.MomentsUpsellQueryParsers.MomentsAppPromotionFragmentParser.HelpLinkParser;
import com.facebook.vault.momentsupsell.graphql.MomentsUpsellQueryParsers.MomentsAppPromotionFragmentParser.ImageParser;
import com.facebook.vault.momentsupsell.graphql.MomentsUpsellQueryParsers.MomentsAppPromotionFragmentParser.TitleParser;
import com.facebook.vault.momentsupsell.graphql.MomentsUpsellQueryParsers.MomentsAppPromotionQueryParser;
import com.facebook.vault.momentsupsell.graphql.MomentsUpsellQueryParsers.MomentsAppPromotionQueryParser.MomentsAppSyncedPhotosParser;
import com.facebook.vault.momentsupsell.graphql.MomentsUpsellQueryParsers.MomentsAppPromotionQueryParser.MomentsAppSyncedPhotosParser.EdgesParser;
import com.facebook.vault.momentsupsell.graphql.MomentsUpsellQueryParsers.MomentsAppPromotionQueryParser.VaultParser;
import com.facebook.vault.momentsupsell.graphql.MomentsUpsellQueryParsers.MomentsAppPromotionQueryParser.VaultParser.ImagesParser;
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

/* compiled from: thread_summary_arg */
public class MomentsUpsellQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1251474347)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: thread_summary_arg */
    public final class MomentsAppPhotoFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private String f1729d;
        @Nullable
        private FBFullImageFragmentModel f1730e;

        /* compiled from: thread_summary_arg */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MomentsAppPhotoFragmentModel.class, new Deserializer());
            }

            public Object m1762a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(MomentsAppPhotoFragmentParser.m1872a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object momentsAppPhotoFragmentModel = new MomentsAppPhotoFragmentModel();
                ((BaseModel) momentsAppPhotoFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (momentsAppPhotoFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) momentsAppPhotoFragmentModel).a();
                }
                return momentsAppPhotoFragmentModel;
            }
        }

        /* compiled from: thread_summary_arg */
        public class Serializer extends JsonSerializer<MomentsAppPhotoFragmentModel> {
            public final void m1763a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MomentsAppPhotoFragmentModel momentsAppPhotoFragmentModel = (MomentsAppPhotoFragmentModel) obj;
                if (momentsAppPhotoFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(momentsAppPhotoFragmentModel.m1766a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    momentsAppPhotoFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                MomentsAppPhotoFragmentParser.m1873a(momentsAppPhotoFragmentModel.w_(), momentsAppPhotoFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(MomentsAppPhotoFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ FBFullImageFragmentModel m1769b() {
            return m1765k();
        }

        public MomentsAppPhotoFragmentModel() {
            super(2);
        }

        @Nullable
        private String m1764j() {
            this.f1729d = super.a(this.f1729d, 0);
            return this.f1729d;
        }

        @Nullable
        private FBFullImageFragmentModel m1765k() {
            this.f1730e = (FBFullImageFragmentModel) super.a(this.f1730e, 1, FBFullImageFragmentModel.class);
            return this.f1730e;
        }

        @Nullable
        public final String m1768a() {
            return m1764j();
        }

        public final int jK_() {
            return 468760580;
        }

        public final GraphQLVisitableModel m1767a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1765k() != null) {
                FBFullImageFragmentModel fBFullImageFragmentModel = (FBFullImageFragmentModel) graphQLModelMutatingVisitor.b(m1765k());
                if (m1765k() != fBFullImageFragmentModel) {
                    graphQLVisitableModel = (MomentsAppPhotoFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1730e = fBFullImageFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1766a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m1764j());
            int a = ModelHelper.a(flatBufferBuilder, m1765k());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1605936535)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: thread_summary_arg */
    public final class MomentsAppPromotionFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ActionLinkModel f1745d;
        @Nullable
        private ActionLinkIfMomentsInstalledModel f1746e;
        private boolean f1747f;
        private int f1748g;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f1749h;
        @Nullable
        private List<FacepileUsersModel> f1750i;
        @Nullable
        private HelpLinkModel f1751j;
        @Nullable
        private ImageModel f1752k;
        private boolean f1753l;
        private boolean f1754m;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f1755n;
        @Nullable
        private TitleModel f1756o;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1134676274)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: thread_summary_arg */
        public final class ActionLinkIfMomentsInstalledModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private GraphQLObjectType f1731d;
            @Nullable
            private String f1732e;
            @Nullable
            private String f1733f;

            /* compiled from: thread_summary_arg */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ActionLinkIfMomentsInstalledModel.class, new Deserializer());
                }

                public Object m1770a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ActionLinkIfMomentsInstalledParser.m1874a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object actionLinkIfMomentsInstalledModel = new ActionLinkIfMomentsInstalledModel();
                    ((BaseModel) actionLinkIfMomentsInstalledModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (actionLinkIfMomentsInstalledModel instanceof Postprocessable) {
                        return ((Postprocessable) actionLinkIfMomentsInstalledModel).a();
                    }
                    return actionLinkIfMomentsInstalledModel;
                }
            }

            /* compiled from: thread_summary_arg */
            public class Serializer extends JsonSerializer<ActionLinkIfMomentsInstalledModel> {
                public final void m1771a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ActionLinkIfMomentsInstalledModel actionLinkIfMomentsInstalledModel = (ActionLinkIfMomentsInstalledModel) obj;
                    if (actionLinkIfMomentsInstalledModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(actionLinkIfMomentsInstalledModel.m1773a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        actionLinkIfMomentsInstalledModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ActionLinkIfMomentsInstalledParser.m1875a(actionLinkIfMomentsInstalledModel.w_(), actionLinkIfMomentsInstalledModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ActionLinkIfMomentsInstalledModel.class, new Serializer());
                }
            }

            public ActionLinkIfMomentsInstalledModel() {
                super(3);
            }

            @Nullable
            private GraphQLObjectType m1772j() {
                if (this.b != null && this.f1731d == null) {
                    this.f1731d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f1731d;
            }

            @Nullable
            public final String m1775a() {
                this.f1732e = super.a(this.f1732e, 1);
                return this.f1732e;
            }

            @Nullable
            public final String m1776b() {
                this.f1733f = super.a(this.f1733f, 2);
                return this.f1733f;
            }

            public final int jK_() {
                return -1747569147;
            }

            public final GraphQLVisitableModel m1774a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m1773a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m1772j());
                int b = flatBufferBuilder.b(m1775a());
                int b2 = flatBufferBuilder.b(m1776b());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1134676274)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: thread_summary_arg */
        public final class ActionLinkModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private GraphQLObjectType f1734d;
            @Nullable
            private String f1735e;
            @Nullable
            private String f1736f;

            /* compiled from: thread_summary_arg */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ActionLinkModel.class, new Deserializer());
                }

                public Object m1777a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ActionLinkParser.m1876a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object actionLinkModel = new ActionLinkModel();
                    ((BaseModel) actionLinkModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (actionLinkModel instanceof Postprocessable) {
                        return ((Postprocessable) actionLinkModel).a();
                    }
                    return actionLinkModel;
                }
            }

            /* compiled from: thread_summary_arg */
            public class Serializer extends JsonSerializer<ActionLinkModel> {
                public final void m1778a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ActionLinkModel actionLinkModel = (ActionLinkModel) obj;
                    if (actionLinkModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(actionLinkModel.m1780a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        actionLinkModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ActionLinkParser.m1877a(actionLinkModel.w_(), actionLinkModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ActionLinkModel.class, new Serializer());
                }
            }

            public ActionLinkModel() {
                super(3);
            }

            @Nullable
            private GraphQLObjectType m1779j() {
                if (this.b != null && this.f1734d == null) {
                    this.f1734d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f1734d;
            }

            @Nullable
            public final String m1782a() {
                this.f1735e = super.a(this.f1735e, 1);
                return this.f1735e;
            }

            @Nullable
            public final String m1783b() {
                this.f1736f = super.a(this.f1736f, 2);
                return this.f1736f;
            }

            public final int jK_() {
                return -1747569147;
            }

            public final GraphQLVisitableModel m1781a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m1780a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m1779j());
                int b = flatBufferBuilder.b(m1782a());
                int b2 = flatBufferBuilder.b(m1783b());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: thread_summary_arg */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MomentsAppPromotionFragmentModel.class, new Deserializer());
            }

            public Object m1784a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(MomentsAppPromotionFragmentParser.m1889a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object momentsAppPromotionFragmentModel = new MomentsAppPromotionFragmentModel();
                ((BaseModel) momentsAppPromotionFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (momentsAppPromotionFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) momentsAppPromotionFragmentModel).a();
                }
                return momentsAppPromotionFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 402705085)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: thread_summary_arg */
        public final class FacepileUsersModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f1738d;
            @Nullable
            private ProfilePictureModel f1739e;

            /* compiled from: thread_summary_arg */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FacepileUsersModel.class, new Deserializer());
                }

                public Object m1785a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FacepileUsersParser.m1881b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object facepileUsersModel = new FacepileUsersModel();
                    ((BaseModel) facepileUsersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (facepileUsersModel instanceof Postprocessable) {
                        return ((Postprocessable) facepileUsersModel).a();
                    }
                    return facepileUsersModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 842551240)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: thread_summary_arg */
            public final class ProfilePictureModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f1737d;

                /* compiled from: thread_summary_arg */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ProfilePictureModel.class, new Deserializer());
                    }

                    public Object m1786a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ProfilePictureParser.m1878a(jsonParser, flatBufferBuilder));
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

                /* compiled from: thread_summary_arg */
                public class Serializer extends JsonSerializer<ProfilePictureModel> {
                    public final void m1787a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ProfilePictureModel profilePictureModel = (ProfilePictureModel) obj;
                        if (profilePictureModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(profilePictureModel.m1788a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            profilePictureModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ProfilePictureParser.m1879a(profilePictureModel.w_(), profilePictureModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(ProfilePictureModel.class, new Serializer());
                    }
                }

                public ProfilePictureModel() {
                    super(1);
                }

                @Nullable
                public final String m1790a() {
                    this.f1737d = super.a(this.f1737d, 0);
                    return this.f1737d;
                }

                public final int jK_() {
                    return 70760763;
                }

                public final GraphQLVisitableModel m1789a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m1788a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m1790a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: thread_summary_arg */
            public class Serializer extends JsonSerializer<FacepileUsersModel> {
                public final void m1791a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FacepileUsersModel facepileUsersModel = (FacepileUsersModel) obj;
                    if (facepileUsersModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(facepileUsersModel.m1794a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        facepileUsersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FacepileUsersParser.m1882b(facepileUsersModel.w_(), facepileUsersModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(FacepileUsersModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ ProfilePictureModel m1799b() {
                return m1793k();
            }

            public FacepileUsersModel() {
                super(2);
            }

            public final void m1797a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m1798a(String str, Object obj, boolean z) {
            }

            @Nullable
            private String m1792j() {
                this.f1738d = super.a(this.f1738d, 0);
                return this.f1738d;
            }

            @Nullable
            private ProfilePictureModel m1793k() {
                this.f1739e = (ProfilePictureModel) super.a(this.f1739e, 1, ProfilePictureModel.class);
                return this.f1739e;
            }

            @Nullable
            public final String m1796a() {
                return m1792j();
            }

            public final int jK_() {
                return 2645995;
            }

            public final GraphQLVisitableModel m1795a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m1793k() != null) {
                    ProfilePictureModel profilePictureModel = (ProfilePictureModel) graphQLModelMutatingVisitor.b(m1793k());
                    if (m1793k() != profilePictureModel) {
                        graphQLVisitableModel = (FacepileUsersModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f1739e = profilePictureModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m1794a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m1792j());
                int a = ModelHelper.a(flatBufferBuilder, m1793k());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1134676274)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: thread_summary_arg */
        public final class HelpLinkModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private GraphQLObjectType f1740d;
            @Nullable
            private String f1741e;
            @Nullable
            private String f1742f;

            /* compiled from: thread_summary_arg */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(HelpLinkModel.class, new Deserializer());
                }

                public Object m1800a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(HelpLinkParser.m1883a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object helpLinkModel = new HelpLinkModel();
                    ((BaseModel) helpLinkModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (helpLinkModel instanceof Postprocessable) {
                        return ((Postprocessable) helpLinkModel).a();
                    }
                    return helpLinkModel;
                }
            }

            /* compiled from: thread_summary_arg */
            public class Serializer extends JsonSerializer<HelpLinkModel> {
                public final void m1801a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    HelpLinkModel helpLinkModel = (HelpLinkModel) obj;
                    if (helpLinkModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(helpLinkModel.m1803a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        helpLinkModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    HelpLinkParser.m1884a(helpLinkModel.w_(), helpLinkModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(HelpLinkModel.class, new Serializer());
                }
            }

            public HelpLinkModel() {
                super(3);
            }

            @Nullable
            private GraphQLObjectType m1802j() {
                if (this.b != null && this.f1740d == null) {
                    this.f1740d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f1740d;
            }

            @Nullable
            public final String m1805a() {
                this.f1741e = super.a(this.f1741e, 1);
                return this.f1741e;
            }

            @Nullable
            public final String m1806b() {
                this.f1742f = super.a(this.f1742f, 2);
                return this.f1742f;
            }

            public final int jK_() {
                return -1747569147;
            }

            public final GraphQLVisitableModel m1804a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m1803a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m1802j());
                int b = flatBufferBuilder.b(m1805a());
                int b2 = flatBufferBuilder.b(m1806b());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: thread_summary_arg */
        public final class ImageModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f1743d;

            /* compiled from: thread_summary_arg */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ImageModel.class, new Deserializer());
                }

                public Object m1807a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ImageParser.m1885a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object imageModel = new ImageModel();
                    ((BaseModel) imageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (imageModel instanceof Postprocessable) {
                        return ((Postprocessable) imageModel).a();
                    }
                    return imageModel;
                }
            }

            /* compiled from: thread_summary_arg */
            public class Serializer extends JsonSerializer<ImageModel> {
                public final void m1808a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ImageModel imageModel = (ImageModel) obj;
                    if (imageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(imageModel.m1809a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        imageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ImageParser.m1886a(imageModel.w_(), imageModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ImageModel.class, new Serializer());
                }
            }

            public ImageModel() {
                super(1);
            }

            @Nullable
            public final String m1811a() {
                this.f1743d = super.a(this.f1743d, 0);
                return this.f1743d;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m1810a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m1809a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m1811a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: thread_summary_arg */
        public class Serializer extends JsonSerializer<MomentsAppPromotionFragmentModel> {
            public final void m1812a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MomentsAppPromotionFragmentModel momentsAppPromotionFragmentModel = (MomentsAppPromotionFragmentModel) obj;
                if (momentsAppPromotionFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(momentsAppPromotionFragmentModel.m1825a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    momentsAppPromotionFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                MomentsAppPromotionFragmentParser.m1890a(momentsAppPromotionFragmentModel.w_(), momentsAppPromotionFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(MomentsAppPromotionFragmentModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: thread_summary_arg */
        public final class TitleModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f1744d;

            /* compiled from: thread_summary_arg */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TitleModel.class, new Deserializer());
                }

                public Object m1813a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TitleParser.m1887a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object titleModel = new TitleModel();
                    ((BaseModel) titleModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (titleModel instanceof Postprocessable) {
                        return ((Postprocessable) titleModel).a();
                    }
                    return titleModel;
                }
            }

            /* compiled from: thread_summary_arg */
            public class Serializer extends JsonSerializer<TitleModel> {
                public final void m1814a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TitleModel titleModel = (TitleModel) obj;
                    if (titleModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(titleModel.m1815a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        titleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TitleParser.m1888a(titleModel.w_(), titleModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(TitleModel.class, new Serializer());
                }
            }

            public TitleModel() {
                super(1);
            }

            @Nullable
            public final String m1817a() {
                this.f1744d = super.a(this.f1744d, 0);
                return this.f1744d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m1816a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m1815a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m1817a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @Nullable
        public final /* synthetic */ ActionLinkModel m1827a() {
            return m1818n();
        }

        @Nullable
        public final /* synthetic */ ActionLinkIfMomentsInstalledModel m1829b() {
            return m1819o();
        }

        @Nullable
        public final /* synthetic */ ImageModel kj_() {
            return m1822r();
        }

        @Nullable
        public final /* synthetic */ HelpLinkModel kk_() {
            return m1821q();
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesFields kl_() {
            return m1820p();
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesFields m1835l() {
            return m1823s();
        }

        @Nullable
        public final /* synthetic */ TitleModel m1836m() {
            return m1824t();
        }

        public MomentsAppPromotionFragmentModel() {
            super(12);
        }

        @Nullable
        private ActionLinkModel m1818n() {
            this.f1745d = (ActionLinkModel) super.a(this.f1745d, 0, ActionLinkModel.class);
            return this.f1745d;
        }

        @Nullable
        private ActionLinkIfMomentsInstalledModel m1819o() {
            this.f1746e = (ActionLinkIfMomentsInstalledModel) super.a(this.f1746e, 1, ActionLinkIfMomentsInstalledModel.class);
            return this.f1746e;
        }

        public final boolean m1830c() {
            a(0, 2);
            return this.f1747f;
        }

        public final int m1831d() {
            a(0, 3);
            return this.f1748g;
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel m1820p() {
            this.f1749h = (DefaultTextWithEntitiesFieldsModel) super.a(this.f1749h, 4, DefaultTextWithEntitiesFieldsModel.class);
            return this.f1749h;
        }

        @Nonnull
        public final ImmutableList<FacepileUsersModel> m1832g() {
            this.f1750i = super.a(this.f1750i, 5, FacepileUsersModel.class);
            return (ImmutableList) this.f1750i;
        }

        @Nullable
        private HelpLinkModel m1821q() {
            this.f1751j = (HelpLinkModel) super.a(this.f1751j, 6, HelpLinkModel.class);
            return this.f1751j;
        }

        @Nullable
        private ImageModel m1822r() {
            this.f1752k = (ImageModel) super.a(this.f1752k, 7, ImageModel.class);
            return this.f1752k;
        }

        public final boolean m1833j() {
            a(1, 0);
            return this.f1753l;
        }

        public final boolean m1834k() {
            a(1, 1);
            return this.f1754m;
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel m1823s() {
            this.f1755n = (DefaultTextWithEntitiesFieldsModel) super.a(this.f1755n, 10, DefaultTextWithEntitiesFieldsModel.class);
            return this.f1755n;
        }

        @Nullable
        private TitleModel m1824t() {
            this.f1756o = (TitleModel) super.a(this.f1756o, 11, TitleModel.class);
            return this.f1756o;
        }

        public final int jK_() {
            return 1315524131;
        }

        public final GraphQLVisitableModel m1826a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            DefaultTextWithEntitiesFieldsModel defaultTextWithEntitiesFieldsModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1818n() != null) {
                ActionLinkModel actionLinkModel = (ActionLinkModel) graphQLModelMutatingVisitor.b(m1818n());
                if (m1818n() != actionLinkModel) {
                    graphQLVisitableModel = (MomentsAppPromotionFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1745d = actionLinkModel;
                }
            }
            if (m1819o() != null) {
                ActionLinkIfMomentsInstalledModel actionLinkIfMomentsInstalledModel = (ActionLinkIfMomentsInstalledModel) graphQLModelMutatingVisitor.b(m1819o());
                if (m1819o() != actionLinkIfMomentsInstalledModel) {
                    graphQLVisitableModel = (MomentsAppPromotionFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1746e = actionLinkIfMomentsInstalledModel;
                }
            }
            if (m1820p() != null) {
                defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m1820p());
                if (m1820p() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (MomentsAppPromotionFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1749h = defaultTextWithEntitiesFieldsModel;
                }
            }
            if (m1832g() != null) {
                Builder a = ModelHelper.a(m1832g(), graphQLModelMutatingVisitor);
                if (a != null) {
                    MomentsAppPromotionFragmentModel momentsAppPromotionFragmentModel = (MomentsAppPromotionFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    momentsAppPromotionFragmentModel.f1750i = a.b();
                    graphQLVisitableModel = momentsAppPromotionFragmentModel;
                }
            }
            if (m1821q() != null) {
                HelpLinkModel helpLinkModel = (HelpLinkModel) graphQLModelMutatingVisitor.b(m1821q());
                if (m1821q() != helpLinkModel) {
                    graphQLVisitableModel = (MomentsAppPromotionFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1751j = helpLinkModel;
                }
            }
            if (m1822r() != null) {
                ImageModel imageModel = (ImageModel) graphQLModelMutatingVisitor.b(m1822r());
                if (m1822r() != imageModel) {
                    graphQLVisitableModel = (MomentsAppPromotionFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1752k = imageModel;
                }
            }
            if (m1823s() != null) {
                defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m1823s());
                if (m1823s() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (MomentsAppPromotionFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1755n = defaultTextWithEntitiesFieldsModel;
                }
            }
            if (m1824t() != null) {
                TitleModel titleModel = (TitleModel) graphQLModelMutatingVisitor.b(m1824t());
                if (m1824t() != titleModel) {
                    graphQLVisitableModel = (MomentsAppPromotionFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1756o = titleModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1825a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m1818n());
            int a2 = ModelHelper.a(flatBufferBuilder, m1819o());
            int a3 = ModelHelper.a(flatBufferBuilder, m1820p());
            int a4 = ModelHelper.a(flatBufferBuilder, m1832g());
            int a5 = ModelHelper.a(flatBufferBuilder, m1821q());
            int a6 = ModelHelper.a(flatBufferBuilder, m1822r());
            int a7 = ModelHelper.a(flatBufferBuilder, m1823s());
            int a8 = ModelHelper.a(flatBufferBuilder, m1824t());
            flatBufferBuilder.c(12);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.a(2, this.f1747f);
            flatBufferBuilder.a(3, this.f1748g, 0);
            flatBufferBuilder.b(4, a3);
            flatBufferBuilder.b(5, a4);
            flatBufferBuilder.b(6, a5);
            flatBufferBuilder.b(7, a6);
            flatBufferBuilder.a(8, this.f1753l);
            flatBufferBuilder.a(9, this.f1754m);
            flatBufferBuilder.b(10, a7);
            flatBufferBuilder.b(11, a8);
            i();
            return flatBufferBuilder.d();
        }

        public final void m1828a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f1747f = mutableFlatBuffer.a(i, 2);
            this.f1748g = mutableFlatBuffer.a(i, 3, 0);
            this.f1753l = mutableFlatBuffer.a(i, 8);
            this.f1754m = mutableFlatBuffer.a(i, 9);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -667734277)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: thread_summary_arg */
    public final class MomentsAppPromotionQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private MomentsAppSyncedPhotosModel f1763d;
        @Nullable
        private VaultModel f1764e;

        /* compiled from: thread_summary_arg */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MomentsAppPromotionQueryModel.class, new Deserializer());
            }

            public Object m1837a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = MomentsAppPromotionQueryParser.m1899a(jsonParser);
                Object momentsAppPromotionQueryModel = new MomentsAppPromotionQueryModel();
                ((BaseModel) momentsAppPromotionQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (momentsAppPromotionQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) momentsAppPromotionQueryModel).a();
                }
                return momentsAppPromotionQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -299564614)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: thread_summary_arg */
        public final class MomentsAppSyncedPhotosModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f1758d;

            /* compiled from: thread_summary_arg */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MomentsAppSyncedPhotosModel.class, new Deserializer());
                }

                public Object m1838a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MomentsAppSyncedPhotosParser.m1893a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object momentsAppSyncedPhotosModel = new MomentsAppSyncedPhotosModel();
                    ((BaseModel) momentsAppSyncedPhotosModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (momentsAppSyncedPhotosModel instanceof Postprocessable) {
                        return ((Postprocessable) momentsAppSyncedPhotosModel).a();
                    }
                    return momentsAppSyncedPhotosModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 665392985)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: thread_summary_arg */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private MomentsAppPhotoFragmentModel f1757d;

                /* compiled from: thread_summary_arg */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m1839a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EdgesParser.m1891b(jsonParser, flatBufferBuilder));
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

                /* compiled from: thread_summary_arg */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m1840a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m1842a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EdgesParser.m1892b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ MomentsAppPhotoFragmentModel m1844a() {
                    return m1841j();
                }

                public EdgesModel() {
                    super(1);
                }

                @Nullable
                private MomentsAppPhotoFragmentModel m1841j() {
                    this.f1757d = (MomentsAppPhotoFragmentModel) super.a(this.f1757d, 0, MomentsAppPhotoFragmentModel.class);
                    return this.f1757d;
                }

                public final int jK_() {
                    return -178009882;
                }

                public final GraphQLVisitableModel m1843a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m1841j() != null) {
                        MomentsAppPhotoFragmentModel momentsAppPhotoFragmentModel = (MomentsAppPhotoFragmentModel) graphQLModelMutatingVisitor.b(m1841j());
                        if (m1841j() != momentsAppPhotoFragmentModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f1757d = momentsAppPhotoFragmentModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m1842a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m1841j());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: thread_summary_arg */
            public class Serializer extends JsonSerializer<MomentsAppSyncedPhotosModel> {
                public final void m1845a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MomentsAppSyncedPhotosModel momentsAppSyncedPhotosModel = (MomentsAppSyncedPhotosModel) obj;
                    if (momentsAppSyncedPhotosModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(momentsAppSyncedPhotosModel.m1846a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        momentsAppSyncedPhotosModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MomentsAppSyncedPhotosParser.m1894a(momentsAppSyncedPhotosModel.w_(), momentsAppSyncedPhotosModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(MomentsAppSyncedPhotosModel.class, new Serializer());
                }
            }

            public MomentsAppSyncedPhotosModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<EdgesModel> m1848a() {
                this.f1758d = super.a(this.f1758d, 0, EdgesModel.class);
                return (ImmutableList) this.f1758d;
            }

            public final int jK_() {
                return 1609045831;
            }

            public final GraphQLVisitableModel m1847a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m1848a() != null) {
                    Builder a = ModelHelper.a(m1848a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (MomentsAppSyncedPhotosModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f1758d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m1846a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m1848a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: thread_summary_arg */
        public class Serializer extends JsonSerializer<MomentsAppPromotionQueryModel> {
            public final void m1849a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                MomentsAppPromotionQueryModel momentsAppPromotionQueryModel = (MomentsAppPromotionQueryModel) obj;
                if (momentsAppPromotionQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(momentsAppPromotionQueryModel.m1868a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    momentsAppPromotionQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = momentsAppPromotionQueryModel.w_();
                int u_ = momentsAppPromotionQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("moments_app_synced_photos");
                    MomentsAppSyncedPhotosParser.m1894a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("vault");
                    VaultParser.m1898a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(MomentsAppPromotionQueryModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -572612948)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: thread_summary_arg */
        public final class VaultModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private ImagesModel f1760d;
            @Nullable
            private MomentsAppPromotionFragmentModel f1761e;
            private boolean f1762f;

            /* compiled from: thread_summary_arg */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(VaultModel.class, new Deserializer());
                }

                public Object m1850a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(VaultParser.m1897a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object vaultModel = new VaultModel();
                    ((BaseModel) vaultModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (vaultModel instanceof Postprocessable) {
                        return ((Postprocessable) vaultModel).a();
                    }
                    return vaultModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1723990064)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: thread_summary_arg */
            public final class ImagesModel extends BaseModel implements GraphQLVisitableModel {
                private int f1759d;

                /* compiled from: thread_summary_arg */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ImagesModel.class, new Deserializer());
                    }

                    public Object m1851a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ImagesParser.m1895a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object imagesModel = new ImagesModel();
                        ((BaseModel) imagesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (imagesModel instanceof Postprocessable) {
                            return ((Postprocessable) imagesModel).a();
                        }
                        return imagesModel;
                    }
                }

                /* compiled from: thread_summary_arg */
                public class Serializer extends JsonSerializer<ImagesModel> {
                    public final void m1852a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ImagesModel imagesModel = (ImagesModel) obj;
                        if (imagesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(imagesModel.m1854a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            imagesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ImagesParser.m1896a(imagesModel.w_(), imagesModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(ImagesModel.class, new Serializer());
                    }
                }

                public ImagesModel() {
                    super(1);
                }

                public final int m1853a() {
                    a(0, 0);
                    return this.f1759d;
                }

                public final int jK_() {
                    return -834287192;
                }

                public final GraphQLVisitableModel m1855a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m1854a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, this.f1759d, 0);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m1856a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f1759d = mutableFlatBuffer.a(i, 0, 0);
                }
            }

            /* compiled from: thread_summary_arg */
            public class Serializer extends JsonSerializer<VaultModel> {
                public final void m1857a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    VaultModel vaultModel = (VaultModel) obj;
                    if (vaultModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(vaultModel.m1860a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        vaultModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    VaultParser.m1898a(vaultModel.w_(), vaultModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(VaultModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ ImagesModel m1862a() {
                return m1858j();
            }

            @Nullable
            public final /* synthetic */ MomentsAppPromotionFragmentModel m1864b() {
                return m1859k();
            }

            public VaultModel() {
                super(3);
            }

            @Nullable
            private ImagesModel m1858j() {
                this.f1760d = (ImagesModel) super.a(this.f1760d, 0, ImagesModel.class);
                return this.f1760d;
            }

            @Nullable
            private MomentsAppPromotionFragmentModel m1859k() {
                this.f1761e = (MomentsAppPromotionFragmentModel) super.a(this.f1761e, 1, MomentsAppPromotionFragmentModel.class);
                return this.f1761e;
            }

            public final boolean m1865c() {
                a(0, 2);
                return this.f1762f;
            }

            public final int jK_() {
                return 82428434;
            }

            public final GraphQLVisitableModel m1861a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m1858j() != null) {
                    ImagesModel imagesModel = (ImagesModel) graphQLModelMutatingVisitor.b(m1858j());
                    if (m1858j() != imagesModel) {
                        graphQLVisitableModel = (VaultModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f1760d = imagesModel;
                    }
                }
                if (m1859k() != null) {
                    MomentsAppPromotionFragmentModel momentsAppPromotionFragmentModel = (MomentsAppPromotionFragmentModel) graphQLModelMutatingVisitor.b(m1859k());
                    if (m1859k() != momentsAppPromotionFragmentModel) {
                        graphQLVisitableModel = (VaultModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1761e = momentsAppPromotionFragmentModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m1860a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m1858j());
                int a2 = ModelHelper.a(flatBufferBuilder, m1859k());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.a(2, this.f1762f);
                i();
                return flatBufferBuilder.d();
            }

            public final void m1863a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f1762f = mutableFlatBuffer.a(i, 2);
            }
        }

        @Nullable
        public final /* synthetic */ MomentsAppSyncedPhotosModel m1870a() {
            return m1866j();
        }

        @Nullable
        public final /* synthetic */ VaultModel m1871b() {
            return m1867k();
        }

        public MomentsAppPromotionQueryModel() {
            super(2);
        }

        @Nullable
        private MomentsAppSyncedPhotosModel m1866j() {
            this.f1763d = (MomentsAppSyncedPhotosModel) super.a(this.f1763d, 0, MomentsAppSyncedPhotosModel.class);
            return this.f1763d;
        }

        @Nullable
        private VaultModel m1867k() {
            this.f1764e = (VaultModel) super.a(this.f1764e, 1, VaultModel.class);
            return this.f1764e;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m1869a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1866j() != null) {
                MomentsAppSyncedPhotosModel momentsAppSyncedPhotosModel = (MomentsAppSyncedPhotosModel) graphQLModelMutatingVisitor.b(m1866j());
                if (m1866j() != momentsAppSyncedPhotosModel) {
                    graphQLVisitableModel = (MomentsAppPromotionQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1763d = momentsAppSyncedPhotosModel;
                }
            }
            if (m1867k() != null) {
                VaultModel vaultModel = (VaultModel) graphQLModelMutatingVisitor.b(m1867k());
                if (m1867k() != vaultModel) {
                    graphQLVisitableModel = (MomentsAppPromotionQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1764e = vaultModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1868a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m1866j());
            int a2 = ModelHelper.a(flatBufferBuilder, m1867k());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}

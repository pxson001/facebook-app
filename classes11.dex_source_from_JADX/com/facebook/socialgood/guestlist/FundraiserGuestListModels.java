package com.facebook.socialgood.guestlist;

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
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoTailFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.socialgood.guestlist.FundraiserGuestListParsers.FundraiserConnectionsFragmentParser;
import com.facebook.socialgood.guestlist.FundraiserGuestListParsers.FundraiserConnectionsFragmentParser.MutualFriendsParser;
import com.facebook.socialgood.guestlist.FundraiserGuestListParsers.FundraiserDonorsConnectionQueryParser;
import com.facebook.socialgood.guestlist.FundraiserGuestListParsers.FundraiserDonorsConnectionQueryParser.DonorsParser;
import com.facebook.socialgood.guestlist.FundraiserGuestListParsers.FundraiserDonorsConnectionQueryParser.DonorsParser.EdgesParser;
import com.facebook.socialgood.guestlist.FundraiserGuestListParsers.FundraiserIncrementPersonalUpdatesCountMutationParser;
import com.facebook.socialgood.guestlist.FundraiserGuestListParsers.FundraiserInvitedUsersConnectionQueryParser;
import com.facebook.socialgood.guestlist.FundraiserGuestListParsers.FundraiserInvitedUsersConnectionQueryParser.InvitedUsersParser;
import com.facebook.socialgood.guestlist.FundraiserGuestListParsers.FundraiserSharersConnectionQueryParser;
import com.facebook.socialgood.guestlist.FundraiserGuestListParsers.FundraiserSharersConnectionQueryParser.SharersParser;
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

/* compiled from: PAGE_PHOTOS_BY */
public class FundraiserGuestListModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 138009533)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: PAGE_PHOTOS_BY */
    public final class FundraiserConnectionsFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f12644d;
        @Nullable
        private String f12645e;
        private boolean f12646f;
        @Nullable
        private MutualFriendsModel f12647g;
        @Nullable
        private String f12648h;
        @Nullable
        private DefaultImageFieldsModel f12649i;

        /* compiled from: PAGE_PHOTOS_BY */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FundraiserConnectionsFragmentModel.class, new Deserializer());
            }

            public Object m13057a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FundraiserConnectionsFragmentParser.m13168a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object fundraiserConnectionsFragmentModel = new FundraiserConnectionsFragmentModel();
                ((BaseModel) fundraiserConnectionsFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (fundraiserConnectionsFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) fundraiserConnectionsFragmentModel).a();
                }
                return fundraiserConnectionsFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: PAGE_PHOTOS_BY */
        public final class MutualFriendsModel extends BaseModel implements GraphQLVisitableModel {
            private int f12643d;

            /* compiled from: PAGE_PHOTOS_BY */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MutualFriendsModel.class, new Deserializer());
                }

                public Object m13058a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MutualFriendsParser.m13166a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object mutualFriendsModel = new MutualFriendsModel();
                    ((BaseModel) mutualFriendsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (mutualFriendsModel instanceof Postprocessable) {
                        return ((Postprocessable) mutualFriendsModel).a();
                    }
                    return mutualFriendsModel;
                }
            }

            /* compiled from: PAGE_PHOTOS_BY */
            public class Serializer extends JsonSerializer<MutualFriendsModel> {
                public final void m13059a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MutualFriendsModel mutualFriendsModel = (MutualFriendsModel) obj;
                    if (mutualFriendsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(mutualFriendsModel.m13061a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutualFriendsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MutualFriendsParser.m13167a(mutualFriendsModel.w_(), mutualFriendsModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(MutualFriendsModel.class, new Serializer());
                }
            }

            public MutualFriendsModel() {
                super(1);
            }

            public final int m13060a() {
                a(0, 0);
                return this.f12643d;
            }

            public final int jK_() {
                return 1532278911;
            }

            public final GraphQLVisitableModel m13062a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m13061a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f12643d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m13063a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f12643d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: PAGE_PHOTOS_BY */
        public class Serializer extends JsonSerializer<FundraiserConnectionsFragmentModel> {
            public final void m13064a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FundraiserConnectionsFragmentModel fundraiserConnectionsFragmentModel = (FundraiserConnectionsFragmentModel) obj;
                if (fundraiserConnectionsFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fundraiserConnectionsFragmentModel.m13066a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fundraiserConnectionsFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FundraiserConnectionsFragmentParser.m13169b(fundraiserConnectionsFragmentModel.w_(), fundraiserConnectionsFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FundraiserConnectionsFragmentModel.class, new Serializer());
            }
        }

        public FundraiserConnectionsFragmentModel() {
            super(6);
        }

        public final void m13070a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m13071a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m13065o() {
            if (this.b != null && this.f12644d == null) {
                this.f12644d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f12644d;
        }

        @Nullable
        public final String m13072j() {
            this.f12645e = super.a(this.f12645e, 1);
            return this.f12645e;
        }

        public final boolean m13073k() {
            a(0, 2);
            return this.f12646f;
        }

        @Nullable
        public final MutualFriendsModel m13074l() {
            this.f12647g = (MutualFriendsModel) super.a(this.f12647g, 3, MutualFriendsModel.class);
            return this.f12647g;
        }

        @Nullable
        public final String m13075m() {
            this.f12648h = super.a(this.f12648h, 4);
            return this.f12648h;
        }

        @Nullable
        public final DefaultImageFieldsModel m13076n() {
            this.f12649i = (DefaultImageFieldsModel) super.a(this.f12649i, 5, DefaultImageFieldsModel.class);
            return this.f12649i;
        }

        @Nullable
        public final String m13068a() {
            return m13072j();
        }

        public final int jK_() {
            return 1355227529;
        }

        public final GraphQLVisitableModel m13067a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m13074l() != null) {
                MutualFriendsModel mutualFriendsModel = (MutualFriendsModel) graphQLModelMutatingVisitor.b(m13074l());
                if (m13074l() != mutualFriendsModel) {
                    graphQLVisitableModel = (FundraiserConnectionsFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12647g = mutualFriendsModel;
                }
            }
            if (m13076n() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m13076n());
                if (m13076n() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (FundraiserConnectionsFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12649i = defaultImageFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m13066a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m13065o());
            int b = flatBufferBuilder.b(m13072j());
            int a2 = ModelHelper.a(flatBufferBuilder, m13074l());
            int b2 = flatBufferBuilder.b(m13075m());
            int a3 = ModelHelper.a(flatBufferBuilder, m13076n());
            flatBufferBuilder.c(6);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.a(2, this.f12646f);
            flatBufferBuilder.b(3, a2);
            flatBufferBuilder.b(4, b2);
            flatBufferBuilder.b(5, a3);
            i();
            return flatBufferBuilder.d();
        }

        public final void m13069a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f12646f = mutableFlatBuffer.a(i, 2);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1396699333)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: PAGE_PHOTOS_BY */
    public final class FundraiserDonorsConnectionQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f12653d;
        @Nullable
        private DonorsModel f12654e;
        @Nullable
        private String f12655f;

        /* compiled from: PAGE_PHOTOS_BY */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FundraiserDonorsConnectionQueryModel.class, new Deserializer());
            }

            public Object m13077a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FundraiserDonorsConnectionQueryParser.m13174a(jsonParser);
                Object fundraiserDonorsConnectionQueryModel = new FundraiserDonorsConnectionQueryModel();
                ((BaseModel) fundraiserDonorsConnectionQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fundraiserDonorsConnectionQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fundraiserDonorsConnectionQueryModel).a();
                }
                return fundraiserDonorsConnectionQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -919181773)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: PAGE_PHOTOS_BY */
        public final class DonorsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f12651d;
            @Nullable
            private DefaultPageInfoTailFieldsModel f12652e;

            /* compiled from: PAGE_PHOTOS_BY */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(DonorsModel.class, new Deserializer());
                }

                public Object m13078a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(DonorsParser.m13172a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object donorsModel = new DonorsModel();
                    ((BaseModel) donorsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (donorsModel instanceof Postprocessable) {
                        return ((Postprocessable) donorsModel).a();
                    }
                    return donorsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 2133397961)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: PAGE_PHOTOS_BY */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private FundraiserConnectionsFragmentModel f12650d;

                /* compiled from: PAGE_PHOTOS_BY */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m13079a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EdgesParser.m13170b(jsonParser, flatBufferBuilder));
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

                /* compiled from: PAGE_PHOTOS_BY */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m13080a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m13081a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EdgesParser.m13171b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                public EdgesModel() {
                    super(1);
                }

                @Nullable
                public final FundraiserConnectionsFragmentModel m13083a() {
                    this.f12650d = (FundraiserConnectionsFragmentModel) super.a(this.f12650d, 0, FundraiserConnectionsFragmentModel.class);
                    return this.f12650d;
                }

                public final int jK_() {
                    return -143570905;
                }

                public final GraphQLVisitableModel m13082a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m13083a() != null) {
                        FundraiserConnectionsFragmentModel fundraiserConnectionsFragmentModel = (FundraiserConnectionsFragmentModel) graphQLModelMutatingVisitor.b(m13083a());
                        if (m13083a() != fundraiserConnectionsFragmentModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f12650d = fundraiserConnectionsFragmentModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m13081a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m13083a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: PAGE_PHOTOS_BY */
            public class Serializer extends JsonSerializer<DonorsModel> {
                public final void m13084a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    DonorsModel donorsModel = (DonorsModel) obj;
                    if (donorsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(donorsModel.m13085a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        donorsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    DonorsParser.m13173a(donorsModel.w_(), donorsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(DonorsModel.class, new Serializer());
                }
            }

            public DonorsModel() {
                super(2);
            }

            @Nonnull
            public final ImmutableList<EdgesModel> m13087a() {
                this.f12651d = super.a(this.f12651d, 0, EdgesModel.class);
                return (ImmutableList) this.f12651d;
            }

            @Nullable
            public final DefaultPageInfoTailFieldsModel m13088j() {
                this.f12652e = (DefaultPageInfoTailFieldsModel) super.a(this.f12652e, 1, DefaultPageInfoTailFieldsModel.class);
                return this.f12652e;
            }

            public final int jK_() {
                return -1978703416;
            }

            public final GraphQLVisitableModel m13086a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                DefaultPageInfoTailFieldsModel defaultPageInfoTailFieldsModel;
                h();
                if (m13087a() != null) {
                    Builder a = ModelHelper.a(m13087a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        DonorsModel donorsModel = (DonorsModel) ModelHelper.a(null, this);
                        donorsModel.f12651d = a.b();
                        graphQLVisitableModel = donorsModel;
                        if (m13088j() != null) {
                            defaultPageInfoTailFieldsModel = (DefaultPageInfoTailFieldsModel) graphQLModelMutatingVisitor.b(m13088j());
                            if (m13088j() != defaultPageInfoTailFieldsModel) {
                                graphQLVisitableModel = (DonorsModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f12652e = defaultPageInfoTailFieldsModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m13088j() != null) {
                    defaultPageInfoTailFieldsModel = (DefaultPageInfoTailFieldsModel) graphQLModelMutatingVisitor.b(m13088j());
                    if (m13088j() != defaultPageInfoTailFieldsModel) {
                        graphQLVisitableModel = (DonorsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f12652e = defaultPageInfoTailFieldsModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m13085a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m13087a());
                int a2 = ModelHelper.a(flatBufferBuilder, m13088j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: PAGE_PHOTOS_BY */
        public class Serializer extends JsonSerializer<FundraiserDonorsConnectionQueryModel> {
            public final void m13089a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FundraiserDonorsConnectionQueryModel fundraiserDonorsConnectionQueryModel = (FundraiserDonorsConnectionQueryModel) obj;
                if (fundraiserDonorsConnectionQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fundraiserDonorsConnectionQueryModel.m13092a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fundraiserDonorsConnectionQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fundraiserDonorsConnectionQueryModel.w_();
                int u_ = fundraiserDonorsConnectionQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("donors");
                    DonorsParser.m13173a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 2));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FundraiserDonorsConnectionQueryModel.class, new Serializer());
            }
        }

        public FundraiserDonorsConnectionQueryModel() {
            super(3);
        }

        public final void m13095a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m13096a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m13090k() {
            if (this.b != null && this.f12653d == null) {
                this.f12653d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f12653d;
        }

        @Nullable
        public final DonorsModel m13097j() {
            this.f12654e = (DonorsModel) super.a(this.f12654e, 1, DonorsModel.class);
            return this.f12654e;
        }

        @Nullable
        private String m13091l() {
            this.f12655f = super.a(this.f12655f, 2);
            return this.f12655f;
        }

        @Nullable
        public final String m13094a() {
            return m13091l();
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m13093a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m13097j() != null) {
                DonorsModel donorsModel = (DonorsModel) graphQLModelMutatingVisitor.b(m13097j());
                if (m13097j() != donorsModel) {
                    graphQLVisitableModel = (FundraiserDonorsConnectionQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12654e = donorsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m13092a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m13090k());
            int a2 = ModelHelper.a(flatBufferBuilder, m13097j());
            int b = flatBufferBuilder.b(m13091l());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1162246043)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: PAGE_PHOTOS_BY */
    public final class FundraiserIncrementPersonalUpdatesCountMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f12656d;
        @Nullable
        private String f12657e;
        @Nullable
        private String f12658f;

        /* compiled from: PAGE_PHOTOS_BY */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FundraiserIncrementPersonalUpdatesCountMutationModel.class, new Deserializer());
            }

            public Object m13098a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FundraiserIncrementPersonalUpdatesCountMutationParser.m13175a(jsonParser);
                Object fundraiserIncrementPersonalUpdatesCountMutationModel = new FundraiserIncrementPersonalUpdatesCountMutationModel();
                ((BaseModel) fundraiserIncrementPersonalUpdatesCountMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fundraiserIncrementPersonalUpdatesCountMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) fundraiserIncrementPersonalUpdatesCountMutationModel).a();
                }
                return fundraiserIncrementPersonalUpdatesCountMutationModel;
            }
        }

        /* compiled from: PAGE_PHOTOS_BY */
        public class Serializer extends JsonSerializer<FundraiserIncrementPersonalUpdatesCountMutationModel> {
            public final void m13099a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FundraiserIncrementPersonalUpdatesCountMutationModel fundraiserIncrementPersonalUpdatesCountMutationModel = (FundraiserIncrementPersonalUpdatesCountMutationModel) obj;
                if (fundraiserIncrementPersonalUpdatesCountMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fundraiserIncrementPersonalUpdatesCountMutationModel.m13103a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fundraiserIncrementPersonalUpdatesCountMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fundraiserIncrementPersonalUpdatesCountMutationModel.w_();
                int u_ = fundraiserIncrementPersonalUpdatesCountMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__typename");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("client_subscription_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 2));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FundraiserIncrementPersonalUpdatesCountMutationModel.class, new Serializer());
            }
        }

        public FundraiserIncrementPersonalUpdatesCountMutationModel() {
            super(3);
        }

        @Nullable
        private String m13100a() {
            this.f12656d = super.a(this.f12656d, 0);
            return this.f12656d;
        }

        @Nullable
        private String m13101j() {
            this.f12657e = super.a(this.f12657e, 1);
            return this.f12657e;
        }

        @Nullable
        private String m13102k() {
            this.f12658f = super.a(this.f12658f, 2);
            return this.f12658f;
        }

        public final int jK_() {
            return 1639592292;
        }

        public final GraphQLVisitableModel m13104a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m13103a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m13100a());
            int b2 = flatBufferBuilder.b(m13101j());
            int b3 = flatBufferBuilder.b(m13102k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, b3);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 476087402)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: PAGE_PHOTOS_BY */
    public final class FundraiserInvitedUsersConnectionQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f12662d;
        @Nullable
        private String f12663e;
        @Nullable
        private InvitedUsersModel f12664f;

        /* compiled from: PAGE_PHOTOS_BY */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FundraiserInvitedUsersConnectionQueryModel.class, new Deserializer());
            }

            public Object m13105a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FundraiserInvitedUsersConnectionQueryParser.m13180a(jsonParser);
                Object fundraiserInvitedUsersConnectionQueryModel = new FundraiserInvitedUsersConnectionQueryModel();
                ((BaseModel) fundraiserInvitedUsersConnectionQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fundraiserInvitedUsersConnectionQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fundraiserInvitedUsersConnectionQueryModel).a();
                }
                return fundraiserInvitedUsersConnectionQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1746883710)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: PAGE_PHOTOS_BY */
        public final class InvitedUsersModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f12660d;
            @Nullable
            private DefaultPageInfoTailFieldsModel f12661e;

            /* compiled from: PAGE_PHOTOS_BY */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(InvitedUsersModel.class, new Deserializer());
                }

                public Object m13106a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(InvitedUsersParser.m13178a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object invitedUsersModel = new InvitedUsersModel();
                    ((BaseModel) invitedUsersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (invitedUsersModel instanceof Postprocessable) {
                        return ((Postprocessable) invitedUsersModel).a();
                    }
                    return invitedUsersModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 2133397961)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: PAGE_PHOTOS_BY */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private FundraiserConnectionsFragmentModel f12659d;

                /* compiled from: PAGE_PHOTOS_BY */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m13107a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(InvitedUsersParser.EdgesParser.m13176b(jsonParser, flatBufferBuilder));
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

                /* compiled from: PAGE_PHOTOS_BY */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m13108a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m13109a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        InvitedUsersParser.EdgesParser.m13177b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                public EdgesModel() {
                    super(1);
                }

                @Nullable
                public final FundraiserConnectionsFragmentModel m13111a() {
                    this.f12659d = (FundraiserConnectionsFragmentModel) super.a(this.f12659d, 0, FundraiserConnectionsFragmentModel.class);
                    return this.f12659d;
                }

                public final int jK_() {
                    return -2030700222;
                }

                public final GraphQLVisitableModel m13110a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m13111a() != null) {
                        FundraiserConnectionsFragmentModel fundraiserConnectionsFragmentModel = (FundraiserConnectionsFragmentModel) graphQLModelMutatingVisitor.b(m13111a());
                        if (m13111a() != fundraiserConnectionsFragmentModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f12659d = fundraiserConnectionsFragmentModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m13109a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m13111a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: PAGE_PHOTOS_BY */
            public class Serializer extends JsonSerializer<InvitedUsersModel> {
                public final void m13112a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    InvitedUsersModel invitedUsersModel = (InvitedUsersModel) obj;
                    if (invitedUsersModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(invitedUsersModel.m13113a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        invitedUsersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    InvitedUsersParser.m13179a(invitedUsersModel.w_(), invitedUsersModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(InvitedUsersModel.class, new Serializer());
                }
            }

            public InvitedUsersModel() {
                super(2);
            }

            @Nonnull
            public final ImmutableList<EdgesModel> m13115a() {
                this.f12660d = super.a(this.f12660d, 0, EdgesModel.class);
                return (ImmutableList) this.f12660d;
            }

            @Nullable
            public final DefaultPageInfoTailFieldsModel m13116j() {
                this.f12661e = (DefaultPageInfoTailFieldsModel) super.a(this.f12661e, 1, DefaultPageInfoTailFieldsModel.class);
                return this.f12661e;
            }

            public final int jK_() {
                return 701731491;
            }

            public final GraphQLVisitableModel m13114a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                DefaultPageInfoTailFieldsModel defaultPageInfoTailFieldsModel;
                h();
                if (m13115a() != null) {
                    Builder a = ModelHelper.a(m13115a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        InvitedUsersModel invitedUsersModel = (InvitedUsersModel) ModelHelper.a(null, this);
                        invitedUsersModel.f12660d = a.b();
                        graphQLVisitableModel = invitedUsersModel;
                        if (m13116j() != null) {
                            defaultPageInfoTailFieldsModel = (DefaultPageInfoTailFieldsModel) graphQLModelMutatingVisitor.b(m13116j());
                            if (m13116j() != defaultPageInfoTailFieldsModel) {
                                graphQLVisitableModel = (InvitedUsersModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f12661e = defaultPageInfoTailFieldsModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m13116j() != null) {
                    defaultPageInfoTailFieldsModel = (DefaultPageInfoTailFieldsModel) graphQLModelMutatingVisitor.b(m13116j());
                    if (m13116j() != defaultPageInfoTailFieldsModel) {
                        graphQLVisitableModel = (InvitedUsersModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f12661e = defaultPageInfoTailFieldsModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m13113a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m13115a());
                int a2 = ModelHelper.a(flatBufferBuilder, m13116j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: PAGE_PHOTOS_BY */
        public class Serializer extends JsonSerializer<FundraiserInvitedUsersConnectionQueryModel> {
            public final void m13117a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FundraiserInvitedUsersConnectionQueryModel fundraiserInvitedUsersConnectionQueryModel = (FundraiserInvitedUsersConnectionQueryModel) obj;
                if (fundraiserInvitedUsersConnectionQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fundraiserInvitedUsersConnectionQueryModel.m13120a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fundraiserInvitedUsersConnectionQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fundraiserInvitedUsersConnectionQueryModel.w_();
                int u_ = fundraiserInvitedUsersConnectionQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                int g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("invited_users");
                    InvitedUsersParser.m13179a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FundraiserInvitedUsersConnectionQueryModel.class, new Serializer());
            }
        }

        public FundraiserInvitedUsersConnectionQueryModel() {
            super(3);
        }

        public final void m13123a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m13124a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m13118k() {
            if (this.b != null && this.f12662d == null) {
                this.f12662d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f12662d;
        }

        @Nullable
        private String m13119l() {
            this.f12663e = super.a(this.f12663e, 1);
            return this.f12663e;
        }

        @Nullable
        public final InvitedUsersModel m13125j() {
            this.f12664f = (InvitedUsersModel) super.a(this.f12664f, 2, InvitedUsersModel.class);
            return this.f12664f;
        }

        @Nullable
        public final String m13122a() {
            return m13119l();
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m13121a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m13125j() != null) {
                InvitedUsersModel invitedUsersModel = (InvitedUsersModel) graphQLModelMutatingVisitor.b(m13125j());
                if (m13125j() != invitedUsersModel) {
                    graphQLVisitableModel = (FundraiserInvitedUsersConnectionQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12664f = invitedUsersModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m13120a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m13118k());
            int b = flatBufferBuilder.b(m13119l());
            int a2 = ModelHelper.a(flatBufferBuilder, m13125j());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 495187951)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: PAGE_PHOTOS_BY */
    public final class FundraiserNonDonorsConnectionQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f12668d;
        @Nullable
        private String f12669e;
        @Nullable
        private InvitedUsersModel f12670f;

        /* compiled from: PAGE_PHOTOS_BY */
        public class Deserializer extends FbJsonDeserializer {
            public Deserializer() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = this;
                r0.<init>();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserNonDonorsConnectionQueryModel.Deserializer.<init>():void");
            }

            static {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserNonDonorsConnectionQueryModel.class;
                r1 = new com.facebook.socialgood.guestlist.FundraiserGuestListModels$FundraiserNonDonorsConnectionQueryModel$Deserializer;
                r1.<init>();
                com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserNonDonorsConnectionQueryModel.Deserializer.<clinit>():void");
            }

            public java.lang.Object m13126a(com.fasterxml.jackson.core.JsonParser r6, com.fasterxml.jackson.databind.DeserializationContext r7) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r5 = this;
                r2 = com.facebook.socialgood.guestlist.FundraiserGuestListParsers.FundraiserNonDonorsConnectionQueryParser.m13185a(r6);
                r1 = new com.facebook.socialgood.guestlist.FundraiserGuestListModels$FundraiserNonDonorsConnectionQueryModel;
                r1.<init>();
                r4 = r2.a;
                r0 = r4;
                r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                r0 = r1;
                r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                r0.a(r2, r3, r6);
                r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                if (r0 == 0) goto L_0x0020;
            L_0x001a:
                r1 = (com.facebook.common.json.Postprocessable) r1;
                r1 = r1.a();
            L_0x0020:
                return r1;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserNonDonorsConnectionQueryModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -218155777)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: PAGE_PHOTOS_BY */
        public final class InvitedUsersModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f12666d;
            @Nullable
            private DefaultPageInfoTailFieldsModel f12667e;

            /* compiled from: PAGE_PHOTOS_BY */
            public class Deserializer extends FbJsonDeserializer {
                public Deserializer() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = this;
                    r0.<init>();
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserNonDonorsConnectionQueryModel.InvitedUsersModel.Deserializer.<init>():void");
                }

                static {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserNonDonorsConnectionQueryModel.InvitedUsersModel.class;
                    r1 = new com.facebook.socialgood.guestlist.FundraiserGuestListModels$FundraiserNonDonorsConnectionQueryModel$InvitedUsersModel$Deserializer;
                    r1.<init>();
                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserNonDonorsConnectionQueryModel.InvitedUsersModel.Deserializer.<clinit>():void");
                }

                public java.lang.Object m13127a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r10 = this;
                    r8 = 1;
                    r6 = 0;
                    r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r4.<init>(r5);
                    r5 = com.facebook.socialgood.guestlist.FundraiserGuestListParsers.FundraiserNonDonorsConnectionQueryParser.InvitedUsersParser.m13183a(r11, r4);
                    r4.d(r5);
                    r4 = r4.e();
                    r5 = java.nio.ByteBuffer.wrap(r4);
                    r4 = 0;
                    r5.position(r4);
                    r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                    r7 = r6;
                    r9 = r6;
                    r4.<init>(r5, r6, r7, r8, r9);
                    r5 = 4;
                    r6 = java.lang.Boolean.valueOf(r8);
                    r4.a(r5, r6);
                    r2 = r4;
                    r1 = new com.facebook.socialgood.guestlist.FundraiserGuestListModels$FundraiserNonDonorsConnectionQueryModel$InvitedUsersModel;
                    r1.<init>();
                    r4 = r2.a;
                    r0 = r4;
                    r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                    r0 = r1;
                    r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                    r0.a(r2, r3, r11);
                    r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                    if (r0 == 0) goto L_0x0048;
                L_0x0042:
                    r1 = (com.facebook.common.json.Postprocessable) r1;
                    r1 = r1.a();
                L_0x0048:
                    return r1;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserNonDonorsConnectionQueryModel.InvitedUsersModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 2133397961)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: PAGE_PHOTOS_BY */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private FundraiserConnectionsFragmentModel f12665d;

                /* compiled from: PAGE_PHOTOS_BY */
                public class Deserializer extends FbJsonDeserializer {
                    public Deserializer() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = this;
                        r0.<init>();
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserNonDonorsConnectionQueryModel.InvitedUsersModel.EdgesModel.Deserializer.<init>():void");
                    }

                    static {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserNonDonorsConnectionQueryModel.InvitedUsersModel.EdgesModel.class;
                        r1 = new com.facebook.socialgood.guestlist.FundraiserGuestListModels$FundraiserNonDonorsConnectionQueryModel$InvitedUsersModel$EdgesModel$Deserializer;
                        r1.<init>();
                        com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserNonDonorsConnectionQueryModel.InvitedUsersModel.EdgesModel.Deserializer.<clinit>():void");
                    }

                    public java.lang.Object m13128a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r10 = this;
                        r8 = 1;
                        r6 = 0;
                        r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r4.<init>(r5);
                        r5 = com.facebook.socialgood.guestlist.FundraiserGuestListParsers.FundraiserNonDonorsConnectionQueryParser.InvitedUsersParser.EdgesParser.m13181b(r11, r4);
                        r4.d(r5);
                        r4 = r4.e();
                        r5 = java.nio.ByteBuffer.wrap(r4);
                        r4 = 0;
                        r5.position(r4);
                        r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                        r7 = r6;
                        r9 = r6;
                        r4.<init>(r5, r6, r7, r8, r9);
                        r5 = 4;
                        r6 = java.lang.Boolean.valueOf(r8);
                        r4.a(r5, r6);
                        r2 = r4;
                        r1 = new com.facebook.socialgood.guestlist.FundraiserGuestListModels$FundraiserNonDonorsConnectionQueryModel$InvitedUsersModel$EdgesModel;
                        r1.<init>();
                        r4 = r2.a;
                        r0 = r4;
                        r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                        r0 = r1;
                        r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                        r0.a(r2, r3, r11);
                        r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                        if (r0 == 0) goto L_0x0048;
                    L_0x0042:
                        r1 = (com.facebook.common.json.Postprocessable) r1;
                        r1 = r1.a();
                    L_0x0048:
                        return r1;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserNonDonorsConnectionQueryModel.InvitedUsersModel.EdgesModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                    }
                }

                /* compiled from: PAGE_PHOTOS_BY */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public Serializer() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = this;
                        r0.<init>();
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserNonDonorsConnectionQueryModel.InvitedUsersModel.EdgesModel.Serializer.<init>():void");
                    }

                    public final void m13129a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r7 = this;
                        r8 = (com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserNonDonorsConnectionQueryModel.InvitedUsersModel.EdgesModel) r8;
                        r2 = 0;
                        r0 = r8.w_();
                        if (r0 != 0) goto L_0x0035;
                    L_0x0009:
                        r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r0.<init>(r1);
                        r1 = r8.m13130a(r0);
                        r0.d(r1);
                        r0 = r0.e();
                        r1 = java.nio.ByteBuffer.wrap(r0);
                        r0 = 0;
                        r1.position(r0);
                        r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                        r4 = 1;
                        r3 = r2;
                        r5 = r2;
                        r0.<init>(r1, r2, r3, r4, r5);
                        r6 = r0.a;
                        r1 = r6;
                        r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                        r8.a(r0, r1);
                    L_0x0035:
                        r0 = r8.w_();
                        r1 = r8.u_();
                        com.facebook.socialgood.guestlist.FundraiserGuestListParsers.FundraiserNonDonorsConnectionQueryParser.InvitedUsersParser.EdgesParser.m13182b(r0, r1, r9, r10);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserNonDonorsConnectionQueryModel.InvitedUsersModel.EdgesModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                    }

                    static {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserNonDonorsConnectionQueryModel.InvitedUsersModel.EdgesModel.class;
                        r1 = new com.facebook.socialgood.guestlist.FundraiserGuestListModels$FundraiserNonDonorsConnectionQueryModel$InvitedUsersModel$EdgesModel$Serializer;
                        r1.<init>();
                        com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserNonDonorsConnectionQueryModel.InvitedUsersModel.EdgesModel.Serializer.<clinit>():void");
                    }
                }

                public EdgesModel() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = 1;
                    r1.<init>(r0);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserNonDonorsConnectionQueryModel.InvitedUsersModel.EdgesModel.<init>():void");
                }

                @javax.annotation.Nullable
                public final com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserConnectionsFragmentModel m13132a() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r3 = this;
                    r0 = r3.f12665d;
                    r1 = 0;
                    r2 = com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserConnectionsFragmentModel.class;
                    r0 = super.a(r0, r1, r2);
                    r0 = (com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserConnectionsFragmentModel) r0;
                    r3.f12665d = r0;
                    r0 = r3.f12665d;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserNonDonorsConnectionQueryModel.InvitedUsersModel.EdgesModel.a():com.facebook.socialgood.guestlist.FundraiserGuestListModels$FundraiserConnectionsFragmentModel");
                }

                public final int jK_() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = -2030700222; // 0xffffffff86f5f942 float:-9.252501E-35 double:NaN;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserNonDonorsConnectionQueryModel.InvitedUsersModel.EdgesModel.jK_():int");
                }

                public final com.facebook.graphql.visitor.GraphQLVisitableModel m13131a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r3 = this;
                    r1 = 0;
                    r3.h();
                    r0 = r3.m13132a();
                    if (r0 == 0) goto L_0x0022;
                L_0x000a:
                    r0 = r3.m13132a();
                    r0 = r4.b(r0);
                    r0 = (com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserConnectionsFragmentModel) r0;
                    r2 = r3.m13132a();
                    if (r2 == r0) goto L_0x0022;
                L_0x001a:
                    r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                    r1 = (com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserNonDonorsConnectionQueryModel.InvitedUsersModel.EdgesModel) r1;
                    r1.f12665d = r0;
                L_0x0022:
                    r3.i();
                    if (r1 != 0) goto L_0x0028;
                L_0x0027:
                    return r3;
                L_0x0028:
                    r3 = r1;
                    goto L_0x0027;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserNonDonorsConnectionQueryModel.InvitedUsersModel.EdgesModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                }

                public final int m13130a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r2.h();
                    r0 = r2.m13132a();
                    r0 = com.facebook.graphql.modelutil.ModelHelper.a(r3, r0);
                    r1 = 1;
                    r3.c(r1);
                    r1 = 0;
                    r3.b(r1, r0);
                    r2.i();
                    r0 = r3.d();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserNonDonorsConnectionQueryModel.InvitedUsersModel.EdgesModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                }
            }

            /* compiled from: PAGE_PHOTOS_BY */
            public class Serializer extends JsonSerializer<InvitedUsersModel> {
                public Serializer() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = this;
                    r0.<init>();
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserNonDonorsConnectionQueryModel.InvitedUsersModel.Serializer.<init>():void");
                }

                public final void m13133a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r7 = this;
                    r8 = (com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserNonDonorsConnectionQueryModel.InvitedUsersModel) r8;
                    r2 = 0;
                    r0 = r8.w_();
                    if (r0 != 0) goto L_0x0035;
                L_0x0009:
                    r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r0.<init>(r1);
                    r1 = r8.m13134a(r0);
                    r0.d(r1);
                    r0 = r0.e();
                    r1 = java.nio.ByteBuffer.wrap(r0);
                    r0 = 0;
                    r1.position(r0);
                    r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                    r4 = 1;
                    r3 = r2;
                    r5 = r2;
                    r0.<init>(r1, r2, r3, r4, r5);
                    r6 = r0.a;
                    r1 = r6;
                    r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                    r8.a(r0, r1);
                L_0x0035:
                    r0 = r8.w_();
                    r1 = r8.u_();
                    com.facebook.socialgood.guestlist.FundraiserGuestListParsers.FundraiserNonDonorsConnectionQueryParser.InvitedUsersParser.m13184a(r0, r1, r9, r10);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserNonDonorsConnectionQueryModel.InvitedUsersModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                }

                static {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserNonDonorsConnectionQueryModel.InvitedUsersModel.class;
                    r1 = new com.facebook.socialgood.guestlist.FundraiserGuestListModels$FundraiserNonDonorsConnectionQueryModel$InvitedUsersModel$Serializer;
                    r1.<init>();
                    com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserNonDonorsConnectionQueryModel.InvitedUsersModel.Serializer.<clinit>():void");
                }
            }

            public InvitedUsersModel() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = 2;
                r1.<init>(r0);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserNonDonorsConnectionQueryModel.InvitedUsersModel.<init>():void");
            }

            @javax.annotation.Nonnull
            public final com.google.common.collect.ImmutableList<com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserNonDonorsConnectionQueryModel.InvitedUsersModel.EdgesModel> m13136a() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r0 = r3.f12666d;
                r1 = 0;
                r2 = com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserNonDonorsConnectionQueryModel.InvitedUsersModel.EdgesModel.class;
                r0 = super.a(r0, r1, r2);
                r3.f12666d = r0;
                r0 = r3.f12666d;
                r0 = (com.google.common.collect.ImmutableList) r0;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserNonDonorsConnectionQueryModel.InvitedUsersModel.a():com.google.common.collect.ImmutableList<com.facebook.socialgood.guestlist.FundraiserGuestListModels$FundraiserNonDonorsConnectionQueryModel$InvitedUsersModel$EdgesModel>");
            }

            @javax.annotation.Nullable
            public final com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoTailFieldsModel m13137j() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r0 = r3.f12667e;
                r1 = 1;
                r2 = com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoTailFieldsModel.class;
                r0 = super.a(r0, r1, r2);
                r0 = (com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoTailFieldsModel) r0;
                r3.f12667e = r0;
                r0 = r3.f12667e;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserNonDonorsConnectionQueryModel.InvitedUsersModel.j():com.facebook.graphql.querybuilder.common.CommonGraphQL2Models$DefaultPageInfoTailFieldsModel");
            }

            public final int jK_() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = 701731491; // 0x29d392a3 float:9.39572E-14 double:3.467014223E-315;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserNonDonorsConnectionQueryModel.InvitedUsersModel.jK_():int");
            }

            public final com.facebook.graphql.visitor.GraphQLVisitableModel m13135a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r0 = 0;
                r3.h();
                r1 = r3.m13136a();
                if (r1 == 0) goto L_0x0047;
            L_0x000a:
                r1 = r3.m13136a();
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r4);
                if (r1 == 0) goto L_0x0047;
            L_0x0014:
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r3);
                r0 = (com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserNonDonorsConnectionQueryModel.InvitedUsersModel) r0;
                r1 = r1.b();
                r0.f12666d = r1;
                r1 = r0;
            L_0x0021:
                r0 = r3.m13137j();
                if (r0 == 0) goto L_0x003f;
            L_0x0027:
                r0 = r3.m13137j();
                r0 = r4.b(r0);
                r0 = (com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoTailFieldsModel) r0;
                r2 = r3.m13137j();
                if (r2 == r0) goto L_0x003f;
            L_0x0037:
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                r1 = (com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserNonDonorsConnectionQueryModel.InvitedUsersModel) r1;
                r1.f12667e = r0;
            L_0x003f:
                r3.i();
                if (r1 != 0) goto L_0x0045;
            L_0x0044:
                return r3;
            L_0x0045:
                r3 = r1;
                goto L_0x0044;
            L_0x0047:
                r1 = r0;
                goto L_0x0021;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserNonDonorsConnectionQueryModel.InvitedUsersModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
            }

            public final int m13134a(com.facebook.flatbuffers.FlatBufferBuilder r4) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r3.h();
                r0 = r3.m13136a();
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r4, r0);
                r1 = r3.m13137j();
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r4, r1);
                r2 = 2;
                r4.c(r2);
                r2 = 0;
                r4.b(r2, r0);
                r0 = 1;
                r4.b(r0, r1);
                r3.i();
                r0 = r4.d();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserNonDonorsConnectionQueryModel.InvitedUsersModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
            }
        }

        /* compiled from: PAGE_PHOTOS_BY */
        public class Serializer extends JsonSerializer<FundraiserNonDonorsConnectionQueryModel> {
            public Serializer() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = this;
                r0.<init>();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserNonDonorsConnectionQueryModel.Serializer.<init>():void");
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void m13138a(java.lang.Object r10, com.fasterxml.jackson.core.JsonGenerator r11, com.fasterxml.jackson.databind.SerializerProvider r12) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r9 = this;
                r10 = (com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserNonDonorsConnectionQueryModel) r10;
                r2 = null;
                r0 = r10.w_();
                if (r0 != null) goto L_0x0035;
            L_0x0009:
                r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                r1 = 128;
                r0.<init>(r1);
                r1 = r10.m13141a(r0);
                r0.d(r1);
                r0 = r0.e();
                r1 = java.nio.ByteBuffer.wrap(r0);
                r0 = null;
                r1.position(r0);
                r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                r4 = 1;
                r3 = r2;
                r5 = r2;
                r0.<init>(r1, r2, r3, r4, r5);
                r6 = r0.a;
                r1 = r6;
                r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                r10.a(r0, r1);
            L_0x0035:
                r0 = r10.w_();
                r1 = r10.u_();
                r8 = 1;
                r7 = null;
                r11.f();
                r6 = r0.g(r1, r7);
                if (r6 == null) goto L_0x0050;
            L_0x0048:
                r6 = "__type__";
                r11.a(r6);
                com.facebook.graphql.modelutil.SerializerHelpers.b(r0, r1, r7, r11);
            L_0x0050:
                r6 = r0.g(r1, r8);
                if (r6 == null) goto L_0x0062;
            L_0x0056:
                r6 = "id";
                r11.a(r6);
                r6 = r0.c(r1, r8);
                r11.b(r6);
            L_0x0062:
                r6 = 2;
                r6 = r0.g(r1, r6);
                if (r6 == null) goto L_0x0071;
            L_0x0069:
                r7 = "invited_users";
                r11.a(r7);
                com.facebook.socialgood.guestlist.FundraiserGuestListParsers.FundraiserNonDonorsConnectionQueryParser.InvitedUsersParser.m13184a(r0, r6, r11, r12);
            L_0x0071:
                r11.g();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserNonDonorsConnectionQueryModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
            }

            static {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserNonDonorsConnectionQueryModel.class;
                r1 = new com.facebook.socialgood.guestlist.FundraiserGuestListModels$FundraiserNonDonorsConnectionQueryModel$Serializer;
                r1.<init>();
                com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserNonDonorsConnectionQueryModel.Serializer.<clinit>():void");
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public FundraiserNonDonorsConnectionQueryModel() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = 3;
            r1.<init>(r0);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserNonDonorsConnectionQueryModel.<init>():void");
        }

        public final void m13144a(java.lang.String r1, com.facebook.graphql.visitor.ConsistencyTuple r2) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = this;
            r2.a();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserNonDonorsConnectionQueryModel.a(java.lang.String, com.facebook.graphql.visitor.ConsistencyTuple):void");
        }

        public final void m13145a(java.lang.String r1, java.lang.Object r2, boolean r3) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = this;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserNonDonorsConnectionQueryModel.a(java.lang.String, java.lang.Object, boolean):void");
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        @javax.annotation.Nullable
        private com.facebook.graphql.enums.GraphQLObjectType m13139k() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r4 = this;
            r0 = r4.b;
            if (r0 == null) goto L_0x0017;
        L_0x0004:
            r0 = r4.f12668d;
            if (r0 != null) goto L_0x0017;
        L_0x0008:
            r0 = r4.b;
            r1 = r4.c;
            r2 = null;
            r3 = com.facebook.graphql.enums.GraphQLObjectType.class;
            r0 = r0.d(r1, r2, r3);
            r0 = (com.facebook.graphql.enums.GraphQLObjectType) r0;
            r4.f12668d = r0;
        L_0x0017:
            r0 = r4.f12668d;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserNonDonorsConnectionQueryModel.k():com.facebook.graphql.enums.GraphQLObjectType");
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        @javax.annotation.Nullable
        private java.lang.String m13140l() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r0 = r2.f12669e;
            r1 = 1;
            r0 = super.a(r0, r1);
            r2.f12669e = r0;
            r0 = r2.f12669e;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserNonDonorsConnectionQueryModel.l():java.lang.String");
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        @javax.annotation.Nullable
        public final com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserNonDonorsConnectionQueryModel.InvitedUsersModel m13146j() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r0 = r3.f12670f;
            r1 = 2;
            r2 = com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserNonDonorsConnectionQueryModel.InvitedUsersModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserNonDonorsConnectionQueryModel.InvitedUsersModel) r0;
            r3.f12670f = r0;
            r0 = r3.f12670f;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserNonDonorsConnectionQueryModel.j():com.facebook.socialgood.guestlist.FundraiserGuestListModels$FundraiserNonDonorsConnectionQueryModel$InvitedUsersModel");
        }

        @javax.annotation.Nullable
        public final java.lang.String m13143a() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = r1.m13140l();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserNonDonorsConnectionQueryModel.a():java.lang.String");
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final int jK_() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = 2433570;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserNonDonorsConnectionQueryModel.jK_():int");
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.facebook.graphql.visitor.GraphQLVisitableModel m13142a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r1 = null;
            r3.h();
            r0 = r3.m13146j();
            if (r0 == null) goto L_0x0022;
        L_0x000a:
            r0 = r3.m13146j();
            r0 = r4.b(r0);
            r0 = (com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserNonDonorsConnectionQueryModel.InvitedUsersModel) r0;
            r2 = r3.m13146j();
            if (r2 == r0) goto L_0x0022;
        L_0x001a:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserNonDonorsConnectionQueryModel) r1;
            r1.f12670f = r0;
        L_0x0022:
            r3.i();
            if (r1 != null) goto L_0x0028;
        L_0x0027:
            return r3;
        L_0x0028:
            r3 = r1;
            goto L_0x0027;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserNonDonorsConnectionQueryModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final int m13141a(com.facebook.flatbuffers.FlatBufferBuilder r5) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r4 = this;
            r4.h();
            r0 = r4.m13139k();
            r0 = com.facebook.graphql.modelutil.ModelHelper.a(r5, r0);
            r1 = r4.m13140l();
            r1 = r5.b(r1);
            r2 = r4.m13146j();
            r2 = com.facebook.graphql.modelutil.ModelHelper.a(r5, r2);
            r3 = 3;
            r5.c(r3);
            r3 = null;
            r5.b(r3, r0);
            r0 = 1;
            r5.b(r0, r1);
            r0 = 2;
            r5.b(r0, r2);
            r4.i();
            r0 = r5.d();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserNonDonorsConnectionQueryModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1155949171)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: PAGE_PHOTOS_BY */
    public final class FundraiserSharersConnectionQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f12673d;
        @Nullable
        private String f12674e;
        @Nullable
        private SharersModel f12675f;

        /* compiled from: PAGE_PHOTOS_BY */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FundraiserSharersConnectionQueryModel.class, new Deserializer());
            }

            public Object m13147a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FundraiserSharersConnectionQueryParser.m13188a(jsonParser);
                Object fundraiserSharersConnectionQueryModel = new FundraiserSharersConnectionQueryModel();
                ((BaseModel) fundraiserSharersConnectionQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fundraiserSharersConnectionQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fundraiserSharersConnectionQueryModel).a();
                }
                return fundraiserSharersConnectionQueryModel;
            }
        }

        /* compiled from: PAGE_PHOTOS_BY */
        public class Serializer extends JsonSerializer<FundraiserSharersConnectionQueryModel> {
            public final void m13148a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FundraiserSharersConnectionQueryModel fundraiserSharersConnectionQueryModel = (FundraiserSharersConnectionQueryModel) obj;
                if (fundraiserSharersConnectionQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fundraiserSharersConnectionQueryModel.m13157a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fundraiserSharersConnectionQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fundraiserSharersConnectionQueryModel.w_();
                int u_ = fundraiserSharersConnectionQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                int g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("sharers");
                    SharersParser.m13187a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FundraiserSharersConnectionQueryModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1283865783)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: PAGE_PHOTOS_BY */
        public final class SharersModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<FundraiserConnectionsFragmentModel> f12671d;
            @Nullable
            private DefaultPageInfoTailFieldsModel f12672e;

            /* compiled from: PAGE_PHOTOS_BY */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SharersModel.class, new Deserializer());
                }

                public Object m13149a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SharersParser.m13186a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object sharersModel = new SharersModel();
                    ((BaseModel) sharersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (sharersModel instanceof Postprocessable) {
                        return ((Postprocessable) sharersModel).a();
                    }
                    return sharersModel;
                }
            }

            /* compiled from: PAGE_PHOTOS_BY */
            public class Serializer extends JsonSerializer<SharersModel> {
                public final void m13150a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SharersModel sharersModel = (SharersModel) obj;
                    if (sharersModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(sharersModel.m13151a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        sharersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SharersParser.m13187a(sharersModel.w_(), sharersModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(SharersModel.class, new Serializer());
                }
            }

            public SharersModel() {
                super(2);
            }

            @Nonnull
            public final ImmutableList<FundraiserConnectionsFragmentModel> m13153a() {
                this.f12671d = super.a(this.f12671d, 0, FundraiserConnectionsFragmentModel.class);
                return (ImmutableList) this.f12671d;
            }

            @Nullable
            public final DefaultPageInfoTailFieldsModel m13154j() {
                this.f12672e = (DefaultPageInfoTailFieldsModel) super.a(this.f12672e, 1, DefaultPageInfoTailFieldsModel.class);
                return this.f12672e;
            }

            public final int jK_() {
                return -1727174463;
            }

            public final GraphQLVisitableModel m13152a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                DefaultPageInfoTailFieldsModel defaultPageInfoTailFieldsModel;
                h();
                if (m13153a() != null) {
                    Builder a = ModelHelper.a(m13153a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        SharersModel sharersModel = (SharersModel) ModelHelper.a(null, this);
                        sharersModel.f12671d = a.b();
                        graphQLVisitableModel = sharersModel;
                        if (m13154j() != null) {
                            defaultPageInfoTailFieldsModel = (DefaultPageInfoTailFieldsModel) graphQLModelMutatingVisitor.b(m13154j());
                            if (m13154j() != defaultPageInfoTailFieldsModel) {
                                graphQLVisitableModel = (SharersModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f12672e = defaultPageInfoTailFieldsModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m13154j() != null) {
                    defaultPageInfoTailFieldsModel = (DefaultPageInfoTailFieldsModel) graphQLModelMutatingVisitor.b(m13154j());
                    if (m13154j() != defaultPageInfoTailFieldsModel) {
                        graphQLVisitableModel = (SharersModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f12672e = defaultPageInfoTailFieldsModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m13151a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m13153a());
                int a2 = ModelHelper.a(flatBufferBuilder, m13154j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        public FundraiserSharersConnectionQueryModel() {
            super(3);
        }

        public final void m13160a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m13161a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m13155k() {
            if (this.b != null && this.f12673d == null) {
                this.f12673d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f12673d;
        }

        @Nullable
        private String m13156l() {
            this.f12674e = super.a(this.f12674e, 1);
            return this.f12674e;
        }

        @Nullable
        public final SharersModel m13162j() {
            this.f12675f = (SharersModel) super.a(this.f12675f, 2, SharersModel.class);
            return this.f12675f;
        }

        @Nullable
        public final String m13159a() {
            return m13156l();
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m13158a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m13162j() != null) {
                SharersModel sharersModel = (SharersModel) graphQLModelMutatingVisitor.b(m13162j());
                if (m13162j() != sharersModel) {
                    graphQLVisitableModel = (FundraiserSharersConnectionQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12675f = sharersModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m13157a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m13155k());
            int b = flatBufferBuilder.b(m13156l());
            int a2 = ModelHelper.a(flatBufferBuilder, m13162j());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}

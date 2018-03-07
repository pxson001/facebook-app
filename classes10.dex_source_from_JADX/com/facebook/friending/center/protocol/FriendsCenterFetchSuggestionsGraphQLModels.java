package com.facebook.friending.center.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.friending.center.protocol.FriendsCenterDefaultFieldsGraphQLModels.FriendsCenterDefaultNodeModel;
import com.facebook.friending.center.protocol.FriendsCenterFetchSuggestionsGraphQLParsers.FriendsCenterFetchSuggestionsQueryParser;
import com.facebook.friending.center.protocol.FriendsCenterFetchSuggestionsGraphQLParsers.FriendsCenterFetchSuggestionsQueryParser.PeopleYouMayKnowParser;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
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

/* compiled from: ads_experience_decline */
public class FriendsCenterFetchSuggestionsGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1128334475)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: ads_experience_decline */
    public final class FriendsCenterFetchSuggestionsQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private PeopleYouMayKnowModel f20037d;

        /* compiled from: ads_experience_decline */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FriendsCenterFetchSuggestionsQueryModel.class, new Deserializer());
            }

            public Object m20291a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FriendsCenterFetchSuggestionsQueryParser.m20304a(jsonParser);
                Object friendsCenterFetchSuggestionsQueryModel = new FriendsCenterFetchSuggestionsQueryModel();
                ((BaseModel) friendsCenterFetchSuggestionsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (friendsCenterFetchSuggestionsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) friendsCenterFetchSuggestionsQueryModel).a();
                }
                return friendsCenterFetchSuggestionsQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1065753298)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: ads_experience_decline */
        public final class PeopleYouMayKnowModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<FriendsCenterDefaultNodeModel> f20035d;
            @Nullable
            private DefaultPageInfoFieldsModel f20036e;

            /* compiled from: ads_experience_decline */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PeopleYouMayKnowModel.class, new Deserializer());
                }

                public Object m20292a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PeopleYouMayKnowParser.m20302a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object peopleYouMayKnowModel = new PeopleYouMayKnowModel();
                    ((BaseModel) peopleYouMayKnowModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (peopleYouMayKnowModel instanceof Postprocessable) {
                        return ((Postprocessable) peopleYouMayKnowModel).a();
                    }
                    return peopleYouMayKnowModel;
                }
            }

            /* compiled from: ads_experience_decline */
            public class Serializer extends JsonSerializer<PeopleYouMayKnowModel> {
                public final void m20293a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PeopleYouMayKnowModel peopleYouMayKnowModel = (PeopleYouMayKnowModel) obj;
                    if (peopleYouMayKnowModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(peopleYouMayKnowModel.m20294a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        peopleYouMayKnowModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PeopleYouMayKnowParser.m20303a(peopleYouMayKnowModel.w_(), peopleYouMayKnowModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PeopleYouMayKnowModel.class, new Serializer());
                }
            }

            public PeopleYouMayKnowModel() {
                super(2);
            }

            @Nonnull
            public final ImmutableList<FriendsCenterDefaultNodeModel> m20296a() {
                this.f20035d = super.a(this.f20035d, 0, FriendsCenterDefaultNodeModel.class);
                return (ImmutableList) this.f20035d;
            }

            @Nullable
            public final DefaultPageInfoFieldsModel m20297j() {
                this.f20036e = (DefaultPageInfoFieldsModel) super.a(this.f20036e, 1, DefaultPageInfoFieldsModel.class);
                return this.f20036e;
            }

            public final int jK_() {
                return 1781614462;
            }

            public final GraphQLVisitableModel m20295a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                DefaultPageInfoFieldsModel defaultPageInfoFieldsModel;
                h();
                if (m20296a() != null) {
                    Builder a = ModelHelper.a(m20296a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        PeopleYouMayKnowModel peopleYouMayKnowModel = (PeopleYouMayKnowModel) ModelHelper.a(null, this);
                        peopleYouMayKnowModel.f20035d = a.b();
                        graphQLVisitableModel = peopleYouMayKnowModel;
                        if (m20297j() != null) {
                            defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m20297j());
                            if (m20297j() != defaultPageInfoFieldsModel) {
                                graphQLVisitableModel = (PeopleYouMayKnowModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f20036e = defaultPageInfoFieldsModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m20297j() != null) {
                    defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m20297j());
                    if (m20297j() != defaultPageInfoFieldsModel) {
                        graphQLVisitableModel = (PeopleYouMayKnowModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f20036e = defaultPageInfoFieldsModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m20294a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m20296a());
                int a2 = ModelHelper.a(flatBufferBuilder, m20297j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: ads_experience_decline */
        public class Serializer extends JsonSerializer<FriendsCenterFetchSuggestionsQueryModel> {
            public final void m20298a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FriendsCenterFetchSuggestionsQueryModel friendsCenterFetchSuggestionsQueryModel = (FriendsCenterFetchSuggestionsQueryModel) obj;
                if (friendsCenterFetchSuggestionsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(friendsCenterFetchSuggestionsQueryModel.m20299a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    friendsCenterFetchSuggestionsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = friendsCenterFetchSuggestionsQueryModel.w_();
                int u_ = friendsCenterFetchSuggestionsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("people_you_may_know");
                    PeopleYouMayKnowParser.m20303a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FriendsCenterFetchSuggestionsQueryModel.class, new Serializer());
            }
        }

        public FriendsCenterFetchSuggestionsQueryModel() {
            super(1);
        }

        @Nullable
        public final PeopleYouMayKnowModel m20300a() {
            this.f20037d = (PeopleYouMayKnowModel) super.a(this.f20037d, 0, PeopleYouMayKnowModel.class);
            return this.f20037d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m20301a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m20300a() != null) {
                PeopleYouMayKnowModel peopleYouMayKnowModel = (PeopleYouMayKnowModel) graphQLModelMutatingVisitor.b(m20300a());
                if (m20300a() != peopleYouMayKnowModel) {
                    graphQLVisitableModel = (FriendsCenterFetchSuggestionsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f20037d = peopleYouMayKnowModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m20299a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m20300a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}

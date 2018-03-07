package com.facebook.friends.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.friends.protocol.FetchPeopleYouMayKnowGraphQLParsers.PeopleYouMayKnowQueryParser;
import com.facebook.friends.protocol.FetchPeopleYouMayKnowGraphQLParsers.PeopleYouMayKnowQueryParser.PeopleYouMayKnowParser;
import com.facebook.friends.protocol.FetchPeopleYouMayKnowGraphQLParsers.PersonYouMayKnowEdgeParser;
import com.facebook.friends.protocol.FetchPeopleYouMayKnowGraphQLParsers.PersonYouMayKnowFieldsParser;
import com.facebook.friends.protocol.FetchPeopleYouMayKnowGraphQLParsers.PersonYouMayKnowFieldsParser.MutualFriendsParser;
import com.facebook.friends.protocol.FetchPeopleYouMayKnowGraphQLParsers.PersonYouMayKnowFieldsParser.ProfilePictureParser;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
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
import com.google.common.collect.ImmutableList.Builder;
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: makeCurrent failed in onVSync */
public class FetchPeopleYouMayKnowGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1207982696)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: makeCurrent failed in onVSync */
    public final class PeopleYouMayKnowQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private PeopleYouMayKnowModel f10725d;

        /* compiled from: makeCurrent failed in onVSync */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PeopleYouMayKnowQueryModel.class, new Deserializer());
            }

            public Object m17008a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PeopleYouMayKnowQueryParser.m17052a(jsonParser);
                Object peopleYouMayKnowQueryModel = new PeopleYouMayKnowQueryModel();
                ((BaseModel) peopleYouMayKnowQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (peopleYouMayKnowQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) peopleYouMayKnowQueryModel).a();
                }
                return peopleYouMayKnowQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1097838636)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: makeCurrent failed in onVSync */
        public final class PeopleYouMayKnowModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<PersonYouMayKnowEdgeModel> f10723d;
            @Nullable
            private DefaultPageInfoFieldsModel f10724e;

            /* compiled from: makeCurrent failed in onVSync */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PeopleYouMayKnowModel.class, new Deserializer());
                }

                public Object m17009a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PeopleYouMayKnowParser.m17050a(jsonParser, flatBufferBuilder));
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

            /* compiled from: makeCurrent failed in onVSync */
            public class Serializer extends JsonSerializer<PeopleYouMayKnowModel> {
                public final void m17010a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PeopleYouMayKnowModel peopleYouMayKnowModel = (PeopleYouMayKnowModel) obj;
                    if (peopleYouMayKnowModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(peopleYouMayKnowModel.m17011a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        peopleYouMayKnowModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PeopleYouMayKnowParser.m17051a(peopleYouMayKnowModel.w_(), peopleYouMayKnowModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PeopleYouMayKnowModel.class, new Serializer());
                }
            }

            public PeopleYouMayKnowModel() {
                super(2);
            }

            @Nonnull
            public final ImmutableList<PersonYouMayKnowEdgeModel> m17013a() {
                this.f10723d = super.a(this.f10723d, 0, PersonYouMayKnowEdgeModel.class);
                return (ImmutableList) this.f10723d;
            }

            @Nullable
            public final DefaultPageInfoFieldsModel m17014j() {
                this.f10724e = (DefaultPageInfoFieldsModel) super.a(this.f10724e, 1, DefaultPageInfoFieldsModel.class);
                return this.f10724e;
            }

            public final int jK_() {
                return 1781614462;
            }

            public final GraphQLVisitableModel m17012a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                DefaultPageInfoFieldsModel defaultPageInfoFieldsModel;
                h();
                if (m17013a() != null) {
                    Builder a = ModelHelper.a(m17013a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        PeopleYouMayKnowModel peopleYouMayKnowModel = (PeopleYouMayKnowModel) ModelHelper.a(null, this);
                        peopleYouMayKnowModel.f10723d = a.b();
                        graphQLVisitableModel = peopleYouMayKnowModel;
                        if (m17014j() != null) {
                            defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m17014j());
                            if (m17014j() != defaultPageInfoFieldsModel) {
                                graphQLVisitableModel = (PeopleYouMayKnowModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f10724e = defaultPageInfoFieldsModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m17014j() != null) {
                    defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m17014j());
                    if (m17014j() != defaultPageInfoFieldsModel) {
                        graphQLVisitableModel = (PeopleYouMayKnowModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f10724e = defaultPageInfoFieldsModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m17011a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m17013a());
                int a2 = ModelHelper.a(flatBufferBuilder, m17014j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: makeCurrent failed in onVSync */
        public class Serializer extends JsonSerializer<PeopleYouMayKnowQueryModel> {
            public final void m17015a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PeopleYouMayKnowQueryModel peopleYouMayKnowQueryModel = (PeopleYouMayKnowQueryModel) obj;
                if (peopleYouMayKnowQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(peopleYouMayKnowQueryModel.m17016a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    peopleYouMayKnowQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = peopleYouMayKnowQueryModel.w_();
                int u_ = peopleYouMayKnowQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("people_you_may_know");
                    PeopleYouMayKnowParser.m17051a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PeopleYouMayKnowQueryModel.class, new Serializer());
            }
        }

        public PeopleYouMayKnowQueryModel() {
            super(1);
        }

        @Nullable
        public final PeopleYouMayKnowModel m17017a() {
            this.f10725d = (PeopleYouMayKnowModel) super.a(this.f10725d, 0, PeopleYouMayKnowModel.class);
            return this.f10725d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m17018a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17017a() != null) {
                PeopleYouMayKnowModel peopleYouMayKnowModel = (PeopleYouMayKnowModel) graphQLModelMutatingVisitor.b(m17017a());
                if (m17017a() != peopleYouMayKnowModel) {
                    graphQLVisitableModel = (PeopleYouMayKnowQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10725d = peopleYouMayKnowModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17016a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17017a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1536466138)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: makeCurrent failed in onVSync */
    public final class PersonYouMayKnowEdgeModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private PersonYouMayKnowFieldsModel f10726d;
        @Nullable
        private String f10727e;

        /* compiled from: makeCurrent failed in onVSync */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PersonYouMayKnowEdgeModel.class, new Deserializer());
            }

            public Object m17019a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PersonYouMayKnowEdgeParser.m17053b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object personYouMayKnowEdgeModel = new PersonYouMayKnowEdgeModel();
                ((BaseModel) personYouMayKnowEdgeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (personYouMayKnowEdgeModel instanceof Postprocessable) {
                    return ((Postprocessable) personYouMayKnowEdgeModel).a();
                }
                return personYouMayKnowEdgeModel;
            }
        }

        /* compiled from: makeCurrent failed in onVSync */
        public class Serializer extends JsonSerializer<PersonYouMayKnowEdgeModel> {
            public final void m17020a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PersonYouMayKnowEdgeModel personYouMayKnowEdgeModel = (PersonYouMayKnowEdgeModel) obj;
                if (personYouMayKnowEdgeModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(personYouMayKnowEdgeModel.m17021a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    personYouMayKnowEdgeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PersonYouMayKnowEdgeParser.m17054b(personYouMayKnowEdgeModel.w_(), personYouMayKnowEdgeModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PersonYouMayKnowEdgeModel.class, new Serializer());
            }
        }

        public PersonYouMayKnowEdgeModel() {
            super(2);
        }

        @Nullable
        public final PersonYouMayKnowFieldsModel m17022a() {
            this.f10726d = (PersonYouMayKnowFieldsModel) super.a(this.f10726d, 0, PersonYouMayKnowFieldsModel.class);
            return this.f10726d;
        }

        @Nullable
        public final String m17024j() {
            this.f10727e = super.a(this.f10727e, 1);
            return this.f10727e;
        }

        public final int jK_() {
            return 2038902365;
        }

        public final GraphQLVisitableModel m17023a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17022a() != null) {
                PersonYouMayKnowFieldsModel personYouMayKnowFieldsModel = (PersonYouMayKnowFieldsModel) graphQLModelMutatingVisitor.b(m17022a());
                if (m17022a() != personYouMayKnowFieldsModel) {
                    graphQLVisitableModel = (PersonYouMayKnowEdgeModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10726d = personYouMayKnowFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17021a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17022a());
            int b = flatBufferBuilder.b(m17024j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 671558514)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: makeCurrent failed in onVSync */
    public final class PersonYouMayKnowFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f10730d;
        @Nullable
        private GraphQLFriendshipStatus f10731e;
        @Nullable
        private String f10732f;
        @Nullable
        private MutualFriendsModel f10733g;
        @Nullable
        private String f10734h;
        @Nullable
        private ProfilePictureModel f10735i;

        /* compiled from: makeCurrent failed in onVSync */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PersonYouMayKnowFieldsModel.class, new Deserializer());
            }

            public Object m17025a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PersonYouMayKnowFieldsParser.m17059a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object personYouMayKnowFieldsModel = new PersonYouMayKnowFieldsModel();
                ((BaseModel) personYouMayKnowFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (personYouMayKnowFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) personYouMayKnowFieldsModel).a();
                }
                return personYouMayKnowFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: makeCurrent failed in onVSync */
        public final class MutualFriendsModel extends BaseModel implements GraphQLVisitableModel {
            private int f10728d;

            /* compiled from: makeCurrent failed in onVSync */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MutualFriendsModel.class, new Deserializer());
                }

                public Object m17026a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MutualFriendsParser.m17055a(jsonParser, flatBufferBuilder));
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

            /* compiled from: makeCurrent failed in onVSync */
            public class Serializer extends JsonSerializer<MutualFriendsModel> {
                public final void m17027a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MutualFriendsModel mutualFriendsModel = (MutualFriendsModel) obj;
                    if (mutualFriendsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(mutualFriendsModel.m17029a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutualFriendsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MutualFriendsParser.m17056a(mutualFriendsModel.w_(), mutualFriendsModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(MutualFriendsModel.class, new Serializer());
                }
            }

            public MutualFriendsModel() {
                super(1);
            }

            public final int m17028a() {
                a(0, 0);
                return this.f10728d;
            }

            public final int jK_() {
                return 1532278911;
            }

            public final GraphQLVisitableModel m17030a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17029a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f10728d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m17031a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f10728d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: makeCurrent failed in onVSync */
        public final class ProfilePictureModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f10729d;

            /* compiled from: makeCurrent failed in onVSync */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ProfilePictureModel.class, new Deserializer());
                }

                public Object m17032a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ProfilePictureParser.m17057a(jsonParser, flatBufferBuilder));
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

            /* compiled from: makeCurrent failed in onVSync */
            public class Serializer extends JsonSerializer<ProfilePictureModel> {
                public final void m17033a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ProfilePictureModel profilePictureModel = (ProfilePictureModel) obj;
                    if (profilePictureModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(profilePictureModel.m17034a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        profilePictureModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ProfilePictureParser.m17058a(profilePictureModel.w_(), profilePictureModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ProfilePictureModel.class, new Serializer());
                }
            }

            public ProfilePictureModel() {
                super(1);
            }

            @Nullable
            public final String m17036a() {
                this.f10729d = super.a(this.f10729d, 0);
                return this.f10729d;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m17035a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17034a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m17036a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: makeCurrent failed in onVSync */
        public class Serializer extends JsonSerializer<PersonYouMayKnowFieldsModel> {
            public final void m17037a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PersonYouMayKnowFieldsModel personYouMayKnowFieldsModel = (PersonYouMayKnowFieldsModel) obj;
                if (personYouMayKnowFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(personYouMayKnowFieldsModel.m17040a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    personYouMayKnowFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PersonYouMayKnowFieldsParser.m17060a(personYouMayKnowFieldsModel.w_(), personYouMayKnowFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PersonYouMayKnowFieldsModel.class, new Serializer());
            }
        }

        public PersonYouMayKnowFieldsModel() {
            super(6);
        }

        public final void m17043a(String str, ConsistencyTuple consistencyTuple) {
            if ("friendship_status".equals(str)) {
                consistencyTuple.a = m17045j();
                consistencyTuple.b = u_();
                consistencyTuple.c = 1;
                return;
            }
            consistencyTuple.a();
        }

        public final void m17044a(String str, Object obj, boolean z) {
            if ("friendship_status".equals(str)) {
                m17038a((GraphQLFriendshipStatus) obj);
            }
        }

        @Nullable
        private GraphQLObjectType m17039o() {
            if (this.b != null && this.f10730d == null) {
                this.f10730d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f10730d;
        }

        @Nullable
        public final GraphQLFriendshipStatus m17045j() {
            this.f10731e = (GraphQLFriendshipStatus) super.b(this.f10731e, 1, GraphQLFriendshipStatus.class, GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f10731e;
        }

        private void m17038a(GraphQLFriendshipStatus graphQLFriendshipStatus) {
            this.f10731e = graphQLFriendshipStatus;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 1, graphQLFriendshipStatus != null ? graphQLFriendshipStatus.name() : null);
            }
        }

        @Nullable
        public final String m17046k() {
            this.f10732f = super.a(this.f10732f, 2);
            return this.f10732f;
        }

        @Nullable
        public final MutualFriendsModel m17047l() {
            this.f10733g = (MutualFriendsModel) super.a(this.f10733g, 3, MutualFriendsModel.class);
            return this.f10733g;
        }

        @Nullable
        public final String m17048m() {
            this.f10734h = super.a(this.f10734h, 4);
            return this.f10734h;
        }

        @Nullable
        public final ProfilePictureModel m17049n() {
            this.f10735i = (ProfilePictureModel) super.a(this.f10735i, 5, ProfilePictureModel.class);
            return this.f10735i;
        }

        @Nullable
        public final String m17042a() {
            return m17046k();
        }

        public final int jK_() {
            return 1355227529;
        }

        public final GraphQLVisitableModel m17041a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17047l() != null) {
                MutualFriendsModel mutualFriendsModel = (MutualFriendsModel) graphQLModelMutatingVisitor.b(m17047l());
                if (m17047l() != mutualFriendsModel) {
                    graphQLVisitableModel = (PersonYouMayKnowFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10733g = mutualFriendsModel;
                }
            }
            if (m17049n() != null) {
                ProfilePictureModel profilePictureModel = (ProfilePictureModel) graphQLModelMutatingVisitor.b(m17049n());
                if (m17049n() != profilePictureModel) {
                    graphQLVisitableModel = (PersonYouMayKnowFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10735i = profilePictureModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17040a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17039o());
            int a2 = flatBufferBuilder.a(m17045j());
            int b = flatBufferBuilder.b(m17046k());
            int a3 = ModelHelper.a(flatBufferBuilder, m17047l());
            int b2 = flatBufferBuilder.b(m17048m());
            int a4 = ModelHelper.a(flatBufferBuilder, m17049n());
            flatBufferBuilder.c(6);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.b(4, b2);
            flatBufferBuilder.b(5, a4);
            i();
            return flatBufferBuilder.d();
        }
    }
}

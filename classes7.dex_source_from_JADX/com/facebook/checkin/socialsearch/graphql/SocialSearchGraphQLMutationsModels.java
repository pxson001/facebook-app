package com.facebook.checkin.socialsearch.graphql;

import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.CommentPlaceInfoAttachmentTargetModel.PlaceListItemsModel;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.CommentPlaceInfoPageFieldsModel;
import com.facebook.checkin.socialsearch.graphql.SocialSearchGraphQLMutationsParsers.AddPlaceListItemToCommentMutationParser;
import com.facebook.checkin.socialsearch.graphql.SocialSearchGraphQLMutationsParsers.CommentFieldsForPlaceMutationParser;
import com.facebook.checkin.socialsearch.graphql.SocialSearchGraphQLMutationsParsers.CommentFieldsForPlaceMutationParser.AttachmentsParser;
import com.facebook.checkin.socialsearch.graphql.SocialSearchGraphQLMutationsParsers.CommentFieldsForPlaceMutationParser.AttachmentsParser.TargetParser;
import com.facebook.checkin.socialsearch.graphql.SocialSearchGraphQLMutationsParsers.CommentFieldsForPlaceMutationParser.ParentFeedbackParser;
import com.facebook.checkin.socialsearch.graphql.SocialSearchGraphQLMutationsParsers.DeletePlaceRecommendationFromCommentMutationParser;
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

/* compiled from: uncroppedMediaWidth */
public class SocialSearchGraphQLMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -577852613)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: uncroppedMediaWidth */
    public final class AddPlaceListItemToCommentMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private CommentFieldsForPlaceMutationModel f1123d;

        /* compiled from: uncroppedMediaWidth */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AddPlaceListItemToCommentMutationModel.class, new Deserializer());
            }

            public Object m1165a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = AddPlaceListItemToCommentMutationParser.m1208a(jsonParser);
                Object addPlaceListItemToCommentMutationModel = new AddPlaceListItemToCommentMutationModel();
                ((BaseModel) addPlaceListItemToCommentMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (addPlaceListItemToCommentMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) addPlaceListItemToCommentMutationModel).a();
                }
                return addPlaceListItemToCommentMutationModel;
            }
        }

        /* compiled from: uncroppedMediaWidth */
        public class Serializer extends JsonSerializer<AddPlaceListItemToCommentMutationModel> {
            public final void m1166a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                AddPlaceListItemToCommentMutationModel addPlaceListItemToCommentMutationModel = (AddPlaceListItemToCommentMutationModel) obj;
                if (addPlaceListItemToCommentMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(addPlaceListItemToCommentMutationModel.m1167a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    addPlaceListItemToCommentMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = addPlaceListItemToCommentMutationModel.w_();
                int u_ = addPlaceListItemToCommentMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("comment");
                    CommentFieldsForPlaceMutationParser.m1216a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(AddPlaceListItemToCommentMutationModel.class, new Serializer());
            }
        }

        public AddPlaceListItemToCommentMutationModel() {
            super(1);
        }

        @Nullable
        public final CommentFieldsForPlaceMutationModel m1168a() {
            this.f1123d = (CommentFieldsForPlaceMutationModel) super.a(this.f1123d, 0, CommentFieldsForPlaceMutationModel.class);
            return this.f1123d;
        }

        public final int jK_() {
            return -1726486776;
        }

        public final GraphQLVisitableModel m1169a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1168a() != null) {
                CommentFieldsForPlaceMutationModel commentFieldsForPlaceMutationModel = (CommentFieldsForPlaceMutationModel) graphQLModelMutatingVisitor.b(m1168a());
                if (m1168a() != commentFieldsForPlaceMutationModel) {
                    graphQLVisitableModel = (AddPlaceListItemToCommentMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1123d = commentFieldsForPlaceMutationModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1167a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m1168a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1431899167)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: uncroppedMediaWidth */
    public final class CommentFieldsForPlaceMutationModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private List<AttachmentsModel> f1131d;
        @Nullable
        private String f1132e;
        @Nullable
        private ParentFeedbackModel f1133f;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -458172370)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: uncroppedMediaWidth */
        public final class AttachmentsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private TargetModel f1129d;

            /* compiled from: uncroppedMediaWidth */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AttachmentsModel.class, new Deserializer());
                }

                public Object m1170a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AttachmentsParser.m1211b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object attachmentsModel = new AttachmentsModel();
                    ((BaseModel) attachmentsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (attachmentsModel instanceof Postprocessable) {
                        return ((Postprocessable) attachmentsModel).a();
                    }
                    return attachmentsModel;
                }
            }

            /* compiled from: uncroppedMediaWidth */
            public class Serializer extends JsonSerializer<AttachmentsModel> {
                public final void m1171a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AttachmentsModel attachmentsModel = (AttachmentsModel) obj;
                    if (attachmentsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(attachmentsModel.m1184a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        attachmentsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AttachmentsParser.m1212b(attachmentsModel.w_(), attachmentsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(AttachmentsModel.class, new Serializer());
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -169309393)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: uncroppedMediaWidth */
            public final class TargetModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private GraphQLObjectType f1124d;
                private boolean f1125e;
                @Nullable
                private String f1126f;
                @Nullable
                private List<CommentPlaceInfoPageFieldsModel> f1127g;
                @Nullable
                private PlaceListItemsModel f1128h;

                /* compiled from: uncroppedMediaWidth */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(TargetModel.class, new Deserializer());
                    }

                    public Object m1172a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(TargetParser.m1209a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object targetModel = new TargetModel();
                        ((BaseModel) targetModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (targetModel instanceof Postprocessable) {
                            return ((Postprocessable) targetModel).a();
                        }
                        return targetModel;
                    }
                }

                /* compiled from: uncroppedMediaWidth */
                public class Serializer extends JsonSerializer<TargetModel> {
                    public final void m1173a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        TargetModel targetModel = (TargetModel) obj;
                        if (targetModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(targetModel.m1177a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            targetModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        TargetParser.m1210a(targetModel.w_(), targetModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(TargetModel.class, new Serializer());
                    }
                }

                public TargetModel() {
                    super(5);
                }

                public final void m1181a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m1182a(String str, Object obj, boolean z) {
                }

                @Nullable
                private GraphQLObjectType m1174k() {
                    if (this.b != null && this.f1124d == null) {
                        this.f1124d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f1124d;
                }

                @Nullable
                private String m1175l() {
                    this.f1126f = super.a(this.f1126f, 2);
                    return this.f1126f;
                }

                @Nonnull
                private ImmutableList<CommentPlaceInfoPageFieldsModel> m1176m() {
                    this.f1127g = super.a(this.f1127g, 3, CommentPlaceInfoPageFieldsModel.class);
                    return (ImmutableList) this.f1127g;
                }

                @Nullable
                public final PlaceListItemsModel m1183j() {
                    this.f1128h = (PlaceListItemsModel) super.a(this.f1128h, 4, PlaceListItemsModel.class);
                    return this.f1128h;
                }

                @Nullable
                public final String m1179a() {
                    return m1175l();
                }

                public final int jK_() {
                    return 2433570;
                }

                public final GraphQLVisitableModel m1178a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel;
                    PlaceListItemsModel placeListItemsModel;
                    h();
                    if (m1176m() != null) {
                        Builder a = ModelHelper.a(m1176m(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            TargetModel targetModel = (TargetModel) ModelHelper.a(null, this);
                            targetModel.f1127g = a.b();
                            graphQLVisitableModel = targetModel;
                            if (m1183j() != null) {
                                placeListItemsModel = (PlaceListItemsModel) graphQLModelMutatingVisitor.b(m1183j());
                                if (m1183j() != placeListItemsModel) {
                                    graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f1128h = placeListItemsModel;
                                }
                            }
                            i();
                            return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                        }
                    }
                    graphQLVisitableModel = null;
                    if (m1183j() != null) {
                        placeListItemsModel = (PlaceListItemsModel) graphQLModelMutatingVisitor.b(m1183j());
                        if (m1183j() != placeListItemsModel) {
                            graphQLVisitableModel = (TargetModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f1128h = placeListItemsModel;
                        }
                    }
                    i();
                    if (graphQLVisitableModel != null) {
                    }
                }

                public final int m1177a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m1174k());
                    int b = flatBufferBuilder.b(m1175l());
                    int a2 = ModelHelper.a(flatBufferBuilder, m1176m());
                    int a3 = ModelHelper.a(flatBufferBuilder, m1183j());
                    flatBufferBuilder.c(5);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.a(1, this.f1125e);
                    flatBufferBuilder.b(2, b);
                    flatBufferBuilder.b(3, a2);
                    flatBufferBuilder.b(4, a3);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m1180a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f1125e = mutableFlatBuffer.a(i, 1);
                }
            }

            public AttachmentsModel() {
                super(1);
            }

            @Nullable
            public final TargetModel m1185a() {
                this.f1129d = (TargetModel) super.a(this.f1129d, 0, TargetModel.class);
                return this.f1129d;
            }

            public final int jK_() {
                return -1267730472;
            }

            public final GraphQLVisitableModel m1186a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m1185a() != null) {
                    TargetModel targetModel = (TargetModel) graphQLModelMutatingVisitor.b(m1185a());
                    if (m1185a() != targetModel) {
                        graphQLVisitableModel = (AttachmentsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f1129d = targetModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m1184a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m1185a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: uncroppedMediaWidth */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CommentFieldsForPlaceMutationModel.class, new Deserializer());
            }

            public Object m1187a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(CommentFieldsForPlaceMutationParser.m1215a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object commentFieldsForPlaceMutationModel = new CommentFieldsForPlaceMutationModel();
                ((BaseModel) commentFieldsForPlaceMutationModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (commentFieldsForPlaceMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) commentFieldsForPlaceMutationModel).a();
                }
                return commentFieldsForPlaceMutationModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 335462311)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: uncroppedMediaWidth */
        public final class ParentFeedbackModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f1130d;

            /* compiled from: uncroppedMediaWidth */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ParentFeedbackModel.class, new Deserializer());
                }

                public Object m1188a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ParentFeedbackParser.m1213a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object parentFeedbackModel = new ParentFeedbackModel();
                    ((BaseModel) parentFeedbackModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (parentFeedbackModel instanceof Postprocessable) {
                        return ((Postprocessable) parentFeedbackModel).a();
                    }
                    return parentFeedbackModel;
                }
            }

            /* compiled from: uncroppedMediaWidth */
            public class Serializer extends JsonSerializer<ParentFeedbackModel> {
                public final void m1189a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ParentFeedbackModel parentFeedbackModel = (ParentFeedbackModel) obj;
                    if (parentFeedbackModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(parentFeedbackModel.m1191a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        parentFeedbackModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ParentFeedbackParser.m1214a(parentFeedbackModel.w_(), parentFeedbackModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ParentFeedbackModel.class, new Serializer());
                }
            }

            public ParentFeedbackModel() {
                super(1);
            }

            public final void m1194a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m1195a(String str, Object obj, boolean z) {
            }

            @Nullable
            private String m1190j() {
                this.f1130d = super.a(this.f1130d, 0);
                return this.f1130d;
            }

            @Nullable
            public final String m1193a() {
                return m1190j();
            }

            public final int jK_() {
                return -126857307;
            }

            public final GraphQLVisitableModel m1192a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m1191a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m1190j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: uncroppedMediaWidth */
        public class Serializer extends JsonSerializer<CommentFieldsForPlaceMutationModel> {
            public final void m1196a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                CommentFieldsForPlaceMutationModel commentFieldsForPlaceMutationModel = (CommentFieldsForPlaceMutationModel) obj;
                if (commentFieldsForPlaceMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(commentFieldsForPlaceMutationModel.m1199a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    commentFieldsForPlaceMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                CommentFieldsForPlaceMutationParser.m1216a(commentFieldsForPlaceMutationModel.w_(), commentFieldsForPlaceMutationModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(CommentFieldsForPlaceMutationModel.class, new Serializer());
            }
        }

        public CommentFieldsForPlaceMutationModel() {
            super(3);
        }

        @Nonnull
        public final ImmutableList<AttachmentsModel> m1202j() {
            this.f1131d = super.a(this.f1131d, 0, AttachmentsModel.class);
            return (ImmutableList) this.f1131d;
        }

        @Nullable
        private String m1197k() {
            this.f1132e = super.a(this.f1132e, 1);
            return this.f1132e;
        }

        @Nullable
        private ParentFeedbackModel m1198l() {
            this.f1133f = (ParentFeedbackModel) super.a(this.f1133f, 2, ParentFeedbackModel.class);
            return this.f1133f;
        }

        @Nullable
        public final String m1201a() {
            return m1197k();
        }

        public final int jK_() {
            return -1679915457;
        }

        public final GraphQLVisitableModel m1200a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel;
            ParentFeedbackModel parentFeedbackModel;
            h();
            if (m1202j() != null) {
                Builder a = ModelHelper.a(m1202j(), graphQLModelMutatingVisitor);
                if (a != null) {
                    CommentFieldsForPlaceMutationModel commentFieldsForPlaceMutationModel = (CommentFieldsForPlaceMutationModel) ModelHelper.a(null, this);
                    commentFieldsForPlaceMutationModel.f1131d = a.b();
                    graphQLVisitableModel = commentFieldsForPlaceMutationModel;
                    if (m1198l() != null) {
                        parentFeedbackModel = (ParentFeedbackModel) graphQLModelMutatingVisitor.b(m1198l());
                        if (m1198l() != parentFeedbackModel) {
                            graphQLVisitableModel = (CommentFieldsForPlaceMutationModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f1133f = parentFeedbackModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m1198l() != null) {
                parentFeedbackModel = (ParentFeedbackModel) graphQLModelMutatingVisitor.b(m1198l());
                if (m1198l() != parentFeedbackModel) {
                    graphQLVisitableModel = (CommentFieldsForPlaceMutationModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1133f = parentFeedbackModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m1199a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m1202j());
            int b = flatBufferBuilder.b(m1197k());
            int a2 = ModelHelper.a(flatBufferBuilder, m1198l());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -577852613)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: uncroppedMediaWidth */
    public final class DeletePlaceRecommendationFromCommentMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private CommentFieldsForPlaceMutationModel f1134d;

        /* compiled from: uncroppedMediaWidth */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(DeletePlaceRecommendationFromCommentMutationModel.class, new Deserializer());
            }

            public Object m1203a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = DeletePlaceRecommendationFromCommentMutationParser.m1217a(jsonParser);
                Object deletePlaceRecommendationFromCommentMutationModel = new DeletePlaceRecommendationFromCommentMutationModel();
                ((BaseModel) deletePlaceRecommendationFromCommentMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (deletePlaceRecommendationFromCommentMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) deletePlaceRecommendationFromCommentMutationModel).a();
                }
                return deletePlaceRecommendationFromCommentMutationModel;
            }
        }

        /* compiled from: uncroppedMediaWidth */
        public class Serializer extends JsonSerializer<DeletePlaceRecommendationFromCommentMutationModel> {
            public final void m1204a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                DeletePlaceRecommendationFromCommentMutationModel deletePlaceRecommendationFromCommentMutationModel = (DeletePlaceRecommendationFromCommentMutationModel) obj;
                if (deletePlaceRecommendationFromCommentMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(deletePlaceRecommendationFromCommentMutationModel.m1206a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    deletePlaceRecommendationFromCommentMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = deletePlaceRecommendationFromCommentMutationModel.w_();
                int u_ = deletePlaceRecommendationFromCommentMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("comment");
                    CommentFieldsForPlaceMutationParser.m1216a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(DeletePlaceRecommendationFromCommentMutationModel.class, new Serializer());
            }
        }

        public DeletePlaceRecommendationFromCommentMutationModel() {
            super(1);
        }

        @Nullable
        private CommentFieldsForPlaceMutationModel m1205a() {
            this.f1134d = (CommentFieldsForPlaceMutationModel) super.a(this.f1134d, 0, CommentFieldsForPlaceMutationModel.class);
            return this.f1134d;
        }

        public final int jK_() {
            return 367687553;
        }

        public final GraphQLVisitableModel m1207a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1205a() != null) {
                CommentFieldsForPlaceMutationModel commentFieldsForPlaceMutationModel = (CommentFieldsForPlaceMutationModel) graphQLModelMutatingVisitor.b(m1205a());
                if (m1205a() != commentFieldsForPlaceMutationModel) {
                    graphQLVisitableModel = (DeletePlaceRecommendationFromCommentMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1134d = commentFieldsForPlaceMutationModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1206a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m1205a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}

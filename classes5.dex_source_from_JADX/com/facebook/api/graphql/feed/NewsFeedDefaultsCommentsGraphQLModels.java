package com.facebook.api.graphql.feed;

import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLModels.NewsFeedDefaultsStoryActionLinkFieldsModel;
import com.facebook.api.graphql.attachmenttarget.NewsFeedAttachmentTargetFieldsModels.StoryAttachmentFieldsWithoutMediaModel.AttachmentPropertiesModel;
import com.facebook.api.graphql.attachmenttarget.NewsFeedAttachmentTargetFieldsModels.StoryAttachmentFieldsWithoutMediaModel.SourceModel;
import com.facebook.api.graphql.attachmenttarget.NewsFeedAttachmentTargetFieldsModels.StoryAttachmentFieldsWithoutMediaModel.StyleInfosModel;
import com.facebook.api.graphql.attachmenttarget.NewsFeedAttachmentTargetFieldsModels.StoryAttachmentFieldsWithoutMediaModel.TargetModel;
import com.facebook.api.graphql.feed.NewsFeedDefaultsCommentsGraphQLParsers.CommentFragmentWithoutFeedbackOrAttachmentParser;
import com.facebook.api.graphql.feed.NewsFeedDefaultsCommentsGraphQLParsers.CommentFragmentWithoutFeedbackOrAttachmentParser.AuthorParser;
import com.facebook.api.graphql.feed.NewsFeedDefaultsCommentsGraphQLParsers.CommentFragmentWithoutFeedbackOrAttachmentParser.BodyMarkdownHtmlParser;
import com.facebook.api.graphql.feed.NewsFeedDefaultsCommentsGraphQLParsers.CommentFragmentWithoutFeedbackOrAttachmentParser.EditHistoryParser;
import com.facebook.api.graphql.feed.NewsFeedDefaultsCommentsGraphQLParsers.CommentFragmentWithoutFeedbackParser;
import com.facebook.api.graphql.feed.NewsFeedDefaultsCommentsGraphQLParsers.CommentFragmentWithoutFeedbackParser.AttachmentsParser;
import com.facebook.api.graphql.feed.NewsFeedDefaultsCommentsGraphQLParsers.CommentTranslatabilityFragmentParser;
import com.facebook.api.graphql.feed.NewsFeedDefaultsCommentsGraphQLParsers.CommentTranslatabilityFragmentParser.TranslatabilityForViewerParser;
import com.facebook.api.graphql.feed.NewsFeedDefaultsStoryAttachmentGraphQLModels.StoryAttachmentFieldsModel;
import com.facebook.api.graphql.feed.NewsFeedDefaultsStoryAttachmentGraphQLModels.StoryAttachmentFieldsModel.MediaModel;
import com.facebook.api.graphql.textwithentities.NewsFeedApplicationGraphQLModels.AppStoreApplicationFragmentModel;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithBridge;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.enums.GraphQLTranslatabilityType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultNameFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel;
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

/* compiled from: app_community_manager */
public class NewsFeedDefaultsCommentsGraphQLModels {

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 699216495)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: app_community_manager */
    public final class CommentFragmentWithoutFeedbackModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private List<AttachmentsModel> f9258d;
        @Nullable
        private AuthorModel f9259e;
        @Nullable
        private DefaultTextWithEntitiesLongFieldsModel f9260f;
        @Nullable
        private BodyMarkdownHtmlModel f9261g;
        private boolean f9262h;
        private boolean f9263i;
        private long f9264j;
        @Nullable
        private EditHistoryModel f9265k;
        @Nullable
        private String f9266l;
        private boolean f9267m;
        private boolean f9268n;
        private boolean f9269o;
        @Nullable
        private TranslatabilityForViewerModel f9270p;

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1007268919)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: app_community_manager */
        public final class AttachmentsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NewsFeedDefaultsStoryActionLinkFieldsModel> f9242d;
            @Nullable
            private AppStoreApplicationFragmentModel f9243e;
            @Nullable
            private List<AttachmentPropertiesModel> f9244f;
            @Nullable
            private String f9245g;
            @Nullable
            private DefaultTextWithEntitiesLongFieldsModel f9246h;
            @Nullable
            private MediaModel f9247i;
            @Nullable
            private String f9248j;
            @Nullable
            private SourceModel f9249k;
            @Nullable
            private List<StyleInfosModel> f9250l;
            @Nullable
            private List<GraphQLStoryAttachmentStyle> f9251m;
            @Nullable
            private List<StoryAttachmentFieldsModel> f9252n;
            @Nullable
            private String f9253o;
            @Nullable
            private TargetModel f9254p;
            @Nullable
            private String f9255q;
            @Nullable
            private String f9256r;
            @Nullable
            private String f9257s;

            /* compiled from: app_community_manager */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AttachmentsModel.class, new Deserializer());
                }

                public Object m15749a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AttachmentsParser.m15837b(jsonParser, flatBufferBuilder));
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

            /* compiled from: app_community_manager */
            public class Serializer extends JsonSerializer<AttachmentsModel> {
                public final void m15750a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AttachmentsModel attachmentsModel = (AttachmentsModel) obj;
                    if (attachmentsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(attachmentsModel.m15767a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        attachmentsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AttachmentsParser.m15838b(attachmentsModel.w_(), attachmentsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(AttachmentsModel.class, new Serializer());
                }
            }

            public AttachmentsModel() {
                super(16);
            }

            @Nonnull
            private ImmutableList<NewsFeedDefaultsStoryActionLinkFieldsModel> m15751a() {
                this.f9242d = super.a(this.f9242d, 0, NewsFeedDefaultsStoryActionLinkFieldsModel.class);
                return (ImmutableList) this.f9242d;
            }

            @Nullable
            private AppStoreApplicationFragmentModel m15752j() {
                this.f9243e = (AppStoreApplicationFragmentModel) super.a(this.f9243e, 1, AppStoreApplicationFragmentModel.class);
                return this.f9243e;
            }

            @Nonnull
            private ImmutableList<AttachmentPropertiesModel> m15753k() {
                this.f9244f = super.a(this.f9244f, 2, AttachmentPropertiesModel.class);
                return (ImmutableList) this.f9244f;
            }

            @Nullable
            private String m15754l() {
                this.f9245g = super.a(this.f9245g, 3);
                return this.f9245g;
            }

            @Nullable
            private DefaultTextWithEntitiesLongFieldsModel m15755m() {
                this.f9246h = (DefaultTextWithEntitiesLongFieldsModel) super.a(this.f9246h, 4, DefaultTextWithEntitiesLongFieldsModel.class);
                return this.f9246h;
            }

            @Nullable
            private MediaModel m15756n() {
                this.f9247i = (MediaModel) super.a(this.f9247i, 5, MediaModel.class);
                return this.f9247i;
            }

            @Nullable
            private String m15757o() {
                this.f9248j = super.a(this.f9248j, 6);
                return this.f9248j;
            }

            @Nullable
            private SourceModel m15758p() {
                this.f9249k = (SourceModel) super.a(this.f9249k, 7, SourceModel.class);
                return this.f9249k;
            }

            @Nonnull
            private ImmutableList<StyleInfosModel> m15759q() {
                this.f9250l = super.a(this.f9250l, 8, StyleInfosModel.class);
                return (ImmutableList) this.f9250l;
            }

            @Nonnull
            private ImmutableList<GraphQLStoryAttachmentStyle> m15760r() {
                this.f9251m = super.c(this.f9251m, 9, GraphQLStoryAttachmentStyle.class);
                return (ImmutableList) this.f9251m;
            }

            @Nonnull
            private ImmutableList<StoryAttachmentFieldsModel> m15761s() {
                this.f9252n = super.a(this.f9252n, 10, StoryAttachmentFieldsModel.class);
                return (ImmutableList) this.f9252n;
            }

            @Nullable
            private String m15762t() {
                this.f9253o = super.a(this.f9253o, 11);
                return this.f9253o;
            }

            @Nullable
            private TargetModel m15763u() {
                this.f9254p = (TargetModel) super.a(this.f9254p, 12, TargetModel.class);
                return this.f9254p;
            }

            @Nullable
            private String m15764v() {
                this.f9255q = super.a(this.f9255q, 13);
                return this.f9255q;
            }

            @Nullable
            private String m15765w() {
                this.f9256r = super.a(this.f9256r, 14);
                return this.f9256r;
            }

            @Nullable
            private String m15766x() {
                this.f9257s = super.a(this.f9257s, 15);
                return this.f9257s;
            }

            public final int jK_() {
                return -1267730472;
            }

            public final GraphQLVisitableModel m15768a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                AttachmentsModel attachmentsModel;
                GraphQLVisitableModel graphQLVisitableModel;
                AppStoreApplicationFragmentModel appStoreApplicationFragmentModel;
                Builder a;
                DefaultTextWithEntitiesLongFieldsModel defaultTextWithEntitiesLongFieldsModel;
                MediaModel mediaModel;
                SourceModel sourceModel;
                TargetModel targetModel;
                h();
                if (m15751a() != null) {
                    Builder a2 = ModelHelper.a(m15751a(), graphQLModelMutatingVisitor);
                    if (a2 != null) {
                        attachmentsModel = (AttachmentsModel) ModelHelper.a(null, this);
                        attachmentsModel.f9242d = a2.b();
                        graphQLVisitableModel = attachmentsModel;
                        if (m15752j() != null) {
                            appStoreApplicationFragmentModel = (AppStoreApplicationFragmentModel) graphQLModelMutatingVisitor.b(m15752j());
                            if (m15752j() != appStoreApplicationFragmentModel) {
                                graphQLVisitableModel = (AttachmentsModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f9243e = appStoreApplicationFragmentModel;
                            }
                        }
                        if (m15753k() != null) {
                            a = ModelHelper.a(m15753k(), graphQLModelMutatingVisitor);
                            if (a != null) {
                                attachmentsModel = (AttachmentsModel) ModelHelper.a(graphQLVisitableModel, this);
                                attachmentsModel.f9244f = a.b();
                                graphQLVisitableModel = attachmentsModel;
                            }
                        }
                        if (m15755m() != null) {
                            defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) graphQLModelMutatingVisitor.b(m15755m());
                            if (m15755m() != defaultTextWithEntitiesLongFieldsModel) {
                                graphQLVisitableModel = (AttachmentsModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f9246h = defaultTextWithEntitiesLongFieldsModel;
                            }
                        }
                        if (m15756n() != null) {
                            mediaModel = (MediaModel) graphQLModelMutatingVisitor.b(m15756n());
                            if (m15756n() != mediaModel) {
                                graphQLVisitableModel = (AttachmentsModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f9247i = mediaModel;
                            }
                        }
                        if (m15758p() != null) {
                            sourceModel = (SourceModel) graphQLModelMutatingVisitor.b(m15758p());
                            if (m15758p() != sourceModel) {
                                graphQLVisitableModel = (AttachmentsModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f9249k = sourceModel;
                            }
                        }
                        if (m15759q() != null) {
                            a = ModelHelper.a(m15759q(), graphQLModelMutatingVisitor);
                            if (a != null) {
                                attachmentsModel = (AttachmentsModel) ModelHelper.a(graphQLVisitableModel, this);
                                attachmentsModel.f9250l = a.b();
                                graphQLVisitableModel = attachmentsModel;
                            }
                        }
                        if (m15761s() != null) {
                            a = ModelHelper.a(m15761s(), graphQLModelMutatingVisitor);
                            if (a != null) {
                                attachmentsModel = (AttachmentsModel) ModelHelper.a(graphQLVisitableModel, this);
                                attachmentsModel.f9252n = a.b();
                                graphQLVisitableModel = attachmentsModel;
                            }
                        }
                        if (m15763u() != null) {
                            targetModel = (TargetModel) graphQLModelMutatingVisitor.b(m15763u());
                            if (m15763u() != targetModel) {
                                graphQLVisitableModel = (AttachmentsModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f9254p = targetModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m15752j() != null) {
                    appStoreApplicationFragmentModel = (AppStoreApplicationFragmentModel) graphQLModelMutatingVisitor.b(m15752j());
                    if (m15752j() != appStoreApplicationFragmentModel) {
                        graphQLVisitableModel = (AttachmentsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9243e = appStoreApplicationFragmentModel;
                    }
                }
                if (m15753k() != null) {
                    a = ModelHelper.a(m15753k(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        attachmentsModel = (AttachmentsModel) ModelHelper.a(graphQLVisitableModel, this);
                        attachmentsModel.f9244f = a.b();
                        graphQLVisitableModel = attachmentsModel;
                    }
                }
                if (m15755m() != null) {
                    defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) graphQLModelMutatingVisitor.b(m15755m());
                    if (m15755m() != defaultTextWithEntitiesLongFieldsModel) {
                        graphQLVisitableModel = (AttachmentsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9246h = defaultTextWithEntitiesLongFieldsModel;
                    }
                }
                if (m15756n() != null) {
                    mediaModel = (MediaModel) graphQLModelMutatingVisitor.b(m15756n());
                    if (m15756n() != mediaModel) {
                        graphQLVisitableModel = (AttachmentsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9247i = mediaModel;
                    }
                }
                if (m15758p() != null) {
                    sourceModel = (SourceModel) graphQLModelMutatingVisitor.b(m15758p());
                    if (m15758p() != sourceModel) {
                        graphQLVisitableModel = (AttachmentsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9249k = sourceModel;
                    }
                }
                if (m15759q() != null) {
                    a = ModelHelper.a(m15759q(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        attachmentsModel = (AttachmentsModel) ModelHelper.a(graphQLVisitableModel, this);
                        attachmentsModel.f9250l = a.b();
                        graphQLVisitableModel = attachmentsModel;
                    }
                }
                if (m15761s() != null) {
                    a = ModelHelper.a(m15761s(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        attachmentsModel = (AttachmentsModel) ModelHelper.a(graphQLVisitableModel, this);
                        attachmentsModel.f9252n = a.b();
                        graphQLVisitableModel = attachmentsModel;
                    }
                }
                if (m15763u() != null) {
                    targetModel = (TargetModel) graphQLModelMutatingVisitor.b(m15763u());
                    if (m15763u() != targetModel) {
                        graphQLVisitableModel = (AttachmentsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9254p = targetModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m15767a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m15751a());
                int a2 = ModelHelper.a(flatBufferBuilder, m15752j());
                int a3 = ModelHelper.a(flatBufferBuilder, m15753k());
                int b = flatBufferBuilder.b(m15754l());
                int a4 = ModelHelper.a(flatBufferBuilder, m15755m());
                int a5 = ModelHelper.a(flatBufferBuilder, m15756n());
                int b2 = flatBufferBuilder.b(m15757o());
                int a6 = ModelHelper.a(flatBufferBuilder, m15758p());
                int a7 = ModelHelper.a(flatBufferBuilder, m15759q());
                int d = flatBufferBuilder.d(m15760r());
                int a8 = ModelHelper.a(flatBufferBuilder, m15761s());
                int b3 = flatBufferBuilder.b(m15762t());
                int a9 = ModelHelper.a(flatBufferBuilder, m15763u());
                int b4 = flatBufferBuilder.b(m15764v());
                int b5 = flatBufferBuilder.b(m15765w());
                int b6 = flatBufferBuilder.b(m15766x());
                flatBufferBuilder.c(16);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                flatBufferBuilder.b(3, b);
                flatBufferBuilder.b(4, a4);
                flatBufferBuilder.b(5, a5);
                flatBufferBuilder.b(6, b2);
                flatBufferBuilder.b(7, a6);
                flatBufferBuilder.b(8, a7);
                flatBufferBuilder.b(9, d);
                flatBufferBuilder.b(10, a8);
                flatBufferBuilder.b(11, b3);
                flatBufferBuilder.b(12, a9);
                flatBufferBuilder.b(13, b4);
                flatBufferBuilder.b(14, b5);
                flatBufferBuilder.b(15, b6);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: app_community_manager */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CommentFragmentWithoutFeedbackModel.class, new Deserializer());
            }

            public Object m15769a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(CommentFragmentWithoutFeedbackParser.m15839a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object commentFragmentWithoutFeedbackModel = new CommentFragmentWithoutFeedbackModel();
                ((BaseModel) commentFragmentWithoutFeedbackModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (commentFragmentWithoutFeedbackModel instanceof Postprocessable) {
                    return ((Postprocessable) commentFragmentWithoutFeedbackModel).a();
                }
                return commentFragmentWithoutFeedbackModel;
            }
        }

        /* compiled from: app_community_manager */
        public class Serializer extends JsonSerializer<CommentFragmentWithoutFeedbackModel> {
            public final void m15770a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                CommentFragmentWithoutFeedbackModel commentFragmentWithoutFeedbackModel = (CommentFragmentWithoutFeedbackModel) obj;
                if (commentFragmentWithoutFeedbackModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(commentFragmentWithoutFeedbackModel.m15778a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    commentFragmentWithoutFeedbackModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                CommentFragmentWithoutFeedbackParser.m15840a(commentFragmentWithoutFeedbackModel.w_(), commentFragmentWithoutFeedbackModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(CommentFragmentWithoutFeedbackModel.class, new Serializer());
            }
        }

        public CommentFragmentWithoutFeedbackModel() {
            super(13);
        }

        @Nonnull
        private ImmutableList<AttachmentsModel> m15771j() {
            this.f9258d = super.a(this.f9258d, 0, AttachmentsModel.class);
            return (ImmutableList) this.f9258d;
        }

        @Nullable
        private AuthorModel m15772k() {
            this.f9259e = (AuthorModel) super.a(this.f9259e, 1, AuthorModel.class);
            return this.f9259e;
        }

        @Nullable
        private DefaultTextWithEntitiesLongFieldsModel m15773l() {
            this.f9260f = (DefaultTextWithEntitiesLongFieldsModel) super.a(this.f9260f, 2, DefaultTextWithEntitiesLongFieldsModel.class);
            return this.f9260f;
        }

        @Nullable
        private BodyMarkdownHtmlModel m15774m() {
            this.f9261g = (BodyMarkdownHtmlModel) super.a(this.f9261g, 3, BodyMarkdownHtmlModel.class);
            return this.f9261g;
        }

        @Nullable
        private EditHistoryModel m15775n() {
            this.f9265k = (EditHistoryModel) super.a(this.f9265k, 7, EditHistoryModel.class);
            return this.f9265k;
        }

        @Nullable
        private String m15776o() {
            this.f9266l = super.a(this.f9266l, 8);
            return this.f9266l;
        }

        @Nullable
        private TranslatabilityForViewerModel m15777p() {
            this.f9270p = (TranslatabilityForViewerModel) super.a(this.f9270p, 12, TranslatabilityForViewerModel.class);
            return this.f9270p;
        }

        @Nullable
        public final String m15780a() {
            return m15776o();
        }

        public final int jK_() {
            return -1679915457;
        }

        public final GraphQLVisitableModel m15779a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel;
            AuthorModel authorModel;
            DefaultTextWithEntitiesLongFieldsModel defaultTextWithEntitiesLongFieldsModel;
            BodyMarkdownHtmlModel bodyMarkdownHtmlModel;
            EditHistoryModel editHistoryModel;
            TranslatabilityForViewerModel translatabilityForViewerModel;
            h();
            if (m15771j() != null) {
                Builder a = ModelHelper.a(m15771j(), graphQLModelMutatingVisitor);
                if (a != null) {
                    CommentFragmentWithoutFeedbackModel commentFragmentWithoutFeedbackModel = (CommentFragmentWithoutFeedbackModel) ModelHelper.a(null, this);
                    commentFragmentWithoutFeedbackModel.f9258d = a.b();
                    graphQLVisitableModel = commentFragmentWithoutFeedbackModel;
                    if (m15772k() != null) {
                        authorModel = (AuthorModel) graphQLModelMutatingVisitor.b(m15772k());
                        if (m15772k() != authorModel) {
                            graphQLVisitableModel = (CommentFragmentWithoutFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f9259e = authorModel;
                        }
                    }
                    if (m15773l() != null) {
                        defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) graphQLModelMutatingVisitor.b(m15773l());
                        if (m15773l() != defaultTextWithEntitiesLongFieldsModel) {
                            graphQLVisitableModel = (CommentFragmentWithoutFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f9260f = defaultTextWithEntitiesLongFieldsModel;
                        }
                    }
                    if (m15774m() != null) {
                        bodyMarkdownHtmlModel = (BodyMarkdownHtmlModel) graphQLModelMutatingVisitor.b(m15774m());
                        if (m15774m() != bodyMarkdownHtmlModel) {
                            graphQLVisitableModel = (CommentFragmentWithoutFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f9261g = bodyMarkdownHtmlModel;
                        }
                    }
                    if (m15775n() != null) {
                        editHistoryModel = (EditHistoryModel) graphQLModelMutatingVisitor.b(m15775n());
                        if (m15775n() != editHistoryModel) {
                            graphQLVisitableModel = (CommentFragmentWithoutFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f9265k = editHistoryModel;
                        }
                    }
                    if (m15777p() != null) {
                        translatabilityForViewerModel = (TranslatabilityForViewerModel) graphQLModelMutatingVisitor.b(m15777p());
                        if (m15777p() != translatabilityForViewerModel) {
                            graphQLVisitableModel = (CommentFragmentWithoutFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f9270p = translatabilityForViewerModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m15772k() != null) {
                authorModel = (AuthorModel) graphQLModelMutatingVisitor.b(m15772k());
                if (m15772k() != authorModel) {
                    graphQLVisitableModel = (CommentFragmentWithoutFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9259e = authorModel;
                }
            }
            if (m15773l() != null) {
                defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) graphQLModelMutatingVisitor.b(m15773l());
                if (m15773l() != defaultTextWithEntitiesLongFieldsModel) {
                    graphQLVisitableModel = (CommentFragmentWithoutFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9260f = defaultTextWithEntitiesLongFieldsModel;
                }
            }
            if (m15774m() != null) {
                bodyMarkdownHtmlModel = (BodyMarkdownHtmlModel) graphQLModelMutatingVisitor.b(m15774m());
                if (m15774m() != bodyMarkdownHtmlModel) {
                    graphQLVisitableModel = (CommentFragmentWithoutFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9261g = bodyMarkdownHtmlModel;
                }
            }
            if (m15775n() != null) {
                editHistoryModel = (EditHistoryModel) graphQLModelMutatingVisitor.b(m15775n());
                if (m15775n() != editHistoryModel) {
                    graphQLVisitableModel = (CommentFragmentWithoutFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9265k = editHistoryModel;
                }
            }
            if (m15777p() != null) {
                translatabilityForViewerModel = (TranslatabilityForViewerModel) graphQLModelMutatingVisitor.b(m15777p());
                if (m15777p() != translatabilityForViewerModel) {
                    graphQLVisitableModel = (CommentFragmentWithoutFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9270p = translatabilityForViewerModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m15778a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15771j());
            int a2 = ModelHelper.a(flatBufferBuilder, m15772k());
            int a3 = ModelHelper.a(flatBufferBuilder, m15773l());
            int a4 = ModelHelper.a(flatBufferBuilder, m15774m());
            int a5 = ModelHelper.a(flatBufferBuilder, m15775n());
            int b = flatBufferBuilder.b(m15776o());
            int a6 = ModelHelper.a(flatBufferBuilder, m15777p());
            flatBufferBuilder.c(13);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, a4);
            flatBufferBuilder.a(4, this.f9262h);
            flatBufferBuilder.a(5, this.f9263i);
            flatBufferBuilder.a(6, this.f9264j, 0);
            flatBufferBuilder.b(7, a5);
            flatBufferBuilder.b(8, b);
            flatBufferBuilder.a(9, this.f9267m);
            flatBufferBuilder.a(10, this.f9268n);
            flatBufferBuilder.a(11, this.f9269o);
            flatBufferBuilder.b(12, a6);
            i();
            return flatBufferBuilder.d();
        }

        public final void m15781a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f9262h = mutableFlatBuffer.a(i, 4);
            this.f9263i = mutableFlatBuffer.a(i, 5);
            this.f9264j = mutableFlatBuffer.a(i, 6, 0);
            this.f9267m = mutableFlatBuffer.a(i, 9);
            this.f9268n = mutableFlatBuffer.a(i, 10);
            this.f9269o = mutableFlatBuffer.a(i, 11);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1901427315)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: app_community_manager */
    public final class CommentFragmentWithoutFeedbackOrAttachmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private AuthorModel f9281d;
        @Nullable
        private DefaultTextWithEntitiesLongFieldsModel f9282e;
        @Nullable
        private BodyMarkdownHtmlModel f9283f;
        private boolean f9284g;
        private boolean f9285h;
        private long f9286i;
        @Nullable
        private EditHistoryModel f9287j;
        @Nullable
        private String f9288k;
        private boolean f9289l;
        private boolean f9290m;
        private boolean f9291n;
        @Nullable
        private TranslatabilityForViewerModel f9292o;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -461712555)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: app_community_manager */
        public final class AuthorModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f9271d;
            @Nullable
            private String f9272e;
            private boolean f9273f;
            private boolean f9274g;
            private boolean f9275h;
            @Nullable
            private String f9276i;
            @Nullable
            private DefaultImageFieldsModel f9277j;
            @Nullable
            private DefaultNameFieldsModel f9278k;

            /* compiled from: app_community_manager */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AuthorModel.class, new Deserializer());
                }

                public Object m15782a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AuthorParser.m15827a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object authorModel = new AuthorModel();
                    ((BaseModel) authorModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (authorModel instanceof Postprocessable) {
                        return ((Postprocessable) authorModel).a();
                    }
                    return authorModel;
                }
            }

            /* compiled from: app_community_manager */
            public class Serializer extends JsonSerializer<AuthorModel> {
                public final void m15783a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AuthorModel authorModel = (AuthorModel) obj;
                    if (authorModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(authorModel.m15789a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        authorModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AuthorParser.m15828a(authorModel.w_(), authorModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(AuthorModel.class, new Serializer());
                }
            }

            public AuthorModel() {
                super(8);
            }

            public final void m15793a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m15794a(String str, Object obj, boolean z) {
            }

            @Nullable
            private GraphQLObjectType m15784j() {
                if (this.b != null && this.f9271d == null) {
                    this.f9271d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f9271d;
            }

            @Nullable
            private String m15785k() {
                this.f9272e = super.a(this.f9272e, 1);
                return this.f9272e;
            }

            @Nullable
            private String m15786l() {
                this.f9276i = super.a(this.f9276i, 5);
                return this.f9276i;
            }

            @Nullable
            private DefaultImageFieldsModel m15787m() {
                this.f9277j = (DefaultImageFieldsModel) super.a(this.f9277j, 6, DefaultImageFieldsModel.class);
                return this.f9277j;
            }

            @Nullable
            private DefaultNameFieldsModel m15788n() {
                this.f9278k = (DefaultNameFieldsModel) super.a(this.f9278k, 7, DefaultNameFieldsModel.class);
                return this.f9278k;
            }

            @Nullable
            public final String m15791a() {
                return m15785k();
            }

            public final int jK_() {
                return 63093205;
            }

            public final GraphQLVisitableModel m15790a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m15787m() != null) {
                    DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m15787m());
                    if (m15787m() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (AuthorModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f9277j = defaultImageFieldsModel;
                    }
                }
                if (m15788n() != null) {
                    DefaultNameFieldsModel defaultNameFieldsModel = (DefaultNameFieldsModel) graphQLModelMutatingVisitor.b(m15788n());
                    if (m15788n() != defaultNameFieldsModel) {
                        graphQLVisitableModel = (AuthorModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9278k = defaultNameFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m15789a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m15784j());
                int b = flatBufferBuilder.b(m15785k());
                int b2 = flatBufferBuilder.b(m15786l());
                int a2 = ModelHelper.a(flatBufferBuilder, m15787m());
                int a3 = ModelHelper.a(flatBufferBuilder, m15788n());
                flatBufferBuilder.c(8);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.a(2, this.f9273f);
                flatBufferBuilder.a(3, this.f9274g);
                flatBufferBuilder.a(4, this.f9275h);
                flatBufferBuilder.b(5, b2);
                flatBufferBuilder.b(6, a2);
                flatBufferBuilder.b(7, a3);
                i();
                return flatBufferBuilder.d();
            }

            public final void m15792a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f9273f = mutableFlatBuffer.a(i, 2);
                this.f9274g = mutableFlatBuffer.a(i, 3);
                this.f9275h = mutableFlatBuffer.a(i, 4);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: app_community_manager */
        public final class BodyMarkdownHtmlModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f9279d;

            /* compiled from: app_community_manager */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(BodyMarkdownHtmlModel.class, new Deserializer());
                }

                public Object m15795a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(BodyMarkdownHtmlParser.m15829a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object bodyMarkdownHtmlModel = new BodyMarkdownHtmlModel();
                    ((BaseModel) bodyMarkdownHtmlModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (bodyMarkdownHtmlModel instanceof Postprocessable) {
                        return ((Postprocessable) bodyMarkdownHtmlModel).a();
                    }
                    return bodyMarkdownHtmlModel;
                }
            }

            /* compiled from: app_community_manager */
            public class Serializer extends JsonSerializer<BodyMarkdownHtmlModel> {
                public final void m15796a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    BodyMarkdownHtmlModel bodyMarkdownHtmlModel = (BodyMarkdownHtmlModel) obj;
                    if (bodyMarkdownHtmlModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(bodyMarkdownHtmlModel.m15798a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        bodyMarkdownHtmlModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    BodyMarkdownHtmlParser.m15830a(bodyMarkdownHtmlModel.w_(), bodyMarkdownHtmlModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(BodyMarkdownHtmlModel.class, new Serializer());
                }
            }

            public BodyMarkdownHtmlModel() {
                super(1);
            }

            @Nullable
            private String m15797a() {
                this.f9279d = super.a(this.f9279d, 0);
                return this.f9279d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m15799a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m15798a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m15797a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: app_community_manager */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CommentFragmentWithoutFeedbackOrAttachmentModel.class, new Deserializer());
            }

            public Object m15800a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(CommentFragmentWithoutFeedbackOrAttachmentParser.m15833a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object commentFragmentWithoutFeedbackOrAttachmentModel = new CommentFragmentWithoutFeedbackOrAttachmentModel();
                ((BaseModel) commentFragmentWithoutFeedbackOrAttachmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (commentFragmentWithoutFeedbackOrAttachmentModel instanceof Postprocessable) {
                    return ((Postprocessable) commentFragmentWithoutFeedbackOrAttachmentModel).a();
                }
                return commentFragmentWithoutFeedbackOrAttachmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: app_community_manager */
        public final class EditHistoryModel extends BaseModel implements GraphQLVisitableModel {
            private int f9280d;

            /* compiled from: app_community_manager */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(EditHistoryModel.class, new Deserializer());
                }

                public Object m15801a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(EditHistoryParser.m15831a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object editHistoryModel = new EditHistoryModel();
                    ((BaseModel) editHistoryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (editHistoryModel instanceof Postprocessable) {
                        return ((Postprocessable) editHistoryModel).a();
                    }
                    return editHistoryModel;
                }
            }

            /* compiled from: app_community_manager */
            public class Serializer extends JsonSerializer<EditHistoryModel> {
                public final void m15802a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EditHistoryModel editHistoryModel = (EditHistoryModel) obj;
                    if (editHistoryModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(editHistoryModel.m15803a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        editHistoryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    EditHistoryParser.m15832a(editHistoryModel.w_(), editHistoryModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(EditHistoryModel.class, new Serializer());
                }
            }

            public EditHistoryModel() {
                super(1);
            }

            public final int jK_() {
                return -1196208760;
            }

            public final GraphQLVisitableModel m15804a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m15803a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f9280d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m15805a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f9280d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: app_community_manager */
        public class Serializer extends JsonSerializer<CommentFragmentWithoutFeedbackOrAttachmentModel> {
            public final void m15806a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                CommentFragmentWithoutFeedbackOrAttachmentModel commentFragmentWithoutFeedbackOrAttachmentModel = (CommentFragmentWithoutFeedbackOrAttachmentModel) obj;
                if (commentFragmentWithoutFeedbackOrAttachmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(commentFragmentWithoutFeedbackOrAttachmentModel.m15813a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    commentFragmentWithoutFeedbackOrAttachmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                CommentFragmentWithoutFeedbackOrAttachmentParser.m15834a(commentFragmentWithoutFeedbackOrAttachmentModel.w_(), commentFragmentWithoutFeedbackOrAttachmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(CommentFragmentWithoutFeedbackOrAttachmentModel.class, new Serializer());
            }
        }

        public CommentFragmentWithoutFeedbackOrAttachmentModel() {
            super(12);
        }

        @Nullable
        private AuthorModel m15807j() {
            this.f9281d = (AuthorModel) super.a(this.f9281d, 0, AuthorModel.class);
            return this.f9281d;
        }

        @Nullable
        private DefaultTextWithEntitiesLongFieldsModel m15808k() {
            this.f9282e = (DefaultTextWithEntitiesLongFieldsModel) super.a(this.f9282e, 1, DefaultTextWithEntitiesLongFieldsModel.class);
            return this.f9282e;
        }

        @Nullable
        private BodyMarkdownHtmlModel m15809l() {
            this.f9283f = (BodyMarkdownHtmlModel) super.a(this.f9283f, 2, BodyMarkdownHtmlModel.class);
            return this.f9283f;
        }

        @Nullable
        private EditHistoryModel m15810m() {
            this.f9287j = (EditHistoryModel) super.a(this.f9287j, 6, EditHistoryModel.class);
            return this.f9287j;
        }

        @Nullable
        private String m15811n() {
            this.f9288k = super.a(this.f9288k, 7);
            return this.f9288k;
        }

        @Nullable
        private TranslatabilityForViewerModel m15812o() {
            this.f9292o = (TranslatabilityForViewerModel) super.a(this.f9292o, 11, TranslatabilityForViewerModel.class);
            return this.f9292o;
        }

        @Nullable
        public final String m15815a() {
            return m15811n();
        }

        public final int jK_() {
            return -1679915457;
        }

        public final GraphQLVisitableModel m15814a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15807j() != null) {
                AuthorModel authorModel = (AuthorModel) graphQLModelMutatingVisitor.b(m15807j());
                if (m15807j() != authorModel) {
                    graphQLVisitableModel = (CommentFragmentWithoutFeedbackOrAttachmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9281d = authorModel;
                }
            }
            if (m15808k() != null) {
                DefaultTextWithEntitiesLongFieldsModel defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) graphQLModelMutatingVisitor.b(m15808k());
                if (m15808k() != defaultTextWithEntitiesLongFieldsModel) {
                    graphQLVisitableModel = (CommentFragmentWithoutFeedbackOrAttachmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9282e = defaultTextWithEntitiesLongFieldsModel;
                }
            }
            if (m15809l() != null) {
                BodyMarkdownHtmlModel bodyMarkdownHtmlModel = (BodyMarkdownHtmlModel) graphQLModelMutatingVisitor.b(m15809l());
                if (m15809l() != bodyMarkdownHtmlModel) {
                    graphQLVisitableModel = (CommentFragmentWithoutFeedbackOrAttachmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9283f = bodyMarkdownHtmlModel;
                }
            }
            if (m15810m() != null) {
                EditHistoryModel editHistoryModel = (EditHistoryModel) graphQLModelMutatingVisitor.b(m15810m());
                if (m15810m() != editHistoryModel) {
                    graphQLVisitableModel = (CommentFragmentWithoutFeedbackOrAttachmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9287j = editHistoryModel;
                }
            }
            if (m15812o() != null) {
                TranslatabilityForViewerModel translatabilityForViewerModel = (TranslatabilityForViewerModel) graphQLModelMutatingVisitor.b(m15812o());
                if (m15812o() != translatabilityForViewerModel) {
                    graphQLVisitableModel = (CommentFragmentWithoutFeedbackOrAttachmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9292o = translatabilityForViewerModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15813a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15807j());
            int a2 = ModelHelper.a(flatBufferBuilder, m15808k());
            int a3 = ModelHelper.a(flatBufferBuilder, m15809l());
            int a4 = ModelHelper.a(flatBufferBuilder, m15810m());
            int b = flatBufferBuilder.b(m15811n());
            int a5 = ModelHelper.a(flatBufferBuilder, m15812o());
            flatBufferBuilder.c(12);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.a(3, this.f9284g);
            flatBufferBuilder.a(4, this.f9285h);
            flatBufferBuilder.a(5, this.f9286i, 0);
            flatBufferBuilder.b(6, a4);
            flatBufferBuilder.b(7, b);
            flatBufferBuilder.a(8, this.f9289l);
            flatBufferBuilder.a(9, this.f9290m);
            flatBufferBuilder.a(10, this.f9291n);
            flatBufferBuilder.b(11, a5);
            i();
            return flatBufferBuilder.d();
        }

        public final void m15816a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f9284g = mutableFlatBuffer.a(i, 3);
            this.f9285h = mutableFlatBuffer.a(i, 4);
            this.f9286i = mutableFlatBuffer.a(i, 5, 0);
            this.f9289l = mutableFlatBuffer.a(i, 8);
            this.f9290m = mutableFlatBuffer.a(i, 9);
            this.f9291n = mutableFlatBuffer.a(i, 10);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -170726698)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: app_community_manager */
    public final class CommentTranslatabilityFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private TranslatabilityForViewerModel f9294d;

        /* compiled from: app_community_manager */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CommentTranslatabilityFragmentModel.class, new Deserializer());
            }

            public Object m15817a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = CommentTranslatabilityFragmentParser.m15843a(jsonParser);
                Object commentTranslatabilityFragmentModel = new CommentTranslatabilityFragmentModel();
                ((BaseModel) commentTranslatabilityFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (commentTranslatabilityFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) commentTranslatabilityFragmentModel).a();
                }
                return commentTranslatabilityFragmentModel;
            }
        }

        /* compiled from: app_community_manager */
        public class Serializer extends JsonSerializer<CommentTranslatabilityFragmentModel> {
            public final void m15818a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                CommentTranslatabilityFragmentModel commentTranslatabilityFragmentModel = (CommentTranslatabilityFragmentModel) obj;
                if (commentTranslatabilityFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(commentTranslatabilityFragmentModel.m15825a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    commentTranslatabilityFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = commentTranslatabilityFragmentModel.w_();
                int u_ = commentTranslatabilityFragmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("translatability_for_viewer");
                    TranslatabilityForViewerParser.m15842a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(CommentTranslatabilityFragmentModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1357188992)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: app_community_manager */
        public final class TranslatabilityForViewerModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private GraphQLTranslatabilityType f9293d;

            /* compiled from: app_community_manager */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TranslatabilityForViewerModel.class, new Deserializer());
                }

                public Object m15819a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TranslatabilityForViewerParser.m15841a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object translatabilityForViewerModel = new TranslatabilityForViewerModel();
                    ((BaseModel) translatabilityForViewerModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (translatabilityForViewerModel instanceof Postprocessable) {
                        return ((Postprocessable) translatabilityForViewerModel).a();
                    }
                    return translatabilityForViewerModel;
                }
            }

            /* compiled from: app_community_manager */
            public class Serializer extends JsonSerializer<TranslatabilityForViewerModel> {
                public final void m15820a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TranslatabilityForViewerModel translatabilityForViewerModel = (TranslatabilityForViewerModel) obj;
                    if (translatabilityForViewerModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(translatabilityForViewerModel.m15822a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        translatabilityForViewerModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TranslatabilityForViewerParser.m15842a(translatabilityForViewerModel.w_(), translatabilityForViewerModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(TranslatabilityForViewerModel.class, new Serializer());
                }
            }

            public TranslatabilityForViewerModel() {
                super(1);
            }

            @Nullable
            private GraphQLTranslatabilityType m15821a() {
                this.f9293d = (GraphQLTranslatabilityType) super.b(this.f9293d, 0, GraphQLTranslatabilityType.class, GraphQLTranslatabilityType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f9293d;
            }

            public final int jK_() {
                return -1681643917;
            }

            public final GraphQLVisitableModel m15823a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m15822a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = flatBufferBuilder.a(m15821a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public CommentTranslatabilityFragmentModel() {
            super(1);
        }

        @Nullable
        private TranslatabilityForViewerModel m15824a() {
            this.f9294d = (TranslatabilityForViewerModel) super.a(this.f9294d, 0, TranslatabilityForViewerModel.class);
            return this.f9294d;
        }

        public final int jK_() {
            return -1679915457;
        }

        public final GraphQLVisitableModel m15826a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15824a() != null) {
                TranslatabilityForViewerModel translatabilityForViewerModel = (TranslatabilityForViewerModel) graphQLModelMutatingVisitor.b(m15824a());
                if (m15824a() != translatabilityForViewerModel) {
                    graphQLVisitableModel = (CommentTranslatabilityFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9294d = translatabilityForViewerModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15825a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15824a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}

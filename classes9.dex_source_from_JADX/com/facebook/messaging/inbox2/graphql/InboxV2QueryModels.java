package com.facebook.messaging.inbox2.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLMessengerInbox2MessageThreadReason;
import com.facebook.graphql.enums.GraphQLMessengerInbox2RecentUnitConfigType;
import com.facebook.graphql.enums.GraphQLMessengerInboxUnitType;
import com.facebook.graphql.enums.GraphQLMessengerInboxUnitUpdateStatus;
import com.facebook.graphql.enums.GraphQLMessengerPYMMIconType;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.messaging.conversationstarters.graphql.ConversationStartersQueryInterfaces.ConversationStartersFields;
import com.facebook.messaging.conversationstarters.graphql.ConversationStartersQueryInterfaces.ConversationStartersFields.ItemImage;
import com.facebook.messaging.conversationstarters.graphql.ConversationStartersQueryModels.ConversationStartersFieldsModel.ItemDescriptionIconModel;
import com.facebook.messaging.conversationstarters.graphql.ConversationStartersQueryModels.ConversationStartersFieldsModel.ItemDescriptionModel;
import com.facebook.messaging.conversationstarters.graphql.ConversationStartersQueryModels.ConversationStartersFieldsModel.ItemUserModel;
import com.facebook.messaging.conversationstarters.graphql.ConversationStartersQueryModels.ConversationStartersFieldsModel.McsItemTitleModel;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryParsers.AnnouncementInbox2UnitFragmentParser;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryParsers.AnnouncementInbox2UnitFragmentParser.ActionTextParser;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryParsers.AnnouncementInbox2UnitFragmentParser.DescriptionParser;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryParsers.AnnouncementInbox2UnitFragmentParser.ItemImageParser;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryParsers.ExternalUrlInboxItemFragmentParser;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryParsers.ExternalUrlInboxItemFragmentParser.LinkParser;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryParsers.ExternalUrlInboxItemFragmentParser.LinkParser.ExternalUrlOwningProfileParser;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryParsers.ExternalUrlInboxItemFragmentParser.LinkParser.ExternalUrlOwningProfileParser.ProfilePictureParser;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryParsers.ExternalUrlInboxItemFragmentParser.LinkParser.IconParser;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryParsers.ExternalUrlInboxItemFragmentParser.LinkParser.LinkMediaParser;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryParsers.ExternalUrlInboxItemFragmentParser.LinkParser.LinkMediaParser.ImageParser;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryParsers.ExternalUrlInboxItemFragmentParser.LinkParser.SourceParser;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryParsers.ExternalUrlInboxItemFragmentParser.LinkParser.SummaryParser;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryParsers.ExternalUrlInboxItemFragmentParser.LinkParser.TitleParser;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryParsers.Inbox2PageItemFragmentParser;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryParsers.Inbox2PageItemFragmentParser.PageParser;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryParsers.Inbox2VideoItemFragmentParser;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryParsers.Inbox2VideoItemFragmentParser.VideoParser;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryParsers.Inbox2VideoItemFragmentParser.VideoParser.MessageParser;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryParsers.Inbox2VideoItemFragmentParser.VideoParser.OwnerParser;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryParsers.InboxV2QueryParser;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryParsers.InboxV2QueryParser.MessengerInboxUnitsParser;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryParsers.InboxV2QueryParser.MessengerInboxUnitsParser.NodesParser;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryParsers.InboxV2QueryParser.MessengerInboxUnitsParser.NodesParser.MessengerInboxUnitItemsParser;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryParsers.InboxV2QueryParser.MessengerInboxUnitsParser.NodesParser.MessengerInboxUnitItemsParser.MessengerInboxItemAttachmentParser;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryParsers.InboxV2QueryParser.MessengerInboxUnitsParser.NodesParser.MessengerInboxUnitItemsParser.MessengerInboxItemTitleParser;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryParsers.InboxV2QueryParser.MessengerInboxUnitsParser.NodesParser.MessengerInboxUnitTitleParser;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryParsers.MessageThreadsInbox2UnitFragmentParser;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryParsers.MessageThreadsInbox2UnitFragmentParser.ThreadParser;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryParsers.MessageThreadsInbox2UnitFragmentParser.ThreadParser.ThreadKeyParser;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryParsers.MessengerInbox2RecentUnitConfigParser;
import com.facebook.messaging.peopleyoumaymessage.graphql.PeopleYouMayMessageQueryModels.PeopleYouMayMessageUserInfoModel;
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

/* compiled from: mScreenData */
public class InboxV2QueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 63875171)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: mScreenData */
    public final class AnnouncementInbox2UnitFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ActionTextModel f11150d;
        @Nullable
        private DescriptionModel f11151e;
        @Nullable
        private ItemImageModel f11152f;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: mScreenData */
        public final class ActionTextModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f11147d;

            /* compiled from: mScreenData */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ActionTextModel.class, new Deserializer());
                }

                public Object m11545a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ActionTextParser.m11826a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object actionTextModel = new ActionTextModel();
                    ((BaseModel) actionTextModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (actionTextModel instanceof Postprocessable) {
                        return ((Postprocessable) actionTextModel).a();
                    }
                    return actionTextModel;
                }
            }

            /* compiled from: mScreenData */
            public class Serializer extends JsonSerializer<ActionTextModel> {
                public final void m11546a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ActionTextModel actionTextModel = (ActionTextModel) obj;
                    if (actionTextModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(actionTextModel.m11547a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        actionTextModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ActionTextParser.m11827a(actionTextModel.w_(), actionTextModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ActionTextModel.class, new Serializer());
                }
            }

            public ActionTextModel() {
                super(1);
            }

            @Nullable
            public final String m11549a() {
                this.f11147d = super.a(this.f11147d, 0);
                return this.f11147d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m11548a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m11547a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m11549a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: mScreenData */
        public final class DescriptionModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f11148d;

            /* compiled from: mScreenData */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(DescriptionModel.class, new Deserializer());
                }

                public Object m11550a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(DescriptionParser.m11828a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object descriptionModel = new DescriptionModel();
                    ((BaseModel) descriptionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (descriptionModel instanceof Postprocessable) {
                        return ((Postprocessable) descriptionModel).a();
                    }
                    return descriptionModel;
                }
            }

            /* compiled from: mScreenData */
            public class Serializer extends JsonSerializer<DescriptionModel> {
                public final void m11551a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    DescriptionModel descriptionModel = (DescriptionModel) obj;
                    if (descriptionModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(descriptionModel.m11552a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        descriptionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    DescriptionParser.m11829a(descriptionModel.w_(), descriptionModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(DescriptionModel.class, new Serializer());
                }
            }

            public DescriptionModel() {
                super(1);
            }

            @Nullable
            public final String m11554a() {
                this.f11148d = super.a(this.f11148d, 0);
                return this.f11148d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m11553a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m11552a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m11554a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: mScreenData */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AnnouncementInbox2UnitFragmentModel.class, new Deserializer());
            }

            public Object m11555a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = AnnouncementInbox2UnitFragmentParser.m11832a(jsonParser);
                Object announcementInbox2UnitFragmentModel = new AnnouncementInbox2UnitFragmentModel();
                ((BaseModel) announcementInbox2UnitFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (announcementInbox2UnitFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) announcementInbox2UnitFragmentModel).a();
                }
                return announcementInbox2UnitFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: mScreenData */
        public final class ItemImageModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f11149d;

            /* compiled from: mScreenData */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ItemImageModel.class, new Deserializer());
                }

                public Object m11556a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ItemImageParser.m11830a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object itemImageModel = new ItemImageModel();
                    ((BaseModel) itemImageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (itemImageModel instanceof Postprocessable) {
                        return ((Postprocessable) itemImageModel).a();
                    }
                    return itemImageModel;
                }
            }

            /* compiled from: mScreenData */
            public class Serializer extends JsonSerializer<ItemImageModel> {
                public final void m11557a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ItemImageModel itemImageModel = (ItemImageModel) obj;
                    if (itemImageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(itemImageModel.m11559a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        itemImageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ItemImageParser.m11831a(itemImageModel.w_(), itemImageModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ItemImageModel.class, new Serializer());
                }
            }

            public ItemImageModel() {
                super(1);
            }

            @Nullable
            private String m11558a() {
                this.f11149d = super.a(this.f11149d, 0);
                return this.f11149d;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m11560a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m11559a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m11558a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: mScreenData */
        public class Serializer extends JsonSerializer<AnnouncementInbox2UnitFragmentModel> {
            public final void m11561a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                AnnouncementInbox2UnitFragmentModel announcementInbox2UnitFragmentModel = (AnnouncementInbox2UnitFragmentModel) obj;
                if (announcementInbox2UnitFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(announcementInbox2UnitFragmentModel.m11565a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    announcementInbox2UnitFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = announcementInbox2UnitFragmentModel.w_();
                int u_ = announcementInbox2UnitFragmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("action_text");
                    ActionTextParser.m11827a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("description");
                    DescriptionParser.m11829a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("item_image");
                    ItemImageParser.m11831a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(AnnouncementInbox2UnitFragmentModel.class, new Serializer());
            }
        }

        public AnnouncementInbox2UnitFragmentModel() {
            super(3);
        }

        @Nullable
        private ActionTextModel m11562a() {
            this.f11150d = (ActionTextModel) super.a(this.f11150d, 0, ActionTextModel.class);
            return this.f11150d;
        }

        @Nullable
        private DescriptionModel m11563j() {
            this.f11151e = (DescriptionModel) super.a(this.f11151e, 1, DescriptionModel.class);
            return this.f11151e;
        }

        @Nullable
        private ItemImageModel m11564k() {
            this.f11152f = (ItemImageModel) super.a(this.f11152f, 2, ItemImageModel.class);
            return this.f11152f;
        }

        public final int jK_() {
            return 534621161;
        }

        public final GraphQLVisitableModel m11566a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m11562a() != null) {
                ActionTextModel actionTextModel = (ActionTextModel) graphQLModelMutatingVisitor.b(m11562a());
                if (m11562a() != actionTextModel) {
                    graphQLVisitableModel = (AnnouncementInbox2UnitFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11150d = actionTextModel;
                }
            }
            if (m11563j() != null) {
                DescriptionModel descriptionModel = (DescriptionModel) graphQLModelMutatingVisitor.b(m11563j());
                if (m11563j() != descriptionModel) {
                    graphQLVisitableModel = (AnnouncementInbox2UnitFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11151e = descriptionModel;
                }
            }
            if (m11564k() != null) {
                ItemImageModel itemImageModel = (ItemImageModel) graphQLModelMutatingVisitor.b(m11564k());
                if (m11564k() != itemImageModel) {
                    graphQLVisitableModel = (AnnouncementInbox2UnitFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11152f = itemImageModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m11565a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m11562a());
            int a2 = ModelHelper.a(flatBufferBuilder, m11563j());
            int a3 = ModelHelper.a(flatBufferBuilder, m11564k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1302558704)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: mScreenData */
    public final class ExternalUrlInboxItemFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private LinkModel f11173d;

        /* compiled from: mScreenData */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ExternalUrlInboxItemFragmentModel.class, new Deserializer());
            }

            public Object m11567a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ExternalUrlInboxItemFragmentParser.m11851a(jsonParser);
                Object externalUrlInboxItemFragmentModel = new ExternalUrlInboxItemFragmentModel();
                ((BaseModel) externalUrlInboxItemFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (externalUrlInboxItemFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) externalUrlInboxItemFragmentModel).a();
                }
                return externalUrlInboxItemFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1210760820)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: mScreenData */
        public final class LinkModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f11163d;
            @Nullable
            private ExternalUrlOwningProfileModel f11164e;
            @Nullable
            private IconModel f11165f;
            @Nullable
            private String f11166g;
            @Nullable
            private LinkMediaModel f11167h;
            @Nullable
            private String f11168i;
            @Nullable
            private SourceModel f11169j;
            @Nullable
            private SummaryModel f11170k;
            @Nullable
            private TitleModel f11171l;
            @Nullable
            private String f11172m;

            /* compiled from: mScreenData */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(LinkModel.class, new Deserializer());
                }

                public Object m11568a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(LinkParser.m11849a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object linkModel = new LinkModel();
                    ((BaseModel) linkModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (linkModel instanceof Postprocessable) {
                        return ((Postprocessable) linkModel).a();
                    }
                    return linkModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -76512085)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: mScreenData */
            public final class ExternalUrlOwningProfileModel extends BaseModel implements GraphQLVisitableConsistentModel {
                @Nullable
                private GraphQLObjectType f11154d;
                @Nullable
                private ProfilePictureModel f11155e;

                /* compiled from: mScreenData */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ExternalUrlOwningProfileModel.class, new Deserializer());
                    }

                    public Object m11569a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ExternalUrlOwningProfileParser.m11835a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object externalUrlOwningProfileModel = new ExternalUrlOwningProfileModel();
                        ((BaseModel) externalUrlOwningProfileModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (externalUrlOwningProfileModel instanceof Postprocessable) {
                            return ((Postprocessable) externalUrlOwningProfileModel).a();
                        }
                        return externalUrlOwningProfileModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 842551240)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: mScreenData */
                public final class ProfilePictureModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f11153d;

                    /* compiled from: mScreenData */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(ProfilePictureModel.class, new Deserializer());
                        }

                        public Object m11570a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(ProfilePictureParser.m11833a(jsonParser, flatBufferBuilder));
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

                    /* compiled from: mScreenData */
                    public class Serializer extends JsonSerializer<ProfilePictureModel> {
                        public final void m11571a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            ProfilePictureModel profilePictureModel = (ProfilePictureModel) obj;
                            if (profilePictureModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(profilePictureModel.m11572a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                profilePictureModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            ProfilePictureParser.m11834a(profilePictureModel.w_(), profilePictureModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(ProfilePictureModel.class, new Serializer());
                        }
                    }

                    public ProfilePictureModel() {
                        super(1);
                    }

                    @Nullable
                    public final String m11574a() {
                        this.f11153d = super.a(this.f11153d, 0);
                        return this.f11153d;
                    }

                    public final int jK_() {
                        return 70760763;
                    }

                    public final GraphQLVisitableModel m11573a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m11572a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m11574a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: mScreenData */
                public class Serializer extends JsonSerializer<ExternalUrlOwningProfileModel> {
                    public final void m11575a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ExternalUrlOwningProfileModel externalUrlOwningProfileModel = (ExternalUrlOwningProfileModel) obj;
                        if (externalUrlOwningProfileModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(externalUrlOwningProfileModel.m11577a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            externalUrlOwningProfileModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ExternalUrlOwningProfileParser.m11836a(externalUrlOwningProfileModel.w_(), externalUrlOwningProfileModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(ExternalUrlOwningProfileModel.class, new Serializer());
                    }
                }

                public ExternalUrlOwningProfileModel() {
                    super(2);
                }

                public final void m11580a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m11581a(String str, Object obj, boolean z) {
                }

                @Nullable
                private GraphQLObjectType m11576j() {
                    if (this.b != null && this.f11154d == null) {
                        this.f11154d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f11154d;
                }

                @Nullable
                public final ProfilePictureModel m11579a() {
                    this.f11155e = (ProfilePictureModel) super.a(this.f11155e, 1, ProfilePictureModel.class);
                    return this.f11155e;
                }

                public final int jK_() {
                    return 1355227529;
                }

                public final GraphQLVisitableModel m11578a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m11579a() != null) {
                        ProfilePictureModel profilePictureModel = (ProfilePictureModel) graphQLModelMutatingVisitor.b(m11579a());
                        if (m11579a() != profilePictureModel) {
                            graphQLVisitableModel = (ExternalUrlOwningProfileModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f11155e = profilePictureModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m11577a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m11576j());
                    int a2 = ModelHelper.a(flatBufferBuilder, m11579a());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 842551240)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: mScreenData */
            public final class IconModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f11156d;

                /* compiled from: mScreenData */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(IconModel.class, new Deserializer());
                    }

                    public Object m11582a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(IconParser.m11837a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object iconModel = new IconModel();
                        ((BaseModel) iconModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (iconModel instanceof Postprocessable) {
                            return ((Postprocessable) iconModel).a();
                        }
                        return iconModel;
                    }
                }

                /* compiled from: mScreenData */
                public class Serializer extends JsonSerializer<IconModel> {
                    public final void m11583a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        IconModel iconModel = (IconModel) obj;
                        if (iconModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(iconModel.m11584a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            iconModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        IconParser.m11838a(iconModel.w_(), iconModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(IconModel.class, new Serializer());
                    }
                }

                public IconModel() {
                    super(1);
                }

                @Nullable
                public final String m11586a() {
                    this.f11156d = super.a(this.f11156d, 0);
                    return this.f11156d;
                }

                public final int jK_() {
                    return 2273433;
                }

                public final GraphQLVisitableModel m11585a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m11584a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m11586a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1233667394)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: mScreenData */
            public final class LinkMediaModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private GraphQLObjectType f11158d;
                @Nullable
                private ImageModel f11159e;

                /* compiled from: mScreenData */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(LinkMediaModel.class, new Deserializer());
                    }

                    public Object m11587a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(LinkMediaParser.m11841a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object linkMediaModel = new LinkMediaModel();
                        ((BaseModel) linkMediaModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (linkMediaModel instanceof Postprocessable) {
                            return ((Postprocessable) linkMediaModel).a();
                        }
                        return linkMediaModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 842551240)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: mScreenData */
                public final class ImageModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f11157d;

                    /* compiled from: mScreenData */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(ImageModel.class, new Deserializer());
                        }

                        public Object m11588a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(ImageParser.m11839a(jsonParser, flatBufferBuilder));
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

                    /* compiled from: mScreenData */
                    public class Serializer extends JsonSerializer<ImageModel> {
                        public final void m11589a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            ImageModel imageModel = (ImageModel) obj;
                            if (imageModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(imageModel.m11590a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                imageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            ImageParser.m11840a(imageModel.w_(), imageModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(ImageModel.class, new Serializer());
                        }
                    }

                    public ImageModel() {
                        super(1);
                    }

                    @Nullable
                    public final String m11592a() {
                        this.f11157d = super.a(this.f11157d, 0);
                        return this.f11157d;
                    }

                    public final int jK_() {
                        return 70760763;
                    }

                    public final GraphQLVisitableModel m11591a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m11590a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m11592a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: mScreenData */
                public class Serializer extends JsonSerializer<LinkMediaModel> {
                    public final void m11593a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        LinkMediaModel linkMediaModel = (LinkMediaModel) obj;
                        if (linkMediaModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(linkMediaModel.m11595a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            linkMediaModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        LinkMediaParser.m11842a(linkMediaModel.w_(), linkMediaModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(LinkMediaModel.class, new Serializer());
                    }
                }

                public LinkMediaModel() {
                    super(2);
                }

                @Nullable
                private GraphQLObjectType m11594j() {
                    if (this.b != null && this.f11158d == null) {
                        this.f11158d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f11158d;
                }

                @Nullable
                public final ImageModel m11597a() {
                    this.f11159e = (ImageModel) super.a(this.f11159e, 1, ImageModel.class);
                    return this.f11159e;
                }

                public final int jK_() {
                    return 74219460;
                }

                public final GraphQLVisitableModel m11596a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m11597a() != null) {
                        ImageModel imageModel = (ImageModel) graphQLModelMutatingVisitor.b(m11597a());
                        if (m11597a() != imageModel) {
                            graphQLVisitableModel = (LinkMediaModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f11159e = imageModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m11595a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m11594j());
                    int a2 = ModelHelper.a(flatBufferBuilder, m11597a());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: mScreenData */
            public class Serializer extends JsonSerializer<LinkModel> {
                public final void m11598a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    LinkModel linkModel = (LinkModel) obj;
                    if (linkModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(linkModel.m11614a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        linkModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    LinkParser.m11850a(linkModel.w_(), linkModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(LinkModel.class, new Serializer());
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1352864475)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: mScreenData */
            public final class SourceModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f11160d;

                /* compiled from: mScreenData */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(SourceModel.class, new Deserializer());
                    }

                    public Object m11599a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(SourceParser.m11843a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object sourceModel = new SourceModel();
                        ((BaseModel) sourceModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (sourceModel instanceof Postprocessable) {
                            return ((Postprocessable) sourceModel).a();
                        }
                        return sourceModel;
                    }
                }

                /* compiled from: mScreenData */
                public class Serializer extends JsonSerializer<SourceModel> {
                    public final void m11600a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        SourceModel sourceModel = (SourceModel) obj;
                        if (sourceModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(sourceModel.m11601a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            sourceModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        SourceParser.m11844a(sourceModel.w_(), sourceModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(SourceModel.class, new Serializer());
                    }
                }

                public SourceModel() {
                    super(1);
                }

                @Nullable
                public final String m11603a() {
                    this.f11160d = super.a(this.f11160d, 0);
                    return this.f11160d;
                }

                public final int jK_() {
                    return -1919764332;
                }

                public final GraphQLVisitableModel m11602a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m11601a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m11603a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1352864475)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: mScreenData */
            public final class SummaryModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f11161d;

                /* compiled from: mScreenData */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(SummaryModel.class, new Deserializer());
                    }

                    public Object m11604a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(SummaryParser.m11845a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object summaryModel = new SummaryModel();
                        ((BaseModel) summaryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (summaryModel instanceof Postprocessable) {
                            return ((Postprocessable) summaryModel).a();
                        }
                        return summaryModel;
                    }
                }

                /* compiled from: mScreenData */
                public class Serializer extends JsonSerializer<SummaryModel> {
                    public final void m11605a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        SummaryModel summaryModel = (SummaryModel) obj;
                        if (summaryModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(summaryModel.m11606a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            summaryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        SummaryParser.m11846a(summaryModel.w_(), summaryModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(SummaryModel.class, new Serializer());
                    }
                }

                public SummaryModel() {
                    super(1);
                }

                @Nullable
                public final String m11608a() {
                    this.f11161d = super.a(this.f11161d, 0);
                    return this.f11161d;
                }

                public final int jK_() {
                    return -1919764332;
                }

                public final GraphQLVisitableModel m11607a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m11606a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m11608a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1352864475)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: mScreenData */
            public final class TitleModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f11162d;

                /* compiled from: mScreenData */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(TitleModel.class, new Deserializer());
                    }

                    public Object m11609a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(TitleParser.m11847a(jsonParser, flatBufferBuilder));
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

                /* compiled from: mScreenData */
                public class Serializer extends JsonSerializer<TitleModel> {
                    public final void m11610a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        TitleModel titleModel = (TitleModel) obj;
                        if (titleModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(titleModel.m11611a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            titleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        TitleParser.m11848a(titleModel.w_(), titleModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(TitleModel.class, new Serializer());
                    }
                }

                public TitleModel() {
                    super(1);
                }

                @Nullable
                public final String m11613a() {
                    this.f11162d = super.a(this.f11162d, 0);
                    return this.f11162d;
                }

                public final int jK_() {
                    return -1919764332;
                }

                public final GraphQLVisitableModel m11612a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m11611a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m11613a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            public LinkModel() {
                super(10);
            }

            @Nullable
            public final String m11617j() {
                this.f11163d = super.a(this.f11163d, 0);
                return this.f11163d;
            }

            @Nullable
            public final ExternalUrlOwningProfileModel m11618k() {
                this.f11164e = (ExternalUrlOwningProfileModel) super.a(this.f11164e, 1, ExternalUrlOwningProfileModel.class);
                return this.f11164e;
            }

            @Nullable
            public final IconModel m11619l() {
                this.f11165f = (IconModel) super.a(this.f11165f, 2, IconModel.class);
                return this.f11165f;
            }

            @Nullable
            public final String m11620m() {
                this.f11166g = super.a(this.f11166g, 3);
                return this.f11166g;
            }

            @Nullable
            public final LinkMediaModel m11621n() {
                this.f11167h = (LinkMediaModel) super.a(this.f11167h, 4, LinkMediaModel.class);
                return this.f11167h;
            }

            @Nullable
            public final String m11622o() {
                this.f11168i = super.a(this.f11168i, 5);
                return this.f11168i;
            }

            @Nullable
            public final SourceModel m11623p() {
                this.f11169j = (SourceModel) super.a(this.f11169j, 6, SourceModel.class);
                return this.f11169j;
            }

            @Nullable
            public final SummaryModel m11624q() {
                this.f11170k = (SummaryModel) super.a(this.f11170k, 7, SummaryModel.class);
                return this.f11170k;
            }

            @Nullable
            public final TitleModel m11625r() {
                this.f11171l = (TitleModel) super.a(this.f11171l, 8, TitleModel.class);
                return this.f11171l;
            }

            @Nullable
            public final String m11626s() {
                this.f11172m = super.a(this.f11172m, 9);
                return this.f11172m;
            }

            @Nullable
            public final String m11616a() {
                return m11620m();
            }

            public final int jK_() {
                return 514783620;
            }

            public final GraphQLVisitableModel m11615a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m11618k() != null) {
                    ExternalUrlOwningProfileModel externalUrlOwningProfileModel = (ExternalUrlOwningProfileModel) graphQLModelMutatingVisitor.b(m11618k());
                    if (m11618k() != externalUrlOwningProfileModel) {
                        graphQLVisitableModel = (LinkModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f11164e = externalUrlOwningProfileModel;
                    }
                }
                if (m11619l() != null) {
                    IconModel iconModel = (IconModel) graphQLModelMutatingVisitor.b(m11619l());
                    if (m11619l() != iconModel) {
                        graphQLVisitableModel = (LinkModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f11165f = iconModel;
                    }
                }
                if (m11621n() != null) {
                    LinkMediaModel linkMediaModel = (LinkMediaModel) graphQLModelMutatingVisitor.b(m11621n());
                    if (m11621n() != linkMediaModel) {
                        graphQLVisitableModel = (LinkModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f11167h = linkMediaModel;
                    }
                }
                if (m11623p() != null) {
                    SourceModel sourceModel = (SourceModel) graphQLModelMutatingVisitor.b(m11623p());
                    if (m11623p() != sourceModel) {
                        graphQLVisitableModel = (LinkModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f11169j = sourceModel;
                    }
                }
                if (m11624q() != null) {
                    SummaryModel summaryModel = (SummaryModel) graphQLModelMutatingVisitor.b(m11624q());
                    if (m11624q() != summaryModel) {
                        graphQLVisitableModel = (LinkModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f11170k = summaryModel;
                    }
                }
                if (m11625r() != null) {
                    TitleModel titleModel = (TitleModel) graphQLModelMutatingVisitor.b(m11625r());
                    if (m11625r() != titleModel) {
                        graphQLVisitableModel = (LinkModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f11171l = titleModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m11614a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m11617j());
                int a = ModelHelper.a(flatBufferBuilder, m11618k());
                int a2 = ModelHelper.a(flatBufferBuilder, m11619l());
                int b2 = flatBufferBuilder.b(m11620m());
                int a3 = ModelHelper.a(flatBufferBuilder, m11621n());
                int b3 = flatBufferBuilder.b(m11622o());
                int a4 = ModelHelper.a(flatBufferBuilder, m11623p());
                int a5 = ModelHelper.a(flatBufferBuilder, m11624q());
                int a6 = ModelHelper.a(flatBufferBuilder, m11625r());
                int b4 = flatBufferBuilder.b(m11626s());
                flatBufferBuilder.c(10);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.b(2, a2);
                flatBufferBuilder.b(3, b2);
                flatBufferBuilder.b(4, a3);
                flatBufferBuilder.b(5, b3);
                flatBufferBuilder.b(6, a4);
                flatBufferBuilder.b(7, a5);
                flatBufferBuilder.b(8, a6);
                flatBufferBuilder.b(9, b4);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: mScreenData */
        public class Serializer extends JsonSerializer<ExternalUrlInboxItemFragmentModel> {
            public final void m11627a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ExternalUrlInboxItemFragmentModel externalUrlInboxItemFragmentModel = (ExternalUrlInboxItemFragmentModel) obj;
                if (externalUrlInboxItemFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(externalUrlInboxItemFragmentModel.m11629a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    externalUrlInboxItemFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = externalUrlInboxItemFragmentModel.w_();
                int u_ = externalUrlInboxItemFragmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("link");
                    LinkParser.m11850a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ExternalUrlInboxItemFragmentModel.class, new Serializer());
            }
        }

        public ExternalUrlInboxItemFragmentModel() {
            super(1);
        }

        @Nullable
        private LinkModel m11628a() {
            this.f11173d = (LinkModel) super.a(this.f11173d, 0, LinkModel.class);
            return this.f11173d;
        }

        public final int jK_() {
            return -915201829;
        }

        public final GraphQLVisitableModel m11630a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m11628a() != null) {
                LinkModel linkModel = (LinkModel) graphQLModelMutatingVisitor.b(m11628a());
                if (m11628a() != linkModel) {
                    graphQLVisitableModel = (ExternalUrlInboxItemFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11173d = linkModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m11629a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m11628a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1383794870)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: mScreenData */
    public final class Inbox2PageItemFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private PageModel f11177d;

        /* compiled from: mScreenData */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(Inbox2PageItemFragmentModel.class, new Deserializer());
            }

            public Object m11631a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = Inbox2PageItemFragmentParser.m11854a(jsonParser);
                Object inbox2PageItemFragmentModel = new Inbox2PageItemFragmentModel();
                ((BaseModel) inbox2PageItemFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (inbox2PageItemFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) inbox2PageItemFragmentModel).a();
                }
                return inbox2PageItemFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1776966128)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: mScreenData */
        public final class PageModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f11174d;
            private boolean f11175e;
            @Nullable
            private String f11176f;

            /* compiled from: mScreenData */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PageModel.class, new Deserializer());
                }

                public Object m11632a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PageParser.m11852a(jsonParser, flatBufferBuilder));
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

            /* compiled from: mScreenData */
            public class Serializer extends JsonSerializer<PageModel> {
                public final void m11633a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PageModel pageModel = (PageModel) obj;
                    if (pageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pageModel.m11634a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PageParser.m11853a(pageModel.w_(), pageModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PageModel.class, new Serializer());
                }
            }

            public PageModel() {
                super(3);
            }

            public final void m11638a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m11639a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final String m11640j() {
                this.f11174d = super.a(this.f11174d, 0);
                return this.f11174d;
            }

            public final boolean m11641k() {
                a(0, 1);
                return this.f11175e;
            }

            @Nullable
            public final String m11642l() {
                this.f11176f = super.a(this.f11176f, 2);
                return this.f11176f;
            }

            @Nullable
            public final String m11636a() {
                return m11640j();
            }

            public final int jK_() {
                return 2479791;
            }

            public final GraphQLVisitableModel m11635a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m11634a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m11640j());
                int b2 = flatBufferBuilder.b(m11642l());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.a(1, this.f11175e);
                flatBufferBuilder.b(2, b2);
                i();
                return flatBufferBuilder.d();
            }

            public final void m11637a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f11175e = mutableFlatBuffer.a(i, 1);
            }
        }

        /* compiled from: mScreenData */
        public class Serializer extends JsonSerializer<Inbox2PageItemFragmentModel> {
            public final void m11643a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                Inbox2PageItemFragmentModel inbox2PageItemFragmentModel = (Inbox2PageItemFragmentModel) obj;
                if (inbox2PageItemFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(inbox2PageItemFragmentModel.m11645a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    inbox2PageItemFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = inbox2PageItemFragmentModel.w_();
                int u_ = inbox2PageItemFragmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("page");
                    PageParser.m11853a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(Inbox2PageItemFragmentModel.class, new Serializer());
            }
        }

        public Inbox2PageItemFragmentModel() {
            super(1);
        }

        @Nullable
        private PageModel m11644a() {
            this.f11177d = (PageModel) super.a(this.f11177d, 0, PageModel.class);
            return this.f11177d;
        }

        public final int jK_() {
            return -1124450395;
        }

        public final GraphQLVisitableModel m11646a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m11644a() != null) {
                PageModel pageModel = (PageModel) graphQLModelMutatingVisitor.b(m11644a());
                if (m11644a() != pageModel) {
                    graphQLVisitableModel = (Inbox2PageItemFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11177d = pageModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m11645a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m11644a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 231006633)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: mScreenData */
    public final class Inbox2VideoItemFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private VideoModel f11196d;

        /* compiled from: mScreenData */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(Inbox2VideoItemFragmentModel.class, new Deserializer());
            }

            public Object m11647a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = Inbox2VideoItemFragmentParser.m11867a(jsonParser);
                Object inbox2VideoItemFragmentModel = new Inbox2VideoItemFragmentModel();
                ((BaseModel) inbox2VideoItemFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (inbox2VideoItemFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) inbox2VideoItemFragmentModel).a();
                }
                return inbox2VideoItemFragmentModel;
            }
        }

        /* compiled from: mScreenData */
        public class Serializer extends JsonSerializer<Inbox2VideoItemFragmentModel> {
            public final void m11648a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                Inbox2VideoItemFragmentModel inbox2VideoItemFragmentModel = (Inbox2VideoItemFragmentModel) obj;
                if (inbox2VideoItemFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(inbox2VideoItemFragmentModel.m11696a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    inbox2VideoItemFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = inbox2VideoItemFragmentModel.w_();
                int u_ = inbox2VideoItemFragmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("video");
                    VideoParser.m11866a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(Inbox2VideoItemFragmentModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -2010217861)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: mScreenData */
        public final class VideoModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            private int f11185d;
            @Nullable
            private String f11186e;
            @Nullable
            private ImageModel f11187f;
            @Nullable
            private MessageModel f11188g;
            @Nullable
            private OwnerModel f11189h;
            @Nullable
            private String f11190i;
            private int f11191j;
            @Nullable
            private String f11192k;
            @Nullable
            private TitleModel f11193l;
            @Nullable
            private String f11194m;
            private int f11195n;

            /* compiled from: mScreenData */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(VideoModel.class, new Deserializer());
                }

                public Object m11649a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(VideoParser.m11865a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object videoModel = new VideoModel();
                    ((BaseModel) videoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (videoModel instanceof Postprocessable) {
                        return ((Postprocessable) videoModel).a();
                    }
                    return videoModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 842551240)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: mScreenData */
            public final class ImageModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f11178d;

                /* compiled from: mScreenData */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ImageModel.class, new Deserializer());
                    }

                    public Object m11650a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(VideoParser.ImageParser.m11855a(jsonParser, flatBufferBuilder));
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

                /* compiled from: mScreenData */
                public class Serializer extends JsonSerializer<ImageModel> {
                    public final void m11651a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ImageModel imageModel = (ImageModel) obj;
                        if (imageModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(imageModel.m11652a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            imageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        VideoParser.ImageParser.m11856a(imageModel.w_(), imageModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(ImageModel.class, new Serializer());
                    }
                }

                public ImageModel() {
                    super(1);
                }

                @Nullable
                public final String m11654a() {
                    this.f11178d = super.a(this.f11178d, 0);
                    return this.f11178d;
                }

                public final int jK_() {
                    return 70760763;
                }

                public final GraphQLVisitableModel m11653a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m11652a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m11654a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1352864475)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: mScreenData */
            public final class MessageModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f11179d;

                /* compiled from: mScreenData */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(MessageModel.class, new Deserializer());
                    }

                    public Object m11655a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(MessageParser.m11857a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object messageModel = new MessageModel();
                        ((BaseModel) messageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (messageModel instanceof Postprocessable) {
                            return ((Postprocessable) messageModel).a();
                        }
                        return messageModel;
                    }
                }

                /* compiled from: mScreenData */
                public class Serializer extends JsonSerializer<MessageModel> {
                    public final void m11656a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        MessageModel messageModel = (MessageModel) obj;
                        if (messageModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(messageModel.m11657a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            messageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        MessageParser.m11858a(messageModel.w_(), messageModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(MessageModel.class, new Serializer());
                    }
                }

                public MessageModel() {
                    super(1);
                }

                @Nullable
                public final String m11659a() {
                    this.f11179d = super.a(this.f11179d, 0);
                    return this.f11179d;
                }

                public final int jK_() {
                    return -1919764332;
                }

                public final GraphQLVisitableModel m11658a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m11657a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m11659a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1590354034)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: mScreenData */
            public final class OwnerModel extends BaseModel implements GraphQLVisitableConsistentModel {
                @Nullable
                private GraphQLObjectType f11181d;
                @Nullable
                private String f11182e;
                @Nullable
                private ProfilePictureModel f11183f;

                /* compiled from: mScreenData */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(OwnerModel.class, new Deserializer());
                    }

                    public Object m11660a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(OwnerParser.m11861a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object ownerModel = new OwnerModel();
                        ((BaseModel) ownerModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (ownerModel instanceof Postprocessable) {
                            return ((Postprocessable) ownerModel).a();
                        }
                        return ownerModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 842551240)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: mScreenData */
                public final class ProfilePictureModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f11180d;

                    /* compiled from: mScreenData */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(ProfilePictureModel.class, new Deserializer());
                        }

                        public Object m11661a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(OwnerParser.ProfilePictureParser.m11859a(jsonParser, flatBufferBuilder));
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

                    /* compiled from: mScreenData */
                    public class Serializer extends JsonSerializer<ProfilePictureModel> {
                        public final void m11662a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            ProfilePictureModel profilePictureModel = (ProfilePictureModel) obj;
                            if (profilePictureModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(profilePictureModel.m11663a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                profilePictureModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            OwnerParser.ProfilePictureParser.m11860a(profilePictureModel.w_(), profilePictureModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(ProfilePictureModel.class, new Serializer());
                        }
                    }

                    public ProfilePictureModel() {
                        super(1);
                    }

                    @Nullable
                    public final String m11665a() {
                        this.f11180d = super.a(this.f11180d, 0);
                        return this.f11180d;
                    }

                    public final int jK_() {
                        return 70760763;
                    }

                    public final GraphQLVisitableModel m11664a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m11663a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m11665a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: mScreenData */
                public class Serializer extends JsonSerializer<OwnerModel> {
                    public final void m11666a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        OwnerModel ownerModel = (OwnerModel) obj;
                        if (ownerModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(ownerModel.m11668a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            ownerModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        OwnerParser.m11862a(ownerModel.w_(), ownerModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(OwnerModel.class, new Serializer());
                    }
                }

                public OwnerModel() {
                    super(3);
                }

                public final void m11671a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m11672a(String str, Object obj, boolean z) {
                }

                @Nullable
                private GraphQLObjectType m11667k() {
                    if (this.b != null && this.f11181d == null) {
                        this.f11181d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f11181d;
                }

                @Nullable
                public final String m11670a() {
                    this.f11182e = super.a(this.f11182e, 1);
                    return this.f11182e;
                }

                @Nullable
                public final ProfilePictureModel m11673j() {
                    this.f11183f = (ProfilePictureModel) super.a(this.f11183f, 2, ProfilePictureModel.class);
                    return this.f11183f;
                }

                public final int jK_() {
                    return 63093205;
                }

                public final GraphQLVisitableModel m11669a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m11673j() != null) {
                        ProfilePictureModel profilePictureModel = (ProfilePictureModel) graphQLModelMutatingVisitor.b(m11673j());
                        if (m11673j() != profilePictureModel) {
                            graphQLVisitableModel = (OwnerModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f11183f = profilePictureModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m11668a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m11667k());
                    int b = flatBufferBuilder.b(m11670a());
                    int a2 = ModelHelper.a(flatBufferBuilder, m11673j());
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.b(2, a2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: mScreenData */
            public class Serializer extends JsonSerializer<VideoModel> {
                public final void m11674a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    VideoModel videoModel = (VideoModel) obj;
                    if (videoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(videoModel.m11680a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        videoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    VideoParser.m11866a(videoModel.w_(), videoModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(VideoModel.class, new Serializer());
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1352864475)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: mScreenData */
            public final class TitleModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f11184d;

                /* compiled from: mScreenData */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(TitleModel.class, new Deserializer());
                    }

                    public Object m11675a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(VideoParser.TitleParser.m11863a(jsonParser, flatBufferBuilder));
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

                /* compiled from: mScreenData */
                public class Serializer extends JsonSerializer<TitleModel> {
                    public final void m11676a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        TitleModel titleModel = (TitleModel) obj;
                        if (titleModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(titleModel.m11677a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            titleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        VideoParser.TitleParser.m11864a(titleModel.w_(), titleModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(TitleModel.class, new Serializer());
                    }
                }

                public TitleModel() {
                    super(1);
                }

                @Nullable
                public final String m11679a() {
                    this.f11184d = super.a(this.f11184d, 0);
                    return this.f11184d;
                }

                public final int jK_() {
                    return -1919764332;
                }

                public final GraphQLVisitableModel m11678a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m11677a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m11679a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            public VideoModel() {
                super(11);
            }

            public final int m11684j() {
                a(0, 0);
                return this.f11185d;
            }

            @Nullable
            public final String m11685k() {
                this.f11186e = super.a(this.f11186e, 1);
                return this.f11186e;
            }

            @Nullable
            public final ImageModel m11686l() {
                this.f11187f = (ImageModel) super.a(this.f11187f, 2, ImageModel.class);
                return this.f11187f;
            }

            @Nullable
            public final MessageModel m11687m() {
                this.f11188g = (MessageModel) super.a(this.f11188g, 3, MessageModel.class);
                return this.f11188g;
            }

            @Nullable
            public final OwnerModel m11688n() {
                this.f11189h = (OwnerModel) super.a(this.f11189h, 4, OwnerModel.class);
                return this.f11189h;
            }

            @Nullable
            public final String m11689o() {
                this.f11190i = super.a(this.f11190i, 5);
                return this.f11190i;
            }

            public final int m11690p() {
                a(0, 6);
                return this.f11191j;
            }

            @Nullable
            public final String m11691q() {
                this.f11192k = super.a(this.f11192k, 7);
                return this.f11192k;
            }

            @Nullable
            public final TitleModel m11692r() {
                this.f11193l = (TitleModel) super.a(this.f11193l, 8, TitleModel.class);
                return this.f11193l;
            }

            @Nullable
            public final String m11693s() {
                this.f11194m = super.a(this.f11194m, 9);
                return this.f11194m;
            }

            public final int m11694t() {
                a(1, 2);
                return this.f11195n;
            }

            @Nullable
            public final String m11682a() {
                return m11685k();
            }

            public final int jK_() {
                return 82650203;
            }

            public final GraphQLVisitableModel m11681a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m11686l() != null) {
                    ImageModel imageModel = (ImageModel) graphQLModelMutatingVisitor.b(m11686l());
                    if (m11686l() != imageModel) {
                        graphQLVisitableModel = (VideoModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f11187f = imageModel;
                    }
                }
                if (m11687m() != null) {
                    MessageModel messageModel = (MessageModel) graphQLModelMutatingVisitor.b(m11687m());
                    if (m11687m() != messageModel) {
                        graphQLVisitableModel = (VideoModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f11188g = messageModel;
                    }
                }
                if (m11688n() != null) {
                    OwnerModel ownerModel = (OwnerModel) graphQLModelMutatingVisitor.b(m11688n());
                    if (m11688n() != ownerModel) {
                        graphQLVisitableModel = (VideoModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f11189h = ownerModel;
                    }
                }
                if (m11692r() != null) {
                    TitleModel titleModel = (TitleModel) graphQLModelMutatingVisitor.b(m11692r());
                    if (m11692r() != titleModel) {
                        graphQLVisitableModel = (VideoModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f11193l = titleModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m11680a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m11685k());
                int a = ModelHelper.a(flatBufferBuilder, m11686l());
                int a2 = ModelHelper.a(flatBufferBuilder, m11687m());
                int a3 = ModelHelper.a(flatBufferBuilder, m11688n());
                int b2 = flatBufferBuilder.b(m11689o());
                int b3 = flatBufferBuilder.b(m11691q());
                int a4 = ModelHelper.a(flatBufferBuilder, m11692r());
                int b4 = flatBufferBuilder.b(m11693s());
                flatBufferBuilder.c(11);
                flatBufferBuilder.a(0, this.f11185d, 0);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, a);
                flatBufferBuilder.b(3, a2);
                flatBufferBuilder.b(4, a3);
                flatBufferBuilder.b(5, b2);
                flatBufferBuilder.a(6, this.f11191j, 0);
                flatBufferBuilder.b(7, b3);
                flatBufferBuilder.b(8, a4);
                flatBufferBuilder.b(9, b4);
                flatBufferBuilder.a(10, this.f11195n, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m11683a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f11185d = mutableFlatBuffer.a(i, 0, 0);
                this.f11191j = mutableFlatBuffer.a(i, 6, 0);
                this.f11195n = mutableFlatBuffer.a(i, 10, 0);
            }
        }

        public Inbox2VideoItemFragmentModel() {
            super(1);
        }

        @Nullable
        private VideoModel m11695a() {
            this.f11196d = (VideoModel) super.a(this.f11196d, 0, VideoModel.class);
            return this.f11196d;
        }

        public final int jK_() {
            return -403892174;
        }

        public final GraphQLVisitableModel m11697a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m11695a() != null) {
                VideoModel videoModel = (VideoModel) graphQLModelMutatingVisitor.b(m11695a());
                if (m11695a() != videoModel) {
                    graphQLVisitableModel = (Inbox2VideoItemFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11196d = videoModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m11696a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m11695a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -563903300)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: mScreenData */
    public final class InboxV2QueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private MessengerInboxUnitsModel f11285d;

        /* compiled from: mScreenData */
        public final class Builder {
            @Nullable
            public MessengerInboxUnitsModel f11197a;

            public final Builder m11698a(@Nullable MessengerInboxUnitsModel messengerInboxUnitsModel) {
                this.f11197a = messengerInboxUnitsModel;
                return this;
            }

            public final InboxV2QueryModel m11699a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f11197a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new InboxV2QueryModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: mScreenData */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(InboxV2QueryModel.class, new Deserializer());
            }

            public Object m11700a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = InboxV2QueryParser.m11883a(jsonParser);
                Object inboxV2QueryModel = new InboxV2QueryModel();
                ((BaseModel) inboxV2QueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (inboxV2QueryModel instanceof Postprocessable) {
                    return ((Postprocessable) inboxV2QueryModel).a();
                }
                return inboxV2QueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -803401477)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: mScreenData */
        public final class MessengerInboxUnitsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f11284d;

            /* compiled from: mScreenData */
            public final class Builder {
                @Nullable
                public ImmutableList<NodesModel> f11198a;

                public final Builder m11701a(@Nullable ImmutableList<NodesModel> immutableList) {
                    this.f11198a = immutableList;
                    return this;
                }

                public final MessengerInboxUnitsModel m11702a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, this.f11198a);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new MessengerInboxUnitsModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: mScreenData */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MessengerInboxUnitsModel.class, new Deserializer());
                }

                public Object m11703a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MessengerInboxUnitsParser.m11881a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object messengerInboxUnitsModel = new MessengerInboxUnitsModel();
                    ((BaseModel) messengerInboxUnitsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (messengerInboxUnitsModel instanceof Postprocessable) {
                        return ((Postprocessable) messengerInboxUnitsModel).a();
                    }
                    return messengerInboxUnitsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -797567492)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: mScreenData */
            public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private String f11273d;
                @Nullable
                private MessengerInbox2RecentUnitConfigModel f11274e;
                private int f11275f;
                @Nullable
                private List<MessengerInboxUnitItemsModel> f11276g;
                @Nullable
                private String f11277h;
                private boolean f11278i;
                private boolean f11279j;
                @Nullable
                private MessengerInboxUnitTitleModel f11280k;
                @Nullable
                private GraphQLMessengerInboxUnitType f11281l;
                @Nullable
                private GraphQLMessengerInboxUnitUpdateStatus f11282m;
                private long f11283n;

                /* compiled from: mScreenData */
                public final class Builder {
                    @Nullable
                    public String f11199a;
                    @Nullable
                    public MessengerInbox2RecentUnitConfigModel f11200b;
                    public int f11201c;
                    @Nullable
                    public ImmutableList<MessengerInboxUnitItemsModel> f11202d;
                    @Nullable
                    public String f11203e;
                    public boolean f11204f;
                    public boolean f11205g;
                    @Nullable
                    public MessengerInboxUnitTitleModel f11206h;
                    @Nullable
                    public GraphQLMessengerInboxUnitType f11207i;
                    @Nullable
                    public GraphQLMessengerInboxUnitUpdateStatus f11208j;
                    public long f11209k;

                    public final NodesModel m11704a() {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        int b = flatBufferBuilder.b(this.f11199a);
                        int a = ModelHelper.a(flatBufferBuilder, this.f11200b);
                        int a2 = ModelHelper.a(flatBufferBuilder, this.f11202d);
                        int b2 = flatBufferBuilder.b(this.f11203e);
                        int a3 = ModelHelper.a(flatBufferBuilder, this.f11206h);
                        int a4 = flatBufferBuilder.a(this.f11207i);
                        int a5 = flatBufferBuilder.a(this.f11208j);
                        flatBufferBuilder.c(11);
                        flatBufferBuilder.b(0, b);
                        flatBufferBuilder.b(1, a);
                        flatBufferBuilder.a(2, this.f11201c, 0);
                        flatBufferBuilder.b(3, a2);
                        flatBufferBuilder.b(4, b2);
                        flatBufferBuilder.a(5, this.f11204f);
                        flatBufferBuilder.a(6, this.f11205g);
                        flatBufferBuilder.b(7, a3);
                        flatBufferBuilder.b(8, a4);
                        flatBufferBuilder.b(9, a5);
                        flatBufferBuilder.a(10, this.f11209k, 0);
                        flatBufferBuilder.d(flatBufferBuilder.d());
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        return new NodesModel(new MutableFlatBuffer(wrap, null, null, true, null));
                    }
                }

                /* compiled from: mScreenData */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m11705a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodesParser.m11879b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object nodesModel = new NodesModel();
                        ((BaseModel) nodesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (nodesModel instanceof Postprocessable) {
                            return ((Postprocessable) nodesModel).a();
                        }
                        return nodesModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -2103367574)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: mScreenData */
                public final class MessengerInboxUnitItemsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                    @Nullable
                    private String f11265d;
                    @Nullable
                    private MessengerInboxItemAttachmentModel f11266e;
                    private int f11267f;
                    private int f11268g;
                    private int f11269h;
                    @Nullable
                    private String f11270i;
                    @Nullable
                    private MessengerInboxItemTitleModel f11271j;

                    /* compiled from: mScreenData */
                    public final class Builder {
                        @Nullable
                        public String f11210a;
                        @Nullable
                        public MessengerInboxItemAttachmentModel f11211b;
                        public int f11212c;
                        public int f11213d;
                        public int f11214e;
                        @Nullable
                        public String f11215f;
                        @Nullable
                        public MessengerInboxItemTitleModel f11216g;
                    }

                    /* compiled from: mScreenData */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(MessengerInboxUnitItemsModel.class, new Deserializer());
                        }

                        public Object m11706a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(MessengerInboxUnitItemsParser.m11875b(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object messengerInboxUnitItemsModel = new MessengerInboxUnitItemsModel();
                            ((BaseModel) messengerInboxUnitItemsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (messengerInboxUnitItemsModel instanceof Postprocessable) {
                                return ((Postprocessable) messengerInboxUnitItemsModel).a();
                            }
                            return messengerInboxUnitItemsModel;
                        }
                    }

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = 815387639)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: mScreenData */
                    public final class MessengerInboxItemAttachmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, ConversationStartersFields {
                        @Nullable
                        private GraphQLObjectType f11241d;
                        @Nullable
                        private ActionTextModel f11242e;
                        private int f11243f;
                        @Nullable
                        private String f11244g;
                        @Nullable
                        private DescriptionModel f11245h;
                        @Nullable
                        private String f11246i;
                        @Nullable
                        private ItemDescriptionModel f11247j;
                        @Nullable
                        private ItemDescriptionIconModel f11248k;
                        @Nullable
                        private ItemImageModel f11249l;
                        @Nullable
                        private String f11250m;
                        @Nullable
                        private ItemUserModel f11251n;
                        @Nullable
                        private LinkModel f11252o;
                        @Nullable
                        private McsItemTitleModel f11253p;
                        @Nullable
                        private PageModel f11254q;
                        @Nullable
                        private GraphQLMessengerPYMMIconType f11255r;
                        @Nullable
                        private GraphQLMessengerInbox2MessageThreadReason f11256s;
                        private boolean f11257t;
                        @Nullable
                        private String f11258u;
                        @Nullable
                        private ThreadModel f11259v;
                        private int f11260w;
                        private int f11261x;
                        @Nullable
                        private PeopleYouMayMessageUserInfoModel f11262y;
                        @Nullable
                        private VideoModel f11263z;

                        /* compiled from: mScreenData */
                        public final class Builder {
                            @Nullable
                            public GraphQLObjectType f11217a;
                            @Nullable
                            public ActionTextModel f11218b;
                            public int f11219c;
                            @Nullable
                            public String f11220d;
                            @Nullable
                            public DescriptionModel f11221e;
                            @Nullable
                            public String f11222f;
                            @Nullable
                            public ItemDescriptionModel f11223g;
                            @Nullable
                            public ItemDescriptionIconModel f11224h;
                            @Nullable
                            public ItemImageModel f11225i;
                            @Nullable
                            public String f11226j;
                            @Nullable
                            public ItemUserModel f11227k;
                            @Nullable
                            public LinkModel f11228l;
                            @Nullable
                            public McsItemTitleModel f11229m;
                            @Nullable
                            public PageModel f11230n;
                            @Nullable
                            public GraphQLMessengerPYMMIconType f11231o;
                            @Nullable
                            public GraphQLMessengerInbox2MessageThreadReason f11232p;
                            public boolean f11233q;
                            @Nullable
                            public String f11234r;
                            @Nullable
                            public ThreadModel f11235s;
                            public int f11236t;
                            public int f11237u;
                            @Nullable
                            public PeopleYouMayMessageUserInfoModel f11238v;
                            @Nullable
                            public VideoModel f11239w;

                            public final MessengerInboxItemAttachmentModel m11707a() {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                int a = ModelHelper.a(flatBufferBuilder, this.f11217a);
                                int a2 = ModelHelper.a(flatBufferBuilder, this.f11218b);
                                int b = flatBufferBuilder.b(this.f11220d);
                                int a3 = ModelHelper.a(flatBufferBuilder, this.f11221e);
                                int b2 = flatBufferBuilder.b(this.f11222f);
                                int a4 = ModelHelper.a(flatBufferBuilder, this.f11223g);
                                int a5 = ModelHelper.a(flatBufferBuilder, this.f11224h);
                                int a6 = ModelHelper.a(flatBufferBuilder, this.f11225i);
                                int b3 = flatBufferBuilder.b(this.f11226j);
                                int a7 = ModelHelper.a(flatBufferBuilder, this.f11227k);
                                int a8 = ModelHelper.a(flatBufferBuilder, this.f11228l);
                                int a9 = ModelHelper.a(flatBufferBuilder, this.f11229m);
                                int a10 = ModelHelper.a(flatBufferBuilder, this.f11230n);
                                int a11 = flatBufferBuilder.a(this.f11231o);
                                int a12 = flatBufferBuilder.a(this.f11232p);
                                int b4 = flatBufferBuilder.b(this.f11234r);
                                int a13 = ModelHelper.a(flatBufferBuilder, this.f11235s);
                                int a14 = ModelHelper.a(flatBufferBuilder, this.f11238v);
                                int a15 = ModelHelper.a(flatBufferBuilder, this.f11239w);
                                flatBufferBuilder.c(23);
                                flatBufferBuilder.b(0, a);
                                flatBufferBuilder.b(1, a2);
                                flatBufferBuilder.a(2, this.f11219c, 0);
                                flatBufferBuilder.b(3, b);
                                flatBufferBuilder.b(4, a3);
                                flatBufferBuilder.b(5, b2);
                                flatBufferBuilder.b(6, a4);
                                flatBufferBuilder.b(7, a5);
                                flatBufferBuilder.b(8, a6);
                                flatBufferBuilder.b(9, b3);
                                flatBufferBuilder.b(10, a7);
                                flatBufferBuilder.b(11, a8);
                                flatBufferBuilder.b(12, a9);
                                flatBufferBuilder.b(13, a10);
                                flatBufferBuilder.b(14, a11);
                                flatBufferBuilder.b(15, a12);
                                flatBufferBuilder.a(16, this.f11233q);
                                flatBufferBuilder.b(17, b4);
                                flatBufferBuilder.b(18, a13);
                                flatBufferBuilder.a(19, this.f11236t, 0);
                                flatBufferBuilder.a(20, this.f11237u, 0);
                                flatBufferBuilder.b(21, a14);
                                flatBufferBuilder.b(22, a15);
                                flatBufferBuilder.d(flatBufferBuilder.d());
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                return new MessengerInboxItemAttachmentModel(new MutableFlatBuffer(wrap, null, null, true, null));
                            }
                        }

                        /* compiled from: mScreenData */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(MessengerInboxItemAttachmentModel.class, new Deserializer());
                            }

                            public Object m11708a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(MessengerInboxItemAttachmentParser.m11870a(jsonParser, flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                Object messengerInboxItemAttachmentModel = new MessengerInboxItemAttachmentModel();
                                ((BaseModel) messengerInboxItemAttachmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                if (messengerInboxItemAttachmentModel instanceof Postprocessable) {
                                    return ((Postprocessable) messengerInboxItemAttachmentModel).a();
                                }
                                return messengerInboxItemAttachmentModel;
                            }
                        }

                        @JsonDeserialize(using = Deserializer.class)
                        @ModelWithFlatBufferFormatHash(a = 842551240)
                        @JsonSerialize(using = Serializer.class)
                        @FragmentModelWithoutBridge
                        /* compiled from: mScreenData */
                        public final class ItemImageModel extends BaseModel implements GraphQLVisitableModel, ItemImage {
                            @Nullable
                            private String f11240d;

                            /* compiled from: mScreenData */
                            public class Deserializer extends FbJsonDeserializer {
                                static {
                                    GlobalAutoGenDeserializerCache.a(ItemImageModel.class, new Deserializer());
                                }

                                public Object m11709a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(MessengerInboxItemAttachmentParser.ItemImageParser.m11868a(jsonParser, flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                    Object itemImageModel = new ItemImageModel();
                                    ((BaseModel) itemImageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                    if (itemImageModel instanceof Postprocessable) {
                                        return ((Postprocessable) itemImageModel).a();
                                    }
                                    return itemImageModel;
                                }
                            }

                            /* compiled from: mScreenData */
                            public class Serializer extends JsonSerializer<ItemImageModel> {
                                public final void m11710a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                    ItemImageModel itemImageModel = (ItemImageModel) obj;
                                    if (itemImageModel.w_() == null) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(itemImageModel.m11711a(flatBufferBuilder));
                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                        wrap.position(0);
                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                        itemImageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                    }
                                    MessengerInboxItemAttachmentParser.ItemImageParser.m11869a(itemImageModel.w_(), itemImageModel.u_(), jsonGenerator);
                                }

                                static {
                                    FbSerializerProvider.a(ItemImageModel.class, new Serializer());
                                }
                            }

                            public ItemImageModel() {
                                super(1);
                            }

                            @Nullable
                            public final String mo415a() {
                                this.f11240d = super.a(this.f11240d, 0);
                                return this.f11240d;
                            }

                            public final int jK_() {
                                return 70760763;
                            }

                            public final GraphQLVisitableModel m11712a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                h();
                                i();
                                return this;
                            }

                            public final int m11711a(FlatBufferBuilder flatBufferBuilder) {
                                h();
                                int b = flatBufferBuilder.b(mo415a());
                                flatBufferBuilder.c(1);
                                flatBufferBuilder.b(0, b);
                                i();
                                return flatBufferBuilder.d();
                            }
                        }

                        /* compiled from: mScreenData */
                        public class Serializer extends JsonSerializer<MessengerInboxItemAttachmentModel> {
                            public final void m11714a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                MessengerInboxItemAttachmentModel messengerInboxItemAttachmentModel = (MessengerInboxItemAttachmentModel) obj;
                                if (messengerInboxItemAttachmentModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(messengerInboxItemAttachmentModel.m11722a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    messengerInboxItemAttachmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                MessengerInboxItemAttachmentParser.m11871a(messengerInboxItemAttachmentModel.w_(), messengerInboxItemAttachmentModel.u_(), jsonGenerator, serializerProvider);
                            }

                            static {
                                FbSerializerProvider.a(MessengerInboxItemAttachmentModel.class, new Serializer());
                            }
                        }

                        @Nullable
                        public final /* synthetic */ ItemDescriptionModel mo417c() {
                            return m11719x();
                        }

                        @Nullable
                        public final /* synthetic */ ItemDescriptionIconModel mo418d() {
                            return m11720y();
                        }

                        @Nullable
                        public final /* synthetic */ ItemUserModel mo419g() {
                            return m11715A();
                        }

                        @Nullable
                        public final /* synthetic */ McsItemTitleModel lK_() {
                            return m11716B();
                        }

                        @Nullable
                        public final /* synthetic */ ItemImage lL_() {
                            return m11734l();
                        }

                        public MessengerInboxItemAttachmentModel() {
                            super(23);
                        }

                        public MessengerInboxItemAttachmentModel(MutableFlatBuffer mutableFlatBuffer) {
                            super(23);
                            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }

                        public final void m11726a(String str, ConsistencyTuple consistencyTuple) {
                            consistencyTuple.a();
                        }

                        public final void m11727a(String str, Object obj, boolean z) {
                        }

                        @Nullable
                        private GraphQLObjectType m11717v() {
                            if (this.b != null && this.f11241d == null) {
                                this.f11241d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                            }
                            return this.f11241d;
                        }

                        @Nullable
                        public final ActionTextModel m11732j() {
                            this.f11242e = (ActionTextModel) super.a(this.f11242e, 1, ActionTextModel.class);
                            return this.f11242e;
                        }

                        @Nullable
                        public final String mo416b() {
                            this.f11244g = super.a(this.f11244g, 3);
                            return this.f11244g;
                        }

                        @Nullable
                        public final DescriptionModel m11733k() {
                            this.f11245h = (DescriptionModel) super.a(this.f11245h, 4, DescriptionModel.class);
                            return this.f11245h;
                        }

                        @Nullable
                        private String m11718w() {
                            this.f11246i = super.a(this.f11246i, 5);
                            return this.f11246i;
                        }

                        @Nullable
                        private ItemDescriptionModel m11719x() {
                            this.f11247j = (ItemDescriptionModel) super.a(this.f11247j, 6, ItemDescriptionModel.class);
                            return this.f11247j;
                        }

                        @Nullable
                        private ItemDescriptionIconModel m11720y() {
                            this.f11248k = (ItemDescriptionIconModel) super.a(this.f11248k, 7, ItemDescriptionIconModel.class);
                            return this.f11248k;
                        }

                        @Nullable
                        public final ItemImageModel m11734l() {
                            this.f11249l = (ItemImageModel) super.a(this.f11249l, 8, ItemImageModel.class);
                            return this.f11249l;
                        }

                        @Nullable
                        private String m11721z() {
                            this.f11250m = super.a(this.f11250m, 9);
                            return this.f11250m;
                        }

                        @Nullable
                        private ItemUserModel m11715A() {
                            this.f11251n = (ItemUserModel) super.a(this.f11251n, 10, ItemUserModel.class);
                            return this.f11251n;
                        }

                        @Nullable
                        public final LinkModel m11735m() {
                            this.f11252o = (LinkModel) super.a(this.f11252o, 11, LinkModel.class);
                            return this.f11252o;
                        }

                        @Nullable
                        private McsItemTitleModel m11716B() {
                            this.f11253p = (McsItemTitleModel) super.a(this.f11253p, 12, McsItemTitleModel.class);
                            return this.f11253p;
                        }

                        @Nullable
                        public final PageModel m11736n() {
                            this.f11254q = (PageModel) super.a(this.f11254q, 13, PageModel.class);
                            return this.f11254q;
                        }

                        @Nullable
                        public final GraphQLMessengerPYMMIconType m11737o() {
                            this.f11255r = (GraphQLMessengerPYMMIconType) super.b(this.f11255r, 14, GraphQLMessengerPYMMIconType.class, GraphQLMessengerPYMMIconType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                            return this.f11255r;
                        }

                        @Nullable
                        public final GraphQLMessengerInbox2MessageThreadReason m11738p() {
                            this.f11256s = (GraphQLMessengerInbox2MessageThreadReason) super.b(this.f11256s, 15, GraphQLMessengerInbox2MessageThreadReason.class, GraphQLMessengerInbox2MessageThreadReason.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                            return this.f11256s;
                        }

                        public final boolean lJ_() {
                            a(2, 0);
                            return this.f11257t;
                        }

                        @Nullable
                        public final String m11739q() {
                            this.f11258u = super.a(this.f11258u, 17);
                            return this.f11258u;
                        }

                        @Nullable
                        public final ThreadModel m11740r() {
                            this.f11259v = (ThreadModel) super.a(this.f11259v, 18, ThreadModel.class);
                            return this.f11259v;
                        }

                        public final int m11741s() {
                            a(2, 4);
                            return this.f11261x;
                        }

                        @Nullable
                        public final PeopleYouMayMessageUserInfoModel m11742t() {
                            this.f11262y = (PeopleYouMayMessageUserInfoModel) super.a(this.f11262y, 21, PeopleYouMayMessageUserInfoModel.class);
                            return this.f11262y;
                        }

                        @Nullable
                        public final VideoModel m11743u() {
                            this.f11263z = (VideoModel) super.a(this.f11263z, 22, VideoModel.class);
                            return this.f11263z;
                        }

                        @Nullable
                        public final String m11724a() {
                            return m11718w();
                        }

                        public final int jK_() {
                            return -1533711671;
                        }

                        public final GraphQLVisitableModel m11723a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            GraphQLVisitableModel graphQLVisitableModel = null;
                            h();
                            if (m11732j() != null) {
                                ActionTextModel actionTextModel = (ActionTextModel) graphQLModelMutatingVisitor.b(m11732j());
                                if (m11732j() != actionTextModel) {
                                    graphQLVisitableModel = (MessengerInboxItemAttachmentModel) ModelHelper.a(null, this);
                                    graphQLVisitableModel.f11242e = actionTextModel;
                                }
                            }
                            if (m11733k() != null) {
                                DescriptionModel descriptionModel = (DescriptionModel) graphQLModelMutatingVisitor.b(m11733k());
                                if (m11733k() != descriptionModel) {
                                    graphQLVisitableModel = (MessengerInboxItemAttachmentModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f11245h = descriptionModel;
                                }
                            }
                            if (m11719x() != null) {
                                ItemDescriptionModel itemDescriptionModel = (ItemDescriptionModel) graphQLModelMutatingVisitor.b(m11719x());
                                if (m11719x() != itemDescriptionModel) {
                                    graphQLVisitableModel = (MessengerInboxItemAttachmentModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f11247j = itemDescriptionModel;
                                }
                            }
                            if (m11720y() != null) {
                                ItemDescriptionIconModel itemDescriptionIconModel = (ItemDescriptionIconModel) graphQLModelMutatingVisitor.b(m11720y());
                                if (m11720y() != itemDescriptionIconModel) {
                                    graphQLVisitableModel = (MessengerInboxItemAttachmentModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f11248k = itemDescriptionIconModel;
                                }
                            }
                            if (m11734l() != null) {
                                ItemImageModel itemImageModel = (ItemImageModel) graphQLModelMutatingVisitor.b(m11734l());
                                if (m11734l() != itemImageModel) {
                                    graphQLVisitableModel = (MessengerInboxItemAttachmentModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f11249l = itemImageModel;
                                }
                            }
                            if (m11715A() != null) {
                                ItemUserModel itemUserModel = (ItemUserModel) graphQLModelMutatingVisitor.b(m11715A());
                                if (m11715A() != itemUserModel) {
                                    graphQLVisitableModel = (MessengerInboxItemAttachmentModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f11251n = itemUserModel;
                                }
                            }
                            if (m11735m() != null) {
                                LinkModel linkModel = (LinkModel) graphQLModelMutatingVisitor.b(m11735m());
                                if (m11735m() != linkModel) {
                                    graphQLVisitableModel = (MessengerInboxItemAttachmentModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f11252o = linkModel;
                                }
                            }
                            if (m11716B() != null) {
                                McsItemTitleModel mcsItemTitleModel = (McsItemTitleModel) graphQLModelMutatingVisitor.b(m11716B());
                                if (m11716B() != mcsItemTitleModel) {
                                    graphQLVisitableModel = (MessengerInboxItemAttachmentModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f11253p = mcsItemTitleModel;
                                }
                            }
                            if (m11736n() != null) {
                                PageModel pageModel = (PageModel) graphQLModelMutatingVisitor.b(m11736n());
                                if (m11736n() != pageModel) {
                                    graphQLVisitableModel = (MessengerInboxItemAttachmentModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f11254q = pageModel;
                                }
                            }
                            if (m11740r() != null) {
                                ThreadModel threadModel = (ThreadModel) graphQLModelMutatingVisitor.b(m11740r());
                                if (m11740r() != threadModel) {
                                    graphQLVisitableModel = (MessengerInboxItemAttachmentModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f11259v = threadModel;
                                }
                            }
                            if (m11742t() != null) {
                                PeopleYouMayMessageUserInfoModel peopleYouMayMessageUserInfoModel = (PeopleYouMayMessageUserInfoModel) graphQLModelMutatingVisitor.b(m11742t());
                                if (m11742t() != peopleYouMayMessageUserInfoModel) {
                                    graphQLVisitableModel = (MessengerInboxItemAttachmentModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f11262y = peopleYouMayMessageUserInfoModel;
                                }
                            }
                            if (m11743u() != null) {
                                VideoModel videoModel = (VideoModel) graphQLModelMutatingVisitor.b(m11743u());
                                if (m11743u() != videoModel) {
                                    graphQLVisitableModel = (MessengerInboxItemAttachmentModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f11263z = videoModel;
                                }
                            }
                            i();
                            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                        }

                        public final int m11722a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int a = ModelHelper.a(flatBufferBuilder, m11717v());
                            int a2 = ModelHelper.a(flatBufferBuilder, m11732j());
                            int b = flatBufferBuilder.b(mo416b());
                            int a3 = ModelHelper.a(flatBufferBuilder, m11733k());
                            int b2 = flatBufferBuilder.b(m11718w());
                            int a4 = ModelHelper.a(flatBufferBuilder, m11719x());
                            int a5 = ModelHelper.a(flatBufferBuilder, m11720y());
                            int a6 = ModelHelper.a(flatBufferBuilder, m11734l());
                            int b3 = flatBufferBuilder.b(m11721z());
                            int a7 = ModelHelper.a(flatBufferBuilder, m11715A());
                            int a8 = ModelHelper.a(flatBufferBuilder, m11735m());
                            int a9 = ModelHelper.a(flatBufferBuilder, m11716B());
                            int a10 = ModelHelper.a(flatBufferBuilder, m11736n());
                            int a11 = flatBufferBuilder.a(m11737o());
                            int a12 = flatBufferBuilder.a(m11738p());
                            int b4 = flatBufferBuilder.b(m11739q());
                            int a13 = ModelHelper.a(flatBufferBuilder, m11740r());
                            int a14 = ModelHelper.a(flatBufferBuilder, m11742t());
                            int a15 = ModelHelper.a(flatBufferBuilder, m11743u());
                            flatBufferBuilder.c(23);
                            flatBufferBuilder.b(0, a);
                            flatBufferBuilder.b(1, a2);
                            flatBufferBuilder.a(2, this.f11243f, 0);
                            flatBufferBuilder.b(3, b);
                            flatBufferBuilder.b(4, a3);
                            flatBufferBuilder.b(5, b2);
                            flatBufferBuilder.b(6, a4);
                            flatBufferBuilder.b(7, a5);
                            flatBufferBuilder.b(8, a6);
                            flatBufferBuilder.b(9, b3);
                            flatBufferBuilder.b(10, a7);
                            flatBufferBuilder.b(11, a8);
                            flatBufferBuilder.b(12, a9);
                            flatBufferBuilder.b(13, a10);
                            flatBufferBuilder.b(14, a11);
                            flatBufferBuilder.b(15, a12);
                            flatBufferBuilder.a(16, this.f11257t);
                            flatBufferBuilder.b(17, b4);
                            flatBufferBuilder.b(18, a13);
                            flatBufferBuilder.a(19, this.f11260w, 0);
                            flatBufferBuilder.a(20, this.f11261x, 0);
                            flatBufferBuilder.b(21, a14);
                            flatBufferBuilder.b(22, a15);
                            i();
                            return flatBufferBuilder.d();
                        }

                        public final void m11725a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                            super.a(mutableFlatBuffer, i, obj);
                            this.f11243f = mutableFlatBuffer.a(i, 2, 0);
                            this.f11257t = mutableFlatBuffer.a(i, 16);
                            this.f11260w = mutableFlatBuffer.a(i, 19, 0);
                            this.f11261x = mutableFlatBuffer.a(i, 20, 0);
                        }
                    }

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = -1352864475)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: mScreenData */
                    public final class MessengerInboxItemTitleModel extends BaseModel implements GraphQLVisitableModel {
                        @Nullable
                        private String f11264d;

                        /* compiled from: mScreenData */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(MessengerInboxItemTitleModel.class, new Deserializer());
                            }

                            public Object m11744a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(MessengerInboxItemTitleParser.m11872a(jsonParser, flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                Object messengerInboxItemTitleModel = new MessengerInboxItemTitleModel();
                                ((BaseModel) messengerInboxItemTitleModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                if (messengerInboxItemTitleModel instanceof Postprocessable) {
                                    return ((Postprocessable) messengerInboxItemTitleModel).a();
                                }
                                return messengerInboxItemTitleModel;
                            }
                        }

                        /* compiled from: mScreenData */
                        public class Serializer extends JsonSerializer<MessengerInboxItemTitleModel> {
                            public final void m11745a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                MessengerInboxItemTitleModel messengerInboxItemTitleModel = (MessengerInboxItemTitleModel) obj;
                                if (messengerInboxItemTitleModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(messengerInboxItemTitleModel.m11746a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    messengerInboxItemTitleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                MessengerInboxItemTitleParser.m11873a(messengerInboxItemTitleModel.w_(), messengerInboxItemTitleModel.u_(), jsonGenerator);
                            }

                            static {
                                FbSerializerProvider.a(MessengerInboxItemTitleModel.class, new Serializer());
                            }
                        }

                        public MessengerInboxItemTitleModel() {
                            super(1);
                        }

                        @Nullable
                        public final String m11748a() {
                            this.f11264d = super.a(this.f11264d, 0);
                            return this.f11264d;
                        }

                        public final int jK_() {
                            return -1919764332;
                        }

                        public final GraphQLVisitableModel m11747a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            h();
                            i();
                            return this;
                        }

                        public final int m11746a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int b = flatBufferBuilder.b(m11748a());
                            flatBufferBuilder.c(1);
                            flatBufferBuilder.b(0, b);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    /* compiled from: mScreenData */
                    public class Serializer extends JsonSerializer<MessengerInboxUnitItemsModel> {
                        public final void m11749a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            MessengerInboxUnitItemsModel messengerInboxUnitItemsModel = (MessengerInboxUnitItemsModel) obj;
                            if (messengerInboxUnitItemsModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(messengerInboxUnitItemsModel.m11753a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                messengerInboxUnitItemsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            MessengerInboxUnitItemsParser.m11876b(messengerInboxUnitItemsModel.w_(), messengerInboxUnitItemsModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(MessengerInboxUnitItemsModel.class, new Serializer());
                        }
                    }

                    public MessengerInboxUnitItemsModel() {
                        super(7);
                    }

                    public MessengerInboxUnitItemsModel(MutableFlatBuffer mutableFlatBuffer) {
                        super(7);
                        a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }

                    public final void m11757a(String str, ConsistencyTuple consistencyTuple) {
                        if ("messenger_inbox_item_clicks_remaining".equals(str)) {
                            consistencyTuple.a = Integer.valueOf(m11761l());
                            consistencyTuple.b = u_();
                            consistencyTuple.c = 2;
                        } else if ("messenger_inbox_item_hides_remaining".equals(str)) {
                            consistencyTuple.a = Integer.valueOf(m11762m());
                            consistencyTuple.b = u_();
                            consistencyTuple.c = 3;
                        } else if ("messenger_inbox_item_impressions_remaining".equals(str)) {
                            consistencyTuple.a = Integer.valueOf(m11763n());
                            consistencyTuple.b = u_();
                            consistencyTuple.c = 4;
                        } else {
                            consistencyTuple.a();
                        }
                    }

                    public final void m11758a(String str, Object obj, boolean z) {
                        if ("messenger_inbox_item_clicks_remaining".equals(str)) {
                            m11750a(((Integer) obj).intValue());
                        } else if ("messenger_inbox_item_hides_remaining".equals(str)) {
                            m11751b(((Integer) obj).intValue());
                        } else if ("messenger_inbox_item_impressions_remaining".equals(str)) {
                            m11752c(((Integer) obj).intValue());
                        }
                    }

                    @Nullable
                    public final String m11759j() {
                        this.f11265d = super.a(this.f11265d, 0);
                        return this.f11265d;
                    }

                    @Nullable
                    public final MessengerInboxItemAttachmentModel m11760k() {
                        this.f11266e = (MessengerInboxItemAttachmentModel) super.a(this.f11266e, 1, MessengerInboxItemAttachmentModel.class);
                        return this.f11266e;
                    }

                    public final int m11761l() {
                        a(0, 2);
                        return this.f11267f;
                    }

                    private void m11750a(int i) {
                        this.f11267f = i;
                        if (this.b != null && this.b.d) {
                            this.b.b(this.c, 2, i);
                        }
                    }

                    public final int m11762m() {
                        a(0, 3);
                        return this.f11268g;
                    }

                    private void m11751b(int i) {
                        this.f11268g = i;
                        if (this.b != null && this.b.d) {
                            this.b.b(this.c, 3, i);
                        }
                    }

                    public final int m11763n() {
                        a(0, 4);
                        return this.f11269h;
                    }

                    private void m11752c(int i) {
                        this.f11269h = i;
                        if (this.b != null && this.b.d) {
                            this.b.b(this.c, 4, i);
                        }
                    }

                    @Nullable
                    public final String m11764o() {
                        this.f11270i = super.a(this.f11270i, 5);
                        return this.f11270i;
                    }

                    @Nullable
                    public final MessengerInboxItemTitleModel m11765p() {
                        this.f11271j = (MessengerInboxItemTitleModel) super.a(this.f11271j, 6, MessengerInboxItemTitleModel.class);
                        return this.f11271j;
                    }

                    @Nullable
                    public final String m11755a() {
                        return m11759j();
                    }

                    public final int jK_() {
                        return -876460794;
                    }

                    public final GraphQLVisitableModel m11754a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m11760k() != null) {
                            MessengerInboxItemAttachmentModel messengerInboxItemAttachmentModel = (MessengerInboxItemAttachmentModel) graphQLModelMutatingVisitor.b(m11760k());
                            if (m11760k() != messengerInboxItemAttachmentModel) {
                                graphQLVisitableModel = (MessengerInboxUnitItemsModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f11266e = messengerInboxItemAttachmentModel;
                            }
                        }
                        if (m11765p() != null) {
                            MessengerInboxItemTitleModel messengerInboxItemTitleModel = (MessengerInboxItemTitleModel) graphQLModelMutatingVisitor.b(m11765p());
                            if (m11765p() != messengerInboxItemTitleModel) {
                                graphQLVisitableModel = (MessengerInboxUnitItemsModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f11271j = messengerInboxItemTitleModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m11753a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m11759j());
                        int a = ModelHelper.a(flatBufferBuilder, m11760k());
                        int b2 = flatBufferBuilder.b(m11764o());
                        int a2 = ModelHelper.a(flatBufferBuilder, m11765p());
                        flatBufferBuilder.c(7);
                        flatBufferBuilder.b(0, b);
                        flatBufferBuilder.b(1, a);
                        flatBufferBuilder.a(2, this.f11267f, 0);
                        flatBufferBuilder.a(3, this.f11268g, 0);
                        flatBufferBuilder.a(4, this.f11269h, 0);
                        flatBufferBuilder.b(5, b2);
                        flatBufferBuilder.b(6, a2);
                        i();
                        return flatBufferBuilder.d();
                    }

                    public final void m11756a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                        super.a(mutableFlatBuffer, i, obj);
                        this.f11267f = mutableFlatBuffer.a(i, 2, 0);
                        this.f11268g = mutableFlatBuffer.a(i, 3, 0);
                        this.f11269h = mutableFlatBuffer.a(i, 4, 0);
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1352864475)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: mScreenData */
                public final class MessengerInboxUnitTitleModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f11272d;

                    /* compiled from: mScreenData */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(MessengerInboxUnitTitleModel.class, new Deserializer());
                        }

                        public Object m11766a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(MessengerInboxUnitTitleParser.m11877a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object messengerInboxUnitTitleModel = new MessengerInboxUnitTitleModel();
                            ((BaseModel) messengerInboxUnitTitleModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (messengerInboxUnitTitleModel instanceof Postprocessable) {
                                return ((Postprocessable) messengerInboxUnitTitleModel).a();
                            }
                            return messengerInboxUnitTitleModel;
                        }
                    }

                    /* compiled from: mScreenData */
                    public class Serializer extends JsonSerializer<MessengerInboxUnitTitleModel> {
                        public final void m11767a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            MessengerInboxUnitTitleModel messengerInboxUnitTitleModel = (MessengerInboxUnitTitleModel) obj;
                            if (messengerInboxUnitTitleModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(messengerInboxUnitTitleModel.m11768a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                messengerInboxUnitTitleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            MessengerInboxUnitTitleParser.m11878a(messengerInboxUnitTitleModel.w_(), messengerInboxUnitTitleModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(MessengerInboxUnitTitleModel.class, new Serializer());
                        }
                    }

                    public MessengerInboxUnitTitleModel() {
                        super(1);
                    }

                    @Nullable
                    public final String m11770a() {
                        this.f11272d = super.a(this.f11272d, 0);
                        return this.f11272d;
                    }

                    public final int jK_() {
                        return -1919764332;
                    }

                    public final GraphQLVisitableModel m11769a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m11768a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m11770a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: mScreenData */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m11771a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m11773a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NodesParser.m11880b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                public NodesModel() {
                    super(11);
                }

                public NodesModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(11);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                public final void m11777a(String str, ConsistencyTuple consistencyTuple) {
                    if ("messenger_inbox_unit_hides_remaining".equals(str)) {
                        consistencyTuple.a = Integer.valueOf(m11781l());
                        consistencyTuple.b = u_();
                        consistencyTuple.c = 2;
                        return;
                    }
                    consistencyTuple.a();
                }

                public final void m11778a(String str, Object obj, boolean z) {
                    if ("messenger_inbox_unit_hides_remaining".equals(str)) {
                        m11772a(((Integer) obj).intValue());
                    }
                }

                @Nullable
                public final String m11779j() {
                    this.f11273d = super.a(this.f11273d, 0);
                    return this.f11273d;
                }

                @Nullable
                public final MessengerInbox2RecentUnitConfigModel m11780k() {
                    this.f11274e = (MessengerInbox2RecentUnitConfigModel) super.a(this.f11274e, 1, MessengerInbox2RecentUnitConfigModel.class);
                    return this.f11274e;
                }

                public final int m11781l() {
                    a(0, 2);
                    return this.f11275f;
                }

                private void m11772a(int i) {
                    this.f11275f = i;
                    if (this.b != null && this.b.d) {
                        this.b.b(this.c, 2, i);
                    }
                }

                @Nonnull
                public final ImmutableList<MessengerInboxUnitItemsModel> m11782m() {
                    this.f11276g = super.a(this.f11276g, 3, MessengerInboxUnitItemsModel.class);
                    return (ImmutableList) this.f11276g;
                }

                @Nullable
                public final String m11783n() {
                    this.f11277h = super.a(this.f11277h, 4);
                    return this.f11277h;
                }

                public final boolean m11784o() {
                    a(0, 5);
                    return this.f11278i;
                }

                public final boolean m11785p() {
                    a(0, 6);
                    return this.f11279j;
                }

                @Nullable
                public final MessengerInboxUnitTitleModel m11786q() {
                    this.f11280k = (MessengerInboxUnitTitleModel) super.a(this.f11280k, 7, MessengerInboxUnitTitleModel.class);
                    return this.f11280k;
                }

                @Nullable
                public final GraphQLMessengerInboxUnitType m11787r() {
                    this.f11281l = (GraphQLMessengerInboxUnitType) super.b(this.f11281l, 8, GraphQLMessengerInboxUnitType.class, GraphQLMessengerInboxUnitType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                    return this.f11281l;
                }

                @Nullable
                public final GraphQLMessengerInboxUnitUpdateStatus m11788s() {
                    this.f11282m = (GraphQLMessengerInboxUnitUpdateStatus) super.b(this.f11282m, 9, GraphQLMessengerInboxUnitUpdateStatus.class, GraphQLMessengerInboxUnitUpdateStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                    return this.f11282m;
                }

                public final long m11789t() {
                    a(1, 2);
                    return this.f11283n;
                }

                @Nullable
                public final String m11775a() {
                    return m11779j();
                }

                public final int jK_() {
                    return -876108937;
                }

                public final GraphQLVisitableModel m11774a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m11780k() != null) {
                        MessengerInbox2RecentUnitConfigModel messengerInbox2RecentUnitConfigModel = (MessengerInbox2RecentUnitConfigModel) graphQLModelMutatingVisitor.b(m11780k());
                        if (m11780k() != messengerInbox2RecentUnitConfigModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f11274e = messengerInbox2RecentUnitConfigModel;
                        }
                    }
                    if (m11782m() != null) {
                        com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m11782m(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            NodesModel nodesModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                            nodesModel.f11276g = a.b();
                            graphQLVisitableModel = nodesModel;
                        }
                    }
                    if (m11786q() != null) {
                        MessengerInboxUnitTitleModel messengerInboxUnitTitleModel = (MessengerInboxUnitTitleModel) graphQLModelMutatingVisitor.b(m11786q());
                        if (m11786q() != messengerInboxUnitTitleModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f11280k = messengerInboxUnitTitleModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m11773a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m11779j());
                    int a = ModelHelper.a(flatBufferBuilder, m11780k());
                    int a2 = ModelHelper.a(flatBufferBuilder, m11782m());
                    int b2 = flatBufferBuilder.b(m11783n());
                    int a3 = ModelHelper.a(flatBufferBuilder, m11786q());
                    int a4 = flatBufferBuilder.a(m11787r());
                    int a5 = flatBufferBuilder.a(m11788s());
                    flatBufferBuilder.c(11);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, a);
                    flatBufferBuilder.a(2, this.f11275f, 0);
                    flatBufferBuilder.b(3, a2);
                    flatBufferBuilder.b(4, b2);
                    flatBufferBuilder.a(5, this.f11278i);
                    flatBufferBuilder.a(6, this.f11279j);
                    flatBufferBuilder.b(7, a3);
                    flatBufferBuilder.b(8, a4);
                    flatBufferBuilder.b(9, a5);
                    flatBufferBuilder.a(10, this.f11283n, 0);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m11776a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f11275f = mutableFlatBuffer.a(i, 2, 0);
                    this.f11278i = mutableFlatBuffer.a(i, 5);
                    this.f11279j = mutableFlatBuffer.a(i, 6);
                    this.f11283n = mutableFlatBuffer.a(i, 10, 0);
                }
            }

            /* compiled from: mScreenData */
            public class Serializer extends JsonSerializer<MessengerInboxUnitsModel> {
                public final void m11790a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MessengerInboxUnitsModel messengerInboxUnitsModel = (MessengerInboxUnitsModel) obj;
                    if (messengerInboxUnitsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(messengerInboxUnitsModel.m11791a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        messengerInboxUnitsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MessengerInboxUnitsParser.m11882a(messengerInboxUnitsModel.w_(), messengerInboxUnitsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(MessengerInboxUnitsModel.class, new Serializer());
                }
            }

            public MessengerInboxUnitsModel() {
                super(1);
            }

            public MessengerInboxUnitsModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nonnull
            public final ImmutableList<NodesModel> m11793a() {
                this.f11284d = super.a(this.f11284d, 0, NodesModel.class);
                return (ImmutableList) this.f11284d;
            }

            public final int jK_() {
                return -1123351590;
            }

            public final GraphQLVisitableModel m11792a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m11793a() != null) {
                    com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m11793a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (MessengerInboxUnitsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f11284d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m11791a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m11793a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: mScreenData */
        public class Serializer extends JsonSerializer<InboxV2QueryModel> {
            public final void m11794a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                InboxV2QueryModel inboxV2QueryModel = (InboxV2QueryModel) obj;
                if (inboxV2QueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(inboxV2QueryModel.m11795a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    inboxV2QueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = inboxV2QueryModel.w_();
                int u_ = inboxV2QueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("messenger_inbox_units");
                    MessengerInboxUnitsParser.m11882a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(InboxV2QueryModel.class, new Serializer());
            }
        }

        public InboxV2QueryModel() {
            super(1);
        }

        public InboxV2QueryModel(MutableFlatBuffer mutableFlatBuffer) {
            super(1);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final MessengerInboxUnitsModel m11797a() {
            this.f11285d = (MessengerInboxUnitsModel) super.a(this.f11285d, 0, MessengerInboxUnitsModel.class);
            return this.f11285d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m11796a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m11797a() != null) {
                MessengerInboxUnitsModel messengerInboxUnitsModel = (MessengerInboxUnitsModel) graphQLModelMutatingVisitor.b(m11797a());
                if (m11797a() != messengerInboxUnitsModel) {
                    graphQLVisitableModel = (InboxV2QueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11285d = messengerInboxUnitsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m11795a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m11797a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 103157715)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: mScreenData */
    public final class MessageThreadsInbox2UnitFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GraphQLMessengerInbox2MessageThreadReason f11290d;
        @Nullable
        private ThreadModel f11291e;

        /* compiled from: mScreenData */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MessageThreadsInbox2UnitFragmentModel.class, new Deserializer());
            }

            public Object m11798a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = MessageThreadsInbox2UnitFragmentParser.m11888a(jsonParser);
                Object messageThreadsInbox2UnitFragmentModel = new MessageThreadsInbox2UnitFragmentModel();
                ((BaseModel) messageThreadsInbox2UnitFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (messageThreadsInbox2UnitFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) messageThreadsInbox2UnitFragmentModel).a();
                }
                return messageThreadsInbox2UnitFragmentModel;
            }
        }

        /* compiled from: mScreenData */
        public class Serializer extends JsonSerializer<MessageThreadsInbox2UnitFragmentModel> {
            public final void m11799a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                MessageThreadsInbox2UnitFragmentModel messageThreadsInbox2UnitFragmentModel = (MessageThreadsInbox2UnitFragmentModel) obj;
                if (messageThreadsInbox2UnitFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(messageThreadsInbox2UnitFragmentModel.m11815a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    messageThreadsInbox2UnitFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = messageThreadsInbox2UnitFragmentModel.w_();
                int u_ = messageThreadsInbox2UnitFragmentModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("reason");
                    jsonGenerator.b(mutableFlatBuffer.b(u_, 0));
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("thread");
                    ThreadParser.m11887a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(MessageThreadsInbox2UnitFragmentModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 834326509)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: mScreenData */
        public final class ThreadModel extends BaseModel implements GraphQLVisitableModel {
            private boolean f11288d;
            @Nullable
            private ThreadKeyModel f11289e;

            /* compiled from: mScreenData */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ThreadModel.class, new Deserializer());
                }

                public Object m11800a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ThreadParser.m11886a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object threadModel = new ThreadModel();
                    ((BaseModel) threadModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (threadModel instanceof Postprocessable) {
                        return ((Postprocessable) threadModel).a();
                    }
                    return threadModel;
                }
            }

            /* compiled from: mScreenData */
            public class Serializer extends JsonSerializer<ThreadModel> {
                public final void m11801a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ThreadModel threadModel = (ThreadModel) obj;
                    if (threadModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(threadModel.m11808a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        threadModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ThreadParser.m11887a(threadModel.w_(), threadModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ThreadModel.class, new Serializer());
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -955914545)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: mScreenData */
            public final class ThreadKeyModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f11286d;
                @Nullable
                private String f11287e;

                /* compiled from: mScreenData */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ThreadKeyModel.class, new Deserializer());
                    }

                    public Object m11802a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ThreadKeyParser.m11884a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object threadKeyModel = new ThreadKeyModel();
                        ((BaseModel) threadKeyModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (threadKeyModel instanceof Postprocessable) {
                            return ((Postprocessable) threadKeyModel).a();
                        }
                        return threadKeyModel;
                    }
                }

                /* compiled from: mScreenData */
                public class Serializer extends JsonSerializer<ThreadKeyModel> {
                    public final void m11803a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ThreadKeyModel threadKeyModel = (ThreadKeyModel) obj;
                        if (threadKeyModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(threadKeyModel.m11804a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            threadKeyModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ThreadKeyParser.m11885a(threadKeyModel.w_(), threadKeyModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(ThreadKeyModel.class, new Serializer());
                    }
                }

                public ThreadKeyModel() {
                    super(2);
                }

                @Nullable
                public final String m11806a() {
                    this.f11286d = super.a(this.f11286d, 0);
                    return this.f11286d;
                }

                @Nullable
                public final String m11807j() {
                    this.f11287e = super.a(this.f11287e, 1);
                    return this.f11287e;
                }

                public final int jK_() {
                    return 898588622;
                }

                public final GraphQLVisitableModel m11805a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m11804a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m11806a());
                    int b2 = flatBufferBuilder.b(m11807j());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, b2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            public ThreadModel() {
                super(2);
            }

            public final boolean m11811a() {
                a(0, 0);
                return this.f11288d;
            }

            @Nullable
            public final ThreadKeyModel m11812j() {
                this.f11289e = (ThreadKeyModel) super.a(this.f11289e, 1, ThreadKeyModel.class);
                return this.f11289e;
            }

            public final int jK_() {
                return -740570927;
            }

            public final GraphQLVisitableModel m11809a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m11812j() != null) {
                    ThreadKeyModel threadKeyModel = (ThreadKeyModel) graphQLModelMutatingVisitor.b(m11812j());
                    if (m11812j() != threadKeyModel) {
                        graphQLVisitableModel = (ThreadModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f11289e = threadKeyModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m11808a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m11812j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f11288d);
                flatBufferBuilder.b(1, a);
                i();
                return flatBufferBuilder.d();
            }

            public final void m11810a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f11288d = mutableFlatBuffer.a(i, 0);
            }
        }

        public MessageThreadsInbox2UnitFragmentModel() {
            super(2);
        }

        @Nullable
        private GraphQLMessengerInbox2MessageThreadReason m11813a() {
            this.f11290d = (GraphQLMessengerInbox2MessageThreadReason) super.b(this.f11290d, 0, GraphQLMessengerInbox2MessageThreadReason.class, GraphQLMessengerInbox2MessageThreadReason.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f11290d;
        }

        @Nullable
        private ThreadModel m11814j() {
            this.f11291e = (ThreadModel) super.a(this.f11291e, 1, ThreadModel.class);
            return this.f11291e;
        }

        public final int jK_() {
            return -1444572174;
        }

        public final GraphQLVisitableModel m11816a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m11814j() != null) {
                ThreadModel threadModel = (ThreadModel) graphQLModelMutatingVisitor.b(m11814j());
                if (m11814j() != threadModel) {
                    graphQLVisitableModel = (MessageThreadsInbox2UnitFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11291e = threadModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m11815a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = flatBufferBuilder.a(m11813a());
            int a2 = ModelHelper.a(flatBufferBuilder, m11814j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1969241426)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: mScreenData */
    public final class MessengerInbox2RecentUnitConfigModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GraphQLMessengerInbox2RecentUnitConfigType f11292d;
        private int f11293e;
        private int f11294f;
        private int f11295g;

        /* compiled from: mScreenData */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MessengerInbox2RecentUnitConfigModel.class, new Deserializer());
            }

            public Object m11817a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(MessengerInbox2RecentUnitConfigParser.m11889a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object messengerInbox2RecentUnitConfigModel = new MessengerInbox2RecentUnitConfigModel();
                ((BaseModel) messengerInbox2RecentUnitConfigModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (messengerInbox2RecentUnitConfigModel instanceof Postprocessable) {
                    return ((Postprocessable) messengerInbox2RecentUnitConfigModel).a();
                }
                return messengerInbox2RecentUnitConfigModel;
            }
        }

        /* compiled from: mScreenData */
        public class Serializer extends JsonSerializer<MessengerInbox2RecentUnitConfigModel> {
            public final void m11818a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MessengerInbox2RecentUnitConfigModel messengerInbox2RecentUnitConfigModel = (MessengerInbox2RecentUnitConfigModel) obj;
                if (messengerInbox2RecentUnitConfigModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(messengerInbox2RecentUnitConfigModel.m11819a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    messengerInbox2RecentUnitConfigModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                MessengerInbox2RecentUnitConfigParser.m11890a(messengerInbox2RecentUnitConfigModel.w_(), messengerInbox2RecentUnitConfigModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(MessengerInbox2RecentUnitConfigModel.class, new Serializer());
            }
        }

        public MessengerInbox2RecentUnitConfigModel() {
            super(4);
        }

        @Nullable
        public final GraphQLMessengerInbox2RecentUnitConfigType m11820a() {
            this.f11292d = (GraphQLMessengerInbox2RecentUnitConfigType) super.b(this.f11292d, 0, GraphQLMessengerInbox2RecentUnitConfigType.class, GraphQLMessengerInbox2RecentUnitConfigType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f11292d;
        }

        public final int m11823j() {
            a(0, 1);
            return this.f11293e;
        }

        public final int m11824k() {
            a(0, 2);
            return this.f11294f;
        }

        public final int m11825l() {
            a(0, 3);
            return this.f11295g;
        }

        public final int jK_() {
            return -1467950080;
        }

        public final GraphQLVisitableModel m11821a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m11819a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = flatBufferBuilder.a(m11820a());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.a(1, this.f11293e, 0);
            flatBufferBuilder.a(2, this.f11294f, 0);
            flatBufferBuilder.a(3, this.f11295g, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m11822a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f11293e = mutableFlatBuffer.a(i, 1, 0);
            this.f11294f = mutableFlatBuffer.a(i, 2, 0);
            this.f11295g = mutableFlatBuffer.a(i, 3, 0);
        }
    }
}

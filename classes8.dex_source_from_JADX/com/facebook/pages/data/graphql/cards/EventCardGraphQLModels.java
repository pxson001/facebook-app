package com.facebook.pages.data.graphql.cards;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.events.graphql.EventsGraphQLInterfaces.EventSocialContextFields;
import com.facebook.events.graphql.EventsGraphQLInterfaces.EventSocialContextFields.EventMembers;
import com.facebook.events.graphql.EventsGraphQLModels.EventPlaceModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventSocialContextFieldsModel.EventMembersModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventSocialContextFieldsModel.FriendEventMaybesFirst5Model;
import com.facebook.events.graphql.EventsGraphQLModels.EventSocialContextFieldsModel.FriendEventMembersFirst5Model;
import com.facebook.events.graphql.EventsGraphQLModels.EventSocialContextFieldsModel.FriendEventWatchersFirst5Model;
import com.facebook.events.graphql.EventsGraphQLModels.EventSocialContextFieldsModel.SuggestedEventContextSentenceModel;
import com.facebook.events.graphql.EventsGraphQLModels.UserInEventFragmentModel;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLConnectionStyle;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
import com.facebook.graphql.enums.GraphQLEventsCalendarSubscriptionStatus;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.pages.data.graphql.cards.EventCardGraphQLParsers.EventCardQueryParser;
import com.facebook.pages.data.graphql.cards.EventCardGraphQLParsers.PageEventsConnectionParser;
import com.facebook.pages.data.graphql.cards.EventCardGraphQLParsers.PageEventsConnectionParser.NodesParser;
import com.facebook.pages.data.graphql.cards.EventCardGraphQLParsers.PageEventsConnectionParser.NodesParser.CoverPhotoParser;
import com.facebook.pages.data.graphql.cards.EventCardGraphQLParsers.PageEventsConnectionParser.NodesParser.CoverPhotoParser.FocusParser;
import com.facebook.pages.data.graphql.cards.EventCardGraphQLParsers.PageEventsConnectionParser.NodesParser.CoverPhotoParser.PhotoParser;
import com.facebook.pages.data.graphql.cards.EventCardGraphQLParsers.PageEventsConnectionParser.NodesParser.CoverPhotoParser.PhotoParser.ImageParser;
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

/* compiled from: context_items_num */
public class EventCardGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -833292413)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: context_items_num */
    public final class EventCardQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        private boolean f16956d;
        @Nullable
        private GraphQLEventsCalendarSubscriptionStatus f16957e;
        @Nullable
        private PageEventsConnectionModel f16958f;

        /* compiled from: context_items_num */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(EventCardQueryModel.class, new Deserializer());
            }

            public Object m20361a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(EventCardQueryParser.m20443a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object eventCardQueryModel = new EventCardQueryModel();
                ((BaseModel) eventCardQueryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (eventCardQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) eventCardQueryModel).a();
                }
                return eventCardQueryModel;
            }
        }

        /* compiled from: context_items_num */
        public class Serializer extends JsonSerializer<EventCardQueryModel> {
            public final void m20362a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                EventCardQueryModel eventCardQueryModel = (EventCardQueryModel) obj;
                if (eventCardQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(eventCardQueryModel.m20364a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    eventCardQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = eventCardQueryModel.w_();
                int u_ = eventCardQueryModel.u_();
                jsonGenerator.f();
                boolean a = mutableFlatBuffer.a(u_, 0);
                if (a) {
                    jsonGenerator.a("events_calendar_can_viewer_subscribe");
                    jsonGenerator.a(a);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("events_calendar_subscription_status");
                    jsonGenerator.b(mutableFlatBuffer.b(u_, 1));
                }
                int g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("owned_events");
                    PageEventsConnectionParser.m20455a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(EventCardQueryModel.class, new Serializer());
            }
        }

        public EventCardQueryModel() {
            super(3);
        }

        public final void m20367a(String str, ConsistencyTuple consistencyTuple) {
            if ("events_calendar_subscription_status".equals(str)) {
                consistencyTuple.a = m20370j();
                consistencyTuple.b = u_();
                consistencyTuple.c = 1;
                return;
            }
            consistencyTuple.a();
        }

        public final void m20368a(String str, Object obj, boolean z) {
            if ("events_calendar_subscription_status".equals(str)) {
                m20363a((GraphQLEventsCalendarSubscriptionStatus) obj);
            }
        }

        public final boolean m20369a() {
            a(0, 0);
            return this.f16956d;
        }

        @Nullable
        public final GraphQLEventsCalendarSubscriptionStatus m20370j() {
            this.f16957e = (GraphQLEventsCalendarSubscriptionStatus) super.b(this.f16957e, 1, GraphQLEventsCalendarSubscriptionStatus.class, GraphQLEventsCalendarSubscriptionStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f16957e;
        }

        private void m20363a(GraphQLEventsCalendarSubscriptionStatus graphQLEventsCalendarSubscriptionStatus) {
            this.f16957e = graphQLEventsCalendarSubscriptionStatus;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 1, graphQLEventsCalendarSubscriptionStatus != null ? graphQLEventsCalendarSubscriptionStatus.name() : null);
            }
        }

        @Nullable
        public final PageEventsConnectionModel m20371k() {
            this.f16958f = (PageEventsConnectionModel) super.a(this.f16958f, 2, PageEventsConnectionModel.class);
            return this.f16958f;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m20365a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m20371k() != null) {
                PageEventsConnectionModel pageEventsConnectionModel = (PageEventsConnectionModel) graphQLModelMutatingVisitor.b(m20371k());
                if (m20371k() != pageEventsConnectionModel) {
                    graphQLVisitableModel = (EventCardQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f16958f = pageEventsConnectionModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m20364a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = flatBufferBuilder.a(m20370j());
            int a2 = ModelHelper.a(flatBufferBuilder, m20371k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.a(0, this.f16956d);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, a2);
            i();
            return flatBufferBuilder.d();
        }

        public final void m20366a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f16956d = mutableFlatBuffer.a(i, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 121058418)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: context_items_num */
    public final class PageEventsConnectionModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<NodesModel> f16988d;

        /* compiled from: context_items_num */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PageEventsConnectionModel.class, new Deserializer());
            }

            public Object m20372a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PageEventsConnectionParser.m20454a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object pageEventsConnectionModel = new PageEventsConnectionModel();
                ((BaseModel) pageEventsConnectionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (pageEventsConnectionModel instanceof Postprocessable) {
                    return ((Postprocessable) pageEventsConnectionModel).a();
                }
                return pageEventsConnectionModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 526490049)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: context_items_num */
        public final class NodesModel extends BaseModel implements EventSocialContextFields, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            private boolean f16969d;
            private boolean f16970e;
            @Nullable
            private GraphQLConnectionStyle f16971f;
            @Nullable
            private CoverPhotoModel f16972g;
            private long f16973h;
            @Nullable
            private EventMembersModel f16974i;
            @Nullable
            private EventPlaceModel f16975j;
            @Nullable
            private FriendEventMaybesFirst5Model f16976k;
            @Nullable
            private FriendEventMembersFirst5Model f16977l;
            @Nullable
            private FriendEventWatchersFirst5Model f16978m;
            @Nullable
            private String f16979n;
            private boolean f16980o;
            @Nullable
            private String f16981p;
            private long f16982q;
            @Nullable
            private SuggestedEventContextSentenceModel f16983r;
            @Nullable
            private String f16984s;
            @Nullable
            private GraphQLEventGuestStatus f16985t;
            @Nullable
            private List<UserInEventFragmentModel> f16986u;
            @Nullable
            private GraphQLEventWatchStatus f16987v;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1071617842)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: context_items_num */
            public final class CoverPhotoModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private FocusModel f16967d;
                @Nullable
                private PhotoModel f16968e;

                /* compiled from: context_items_num */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(CoverPhotoModel.class, new Deserializer());
                    }

                    public Object m20373a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(CoverPhotoParser.m20450a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object coverPhotoModel = new CoverPhotoModel();
                        ((BaseModel) coverPhotoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (coverPhotoModel instanceof Postprocessable) {
                            return ((Postprocessable) coverPhotoModel).a();
                        }
                        return coverPhotoModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -496435496)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: context_items_num */
                public final class FocusModel extends BaseModel implements GraphQLVisitableModel {
                    private double f16959d;
                    private double f16960e;

                    /* compiled from: context_items_num */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(FocusModel.class, new Deserializer());
                        }

                        public Object m20374a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(FocusParser.m20444a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object focusModel = new FocusModel();
                            ((BaseModel) focusModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (focusModel instanceof Postprocessable) {
                                return ((Postprocessable) focusModel).a();
                            }
                            return focusModel;
                        }
                    }

                    /* compiled from: context_items_num */
                    public class Serializer extends JsonSerializer<FocusModel> {
                        public final void m20375a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            FocusModel focusModel = (FocusModel) obj;
                            if (focusModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(focusModel.m20377a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                focusModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            FocusParser.m20445a(focusModel.w_(), focusModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(FocusModel.class, new Serializer());
                        }
                    }

                    public FocusModel() {
                        super(2);
                    }

                    public final double m20376a() {
                        a(0, 0);
                        return this.f16959d;
                    }

                    public final double m20380b() {
                        a(0, 1);
                        return this.f16960e;
                    }

                    public final int jK_() {
                        return 82530482;
                    }

                    public final GraphQLVisitableModel m20378a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m20377a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        flatBufferBuilder.c(2);
                        flatBufferBuilder.a(0, this.f16959d, 0.0d);
                        flatBufferBuilder.a(1, this.f16960e, 0.0d);
                        i();
                        return flatBufferBuilder.d();
                    }

                    public final void m20379a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                        super.a(mutableFlatBuffer, i, obj);
                        this.f16959d = mutableFlatBuffer.a(i, 0, 0.0d);
                        this.f16960e = mutableFlatBuffer.a(i, 1, 0.0d);
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1619703681)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: context_items_num */
                public final class PhotoModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                    @Nullable
                    private String f16964d;
                    @Nullable
                    private ImageModel f16965e;
                    @Nullable
                    private String f16966f;

                    /* compiled from: context_items_num */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(PhotoModel.class, new Deserializer());
                        }

                        public Object m20381a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(PhotoParser.m20448a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object photoModel = new PhotoModel();
                            ((BaseModel) photoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (photoModel instanceof Postprocessable) {
                                return ((Postprocessable) photoModel).a();
                            }
                            return photoModel;
                        }
                    }

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = 729935302)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: context_items_num */
                    public final class ImageModel extends BaseModel implements GraphQLVisitableModel {
                        private int f16961d;
                        @Nullable
                        private String f16962e;
                        private int f16963f;

                        /* compiled from: context_items_num */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(ImageModel.class, new Deserializer());
                            }

                            public Object m20382a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(ImageParser.m20446a(jsonParser, flatBufferBuilder));
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

                        /* compiled from: context_items_num */
                        public class Serializer extends JsonSerializer<ImageModel> {
                            public final void m20383a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                ImageModel imageModel = (ImageModel) obj;
                                if (imageModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(imageModel.m20385a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    imageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                ImageParser.m20447a(imageModel.w_(), imageModel.u_(), jsonGenerator);
                            }

                            static {
                                FbSerializerProvider.a(ImageModel.class, new Serializer());
                            }
                        }

                        public ImageModel() {
                            super(3);
                        }

                        public final int m20384a() {
                            a(0, 0);
                            return this.f16961d;
                        }

                        @Nullable
                        public final String m20388b() {
                            this.f16962e = super.a(this.f16962e, 1);
                            return this.f16962e;
                        }

                        public final int m20389c() {
                            a(0, 2);
                            return this.f16963f;
                        }

                        public final int jK_() {
                            return 70760763;
                        }

                        public final GraphQLVisitableModel m20386a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            h();
                            i();
                            return this;
                        }

                        public final int m20385a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int b = flatBufferBuilder.b(m20388b());
                            flatBufferBuilder.c(3);
                            flatBufferBuilder.a(0, this.f16961d, 0);
                            flatBufferBuilder.b(1, b);
                            flatBufferBuilder.a(2, this.f16963f, 0);
                            i();
                            return flatBufferBuilder.d();
                        }

                        public final void m20387a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                            super.a(mutableFlatBuffer, i, obj);
                            this.f16961d = mutableFlatBuffer.a(i, 0, 0);
                            this.f16963f = mutableFlatBuffer.a(i, 2, 0);
                        }
                    }

                    /* compiled from: context_items_num */
                    public class Serializer extends JsonSerializer<PhotoModel> {
                        public final void m20390a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            PhotoModel photoModel = (PhotoModel) obj;
                            if (photoModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(photoModel.m20392a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                photoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            PhotoParser.m20449a(photoModel.w_(), photoModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(PhotoModel.class, new Serializer());
                        }
                    }

                    @Nullable
                    public final /* synthetic */ ImageModel m20396c() {
                        return m20391j();
                    }

                    public PhotoModel() {
                        super(3);
                    }

                    @Nullable
                    public final String m20395b() {
                        this.f16964d = super.a(this.f16964d, 0);
                        return this.f16964d;
                    }

                    @Nullable
                    private ImageModel m20391j() {
                        this.f16965e = (ImageModel) super.a(this.f16965e, 1, ImageModel.class);
                        return this.f16965e;
                    }

                    @Nullable
                    public final String m20397d() {
                        this.f16966f = super.a(this.f16966f, 2);
                        return this.f16966f;
                    }

                    @Nullable
                    public final String m20394a() {
                        return m20395b();
                    }

                    public final int jK_() {
                        return 77090322;
                    }

                    public final GraphQLVisitableModel m20393a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m20391j() != null) {
                            ImageModel imageModel = (ImageModel) graphQLModelMutatingVisitor.b(m20391j());
                            if (m20391j() != imageModel) {
                                graphQLVisitableModel = (PhotoModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f16965e = imageModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m20392a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m20395b());
                        int a = ModelHelper.a(flatBufferBuilder, m20391j());
                        int b2 = flatBufferBuilder.b(m20397d());
                        flatBufferBuilder.c(3);
                        flatBufferBuilder.b(0, b);
                        flatBufferBuilder.b(1, a);
                        flatBufferBuilder.b(2, b2);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: context_items_num */
                public class Serializer extends JsonSerializer<CoverPhotoModel> {
                    public final void m20398a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        CoverPhotoModel coverPhotoModel = (CoverPhotoModel) obj;
                        if (coverPhotoModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(coverPhotoModel.m20401a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            coverPhotoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        CoverPhotoParser.m20451a(coverPhotoModel.w_(), coverPhotoModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(CoverPhotoModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ FocusModel m20403a() {
                    return m20399j();
                }

                @Nullable
                public final /* synthetic */ PhotoModel m20404b() {
                    return m20400k();
                }

                public CoverPhotoModel() {
                    super(2);
                }

                @Nullable
                private FocusModel m20399j() {
                    this.f16967d = (FocusModel) super.a(this.f16967d, 0, FocusModel.class);
                    return this.f16967d;
                }

                @Nullable
                private PhotoModel m20400k() {
                    this.f16968e = (PhotoModel) super.a(this.f16968e, 1, PhotoModel.class);
                    return this.f16968e;
                }

                public final int jK_() {
                    return 497264923;
                }

                public final GraphQLVisitableModel m20402a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m20399j() != null) {
                        FocusModel focusModel = (FocusModel) graphQLModelMutatingVisitor.b(m20399j());
                        if (m20399j() != focusModel) {
                            graphQLVisitableModel = (CoverPhotoModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f16967d = focusModel;
                        }
                    }
                    if (m20400k() != null) {
                        PhotoModel photoModel = (PhotoModel) graphQLModelMutatingVisitor.b(m20400k());
                        if (m20400k() != photoModel) {
                            graphQLVisitableModel = (CoverPhotoModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f16968e = photoModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m20401a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m20399j());
                    int a2 = ModelHelper.a(flatBufferBuilder, m20400k());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: context_items_num */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                }

                public Object m20405a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(NodesParser.m20452b(jsonParser, flatBufferBuilder));
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

            /* compiled from: context_items_num */
            public class Serializer extends JsonSerializer<NodesModel> {
                public final void m20406a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    NodesModel nodesModel = (NodesModel) obj;
                    if (nodesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(nodesModel.m20417a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    NodesParser.m20453b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(NodesModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ FriendEventMaybesFirst5Model m20427j() {
                return m20415y();
            }

            @Nullable
            public final /* synthetic */ FriendEventMembersFirst5Model m20428k() {
                return m20416z();
            }

            @Nullable
            public final /* synthetic */ EventPlaceModel ku_() {
                return m20414x();
            }

            @Nullable
            public final /* synthetic */ EventMembers kv_() {
                return m20413w();
            }

            @Nullable
            public final /* synthetic */ CoverPhotoModel kw_() {
                return m20412v();
            }

            @Nullable
            public final /* synthetic */ FriendEventWatchersFirst5Model m20429l() {
                return m20407A();
            }

            @Nullable
            public final /* synthetic */ SuggestedEventContextSentenceModel m20434q() {
                return m20408B();
            }

            public NodesModel() {
                super(19);
            }

            public final void m20421a(String str, ConsistencyTuple consistencyTuple) {
                if ("event_members.count".equals(str)) {
                    EventMembersModel w = m20413w();
                    if (w != null) {
                        consistencyTuple.a = Integer.valueOf(w.a());
                        consistencyTuple.b = w.u_();
                        consistencyTuple.c = 0;
                        return;
                    }
                } else if ("name".equals(str)) {
                    consistencyTuple.a = m20432o();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 12;
                    return;
                } else if ("viewer_guest_status".equals(str)) {
                    consistencyTuple.a = m20436s();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 16;
                    return;
                } else if ("viewer_watch_status".equals(str)) {
                    consistencyTuple.a = m20438u();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 18;
                    return;
                }
                consistencyTuple.a();
            }

            public final void m20422a(String str, Object obj, boolean z) {
                if ("event_members.count".equals(str)) {
                    EventMembersModel w = m20413w();
                    if (w == null) {
                        return;
                    }
                    if (z) {
                        w = (EventMembersModel) w.clone();
                        w.a(((Integer) obj).intValue());
                        this.f16974i = w;
                        return;
                    }
                    w.a(((Integer) obj).intValue());
                } else if ("name".equals(str)) {
                    m20411a((String) obj);
                } else if ("viewer_guest_status".equals(str)) {
                    m20409a((GraphQLEventGuestStatus) obj);
                } else if ("viewer_watch_status".equals(str)) {
                    m20410a((GraphQLEventWatchStatus) obj);
                }
            }

            public final boolean m20423b() {
                a(0, 0);
                return this.f16969d;
            }

            public final boolean m20424c() {
                a(0, 1);
                return this.f16970e;
            }

            @Nullable
            public final GraphQLConnectionStyle m20425d() {
                this.f16971f = (GraphQLConnectionStyle) super.b(this.f16971f, 2, GraphQLConnectionStyle.class, GraphQLConnectionStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f16971f;
            }

            @Nullable
            private CoverPhotoModel m20412v() {
                this.f16972g = (CoverPhotoModel) super.a(this.f16972g, 3, CoverPhotoModel.class);
                return this.f16972g;
            }

            public final long m20426g() {
                a(0, 4);
                return this.f16973h;
            }

            @Nullable
            private EventMembersModel m20413w() {
                this.f16974i = (EventMembersModel) super.a(this.f16974i, 5, EventMembersModel.class);
                return this.f16974i;
            }

            @Nullable
            private EventPlaceModel m20414x() {
                this.f16975j = (EventPlaceModel) super.a(this.f16975j, 6, EventPlaceModel.class);
                return this.f16975j;
            }

            @Nullable
            private FriendEventMaybesFirst5Model m20415y() {
                this.f16976k = (FriendEventMaybesFirst5Model) super.a(this.f16976k, 7, FriendEventMaybesFirst5Model.class);
                return this.f16976k;
            }

            @Nullable
            private FriendEventMembersFirst5Model m20416z() {
                this.f16977l = (FriendEventMembersFirst5Model) super.a(this.f16977l, 8, FriendEventMembersFirst5Model.class);
                return this.f16977l;
            }

            @Nullable
            private FriendEventWatchersFirst5Model m20407A() {
                this.f16978m = (FriendEventWatchersFirst5Model) super.a(this.f16978m, 9, FriendEventWatchersFirst5Model.class);
                return this.f16978m;
            }

            @Nullable
            public final String m20430m() {
                this.f16979n = super.a(this.f16979n, 10);
                return this.f16979n;
            }

            public final boolean m20431n() {
                a(1, 3);
                return this.f16980o;
            }

            @Nullable
            public final String m20432o() {
                this.f16981p = super.a(this.f16981p, 12);
                return this.f16981p;
            }

            private void m20411a(@Nullable String str) {
                this.f16981p = str;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 12, str);
                }
            }

            public final long m20433p() {
                a(1, 5);
                return this.f16982q;
            }

            @Nullable
            private SuggestedEventContextSentenceModel m20408B() {
                this.f16983r = (SuggestedEventContextSentenceModel) super.a(this.f16983r, 14, SuggestedEventContextSentenceModel.class);
                return this.f16983r;
            }

            @Nullable
            public final String m20435r() {
                this.f16984s = super.a(this.f16984s, 15);
                return this.f16984s;
            }

            @Nullable
            public final GraphQLEventGuestStatus m20436s() {
                this.f16985t = (GraphQLEventGuestStatus) super.b(this.f16985t, 16, GraphQLEventGuestStatus.class, GraphQLEventGuestStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f16985t;
            }

            private void m20409a(GraphQLEventGuestStatus graphQLEventGuestStatus) {
                this.f16985t = graphQLEventGuestStatus;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 16, graphQLEventGuestStatus != null ? graphQLEventGuestStatus.name() : null);
                }
            }

            @Nonnull
            public final ImmutableList<UserInEventFragmentModel> m20437t() {
                this.f16986u = super.a(this.f16986u, 17, UserInEventFragmentModel.class);
                return (ImmutableList) this.f16986u;
            }

            @Nullable
            public final GraphQLEventWatchStatus m20438u() {
                this.f16987v = (GraphQLEventWatchStatus) super.b(this.f16987v, 18, GraphQLEventWatchStatus.class, GraphQLEventWatchStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f16987v;
            }

            private void m20410a(GraphQLEventWatchStatus graphQLEventWatchStatus) {
                this.f16987v = graphQLEventWatchStatus;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 18, graphQLEventWatchStatus != null ? graphQLEventWatchStatus.name() : null);
                }
            }

            @Nullable
            public final String m20419a() {
                return m20430m();
            }

            public final int jK_() {
                return 67338874;
            }

            public final GraphQLVisitableModel m20418a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m20412v() != null) {
                    CoverPhotoModel coverPhotoModel = (CoverPhotoModel) graphQLModelMutatingVisitor.b(m20412v());
                    if (m20412v() != coverPhotoModel) {
                        graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f16972g = coverPhotoModel;
                    }
                }
                if (m20413w() != null) {
                    EventMembersModel eventMembersModel = (EventMembersModel) graphQLModelMutatingVisitor.b(m20413w());
                    if (m20413w() != eventMembersModel) {
                        graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f16974i = eventMembersModel;
                    }
                }
                if (m20414x() != null) {
                    EventPlaceModel eventPlaceModel = (EventPlaceModel) graphQLModelMutatingVisitor.b(m20414x());
                    if (m20414x() != eventPlaceModel) {
                        graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f16975j = eventPlaceModel;
                    }
                }
                if (m20415y() != null) {
                    FriendEventMaybesFirst5Model friendEventMaybesFirst5Model = (FriendEventMaybesFirst5Model) graphQLModelMutatingVisitor.b(m20415y());
                    if (m20415y() != friendEventMaybesFirst5Model) {
                        graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f16976k = friendEventMaybesFirst5Model;
                    }
                }
                if (m20416z() != null) {
                    FriendEventMembersFirst5Model friendEventMembersFirst5Model = (FriendEventMembersFirst5Model) graphQLModelMutatingVisitor.b(m20416z());
                    if (m20416z() != friendEventMembersFirst5Model) {
                        graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f16977l = friendEventMembersFirst5Model;
                    }
                }
                if (m20407A() != null) {
                    FriendEventWatchersFirst5Model friendEventWatchersFirst5Model = (FriendEventWatchersFirst5Model) graphQLModelMutatingVisitor.b(m20407A());
                    if (m20407A() != friendEventWatchersFirst5Model) {
                        graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f16978m = friendEventWatchersFirst5Model;
                    }
                }
                if (m20408B() != null) {
                    SuggestedEventContextSentenceModel suggestedEventContextSentenceModel = (SuggestedEventContextSentenceModel) graphQLModelMutatingVisitor.b(m20408B());
                    if (m20408B() != suggestedEventContextSentenceModel) {
                        graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f16983r = suggestedEventContextSentenceModel;
                    }
                }
                if (m20437t() != null) {
                    Builder a = ModelHelper.a(m20437t(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        NodesModel nodesModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                        nodesModel.f16986u = a.b();
                        graphQLVisitableModel = nodesModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m20417a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = flatBufferBuilder.a(m20425d());
                int a2 = ModelHelper.a(flatBufferBuilder, m20412v());
                int a3 = ModelHelper.a(flatBufferBuilder, m20413w());
                int a4 = ModelHelper.a(flatBufferBuilder, m20414x());
                int a5 = ModelHelper.a(flatBufferBuilder, m20415y());
                int a6 = ModelHelper.a(flatBufferBuilder, m20416z());
                int a7 = ModelHelper.a(flatBufferBuilder, m20407A());
                int b = flatBufferBuilder.b(m20430m());
                int b2 = flatBufferBuilder.b(m20432o());
                int a8 = ModelHelper.a(flatBufferBuilder, m20408B());
                int b3 = flatBufferBuilder.b(m20435r());
                int a9 = flatBufferBuilder.a(m20436s());
                int a10 = ModelHelper.a(flatBufferBuilder, m20437t());
                int a11 = flatBufferBuilder.a(m20438u());
                flatBufferBuilder.c(19);
                flatBufferBuilder.a(0, this.f16969d);
                flatBufferBuilder.a(1, this.f16970e);
                flatBufferBuilder.b(2, a);
                flatBufferBuilder.b(3, a2);
                flatBufferBuilder.a(4, this.f16973h, 0);
                flatBufferBuilder.b(5, a3);
                flatBufferBuilder.b(6, a4);
                flatBufferBuilder.b(7, a5);
                flatBufferBuilder.b(8, a6);
                flatBufferBuilder.b(9, a7);
                flatBufferBuilder.b(10, b);
                flatBufferBuilder.a(11, this.f16980o);
                flatBufferBuilder.b(12, b2);
                flatBufferBuilder.a(13, this.f16982q, 0);
                flatBufferBuilder.b(14, a8);
                flatBufferBuilder.b(15, b3);
                flatBufferBuilder.b(16, a9);
                flatBufferBuilder.b(17, a10);
                flatBufferBuilder.b(18, a11);
                i();
                return flatBufferBuilder.d();
            }

            public final void m20420a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f16969d = mutableFlatBuffer.a(i, 0);
                this.f16970e = mutableFlatBuffer.a(i, 1);
                this.f16973h = mutableFlatBuffer.a(i, 4, 0);
                this.f16980o = mutableFlatBuffer.a(i, 11);
                this.f16982q = mutableFlatBuffer.a(i, 13, 0);
            }
        }

        /* compiled from: context_items_num */
        public class Serializer extends JsonSerializer<PageEventsConnectionModel> {
            public final void m20439a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PageEventsConnectionModel pageEventsConnectionModel = (PageEventsConnectionModel) obj;
                if (pageEventsConnectionModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pageEventsConnectionModel.m20440a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pageEventsConnectionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PageEventsConnectionParser.m20455a(pageEventsConnectionModel.w_(), pageEventsConnectionModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PageEventsConnectionModel.class, new Serializer());
            }
        }

        public PageEventsConnectionModel() {
            super(1);
        }

        @Nonnull
        public final ImmutableList<NodesModel> m20442a() {
            this.f16988d = super.a(this.f16988d, 0, NodesModel.class);
            return (ImmutableList) this.f16988d;
        }

        public final int jK_() {
            return 1990200700;
        }

        public final GraphQLVisitableModel m20441a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m20442a() != null) {
                Builder a = ModelHelper.a(m20442a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (PageEventsConnectionModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f16988d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m20440a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m20442a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}

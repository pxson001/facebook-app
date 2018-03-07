package com.facebook.pages.common.surface.calltoaction.graphql;

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
import com.facebook.graphql.enums.GraphQLPageCallToActionType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.pages.common.surface.calltoaction.graphql.PageCallToActionMutationsParsers.PageCallToActionContactUsFormSubmitMutationParser;
import com.facebook.pages.common.surface.calltoaction.graphql.PageCallToActionMutationsParsers.PageCallToActionContactUsFormSubmitMutationParser.ViewerParser;
import com.facebook.pages.common.surface.calltoaction.graphql.PageCallToActionMutationsParsers.PageCallToActionContactUsFormSubmitMutationParser.ViewerParser.ActorParser;
import com.facebook.pages.common.surface.calltoaction.graphql.PageCallToActionMutationsParsers.PageCallToActionCoreCreateMutationFieldsParser;
import com.facebook.pages.common.surface.calltoaction.graphql.PageCallToActionMutationsParsers.PageCallToActionCoreCreateMutationFieldsParser.PageCallToActionParser;
import com.facebook.pages.common.surface.calltoaction.graphql.PageCallToActionMutationsParsers.PageCallToActionCoreDeleteMutationParser;
import com.facebook.pages.common.surface.calltoaction.graphql.PageCallToActionMutationsParsers.PageCallToActionCoreUpdateMutationFieldsParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: cover_photo_fullscreen_short_dimen */
public class PageCallToActionMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 161557446)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: cover_photo_fullscreen_short_dimen */
    public final class PageCallToActionContactUsFormSubmitMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ViewerModel f16788d;

        /* compiled from: cover_photo_fullscreen_short_dimen */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PageCallToActionContactUsFormSubmitMutationModel.class, new Deserializer());
            }

            public Object m19976a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PageCallToActionContactUsFormSubmitMutationParser.m20028a(jsonParser);
                Object pageCallToActionContactUsFormSubmitMutationModel = new PageCallToActionContactUsFormSubmitMutationModel();
                ((BaseModel) pageCallToActionContactUsFormSubmitMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (pageCallToActionContactUsFormSubmitMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) pageCallToActionContactUsFormSubmitMutationModel).a();
                }
                return pageCallToActionContactUsFormSubmitMutationModel;
            }
        }

        /* compiled from: cover_photo_fullscreen_short_dimen */
        public class Serializer extends JsonSerializer<PageCallToActionContactUsFormSubmitMutationModel> {
            public final void m19977a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PageCallToActionContactUsFormSubmitMutationModel pageCallToActionContactUsFormSubmitMutationModel = (PageCallToActionContactUsFormSubmitMutationModel) obj;
                if (pageCallToActionContactUsFormSubmitMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pageCallToActionContactUsFormSubmitMutationModel.m19993a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pageCallToActionContactUsFormSubmitMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = pageCallToActionContactUsFormSubmitMutationModel.w_();
                int u_ = pageCallToActionContactUsFormSubmitMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("viewer");
                    ViewerParser.m20027a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PageCallToActionContactUsFormSubmitMutationModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1279972757)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: cover_photo_fullscreen_short_dimen */
        public final class ViewerModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private ActorModel f16787d;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1787905591)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: cover_photo_fullscreen_short_dimen */
            public final class ActorModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private GraphQLObjectType f16785d;
                @Nullable
                private String f16786e;

                /* compiled from: cover_photo_fullscreen_short_dimen */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ActorModel.class, new Deserializer());
                    }

                    public Object m19978a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ActorParser.m20024a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object actorModel = new ActorModel();
                        ((BaseModel) actorModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (actorModel instanceof Postprocessable) {
                            return ((Postprocessable) actorModel).a();
                        }
                        return actorModel;
                    }
                }

                /* compiled from: cover_photo_fullscreen_short_dimen */
                public class Serializer extends JsonSerializer<ActorModel> {
                    public final void m19979a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ActorModel actorModel = (ActorModel) obj;
                        if (actorModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(actorModel.m19982a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            actorModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ActorParser.m20025a(actorModel.w_(), actorModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(ActorModel.class, new Serializer());
                    }
                }

                public ActorModel() {
                    super(2);
                }

                public final void m19985a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m19986a(String str, Object obj, boolean z) {
                }

                @Nullable
                private GraphQLObjectType m19980j() {
                    if (this.b != null && this.f16785d == null) {
                        this.f16785d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f16785d;
                }

                @Nullable
                private String m19981k() {
                    this.f16786e = super.a(this.f16786e, 1);
                    return this.f16786e;
                }

                @Nullable
                public final String m19984a() {
                    return m19981k();
                }

                public final int jK_() {
                    return 63093205;
                }

                public final GraphQLVisitableModel m19983a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m19982a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m19980j());
                    int b = flatBufferBuilder.b(m19981k());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: cover_photo_fullscreen_short_dimen */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ViewerModel.class, new Deserializer());
                }

                public Object m19987a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ViewerParser.m20026a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object viewerModel = new ViewerModel();
                    ((BaseModel) viewerModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (viewerModel instanceof Postprocessable) {
                        return ((Postprocessable) viewerModel).a();
                    }
                    return viewerModel;
                }
            }

            /* compiled from: cover_photo_fullscreen_short_dimen */
            public class Serializer extends JsonSerializer<ViewerModel> {
                public final void m19988a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ViewerModel viewerModel = (ViewerModel) obj;
                    if (viewerModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(viewerModel.m19990a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        viewerModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ViewerParser.m20027a(viewerModel.w_(), viewerModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ViewerModel.class, new Serializer());
                }
            }

            public ViewerModel() {
                super(1);
            }

            @Nullable
            private ActorModel m19989a() {
                this.f16787d = (ActorModel) super.a(this.f16787d, 0, ActorModel.class);
                return this.f16787d;
            }

            public final int jK_() {
                return -1732764110;
            }

            public final GraphQLVisitableModel m19991a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m19989a() != null) {
                    ActorModel actorModel = (ActorModel) graphQLModelMutatingVisitor.b(m19989a());
                    if (m19989a() != actorModel) {
                        graphQLVisitableModel = (ViewerModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f16787d = actorModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m19990a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m19989a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public PageCallToActionContactUsFormSubmitMutationModel() {
            super(1);
        }

        @Nullable
        private ViewerModel m19992a() {
            this.f16788d = (ViewerModel) super.a(this.f16788d, 0, ViewerModel.class);
            return this.f16788d;
        }

        public final int jK_() {
            return 1656138225;
        }

        public final GraphQLVisitableModel m19994a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m19992a() != null) {
                ViewerModel viewerModel = (ViewerModel) graphQLModelMutatingVisitor.b(m19992a());
                if (m19992a() != viewerModel) {
                    graphQLVisitableModel = (PageCallToActionContactUsFormSubmitMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f16788d = viewerModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m19993a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m19992a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1445710338)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: cover_photo_fullscreen_short_dimen */
    public final class PageCallToActionCoreCreateMutationFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private PageCallToActionModel f16791d;

        /* compiled from: cover_photo_fullscreen_short_dimen */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PageCallToActionCoreCreateMutationFieldsModel.class, new Deserializer());
            }

            public Object m19995a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PageCallToActionCoreCreateMutationFieldsParser.m20031a(jsonParser);
                Object pageCallToActionCoreCreateMutationFieldsModel = new PageCallToActionCoreCreateMutationFieldsModel();
                ((BaseModel) pageCallToActionCoreCreateMutationFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (pageCallToActionCoreCreateMutationFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) pageCallToActionCoreCreateMutationFieldsModel).a();
                }
                return pageCallToActionCoreCreateMutationFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1983637982)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: cover_photo_fullscreen_short_dimen */
        public final class PageCallToActionModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private GraphQLPageCallToActionType f16789d;
            @Nullable
            private String f16790e;

            /* compiled from: cover_photo_fullscreen_short_dimen */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PageCallToActionModel.class, new Deserializer());
                }

                public Object m19996a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PageCallToActionParser.m20029a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object pageCallToActionModel = new PageCallToActionModel();
                    ((BaseModel) pageCallToActionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (pageCallToActionModel instanceof Postprocessable) {
                        return ((Postprocessable) pageCallToActionModel).a();
                    }
                    return pageCallToActionModel;
                }
            }

            /* compiled from: cover_photo_fullscreen_short_dimen */
            public class Serializer extends JsonSerializer<PageCallToActionModel> {
                public final void m19997a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PageCallToActionModel pageCallToActionModel = (PageCallToActionModel) obj;
                    if (pageCallToActionModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pageCallToActionModel.m20000a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pageCallToActionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PageCallToActionParser.m20030a(pageCallToActionModel.w_(), pageCallToActionModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PageCallToActionModel.class, new Serializer());
                }
            }

            public PageCallToActionModel() {
                super(2);
            }

            @Nullable
            private GraphQLPageCallToActionType m19998j() {
                this.f16789d = (GraphQLPageCallToActionType) super.b(this.f16789d, 0, GraphQLPageCallToActionType.class, GraphQLPageCallToActionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f16789d;
            }

            @Nullable
            private String m19999k() {
                this.f16790e = super.a(this.f16790e, 1);
                return this.f16790e;
            }

            @Nullable
            public final String m20002a() {
                return m19999k();
            }

            public final int jK_() {
                return 133279070;
            }

            public final GraphQLVisitableModel m20001a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m20000a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = flatBufferBuilder.a(m19998j());
                int b = flatBufferBuilder.b(m19999k());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: cover_photo_fullscreen_short_dimen */
        public class Serializer extends JsonSerializer<PageCallToActionCoreCreateMutationFieldsModel> {
            public final void m20003a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PageCallToActionCoreCreateMutationFieldsModel pageCallToActionCoreCreateMutationFieldsModel = (PageCallToActionCoreCreateMutationFieldsModel) obj;
                if (pageCallToActionCoreCreateMutationFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pageCallToActionCoreCreateMutationFieldsModel.m20005a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pageCallToActionCoreCreateMutationFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = pageCallToActionCoreCreateMutationFieldsModel.w_();
                int u_ = pageCallToActionCoreCreateMutationFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("page_call_to_action");
                    PageCallToActionParser.m20030a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PageCallToActionCoreCreateMutationFieldsModel.class, new Serializer());
            }
        }

        public PageCallToActionCoreCreateMutationFieldsModel() {
            super(1);
        }

        @Nullable
        private PageCallToActionModel m20004a() {
            this.f16791d = (PageCallToActionModel) super.a(this.f16791d, 0, PageCallToActionModel.class);
            return this.f16791d;
        }

        public final int jK_() {
            return 587403955;
        }

        public final GraphQLVisitableModel m20006a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m20004a() != null) {
                PageCallToActionModel pageCallToActionModel = (PageCallToActionModel) graphQLModelMutatingVisitor.b(m20004a());
                if (m20004a() != pageCallToActionModel) {
                    graphQLVisitableModel = (PageCallToActionCoreCreateMutationFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f16791d = pageCallToActionModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m20005a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m20004a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 751659232)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: cover_photo_fullscreen_short_dimen */
    public final class PageCallToActionCoreDeleteMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f16792d;

        /* compiled from: cover_photo_fullscreen_short_dimen */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PageCallToActionCoreDeleteMutationModel.class, new Deserializer());
            }

            public Object m20007a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PageCallToActionCoreDeleteMutationParser.m20032a(jsonParser);
                Object pageCallToActionCoreDeleteMutationModel = new PageCallToActionCoreDeleteMutationModel();
                ((BaseModel) pageCallToActionCoreDeleteMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (pageCallToActionCoreDeleteMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) pageCallToActionCoreDeleteMutationModel).a();
                }
                return pageCallToActionCoreDeleteMutationModel;
            }
        }

        /* compiled from: cover_photo_fullscreen_short_dimen */
        public class Serializer extends JsonSerializer<PageCallToActionCoreDeleteMutationModel> {
            public final void m20008a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PageCallToActionCoreDeleteMutationModel pageCallToActionCoreDeleteMutationModel = (PageCallToActionCoreDeleteMutationModel) obj;
                if (pageCallToActionCoreDeleteMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pageCallToActionCoreDeleteMutationModel.m20010a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pageCallToActionCoreDeleteMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = pageCallToActionCoreDeleteMutationModel.w_();
                int u_ = pageCallToActionCoreDeleteMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("deleted_page_call_to_action_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PageCallToActionCoreDeleteMutationModel.class, new Serializer());
            }
        }

        public PageCallToActionCoreDeleteMutationModel() {
            super(1);
        }

        @Nullable
        private String m20009a() {
            this.f16792d = super.a(this.f16792d, 0);
            return this.f16792d;
        }

        public final int jK_() {
            return 508844580;
        }

        public final GraphQLVisitableModel m20011a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m20010a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m20009a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1593415936)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: cover_photo_fullscreen_short_dimen */
    public final class PageCallToActionCoreUpdateMutationFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private PageCallToActionModel f16795d;

        /* compiled from: cover_photo_fullscreen_short_dimen */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PageCallToActionCoreUpdateMutationFieldsModel.class, new Deserializer());
            }

            public Object m20012a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PageCallToActionCoreUpdateMutationFieldsParser.m20035a(jsonParser);
                Object pageCallToActionCoreUpdateMutationFieldsModel = new PageCallToActionCoreUpdateMutationFieldsModel();
                ((BaseModel) pageCallToActionCoreUpdateMutationFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (pageCallToActionCoreUpdateMutationFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) pageCallToActionCoreUpdateMutationFieldsModel).a();
                }
                return pageCallToActionCoreUpdateMutationFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1983637982)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: cover_photo_fullscreen_short_dimen */
        public final class PageCallToActionModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private GraphQLPageCallToActionType f16793d;
            @Nullable
            private String f16794e;

            /* compiled from: cover_photo_fullscreen_short_dimen */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PageCallToActionModel.class, new Deserializer());
                }

                public Object m20013a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PageCallToActionCoreUpdateMutationFieldsParser.PageCallToActionParser.m20033a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object pageCallToActionModel = new PageCallToActionModel();
                    ((BaseModel) pageCallToActionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (pageCallToActionModel instanceof Postprocessable) {
                        return ((Postprocessable) pageCallToActionModel).a();
                    }
                    return pageCallToActionModel;
                }
            }

            /* compiled from: cover_photo_fullscreen_short_dimen */
            public class Serializer extends JsonSerializer<PageCallToActionModel> {
                public final void m20014a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PageCallToActionModel pageCallToActionModel = (PageCallToActionModel) obj;
                    if (pageCallToActionModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pageCallToActionModel.m20017a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pageCallToActionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PageCallToActionCoreUpdateMutationFieldsParser.PageCallToActionParser.m20034a(pageCallToActionModel.w_(), pageCallToActionModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PageCallToActionModel.class, new Serializer());
                }
            }

            public PageCallToActionModel() {
                super(2);
            }

            @Nullable
            private GraphQLPageCallToActionType m20015j() {
                this.f16793d = (GraphQLPageCallToActionType) super.b(this.f16793d, 0, GraphQLPageCallToActionType.class, GraphQLPageCallToActionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f16793d;
            }

            @Nullable
            private String m20016k() {
                this.f16794e = super.a(this.f16794e, 1);
                return this.f16794e;
            }

            @Nullable
            public final String m20019a() {
                return m20016k();
            }

            public final int jK_() {
                return 133279070;
            }

            public final GraphQLVisitableModel m20018a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m20017a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = flatBufferBuilder.a(m20015j());
                int b = flatBufferBuilder.b(m20016k());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: cover_photo_fullscreen_short_dimen */
        public class Serializer extends JsonSerializer<PageCallToActionCoreUpdateMutationFieldsModel> {
            public final void m20020a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PageCallToActionCoreUpdateMutationFieldsModel pageCallToActionCoreUpdateMutationFieldsModel = (PageCallToActionCoreUpdateMutationFieldsModel) obj;
                if (pageCallToActionCoreUpdateMutationFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pageCallToActionCoreUpdateMutationFieldsModel.m20022a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pageCallToActionCoreUpdateMutationFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = pageCallToActionCoreUpdateMutationFieldsModel.w_();
                int u_ = pageCallToActionCoreUpdateMutationFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("page_call_to_action");
                    PageCallToActionCoreUpdateMutationFieldsParser.PageCallToActionParser.m20034a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PageCallToActionCoreUpdateMutationFieldsModel.class, new Serializer());
            }
        }

        public PageCallToActionCoreUpdateMutationFieldsModel() {
            super(1);
        }

        @Nullable
        private PageCallToActionModel m20021a() {
            this.f16795d = (PageCallToActionModel) super.a(this.f16795d, 0, PageCallToActionModel.class);
            return this.f16795d;
        }

        public final int jK_() {
            return 1758873414;
        }

        public final GraphQLVisitableModel m20023a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m20021a() != null) {
                PageCallToActionModel pageCallToActionModel = (PageCallToActionModel) graphQLModelMutatingVisitor.b(m20021a());
                if (m20021a() != pageCallToActionModel) {
                    graphQLVisitableModel = (PageCallToActionCoreUpdateMutationFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f16795d = pageCallToActionModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m20022a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m20021a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}

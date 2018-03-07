package com.facebook.messaging.bots.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLMessengerBotCommandIconStyle;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.messaging.bots.graphql.FetchBotCommandsQueryParsers.FetchBotCommandsQueryParser;
import com.facebook.messaging.bots.graphql.FetchBotCommandsQueryParsers.FetchBotCommandsQueryParser.SuggestionsParser;
import com.facebook.messaging.bots.graphql.FetchBotCommandsQueryParsers.FetchBotCommandsQueryParser.SuggestionsParser.CommandParser;
import com.facebook.messaging.bots.graphql.FetchBotCommandsQueryParsers.FetchBotCommandsQueryParser.SuggestionsParser.IconParser;
import com.facebook.messaging.bots.graphql.FetchBotCommandsQueryParsers.FetchBotCommandsQueryParser.SuggestionsParser.IconParser.ImageParser;
import com.facebook.messaging.bots.graphql.FetchBotCommandsQueryParsers.FetchBotCommandsQueryParser.SuggestionsParser.ItemParser;
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

/* compiled from: objective_for_results_label */
public class FetchBotCommandsQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1724836306)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: objective_for_results_label */
    public final class FetchBotCommandsQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<SuggestionsModel> f8327d;

        /* compiled from: objective_for_results_label */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchBotCommandsQueryModel.class, new Deserializer());
            }

            public Object m8581a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FetchBotCommandsQueryParser.m8630a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object fetchBotCommandsQueryModel = new FetchBotCommandsQueryModel();
                ((BaseModel) fetchBotCommandsQueryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (fetchBotCommandsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchBotCommandsQueryModel).a();
                }
                return fetchBotCommandsQueryModel;
            }
        }

        /* compiled from: objective_for_results_label */
        public class Serializer extends JsonSerializer<FetchBotCommandsQueryModel> {
            public final void m8582a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchBotCommandsQueryModel fetchBotCommandsQueryModel = (FetchBotCommandsQueryModel) obj;
                if (fetchBotCommandsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchBotCommandsQueryModel.m8617a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchBotCommandsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchBotCommandsQueryModel.w_();
                int u_ = fetchBotCommandsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("suggestions");
                    jsonGenerator.d();
                    for (int i = 0; i < mutableFlatBuffer.c(g); i++) {
                        SuggestionsParser.m8629b(mutableFlatBuffer, mutableFlatBuffer.m(g, i), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchBotCommandsQueryModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1938853907)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: objective_for_results_label */
        public final class SuggestionsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private CommandModel f8324d;
            @Nullable
            private IconModel f8325e;
            @Nullable
            private ItemModel f8326f;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 768267317)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: objective_for_results_label */
            public final class CommandModel extends BaseModel implements GraphQLVisitableModel {
                private boolean f8315d;
                @Nullable
                private String f8316e;

                /* compiled from: objective_for_results_label */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(CommandModel.class, new Deserializer());
                    }

                    public Object m8583a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(CommandParser.m8620a(r11, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object commandModel = new CommandModel();
                        ((BaseModel) commandModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), r11);
                        if (commandModel instanceof Postprocessable) {
                            return ((Postprocessable) commandModel).a();
                        }
                        return commandModel;
                    }
                }

                /* compiled from: objective_for_results_label */
                public class Serializer extends JsonSerializer<CommandModel> {
                    public final void m8584a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        CommandModel commandModel = (CommandModel) r8;
                        if (commandModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(commandModel.m8585a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            commandModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        CommandParser.m8621a(commandModel.w_(), commandModel.u_(), r9);
                    }

                    static {
                        FbSerializerProvider.a(CommandModel.class, new Serializer());
                    }
                }

                public CommandModel() {
                    super(2);
                }

                public final boolean m8588a() {
                    a(0, 0);
                    return this.f8315d;
                }

                @Nullable
                public final String m8589j() {
                    this.f8316e = super.a(this.f8316e, 1);
                    return this.f8316e;
                }

                public final int jK_() {
                    return -1146609961;
                }

                public final GraphQLVisitableModel m8586a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m8585a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = r4.b(m8589j());
                    r4.c(2);
                    r4.a(0, this.f8315d);
                    r4.b(1, b);
                    i();
                    return r4.d();
                }

                public final void m8587a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(r2, r3, r4);
                    this.f8315d = r2.a(r3, 0);
                }
            }

            /* compiled from: objective_for_results_label */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SuggestionsModel.class, new Deserializer());
                }

                public Object m8590a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SuggestionsParser.m8628b(r11, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object suggestionsModel = new SuggestionsModel();
                    ((BaseModel) suggestionsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), r11);
                    if (suggestionsModel instanceof Postprocessable) {
                        return ((Postprocessable) suggestionsModel).a();
                    }
                    return suggestionsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1931673001)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: objective_for_results_label */
            public final class IconModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private ImageModel f8320d;
                @Nullable
                private GraphQLMessengerBotCommandIconStyle f8321e;

                /* compiled from: objective_for_results_label */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(IconModel.class, new Deserializer());
                    }

                    public Object m8591a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(IconParser.m8624a(r11, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object iconModel = new IconModel();
                        ((BaseModel) iconModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), r11);
                        if (iconModel instanceof Postprocessable) {
                            return ((Postprocessable) iconModel).a();
                        }
                        return iconModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 729935302)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: objective_for_results_label */
                public final class ImageModel extends BaseModel implements GraphQLVisitableModel {
                    private int f8317d;
                    @Nullable
                    private String f8318e;
                    private int f8319f;

                    /* compiled from: objective_for_results_label */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(ImageModel.class, new Deserializer());
                        }

                        public Object m8592a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(ImageParser.m8622a(r11, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object imageModel = new ImageModel();
                            ((BaseModel) imageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), r11);
                            if (imageModel instanceof Postprocessable) {
                                return ((Postprocessable) imageModel).a();
                            }
                            return imageModel;
                        }
                    }

                    /* compiled from: objective_for_results_label */
                    public class Serializer extends JsonSerializer<ImageModel> {
                        public final void m8593a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            ImageModel imageModel = (ImageModel) r8;
                            if (imageModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(imageModel.m8595a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                imageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            ImageParser.m8623a(imageModel.w_(), imageModel.u_(), r9);
                        }

                        static {
                            FbSerializerProvider.a(ImageModel.class, new Serializer());
                        }
                    }

                    public ImageModel() {
                        super(3);
                    }

                    public final int m8594a() {
                        a(0, 0);
                        return this.f8317d;
                    }

                    @Nullable
                    public final String m8598j() {
                        this.f8318e = super.a(this.f8318e, 1);
                        return this.f8318e;
                    }

                    public final int m8599k() {
                        a(0, 2);
                        return this.f8319f;
                    }

                    public final int jK_() {
                        return 70760763;
                    }

                    public final GraphQLVisitableModel m8596a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m8595a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = r4.b(m8598j());
                        r4.c(3);
                        r4.a(0, this.f8317d, 0);
                        r4.b(1, b);
                        r4.a(2, this.f8319f, 0);
                        i();
                        return r4.d();
                    }

                    public final void m8597a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                        super.a(r3, r4, r5);
                        this.f8317d = r3.a(r4, 0, 0);
                        this.f8319f = r3.a(r4, 2, 0);
                    }
                }

                /* compiled from: objective_for_results_label */
                public class Serializer extends JsonSerializer<IconModel> {
                    public final void m8600a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        IconModel iconModel = (IconModel) r8;
                        if (iconModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(iconModel.m8601a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            iconModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        IconParser.m8625a(iconModel.w_(), iconModel.u_(), r9, r10);
                    }

                    static {
                        FbSerializerProvider.a(IconModel.class, new Serializer());
                    }
                }

                public IconModel() {
                    super(2);
                }

                @Nullable
                public final ImageModel m8603a() {
                    this.f8320d = (ImageModel) super.a(this.f8320d, 0, ImageModel.class);
                    return this.f8320d;
                }

                @Nullable
                public final GraphQLMessengerBotCommandIconStyle m8604j() {
                    this.f8321e = (GraphQLMessengerBotCommandIconStyle) super.b(this.f8321e, 1, GraphQLMessengerBotCommandIconStyle.class, GraphQLMessengerBotCommandIconStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                    return this.f8321e;
                }

                public final int jK_() {
                    return 1516342256;
                }

                public final GraphQLVisitableModel m8602a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m8603a() != null) {
                        ImageModel imageModel = (ImageModel) r4.b(m8603a());
                        if (m8603a() != imageModel) {
                            graphQLVisitableModel = (IconModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f8320d = imageModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m8601a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(r4, m8603a());
                    int a2 = r4.a(m8604j());
                    r4.c(2);
                    r4.b(0, a);
                    r4.b(1, a2);
                    i();
                    return r4.d();
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 2028791240)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: objective_for_results_label */
            public final class ItemModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f8322d;
                @Nullable
                private String f8323e;

                /* compiled from: objective_for_results_label */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ItemModel.class, new Deserializer());
                    }

                    public Object m8605a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ItemParser.m8626a(r11, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object itemModel = new ItemModel();
                        ((BaseModel) itemModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), r11);
                        if (itemModel instanceof Postprocessable) {
                            return ((Postprocessable) itemModel).a();
                        }
                        return itemModel;
                    }
                }

                /* compiled from: objective_for_results_label */
                public class Serializer extends JsonSerializer<ItemModel> {
                    public final void m8606a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ItemModel itemModel = (ItemModel) r8;
                        if (itemModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(itemModel.m8607a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            itemModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ItemParser.m8627a(itemModel.w_(), itemModel.u_(), r9);
                    }

                    static {
                        FbSerializerProvider.a(ItemModel.class, new Serializer());
                    }
                }

                public ItemModel() {
                    super(2);
                }

                @Nullable
                public final String m8609a() {
                    this.f8322d = super.a(this.f8322d, 0);
                    return this.f8322d;
                }

                @Nullable
                public final String m8610j() {
                    this.f8323e = super.a(this.f8323e, 1);
                    return this.f8323e;
                }

                public final int jK_() {
                    return 1516358282;
                }

                public final GraphQLVisitableModel m8608a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m8607a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = r4.b(m8609a());
                    int b2 = r4.b(m8610j());
                    r4.c(2);
                    r4.b(0, b);
                    r4.b(1, b2);
                    i();
                    return r4.d();
                }
            }

            /* compiled from: objective_for_results_label */
            public class Serializer extends JsonSerializer<SuggestionsModel> {
                public final void m8611a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SuggestionsModel suggestionsModel = (SuggestionsModel) r8;
                    if (suggestionsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(suggestionsModel.m8612a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        suggestionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SuggestionsParser.m8629b(suggestionsModel.w_(), suggestionsModel.u_(), r9, r10);
                }

                static {
                    FbSerializerProvider.a(SuggestionsModel.class, new Serializer());
                }
            }

            public SuggestionsModel() {
                super(3);
            }

            @Nullable
            public final CommandModel m8614a() {
                this.f8324d = (CommandModel) super.a(this.f8324d, 0, CommandModel.class);
                return this.f8324d;
            }

            @Nullable
            public final IconModel m8615j() {
                this.f8325e = (IconModel) super.a(this.f8325e, 1, IconModel.class);
                return this.f8325e;
            }

            @Nullable
            public final ItemModel m8616k() {
                this.f8326f = (ItemModel) super.a(this.f8326f, 2, ItemModel.class);
                return this.f8326f;
            }

            public final int jK_() {
                return -522034117;
            }

            public final GraphQLVisitableModel m8613a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m8614a() != null) {
                    CommandModel commandModel = (CommandModel) r4.b(m8614a());
                    if (m8614a() != commandModel) {
                        graphQLVisitableModel = (SuggestionsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f8324d = commandModel;
                    }
                }
                if (m8615j() != null) {
                    IconModel iconModel = (IconModel) r4.b(m8615j());
                    if (m8615j() != iconModel) {
                        graphQLVisitableModel = (SuggestionsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f8325e = iconModel;
                    }
                }
                if (m8616k() != null) {
                    ItemModel itemModel = (ItemModel) r4.b(m8616k());
                    if (m8616k() != itemModel) {
                        graphQLVisitableModel = (SuggestionsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f8326f = itemModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m8612a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(r5, m8614a());
                int a2 = ModelHelper.a(r5, m8615j());
                int a3 = ModelHelper.a(r5, m8616k());
                r5.c(3);
                r5.b(0, a);
                r5.b(1, a2);
                r5.b(2, a3);
                i();
                return r5.d();
            }
        }

        public FetchBotCommandsQueryModel() {
            super(1);
        }

        @Nonnull
        public final ImmutableList<SuggestionsModel> m8619a() {
            this.f8327d = super.a(this.f8327d, 0, SuggestionsModel.class);
            return (ImmutableList) this.f8327d;
        }

        public final int jK_() {
            return 158282279;
        }

        public final GraphQLVisitableModel m8618a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m8619a() != null) {
                Builder a = ModelHelper.a(m8619a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (FetchBotCommandsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8327d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m8617a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m8619a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}

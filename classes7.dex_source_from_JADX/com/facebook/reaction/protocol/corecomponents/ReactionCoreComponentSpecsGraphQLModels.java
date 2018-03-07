package com.facebook.reaction.protocol.corecomponents;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLReactionCoreComponentMargin;
import com.facebook.graphql.enums.GraphQLReactionCoreComponentPadding;
import com.facebook.graphql.enums.GraphQLReactionCoreTextAlignment;
import com.facebook.graphql.enums.GraphQLReactionCoreTextBoldness;
import com.facebook.graphql.enums.GraphQLReactionCoreTextLineSpacing;
import com.facebook.graphql.enums.GraphQLReactionCoreTextSize;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.reaction.protocol.corecomponents.ReactionCoreComponentSpecsGraphQLParsers.ReactionCoreComponentBorderSpecFieldsParser;
import com.facebook.reaction.protocol.corecomponents.ReactionCoreComponentSpecsGraphQLParsers.ReactionCoreComponentMarginSpecFieldsParser;
import com.facebook.reaction.protocol.corecomponents.ReactionCoreComponentSpecsGraphQLParsers.ReactionCoreComponentPaddingSpecFieldsParser;
import com.facebook.reaction.protocol.corecomponents.ReactionCoreComponentSpecsGraphQLParsers.ReactionCoreComponentTextSpecFieldsParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: filter_swipes_in_gallery */
public class ReactionCoreComponentSpecsGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1589950056)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: filter_swipes_in_gallery */
    public final class ReactionCoreComponentBorderSpecFieldsModel extends BaseModel implements GraphQLVisitableModel {
        private boolean f12408d;
        private boolean f12409e;
        private boolean f12410f;
        private boolean f12411g;

        /* compiled from: filter_swipes_in_gallery */
        public final class Builder {
            public boolean f12404a;
            public boolean f12405b;
            public boolean f12406c;
            public boolean f12407d;
        }

        /* compiled from: filter_swipes_in_gallery */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionCoreComponentBorderSpecFieldsModel.class, new Deserializer());
            }

            public Object m15243a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ReactionCoreComponentBorderSpecFieldsParser.m15284a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object reactionCoreComponentBorderSpecFieldsModel = new ReactionCoreComponentBorderSpecFieldsModel();
                ((BaseModel) reactionCoreComponentBorderSpecFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (reactionCoreComponentBorderSpecFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionCoreComponentBorderSpecFieldsModel).a();
                }
                return reactionCoreComponentBorderSpecFieldsModel;
            }
        }

        /* compiled from: filter_swipes_in_gallery */
        public class Serializer extends JsonSerializer<ReactionCoreComponentBorderSpecFieldsModel> {
            public final void m15244a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ReactionCoreComponentBorderSpecFieldsModel reactionCoreComponentBorderSpecFieldsModel = (ReactionCoreComponentBorderSpecFieldsModel) obj;
                if (reactionCoreComponentBorderSpecFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionCoreComponentBorderSpecFieldsModel.m15246a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionCoreComponentBorderSpecFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ReactionCoreComponentBorderSpecFieldsParser.m15285a(reactionCoreComponentBorderSpecFieldsModel.w_(), reactionCoreComponentBorderSpecFieldsModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(ReactionCoreComponentBorderSpecFieldsModel.class, new Serializer());
            }
        }

        public ReactionCoreComponentBorderSpecFieldsModel() {
            super(4);
        }

        public ReactionCoreComponentBorderSpecFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(4);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final boolean m15249a() {
            a(0, 0);
            return this.f12408d;
        }

        public final boolean m15250b() {
            a(0, 1);
            return this.f12409e;
        }

        public final boolean m15251c() {
            a(0, 2);
            return this.f12410f;
        }

        public final boolean m15252d() {
            a(0, 3);
            return this.f12411g;
        }

        public static ReactionCoreComponentBorderSpecFieldsModel m15245a(ReactionCoreComponentBorderSpecFieldsModel reactionCoreComponentBorderSpecFieldsModel) {
            if (reactionCoreComponentBorderSpecFieldsModel == null) {
                return null;
            }
            if (reactionCoreComponentBorderSpecFieldsModel instanceof ReactionCoreComponentBorderSpecFieldsModel) {
                return reactionCoreComponentBorderSpecFieldsModel;
            }
            Builder builder = new Builder();
            builder.f12404a = reactionCoreComponentBorderSpecFieldsModel.m15249a();
            builder.f12405b = reactionCoreComponentBorderSpecFieldsModel.m15250b();
            builder.f12406c = reactionCoreComponentBorderSpecFieldsModel.m15251c();
            builder.f12407d = reactionCoreComponentBorderSpecFieldsModel.m15252d();
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.c(4);
            flatBufferBuilder.a(0, builder.f12404a);
            flatBufferBuilder.a(1, builder.f12405b);
            flatBufferBuilder.a(2, builder.f12406c);
            flatBufferBuilder.a(3, builder.f12407d);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new ReactionCoreComponentBorderSpecFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        public final int jK_() {
            return -1360986052;
        }

        public final GraphQLVisitableModel m15247a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m15246a(FlatBufferBuilder flatBufferBuilder) {
            h();
            flatBufferBuilder.c(4);
            flatBufferBuilder.a(0, this.f12408d);
            flatBufferBuilder.a(1, this.f12409e);
            flatBufferBuilder.a(2, this.f12410f);
            flatBufferBuilder.a(3, this.f12411g);
            i();
            return flatBufferBuilder.d();
        }

        public final void m15248a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f12408d = mutableFlatBuffer.a(i, 0);
            this.f12409e = mutableFlatBuffer.a(i, 1);
            this.f12410f = mutableFlatBuffer.a(i, 2);
            this.f12411g = mutableFlatBuffer.a(i, 3);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -839555411)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: filter_swipes_in_gallery */
    public final class ReactionCoreComponentMarginSpecFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GraphQLReactionCoreComponentMargin f12416d;
        @Nullable
        private GraphQLReactionCoreComponentMargin f12417e;
        @Nullable
        private GraphQLReactionCoreComponentMargin f12418f;
        @Nullable
        private GraphQLReactionCoreComponentMargin f12419g;

        /* compiled from: filter_swipes_in_gallery */
        public final class Builder {
            @Nullable
            public GraphQLReactionCoreComponentMargin f12412a;
            @Nullable
            public GraphQLReactionCoreComponentMargin f12413b;
            @Nullable
            public GraphQLReactionCoreComponentMargin f12414c;
            @Nullable
            public GraphQLReactionCoreComponentMargin f12415d;
        }

        /* compiled from: filter_swipes_in_gallery */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionCoreComponentMarginSpecFieldsModel.class, new Deserializer());
            }

            public Object m15253a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ReactionCoreComponentMarginSpecFieldsParser.m15286a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object reactionCoreComponentMarginSpecFieldsModel = new ReactionCoreComponentMarginSpecFieldsModel();
                ((BaseModel) reactionCoreComponentMarginSpecFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (reactionCoreComponentMarginSpecFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionCoreComponentMarginSpecFieldsModel).a();
                }
                return reactionCoreComponentMarginSpecFieldsModel;
            }
        }

        /* compiled from: filter_swipes_in_gallery */
        public class Serializer extends JsonSerializer<ReactionCoreComponentMarginSpecFieldsModel> {
            public final void m15254a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ReactionCoreComponentMarginSpecFieldsModel reactionCoreComponentMarginSpecFieldsModel = (ReactionCoreComponentMarginSpecFieldsModel) obj;
                if (reactionCoreComponentMarginSpecFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionCoreComponentMarginSpecFieldsModel.m15256a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionCoreComponentMarginSpecFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ReactionCoreComponentMarginSpecFieldsParser.m15287a(reactionCoreComponentMarginSpecFieldsModel.w_(), reactionCoreComponentMarginSpecFieldsModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(ReactionCoreComponentMarginSpecFieldsModel.class, new Serializer());
            }
        }

        public ReactionCoreComponentMarginSpecFieldsModel() {
            super(4);
        }

        public ReactionCoreComponentMarginSpecFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(4);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final GraphQLReactionCoreComponentMargin m15257a() {
            this.f12416d = (GraphQLReactionCoreComponentMargin) super.b(this.f12416d, 0, GraphQLReactionCoreComponentMargin.class, GraphQLReactionCoreComponentMargin.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f12416d;
        }

        @Nullable
        public final GraphQLReactionCoreComponentMargin m15259b() {
            this.f12417e = (GraphQLReactionCoreComponentMargin) super.b(this.f12417e, 1, GraphQLReactionCoreComponentMargin.class, GraphQLReactionCoreComponentMargin.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f12417e;
        }

        @Nullable
        public final GraphQLReactionCoreComponentMargin m15260c() {
            this.f12418f = (GraphQLReactionCoreComponentMargin) super.b(this.f12418f, 2, GraphQLReactionCoreComponentMargin.class, GraphQLReactionCoreComponentMargin.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f12418f;
        }

        @Nullable
        public final GraphQLReactionCoreComponentMargin m15261d() {
            this.f12419g = (GraphQLReactionCoreComponentMargin) super.b(this.f12419g, 3, GraphQLReactionCoreComponentMargin.class, GraphQLReactionCoreComponentMargin.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f12419g;
        }

        public static ReactionCoreComponentMarginSpecFieldsModel m15255a(ReactionCoreComponentMarginSpecFieldsModel reactionCoreComponentMarginSpecFieldsModel) {
            if (reactionCoreComponentMarginSpecFieldsModel == null) {
                return null;
            }
            if (reactionCoreComponentMarginSpecFieldsModel instanceof ReactionCoreComponentMarginSpecFieldsModel) {
                return reactionCoreComponentMarginSpecFieldsModel;
            }
            Builder builder = new Builder();
            builder.f12412a = reactionCoreComponentMarginSpecFieldsModel.m15257a();
            builder.f12413b = reactionCoreComponentMarginSpecFieldsModel.m15259b();
            builder.f12414c = reactionCoreComponentMarginSpecFieldsModel.m15260c();
            builder.f12415d = reactionCoreComponentMarginSpecFieldsModel.m15261d();
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int a = flatBufferBuilder.a(builder.f12412a);
            int a2 = flatBufferBuilder.a(builder.f12413b);
            int a3 = flatBufferBuilder.a(builder.f12414c);
            int a4 = flatBufferBuilder.a(builder.f12415d);
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, a4);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new ReactionCoreComponentMarginSpecFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        public final int jK_() {
            return -1214742338;
        }

        public final GraphQLVisitableModel m15258a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m15256a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = flatBufferBuilder.a(m15257a());
            int a2 = flatBufferBuilder.a(m15259b());
            int a3 = flatBufferBuilder.a(m15260c());
            int a4 = flatBufferBuilder.a(m15261d());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, a4);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1849926839)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: filter_swipes_in_gallery */
    public final class ReactionCoreComponentPaddingSpecFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GraphQLReactionCoreComponentPadding f12424d;
        @Nullable
        private GraphQLReactionCoreComponentPadding f12425e;
        @Nullable
        private GraphQLReactionCoreComponentPadding f12426f;
        @Nullable
        private GraphQLReactionCoreComponentPadding f12427g;

        /* compiled from: filter_swipes_in_gallery */
        public final class Builder {
            @Nullable
            public GraphQLReactionCoreComponentPadding f12420a;
            @Nullable
            public GraphQLReactionCoreComponentPadding f12421b;
            @Nullable
            public GraphQLReactionCoreComponentPadding f12422c;
            @Nullable
            public GraphQLReactionCoreComponentPadding f12423d;
        }

        /* compiled from: filter_swipes_in_gallery */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionCoreComponentPaddingSpecFieldsModel.class, new Deserializer());
            }

            public Object m15262a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ReactionCoreComponentPaddingSpecFieldsParser.m15288a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object reactionCoreComponentPaddingSpecFieldsModel = new ReactionCoreComponentPaddingSpecFieldsModel();
                ((BaseModel) reactionCoreComponentPaddingSpecFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (reactionCoreComponentPaddingSpecFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionCoreComponentPaddingSpecFieldsModel).a();
                }
                return reactionCoreComponentPaddingSpecFieldsModel;
            }
        }

        /* compiled from: filter_swipes_in_gallery */
        public class Serializer extends JsonSerializer<ReactionCoreComponentPaddingSpecFieldsModel> {
            public final void m15263a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ReactionCoreComponentPaddingSpecFieldsModel reactionCoreComponentPaddingSpecFieldsModel = (ReactionCoreComponentPaddingSpecFieldsModel) obj;
                if (reactionCoreComponentPaddingSpecFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionCoreComponentPaddingSpecFieldsModel.m15265a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionCoreComponentPaddingSpecFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ReactionCoreComponentPaddingSpecFieldsParser.m15289a(reactionCoreComponentPaddingSpecFieldsModel.w_(), reactionCoreComponentPaddingSpecFieldsModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(ReactionCoreComponentPaddingSpecFieldsModel.class, new Serializer());
            }
        }

        public ReactionCoreComponentPaddingSpecFieldsModel() {
            super(4);
        }

        public ReactionCoreComponentPaddingSpecFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(4);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final GraphQLReactionCoreComponentPadding m15266a() {
            this.f12424d = (GraphQLReactionCoreComponentPadding) super.b(this.f12424d, 0, GraphQLReactionCoreComponentPadding.class, GraphQLReactionCoreComponentPadding.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f12424d;
        }

        @Nullable
        public final GraphQLReactionCoreComponentPadding m15268b() {
            this.f12425e = (GraphQLReactionCoreComponentPadding) super.b(this.f12425e, 1, GraphQLReactionCoreComponentPadding.class, GraphQLReactionCoreComponentPadding.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f12425e;
        }

        @Nullable
        public final GraphQLReactionCoreComponentPadding m15269c() {
            this.f12426f = (GraphQLReactionCoreComponentPadding) super.b(this.f12426f, 2, GraphQLReactionCoreComponentPadding.class, GraphQLReactionCoreComponentPadding.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f12426f;
        }

        @Nullable
        public final GraphQLReactionCoreComponentPadding m15270d() {
            this.f12427g = (GraphQLReactionCoreComponentPadding) super.b(this.f12427g, 3, GraphQLReactionCoreComponentPadding.class, GraphQLReactionCoreComponentPadding.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f12427g;
        }

        public static ReactionCoreComponentPaddingSpecFieldsModel m15264a(ReactionCoreComponentPaddingSpecFieldsModel reactionCoreComponentPaddingSpecFieldsModel) {
            if (reactionCoreComponentPaddingSpecFieldsModel == null) {
                return null;
            }
            if (reactionCoreComponentPaddingSpecFieldsModel instanceof ReactionCoreComponentPaddingSpecFieldsModel) {
                return reactionCoreComponentPaddingSpecFieldsModel;
            }
            Builder builder = new Builder();
            builder.f12420a = reactionCoreComponentPaddingSpecFieldsModel.m15266a();
            builder.f12421b = reactionCoreComponentPaddingSpecFieldsModel.m15268b();
            builder.f12422c = reactionCoreComponentPaddingSpecFieldsModel.m15269c();
            builder.f12423d = reactionCoreComponentPaddingSpecFieldsModel.m15270d();
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int a = flatBufferBuilder.a(builder.f12420a);
            int a2 = flatBufferBuilder.a(builder.f12421b);
            int a3 = flatBufferBuilder.a(builder.f12422c);
            int a4 = flatBufferBuilder.a(builder.f12423d);
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, a4);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new ReactionCoreComponentPaddingSpecFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        public final int jK_() {
            return -1479481385;
        }

        public final GraphQLVisitableModel m15267a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m15265a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = flatBufferBuilder.a(m15266a());
            int a2 = flatBufferBuilder.a(m15268b());
            int a3 = flatBufferBuilder.a(m15269c());
            int a4 = flatBufferBuilder.a(m15270d());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, a4);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 973267141)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: filter_swipes_in_gallery */
    public final class ReactionCoreComponentTextSpecFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GraphQLReactionCoreTextAlignment f12438d;
        @Nullable
        private GraphQLReactionCoreTextBoldness f12439e;
        private boolean f12440f;
        @Nullable
        private String f12441g;
        @Nullable
        private GraphQLReactionCoreTextLineSpacing f12442h;
        private boolean f12443i;
        @Nullable
        private GraphQLReactionCoreTextSize f12444j;
        private int f12445k;
        @Nullable
        private String f12446l;
        private boolean f12447m;

        /* compiled from: filter_swipes_in_gallery */
        public final class Builder {
            @Nullable
            public GraphQLReactionCoreTextAlignment f12428a;
            @Nullable
            public GraphQLReactionCoreTextBoldness f12429b;
            public boolean f12430c;
            @Nullable
            public String f12431d;
            @Nullable
            public GraphQLReactionCoreTextLineSpacing f12432e;
            public boolean f12433f;
            @Nullable
            public GraphQLReactionCoreTextSize f12434g;
            public int f12435h;
            @Nullable
            public String f12436i;
            public boolean f12437j;
        }

        /* compiled from: filter_swipes_in_gallery */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionCoreComponentTextSpecFieldsModel.class, new Deserializer());
            }

            public Object m15271a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ReactionCoreComponentTextSpecFieldsParser.m15290a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object reactionCoreComponentTextSpecFieldsModel = new ReactionCoreComponentTextSpecFieldsModel();
                ((BaseModel) reactionCoreComponentTextSpecFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (reactionCoreComponentTextSpecFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionCoreComponentTextSpecFieldsModel).a();
                }
                return reactionCoreComponentTextSpecFieldsModel;
            }
        }

        /* compiled from: filter_swipes_in_gallery */
        public class Serializer extends JsonSerializer<ReactionCoreComponentTextSpecFieldsModel> {
            public final void m15272a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ReactionCoreComponentTextSpecFieldsModel reactionCoreComponentTextSpecFieldsModel = (ReactionCoreComponentTextSpecFieldsModel) obj;
                if (reactionCoreComponentTextSpecFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionCoreComponentTextSpecFieldsModel.m15274a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionCoreComponentTextSpecFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ReactionCoreComponentTextSpecFieldsParser.m15291a(reactionCoreComponentTextSpecFieldsModel.w_(), reactionCoreComponentTextSpecFieldsModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(ReactionCoreComponentTextSpecFieldsModel.class, new Serializer());
            }
        }

        public ReactionCoreComponentTextSpecFieldsModel() {
            super(10);
        }

        public ReactionCoreComponentTextSpecFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(10);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final GraphQLReactionCoreTextAlignment m15275a() {
            this.f12438d = (GraphQLReactionCoreTextAlignment) super.b(this.f12438d, 0, GraphQLReactionCoreTextAlignment.class, GraphQLReactionCoreTextAlignment.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f12438d;
        }

        @Nullable
        public final GraphQLReactionCoreTextBoldness m15278b() {
            this.f12439e = (GraphQLReactionCoreTextBoldness) super.b(this.f12439e, 1, GraphQLReactionCoreTextBoldness.class, GraphQLReactionCoreTextBoldness.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f12439e;
        }

        public final boolean m15279c() {
            a(0, 2);
            return this.f12440f;
        }

        @Nullable
        public final String m15280d() {
            this.f12441g = super.a(this.f12441g, 3);
            return this.f12441g;
        }

        @Nullable
        public final GraphQLReactionCoreTextLineSpacing eY_() {
            this.f12442h = (GraphQLReactionCoreTextLineSpacing) super.b(this.f12442h, 4, GraphQLReactionCoreTextLineSpacing.class, GraphQLReactionCoreTextLineSpacing.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f12442h;
        }

        public final boolean m15281g() {
            a(0, 5);
            return this.f12443i;
        }

        @Nullable
        public final GraphQLReactionCoreTextSize eZ_() {
            this.f12444j = (GraphQLReactionCoreTextSize) super.b(this.f12444j, 6, GraphQLReactionCoreTextSize.class, GraphQLReactionCoreTextSize.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f12444j;
        }

        public final int fa_() {
            a(0, 7);
            return this.f12445k;
        }

        @Nullable
        public final String m15282j() {
            this.f12446l = super.a(this.f12446l, 8);
            return this.f12446l;
        }

        public final boolean m15283k() {
            a(1, 1);
            return this.f12447m;
        }

        public static ReactionCoreComponentTextSpecFieldsModel m15273a(ReactionCoreComponentTextSpecFieldsModel reactionCoreComponentTextSpecFieldsModel) {
            if (reactionCoreComponentTextSpecFieldsModel == null) {
                return null;
            }
            if (reactionCoreComponentTextSpecFieldsModel instanceof ReactionCoreComponentTextSpecFieldsModel) {
                return reactionCoreComponentTextSpecFieldsModel;
            }
            Builder builder = new Builder();
            builder.f12428a = reactionCoreComponentTextSpecFieldsModel.m15275a();
            builder.f12429b = reactionCoreComponentTextSpecFieldsModel.m15278b();
            builder.f12430c = reactionCoreComponentTextSpecFieldsModel.m15279c();
            builder.f12431d = reactionCoreComponentTextSpecFieldsModel.m15280d();
            builder.f12432e = reactionCoreComponentTextSpecFieldsModel.eY_();
            builder.f12433f = reactionCoreComponentTextSpecFieldsModel.m15281g();
            builder.f12434g = reactionCoreComponentTextSpecFieldsModel.eZ_();
            builder.f12435h = reactionCoreComponentTextSpecFieldsModel.fa_();
            builder.f12436i = reactionCoreComponentTextSpecFieldsModel.m15282j();
            builder.f12437j = reactionCoreComponentTextSpecFieldsModel.m15283k();
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int a = flatBufferBuilder.a(builder.f12428a);
            int a2 = flatBufferBuilder.a(builder.f12429b);
            int b = flatBufferBuilder.b(builder.f12431d);
            int a3 = flatBufferBuilder.a(builder.f12432e);
            int a4 = flatBufferBuilder.a(builder.f12434g);
            int b2 = flatBufferBuilder.b(builder.f12436i);
            flatBufferBuilder.c(10);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.a(2, builder.f12430c);
            flatBufferBuilder.b(3, b);
            flatBufferBuilder.b(4, a3);
            flatBufferBuilder.a(5, builder.f12433f);
            flatBufferBuilder.b(6, a4);
            flatBufferBuilder.a(7, builder.f12435h, 0);
            flatBufferBuilder.b(8, b2);
            flatBufferBuilder.a(9, builder.f12437j);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new ReactionCoreComponentTextSpecFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        public final int jK_() {
            return 722629117;
        }

        public final GraphQLVisitableModel m15276a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m15274a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = flatBufferBuilder.a(m15275a());
            int a2 = flatBufferBuilder.a(m15278b());
            int b = flatBufferBuilder.b(m15280d());
            int a3 = flatBufferBuilder.a(eY_());
            int a4 = flatBufferBuilder.a(eZ_());
            int b2 = flatBufferBuilder.b(m15282j());
            flatBufferBuilder.c(10);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.a(2, this.f12440f);
            flatBufferBuilder.b(3, b);
            flatBufferBuilder.b(4, a3);
            flatBufferBuilder.a(5, this.f12443i);
            flatBufferBuilder.b(6, a4);
            flatBufferBuilder.a(7, this.f12445k, 0);
            flatBufferBuilder.b(8, b2);
            flatBufferBuilder.a(9, this.f12447m);
            i();
            return flatBufferBuilder.d();
        }

        public final void m15277a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f12440f = mutableFlatBuffer.a(i, 2);
            this.f12443i = mutableFlatBuffer.a(i, 5);
            this.f12445k = mutableFlatBuffer.a(i, 7, 0);
            this.f12447m = mutableFlatBuffer.a(i, 9);
        }
    }
}

package com.facebook.entitycards.contextitems.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryInterfaces.ContextItemsConnectionFragment;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryParsers.ContextItemFieldsParser;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryParsers.ContextItemFieldsParser.IconParser;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryParsers.ContextItemFieldsParser.ItemLinksParser;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryParsers.ContextItemsConnectionFragmentParser;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryParsers.ContextItemsConnectionFragmentParser.EdgesParser;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryParsers.ContextItemsConnectionWithPageInfoFragmentParser;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryParsers.ContextItemsConnectionWithPageInfoFragmentParser.PageInfoParser;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryParsers.ContextItemsQueryParser;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryParsers.FBFullImageFragmentParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLEntityCardContextItemType;
import com.facebook.graphql.enums.GraphQLImageSizingStyle;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
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

/* compiled from: Zero Campaign is not enabled (uri was  */
public class ContextItemsQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -387762130)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: Zero Campaign is not enabled (uri was  */
    public final class ContextItemFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f12044d;
        @Nullable
        private IconModel f12045e;
        @Nullable
        private List<ItemLinksModel> f12046f;
        @Nullable
        private GraphQLEntityCardContextItemType f12047g;
        @Nullable
        private String f12048h;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f12049i;
        @Nullable
        private DefaultTextWithEntitiesLongFieldsModel f12050j;
        @Nullable
        private String f12051k;

        /* compiled from: Zero Campaign is not enabled (uri was  */
        public final class Builder {
            @Nullable
            public String f12026a;
            @Nullable
            public IconModel f12027b;
            @Nullable
            public ImmutableList<ItemLinksModel> f12028c;
            @Nullable
            public GraphQLEntityCardContextItemType f12029d;
            @Nullable
            public String f12030e;
            @Nullable
            public DefaultTextWithEntitiesFieldsModel f12031f;
            @Nullable
            public DefaultTextWithEntitiesLongFieldsModel f12032g;
            @Nullable
            public String f12033h;

            public static Builder m20015a(ContextItemFieldsModel contextItemFieldsModel) {
                Builder builder = new Builder();
                builder.f12026a = contextItemFieldsModel.m20039a();
                builder.f12027b = contextItemFieldsModel.m20044j();
                builder.f12028c = contextItemFieldsModel.m20041c();
                builder.f12029d = contextItemFieldsModel.m20042d();
                builder.f12030e = contextItemFieldsModel.bA_();
                builder.f12031f = contextItemFieldsModel.m20045k();
                builder.f12032g = contextItemFieldsModel.m20046l();
                builder.f12033h = contextItemFieldsModel.bB_();
                return builder;
            }

            public final ContextItemFieldsModel m20016a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(this.f12026a);
                int a = ModelHelper.a(flatBufferBuilder, this.f12027b);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f12028c);
                int a3 = flatBufferBuilder.a(this.f12029d);
                int b2 = flatBufferBuilder.b(this.f12030e);
                int a4 = ModelHelper.a(flatBufferBuilder, this.f12031f);
                int a5 = ModelHelper.a(flatBufferBuilder, this.f12032g);
                int b3 = flatBufferBuilder.b(this.f12033h);
                flatBufferBuilder.c(8);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.b(2, a2);
                flatBufferBuilder.b(3, a3);
                flatBufferBuilder.b(4, b2);
                flatBufferBuilder.b(5, a4);
                flatBufferBuilder.b(6, a5);
                flatBufferBuilder.b(7, b3);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new ContextItemFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: Zero Campaign is not enabled (uri was  */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ContextItemFieldsModel.class, new Deserializer());
            }

            public Object m20017a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ContextItemFieldsParser.m20101a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object contextItemFieldsModel = new ContextItemFieldsModel();
                ((BaseModel) contextItemFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (contextItemFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) contextItemFieldsModel).a();
                }
                return contextItemFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1000468661)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: Zero Campaign is not enabled (uri was  */
        public final class IconModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private FBFullImageFragmentModel f12036d;
            @Nullable
            private GraphQLImageSizingStyle f12037e;

            /* compiled from: Zero Campaign is not enabled (uri was  */
            public final class Builder {
                @Nullable
                public FBFullImageFragmentModel f12034a;
                @Nullable
                public GraphQLImageSizingStyle f12035b;
            }

            /* compiled from: Zero Campaign is not enabled (uri was  */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(IconModel.class, new Deserializer());
                }

                public Object m20018a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(IconParser.m20097a(jsonParser, flatBufferBuilder));
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

            /* compiled from: Zero Campaign is not enabled (uri was  */
            public class Serializer extends JsonSerializer<IconModel> {
                public final void m20019a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    IconModel iconModel = (IconModel) obj;
                    if (iconModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(iconModel.m20022a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        iconModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    IconParser.m20098a(iconModel.w_(), iconModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(IconModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ FBFullImageFragmentModel m20023a() {
                return m20021j();
            }

            public IconModel() {
                super(2);
            }

            public IconModel(MutableFlatBuffer mutableFlatBuffer) {
                super(2);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            private FBFullImageFragmentModel m20021j() {
                this.f12036d = (FBFullImageFragmentModel) super.a(this.f12036d, 0, FBFullImageFragmentModel.class);
                return this.f12036d;
            }

            @Nullable
            public final GraphQLImageSizingStyle m20025b() {
                this.f12037e = (GraphQLImageSizingStyle) super.b(this.f12037e, 1, GraphQLImageSizingStyle.class, GraphQLImageSizingStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f12037e;
            }

            public static IconModel m20020a(IconModel iconModel) {
                if (iconModel == null) {
                    return null;
                }
                if (iconModel instanceof IconModel) {
                    return iconModel;
                }
                Builder builder = new Builder();
                builder.f12034a = FBFullImageFragmentModel.m20089a(iconModel.m20023a());
                builder.f12035b = iconModel.m20025b();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f12034a);
                int a2 = flatBufferBuilder.a(builder.f12035b);
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new IconModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 1667242696;
            }

            public final GraphQLVisitableModel m20024a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m20021j() != null) {
                    FBFullImageFragmentModel fBFullImageFragmentModel = (FBFullImageFragmentModel) graphQLModelMutatingVisitor.b(m20021j());
                    if (m20021j() != fBFullImageFragmentModel) {
                        graphQLVisitableModel = (IconModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f12036d = fBFullImageFragmentModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m20022a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m20021j());
                int a2 = flatBufferBuilder.a(m20025b());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1955750292)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: Zero Campaign is not enabled (uri was  */
        public final class ItemLinksModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<String> f12041d;
            @Nullable
            private String f12042e;
            @Nullable
            private String f12043f;

            /* compiled from: Zero Campaign is not enabled (uri was  */
            public final class Builder {
                @Nullable
                public ImmutableList<String> f12038a;
                @Nullable
                public String f12039b;
                @Nullable
                public String f12040c;

                public final ItemLinksModel m20026a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int c = flatBufferBuilder.c(this.f12038a);
                    int b = flatBufferBuilder.b(this.f12039b);
                    int b2 = flatBufferBuilder.b(this.f12040c);
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, c);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.b(2, b2);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new ItemLinksModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: Zero Campaign is not enabled (uri was  */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ItemLinksModel.class, new Deserializer());
                }

                public Object m20027a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ItemLinksParser.m20100b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object itemLinksModel = new ItemLinksModel();
                    ((BaseModel) itemLinksModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (itemLinksModel instanceof Postprocessable) {
                        return ((Postprocessable) itemLinksModel).a();
                    }
                    return itemLinksModel;
                }
            }

            /* compiled from: Zero Campaign is not enabled (uri was  */
            public class Serializer extends JsonSerializer<ItemLinksModel> {
                public final void m20028a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ItemLinksModel itemLinksModel = (ItemLinksModel) obj;
                    if (itemLinksModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(itemLinksModel.m20030a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        itemLinksModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ItemLinksParser.m20099a(itemLinksModel.w_(), itemLinksModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ItemLinksModel.class, new Serializer());
                }
            }

            public ItemLinksModel() {
                super(3);
            }

            public ItemLinksModel(MutableFlatBuffer mutableFlatBuffer) {
                super(3);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nonnull
            public final ImmutableList<String> m20032a() {
                this.f12041d = super.a(this.f12041d, 0);
                return (ImmutableList) this.f12041d;
            }

            @Nullable
            public final String m20033b() {
                this.f12042e = super.a(this.f12042e, 1);
                return this.f12042e;
            }

            @Nullable
            public final String m20034c() {
                this.f12043f = super.a(this.f12043f, 2);
                return this.f12043f;
            }

            public static ItemLinksModel m20029a(ItemLinksModel itemLinksModel) {
                if (itemLinksModel == null) {
                    return null;
                }
                if (itemLinksModel instanceof ItemLinksModel) {
                    return itemLinksModel;
                }
                Builder builder = new Builder();
                com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
                for (int i = 0; i < itemLinksModel.m20032a().size(); i++) {
                    builder2.c(itemLinksModel.m20032a().get(i));
                }
                builder.f12038a = builder2.b();
                builder.f12039b = itemLinksModel.m20033b();
                builder.f12040c = itemLinksModel.m20034c();
                return builder.m20026a();
            }

            public final int jK_() {
                return 1667337801;
            }

            public final GraphQLVisitableModel m20031a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m20030a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int c = flatBufferBuilder.c(m20032a());
                int b = flatBufferBuilder.b(m20033b());
                int b2 = flatBufferBuilder.b(m20034c());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, c);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: Zero Campaign is not enabled (uri was  */
        public class Serializer extends JsonSerializer<ContextItemFieldsModel> {
            public final void m20035a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ContextItemFieldsModel contextItemFieldsModel = (ContextItemFieldsModel) obj;
                if (contextItemFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(contextItemFieldsModel.m20037a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    contextItemFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ContextItemFieldsParser.m20102b(contextItemFieldsModel.w_(), contextItemFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ContextItemFieldsModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ IconModel m20040b() {
            return m20044j();
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesLongFields bC_() {
            return m20046l();
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesFields m20043g() {
            return m20045k();
        }

        public ContextItemFieldsModel() {
            super(8);
        }

        public ContextItemFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(8);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final String m20039a() {
            this.f12044d = super.a(this.f12044d, 0);
            return this.f12044d;
        }

        @Nullable
        public final IconModel m20044j() {
            this.f12045e = (IconModel) super.a(this.f12045e, 1, IconModel.class);
            return this.f12045e;
        }

        @Nonnull
        public final ImmutableList<ItemLinksModel> m20041c() {
            this.f12046f = super.a(this.f12046f, 2, ItemLinksModel.class);
            return (ImmutableList) this.f12046f;
        }

        @Nullable
        public final GraphQLEntityCardContextItemType m20042d() {
            this.f12047g = (GraphQLEntityCardContextItemType) super.b(this.f12047g, 3, GraphQLEntityCardContextItemType.class, GraphQLEntityCardContextItemType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f12047g;
        }

        @Nullable
        public final String bA_() {
            this.f12048h = super.a(this.f12048h, 4);
            return this.f12048h;
        }

        @Nullable
        public final DefaultTextWithEntitiesFieldsModel m20045k() {
            this.f12049i = (DefaultTextWithEntitiesFieldsModel) super.a(this.f12049i, 5, DefaultTextWithEntitiesFieldsModel.class);
            return this.f12049i;
        }

        @Nullable
        public final DefaultTextWithEntitiesLongFieldsModel m20046l() {
            this.f12050j = (DefaultTextWithEntitiesLongFieldsModel) super.a(this.f12050j, 6, DefaultTextWithEntitiesLongFieldsModel.class);
            return this.f12050j;
        }

        @Nullable
        public final String bB_() {
            this.f12051k = super.a(this.f12051k, 7);
            return this.f12051k;
        }

        public static ContextItemFieldsModel m20036a(ContextItemFieldsModel contextItemFieldsModel) {
            if (contextItemFieldsModel == null) {
                return null;
            }
            if (contextItemFieldsModel instanceof ContextItemFieldsModel) {
                return contextItemFieldsModel;
            }
            Builder builder = new Builder();
            builder.f12026a = contextItemFieldsModel.m20039a();
            builder.f12027b = IconModel.m20020a(contextItemFieldsModel.m20040b());
            com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < contextItemFieldsModel.m20041c().size(); i++) {
                builder2.c(ItemLinksModel.m20029a((ItemLinksModel) contextItemFieldsModel.m20041c().get(i)));
            }
            builder.f12028c = builder2.b();
            builder.f12029d = contextItemFieldsModel.m20042d();
            builder.f12030e = contextItemFieldsModel.bA_();
            builder.f12031f = DefaultTextWithEntitiesFieldsModel.m9783a(contextItemFieldsModel.m20043g());
            builder.f12032g = DefaultTextWithEntitiesLongFieldsModel.m9801a(contextItemFieldsModel.bC_());
            builder.f12033h = contextItemFieldsModel.bB_();
            return builder.m20016a();
        }

        public final int jK_() {
            return -1758471761;
        }

        public final GraphQLVisitableModel m20038a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m20044j() != null) {
                IconModel iconModel = (IconModel) graphQLModelMutatingVisitor.b(m20044j());
                if (m20044j() != iconModel) {
                    graphQLVisitableModel = (ContextItemFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12045e = iconModel;
                }
            }
            if (m20041c() != null) {
                com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m20041c(), graphQLModelMutatingVisitor);
                if (a != null) {
                    ContextItemFieldsModel contextItemFieldsModel = (ContextItemFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    contextItemFieldsModel.f12046f = a.b();
                    graphQLVisitableModel = contextItemFieldsModel;
                }
            }
            if (m20045k() != null) {
                DefaultTextWithEntitiesFieldsModel defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m20045k());
                if (m20045k() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (ContextItemFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12049i = defaultTextWithEntitiesFieldsModel;
                }
            }
            if (m20046l() != null) {
                DefaultTextWithEntitiesLongFieldsModel defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) graphQLModelMutatingVisitor.b(m20046l());
                if (m20046l() != defaultTextWithEntitiesLongFieldsModel) {
                    graphQLVisitableModel = (ContextItemFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12050j = defaultTextWithEntitiesLongFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m20037a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m20039a());
            int a = ModelHelper.a(flatBufferBuilder, m20044j());
            int a2 = ModelHelper.a(flatBufferBuilder, m20041c());
            int a3 = flatBufferBuilder.a(m20042d());
            int b2 = flatBufferBuilder.b(bA_());
            int a4 = ModelHelper.a(flatBufferBuilder, m20045k());
            int a5 = ModelHelper.a(flatBufferBuilder, m20046l());
            int b3 = flatBufferBuilder.b(bB_());
            flatBufferBuilder.c(8);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.b(4, b2);
            flatBufferBuilder.b(5, a4);
            flatBufferBuilder.b(6, a5);
            flatBufferBuilder.b(7, b3);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1626123447)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: Zero Campaign is not enabled (uri was  */
    public final class ContextItemsConnectionFragmentModel extends BaseModel implements ContextItemsConnectionFragment, GraphQLVisitableModel {
        @Nullable
        private List<EdgesModel> f12054d;

        /* compiled from: Zero Campaign is not enabled (uri was  */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ContextItemsConnectionFragmentModel.class, new Deserializer());
            }

            public Object m20047a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ContextItemsConnectionFragmentParser.m20107a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object contextItemsConnectionFragmentModel = new ContextItemsConnectionFragmentModel();
                ((BaseModel) contextItemsConnectionFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (contextItemsConnectionFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) contextItemsConnectionFragmentModel).a();
                }
                return contextItemsConnectionFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1287986292)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: Zero Campaign is not enabled (uri was  */
        public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private ContextItemFieldsModel f12053d;

            /* compiled from: Zero Campaign is not enabled (uri was  */
            public final class Builder {
                @Nullable
                public ContextItemFieldsModel f12052a;

                public static Builder m20048a(EdgesModel edgesModel) {
                    Builder builder = new Builder();
                    builder.f12052a = edgesModel.m20056j();
                    return builder;
                }

                public final EdgesModel m20049a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, this.f12052a);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new EdgesModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: Zero Campaign is not enabled (uri was  */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                }

                public Object m20050a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(EdgesParser.m20105b(jsonParser, flatBufferBuilder));
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

            /* compiled from: Zero Campaign is not enabled (uri was  */
            public class Serializer extends JsonSerializer<EdgesModel> {
                public final void m20051a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EdgesModel edgesModel = (EdgesModel) obj;
                    if (edgesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(edgesModel.m20053a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    EdgesParser.m20106b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(EdgesModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ ContextItemFieldsModel m20054a() {
                return m20056j();
            }

            public EdgesModel() {
                super(1);
            }

            public EdgesModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final ContextItemFieldsModel m20056j() {
                this.f12053d = (ContextItemFieldsModel) super.a(this.f12053d, 0, ContextItemFieldsModel.class);
                return this.f12053d;
            }

            public static EdgesModel m20052a(EdgesModel edgesModel) {
                if (edgesModel == null) {
                    return null;
                }
                if (edgesModel instanceof EdgesModel) {
                    return edgesModel;
                }
                Builder builder = new Builder();
                builder.f12052a = ContextItemFieldsModel.m20036a(edgesModel.m20054a());
                return builder.m20049a();
            }

            public final int jK_() {
                return 182799489;
            }

            public final GraphQLVisitableModel m20055a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m20056j() != null) {
                    ContextItemFieldsModel contextItemFieldsModel = (ContextItemFieldsModel) graphQLModelMutatingVisitor.b(m20056j());
                    if (m20056j() != contextItemFieldsModel) {
                        graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f12053d = contextItemFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m20053a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m20056j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: Zero Campaign is not enabled (uri was  */
        public class Serializer extends JsonSerializer<ContextItemsConnectionFragmentModel> {
            public final void m20057a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ContextItemsConnectionFragmentModel contextItemsConnectionFragmentModel = (ContextItemsConnectionFragmentModel) obj;
                if (contextItemsConnectionFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(contextItemsConnectionFragmentModel.m20058a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    contextItemsConnectionFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ContextItemsConnectionFragmentParser.m20108a(contextItemsConnectionFragmentModel.w_(), contextItemsConnectionFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ContextItemsConnectionFragmentModel.class, new Serializer());
            }
        }

        public ContextItemsConnectionFragmentModel() {
            super(1);
        }

        @Nonnull
        public final ImmutableList<EdgesModel> mo1207a() {
            this.f12054d = super.a(this.f12054d, 0, EdgesModel.class);
            return (ImmutableList) this.f12054d;
        }

        public final int jK_() {
            return 1751202466;
        }

        public final GraphQLVisitableModel m20059a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (mo1207a() != null) {
                Builder a = ModelHelper.a(mo1207a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (ContextItemsConnectionFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12054d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m20058a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, mo1207a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1263876682)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: Zero Campaign is not enabled (uri was  */
    public final class ContextItemsConnectionWithPageInfoFragmentModel extends BaseModel implements ContextItemsConnectionFragment, GraphQLVisitableModel {
        @Nullable
        private List<EdgesModel> f12061d;
        @Nullable
        private PageInfoModel f12062e;

        /* compiled from: Zero Campaign is not enabled (uri was  */
        public final class Builder {
            @Nullable
            public ImmutableList<EdgesModel> f12055a;
            @Nullable
            public PageInfoModel f12056b;

            public static Builder m20061a(ContextItemsConnectionWithPageInfoFragmentModel contextItemsConnectionWithPageInfoFragmentModel) {
                Builder builder = new Builder();
                builder.f12055a = contextItemsConnectionWithPageInfoFragmentModel.mo1207a();
                builder.f12056b = contextItemsConnectionWithPageInfoFragmentModel.m20078j();
                return builder;
            }

            public final ContextItemsConnectionWithPageInfoFragmentModel m20062a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f12055a);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f12056b);
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new ContextItemsConnectionWithPageInfoFragmentModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: Zero Campaign is not enabled (uri was  */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ContextItemsConnectionWithPageInfoFragmentModel.class, new Deserializer());
            }

            public Object m20063a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ContextItemsConnectionWithPageInfoFragmentParser.m20111a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object contextItemsConnectionWithPageInfoFragmentModel = new ContextItemsConnectionWithPageInfoFragmentModel();
                ((BaseModel) contextItemsConnectionWithPageInfoFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (contextItemsConnectionWithPageInfoFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) contextItemsConnectionWithPageInfoFragmentModel).a();
                }
                return contextItemsConnectionWithPageInfoFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -2005169142)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: Zero Campaign is not enabled (uri was  */
        public final class PageInfoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f12059d;
            private boolean f12060e;

            /* compiled from: Zero Campaign is not enabled (uri was  */
            public final class Builder {
                @Nullable
                public String f12057a;
                public boolean f12058b;
            }

            /* compiled from: Zero Campaign is not enabled (uri was  */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PageInfoModel.class, new Deserializer());
                }

                public Object m20064a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PageInfoParser.m20109a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object pageInfoModel = new PageInfoModel();
                    ((BaseModel) pageInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (pageInfoModel instanceof Postprocessable) {
                        return ((Postprocessable) pageInfoModel).a();
                    }
                    return pageInfoModel;
                }
            }

            /* compiled from: Zero Campaign is not enabled (uri was  */
            public class Serializer extends JsonSerializer<PageInfoModel> {
                public final void m20065a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PageInfoModel pageInfoModel = (PageInfoModel) obj;
                    if (pageInfoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pageInfoModel.m20067a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pageInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PageInfoParser.m20110a(pageInfoModel.w_(), pageInfoModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PageInfoModel.class, new Serializer());
                }
            }

            public PageInfoModel() {
                super(2);
            }

            public PageInfoModel(MutableFlatBuffer mutableFlatBuffer) {
                super(2);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m20069a() {
                this.f12059d = super.a(this.f12059d, 0);
                return this.f12059d;
            }

            public final boolean m20071b() {
                a(0, 1);
                return this.f12060e;
            }

            public static PageInfoModel m20066a(PageInfoModel pageInfoModel) {
                if (pageInfoModel == null) {
                    return null;
                }
                if (pageInfoModel instanceof PageInfoModel) {
                    return pageInfoModel;
                }
                Builder builder = new Builder();
                builder.f12057a = pageInfoModel.m20069a();
                builder.f12058b = pageInfoModel.m20071b();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f12057a);
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.a(1, builder.f12058b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new PageInfoModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 923779069;
            }

            public final GraphQLVisitableModel m20068a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m20067a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m20069a());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.a(1, this.f12060e);
                i();
                return flatBufferBuilder.d();
            }

            public final void m20070a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f12060e = mutableFlatBuffer.a(i, 1);
            }
        }

        /* compiled from: Zero Campaign is not enabled (uri was  */
        public class Serializer extends JsonSerializer<ContextItemsConnectionWithPageInfoFragmentModel> {
            public final void m20072a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ContextItemsConnectionWithPageInfoFragmentModel contextItemsConnectionWithPageInfoFragmentModel = (ContextItemsConnectionWithPageInfoFragmentModel) obj;
                if (contextItemsConnectionWithPageInfoFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(contextItemsConnectionWithPageInfoFragmentModel.m20074a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    contextItemsConnectionWithPageInfoFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ContextItemsConnectionWithPageInfoFragmentParser.m20112a(contextItemsConnectionWithPageInfoFragmentModel.w_(), contextItemsConnectionWithPageInfoFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ContextItemsConnectionWithPageInfoFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ PageInfoModel m20077b() {
            return m20078j();
        }

        public ContextItemsConnectionWithPageInfoFragmentModel() {
            super(2);
        }

        public ContextItemsConnectionWithPageInfoFragmentModel(MutableFlatBuffer mutableFlatBuffer) {
            super(2);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nonnull
        public final ImmutableList<EdgesModel> mo1207a() {
            this.f12061d = super.a(this.f12061d, 0, EdgesModel.class);
            return (ImmutableList) this.f12061d;
        }

        @Nullable
        public final PageInfoModel m20078j() {
            this.f12062e = (PageInfoModel) super.a(this.f12062e, 1, PageInfoModel.class);
            return this.f12062e;
        }

        public static ContextItemsConnectionWithPageInfoFragmentModel m20073a(ContextItemsConnectionWithPageInfoFragmentModel contextItemsConnectionWithPageInfoFragmentModel) {
            if (contextItemsConnectionWithPageInfoFragmentModel == null) {
                return null;
            }
            if (contextItemsConnectionWithPageInfoFragmentModel instanceof ContextItemsConnectionWithPageInfoFragmentModel) {
                return contextItemsConnectionWithPageInfoFragmentModel;
            }
            Builder builder = new Builder();
            com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < contextItemsConnectionWithPageInfoFragmentModel.mo1207a().size(); i++) {
                builder2.c(EdgesModel.m20052a((EdgesModel) contextItemsConnectionWithPageInfoFragmentModel.mo1207a().get(i)));
            }
            builder.f12055a = builder2.b();
            builder.f12056b = PageInfoModel.m20066a(contextItemsConnectionWithPageInfoFragmentModel.m20077b());
            return builder.m20062a();
        }

        public final int jK_() {
            return 1751202466;
        }

        public final GraphQLVisitableModel m20075a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel;
            PageInfoModel pageInfoModel;
            h();
            if (mo1207a() != null) {
                com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(mo1207a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    ContextItemsConnectionWithPageInfoFragmentModel contextItemsConnectionWithPageInfoFragmentModel = (ContextItemsConnectionWithPageInfoFragmentModel) ModelHelper.a(null, this);
                    contextItemsConnectionWithPageInfoFragmentModel.f12061d = a.b();
                    graphQLVisitableModel = contextItemsConnectionWithPageInfoFragmentModel;
                    if (m20078j() != null) {
                        pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m20078j());
                        if (m20078j() != pageInfoModel) {
                            graphQLVisitableModel = (ContextItemsConnectionWithPageInfoFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f12062e = pageInfoModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m20078j() != null) {
                pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m20078j());
                if (m20078j() != pageInfoModel) {
                    graphQLVisitableModel = (ContextItemsConnectionWithPageInfoFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12062e = pageInfoModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m20074a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, mo1207a());
            int a2 = ModelHelper.a(flatBufferBuilder, m20078j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1755105904)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: Zero Campaign is not enabled (uri was  */
    public final class ContextItemsQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f12063d;
        @Nullable
        private ContextItemsConnectionWithPageInfoFragmentModel f12064e;

        /* compiled from: Zero Campaign is not enabled (uri was  */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ContextItemsQueryModel.class, new Deserializer());
            }

            public Object m20079a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ContextItemsQueryParser.m20113a(jsonParser);
                Object contextItemsQueryModel = new ContextItemsQueryModel();
                ((BaseModel) contextItemsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (contextItemsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) contextItemsQueryModel).a();
                }
                return contextItemsQueryModel;
            }
        }

        /* compiled from: Zero Campaign is not enabled (uri was  */
        public class Serializer extends JsonSerializer<ContextItemsQueryModel> {
            public final void m20080a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ContextItemsQueryModel contextItemsQueryModel = (ContextItemsQueryModel) obj;
                if (contextItemsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(contextItemsQueryModel.m20082a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    contextItemsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = contextItemsQueryModel.w_();
                int u_ = contextItemsQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("entity_card_context_items");
                    ContextItemsConnectionWithPageInfoFragmentParser.m20112a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ContextItemsQueryModel.class, new Serializer());
            }
        }

        public ContextItemsQueryModel() {
            super(2);
        }

        public final void m20085a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m20086a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m20081j() {
            if (this.b != null && this.f12063d == null) {
                this.f12063d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f12063d;
        }

        @Nullable
        public final ContextItemsConnectionWithPageInfoFragmentModel m20083a() {
            this.f12064e = (ContextItemsConnectionWithPageInfoFragmentModel) super.a(this.f12064e, 1, ContextItemsConnectionWithPageInfoFragmentModel.class);
            return this.f12064e;
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m20084a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m20083a() != null) {
                ContextItemsConnectionWithPageInfoFragmentModel contextItemsConnectionWithPageInfoFragmentModel = (ContextItemsConnectionWithPageInfoFragmentModel) graphQLModelMutatingVisitor.b(m20083a());
                if (m20083a() != contextItemsConnectionWithPageInfoFragmentModel) {
                    graphQLVisitableModel = (ContextItemsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12064e = contextItemsConnectionWithPageInfoFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m20082a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m20081j());
            int a2 = ModelHelper.a(flatBufferBuilder, m20083a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1098422116)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: Zero Campaign is not enabled (uri was  */
    public final class FBFullImageFragmentModel extends BaseModel implements GraphQLVisitableModel {
        private int f12070d;
        @Nullable
        private String f12071e;
        private double f12072f;
        @Nullable
        private String f12073g;
        private int f12074h;

        /* compiled from: Zero Campaign is not enabled (uri was  */
        public final class Builder {
            public int f12065a;
            @Nullable
            public String f12066b;
            public double f12067c;
            @Nullable
            public String f12068d;
            public int f12069e;
        }

        /* compiled from: Zero Campaign is not enabled (uri was  */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FBFullImageFragmentModel.class, new Deserializer());
            }

            public Object m20087a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FBFullImageFragmentParser.m20114a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object fBFullImageFragmentModel = new FBFullImageFragmentModel();
                ((BaseModel) fBFullImageFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (fBFullImageFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) fBFullImageFragmentModel).a();
                }
                return fBFullImageFragmentModel;
            }
        }

        /* compiled from: Zero Campaign is not enabled (uri was  */
        public class Serializer extends JsonSerializer<FBFullImageFragmentModel> {
            public final void m20088a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FBFullImageFragmentModel fBFullImageFragmentModel = (FBFullImageFragmentModel) obj;
                if (fBFullImageFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fBFullImageFragmentModel.m20091a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fBFullImageFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FBFullImageFragmentParser.m20115a(fBFullImageFragmentModel.w_(), fBFullImageFragmentModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(FBFullImageFragmentModel.class, new Serializer());
            }
        }

        public FBFullImageFragmentModel() {
            super(5);
        }

        public FBFullImageFragmentModel(MutableFlatBuffer mutableFlatBuffer) {
            super(5);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final int m20090a() {
            a(0, 0);
            return this.f12070d;
        }

        @Nullable
        public final String m20094b() {
            this.f12071e = super.a(this.f12071e, 1);
            return this.f12071e;
        }

        public final double m20095c() {
            a(0, 2);
            return this.f12072f;
        }

        @Nullable
        public final String m20096d() {
            this.f12073g = super.a(this.f12073g, 3);
            return this.f12073g;
        }

        public final int bD_() {
            a(0, 4);
            return this.f12074h;
        }

        public static FBFullImageFragmentModel m20089a(FBFullImageFragmentModel fBFullImageFragmentModel) {
            if (fBFullImageFragmentModel == null) {
                return null;
            }
            if (fBFullImageFragmentModel instanceof FBFullImageFragmentModel) {
                return fBFullImageFragmentModel;
            }
            Builder builder = new Builder();
            builder.f12065a = fBFullImageFragmentModel.m20090a();
            builder.f12066b = fBFullImageFragmentModel.m20094b();
            builder.f12067c = fBFullImageFragmentModel.m20095c();
            builder.f12068d = fBFullImageFragmentModel.m20096d();
            builder.f12069e = fBFullImageFragmentModel.bD_();
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int b = flatBufferBuilder.b(builder.f12066b);
            int b2 = flatBufferBuilder.b(builder.f12068d);
            flatBufferBuilder.c(5);
            flatBufferBuilder.a(0, builder.f12065a, 0);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.a(2, builder.f12067c, 0.0d);
            flatBufferBuilder.b(3, b2);
            flatBufferBuilder.a(4, builder.f12069e, 0);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new FBFullImageFragmentModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        public final int jK_() {
            return 70760763;
        }

        public final GraphQLVisitableModel m20092a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m20091a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m20094b());
            int b2 = flatBufferBuilder.b(m20096d());
            flatBufferBuilder.c(5);
            flatBufferBuilder.a(0, this.f12070d, 0);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.a(2, this.f12072f, 0.0d);
            flatBufferBuilder.b(3, b2);
            flatBufferBuilder.a(4, this.f12074h, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m20093a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f12070d = mutableFlatBuffer.a(i, 0, 0);
            this.f12072f = mutableFlatBuffer.a(i, 2, 0.0d);
            this.f12074h = mutableFlatBuffer.a(i, 4, 0);
        }
    }
}

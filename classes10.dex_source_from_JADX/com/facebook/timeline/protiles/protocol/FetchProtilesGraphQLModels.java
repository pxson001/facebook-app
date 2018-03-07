package com.facebook.timeline.protiles.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLProfileTileSectionType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultVect2Fields;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultVect2FieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.photos.data.protocol.PhotosDefaultsGraphQLInterfaces.SizeAwareMedia;
import com.facebook.timeline.protiles.protocol.FetchProtilesGraphQLParsers.ProtileItemFieldsParser;
import com.facebook.timeline.protiles.protocol.FetchProtilesGraphQLParsers.ProtileItemFieldsParser.CollageLayoutParser;
import com.facebook.timeline.protiles.protocol.FetchProtilesGraphQLParsers.ProtileItemFieldsParser.NodeParser;
import com.facebook.timeline.protiles.protocol.FetchProtilesGraphQLParsers.ProtileItemFieldsParser.SubtitleParser;
import com.facebook.timeline.protiles.protocol.FetchProtilesGraphQLParsers.ProtileItemFieldsParser.TitleParser;
import com.facebook.timeline.protiles.protocol.FetchProtilesGraphQLParsers.ProtileItemsConnectionFieldsParser;
import com.facebook.timeline.protiles.protocol.FetchProtilesGraphQLParsers.ProtileSectionFieldsParser;
import com.facebook.timeline.protiles.protocol.FetchProtilesGraphQLParsers.ProtileSectionFieldsParser.FooterParser;
import com.facebook.timeline.protiles.protocol.FetchProtilesGraphQLParsers.ProtileSectionFieldsParser.IconImageParser;
import com.facebook.timeline.protiles.protocol.FetchProtilesGraphQLParsers.ProtileSectionsConnectionFieldsParser;
import com.facebook.timeline.protiles.protocol.FetchProtilesGraphQLParsers.ProtileViewFieldsParser;
import com.facebook.timeline.protiles.protocol.FetchProtilesGraphQLParsers.ProtileViewFieldsParser.ViewMediasetParser;
import com.facebook.timeline.protiles.protocol.FetchProtilesGraphQLParsers.ProtileViewsConnectionFieldsParser;
import com.facebook.timeline.protiles.protocol.FetchProtilesGraphQLParsers.TimelineProtilesQueryParser;
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

/* compiled from: featured_photos_suggestions */
public class FetchProtilesGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1325155112)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: featured_photos_suggestions */
    public final class ProtileItemFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private CollageLayoutModel f12163d;
        @Nullable
        private NodeModel f12164e;
        @Nullable
        private SubtitleModel f12165f;
        @Nullable
        private TitleModel f12166g;

        /* compiled from: featured_photos_suggestions */
        public final class Builder {
            @Nullable
            public CollageLayoutModel f12127a;
            @Nullable
            public NodeModel f12128b;
            @Nullable
            public SubtitleModel f12129c;
            @Nullable
            public TitleModel f12130d;

            public final ProtileItemFieldsModel m12128a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f12127a);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f12128b);
                int a3 = ModelHelper.a(flatBufferBuilder, this.f12129c);
                int a4 = ModelHelper.a(flatBufferBuilder, this.f12130d);
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                flatBufferBuilder.b(3, a4);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new ProtileItemFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 611352277)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: featured_photos_suggestions */
        public final class CollageLayoutModel extends BaseModel implements GraphQLVisitableModel {
            private double f12131d;
            private double f12132e;
            private double f12133f;
            private double f12134g;

            /* compiled from: featured_photos_suggestions */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CollageLayoutModel.class, new Deserializer());
                }

                public Object m12129a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CollageLayoutParser.m12254a(r11, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object collageLayoutModel = new CollageLayoutModel();
                    ((BaseModel) collageLayoutModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), r11);
                    if (collageLayoutModel instanceof Postprocessable) {
                        return ((Postprocessable) collageLayoutModel).a();
                    }
                    return collageLayoutModel;
                }
            }

            /* compiled from: featured_photos_suggestions */
            public class Serializer extends JsonSerializer<CollageLayoutModel> {
                public final void m12130a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CollageLayoutModel collageLayoutModel = (CollageLayoutModel) r8;
                    if (collageLayoutModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(collageLayoutModel.m12132a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        collageLayoutModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CollageLayoutParser.m12255a(collageLayoutModel.w_(), collageLayoutModel.u_(), r9);
                }

                static {
                    FbSerializerProvider.a(CollageLayoutModel.class, new Serializer());
                }
            }

            public CollageLayoutModel() {
                super(4);
            }

            public final double m12131a() {
                a(0, 0);
                return this.f12131d;
            }

            public final double m12135b() {
                a(0, 1);
                return this.f12132e;
            }

            public final double m12136c() {
                a(0, 2);
                return this.f12133f;
            }

            public final double m12137d() {
                a(0, 3);
                return this.f12134g;
            }

            public final int jK_() {
                return -1169699505;
            }

            public final GraphQLVisitableModel m12133a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m12132a(FlatBufferBuilder flatBufferBuilder) {
                h();
                r7.c(4);
                r7.a(0, this.f12131d, 0.0d);
                r7.a(1, this.f12132e, 0.0d);
                r7.a(2, this.f12133f, 0.0d);
                r7.a(3, this.f12134g, 0.0d);
                i();
                return r7.d();
            }

            public final void m12134a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(r5, r6, r7);
                this.f12131d = r5.a(r6, 0, 0.0d);
                this.f12132e = r5.a(r6, 1, 0.0d);
                this.f12133f = r5.a(r6, 2, 0.0d);
                this.f12134g = r5.a(r6, 3, 0.0d);
            }
        }

        /* compiled from: featured_photos_suggestions */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ProtileItemFieldsModel.class, new Deserializer());
            }

            public Object m12138a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ProtileItemFieldsParser.m12262b(r11, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object protileItemFieldsModel = new ProtileItemFieldsModel();
                ((BaseModel) protileItemFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), r11);
                if (protileItemFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) protileItemFieldsModel).a();
                }
                return protileItemFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1941696775)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: featured_photos_suggestions */
        public final class NodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, SizeAwareMedia {
            @Nullable
            private GraphQLObjectType f12148d;
            @Nullable
            private String f12149e;
            @Nullable
            private DefaultImageFieldsModel f12150f;
            @Nullable
            private String f12151g;
            @Nullable
            private DefaultVect2FieldsModel f12152h;
            @Nullable
            private GraphQLFriendshipStatus f12153i;
            @Nullable
            private String f12154j;
            @Nullable
            private DefaultImageFieldsModel f12155k;
            @Nullable
            private DefaultImageFieldsModel f12156l;
            @Nullable
            private DefaultImageFieldsModel f12157m;
            @Nullable
            private DefaultImageFieldsModel f12158n;
            @Nullable
            private DefaultImageFieldsModel f12159o;
            private int f12160p;

            /* compiled from: featured_photos_suggestions */
            public final class Builder {
                @Nullable
                public GraphQLObjectType f12135a;
                @Nullable
                public String f12136b;
                @Nullable
                public DefaultImageFieldsModel f12137c;
                @Nullable
                public String f12138d;
                @Nullable
                public DefaultVect2FieldsModel f12139e;
                @Nullable
                public GraphQLFriendshipStatus f12140f;
                @Nullable
                public String f12141g;
                @Nullable
                public DefaultImageFieldsModel f12142h;
                @Nullable
                public DefaultImageFieldsModel f12143i;
                @Nullable
                public DefaultImageFieldsModel f12144j;
                @Nullable
                public DefaultImageFieldsModel f12145k;
                @Nullable
                public DefaultImageFieldsModel f12146l;
                public int f12147m;

                public final NodeModel m12139a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, this.f12135a);
                    int b = flatBufferBuilder.b(this.f12136b);
                    int a2 = ModelHelper.a(flatBufferBuilder, this.f12137c);
                    int b2 = flatBufferBuilder.b(this.f12138d);
                    int a3 = ModelHelper.a(flatBufferBuilder, this.f12139e);
                    int a4 = flatBufferBuilder.a(this.f12140f);
                    int b3 = flatBufferBuilder.b(this.f12141g);
                    int a5 = ModelHelper.a(flatBufferBuilder, this.f12142h);
                    int a6 = ModelHelper.a(flatBufferBuilder, this.f12143i);
                    int a7 = ModelHelper.a(flatBufferBuilder, this.f12144j);
                    int a8 = ModelHelper.a(flatBufferBuilder, this.f12145k);
                    int a9 = ModelHelper.a(flatBufferBuilder, this.f12146l);
                    flatBufferBuilder.c(13);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.b(2, a2);
                    flatBufferBuilder.b(3, b2);
                    flatBufferBuilder.b(4, a3);
                    flatBufferBuilder.b(5, a4);
                    flatBufferBuilder.b(6, b3);
                    flatBufferBuilder.b(7, a5);
                    flatBufferBuilder.b(8, a6);
                    flatBufferBuilder.b(9, a7);
                    flatBufferBuilder.b(10, a8);
                    flatBufferBuilder.b(11, a9);
                    flatBufferBuilder.a(12, this.f12147m, 0);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new NodeModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: featured_photos_suggestions */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                }

                public Object m12140a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(NodeParser.m12256a(r11, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object nodeModel = new NodeModel();
                    ((BaseModel) nodeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), r11);
                    if (nodeModel instanceof Postprocessable) {
                        return ((Postprocessable) nodeModel).a();
                    }
                    return nodeModel;
                }
            }

            /* compiled from: featured_photos_suggestions */
            public class Serializer extends JsonSerializer<NodeModel> {
                public final void m12141a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    NodeModel nodeModel = (NodeModel) r8;
                    if (nodeModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(nodeModel.m12143a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    NodeParser.m12257a(nodeModel.w_(), nodeModel.u_(), r9, r10);
                }

                static {
                    FbSerializerProvider.a(NodeModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ DefaultImageFields bc_() {
                return m12164u();
            }

            @Nullable
            public final /* synthetic */ DefaultImageFields bd_() {
                return m12163t();
            }

            @Nullable
            public final /* synthetic */ DefaultImageFields be_() {
                return m12161r();
            }

            @Nullable
            public final /* synthetic */ DefaultVect2Fields m12150c() {
                return m12160q();
            }

            @Nullable
            public final /* synthetic */ DefaultImageFields m12152g() {
                return m12162s();
            }

            @Nullable
            public final /* synthetic */ DefaultImageFields m12154k() {
                return m12159p();
            }

            @Nullable
            public final /* synthetic */ DefaultImageFields m12157n() {
                return m12165v();
            }

            public NodeModel() {
                super(13);
            }

            public NodeModel(MutableFlatBuffer mutableFlatBuffer) {
                super(13);
                a(r3, FlatBuffer.a(r3.a));
            }

            public final void m12147a(String str, ConsistencyTuple consistencyTuple) {
                if ("friendship_status".equals(r2)) {
                    r3.a = m12156m();
                    r3.b = u_();
                    r3.c = 5;
                    return;
                }
                r3.a();
            }

            public final void m12148a(String str, Object obj, boolean z) {
                if ("friendship_status".equals(r2)) {
                    m12142a((GraphQLFriendshipStatus) r3);
                }
            }

            @Nullable
            public final GraphQLObjectType m12149b() {
                if (this.b != null && this.f12148d == null) {
                    this.f12148d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f12148d;
            }

            @Nullable
            public final String m12153j() {
                this.f12149e = super.a(this.f12149e, 1);
                return this.f12149e;
            }

            @Nullable
            public final DefaultImageFieldsModel m12159p() {
                this.f12150f = (DefaultImageFieldsModel) super.a(this.f12150f, 2, DefaultImageFieldsModel.class);
                return this.f12150f;
            }

            @Nullable
            public final String m12155l() {
                this.f12151g = super.a(this.f12151g, 3);
                return this.f12151g;
            }

            @Nullable
            public final DefaultVect2FieldsModel m12160q() {
                this.f12152h = (DefaultVect2FieldsModel) super.a(this.f12152h, 4, DefaultVect2FieldsModel.class);
                return this.f12152h;
            }

            @Nullable
            public final GraphQLFriendshipStatus m12156m() {
                this.f12153i = (GraphQLFriendshipStatus) super.b(this.f12153i, 5, GraphQLFriendshipStatus.class, GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f12153i;
            }

            private void m12142a(GraphQLFriendshipStatus graphQLFriendshipStatus) {
                this.f12153i = r6;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 5, r6 != null ? r6.name() : null);
                }
            }

            @Nullable
            public final String m12151d() {
                this.f12154j = super.a(this.f12154j, 6);
                return this.f12154j;
            }

            @Nullable
            public final DefaultImageFieldsModel m12161r() {
                this.f12155k = (DefaultImageFieldsModel) super.a(this.f12155k, 7, DefaultImageFieldsModel.class);
                return this.f12155k;
            }

            @Nullable
            public final DefaultImageFieldsModel m12162s() {
                this.f12156l = (DefaultImageFieldsModel) super.a(this.f12156l, 8, DefaultImageFieldsModel.class);
                return this.f12156l;
            }

            @Nullable
            public final DefaultImageFieldsModel m12163t() {
                this.f12157m = (DefaultImageFieldsModel) super.a(this.f12157m, 9, DefaultImageFieldsModel.class);
                return this.f12157m;
            }

            @Nullable
            public final DefaultImageFieldsModel m12164u() {
                this.f12158n = (DefaultImageFieldsModel) super.a(this.f12158n, 10, DefaultImageFieldsModel.class);
                return this.f12158n;
            }

            @Nullable
            public final DefaultImageFieldsModel m12165v() {
                this.f12159o = (DefaultImageFieldsModel) super.a(this.f12159o, 11, DefaultImageFieldsModel.class);
                return this.f12159o;
            }

            public final int m12158o() {
                a(1, 4);
                return this.f12160p;
            }

            @Nullable
            public final String m12145a() {
                return m12151d();
            }

            public final int jK_() {
                return 2433570;
            }

            public final GraphQLVisitableModel m12144a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                DefaultImageFieldsModel defaultImageFieldsModel;
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m12159p() != null) {
                    defaultImageFieldsModel = (DefaultImageFieldsModel) r4.b(m12159p());
                    if (m12159p() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f12150f = defaultImageFieldsModel;
                    }
                }
                if (m12160q() != null) {
                    DefaultVect2FieldsModel defaultVect2FieldsModel = (DefaultVect2FieldsModel) r4.b(m12160q());
                    if (m12160q() != defaultVect2FieldsModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f12152h = defaultVect2FieldsModel;
                    }
                }
                if (m12161r() != null) {
                    defaultImageFieldsModel = (DefaultImageFieldsModel) r4.b(m12161r());
                    if (m12161r() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f12155k = defaultImageFieldsModel;
                    }
                }
                if (m12162s() != null) {
                    defaultImageFieldsModel = (DefaultImageFieldsModel) r4.b(m12162s());
                    if (m12162s() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f12156l = defaultImageFieldsModel;
                    }
                }
                if (m12163t() != null) {
                    defaultImageFieldsModel = (DefaultImageFieldsModel) r4.b(m12163t());
                    if (m12163t() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f12157m = defaultImageFieldsModel;
                    }
                }
                if (m12164u() != null) {
                    defaultImageFieldsModel = (DefaultImageFieldsModel) r4.b(m12164u());
                    if (m12164u() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f12158n = defaultImageFieldsModel;
                    }
                }
                if (m12165v() != null) {
                    defaultImageFieldsModel = (DefaultImageFieldsModel) r4.b(m12165v());
                    if (m12165v() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f12159o = defaultImageFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m12143a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(r15, m12149b());
                int b = r15.b(m12153j());
                int a2 = ModelHelper.a(r15, m12159p());
                int b2 = r15.b(m12155l());
                int a3 = ModelHelper.a(r15, m12160q());
                int a4 = r15.a(m12156m());
                int b3 = r15.b(m12151d());
                int a5 = ModelHelper.a(r15, m12161r());
                int a6 = ModelHelper.a(r15, m12162s());
                int a7 = ModelHelper.a(r15, m12163t());
                int a8 = ModelHelper.a(r15, m12164u());
                int a9 = ModelHelper.a(r15, m12165v());
                r15.c(13);
                r15.b(0, a);
                r15.b(1, b);
                r15.b(2, a2);
                r15.b(3, b2);
                r15.b(4, a3);
                r15.b(5, a4);
                r15.b(6, b3);
                r15.b(7, a5);
                r15.b(8, a6);
                r15.b(9, a7);
                r15.b(10, a8);
                r15.b(11, a9);
                r15.a(12, this.f12160p, 0);
                i();
                return r15.d();
            }

            public final void m12146a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(r3, r4, r5);
                this.f12160p = r3.a(r4, 12, 0);
            }
        }

        /* compiled from: featured_photos_suggestions */
        public class Serializer extends JsonSerializer<ProtileItemFieldsModel> {
            public final void m12166a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ProtileItemFieldsModel protileItemFieldsModel = (ProtileItemFieldsModel) r8;
                if (protileItemFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(protileItemFieldsModel.m12177a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    protileItemFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ProtileItemFieldsParser.m12263b(protileItemFieldsModel.w_(), protileItemFieldsModel.u_(), r9, r10);
            }

            static {
                FbSerializerProvider.a(ProtileItemFieldsModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: featured_photos_suggestions */
        public final class SubtitleModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f12161d;

            /* compiled from: featured_photos_suggestions */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SubtitleModel.class, new Deserializer());
                }

                public Object m12167a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SubtitleParser.m12258a(r11, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object subtitleModel = new SubtitleModel();
                    ((BaseModel) subtitleModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), r11);
                    if (subtitleModel instanceof Postprocessable) {
                        return ((Postprocessable) subtitleModel).a();
                    }
                    return subtitleModel;
                }
            }

            /* compiled from: featured_photos_suggestions */
            public class Serializer extends JsonSerializer<SubtitleModel> {
                public final void m12168a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SubtitleModel subtitleModel = (SubtitleModel) r8;
                    if (subtitleModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(subtitleModel.m12169a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        subtitleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SubtitleParser.m12259a(subtitleModel.w_(), subtitleModel.u_(), r9);
                }

                static {
                    FbSerializerProvider.a(SubtitleModel.class, new Serializer());
                }
            }

            public SubtitleModel() {
                super(1);
            }

            @Nullable
            public final String m12171a() {
                this.f12161d = super.a(this.f12161d, 0);
                return this.f12161d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m12170a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m12169a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = r3.b(m12171a());
                r3.c(1);
                r3.b(0, b);
                i();
                return r3.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: featured_photos_suggestions */
        public final class TitleModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f12162d;

            /* compiled from: featured_photos_suggestions */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TitleModel.class, new Deserializer());
                }

                public Object m12172a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TitleParser.m12260a(r11, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object titleModel = new TitleModel();
                    ((BaseModel) titleModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), r11);
                    if (titleModel instanceof Postprocessable) {
                        return ((Postprocessable) titleModel).a();
                    }
                    return titleModel;
                }
            }

            /* compiled from: featured_photos_suggestions */
            public class Serializer extends JsonSerializer<TitleModel> {
                public final void m12173a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TitleModel titleModel = (TitleModel) r8;
                    if (titleModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(titleModel.m12174a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        titleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TitleParser.m12261a(titleModel.w_(), titleModel.u_(), r9);
                }

                static {
                    FbSerializerProvider.a(TitleModel.class, new Serializer());
                }
            }

            public TitleModel() {
                super(1);
            }

            @Nullable
            public final String m12176a() {
                this.f12162d = super.a(this.f12162d, 0);
                return this.f12162d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m12175a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m12174a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = r3.b(m12176a());
                r3.c(1);
                r3.b(0, b);
                i();
                return r3.d();
            }
        }

        @Nullable
        public final /* synthetic */ CollageLayoutModel m12179a() {
            return m12183j();
        }

        @Nullable
        public final /* synthetic */ NodeModel m12180b() {
            return m12184k();
        }

        @Nullable
        public final /* synthetic */ SubtitleModel m12181c() {
            return m12185l();
        }

        @Nullable
        public final /* synthetic */ TitleModel m12182d() {
            return m12186m();
        }

        public ProtileItemFieldsModel() {
            super(4);
        }

        public ProtileItemFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(4);
            a(r3, FlatBuffer.a(r3.a));
        }

        @Nullable
        public final CollageLayoutModel m12183j() {
            this.f12163d = (CollageLayoutModel) super.a(this.f12163d, 0, CollageLayoutModel.class);
            return this.f12163d;
        }

        @Nullable
        public final NodeModel m12184k() {
            this.f12164e = (NodeModel) super.a(this.f12164e, 1, NodeModel.class);
            return this.f12164e;
        }

        @Nullable
        public final SubtitleModel m12185l() {
            this.f12165f = (SubtitleModel) super.a(this.f12165f, 2, SubtitleModel.class);
            return this.f12165f;
        }

        @Nullable
        public final TitleModel m12186m() {
            this.f12166g = (TitleModel) super.a(this.f12166g, 3, TitleModel.class);
            return this.f12166g;
        }

        public final int jK_() {
            return 1258563466;
        }

        public final GraphQLVisitableModel m12178a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m12183j() != null) {
                CollageLayoutModel collageLayoutModel = (CollageLayoutModel) r4.b(m12183j());
                if (m12183j() != collageLayoutModel) {
                    graphQLVisitableModel = (ProtileItemFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12163d = collageLayoutModel;
                }
            }
            if (m12184k() != null) {
                NodeModel nodeModel = (NodeModel) r4.b(m12184k());
                if (m12184k() != nodeModel) {
                    graphQLVisitableModel = (ProtileItemFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12164e = nodeModel;
                }
            }
            if (m12185l() != null) {
                SubtitleModel subtitleModel = (SubtitleModel) r4.b(m12185l());
                if (m12185l() != subtitleModel) {
                    graphQLVisitableModel = (ProtileItemFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12165f = subtitleModel;
                }
            }
            if (m12186m() != null) {
                TitleModel titleModel = (TitleModel) r4.b(m12186m());
                if (m12186m() != titleModel) {
                    graphQLVisitableModel = (ProtileItemFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12166g = titleModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m12177a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(r6, m12183j());
            int a2 = ModelHelper.a(r6, m12184k());
            int a3 = ModelHelper.a(r6, m12185l());
            int a4 = ModelHelper.a(r6, m12186m());
            r6.c(4);
            r6.b(0, a);
            r6.b(1, a2);
            r6.b(2, a3);
            r6.b(3, a4);
            i();
            return r6.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1665477227)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: featured_photos_suggestions */
    public final class ProtileItemsConnectionFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<ProtileItemFieldsModel> f12167d;

        /* compiled from: featured_photos_suggestions */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ProtileItemsConnectionFieldsModel.class, new Deserializer());
            }

            public Object m12187a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ProtileItemsConnectionFieldsParser.m12264a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object protileItemsConnectionFieldsModel = new ProtileItemsConnectionFieldsModel();
                ((BaseModel) protileItemsConnectionFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (protileItemsConnectionFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) protileItemsConnectionFieldsModel).a();
                }
                return protileItemsConnectionFieldsModel;
            }
        }

        /* compiled from: featured_photos_suggestions */
        public class Serializer extends JsonSerializer<ProtileItemsConnectionFieldsModel> {
            public final void m12188a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ProtileItemsConnectionFieldsModel protileItemsConnectionFieldsModel = (ProtileItemsConnectionFieldsModel) obj;
                if (protileItemsConnectionFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(protileItemsConnectionFieldsModel.m12189a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    protileItemsConnectionFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ProtileItemsConnectionFieldsParser.m12265a(protileItemsConnectionFieldsModel.w_(), protileItemsConnectionFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ProtileItemsConnectionFieldsModel.class, new Serializer());
            }
        }

        public ProtileItemsConnectionFieldsModel() {
            super(1);
        }

        @Nonnull
        public final ImmutableList<ProtileItemFieldsModel> m12191a() {
            this.f12167d = super.a(this.f12167d, 0, ProtileItemFieldsModel.class);
            return (ImmutableList) this.f12167d;
        }

        public final int jK_() {
            return -876395033;
        }

        public final GraphQLVisitableModel m12190a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m12191a() != null) {
                Builder a = ModelHelper.a(m12191a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (ProtileItemsConnectionFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12167d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m12189a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m12191a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2008003754)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: featured_photos_suggestions */
    public final class ProtileSectionFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private FooterModel f12172d;
        @Nullable
        private IconImageModel f12173e;
        @Nullable
        private GraphQLProfileTileSectionType f12174f;
        @Nullable
        private ProtileViewsConnectionFieldsModel f12175g;
        @Nullable
        private SubtitleModel f12176h;
        @Nullable
        private TitleModel f12177i;

        /* compiled from: featured_photos_suggestions */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ProtileSectionFieldsModel.class, new Deserializer());
            }

            public Object m12192a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ProtileSectionFieldsParser.m12274b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object protileSectionFieldsModel = new ProtileSectionFieldsModel();
                ((BaseModel) protileSectionFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (protileSectionFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) protileSectionFieldsModel).a();
                }
                return protileSectionFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: featured_photos_suggestions */
        public final class FooterModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f12168d;

            /* compiled from: featured_photos_suggestions */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FooterModel.class, new Deserializer());
                }

                public Object m12193a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FooterParser.m12266a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object footerModel = new FooterModel();
                    ((BaseModel) footerModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (footerModel instanceof Postprocessable) {
                        return ((Postprocessable) footerModel).a();
                    }
                    return footerModel;
                }
            }

            /* compiled from: featured_photos_suggestions */
            public class Serializer extends JsonSerializer<FooterModel> {
                public final void m12194a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FooterModel footerModel = (FooterModel) obj;
                    if (footerModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(footerModel.m12195a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        footerModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FooterParser.m12267a(footerModel.w_(), footerModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(FooterModel.class, new Serializer());
                }
            }

            public FooterModel() {
                super(1);
            }

            @Nullable
            public final String m12197a() {
                this.f12168d = super.a(this.f12168d, 0);
                return this.f12168d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m12196a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m12195a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m12197a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: featured_photos_suggestions */
        public final class IconImageModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f12169d;

            /* compiled from: featured_photos_suggestions */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(IconImageModel.class, new Deserializer());
                }

                public Object m12198a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(IconImageParser.m12268a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object iconImageModel = new IconImageModel();
                    ((BaseModel) iconImageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (iconImageModel instanceof Postprocessable) {
                        return ((Postprocessable) iconImageModel).a();
                    }
                    return iconImageModel;
                }
            }

            /* compiled from: featured_photos_suggestions */
            public class Serializer extends JsonSerializer<IconImageModel> {
                public final void m12199a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    IconImageModel iconImageModel = (IconImageModel) obj;
                    if (iconImageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(iconImageModel.m12200a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        iconImageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    IconImageParser.m12269a(iconImageModel.w_(), iconImageModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(IconImageModel.class, new Serializer());
                }
            }

            public IconImageModel() {
                super(1);
            }

            @Nullable
            public final String m12202a() {
                this.f12169d = super.a(this.f12169d, 0);
                return this.f12169d;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m12201a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m12200a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m12202a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: featured_photos_suggestions */
        public class Serializer extends JsonSerializer<ProtileSectionFieldsModel> {
            public final void m12203a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ProtileSectionFieldsModel protileSectionFieldsModel = (ProtileSectionFieldsModel) obj;
                if (protileSectionFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(protileSectionFieldsModel.m12214a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    protileSectionFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ProtileSectionFieldsParser.m12275b(protileSectionFieldsModel.w_(), protileSectionFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ProtileSectionFieldsModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: featured_photos_suggestions */
        public final class SubtitleModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f12170d;

            /* compiled from: featured_photos_suggestions */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SubtitleModel.class, new Deserializer());
                }

                public Object m12204a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ProtileSectionFieldsParser.SubtitleParser.m12270a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object subtitleModel = new SubtitleModel();
                    ((BaseModel) subtitleModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (subtitleModel instanceof Postprocessable) {
                        return ((Postprocessable) subtitleModel).a();
                    }
                    return subtitleModel;
                }
            }

            /* compiled from: featured_photos_suggestions */
            public class Serializer extends JsonSerializer<SubtitleModel> {
                public final void m12205a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SubtitleModel subtitleModel = (SubtitleModel) obj;
                    if (subtitleModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(subtitleModel.m12206a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        subtitleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ProtileSectionFieldsParser.SubtitleParser.m12271a(subtitleModel.w_(), subtitleModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(SubtitleModel.class, new Serializer());
                }
            }

            public SubtitleModel() {
                super(1);
            }

            @Nullable
            public final String m12208a() {
                this.f12170d = super.a(this.f12170d, 0);
                return this.f12170d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m12207a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m12206a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m12208a());
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
        /* compiled from: featured_photos_suggestions */
        public final class TitleModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f12171d;

            /* compiled from: featured_photos_suggestions */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TitleModel.class, new Deserializer());
                }

                public Object m12209a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ProtileSectionFieldsParser.TitleParser.m12272a(jsonParser, flatBufferBuilder));
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

            /* compiled from: featured_photos_suggestions */
            public class Serializer extends JsonSerializer<TitleModel> {
                public final void m12210a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TitleModel titleModel = (TitleModel) obj;
                    if (titleModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(titleModel.m12211a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        titleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ProtileSectionFieldsParser.TitleParser.m12273a(titleModel.w_(), titleModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(TitleModel.class, new Serializer());
                }
            }

            public TitleModel() {
                super(1);
            }

            @Nullable
            public final String m12213a() {
                this.f12171d = super.a(this.f12171d, 0);
                return this.f12171d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m12212a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m12211a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m12213a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        public ProtileSectionFieldsModel() {
            super(6);
        }

        @Nullable
        public final FooterModel m12216a() {
            this.f12172d = (FooterModel) super.a(this.f12172d, 0, FooterModel.class);
            return this.f12172d;
        }

        @Nullable
        public final IconImageModel m12217j() {
            this.f12173e = (IconImageModel) super.a(this.f12173e, 1, IconImageModel.class);
            return this.f12173e;
        }

        @Nullable
        public final GraphQLProfileTileSectionType m12218k() {
            this.f12174f = (GraphQLProfileTileSectionType) super.b(this.f12174f, 2, GraphQLProfileTileSectionType.class, GraphQLProfileTileSectionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f12174f;
        }

        @Nullable
        public final ProtileViewsConnectionFieldsModel m12219l() {
            this.f12175g = (ProtileViewsConnectionFieldsModel) super.a(this.f12175g, 3, ProtileViewsConnectionFieldsModel.class);
            return this.f12175g;
        }

        @Nullable
        public final SubtitleModel m12220m() {
            this.f12176h = (SubtitleModel) super.a(this.f12176h, 4, SubtitleModel.class);
            return this.f12176h;
        }

        @Nullable
        public final TitleModel m12221n() {
            this.f12177i = (TitleModel) super.a(this.f12177i, 5, TitleModel.class);
            return this.f12177i;
        }

        public final int jK_() {
            return -1346147570;
        }

        public final GraphQLVisitableModel m12215a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m12216a() != null) {
                FooterModel footerModel = (FooterModel) graphQLModelMutatingVisitor.b(m12216a());
                if (m12216a() != footerModel) {
                    graphQLVisitableModel = (ProtileSectionFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12172d = footerModel;
                }
            }
            if (m12217j() != null) {
                IconImageModel iconImageModel = (IconImageModel) graphQLModelMutatingVisitor.b(m12217j());
                if (m12217j() != iconImageModel) {
                    graphQLVisitableModel = (ProtileSectionFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12173e = iconImageModel;
                }
            }
            if (m12219l() != null) {
                ProtileViewsConnectionFieldsModel protileViewsConnectionFieldsModel = (ProtileViewsConnectionFieldsModel) graphQLModelMutatingVisitor.b(m12219l());
                if (m12219l() != protileViewsConnectionFieldsModel) {
                    graphQLVisitableModel = (ProtileSectionFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12175g = protileViewsConnectionFieldsModel;
                }
            }
            if (m12220m() != null) {
                SubtitleModel subtitleModel = (SubtitleModel) graphQLModelMutatingVisitor.b(m12220m());
                if (m12220m() != subtitleModel) {
                    graphQLVisitableModel = (ProtileSectionFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12176h = subtitleModel;
                }
            }
            if (m12221n() != null) {
                TitleModel titleModel = (TitleModel) graphQLModelMutatingVisitor.b(m12221n());
                if (m12221n() != titleModel) {
                    graphQLVisitableModel = (ProtileSectionFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12177i = titleModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m12214a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m12216a());
            int a2 = ModelHelper.a(flatBufferBuilder, m12217j());
            int a3 = flatBufferBuilder.a(m12218k());
            int a4 = ModelHelper.a(flatBufferBuilder, m12219l());
            int a5 = ModelHelper.a(flatBufferBuilder, m12220m());
            int a6 = ModelHelper.a(flatBufferBuilder, m12221n());
            flatBufferBuilder.c(6);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, a4);
            flatBufferBuilder.b(4, a5);
            flatBufferBuilder.b(5, a6);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -661402051)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: featured_photos_suggestions */
    public final class ProtileSectionsConnectionFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<ProtileSectionFieldsModel> f12178d;

        /* compiled from: featured_photos_suggestions */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ProtileSectionsConnectionFieldsModel.class, new Deserializer());
            }

            public Object m12222a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ProtileSectionsConnectionFieldsParser.m12276a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object protileSectionsConnectionFieldsModel = new ProtileSectionsConnectionFieldsModel();
                ((BaseModel) protileSectionsConnectionFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (protileSectionsConnectionFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) protileSectionsConnectionFieldsModel).a();
                }
                return protileSectionsConnectionFieldsModel;
            }
        }

        /* compiled from: featured_photos_suggestions */
        public class Serializer extends JsonSerializer<ProtileSectionsConnectionFieldsModel> {
            public final void m12223a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ProtileSectionsConnectionFieldsModel protileSectionsConnectionFieldsModel = (ProtileSectionsConnectionFieldsModel) obj;
                if (protileSectionsConnectionFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(protileSectionsConnectionFieldsModel.m12224a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    protileSectionsConnectionFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ProtileSectionsConnectionFieldsParser.m12277a(protileSectionsConnectionFieldsModel.w_(), protileSectionsConnectionFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ProtileSectionsConnectionFieldsModel.class, new Serializer());
            }
        }

        public ProtileSectionsConnectionFieldsModel() {
            super(1);
        }

        @Nonnull
        public final ImmutableList<ProtileSectionFieldsModel> m12226a() {
            this.f12178d = super.a(this.f12178d, 0, ProtileSectionFieldsModel.class);
            return (ImmutableList) this.f12178d;
        }

        public final int jK_() {
            return -1081776157;
        }

        public final GraphQLVisitableModel m12225a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m12226a() != null) {
                Builder a = ModelHelper.a(m12226a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (ProtileSectionsConnectionFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12178d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m12224a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m12226a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1106093189)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: featured_photos_suggestions */
    public final class ProtileViewFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private String f12181d;
        @Nullable
        private ProtileItemsConnectionFieldsModel f12182e;
        @Nullable
        private ViewMediasetModel f12183f;

        /* compiled from: featured_photos_suggestions */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ProtileViewFieldsModel.class, new Deserializer());
            }

            public Object m12227a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ProtileViewFieldsParser.m12280b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object protileViewFieldsModel = new ProtileViewFieldsModel();
                ((BaseModel) protileViewFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (protileViewFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) protileViewFieldsModel).a();
                }
                return protileViewFieldsModel;
            }
        }

        /* compiled from: featured_photos_suggestions */
        public class Serializer extends JsonSerializer<ProtileViewFieldsModel> {
            public final void m12228a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ProtileViewFieldsModel protileViewFieldsModel = (ProtileViewFieldsModel) obj;
                if (protileViewFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(protileViewFieldsModel.m12237a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    protileViewFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ProtileViewFieldsParser.m12281b(protileViewFieldsModel.w_(), protileViewFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ProtileViewFieldsModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1787905591)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: featured_photos_suggestions */
        public final class ViewMediasetModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private GraphQLObjectType f12179d;
            @Nullable
            private String f12180e;

            /* compiled from: featured_photos_suggestions */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ViewMediasetModel.class, new Deserializer());
                }

                public Object m12229a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ViewMediasetParser.m12278a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object viewMediasetModel = new ViewMediasetModel();
                    ((BaseModel) viewMediasetModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (viewMediasetModel instanceof Postprocessable) {
                        return ((Postprocessable) viewMediasetModel).a();
                    }
                    return viewMediasetModel;
                }
            }

            /* compiled from: featured_photos_suggestions */
            public class Serializer extends JsonSerializer<ViewMediasetModel> {
                public final void m12230a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ViewMediasetModel viewMediasetModel = (ViewMediasetModel) obj;
                    if (viewMediasetModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(viewMediasetModel.m12232a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        viewMediasetModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ViewMediasetParser.m12279a(viewMediasetModel.w_(), viewMediasetModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ViewMediasetModel.class, new Serializer());
                }
            }

            public ViewMediasetModel() {
                super(2);
            }

            @Nullable
            private GraphQLObjectType m12231k() {
                if (this.b != null && this.f12179d == null) {
                    this.f12179d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f12179d;
            }

            @Nullable
            public final String m12235j() {
                this.f12180e = super.a(this.f12180e, 1);
                return this.f12180e;
            }

            @Nullable
            public final String m12234a() {
                return m12235j();
            }

            public final int jK_() {
                return -836141570;
            }

            public final GraphQLVisitableModel m12233a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m12232a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m12231k());
                int b = flatBufferBuilder.b(m12235j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        public ProtileViewFieldsModel() {
            super(3);
        }

        @Nullable
        private String m12236l() {
            this.f12181d = super.a(this.f12181d, 0);
            return this.f12181d;
        }

        @Nullable
        public final ProtileItemsConnectionFieldsModel m12240j() {
            this.f12182e = (ProtileItemsConnectionFieldsModel) super.a(this.f12182e, 1, ProtileItemsConnectionFieldsModel.class);
            return this.f12182e;
        }

        @Nullable
        public final ViewMediasetModel m12241k() {
            this.f12183f = (ViewMediasetModel) super.a(this.f12183f, 2, ViewMediasetModel.class);
            return this.f12183f;
        }

        @Nullable
        public final String m12239a() {
            return m12236l();
        }

        public final int jK_() {
            return 1258940188;
        }

        public final GraphQLVisitableModel m12238a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m12240j() != null) {
                ProtileItemsConnectionFieldsModel protileItemsConnectionFieldsModel = (ProtileItemsConnectionFieldsModel) graphQLModelMutatingVisitor.b(m12240j());
                if (m12240j() != protileItemsConnectionFieldsModel) {
                    graphQLVisitableModel = (ProtileViewFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12182e = protileItemsConnectionFieldsModel;
                }
            }
            if (m12241k() != null) {
                ViewMediasetModel viewMediasetModel = (ViewMediasetModel) graphQLModelMutatingVisitor.b(m12241k());
                if (m12241k() != viewMediasetModel) {
                    graphQLVisitableModel = (ProtileViewFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12183f = viewMediasetModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m12237a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m12236l());
            int a = ModelHelper.a(flatBufferBuilder, m12240j());
            int a2 = ModelHelper.a(flatBufferBuilder, m12241k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1696986609)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: featured_photos_suggestions */
    public final class ProtileViewsConnectionFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<ProtileViewFieldsModel> f12184d;

        /* compiled from: featured_photos_suggestions */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ProtileViewsConnectionFieldsModel.class, new Deserializer());
            }

            public Object m12242a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ProtileViewsConnectionFieldsParser.m12282a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object protileViewsConnectionFieldsModel = new ProtileViewsConnectionFieldsModel();
                ((BaseModel) protileViewsConnectionFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (protileViewsConnectionFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) protileViewsConnectionFieldsModel).a();
                }
                return protileViewsConnectionFieldsModel;
            }
        }

        /* compiled from: featured_photos_suggestions */
        public class Serializer extends JsonSerializer<ProtileViewsConnectionFieldsModel> {
            public final void m12243a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ProtileViewsConnectionFieldsModel protileViewsConnectionFieldsModel = (ProtileViewsConnectionFieldsModel) obj;
                if (protileViewsConnectionFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(protileViewsConnectionFieldsModel.m12244a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    protileViewsConnectionFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ProtileViewsConnectionFieldsParser.m12283a(protileViewsConnectionFieldsModel.w_(), protileViewsConnectionFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ProtileViewsConnectionFieldsModel.class, new Serializer());
            }
        }

        public ProtileViewsConnectionFieldsModel() {
            super(1);
        }

        @Nonnull
        public final ImmutableList<ProtileViewFieldsModel> m12246a() {
            this.f12184d = super.a(this.f12184d, 0, ProtileViewFieldsModel.class);
            return (ImmutableList) this.f12184d;
        }

        public final int jK_() {
            return -196053227;
        }

        public final GraphQLVisitableModel m12245a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m12246a() != null) {
                Builder a = ModelHelper.a(m12246a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (ProtileViewsConnectionFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12184d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m12244a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m12246a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -179460200)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: featured_photos_suggestions */
    public final class TimelineProtilesQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private ProtileSectionsConnectionFieldsModel f12185d;

        /* compiled from: featured_photos_suggestions */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TimelineProtilesQueryModel.class, new Deserializer());
            }

            public Object m12247a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = TimelineProtilesQueryParser.m12284a(jsonParser);
                Object timelineProtilesQueryModel = new TimelineProtilesQueryModel();
                ((BaseModel) timelineProtilesQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (timelineProtilesQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) timelineProtilesQueryModel).a();
                }
                return timelineProtilesQueryModel;
            }
        }

        /* compiled from: featured_photos_suggestions */
        public class Serializer extends JsonSerializer<TimelineProtilesQueryModel> {
            public final void m12248a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                TimelineProtilesQueryModel timelineProtilesQueryModel = (TimelineProtilesQueryModel) obj;
                if (timelineProtilesQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(timelineProtilesQueryModel.m12249a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    timelineProtilesQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = timelineProtilesQueryModel.w_();
                int u_ = timelineProtilesQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("profile_tile_sections");
                    ProtileSectionsConnectionFieldsParser.m12277a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(TimelineProtilesQueryModel.class, new Serializer());
            }
        }

        public TimelineProtilesQueryModel() {
            super(1);
        }

        public final void m12252a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m12253a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final ProtileSectionsConnectionFieldsModel m12251a() {
            this.f12185d = (ProtileSectionsConnectionFieldsModel) super.a(this.f12185d, 0, ProtileSectionsConnectionFieldsModel.class);
            return this.f12185d;
        }

        public final int jK_() {
            return 2645995;
        }

        public final GraphQLVisitableModel m12250a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m12251a() != null) {
                ProtileSectionsConnectionFieldsModel protileSectionsConnectionFieldsModel = (ProtileSectionsConnectionFieldsModel) graphQLModelMutatingVisitor.b(m12251a());
                if (m12251a() != protileSectionsConnectionFieldsModel) {
                    graphQLVisitableModel = (TimelineProtilesQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12185d = protileSectionsConnectionFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m12249a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m12251a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}

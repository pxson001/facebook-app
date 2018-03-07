package com.facebook.search.protocol;

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
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.search.protocol.C0910xd29004f9.NodeParser;
import com.facebook.search.protocol.C0910xd29004f9.NodeParser.CoverPhotoParser;
import com.facebook.search.protocol.C0910xd29004f9.NodeParser.CoverPhotoParser.PhotoParser;
import com.facebook.search.protocol.C0910xd29004f9.NodeParser.CoverPhotoParser.PhotoParser.ImageParser;
import com.facebook.search.protocol.C0910xd29004f9.NodeParser.GroupIconParser;
import com.facebook.search.protocol.C0910xd29004f9.NodeParser.GroupIconParser.DarkIconParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = 1084404505)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: network_operation */
public final class C0906x8b04d39c extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
    @Nullable
    private GraphQLObjectType f8023d;
    @Nullable
    private CoverPhotoModel f8024e;
    @Nullable
    private String f8025f;
    @Nullable
    private GroupIconModel f8026g;
    @Nullable
    private String f8027h;
    @Nullable
    private String f8028i;
    @Nullable
    private String f8029j;
    @Nullable
    private String f8030k;
    @Nullable
    private String f8031l;
    @Nullable
    private DefaultImageFieldsModel f8032m;
    private int f8033n;

    /* compiled from: network_operation */
    public final class Builder {
        @Nullable
        public GraphQLObjectType f8005a;
        @Nullable
        public CoverPhotoModel f8006b;
        @Nullable
        public String f8007c;
        @Nullable
        public GroupIconModel f8008d;
        @Nullable
        public String f8009e;
        @Nullable
        public String f8010f;
        @Nullable
        public String f8011g;
        @Nullable
        public String f8012h;
        @Nullable
        public String f8013i;
        @Nullable
        public DefaultImageFieldsModel f8014j;
        public int f8015k;

        public final C0906x8b04d39c m8715a() {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int a = ModelHelper.a(flatBufferBuilder, this.f8005a);
            int a2 = ModelHelper.a(flatBufferBuilder, this.f8006b);
            int b = flatBufferBuilder.b(this.f8007c);
            int a3 = ModelHelper.a(flatBufferBuilder, this.f8008d);
            int b2 = flatBufferBuilder.b(this.f8009e);
            int b3 = flatBufferBuilder.b(this.f8010f);
            int b4 = flatBufferBuilder.b(this.f8011g);
            int b5 = flatBufferBuilder.b(this.f8012h);
            int b6 = flatBufferBuilder.b(this.f8013i);
            int a4 = ModelHelper.a(flatBufferBuilder, this.f8014j);
            flatBufferBuilder.c(11);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.b(4, b2);
            flatBufferBuilder.b(5, b3);
            flatBufferBuilder.b(6, b4);
            flatBufferBuilder.b(7, b5);
            flatBufferBuilder.b(8, b6);
            flatBufferBuilder.b(9, a4);
            flatBufferBuilder.a(10, this.f8015k, 0);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new C0906x8b04d39c(new MutableFlatBuffer(wrap, null, null, true, null));
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2082905822)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: network_operation */
    public final class CoverPhotoModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private PhotoModel f8018d;

        /* compiled from: network_operation */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CoverPhotoModel.class, new Deserializer());
            }

            public Object m8716a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(CoverPhotoParser.m8767a(jsonParser, flatBufferBuilder));
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
        @ModelWithFlatBufferFormatHash(a = -1023729861)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: network_operation */
        public final class PhotoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private ImageModel f8017d;

            /* compiled from: network_operation */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PhotoModel.class, new Deserializer());
                }

                public Object m8717a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PhotoParser.m8765a(jsonParser, flatBufferBuilder));
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
            @ModelWithFlatBufferFormatHash(a = 842551240)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: network_operation */
            public final class ImageModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f8016d;

                /* compiled from: network_operation */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ImageModel.class, new Deserializer());
                    }

                    public Object m8718a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ImageParser.m8763a(jsonParser, flatBufferBuilder));
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

                /* compiled from: network_operation */
                public class Serializer extends JsonSerializer<ImageModel> {
                    public final void m8719a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ImageModel imageModel = (ImageModel) obj;
                        if (imageModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(imageModel.m8720a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            imageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ImageParser.m8764a(imageModel.w_(), imageModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(ImageModel.class, new Serializer());
                    }
                }

                public ImageModel() {
                    super(1);
                }

                @Nullable
                public final String m8722a() {
                    this.f8016d = super.a(this.f8016d, 0);
                    return this.f8016d;
                }

                public final int jK_() {
                    return 70760763;
                }

                public final GraphQLVisitableModel m8721a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m8720a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m8722a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: network_operation */
            public class Serializer extends JsonSerializer<PhotoModel> {
                public final void m8723a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PhotoModel photoModel = (PhotoModel) obj;
                    if (photoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(photoModel.m8724a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        photoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PhotoParser.m8766a(photoModel.w_(), photoModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PhotoModel.class, new Serializer());
                }
            }

            public PhotoModel() {
                super(1);
            }

            @Nullable
            public final ImageModel m8726a() {
                this.f8017d = (ImageModel) super.a(this.f8017d, 0, ImageModel.class);
                return this.f8017d;
            }

            public final int jK_() {
                return 77090322;
            }

            public final GraphQLVisitableModel m8725a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m8726a() != null) {
                    ImageModel imageModel = (ImageModel) graphQLModelMutatingVisitor.b(m8726a());
                    if (m8726a() != imageModel) {
                        graphQLVisitableModel = (PhotoModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f8017d = imageModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m8724a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m8726a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: network_operation */
        public class Serializer extends JsonSerializer<CoverPhotoModel> {
            public final void m8727a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                CoverPhotoModel coverPhotoModel = (CoverPhotoModel) obj;
                if (coverPhotoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(coverPhotoModel.m8728a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    coverPhotoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                CoverPhotoParser.m8768a(coverPhotoModel.w_(), coverPhotoModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(CoverPhotoModel.class, new Serializer());
            }
        }

        public CoverPhotoModel() {
            super(1);
        }

        @Nullable
        public final PhotoModel m8730a() {
            this.f8018d = (PhotoModel) super.a(this.f8018d, 0, PhotoModel.class);
            return this.f8018d;
        }

        public final int jK_() {
            return 497264923;
        }

        public final GraphQLVisitableModel m8729a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m8730a() != null) {
                PhotoModel photoModel = (PhotoModel) graphQLModelMutatingVisitor.b(m8730a());
                if (m8730a() != photoModel) {
                    graphQLVisitableModel = (CoverPhotoModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8018d = photoModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m8728a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m8730a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    /* compiled from: network_operation */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(C0906x8b04d39c.class, new Deserializer());
        }

        public Object m8731a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(NodeParser.m8773a(jsonParser, flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
            Object c0906x8b04d39c = new C0906x8b04d39c();
            ((BaseModel) c0906x8b04d39c).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
            if (c0906x8b04d39c instanceof Postprocessable) {
                return ((Postprocessable) c0906x8b04d39c).a();
            }
            return c0906x8b04d39c;
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 999184973)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: network_operation */
    public final class GroupIconModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private DarkIconModel f8022d;

        /* compiled from: network_operation */
        public final class Builder {
            @Nullable
            public DarkIconModel f8019a;

            public final GroupIconModel m8732a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f8019a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new GroupIconModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: network_operation */
        public final class DarkIconModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f8021d;

            /* compiled from: network_operation */
            public final class Builder {
                @Nullable
                public String f8020a;

                public final DarkIconModel m8733a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int b = flatBufferBuilder.b(this.f8020a);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new DarkIconModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: network_operation */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(DarkIconModel.class, new Deserializer());
                }

                public Object m8734a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(DarkIconParser.m8769a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object darkIconModel = new DarkIconModel();
                    ((BaseModel) darkIconModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (darkIconModel instanceof Postprocessable) {
                        return ((Postprocessable) darkIconModel).a();
                    }
                    return darkIconModel;
                }
            }

            /* compiled from: network_operation */
            public class Serializer extends JsonSerializer<DarkIconModel> {
                public final void m8735a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    DarkIconModel darkIconModel = (DarkIconModel) obj;
                    if (darkIconModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(darkIconModel.m8736a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        darkIconModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    DarkIconParser.m8770a(darkIconModel.w_(), darkIconModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(DarkIconModel.class, new Serializer());
                }
            }

            public DarkIconModel() {
                super(1);
            }

            public DarkIconModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m8738a() {
                this.f8021d = super.a(this.f8021d, 0);
                return this.f8021d;
            }

            public final int jK_() {
                return 2273433;
            }

            public final GraphQLVisitableModel m8737a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m8736a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m8738a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: network_operation */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupIconModel.class, new Deserializer());
            }

            public Object m8739a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(GroupIconParser.m8771a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object groupIconModel = new GroupIconModel();
                ((BaseModel) groupIconModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (groupIconModel instanceof Postprocessable) {
                    return ((Postprocessable) groupIconModel).a();
                }
                return groupIconModel;
            }
        }

        /* compiled from: network_operation */
        public class Serializer extends JsonSerializer<GroupIconModel> {
            public final void m8740a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                GroupIconModel groupIconModel = (GroupIconModel) obj;
                if (groupIconModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupIconModel.m8741a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupIconModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                GroupIconParser.m8772a(groupIconModel.w_(), groupIconModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(GroupIconModel.class, new Serializer());
            }
        }

        public GroupIconModel() {
            super(1);
        }

        public GroupIconModel(MutableFlatBuffer mutableFlatBuffer) {
            super(1);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final DarkIconModel m8743a() {
            this.f8022d = (DarkIconModel) super.a(this.f8022d, 0, DarkIconModel.class);
            return this.f8022d;
        }

        public final int jK_() {
            return -452718528;
        }

        public final GraphQLVisitableModel m8742a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m8743a() != null) {
                DarkIconModel darkIconModel = (DarkIconModel) graphQLModelMutatingVisitor.b(m8743a());
                if (m8743a() != darkIconModel) {
                    graphQLVisitableModel = (GroupIconModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8022d = darkIconModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m8741a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m8743a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    /* compiled from: network_operation */
    public class Serializer extends JsonSerializer<C0906x8b04d39c> {
        public final void m8744a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            C0906x8b04d39c c0906x8b04d39c = (C0906x8b04d39c) obj;
            if (c0906x8b04d39c.w_() == null) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(c0906x8b04d39c.m8746a(flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                c0906x8b04d39c.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }
            NodeParser.m8774a(c0906x8b04d39c.w_(), c0906x8b04d39c.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(C0906x8b04d39c.class, new Serializer());
        }
    }

    public C0906x8b04d39c() {
        super(11);
    }

    public C0906x8b04d39c(MutableFlatBuffer mutableFlatBuffer) {
        super(11);
        a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
    }

    @Nullable
    public final GraphQLObjectType m8750j() {
        if (this.b != null && this.f8023d == null) {
            this.f8023d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
        }
        return this.f8023d;
    }

    @Nullable
    public final CoverPhotoModel m8751k() {
        this.f8024e = (CoverPhotoModel) super.a(this.f8024e, 1, CoverPhotoModel.class);
        return this.f8024e;
    }

    @Nullable
    public final String m8752l() {
        this.f8025f = super.a(this.f8025f, 2);
        return this.f8025f;
    }

    @Nullable
    public final GroupIconModel m8753m() {
        this.f8026g = (GroupIconModel) super.a(this.f8026g, 3, GroupIconModel.class);
        return this.f8026g;
    }

    @Nullable
    public final String m8754n() {
        this.f8027h = super.a(this.f8027h, 4);
        return this.f8027h;
    }

    @Nullable
    public final String m8755o() {
        this.f8028i = super.a(this.f8028i, 5);
        return this.f8028i;
    }

    @Nullable
    public final String m8756p() {
        this.f8029j = super.a(this.f8029j, 6);
        return this.f8029j;
    }

    @Nullable
    private String m8745t() {
        this.f8030k = super.a(this.f8030k, 7);
        return this.f8030k;
    }

    @Nullable
    public final String m8757q() {
        this.f8031l = super.a(this.f8031l, 8);
        return this.f8031l;
    }

    @Nullable
    public final DefaultImageFieldsModel m8758r() {
        this.f8032m = (DefaultImageFieldsModel) super.a(this.f8032m, 9, DefaultImageFieldsModel.class);
        return this.f8032m;
    }

    public final int m8759s() {
        a(1, 2);
        return this.f8033n;
    }

    @Nullable
    public final String m8748a() {
        return m8755o();
    }

    public final int jK_() {
        return 1283375906;
    }

    public final GraphQLVisitableModel m8747a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m8751k() != null) {
            CoverPhotoModel coverPhotoModel = (CoverPhotoModel) graphQLModelMutatingVisitor.b(m8751k());
            if (m8751k() != coverPhotoModel) {
                graphQLVisitableModel = (C0906x8b04d39c) ModelHelper.a(null, this);
                graphQLVisitableModel.f8024e = coverPhotoModel;
            }
        }
        if (m8753m() != null) {
            GroupIconModel groupIconModel = (GroupIconModel) graphQLModelMutatingVisitor.b(m8753m());
            if (m8753m() != groupIconModel) {
                graphQLVisitableModel = (C0906x8b04d39c) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f8026g = groupIconModel;
            }
        }
        if (m8758r() != null) {
            DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m8758r());
            if (m8758r() != defaultImageFieldsModel) {
                graphQLVisitableModel = (C0906x8b04d39c) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f8032m = defaultImageFieldsModel;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final int m8746a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m8750j());
        int a2 = ModelHelper.a(flatBufferBuilder, m8751k());
        int b = flatBufferBuilder.b(m8752l());
        int a3 = ModelHelper.a(flatBufferBuilder, m8753m());
        int b2 = flatBufferBuilder.b(m8754n());
        int b3 = flatBufferBuilder.b(m8755o());
        int b4 = flatBufferBuilder.b(m8756p());
        int b5 = flatBufferBuilder.b(m8745t());
        int b6 = flatBufferBuilder.b(m8757q());
        int a4 = ModelHelper.a(flatBufferBuilder, m8758r());
        flatBufferBuilder.c(11);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, a2);
        flatBufferBuilder.b(2, b);
        flatBufferBuilder.b(3, a3);
        flatBufferBuilder.b(4, b2);
        flatBufferBuilder.b(5, b3);
        flatBufferBuilder.b(6, b4);
        flatBufferBuilder.b(7, b5);
        flatBufferBuilder.b(8, b6);
        flatBufferBuilder.b(9, a4);
        flatBufferBuilder.a(10, this.f8033n, 0);
        i();
        return flatBufferBuilder.d();
    }

    public final void m8749a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f8033n = mutableFlatBuffer.a(i, 10, 0);
    }
}

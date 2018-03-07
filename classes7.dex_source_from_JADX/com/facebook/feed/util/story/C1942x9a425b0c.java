package com.facebook.feed.util.story;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.ShouldDisplayProfilePictureGraphQLParser.ActorsParser.ProfileBadgeParser;
import com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.ShouldDisplayProfilePictureGraphQLParser.ActorsParser.ProfileBadgeParser.BadgeIconParser;
import com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.ShouldDisplayProfilePictureGraphQLParser.ActorsParser.ProfileBadgeParser.BadgeIconParser.ImageParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
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
@ModelWithFlatBufferFormatHash(a = 808613477)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: TQUERY_CONSTRUCTION_PARAM; */
public final class C1942x9a425b0c extends BaseModel implements GraphQLVisitableModel {
    @Nullable
    private BadgeIconModel f22500d;

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1625774401)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: TQUERY_CONSTRUCTION_PARAM; */
    public final class BadgeIconModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ImageModel f22499d;

        /* compiled from: TQUERY_CONSTRUCTION_PARAM; */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(BadgeIconModel.class, new Deserializer());
            }

            public Object m25107a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(BadgeIconParser.m25188a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object badgeIconModel = new BadgeIconModel();
                ((BaseModel) badgeIconModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (badgeIconModel instanceof Postprocessable) {
                    return ((Postprocessable) badgeIconModel).a();
                }
                return badgeIconModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: TQUERY_CONSTRUCTION_PARAM; */
        public final class ImageModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f22498d;

            /* compiled from: TQUERY_CONSTRUCTION_PARAM; */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ImageModel.class, new Deserializer());
                }

                public Object m25108a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ImageParser.m25186a(jsonParser, flatBufferBuilder));
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

            /* compiled from: TQUERY_CONSTRUCTION_PARAM; */
            public class Serializer extends JsonSerializer<ImageModel> {
                public final void m25109a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ImageModel imageModel = (ImageModel) obj;
                    if (imageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(imageModel.m25111a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        imageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ImageParser.m25187a(imageModel.w_(), imageModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ImageModel.class, new Serializer());
                }
            }

            public ImageModel() {
                super(1);
            }

            @Nullable
            private String m25110a() {
                this.f22498d = super.a(this.f22498d, 0);
                return this.f22498d;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m25112a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m25111a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m25110a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: TQUERY_CONSTRUCTION_PARAM; */
        public class Serializer extends JsonSerializer<BadgeIconModel> {
            public final void m25113a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                BadgeIconModel badgeIconModel = (BadgeIconModel) obj;
                if (badgeIconModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(badgeIconModel.m25115a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    badgeIconModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                BadgeIconParser.m25189a(badgeIconModel.w_(), badgeIconModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(BadgeIconModel.class, new Serializer());
            }
        }

        public BadgeIconModel() {
            super(1);
        }

        @Nullable
        private ImageModel m25114a() {
            this.f22499d = (ImageModel) super.a(this.f22499d, 0, ImageModel.class);
            return this.f22499d;
        }

        public final int jK_() {
            return 638969039;
        }

        public final GraphQLVisitableModel m25116a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m25114a() != null) {
                ImageModel imageModel = (ImageModel) graphQLModelMutatingVisitor.b(m25114a());
                if (m25114a() != imageModel) {
                    graphQLVisitableModel = (BadgeIconModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f22499d = imageModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m25115a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m25114a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    /* compiled from: TQUERY_CONSTRUCTION_PARAM; */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(C1942x9a425b0c.class, new Deserializer());
        }

        public Object m25117a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(ProfileBadgeParser.m25190a(jsonParser, flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
            Object c1942x9a425b0c = new C1942x9a425b0c();
            ((BaseModel) c1942x9a425b0c).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
            if (c1942x9a425b0c instanceof Postprocessable) {
                return ((Postprocessable) c1942x9a425b0c).a();
            }
            return c1942x9a425b0c;
        }
    }

    /* compiled from: TQUERY_CONSTRUCTION_PARAM; */
    public class Serializer extends JsonSerializer<C1942x9a425b0c> {
        public final void m25118a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            C1942x9a425b0c c1942x9a425b0c = (C1942x9a425b0c) obj;
            if (c1942x9a425b0c.w_() == null) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(c1942x9a425b0c.m25120a(flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                c1942x9a425b0c.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }
            ProfileBadgeParser.m25191a(c1942x9a425b0c.w_(), c1942x9a425b0c.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(C1942x9a425b0c.class, new Serializer());
        }
    }

    public C1942x9a425b0c() {
        super(1);
    }

    @Nullable
    private BadgeIconModel m25119a() {
        this.f22500d = (BadgeIconModel) super.a(this.f22500d, 0, BadgeIconModel.class);
        return this.f22500d;
    }

    public final int jK_() {
        return 1360861082;
    }

    public final GraphQLVisitableModel m25121a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m25119a() != null) {
            BadgeIconModel badgeIconModel = (BadgeIconModel) graphQLModelMutatingVisitor.b(m25119a());
            if (m25119a() != badgeIconModel) {
                graphQLVisitableModel = (C1942x9a425b0c) ModelHelper.a(null, this);
                graphQLVisitableModel.f22500d = badgeIconModel;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final int m25120a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m25119a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }
}

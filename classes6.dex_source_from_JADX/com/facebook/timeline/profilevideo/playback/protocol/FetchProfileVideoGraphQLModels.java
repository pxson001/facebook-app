package com.facebook.timeline.profilevideo.playback.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.timeline.profilevideo.playback.protocol.FetchProfileVideoGraphQLParsers.ProfileHeaderAssociatedVideoParser;
import com.facebook.timeline.profilevideo.playback.protocol.FetchProfileVideoGraphQLParsers.ProfileVideoHeaderFieldsParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: deltaBroadcastMessage */
public class FetchProfileVideoGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1275773442)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: deltaBroadcastMessage */
    public final class ProfileHeaderAssociatedVideoModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ProfileVideoHeaderFieldsModel f17636d;

        /* compiled from: deltaBroadcastMessage */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ProfileHeaderAssociatedVideoModel.class, new Deserializer());
            }

            public Object m25637a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ProfileHeaderAssociatedVideoParser.m25650a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object profileHeaderAssociatedVideoModel = new ProfileHeaderAssociatedVideoModel();
                ((BaseModel) profileHeaderAssociatedVideoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (profileHeaderAssociatedVideoModel instanceof Postprocessable) {
                    return ((Postprocessable) profileHeaderAssociatedVideoModel).a();
                }
                return profileHeaderAssociatedVideoModel;
            }
        }

        /* compiled from: deltaBroadcastMessage */
        public class Serializer extends JsonSerializer<ProfileHeaderAssociatedVideoModel> {
            public final void m25638a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ProfileHeaderAssociatedVideoModel profileHeaderAssociatedVideoModel = (ProfileHeaderAssociatedVideoModel) obj;
                if (profileHeaderAssociatedVideoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(profileHeaderAssociatedVideoModel.m25639a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    profileHeaderAssociatedVideoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ProfileHeaderAssociatedVideoParser.m25651a(profileHeaderAssociatedVideoModel.w_(), profileHeaderAssociatedVideoModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ProfileHeaderAssociatedVideoModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ ProfileVideoHeaderFieldsModel m25641a() {
            return m25642j();
        }

        public ProfileHeaderAssociatedVideoModel() {
            super(1);
        }

        @Nullable
        public final ProfileVideoHeaderFieldsModel m25642j() {
            this.f17636d = (ProfileVideoHeaderFieldsModel) super.a(this.f17636d, 0, ProfileVideoHeaderFieldsModel.class);
            return this.f17636d;
        }

        public final int jK_() {
            return 1379569778;
        }

        public final GraphQLVisitableModel m25640a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m25642j() != null) {
                ProfileVideoHeaderFieldsModel profileVideoHeaderFieldsModel = (ProfileVideoHeaderFieldsModel) graphQLModelMutatingVisitor.b(m25642j());
                if (m25642j() != profileVideoHeaderFieldsModel) {
                    graphQLVisitableModel = (ProfileHeaderAssociatedVideoModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17636d = profileVideoHeaderFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m25639a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m25642j());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1230558878)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: deltaBroadcastMessage */
    public final class ProfileVideoHeaderFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private String f17639d;
        @Nullable
        private String f17640e;

        /* compiled from: deltaBroadcastMessage */
        public final class Builder {
            @Nullable
            public String f17637a;
            @Nullable
            public String f17638b;
        }

        /* compiled from: deltaBroadcastMessage */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ProfileVideoHeaderFieldsModel.class, new Deserializer());
            }

            public Object m25643a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ProfileVideoHeaderFieldsParser.m25652a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object profileVideoHeaderFieldsModel = new ProfileVideoHeaderFieldsModel();
                ((BaseModel) profileVideoHeaderFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (profileVideoHeaderFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) profileVideoHeaderFieldsModel).a();
                }
                return profileVideoHeaderFieldsModel;
            }
        }

        /* compiled from: deltaBroadcastMessage */
        public class Serializer extends JsonSerializer<ProfileVideoHeaderFieldsModel> {
            public final void m25644a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ProfileVideoHeaderFieldsModel profileVideoHeaderFieldsModel = (ProfileVideoHeaderFieldsModel) obj;
                if (profileVideoHeaderFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(profileVideoHeaderFieldsModel.m25645a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    profileVideoHeaderFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ProfileVideoHeaderFieldsParser.m25653a(profileVideoHeaderFieldsModel.w_(), profileVideoHeaderFieldsModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(ProfileVideoHeaderFieldsModel.class, new Serializer());
            }
        }

        public ProfileVideoHeaderFieldsModel() {
            super(2);
        }

        public ProfileVideoHeaderFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(2);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final String m25648b() {
            this.f17639d = super.a(this.f17639d, 0);
            return this.f17639d;
        }

        @Nullable
        public final String m25649c() {
            this.f17640e = super.a(this.f17640e, 1);
            return this.f17640e;
        }

        @Nullable
        public final String m25647a() {
            return m25648b();
        }

        public final int jK_() {
            return 82650203;
        }

        public final GraphQLVisitableModel m25646a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m25645a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m25648b());
            int b2 = flatBufferBuilder.b(m25649c());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            i();
            return flatBufferBuilder.d();
        }
    }
}

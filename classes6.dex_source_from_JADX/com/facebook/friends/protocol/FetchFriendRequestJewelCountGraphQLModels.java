package com.facebook.friends.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.friends.protocol.FetchFriendRequestJewelCountGraphQLParsers.FetchFriendRequestJewelCountGraphQLParser;
import com.facebook.friends.protocol.FetchFriendRequestJewelCountGraphQLParsers.FetchFriendRequestJewelCountGraphQLParser.FriendingPossibilitiesParser;
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

/* compiled from: map_with_overlay */
public class FetchFriendRequestJewelCountGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -305865)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: map_with_overlay */
    public final class FetchFriendRequestJewelCountGraphQLModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private FriendingPossibilitiesModel f10701d;

        /* compiled from: map_with_overlay */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchFriendRequestJewelCountGraphQLModel.class, new Deserializer());
            }

            public Object m16917a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchFriendRequestJewelCountGraphQLParser.m16930a(jsonParser);
                Object fetchFriendRequestJewelCountGraphQLModel = new FetchFriendRequestJewelCountGraphQLModel();
                ((BaseModel) fetchFriendRequestJewelCountGraphQLModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchFriendRequestJewelCountGraphQLModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchFriendRequestJewelCountGraphQLModel).a();
                }
                return fetchFriendRequestJewelCountGraphQLModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -437243616)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: map_with_overlay */
        public final class FriendingPossibilitiesModel extends BaseModel implements GraphQLVisitableModel {
            private int f10700d;

            /* compiled from: map_with_overlay */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FriendingPossibilitiesModel.class, new Deserializer());
                }

                public Object m16918a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FriendingPossibilitiesParser.m16928a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object friendingPossibilitiesModel = new FriendingPossibilitiesModel();
                    ((BaseModel) friendingPossibilitiesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (friendingPossibilitiesModel instanceof Postprocessable) {
                        return ((Postprocessable) friendingPossibilitiesModel).a();
                    }
                    return friendingPossibilitiesModel;
                }
            }

            /* compiled from: map_with_overlay */
            public class Serializer extends JsonSerializer<FriendingPossibilitiesModel> {
                public final void m16919a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FriendingPossibilitiesModel friendingPossibilitiesModel = (FriendingPossibilitiesModel) obj;
                    if (friendingPossibilitiesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(friendingPossibilitiesModel.m16921a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        friendingPossibilitiesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FriendingPossibilitiesParser.m16929a(friendingPossibilitiesModel.w_(), friendingPossibilitiesModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(FriendingPossibilitiesModel.class, new Serializer());
                }
            }

            public FriendingPossibilitiesModel() {
                super(1);
            }

            public final int m16920a() {
                a(0, 0);
                return this.f10700d;
            }

            public final int jK_() {
                return 1085064779;
            }

            public final GraphQLVisitableModel m16922a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m16921a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f10700d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m16923a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f10700d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: map_with_overlay */
        public class Serializer extends JsonSerializer<FetchFriendRequestJewelCountGraphQLModel> {
            public final void m16924a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchFriendRequestJewelCountGraphQLModel fetchFriendRequestJewelCountGraphQLModel = (FetchFriendRequestJewelCountGraphQLModel) obj;
                if (fetchFriendRequestJewelCountGraphQLModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchFriendRequestJewelCountGraphQLModel.m16925a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchFriendRequestJewelCountGraphQLModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchFriendRequestJewelCountGraphQLModel.w_();
                int u_ = fetchFriendRequestJewelCountGraphQLModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("friending_possibilities");
                    FriendingPossibilitiesParser.m16929a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchFriendRequestJewelCountGraphQLModel.class, new Serializer());
            }
        }

        public FetchFriendRequestJewelCountGraphQLModel() {
            super(1);
        }

        @Nullable
        public final FriendingPossibilitiesModel m16926a() {
            this.f10701d = (FriendingPossibilitiesModel) super.a(this.f10701d, 0, FriendingPossibilitiesModel.class);
            return this.f10701d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m16927a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16926a() != null) {
                FriendingPossibilitiesModel friendingPossibilitiesModel = (FriendingPossibilitiesModel) graphQLModelMutatingVisitor.b(m16926a());
                if (m16926a() != friendingPossibilitiesModel) {
                    graphQLVisitableModel = (FetchFriendRequestJewelCountGraphQLModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10701d = friendingPossibilitiesModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16925a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16926a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}

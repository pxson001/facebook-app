package com.facebook.video.videohome.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.facecastdisplay.protocol.FetchVideoBroadcastQueryModels.VideoBroadcastFragmentModel;
import com.facebook.facecastdisplay.protocol.FetchVideoBroadcastQueryParsers.VideoBroadcastFragmentParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.video.videohome.protocol.VideoHomeSubscriptionsParsers.LiveVideoBroadcastStatusUpdateSubscriptionParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: dict =  */
public class VideoHomeSubscriptionsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 325888169)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: dict =  */
    public final class LiveVideoBroadcastStatusUpdateSubscriptionModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private VideoBroadcastFragmentModel f15791d;

        /* compiled from: dict =  */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(LiveVideoBroadcastStatusUpdateSubscriptionModel.class, new Deserializer());
            }

            public Object m19753a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = LiveVideoBroadcastStatusUpdateSubscriptionParser.m19760a(jsonParser);
                Object liveVideoBroadcastStatusUpdateSubscriptionModel = new LiveVideoBroadcastStatusUpdateSubscriptionModel();
                ((BaseModel) liveVideoBroadcastStatusUpdateSubscriptionModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (liveVideoBroadcastStatusUpdateSubscriptionModel instanceof Postprocessable) {
                    return ((Postprocessable) liveVideoBroadcastStatusUpdateSubscriptionModel).a();
                }
                return liveVideoBroadcastStatusUpdateSubscriptionModel;
            }
        }

        /* compiled from: dict =  */
        public class Serializer extends JsonSerializer<LiveVideoBroadcastStatusUpdateSubscriptionModel> {
            public final void m19754a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                LiveVideoBroadcastStatusUpdateSubscriptionModel liveVideoBroadcastStatusUpdateSubscriptionModel = (LiveVideoBroadcastStatusUpdateSubscriptionModel) obj;
                if (liveVideoBroadcastStatusUpdateSubscriptionModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(liveVideoBroadcastStatusUpdateSubscriptionModel.m19755a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    liveVideoBroadcastStatusUpdateSubscriptionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = liveVideoBroadcastStatusUpdateSubscriptionModel.w_();
                int u_ = liveVideoBroadcastStatusUpdateSubscriptionModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("video");
                    VideoBroadcastFragmentParser.m4026a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(LiveVideoBroadcastStatusUpdateSubscriptionModel.class, new Serializer());
            }
        }

        public LiveVideoBroadcastStatusUpdateSubscriptionModel() {
            super(1);
        }

        @Nullable
        public final VideoBroadcastFragmentModel m19756a() {
            this.f15791d = (VideoBroadcastFragmentModel) super.a(this.f15791d, 0, VideoBroadcastFragmentModel.class);
            return this.f15791d;
        }

        public final int jK_() {
            return 1760485296;
        }

        public final GraphQLVisitableModel m19757a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m19756a() != null) {
                VideoBroadcastFragmentModel videoBroadcastFragmentModel = (VideoBroadcastFragmentModel) graphQLModelMutatingVisitor.b(m19756a());
                if (m19756a() != videoBroadcastFragmentModel) {
                    graphQLVisitableModel = (LiveVideoBroadcastStatusUpdateSubscriptionModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f15791d = videoBroadcastFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m19755a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m19756a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}

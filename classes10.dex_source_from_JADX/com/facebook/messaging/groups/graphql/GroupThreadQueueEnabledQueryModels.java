package com.facebook.messaging.groups.graphql;

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
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.messaging.groups.graphql.GroupThreadQueueEnabledQueryParsers.GroupThreadQueueEnabledQueryParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;

/* compiled from: showStatusComposer */
public class GroupThreadQueueEnabledQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 681138477)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: showStatusComposer */
    public final class GroupThreadQueueEnabledQueryModel extends BaseModel implements GraphQLVisitableModel {
        private boolean f2462d;

        /* compiled from: showStatusComposer */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupThreadQueueEnabledQueryModel.class, new Deserializer());
            }

            public Object m2429a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GroupThreadQueueEnabledQueryParser.m2435a(jsonParser);
                Object groupThreadQueueEnabledQueryModel = new GroupThreadQueueEnabledQueryModel();
                ((BaseModel) groupThreadQueueEnabledQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (groupThreadQueueEnabledQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) groupThreadQueueEnabledQueryModel).a();
                }
                return groupThreadQueueEnabledQueryModel;
            }
        }

        /* compiled from: showStatusComposer */
        public class Serializer extends JsonSerializer<GroupThreadQueueEnabledQueryModel> {
            public final void m2430a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GroupThreadQueueEnabledQueryModel groupThreadQueueEnabledQueryModel = (GroupThreadQueueEnabledQueryModel) obj;
                if (groupThreadQueueEnabledQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupThreadQueueEnabledQueryModel.m2431a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupThreadQueueEnabledQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = groupThreadQueueEnabledQueryModel.w_();
                int u_ = groupThreadQueueEnabledQueryModel.u_();
                jsonGenerator.f();
                boolean a = mutableFlatBuffer.a(u_, 0);
                if (a) {
                    jsonGenerator.a("thread_queue_enabled");
                    jsonGenerator.a(a);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GroupThreadQueueEnabledQueryModel.class, new Serializer());
            }
        }

        public GroupThreadQueueEnabledQueryModel() {
            super(1);
        }

        public final boolean m2434a() {
            a(0, 0);
            return this.f2462d;
        }

        public final int jK_() {
            return -740570927;
        }

        public final GraphQLVisitableModel m2432a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m2431a(FlatBufferBuilder flatBufferBuilder) {
            h();
            flatBufferBuilder.c(1);
            flatBufferBuilder.a(0, this.f2462d);
            i();
            return flatBufferBuilder.d();
        }

        public final void m2433a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f2462d = mutableFlatBuffer.a(i, 0);
        }
    }
}

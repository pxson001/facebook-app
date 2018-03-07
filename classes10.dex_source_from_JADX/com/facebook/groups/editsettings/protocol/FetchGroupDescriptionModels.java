package com.facebook.groups.editsettings.protocol;

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
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.groups.editsettings.protocol.FetchGroupDescriptionParsers.GroupNameDescriptionQueryParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: Unable to safeCancelAndNotifyWithRetry */
public class FetchGroupDescriptionModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1887958306)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: Unable to safeCancelAndNotifyWithRetry */
    public final class GroupNameDescriptionQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private String f21675d;
        @Nullable
        private String f21676e;
        @Nullable
        private String f21677f;

        /* compiled from: Unable to safeCancelAndNotifyWithRetry */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupNameDescriptionQueryModel.class, new Deserializer());
            }

            public Object m22631a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GroupNameDescriptionQueryParser.m22643a(jsonParser);
                Object groupNameDescriptionQueryModel = new GroupNameDescriptionQueryModel();
                ((BaseModel) groupNameDescriptionQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (groupNameDescriptionQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) groupNameDescriptionQueryModel).a();
                }
                return groupNameDescriptionQueryModel;
            }
        }

        /* compiled from: Unable to safeCancelAndNotifyWithRetry */
        public class Serializer extends JsonSerializer<GroupNameDescriptionQueryModel> {
            public final void m22632a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GroupNameDescriptionQueryModel groupNameDescriptionQueryModel = (GroupNameDescriptionQueryModel) obj;
                if (groupNameDescriptionQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupNameDescriptionQueryModel.m22636a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupNameDescriptionQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = groupNameDescriptionQueryModel.w_();
                int u_ = groupNameDescriptionQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("description");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 2));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GroupNameDescriptionQueryModel.class, new Serializer());
            }
        }

        public GroupNameDescriptionQueryModel() {
            super(3);
        }

        public final void m22639a(String str, ConsistencyTuple consistencyTuple) {
            if ("description".equals(str)) {
                consistencyTuple.a = m22641j();
                consistencyTuple.b = u_();
                consistencyTuple.c = 0;
            } else if ("name".equals(str)) {
                consistencyTuple.a = m22642k();
                consistencyTuple.b = u_();
                consistencyTuple.c = 2;
            } else {
                consistencyTuple.a();
            }
        }

        public final void m22640a(String str, Object obj, boolean z) {
            if ("description".equals(str)) {
                m22633a((String) obj);
            } else if ("name".equals(str)) {
                m22634b((String) obj);
            }
        }

        @Nullable
        public final String m22641j() {
            this.f21675d = super.a(this.f21675d, 0);
            return this.f21675d;
        }

        private void m22633a(@Nullable String str) {
            this.f21675d = str;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 0, str);
            }
        }

        @Nullable
        private String m22635l() {
            this.f21676e = super.a(this.f21676e, 1);
            return this.f21676e;
        }

        @Nullable
        public final String m22642k() {
            this.f21677f = super.a(this.f21677f, 2);
            return this.f21677f;
        }

        private void m22634b(@Nullable String str) {
            this.f21677f = str;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 2, str);
            }
        }

        @Nullable
        public final String m22638a() {
            return m22635l();
        }

        public final int jK_() {
            return 69076575;
        }

        public final GraphQLVisitableModel m22637a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m22636a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m22641j());
            int b2 = flatBufferBuilder.b(m22635l());
            int b3 = flatBufferBuilder.b(m22642k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, b3);
            i();
            return flatBufferBuilder.d();
        }
    }
}

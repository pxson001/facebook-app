package com.facebook.katana.dbl;

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
import com.facebook.katana.dbl.DBLRemoveRemoteDeviceMutationParsers.DeviceBasedLoginRemoveRemoteDeviceMutationParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: update_ts_ms */
public class DBLRemoveRemoteDeviceMutationModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1970617647)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: update_ts_ms */
    public final class DeviceBasedLoginRemoveRemoteDeviceMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f888d;

        /* compiled from: update_ts_ms */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(DeviceBasedLoginRemoveRemoteDeviceMutationModel.class, new Deserializer());
            }

            public Object m911a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = DeviceBasedLoginRemoveRemoteDeviceMutationParser.m916a(jsonParser);
                Object deviceBasedLoginRemoveRemoteDeviceMutationModel = new DeviceBasedLoginRemoveRemoteDeviceMutationModel();
                ((BaseModel) deviceBasedLoginRemoveRemoteDeviceMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (deviceBasedLoginRemoveRemoteDeviceMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) deviceBasedLoginRemoveRemoteDeviceMutationModel).a();
                }
                return deviceBasedLoginRemoveRemoteDeviceMutationModel;
            }
        }

        /* compiled from: update_ts_ms */
        public class Serializer extends JsonSerializer<DeviceBasedLoginRemoveRemoteDeviceMutationModel> {
            public final void m912a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                DeviceBasedLoginRemoveRemoteDeviceMutationModel deviceBasedLoginRemoveRemoteDeviceMutationModel = (DeviceBasedLoginRemoveRemoteDeviceMutationModel) obj;
                if (deviceBasedLoginRemoveRemoteDeviceMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(deviceBasedLoginRemoveRemoteDeviceMutationModel.m914a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    deviceBasedLoginRemoveRemoteDeviceMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = deviceBasedLoginRemoveRemoteDeviceMutationModel.w_();
                int u_ = deviceBasedLoginRemoveRemoteDeviceMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("datr");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(DeviceBasedLoginRemoveRemoteDeviceMutationModel.class, new Serializer());
            }
        }

        public DeviceBasedLoginRemoveRemoteDeviceMutationModel() {
            super(1);
        }

        @Nullable
        private String m913a() {
            this.f888d = super.a(this.f888d, 0);
            return this.f888d;
        }

        public final int jK_() {
            return -493356063;
        }

        public final GraphQLVisitableModel m915a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m914a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m913a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}

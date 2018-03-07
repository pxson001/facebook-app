package com.facebook.video.settings.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLAutoplaySettingEffective;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.video.settings.graphql.AutoplaySettingsMutationsParsers.DeviceAutoplaySettingUpdateParser;
import com.facebook.video.settings.graphql.AutoplaySettingsMutationsParsers.DeviceAutoplaySettingUpdateParser.DeviceAutoplaySettingParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms.maps.internal.IUiSettingsDelegate */
public class AutoplaySettingsMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 711524253)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: com.google.android.gms.maps.internal.IUiSettingsDelegate */
    public final class DeviceAutoplaySettingUpdateModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private DeviceAutoplaySettingModel f19635d;

        /* compiled from: com.google.android.gms.maps.internal.IUiSettingsDelegate */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(DeviceAutoplaySettingUpdateModel.class, new Deserializer());
            }

            public Object m28354a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = DeviceAutoplaySettingUpdateParser.m28369a(jsonParser);
                Object deviceAutoplaySettingUpdateModel = new DeviceAutoplaySettingUpdateModel();
                ((BaseModel) deviceAutoplaySettingUpdateModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (deviceAutoplaySettingUpdateModel instanceof Postprocessable) {
                    return ((Postprocessable) deviceAutoplaySettingUpdateModel).a();
                }
                return deviceAutoplaySettingUpdateModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -755877226)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: com.google.android.gms.maps.internal.IUiSettingsDelegate */
        public final class DeviceAutoplaySettingModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private GraphQLAutoplaySettingEffective f19632d;
            @Nullable
            private String f19633e;
            private boolean f19634f;

            /* compiled from: com.google.android.gms.maps.internal.IUiSettingsDelegate */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(DeviceAutoplaySettingModel.class, new Deserializer());
                }

                public Object m28355a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(DeviceAutoplaySettingParser.m28367a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object deviceAutoplaySettingModel = new DeviceAutoplaySettingModel();
                    ((BaseModel) deviceAutoplaySettingModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (deviceAutoplaySettingModel instanceof Postprocessable) {
                        return ((Postprocessable) deviceAutoplaySettingModel).a();
                    }
                    return deviceAutoplaySettingModel;
                }
            }

            /* compiled from: com.google.android.gms.maps.internal.IUiSettingsDelegate */
            public class Serializer extends JsonSerializer<DeviceAutoplaySettingModel> {
                public final void m28356a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    DeviceAutoplaySettingModel deviceAutoplaySettingModel = (DeviceAutoplaySettingModel) obj;
                    if (deviceAutoplaySettingModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(deviceAutoplaySettingModel.m28358a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        deviceAutoplaySettingModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    DeviceAutoplaySettingParser.m28368a(deviceAutoplaySettingModel.w_(), deviceAutoplaySettingModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(DeviceAutoplaySettingModel.class, new Serializer());
                }
            }

            public DeviceAutoplaySettingModel() {
                super(3);
            }

            @Nullable
            public final GraphQLAutoplaySettingEffective m28359a() {
                this.f19632d = (GraphQLAutoplaySettingEffective) super.b(this.f19632d, 0, GraphQLAutoplaySettingEffective.class, GraphQLAutoplaySettingEffective.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f19632d;
            }

            @Nullable
            private String m28357k() {
                this.f19633e = super.a(this.f19633e, 1);
                return this.f19633e;
            }

            public final boolean m28362j() {
                a(0, 2);
                return this.f19634f;
            }

            public final int jK_() {
                return 546150935;
            }

            public final GraphQLVisitableModel m28360a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m28358a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = flatBufferBuilder.a(m28359a());
                int b = flatBufferBuilder.b(m28357k());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.a(2, this.f19634f);
                i();
                return flatBufferBuilder.d();
            }

            public final void m28361a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f19634f = mutableFlatBuffer.a(i, 2);
            }
        }

        /* compiled from: com.google.android.gms.maps.internal.IUiSettingsDelegate */
        public class Serializer extends JsonSerializer<DeviceAutoplaySettingUpdateModel> {
            public final void m28363a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                DeviceAutoplaySettingUpdateModel deviceAutoplaySettingUpdateModel = (DeviceAutoplaySettingUpdateModel) obj;
                if (deviceAutoplaySettingUpdateModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(deviceAutoplaySettingUpdateModel.m28364a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    deviceAutoplaySettingUpdateModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = deviceAutoplaySettingUpdateModel.w_();
                int u_ = deviceAutoplaySettingUpdateModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("device_autoplay_setting");
                    DeviceAutoplaySettingParser.m28368a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(DeviceAutoplaySettingUpdateModel.class, new Serializer());
            }
        }

        public DeviceAutoplaySettingUpdateModel() {
            super(1);
        }

        @Nullable
        public final DeviceAutoplaySettingModel m28366a() {
            this.f19635d = (DeviceAutoplaySettingModel) super.a(this.f19635d, 0, DeviceAutoplaySettingModel.class);
            return this.f19635d;
        }

        public final int jK_() {
            return -842418131;
        }

        public final GraphQLVisitableModel m28365a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m28366a() != null) {
                DeviceAutoplaySettingModel deviceAutoplaySettingModel = (DeviceAutoplaySettingModel) graphQLModelMutatingVisitor.b(m28366a());
                if (m28366a() != deviceAutoplaySettingModel) {
                    graphQLVisitableModel = (DeviceAutoplaySettingUpdateModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f19635d = deviceAutoplaySettingModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m28364a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m28366a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}

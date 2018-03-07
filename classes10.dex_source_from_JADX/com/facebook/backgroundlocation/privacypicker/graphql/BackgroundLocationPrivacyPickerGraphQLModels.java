package com.facebook.backgroundlocation.privacypicker.graphql;

import com.facebook.backgroundlocation.privacypicker.graphql.BackgroundLocationPrivacyPickerGraphQLParsers.BackgroundLocationPrivacyPickerOptionEdgeParser;
import com.facebook.backgroundlocation.privacypicker.graphql.BackgroundLocationPrivacyPickerGraphQLParsers.BackgroundLocationPrivacyPickerOptionParser;
import com.facebook.backgroundlocation.privacypicker.graphql.BackgroundLocationPrivacyPickerGraphQLParsers.BackgroundLocationPrivacyPickerOptionsParser;
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
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyIconFields;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyOptionWithIconFields;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyOptionWithLegacyJsonFields;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLModels.PrivacyIconFieldsModel;
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

/* compiled from: divebar_availability_warning_turn_on */
public class BackgroundLocationPrivacyPickerGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -416343158)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: divebar_availability_warning_turn_on */
    public final class BackgroundLocationPrivacyPickerOptionEdgeModel extends BaseModel implements GraphQLVisitableModel {
        private boolean f14853d;
        private boolean f14854e;
        @Nullable
        private BackgroundLocationPrivacyPickerOptionModel f14855f;

        /* compiled from: divebar_availability_warning_turn_on */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(BackgroundLocationPrivacyPickerOptionEdgeModel.class, new Deserializer());
            }

            public Object m15300a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(BackgroundLocationPrivacyPickerOptionEdgeParser.m15322b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object backgroundLocationPrivacyPickerOptionEdgeModel = new BackgroundLocationPrivacyPickerOptionEdgeModel();
                ((BaseModel) backgroundLocationPrivacyPickerOptionEdgeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (backgroundLocationPrivacyPickerOptionEdgeModel instanceof Postprocessable) {
                    return ((Postprocessable) backgroundLocationPrivacyPickerOptionEdgeModel).a();
                }
                return backgroundLocationPrivacyPickerOptionEdgeModel;
            }
        }

        /* compiled from: divebar_availability_warning_turn_on */
        public class Serializer extends JsonSerializer<BackgroundLocationPrivacyPickerOptionEdgeModel> {
            public final void m15301a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                BackgroundLocationPrivacyPickerOptionEdgeModel backgroundLocationPrivacyPickerOptionEdgeModel = (BackgroundLocationPrivacyPickerOptionEdgeModel) obj;
                if (backgroundLocationPrivacyPickerOptionEdgeModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(backgroundLocationPrivacyPickerOptionEdgeModel.m15303a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    backgroundLocationPrivacyPickerOptionEdgeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                BackgroundLocationPrivacyPickerOptionEdgeParser.m15323b(backgroundLocationPrivacyPickerOptionEdgeModel.w_(), backgroundLocationPrivacyPickerOptionEdgeModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(BackgroundLocationPrivacyPickerOptionEdgeModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ BackgroundLocationPrivacyPickerOptionModel m15308c() {
            return m15302j();
        }

        public BackgroundLocationPrivacyPickerOptionEdgeModel() {
            super(3);
        }

        public final boolean m15306a() {
            a(0, 0);
            return this.f14853d;
        }

        public final boolean m15307b() {
            a(0, 1);
            return this.f14854e;
        }

        @Nullable
        private BackgroundLocationPrivacyPickerOptionModel m15302j() {
            this.f14855f = (BackgroundLocationPrivacyPickerOptionModel) super.a(this.f14855f, 2, BackgroundLocationPrivacyPickerOptionModel.class);
            return this.f14855f;
        }

        public final int jK_() {
            return 201834568;
        }

        public final GraphQLVisitableModel m15304a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15302j() != null) {
                BackgroundLocationPrivacyPickerOptionModel backgroundLocationPrivacyPickerOptionModel = (BackgroundLocationPrivacyPickerOptionModel) graphQLModelMutatingVisitor.b(m15302j());
                if (m15302j() != backgroundLocationPrivacyPickerOptionModel) {
                    graphQLVisitableModel = (BackgroundLocationPrivacyPickerOptionEdgeModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f14855f = backgroundLocationPrivacyPickerOptionModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15303a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15302j());
            flatBufferBuilder.c(3);
            flatBufferBuilder.a(0, this.f14853d);
            flatBufferBuilder.a(1, this.f14854e);
            flatBufferBuilder.b(2, a);
            i();
            return flatBufferBuilder.d();
        }

        public final void m15305a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f14853d = mutableFlatBuffer.a(i, 0);
            this.f14854e = mutableFlatBuffer.a(i, 1);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 818965534)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: divebar_availability_warning_turn_on */
    public final class BackgroundLocationPrivacyPickerOptionModel extends BaseModel implements GraphQLVisitableModel, PrivacyOptionWithIconFields, PrivacyOptionWithLegacyJsonFields {
        @Nullable
        private PrivacyIconFieldsModel f14856d;
        @Nullable
        private String f14857e;
        @Nullable
        private String f14858f;

        /* compiled from: divebar_availability_warning_turn_on */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(BackgroundLocationPrivacyPickerOptionModel.class, new Deserializer());
            }

            public Object m15309a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(BackgroundLocationPrivacyPickerOptionParser.m15324a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object backgroundLocationPrivacyPickerOptionModel = new BackgroundLocationPrivacyPickerOptionModel();
                ((BaseModel) backgroundLocationPrivacyPickerOptionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (backgroundLocationPrivacyPickerOptionModel instanceof Postprocessable) {
                    return ((Postprocessable) backgroundLocationPrivacyPickerOptionModel).a();
                }
                return backgroundLocationPrivacyPickerOptionModel;
            }
        }

        /* compiled from: divebar_availability_warning_turn_on */
        public class Serializer extends JsonSerializer<BackgroundLocationPrivacyPickerOptionModel> {
            public final void m15310a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                BackgroundLocationPrivacyPickerOptionModel backgroundLocationPrivacyPickerOptionModel = (BackgroundLocationPrivacyPickerOptionModel) obj;
                if (backgroundLocationPrivacyPickerOptionModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(backgroundLocationPrivacyPickerOptionModel.m15312a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    backgroundLocationPrivacyPickerOptionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                BackgroundLocationPrivacyPickerOptionParser.m15325a(backgroundLocationPrivacyPickerOptionModel.w_(), backgroundLocationPrivacyPickerOptionModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(BackgroundLocationPrivacyPickerOptionModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ PrivacyIconFields m15315b() {
            return m15311j();
        }

        public BackgroundLocationPrivacyPickerOptionModel() {
            super(3);
        }

        @Nullable
        private PrivacyIconFieldsModel m15311j() {
            this.f14856d = (PrivacyIconFieldsModel) super.a(this.f14856d, 0, PrivacyIconFieldsModel.class);
            return this.f14856d;
        }

        @Nullable
        public final String m15316c() {
            this.f14857e = super.a(this.f14857e, 1);
            return this.f14857e;
        }

        @Nullable
        public final String m15314a() {
            this.f14858f = super.a(this.f14858f, 2);
            return this.f14858f;
        }

        public final int jK_() {
            return -1984364035;
        }

        public final GraphQLVisitableModel m15313a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15311j() != null) {
                PrivacyIconFieldsModel privacyIconFieldsModel = (PrivacyIconFieldsModel) graphQLModelMutatingVisitor.b(m15311j());
                if (m15311j() != privacyIconFieldsModel) {
                    graphQLVisitableModel = (BackgroundLocationPrivacyPickerOptionModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f14856d = privacyIconFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15312a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15311j());
            int b = flatBufferBuilder.b(m15316c());
            int b2 = flatBufferBuilder.b(m15314a());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1933073804)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: divebar_availability_warning_turn_on */
    public final class BackgroundLocationPrivacyPickerOptionsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<BackgroundLocationPrivacyPickerOptionEdgeModel> f14859d;

        /* compiled from: divebar_availability_warning_turn_on */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(BackgroundLocationPrivacyPickerOptionsModel.class, new Deserializer());
            }

            public Object m15317a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(BackgroundLocationPrivacyPickerOptionsParser.m15326a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object backgroundLocationPrivacyPickerOptionsModel = new BackgroundLocationPrivacyPickerOptionsModel();
                ((BaseModel) backgroundLocationPrivacyPickerOptionsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (backgroundLocationPrivacyPickerOptionsModel instanceof Postprocessable) {
                    return ((Postprocessable) backgroundLocationPrivacyPickerOptionsModel).a();
                }
                return backgroundLocationPrivacyPickerOptionsModel;
            }
        }

        /* compiled from: divebar_availability_warning_turn_on */
        public class Serializer extends JsonSerializer<BackgroundLocationPrivacyPickerOptionsModel> {
            public final void m15318a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                BackgroundLocationPrivacyPickerOptionsModel backgroundLocationPrivacyPickerOptionsModel = (BackgroundLocationPrivacyPickerOptionsModel) obj;
                if (backgroundLocationPrivacyPickerOptionsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(backgroundLocationPrivacyPickerOptionsModel.m15319a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    backgroundLocationPrivacyPickerOptionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                BackgroundLocationPrivacyPickerOptionsParser.m15327a(backgroundLocationPrivacyPickerOptionsModel.w_(), backgroundLocationPrivacyPickerOptionsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(BackgroundLocationPrivacyPickerOptionsModel.class, new Serializer());
            }
        }

        public BackgroundLocationPrivacyPickerOptionsModel() {
            super(1);
        }

        @Nonnull
        public final ImmutableList<BackgroundLocationPrivacyPickerOptionEdgeModel> m15321a() {
            this.f14859d = super.a(this.f14859d, 0, BackgroundLocationPrivacyPickerOptionEdgeModel.class);
            return (ImmutableList) this.f14859d;
        }

        public final int jK_() {
            return 328826153;
        }

        public final GraphQLVisitableModel m15320a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15321a() != null) {
                Builder a = ModelHelper.a(m15321a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (BackgroundLocationPrivacyPickerOptionsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f14859d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15319a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15321a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}

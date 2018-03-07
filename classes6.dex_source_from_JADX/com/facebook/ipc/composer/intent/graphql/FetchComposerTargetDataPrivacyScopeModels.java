package com.facebook.ipc.composer.intent.graphql;

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
import com.facebook.ipc.composer.intent.graphql.FetchComposerTargetDataPrivacyScopeInterfaces.ComposerTargetDataPrivacyScopeFields;
import com.facebook.ipc.composer.intent.graphql.FetchComposerTargetDataPrivacyScopeParsers.ComposerTargetDataPrivacyScopeFieldsParser;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyIconFields;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLModels.PrivacyIconFieldsModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: life_event_categories */
public class FetchComposerTargetDataPrivacyScopeModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2019387173)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: life_event_categories */
    public final class ComposerTargetDataPrivacyScopeFieldsModel extends BaseModel implements GraphQLVisitableModel, ComposerTargetDataPrivacyScopeFields {
        @Nullable
        private PrivacyIconFieldsModel f11605d;
        @Nullable
        private String f11606e;

        /* compiled from: life_event_categories */
        public final class Builder {
            @Nullable
            public PrivacyIconFieldsModel f11603a;
            @Nullable
            public String f11604b;

            public final ComposerTargetDataPrivacyScopeFieldsModel m18309a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f11603a);
                int b = flatBufferBuilder.b(this.f11604b);
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new ComposerTargetDataPrivacyScopeFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: life_event_categories */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ComposerTargetDataPrivacyScopeFieldsModel.class, new Deserializer());
            }

            public Object m18310a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ComposerTargetDataPrivacyScopeFieldsParser.m18318a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object composerTargetDataPrivacyScopeFieldsModel = new ComposerTargetDataPrivacyScopeFieldsModel();
                ((BaseModel) composerTargetDataPrivacyScopeFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (composerTargetDataPrivacyScopeFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) composerTargetDataPrivacyScopeFieldsModel).a();
                }
                return composerTargetDataPrivacyScopeFieldsModel;
            }
        }

        /* compiled from: life_event_categories */
        public class Serializer extends JsonSerializer<ComposerTargetDataPrivacyScopeFieldsModel> {
            public final void m18311a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ComposerTargetDataPrivacyScopeFieldsModel composerTargetDataPrivacyScopeFieldsModel = (ComposerTargetDataPrivacyScopeFieldsModel) obj;
                if (composerTargetDataPrivacyScopeFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(composerTargetDataPrivacyScopeFieldsModel.m18314a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    composerTargetDataPrivacyScopeFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ComposerTargetDataPrivacyScopeFieldsParser.m18319a(composerTargetDataPrivacyScopeFieldsModel.w_(), composerTargetDataPrivacyScopeFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ComposerTargetDataPrivacyScopeFieldsModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ PrivacyIconFields mo1082a() {
            return m18313j();
        }

        public ComposerTargetDataPrivacyScopeFieldsModel() {
            super(2);
        }

        public ComposerTargetDataPrivacyScopeFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(2);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        private PrivacyIconFieldsModel m18313j() {
            this.f11605d = (PrivacyIconFieldsModel) super.a(this.f11605d, 0, PrivacyIconFieldsModel.class);
            return this.f11605d;
        }

        @Nullable
        public final String mo1083b() {
            this.f11606e = super.a(this.f11606e, 1);
            return this.f11606e;
        }

        public static ComposerTargetDataPrivacyScopeFieldsModel m18312a(ComposerTargetDataPrivacyScopeFields composerTargetDataPrivacyScopeFields) {
            if (composerTargetDataPrivacyScopeFields == null) {
                return null;
            }
            if (composerTargetDataPrivacyScopeFields instanceof ComposerTargetDataPrivacyScopeFieldsModel) {
                return (ComposerTargetDataPrivacyScopeFieldsModel) composerTargetDataPrivacyScopeFields;
            }
            Builder builder = new Builder();
            builder.f11603a = PrivacyIconFieldsModel.a(composerTargetDataPrivacyScopeFields.mo1082a());
            builder.f11604b = composerTargetDataPrivacyScopeFields.mo1083b();
            return builder.m18309a();
        }

        public final int jK_() {
            return -476351540;
        }

        public final GraphQLVisitableModel m18315a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m18313j() != null) {
                PrivacyIconFieldsModel privacyIconFieldsModel = (PrivacyIconFieldsModel) graphQLModelMutatingVisitor.b(m18313j());
                if (m18313j() != privacyIconFieldsModel) {
                    graphQLVisitableModel = (ComposerTargetDataPrivacyScopeFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11605d = privacyIconFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m18314a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m18313j());
            int b = flatBufferBuilder.b(mo1083b());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}

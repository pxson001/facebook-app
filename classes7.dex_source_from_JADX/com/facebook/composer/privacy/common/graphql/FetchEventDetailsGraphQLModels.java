package com.facebook.composer.privacy.common.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.composer.privacy.common.graphql.FetchEventDetailsGraphQLParsers.EventDetailsParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.ipc.composer.intent.graphql.FetchComposerTargetDataPrivacyScopeModels.ComposerTargetDataPrivacyScopeFieldsModel;
import com.facebook.ipc.composer.intent.graphql.FetchComposerTargetDataPrivacyScopeParsers.ComposerTargetDataPrivacyScopeFieldsParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: tapped_photos_at_page */
public class FetchEventDetailsGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1609080420)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: tapped_photos_at_page */
    public final class EventDetailsModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private String f2057d;
        @Nullable
        private ComposerTargetDataPrivacyScopeFieldsModel f2058e;

        /* compiled from: tapped_photos_at_page */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(EventDetailsModel.class, new Deserializer());
            }

            public Object m1996a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = EventDetailsParser.m2005a(jsonParser);
                Object eventDetailsModel = new EventDetailsModel();
                ((BaseModel) eventDetailsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (eventDetailsModel instanceof Postprocessable) {
                    return ((Postprocessable) eventDetailsModel).a();
                }
                return eventDetailsModel;
            }
        }

        /* compiled from: tapped_photos_at_page */
        public class Serializer extends JsonSerializer<EventDetailsModel> {
            public final void m1997a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                EventDetailsModel eventDetailsModel = (EventDetailsModel) obj;
                if (eventDetailsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(eventDetailsModel.m2000a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    eventDetailsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = eventDetailsModel.w_();
                int u_ = eventDetailsModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("privacy_scope");
                    ComposerTargetDataPrivacyScopeFieldsParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(EventDetailsModel.class, new Serializer());
            }
        }

        public EventDetailsModel() {
            super(2);
        }

        public final void m2003a(String str, ConsistencyTuple consistencyTuple) {
            if ("name".equals(str)) {
                consistencyTuple.a = m1999j();
                consistencyTuple.b = u_();
                consistencyTuple.c = 0;
                return;
            }
            consistencyTuple.a();
        }

        public final void m2004a(String str, Object obj, boolean z) {
            if ("name".equals(str)) {
                m1998a((String) obj);
            }
        }

        @Nullable
        private String m1999j() {
            this.f2057d = super.a(this.f2057d, 0);
            return this.f2057d;
        }

        private void m1998a(@Nullable String str) {
            this.f2057d = str;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 0, str);
            }
        }

        @Nullable
        public final ComposerTargetDataPrivacyScopeFieldsModel m2002a() {
            this.f2058e = (ComposerTargetDataPrivacyScopeFieldsModel) super.a(this.f2058e, 1, ComposerTargetDataPrivacyScopeFieldsModel.class);
            return this.f2058e;
        }

        public final int jK_() {
            return 67338874;
        }

        public final GraphQLVisitableModel m2001a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2002a() != null) {
                ComposerTargetDataPrivacyScopeFieldsModel composerTargetDataPrivacyScopeFieldsModel = (ComposerTargetDataPrivacyScopeFieldsModel) graphQLModelMutatingVisitor.b(m2002a());
                if (m2002a() != composerTargetDataPrivacyScopeFieldsModel) {
                    graphQLVisitableModel = (EventDetailsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f2058e = composerTargetDataPrivacyScopeFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2000a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m1999j());
            int a = ModelHelper.a(flatBufferBuilder, m2002a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}

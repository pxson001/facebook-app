package com.facebook.backgroundlocation.reporting.graphql;

import com.facebook.common.json.FbJsonDeserializer;
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
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import javax.annotation.Nullable;

/* compiled from: is_viewer_notified_about */
public class BackgroundLocationReportingGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1288162795)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: is_viewer_notified_about */
    public final class FetchBackgroundLocationReportingSettingsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private LocationSharingModel f9773d;

        /* compiled from: is_viewer_notified_about */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchBackgroundLocationReportingSettingsModel.class, new Deserializer());
            }

            public Object m11064a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = C0480x31029b21.m11065a(jsonParser);
                Object fetchBackgroundLocationReportingSettingsModel = new FetchBackgroundLocationReportingSettingsModel();
                ((BaseModel) fetchBackgroundLocationReportingSettingsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchBackgroundLocationReportingSettingsModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchBackgroundLocationReportingSettingsModel).a();
                }
                return fetchBackgroundLocationReportingSettingsModel;
            }
        }

        public FetchBackgroundLocationReportingSettingsModel() {
            super(1);
        }

        @Nullable
        public final LocationSharingModel m10201a() {
            this.f9773d = (LocationSharingModel) super.a(this.f9773d, 0, LocationSharingModel.class);
            return this.f9773d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m10202a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10201a() != null) {
                LocationSharingModel locationSharingModel = (LocationSharingModel) graphQLModelMutatingVisitor.b(m10201a());
                if (m10201a() != locationSharingModel) {
                    graphQLVisitableModel = (FetchBackgroundLocationReportingSettingsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9773d = locationSharingModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10200a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m10201a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1365876301)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: is_viewer_notified_about */
    public final class LocationSharingModel extends BaseModel implements GraphQLVisitableModel {
        private boolean f10536d;

        public LocationSharingModel() {
            super(1);
        }

        public final boolean m11073a() {
            a(0, 0);
            return this.f10536d;
        }

        public final int jK_() {
            return 924875591;
        }

        public final GraphQLVisitableModel m11071a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m11070a(FlatBufferBuilder flatBufferBuilder) {
            h();
            flatBufferBuilder.c(1);
            flatBufferBuilder.a(0, this.f10536d);
            i();
            return flatBufferBuilder.d();
        }

        public final void m11072a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f10536d = mutableFlatBuffer.a(i, 0);
        }
    }
}

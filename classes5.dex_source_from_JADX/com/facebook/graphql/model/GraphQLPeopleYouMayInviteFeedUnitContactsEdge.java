package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLPeopleYouMayInviteFeedUnitContactsEdgeDeserializer;
import com.facebook.graphql.model.PropertyBag.HasProperty;
import com.facebook.graphql.model.extras.BaseExtra;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.graphql.model.interfaces.HasTracking;
import com.facebook.graphql.model.interfaces.ItemListFeedUnitItem;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: WORK_FEEDBACK */
public final class GraphQLPeopleYouMayInviteFeedUnitContactsEdge extends BaseModel implements HasProperty, CacheableEntity, HasTracking, ItemListFeedUnitItem, TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLPeopleYouMayInviteFeedUnitContactsEdge> CREATOR = new C11641();
    @Nullable
    public String f12473d;
    @Nullable
    public String f12474e;
    @Nullable
    public String f12475f;
    @Nullable
    public GraphQLContactPoint f12476g;
    private PeopleYouMayInviteFeedUnitContactsEdgeExtra f12477h;
    @Nullable
    private PropertyBag f12478i = null;

    /* compiled from: WORK_FEEDBACK */
    final class C11641 implements Creator<GraphQLPeopleYouMayInviteFeedUnitContactsEdge> {
        C11641() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLPeopleYouMayInviteFeedUnitContactsEdge(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLPeopleYouMayInviteFeedUnitContactsEdge[i];
        }
    }

    /* compiled from: WORK_FEEDBACK */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLPeopleYouMayInviteFeedUnitContactsEdge.class, new Deserializer());
        }

        public Object m20654a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLPeopleYouMayInviteFeedUnitContactsEdgeDeserializer.m5579a(jsonParser, (short) 334);
            Object graphQLPeopleYouMayInviteFeedUnitContactsEdge = new GraphQLPeopleYouMayInviteFeedUnitContactsEdge();
            ((BaseModel) graphQLPeopleYouMayInviteFeedUnitContactsEdge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLPeopleYouMayInviteFeedUnitContactsEdge instanceof Postprocessable) {
                return ((Postprocessable) graphQLPeopleYouMayInviteFeedUnitContactsEdge).a();
            }
            return graphQLPeopleYouMayInviteFeedUnitContactsEdge;
        }
    }

    /* compiled from: WORK_FEEDBACK */
    public class PeopleYouMayInviteFeedUnitContactsEdgeExtra extends BaseExtra {
        public static final Creator<PeopleYouMayInviteFeedUnitContactsEdgeExtra> CREATOR = new C11651();
        public boolean f12472a = false;

        /* compiled from: WORK_FEEDBACK */
        final class C11651 implements Creator<PeopleYouMayInviteFeedUnitContactsEdgeExtra> {
            C11651() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new PeopleYouMayInviteFeedUnitContactsEdgeExtra(parcel);
            }

            public final Object[] newArray(int i) {
                return new PeopleYouMayInviteFeedUnitContactsEdgeExtra[i];
            }
        }

        protected PeopleYouMayInviteFeedUnitContactsEdgeExtra(Parcel parcel) {
            super((byte) 0);
        }

        public final int m20655a(FlatBufferBuilder flatBufferBuilder) {
            int a = super.a(flatBufferBuilder);
            flatBufferBuilder.c(2);
            if (a > 0) {
                flatBufferBuilder.b(0, a);
            }
            flatBufferBuilder.a(1, this.f12472a);
            return flatBufferBuilder.d();
        }

        public final void m20656a(MutableFlatBuffer mutableFlatBuffer, int i) {
            super.a(mutableFlatBuffer, mutableFlatBuffer.g(i, 0));
            this.f12472a = mutableFlatBuffer.a(i, 1);
        }
    }

    /* compiled from: WORK_FEEDBACK */
    public final class Serializer extends JsonSerializer<GraphQLPeopleYouMayInviteFeedUnitContactsEdge> {
        public final void m20657a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLPeopleYouMayInviteFeedUnitContactsEdge graphQLPeopleYouMayInviteFeedUnitContactsEdge = (GraphQLPeopleYouMayInviteFeedUnitContactsEdge) obj;
            GraphQLPeopleYouMayInviteFeedUnitContactsEdgeDeserializer.m5580b(graphQLPeopleYouMayInviteFeedUnitContactsEdge.w_(), graphQLPeopleYouMayInviteFeedUnitContactsEdge.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLPeopleYouMayInviteFeedUnitContactsEdge.class, new Serializer());
            FbSerializerProvider.a(GraphQLPeopleYouMayInviteFeedUnitContactsEdge.class, new Serializer());
        }
    }

    public final String m20660g() {
        return m20662k();
    }

    @FieldOffset
    @Nullable
    public final String m20661j() {
        this.f12473d = super.a(this.f12473d, 0);
        return this.f12473d;
    }

    @FieldOffset
    @Nullable
    public final String m20663l() {
        this.f12474e = super.a(this.f12474e, 1);
        return this.f12474e;
    }

    @FieldOffset
    @Nullable
    public final String m20662k() {
        this.f12475f = super.a(this.f12475f, 2);
        return this.f12475f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLContactPoint m20664m() {
        this.f12476g = (GraphQLContactPoint) super.a(this.f12476g, 3, GraphQLContactPoint.class);
        return this.f12476g;
    }

    public final int jK_() {
        return 1863959280;
    }

    public final GraphQLVisitableModel m20659a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m20664m() != null) {
            GraphQLContactPoint graphQLContactPoint = (GraphQLContactPoint) graphQLModelMutatingVisitor.b(m20664m());
            if (m20664m() != graphQLContactPoint) {
                graphQLVisitableModel = (GraphQLPeopleYouMayInviteFeedUnitContactsEdge) ModelHelper.a(null, this);
                graphQLVisitableModel.f12476g = graphQLContactPoint;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLPeopleYouMayInviteFeedUnitContactsEdge() {
        super(5);
    }

    public final int m20658a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m20661j());
        int b2 = flatBufferBuilder.b(m20663l());
        int b3 = flatBufferBuilder.b(m20662k());
        int a = ModelHelper.a(flatBufferBuilder, m20664m());
        flatBufferBuilder.c(4);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, b2);
        flatBufferBuilder.b(2, b3);
        flatBufferBuilder.b(3, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLPeopleYouMayInviteFeedUnitContactsEdge(Parcel parcel) {
        super(5);
        this.f12473d = parcel.readString();
        this.f12474e = parcel.readString();
        this.f12476g = (GraphQLContactPoint) parcel.readValue(GraphQLContactPoint.class.getClassLoader());
        this.f12475f = parcel.readString();
        this.f12477h = (PeopleYouMayInviteFeedUnitContactsEdgeExtra) ParcelUtil.m3828b(parcel, PeopleYouMayInviteFeedUnitContactsEdgeExtra.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m20661j());
        parcel.writeString(m20663l());
        parcel.writeValue(m20664m());
        parcel.writeString(m20662k());
        parcel.writeParcelable(m20665n(), i);
    }

    public final PeopleYouMayInviteFeedUnitContactsEdgeExtra m20665n() {
        if (this.f12477h == null) {
            if (this.b == null || !this.b.d) {
                this.f12477h = new PeopleYouMayInviteFeedUnitContactsEdgeExtra();
            } else {
                this.f12477h = (PeopleYouMayInviteFeedUnitContactsEdgeExtra) this.b.a(this.c, this, PeopleYouMayInviteFeedUnitContactsEdgeExtra.class);
            }
        }
        return this.f12477h;
    }

    public final PropertyBag U_() {
        if (this.f12478i == null) {
            this.f12478i = new PropertyBag();
        }
        return this.f12478i;
    }
}

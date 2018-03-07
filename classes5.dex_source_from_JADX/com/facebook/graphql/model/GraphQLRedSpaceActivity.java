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
import com.facebook.graphql.deserializers.GraphQLRedSpaceActivityDeserializer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLRedSpaceActivityType;
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
/* compiled from: VIDEO_SETS_CACHE_CHECK */
public final class GraphQLRedSpaceActivity extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLRedSpaceActivity> CREATOR = new C12041();
    @Nullable
    public GraphQLObjectType f12901d;
    public GraphQLRedSpaceActivityType f12902e;
    @Nullable
    public GraphQLIcon f12903f;
    @Nullable
    public GraphQLTextWithEntities f12904g;
    @Nullable
    public String f12905h;
    @Nullable
    public String f12906i;
    @Nullable
    public GraphQLPage f12907j;
    @Nullable
    public String f12908k;
    @Nullable
    public GraphQLTimezoneInfo f12909l;

    /* compiled from: VIDEO_SETS_CACHE_CHECK */
    final class C12041 implements Creator<GraphQLRedSpaceActivity> {
        C12041() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLRedSpaceActivity(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLRedSpaceActivity[i];
        }
    }

    /* compiled from: VIDEO_SETS_CACHE_CHECK */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLRedSpaceActivity.class, new Deserializer());
        }

        public Object m21354a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLRedSpaceActivityDeserializer.m5794a(jsonParser, (short) 552);
            Object graphQLRedSpaceActivity = new GraphQLRedSpaceActivity();
            ((BaseModel) graphQLRedSpaceActivity).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLRedSpaceActivity instanceof Postprocessable) {
                return ((Postprocessable) graphQLRedSpaceActivity).a();
            }
            return graphQLRedSpaceActivity;
        }
    }

    /* compiled from: VIDEO_SETS_CACHE_CHECK */
    public final class Serializer extends JsonSerializer<GraphQLRedSpaceActivity> {
        public final void m21355a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLRedSpaceActivity graphQLRedSpaceActivity = (GraphQLRedSpaceActivity) obj;
            GraphQLRedSpaceActivityDeserializer.m5795a(graphQLRedSpaceActivity.w_(), graphQLRedSpaceActivity.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLRedSpaceActivity.class, new Serializer());
            FbSerializerProvider.a(GraphQLRedSpaceActivity.class, new Serializer());
        }
    }

    @Nullable
    public final GraphQLObjectType m21357a() {
        if (this.b != null && this.f12901d == null) {
            this.f12901d = new GraphQLObjectType(this.b.b(this.c, 0));
        }
        if (this.f12901d == null || this.f12901d.g() != 0) {
            return this.f12901d;
        }
        return null;
    }

    @FieldOffset
    public final GraphQLRedSpaceActivityType m21359j() {
        this.f12902e = (GraphQLRedSpaceActivityType) super.a(this.f12902e, 1, GraphQLRedSpaceActivityType.class, GraphQLRedSpaceActivityType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f12902e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLIcon m21360k() {
        this.f12903f = (GraphQLIcon) super.a(this.f12903f, 2, GraphQLIcon.class);
        return this.f12903f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m21361l() {
        this.f12904g = (GraphQLTextWithEntities) super.a(this.f12904g, 3, GraphQLTextWithEntities.class);
        return this.f12904g;
    }

    @FieldOffset
    @Nullable
    public final String m21362m() {
        this.f12905h = super.a(this.f12905h, 4);
        return this.f12905h;
    }

    @FieldOffset
    @Nullable
    public final String m21363n() {
        this.f12906i = super.a(this.f12906i, 5);
        return this.f12906i;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPage m21364o() {
        this.f12907j = (GraphQLPage) super.a(this.f12907j, 6, GraphQLPage.class);
        return this.f12907j;
    }

    @FieldOffset
    @Nullable
    public final String m21365p() {
        this.f12908k = super.a(this.f12908k, 7);
        return this.f12908k;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTimezoneInfo m21366q() {
        this.f12909l = (GraphQLTimezoneInfo) super.a(this.f12909l, 8, GraphQLTimezoneInfo.class);
        return this.f12909l;
    }

    public final int jK_() {
        return -1537945276;
    }

    public final GraphQLVisitableModel m21358a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m21364o() != null) {
            GraphQLPage graphQLPage = (GraphQLPage) graphQLModelMutatingVisitor.b(m21364o());
            if (m21364o() != graphQLPage) {
                graphQLVisitableModel = (GraphQLRedSpaceActivity) ModelHelper.a(null, this);
                graphQLVisitableModel.f12907j = graphQLPage;
            }
        }
        if (m21360k() != null) {
            GraphQLIcon graphQLIcon = (GraphQLIcon) graphQLModelMutatingVisitor.b(m21360k());
            if (m21360k() != graphQLIcon) {
                graphQLVisitableModel = (GraphQLRedSpaceActivity) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12903f = graphQLIcon;
            }
        }
        if (m21361l() != null) {
            GraphQLTextWithEntities graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m21361l());
            if (m21361l() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLRedSpaceActivity) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12904g = graphQLTextWithEntities;
            }
        }
        if (m21366q() != null) {
            GraphQLTimezoneInfo graphQLTimezoneInfo = (GraphQLTimezoneInfo) graphQLModelMutatingVisitor.b(m21366q());
            if (m21366q() != graphQLTimezoneInfo) {
                graphQLVisitableModel = (GraphQLRedSpaceActivity) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12909l = graphQLTimezoneInfo;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLRedSpaceActivity() {
        super(10);
    }

    public final int m21356a(FlatBufferBuilder flatBufferBuilder) {
        Enum enumR = null;
        h();
        int a = flatBufferBuilder.a(m21357a() != null ? m21357a().e() : null);
        int a2 = ModelHelper.a(flatBufferBuilder, m21360k());
        int a3 = ModelHelper.a(flatBufferBuilder, m21361l());
        int b = flatBufferBuilder.b(m21362m());
        int b2 = flatBufferBuilder.b(m21363n());
        int a4 = ModelHelper.a(flatBufferBuilder, m21364o());
        int b3 = flatBufferBuilder.b(m21365p());
        int a5 = ModelHelper.a(flatBufferBuilder, m21366q());
        flatBufferBuilder.c(9);
        flatBufferBuilder.b(0, a);
        if (m21359j() != GraphQLRedSpaceActivityType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
            enumR = m21359j();
        }
        flatBufferBuilder.a(1, enumR);
        flatBufferBuilder.b(2, a2);
        flatBufferBuilder.b(3, a3);
        flatBufferBuilder.b(4, b);
        flatBufferBuilder.b(5, b2);
        flatBufferBuilder.b(6, a4);
        flatBufferBuilder.b(7, b3);
        flatBufferBuilder.b(8, a5);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLRedSpaceActivity(Parcel parcel) {
        super(10);
        this.f12902e = GraphQLRedSpaceActivityType.fromString(parcel.readString());
        this.f12907j = (GraphQLPage) parcel.readValue(GraphQLPage.class.getClassLoader());
        this.f12905h = parcel.readString();
        this.f12903f = (GraphQLIcon) parcel.readValue(GraphQLIcon.class.getClassLoader());
        this.f12904g = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f12908k = parcel.readString();
        this.f12909l = (GraphQLTimezoneInfo) parcel.readValue(GraphQLTimezoneInfo.class.getClassLoader());
        this.f12906i = parcel.readString();
        this.f12901d = (GraphQLObjectType) ParcelUtil.m3828b(parcel, GraphQLObjectType.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m21359j().name());
        parcel.writeValue(m21364o());
        parcel.writeString(m21362m());
        parcel.writeValue(m21360k());
        parcel.writeValue(m21361l());
        parcel.writeString(m21365p());
        parcel.writeValue(m21366q());
        parcel.writeString(m21363n());
        parcel.writeParcelable(this.f12901d, i);
    }
}

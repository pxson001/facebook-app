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
import com.facebook.graphql.deserializers.GraphQLSideFeedUnitDeserializer;
import com.facebook.graphql.enums.GraphQLObjectType;
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
/* compiled from: VEGETARIAN_VEGAN_RESTAURANT */
public final class GraphQLSideFeedUnit extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLSideFeedUnit> CREATOR = new C12241();
    @Nullable
    public GraphQLObjectType f13021d;
    @Nullable
    public GraphQLAppAdStoriesSideFeedConnection f13022e;

    /* compiled from: VEGETARIAN_VEGAN_RESTAURANT */
    final class C12241 implements Creator<GraphQLSideFeedUnit> {
        C12241() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLSideFeedUnit(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLSideFeedUnit[i];
        }
    }

    /* compiled from: VEGETARIAN_VEGAN_RESTAURANT */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLSideFeedUnit.class, new Deserializer());
        }

        public Object m21648a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLSideFeedUnitDeserializer.m5887a(jsonParser, (short) 509);
            Object graphQLSideFeedUnit = new GraphQLSideFeedUnit();
            ((BaseModel) graphQLSideFeedUnit).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLSideFeedUnit instanceof Postprocessable) {
                return ((Postprocessable) graphQLSideFeedUnit).a();
            }
            return graphQLSideFeedUnit;
        }
    }

    /* compiled from: VEGETARIAN_VEGAN_RESTAURANT */
    public final class Serializer extends JsonSerializer<GraphQLSideFeedUnit> {
        public final void m21649a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLSideFeedUnit graphQLSideFeedUnit = (GraphQLSideFeedUnit) obj;
            GraphQLSideFeedUnitDeserializer.m5888a(graphQLSideFeedUnit.w_(), graphQLSideFeedUnit.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLSideFeedUnit.class, new Serializer());
            FbSerializerProvider.a(GraphQLSideFeedUnit.class, new Serializer());
        }
    }

    @Nullable
    public final GraphQLObjectType m21651a() {
        if (this.b != null && this.f13021d == null) {
            this.f13021d = new GraphQLObjectType(this.b.b(this.c, 0));
        }
        if (this.f13021d == null || this.f13021d.g() != 0) {
            return this.f13021d;
        }
        return null;
    }

    @FieldOffset
    @Nullable
    public final GraphQLAppAdStoriesSideFeedConnection m21653j() {
        this.f13022e = (GraphQLAppAdStoriesSideFeedConnection) super.a(this.f13022e, 1, GraphQLAppAdStoriesSideFeedConnection.class);
        return this.f13022e;
    }

    public final int jK_() {
        return 1954579161;
    }

    public final GraphQLVisitableModel m21652a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m21653j() != null) {
            GraphQLAppAdStoriesSideFeedConnection graphQLAppAdStoriesSideFeedConnection = (GraphQLAppAdStoriesSideFeedConnection) graphQLModelMutatingVisitor.b(m21653j());
            if (m21653j() != graphQLAppAdStoriesSideFeedConnection) {
                graphQLVisitableModel = (GraphQLSideFeedUnit) ModelHelper.a(null, this);
                graphQLVisitableModel.f13022e = graphQLAppAdStoriesSideFeedConnection;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLSideFeedUnit() {
        super(3);
    }

    public final int m21650a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = flatBufferBuilder.a(m21651a() != null ? m21651a().e() : null);
        int a2 = ModelHelper.a(flatBufferBuilder, m21653j());
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, a2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLSideFeedUnit(Parcel parcel) {
        super(3);
        this.f13022e = (GraphQLAppAdStoriesSideFeedConnection) parcel.readValue(GraphQLAppAdStoriesSideFeedConnection.class.getClassLoader());
        this.f13021d = (GraphQLObjectType) ParcelUtil.m3828b(parcel, GraphQLObjectType.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m21653j());
        parcel.writeParcelable(this.f13021d, i);
    }
}

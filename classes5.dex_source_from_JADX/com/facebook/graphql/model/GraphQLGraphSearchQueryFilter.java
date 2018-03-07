package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLGraphSearchQueryFilterDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
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
/* compiled from: getAveragePower */
public final class GraphQLGraphSearchQueryFilter extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLGraphSearchQueryFilter> CREATOR = new C03751();
    @Nullable
    GraphQLGraphSearchQueryFilterValue f4075d;
    @Nullable
    GraphQLGraphSearchQueryFilterCustomValue f4076e;
    @Nullable
    String f4077f;
    @Nullable
    GraphQLGraphSearchQueryFilterValuesConnection f4078g;
    @Nullable
    String f4079h;
    @Nullable
    String f4080i;
    @Nullable
    String f4081j;
    @Nullable
    String f4082k;
    @Nullable
    String f4083l;

    /* compiled from: getAveragePower */
    final class C03751 implements Creator<GraphQLGraphSearchQueryFilter> {
        C03751() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLGraphSearchQueryFilter(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLGraphSearchQueryFilter[i];
        }
    }

    /* compiled from: getAveragePower */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLGraphSearchQueryFilter.class, new Deserializer());
        }

        public Object m8199a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLGraphSearchQueryFilterDeserializer.m5090a(jsonParser, (short) 93);
            Object graphQLGraphSearchQueryFilter = new GraphQLGraphSearchQueryFilter();
            ((BaseModel) graphQLGraphSearchQueryFilter).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLGraphSearchQueryFilter instanceof Postprocessable) {
                return ((Postprocessable) graphQLGraphSearchQueryFilter).a();
            }
            return graphQLGraphSearchQueryFilter;
        }
    }

    /* compiled from: getAveragePower */
    public final class Serializer extends JsonSerializer<GraphQLGraphSearchQueryFilter> {
        public final void m8200a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLGraphSearchQueryFilter graphQLGraphSearchQueryFilter = (GraphQLGraphSearchQueryFilter) obj;
            GraphQLGraphSearchQueryFilterDeserializer.m5091a(graphQLGraphSearchQueryFilter.w_(), graphQLGraphSearchQueryFilter.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLGraphSearchQueryFilter.class, new Serializer());
            FbSerializerProvider.a(GraphQLGraphSearchQueryFilter.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLGraphSearchQueryFilterValue m8204j() {
        this.f4075d = (GraphQLGraphSearchQueryFilterValue) super.a(this.f4075d, 0, GraphQLGraphSearchQueryFilterValue.class);
        return this.f4075d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLGraphSearchQueryFilterCustomValue m8205k() {
        this.f4076e = (GraphQLGraphSearchQueryFilterCustomValue) super.a(this.f4076e, 1, GraphQLGraphSearchQueryFilterCustomValue.class);
        return this.f4076e;
    }

    @FieldOffset
    @Nullable
    public final String m8206l() {
        this.f4077f = super.a(this.f4077f, 2);
        return this.f4077f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLGraphSearchQueryFilterValuesConnection m8207m() {
        this.f4078g = (GraphQLGraphSearchQueryFilterValuesConnection) super.a(this.f4078g, 4, GraphQLGraphSearchQueryFilterValuesConnection.class);
        return this.f4078g;
    }

    @FieldOffset
    @Nullable
    public final String m8208n() {
        this.f4079h = super.a(this.f4079h, 5);
        return this.f4079h;
    }

    @FieldOffset
    @Nullable
    public final String m8209o() {
        this.f4080i = super.a(this.f4080i, 6);
        return this.f4080i;
    }

    @FieldOffset
    @Nullable
    public final String m8210p() {
        this.f4081j = super.a(this.f4081j, 7);
        return this.f4081j;
    }

    @FieldOffset
    @Nullable
    public final String m8211q() {
        this.f4082k = super.a(this.f4082k, 8);
        return this.f4082k;
    }

    @FieldOffset
    @Nullable
    public final String m8212r() {
        this.f4083l = super.a(this.f4083l, 9);
        return this.f4083l;
    }

    @Nullable
    public final String m8203a() {
        return m8209o();
    }

    public final int jK_() {
        return -1440418806;
    }

    public final GraphQLVisitableModel m8202a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m8204j() != null) {
            GraphQLGraphSearchQueryFilterValue graphQLGraphSearchQueryFilterValue = (GraphQLGraphSearchQueryFilterValue) graphQLModelMutatingVisitor.b(m8204j());
            if (m8204j() != graphQLGraphSearchQueryFilterValue) {
                graphQLVisitableModel = (GraphQLGraphSearchQueryFilter) ModelHelper.a(null, this);
                graphQLVisitableModel.f4075d = graphQLGraphSearchQueryFilterValue;
            }
        }
        if (m8205k() != null) {
            GraphQLGraphSearchQueryFilterCustomValue graphQLGraphSearchQueryFilterCustomValue = (GraphQLGraphSearchQueryFilterCustomValue) graphQLModelMutatingVisitor.b(m8205k());
            if (m8205k() != graphQLGraphSearchQueryFilterCustomValue) {
                graphQLVisitableModel = (GraphQLGraphSearchQueryFilter) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4076e = graphQLGraphSearchQueryFilterCustomValue;
            }
        }
        if (m8207m() != null) {
            GraphQLGraphSearchQueryFilterValuesConnection graphQLGraphSearchQueryFilterValuesConnection = (GraphQLGraphSearchQueryFilterValuesConnection) graphQLModelMutatingVisitor.b(m8207m());
            if (m8207m() != graphQLGraphSearchQueryFilterValuesConnection) {
                graphQLVisitableModel = (GraphQLGraphSearchQueryFilter) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4078g = graphQLGraphSearchQueryFilterValuesConnection;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLGraphSearchQueryFilter() {
        super(11);
    }

    public final int m8201a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m8204j());
        int a2 = ModelHelper.a(flatBufferBuilder, m8205k());
        int b = flatBufferBuilder.b(m8206l());
        int a3 = ModelHelper.a(flatBufferBuilder, m8207m());
        int b2 = flatBufferBuilder.b(m8208n());
        int b3 = flatBufferBuilder.b(m8209o());
        int b4 = flatBufferBuilder.b(m8210p());
        int b5 = flatBufferBuilder.b(m8211q());
        int b6 = flatBufferBuilder.b(m8212r());
        flatBufferBuilder.c(10);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, a2);
        flatBufferBuilder.b(2, b);
        flatBufferBuilder.b(4, a3);
        flatBufferBuilder.b(5, b2);
        flatBufferBuilder.b(6, b3);
        flatBufferBuilder.b(7, b4);
        flatBufferBuilder.b(8, b5);
        flatBufferBuilder.b(9, b6);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLGraphSearchQueryFilter(Parcel parcel) {
        super(11);
        this.f4075d = (GraphQLGraphSearchQueryFilterValue) parcel.readValue(GraphQLGraphSearchQueryFilterValue.class.getClassLoader());
        this.f4076e = (GraphQLGraphSearchQueryFilterCustomValue) parcel.readValue(GraphQLGraphSearchQueryFilterCustomValue.class.getClassLoader());
        this.f4077f = parcel.readString();
        this.f4078g = (GraphQLGraphSearchQueryFilterValuesConnection) parcel.readValue(GraphQLGraphSearchQueryFilterValuesConnection.class.getClassLoader());
        this.f4079h = parcel.readString();
        this.f4080i = parcel.readString();
        this.f4081j = parcel.readString();
        this.f4083l = parcel.readString();
        this.f4082k = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m8204j());
        parcel.writeValue(m8205k());
        parcel.writeString(m8206l());
        parcel.writeValue(m8207m());
        parcel.writeString(m8208n());
        parcel.writeString(m8209o());
        parcel.writeString(m8210p());
        parcel.writeString(m8212r());
        parcel.writeString(m8211q());
    }
}

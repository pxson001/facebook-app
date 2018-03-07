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
import com.facebook.graphql.deserializers.GraphQLSouvenirMediaElementMediaConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: Unsupported object for column  */
public final class GraphQLSouvenirMediaElementMediaConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLSouvenirMediaElementMediaConnection> CREATOR = new C12311();
    public List<GraphQLSouvenirMediaElementMediaEdge> f13040d;

    /* compiled from: Unsupported object for column  */
    final class C12311 implements Creator<GraphQLSouvenirMediaElementMediaConnection> {
        C12311() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLSouvenirMediaElementMediaConnection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLSouvenirMediaElementMediaConnection[i];
        }
    }

    /* compiled from: Unsupported object for column  */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLSouvenirMediaElementMediaConnection.class, new Deserializer());
        }

        public Object m21729a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLSouvenirMediaElementMediaConnectionDeserializer.m5916a(jsonParser, (short) 229);
            Object graphQLSouvenirMediaElementMediaConnection = new GraphQLSouvenirMediaElementMediaConnection();
            ((BaseModel) graphQLSouvenirMediaElementMediaConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLSouvenirMediaElementMediaConnection instanceof Postprocessable) {
                return ((Postprocessable) graphQLSouvenirMediaElementMediaConnection).a();
            }
            return graphQLSouvenirMediaElementMediaConnection;
        }
    }

    /* compiled from: Unsupported object for column  */
    public final class Serializer extends JsonSerializer<GraphQLSouvenirMediaElementMediaConnection> {
        public final void m21730a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLSouvenirMediaElementMediaConnection graphQLSouvenirMediaElementMediaConnection = (GraphQLSouvenirMediaElementMediaConnection) obj;
            GraphQLSouvenirMediaElementMediaConnectionDeserializer.m5917a(graphQLSouvenirMediaElementMediaConnection.w_(), graphQLSouvenirMediaElementMediaConnection.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLSouvenirMediaElementMediaConnection.class, new Serializer());
            FbSerializerProvider.a(GraphQLSouvenirMediaElementMediaConnection.class, new Serializer());
        }
    }

    @FieldOffset
    public final ImmutableList<GraphQLSouvenirMediaElementMediaEdge> m21733a() {
        this.f13040d = super.a(this.f13040d, 0, GraphQLSouvenirMediaElementMediaEdge.class);
        return (ImmutableList) this.f13040d;
    }

    public final int jK_() {
        return 228004763;
    }

    public final GraphQLVisitableModel m21732a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m21733a() != null) {
            Builder a = ModelHelper.a(m21733a(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLSouvenirMediaElementMediaConnection) ModelHelper.a(null, this);
                graphQLVisitableModel.f13040d = a.b();
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLSouvenirMediaElementMediaConnection() {
        super(2);
    }

    public final int m21731a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m21733a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLSouvenirMediaElementMediaConnection(Parcel parcel) {
        super(2);
        this.f13040d = ImmutableListHelper.a(parcel.readArrayList(GraphQLSouvenirMediaElementMediaEdge.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m21733a());
    }
}

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
import com.facebook.graphql.deserializers.GraphQLGoodwillThrowbackPromotedCampaignsConnectionDeserializer;
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
/* compiled from: getTcpBytesReceived */
public final class GraphQLGoodwillThrowbackPromotedCampaignsConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLGoodwillThrowbackPromotedCampaignsConnection> CREATOR = new C03641();
    public List<GraphQLGoodwillCampaign> f4030d;

    /* compiled from: getTcpBytesReceived */
    final class C03641 implements Creator<GraphQLGoodwillThrowbackPromotedCampaignsConnection> {
        C03641() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLGoodwillThrowbackPromotedCampaignsConnection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLGoodwillThrowbackPromotedCampaignsConnection[i];
        }
    }

    /* compiled from: getTcpBytesReceived */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLGoodwillThrowbackPromotedCampaignsConnection.class, new Deserializer());
        }

        public Object m8070a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLGoodwillThrowbackPromotedCampaignsConnectionDeserializer.m5057a(jsonParser, (short) 368);
            Object graphQLGoodwillThrowbackPromotedCampaignsConnection = new GraphQLGoodwillThrowbackPromotedCampaignsConnection();
            ((BaseModel) graphQLGoodwillThrowbackPromotedCampaignsConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLGoodwillThrowbackPromotedCampaignsConnection instanceof Postprocessable) {
                return ((Postprocessable) graphQLGoodwillThrowbackPromotedCampaignsConnection).a();
            }
            return graphQLGoodwillThrowbackPromotedCampaignsConnection;
        }
    }

    /* compiled from: getTcpBytesReceived */
    public final class Serializer extends JsonSerializer<GraphQLGoodwillThrowbackPromotedCampaignsConnection> {
        public final void m8071a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLGoodwillThrowbackPromotedCampaignsConnection graphQLGoodwillThrowbackPromotedCampaignsConnection = (GraphQLGoodwillThrowbackPromotedCampaignsConnection) obj;
            GraphQLGoodwillThrowbackPromotedCampaignsConnectionDeserializer.m5058a(graphQLGoodwillThrowbackPromotedCampaignsConnection.w_(), graphQLGoodwillThrowbackPromotedCampaignsConnection.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLGoodwillThrowbackPromotedCampaignsConnection.class, new Serializer());
            FbSerializerProvider.a(GraphQLGoodwillThrowbackPromotedCampaignsConnection.class, new Serializer());
        }
    }

    @FieldOffset
    public final ImmutableList<GraphQLGoodwillCampaign> m8074a() {
        this.f4030d = super.a(this.f4030d, 0, GraphQLGoodwillCampaign.class);
        return (ImmutableList) this.f4030d;
    }

    public final int jK_() {
        return 821104415;
    }

    public final GraphQLVisitableModel m8073a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m8074a() != null) {
            Builder a = ModelHelper.a(m8074a(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackPromotedCampaignsConnection) ModelHelper.a(null, this);
                graphQLVisitableModel.f4030d = a.b();
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLGoodwillThrowbackPromotedCampaignsConnection() {
        super(2);
    }

    public final int m8072a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m8074a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLGoodwillThrowbackPromotedCampaignsConnection(Parcel parcel) {
        super(2);
        this.f4030d = ImmutableListHelper.a(parcel.readArrayList(GraphQLGoodwillCampaign.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m8074a());
    }
}

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
import com.facebook.graphql.deserializers.C0240xd8bd97ec;
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
/* compiled from: group_commerce */
public final class GraphQLGoodwillBirthdayCampaignPostingActorsConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLGoodwillBirthdayCampaignPostingActorsConnection> CREATOR = new C03421();
    public List<GraphQLUser> f3878d;

    /* compiled from: group_commerce */
    final class C03421 implements Creator<GraphQLGoodwillBirthdayCampaignPostingActorsConnection> {
        C03421() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLGoodwillBirthdayCampaignPostingActorsConnection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLGoodwillBirthdayCampaignPostingActorsConnection[i];
        }
    }

    /* compiled from: group_commerce */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLGoodwillBirthdayCampaignPostingActorsConnection.class, new Deserializer());
        }

        public Object m7809a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = C0240xd8bd97ec.m5006a(jsonParser, (short) 369);
            Object graphQLGoodwillBirthdayCampaignPostingActorsConnection = new GraphQLGoodwillBirthdayCampaignPostingActorsConnection();
            ((BaseModel) graphQLGoodwillBirthdayCampaignPostingActorsConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLGoodwillBirthdayCampaignPostingActorsConnection instanceof Postprocessable) {
                return ((Postprocessable) graphQLGoodwillBirthdayCampaignPostingActorsConnection).a();
            }
            return graphQLGoodwillBirthdayCampaignPostingActorsConnection;
        }
    }

    /* compiled from: group_commerce */
    public final class Serializer extends JsonSerializer<GraphQLGoodwillBirthdayCampaignPostingActorsConnection> {
        public final void m7810a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLGoodwillBirthdayCampaignPostingActorsConnection graphQLGoodwillBirthdayCampaignPostingActorsConnection = (GraphQLGoodwillBirthdayCampaignPostingActorsConnection) obj;
            C0240xd8bd97ec.m5007a(graphQLGoodwillBirthdayCampaignPostingActorsConnection.w_(), graphQLGoodwillBirthdayCampaignPostingActorsConnection.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLGoodwillBirthdayCampaignPostingActorsConnection.class, new Serializer());
            FbSerializerProvider.a(GraphQLGoodwillBirthdayCampaignPostingActorsConnection.class, new Serializer());
        }
    }

    @FieldOffset
    public final ImmutableList<GraphQLUser> m7813a() {
        this.f3878d = super.a(this.f3878d, 0, GraphQLUser.class);
        return (ImmutableList) this.f3878d;
    }

    public final int jK_() {
        return 641968994;
    }

    public final GraphQLVisitableModel m7812a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m7813a() != null) {
            Builder a = ModelHelper.a(m7813a(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLGoodwillBirthdayCampaignPostingActorsConnection) ModelHelper.a(null, this);
                graphQLVisitableModel.f3878d = a.b();
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLGoodwillBirthdayCampaignPostingActorsConnection() {
        super(2);
    }

    public final int m7811a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m7813a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLGoodwillBirthdayCampaignPostingActorsConnection(Parcel parcel) {
        super(2);
        this.f3878d = ImmutableListHelper.a(parcel.readArrayList(GraphQLUser.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m7813a());
    }
}

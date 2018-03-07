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
import com.facebook.graphql.deserializers.GraphQLAppListDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
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
/* compiled from: item_links */
public final class GraphQLAppList extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLAppList> CREATOR = new C02671();
    @Nullable
    String f3348d;
    @Nullable
    String f3349e;

    /* compiled from: item_links */
    final class C02671 implements Creator<GraphQLAppList> {
        C02671() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLAppList(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLAppList[i];
        }
    }

    /* compiled from: item_links */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLAppList.class, new Deserializer());
        }

        public Object m6560a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLAppListDeserializer.m4571a(jsonParser, (short) 73);
            Object graphQLAppList = new GraphQLAppList();
            ((BaseModel) graphQLAppList).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLAppList instanceof Postprocessable) {
                return ((Postprocessable) graphQLAppList).a();
            }
            return graphQLAppList;
        }
    }

    /* compiled from: item_links */
    public final class Serializer extends JsonSerializer<GraphQLAppList> {
        public final void m6561a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLAppList graphQLAppList = (GraphQLAppList) obj;
            GraphQLAppListDeserializer.m4572a(graphQLAppList.w_(), graphQLAppList.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(GraphQLAppList.class, new Serializer());
            FbSerializerProvider.a(GraphQLAppList.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final String m6565j() {
        this.f3348d = super.a(this.f3348d, 1);
        return this.f3348d;
    }

    @FieldOffset
    @Nullable
    public final String m6566k() {
        this.f3349e = super.a(this.f3349e, 3);
        return this.f3349e;
    }

    @Nullable
    public final String m6564a() {
        return m6565j();
    }

    public final int jK_() {
        return 870465087;
    }

    public final GraphQLVisitableModel m6563a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public GraphQLAppList() {
        super(5);
    }

    public final int m6562a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m6565j());
        int b2 = flatBufferBuilder.b(m6566k());
        flatBufferBuilder.c(4);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.b(3, b2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLAppList(Parcel parcel) {
        super(5);
        this.f3348d = parcel.readString();
        this.f3349e = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m6565j());
        parcel.writeString(m6566k());
    }
}

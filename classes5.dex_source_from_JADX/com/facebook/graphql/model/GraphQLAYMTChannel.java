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
import com.facebook.graphql.deserializers.GraphQLAYMTChannelDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: layout_y */
public final class GraphQLAYMTChannel extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLAYMTChannel> CREATOR = new C02541();
    @Nullable
    String f3255d;
    List<GraphQLAYMTTip> f3256e;
    @Nullable
    String f3257f;

    /* compiled from: layout_y */
    final class C02541 implements Creator<GraphQLAYMTChannel> {
        C02541() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLAYMTChannel(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLAYMTChannel[i];
        }
    }

    /* compiled from: layout_y */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLAYMTChannel.class, new Deserializer());
        }

        public Object m6343a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLAYMTChannelDeserializer.m4506a(jsonParser, (short) 11);
            Object graphQLAYMTChannel = new GraphQLAYMTChannel();
            ((BaseModel) graphQLAYMTChannel).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLAYMTChannel instanceof Postprocessable) {
                return ((Postprocessable) graphQLAYMTChannel).a();
            }
            return graphQLAYMTChannel;
        }
    }

    /* compiled from: layout_y */
    public final class Serializer extends JsonSerializer<GraphQLAYMTChannel> {
        public final void m6344a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLAYMTChannel graphQLAYMTChannel = (GraphQLAYMTChannel) obj;
            GraphQLAYMTChannelDeserializer.m4507a(graphQLAYMTChannel.w_(), graphQLAYMTChannel.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLAYMTChannel.class, new Serializer());
            FbSerializerProvider.a(GraphQLAYMTChannel.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final String m6348j() {
        this.f3255d = super.a(this.f3255d, 0);
        return this.f3255d;
    }

    @FieldOffset
    public final ImmutableList<GraphQLAYMTTip> m6349k() {
        this.f3256e = super.a(this.f3256e, 1, GraphQLAYMTTip.class);
        return (ImmutableList) this.f3256e;
    }

    @FieldOffset
    @Nullable
    public final String m6350l() {
        this.f3257f = super.a(this.f3257f, 2);
        return this.f3257f;
    }

    @Nullable
    public final String m6347a() {
        return m6348j();
    }

    public final int jK_() {
        return -111810524;
    }

    public final GraphQLVisitableModel m6346a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m6349k() != null) {
            Builder a = ModelHelper.a(m6349k(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLAYMTChannel) ModelHelper.a(null, this);
                graphQLVisitableModel.f3256e = a.b();
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLAYMTChannel() {
        super(4);
    }

    public final int m6345a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m6348j());
        int a = ModelHelper.a(flatBufferBuilder, m6349k());
        int b2 = flatBufferBuilder.b(m6350l());
        flatBufferBuilder.c(3);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, a);
        flatBufferBuilder.b(2, b2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLAYMTChannel(Parcel parcel) {
        super(4);
        this.f3255d = parcel.readString();
        this.f3256e = ImmutableListHelper.a(parcel.readArrayList(GraphQLAYMTTip.class.getClassLoader()));
        this.f3257f = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m6348j());
        parcel.writeList(m6349k());
        parcel.writeString(m6350l());
    }
}

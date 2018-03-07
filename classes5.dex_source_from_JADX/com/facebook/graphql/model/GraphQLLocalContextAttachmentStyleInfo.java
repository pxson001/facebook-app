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
import com.facebook.graphql.deserializers.GraphQLLocalContextAttachmentStyleInfoDeserializer;
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
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: fc_friends */
public final class GraphQLLocalContextAttachmentStyleInfo extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLLocalContextAttachmentStyleInfo> CREATOR = new C04281();
    @Nullable
    String f4409d;
    List<GraphQLPlaceOpenStatusFormat> f4410e;
    @Nullable
    String f4411f;

    /* compiled from: fc_friends */
    final class C04281 implements Creator<GraphQLLocalContextAttachmentStyleInfo> {
        C04281() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLLocalContextAttachmentStyleInfo(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLLocalContextAttachmentStyleInfo[i];
        }
    }

    /* compiled from: fc_friends */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLLocalContextAttachmentStyleInfo.class, new Deserializer());
        }

        public Object m8950a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLLocalContextAttachmentStyleInfoDeserializer.m5328a(jsonParser, (short) 240);
            Object graphQLLocalContextAttachmentStyleInfo = new GraphQLLocalContextAttachmentStyleInfo();
            ((BaseModel) graphQLLocalContextAttachmentStyleInfo).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLLocalContextAttachmentStyleInfo instanceof Postprocessable) {
                return ((Postprocessable) graphQLLocalContextAttachmentStyleInfo).a();
            }
            return graphQLLocalContextAttachmentStyleInfo;
        }
    }

    /* compiled from: fc_friends */
    public final class Serializer extends JsonSerializer<GraphQLLocalContextAttachmentStyleInfo> {
        public final void m8951a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLLocalContextAttachmentStyleInfo graphQLLocalContextAttachmentStyleInfo = (GraphQLLocalContextAttachmentStyleInfo) obj;
            GraphQLLocalContextAttachmentStyleInfoDeserializer.m5329a(graphQLLocalContextAttachmentStyleInfo.w_(), graphQLLocalContextAttachmentStyleInfo.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLLocalContextAttachmentStyleInfo.class, new Serializer());
            FbSerializerProvider.a(GraphQLLocalContextAttachmentStyleInfo.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final String m8954a() {
        this.f4409d = super.a(this.f4409d, 0);
        return this.f4409d;
    }

    @FieldOffset
    public final ImmutableList<GraphQLPlaceOpenStatusFormat> m8955j() {
        this.f4410e = super.a(this.f4410e, 1, GraphQLPlaceOpenStatusFormat.class);
        return (ImmutableList) this.f4410e;
    }

    @FieldOffset
    @Nullable
    public final String m8956k() {
        this.f4411f = super.a(this.f4411f, 2);
        return this.f4411f;
    }

    public final int jK_() {
        return -2113223272;
    }

    public final GraphQLVisitableModel m8953a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m8955j() != null) {
            Builder a = ModelHelper.a(m8955j(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLLocalContextAttachmentStyleInfo) ModelHelper.a(null, this);
                graphQLVisitableModel.f4410e = a.b();
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLLocalContextAttachmentStyleInfo() {
        super(4);
    }

    public final int m8952a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m8954a());
        int a = ModelHelper.a(flatBufferBuilder, m8955j());
        int b2 = flatBufferBuilder.b(m8956k());
        flatBufferBuilder.c(3);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, a);
        flatBufferBuilder.b(2, b2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLLocalContextAttachmentStyleInfo(Parcel parcel) {
        super(4);
        this.f4409d = parcel.readString();
        this.f4410e = ImmutableListHelper.a(parcel.readArrayList(GraphQLPlaceOpenStatusFormat.class.getClassLoader()));
        this.f4411f = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m8954a());
        parcel.writeList(m8955j());
        parcel.writeString(m8956k());
    }
}

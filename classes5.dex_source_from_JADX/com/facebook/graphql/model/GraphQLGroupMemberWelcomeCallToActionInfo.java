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
import com.facebook.graphql.deserializers.GraphQLGroupMemberWelcomeCallToActionInfoDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
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
/* compiled from: friend_list */
public final class GraphQLGroupMemberWelcomeCallToActionInfo extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLGroupMemberWelcomeCallToActionInfo> CREATOR = new C03981();
    @Deprecated
    @Nullable
    public String f4204d;

    /* compiled from: friend_list */
    final class C03981 implements Creator<GraphQLGroupMemberWelcomeCallToActionInfo> {
        C03981() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLGroupMemberWelcomeCallToActionInfo(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLGroupMemberWelcomeCallToActionInfo[i];
        }
    }

    /* compiled from: friend_list */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLGroupMemberWelcomeCallToActionInfo.class, new Deserializer());
        }

        public Object m8447a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLGroupMemberWelcomeCallToActionInfoDeserializer.m5167a(jsonParser, (short) 548);
            Object graphQLGroupMemberWelcomeCallToActionInfo = new GraphQLGroupMemberWelcomeCallToActionInfo();
            ((BaseModel) graphQLGroupMemberWelcomeCallToActionInfo).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLGroupMemberWelcomeCallToActionInfo instanceof Postprocessable) {
                return ((Postprocessable) graphQLGroupMemberWelcomeCallToActionInfo).a();
            }
            return graphQLGroupMemberWelcomeCallToActionInfo;
        }
    }

    /* compiled from: friend_list */
    public final class Serializer extends JsonSerializer<GraphQLGroupMemberWelcomeCallToActionInfo> {
        public final void m8448a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLGroupMemberWelcomeCallToActionInfo graphQLGroupMemberWelcomeCallToActionInfo = (GraphQLGroupMemberWelcomeCallToActionInfo) obj;
            GraphQLGroupMemberWelcomeCallToActionInfoDeserializer.m5168a(graphQLGroupMemberWelcomeCallToActionInfo.w_(), graphQLGroupMemberWelcomeCallToActionInfo.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(GraphQLGroupMemberWelcomeCallToActionInfo.class, new Serializer());
            FbSerializerProvider.a(GraphQLGroupMemberWelcomeCallToActionInfo.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final String m8451a() {
        this.f4204d = super.a(this.f4204d, 0);
        return this.f4204d;
    }

    public final int jK_() {
        return -1455915066;
    }

    public final GraphQLVisitableModel m8450a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public GraphQLGroupMemberWelcomeCallToActionInfo() {
        super(2);
    }

    public final int m8449a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m8451a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, b);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLGroupMemberWelcomeCallToActionInfo(Parcel parcel) {
        super(2);
        this.f4204d = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m8451a());
    }
}

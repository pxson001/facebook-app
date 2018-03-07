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
import com.facebook.graphql.deserializers.GraphQLGroupCreationSuggestionCallToActionInfoDeserializer;
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
/* compiled from: friends_center_friends */
public final class GraphQLGroupCreationSuggestionCallToActionInfo extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLGroupCreationSuggestionCallToActionInfo> CREATOR = new C03931();
    @Nullable
    public GraphQLGroupCreationSuggestion f4199d;

    /* compiled from: friends_center_friends */
    final class C03931 implements Creator<GraphQLGroupCreationSuggestionCallToActionInfo> {
        C03931() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLGroupCreationSuggestionCallToActionInfo(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLGroupCreationSuggestionCallToActionInfo[i];
        }
    }

    /* compiled from: friends_center_friends */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLGroupCreationSuggestionCallToActionInfo.class, new Deserializer());
        }

        public Object m8411a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLGroupCreationSuggestionCallToActionInfoDeserializer.m5149a(jsonParser, (short) 181);
            Object graphQLGroupCreationSuggestionCallToActionInfo = new GraphQLGroupCreationSuggestionCallToActionInfo();
            ((BaseModel) graphQLGroupCreationSuggestionCallToActionInfo).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLGroupCreationSuggestionCallToActionInfo instanceof Postprocessable) {
                return ((Postprocessable) graphQLGroupCreationSuggestionCallToActionInfo).a();
            }
            return graphQLGroupCreationSuggestionCallToActionInfo;
        }
    }

    /* compiled from: friends_center_friends */
    public final class Serializer extends JsonSerializer<GraphQLGroupCreationSuggestionCallToActionInfo> {
        public final void m8412a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLGroupCreationSuggestionCallToActionInfo graphQLGroupCreationSuggestionCallToActionInfo = (GraphQLGroupCreationSuggestionCallToActionInfo) obj;
            GraphQLGroupCreationSuggestionCallToActionInfoDeserializer.m5150a(graphQLGroupCreationSuggestionCallToActionInfo.w_(), graphQLGroupCreationSuggestionCallToActionInfo.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLGroupCreationSuggestionCallToActionInfo.class, new Serializer());
            FbSerializerProvider.a(GraphQLGroupCreationSuggestionCallToActionInfo.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLGroupCreationSuggestion m8414a() {
        this.f4199d = (GraphQLGroupCreationSuggestion) super.a(this.f4199d, 0, GraphQLGroupCreationSuggestion.class);
        return this.f4199d;
    }

    public final int jK_() {
        return -495215233;
    }

    public final GraphQLVisitableModel m8415a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m8414a() != null) {
            GraphQLGroupCreationSuggestion graphQLGroupCreationSuggestion = (GraphQLGroupCreationSuggestion) graphQLModelMutatingVisitor.b(m8414a());
            if (m8414a() != graphQLGroupCreationSuggestion) {
                graphQLVisitableModel = (GraphQLGroupCreationSuggestionCallToActionInfo) ModelHelper.a(null, this);
                graphQLVisitableModel.f4199d = graphQLGroupCreationSuggestion;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLGroupCreationSuggestionCallToActionInfo() {
        super(2);
    }

    public final int m8413a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m8414a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLGroupCreationSuggestionCallToActionInfo(Parcel parcel) {
        super(2);
        this.f4199d = (GraphQLGroupCreationSuggestion) parcel.readValue(GraphQLGroupCreationSuggestion.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m8414a());
    }
}

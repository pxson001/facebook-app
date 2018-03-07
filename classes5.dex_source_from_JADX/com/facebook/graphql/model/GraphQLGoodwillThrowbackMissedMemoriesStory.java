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
import com.facebook.graphql.deserializers.GraphQLGoodwillThrowbackMissedMemoriesStoryDeserializer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.PropertyBag.HasProperty;
import com.facebook.graphql.model.extras.FeedUnitExtra;
import com.facebook.graphql.model.interfaces.CacheableEntity;
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
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: getWakeTime */
public final class GraphQLGoodwillThrowbackMissedMemoriesStory extends BaseModel implements FeedUnit, HasProperty, CacheableEntity, TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLGoodwillThrowbackMissedMemoriesStory> CREATOR = new C03601();
    GraphQLObjectType f4019d = new GraphQLObjectType(-655098947);
    long f4020e;
    List<GraphQLStoryAttachment> f4021f;
    List<GraphQLStory> f4022g;
    @Nullable
    GraphQLGoodwillThrowbackSection f4023h;
    @Nullable
    String f4024i;
    private GoodwillThrowbackMissedMemoriesStoryExtra f4025j;
    @Nullable
    private PropertyBag f4026k = null;

    /* compiled from: getWakeTime */
    final class C03601 implements Creator<GraphQLGoodwillThrowbackMissedMemoriesStory> {
        C03601() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLGoodwillThrowbackMissedMemoriesStory(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLGoodwillThrowbackMissedMemoriesStory[i];
        }
    }

    /* compiled from: getWakeTime */
    public class Builder extends com.facebook.graphql.modelutil.BaseModel.Builder {
        public long f4013d;
        public ImmutableList<GraphQLStoryAttachment> f4014e;
        public ImmutableList<GraphQLStory> f4015f;
        @Nullable
        public String f4016g;
        @Nullable
        public GraphQLGoodwillThrowbackSection f4017h;
        @Nullable
        PropertyBag f4018i = null;

        public Builder() {
            Preconditions.checkState(this instanceof Builder);
        }
    }

    /* compiled from: getWakeTime */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLGoodwillThrowbackMissedMemoriesStory.class, new Deserializer());
        }

        public Object m8035a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLGoodwillThrowbackMissedMemoriesStoryDeserializer.m5048a(jsonParser, (short) 404);
            Object graphQLGoodwillThrowbackMissedMemoriesStory = new GraphQLGoodwillThrowbackMissedMemoriesStory();
            ((BaseModel) graphQLGoodwillThrowbackMissedMemoriesStory).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLGoodwillThrowbackMissedMemoriesStory instanceof Postprocessable) {
                return ((Postprocessable) graphQLGoodwillThrowbackMissedMemoriesStory).a();
            }
            return graphQLGoodwillThrowbackMissedMemoriesStory;
        }
    }

    /* compiled from: getWakeTime */
    public class GoodwillThrowbackMissedMemoriesStoryExtra extends FeedUnitExtra {
        public static final Creator<GoodwillThrowbackMissedMemoriesStoryExtra> CREATOR = new C03611();

        /* compiled from: getWakeTime */
        final class C03611 implements Creator<GoodwillThrowbackMissedMemoriesStoryExtra> {
            C03611() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new GoodwillThrowbackMissedMemoriesStoryExtra(parcel);
            }

            public final Object[] newArray(int i) {
                return new GoodwillThrowbackMissedMemoriesStoryExtra[i];
            }
        }

        protected GoodwillThrowbackMissedMemoriesStoryExtra(Parcel parcel) {
            super(parcel);
        }
    }

    /* compiled from: getWakeTime */
    public final class Serializer extends JsonSerializer<GraphQLGoodwillThrowbackMissedMemoriesStory> {
        public final void m8036a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLGoodwillThrowbackMissedMemoriesStory graphQLGoodwillThrowbackMissedMemoriesStory = (GraphQLGoodwillThrowbackMissedMemoriesStory) obj;
            GraphQLGoodwillThrowbackMissedMemoriesStoryDeserializer.m5049a(graphQLGoodwillThrowbackMissedMemoriesStory.w_(), graphQLGoodwillThrowbackMissedMemoriesStory.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLGoodwillThrowbackMissedMemoriesStory.class, new Serializer());
            FbSerializerProvider.a(GraphQLGoodwillThrowbackMissedMemoriesStory.class, new Serializer());
        }
    }

    public final String m8046g() {
        return null;
    }

    @FieldOffset
    @Nullable
    public final /* synthetic */ GraphQLGoodwillThrowbackSection Y_() {
        return m8048k();
    }

    public final /* synthetic */ FeedUnitExtra m8047j() {
        return m8037l();
    }

    public final GraphQLObjectType getType() {
        return this.f4019d;
    }

    public final String S_() {
        return null;
    }

    public final ImmutableList<String> m8045d() {
        if (m8046g() != null) {
            return ImmutableList.of(m8046g());
        }
        return RegularImmutableList.a;
    }

    @FieldOffset
    public final long T_() {
        a(0, 0);
        return this.f4020e;
    }

    public final void m8041a(long j) {
        this.f4020e = j;
    }

    @FieldOffset
    public final ImmutableList<GraphQLStoryAttachment> m8040a() {
        this.f4021f = super.a(this.f4021f, 1, GraphQLStoryAttachment.class);
        return (ImmutableList) this.f4021f;
    }

    @FieldOffset
    public final ImmutableList<GraphQLStory> m8043b() {
        this.f4022g = super.a(this.f4022g, 2, GraphQLStory.class);
        return (ImmutableList) this.f4022g;
    }

    @FieldOffset
    @Nullable
    public final GraphQLGoodwillThrowbackSection m8048k() {
        this.f4023h = (GraphQLGoodwillThrowbackSection) super.a(this.f4023h, 3, GraphQLGoodwillThrowbackSection.class);
        return this.f4023h;
    }

    @FieldOffset
    @Nullable
    public final String m8044c() {
        this.f4024i = super.a(this.f4024i, 4);
        return this.f4024i;
    }

    public final int jK_() {
        return -655098947;
    }

    public final GraphQLVisitableModel m8039a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        com.google.common.collect.ImmutableList.Builder a;
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m8040a() != null) {
            a = ModelHelper.a(m8040a(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackMissedMemoriesStory) ModelHelper.a(null, this);
                graphQLVisitableModel.f4021f = a.b();
            }
        }
        if (m8043b() != null) {
            a = ModelHelper.a(m8043b(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackMissedMemoriesStory) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4022g = a.b();
            }
        }
        GraphQLVisitableModel graphQLVisitableModel2 = graphQLVisitableModel;
        if (m8048k() != null) {
            GraphQLGoodwillThrowbackSection graphQLGoodwillThrowbackSection = (GraphQLGoodwillThrowbackSection) graphQLModelMutatingVisitor.b(m8048k());
            if (m8048k() != graphQLGoodwillThrowbackSection) {
                graphQLVisitableModel2 = (GraphQLGoodwillThrowbackMissedMemoriesStory) ModelHelper.a(graphQLVisitableModel2, this);
                graphQLVisitableModel2.f4023h = graphQLGoodwillThrowbackSection;
            }
        }
        i();
        return graphQLVisitableModel2 == null ? this : graphQLVisitableModel2;
    }

    public GraphQLGoodwillThrowbackMissedMemoriesStory() {
        super(6);
    }

    public final void m8042a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f4020e = mutableFlatBuffer.a(i, 0, 0);
    }

    public final int m8038a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m8040a());
        int a2 = ModelHelper.a(flatBufferBuilder, m8043b());
        int a3 = ModelHelper.a(flatBufferBuilder, m8048k());
        int b = flatBufferBuilder.b(m8044c());
        flatBufferBuilder.c(5);
        flatBufferBuilder.a(0, T_(), 0);
        flatBufferBuilder.b(1, a);
        flatBufferBuilder.b(2, a2);
        flatBufferBuilder.b(3, a3);
        flatBufferBuilder.b(4, b);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLGoodwillThrowbackMissedMemoriesStory(Parcel parcel) {
        super(6);
        this.f4020e = parcel.readLong();
        this.f4021f = ImmutableListHelper.a(parcel.readArrayList(GraphQLStoryAttachment.class.getClassLoader()));
        this.f4022g = ImmutableListHelper.a(parcel.readArrayList(GraphQLStory.class.getClassLoader()));
        this.f4024i = parcel.readString();
        this.f4023h = (GraphQLGoodwillThrowbackSection) parcel.readValue(GraphQLGoodwillThrowbackSection.class.getClassLoader());
        this.f4025j = (GoodwillThrowbackMissedMemoriesStoryExtra) ParcelUtil.m3828b(parcel, GoodwillThrowbackMissedMemoriesStoryExtra.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(T_());
        parcel.writeList(m8040a());
        parcel.writeList(m8043b());
        parcel.writeString(m8044c());
        parcel.writeValue(m8048k());
        parcel.writeParcelable(m8037l(), i);
    }

    public GraphQLGoodwillThrowbackMissedMemoriesStory(Builder builder) {
        super(6);
        this.b = builder.a;
        this.c = builder.b;
        this.f4020e = builder.f4013d;
        this.f4021f = builder.f4014e;
        this.f4022g = builder.f4015f;
        this.f4024i = builder.f4016g;
        this.f4023h = builder.f4017h;
        this.f4026k = builder.f4018i;
    }

    private GoodwillThrowbackMissedMemoriesStoryExtra m8037l() {
        if (this.f4025j == null) {
            if (this.b == null || !this.b.d) {
                this.f4025j = new GoodwillThrowbackMissedMemoriesStoryExtra();
            } else {
                this.f4025j = (GoodwillThrowbackMissedMemoriesStoryExtra) this.b.a(this.c, this, GoodwillThrowbackMissedMemoriesStoryExtra.class);
            }
        }
        return this.f4025j;
    }

    public final PropertyBag U_() {
        if (this.f4026k == null) {
            this.f4026k = new PropertyBag();
        }
        return this.f4026k;
    }
}

package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: onStreamInterrupted */
public final class GraphQLPYMLWithLargeImageFeedUnitsConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLPYMLWithLargeImageFeedUnitsConnection> CREATOR = new C02691();
    public List<GraphQLPYMLWithLargeImageFeedUnitsEdge> f6110d;

    /* compiled from: onStreamInterrupted */
    final class C02691 implements Creator<GraphQLPYMLWithLargeImageFeedUnitsConnection> {
        C02691() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLPYMLWithLargeImageFeedUnitsConnection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLPYMLWithLargeImageFeedUnitsConnection[i];
        }
    }

    @FieldOffset
    public final ImmutableList<GraphQLPYMLWithLargeImageFeedUnitsEdge> m6576a() {
        this.f6110d = super.a(this.f6110d, 0, GraphQLPYMLWithLargeImageFeedUnitsEdge.class);
        return (ImmutableList) this.f6110d;
    }

    public final int jK_() {
        return -356091007;
    }

    public final GraphQLVisitableModel m6575a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m6576a() != null) {
            Builder a = ModelHelper.a(m6576a(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLPYMLWithLargeImageFeedUnitsConnection) ModelHelper.a(null, this);
                graphQLVisitableModel.f6110d = a.b();
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLPYMLWithLargeImageFeedUnitsConnection() {
        super(2);
    }

    public final int m6574a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m6576a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLPYMLWithLargeImageFeedUnitsConnection(Parcel parcel) {
        super(2);
        this.f6110d = ImmutableListHelper.a(parcel.readArrayList(GraphQLPYMLWithLargeImageFeedUnitsEdge.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m6576a());
    }

    public GraphQLPYMLWithLargeImageFeedUnitsConnection(Builder builder) {
        super(2);
        this.b = builder.a;
        this.c = builder.b;
        this.f6110d = builder.d;
    }
}

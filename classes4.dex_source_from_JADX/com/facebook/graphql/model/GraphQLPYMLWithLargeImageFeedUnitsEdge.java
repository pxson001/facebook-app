package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: onStreamEvaluate */
public final class GraphQLPYMLWithLargeImageFeedUnitsEdge extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLPYMLWithLargeImageFeedUnitsEdge> CREATOR = new C02701();
    @Nullable
    public GraphQLPYMLWithLargeImageFeedUnitItem f6111d;

    /* compiled from: onStreamEvaluate */
    final class C02701 implements Creator<GraphQLPYMLWithLargeImageFeedUnitsEdge> {
        C02701() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLPYMLWithLargeImageFeedUnitsEdge(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLPYMLWithLargeImageFeedUnitsEdge[i];
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLPYMLWithLargeImageFeedUnitItem m6578a() {
        this.f6111d = (GraphQLPYMLWithLargeImageFeedUnitItem) super.a(this.f6111d, 0, GraphQLPYMLWithLargeImageFeedUnitItem.class);
        return this.f6111d;
    }

    public final int jK_() {
        return 252207264;
    }

    public final GraphQLVisitableModel m6579a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m6578a() != null) {
            GraphQLPYMLWithLargeImageFeedUnitItem graphQLPYMLWithLargeImageFeedUnitItem = (GraphQLPYMLWithLargeImageFeedUnitItem) graphQLModelMutatingVisitor.b(m6578a());
            if (m6578a() != graphQLPYMLWithLargeImageFeedUnitItem) {
                graphQLVisitableModel = (GraphQLPYMLWithLargeImageFeedUnitsEdge) ModelHelper.a(null, this);
                graphQLVisitableModel.f6111d = graphQLPYMLWithLargeImageFeedUnitItem;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLPYMLWithLargeImageFeedUnitsEdge() {
        super(2);
    }

    public final int m6577a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m6578a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLPYMLWithLargeImageFeedUnitsEdge(Parcel parcel) {
        super(2);
        this.f6111d = (GraphQLPYMLWithLargeImageFeedUnitItem) parcel.readValue(GraphQLPYMLWithLargeImageFeedUnitItem.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m6578a());
    }

    public GraphQLPYMLWithLargeImageFeedUnitsEdge(Builder builder) {
        super(2);
        this.b = builder.a;
        this.c = builder.b;
        this.f6111d = builder.d;
    }
}

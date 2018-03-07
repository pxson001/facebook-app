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
/* compiled from: user_location */
public final class GraphQLTimelineAppCollectionMembershipStateInfo extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLTimelineAppCollectionMembershipStateInfo> CREATOR = new C00391();
    @Nullable
    public String f408d;
    @Nullable
    public GraphQLTextWithEntities f409e;

    /* compiled from: user_location */
    final class C00391 implements Creator<GraphQLTimelineAppCollectionMembershipStateInfo> {
        C00391() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLTimelineAppCollectionMembershipStateInfo(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLTimelineAppCollectionMembershipStateInfo[i];
        }
    }

    @FieldOffset
    @Nullable
    public final String m694a() {
        this.f408d = super.a(this.f408d, 0);
        return this.f408d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m695j() {
        this.f409e = (GraphQLTextWithEntities) super.a(this.f409e, 1, GraphQLTextWithEntities.class);
        return this.f409e;
    }

    public final int jK_() {
        return 1295346699;
    }

    public final GraphQLVisitableModel m693a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m695j() != null) {
            GraphQLTextWithEntities graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m695j());
            if (m695j() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLTimelineAppCollectionMembershipStateInfo) ModelHelper.a(null, this);
                graphQLVisitableModel.f409e = graphQLTextWithEntities;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLTimelineAppCollectionMembershipStateInfo() {
        super(3);
    }

    public final int m692a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m694a());
        int a = ModelHelper.a(flatBufferBuilder, m695j());
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLTimelineAppCollectionMembershipStateInfo(Parcel parcel) {
        super(3);
        this.f408d = parcel.readString();
        this.f409e = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m694a());
        parcel.writeValue(m695j());
    }

    public GraphQLTimelineAppCollectionMembershipStateInfo(Builder builder) {
        super(3);
        this.b = builder.a;
        this.c = builder.b;
        this.f408d = builder.d;
        this.f409e = builder.e;
    }
}

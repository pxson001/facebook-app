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
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: limit_tracking */
public final class GraphQLOpenGraphMetadata extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLOpenGraphMetadata> CREATOR = new C09191();
    @Nullable
    String f17486d;
    List<GraphQLCurrencyQuantity> f17487e;
    @Nullable
    String f17488f;

    /* compiled from: limit_tracking */
    final class C09191 implements Creator<GraphQLOpenGraphMetadata> {
        C09191() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLOpenGraphMetadata(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLOpenGraphMetadata[i];
        }
    }

    @FieldOffset
    @Nullable
    public final String m24600a() {
        this.f17486d = super.m9948a(this.f17486d, 0);
        return this.f17486d;
    }

    @FieldOffset
    public final ImmutableList<GraphQLCurrencyQuantity> m24601j() {
        this.f17487e = super.m9944a(this.f17487e, 1, GraphQLCurrencyQuantity.class);
        return (ImmutableList) this.f17487e;
    }

    @FieldOffset
    @Nullable
    public final String m24602k() {
        this.f17488f = super.m9948a(this.f17488f, 2);
        return this.f17488f;
    }

    public final int jK_() {
        return 405455955;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m24601j() != null) {
            Builder a = ModelHelper.m23097a(m24601j(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLOpenGraphMetadata) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17487e = a.m1068b();
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLOpenGraphMetadata() {
        super(4);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(m24600a());
        int a = ModelHelper.m23094a(flatBufferBuilder, m24601j());
        int b2 = flatBufferBuilder.m21502b(m24602k());
        flatBufferBuilder.m21510c(3);
        flatBufferBuilder.m21507b(0, b);
        flatBufferBuilder.m21507b(1, a);
        flatBufferBuilder.m21507b(2, b2);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLOpenGraphMetadata(Parcel parcel) {
        super(4);
        this.f17486d = parcel.readString();
        this.f17487e = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLCurrencyQuantity.class.getClassLoader()));
        this.f17488f = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m24600a());
        parcel.writeList(m24601j());
        parcel.writeString(m24602k());
    }
}

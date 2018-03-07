package com.facebook.graphql.model.interfaces;

import android.os.Parcelable;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.model.extras.FeedUnitExtra;
import com.facebook.graphql.visitor.GraphQLVisitableModel;

/* compiled from: missing tracking codes */
public interface FeedUnitCommon extends Parcelable, Flattenable, CacheableEntity, GraphQLVisitableModel {
    String S_();

    long T_();

    void mo2872a(long j);

    String mo2507g();

    FeedUnitExtra mo2876j();

    int u_();

    MutableFlatBuffer w_();
}

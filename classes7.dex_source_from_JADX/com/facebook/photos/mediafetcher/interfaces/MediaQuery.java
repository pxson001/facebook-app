package com.facebook.photos.mediafetcher.interfaces;

import com.google.common.base.Preconditions;

/* compiled from: lastSeqId */
public abstract class MediaQuery<QUERY_CONSTRUCTION_PARAM extends QueryParam> {
    public final QUERY_CONSTRUCTION_PARAM f10557a;

    protected MediaQuery(QUERY_CONSTRUCTION_PARAM query_construction_param) {
        this.f10557a = (QueryParam) Preconditions.checkNotNull(query_construction_param);
    }
}

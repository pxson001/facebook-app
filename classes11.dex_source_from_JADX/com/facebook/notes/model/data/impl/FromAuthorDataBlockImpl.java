package com.facebook.notes.model.data.impl;

import com.facebook.richdocument.model.data.BlockData;
import com.facebook.richdocument.model.data.impl.BaseBlockData;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.FBProfileModel;
import javax.annotation.Nullable;

/* compiled from: Trying to set a non-supported collection! */
public class FromAuthorDataBlockImpl extends BaseBlockData implements BlockData {
    public final String f10530a;
    public final String f10531b;

    public FromAuthorDataBlockImpl(FBProfileModel fBProfileModel) {
        super(201);
        this.f10530a = fBProfileModel.b();
        this.f10531b = fBProfileModel.c() != null ? fBProfileModel.c().d() : null;
    }

    @Nullable
    public final String m11033l() {
        return null;
    }
}

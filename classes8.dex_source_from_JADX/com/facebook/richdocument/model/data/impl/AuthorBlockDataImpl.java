package com.facebook.richdocument.model.data.impl;

import com.facebook.richdocument.model.data.BlockData;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentAuthorModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentAuthorModel.ProfileModel;
import javax.annotation.Nullable;

/* compiled from: photo_uploads */
public class AuthorBlockDataImpl extends BaseBlockData implements BlockData {
    public final RichDocumentAuthorModel f5674a;

    public AuthorBlockDataImpl(RichDocumentAuthorModel richDocumentAuthorModel) {
        super(1);
        this.f5674a = richDocumentAuthorModel;
    }

    @Nullable
    public final String m5487a() {
        return this.f5674a.m5835d();
    }

    @Nullable
    public final String m5488c() {
        return this.f5674a.m5834c();
    }

    public final boolean m5489d() {
        return this.f5674a.m5836g();
    }

    @Nullable
    public final ProfileModel m5490e() {
        return this.f5674a.hY_();
    }

    @Nullable
    public final String mo271l() {
        return this.f5674a.hX_();
    }
}

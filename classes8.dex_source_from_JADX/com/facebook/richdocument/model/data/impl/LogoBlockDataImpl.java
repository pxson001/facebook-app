package com.facebook.richdocument.model.data.impl;

import com.facebook.richdocument.model.data.BlockData;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.FBPage;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentLogoModel;

/* compiled from: photo_removed */
public class LogoBlockDataImpl extends BaseBlockData implements BlockData {
    public final RichDocumentLogoModel f5730a;
    public final FBPage f5731b;

    public LogoBlockDataImpl(RichDocumentLogoModel richDocumentLogoModel, FBPage fBPage, String str) {
        super(str, 12);
        this.f5730a = richDocumentLogoModel;
        this.f5731b = fBPage;
    }
}

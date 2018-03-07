package com.facebook.instantshopping.model.block.media;

import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.FBFullImageFragmentModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.FBPhoto;
import javax.annotation.Nullable;

/* compiled from: SentAnimationDependentViews */
public class InstantShoppingPhoto implements FBPhoto {
    private final FBFullImageFragmentModel f23594a;

    public InstantShoppingPhoto(FBFullImageFragmentModel fBFullImageFragmentModel) {
        this.f23594a = fBFullImageFragmentModel;
    }

    @Nullable
    public final FBFullImageFragmentModel m24900c() {
        return this.f23594a;
    }

    @Nullable
    public final FBFullImageFragmentModel m24901d() {
        return null;
    }

    @Nullable
    public final String hS_() {
        return null;
    }

    @Nullable
    public final String m24899b() {
        return null;
    }

    public Object clone() {
        throw new CloneNotSupportedException("InstantShoppingPhoto is a client side only class");
    }
}

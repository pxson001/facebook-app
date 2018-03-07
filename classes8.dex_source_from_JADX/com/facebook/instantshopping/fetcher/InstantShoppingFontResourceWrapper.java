package com.facebook.instantshopping.fetcher;

import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingFontObjectFragmentModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentFontResource;
import javax.annotation.Nullable;

/* compiled from: upload_photo_menu_delete_photo_button_click */
public class InstantShoppingFontResourceWrapper implements RichDocumentFontResource {
    private final InstantShoppingFontObjectFragmentModel f870a;

    public InstantShoppingFontResourceWrapper(InstantShoppingFontObjectFragmentModel instantShoppingFontObjectFragmentModel) {
        this.f870a = instantShoppingFontObjectFragmentModel;
    }

    @Nullable
    public final String mo25a() {
        return this.f870a.m1051a();
    }

    @Nullable
    public final String mo26b() {
        return this.f870a.m1053b();
    }

    @Nullable
    public final String mo27c() {
        return this.f870a.m1054c();
    }

    public Object clone() {
        return this;
    }
}

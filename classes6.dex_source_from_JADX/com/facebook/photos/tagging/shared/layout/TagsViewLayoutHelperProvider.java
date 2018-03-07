package com.facebook.photos.tagging.shared.layout;

import android.view.View;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: guest_id */
public class TagsViewLayoutHelperProvider extends AbstractAssistedProvider<TagsViewLayoutHelper> {
    public final <TAGVIEW extends View & LayoutableTagView> TagsViewLayoutHelper<TAGVIEW> m21078a(View view, float f) {
        return new TagsViewLayoutHelper(view, f, (DummyTagViewProvider) getOnDemandAssistedProviderForStaticDi(DummyTagViewProvider.class));
    }
}

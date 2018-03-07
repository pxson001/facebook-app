package com.facebook.photos.tagging.shared.layout;

import android.view.View;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: has_available_link_menus */
public class DummyTagViewProvider extends AbstractAssistedProvider<DummyTagView> {
    public static <TAGVIEW extends View & LayoutableTagView> DummyTagView<TAGVIEW> m21055a(LayoutableTagView layoutableTagView, Integer num, TagWithFacebox tagWithFacebox) {
        return new DummyTagView(layoutableTagView, num, tagWithFacebox);
    }
}

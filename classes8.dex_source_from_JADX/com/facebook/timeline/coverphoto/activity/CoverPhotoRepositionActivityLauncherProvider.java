package com.facebook.timeline.coverphoto.activity;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;

/* compiled from: marketplace_search_typeahead_react_tag */
public class CoverPhotoRepositionActivityLauncherProvider extends AbstractAssistedProvider<CoverPhotoRepositionActivityLauncher> {
    public final CoverPhotoRepositionActivityLauncher m10917a(Long l) {
        return new CoverPhotoRepositionActivityLauncher(l, IdBasedSingletonScopeProvider.a(this, 968));
    }
}

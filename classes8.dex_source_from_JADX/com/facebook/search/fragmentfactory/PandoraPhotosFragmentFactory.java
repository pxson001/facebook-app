package com.facebook.search.fragmentfactory;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.search.results.fragment.photos.SearchResultsPandoraPhotoFragment;

/* compiled from: This type of friend event is not supported. */
public class PandoraPhotosFragmentFactory implements IFragmentFactory {
    public final Fragment m25436a(Intent intent) {
        SearchResultsPandoraPhotoFragment searchResultsPandoraPhotoFragment = new SearchResultsPandoraPhotoFragment();
        searchResultsPandoraPhotoFragment.g(intent.getExtras());
        return searchResultsPandoraPhotoFragment;
    }
}

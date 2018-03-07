package com.facebook.photos.upload.module;

import com.facebook.inject.AbstractProvider;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;

/* compiled from: graphUploadBulkContacts */
public class Boolean_PhotosHighDefUploadSettingValueMethodAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return PhotosUploadModule.m21431a((FbSharedPreferences) FbSharedPreferencesImpl.a(this));
    }
}

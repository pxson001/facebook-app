package com.facebook.api.feedcache.db;

import android.content.Context;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;
import java.io.File;

/* compiled from: sessionless_gatekeepers */
public class File_FeedCacheStorageDirectoryMethodAutoProvider extends AbstractProvider<File> {
    public static File m9266b(InjectorLike injectorLike) {
        return FeedDbCacheModule.m9267a((Context) injectorLike.getInstance(Context.class));
    }

    public Object get() {
        return FeedDbCacheModule.m9267a((Context) getInstance(Context.class));
    }
}

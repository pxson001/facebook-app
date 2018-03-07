package com.facebook.api.feedcache.db;

import android.content.Context;
import com.facebook.api.feed.annotation.FeedDbCacheSize;
import com.facebook.api.feed.annotation.FeedUnitLowEngagementCacheSize;
import com.facebook.api.feed.annotation.FeedbackDbCacheSize;
import com.facebook.api.feed.annotation.StoryDbCacheSize;
import com.facebook.api.feedcache.db.storage.FeedCacheStorageDirectory;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import java.io.File;
import java.io.IOException;

@InjectorModule
/* compiled from: sessionless__ */
public class FeedDbCacheModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @FeedDbCacheSize
    public static Integer m9268a() {
        return Integer.valueOf(200);
    }

    @ProviderMethod
    @StoryDbCacheSize
    static Integer m9269b() {
        return Integer.valueOf(100);
    }

    @ProviderMethod
    @FeedbackDbCacheSize
    static Integer m9270c() {
        return Integer.valueOf(300);
    }

    @ProviderMethod
    @FeedUnitLowEngagementCacheSize
    static Integer m9271d() {
        return Integer.valueOf(100);
    }

    @ProviderMethod
    @FeedCacheStorageDirectory
    static File m9267a(Context context) {
        String canonicalPath;
        String str = null;
        try {
            canonicalPath = context.getFilesDir().getCanonicalPath();
        } catch (IOException e) {
            canonicalPath = str;
        }
        if (canonicalPath != null) {
            return new File(canonicalPath, "NewsFeed/");
        }
        return new File(context.getFilesDir(), "NewsFeed/");
    }
}

package com.facebook.feed.ui.imageloader;

import com.facebook.feed.ui.imageloader.FeedImageLoader.FeedImageType;

/* compiled from: The wrapper of ComposerTextEdit must be put in a ScrollView or RecyclerView */
/* synthetic */ class FeedImageLoader$1 {
    static final /* synthetic */ int[] f22199a = new int[FeedImageType.values().length];

    static {
        try {
            f22199a[FeedImageType.Album.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f22199a[FeedImageType.Photo.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f22199a[FeedImageType.Video.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f22199a[FeedImageType.ShareLargeImage.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f22199a[FeedImageType.AddFriend.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f22199a[FeedImageType.AvatarList.ordinal()] = 6;
        } catch (NoSuchFieldError e6) {
        }
    }
}

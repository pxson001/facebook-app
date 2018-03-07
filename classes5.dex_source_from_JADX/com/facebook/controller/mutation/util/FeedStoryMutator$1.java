package com.facebook.controller.mutation.util;

import com.facebook.feedplugins.graphqlstory.page.actionablepage.PageStoryType;

/* compiled from: account_id */
/* synthetic */ class FeedStoryMutator$1 {
    static final /* synthetic */ int[] f11699a = new int[PageStoryType.values().length];

    static {
        try {
            f11699a[PageStoryType.PAGE_LIKE.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f11699a[PageStoryType.GROUPER.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f11699a[PageStoryType.GROUPER_ATTACHED_STORY.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f11699a[PageStoryType.NCPP.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f11699a[PageStoryType.OTHER.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f11699a[PageStoryType.OFFER.ordinal()] = 6;
        } catch (NoSuchFieldError e6) {
        }
    }
}

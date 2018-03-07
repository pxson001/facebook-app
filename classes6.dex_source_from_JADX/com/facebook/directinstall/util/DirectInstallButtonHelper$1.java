package com.facebook.directinstall.util;

import com.facebook.graphql.enums.GraphQLAppStoreApplicationInstallState;

/* compiled from: offline_post_delete_missing_story */
/* synthetic */ class DirectInstallButtonHelper$1 {
    static final /* synthetic */ int[] f8883a = new int[GraphQLAppStoreApplicationInstallState.values().length];

    static {
        try {
            f8883a[GraphQLAppStoreApplicationInstallState.PENDING.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f8883a[GraphQLAppStoreApplicationInstallState.DOWNLOADING.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f8883a[GraphQLAppStoreApplicationInstallState.INSTALLING.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f8883a[GraphQLAppStoreApplicationInstallState.INSTALLED.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f8883a[GraphQLAppStoreApplicationInstallState.CANCELED.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f8883a[GraphQLAppStoreApplicationInstallState.FAILED_INSTALL.ordinal()] = 6;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f8883a[GraphQLAppStoreApplicationInstallState.NOT_INSTALLED.ordinal()] = 7;
        } catch (NoSuchFieldError e7) {
        }
        try {
            f8883a[GraphQLAppStoreApplicationInstallState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE.ordinal()] = 8;
        } catch (NoSuchFieldError e8) {
        }
    }
}

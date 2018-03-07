package com.facebook.messaging.contextbanner;

import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.graphql.enums.GraphQLTimelineContextListItemType;
import com.facebook.inject.Lazy;
import javax.inject.Inject;

/* compiled from: suggested_mediasets */
public class ProfileContextItemsParser {
    public final Lazy<FbErrorReporter> f2199a;

    /* compiled from: suggested_mediasets */
    public /* synthetic */ class C03681 {
        public static final /* synthetic */ int[] f2198a = new int[GraphQLTimelineContextListItemType.values().length];

        static {
            try {
                f2198a[GraphQLTimelineContextListItemType.WORK.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2198a[GraphQLTimelineContextListItemType.CURRENT_CITY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2198a[GraphQLTimelineContextListItemType.EDUCATION.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    @Inject
    public ProfileContextItemsParser(Lazy<FbErrorReporter> lazy) {
        this.f2199a = lazy;
    }
}

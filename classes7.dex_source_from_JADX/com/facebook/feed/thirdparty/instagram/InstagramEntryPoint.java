package com.facebook.feed.thirdparty.instagram;

import com.facebook.common.time.SystemClock;
import com.facebook.graphql.enums.GraphQLFollowUpFeedUnitActionType;

/* compiled from: should_show_intercept */
public enum InstagramEntryPoint {
    Text("text"),
    Photo("photo"),
    Ego("ego"),
    PivotOnClick("pivot_on_click"),
    PivotOnComment("pivot_on_comment"),
    PivotOnShare("pivot_on_share");
    
    private long mLastImpressionLogTime;
    private final String mType;

    /* compiled from: should_show_intercept */
    /* synthetic */ class C03151 {
        static final /* synthetic */ int[] f3767b = null;

        static {
            f3767b = new int[GraphQLFollowUpFeedUnitActionType.values().length];
            try {
                f3767b[GraphQLFollowUpFeedUnitActionType.COMMENT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f3767b[GraphQLFollowUpFeedUnitActionType.SHARE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            f3766a = new int[InstagramEntryPoint.values().length];
            try {
                f3766a[InstagramEntryPoint.PivotOnClick.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f3766a[InstagramEntryPoint.PivotOnComment.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f3766a[InstagramEntryPoint.PivotOnShare.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    private InstagramEntryPoint(String str) {
        this.mLastImpressionLogTime = -7200000;
        this.mType = str;
    }

    public final String getType() {
        return this.mType;
    }

    private boolean shouldThrottleLogging() {
        switch (this) {
            case PivotOnClick:
            case PivotOnComment:
            case PivotOnShare:
                return false;
            default:
                return true;
        }
    }

    public final boolean shouldLogImpression() {
        if (!shouldThrottleLogging()) {
            return true;
        }
        long a = SystemClock.a.a();
        if (this.mLastImpressionLogTime + 7200000 >= a) {
            return false;
        }
        this.mLastImpressionLogTime = a;
        return true;
    }

    public static InstagramEntryPoint getEntryPoint(GraphQLFollowUpFeedUnitActionType graphQLFollowUpFeedUnitActionType) {
        switch (C03151.f3767b[graphQLFollowUpFeedUnitActionType.ordinal()]) {
            case 1:
                return PivotOnComment;
            case 2:
                return PivotOnShare;
            default:
                return PivotOnClick;
        }
    }
}

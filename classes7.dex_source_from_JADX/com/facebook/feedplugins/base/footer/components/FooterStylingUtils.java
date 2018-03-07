package com.facebook.feedplugins.base.footer.components;

import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import com.facebook.analytics.view.tracking.TrackingNodes;
import com.facebook.analytics.view.tracking.TrackingNodes.TrackingNode;
import com.facebook.components.ComponentContext;
import com.facebook.components.glyph.GlyphColorizerDrawableReference;
import com.facebook.components.reference.Reference;
import com.facebook.feedplugins.base.footer.ui.Footer.FooterButtonId;
import com.facebook.graphql.model.GraphQLStory;

/* compiled from: TAGGEES */
class FooterStylingUtils {
    private static final SparseArray<Object> f23001a = TrackingNodes.a(TrackingNode.LIKE_LINK);
    private static final SparseArray<Object> f23002b = TrackingNodes.a(TrackingNode.COMMENT_LINK);
    private static final SparseArray<Object> f23003c = TrackingNodes.a(TrackingNode.SHARE_LINK);

    /* compiled from: TAGGEES */
    /* synthetic */ class C19881 {
        static final /* synthetic */ int[] f23000a = new int[FooterButtonId.values().length];

        static {
            try {
                f23000a[FooterButtonId.LIKE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f23000a[FooterButtonId.COMMENT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f23000a[FooterButtonId.SHARE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    FooterStylingUtils() {
    }

    static int m25484a(FooterButtonId footerButtonId) {
        switch (C19881.f23000a[footerButtonId.ordinal()]) {
            case 1:
                return 2131233267;
            case 2:
                return 2131233269;
            case 3:
                return 2131233280;
            default:
                throw new IllegalArgumentException("FooterButtonId not recognised");
        }
    }

    static Reference<Drawable> m25487a(ComponentContext componentContext, GraphQLStory graphQLStory, FooterButtonId footerButtonId, GlyphColorizerDrawableReference glyphColorizerDrawableReference) {
        int i;
        switch (C19881.f23000a[footerButtonId.ordinal()]) {
            case 1:
                i = 2130843790;
                break;
            case 2:
                i = 2130843788;
                break;
            case 3:
                i = 2130843792;
                break;
            default:
                throw new IllegalArgumentException("FooterButtonId not recognised");
        }
        return glyphColorizerDrawableReference.a(componentContext).m1294h(i).m1295i(m25486a(graphQLStory, footerButtonId)).b();
    }

    static int m25486a(GraphQLStory graphQLStory, FooterButtonId footerButtonId) {
        if (footerButtonId.equals(FooterButtonId.LIKE) && graphQLStory.B()) {
            return -10972929;
        }
        return -7235677;
    }

    static SparseArray<Object> m25488b(FooterButtonId footerButtonId) {
        switch (C19881.f23000a[footerButtonId.ordinal()]) {
            case 1:
                return f23001a;
            case 2:
                return f23002b;
            case 3:
                return f23003c;
            default:
                throw new IllegalArgumentException("FooterButtonId not recognised");
        }
    }

    static int m25485a(FooterButtonId footerButtonId, GraphQLStory graphQLStory) {
        switch (C19881.f23000a[footerButtonId.ordinal()]) {
            case 1:
                return graphQLStory.B() ? 2131233608 : 2131233607;
            case 2:
                return 2131233609;
            case 3:
                return 2131233610;
            default:
                throw new IllegalArgumentException("FooterButtonId not recognised");
        }
    }
}

package com.facebook.reaction.feed.corecomponents.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import com.facebook.graphql.enums.GraphQLReactionCoreImageTextImageSize;
import com.facebook.graphql.enums.GraphQLReactionCoreTextBoldness;
import com.facebook.graphql.enums.GraphQLReactionCoreTextLineSpacing;
import com.facebook.widget.text.CustomFontHelper;
import com.facebook.widget.text.CustomFontHelper.FontFamily;
import com.facebook.widget.text.CustomFontHelper.FontWeight;
import javax.annotation.Nullable;

/* compiled from: qp_id */
public class ReactionCoreComponentsUtil {

    /* compiled from: qp_id */
    /* synthetic */ class C06511 {
        static final /* synthetic */ int[] f4876a = new int[GraphQLReactionCoreImageTextImageSize.values().length];

        static {
            try {
                f4876a[GraphQLReactionCoreImageTextImageSize.EXTRA_LARGE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f4876a[GraphQLReactionCoreImageTextImageSize.LARGE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f4876a[GraphQLReactionCoreImageTextImageSize.MEDIUM.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f4876a[GraphQLReactionCoreImageTextImageSize.SMALL.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f4876a[GraphQLReactionCoreImageTextImageSize.EXTRA_SMALL.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public static float m4766a(GraphQLReactionCoreTextLineSpacing graphQLReactionCoreTextLineSpacing) {
        if (graphQLReactionCoreTextLineSpacing == GraphQLReactionCoreTextLineSpacing.EXTRA_LARGE) {
            return 1.5f;
        }
        if (graphQLReactionCoreTextLineSpacing == GraphQLReactionCoreTextLineSpacing.LARGE) {
            return 1.33f;
        }
        if (graphQLReactionCoreTextLineSpacing == GraphQLReactionCoreTextLineSpacing.MEDIUM) {
            return 1.25f;
        }
        return graphQLReactionCoreTextLineSpacing == GraphQLReactionCoreTextLineSpacing.SMALL ? 1.0f : 1.0f;
    }

    public static int m4768a(@Nullable String str, Resources resources) {
        try {
            return Color.parseColor("#" + str);
        } catch (IllegalArgumentException e) {
            return resources.getColor(2131361974);
        }
    }

    public static int m4767a(GraphQLReactionCoreImageTextImageSize graphQLReactionCoreImageTextImageSize) {
        switch (C06511.f4876a[graphQLReactionCoreImageTextImageSize.ordinal()]) {
            case 1:
                return 2131427461;
            case 2:
                return 2131427460;
            case 3:
                return 2131427458;
            case 4:
                return 2131427457;
            case 5:
                return 2131427456;
            default:
                return 2131427457;
        }
    }

    public static Typeface m4769a(Context context, @Nullable GraphQLReactionCoreTextBoldness graphQLReactionCoreTextBoldness) {
        if (graphQLReactionCoreTextBoldness == GraphQLReactionCoreTextBoldness.BOLD) {
            return CustomFontHelper.a(context, FontFamily.ROBOTO, FontWeight.BOLD, null);
        }
        if (graphQLReactionCoreTextBoldness == GraphQLReactionCoreTextBoldness.SEMIBOLD) {
            return CustomFontHelper.a(context, FontFamily.ROBOTO, FontWeight.MEDIUM, null);
        }
        if (graphQLReactionCoreTextBoldness == GraphQLReactionCoreTextBoldness.LIGHT) {
            return CustomFontHelper.a(context, FontFamily.ROBOTO, FontWeight.LIGHT, null);
        }
        return CustomFontHelper.a(context, FontFamily.ROBOTO, FontWeight.REGULAR, null);
    }
}

package com.facebook.feedplugins.quickpromotion;

import android.text.TextUtils;
import com.facebook.feedplugins.quickpromotion.QuickPromotionTemplateParameter.FeedTapAction;
import com.facebook.feedplugins.quickpromotion.QuickPromotionTemplateParameter.LargeImageProfilePhotoOption;
import com.facebook.feedplugins.quickpromotion.QuickPromotionTemplateParameter.PrimaryActionButtonGlyph;
import com.facebook.feedplugins.quickpromotion.QuickPromotionTemplateParameter.PrimaryActionButtonStyle;
import com.facebook.feedplugins.quickpromotion.QuickPromotionTemplateParameter.SecondaryActionButtonGlyph;
import com.facebook.feedplugins.quickpromotion.QuickPromotionTemplateParameter.Type;
import com.facebook.graphql.model.GraphQLQPTemplateParameter;
import com.facebook.graphql.model.GraphQLQuickPromotionAction;
import com.facebook.graphql.model.GraphQLQuickPromotionCreative;
import com.facebook.graphql.model.GraphQLQuickPromotionFeedUnit;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.QuickPromotionFeedUnitHelper;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: ccu_legal_open */
public class QuickPromotionFeedUnitUtils {

    /* compiled from: ccu_legal_open */
    public /* synthetic */ class C10791 {
        public static final /* synthetic */ int[] f8876a = new int[Type.values().length];

        static {
            try {
                f8876a[Type.IMAGE_OVERLAY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f8876a[Type.PRIMARY_ACTION_BUTTON_GLYPH.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f8876a[Type.NEWSFEED_LARGE_IMAGE_LOCATION.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f8876a[Type.FEED_TAP_ACTION.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f8876a[Type.NEWSFEED_BRANDING_STYLE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f8876a[Type.SECONDARY_ACTION_BUTTON_GLYPH.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f8876a[Type.TITLE_SIZE.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f8876a[Type.PRIMARY_ACTION_BUTTON_STYLE.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f8876a[Type.UNKNOWN.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
        }
    }

    public static boolean m9624a(@Nullable GraphQLQuickPromotionCreative graphQLQuickPromotionCreative) {
        if (graphQLQuickPromotionCreative == null || !m9623a(graphQLQuickPromotionCreative.p()) || m9623a(graphQLQuickPromotionCreative.q())) {
            return false;
        }
        return true;
    }

    public static boolean m9627b(@Nullable GraphQLQuickPromotionCreative graphQLQuickPromotionCreative) {
        if (graphQLQuickPromotionCreative != null && m9623a(graphQLQuickPromotionCreative.p()) && m9623a(graphQLQuickPromotionCreative.q())) {
            return true;
        }
        return false;
    }

    public static boolean m9623a(@Nullable GraphQLQuickPromotionAction graphQLQuickPromotionAction) {
        if (graphQLQuickPromotionAction == null || graphQLQuickPromotionAction.a() == null || TextUtils.isEmpty(graphQLQuickPromotionAction.a().a()) || TextUtils.isEmpty(graphQLQuickPromotionAction.j())) {
            return false;
        }
        return true;
    }

    public static boolean m9625a(GraphQLQuickPromotionFeedUnit graphQLQuickPromotionFeedUnit) {
        return !TextUtils.isEmpty(QuickPromotionFeedUnitHelper.d(graphQLQuickPromotionFeedUnit));
    }

    public static boolean m9628b(GraphQLQuickPromotionFeedUnit graphQLQuickPromotionFeedUnit) {
        GraphQLQuickPromotionCreative c = QuickPromotionFeedUnitHelper.c(graphQLQuickPromotionFeedUnit);
        return (c == null || c.r() == null || TextUtils.isEmpty(c.r().a())) ? false : true;
    }

    public static boolean m9626a(GraphQLTextWithEntities graphQLTextWithEntities) {
        return graphQLTextWithEntities != null && (!TextUtils.isEmpty(graphQLTextWithEntities.a()) || (graphQLTextWithEntities.d() != null && graphQLTextWithEntities.d().size() > 0));
    }

    public static FeedTapAction m9622a(ImmutableList<GraphQLQPTemplateParameter> immutableList) {
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            GraphQLQPTemplateParameter graphQLQPTemplateParameter = (GraphQLQPTemplateParameter) immutableList.get(i);
            if (Type.FEED_TAP_ACTION == Type.fromString(graphQLQPTemplateParameter.j())) {
                return FeedTapAction.fromString(graphQLQPTemplateParameter.l());
            }
        }
        return FeedTapAction.UNKNOWN;
    }

    public static PrimaryActionButtonGlyph m9629c(ImmutableList<GraphQLQPTemplateParameter> immutableList) {
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            GraphQLQPTemplateParameter graphQLQPTemplateParameter = (GraphQLQPTemplateParameter) immutableList.get(i);
            if (Type.PRIMARY_ACTION_BUTTON_GLYPH == Type.fromString(graphQLQPTemplateParameter.j())) {
                return PrimaryActionButtonGlyph.fromString(graphQLQPTemplateParameter.l());
            }
        }
        return PrimaryActionButtonGlyph.UNKNOWN;
    }

    public static SecondaryActionButtonGlyph m9630d(ImmutableList<GraphQLQPTemplateParameter> immutableList) {
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            GraphQLQPTemplateParameter graphQLQPTemplateParameter = (GraphQLQPTemplateParameter) immutableList.get(i);
            if (Type.SECONDARY_ACTION_BUTTON_GLYPH == Type.fromString(graphQLQPTemplateParameter.j())) {
                return SecondaryActionButtonGlyph.fromString(graphQLQPTemplateParameter.l());
            }
        }
        return SecondaryActionButtonGlyph.UNKNOWN;
    }

    public static PrimaryActionButtonStyle m9631f(ImmutableList<GraphQLQPTemplateParameter> immutableList) {
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            GraphQLQPTemplateParameter graphQLQPTemplateParameter = (GraphQLQPTemplateParameter) immutableList.get(i);
            if (Type.PRIMARY_ACTION_BUTTON_STYLE == Type.fromString(graphQLQPTemplateParameter.j())) {
                return PrimaryActionButtonStyle.fromString(graphQLQPTemplateParameter.l());
            }
        }
        return PrimaryActionButtonStyle.UNKNOWN;
    }

    public static LargeImageProfilePhotoOption m9632h(ImmutableList<GraphQLQPTemplateParameter> immutableList) {
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            GraphQLQPTemplateParameter graphQLQPTemplateParameter = (GraphQLQPTemplateParameter) immutableList.get(i);
            if (Type.NEWSFEED_LARGE_IMAGE_PROFILE_PHOTO == Type.fromString(graphQLQPTemplateParameter.j())) {
                return LargeImageProfilePhotoOption.fromString(graphQLQPTemplateParameter.l());
            }
        }
        return LargeImageProfilePhotoOption.UNKNOWN;
    }
}

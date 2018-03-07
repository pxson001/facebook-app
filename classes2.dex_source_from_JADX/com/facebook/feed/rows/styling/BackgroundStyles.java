package com.facebook.feed.rows.styling;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import com.facebook.common.util.SizeUtil;
import com.facebook.feed.rows.core.parts.PartWithViewType;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.PaddingStyle.PaddingValues;
import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: is_async_prepare */
public class BackgroundStyles {
    private BackgroundStyles() {
    }

    public static int m26966a(@Nullable FeedProps<? extends FeedUnit> feedProps, GraphQLStoryUtil graphQLStoryUtil) {
        return feedProps == null ? 0 : graphQLStoryUtil.m9602m((FeedProps) feedProps);
    }

    public static BackgroundStyler$Position m26972a(int i, @Nullable FeedProps<? extends FeedUnit> feedProps, BackgroundStyler$Position backgroundStyler$Position, PositionResolver positionResolver, PartWithViewType partWithViewType, PartWithViewType partWithViewType2, PartWithViewType partWithViewType3, Object obj, Object obj2) {
        return backgroundStyler$Position != null ? backgroundStyler$Position : positionResolver.m19149a(feedProps, i, partWithViewType, partWithViewType2, partWithViewType3, obj, obj2);
    }

    public static void m26973a(BackgroundStyler$Position backgroundStyler$Position, int i, BasePaddingStyleResolver basePaddingStyleResolver, PaddingStyle paddingStyle, Context context, Rect rect) {
        PaddingValues a = basePaddingStyleResolver.mo2549a(paddingStyle, backgroundStyler$Position, i);
        float a2 = a.f13047d.mo2553a(i);
        rect.set(m26965a(context, a2), m26965a(context, a.f13044a), m26965a(context, a2 + a.f13046c), m26965a(context, a.f13045b));
        boolean z = rect.top >= 0 && rect.bottom >= 0 && rect.left >= 0 && rect.right >= 0;
        Preconditions.checkArgument(z);
    }

    private static int m26965a(Context context, float f) {
        return Math.max(0, SizeUtil.m19191a(context, f));
    }

    public static Drawable m26969a(BackgroundStyler$Position backgroundStyler$Position, int i, int i2, int i3, BackgroundResourceResolver backgroundResourceResolver, Context context, Rect rect, PaddingStyle paddingStyle, BasePaddingStyleResolver basePaddingStyleResolver, GraphQLStorySeenState graphQLStorySeenState) {
        return m26968a(i3, m26967a(i2, m26970a(backgroundStyler$Position, i, backgroundResourceResolver, context, graphQLStorySeenState), context, rect), backgroundStyler$Position, i, context, paddingStyle, basePaddingStyleResolver);
    }

    private static Drawable m26970a(BackgroundStyler$Position backgroundStyler$Position, int i, BackgroundResourceResolver backgroundResourceResolver, Context context, GraphQLStorySeenState graphQLStorySeenState) {
        return backgroundResourceResolver.mo2548a(context.getResources(), backgroundStyler$Position, i, graphQLStorySeenState);
    }

    private static Drawable m26967a(int i, Drawable drawable, Context context, Rect rect) {
        if (i < 0) {
            return drawable;
        }
        return m26971a(drawable, context.getResources().getDrawable(i), rect.left, rect.top, rect.right, rect.bottom);
    }

    private static Drawable m26968a(int i, Drawable drawable, BackgroundStyler$Position backgroundStyler$Position, int i2, Context context, PaddingStyle paddingStyle, BasePaddingStyleResolver basePaddingStyleResolver) {
        if (i < 0) {
            return drawable;
        }
        Drawable drawable2 = context.getResources().getDrawable(i);
        PaddingValues b = basePaddingStyleResolver.mo2551b(paddingStyle, backgroundStyler$Position, i2);
        float a = b.f13047d.mo2553a(i2);
        int a2 = m26965a(context, a);
        int a3 = m26965a(context, a + b.f13046c);
        return m26971a(drawable, drawable2, a2, m26965a(context, b.f13044a), a3, m26965a(context, b.f13045b));
    }

    private static LayerDrawable m26971a(Drawable drawable, Drawable drawable2, int i, int i2, int i3, int i4) {
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{drawable, drawable2});
        layerDrawable.setLayerInset(layerDrawable.getNumberOfLayers() - 1, i, i2, i3, i4);
        return layerDrawable;
    }
}

package com.facebook.feed.ui.chaining;

import android.content.res.Resources;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.StringUtil;
import com.facebook.device.ScreenUtil;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.feed.ui.imageloader.FeedImageLoader;
import com.facebook.feed.ui.imageloader.FeedImageLoader.FeedImageType;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.ScrollableItemListFeedUnit;
import com.google.common.base.Strings;

/* compiled from: Tried to get non-existent cookie */
public class HScrollChainingUtil {
    public static void m24427a(Resources resources, ScrollableItemListFeedUnit scrollableItemListFeedUnit, TextView textView, int i) {
        CharSequence quantityString;
        int size = scrollableItemListFeedUnit.v().size();
        if (scrollableItemListFeedUnit.m() == null || StringUtil.c(scrollableItemListFeedUnit.m().a())) {
            quantityString = resources.getQuantityString(i, size);
        } else {
            quantityString = scrollableItemListFeedUnit.m().a();
        }
        textView.setText(quantityString);
        textView.setVisibility(0);
    }

    public static void m24428a(FbDraweeView fbDraweeView, GraphQLStoryAttachment graphQLStoryAttachment, FeedImageLoader feedImageLoader, FbDraweeControllerBuilder fbDraweeControllerBuilder, CallerContext callerContext) {
        if (graphQLStoryAttachment.r() == null) {
            fbDraweeView.setVisibility(8);
            return;
        }
        fbDraweeView.setAspectRatio(1.9318181f);
        GraphQLImage b = feedImageLoader.b(graphQLStoryAttachment.r(), FeedImageType.Share);
        if (b != null) {
            fbDraweeView.setVisibility(0);
            fbDraweeView.setController(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) fbDraweeControllerBuilder.a(callerContext).b(fbDraweeView.getController())).c(FeedImageLoader.a(b))).s());
            fbDraweeView.setContentDescription(Strings.nullToEmpty(graphQLStoryAttachment.A()));
            return;
        }
        fbDraweeView.setVisibility(8);
    }

    public static int m24426a(ScreenUtil screenUtil, int i, int i2) {
        return (Math.min(screenUtil.c(), screenUtil.d()) - (i * 2)) - (i2 / 2);
    }

    public static int m24425a(int i) {
        return (int) Math.floor((double) (((float) i) / 1.9318181f));
    }
}

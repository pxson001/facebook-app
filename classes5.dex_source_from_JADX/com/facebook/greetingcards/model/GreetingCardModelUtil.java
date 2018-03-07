package com.facebook.greetingcards.model;

import android.graphics.PointF;
import android.net.Uri;
import com.facebook.graphql.enums.GraphQLGreetingCardSlideType;
import com.facebook.greetingcards.model.GreetingCard.Slide;
import com.facebook.greetingcards.model.GreetingCardGraphQLModels.PrefilledGreetingCardFieldsModel.SlidesModel.NodesModel;
import com.facebook.greetingcards.model.GreetingCardGraphQLModels.PrefilledGreetingCardFieldsModel.SlidesModel.NodesModel.PhotosModel.PhotosNodesModel;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

/* compiled from: TRENDING_TOPIC */
public class GreetingCardModelUtil {

    /* compiled from: TRENDING_TOPIC */
    public /* synthetic */ class C12911 {
        public static final /* synthetic */ int[] f13547a = new int[GraphQLGreetingCardSlideType.values().length];

        static {
            try {
                f13547a[GraphQLGreetingCardSlideType.COVER_SLIDE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f13547a[GraphQLGreetingCardSlideType.STORY_SLIDE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f13547a[GraphQLGreetingCardSlideType.CLOSING_SLIDE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public static Slide m22804a(NodesModel nodesModel) {
        Builder builder = ImmutableList.builder();
        ImmutableList a = nodesModel.m22771j().m22761a();
        int size = a.size();
        int size2 = a.size();
        for (int i = 0; i < size2; i++) {
            PhotosNodesModel photosNodesModel = (PhotosNodesModel) a.get(i);
            if (size == 1 && photosNodesModel.m22756l() != null) {
                builder.c(CardPhoto.m22711a(Uri.parse(photosNodesModel.m22756l().m22743a()), photosNodesModel.m22755k(), photosNodesModel.m22754j() == null ? null : new PointF((float) photosNodesModel.m22754j().m9639a(), (float) photosNodesModel.m22754j().m9643b())));
            } else if (photosNodesModel.m22757m() != null) {
                builder.c(CardPhoto.m22711a(Uri.parse(photosNodesModel.m22757m().m22748a()), photosNodesModel.m22755k(), photosNodesModel.m22754j() == null ? null : new PointF((float) photosNodesModel.m22754j().m9639a(), (float) photosNodesModel.m22754j().m9643b())));
            }
        }
        return new Slide(nodesModel.m22773l() != null ? nodesModel.m22773l().m22767a() : "", nodesModel.m22770a() != null ? nodesModel.m22770a().m22736a() : "", builder.b());
    }
}

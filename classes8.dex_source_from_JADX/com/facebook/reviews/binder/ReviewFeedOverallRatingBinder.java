package com.facebook.reviews.binder;

import android.util.SparseIntArray;
import com.facebook.reviews.protocol.graphql.PageReviewsFragmentsModels.PageOverallStarRatingModel;
import com.facebook.reviews.protocol.graphql.PageReviewsFragmentsModels.PageOverallStarRatingModel.HistogramModel;
import com.facebook.reviews.ui.ReviewFeedOverallRatingView;
import com.google.common.collect.ImmutableList;

/* compiled from: UPDATE_EMAIL */
public class ReviewFeedOverallRatingBinder {
    public static void m25031b(ReviewFeedOverallRatingView reviewFeedOverallRatingView, PageOverallStarRatingModel pageOverallStarRatingModel) {
        reviewFeedOverallRatingView.setTitle(pageOverallStarRatingModel.d());
        SparseIntArray sparseIntArray = new SparseIntArray();
        ImmutableList a = pageOverallStarRatingModel.a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            HistogramModel histogramModel = (HistogramModel) a.get(i);
            sparseIntArray.append(histogramModel.b(), histogramModel.a());
        }
        reviewFeedOverallRatingView.m25263a(sparseIntArray, pageOverallStarRatingModel.c());
    }
}

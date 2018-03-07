package com.facebook.reviews.adapter;

import android.support.v4.util.ArrayMap;
import com.facebook.reviews.protocol.graphql.UserReviewsFragmentsInterfaces.PlaceToReview;
import com.facebook.reviews.protocol.graphql.UserReviewsFragmentsModels.PlaceToReviewModel;
import com.facebook.reviews.protocol.graphql.UserReviewsFragmentsModels.PlacesToReviewModel.PlaceReviewSuggestionsModel;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: US/Pacific */
public class PlacesToReviewSection extends UserReviewsListBaseSection<PlaceToReview> {
    public final UserReviewsListSeeMoreFooter f21353a;
    public final List<PlaceToReview> f21354b = new ArrayList();
    public final Map<String, PlaceToReview> f21355c = new ArrayMap();
    public boolean f21356d = true;
    public String f21357e;
    public String f21358f;

    @Inject
    public PlacesToReviewSection(UserReviewsListSeeMoreFooter userReviewsListSeeMoreFooter) {
        this.f21353a = userReviewsListSeeMoreFooter;
    }

    public final void m24975a(@Nullable PlaceReviewSuggestionsModel placeReviewSuggestionsModel) {
        if (placeReviewSuggestionsModel != null && placeReviewSuggestionsModel.a() != null) {
            ImmutableList a = placeReviewSuggestionsModel.a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                PlaceToReviewModel placeToReviewModel = (PlaceToReviewModel) a.get(i);
                if (!(placeToReviewModel == null || this.f21355c.containsKey(placeToReviewModel.c()))) {
                    this.f21354b.add(placeToReviewModel);
                    this.f21355c.put(placeToReviewModel.c(), placeToReviewModel);
                }
            }
            if (placeReviewSuggestionsModel.b() != null) {
                this.f21356d = placeReviewSuggestionsModel.b().b();
                if (!this.f21356d) {
                    this.f21353a.f21373a = false;
                }
                this.f21357e = placeReviewSuggestionsModel.b().a();
            }
        }
    }

    public final /* synthetic */ UserReviewsListBaseFooter mo1167l() {
        return this.f21353a;
    }

    public final boolean m24978b(String str) {
        if (!this.f21355c.containsKey(str)) {
            return false;
        }
        this.f21354b.remove((PlaceToReviewModel) this.f21355c.get(str));
        return true;
    }

    protected final UserReviewsListViewTypes mo1164i() {
        return this.f21354b.isEmpty() ? UserReviewsListViewTypes.NO_HEADER : UserReviewsListViewTypes.DEFAULT_HEADER;
    }

    protected final boolean mo1165j() {
        return !this.f21354b.isEmpty();
    }

    protected final int mo1166k() {
        return this.f21354b.size();
    }

    protected final Object mo1163b(int i) {
        return (PlaceToReviewModel) this.f21354b.get(i);
    }

    protected final UserReviewsListViewTypes mo1162a(int i) {
        return UserReviewsListViewTypes.PLACES_TO_REVIEW;
    }

    public final String m24974a() {
        return this.f21358f;
    }

    public final List m24977b() {
        return ImmutableList.copyOf(this.f21354b);
    }
}

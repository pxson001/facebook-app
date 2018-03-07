package com.facebook.pages.common.surface.ui.metabox;

import com.facebook.common.locale.Locales;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.enums.GraphQLPageOpenHoursDisplayDecisionEnum;
import com.facebook.pages.common.abtest.qe.PagesExperimentUtils;
import com.facebook.pages.common.surface.ui.metabox.PagesMetaboxViewModel.MetaboxTopRowState;
import com.facebook.pages.data.model.pageheader.PageHeaderData;
import com.facebook.reviews.util.helper.ReviewsRatingHelper;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: region_south_latitude */
public class PagesMetaboxController {
    private final ReviewsRatingHelper f2655a;
    private final Locales f2656b;
    private final PagesExperimentUtils f2657c;

    @Inject
    public PagesMetaboxController(ReviewsRatingHelper reviewsRatingHelper, Locales locales, PagesExperimentUtils pagesExperimentUtils) {
        this.f2655a = reviewsRatingHelper;
        this.f2656b = locales;
        this.f2657c = pagesExperimentUtils;
    }

    public final PagesMetaboxViewModel m3616a(PageHeaderData pageHeaderData) {
        boolean z;
        boolean z2;
        String str;
        MetaboxTopRowState metaboxTopRowState;
        int i;
        Preconditions.checkNotNull(pageHeaderData);
        Preconditions.checkNotNull(pageHeaderData.e);
        if (StringUtil.a((CharSequence) pageHeaderData.e.s().get(0))) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((String) pageHeaderData.e.s().get(0));
        if (!(this.f2657c.g() || pageHeaderData.e.j() == null || StringUtil.a(pageHeaderData.e.j().a()))) {
            stringBuilder.append(" · ");
            stringBuilder.append(pageHeaderData.e.j().a());
        }
        Object obj = null;
        float f = 0.0f;
        String str2 = "";
        String str3 = null;
        boolean z3 = false;
        int i2 = 0;
        GraphQLPageOpenHoursDisplayDecisionEnum graphQLPageOpenHoursDisplayDecisionEnum = GraphQLPageOpenHoursDisplayDecisionEnum.NO_SHOW;
        MetaboxTopRowState metaboxTopRowState2 = MetaboxTopRowState.HIDDEN;
        if (!this.f2657c.i()) {
            if (pageHeaderData.e.F() != null) {
                obj = 1;
                f = (float) pageHeaderData.e.F().j();
                str2 = this.f2655a.a(pageHeaderData.e.F().j());
                if (pageHeaderData.e.F().a() > 0 && this.f2657c.k()) {
                    i2 = pageHeaderData.e.F().a();
                    z3 = true;
                }
            }
            Object obj2 = null;
            if (!(pageHeaderData.e.I() == null || StringUtil.a(pageHeaderData.e.I().a()) || pageHeaderData.e.J() == null)) {
                obj2 = 1;
                str3 = pageHeaderData.e.I().a().toUpperCase(this.f2656b.a());
                graphQLPageOpenHoursDisplayDecisionEnum = pageHeaderData.e.J();
            }
            if (obj == null || obj2 == null) {
                if (obj != null) {
                    z2 = z3;
                    str = str2;
                    metaboxTopRowState = MetaboxTopRowState.RATING_ONLY;
                    i = i2;
                } else if (obj2 != null) {
                    z2 = z3;
                    str = str2;
                    metaboxTopRowState = MetaboxTopRowState.OPEN_HOURS_ONLY;
                    i = i2;
                }
                return new PagesMetaboxViewModel(stringBuilder.toString(), metaboxTopRowState, f, i, z2, str, str3, graphQLPageOpenHoursDisplayDecisionEnum, this.f2657c.j());
            }
            z2 = z3;
            str = str2;
            metaboxTopRowState = MetaboxTopRowState.RATING_AND_OPEN_HOURS;
            i = i2;
            return new PagesMetaboxViewModel(stringBuilder.toString(), metaboxTopRowState, f, i, z2, str, str3, graphQLPageOpenHoursDisplayDecisionEnum, this.f2657c.j());
        }
        i = i2;
        str = str2;
        metaboxTopRowState = metaboxTopRowState2;
        z2 = z3;
        return new PagesMetaboxViewModel(stringBuilder.toString(), metaboxTopRowState, f, i, z2, str, str3, graphQLPageOpenHoursDisplayDecisionEnum, this.f2657c.j());
    }
}

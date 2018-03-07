package com.facebook.pages.common.editpage.presenter;

import android.app.Activity;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import com.facebook.graphql.enums.GraphQLPagePresenceTabType;
import com.facebook.inject.Assisted;
import com.facebook.pages.common.abtest.qe.PagesExperimentUtils;
import com.facebook.pages.common.editpage.EditPageNavigationUtil;
import com.facebook.pages.common.editpage.graphql.FetchEditPageQueryInterfaces.EditPageData;
import com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.SectionsCanAddDataModel.SectionsCanAddModel;
import com.facebook.pages.common.editpage.presenter.EditPageSectionPresenter.SectionContext;
import javax.inject.Inject;

/* compiled from: should_fetch_payment_methods */
public class GenericViewSectionPresenter implements EditPageSectionPresenter {
    private final PagesExperimentUtils f1608a;
    private final GraphQLPagePresenceTabType f1609b;

    /* compiled from: should_fetch_payment_methods */
    /* synthetic */ class C02201 {
        static final /* synthetic */ int[] f1607a = new int[GraphQLPagePresenceTabType.values().length];

        static {
            try {
                f1607a[GraphQLPagePresenceTabType.BOOK_PREVIEW.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1607a[GraphQLPagePresenceTabType.EVENTS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f1607a[GraphQLPagePresenceTabType.LOCATIONS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f1607a[GraphQLPagePresenceTabType.MUSIC.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f1607a[GraphQLPagePresenceTabType.PHOTOS.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f1607a[GraphQLPagePresenceTabType.POSTS.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f1607a[GraphQLPagePresenceTabType.REVIEWS.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f1607a[GraphQLPagePresenceTabType.VIDEOS.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f1607a[GraphQLPagePresenceTabType.ACTIVITY.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f1607a[GraphQLPagePresenceTabType.GROUPS.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
        }
    }

    @Inject
    public GenericViewSectionPresenter(PagesExperimentUtils pagesExperimentUtils, @Assisted GraphQLPagePresenceTabType graphQLPagePresenceTabType) {
        this.f1608a = pagesExperimentUtils;
        this.f1609b = graphQLPagePresenceTabType;
    }

    public final boolean mo36a(EditPageData editPageData) {
        return this.f1608a.a();
    }

    public final boolean mo37a(SectionsCanAddModel sectionsCanAddModel) {
        return false;
    }

    @DrawableRes
    public final int mo38b() {
        switch (C02201.f1607a[this.f1609b.ordinal()]) {
            case 1:
                return 2130839718;
            case 2:
                return 2130839851;
            case 3:
                return 2130839969;
            case 4:
                return 2130839995;
            case 5:
                return 2130840019;
            case 6:
                return 2130840052;
            case 7:
                return 2130840114;
            case 8:
                return 2130840148;
            case 9:
                return 2130839905;
            case 10:
                return 2130839914;
            default:
                return 0;
        }
    }

    @StringRes
    public final int mo39c() {
        return 0;
    }

    public final void mo35a(Activity activity, long j, SectionContext sectionContext) {
        if (sectionContext == SectionContext.EDIT) {
            EditPageNavigationUtil.m2253a(activity, this.f1609b);
            return;
        }
        throw new UnsupportedOperationException("Cannot " + sectionContext.toString() + " the " + this.f1609b.name() + " section.");
    }
}

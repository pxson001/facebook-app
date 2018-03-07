package com.facebook.pages.identity.contextitems;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.facebook.crowdsourcing.enums.CrowdsourcingFieldType;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.ContextItemFieldsModel;
import com.facebook.graphql.enums.GraphQLEntityCardContextItemType;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.pages.common.logging.analytics.PagesAnalytics;
import com.facebook.pages.identity.cards.maps.PageIdentityMapUtil;
import com.facebook.pages.identity.contextitems.handler.PageContextItemHandlingData;
import com.facebook.pages.identity.contextitems.handler.PageContextItemsClickHandler;
import javax.inject.Inject;

/* compiled from: photosEnabled */
public class PageContextItemsClickHandlerImpl implements PageContextItemsClickHandler {
    private final Lazy<PageContextItemsPageDetailsHandler> f3812a;
    private final Lazy<PageContextItemsReviewsHandler> f3813b;
    private final Lazy<PageContextItemsCallHandler> f3814c;
    private final Lazy<PageContextItemsViewWebsiteHandler> f3815d;
    private final Lazy<PageContextItemsAddPhotoMenuHandler> f3816e;
    private final Lazy<PageContextItemsAddProfilePhotoHandler> f3817f;
    private final Lazy<PageContextItemsAddCoverPhotoHandler> f3818g;
    private final Lazy<PageContextItemsLaunchComposerHandler> f3819h;
    private final Lazy<PageContextItemsAddReviewHandler> f3820i;
    private final Lazy<PageContextItemsFallbackHandler> f3821j;
    private final Lazy<PageContextItemsInsightsHandler> f3822k;
    private final Lazy<PageContextItemsMessageResponsivenessHandler> f3823l;
    private final Lazy<PageContextItemsReactionHandler> f3824m;
    private final Lazy<PageContextItemsViewMenuHandler> f3825n;
    private final Lazy<PageContextItemsAddPageInfoHandler> f3826o;
    private final Lazy<PageContextItemsAddressPlaceQuestionHandler> f3827p;
    private final Lazy<PageContextItemsCategoryPlaceQuestionHandler> f3828q;
    private final Lazy<PageContextItemsSubscribeToNearbyEventsHandler> f3829r;
    private final Lazy<PageContextItemsInviteFriendsLikePageHandler> f3830s;
    private final Lazy<PageContextItemsMessagePageHandler> f3831t;
    private final Lazy<PageContextItemsPageTipsHandler> f3832u;
    private final Lazy<PageIdentityMapUtil> f3833v;
    private final Lazy<PagesAnalytics> f3834w;

    /* compiled from: photosEnabled */
    /* synthetic */ class C05201 {
        static final /* synthetic */ int[] f3811a = new int[GraphQLEntityCardContextItemType.values().length];

        static {
            try {
                f3811a[GraphQLEntityCardContextItemType.MOVIE_DETAILS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f3811a[GraphQLEntityCardContextItemType.TV_SHOW_DETAILS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f3811a[GraphQLEntityCardContextItemType.IMPRESSUM.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f3811a[GraphQLEntityCardContextItemType.PLACE_INFO.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f3811a[GraphQLEntityCardContextItemType.DISTANCE_FROM_USER.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f3811a[GraphQLEntityCardContextItemType.CALL.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f3811a[GraphQLEntityCardContextItemType.VIEW_WEBSITE.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f3811a[GraphQLEntityCardContextItemType.ADMIN_TIP_ADD_PHOTO_MENU.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f3811a[GraphQLEntityCardContextItemType.ADMIN_TIP_ADD_PROFILE_PIC.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f3811a[GraphQLEntityCardContextItemType.ADMIN_TIP_ADD_COVER_PHOTO.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f3811a[GraphQLEntityCardContextItemType.ADMIN_TIP_CREATE_POST.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f3811a[GraphQLEntityCardContextItemType.ADMIN_TIP_CREATE_PHOTO_POST.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                f3811a[GraphQLEntityCardContextItemType.RATINGS_AND_REVIEWS.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                f3811a[GraphQLEntityCardContextItemType.ADMIN_WEEKLY_NEW_LIKES.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                f3811a[GraphQLEntityCardContextItemType.ADMIN_WEEKLY_POST_REACH.ordinal()] = 15;
            } catch (NoSuchFieldError e15) {
            }
            try {
                f3811a[GraphQLEntityCardContextItemType.ADMIN_MESSAGE_ACTIVE_TROPHY.ordinal()] = 16;
            } catch (NoSuchFieldError e16) {
            }
            try {
                f3811a[GraphQLEntityCardContextItemType.ADMIN_MESSAGE_INACTIVE_TROPHY.ordinal()] = 17;
            } catch (NoSuchFieldError e17) {
            }
            try {
                f3811a[GraphQLEntityCardContextItemType.SELF_REVIEW.ordinal()] = 18;
            } catch (NoSuchFieldError e18) {
            }
            try {
                f3811a[GraphQLEntityCardContextItemType.LIKES_AP.ordinal()] = 19;
            } catch (NoSuchFieldError e19) {
            }
            try {
                f3811a[GraphQLEntityCardContextItemType.VISITS_AP.ordinal()] = 20;
            } catch (NoSuchFieldError e20) {
            }
            try {
                f3811a[GraphQLEntityCardContextItemType.PAGE_FRIEND_CONTENT.ordinal()] = 21;
            } catch (NoSuchFieldError e21) {
            }
            try {
                f3811a[GraphQLEntityCardContextItemType.PAGE_POPULAR_CONTENT.ordinal()] = 22;
            } catch (NoSuchFieldError e22) {
            }
            try {
                f3811a[GraphQLEntityCardContextItemType.PAGE_FRIENDS_POPULAR_CONTENT.ordinal()] = 23;
            } catch (NoSuchFieldError e23) {
            }
            try {
                f3811a[GraphQLEntityCardContextItemType.PAGE_REACTION_UNITS_SANDBOX.ordinal()] = 24;
            } catch (NoSuchFieldError e24) {
            }
            try {
                f3811a[GraphQLEntityCardContextItemType.FRIEND_LIKES.ordinal()] = 25;
            } catch (NoSuchFieldError e25) {
            }
            try {
                f3811a[GraphQLEntityCardContextItemType.GLOBAL_INFORMATION.ordinal()] = 26;
            } catch (NoSuchFieldError e26) {
            }
            try {
                f3811a[GraphQLEntityCardContextItemType.MENU.ordinal()] = 27;
            } catch (NoSuchFieldError e27) {
            }
            try {
                f3811a[GraphQLEntityCardContextItemType.ADD_PAGE_INFO.ordinal()] = 28;
            } catch (NoSuchFieldError e28) {
            }
            try {
                f3811a[GraphQLEntityCardContextItemType.PLACE_STREET_ADDRESS_QUESTION.ordinal()] = 29;
            } catch (NoSuchFieldError e29) {
            }
            try {
                f3811a[GraphQLEntityCardContextItemType.PLACE_CITY_QUESTION.ordinal()] = 30;
            } catch (NoSuchFieldError e30) {
            }
            try {
                f3811a[GraphQLEntityCardContextItemType.PLACE_ZIP_CODE_QUESTION.ordinal()] = 31;
            } catch (NoSuchFieldError e31) {
            }
            try {
                f3811a[GraphQLEntityCardContextItemType.PLACE_CATEGORY_QUESTION.ordinal()] = 32;
            } catch (NoSuchFieldError e32) {
            }
            try {
                f3811a[GraphQLEntityCardContextItemType.PAGE_EVENTS_CALENDAR_SUBSCRIPTION.ordinal()] = 33;
            } catch (NoSuchFieldError e33) {
            }
            try {
                f3811a[GraphQLEntityCardContextItemType.FRIEND_INVITER.ordinal()] = 34;
            } catch (NoSuchFieldError e34) {
            }
            try {
                f3811a[GraphQLEntityCardContextItemType.MESSAGE_PAGE.ordinal()] = 35;
            } catch (NoSuchFieldError e35) {
            }
            try {
                f3811a[GraphQLEntityCardContextItemType.ADS_AFTER_PARTY_AYMT_TIPS.ordinal()] = 36;
            } catch (NoSuchFieldError e36) {
            }
        }
    }

    public static PageContextItemsClickHandlerImpl m4770b(InjectorLike injectorLike) {
        return new PageContextItemsClickHandlerImpl(IdBasedLazy.a(injectorLike, 9069), IdBasedLazy.a(injectorLike, 9073), IdBasedLazy.a(injectorLike, 9060), IdBasedLazy.a(injectorLike, 9076), IdBasedLazy.a(injectorLike, 9056), IdBasedSingletonScopeProvider.b(injectorLike, 9057), IdBasedSingletonScopeProvider.b(injectorLike, 9054), IdBasedLazy.a(injectorLike, 9066), IdBasedLazy.a(injectorLike, 9058), IdBasedLazy.a(injectorLike, 9063), IdBasedLazy.a(injectorLike, 9064), IdBasedLazy.a(injectorLike, 9068), IdBasedLazy.a(injectorLike, 9072), IdBasedLazy.a(injectorLike, 9075), IdBasedLazy.a(injectorLike, 9055), IdBasedLazy.a(injectorLike, 9059), IdBasedLazy.a(injectorLike, 9061), IdBasedLazy.a(injectorLike, 9074), IdBasedLazy.a(injectorLike, 9067), IdBasedLazy.a(injectorLike, 9070), IdBasedLazy.a(injectorLike, 9039), IdBasedSingletonScopeProvider.b(injectorLike, 8930), IdBasedSingletonScopeProvider.b(injectorLike, 9065));
    }

    @Inject
    public PageContextItemsClickHandlerImpl(Lazy<PageContextItemsPageDetailsHandler> lazy, Lazy<PageContextItemsReviewsHandler> lazy2, Lazy<PageContextItemsCallHandler> lazy3, Lazy<PageContextItemsViewWebsiteHandler> lazy4, Lazy<PageContextItemsAddPhotoMenuHandler> lazy5, Lazy<PageContextItemsAddProfilePhotoHandler> lazy6, Lazy<PageContextItemsAddCoverPhotoHandler> lazy7, Lazy<PageContextItemsLaunchComposerHandler> lazy8, Lazy<PageContextItemsAddReviewHandler> lazy9, Lazy<PageContextItemsFallbackHandler> lazy10, Lazy<PageContextItemsInsightsHandler> lazy11, Lazy<PageContextItemsMessageResponsivenessHandler> lazy12, Lazy<PageContextItemsReactionHandler> lazy13, Lazy<PageContextItemsViewMenuHandler> lazy14, Lazy<PageContextItemsAddPageInfoHandler> lazy15, Lazy<PageContextItemsAddressPlaceQuestionHandler> lazy16, Lazy<PageContextItemsCategoryPlaceQuestionHandler> lazy17, Lazy<PageContextItemsSubscribeToNearbyEventsHandler> lazy18, Lazy<PageContextItemsMessagePageHandler> lazy19, Lazy<PageContextItemsPageTipsHandler> lazy20, Lazy<PageIdentityMapUtil> lazy21, Lazy<PagesAnalytics> lazy22, Lazy<PageContextItemsInviteFriendsLikePageHandler> lazy23) {
        this.f3812a = lazy;
        this.f3813b = lazy2;
        this.f3814c = lazy3;
        this.f3815d = lazy4;
        this.f3816e = lazy5;
        this.f3817f = lazy6;
        this.f3818g = lazy7;
        this.f3819h = lazy8;
        this.f3820i = lazy9;
        this.f3821j = lazy10;
        this.f3822k = lazy11;
        this.f3823l = lazy12;
        this.f3824m = lazy13;
        this.f3825n = lazy14;
        this.f3826o = lazy15;
        this.f3827p = lazy16;
        this.f3828q = lazy17;
        this.f3829r = lazy18;
        this.f3831t = lazy19;
        this.f3833v = lazy21;
        this.f3834w = lazy22;
        this.f3830s = lazy23;
        this.f3832u = lazy20;
    }

    public final void m4771a(View view, ContextItemFieldsModel contextItemFieldsModel, PageContextItemHandlingData pageContextItemHandlingData) {
        GraphQLEntityCardContextItemType d = contextItemFieldsModel.d();
        if (d == GraphQLEntityCardContextItemType.CALL_TO_ACTION) {
            ((PagesAnalytics) this.f3834w.get()).a(pageContextItemHandlingData.a, null, null);
        }
        switch (C05201.f3811a[d.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                ((PageContextItemsPageDetailsHandler) this.f3812a.get()).f3850a.a(pageContextItemHandlingData.a);
                return;
            case 5:
                ((PageIdentityMapUtil) this.f3833v.get()).m4565b(pageContextItemHandlingData);
                return;
            case 6:
                ((PageContextItemsCallHandler) this.f3814c.get()).m4769a(contextItemFieldsModel);
                return;
            case 7:
                PageContextItemsViewWebsiteHandler pageContextItemsViewWebsiteHandler = (PageContextItemsViewWebsiteHandler) this.f3815d.get();
                String a = contextItemFieldsModel.a();
                if (a != null) {
                    pageContextItemsViewWebsiteHandler.f3892b.b(new Intent("android.intent.action.VIEW").setData(Uri.parse(a)), pageContextItemsViewWebsiteHandler.f3891a);
                }
                return;
            case 8:
                ((PageContextItemsAddPhotoMenuHandler) this.f3816e.get()).m4764a(view, pageContextItemHandlingData);
                return;
            case 9:
                ((PageContextItemsAddProfilePhotoHandler) this.f3817f.get()).m4767a(view);
                return;
            case 10:
                ((PageContextItemsAddCoverPhotoHandler) this.f3818g.get()).m4762a(view);
                return;
            case 11:
            case 12:
                ((PageContextItemsLaunchComposerHandler) this.f3819h.get()).m4781a(view, contextItemFieldsModel, pageContextItemHandlingData);
                return;
            case 13:
                ((PageContextItemsReviewsHandler) this.f3813b.get()).m4797a(pageContextItemHandlingData);
                return;
            case 14:
            case 15:
                ((PageContextItemsInsightsHandler) this.f3822k.get()).m4776a(contextItemFieldsModel, pageContextItemHandlingData);
                return;
            case 16:
            case 17:
                ((PageContextItemsMessageResponsivenessHandler) this.f3823l.get()).m4783a(view, pageContextItemHandlingData);
                return;
            case 18:
                ((PageContextItemsAddReviewHandler) this.f3820i.get()).m4768a(view, pageContextItemHandlingData);
                return;
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
                ((PageContextItemsReactionHandler) this.f3824m.get()).m4796a(contextItemFieldsModel, pageContextItemHandlingData);
                return;
            case 27:
                ((PageContextItemsViewMenuHandler) this.f3825n.get()).m4799a(view, contextItemFieldsModel, pageContextItemHandlingData);
                return;
            case 28:
                ((PageContextItemsAddPageInfoHandler) this.f3826o.get()).m4763a(view, pageContextItemHandlingData);
                return;
            case 29:
            case 30:
            case 31:
                ((PageContextItemsAddressPlaceQuestionHandler) this.f3827p.get()).f3807a.m4795a(view, pageContextItemHandlingData, CrowdsourcingFieldType.PLACE_ADDRESS);
                return;
            case 32:
                ((PageContextItemsCategoryPlaceQuestionHandler) this.f3828q.get()).f3810a.m4795a(view, pageContextItemHandlingData, CrowdsourcingFieldType.PLACE_TOPIC);
                return;
            case 33:
                ((PageContextItemsSubscribeToNearbyEventsHandler) this.f3829r.get()).m4798a(view, pageContextItemHandlingData);
                return;
            case 34:
                ((PageContextItemsInviteFriendsLikePageHandler) this.f3830s.get()).m4779a(view, pageContextItemHandlingData);
                return;
            case 35:
                ((PageContextItemsMessagePageHandler) this.f3831t.get()).m4782a(view, pageContextItemHandlingData);
                return;
            case 36:
                ((PageContextItemsPageTipsHandler) this.f3832u.get()).m4784a(pageContextItemHandlingData);
                return;
            default:
                ((PageContextItemsFallbackHandler) this.f3821j.get()).m4774a(contextItemFieldsModel);
                return;
        }
    }
}

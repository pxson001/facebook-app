package com.facebook.pages.identity.cards.criticreviews;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.Assisted;
import com.facebook.localcontent.criticreviews.CriticReviewView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.data.graphql.cards.CriticReviewsCardGraphQLInterfaces.CriticReviewsCardQuery.CriticReviewsReceived.Nodes;
import com.facebook.pages.data.graphql.cards.CriticReviewsCardGraphQLModels.CriticReviewsCardQueryModel.CriticReviewsReceivedModel.NodesModel;
import com.facebook.reviews.analytics.ReviewsClickEventTargets;
import com.facebook.reviews.analytics.ReviewsLogger;
import com.facebook.ui.recyclablepager.PagerViewType;
import com.facebook.ui.recyclablepager.RecyclablePagerAdapter;
import com.facebook.ui.recyclableviewpool.RecyclableViewPoolManager;
import com.google.common.base.Strings;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: privacy_checkup_manager_empty_review_section_header */
public class PageIdentityCriticReviewsAdapter extends RecyclablePagerAdapter<Nodes> {
    private final PagerViewType f3440a;
    public final FbUriIntentHandler f3441b;
    public final ReviewsLogger f3442c;
    public final SecureContextHelper f3443d;
    public List<Nodes> f3444e = new ArrayList();
    public String f3445f;

    public final void m4523a(View view, Object obj, int i) {
        final NodesModel nodesModel = (NodesModel) obj;
        CriticReviewView criticReviewView = (CriticReviewView) view;
        criticReviewView.setPublisherName(nodesModel.kt_().c());
        criticReviewView.setPublishTime(nodesModel.d() == null ? null : nodesModel.d().a());
        criticReviewView.setPublisherThumbnail(nodesModel.kt_().d().a());
        criticReviewView.setReviewTitle(nodesModel.ks_().a());
        criticReviewView.setReviewSummary(nodesModel.g().a());
        criticReviewView.setReviewAuthor(nodesModel.a() == null ? null : nodesModel.a().a());
        criticReviewView.setReviewThumbnail(nodesModel.b().a());
        if (Strings.isNullOrEmpty(nodesModel.kt_().b())) {
            criticReviewView.setPublisherContainerOnClickListener(null);
        } else {
            criticReviewView.setPublisherContainerOnClickListener(new OnClickListener(this) {
                final /* synthetic */ PageIdentityCriticReviewsAdapter f3437b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 1275569450);
                    this.f3437b.f3442c.a("pages_public_view", this.f3437b.f3445f, nodesModel.kt_().b(), ReviewsClickEventTargets.CRITIC_REVIEW_PUBLISHER_CONTAINER);
                    this.f3437b.f3441b.a(view.getContext(), StringFormatUtil.formatStrLocaleSafe(FBLinks.af, nodesModel.kt_().b()));
                    Logger.a(2, EntryType.UI_INPUT_END, -535214781, a);
                }
            });
        }
        criticReviewView.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PageIdentityCriticReviewsAdapter f3439b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1960446601);
                this.f3439b.f3442c.a("pages_public_view", this.f3439b.f3445f, nodesModel.kt_().b(), ReviewsClickEventTargets.CRITIC_REVIEW);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(nodesModel.c()));
                this.f3439b.f3443d.b(intent, view.getContext());
                Logger.a(2, EntryType.UI_INPUT_END, -796570088, a);
            }
        });
    }

    @Inject
    public PageIdentityCriticReviewsAdapter(FbUriIntentHandler fbUriIntentHandler, ReviewsLogger reviewsLogger, SecureContextHelper secureContextHelper, RecyclableViewPoolManager recyclableViewPoolManager, @Assisted final ViewPager viewPager) {
        super(recyclableViewPoolManager);
        this.f3441b = fbUriIntentHandler;
        this.f3442c = reviewsLogger;
        this.f3443d = secureContextHelper;
        this.f3440a = new PagerViewType(this) {
            final /* synthetic */ PageIdentityCriticReviewsAdapter f3435b;

            public final Class m4521a() {
                return CriticReviewView.class;
            }

            public final View m4520a(Context context) {
                return LayoutInflater.from(context).inflate(2130906013, viewPager, false);
            }
        };
    }

    public final PagerViewType m4522a(int i) {
        return this.f3440a;
    }

    public final Object m4525b(int i) {
        return (NodesModel) this.f3444e.get(i);
    }

    public final int m4524b() {
        return this.f3444e.size();
    }

    public final float m4526d(int i) {
        return 1.0f;
    }
}

package com.facebook.feedback.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.InjectorLike;
import com.facebook.privacy.nux.PrivacyEducationBannerController;
import com.facebook.privacy.ui.PrivacyEducationBannerView;
import com.facebook.story.GraphQLStoryHelper;
import com.facebook.widget.listview.FbBaseAdapter;
import javax.inject.Inject;

/* compiled from: savedComposerTargetData */
public class FeedbackHeaderAdapter extends FbBaseAdapter implements Bindable<GraphQLStory> {
    private final PrivacyEducationBannerController f4531a;
    private GraphQLStory f4532b;
    private boolean f4533c;

    /* compiled from: savedComposerTargetData */
    enum RowaType {
        PRIVACY_EDUCATION,
        UNKNOWN
    }

    public static FeedbackHeaderAdapter m5086a(InjectorLike injectorLike) {
        return new FeedbackHeaderAdapter(PrivacyEducationBannerController.a(injectorLike));
    }

    @Inject
    public FeedbackHeaderAdapter(PrivacyEducationBannerController privacyEducationBannerController) {
        this.f4531a = privacyEducationBannerController;
    }

    public final View m5087a(int i, ViewGroup viewGroup) {
        switch (RowaType.values()[i]) {
            case PRIVACY_EDUCATION:
                if (!this.f4533c) {
                    return null;
                }
                View privacyEducationBannerView = new PrivacyEducationBannerView(viewGroup.getContext());
                LayoutParams layoutParams = (LayoutParams) privacyEducationBannerView.f.getLayoutParams();
                layoutParams.addRule(11, 0);
                layoutParams.addRule(21, 0);
                layoutParams.addRule(14);
                privacyEducationBannerView.f.setLayoutParams(layoutParams);
                return privacyEducationBannerView;
            default:
                return null;
        }
    }

    public final void m5088a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        switch (RowaType.values()[i2]) {
            case PRIVACY_EDUCATION:
                if (GraphQLStoryHelper.c(this.f4532b) != null) {
                    ((PrivacyEducationBannerView) view).a(GraphQLStoryHelper.c(this.f4532b).k(), this.f4532b.c());
                    return;
                }
                return;
            default:
                return;
        }
    }

    public int getItemViewType(int i) {
        if (this.f4533c) {
            return RowaType.PRIVACY_EDUCATION.ordinal();
        }
        return RowaType.UNKNOWN.ordinal();
    }

    public int getViewTypeCount() {
        return RowaType.values().length;
    }

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getCount() {
        return this.f4533c ? 1 : 0;
    }

    public final void m5089a(GraphQLStory graphQLStory) {
        this.f4532b = graphQLStory;
        if (graphQLStory == null || graphQLStory.ay() == null || !graphQLStory.ay().q() || !PrivacyEducationBannerController.a(graphQLStory)) {
            this.f4533c = false;
        } else {
            this.f4533c = true;
        }
    }
}

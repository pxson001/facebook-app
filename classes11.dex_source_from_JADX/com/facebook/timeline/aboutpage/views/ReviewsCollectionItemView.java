package com.facebook.timeline.aboutpage.views;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RatingBar;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.StringUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.graphql.enums.GraphQLTimelineAppSectionType;
import com.facebook.inject.FbInjector;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.profile.api.ProfileViewerContext;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLModels.AppCollectionItemModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLModels.CollectionsAppSectionRequestableFieldModel;
import com.facebook.widget.CustomRelativeLayout;
import javax.inject.Inject;

/* compiled from: Ljava/lang/StringBuilder; */
public class ReviewsCollectionItemView extends CustomRelativeLayout implements ICollectionItemView {
    private static final CallerContext f13924b = CallerContext.a(ReviewsCollectionItemView.class, "collections_collection");
    @Inject
    public IFeedIntentBuilder f13925a;
    private FbDraweeView f13926c;
    private TextView f13927d;
    private RatingBar f13928e;
    private TextView f13929f;

    private static <T extends View> void m15046a(Class<T> cls, T t) {
        m15047a((Object) t, t.getContext());
    }

    private static void m15047a(Object obj, Context context) {
        ((ReviewsCollectionItemView) obj).f13925a = (IFeedIntentBuilder) DefaultFeedIntentBuilder.a(FbInjector.get(context));
    }

    public ReviewsCollectionItemView(Context context) {
        this(context, null);
        m15044a();
    }

    public ReviewsCollectionItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m15044a();
    }

    private void m15044a() {
        m15046a(ReviewsCollectionItemView.class, (View) this);
        setContentView(2130903599);
        this.f13927d = (TextView) a(2131560391);
        this.f13928e = (RatingBar) a(2131560392);
        this.f13929f = (TextView) a(2131560393);
        this.f13926c = (FbDraweeView) a(2131560390);
    }

    public final void mo424a(final AppCollectionItemModel appCollectionItemModel) {
        if (appCollectionItemModel.nI_() == null || StringUtil.a(appCollectionItemModel.nI_().b())) {
            this.f13926c.a(null, f13924b);
        } else {
            this.f13926c.a(Uri.parse(appCollectionItemModel.nI_().b()), f13924b);
        }
        if (appCollectionItemModel.m14299l() == null || StringUtil.a(appCollectionItemModel.m14299l().m14277a())) {
            this.f13927d.setVisibility(8);
        } else {
            this.f13927d.setVisibility(0);
            this.f13927d.setText(appCollectionItemModel.m14299l().m14277a());
        }
        if (appCollectionItemModel.nG_() == null) {
            this.f13928e.setVisibility(8);
        } else {
            this.f13928e.setVisibility(0);
            this.f13928e.setRating((float) appCollectionItemModel.nG_().m14230a());
        }
        if (appCollectionItemModel.m14297j() == null || StringUtil.a(appCollectionItemModel.m14297j().a())) {
            this.f13929f.setVisibility(8);
        } else {
            this.f13929f.setText(appCollectionItemModel.m14297j().a());
            this.f13929f.setVisibility(0);
        }
        if (StringUtil.a(appCollectionItemModel.m14300m())) {
            setOnClickListener(null);
        } else {
            setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ ReviewsCollectionItemView f13923b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -1234779586);
                    this.f13923b.f13925a.a(this.f13923b.getContext(), appCollectionItemModel.m14300m());
                    Logger.a(2, EntryType.UI_INPUT_END, 314713946, a);
                }
            });
        }
    }

    public final void mo425a(CollectionsAppSectionRequestableFieldModel collectionsAppSectionRequestableFieldModel, ProfileViewerContext profileViewerContext, GraphQLTimelineAppSectionType graphQLTimelineAppSectionType) {
    }

    private void m15045a(IFeedIntentBuilder iFeedIntentBuilder) {
        this.f13925a = iFeedIntentBuilder;
    }
}

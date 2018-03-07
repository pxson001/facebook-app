package com.facebook.timeline.aboutpage.views;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.TextView;
import com.facebook.common.android.WindowManagerMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.callercontexttagger.AnalyticsTagger;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.graphql.enums.GraphQLTimelineAppSectionType;
import com.facebook.graphql.linkutil.GraphQLLinkExtractor;
import com.facebook.inject.FbInjector;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.profile.api.ProfileViewerContext;
import com.facebook.timeline.aboutpage.StandardCollectionSizes;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLModels.AppCollectionItemModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLModels.CollectionsAppSectionRequestableFieldModel;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomLinearLayout;
import javax.inject.Inject;

/* compiled from: Ljava/util/EnumMap */
public class GridCollectionItemView extends CustomLinearLayout implements ICollectionItemView {
    private static final CallerContext f13824f = CallerContext.a(GridCollectionItemView.class);
    @Inject
    IFeedIntentBuilder f13825a;
    @Inject
    WindowManager f13826b;
    @Inject
    StandardCollectionSizes f13827c;
    @Inject
    GraphQLLinkExtractor f13828d;
    @Inject
    AnalyticsTagger f13829e;
    private TextView f13830g;
    private FbDraweeView f13831h;
    private Display f13832i;
    private int f13833j;
    private final OnClickListener f13834k = new C16111(this);

    /* compiled from: Ljava/util/EnumMap */
    class C16111 implements OnClickListener {
        final /* synthetic */ GridCollectionItemView f13823a;

        C16111(GridCollectionItemView gridCollectionItemView) {
            this.f13823a = gridCollectionItemView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1837151982);
            String str = (String) view.getTag();
            if (str == null) {
                Logger.a(2, EntryType.UI_INPUT_END, -1318125468, a);
                return;
            }
            this.f13823a.f13825a.a(this.f13823a.getContext(), str);
            LogUtils.a(-1918691977, a);
        }
    }

    private static <T extends View> void m14985a(Class<T> cls, T t) {
        m14986a((Object) t, t.getContext());
    }

    private static void m14986a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((GridCollectionItemView) obj).m14984a((IFeedIntentBuilder) DefaultFeedIntentBuilder.a(fbInjector), WindowManagerMethodAutoProvider.b(fbInjector), StandardCollectionSizes.m13827a(fbInjector), GraphQLLinkExtractor.a(fbInjector), AnalyticsTagger.a(fbInjector));
    }

    public GridCollectionItemView(Context context) {
        super(context);
        m14983a();
    }

    public GridCollectionItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m14983a();
    }

    private void m14983a() {
        m14985a(GridCollectionItemView.class, (View) this);
        this.f13832i = this.f13826b.getDefaultDisplay();
        this.f13833j = this.f13827c.f13056a;
    }

    protected void onFinishInflate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1028830053);
        super.onFinishInflate();
        this.f13830g = (TextView) a(2131560350);
        this.f13831h = (FbDraweeView) a(2131560349);
        this.f13829e.a(this.f13831h, "collections_collection", getClass());
        m14987b();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1780891023, a);
    }

    public final void mo424a(AppCollectionItemModel appCollectionItemModel) {
        Uri uri = null;
        if (appCollectionItemModel.m14298k() != null) {
            uri = Uri.parse(appCollectionItemModel.m14298k().b());
            this.f13831h.setTag(CollectionsViewFactory.m14941a(appCollectionItemModel, this.f13828d));
            this.f13831h.setOnClickListener(this.f13834k);
        }
        this.f13831h.a(uri, f13824f);
        if (appCollectionItemModel.m14299l() == null || appCollectionItemModel.m14299l().m14277a() == null) {
            this.f13830g.setText("");
            this.f13830g.setVisibility(8);
            return;
        }
        this.f13830g.setText(appCollectionItemModel.m14299l().m14277a());
        this.f13830g.setVisibility(0);
    }

    public final void mo425a(CollectionsAppSectionRequestableFieldModel collectionsAppSectionRequestableFieldModel, ProfileViewerContext profileViewerContext, GraphQLTimelineAppSectionType graphQLTimelineAppSectionType) {
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m14987b();
    }

    private void m14987b() {
        LayoutParams layoutParams = this.f13831h.getLayoutParams();
        Resources resources = getResources();
        int dimensionPixelSize = (resources.getDimensionPixelSize(2131434522) * 2) * this.f13833j;
        layoutParams.width = ((this.f13832i.getWidth() - dimensionPixelSize) - (resources.getDimensionPixelSize(2131434517) * 2)) / this.f13833j;
        layoutParams.height = layoutParams.width;
        this.f13831h.setLayoutParams(layoutParams);
    }

    private void m14984a(IFeedIntentBuilder iFeedIntentBuilder, WindowManager windowManager, StandardCollectionSizes standardCollectionSizes, GraphQLLinkExtractor graphQLLinkExtractor, AnalyticsTagger analyticsTagger) {
        this.f13825a = iFeedIntentBuilder;
        this.f13826b = windowManager;
        this.f13827c = standardCollectionSizes;
        this.f13828d = graphQLLinkExtractor;
        this.f13829e = analyticsTagger;
    }
}

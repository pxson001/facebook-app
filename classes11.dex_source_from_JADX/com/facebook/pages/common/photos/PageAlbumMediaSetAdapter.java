package com.facebook.pages.common.photos;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.model.GraphQLAlbum;
import com.facebook.inject.Lazy;
import com.facebook.pages.common.photos.PagesAlbumPhotosGridFragment.C02312;
import com.facebook.photos.pandora.common.cache.PandoraStoryMemoryCache;
import com.facebook.photos.pandora.common.futures.PandoraFuturesGenerator;
import com.facebook.photos.pandora.common.ui.renderer.PandoraRendererController;
import com.facebook.photos.pandora.common.ui.renderer.configs.PandoraRendererGridConfiguration;
import com.facebook.photos.pandora.common.ui.views.PandoraInlineVideoEnvironmentProvider;
import com.facebook.photos.pandora.logging.PandoraSequenceLogger;
import com.facebook.photos.pandora.ui.PandoraAlbumMediaSetAdapter;
import com.facebook.photos.pandora.ui.views.PandoraAlbumPermalinkDetailsView;
import com.facebook.photos.photoset.ui.permalink.futures.AlbumPermalinkFuturesGenerator;
import com.facebook.ui.futures.TasksManager;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: sgny_join */
public class PageAlbumMediaSetAdapter extends PandoraAlbumMediaSetAdapter {
    public static final String f1676t = PageAlbumMediaSetAdapter.class.toString();
    @Nullable
    public C02312 f1677u;
    private Lazy<FbErrorReporter> f1678v;

    /* compiled from: sgny_join */
    public class InvalidDetailViewException extends Exception {
        public InvalidDetailViewException(String str) {
            super(str);
        }
    }

    @Inject
    public PageAlbumMediaSetAdapter(Lazy<PandoraStoryMemoryCache> lazy, Lazy<PandoraFuturesGenerator> lazy2, Lazy<TasksManager> lazy3, Lazy<PandoraRendererController> lazy4, Lazy<PandoraRendererGridConfiguration> lazy5, Lazy<AlbumPermalinkFuturesGenerator> lazy6, Lazy<FbErrorReporter> lazy7, ViewerContext viewerContext, PandoraSequenceLogger pandoraSequenceLogger, PandoraInlineVideoEnvironmentProvider pandoraInlineVideoEnvironmentProvider) {
        super(lazy, lazy2, lazy3, lazy4, lazy5, lazy6, lazy7, viewerContext, pandoraSequenceLogger, pandoraInlineVideoEnvironmentProvider);
        this.f1678v = lazy7;
    }

    protected final View m2491a(View view, View view2) {
        if (view == null) {
            return m2489b(view, view2);
        }
        m2490c(view, view2);
        return view;
    }

    private LinearLayout m2489b(View view, View view2) {
        Context context = view2.getContext();
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        PageAlbumDetailView pageAlbumDetailView = new PageAlbumDetailView(context);
        linearLayout.addView(pageAlbumDetailView);
        try {
            linearLayout.addView(m2487a(super.a(view, view2)));
        } catch (InvalidDetailViewException e) {
            ((AbstractFbErrorReporter) this.f1678v.get()).b(f1676t, e.getMessage());
        }
        m2488a(n(), pageAlbumDetailView);
        return linearLayout;
    }

    private void m2488a(GraphQLAlbum graphQLAlbum, PageAlbumDetailView pageAlbumDetailView) {
        Object obj;
        if (graphQLAlbum == null || graphQLAlbum.G() == null) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            String str;
            int i = 0;
            int i2 = (graphQLAlbum.E() == null || StringUtil.a(graphQLAlbum.E().a())) ? 1 : 0;
            CharSequence a = i2 != 0 ? "" : graphQLAlbum.E().a();
            if (graphQLAlbum.C() != null) {
                i = graphQLAlbum.C().a();
            }
            long z = graphQLAlbum.z();
            pageAlbumDetailView.f1675e.setText(a);
            StringBuilder append = new StringBuilder().append(PageAlbumDetailView.m2484a(i, pageAlbumDetailView.getContext())).append(" · ");
            DefaultTimeFormatUtil defaultTimeFormatUtil = pageAlbumDetailView.f1672b;
            if (z == 0) {
                str = "";
            } else {
                str = defaultTimeFormatUtil.a(TimeFormatStyle.STREAM_RELATIVE_STYLE, 1000 * z);
            }
            pageAlbumDetailView.f1674d.setText(append.append(str).append(" · ").toString());
            View view = pageAlbumDetailView.f1673c;
            if (this.f1677u == null || !this.f1677u.f1690a) {
                view.setClickable(false);
                view.setVisibility(8);
            } else {
                view.setClickable(true);
                if (view.getVisibility() != 0) {
                    view.setVisibility(0);
                }
                view.setOnClickListener(this.f1677u);
            }
            pageAlbumDetailView.setVisibility(0);
            return;
        }
        pageAlbumDetailView.setVisibility(8);
    }

    private static PandoraAlbumPermalinkDetailsView m2487a(View view) {
        if (view == null || !(view instanceof PandoraAlbumPermalinkDetailsView)) {
            throw new InvalidDetailViewException("Original detail view is not PandoraAlbumPermalinkDetailsView");
        }
        PandoraAlbumPermalinkDetailsView pandoraAlbumPermalinkDetailsView = (PandoraAlbumPermalinkDetailsView) view;
        View findViewById = pandoraAlbumPermalinkDetailsView.findViewById(2131559541);
        if (findViewById == null) {
            throw new InvalidDetailViewException("PandoraAlbumPermalinkDetailsView layout mismatch");
        }
        View findViewById2 = pandoraAlbumPermalinkDetailsView.findViewById(2131565759);
        if (findViewById2 == null || findViewById2.getParent() == null) {
            throw new InvalidDetailViewException("PandoraAlbumPermalinkDetailsView layout mismatch");
        }
        findViewById2 = (View) findViewById2.getParent();
        findViewById.setVisibility(8);
        findViewById2.setVisibility(8);
        return pandoraAlbumPermalinkDetailsView;
    }

    private void m2490c(View view, View view2) {
        LinearLayout linearLayout = (LinearLayout) view;
        PageAlbumDetailView pageAlbumDetailView = (PageAlbumDetailView) linearLayout.getChildAt(0);
        if (linearLayout.getChildCount() == 2) {
            super.a((PandoraAlbumPermalinkDetailsView) linearLayout.getChildAt(1), view2);
        } else {
            ((AbstractFbErrorReporter) this.f1678v.get()).b(f1676t, "PandoraAlbumPermalinkDetailsView is not integrated");
        }
        m2488a(this.x, pageAlbumDetailView);
    }
}

package com.facebook.pages.browser.data.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.numbers.NumberTruncationUtil;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.contentview.ContentView.ThumbnailSize;
import com.facebook.fbui.widget.contentview.ContentViewWithButton;
import com.facebook.fbui.widget.header.SectionHeaderView;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.browser.analytics.PagesBrowserAnalytics;
import com.facebook.pages.browser.data.graphql.RecommendedPagesModels.AllSectionsRecommendedPagesModel.PageBrowserCategoriesModel.NodesModel;
import com.facebook.pages.browser.data.graphql.RecommendedPagesModels.RecommendedPageFieldsModel;
import com.facebook.pages.browser.data.graphql.RecommendedPagesModels.RecommendedPageFieldsModel.InvitersForViewerToLikeModel;
import com.facebook.pages.browser.event.PagesBrowserEventBus;
import com.facebook.pages.browser.event.PagesBrowserEvents.PageLikedEvent;
import com.facebook.pages.browser.ui.list.PagesBrowserLoadingRowView;
import com.facebook.pages.browser.ui.list.PagesBrowserSeeMoreRowView;
import com.facebook.pages.browser.util.PagesBrowserLikeHolder;
import com.facebook.timeline.intent.ModelBundle;
import com.facebook.widget.listview.SectionedListAdapter;
import com.google.common.base.Strings;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: succes_data_load */
public class PagesBrowserSectionAdapter extends SectionedListAdapter {
    private static final Object f1238c = new Object();
    private static final Object f1239d = new Object();
    public List<Section> f1240e;
    public final Context f1241f;
    public NumberTruncationUtil f1242g;
    private GlyphColorizer f1243h;
    public FbUriIntentHandler f1244i;
    public PagesBrowserAnalytics f1245j;
    private PagesBrowserEventBus f1246k;
    private PagesBrowserLikeHolder f1247l;
    private boolean f1248m = true;
    private Drawable f1249n;
    private Drawable f1250o;

    /* compiled from: succes_data_load */
    public class Section {
        @Nullable
        protected final String f1233a;
        @Nullable
        protected final String f1234b;
        public List<RecommendedPageFieldsModel> f1235c = new ArrayList();
        public boolean f1236d;
        public boolean f1237e;

        public Section(@Nullable String str, @Nullable String str2) {
            this.f1233a = str;
            this.f1234b = str2;
        }
    }

    /* compiled from: succes_data_load */
    enum ViewTypes {
        HEADER,
        PAGE,
        LOADING,
        MORE
    }

    public static PagesBrowserSectionAdapter m1800b(InjectorLike injectorLike) {
        return new PagesBrowserSectionAdapter((Context) injectorLike.getInstance(Context.class), NumberTruncationUtil.a(injectorLike), GlyphColorizer.a(injectorLike), PagesBrowserAnalytics.m1788a(injectorLike), FbUriIntentHandler.a(injectorLike), PagesBrowserEventBus.m1936a(injectorLike), PagesBrowserLikeHolder.m1988a(injectorLike));
    }

    protected final /* synthetic */ Object m1808b(int i) {
        return m1802f(i);
    }

    @Inject
    public PagesBrowserSectionAdapter(Context context, NumberTruncationUtil numberTruncationUtil, GlyphColorizer glyphColorizer, PagesBrowserAnalytics pagesBrowserAnalytics, FbUriIntentHandler fbUriIntentHandler, PagesBrowserEventBus pagesBrowserEventBus, PagesBrowserLikeHolder pagesBrowserLikeHolder) {
        this.f1241f = context;
        this.f1240e = new ArrayList();
        this.f1242g = numberTruncationUtil;
        this.f1243h = glyphColorizer;
        this.f1245j = pagesBrowserAnalytics;
        this.f1244i = fbUriIntentHandler;
        this.f1246k = pagesBrowserEventBus;
        this.f1247l = pagesBrowserLikeHolder;
        this.f1250o = this.f1243h.a(2130839953, -10972929);
        this.f1249n = this.f1243h.a(2130839953, -8421505);
    }

    public final void m1807a(NodesModel nodesModel, boolean z, boolean z2) {
        Section section = new Section(nodesModel.m1832j(), nodesModel.m1831a());
        section.f1235c = nodesModel.m1833k().m1828a();
        section.f1236d = z;
        section.f1237e = z2;
        this.f1240e.add(section);
    }

    protected final int m1810c() {
        return this.f1240e.size();
    }

    protected final View m1805a(int i, View view, ViewGroup viewGroup) {
        if (!(view instanceof SectionHeaderView) || view == null) {
            view = new SectionHeaderView(this.f1241f);
        } else {
            SectionHeaderView sectionHeaderView = (SectionHeaderView) view;
        }
        view.setTitleText(m1802f(i).f1233a);
        return view;
    }

    protected final int m1803a(int i) {
        return ViewTypes.HEADER.ordinal();
    }

    private Section m1802f(int i) {
        return (Section) this.f1240e.get(i);
    }

    protected final int m1811c(int i) {
        if (m1802f(i).f1236d) {
            return 3;
        }
        if (m1802f(i).f1237e) {
            return m1802f(i).f1235c.size() + 1;
        }
        return m1802f(i).f1235c.size();
    }

    protected final Object m1806a(int i, int i2) {
        if (i2 == m1802f(i).f1235c.size() || (m1802f(i).f1236d && i2 == 2)) {
            return f1239d;
        }
        return m1802f(i).f1235c.get(i2);
    }

    protected final View m1804a(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        Object a = m1806a(i, i2);
        if (a == f1238c) {
            return m1796a(view);
        }
        if (a == f1239d) {
            return m1797a(view, m1802f(i).f1234b);
        }
        return m1795a(view, (RecommendedPageFieldsModel) m1806a(i, i2));
    }

    private View m1795a(View view, final RecommendedPageFieldsModel recommendedPageFieldsModel) {
        ContentViewWithButton contentViewWithButton;
        int i;
        if (view == null || !(view instanceof ContentViewWithButton)) {
            contentViewWithButton = new ContentViewWithButton(this.f1241f);
        } else {
            contentViewWithButton = (ContentViewWithButton) view;
        }
        contentViewWithButton.setMaxLinesFromThumbnailSize(false);
        contentViewWithButton.setThumbnailSize(ThumbnailSize.LARGE);
        contentViewWithButton.setActionButtonBackground(null);
        m1798a(contentViewWithButton, this.f1247l.m1990c(recommendedPageFieldsModel.m1873c()));
        contentViewWithButton.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PagesBrowserSectionAdapter f1227b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1287663040);
                PagesBrowserSectionAdapter pagesBrowserSectionAdapter = this.f1227b;
                RecommendedPageFieldsModel recommendedPageFieldsModel = recommendedPageFieldsModel;
                long parseLong = Long.parseLong(recommendedPageFieldsModel.m1873c());
                pagesBrowserSectionAdapter.f1245j.f1219a.c(PagesBrowserAnalytics.m1790d("tapped_page_on_landing").a("page_id", parseLong));
                String a2 = StringFormatUtil.a(FBLinks.af, new Object[]{Long.valueOf(parseLong)});
                Bundle bundle = new Bundle();
                ModelBundle.b(bundle, String.valueOf(parseLong), recommendedPageFieldsModel.m1876l(), recommendedPageFieldsModel.m1878n() != null ? recommendedPageFieldsModel.m1878n().b() : null);
                pagesBrowserSectionAdapter.f1244i.a(pagesBrowserSectionAdapter.f1241f, a2, bundle);
                Logger.a(2, EntryType.UI_INPUT_END, -183196464, a);
            }
        });
        contentViewWithButton.setActionButtonOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PagesBrowserSectionAdapter f1230c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 971226369);
                PagesBrowserSectionAdapter.m1799a(this.f1230c, contentViewWithButton, recommendedPageFieldsModel);
                Logger.a(2, EntryType.UI_INPUT_END, 2017180248, a);
            }
        });
        CharSequence l = recommendedPageFieldsModel.m1876l();
        if (!Strings.isNullOrEmpty(l)) {
            contentViewWithButton.setTitleText(l);
        }
        String str = (String) recommendedPageFieldsModel.m1874j().get(0);
        if (!StringUtil.a(str)) {
            contentViewWithButton.setSubtitleText(str);
        }
        if (recommendedPageFieldsModel.m1875k() == null || recommendedPageFieldsModel.m1875k().m1855a().isEmpty() || StringUtil.a(((InvitersForViewerToLikeModel.NodesModel) recommendedPageFieldsModel.m1875k().m1855a().get(0)).m1849a())) {
            i = 0;
        } else {
            i = 1;
        }
        if (i != 0) {
            str = this.f1241f.getResources().getString(2131242281, new Object[]{((InvitersForViewerToLikeModel.NodesModel) recommendedPageFieldsModel.m1875k().m1855a().get(0)).m1849a()});
            if (!StringUtil.a(str)) {
                contentViewWithButton.setMetaText(str);
            }
        } else {
            l = m1801c(recommendedPageFieldsModel);
            if (!StringUtil.a(l)) {
                contentViewWithButton.setMetaText(l);
            }
        }
        DefaultImageFieldsModel n = recommendedPageFieldsModel.m1878n();
        if (recommendedPageFieldsModel != null) {
            contentViewWithButton.setThumbnailUri(Uri.parse(n.b()));
        }
        return contentViewWithButton;
    }

    protected final boolean m1809b(int i, int i2) {
        return true;
    }

    protected final int m1812c(int i, int i2) {
        if (m1806a(i, i2) == f1238c) {
            return ViewTypes.LOADING.ordinal();
        }
        return ViewTypes.PAGE.ordinal();
    }

    private String m1801c(RecommendedPageFieldsModel recommendedPageFieldsModel) {
        if (recommendedPageFieldsModel.m1877m().m1858a() == 0) {
            return null;
        }
        String a;
        Resources resources = this.f1241f.getResources();
        int a2 = recommendedPageFieldsModel.m1877m().m1858a();
        Object[] objArr = new Object[1];
        int a3 = recommendedPageFieldsModel.m1877m().m1858a();
        if (a3 < 1000) {
            a = StringLocaleUtil.a("%,d", new Object[]{Integer.valueOf(a3)});
        } else {
            a = this.f1242g.a(a3);
        }
        objArr[0] = a;
        return resources.getQuantityString(2131689818, a2, objArr);
    }

    private PagesBrowserLoadingRowView m1796a(View view) {
        if (view != null && (view instanceof PagesBrowserLoadingRowView)) {
            return (PagesBrowserLoadingRowView) view;
        }
        view = new PagesBrowserLoadingRowView(this.f1241f);
        view.setBackgroundResource(2131361920);
        return view;
    }

    private PagesBrowserSeeMoreRowView m1797a(View view, final String str) {
        if (view != null && (view instanceof PagesBrowserSeeMoreRowView)) {
            return (PagesBrowserSeeMoreRowView) view;
        }
        view = new PagesBrowserSeeMoreRowView(this.f1241f);
        view.setBackgroundResource(2131361920);
        view.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PagesBrowserSectionAdapter f1232b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1392128733);
                PagesBrowserSectionAdapter pagesBrowserSectionAdapter = this.f1232b;
                pagesBrowserSectionAdapter.f1245j.f1219a.c(PagesBrowserAnalytics.m1790d("tapped_see_more").b("page_id", str));
                pagesBrowserSectionAdapter.f1244i.a(pagesBrowserSectionAdapter.f1241f, StringFormatUtil.a(FBLinks.aK, new Object[]{r2}), new Bundle());
                Logger.a(2, EntryType.UI_INPUT_END, -2002055041, a);
            }
        });
        return view;
    }

    public static void m1799a(PagesBrowserSectionAdapter pagesBrowserSectionAdapter, ContentViewWithButton contentViewWithButton, RecommendedPageFieldsModel recommendedPageFieldsModel) {
        pagesBrowserSectionAdapter.m1798a(contentViewWithButton, pagesBrowserSectionAdapter.f1247l.m1990c(recommendedPageFieldsModel.m1873c()));
        pagesBrowserSectionAdapter.f1246k.a(new PageLikedEvent(recommendedPageFieldsModel.m1873c(), !pagesBrowserSectionAdapter.f1247l.m1990c(recommendedPageFieldsModel.m1873c())));
    }

    private void m1798a(ContentViewWithButton contentViewWithButton, boolean z) {
        if (z) {
            contentViewWithButton.setActionButtonDrawable(this.f1250o);
        } else {
            contentViewWithButton.setActionButtonDrawable(this.f1249n);
        }
    }
}

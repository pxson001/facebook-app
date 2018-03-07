package com.facebook.pages.browser.ui.list;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.numbers.NumberTruncationUtil;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.browser.analytics.PagesBrowserAnalytics;
import com.facebook.pages.browser.data.graphql.RecommendedPagesModels.RecommendedPageFieldsModel;
import com.facebook.pages.browser.data.graphql.RecommendedPagesModels.RecommendedPageFieldsModel.InvitersForViewerToLikeModel.NodesModel;
import com.facebook.pages.browser.event.PagesBrowserEventBus;
import com.facebook.pages.browser.event.PagesBrowserEvents.PageLikedEvent;
import com.facebook.pages.browser.util.PagesBrowserLikeHolder;
import com.facebook.timeline.intent.ModelBundle;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.RecyclableView;
import com.google.common.base.Strings;
import javax.inject.Inject;

/* compiled from: story_gallery_survey_actions_params_key */
public class PagesBrowserListRowView extends CustomRelativeLayout implements RecyclableView {
    public static final CallerContext f1325g = CallerContext.a(PagesBrowserListRowView.class, "pages_browser");
    public final FbDraweeView f1326a;
    public final TextView f1327b;
    public final TextView f1328c;
    public final TextView f1329d;
    public final ImageView f1330e;
    public final View f1331f;
    private Resources f1332h;
    public FbUriIntentHandler f1333i;
    public PagesBrowserAnalytics f1334j;
    public PagesBrowserEventBus f1335k;
    public PagesBrowserLikeHolder f1336l;
    public NumberTruncationUtil f1337m;
    public RecommendedPageFieldsModel f1338n;
    public String f1339o;
    public int f1340p;
    public boolean f1341q;

    /* compiled from: story_gallery_survey_actions_params_key */
    public class ItemClickListener implements OnClickListener {
        final /* synthetic */ PagesBrowserListRowView f1324a;

        public ItemClickListener(PagesBrowserListRowView pagesBrowserListRowView) {
            this.f1324a = pagesBrowserListRowView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1749472064);
            PagesBrowserListRowView pagesBrowserListRowView = this.f1324a;
            long parseLong = Long.parseLong(pagesBrowserListRowView.f1338n.m1873c());
            pagesBrowserListRowView.f1334j.f1219a.c(PagesBrowserAnalytics.m1790d("tapped_page_in_category").a("page_id", parseLong).b("page_id", pagesBrowserListRowView.f1339o));
            String a2 = StringFormatUtil.a(FBLinks.af, new Object[]{Long.valueOf(parseLong)});
            Bundle bundle = new Bundle();
            ModelBundle.b(bundle, String.valueOf(parseLong), pagesBrowserListRowView.f1338n.m1876l(), pagesBrowserListRowView.f1338n.m1878n() != null ? pagesBrowserListRowView.f1338n.m1878n().b() : null);
            pagesBrowserListRowView.f1333i.a(pagesBrowserListRowView.getContext(), a2, bundle);
            Logger.a(2, EntryType.UI_INPUT_END, -1836999171, a);
        }
    }

    public static void m1980a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((PagesBrowserListRowView) obj).m1979a(FbUriIntentHandler.a(injectorLike), PagesBrowserAnalytics.m1788a(injectorLike), PagesBrowserEventBus.m1936a(injectorLike), PagesBrowserLikeHolder.m1988a(injectorLike), NumberTruncationUtil.a(injectorLike));
    }

    public PagesBrowserListRowView(Context context) {
        this(context, null);
    }

    private PagesBrowserListRowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Class cls = PagesBrowserListRowView.class;
        m1980a((Object) this, getContext());
        this.f1332h = getResources();
        setContentView(2130906100);
        this.f1326a = (FbDraweeView) a(2131565679);
        this.f1327b = (TextView) a(2131565678);
        this.f1328c = (TextView) a(2131565682);
        this.f1329d = (TextView) a(2131565683);
        this.f1330e = (ImageView) a(2131565684);
        this.f1331f = a(2131565681);
        this.f1327b.setMovementMethod(LinkMovementMethod.getInstance());
        this.f1328c.setMovementMethod(LinkMovementMethod.getInstance());
        this.f1329d.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Inject
    private void m1979a(FbUriIntentHandler fbUriIntentHandler, PagesBrowserAnalytics pagesBrowserAnalytics, PagesBrowserEventBus pagesBrowserEventBus, PagesBrowserLikeHolder pagesBrowserLikeHolder, NumberTruncationUtil numberTruncationUtil) {
        this.f1333i = fbUriIntentHandler;
        this.f1334j = pagesBrowserAnalytics;
        this.f1335k = pagesBrowserEventBus;
        this.f1336l = pagesBrowserLikeHolder;
        this.f1337m = numberTruncationUtil;
    }

    public final void m1984a(final RecommendedPageFieldsModel recommendedPageFieldsModel, String str) {
        this.f1338n = recommendedPageFieldsModel;
        this.f1339o = str;
        this.f1340p = this.f1332h.getDimensionPixelOffset(2131434412);
        setVisibility(0);
        DefaultImageFieldsModel n = recommendedPageFieldsModel.m1878n();
        if (recommendedPageFieldsModel != null) {
            this.f1326a.setLayoutParams(new LayoutParams(this.f1340p, this.f1340p));
            this.f1326a.setVisibility(0);
            this.f1326a.a(Uri.parse(n.b()), f1325g);
            this.f1326a.setContentDescription(m1982e(recommendedPageFieldsModel));
            this.f1326a.setOnClickListener(new ItemClickListener(this));
        } else {
            this.f1326a.setVisibility(8);
        }
        m1981b(recommendedPageFieldsModel);
        m1985a(this.f1336l.m1990c(recommendedPageFieldsModel.m1873c()));
        this.f1331f.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PagesBrowserListRowView f1323b;

            public void onClick(View view) {
                boolean z = true;
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1128448214);
                this.f1323b.m1985a(!this.f1323b.f1336l.m1990c(recommendedPageFieldsModel.m1873c()));
                PagesBrowserEventBus pagesBrowserEventBus = this.f1323b.f1335k;
                String c = recommendedPageFieldsModel.m1873c();
                if (this.f1323b.f1336l.m1990c(recommendedPageFieldsModel.m1873c())) {
                    z = false;
                }
                pagesBrowserEventBus.a(new PageLikedEvent(c, z));
                LogUtils.a(-2062368743, a);
            }
        });
    }

    private void m1981b(RecommendedPageFieldsModel recommendedPageFieldsModel) {
        CharSequence e = m1982e(recommendedPageFieldsModel);
        if (Strings.isNullOrEmpty(e)) {
            this.f1327b.setVisibility(8);
        } else {
            this.f1327b.setVisibility(0);
            this.f1327b.setText(e);
            this.f1327b.setOnClickListener(new ItemClickListener(this));
        }
        String str = (String) recommendedPageFieldsModel.m1874j().get(0);
        if (StringUtil.a(str)) {
            this.f1328c.setVisibility(8);
        } else {
            this.f1328c.setVisibility(0);
            this.f1328c.setText(str);
        }
        e = m1983g(recommendedPageFieldsModel);
        if (StringUtil.a(e)) {
            this.f1329d.setVisibility(8);
            return;
        }
        this.f1329d.setVisibility(0);
        this.f1329d.setText(e);
    }

    public static String m1982e(RecommendedPageFieldsModel recommendedPageFieldsModel) {
        return recommendedPageFieldsModel.m1876l();
    }

    private String m1983g(RecommendedPageFieldsModel recommendedPageFieldsModel) {
        if (recommendedPageFieldsModel.m1875k() != null && !recommendedPageFieldsModel.m1875k().m1855a().isEmpty() && !StringUtil.a(((NodesModel) recommendedPageFieldsModel.m1875k().m1855a().get(0)).m1849a())) {
            return this.f1332h.getString(2131242281, new Object[]{((NodesModel) recommendedPageFieldsModel.m1875k().m1855a().get(0)).m1849a()});
        } else if (recommendedPageFieldsModel.m1877m().m1858a() == 0) {
            return null;
        } else {
            String a;
            Resources resources = this.f1332h;
            int a2 = recommendedPageFieldsModel.m1877m().m1858a();
            Object[] objArr = new Object[1];
            int a3 = recommendedPageFieldsModel.m1877m().m1858a();
            if (a3 < 1000) {
                a = StringLocaleUtil.a("%,d", new Object[]{Integer.valueOf(a3)});
            } else {
                a = this.f1337m.a(a3);
            }
            objArr[0] = a;
            return resources.getQuantityString(2131689818, a2, objArr);
        }
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 881324662);
        super.onAttachedToWindow();
        this.f1341q = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1413549806, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1082764725);
        super.onDetachedFromWindow();
        this.f1341q = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -242327909, a);
    }

    public final boolean m1986a() {
        return this.f1341q;
    }

    public final void m1985a(boolean z) {
        this.f1330e.setSelected(z);
        if (z) {
            m1978a(this.f1330e, 2131233427);
        } else {
            m1978a(this.f1330e, 2131233426);
        }
    }

    private void m1978a(View view, int i) {
        view.setContentDescription(getResources().getString(i));
    }
}

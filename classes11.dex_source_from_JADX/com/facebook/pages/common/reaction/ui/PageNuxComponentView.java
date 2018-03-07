package com.facebook.pages.common.reaction.ui;

import android.animation.LayoutTransition;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesFields;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.reaction.protocol.methods.PageNuxExposuresMethod;
import com.facebook.pages.common.reaction.protocol.methods.model.PageNuxExposuresCallArguments;
import com.facebook.pages.common.reaction.state.PageNuxViewStateStore;
import com.facebook.pages.common.reaction.state.PageNuxViewStateStore.NuxStateKey;
import com.facebook.pages.common.reaction.state.PageNuxViewStateStore.NuxViewState;
import com.facebook.resources.ui.FbButton;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;
import com.facebook.widget.text.CustomFontHelper;
import com.facebook.widget.text.CustomFontHelper.FontFamily;
import com.facebook.widget.text.CustomFontHelper.FontWeight;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: search_identifier */
public class PageNuxComponentView extends CustomLinearLayout {
    private static final String f2193e = System.getProperty("line.separator");
    private static final CallerContext f2194f = CallerContext.a(PageNuxComponentView.class, "pages_public_view");
    @Inject
    public Provider<FbDraweeControllerBuilder> f2195a;
    @Inject
    public Provider<SingleMethodRunner> f2196b;
    @Inject
    public PageNuxExposuresMethod f2197c;
    @Inject
    public PageNuxViewStateStore f2198d;
    public final BetterTextView f2199g = ((BetterTextView) a(2131565630));
    public final BetterTextView f2200h = ((BetterTextView) a(2131565629));
    public final BetterTextView f2201i = ((BetterTextView) a(2131565631));
    public final FbDraweeView f2202j = ((FbDraweeView) a(2131565627));
    public final FrameLayout f2203k = ((FrameLayout) a(2131565626));
    public final FbButton f2204l = ((FbButton) a(2131565632));
    public final ImageView f2205m = ((ImageView) a(2131565628));
    public final BetterTextView f2206n = ((BetterTextView) a(2131565625));
    public C02761 f2207o;
    public NuxStateKey f2208p;

    /* compiled from: search_identifier */
    public class C02761 {
        public final /* synthetic */ PageNuxComponentView f2188a;

        C02761(PageNuxComponentView pageNuxComponentView) {
            this.f2188a = pageNuxComponentView;
        }
    }

    /* compiled from: search_identifier */
    public /* synthetic */ class C02783 {
        public static final /* synthetic */ int[] f2192a = new int[NuxViewState.values().length];

        static {
            try {
                f2192a[NuxViewState.NUX_CAN_SHOW.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2192a[NuxViewState.NUX_DISMISSED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public static void m3178a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        PageNuxComponentView pageNuxComponentView = (PageNuxComponentView) obj;
        Provider a = IdBasedProvider.a(injectorLike, 1117);
        Provider a2 = IdBasedSingletonScopeProvider.a(injectorLike, 2289);
        PageNuxExposuresMethod a3 = PageNuxExposuresMethod.m3156a(injectorLike);
        PageNuxViewStateStore a4 = PageNuxViewStateStore.m3160a(injectorLike);
        pageNuxComponentView.f2195a = a;
        pageNuxComponentView.f2196b = a2;
        pageNuxComponentView.f2197c = a3;
        pageNuxComponentView.f2198d = a4;
    }

    public PageNuxComponentView(Context context) {
        super(context);
        setContentView(2130906069);
        setOrientation(1);
        setBackgroundResource(2131361920);
        setLayoutTransition(new LayoutTransition());
        CustomFontHelper.a(this.f2200h, FontFamily.ROBOTO, FontWeight.BOLD, this.f2200h.getTypeface());
        CustomFontHelper.a(this.f2199g, FontFamily.ROBOTO, FontWeight.REGULAR, this.f2199g.getTypeface());
        CustomFontHelper.a(this.f2201i, FontFamily.ROBOTO, FontWeight.REGULAR, this.f2201i.getTypeface());
        CustomFontHelper.a(this.f2204l, FontFamily.ROBOTO, FontWeight.BOLD, this.f2204l.getTypeface());
        CustomFontHelper.a(this.f2206n, FontFamily.ROBOTO, FontWeight.REGULAR, this.f2206n.getTypeface());
        Class cls = PageNuxComponentView.class;
        m3178a((Object) this, getContext());
    }

    public final void m3179a(NuxStateKey nuxStateKey, DefaultTextWithEntitiesFields defaultTextWithEntitiesFields, DefaultTextWithEntitiesFields defaultTextWithEntitiesFields2, ImmutableList<? extends DefaultTextWithEntitiesFields> immutableList, DefaultImageFields defaultImageFields, String str, String str2, OnClickListener onClickListener, String str3, OnClickListener onClickListener2, String str4) {
        Preconditions.checkNotNull(nuxStateKey);
        this.f2208p = nuxStateKey;
        this.f2207o = new C02761(this);
        m3175a(defaultImageFields, str);
        m3176a(defaultTextWithEntitiesFields, defaultTextWithEntitiesFields2, (ImmutableList) immutableList);
        m3174a(onClickListener, str3, onClickListener2, str4, nuxStateKey.f2135b, str2);
        setState(this, getNuxViewState());
    }

    public static void setState(PageNuxComponentView pageNuxComponentView, NuxViewState nuxViewState) {
        pageNuxComponentView.f2198d.m3163a(pageNuxComponentView.f2208p, nuxViewState, pageNuxComponentView.f2207o);
    }

    private NuxViewState getNuxViewState() {
        NuxViewState a = this.f2198d.m3162a(this.f2208p);
        return a != null ? a : NuxViewState.NUX_CAN_SHOW;
    }

    private void m3174a(OnClickListener onClickListener, String str, OnClickListener onClickListener2, String str2, final String str3, final String str4) {
        this.f2204l.setOnClickListener(onClickListener);
        this.f2204l.setText(str);
        this.f2206n.setText(str2);
        this.f2206n.setOnClickListener(onClickListener2);
        this.f2205m.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PageNuxComponentView f2191c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1290839660);
                PageNuxComponentView.setState(this.f2191c, NuxViewState.NUX_DISMISSED);
                PageNuxComponentView.m3177a(this.f2191c, str3, str4);
                Logger.a(2, EntryType.UI_INPUT_END, -230343541, a);
            }
        });
    }

    public static void m3177a(PageNuxComponentView pageNuxComponentView, String str, String str2) {
        try {
            ((AbstractSingleMethodRunner) pageNuxComponentView.f2196b.get()).a(pageNuxComponentView.f2197c, new PageNuxExposuresCallArguments(str, str2), f2194f);
        } catch (Exception e) {
        }
    }

    private void m3175a(DefaultImageFields defaultImageFields, String str) {
        this.f2203k.setBackgroundColor(Color.parseColor(str));
        this.f2202j.setController(((FbDraweeControllerBuilder) this.f2195a.get()).a(f2194f).a(defaultImageFields.b()).s());
        LayoutParams layoutParams = this.f2202j.getLayoutParams();
        layoutParams.width = defaultImageFields.c();
        layoutParams.height = defaultImageFields.a();
    }

    private void m3176a(DefaultTextWithEntitiesFields defaultTextWithEntitiesFields, DefaultTextWithEntitiesFields defaultTextWithEntitiesFields2, ImmutableList<? extends DefaultTextWithEntitiesFields> immutableList) {
        this.f2200h.setText(defaultTextWithEntitiesFields.a());
        this.f2199g.setText(defaultTextWithEntitiesFields2.a());
        if (immutableList.isEmpty()) {
            this.f2201i.setVisibility(8);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < immutableList.size(); i++) {
            stringBuilder.append(" • ");
            stringBuilder.append(((DefaultTextWithEntitiesFields) immutableList.get(i)).a());
            if (i < immutableList.size() - 1) {
                stringBuilder.append(f2193e);
            }
        }
        this.f2201i.setVisibility(0);
        this.f2201i.setText(stringBuilder.toString());
    }
}

package com.facebook.instantshopping.view.block.impl;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.facebook.common.util.SizeUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.enums.GraphQLInstantShoppingActionType;
import com.facebook.graphql.executor.cache.GraphQLCacheManager;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.instantshopping.action.InstantShoppingActionUtils;
import com.facebook.instantshopping.event.InstantShoppingEvents.ProductSavedEvent;
import com.facebook.instantshopping.fetcher.InstantShoppingDocumentFetcher;
import com.facebook.instantshopping.logging.InstantShoppingAnalyticsLogger;
import com.facebook.instantshopping.logging.LoggingParams;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingActionFragmentModel;
import com.facebook.instantshopping.presenter.ToggleButtonBlockPresenter;
import com.facebook.instantshopping.utils.InstantShoppingDocumentContext;
import com.facebook.instantshopping.utils.InstantShoppingSaveUtils;
import com.facebook.instantshopping.view.block.ToggleButtonBlockView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.richdocument.event.RichDocumentEventBus;
import com.facebook.richdocument.model.block.RichText;
import com.facebook.richdocument.presenter.AbstractBlockPresenter;
import com.facebook.richdocument.view.block.impl.AbstractBlockView;
import com.facebook.richdocument.view.widget.RichTextView;
import com.facebook.richdocument.view.widget.RichTextView.InnerRichTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.collect.ImmutableSet;
import java.util.HashMap;
import javax.inject.Inject;

/* compiled from: SSL */
public class ToggleButtonBlockViewImpl extends AbstractBlockView<ToggleButtonBlockPresenter> implements ToggleButtonBlockView {
    @Inject
    InstantShoppingActionUtils f23836a;
    @Inject
    RichDocumentEventBus f23837b;
    @Inject
    public InstantShoppingSaveUtils f23838c;
    @Inject
    public InstantShoppingDocumentContext f23839d;
    @Inject
    GraphQLCacheManager f23840e;
    @Inject
    InstantShoppingDocumentFetcher f23841f;
    @Inject
    public InstantShoppingAnalyticsLogger f23842g;
    public final FrameLayout f23843h;
    public final InnerRichTextView f23844i;
    public ToggleButtonBlockPresenter f23845j;

    /* compiled from: SSL */
    public class C34201 implements OnClickListener {
        final /* synthetic */ InstantShoppingActionFragmentModel f23832a;
        final /* synthetic */ InstantShoppingActionFragmentModel f23833b;
        final /* synthetic */ LoggingParams f23834c;
        final /* synthetic */ ToggleButtonBlockViewImpl f23835d;

        public C34201(ToggleButtonBlockViewImpl toggleButtonBlockViewImpl, InstantShoppingActionFragmentModel instantShoppingActionFragmentModel, InstantShoppingActionFragmentModel instantShoppingActionFragmentModel2, LoggingParams loggingParams) {
            this.f23835d = toggleButtonBlockViewImpl;
            this.f23832a = instantShoppingActionFragmentModel;
            this.f23833b = instantShoppingActionFragmentModel2;
            this.f23834c = loggingParams;
        }

        public void onClick(View view) {
            boolean z = true;
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1263521214);
            final boolean z2 = this.f23835d.f23845j.f23694d;
            this.f23835d.f23845j.m25029a(!z2);
            this.f23835d.f23836a.m24802a(this.f23835d.getContext(), z2 ? this.f23832a : this.f23833b, this.f23834c, new HashMap<String, Object>() {
            });
            if (this.f23833b.a() == GraphQLInstantShoppingActionType.SAVE || this.f23832a.a() == GraphQLInstantShoppingActionType.UNSAVE) {
                RichDocumentEventBus richDocumentEventBus = this.f23835d.f23837b;
                if (z2) {
                    z = false;
                }
                richDocumentEventBus.a(new ProductSavedEvent(z));
                this.f23835d.f23840e.a(ImmutableSet.of(this.f23835d.f23841f.a(this.f23835d.f23839d.a)));
            }
            LogUtils.a(-925924826, a);
        }
    }

    public static void m25119a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((ToggleButtonBlockViewImpl) obj).m25118a(InstantShoppingActionUtils.m24796a(injectorLike), RichDocumentEventBus.a(injectorLike), InstantShoppingSaveUtils.a(injectorLike), InstantShoppingDocumentContext.a(injectorLike), GraphQLCacheManager.a(injectorLike), InstantShoppingDocumentFetcher.a(injectorLike), InstantShoppingAnalyticsLogger.m24853a(injectorLike));
    }

    private void m25118a(InstantShoppingActionUtils instantShoppingActionUtils, RichDocumentEventBus richDocumentEventBus, InstantShoppingSaveUtils instantShoppingSaveUtils, InstantShoppingDocumentContext instantShoppingDocumentContext, GraphQLCacheManager graphQLCacheManager, InstantShoppingDocumentFetcher instantShoppingDocumentFetcher, InstantShoppingAnalyticsLogger instantShoppingAnalyticsLogger) {
        this.f23836a = instantShoppingActionUtils;
        this.f23837b = richDocumentEventBus;
        this.f23838c = instantShoppingSaveUtils;
        this.f23839d = instantShoppingDocumentContext;
        this.f23840e = graphQLCacheManager;
        this.f23841f = instantShoppingDocumentFetcher;
        this.f23842g = instantShoppingAnalyticsLogger;
    }

    public final void m25123a(AbstractBlockPresenter abstractBlockPresenter) {
        ToggleButtonBlockPresenter toggleButtonBlockPresenter = (ToggleButtonBlockPresenter) abstractBlockPresenter;
        super.a(toggleButtonBlockPresenter);
        this.f23845j = toggleButtonBlockPresenter;
    }

    public ToggleButtonBlockViewImpl(View view) {
        super(view);
        this.f23843h = (FrameLayout) view.findViewById(2131563267);
        this.f23844i = ((RichTextView) view.findViewById(2131563268)).d;
        Class cls = ToggleButtonBlockViewImpl.class;
        m25119a(this, getContext());
    }

    public final void m25121a(Bundle bundle) {
        super.a(bundle);
        iY_().setVisibility(8);
        this.f23844i.a();
    }

    public final void m25122a(RichText richText) {
        if (richText != null) {
            this.f23844i.setText(richText);
        }
    }

    public final void m25120a(int i) {
        this.f23844i.setTextColor(i);
    }

    public final void m25124a(String str) {
        if (!StringUtil.a(str)) {
            try {
                this.f23843h.setMinimumHeight(SizeUtil.a(getContext(), Float.parseFloat(str)));
            } catch (NumberFormatException e) {
            }
        }
    }

    public final void m25125b(int i) {
        this.f23843h.setBackgroundResource(i);
    }
}

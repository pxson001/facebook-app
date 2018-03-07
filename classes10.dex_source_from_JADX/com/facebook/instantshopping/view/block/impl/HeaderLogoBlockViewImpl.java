package com.facebook.instantshopping.view.block.impl;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.instantshopping.action.InstantShoppingActionUtils;
import com.facebook.instantshopping.logging.InstantShoppingAnalyticsLogger;
import com.facebook.instantshopping.logging.LoggingParams;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingActionFragmentModel;
import com.facebook.instantshopping.presenter.HeaderBlockPresenter;
import com.facebook.instantshopping.view.block.HeaderBlockView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.richdocument.view.block.impl.AbstractBlockView;
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.inject.Inject;

/* compiled from: START_NEW_FETCH_AND_TRACK_RESULT */
public class HeaderLogoBlockViewImpl extends AbstractBlockView<HeaderBlockPresenter> implements HeaderBlockView {
    private static final CallerContext f23768d = CallerContext.a(HeaderLogoBlockViewImpl.class);
    public FbDraweeView f23769a;
    @Inject
    public InstantShoppingActionUtils f23770b;
    @Inject
    public InstantShoppingAnalyticsLogger f23771c;
    public LoggingParams f23772e;

    public static void m25063a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        HeaderLogoBlockViewImpl headerLogoBlockViewImpl = (HeaderLogoBlockViewImpl) obj;
        InstantShoppingActionUtils a = InstantShoppingActionUtils.m24796a(injectorLike);
        InstantShoppingAnalyticsLogger a2 = InstantShoppingAnalyticsLogger.m24853a(injectorLike);
        headerLogoBlockViewImpl.f23770b = a;
        headerLogoBlockViewImpl.f23771c = a2;
    }

    public HeaderLogoBlockViewImpl(View view) {
        super(view);
        Class cls = HeaderLogoBlockViewImpl.class;
        m25063a(this, getContext());
        this.f23769a = (FbDraweeView) view.findViewById(mo1030d());
    }

    protected int mo1030d() {
        return 2131563312;
    }

    public final void mo1028c() {
        this.f23769a.setVisibility(0);
    }

    public final void mo1027a(final InstantShoppingActionFragmentModel instantShoppingActionFragmentModel) {
        this.f23769a.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ HeaderLogoBlockViewImpl f23775b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 2059766784);
                if (instantShoppingActionFragmentModel == null) {
                    Logger.a(2, EntryType.UI_INPUT_END, 1240399128, a);
                    return;
                }
                this.f23775b.f23770b.m24802a(this.f23775b.getContext(), instantShoppingActionFragmentModel, this.f23775b.f23772e, null);
                LogUtils.a(-1960610427, a);
            }
        });
    }

    public CallerContext mo1031f() {
        return f23768d;
    }
}

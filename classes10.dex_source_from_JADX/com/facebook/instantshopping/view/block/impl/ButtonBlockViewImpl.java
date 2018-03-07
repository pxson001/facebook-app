package com.facebook.instantshopping.view.block.impl;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.facebook.common.util.SizeUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.enums.GraphQLInstantShoppingPresentationStyle;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.instantshopping.action.InstantShoppingActionUtils;
import com.facebook.instantshopping.logging.InstantShoppingAnalyticsLogger;
import com.facebook.instantshopping.logging.InstantShoppingLoggingUtils;
import com.facebook.instantshopping.logging.LoggingParams;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingActionFragmentModel;
import com.facebook.instantshopping.presenter.ButtonBlockPresenter;
import com.facebook.instantshopping.utils.InstantShoppingTextUtils;
import com.facebook.instantshopping.view.block.ButtonBlockView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.richdocument.view.block.impl.AbstractBlockView;
import com.facebook.richdocument.view.widget.RichTextView;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: STATUS_UNSUBSCRIBED */
public class ButtonBlockViewImpl extends AbstractBlockView<ButtonBlockPresenter> implements ButtonBlockView {
    @Inject
    public InstantShoppingAnalyticsLogger f23701a;
    @Inject
    public InstantShoppingActionUtils f23702b;
    @Inject
    public InstantShoppingTextUtils f23703c;
    @Inject
    public InstantShoppingLoggingUtils f23704d;
    public final FrameLayout f23705e;
    public final RichTextView f23706f;

    /* compiled from: STATUS_UNSUBSCRIBED */
    public class C33991 implements OnClickListener {
        final /* synthetic */ LoggingParams f23698a;
        final /* synthetic */ InstantShoppingActionFragmentModel f23699b;
        final /* synthetic */ ButtonBlockViewImpl f23700c;

        public C33991(ButtonBlockViewImpl buttonBlockViewImpl, LoggingParams loggingParams, InstantShoppingActionFragmentModel instantShoppingActionFragmentModel) {
            this.f23700c = buttonBlockViewImpl;
            this.f23698a = loggingParams;
            this.f23699b = instantShoppingActionFragmentModel;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 383111687);
            this.f23700c.f23704d.m24884b("button_link_click", this.f23698a.toString() + this.f23699b.toString());
            this.f23700c.f23702b.m24802a(this.f23700c.getContext(), this.f23699b, this.f23698a, null);
            Logger.a(2, EntryType.UI_INPUT_END, 1742555776, a);
        }
    }

    public static void m25037a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ButtonBlockViewImpl buttonBlockViewImpl = (ButtonBlockViewImpl) obj;
        InstantShoppingAnalyticsLogger a = InstantShoppingAnalyticsLogger.m24853a(injectorLike);
        InstantShoppingActionUtils a2 = InstantShoppingActionUtils.m24796a(injectorLike);
        InstantShoppingTextUtils b = InstantShoppingTextUtils.b(injectorLike);
        InstantShoppingLoggingUtils a3 = InstantShoppingLoggingUtils.m24879a(injectorLike);
        buttonBlockViewImpl.f23701a = a;
        buttonBlockViewImpl.f23702b = a2;
        buttonBlockViewImpl.f23703c = b;
        buttonBlockViewImpl.f23704d = a3;
    }

    public ButtonBlockViewImpl(View view) {
        super(view);
        this.f23706f = (RichTextView) view.findViewById(2131563229);
        this.f23705e = (FrameLayout) view.findViewById(2131563228);
        Class cls = ButtonBlockViewImpl.class;
        m25037a(this, getContext());
    }

    public final void m25038a(Bundle bundle) {
        super.a(bundle);
        this.f23706f.setVisibility(8);
        this.f23706f.d.a();
    }

    public final void m25039a(String str) {
        if (!StringUtil.a(str)) {
            try {
                this.f23705e.setMinimumHeight(SizeUtil.a(getContext(), Float.parseFloat(str)));
            } catch (NumberFormatException e) {
            }
        }
    }

    public static GradientDrawable m25036a(Context context, ImmutableList<GraphQLInstantShoppingPresentationStyle> immutableList, int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius((float) context.getResources().getDimensionPixelSize(2131432842));
        if (immutableList == null || !immutableList.contains(GraphQLInstantShoppingPresentationStyle.BUTTON_OUTLINE)) {
            gradientDrawable.setColor(i);
        } else {
            gradientDrawable.setStroke(SizeUtil.a(context, 1.0f), i);
            gradientDrawable.setColor(0);
        }
        return gradientDrawable;
    }
}

package com.facebook.instantshopping.presenter;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View.OnClickListener;
import com.facebook.graphql.enums.GraphQLInstantShoppingDocumentAlignmentDescriptorType;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.instantshopping.logging.InstantShoppingElementDwellTimeLogger;
import com.facebook.instantshopping.logging.InstantShoppingLoggingUtils;
import com.facebook.instantshopping.logging.LoggingParams;
import com.facebook.instantshopping.model.data.ButtonBlockData;
import com.facebook.instantshopping.model.data.impl.ButtonBlockDataImpl;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingTextMetricsDescriptorFragmentModel;
import com.facebook.instantshopping.view.block.ButtonBlockView;
import com.facebook.instantshopping.view.block.impl.ButtonBlockViewImpl;
import com.facebook.instantshopping.view.block.impl.ButtonBlockViewImpl.C33991;
import com.facebook.richdocument.model.block.RichText;
import com.facebook.richdocument.model.block.RichText.RichTextBuilder;
import com.facebook.richdocument.model.data.BlockData;
import com.facebook.richdocument.presenter.AbstractBlockPresenter;
import com.facebook.widget.CustomViewUtils;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: SUMMARY_LINES */
public class ButtonBlockPresenter extends AbstractBlockPresenter<ButtonBlockView, ButtonBlockData> {
    @Inject
    public InstantShoppingLoggingUtils f23660d;
    @Inject
    public InstantShoppingElementDwellTimeLogger f23661e;
    private LoggingParams f23662f;

    public static void m24980a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ButtonBlockPresenter buttonBlockPresenter = (ButtonBlockPresenter) obj;
        InstantShoppingLoggingUtils a = InstantShoppingLoggingUtils.m24879a(injectorLike);
        InstantShoppingElementDwellTimeLogger a2 = InstantShoppingElementDwellTimeLogger.m24873a(injectorLike);
        buttonBlockPresenter.f23660d = a;
        buttonBlockPresenter.f23661e = a2;
    }

    public final void m24982a(BlockData blockData) {
        ImmutableList iJ_;
        ButtonBlockDataImpl buttonBlockDataImpl = (ButtonBlockDataImpl) blockData;
        ButtonBlockViewImpl buttonBlockViewImpl = (ButtonBlockViewImpl) this.d;
        RichText a = new RichTextBuilder(getContext()).a(buttonBlockDataImpl.f23639a.iK_()).a(2131626227).a();
        InstantShoppingTextMetricsDescriptorFragmentModel f = buttonBlockDataImpl.mo1021f();
        buttonBlockViewImpl.f23706f.d.setText(a);
        buttonBlockViewImpl.f23706f.d.setMovementMethod(null);
        buttonBlockViewImpl.f23703c.a(buttonBlockViewImpl.f23706f.d, GraphQLInstantShoppingDocumentAlignmentDescriptorType.CENTER, f);
        buttonBlockViewImpl.m25039a(buttonBlockDataImpl.f23639a.d().iO_());
        OnClickListener c33991 = new C33991(buttonBlockViewImpl, buttonBlockDataImpl.mo1008C(), buttonBlockDataImpl.f23639a.a());
        buttonBlockViewImpl.f23706f.d.setOnClickListener(c33991);
        buttonBlockViewImpl.f23705e.setOnClickListener(c33991);
        this.f23662f = buttonBlockDataImpl.mo1008C();
        buttonBlockViewImpl.f23701a.m24856a(this.f23662f);
        if (buttonBlockDataImpl.f23639a.iJ_() != null) {
            iJ_ = buttonBlockDataImpl.f23639a.iJ_();
        } else {
            iJ_ = null;
        }
        ImmutableList immutableList = iJ_;
        int parseColor = buttonBlockDataImpl.f23639a.b() == null ? -1 : buttonBlockDataImpl.f23639a.b().startsWith("#") ? Color.parseColor(buttonBlockDataImpl.f23639a.b()) : Color.parseColor("#" + buttonBlockDataImpl.f23639a.b());
        CustomViewUtils.b(buttonBlockViewImpl.f23705e, ButtonBlockViewImpl.m25036a(buttonBlockViewImpl.getContext(), immutableList, parseColor));
    }

    public ButtonBlockPresenter(ButtonBlockViewImpl buttonBlockViewImpl) {
        super(buttonBlockViewImpl);
        Class cls = ButtonBlockPresenter.class;
        m24980a(this, getContext());
    }

    public final void m24981a(Bundle bundle) {
        super.a(bundle);
        this.f23660d.m24884b("button_element_start", this.f23662f.toString());
        this.f23661e.m24876a(this.f23662f.toString());
    }

    public final void m24983b(Bundle bundle) {
        super.b(bundle);
        this.f23660d.m24884b("button_element_end", this.f23662f.toString());
        this.f23661e.m24877b(this.f23662f.toString());
    }
}

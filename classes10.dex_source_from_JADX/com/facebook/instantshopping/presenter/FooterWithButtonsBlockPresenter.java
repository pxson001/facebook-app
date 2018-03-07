package com.facebook.instantshopping.presenter;

import android.view.View.OnClickListener;
import com.facebook.graphql.enums.GraphQLInstantShoppingDocumentAlignmentDescriptorType;
import com.facebook.graphql.enums.GraphQLInstantShoppingDocumentElementType;
import com.facebook.instantshopping.logging.LoggingParams;
import com.facebook.instantshopping.model.block.button.InstantShoppingButtonBlockWrapper;
import com.facebook.instantshopping.model.block.button.InstantShoppingToggleButtonBlockWrapper;
import com.facebook.instantshopping.model.block.footer.InstantShoppingFooterWithButtonsWrapper;
import com.facebook.instantshopping.model.data.FooterBlockData;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingActionFragmentModel;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingTextMetricsDescriptorFragmentModel;
import com.facebook.instantshopping.view.block.FooterBlockView;
import com.facebook.instantshopping.view.block.impl.ButtonBlockViewImpl;
import com.facebook.instantshopping.view.block.impl.FooterBlockViewImpl;
import com.facebook.instantshopping.view.block.impl.FooterBlockViewImpl.C34081;
import com.facebook.instantshopping.view.block.impl.FooterBlockViewImpl.C34102;
import com.facebook.richdocument.model.block.RichText;
import com.facebook.richdocument.model.block.RichText.RichTextBuilder;
import com.facebook.richdocument.model.data.BlockData;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentText;
import com.facebook.richdocument.presenter.AbstractBlockPresenter;
import com.facebook.widget.CustomViewUtils;
import com.google.common.collect.ImmutableList;
import java.util.Map;

/* compiled from: STRUCTURED_APPEND */
public class FooterWithButtonsBlockPresenter extends AbstractBlockPresenter<FooterBlockView, FooterBlockData> {
    private final InstantShoppingFooterWithButtonsWrapper f23674d;
    private InstantShoppingToggleButtonBlockWrapper f23675e;
    public boolean f23676f;

    public final /* synthetic */ void m25001a(BlockData blockData) {
        m25003b();
    }

    public FooterWithButtonsBlockPresenter(FooterBlockViewImpl footerBlockViewImpl, InstantShoppingFooterWithButtonsWrapper instantShoppingFooterWithButtonsWrapper) {
        super(footerBlockViewImpl);
        this.f23674d = instantShoppingFooterWithButtonsWrapper;
    }

    public final void m25003b() {
        ((FooterBlockViewImpl) this.d).iY_().setVisibility(0);
        Map a = this.f23674d.m24898a();
        if (a.containsKey(GraphQLInstantShoppingDocumentElementType.BUTTON)) {
            InstantShoppingButtonBlockWrapper instantShoppingButtonBlockWrapper = (InstantShoppingButtonBlockWrapper) a.get(GraphQLInstantShoppingDocumentElementType.BUTTON);
            ((FooterBlockViewImpl) this.d).f23763l.setVisibility(0);
            FooterBlockViewImpl footerBlockViewImpl = (FooterBlockViewImpl) this.d;
            RichText a2 = new RichTextBuilder(getContext()).a(instantShoppingButtonBlockWrapper.f23589a.iK_()).a(2131626226).a();
            InstantShoppingTextMetricsDescriptorFragmentModel nu_ = instantShoppingButtonBlockWrapper.nu_();
            if (a2 != null) {
                footerBlockViewImpl.f23765n.setText(a2);
                footerBlockViewImpl.f23765n.setMovementMethod(null);
                footerBlockViewImpl.f23761j.a(footerBlockViewImpl.f23765n, GraphQLInstantShoppingDocumentAlignmentDescriptorType.CENTER, nu_);
            } else {
                footerBlockViewImpl.f23763l.setVisibility(8);
            }
            footerBlockViewImpl = (FooterBlockViewImpl) this.d;
            OnClickListener c34081 = new C34081(footerBlockViewImpl, instantShoppingButtonBlockWrapper.f23589a.a(), new LoggingParams(instantShoppingButtonBlockWrapper.f23589a.iI_(), instantShoppingButtonBlockWrapper.f23589a.c().toString()));
            footerBlockViewImpl.f23763l.setOnClickListener(c34081);
            footerBlockViewImpl.f23765n.setOnClickListener(c34081);
            if (instantShoppingButtonBlockWrapper.m24897c() != -1) {
                ImmutableList iJ_;
                footerBlockViewImpl = (FooterBlockViewImpl) this.d;
                if (instantShoppingButtonBlockWrapper.f23589a.iJ_() != null) {
                    iJ_ = instantShoppingButtonBlockWrapper.f23589a.iJ_();
                } else {
                    iJ_ = null;
                }
                CustomViewUtils.b(footerBlockViewImpl.f23763l, ButtonBlockViewImpl.m25036a(footerBlockViewImpl.getContext(), iJ_, instantShoppingButtonBlockWrapper.m24897c()));
            }
        }
        if (a.containsKey(GraphQLInstantShoppingDocumentElementType.TOGGLE_BUTTON)) {
            boolean a3;
            this.f23675e = (InstantShoppingToggleButtonBlockWrapper) a.get(GraphQLInstantShoppingDocumentElementType.TOGGLE_BUTTON);
            ((FooterBlockViewImpl) this.d).f23764m.setVisibility(0);
            FooterBlockViewImpl footerBlockViewImpl2 = (FooterBlockViewImpl) this.d;
            InstantShoppingToggleButtonBlockWrapper instantShoppingToggleButtonBlockWrapper = this.f23675e;
            String str = footerBlockViewImpl2.f23756e.a;
            if (footerBlockViewImpl2.f23755d.b(str)) {
                a3 = footerBlockViewImpl2.f23755d.a(str);
            } else {
                a3 = instantShoppingToggleButtonBlockWrapper.f23590a.r();
            }
            this.f23676f = a3;
            m25002a(this.f23676f);
            footerBlockViewImpl2 = (FooterBlockViewImpl) this.d;
            InstantShoppingActionFragmentModel q = this.f23675e.f23590a.q();
            InstantShoppingActionFragmentModel u = this.f23675e.f23590a.u();
            InstantShoppingToggleButtonBlockWrapper instantShoppingToggleButtonBlockWrapper2 = this.f23675e;
            c34081 = new C34102(footerBlockViewImpl2, u, q, new LoggingParams(instantShoppingToggleButtonBlockWrapper2.f23590a.iI_(), instantShoppingToggleButtonBlockWrapper2.f23590a.c().toString()));
            footerBlockViewImpl2.f23764m.setOnClickListener(c34081);
            footerBlockViewImpl2.f23766o.setOnClickListener(c34081);
            if (!this.f23676f) {
                ((FooterBlockViewImpl) this.d).m25062f();
            }
        }
    }

    public final void m25002a(boolean z) {
        this.f23676f = z;
        if (this.f23676f) {
            ((FooterBlockViewImpl) this.d).m25059a(m25000b(this.f23675e.f23590a.t()));
            ((FooterBlockViewImpl) this.d).m25057a(getContext().getResources().getColor(2131361917));
            ((FooterBlockViewImpl) this.d).m25061b(2130840977);
            return;
        }
        ((FooterBlockViewImpl) this.d).m25059a(m25000b(this.f23675e.f23590a.s()));
        ((FooterBlockViewImpl) this.d).m25057a(getContext().getResources().getColor(2131363670));
        ((FooterBlockViewImpl) this.d).m25061b(2130840976);
    }

    private RichText m25000b(RichDocumentText richDocumentText) {
        return new RichTextBuilder(getContext()).a(richDocumentText).a(2131626226).a();
    }
}

package com.facebook.instantshopping.model.block.text;

import com.facebook.instantshopping.logging.LoggingParams;
import com.facebook.instantshopping.model.block.BaseInstantShoppingBlockWrapper;
import com.facebook.instantshopping.model.block.HasTextMetrics;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLInterfaces.InstantShoppingTextElementFragment;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingTextMetricsDescriptorFragmentModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentText;
import javax.annotation.Nullable;

/* compiled from: SendApiHandler_NULL_RETRYABLE_ERROR_MESSAGE */
public class InstantShoppingTextBlockWrapper extends BaseInstantShoppingBlockWrapper implements HasTextMetrics {
    public final RichDocumentText f23602a;
    private InstantShoppingTextElementFragment f23603b;
    private boolean f23604c = true;

    public InstantShoppingTextBlockWrapper(InstantShoppingTextElementFragment instantShoppingTextElementFragment) {
        super(instantShoppingTextElementFragment.d());
        this.f23602a = instantShoppingTextElementFragment.iK_();
        this.f23603b = instantShoppingTextElementFragment;
    }

    @Nullable
    public final InstantShoppingTextMetricsDescriptorFragmentModel nu_() {
        return this.f23603b.d() == null ? null : this.f23603b.d().g();
    }

    public final LoggingParams m24906f() {
        return new LoggingParams(this.f23603b.iI_(), this.f23603b.c().toString());
    }
}

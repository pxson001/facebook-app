package com.facebook.instantshopping.presenter;

import com.facebook.graphql.enums.GraphQLInstantShoppingDocumentAlignmentDescriptorType;
import com.facebook.instantshopping.logging.InstantShoppingAnalyticsLogger;
import com.facebook.instantshopping.model.block.BaseInstantShoppingBlockWrapper;
import com.facebook.instantshopping.model.block.text.InstantShoppingText.InstantShoppingTextBuilder;
import com.facebook.instantshopping.model.block.text.InstantShoppingTextBlockWrapper;
import com.facebook.instantshopping.model.data.MediaHasCaption;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLInterfaces.InstantShoppingTextElementFragment;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingTextMetricsDescriptorFragmentModel;
import com.facebook.instantshopping.view.block.impl.LinkableImageWithAnnotationBlockViewImpl;
import com.facebook.richdocument.model.block.RichText;
import com.facebook.richdocument.model.data.ImageBlockData;
import com.facebook.richdocument.view.block.impl.ImageBlockViewImpl;

/* compiled from: STICKER */
public class LinkableImageWithAnnotationBlockPresenter extends LinkableImageBlockPresenter {
    private final InstantShoppingAnalyticsLogger f23692i;

    public LinkableImageWithAnnotationBlockPresenter(ImageBlockViewImpl imageBlockViewImpl, InstantShoppingAnalyticsLogger instantShoppingAnalyticsLogger) {
        super(imageBlockViewImpl);
        this.f23692i = instantShoppingAnalyticsLogger;
    }

    public final void mo1026a(ImageBlockData imageBlockData) {
        super.mo1026a(imageBlockData);
        if ((this.d instanceof LinkableImageWithAnnotationBlockViewImpl) && (imageBlockData instanceof MediaHasCaption)) {
            InstantShoppingTextElementFragment nz_ = ((MediaHasCaption) imageBlockData).nz_();
            if (nz_ != null) {
                BaseInstantShoppingBlockWrapper instantShoppingTextBlockWrapper = new InstantShoppingTextBlockWrapper(nz_);
                RichText a = new InstantShoppingTextBuilder(getContext(), instantShoppingTextBlockWrapper.m24906f()).a(instantShoppingTextBlockWrapper).a();
                LinkableImageWithAnnotationBlockViewImpl linkableImageWithAnnotationBlockViewImpl = (LinkableImageWithAnnotationBlockViewImpl) this.d;
                GraphQLInstantShoppingDocumentAlignmentDescriptorType e = instantShoppingTextBlockWrapper.m24891e();
                InstantShoppingTextMetricsDescriptorFragmentModel nu_ = instantShoppingTextBlockWrapper.nu_();
                linkableImageWithAnnotationBlockViewImpl.f23820r.setText(a.a);
                linkableImageWithAnnotationBlockViewImpl.f23818p.a(linkableImageWithAnnotationBlockViewImpl.f23820r, e, nu_);
            }
        }
    }
}

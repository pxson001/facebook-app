package com.facebook.commerce.publishing.fragments.adminproduct;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;

/* compiled from: cuts_count */
public class AdminProductFragmentControllerProvider extends AbstractAssistedProvider<AdminProductFragmentController> {
    public final AdminProductFragmentController m16097a(AdminProductFragment adminProductFragment) {
        return new AdminProductFragmentController(new AdminProductFragmentLoader(), adminProductFragment, (ProductCreationFieldsProvider) getOnDemandAssistedProviderForStaticDi(ProductCreationFieldsProvider.class), (ProductWithEditFieldsProvider) getOnDemandAssistedProviderForStaticDi(ProductWithEditFieldsProvider.class), (PageViewerContextLoadableProvider) getOnDemandAssistedProviderForStaticDi(PageViewerContextLoadableProvider.class), IdBasedLazy.a(this, 3561), IdBasedSingletonScopeProvider.b(this, 494));
    }
}

package com.facebook.friendsharing.souvenirs.verve;

import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.friendsharing.souvenirs.protocols.FetchSouvenirsModels.SouvenirsDetailsFieldsModel;
import com.facebook.friendsharing.souvenirs.util.SouvenirsElementHelper;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;

/* compiled from: Publish Mode Selector NUX */
public class SouvenirsVerveViewSupplierProvider extends AbstractAssistedProvider<SouvenirsVerveViewSupplier> {
    public final SouvenirsVerveViewSupplier m26496a(SouvenirsDetailsFieldsModel souvenirsDetailsFieldsModel, FeedProps feedProps) {
        return new SouvenirsVerveViewSupplier(IdBasedProvider.a(this, 9351), new SouvenirsElementHelper(), ResourcesMethodAutoProvider.a(this), (SecureContextHelper) DefaultSecureContextHelper.a(this), souvenirsDetailsFieldsModel, feedProps);
    }
}

package com.facebook.friendsharing.souvenirs.attachment;

import android.content.Context;
import com.facebook.friendsharing.souvenirs.attachment.SouvenirAttachmentPagerAdapter.Delegate;
import com.facebook.friendsharing.souvenirs.models.SouvenirModel;
import com.facebook.inject.AbstractAssistedProvider;
import com.google.common.collect.ImmutableList;

/* compiled from: Requesting more media than we can provide */
public class SouvenirAttachmentPagerAdapterProvider extends AbstractAssistedProvider<SouvenirAttachmentPagerAdapter> {
    public final SouvenirAttachmentPagerAdapter m26117a(Delegate delegate, ImmutableList<SouvenirModel> immutableList) {
        return new SouvenirAttachmentPagerAdapter(delegate, immutableList, (Context) getInstance(Context.class), (SouvenirsViewStateProvider) getOnDemandAssistedProviderForStaticDi(SouvenirsViewStateProvider.class));
    }
}

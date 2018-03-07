package com.facebook.composer.ui.statusview;

import android.content.Context;
import android.view.ViewStub;
import com.facebook.auth.module.User_LoggedInUserMethodAutoProvider;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.minutiae.model.MinutiaeObject.ProvidesMinutiae;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesMetaText;
import com.facebook.ipc.composer.intent.ComposerTargetData.ProvidesTargetData;

/* compiled from: fb4a_total_rss_kb */
public class ComposerHeaderViewControllerProvider extends AbstractAssistedProvider<ComposerHeaderViewController> {
    public final <DataProvider extends ProvidesMetaText & ProvidesTargetData & ProvidesMinutiae> ComposerHeaderViewController<DataProvider> m8367a(DataProvider dataProvider, ViewStub viewStub) {
        return new ComposerHeaderViewController(FbDraweeControllerBuilder.b(this), ResourcesMethodAutoProvider.a(this), (Context) getInstance(Context.class), User_LoggedInUserMethodAutoProvider.b(this), (ComposerDataProviderImpl) dataProvider, viewStub);
    }
}

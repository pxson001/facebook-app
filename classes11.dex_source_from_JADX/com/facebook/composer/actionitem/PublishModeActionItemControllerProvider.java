package com.facebook.composer.actionitem;

import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.ui.publishmode.PublishModeTitleGenerator;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsCustomPublishModeSupported;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesPublishScheduleTime;
import com.facebook.ipc.composer.model.PublishMode.ProvidesPublishMode;

/* compiled from: is_pma */
public class PublishModeActionItemControllerProvider extends AbstractAssistedProvider<PublishModeActionItemController> {
    public final <DataProvider extends ProvidesIsCustomPublishModeSupported & ProvidesPublishMode & ProvidesPublishScheduleTime> PublishModeActionItemController<DataProvider> m7346a(DataProvider dataProvider, ActionItemController$Delegate actionItemController$Delegate) {
        return new PublishModeActionItemController((ComposerDataProviderImpl) dataProvider, actionItemController$Delegate, ActionItemThumbnailHelper.m7343a(this), PublishModeTitleGenerator.b(this));
    }
}

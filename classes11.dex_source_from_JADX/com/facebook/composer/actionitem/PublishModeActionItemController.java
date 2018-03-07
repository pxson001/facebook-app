package com.facebook.composer.actionitem;

import com.facebook.composer.ui.publishmode.PublishModeTitleGenerator;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsCustomPublishModeSupported;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesPublishScheduleTime;
import com.facebook.ipc.composer.model.PublishMode.ProvidesPublishMode;
import javax.inject.Inject;

/* compiled from: is_requestable_fields_enabled */
public class PublishModeActionItemController<DataProvider extends ProvidesIsCustomPublishModeSupported & ProvidesPublishMode & ProvidesPublishScheduleTime> {
    public final DataProvider f5941a;
    public final ActionItemController$Delegate f5942b;
    public final ActionItemThumbnailHelper f5943c;
    public final PublishModeTitleGenerator f5944d;

    @Inject
    public PublishModeActionItemController(@Assisted DataProvider dataProvider, @Assisted ActionItemController$Delegate actionItemController$Delegate, ActionItemThumbnailHelper actionItemThumbnailHelper, PublishModeTitleGenerator publishModeTitleGenerator) {
        this.f5941a = dataProvider;
        this.f5942b = actionItemController$Delegate;
        this.f5943c = actionItemThumbnailHelper;
        this.f5944d = publishModeTitleGenerator;
    }

    public final boolean m7345c() {
        return this.f5941a.m7402C();
    }
}

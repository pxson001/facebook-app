package com.facebook.composer.actionitem;

import android.content.Context;
import com.facebook.composer.analytics.ComposerAnalyticsLogger;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.composer.event.ComposerEventHandler;
import com.facebook.composer.event.ComposerEventOriginator;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsCustomPublishModeSupported;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesPublishScheduleTime;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesSessionId;
import com.facebook.ipc.composer.model.PublishMode.ProvidesPublishMode;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.facebook.widget.recyclerview.ContentWrappingLinearLayoutManager;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: is_warm_launch */
public class ActionItemListController<DataProvider extends ProvidesIsCustomPublishModeSupported & ProvidesPublishScheduleTime & ProvidesSessionId & ProvidesPublishMode> implements ComposerEventHandler {
    public final Context f5929a;
    public final ImmutableList<ActionItemController> f5930b;
    public final ActionItemListAdapter f5931c;
    private final ComposerAnalyticsLogger f5932d;
    public ContentWrappingLinearLayoutManager f5933e;
    public BetterRecyclerView f5934f;

    @Inject
    public ActionItemListController(@Assisted DataProvider dataProvider, @Assisted ActionItemController$Delegate actionItemController$Delegate, PublishModeActionItemControllerProvider publishModeActionItemControllerProvider, Context context, ComposerAnalyticsLogger composerAnalyticsLogger) {
        this.f5929a = context;
        this.f5932d = composerAnalyticsLogger;
        Builder builder = ImmutableList.builder();
        builder.c(publishModeActionItemControllerProvider.m7346a(dataProvider, actionItemController$Delegate));
        this.f5930b = builder.b();
        this.f5931c = new ActionItemListAdapter(this.f5929a, this.f5932d, (ProvidesSessionId) dataProvider);
        m7341a();
    }

    public final void m7342a(ComposerEvent composerEvent, @Nullable ComposerEventOriginator composerEventOriginator) {
        if (composerEvent == ComposerEvent.ON_DATASET_CHANGE) {
            m7341a();
        }
    }

    private void m7341a() {
        Object obj;
        ImmutableList immutableList;
        ActionItemListAdapter actionItemListAdapter = this.f5931c;
        ImmutableList immutableList2 = this.f5931c.f5928d;
        int size = this.f5930b.size();
        for (int i = 0; i < size; i++) {
            PublishModeActionItemController publishModeActionItemController = (PublishModeActionItemController) this.f5930b.get(i);
            if (publishModeActionItemController.m7345c() != immutableList2.contains(publishModeActionItemController)) {
                obj = 1;
                break;
            }
        }
        obj = null;
        if (obj == null) {
            immutableList = immutableList2;
        } else {
            Builder builder = ImmutableList.builder();
            size = this.f5930b.size();
            for (int i2 = 0; i2 < size; i2++) {
                publishModeActionItemController = (PublishModeActionItemController) this.f5930b.get(i2);
                if (publishModeActionItemController.m7345c()) {
                    builder.c(publishModeActionItemController);
                }
            }
            immutableList = builder.b();
        }
        actionItemListAdapter.f5928d = immutableList;
        this.f5931c.notifyDataSetChanged();
    }
}

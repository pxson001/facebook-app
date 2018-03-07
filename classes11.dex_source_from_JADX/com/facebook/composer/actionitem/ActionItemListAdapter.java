package com.facebook.composer.actionitem;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.composer.analytics.ComposerAnalyticsEventBuilder;
import com.facebook.composer.analytics.ComposerAnalyticsLogger;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesSessionId;
import com.facebook.ipc.composer.model.PublishMode;
import com.facebook.ipc.composer.model.PublishMode.ProvidesPublishMode;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;

/* compiled from: italic */
public class ActionItemListAdapter<DataProvider extends ProvidesSessionId> extends Adapter<ActionItemViewHolder> {
    private final Context f5925a;
    public final ComposerAnalyticsLogger f5926b;
    public final DataProvider f5927c;
    public ImmutableList<ActionItemController> f5928d = RegularImmutableList.a;

    /* compiled from: italic */
    public class ActionItemViewHolder extends ViewHolder {
        final ContentView f5924l;

        public ActionItemViewHolder(ContentView contentView) {
            super(contentView);
            this.f5924l = contentView;
        }
    }

    /* compiled from: italic */
    public enum ViewType {
        STANDARD,
        PRIVACY
    }

    public final void m7340a(ViewHolder viewHolder, int i) {
        CharSequence a;
        ActionItemViewHolder actionItemViewHolder = (ActionItemViewHolder) viewHolder;
        final PublishModeActionItemController publishModeActionItemController = (PublishModeActionItemController) this.f5928d.get(i);
        actionItemViewHolder.f5924l.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ActionItemListAdapter f5923b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -718539804);
                publishModeActionItemController.f5942b.mo184a();
                ComposerAnalyticsLogger composerAnalyticsLogger = this.f5923b.f5926b;
                String ab = this.f5923b.f5927c.ab();
                PublishModeActionItemController publishModeActionItemController = publishModeActionItemController;
                ComposerAnalyticsEventBuilder h = new ComposerAnalyticsEventBuilder("composer_action_item_click").h(ab);
                h.a.b("action_item_type", "publish_mode");
                composerAnalyticsLogger.a.a(h.a);
                Logger.a(2, EntryType.UI_INPUT_END, -656962800, a);
            }
        });
        ContentView contentView = actionItemViewHolder.f5924l;
        contentView.setTitleText(2131234769);
        if (((ProvidesPublishMode) publishModeActionItemController.f5941a).j() == PublishMode.SCHEDULE_POST) {
            a = publishModeActionItemController.f5944d.a(publishModeActionItemController.f5941a.m7422Y().longValue());
        } else {
            a = publishModeActionItemController.f5944d.a(((ProvidesPublishMode) publishModeActionItemController.f5941a).j());
        }
        contentView.setSubtitleText(a);
        ActionItemThumbnailHelper actionItemThumbnailHelper = publishModeActionItemController.f5943c;
        if (!actionItemThumbnailHelper.f5938c) {
            actionItemThumbnailHelper.f5939d = actionItemThumbnailHelper.f5936a.getColor(2131362956);
            actionItemThumbnailHelper.f5940e = actionItemThumbnailHelper.f5936a.getColor(2131362957);
            actionItemThumbnailHelper.f5938c = true;
        }
        contentView.setThumbnailDrawable(actionItemThumbnailHelper.f5937b.a(2130838091, 1 != 0 ? actionItemThumbnailHelper.f5939d : actionItemThumbnailHelper.f5940e));
    }

    public ActionItemListAdapter(Context context, ComposerAnalyticsLogger composerAnalyticsLogger, DataProvider dataProvider) {
        this.f5925a = context;
        this.f5926b = composerAnalyticsLogger;
        this.f5927c = dataProvider;
    }

    public final ViewHolder m7339a(ViewGroup viewGroup, int i) {
        return new ActionItemViewHolder((ContentView) LayoutInflater.from(this.f5925a).inflate(2130903076, viewGroup, false));
    }

    public final int aZ_() {
        return this.f5928d.size();
    }

    public int getItemViewType(int i) {
        PublishModeActionItemController publishModeActionItemController = (PublishModeActionItemController) this.f5928d.get(i);
        return ViewType.STANDARD.ordinal();
    }
}

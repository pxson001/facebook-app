package com.facebook.feed.inlinecomposer.multirow.work;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.common.util.ContextUtils;
import com.facebook.feed.inlinecomposer.model.ComposerGroup;
import com.facebook.feed.inlinecomposer.work.WorkGroupPogView;
import com.facebook.feed.inlinecomposer.work.WorkHeaderGroupsActionHandler;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.intent.ComposerConfiguration.Builder;
import com.facebook.ipc.composer.intent.ComposerConfigurationFactory;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.model.ComposerSourceSurface;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.work.inlinecomposer.WorkComposerGroup;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: android.intent.extra.ringtone.PICKED_URI */
public class WorkGroupsPogRecyclerViewAdapter extends Adapter<ViewHolder> {
    private final ImmutableList<ComposerGroup> f19321a;
    private final String f19322b;
    private final int f19323c;
    private final int f19324d;
    private final InlineComposerHscrollRecyclerViewPartDefinition$2 f19325e;

    /* compiled from: android.intent.extra.ringtone.PICKED_URI */
    public class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder implements OnClickListener {
        private final InlineComposerHscrollRecyclerViewPartDefinition$2 f19319l;
        public WorkComposerGroup f19320m;

        public ViewHolder(View view, InlineComposerHscrollRecyclerViewPartDefinition$2 inlineComposerHscrollRecyclerViewPartDefinition$2) {
            super(view);
            this.f19319l = inlineComposerHscrollRecyclerViewPartDefinition$2;
            view.setOnClickListener(this);
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1071374436);
            InlineComposerHscrollRecyclerViewPartDefinition$2 inlineComposerHscrollRecyclerViewPartDefinition$2;
            if (this.f19320m != null) {
                inlineComposerHscrollRecyclerViewPartDefinition$2 = this.f19319l;
                Context context = view.getContext();
                WorkComposerGroup workComposerGroup = this.f19320m;
                WorkHeaderGroupsActionHandler workHeaderGroupsActionHandler = inlineComposerHscrollRecyclerViewPartDefinition$2.f19315a.f;
                if (workComposerGroup != null) {
                    Builder a2 = ComposerConfigurationFactory.a(ComposerSourceSurface.NEWSFEED, "workTopGroupsComposer");
                    ComposerTargetData.Builder builder = new ComposerTargetData.Builder(Long.parseLong(workComposerGroup.a), TargetType.GROUP);
                    builder.c = workComposerGroup.b;
                    workHeaderGroupsActionHandler.c.a(null, a2.setInitialTargetData(builder.a()).a(), 1756, (Activity) ContextUtils.a(context, Activity.class));
                }
            } else {
                inlineComposerHscrollRecyclerViewPartDefinition$2 = this.f19319l;
                inlineComposerHscrollRecyclerViewPartDefinition$2.f19315a.f.a(view.getContext());
            }
            LogUtils.a(-1790594053, a);
        }
    }

    public final void m22791a(android.support.v7.widget.RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        WorkGroupPogView workGroupPogView = (WorkGroupPogView) viewHolder2.a;
        if (getItemViewType(i) == 0) {
            WorkComposerGroup workComposerGroup = (WorkComposerGroup) this.f19321a.get(i);
            workGroupPogView.setName(workComposerGroup.b);
            workGroupPogView.setImage(workComposerGroup.c);
            workGroupPogView.setTextColor(this.f19323c);
            workGroupPogView.f19328c.setVisibility(8);
            viewHolder2.f19320m = workComposerGroup;
            return;
        }
        workGroupPogView.setName(this.f19322b);
        workGroupPogView.setImage(null);
        workGroupPogView.setTextColor(this.f19324d);
        workGroupPogView.f19328c.setVisibility(0);
        viewHolder2.f19320m = null;
    }

    @Inject
    public WorkGroupsPogRecyclerViewAdapter(@Assisted ImmutableList<ComposerGroup> immutableList, @Assisted ClickHandler clickHandler, Context context) {
        this.f19321a = immutableList;
        this.f19325e = clickHandler;
        this.f19322b = context.getString(2131235734);
        this.f19323c = ContextCompat.b(context, 2131361936);
        this.f19324d = ContextCompat.b(context, 2131363108);
    }

    public final android.support.v7.widget.RecyclerView.ViewHolder m22790a(ViewGroup viewGroup, int i) {
        return new ViewHolder(new WorkGroupPogView(viewGroup.getContext()), this.f19325e);
    }

    public final int aZ_() {
        if (this.f19321a.isEmpty()) {
            return 0;
        }
        return this.f19321a.size() + 1;
    }

    public int getItemViewType(int i) {
        return (i == aZ_() + -1 ? 1 : null) != null ? 1 : 0;
    }
}

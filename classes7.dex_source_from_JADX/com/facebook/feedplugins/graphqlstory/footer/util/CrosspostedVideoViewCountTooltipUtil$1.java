package com.facebook.feedplugins.graphqlstory.footer.util;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.base.Preconditions;

/* compiled from: Session expired */
class CrosspostedVideoViewCountTooltipUtil$1 implements OnClickListener {
    final /* synthetic */ GraphQLStoryAttachment f23328a;
    final /* synthetic */ CrosspostedVideoViewCountTooltipUtil f23329b;

    CrosspostedVideoViewCountTooltipUtil$1(CrosspostedVideoViewCountTooltipUtil crosspostedVideoViewCountTooltipUtil, GraphQLStoryAttachment graphQLStoryAttachment) {
        this.f23329b = crosspostedVideoViewCountTooltipUtil;
        this.f23328a = graphQLStoryAttachment;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 355117550);
        Context context = view.getContext();
        int bA = this.f23328a.r().bA();
        int bz = this.f23328a.r().bz();
        int aJ = this.f23328a.r().aJ();
        Preconditions.checkArgument(bA > 1);
        Tooltip tooltip = new Tooltip(context, 1);
        tooltip.a(Position.ABOVE);
        tooltip.a(context.getResources().getQuantityString(2131689551, bA, new Object[]{Integer.valueOf(bA)}));
        tooltip.b(CrosspostedVideoViewCountTooltipUtil.a(bz, aJ, bA - 1, context));
        tooltip.f(view);
        Logger.a(2, EntryType.UI_INPUT_END, -927510773, a);
    }
}

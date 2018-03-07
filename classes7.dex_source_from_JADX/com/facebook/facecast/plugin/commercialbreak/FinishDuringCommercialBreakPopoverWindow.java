package com.facebook.facecast.plugin.commercialbreak;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.facecast.FacecastStateManager.FacecastBroadcastState;
import com.facebook.facecast.plugin.FacecastRecordingAggregatePlugin.FinishDuringCommercialBreakPopoverCallback;
import com.facebook.facecast.plugin.commercialbreak.CommercialBreakBroadcastStateManager.CommercialBreakBroadcastState;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import javax.annotation.Nullable;

/* compiled from: bio_edit_click */
public class FinishDuringCommercialBreakPopoverWindow extends PopoverWindow {
    @Nullable
    public FinishDuringCommercialBreakPopoverCallback f18635a;

    /* compiled from: bio_edit_click */
    public class C16071 implements OnClickListener {
        final /* synthetic */ FinishDuringCommercialBreakPopoverWindow f18633a;

        public C16071(FinishDuringCommercialBreakPopoverWindow finishDuringCommercialBreakPopoverWindow) {
            this.f18633a = finishDuringCommercialBreakPopoverWindow;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1786113524);
            if (this.f18633a.f18635a != null) {
                FinishDuringCommercialBreakPopoverCallback finishDuringCommercialBreakPopoverCallback = this.f18633a.f18635a;
                if (finishDuringCommercialBreakPopoverCallback.f18476a.f18495r != null) {
                    finishDuringCommercialBreakPopoverCallback.f18476a.f18495r.l();
                }
                finishDuringCommercialBreakPopoverCallback.f18476a.f18166b.m21883b(FacecastBroadcastState.FACECAST_BROADCAST_STATE_ABOUT_TO_FINISH);
                finishDuringCommercialBreakPopoverCallback.f18476a.f18483f.m22185a(CommercialBreakBroadcastState.COMMERCIAL_BREAK_BROADCAST_FINISH);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1547864772, a);
        }
    }

    /* compiled from: bio_edit_click */
    public class C16082 implements OnClickListener {
        final /* synthetic */ FinishDuringCommercialBreakPopoverWindow f18634a;

        public C16082(FinishDuringCommercialBreakPopoverWindow finishDuringCommercialBreakPopoverWindow) {
            this.f18634a = finishDuringCommercialBreakPopoverWindow;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 535442166);
            if (this.f18634a.f18635a != null) {
                this.f18634a.f18635a.f18476a.f18483f.m22185a(CommercialBreakBroadcastState.COMMERCIAL_BREAK_BROADCAST_RESUME);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1856261873, a);
        }
    }

    public FinishDuringCommercialBreakPopoverWindow(Context context) {
        super(context);
        View inflate = LayoutInflater.from(getContext()).inflate(2130904376, null, false);
        d(inflate);
        inflate.findViewById(2131562078).setOnClickListener(new C16071(this));
        inflate.findViewById(2131562079).setOnClickListener(new C16082(this));
    }
}

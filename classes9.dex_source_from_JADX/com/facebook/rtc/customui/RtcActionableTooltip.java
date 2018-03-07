package com.facebook.rtc.customui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.user.model.UserKey;
import com.facebook.user.tiles.UserTileView;
import com.facebook.user.tiles.UserTileViewParams;

/* compiled from: audio/x-mpeg */
public class RtcActionableTooltip extends Tooltip {
    public OnActionClickListener f19314a;
    public View f19315l = this.g.findViewById(2131567191);
    public View f19316m = this.g.findViewById(2131567192);
    public UserTileView f19317n = ((UserTileView) this.g.findViewById(2131567190));
    public UserTileView f19318o = ((UserTileView) this.g.findViewById(2131567189));
    public long f19319p;
    public long f19320q;

    /* compiled from: audio/x-mpeg */
    public class C22881 implements OnClickListener {
        final /* synthetic */ RtcActionableTooltip f19312a;

        public C22881(RtcActionableTooltip rtcActionableTooltip) {
            this.f19312a = rtcActionableTooltip;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2130264070);
            if (this.f19312a.f19314a != null) {
                this.f19312a.f19314a.mo837a(view.getId());
            }
            Logger.a(2, EntryType.UI_INPUT_END, -989399252, a);
        }
    }

    /* compiled from: audio/x-mpeg */
    public class C22892 implements OnClickListener {
        final /* synthetic */ RtcActionableTooltip f19313a;

        public C22892(RtcActionableTooltip rtcActionableTooltip) {
            this.f19313a = rtcActionableTooltip;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -677579625);
            if (this.f19313a.f19314a != null) {
                this.f19313a.f19314a.mo837a(view.getId());
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1842545078, a);
        }
    }

    /* compiled from: audio/x-mpeg */
    public interface OnActionClickListener {
        void mo837a(int i);
    }

    public RtcActionableTooltip(Context context, int i, int i2, long j, long j2) {
        super(context, i, i2);
        this.f19319p = j;
        this.f19320q = j2;
        if (this.f19319p > 0 && this.f19318o != null) {
            this.f19318o.setParams(UserTileViewParams.a(UserKey.b(Long.toString(this.f19319p))));
        }
        if (this.f19320q > 0 && this.f19317n != null) {
            this.f19317n.setParams(UserTileViewParams.a(UserKey.b(Long.toString(this.f19320q))));
        }
        if (this.f19315l != null) {
            this.f19315l.setOnClickListener(new C22881(this));
        }
        if (this.f19316m != null) {
            this.f19316m.setOnClickListener(new C22892(this));
        }
    }
}

package com.facebook.rtc.fbwebrtc;

import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.rtc.models.RtcConferenceParticipantInfo;
import com.facebook.rtc.models.RtcConferenceParticipantInfo.ParticipantCallState;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserKey;
import com.facebook.user.tiles.UserTileView;
import com.facebook.user.tiles.UserTileViewParams;
import com.google.common.collect.ImmutableList;

/* compiled from: audio/mp3 */
public class VideoParticipantsAdapter extends Adapter<ViewHolder> {
    private ImmutableList<RtcConferenceParticipantInfo> f19375a;
    public RtcConferenceParticipantInfo f19376b;
    public boolean f19377c;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<WebrtcUiHandler> f19378d = UltralightRuntime.b;

    /* compiled from: audio/mp3 */
    public class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
        public final /* synthetic */ VideoParticipantsAdapter f19368l;
        public View f19369m;
        public UserTileView f19370n;
        public View f19371o;
        public View f19372p;
        public boolean f19373q;
        public RtcConferenceParticipantInfo f19374r;

        /* compiled from: audio/mp3 */
        public class C22971 implements OnClickListener {
            final /* synthetic */ RtcConferenceParticipantInfo f19366a;
            final /* synthetic */ ViewHolder f19367b;

            public C22971(ViewHolder viewHolder, RtcConferenceParticipantInfo rtcConferenceParticipantInfo) {
                this.f19367b = viewHolder;
                this.f19366a = rtcConferenceParticipantInfo;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 557031758);
                if (this.f19366a.f19840h) {
                    if (!StringUtil.a(this.f19366a.f19838f)) {
                        if (this.f19367b.f19368l.f19376b == null || !this.f19367b.f19368l.f19376b.f19834b.equals(this.f19366a.f19834b)) {
                            this.f19367b.f19368l.f19377c = true;
                        } else {
                            boolean z;
                            VideoParticipantsAdapter videoParticipantsAdapter = this.f19367b.f19368l;
                            if (this.f19367b.f19368l.f19377c) {
                                z = false;
                            } else {
                                z = true;
                            }
                            videoParticipantsAdapter.f19377c = z;
                        }
                        this.f19367b.f19368l.f19376b = this.f19366a;
                        this.f19367b.f19369m.setSelected(this.f19367b.f19368l.f19377c);
                        ((WebrtcUiHandler) this.f19367b.f19368l.f19378d.get()).m19459a(this.f19366a.f19834b, this.f19366a.f19838f, this.f19367b.f19368l.f19377c, true);
                    }
                    LogUtils.a(-439868499, a);
                    return;
                }
                Logger.a(2, EntryType.UI_INPUT_END, 134096740, a);
            }
        }

        public ViewHolder(VideoParticipantsAdapter videoParticipantsAdapter, View view) {
            this.f19368l = videoParticipantsAdapter;
            super(view);
            this.f19369m = view;
            this.f19370n = (UserTileView) view.findViewById(2131567145);
            this.f19371o = view.findViewById(2131567146);
            this.f19372p = view.findViewById(2131567147);
        }
    }

    public final void m19360a(android.support.v7.widget.RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        RtcConferenceParticipantInfo rtcConferenceParticipantInfo = (RtcConferenceParticipantInfo) this.f19375a.get(i);
        boolean z = true;
        viewHolder2.f19374r = rtcConferenceParticipantInfo;
        boolean z2 = viewHolder2.f19368l.f19376b != null && viewHolder2.f19374r.f19834b.contentEquals(viewHolder2.f19368l.f19376b.f19834b);
        viewHolder2.f19373q = z2;
        viewHolder2.f19370n.setParams(UserTileViewParams.a(new UserKey(Type.FACEBOOK, rtcConferenceParticipantInfo.f19834b)));
        if (viewHolder2.f19373q) {
            viewHolder2.f19371o.setVisibility(8);
        } else {
            viewHolder2.f19371o.setVisibility(0);
        }
        if (viewHolder2.f19374r.f19840h) {
            viewHolder2.f19372p.setVisibility(8);
        } else {
            viewHolder2.f19372p.setVisibility(0);
        }
        View view = viewHolder2.f19369m;
        if (!(viewHolder2.f19373q && viewHolder2.f19368l.f19377c)) {
            z = false;
        }
        view.setSelected(z);
        if (viewHolder2.f19374r.f19833a == ParticipantCallState.CONNECTED && viewHolder2.f19374r.f19840h) {
            viewHolder2.f19369m.setOnClickListener(new C22971(viewHolder2, rtcConferenceParticipantInfo));
        }
    }

    @Inject
    public VideoParticipantsAdapter(@Assisted ImmutableList<RtcConferenceParticipantInfo> immutableList) {
        this.f19375a = immutableList;
        a(true);
    }

    public final android.support.v7.widget.RecyclerView.ViewHolder m19358a(ViewGroup viewGroup, int i) {
        return new ViewHolder(this, LayoutInflater.from(viewGroup.getContext()).inflate(2130906912, viewGroup, false));
    }

    public final long H_(int i) {
        return (long) ((RtcConferenceParticipantInfo) this.f19375a.get(i)).f19834b.hashCode();
    }

    public final int aZ_() {
        return this.f19375a.size();
    }

    public final void m19361a(ImmutableList<RtcConferenceParticipantInfo> immutableList) {
        this.f19375a = immutableList;
        notifyDataSetChanged();
    }
}

package com.facebook.rtc.fbwebrtc.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.rtc.dialogs.WebrtcGroupDialogBuilder.GroupCallingListener;
import com.facebook.rtc.helpers.RtcCallButtonIconProvider;
import com.facebook.rtc.models.RtcCalleeInfo;
import com.facebook.rtcpresence.RtcPresenceHandler;
import com.facebook.rtcpresence.RtcPresenceState;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: application/x-x968-user-cert */
public class VoipGroupCallingListAdapter extends ArrayAdapter<RtcCalleeInfo> {
    public final RtcCallButtonIconProvider f19633a;
    public final Provider<Boolean> f19634b;
    public final GroupCallingListener f19635c;
    private final RtcPresenceHandler f19636d;

    @Inject
    public VoipGroupCallingListAdapter(Context context, RtcCallButtonIconProvider rtcCallButtonIconProvider, RtcPresenceHandler rtcPresenceHandler, Provider<Boolean> provider, @Assisted RtcGroupCallingAdapterListener rtcGroupCallingAdapterListener, @Assisted List<RtcCalleeInfo> list) {
        super(context, 0, list);
        this.f19633a = rtcCallButtonIconProvider;
        this.f19636d = rtcPresenceHandler;
        this.f19634b = provider;
        this.f19635c = rtcGroupCallingAdapterListener;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(2130907748, null);
        }
        final RtcCalleeInfo rtcCalleeInfo = (RtcCalleeInfo) getItem(i);
        if (rtcCalleeInfo != null) {
            ImageButton imageButton = (ImageButton) view.findViewById(2131568456);
            ImageButton imageButton2 = (ImageButton) view.findViewById(2131568455);
            ((TextView) view.findViewById(2131568454)).setText(rtcCalleeInfo.f19831a);
            RtcPresenceState a = this.f19636d.a(rtcCalleeInfo.f19832b);
            if (((Boolean) this.f19634b.get()).booleanValue()) {
                imageButton2.setImageDrawable(this.f19633a.m19543b(a));
            }
            imageButton.setImageDrawable(this.f19633a.m19540a(a));
            imageButton.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ VoipGroupCallingListAdapter f19630b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -1398730545);
                    GroupCallingListener groupCallingListener = this.f19630b.f19635c;
                    groupCallingListener.f19348c.f19350b.a(groupCallingListener.f19348c.f19349a, rtcCalleeInfo.f19832b, groupCallingListener.f19346a);
                    Logger.a(2, EntryType.UI_INPUT_END, -815888714, a);
                }
            });
            imageButton2.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ VoipGroupCallingListAdapter f19632b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -644740131);
                    GroupCallingListener groupCallingListener = this.f19632b.f19635c;
                    groupCallingListener.f19348c.f19350b.b(groupCallingListener.f19348c.f19349a, rtcCalleeInfo.f19832b, groupCallingListener.f19347b);
                    Logger.a(2, EntryType.UI_INPUT_END, 455838188, a);
                }
            });
        }
        return view;
    }
}

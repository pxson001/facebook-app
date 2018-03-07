package com.facebook.rtc.fbwebrtc.adapters;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.ResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.badges.BadgesExperimentController;
import com.facebook.messaging.dialog.MenuDialogFragment;
import com.facebook.messaging.dialog.MenuDialogFragment.Listener;
import com.facebook.messaging.dialog.MenuDialogItem;
import com.facebook.messaging.dialog.MenuDialogItemBuilder;
import com.facebook.messaging.dialog.MenuDialogParamsBuilder;
import com.facebook.messaging.util.launchtimeline.LaunchTimelineHelper;
import com.facebook.resources.ui.FbTextView;
import com.facebook.rtc.fbwebrtc.WebrtcUiHandler;
import com.facebook.rtc.interfaces.ContactFetcher;
import com.facebook.rtc.models.RtcConferenceParticipantInfo;
import com.facebook.rtc.models.RtcConferenceParticipantInfo.ParticipantCallState;
import com.facebook.rtc.views.RtcLevelTileView;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserKey;
import com.facebook.user.tiles.UserTileView;
import com.facebook.user.tiles.UserTileViewParams;
import com.facebook.widget.tiles.TileBadge;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;

/* compiled from: application/xml */
public class VoipConferenceRosterListAdapter extends ArrayAdapter<RosterListItem> {
    public static final Class f19615a = VoipConferenceRosterListAdapter.class;
    private static final List<ParticipantCallState> f19616n = Arrays.asList(new ParticipantCallState[]{ParticipantCallState.CONTACTING, ParticipantCallState.CONNECTED, ParticipantCallState.RINGING, ParticipantCallState.CONNECTING});
    private List<RtcConferenceParticipantInfo> f19617b = new ArrayList();
    private List<RtcConferenceParticipantInfo> f19618c = new ArrayList();
    public Map<String, Integer> f19619d = new HashMap();
    private LayoutInflater f19620e = LayoutInflater.from(getContext());
    private final ContactFetcher f19621f;
    private final ExecutorService f19622g;
    private final GatekeeperStoreImpl f19623h;
    public final LaunchTimelineHelper f19624i;
    public final FragmentManager f19625j;
    public final Listener f19626k;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<WebrtcUiHandler> f19627l = UltralightRuntime.b;
    @Inject
    public BadgesExperimentController f19628m;

    /* compiled from: application/xml */
    class C23091 implements Listener {
        final /* synthetic */ VoipConferenceRosterListAdapter f19596a;

        C23091(VoipConferenceRosterListAdapter voipConferenceRosterListAdapter) {
            this.f19596a = voipConferenceRosterListAdapter;
        }

        public final boolean m19494a(MenuDialogItem menuDialogItem, Object obj) {
            if (menuDialogItem.a != 1) {
                return false;
            }
            this.f19596a.f19624i.m18340a((UserKey) menuDialogItem.e, this.f19596a.f19625j);
            return true;
        }
    }

    /* compiled from: application/xml */
    class C23113 implements OnClickListener {
        final /* synthetic */ VoipConferenceRosterListAdapter f19599a;

        C23113(VoipConferenceRosterListAdapter voipConferenceRosterListAdapter) {
            this.f19599a = voipConferenceRosterListAdapter;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 398188550);
            ImageButton imageButton = (ImageButton) view;
            imageButton.setEnabled(false);
            imageButton.setAlpha(0.5f);
            Logger.a(2, EntryType.UI_INPUT_END, -1201275833, a);
        }
    }

    /* compiled from: application/xml */
    class C23124 implements OnClickListener {
        final /* synthetic */ VoipConferenceRosterListAdapter f19600a;

        C23124(VoipConferenceRosterListAdapter voipConferenceRosterListAdapter) {
            this.f19600a = voipConferenceRosterListAdapter;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -728369540);
            ImageButton imageButton = (ImageButton) view;
            imageButton.setEnabled(false);
            String str = (String) imageButton.getTag();
            WebrtcUiHandler webrtcUiHandler = (WebrtcUiHandler) this.f19600a.f19627l.get();
            String[] strArr = new String[]{str};
            if (webrtcUiHandler.ae == null) {
                BLog.a("WebrtcUiHandler", "Trying to invite participants to a null conference call object");
            } else if (strArr == null || strArr.length == 0) {
                BLog.a("WebrtcUiHandler", "Invalid invitees list");
            } else {
                webrtcUiHandler.ae.inviteParticipants(strArr);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1575438236, a);
        }
    }

    /* compiled from: application/xml */
    class C23135 implements OnLongClickListener {
        final /* synthetic */ VoipConferenceRosterListAdapter f19601a;

        C23135(VoipConferenceRosterListAdapter voipConferenceRosterListAdapter) {
            this.f19601a = voipConferenceRosterListAdapter;
        }

        public boolean onLongClick(View view) {
            ((RosterViewHolder) view.getTag()).f19614g.a(this.f19601a.f19625j, "roster_item_menu_dialog");
            return true;
        }
    }

    /* compiled from: application/xml */
    class DividerViewHolder {
        TextView f19604a;

        DividerViewHolder() {
        }
    }

    /* compiled from: application/xml */
    public enum ItemType {
        Participant,
        InCallHeader,
        NotInCallHeader
    }

    /* compiled from: application/xml */
    public class RosterListItem {
        public ItemType f19605a;
        public RtcConferenceParticipantInfo f19606b;
        final /* synthetic */ VoipConferenceRosterListAdapter f19607c;

        public RosterListItem(VoipConferenceRosterListAdapter voipConferenceRosterListAdapter, ItemType itemType, RtcConferenceParticipantInfo rtcConferenceParticipantInfo) {
            this.f19607c = voipConferenceRosterListAdapter;
            this.f19605a = itemType;
            this.f19606b = rtcConferenceParticipantInfo;
        }
    }

    /* compiled from: application/xml */
    class RosterViewHolder {
        UserTileView f19608a;
        RtcLevelTileView f19609b;
        FbTextView f19610c;
        FbTextView f19611d;
        ImageButton f19612e;
        ImageButton f19613f;
        MenuDialogFragment f19614g;

        RosterViewHolder() {
        }
    }

    @Inject
    public VoipConferenceRosterListAdapter(Context context, ContactFetcher contactFetcher, ExecutorService executorService, GatekeeperStore gatekeeperStore, LaunchTimelineHelper launchTimelineHelper, @Assisted ImmutableList<RtcConferenceParticipantInfo> immutableList, @Assisted FragmentManager fragmentManager) {
        super(context, 0, new ArrayList());
        this.f19621f = contactFetcher;
        this.f19622g = executorService;
        this.f19623h = gatekeeperStore;
        this.f19624i = launchTimelineHelper;
        this.f19625j = fragmentManager;
        this.f19626k = new C23091(this);
        m19498b(immutableList);
    }

    public final void m19501a() {
        m19499c();
    }

    private void m19499c() {
        for (int i = 0; i < getCount(); i++) {
            final RosterListItem rosterListItem = (RosterListItem) getItem(i);
            if (rosterListItem.f19605a == ItemType.Participant && StringUtil.a(rosterListItem.f19606b.f19835c)) {
                try {
                    ContactFetcher contactFetcher = this.f19621f;
                    Long.parseLong(rosterListItem.f19606b.f19834b);
                    Object a = contactFetcher.m19557a();
                    if (StringUtil.a(a)) {
                        contactFetcher = this.f19621f;
                        Long.parseLong(rosterListItem.f19606b.f19834b);
                        Futures.a(contactFetcher.m19558b(), new ResultFutureCallback<String>(this) {
                            final /* synthetic */ VoipConferenceRosterListAdapter f19598b;

                            protected final void m19495a(ServiceException serviceException) {
                                Class cls = VoipConferenceRosterListAdapter.f19615a;
                            }

                            public final void m19496a(Object obj) {
                                rosterListItem.f19606b.f19835c = (String) obj;
                                AdapterDetour.a(this.f19598b, -1003298885);
                            }
                        }, this.f19622g);
                    } else {
                        rosterListItem.f19606b.f19835c = a;
                    }
                } catch (Throwable e) {
                    BLog.b(f19615a, "Invalid user id", e);
                }
            }
        }
    }

    private void m19498b(ImmutableList<RtcConferenceParticipantInfo> immutableList) {
        this.f19617b.clear();
        this.f19618c.clear();
        clear();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            RtcConferenceParticipantInfo rtcConferenceParticipantInfo = (RtcConferenceParticipantInfo) immutableList.get(i);
            if (rtcConferenceParticipantInfo.f19833a == ParticipantCallState.CONNECTED) {
                this.f19617b.add(rtcConferenceParticipantInfo);
            } else {
                this.f19618c.add(rtcConferenceParticipantInfo);
            }
        }
        Collections.sort(this.f19617b);
        Collections.sort(this.f19618c);
        if (!this.f19617b.isEmpty()) {
            add(new RosterListItem(this, ItemType.InCallHeader, null));
        }
        for (RtcConferenceParticipantInfo rtcConferenceParticipantInfo2 : this.f19617b) {
            add(new RosterListItem(this, ItemType.Participant, rtcConferenceParticipantInfo2));
        }
        if (!this.f19618c.isEmpty()) {
            add(new RosterListItem(this, ItemType.NotInCallHeader, null));
        }
        for (RtcConferenceParticipantInfo rtcConferenceParticipantInfo22 : this.f19618c) {
            add(new RosterListItem(this, ItemType.Participant, rtcConferenceParticipantInfo22));
        }
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getItemViewType(int i) {
        return ((RosterListItem) getItem(i)).f19605a.ordinal();
    }

    public int getViewTypeCount() {
        return ItemType.values().length;
    }

    public final void m19502a(ImmutableList<RtcConferenceParticipantInfo> immutableList) {
        m19498b(immutableList);
        m19499c();
        AdapterDetour.a(this, 692237385);
    }

    @Nullable
    private String m19497a(ParticipantCallState participantCallState) {
        switch (participantCallState) {
            case CONNECTING:
                return getContext().getString(2131232004);
            case CONTACTING:
                return getContext().getString(2131232001);
            case CONNECTION_DROPPED:
                return getContext().getString(2131232006);
            case RINGING:
                return getContext().getString(2131232003);
            case UNREACHABLE:
                return getContext().getString(2131232007);
            case NO_ANSWER:
                return getContext().getString(2131232008);
            case REJECTED:
                return getContext().getString(2131232005);
            case PARTICIPANT_LIMIT_REACHED:
                return getContext().getString(2131232017);
            default:
                return null;
        }
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        RosterListItem rosterListItem = (RosterListItem) getItem(i);
        switch (rosterListItem.f19605a) {
            case Participant:
                RosterViewHolder rosterViewHolder;
                if (view == null) {
                    view = this.f19620e.inflate(2130907754, viewGroup, false);
                    RosterViewHolder rosterViewHolder2 = new RosterViewHolder();
                    rosterViewHolder2.f19608a = (UserTileView) view.findViewById(2131568463);
                    rosterViewHolder2.f19609b = (RtcLevelTileView) view.findViewById(2131568462);
                    rosterViewHolder2.f19610c = (FbTextView) view.findViewById(2131568464);
                    rosterViewHolder2.f19611d = (FbTextView) view.findViewById(2131564425);
                    rosterViewHolder2.f19612e = (ImageButton) view.findViewById(2131568466);
                    rosterViewHolder2.f19613f = (ImageButton) view.findViewById(2131568465);
                    view.setTag(rosterViewHolder2);
                    rosterViewHolder = rosterViewHolder2;
                } else {
                    rosterViewHolder = (RosterViewHolder) view.getTag();
                }
                String str = rosterListItem.f19606b.f19834b;
                MenuDialogParamsBuilder menuDialogParamsBuilder = new MenuDialogParamsBuilder();
                menuDialogParamsBuilder.b = "";
                MenuDialogItemBuilder menuDialogItemBuilder = new MenuDialogItemBuilder();
                menuDialogItemBuilder.a = 1;
                menuDialogItemBuilder = menuDialogItemBuilder;
                menuDialogItemBuilder.b = 2131231999;
                menuDialogItemBuilder = menuDialogItemBuilder;
                menuDialogItemBuilder.d = "roster_view_profile";
                menuDialogItemBuilder = menuDialogItemBuilder;
                menuDialogItemBuilder.e = UserKey.b(str);
                menuDialogParamsBuilder.a(menuDialogItemBuilder.f());
                MenuDialogFragment a = MenuDialogFragment.a(menuDialogParamsBuilder.e());
                a.an = this.f19626k;
                rosterViewHolder.f19614g = a;
                rosterViewHolder.f19610c.setText(rosterListItem.f19606b.f19835c);
                rosterViewHolder.f19608a.setParams(UserTileViewParams.a(new UserKey(Type.FACEBOOK, rosterListItem.f19606b.f19834b), this.f19628m.m8366a() ? TileBadge.NONE : TileBadge.MESSENGER));
                CharSequence a2 = m19497a(rosterListItem.f19606b.f19833a);
                if (StringUtil.a(a2)) {
                    rosterViewHolder.f19611d.setVisibility(8);
                } else {
                    rosterViewHolder.f19611d.setText(a2);
                    rosterViewHolder.f19611d.setVisibility(0);
                }
                rosterViewHolder.f19612e.setVisibility(8);
                rosterViewHolder.f19613f.setVisibility(8);
                if (rosterListItem.f19606b.f19833a == ParticipantCallState.CONNECTED) {
                    if (m19500d()) {
                        rosterViewHolder.f19612e.setVisibility(0);
                        rosterViewHolder.f19612e.setEnabled(rosterListItem.f19606b.f19841i);
                        rosterViewHolder.f19612e.setAlpha(rosterListItem.f19606b.f19841i ? 1.0f : 0.5f);
                        rosterViewHolder.f19612e.setTag(rosterListItem.f19606b.f19834b);
                        rosterViewHolder.f19612e.setOnClickListener(new C23113(this));
                    }
                } else if (!f19616n.contains(rosterListItem.f19606b.f19833a)) {
                    rosterViewHolder.f19613f.setVisibility(0);
                    rosterViewHolder.f19613f.setEnabled(true);
                    rosterViewHolder.f19613f.setTag(rosterListItem.f19606b.f19834b);
                    rosterViewHolder.f19613f.setOnClickListener(new C23124(this));
                }
                if (rosterListItem.f19606b.f19833a == ParticipantCallState.CONNECTED) {
                    rosterViewHolder.f19609b.setVisibility(0);
                    if (this.f19619d.containsKey(rosterListItem.f19606b.f19834b)) {
                        rosterViewHolder.f19609b.m19799a(((Integer) this.f19619d.get(rosterListItem.f19606b.f19834b)).intValue());
                    } else {
                        rosterViewHolder.f19609b.m19799a(0);
                    }
                } else {
                    rosterViewHolder.f19609b.setVisibility(8);
                }
                view.setOnLongClickListener(new C23135(this));
                break;
            case InCallHeader:
            case NotInCallHeader:
                DividerViewHolder dividerViewHolder;
                if (view == null) {
                    view = this.f19620e.inflate(2130907753, viewGroup, false);
                    DividerViewHolder dividerViewHolder2 = new DividerViewHolder();
                    dividerViewHolder2.f19604a = (FbTextView) view.findViewById(2131568460);
                    view.setTag(dividerViewHolder2);
                    dividerViewHolder = dividerViewHolder2;
                } else {
                    dividerViewHolder = (DividerViewHolder) view.getTag();
                }
                if (rosterListItem.f19605a != ItemType.InCallHeader) {
                    dividerViewHolder.f19604a.setText(2131231998);
                    break;
                }
                dividerViewHolder.f19604a.setText(2131231997);
                break;
        }
        return view;
    }

    private boolean m19500d() {
        return this.f19623h.a(1089, false);
    }
}

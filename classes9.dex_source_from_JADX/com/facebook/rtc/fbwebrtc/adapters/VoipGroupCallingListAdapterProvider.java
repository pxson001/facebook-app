package com.facebook.rtc.fbwebrtc.adapters;

import android.content.Context;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.rtc.fbwebrtc.adapters.VoipGroupCallingListAdapter.RtcGroupCallingAdapterListener;
import com.facebook.rtc.helpers.RtcCallButtonIconProvider;
import com.facebook.rtc.models.RtcCalleeInfo;
import com.facebook.rtcpresence.RtcPresenceHandler;
import java.util.List;

/* compiled from: application/x-x968-cross-cert */
public class VoipGroupCallingListAdapterProvider extends AbstractAssistedProvider<VoipGroupCallingListAdapter> {
    public final VoipGroupCallingListAdapter m19504a(RtcGroupCallingAdapterListener rtcGroupCallingAdapterListener, List<RtcCalleeInfo> list) {
        return new VoipGroupCallingListAdapter((Context) getInstance(Context.class), RtcCallButtonIconProvider.m19533b((InjectorLike) this), RtcPresenceHandler.b(this), IdBasedProvider.a(this, 4302), rtcGroupCallingAdapterListener, list);
    }
}

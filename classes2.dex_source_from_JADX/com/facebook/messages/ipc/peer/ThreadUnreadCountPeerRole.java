package com.facebook.messages.ipc.peer;

import android.net.Uri;
import android.os.Bundle;
import com.facebook.common.uri.UriTemplateMap;
import com.facebook.common.uri.UriTemplateMap.InvalidUriException;
import com.facebook.common.uri.UriTemplateMap.UriMatch;
import com.facebook.multiprocess.peer.state.PeerStateRole;
import com.facebook.multiprocess.peer.state.PeerStateRole.QueryStateResult;
import com.facebook.proxygen.HTTPTransportCallback;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: time_last_prompt_shown */
public class ThreadUnreadCountPeerRole extends PeerStateRole {
    private final Map<String, Set<String>> f2855b = Maps.m838c();
    private final UriTemplateMap<Integer> f2856c = new UriTemplateMap();

    public ThreadUnreadCountPeerRole(int i) {
        super(MessageNotificationPeerContract.f2849o, i);
        this.f2856c.m4859a("peer://msg_notification_unread_count/clear_thread/{thread_id}", Integer.valueOf(0));
        this.f2856c.m4859a("peer://msg_notification_unread_count/thread/{thread_id}", Integer.valueOf(1));
    }

    public final void mo679a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        for (Entry entry : this.f2855b.entrySet()) {
            bundle2.putStringArrayList((String) entry.getKey(), Lists.m1298a((Iterable) entry.getValue()));
        }
        bundle.putBundle(this.f2853b.getAuthority(), bundle2);
    }

    public final void mo681b(Bundle bundle) {
        this.f2855b.clear();
        Bundle bundle2 = bundle.getBundle(this.f2853b.getAuthority());
        for (String str : bundle2.keySet()) {
            this.f2855b.put(str, Sets.m1324b(bundle2.getStringArrayList(str)));
        }
    }

    public final void mo677a() {
        this.f2855b.clear();
    }

    public final boolean mo680a(Uri uri, @Nullable Object obj) {
        if (!MessageNotificationPeerContract.f2850p.equals(uri)) {
            try {
                UriMatch a = this.f2856c.m4858a(uri.toString());
                if (a == null) {
                    return false;
                }
                switch (((Integer) a.a).intValue()) {
                    case 0:
                        boolean z;
                        if (this.f2855b.remove(a.b.getString("thread_id")) != null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        return z;
                    case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                        String string = a.b.getString("thread_id");
                        String valueOf = String.valueOf(obj);
                        Set set = (Set) this.f2855b.get(string);
                        if (set == null) {
                            set = Sets.m1313a();
                            this.f2855b.put(string, set);
                        }
                        return set.add(valueOf);
                    default:
                        return false;
                }
            } catch (InvalidUriException e) {
                return false;
            }
        } else if (this.f2855b.isEmpty()) {
            return false;
        } else {
            this.f2855b.clear();
            return true;
        }
    }

    public final void mo678a(Uri uri, QueryStateResult queryStateResult) {
        try {
            UriMatch a = this.f2856c.m4858a(uri.toString());
            if (a != null && 1 == ((Integer) a.a).intValue()) {
                Set set = (Set) this.f2855b.get(a.b.getString("thread_id"));
                if (set != null) {
                    if (queryStateResult.a == null) {
                        queryStateResult.a = Sets.m1313a();
                    }
                    ((Set) queryStateResult.a).addAll(set);
                }
            }
        } catch (InvalidUriException e) {
        }
    }
}

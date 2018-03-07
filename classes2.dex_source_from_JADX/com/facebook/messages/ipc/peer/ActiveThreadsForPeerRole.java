package com.facebook.messages.ipc.peer;

import android.net.Uri;
import android.os.Bundle;
import com.facebook.common.uri.UriTemplateMap;
import com.facebook.common.uri.UriTemplateMap.InvalidUriException;
import com.facebook.common.uri.UriTemplateMap.UriMatch;
import com.facebook.debug.log.BLog;
import com.facebook.multiprocess.peer.state.PeerStateRole.QueryStateResult;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.List;
import java.util.Set;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: textlink_promote_instagram_friend_count_99 */
class ActiveThreadsForPeerRole {
    private final Uri f3079a;
    private final UriTemplateMap<String> f3080b;
    private final Set<String> f3081c = Sets.m1313a();
    private final String f3082d;

    ActiveThreadsForPeerRole(Uri uri, String str) {
        this.f3079a = uri;
        this.f3080b = new UriTemplateMap();
        this.f3080b.m4859a(str + "/{thread_id}", "THREAD");
        this.f3082d = Uri.parse(str).getPath();
    }

    final void m5068a(Bundle bundle) {
        bundle.putStringArrayList(this.f3082d, Lists.m1298a(this.f3081c));
    }

    final void m5071b(Bundle bundle) {
        this.f3081c.clear();
        List<String> stringArrayList = bundle.getStringArrayList(this.f3082d);
        if (stringArrayList == null) {
            BLog.b(ActiveThreadsForPeerRole.class, "%s should not be null in the bundle, it happened because some bad upgrade had happened.", new Object[]{this.f3082d});
            return;
        }
        for (String add : stringArrayList) {
            this.f3081c.add(add);
        }
    }

    final void m5066a() {
        this.f3081c.clear();
    }

    final boolean m5069a(Uri uri) {
        return this.f3079a.equals(uri) || m5065b(uri).isPresent();
    }

    final boolean m5070a(Uri uri, Object obj) {
        if (this.f3079a.equals(uri)) {
            this.f3081c.clear();
            return true;
        }
        Optional b = m5065b(uri);
        if (!b.isPresent()) {
            return false;
        }
        if (Boolean.TRUE.equals(obj)) {
            return this.f3081c.add(b.get());
        }
        return this.f3081c.remove(b.get());
    }

    final void m5067a(Uri uri, QueryStateResult queryStateResult) {
        Optional b = m5065b(uri);
        if (b.isPresent()) {
            queryStateResult.a = Boolean.valueOf(this.f3081c.contains(b.get()));
            if (Boolean.TRUE.equals(queryStateResult.a)) {
                queryStateResult.b = true;
            }
        }
    }

    private Optional<String> m5065b(Uri uri) {
        try {
            UriMatch a = this.f3080b.m4858a(uri.toString());
            if (a != null && "THREAD".equals(a.a)) {
                return Optional.of(a.b.getString("thread_id"));
            }
        } catch (InvalidUriException e) {
        }
        return Absent.withType();
    }
}

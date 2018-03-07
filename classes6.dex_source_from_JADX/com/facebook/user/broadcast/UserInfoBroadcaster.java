package com.facebook.user.broadcast;

import android.content.Intent;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.user.model.UserKey;
import java.util.ArrayList;
import javax.inject.Inject;

/* compiled from: copyAttachmentId */
public class UserInfoBroadcaster {
    public final BaseFbBroadcastManager f18455a;

    @Inject
    public UserInfoBroadcaster(BaseFbBroadcastManager baseFbBroadcastManager) {
        this.f18455a = baseFbBroadcastManager;
    }

    public final void m27074a(UserKey userKey) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(userKey);
        Intent intent = new Intent("com.facebook.orca.users.ACTION_USERS_UPDATED");
        intent.putParcelableArrayListExtra("updated_users", arrayList);
        this.f18455a.a(intent);
    }
}

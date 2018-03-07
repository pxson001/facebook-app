package com.facebook.messaging.photos.service;

import android.net.Uri;
import android.os.Parcelable;
import com.facebook.messaging.model.messages.Message;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.user.model.UserKey;
import javax.annotation.Nullable;

/* compiled from: dialog_id */
public interface MediaMessageItem extends Parcelable {
    void m16358a(Uri uri);

    void m16359a(boolean z);

    boolean m16360a();

    int m16361b();

    int m16362c();

    Uri m16363d();

    MediaResource m16364e();

    String m16365f();

    UserKey m16366g();

    @Nullable
    String m16367h();

    @Nullable
    Message m16368i();
}

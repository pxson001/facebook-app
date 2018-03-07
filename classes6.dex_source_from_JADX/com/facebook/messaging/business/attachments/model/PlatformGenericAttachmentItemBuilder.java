package com.facebook.messaging.business.attachments.model;

import android.net.Uri;
import com.facebook.messaging.business.common.calltoaction.model.CallToAction;
import com.google.common.base.Strings;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: view_count */
public class PlatformGenericAttachmentItemBuilder {
    public String f460a;
    public String f461b;
    @Nullable
    public String f462c;
    @Nullable
    public Uri f463d;
    @Nullable
    public String f464e;
    public int f465f;
    @Nullable
    public String f466g;
    @Nullable
    public String f467h;
    @Nullable
    public String f468i;
    @Nullable
    public String f469j;
    @Nullable
    public List<CallToAction> f470k;
    @Nullable
    public Uri f471l;
    @Nullable
    public Uri f472m;

    public final PlatformGenericAttachmentItemBuilder m391d(@Nullable String str) {
        this.f463d = !Strings.isNullOrEmpty(str) ? Uri.parse(str) : null;
        return this;
    }

    public final PlatformGenericAttachmentItemBuilder m392j(@Nullable String str) {
        this.f471l = !Strings.isNullOrEmpty(str) ? Uri.parse(str) : null;
        return this;
    }

    public final PlatformGenericAttachmentItem m393n() {
        return new PlatformGenericAttachmentItem(this);
    }
}

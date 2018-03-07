package com.facebook.messaging.business.commerce.model.retail;

import android.net.Uri;
import com.facebook.messaging.business.attachments.model.LogoImage;
import com.facebook.messaging.business.attachments.model.PlatformGenericAttachmentItem;
import com.google.common.base.Strings;
import java.util.List;

/* compiled from: video_transcode_success_count */
public class ReceiptBuilder {
    public String f595a;
    public String f596b;
    public String f597c;
    public String f598d;
    public Uri f599e;
    public Uri f600f;
    public RetailAddress f601g;
    public String f602h;
    public String f603i;
    public String f604j;
    public String f605k;
    public List<RetailAdjustment> f606l;
    public String f607m;
    public String f608n;
    public int f609o;
    public LogoImage f610p;
    public List<PlatformGenericAttachmentItem> f611q;
    public String f612r;
    public String f613s;
    public boolean f614t;

    public final ReceiptBuilder m692e(String str) {
        this.f599e = !Strings.isNullOrEmpty(str) ? Uri.parse(str) : null;
        return this;
    }

    public final ReceiptBuilder m693f(String str) {
        this.f600f = !Strings.isNullOrEmpty(str) ? Uri.parse(str) : null;
        return this;
    }

    public final Receipt m694u() {
        return new Receipt(this);
    }
}

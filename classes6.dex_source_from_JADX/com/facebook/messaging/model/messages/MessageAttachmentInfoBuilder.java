package com.facebook.messaging.model.messages;

import com.facebook.ui.media.attachments.MediaResource.Source;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import java.util.ArrayList;
import java.util.List;

/* compiled from: upload_speed_updated */
public class MessageAttachmentInfoBuilder {
    public Multimap<Type, Source> f2047a = ArrayListMultimap.t();
    public List<String> f2048b = new ArrayList();
    public long f2049c;
    public int f2050d;
    public int f2051e;
    public int f2052f;
    public int f2053g;
    public int f2054h;
    public int f2055i;
    public int f2056j;
    public int f2057k;

    public final void m3362a(long j) {
        if (this.f2049c == -1) {
            this.f2049c = j;
        } else {
            this.f2049c += j;
        }
    }

    public final void m3363a(String str) {
        this.f2048b.add(str);
    }

    public final MessageAttachmentInfo m3364s() {
        return new MessageAttachmentInfo(this);
    }
}

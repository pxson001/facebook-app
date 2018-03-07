package com.facebook.messaging.attachments;

import android.net.Uri;
import com.facebook.messaging.attachments.VideoAttachmentData.AttachmentType;
import com.facebook.messaging.model.attachment.VideoData.Source;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.video.engine.VideoDataSource;
import java.util.List;

/* compiled from: p2p_campaign_transfers */
public class VideoAttachmentDataBuilder {
    public AttachmentType f7777a;
    public int f7778b;
    public int f7779c;
    public int f7780d;
    public int f7781e;
    public int f7782f;
    public List<VideoDataSource> f7783g;
    public Uri f7784h;
    public Source f7785i;
    public String f7786j;
    public MediaResource f7787k;
    public int f7788l = 0;
    public int f7789m = -1;

    VideoAttachmentDataBuilder() {
    }

    public final VideoAttachmentData m8033n() {
        return new VideoAttachmentData(this);
    }
}

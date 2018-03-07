package com.facebook.videocodec.resizer;

import android.media.MediaFormat;
import com.facebook.videocodec.codecs.MediaBaseCodecBuffer;
import com.facebook.videocodec.policy.VideoTranscodeParams;

/* compiled from: resizeVideoOnCurrentThread */
interface VideoTranscoder {
    MediaBaseCodecBuffer mo377a(long j);

    void mo378a(MediaFormat mediaFormat);

    void mo379a(MediaBaseCodecBuffer mediaBaseCodecBuffer);

    void mo380a(VideoTranscodeParams videoTranscodeParams);

    boolean mo381a();

    void mo382b();

    void mo383b(long j);

    void mo384b(MediaBaseCodecBuffer mediaBaseCodecBuffer);

    MediaBaseCodecBuffer mo385c(long j);

    void mo386c();

    MediaFormat mo387d();

    int mo388e();
}

package com.facebook.crowdsourcing.picker;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.crowdsourcing.enums.SuggestEditsInputType;

/* compiled from: com.facebook.livephotos.exoplayer.extractor.wav.WavExtractor */
public interface SuggestEditsPicker<T> {
    Intent mo1362a(T t, Fragment fragment);

    SuggestEditsInputType mo1363a();

    T mo1364a(Intent intent, T t);
}

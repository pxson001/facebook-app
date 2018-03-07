package com.facebook.transliteration.algorithms.bigram;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.transliteration.datamanager.DataManagerUtil;

/* compiled from: extra_composer_life_event_model */
public class BigramAlgorithmProvider extends AbstractAssistedProvider<BigramAlgorithm> {
    public final BigramAlgorithm m19116a(int i) {
        return new BigramAlgorithm(DataManagerUtil.m19168b((InjectorLike) this), i);
    }
}

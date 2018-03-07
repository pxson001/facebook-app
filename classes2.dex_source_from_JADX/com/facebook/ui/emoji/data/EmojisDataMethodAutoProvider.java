package com.facebook.ui.emoji.data;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.emoji.model.EmojisData;

/* compiled from: include_read_likelihood */
public class EmojisDataMethodAutoProvider extends AbstractProvider<EmojisData> {
    public Object get() {
        return FacebookEmojisDataModule.m27895a();
    }

    public static FacebookEmojisData m27894a(InjectorLike injectorLike) {
        return FacebookEmojisDataModule.m27895a();
    }
}

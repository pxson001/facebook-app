package com.facebook.photos.pandora.common.ui.adapter;

import android.view.View;
import android.widget.BaseAdapter;
import com.google.common.collect.ImmutableList;

/* compiled from: com/facebook/video/chromecast/ */
public abstract class AbstractPandoraChildAdapter extends BaseAdapter {
    public abstract ImmutableList<? extends Class<? extends View>> mo1043a();

    public abstract Class<? extends View> mo1044a(int i);

    public final int getViewTypeCount() {
        throw new UnsupportedOperationException();
    }

    public final int getItemViewType(int i) {
        throw new UnsupportedOperationException();
    }
}

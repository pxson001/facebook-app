package com.facebook.photos.simplepicker.view;

import com.facebook.ipc.media.MediaItem;
import com.facebook.photos.simplepicker.controller.PickerGridItemType;
import javax.annotation.Nullable;

/* compiled from: setOnClickListener not allowed */
public interface SelectableView {
    void mo154a(int i, boolean z);

    void mo155e();

    boolean mo156f();

    int getId();

    int getIndex();

    PickerGridItemType getItemType();

    int getLayoutResourceId();

    @Nullable
    MediaItem getMediaItem();

    int getSelectedOrder();

    boolean isSelected();
}

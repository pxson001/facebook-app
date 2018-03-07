package com.facebook.photos.simplepicker.controller;

import com.facebook.ipc.media.SupportedMediaType;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.List;
import java.util.Map;

/* compiled from: shoppingCatalogID */
public class EnabledMediaTypeUtil {
    private static final Map<SupportedMediaType, List<PickerGridItemType>> f3010a = new Builder().b(SupportedMediaType.PHOTO_ONLY, ImmutableList.of(PickerGridItemType.PHOTO, PickerGridItemType.GIF, PickerGridItemType.LIVE_CAMERA)).b(SupportedMediaType.VIDEO_ONLY, ImmutableList.of(PickerGridItemType.VIDEO, PickerGridItemType.LIVE_CAMERA)).b(SupportedMediaType.ALL, ImmutableList.copyOf(PickerGridItemType.values())).b(SupportedMediaType.PHOTO_ONLY_EXCLUDING_GIFS, ImmutableList.of(PickerGridItemType.PHOTO, PickerGridItemType.LIVE_CAMERA)).b();

    public static boolean m3066a(SupportedMediaType supportedMediaType, PickerGridItemType pickerGridItemType) {
        return f3010a.containsKey(supportedMediaType) && ((List) f3010a.get(supportedMediaType)).contains(pickerGridItemType);
    }
}

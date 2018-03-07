package com.facebook.photos.simplepicker.view;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.photos.simplepicker.controller.PickerSelectionController;

/* compiled from: setPictureListener not supported by IAWebView */
public class GridItemViewOnTouchListenerProvider extends AbstractAssistedProvider<GridItemViewOnTouchListener> {
    public final GridItemViewOnTouchListener m3197a(PickerSelectionController pickerSelectionController, PickerLongPressProgressBar pickerLongPressProgressBar, SelectableView selectableView) {
        return new GridItemViewOnTouchListener(pickerSelectionController, pickerLongPressProgressBar, selectableView, IdBasedLazy.a(this, 3433));
    }
}

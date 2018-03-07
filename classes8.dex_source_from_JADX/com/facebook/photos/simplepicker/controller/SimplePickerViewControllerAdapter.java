package com.facebook.photos.simplepicker.controller;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import com.facebook.ipc.media.SupportedMediaType;
import com.facebook.photos.creativeediting.model.FrameGraphQLModels.FramePackModel;
import com.facebook.photos.simplepicker.SimplePickerFragment.C03828;
import com.facebook.photos.simplepicker.view.PickerLongPressProgressBar;
import com.google.common.base.Optional;

/* compiled from: show_password */
public interface SimplePickerViewControllerAdapter {
    int mo142a();

    View mo143a(int i);

    void mo144a(Cursor cursor, PickerSelectionController pickerSelectionController, Optional<PickerLongPressProgressBar> optional, boolean z);

    void mo145a(Bundle bundle);

    void mo146a(SupportedMediaType supportedMediaType);

    void mo147a(FramePackModel framePackModel);

    void mo148a(C03828 c03828);

    int mo149b();

    void mo150b(Bundle bundle);

    void mo151c();

    void mo152d();

    int mo153e();
}

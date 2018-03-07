package com.facebook.places.checkin.protocol;

import android.location.Location;
import com.facebook.places.checkin.ipc.CheckinComposerEntryPoint;
import com.facebook.places.checkin.ipc.SearchType;
import javax.annotation.Nullable;

/* compiled from: info_page_load_successful */
public class PlacePickerFetchParams {
    public String f11108a = "";
    @Nullable
    public Location f11109b;
    public SearchType f11110c = SearchType.STATUS;
    public boolean f11111d = false;
    @Nullable
    public String f11112e;
    @Nullable
    public String f11113f;
    public CheckinComposerEntryPoint f11114g = CheckinComposerEntryPoint.Other;

    public String toString() {
        return "[" + this.f11108a + "," + this.f11109b + "," + this.f11110c + "]";
    }
}

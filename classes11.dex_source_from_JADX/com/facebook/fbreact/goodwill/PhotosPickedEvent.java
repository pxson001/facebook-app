package com.facebook.fbreact.goodwill;

import com.facebook.fbreact.goodwill.GoodwillVideoState.PhotoData;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import java.util.ArrayList;

/* compiled from: extra_selected_album */
public class PhotosPickedEvent {
    private ArrayList<PhotoData> f7334a;

    public PhotosPickedEvent(ArrayList<PhotoData> arrayList) {
        this.f7334a = arrayList;
    }

    public final WritableArray m8524a() {
        WritableArray a = Arguments.a();
        int size = this.f7334a.size();
        for (int i = 0; i < size; i++) {
            PhotoData photoData = (PhotoData) this.f7334a.get(i);
            WritableMap b = Arguments.b();
            b.putString("id", photoData.f7326a);
            b.putString("uri", photoData.f7327b);
            b.putInt("width", photoData.f7328c);
            b.putInt("height", photoData.f7329d);
            a.a(b);
        }
        return a;
    }
}

package com.facebook.messaging.media.mediapicker.dialog;

import com.facebook.ipc.media.MediaItem;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.google.common.collect.ImmutableSet;
import java.util.ArrayList;
import java.util.Set;

/* compiled from: lower_estimate */
public class PickMediaDialogParamsBuilder {
    public PickMediaSource f11778a;
    public CropImageParams f11779b;
    public boolean f11780c;
    public Set<Type> f11781d = ImmutableSet.of(Type.PHOTO);
    public MediaResource f11782e;
    public boolean f11783f;
    public ArrayList<MediaItem> f11784g;
    public ThreadKey f11785h;
    public String f11786i;

    public final PickMediaDialogParams m12411j() {
        return new PickMediaDialogParams(this);
    }
}

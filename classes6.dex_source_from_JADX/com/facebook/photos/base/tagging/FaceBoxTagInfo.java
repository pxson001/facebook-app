package com.facebook.photos.base.tagging;

import android.graphics.Bitmap;
import com.facebook.tagging.model.TaggingProfile.Type;
import com.facebook.user.model.Name;
import javax.annotation.Nullable;

/* compiled from: initial_attachments */
public class FaceBoxTagInfo {
    public FaceBox f12781a;
    @Nullable
    public Tag f12782b;
    public String f12783c;
    public int f12784d;
    @Nullable
    public Bitmap f12785e;

    public final void m20175a(String str, long j) {
        if (j > 0) {
            int indexOf = str.indexOf(" ");
            boolean z = indexOf == -1;
            this.f12782b = new Tag(this.f12781a, new Name(z ? str : str.substring(0, indexOf), z ? "" : str.substring(indexOf + 1), str), j, Type.USER);
        } else {
            this.f12782b = new Tag(this.f12781a, new Name(str, "", str), j, Type.TEXT);
        }
        this.f12781a.f12770f = true;
    }
}

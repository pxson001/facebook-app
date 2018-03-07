package com.facebook.tagging.conversion;

import android.graphics.Bitmap;
import com.facebook.bitmaps.NativeImageProcessor;
import com.facebook.photos.base.tagging.FaceBoxTagInfo;
import com.facebook.widget.tokenizedtypeahead.model.BaseToken;

/* compiled from: maxWidth */
public class SuggestionToken extends BaseToken<FaceBoxTagInfo> {
    public FaceBoxTagInfo f9111e;
    public String f9112f;
    public long f9113g;
    private int f9114h;
    private final NativeImageProcessor f9115i;

    public final boolean m10893q() {
        return this.f9112f != null;
    }

    public final String m10885b() {
        return this.f9112f;
    }

    public final int m10887e() {
        return -1;
    }

    public final int m10888f() {
        return -1;
    }

    public final int m10889g() {
        return -1;
    }

    public final int m10890h() {
        return -1;
    }

    public final String m10891i() {
        return null;
    }

    public final Bitmap m10892j() {
        FaceBoxTagInfo faceBoxTagInfo = this.f9111e;
        int i = this.f9114h;
        NativeImageProcessor nativeImageProcessor = this.f9115i;
        if (faceBoxTagInfo.e == null) {
            faceBoxTagInfo.e = (Bitmap) nativeImageProcessor.a(faceBoxTagInfo.c, faceBoxTagInfo.d, faceBoxTagInfo.a.b, i).first;
        }
        return faceBoxTagInfo.e;
    }

    public final /* synthetic */ Object m10886d() {
        return this.f9111e;
    }
}

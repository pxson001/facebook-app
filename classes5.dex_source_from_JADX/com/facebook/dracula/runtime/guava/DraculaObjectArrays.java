package com.facebook.dracula.runtime.guava;

import com.facebook.annotationprocessors.transformer.api.Clone;
import com.facebook.annotationprocessors.transformer.api.Stub;
import com.facebook.dracula.api.DraculaReturnValue;
import com.facebook.dracula.api.FlatPlaceholder;
import com.facebook.dracula.runtime.base.DraculaArray;
import com.facebook.dracula.runtime.base.DraculaRuntime;
import com.facebook.flatbuffers.MutableFlatBuffer;

/* compiled from: rn_mobile_places_editor_review_module */
public final class DraculaObjectArrays {
    @Stub(processor = "com.facebook.dracula.transformer.Transformer", to = "EMPTY_ARRAY$")
    static final FlatPlaceholder[] f2946a = null;
    @Clone(from = "EMPTY_ARRAY", processor = "com.facebook.dracula.transformer.Transformer")
    static final DraculaArray f2947b = DraculaArray.m4066a(0);

    private DraculaObjectArrays() {
    }

    public static DraculaReturnValue m4115a(MutableFlatBuffer mutableFlatBuffer, int i, int i2, int i3) {
        if (!DraculaRuntime.m4076a(mutableFlatBuffer, i, null, 0)) {
            return DraculaReturnValue.m4065a(mutableFlatBuffer, i, i2);
        }
        throw new NullPointerException("at index " + i3);
    }
}

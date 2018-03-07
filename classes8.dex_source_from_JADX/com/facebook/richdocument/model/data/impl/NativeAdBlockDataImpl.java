package com.facebook.richdocument.model.data.impl;

import android.content.Context;
import com.facebook.graphql.enums.GraphQLDocumentElementType;
import com.facebook.richdocument.model.data.BlockData;
import com.facebook.richdocument.model.data.OGBlock;
import com.facebook.richdocument.model.data.PreloadableBlock;
import javax.annotation.Nullable;

/* compiled from: photo_picker_start_camera */
public class NativeAdBlockDataImpl extends BaseBlockData implements BlockData, OGBlock, PreloadableBlock {
    private final String f5740a;
    private boolean f5741b = true;

    public NativeAdBlockDataImpl(String str) {
        super(23);
        this.f5740a = str;
    }

    @Nullable
    public final String mo271l() {
        return this.f5740a;
    }

    public final GraphQLDocumentElementType iT_() {
        return GraphQLDocumentElementType.NATIVE_AD;
    }

    public final int mo284d() {
        return 10000;
    }

    public final boolean iU_() {
        return this.f5741b;
    }

    public final void mo283a(boolean z) {
        this.f5741b = z;
    }

    public final void mo282a(Context context) {
        this.f5741b = false;
    }
}

package com.facebook.richdocument.model.block.v2;

import android.os.Bundle;
import com.facebook.richdocument.model.data.BlockData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: picker_creativecam_impression */
public class RichDocumentBlocksImpl {
    public final String f5668a;
    public final Bundle f5669b = new Bundle();
    public final List<BlockData> f5670c = new ArrayList();

    public RichDocumentBlocksImpl(String str) {
        this.f5668a = str;
    }

    public final void m5458a(Collection<BlockData> collection) {
        if (collection != null) {
            this.f5670c.addAll(collection);
        }
    }

    public final BlockData m5457a(int i) {
        return (BlockData) this.f5670c.get(i);
    }

    public final int m5459c() {
        return this.f5670c.size();
    }
}

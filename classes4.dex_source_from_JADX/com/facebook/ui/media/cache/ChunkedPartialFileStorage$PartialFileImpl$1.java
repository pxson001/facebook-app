package com.facebook.ui.media.cache;

import com.facebook.common.iolite.FbFilterOutputStream;
import com.facebook.ui.media.cache.ChunkedPartialFileStorage.PartialFileImpl;
import java.io.File;
import java.io.OutputStream;

/* compiled from: pack_lists */
class ChunkedPartialFileStorage$PartialFileImpl$1 extends FbFilterOutputStream {
    final /* synthetic */ File f5558a;
    final /* synthetic */ PartialFileImpl f5559b;

    ChunkedPartialFileStorage$PartialFileImpl$1(PartialFileImpl partialFileImpl, OutputStream outputStream, File file) {
        this.f5559b = partialFileImpl;
        this.f5558a = file;
        super(outputStream);
    }

    public void close() {
        try {
            super.close();
        } finally {
            if (this.f5558a.length() == 0) {
                this.f5558a.delete();
            }
        }
    }
}

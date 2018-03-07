package com.facebook.analytics2.logger;

import com.facebook.analytics2.logger.UploadJobHandler.C01341;
import java.io.File;

/* compiled from: thirdPartyOwner */
class FileBatchPayloadIteratorFactory {
    FileBatchPayloadIteratorFactory() {
    }

    public static FileBatchPayloadIterator m2703a(File file, BatchDynamicMetadataHelper batchDynamicMetadataHelper, C01341 c01341) {
        return new FileBatchPayloadIterator(file, batchDynamicMetadataHelper, c01341, 20000);
    }
}

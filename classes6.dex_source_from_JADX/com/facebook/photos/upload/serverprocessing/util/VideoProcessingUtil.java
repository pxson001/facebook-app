package com.facebook.photos.upload.serverprocessing.util;

import com.facebook.composer.abtest.ExperimentsForComposerAbTestModule;
import com.facebook.qe.api.QeAccessor;
import com.facebook.video.creativeediting.abtest.ExperimentsForVideoCreativeEditingAbtestModule;

/* compiled from: fullName */
public class VideoProcessingUtil {
    public static boolean m21932a(QeAccessor qeAccessor) {
        return qeAccessor.a(ExperimentsForComposerAbTestModule.ac, false) || qeAccessor.a(ExperimentsForComposerAbTestModule.R, false) || qeAccessor.a(ExperimentsForVideoCreativeEditingAbtestModule.f18622f, false);
    }
}

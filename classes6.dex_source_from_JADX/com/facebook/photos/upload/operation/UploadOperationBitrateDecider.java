package com.facebook.photos.upload.operation;

import android.os.Bundle;
import com.facebook.composer.abtest.ExperimentsForComposerAbTestModule;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.video.creativeediting.abtest.ExperimentsForVideoCreativeEditingAbtestModule;
import com.facebook.video.creativeediting.model.VideoCreativeEditingData;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: global */
public class UploadOperationBitrateDecider {
    private final QeAccessor f13804a;
    private final Provider<Boolean> f13805b;

    public final int m21553a(@Nullable Bundle bundle) {
        Object obj;
        if (bundle == null) {
            obj = null;
        } else {
            bundle.setClassLoader(VideoCreativeEditingData.class.getClassLoader());
            VideoCreativeEditingData videoCreativeEditingData = (VideoCreativeEditingData) bundle.getParcelable("video_creative_editing_metadata");
            Object obj2 = null;
            if (videoCreativeEditingData != null) {
                int i;
                if (videoCreativeEditingData.m27386a() != null && videoCreativeEditingData.m27386a().isTrimSpecified) {
                    i = 1;
                } else if (videoCreativeEditingData.m27387b() != 0) {
                    i = 1;
                } else if (videoCreativeEditingData.m27390e() != null) {
                    i = 1;
                } else if (videoCreativeEditingData.m27388c()) {
                    i = 1;
                } else if (videoCreativeEditingData.m27391f() != null || videoCreativeEditingData.m27392g() != null) {
                    i = 1;
                } else if (videoCreativeEditingData.m27393h()) {
                    i = 1;
                }
            }
            obj = obj2;
        }
        if (obj == null || !this.f13804a.a(ExperimentsForVideoCreativeEditingAbtestModule.f18618b, false)) {
            return m21552a();
        }
        return this.f13804a.a(ExperimentsForVideoCreativeEditingAbtestModule.f18617a, -1);
    }

    public static UploadOperationBitrateDecider m21551b(InjectorLike injectorLike) {
        return new UploadOperationBitrateDecider((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 4255));
    }

    @Inject
    public UploadOperationBitrateDecider(QeAccessor qeAccessor, Provider<Boolean> provider) {
        this.f13804a = qeAccessor;
        this.f13805b = provider;
    }

    public final int m21552a() {
        if (((Boolean) this.f13805b.get()).booleanValue()) {
            return -2;
        }
        return this.f13804a.a(ExperimentsForComposerAbTestModule.W, false) ? this.f13804a.a(ExperimentsForComposerAbTestModule.ab, -1) : -1;
    }
}

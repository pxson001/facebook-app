package com.facebook.photos.upload.abtest;

import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

/* compiled from: node pack is missing */
public class AutoRetryPolicyController {
    private final QeAccessor f7066a;

    public static AutoRetryPolicyController m7358b(InjectorLike injectorLike) {
        return new AutoRetryPolicyController((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public AutoRetryPolicyController(QeAccessor qeAccessor) {
        this.f7066a = qeAccessor;
    }

    public AutoRetryPolicyController() {
        this.f7066a = null;
    }

    public final int m7359a() {
        return m7356a(ExperimentsForPhotosUploadModule.f, 100);
    }

    public final long m7360b() {
        return m7357a(ExperimentsForPhotosUploadModule.i, 720) * 60000;
    }

    public final int m7361c() {
        return m7356a(ExperimentsForPhotosUploadModule.g, 5);
    }

    public final int m7362d() {
        return m7356a(ExperimentsForPhotosUploadModule.h, 10);
    }

    public final float m7363e() {
        return m7355a(ExperimentsForPhotosUploadModule.a, 0.1f);
    }

    public final float m7364f() {
        return m7355a(ExperimentsForPhotosUploadModule.c, 0.2f);
    }

    public final float m7365g() {
        return m7355a(ExperimentsForPhotosUploadModule.d, 0.3f);
    }

    public final float m7366h() {
        return m7355a(ExperimentsForPhotosUploadModule.b, 0.5f);
    }

    public final long m7367i() {
        return m7357a(ExperimentsForPhotosUploadModule.k, 20) * 60000;
    }

    public final long m7368j() {
        return m7357a(ExperimentsForPhotosUploadModule.l, 15) * 60000;
    }

    public final long m7369k() {
        return m7357a(ExperimentsForPhotosUploadModule.j, 10) * 60000;
    }

    public final float m7370l() {
        return m7355a(ExperimentsForPhotosUploadModule.e, 1.0f);
    }

    private int m7356a(int i, int i2) {
        return this.f7066a == null ? i2 : this.f7066a.a(i, i2);
    }

    private long m7357a(long j, long j2) {
        return this.f7066a == null ? j2 : this.f7066a.a(j, j2);
    }

    private float m7355a(float f, float f2) {
        return this.f7066a == null ? f2 : this.f7066a.a(f, f2);
    }
}

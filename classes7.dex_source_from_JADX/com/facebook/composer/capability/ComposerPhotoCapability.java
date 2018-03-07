package com.facebook.composer.capability;

import com.facebook.composer.abtest.ExperimentsForComposerAbTestModule;
import com.facebook.composer.attachments.AttachmentUtils;
import com.facebook.composer.attachments.ComposerAttachment;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters$BooleanGetter;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.spherical.photo.abtest.Photos360QEHelper;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: cover_photo_source */
public class ComposerPhotoCapability {
    private static final ImmutableSet<TargetType> f16695a = ImmutableSet.of(TargetType.UNDIRECTED, TargetType.EVENT, TargetType.GROUP, TargetType.PAGE, TargetType.MARKETPLACE);
    private static final ImmutableSet<TargetType> f16696b = ImmutableSet.builder().b(f16695a).c(TargetType.USER).b();
    private final QeAccessor f16697c;
    private final Photos360QEHelper f16698d;

    /* compiled from: cover_photo_source */
    public enum Capability {
        ALLOW(true),
        ALLOW_SINGLE_PHOTO_ONLY(true),
        UNSUPPORTED(false);
        
        private final boolean mIsSupported;

        private Capability(boolean z) {
            this.mIsSupported = z;
        }

        public final boolean isSupported() {
            return this.mIsSupported;
        }
    }

    public static ComposerPhotoCapability m20730b(InjectorLike injectorLike) {
        return new ComposerPhotoCapability((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), Photos360QEHelper.a(injectorLike));
    }

    public static ComposerPhotoCapability m20728a(InjectorLike injectorLike) {
        return m20730b(injectorLike);
    }

    @Inject
    public ComposerPhotoCapability(QeAccessor qeAccessor, Photos360QEHelper photos360QEHelper) {
        this.f16697c = qeAccessor;
        this.f16698d = photos360QEHelper;
    }

    public final Capability m20731a(@Nullable ComposerPluginGetters$BooleanGetter composerPluginGetters$BooleanGetter, boolean z, TargetType targetType, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, ImmutableList<ComposerAttachment> immutableList) {
        if ((composerPluginGetters$BooleanGetter != null && !composerPluginGetters$BooleanGetter.mo1301a()) || z3 || !z4) {
            return Capability.UNSUPPORTED;
        }
        if (z) {
            return Capability.UNSUPPORTED;
        }
        if (AttachmentUtils.r(immutableList) && this.f16698d.i()) {
            return Capability.UNSUPPORTED;
        }
        if (z7) {
            return Capability.UNSUPPORTED;
        }
        if (z5 && TargetType.PAGE.equals(targetType)) {
            return Capability.UNSUPPORTED;
        }
        if (targetType == TargetType.PAGE && !z2) {
            return Capability.ALLOW_SINGLE_PHOTO_ONLY;
        }
        if (z5 && !z6) {
            return Capability.UNSUPPORTED;
        }
        if (z5 && !m20729a()) {
            return Capability.UNSUPPORTED;
        }
        return (this.f16697c.a(ExperimentsForComposerAbTestModule.r, false) ? f16696b : f16695a).contains(targetType) ? Capability.ALLOW : Capability.ALLOW_SINGLE_PHOTO_ONLY;
    }

    @VisibleForTesting
    private boolean m20729a() {
        return this.f16697c.a(Liveness.Live, ExperimentsForComposerAbTestModule.t, false);
    }
}

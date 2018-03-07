package com.facebook.composer.capability;

import com.facebook.common.util.TriState;
import com.facebook.composer.abtest.ExperimentsForComposerAbTestModule;
import com.facebook.composer.attachments.AttachmentUtils;
import com.facebook.composer.attachments.ComposerAttachment;
import com.facebook.composer.pagesintegration.CheckViewerPageAdminPagesUtil;
import com.facebook.composer.viewerpageadminutil.CheckViewerPageAdminUtil;
import com.facebook.graphql.enums.GraphQLPhotosAlbumAPIType;
import com.facebook.graphql.model.GraphQLAlbum;
import com.facebook.groups.photos.gk.IsInGroupsPhotoAlbumsGk;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.model.PublishMode;
import com.facebook.ipc.composer.model.RedSpaceValue;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters$BooleanGetter;
import com.facebook.qe.api.QeAccessor;
import com.facebook.spherical.photo.abtest.Photos360QEHelper;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: createUIManagerModule */
public class ComposerAlbumCapability {
    @IsInGroupsPhotoAlbumsGk
    private final Provider<TriState> f16684a;
    private final CheckViewerPageAdminUtil f16685b;
    private final Lazy<QeAccessor> f16686c;
    private final Photos360QEHelper f16687d;

    public static ComposerAlbumCapability m20711b(InjectorLike injectorLike) {
        return new ComposerAlbumCapability(IdBasedProvider.a(injectorLike, 689), (CheckViewerPageAdminUtil) CheckViewerPageAdminPagesUtil.b(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 3219), Photos360QEHelper.a(injectorLike));
    }

    @Inject
    public ComposerAlbumCapability(Provider<TriState> provider, CheckViewerPageAdminUtil checkViewerPageAdminUtil, Lazy<QeAccessor> lazy, Photos360QEHelper photos360QEHelper) {
        this.f16684a = provider;
        this.f16685b = checkViewerPageAdminUtil;
        this.f16686c = lazy;
        this.f16687d = photos360QEHelper;
    }

    public static ComposerAlbumCapability m20709a(InjectorLike injectorLike) {
        return m20711b(injectorLike);
    }

    public final boolean m20713a(@Nullable ComposerPluginGetters$BooleanGetter composerPluginGetters$BooleanGetter, TargetType targetType, String str, PublishMode publishMode, boolean z, boolean z2, ImmutableList<ComposerAttachment> immutableList, boolean z3, boolean z4, RedSpaceValue redSpaceValue, boolean z5, boolean z6) {
        if (composerPluginGetters$BooleanGetter != null && !composerPluginGetters$BooleanGetter.mo1301a()) {
            return false;
        }
        if (z) {
            return false;
        }
        if (AttachmentUtils.r(immutableList) && this.f16687d.i()) {
            return false;
        }
        boolean m = (AttachmentUtils.i(immutableList) && m20710a(targetType)) ? true : AttachmentUtils.m(immutableList);
        if (!m) {
            return false;
        }
        if (z2) {
            return false;
        }
        if (z3) {
            return false;
        }
        if (publishMode != PublishMode.NORMAL) {
            return false;
        }
        if (targetType != TargetType.UNDIRECTED && targetType != TargetType.PAGE && (targetType != TargetType.GROUP || this.f16684a.get() != TriState.YES)) {
            return false;
        }
        if (targetType == TargetType.PAGE && (!z4 || !this.f16685b.mo1355a(str))) {
            return false;
        }
        if (redSpaceValue == RedSpaceValue.POST_TO_REDSPACE) {
            return false;
        }
        if (!z5 || z6) {
            return true;
        }
        return false;
    }

    public final boolean m20712a(TargetType targetType, @Nullable GraphQLAlbum graphQLAlbum) {
        if (graphQLAlbum == null || graphQLAlbum.k() != GraphQLPhotosAlbumAPIType.SHARED) {
            return m20710a(targetType);
        }
        return false;
    }

    private boolean m20710a(TargetType targetType) {
        return targetType == TargetType.UNDIRECTED && ((QeAccessor) this.f16686c.get()).a(ExperimentsForComposerAbTestModule.N, false);
    }
}

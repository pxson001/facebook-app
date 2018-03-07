package com.facebook.platform.common.server;

import android.content.Context;
import com.facebook.common.file.MoreFileUtils;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.katana.platform.database.PendingMediaUploadsStorageImpl;
import com.facebook.katana.platform.handler.AddPendingMediaUploadAppCallOperation;
import com.facebook.katana.platform.handler.CopyPlatformAppContentToTempFileOperation;
import com.facebook.katana.platform.handler.GetPendingAppCallForMediaUploadOperation;
import com.facebook.messaging.platform.utilities.LinkShareMessageBatchOperation;
import com.facebook.messaging.platform.utilities.OpenGraphMessageBatchOperation;
import com.facebook.platform.auth.server.AuthorizeAppOperation;
import com.facebook.platform.auth.server.ExtendAccessTokenOperation;
import com.facebook.platform.common.util.PlatformTempFileManager;
import com.facebook.platform.database.PendingAppCallsStorageImpl;
import com.facebook.platform.database.PlatformDatabaseSupplier;
import com.facebook.platform.opengraph.OpenGraphRequestFactory;
import com.facebook.platform.opengraph.server.GetRobotextPreviewMethod;
import com.facebook.platform.opengraph.server.GetRobotextPreviewOperation;
import com.facebook.platform.opengraph.server.PublishOpenGraphActionMethod;
import com.facebook.platform.opengraph.server.PublishOpenGraphActionOperation;
import com.facebook.platform.opengraph.server.UploadStagingResourcePhotosOperation;
import com.facebook.platform.server.handler.GetAppNameOperation;
import com.facebook.platform.server.handler.GetAppPermissionsOperation;
import com.facebook.platform.server.handler.GetCanonicalProfileIdsOperation;
import com.facebook.platform.server.handler.ResolveTaggableProfileIdsOperation;
import com.facebook.platform.server.protocol.GetAppNameMethod;
import com.facebook.platform.webdialogs.PlatformWebDialogFetchOperation;
import com.facebook.platform.webdialogs.PlatformWebDialogsCache;
import com.facebook.platform.webdialogs.PlatformWebDialogsCacheCleanupOperation;
import com.facebook.platform.webdialogs.PlatformWebDialogsDownloader;
import com.facebook.platform.webdialogs.PlatformWebDialogsManifest;
import com.facebook.platform.webdialogs.PlatformWebDialogsManifestFetchOperation;
import com.facebook.platform.webdialogs.PlatformWebDialogsManifestLoadOperation;
import com.facebook.platform.webdialogs.PlatformWebDialogsManifestSaveOperation;
import com.facebook.share.protocol.LinksPreviewMethod;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: updateDeviceSyncOlderPhotosOnServer */
public final class STATICDI_MULTIBIND_PROVIDER$PlatformOperation implements MultiBindIndexedProvider<PlatformOperation>, Provider<Set<PlatformOperation>> {
    private final InjectorLike f11247a;

    public STATICDI_MULTIBIND_PROVIDER$PlatformOperation(InjectorLike injectorLike) {
        this.f11247a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f11247a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 20;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new AddPendingMediaUploadAppCallOperation(PendingMediaUploadsStorageImpl.m11670a((InjectorLike) injector), PendingAppCallsStorageImpl.m11684a((InjectorLike) injector), PlatformDatabaseSupplier.m11676a(injector));
            case 1:
                return new CopyPlatformAppContentToTempFileOperation((Context) injector.getInstance(Context.class), PlatformTempFileManager.m11691a((InjectorLike) injector), MoreFileUtils.a(injector));
            case 2:
                return new GetPendingAppCallForMediaUploadOperation(PendingMediaUploadsStorageImpl.m11670a((InjectorLike) injector), PendingAppCallsStorageImpl.m11684a((InjectorLike) injector), PlatformDatabaseSupplier.m11676a(injector));
            case 3:
                return new LinkShareMessageBatchOperation(ApiMethodRunnerImpl.a(injector), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(injector), LinksPreviewMethod.m11698b(injector));
            case 4:
                return new OpenGraphMessageBatchOperation(ApiMethodRunnerImpl.a(injector), OpenGraphRequestFactory.m11706a((InjectorLike) injector), PublishOpenGraphActionMethod.m11729a((InjectorLike) injector), GetAppNameMethod.m11732a((InjectorLike) injector), GetRobotextPreviewMethod.m11735b(injector), IdBasedProvider.a(injector, 3423));
            case 5:
                return AuthorizeAppOperation.m11738b(injector);
            case 6:
                return ExtendAccessTokenOperation.m11746b(injector);
            case 7:
                return new DeleteTempFilesForAppCallOperation(PlatformTempFileManager.m11691a((InjectorLike) injector));
            case 8:
                return new GetRobotextPreviewOperation(IdBasedSingletonScopeProvider.a(injector, 2289), GetRobotextPreviewMethod.m11735b(injector));
            case 9:
                return new PublishOpenGraphActionOperation(PublishOpenGraphActionMethod.m11729a((InjectorLike) injector), IdBasedSingletonScopeProvider.a(injector, 2289));
            case 10:
                return UploadStagingResourcePhotosOperation.m11755b(injector);
            case 11:
                return new GetAppNameOperation(IdBasedSingletonScopeProvider.a(injector, 2289), GetAppNameMethod.m11732a((InjectorLike) injector));
            case 12:
                return GetAppPermissionsOperation.m11761b(injector);
            case 13:
                return GetCanonicalProfileIdsOperation.m11766b(injector);
            case 14:
                return ResolveTaggableProfileIdsOperation.m11771b(injector);
            case 15:
                return new PlatformWebDialogFetchOperation(PlatformWebDialogsDownloader.m11778a((InjectorLike) injector), PlatformWebDialogsCache.m9392a((InjectorLike) injector));
            case 16:
                return new PlatformWebDialogsCacheCleanupOperation(PlatformWebDialogsCache.m9392a((InjectorLike) injector));
            case 17:
                return new PlatformWebDialogsManifestFetchOperation(PlatformWebDialogsDownloader.m11778a((InjectorLike) injector));
            case 18:
                return new PlatformWebDialogsManifestLoadOperation(PlatformWebDialogsManifest.m9372a((InjectorLike) injector));
            case 19:
                return new PlatformWebDialogsManifestSaveOperation(PlatformWebDialogsManifest.m9372a((InjectorLike) injector));
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}

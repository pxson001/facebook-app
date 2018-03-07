package com.facebook.photos.albums;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.widget.Toast;
import com.facebook.auth.module.ViewerContextMethodAutoProvider;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.FbAsyncTask;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ForegroundExecutorService;
import com.facebook.common.executors.ListeningExecutorService_ForegroundExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.references.CloseableReference;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLPhoto;
import com.facebook.graphql.model.GraphQLPhoto.Builder;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.memory.NativePooledByteBuffer;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.memory.PooledByteBufferInputStream;
import com.facebook.imagepipeline.module.ImagePipelineMethodAutoProvider;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.editgallery.CropMode;
import com.facebook.ipc.editgallery.EditFeature;
import com.facebook.ipc.editgallery.EditGalleryIntentCreator;
import com.facebook.ipc.editgallery.EditGalleryLaunchConfiguration;
import com.facebook.ipc.editgallery.EntryPoint;
import com.facebook.photos.base.photos.PhotoFetchInfo;
import com.facebook.photos.data.method.FetchPhotosMetadataParams;
import com.facebook.photos.data.method.FetchPhotosMetadataResult;
import com.facebook.photos.data.protocol.FetchBestAvailableImageUriQuery.FetchBestAvailableImageUriQueryString;
import com.facebook.photos.data.protocol.FetchBestAvailableImageUriQueryModels.FetchBestAvailableImageUriQueryModel;
import com.facebook.photos.futures.PhotosFuturesGenerator;
import com.facebook.photos.sharing.TempBinaryFileManager;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.runtimepermissions.AbstractRuntimePermissionsListener;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManagerProvider;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.stagingground.StagingGroundIntentFactory;
import com.facebook.timeline.stagingground.StagingGroundLaunchConfig;
import com.facebook.timeline.tempprofilepic.model.ExpirationState;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.dialogs.ProgressDialogFragment;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.collect.Lists;
import com.google.common.io.Closeables;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: magic_stories_kit_view */
public class ProfilePicCoverPhotoEditHelper {
    private static final CallerContext f9422a = CallerContext.a(ProfilePicCoverPhotoEditHelper.class, "set_cover_photo");
    public static final Class<?> f9423b = ProfilePicCoverPhotoEditHelper.class;
    public final TasksManager f9424c;
    private final SecureContextHelper f9425d;
    private final ImagePipeline f9426e;
    @ForUiThread
    private final Executor f9427f;
    @ForegroundExecutorService
    public final ExecutorService f9428g;
    private final PhotosFuturesGenerator f9429h;
    public final TempBinaryFileManager f9430i;
    private final ViewerContext f9431j;
    public final AbstractFbErrorReporter f9432k;
    public final Toaster f9433l;
    public final GraphQLQueryExecutor f9434m;
    private final ActivityRuntimePermissionsManagerProvider f9435n;
    private final QeAccessor f9436o;
    private final AllCapsTransformationMethod f9437p;

    /* compiled from: magic_stories_kit_view */
    public enum TaskId {
        FETCH_FACEBOOK_PHOTO,
        DOWNLOAD_COVER_PHOTO,
        BEST_AVAILABLE_IMAGE_URI_QUERY
    }

    public static ProfilePicCoverPhotoEditHelper m11388b(InjectorLike injectorLike) {
        return new ProfilePicCoverPhotoEditHelper(TasksManager.b(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), ImagePipelineMethodAutoProvider.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (ExecutorService) ListeningExecutorService_ForegroundExecutorServiceMethodAutoProvider.a(injectorLike), PhotosFuturesGenerator.m12388a(injectorLike), TempBinaryFileManager.m12905a(injectorLike), ViewerContextMethodAutoProvider.b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), Toaster.b(injectorLike), GraphQLQueryExecutor.a(injectorLike), (ActivityRuntimePermissionsManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ActivityRuntimePermissionsManagerProvider.class), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), AllCapsTransformationMethod.b(injectorLike));
    }

    @Inject
    public ProfilePicCoverPhotoEditHelper(TasksManager tasksManager, SecureContextHelper secureContextHelper, ImagePipeline imagePipeline, Executor executor, ExecutorService executorService, PhotosFuturesGenerator photosFuturesGenerator, TempBinaryFileManager tempBinaryFileManager, ViewerContext viewerContext, AbstractFbErrorReporter abstractFbErrorReporter, Toaster toaster, GraphQLQueryExecutor graphQLQueryExecutor, ActivityRuntimePermissionsManagerProvider activityRuntimePermissionsManagerProvider, QeAccessor qeAccessor, AllCapsTransformationMethod allCapsTransformationMethod) {
        this.f9424c = tasksManager;
        this.f9425d = secureContextHelper;
        this.f9426e = imagePipeline;
        this.f9427f = executor;
        this.f9428g = executorService;
        this.f9429h = photosFuturesGenerator;
        this.f9430i = tempBinaryFileManager;
        this.f9431j = viewerContext;
        this.f9432k = abstractFbErrorReporter;
        this.f9433l = toaster;
        this.f9434m = graphQLQueryExecutor;
        this.f9435n = activityRuntimePermissionsManagerProvider;
        this.f9436o = qeAccessor;
        this.f9437p = allCapsTransformationMethod;
    }

    public final void m11396a(long j, final FbFragment fbFragment, PhotoFetchInfo photoFetchInfo) {
        this.f9424c.a(TaskId.FETCH_FACEBOOK_PHOTO, m11382a(j, photoFetchInfo), new AbstractDisposableFutureCallback<OperationResult>(this) {
            final /* synthetic */ ProfilePicCoverPhotoEditHelper f9393b;

            protected final void m11364a(Object obj) {
                FetchPhotosMetadataResult fetchPhotosMetadataResult = (FetchPhotosMetadataResult) ((OperationResult) obj).h();
                if (fetchPhotosMetadataResult != null && fetchPhotosMetadataResult.a != null && !fetchPhotosMetadataResult.a.isEmpty()) {
                    this.f9393b.m11397a((GraphQLPhoto) fetchPhotosMetadataResult.a.get(0), fbFragment.o());
                }
            }

            protected final void m11365a(Throwable th) {
                BLog.b(ProfilePicCoverPhotoEditHelper.f9423b, "Failed to fetch FacebookPhoto by fbid");
            }
        });
    }

    public final void m11391a(long j, final Activity activity, PhotoFetchInfo photoFetchInfo) {
        this.f9424c.a(TaskId.FETCH_FACEBOOK_PHOTO, m11382a(j, photoFetchInfo), new AbstractDisposableFutureCallback<OperationResult>(this) {
            final /* synthetic */ ProfilePicCoverPhotoEditHelper f9395b;

            protected final void m11366a(Object obj) {
                FetchPhotosMetadataResult fetchPhotosMetadataResult = (FetchPhotosMetadataResult) ((OperationResult) obj).h();
                if (fetchPhotosMetadataResult != null && fetchPhotosMetadataResult.a != null && !fetchPhotosMetadataResult.a.isEmpty()) {
                    this.f9395b.m11397a((GraphQLPhoto) fetchPhotosMetadataResult.a.get(0), activity);
                }
            }

            protected final void m11367a(Throwable th) {
                BLog.b(ProfilePicCoverPhotoEditHelper.f9423b, "Failed to fetch FacebookPhoto by fbid");
            }
        });
    }

    public final void m11393a(long j, @Nullable Uri uri, final FbFragment fbFragment, PhotoFetchInfo photoFetchInfo, boolean z) {
        if (z) {
            String valueOf = String.valueOf(j);
            Builder builder = new Builder();
            builder.F = valueOf;
            builder = builder;
            if (uri != null) {
                GraphQLImage.Builder builder2 = new GraphQLImage.Builder();
                builder2.g = uri.toString();
                builder.G = builder2.a();
            }
            m11385a(builder.a(), fbFragment);
            return;
        }
        this.f9424c.a(TaskId.FETCH_FACEBOOK_PHOTO, m11382a(j, photoFetchInfo), new AbstractDisposableFutureCallback<OperationResult>(this) {
            final /* synthetic */ ProfilePicCoverPhotoEditHelper f9397b;

            protected final void m11368a(Object obj) {
                FetchPhotosMetadataResult fetchPhotosMetadataResult = (FetchPhotosMetadataResult) ((OperationResult) obj).h();
                if (fetchPhotosMetadataResult != null && fetchPhotosMetadataResult.a != null && !fetchPhotosMetadataResult.a.isEmpty()) {
                    GraphQLPhoto graphQLPhoto = (GraphQLPhoto) fetchPhotosMetadataResult.a.get(0);
                    ProfilePicCoverPhotoEditHelper profilePicCoverPhotoEditHelper = this.f9397b;
                    ProfilePicCoverPhotoEditHelper.m11385a(graphQLPhoto, fbFragment);
                }
            }

            protected final void m11369a(Throwable th) {
                BLog.b(ProfilePicCoverPhotoEditHelper.f9423b, "Failed to fetch FacebookPhoto by fbid");
            }
        });
    }

    public final void m11395a(long j, FbFragment fbFragment, long j2, PhotoFetchInfo photoFetchInfo) {
        if (fbFragment != null && fbFragment.hn_() && fbFragment.o() != null) {
            m11394a(j, fbFragment.o(), j2, photoFetchInfo);
        }
    }

    public final void m11394a(long j, final FragmentActivity fragmentActivity, final long j2, PhotoFetchInfo photoFetchInfo) {
        this.f9424c.a(TaskId.FETCH_FACEBOOK_PHOTO, m11382a(j, photoFetchInfo), new AbstractDisposableFutureCallback<OperationResult>(this) {
            final /* synthetic */ ProfilePicCoverPhotoEditHelper f9400c;

            protected final void m11370a(Object obj) {
                FetchPhotosMetadataResult fetchPhotosMetadataResult = (FetchPhotosMetadataResult) ((OperationResult) obj).h();
                if (fetchPhotosMetadataResult != null && fetchPhotosMetadataResult.a != null && !fetchPhotosMetadataResult.a.isEmpty()) {
                    this.f9400c.m11398a((GraphQLPhoto) fetchPhotosMetadataResult.a.get(0), fragmentActivity, j2);
                }
            }

            protected final void m11371a(Throwable th) {
                BLog.b(ProfilePicCoverPhotoEditHelper.f9423b, "Failed to fetch FacebookPhoto by fbid");
            }
        });
    }

    public final void m11390a() {
        this.f9424c.c();
    }

    public static void m11385a(GraphQLPhoto graphQLPhoto, FbFragment fbFragment) {
        Intent intent = new Intent();
        FlatBufferModelHelper.a(intent, "photo", graphQLPhoto);
        Activity ao = fbFragment.ao();
        if (ao != null) {
            ao.setResult(-1, intent);
            ao.finish();
        }
    }

    private final ListenableFuture<OperationResult> m11382a(long j, PhotoFetchInfo photoFetchInfo) {
        CallerContext callerContext;
        PhotosFuturesGenerator photosFuturesGenerator = this.f9429h;
        List a = Lists.a(new Long[]{Long.valueOf(j)});
        Bundle bundle = new Bundle();
        FetchPhotosMetadataParams fetchPhotosMetadataParams = new FetchPhotosMetadataParams(a, photoFetchInfo);
        bundle.putParcelable("fetchPhotosMetadataParams", fetchPhotosMetadataParams);
        DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory = photosFuturesGenerator.f10532a;
        String str = "fetch_photos_metadata";
        if (fetchPhotosMetadataParams.b == null) {
            callerContext = null;
        } else {
            callerContext = fetchPhotosMetadataParams.b.b;
        }
        return BlueServiceOperationFactoryDetour.a(defaultBlueServiceOperationFactory, str, bundle, callerContext, -186452635).a();
    }

    private static GraphQLImage m11381a(@Nullable GraphQLPhoto graphQLPhoto) {
        if (graphQLPhoto == null || graphQLPhoto.L() == null) {
            return null;
        }
        return graphQLPhoto.L();
    }

    public final void m11397a(GraphQLPhoto graphQLPhoto, final Activity activity) {
        GraphQLImage a = m11381a(graphQLPhoto);
        if (activity != null && graphQLPhoto != null && a != null) {
            if (a.a() < 180 || a.c() < 180) {
                this.f9432k.b(getClass().getName(), "First query's photo is too small to be profile picture");
                final String K = graphQLPhoto.K();
                graphQLPhoto.k();
                GraphQlQueryString fetchBestAvailableImageUriQueryString = new FetchBestAvailableImageUriQueryString();
                fetchBestAvailableImageUriQueryString.a("node", K);
                this.f9424c.a(TaskId.BEST_AVAILABLE_IMAGE_URI_QUERY, this.f9434m.a(GraphQLRequest.a(fetchBestAvailableImageUriQueryString).a(GraphQLCachePolicy.a).a(600)), new AbstractDisposableFutureCallback<GraphQLResult<FetchBestAvailableImageUriQueryModel>>(this) {
                    final /* synthetic */ ProfilePicCoverPhotoEditHelper f9421c;

                    protected final void m11379a(Object obj) {
                        GraphQLResult graphQLResult = (GraphQLResult) obj;
                        String j = ((FetchBestAvailableImageUriQueryModel) graphQLResult.e).a().j();
                        int a = ((FetchBestAvailableImageUriQueryModel) graphQLResult.e).a().a();
                        int k = ((FetchBestAvailableImageUriQueryModel) graphQLResult.e).a().k();
                        if (a < 180 || k < 180) {
                            this.f9421c.f9433l.b(new ToastBuilder(2131237819));
                            return;
                        }
                        this.f9421c.f9432k.b(getClass().getName(), "failed to fetch available image from server on first query");
                        ProfilePicCoverPhotoEditHelper.m11387a(this.f9421c, K, j, activity);
                    }

                    protected final void m11380a(Throwable th) {
                        this.f9421c.f9432k.b(getClass().getName(), "failed to fetch available image from server on fallback query", th);
                    }
                });
                return;
            }
            m11387a(this, graphQLPhoto.K(), a.b(), activity);
        }
    }

    public final void m11398a(GraphQLPhoto graphQLPhoto, FragmentActivity fragmentActivity, long j) {
        if (fragmentActivity != null && fragmentActivity.kO_() != null && graphQLPhoto != null) {
            final GraphQLPhoto graphQLPhoto2 = graphQLPhoto;
            final FragmentActivity fragmentActivity2 = fragmentActivity;
            final long j2 = j;
            this.f9435n.a(fragmentActivity).a(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, new AbstractRuntimePermissionsListener(this) {
                final /* synthetic */ ProfilePicCoverPhotoEditHelper f9404d;

                public final void m11372a() {
                    ProfilePicCoverPhotoEditHelper.m11389b(this.f9404d, graphQLPhoto2, fragmentActivity2, j2);
                }
            });
        }
    }

    public static void m11389b(ProfilePicCoverPhotoEditHelper profilePicCoverPhotoEditHelper, GraphQLPhoto graphQLPhoto, FragmentActivity fragmentActivity, long j) {
        FragmentManager kO_ = fragmentActivity.kO_();
        DialogFragment a = ProgressDialogFragment.a(2131234354, true, true);
        a.a(kO_.a(), "DownloadingCoverPhotoDialog", true);
        kO_.b();
        profilePicCoverPhotoEditHelper.m11383a(Long.parseLong(graphQLPhoto.K()), fragmentActivity, a, j, ImageUtil.a(m11381a(graphQLPhoto)));
    }

    private void m11383a(long j, FragmentActivity fragmentActivity, DialogFragment dialogFragment, long j2, Uri uri) {
        final ImageRequest a = ImageRequest.a(uri);
        final DialogFragment dialogFragment2 = dialogFragment;
        final FragmentActivity fragmentActivity2 = fragmentActivity;
        final long j3 = j;
        final long j4 = j2;
        this.f9426e.d(a, f9422a).a(new BaseDataSubscriber<CloseableReference<PooledByteBuffer>>(this) {
            final /* synthetic */ ProfilePicCoverPhotoEditHelper f9412f;

            protected final void m11374e(DataSource<CloseableReference<PooledByteBuffer>> dataSource) {
                if (dataSource.b()) {
                    final CloseableReference closeableReference = (CloseableReference) dataSource.d();
                    PooledByteBufferInputStream pooledByteBufferInputStream = new PooledByteBufferInputStream((NativePooledByteBuffer) closeableReference.a());
                    if (ImageFormatChecker.b(pooledByteBufferInputStream) == ImageFormat.JPEG) {
                        pooledByteBufferInputStream.reset();
                        C07681 c07681 = new FbAsyncTask<InputStream, Void, Uri>(this) {
                            final /* synthetic */ C07696 f9406b;

                            protected final Object m11373a(Object[] objArr) {
                                Object a;
                                InputStream inputStream = ((InputStream[]) objArr)[0];
                                try {
                                    a = this.f9406b.f9412f.f9430i.m12915a(inputStream);
                                } catch (IOException e) {
                                    return null;
                                } finally {
                                    Closeables.a(inputStream);
                                    CloseableReference.c(closeableReference);
                                }
                                return a;
                            }

                            protected void onPostExecute(Object obj) {
                                Uri uri = (Uri) obj;
                                dialogFragment2.b();
                                if (uri == null) {
                                    FragmentActivity fragmentActivity = fragmentActivity2;
                                    DialogFragment dialogFragment = dialogFragment2;
                                    Toast.makeText(fragmentActivity, 2131234392, 0).show();
                                    return;
                                }
                                this.f9406b.f9412f.m11392a(j3, uri, fragmentActivity2, j4);
                            }
                        };
                        if (VERSION.SDK_INT >= 11) {
                            c07681.executeOnExecutor(this.f9412f.f9428g, new InputStream[]{pooledByteBufferInputStream});
                            return;
                        }
                        c07681.execute(new InputStream[]{pooledByteBufferInputStream});
                        return;
                    }
                    Closeables.a(pooledByteBufferInputStream);
                    CloseableReference.c(closeableReference);
                    this.f9412f.m11384a(j3, fragmentActivity2, dialogFragment2, j4, a);
                }
            }

            protected final void m11375f(DataSource<CloseableReference<PooledByteBuffer>> dataSource) {
                FragmentActivity fragmentActivity = fragmentActivity2;
                DialogFragment dialogFragment = dialogFragment2;
                Toast.makeText(fragmentActivity, 2131234392, 0).show();
            }
        }, this.f9427f);
    }

    private void m11384a(long j, FragmentActivity fragmentActivity, DialogFragment dialogFragment, long j2, ImageRequest imageRequest) {
        final DialogFragment dialogFragment2 = dialogFragment;
        final FragmentActivity fragmentActivity2 = fragmentActivity;
        final long j3 = j;
        final long j4 = j2;
        this.f9426e.c(imageRequest, f9422a).a(new BaseDataSubscriber<CloseableReference<CloseableImage>>(this) {
            final /* synthetic */ ProfilePicCoverPhotoEditHelper f9418e;

            /* compiled from: magic_stories_kit_view */
            class C07701 extends FbAsyncTask<CloseableReference<CloseableImage>, Void, Uri> {
                final /* synthetic */ C07717 f9413a;

                C07701(C07717 c07717) {
                    this.f9413a = c07717;
                }

                protected final Object m11376a(Object[] objArr) {
                    CloseableReference[] closeableReferenceArr = (CloseableReference[]) objArr;
                    CloseableReference closeableReference = null;
                    try {
                        Bitmap a = ((CloseableBitmap) closeableReferenceArr[0].a()).a();
                        if (a.isRecycled()) {
                            this.f9413a.f9418e.f9432k.a(ProfilePicCoverPhotoEditHelper.f9423b.getName(), "Profile Pic cannot be saved because bitmap is recycled");
                            CloseableReference.c(closeableReferenceArr[0]);
                            return null;
                        }
                        Object a2 = this.f9413a.f9418e.f9430i.m12912a(a);
                        return a2;
                    } catch (IOException e) {
                        return closeableReference;
                    } finally {
                        closeableReference = closeableReferenceArr[0];
                        CloseableReference.c(closeableReference);
                    }
                }

                protected void onPostExecute(Object obj) {
                    Uri uri = (Uri) obj;
                    dialogFragment2.b();
                    if (uri == null) {
                        FragmentActivity fragmentActivity = fragmentActivity2;
                        DialogFragment dialogFragment = dialogFragment2;
                        Toast.makeText(fragmentActivity, 2131234392, 0).show();
                        return;
                    }
                    this.f9413a.f9418e.m11392a(j3, uri, fragmentActivity2, j4);
                }
            }

            protected final void m11377e(DataSource<CloseableReference<CloseableImage>> dataSource) {
                if (dataSource.b()) {
                    CloseableReference closeableReference = (CloseableReference) dataSource.d();
                    if (closeableReference == null || !(closeableReference.a() instanceof CloseableBitmap)) {
                        CloseableReference.c(closeableReference);
                        return;
                    }
                    C07701 c07701 = new C07701(this);
                    if (VERSION.SDK_INT >= 11) {
                        c07701.executeOnExecutor(this.f9418e.f9428g, new CloseableReference[]{closeableReference});
                        return;
                    }
                    c07701.execute(new CloseableReference[]{closeableReference});
                }
            }

            protected final void m11378f(DataSource<CloseableReference<CloseableImage>> dataSource) {
                FragmentActivity fragmentActivity = fragmentActivity2;
                DialogFragment dialogFragment = dialogFragment2;
                Toast.makeText(fragmentActivity, 2131234392, 0).show();
            }
        }, this.f9427f);
    }

    public final void m11392a(long j, @Nullable Uri uri, @Nullable Activity activity, long j2) {
        if (uri == null) {
            BLog.a(f9423b, "Image path from TempBinaryFileManager cannot be null.");
        } else if (activity != null) {
            Intent component = new Intent().setComponent(new ComponentName(activity, "com.facebook.timeline.coverphoto.activity.CoverPhotoRepositionActivity"));
            component.putExtra("cover_photo_uri", uri.getPath());
            component.putExtra("cover_photo_fbid", j);
            if (this.f9431j.mIsPageContext) {
                component.putExtra("com.facebook.orca.auth.OVERRIDDEN_VIEWER_CONTEXT", this.f9431j);
                component.putExtra("target_fragment", ContentFragmentType.PMA_COVERPHOTO_FRAGMENT.ordinal());
            } else {
                component.putExtra("target_fragment", ContentFragmentType.TIMELINE_COVERPHOTO_FRAGMENT.ordinal());
            }
            component.putExtra("profile_id", j2);
            this.f9425d.a(component, 9916, activity);
        }
    }

    public static void m11387a(ProfilePicCoverPhotoEditHelper profilePicCoverPhotoEditHelper, String str, String str2, Activity activity) {
        Intent a;
        EditGalleryLaunchConfiguration.Builder a2 = new EditGalleryLaunchConfiguration.Builder().a(Uri.parse(str2), str).a(EditFeature.CROP).a(CropMode.ZOOM_CROP);
        a2.f = true;
        a2 = a2;
        a2.h = false;
        a2 = a2;
        a2.i = profilePicCoverPhotoEditHelper.f9437p.getTransformation(activity.getString(2131234496), null).toString();
        a2 = a2;
        a2.k = ExpirationState.b;
        EditGalleryLaunchConfiguration a3 = a2.a();
        if (profilePicCoverPhotoEditHelper.f9436o.a(ExperimentsForTimelineAbTestModule.o, false)) {
            StagingGroundLaunchConfig.Builder a4 = new StagingGroundLaunchConfig.Builder().m18669a(Uri.parse(str2), str);
            a4.f14749d = EntryPoint.PROFILE.name();
            a4 = a4;
            a4.f14751f = 0;
            a4 = a4;
            a4.f14750e = a3.g;
            a4 = a4;
            a4.f14761p = false;
            a4 = a4;
            a4.f14763r = profilePicCoverPhotoEditHelper.f9436o.a(ExperimentsForTimelineAbTestModule.k, false);
            a4 = a4;
            a4.f14764s = profilePicCoverPhotoEditHelper.f9436o.a(ExperimentsForTimelineAbTestModule.l, false);
            a4 = a4;
            a4.f14765t = profilePicCoverPhotoEditHelper.f9436o.a(ExperimentsForTimelineAbTestModule.h, false);
            a = StagingGroundIntentFactory.m18666a((Context) activity, a4.m18670a(), a3);
        } else {
            a = EditGalleryIntentCreator.a(activity, EntryPoint.PROFILE.name(), a3);
        }
        profilePicCoverPhotoEditHelper.f9425d.a(a, 9915, activity);
    }
}

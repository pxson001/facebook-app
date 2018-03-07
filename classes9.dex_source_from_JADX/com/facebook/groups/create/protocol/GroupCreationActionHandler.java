package com.facebook.groups.create.protocol;

import android.net.Uri;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.debug.log.BLog;
import com.facebook.fbui.dialog.ProgressDialog;
import com.facebook.graphql.calls.GroupAddMemberInputData.Source;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.groups.create.GroupCreationProgressDialogFragment;
import com.facebook.groups.create.GroupCreationProgressDialogFragment.C06941;
import com.facebook.groups.create.GroupCreationProgressDialogFragment.GroupCreationProgress;
import com.facebook.groups.create.coverphoto.UploadGroupPhotoHandler;
import com.facebook.groups.create.protocol.SetAsCoverPhotoParams.Builder;
import com.facebook.groups.fb4a.create.FB4AGroupsCreateFragment;
import com.facebook.groups.fb4a.create.FB4AGroupsCreateFragment.C07061;
import com.facebook.groups.memberpicker.protocol.GroupAddMembersMutationModels.GroupAddMembersMutationModel;
import com.facebook.groups.memberpicker.protocol.MultipleMemberAdder;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.base.analytics.DefaultPhotoFlowLogger;
import com.facebook.photos.upload.uploaders.DirectPhotoUploader;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: payments_protected */
public class GroupCreationActionHandler {
    public static final Class f6831a = GroupCreationActionHandler.class;
    public ApiMethodRunnerImpl f6832b;
    public CreateGroupMethod f6833c;
    private ExecutorService f6834d;
    public ExecutorService f6835e;
    public MultipleMemberAdder f6836f;
    public SetAsCoverPhotoMethod f6837g;
    private UploadGroupPhotoHandler f6838h;

    public static GroupCreationActionHandler m7117b(InjectorLike injectorLike) {
        return new GroupCreationActionHandler(ApiMethodRunnerImpl.a(injectorLike), new CreateGroupMethod(), MultipleMemberAdder.b(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), new SetAsCoverPhotoMethod(), new UploadGroupPhotoHandler(DirectPhotoUploader.b(injectorLike), DefaultPhotoFlowLogger.b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike)), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public GroupCreationActionHandler(ApiMethodRunnerImpl apiMethodRunnerImpl, CreateGroupMethod createGroupMethod, MultipleMemberAdder multipleMemberAdder, ExecutorService executorService, SetAsCoverPhotoMethod setAsCoverPhotoMethod, UploadGroupPhotoHandler uploadGroupPhotoHandler, ExecutorService executorService2) {
        this.f6832b = apiMethodRunnerImpl;
        this.f6833c = createGroupMethod;
        this.f6838h = uploadGroupPhotoHandler;
        this.f6837g = setAsCoverPhotoMethod;
        this.f6836f = multipleMemberAdder;
        this.f6834d = executorService;
        this.f6835e = executorService2;
    }

    public static void m7114a(GroupCreationActionHandler groupCreationActionHandler, final GroupCreationProgress groupCreationProgress, final C07061 c07061) {
        ExecutorDetour.a(groupCreationActionHandler.f6835e, new Runnable(groupCreationActionHandler) {
            final /* synthetic */ GroupCreationActionHandler f6810c;

            public void run() {
                if (c07061 != null) {
                    C07061 c07061 = c07061;
                    GroupCreationProgress groupCreationProgress = groupCreationProgress;
                    FB4AGroupsCreateFragment fB4AGroupsCreateFragment = c07061.f6852a;
                    if (fB4AGroupsCreateFragment.az != null) {
                        int i;
                        GroupCreationProgressDialogFragment groupCreationProgressDialogFragment = fB4AGroupsCreateFragment.az;
                        switch (C06941.f6768a[groupCreationProgress.ordinal()]) {
                            case 1:
                                i = 2131239956;
                                break;
                            case 2:
                                i = 2131239958;
                                break;
                            case 3:
                                i = 2131239957;
                                break;
                            case 4:
                                i = 2131239959;
                                break;
                            case 5:
                                i = 2131238095;
                                break;
                            default:
                                i = 0;
                                break;
                        }
                        ProgressDialog progressDialog = (ProgressDialog) groupCreationProgressDialogFragment.f;
                        if (progressDialog != null && groupCreationProgressDialogFragment.o() != null) {
                            progressDialog.a(groupCreationProgressDialogFragment.jW_().getString(i));
                        }
                    }
                }
            }
        }, -547853915);
    }

    public final ListenableFuture<String> m7118a(CreateGroupParams createGroupParams, ImmutableList<String> immutableList, GroupCreationActionProgressListener groupCreationActionProgressListener, Uri uri) {
        final SettableFuture f = SettableFuture.f();
        final CreateGroupParams createGroupParams2 = createGroupParams;
        final C07061 c07061 = groupCreationActionProgressListener;
        final ImmutableList<String> immutableList2 = immutableList;
        final Uri uri2 = uri;
        ExecutorDetour.a(this.f6834d, new Runnable(this) {
            final /* synthetic */ GroupCreationActionHandler f6818f;

            public void run() {
                try {
                    final String str = (String) this.f6818f.f6832b.a(this.f6818f.f6833c, createGroupParams2);
                    GroupCreationActionHandler.m7114a(this.f6818f, GroupCreationProgress.INVITE_MEMBERS, c07061);
                    Futures.a(this.f6818f.f6836f.a(str, immutableList2, Source.MOBILE_CREATE_GROUP), new AbstractDisposableFutureCallback<GraphQLResult<GroupAddMembersMutationModel>>(this) {
                        final /* synthetic */ C07012 f6812b;

                        protected final void m7110a(Object obj) {
                            if (((GroupAddMembersMutationModel) ((GraphQLResult) obj).e).a().isEmpty()) {
                                f.a(new IllegalStateException("Create group failure: Couldn't invite any group members"));
                                return;
                            }
                            GroupCreationActionHandler.m7114a(this.f6812b.f6818f, GroupCreationProgress.UPLOADING_COVER_PHOTO, c07061);
                            this.f6812b.f6818f.m7119a(str, uri2, f, c07061, false);
                        }

                        protected final void m7111a(Throwable th) {
                            f.a(th);
                        }
                    }, this.f6818f.f6835e);
                } catch (Throwable e) {
                    f.a(e);
                }
            }
        }, 768711661);
        return f;
    }

    public final void m7119a(String str, Uri uri, SettableFuture<String> settableFuture, @Nullable GroupCreationActionProgressListener groupCreationActionProgressListener, boolean z) {
        final C07061 c07061 = groupCreationActionProgressListener;
        final String str2 = str;
        final SettableFuture<String> settableFuture2 = settableFuture;
        final boolean z2 = z;
        Futures.a(this.f6838h.m7096a(uri, str), new AbstractDisposableFutureCallback<String>(this) {
            final /* synthetic */ GroupCreationActionHandler f6823e;

            protected final void m7112a(Object obj) {
                String str = (String) obj;
                if (c07061 != null) {
                    GroupCreationActionHandler.m7114a(this.f6823e, GroupCreationProgress.SETTING_AS_COVER, c07061);
                }
                this.f6823e.m7116a(str, str2, settableFuture2, c07061, z2);
            }

            protected final void m7113a(Throwable th) {
                FutureDetour.a(settableFuture2, str2, 547674245);
            }
        }, this.f6834d);
    }

    private void m7116a(String str, String str2, SettableFuture<String> settableFuture, GroupCreationActionProgressListener groupCreationActionProgressListener, boolean z) {
        Builder builder = new Builder();
        builder.f6839a = str2;
        builder = builder;
        builder.f6840b = str;
        final SetAsCoverPhotoParams a = builder.m7122a();
        final boolean z2 = z;
        final C07061 c07061 = groupCreationActionProgressListener;
        final SettableFuture<String> settableFuture2 = settableFuture;
        final String str3 = str2;
        ExecutorDetour.a(this.f6834d, new Runnable(this) {
            final /* synthetic */ GroupCreationActionHandler f6830f;

            /* compiled from: payments_protected */
            class C07031 implements Runnable {
                final /* synthetic */ C07045 f6824a;

                C07031(C07045 c07045) {
                    this.f6824a = c07045;
                }

                public void run() {
                    if (z2 && c07061 != null) {
                        GroupCreationActionHandler.m7114a(this.f6824a.f6830f, GroupCreationProgress.COVER_PHOTO_UPDATED_SUCCESSFULLY, c07061);
                    }
                }
            }

            public void run() {
                try {
                    Boolean bool = (Boolean) this.f6830f.f6832b.a(this.f6830f.f6837g, a);
                    ExecutorDetour.a(this.f6830f.f6835e, new C07031(this), 29271857);
                    bool.booleanValue();
                } catch (Throwable th) {
                    BLog.b(GroupCreationActionHandler.f6831a, th.getMessage(), th);
                } finally {
                    FutureDetour.a(settableFuture2, str3, 1885081129);
                }
            }
        }, -1516052072);
    }
}

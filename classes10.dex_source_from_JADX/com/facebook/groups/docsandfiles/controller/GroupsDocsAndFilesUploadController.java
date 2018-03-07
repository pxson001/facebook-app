package com.facebook.groups.docsandfiles.controller;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.auth.datastore.LoggedInUserAuthDataStore;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.util.CollectionUtil;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.fbuploader.Config;
import com.facebook.fbuploader.Config.Namespace;
import com.facebook.fbuploader.Config.RetryPolicy;
import com.facebook.fbuploader.Content;
import com.facebook.fbuploader.FbUploaderImpl;
import com.facebook.fbuploader.FbUploaderImpl.FbUploadJobHandleImpl;
import com.facebook.fbuploader.Listener;
import com.facebook.fbuploader.UploadFailureException;
import com.facebook.fbuploader.UploadResult;
import com.facebook.fbuploader.fbcommon.FbUploaderSingletonWrapper;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.StoryCreateInputData;
import com.facebook.graphql.calls.StoryCreateInputData.Attachments;
import com.facebook.graphql.calls.StoryCreateInputData.Attachments.File.Files;
import com.facebook.graphql.calls.StoryCreateInputData.Audience;
import com.facebook.graphql.calls.StoryCreateInputData.Message;
import com.facebook.graphql.calls.StoryCreateInputData.Source;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.groups.docsandfiles.adapter.GroupDocsAndFilesAdapter;
import com.facebook.groups.docsandfiles.fragment.GroupDocOrFileListViewItem.FileModel;
import com.facebook.groups.docsandfiles.fragment.GroupDocOrFileListViewItem.FileState;
import com.facebook.groups.docsandfiles.fragment.GroupDocsAndFilesFragment.C30483;
import com.facebook.groups.docsandfiles.loader.GroupDocsAndFilesPagedListLoader;
import com.facebook.groups.docsandfiles.protocol.FileUploadingMutations.CreateFileMutationString;
import com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel;
import com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel;
import com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.ActorsModel;
import com.facebook.groups.docsandfiles.protocol.FileUploadingMutationsModels.CreateFileMutationModel.StoryModel.AttachmentsModel;
import com.facebook.groups.docsandfiles.protocol.GroupDocsAndFilesModels.GroupDocsAndFilesQueryModel.GroupDocsAndFilesModel.NodesModel;
import com.facebook.groups.docsandfiles.protocol.GroupDocsAndFilesModels.GroupDocsAndFilesQueryModel.GroupDocsAndFilesModel.NodesModel.OriginalPostModel;
import com.facebook.groups.docsandfiles.protocol.GroupDocsAndFilesModels.GroupDocsAndFilesQueryModel.GroupDocsAndFilesModel.NodesModel.OwnerModel;
import com.facebook.groups.docsandfiles.utils.FileUtils;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.ui.futures.TasksManager;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: Uploading */
public class GroupsDocsAndFilesUploadController {
    public final ExecutorService f21371a;
    private final Lazy<Resources> f21372b;
    public final TasksManager f21373c;
    public final Lazy<FbUploaderSingletonWrapper> f21374d;
    public final Boolean f21375e;
    public final ViewerContextManager f21376f;
    public final GraphQLQueryExecutor f21377g;
    public final Lazy<LoggedInUserAuthDataStore> f21378h;
    public final String f21379i;
    private final Context f21380j;
    public final C30483 f21381k;
    public final Map<String, UploadingFileItem> f21382l = new HashMap();
    public Listener f21383m;

    /* compiled from: Uploading */
    class C30351 extends AbstractDisposableFutureCallback<UploadingFileResult> {
        final /* synthetic */ GroupsDocsAndFilesUploadController f21354a;

        C30351(GroupsDocsAndFilesUploadController groupsDocsAndFilesUploadController) {
            this.f21354a = groupsDocsAndFilesUploadController;
        }

        protected final void m22322a(Object obj) {
            UploadingFileResult uploadingFileResult = (UploadingFileResult) obj;
            String str = uploadingFileResult.f21369a;
            this.f21354a.f21382l.remove(str);
            if (this.f21354a.f21381k != null) {
                C30483 c30483 = this.f21354a.f21381k;
                NodesModel nodesModel = uploadingFileResult.f21370b;
                c30483.f21418a.ap.m22315a(str, false);
                GroupDocsAndFilesPagedListLoader groupDocsAndFilesPagedListLoader = c30483.f21418a.aq;
                Builder builder = new Builder();
                builder.c(nodesModel);
                if (groupDocsAndFilesPagedListLoader.f21446e != null) {
                    builder.b(groupDocsAndFilesPagedListLoader.f21446e);
                }
                groupDocsAndFilesPagedListLoader.f21446e = builder.b();
                groupDocsAndFilesPagedListLoader.f21447f.m22350a(groupDocsAndFilesPagedListLoader.f21446e);
                groupDocsAndFilesPagedListLoader.f21447f.m22352b(false);
            }
        }

        protected final void m22323a(Throwable th) {
            if ((th instanceof FileUploadingException) && ((FileUploadingException) th).reason != UploadFailureReason.SEGMENT_UPLOADING_CANCELLATION) {
                String d = GroupsDocsAndFilesUploadController.m22337d(((FileUploadingException) th).file);
                GroupsDocsAndFilesUploadController groupsDocsAndFilesUploadController = this.f21354a;
                UploadFailureReason uploadFailureReason = ((FileUploadingException) th).reason;
                if (groupsDocsAndFilesUploadController.f21382l.get(d) != null) {
                    ((UploadingFileItem) groupsDocsAndFilesUploadController.f21382l.get(d)).f21366b = uploadFailureReason;
                }
                if (this.f21354a.f21381k != null) {
                    this.f21354a.f21381k.f21418a.ap.m22314a(d, FileState.UPLOADING_FAILED_SHOW_RETRY);
                }
            }
        }
    }

    /* compiled from: Uploading */
    class FileUploadingException extends Exception {
        public File file;
        public UploadFailureReason reason;

        public FileUploadingException(UploadFailureReason uploadFailureReason, File file) {
            this.reason = uploadFailureReason;
            this.file = file;
        }
    }

    /* compiled from: Uploading */
    class GroupUploadListener implements Listener {
        public final void m22326a() {
        }

        public final void m22327a(float f) {
        }

        public final void m22328a(UploadFailureException uploadFailureException) {
        }

        public final void m22330b() {
        }

        public final void m22329a(UploadResult uploadResult) {
        }
    }

    /* compiled from: Uploading */
    public enum Tasks {
        UPLOAD_GROUP_FILE_BODY,
        UPLOAD_GROUP_FILE_HANDLE
    }

    /* compiled from: Uploading */
    enum UploadFailureReason {
        SEGMENT_UPLOADING_FAILURE,
        SEGMENT_UPLOADING_CANCELLATION,
        FILE_HANDLE_UPLOADING_FAILURE
    }

    /* compiled from: Uploading */
    public class UploadingFileItem {
        public File f21365a;
        public UploadFailureReason f21366b;
        public String f21367c;
        public FbUploadJobHandleImpl f21368d;

        public UploadingFileItem(File file) {
            this.f21365a = file;
        }
    }

    /* compiled from: Uploading */
    class UploadingFileResult {
        public String f21369a;
        public NodesModel f21370b;

        public UploadingFileResult(NodesModel nodesModel, String str) {
            this.f21370b = nodesModel;
            this.f21369a = str;
        }
    }

    @Inject
    public GroupsDocsAndFilesUploadController(ExecutorService executorService, Lazy<Resources> lazy, TasksManager tasksManager, Lazy<FbUploaderSingletonWrapper> lazy2, ViewerContextManager viewerContextManager, Boolean bool, GraphQLQueryExecutor graphQLQueryExecutor, Lazy<LoggedInUserAuthDataStore> lazy3, @Assisted String str, @Assisted Context context, @Assisted GroupsDocsAndFilesUploadControllerListener groupsDocsAndFilesUploadControllerListener) {
        this.f21371a = executorService;
        this.f21372b = lazy;
        this.f21373c = tasksManager;
        this.f21374d = lazy2;
        this.f21375e = bool;
        this.f21376f = viewerContextManager;
        this.f21377g = graphQLQueryExecutor;
        this.f21378h = lazy3;
        this.f21379i = str;
        this.f21380j = context;
        this.f21381k = groupsDocsAndFilesUploadControllerListener;
    }

    public final void m22340a(File file) {
        if (!m22338e(file)) {
            String d = m22337d(file);
            if (this.f21381k != null) {
                C30483 c30483 = this.f21381k;
                String name = file.getName();
                NodesModel.Builder builder = new NodesModel.Builder();
                builder.f21470c = d;
                builder.f21471d = name;
                OwnerModel.Builder builder2 = new OwnerModel.Builder();
                builder2.f21480c = ((LoggedInUserSessionManager) this.f21378h.get()).c().k();
                builder.f21473f = builder2.m22464a();
                FileModel fileModel = new FileModel(builder.m22453a(), null != null ? FileState.UPLOADING_FAILED_SHOW_RETRY : FileState.UPLOADING_IS_IN_PROGRESS);
                GroupDocsAndFilesAdapter groupDocsAndFilesAdapter = c30483.f21418a.ap;
                groupDocsAndFilesAdapter.f21331e.put(d, fileModel);
                groupDocsAndFilesAdapter.f21327a.add(0, fileModel);
                groupDocsAndFilesAdapter.notifyDataSetChanged();
            }
            this.f21382l.put(d, new UploadingFileItem(file));
            m22335a(m22339f(file));
        }
    }

    public final void m22341b(String str) {
        UploadingFileItem uploadingFileItem = (UploadingFileItem) this.f21382l.get(str);
        if (uploadingFileItem != null) {
            if (uploadingFileItem.f21366b == UploadFailureReason.SEGMENT_UPLOADING_FAILURE || uploadingFileItem.f21367c == null) {
                m22335a(m22339f(uploadingFileItem.f21365a));
                return;
            }
            final File file = uploadingFileItem.f21365a;
            final String str2 = uploadingFileItem.f21367c;
            final SettableFuture f = SettableFuture.f();
            ExecutorDetour.a(this.f21371a, new Runnable(this) {
                final /* synthetic */ GroupsDocsAndFilesUploadController f21361d;

                public void run() {
                    GroupsDocsAndFilesUploadController.m22333a(this.f21361d, file, str2, f);
                }
            }, -1475592200);
            m22335a((ListenableFuture) f);
        }
    }

    public static String m22337d(File file) {
        return String.valueOf(file.hashCode());
    }

    private boolean m22338e(File file) {
        if (file.length() > 26214400) {
            m22332a(2131242072, 2131242071, 17039370);
            return true;
        } else if (this.f21382l.containsKey(m22337d(file))) {
            m22332a(2131242074, 2131242073, 17039370);
            return true;
        } else {
            Object obj;
            String a = FileUtils.m22521a(file.getName());
            if (".exe".equalsIgnoreCase(a) || ".mp3".equalsIgnoreCase(a)) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null) {
                return false;
            }
            m22332a(2131242076, 2131242075, 17039370);
            return true;
        }
    }

    private void m22332a(int i, int i2, int i3) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f21380j);
        builder.a(((Resources) this.f21372b.get()).getString(i));
        builder.b(((Resources) this.f21372b.get()).getString(i2));
        builder.a(((Resources) this.f21372b.get()).getString(i3), null);
        builder.a().show();
    }

    private void m22335a(ListenableFuture<UploadingFileResult> listenableFuture) {
        this.f21373c.c(Tasks.UPLOAD_GROUP_FILE_BODY, listenableFuture, new C30351(this));
    }

    private ListenableFuture<UploadingFileResult> m22339f(final File file) {
        final SettableFuture f = SettableFuture.f();
        ExecutorDetour.a(this.f21371a, new Runnable(this) {
            final /* synthetic */ GroupsDocsAndFilesUploadController f21357c;

            public void run() {
                String a = FileUtils.m22520a(file);
                FbUploaderImpl a2 = ((FbUploaderSingletonWrapper) this.f21357c.f21374d.get()).a();
                Content content = new Content(file, a);
                Config config = new Config(Namespace.GROUPS, new HashMap(), new RetryPolicy());
                if (this.f21357c.f21383m == null) {
                    this.f21357c.f21383m = new GroupUploadListener();
                }
                try {
                    String d = GroupsDocsAndFilesUploadController.m22337d(file);
                    FbUploadJobHandleImpl a3 = a2.a(content, config, this.f21357c.f21383m);
                    GroupsDocsAndFilesUploadController.m22334a(this.f21357c, d, a3);
                    String str = a2.b(a3).a;
                    GroupsDocsAndFilesUploadController.m22334a(this.f21357c, d, null);
                    GroupsDocsAndFilesUploadController.m22333a(this.f21357c, file, str, f);
                } catch (UploadFailureException e) {
                    f.a(new FileUploadingException(e.mIsCancellation ? UploadFailureReason.SEGMENT_UPLOADING_CANCELLATION : UploadFailureReason.SEGMENT_UPLOADING_FAILURE, file));
                }
            }
        }, -761234089);
        return f;
    }

    public static void m22333a(GroupsDocsAndFilesUploadController groupsDocsAndFilesUploadController, final File file, String str, final SettableFuture settableFuture) {
        String d = m22337d(file);
        if (groupsDocsAndFilesUploadController.f21382l.get(d) != null) {
            ((UploadingFileItem) groupsDocsAndFilesUploadController.f21382l.get(d)).f21367c = str;
        }
        StoryCreateInputData storyCreateInputData = new StoryCreateInputData();
        Enum enumR = groupsDocsAndFilesUploadController.f21375e.booleanValue() ? Source.TABLET : Source.MOBILE;
        List arrayList = new ArrayList();
        Files files = new Files();
        files.a("name", file.getName());
        GraphQlCallInput graphQlCallInput = files;
        graphQlCallInput.a("url", str);
        arrayList.add(graphQlCallInput);
        Attachments.File file2 = new Attachments.File();
        file2.a("files", arrayList);
        GraphQlCallInput graphQlCallInput2 = file2;
        storyCreateInputData.a("source", enumR);
        GraphQlCallInput graphQlCallInput3 = storyCreateInputData;
        graphQlCallInput3.a("actor_id", groupsDocsAndFilesUploadController.f21376f.d().mUserId);
        graphQlCallInput3 = graphQlCallInput3;
        Audience audience = new Audience();
        audience.a("to_id", groupsDocsAndFilesUploadController.f21379i);
        graphQlCallInput3.a("audience", audience);
        graphQlCallInput3 = graphQlCallInput3;
        Message message = new Message();
        message.a("text", "");
        graphQlCallInput3.a("message", message);
        graphQlCallInput3 = graphQlCallInput3;
        Attachments[] attachmentsArr = new Attachments[1];
        Attachments attachments = new Attachments();
        attachments.a("file", graphQlCallInput2);
        attachmentsArr[0] = attachments;
        graphQlCallInput3.a("attachments", Arrays.asList(attachmentsArr));
        groupsDocsAndFilesUploadController.f21373c.c(Tasks.UPLOAD_GROUP_FILE_HANDLE, groupsDocsAndFilesUploadController.f21377g.a(GraphQLRequest.a((CreateFileMutationString) new CreateFileMutationString().a("input", storyCreateInputData))), new AbstractDisposableFutureCallback<GraphQLResult<CreateFileMutationModel>>(groupsDocsAndFilesUploadController) {
            final /* synthetic */ GroupsDocsAndFilesUploadController f21364c;

            protected final void m22324a(Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (graphQLResult == null || graphQLResult.e == null || ((CreateFileMutationModel) graphQLResult.e).m22436a() == null) {
                    settableFuture.a(new FileUploadingException(UploadFailureReason.FILE_HANDLE_UPLOADING_FAILURE, file));
                } else {
                    FutureDetour.a(settableFuture, GroupsDocsAndFilesUploadController.m22336b(file, ((CreateFileMutationModel) graphQLResult.e).m22436a()), -644475677);
                }
            }

            protected final void m22325a(Throwable th) {
                settableFuture.a(new FileUploadingException(UploadFailureReason.FILE_HANDLE_UPLOADING_FAILURE, file));
            }
        });
    }

    public static UploadingFileResult m22336b(File file, StoryModel storyModel) {
        NodesModel.Builder builder = new NodesModel.Builder();
        builder.f21470c = storyModel.m22433m();
        if (CollectionUtil.b(storyModel.m22431k()) && storyModel.m22431k().get(0) != null) {
            AttachmentsModel attachmentsModel = (AttachmentsModel) storyModel.m22431k().get(0);
            builder.f21471d = attachmentsModel.m22414j();
            if (attachmentsModel.m22413a() != null) {
                builder.f21469b = attachmentsModel.m22413a().m22409j();
            }
        }
        if (CollectionUtil.b(storyModel.m22430j()) && storyModel.m22430j().get(0) != null) {
            OwnerModel.Builder builder2 = new OwnerModel.Builder();
            builder2.f21480c = ((ActorsModel) storyModel.m22430j().get(0)).m22396j();
            builder.f21473f = builder2.m22464a();
        }
        builder.f21468a = storyModel.m22432l();
        OriginalPostModel.Builder builder3 = new OriginalPostModel.Builder();
        builder3.f21474a = storyModel.m22433m();
        builder3 = builder3;
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int b = flatBufferBuilder.b(builder3.f21474a);
        int b2 = flatBufferBuilder.b(builder3.f21475b);
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, b2);
        flatBufferBuilder.d(flatBufferBuilder.d());
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        builder.f21472e = new OriginalPostModel(new MutableFlatBuffer(wrap, null, null, true, null));
        return new UploadingFileResult(builder.m22453a(), m22337d(file));
    }

    public static void m22334a(GroupsDocsAndFilesUploadController groupsDocsAndFilesUploadController, String str, FbUploadJobHandleImpl fbUploadJobHandleImpl) {
        if (groupsDocsAndFilesUploadController.f21382l.get(str) != null) {
            ((UploadingFileItem) groupsDocsAndFilesUploadController.f21382l.get(str)).f21368d = fbUploadJobHandleImpl;
        }
    }
}

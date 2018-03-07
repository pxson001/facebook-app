package com.facebook.groups.docsandfiles.controller;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.app.NotificationCompat.Builder;
import android.webkit.MimeTypeMap;
import com.facebook.cdn.handler.CdnHeaderResponse;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.groups.docsandfiles.fragment.GroupDocOrFileListViewItem.FileState;
import com.facebook.groups.docsandfiles.fragment.GroupDocsAndFilesFragment.C30538;
import com.facebook.groups.docsandfiles.loader.FileMediaDownloader;
import com.facebook.groups.docsandfiles.view.DefaultGroupDocsAndFilesViewFactory;
import com.facebook.groups.docsandfiles.view.GroupDocsAndFilesViewFactory;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.media.fetch.DownloadResultResponseHandler;
import com.facebook.ui.media.fetch.MediaDownloadRequest;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.io.ByteStreams;
import com.google.common.io.FileWriteMode;
import com.google.common.io.Files;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: User cancelled the dialog */
public class GroupsDocsAndFilesDownloadController {
    public static final String f21342a = GroupsDocsAndFilesDownloadController.class.getName();
    public static final CallerContext f21343b = CallerContext.a(GroupsDocsAndFilesDownloadController.class);
    private final ExecutorService f21344c;
    public final Lazy<Toaster> f21345d;
    public final FileMediaDownloader f21346e;
    public final Lazy<FbErrorReporter> f21347f;
    public final Lazy<Resources> f21348g;
    public final TasksManager f21349h;
    public final DefaultGroupDocsAndFilesViewFactory f21350i;
    public final NotificationManager f21351j;
    public final Context f21352k;
    public final C30538 f21353l;

    /* compiled from: User cancelled the dialog */
    public class C30342 extends AbstractDisposableFutureCallback<FileDownloadingResult> {
        final /* synthetic */ GroupsDocsAndFilesDownloadController f21339a;

        public C30342(GroupsDocsAndFilesDownloadController groupsDocsAndFilesDownloadController) {
            this.f21339a = groupsDocsAndFilesDownloadController;
        }

        protected final void m22317a(Object obj) {
            FileDownloadingResult fileDownloadingResult = (FileDownloadingResult) obj;
            if (this.f21339a.f21353l != null) {
                C30538 c30538 = this.f21339a.f21353l;
                c30538.f21426a.ap.m22312a(fileDownloadingResult.f21340a, FileState.NORMAL);
            }
            GroupsDocsAndFilesDownloadController groupsDocsAndFilesDownloadController = this.f21339a;
            File file = fileDownloadingResult.f21341b;
            Intent intent = new Intent("android.intent.action.VIEW");
            Uri fromFile = Uri.fromFile(file);
            intent.setDataAndType(fromFile, MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(fromFile.toString())));
            if (groupsDocsAndFilesDownloadController.f21352k.getPackageManager().queryIntentActivities(intent, 0).isEmpty()) {
                intent.setAction("android.intent.action.GET_CONTENT");
            }
            PendingIntent activity = PendingIntent.getActivity(groupsDocsAndFilesDownloadController.f21352k, 621, intent, 134217728);
            Object name = file.getName();
            Builder builder = new Builder(groupsDocsAndFilesDownloadController.f21352k);
            builder.g = ((BitmapDrawable) groupsDocsAndFilesDownloadController.f21350i.f21502a.getDrawable(2130839634)).getBitmap();
            Builder c = builder.a(2130839834).a(name).b(((Resources) groupsDocsAndFilesDownloadController.f21348g.get()).getString(2131242090)).c(true);
            c.d = activity;
            groupsDocsAndFilesDownloadController.f21351j.notify(name, 16, c.c());
        }

        protected final void m22318a(Throwable th) {
            ((Toaster) this.f21339a.f21345d.get()).b(new ToastBuilder(((Resources) this.f21339a.f21348g.get()).getString(2131242068)));
            ((AbstractFbErrorReporter) this.f21339a.f21347f.get()).a(SoftError.b(GroupsDocsAndFilesDownloadController.f21342a, th.getMessage()));
            if ((th instanceof FileDownloadingException) && this.f21339a.f21353l != null) {
                C30538 c30538 = this.f21339a.f21353l;
                c30538.f21426a.ap.m22312a(((FileDownloadingException) th).position, FileState.NORMAL);
            }
        }
    }

    /* compiled from: User cancelled the dialog */
    class FileDownloadingException extends Exception {
        public int position;

        public FileDownloadingException(int i, String str) {
            super(str);
            this.position = i;
        }

        public FileDownloadingException(int i, Exception exception) {
            super(exception);
            this.position = i;
        }
    }

    /* compiled from: User cancelled the dialog */
    class FileDownloadingResult {
        public int f21340a;
        public File f21341b;

        public FileDownloadingResult(int i, File file) {
            this.f21340a = i;
            this.f21341b = file;
        }
    }

    @Inject
    public GroupsDocsAndFilesDownloadController(ExecutorService executorService, Lazy<Toaster> lazy, FileMediaDownloader fileMediaDownloader, Lazy<FbErrorReporter> lazy2, Lazy<Resources> lazy3, TasksManager tasksManager, GroupDocsAndFilesViewFactory groupDocsAndFilesViewFactory, NotificationManager notificationManager, @Assisted Context context, @Assisted GroupsDocsAndFilesDownloadControllerListener groupsDocsAndFilesDownloadControllerListener) {
        this.f21344c = executorService;
        this.f21345d = lazy;
        this.f21346e = fileMediaDownloader;
        this.f21347f = lazy2;
        this.f21348g = lazy3;
        this.f21349h = tasksManager;
        this.f21350i = groupDocsAndFilesViewFactory;
        this.f21351j = notificationManager;
        this.f21352k = context;
        this.f21353l = groupsDocsAndFilesDownloadControllerListener;
    }

    private ListenableFuture<FileDownloadingResult> m22319b(String str, String str2, int i) {
        final SettableFuture f = SettableFuture.f();
        final String str3 = str;
        final String str4 = str2;
        final int i2 = i;
        ExecutorDetour.a(this.f21344c, new Runnable(this) {
            final /* synthetic */ GroupsDocsAndFilesDownloadController f21338e;

            /* compiled from: User cancelled the dialog */
            class C30321 implements DownloadResultResponseHandler<File> {
                final /* synthetic */ C30331 f21333a;

                C30321(C30331 c30331) {
                    this.f21333a = c30331;
                }

                public final Object m22316a(InputStream inputStream, long j, CdnHeaderResponse cdnHeaderResponse) {
                    OutputStream outputStream = null;
                    Object file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), str3);
                    try {
                        outputStream = Files.a(file, new FileWriteMode[0]).a();
                        ByteStreams.a(inputStream, outputStream);
                        return file;
                    } finally {
                        if (outputStream != null) {
                            outputStream.close();
                        }
                    }
                }
            }

            public void run() {
                try {
                    File file = (File) this.f21338e.f21346e.a(new MediaDownloadRequest(Uri.parse(str4), new C30321(this), GroupsDocsAndFilesDownloadController.f21343b));
                    if (file == null) {
                        f.a(new FileDownloadingException(i2, "Empty resource"));
                    } else {
                        FutureDetour.a(f, new FileDownloadingResult(i2, file), 337483419);
                    }
                } catch (Exception e) {
                    f.a(new FileDownloadingException(i2, e));
                }
            }
        }, 1715042823);
        return f;
    }

    public final void m22320a(String str, String str2, int i) {
        this.f21349h.c("DOWNLOAD_GROUP_FILES_" + str, m22319b(str, str2.replace(" ", "%20"), i), new C30342(this));
    }
}

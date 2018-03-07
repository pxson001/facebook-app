package com.facebook.composer.publish;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Handler;
import android.view.ContextThemeWrapper;
import com.facebook.bugreporter.BugReportExtraFileMapProvider;
import com.facebook.bugreporter.BugReportFlowStartParams;
import com.facebook.bugreporter.BugReportSource;
import com.facebook.bugreporter.BugReporter;
import com.facebook.bugreporter.BugReportingXConfig;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.composer.publish.cache.pendingstory.PendingStoryStore;
import com.facebook.composer.publish.common.ErrorDetails;
import com.facebook.composer.publish.common.PendingStory;
import com.facebook.composer.publish.common.PostParamsWrapper;
import com.facebook.debug.log.BLog;
import com.facebook.inject.Assisted;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.dialogs.DialogContext;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.xconfig.core.XConfigReader;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Optional;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.ImmutableSet;
import java.io.File;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.inject.Inject;

/* compiled from: picture_count */
public class PostFailureDialogController {
    public static final Class<?> f8006a = PostFailureDialogController.class;
    public final Context f8007b;
    public final FbObjectMapper f8008c;
    public final BugReporter f8009d;
    private final PendingStoryStore f8010e;
    private final Handler f8011f;
    private final String f8012g;
    public final XConfigReader f8013h;

    @AutoGenJsonSerializer
    @JsonSerialize(using = PostFailureDialogController_PostFailedBugReportDataSerializer.class)
    /* compiled from: picture_count */
    class PostFailedBugReportData {
        @JsonProperty("error_details")
        final ErrorDetails mErrorDetails;
        @JsonProperty("post_params")
        final PostParamsWrapper mPostParamsWrapper;

        public PostFailedBugReportData(ErrorDetails errorDetails, PostParamsWrapper postParamsWrapper) {
            this.mErrorDetails = errorDetails;
            this.mPostParamsWrapper = postParamsWrapper;
        }
    }

    /* compiled from: picture_count */
    class PostFailedDataFileProvider implements BugReportExtraFileMapProvider {
        final /* synthetic */ PostFailureDialogController f8004a;
        @Nonnull
        private final PostFailedBugReportData f8005b;

        public PostFailedDataFileProvider(PostFailureDialogController postFailureDialogController, @Nonnull PostFailedBugReportData postFailedBugReportData) {
            this.f8004a = postFailureDialogController;
            this.f8005b = postFailedBugReportData;
        }

        public boolean shouldSendAsync() {
            return this.f8004a.f8013h.a(BugReportingXConfig.y, false);
        }

        public Map<String, String> getExtraFileFromWorkerThread(File file) {
            Builder builder = ImmutableMap.builder();
            try {
                File file2 = new File(file, "post_failure_data.txt");
                Uri fromFile = Uri.fromFile(file2);
                this.f8004a.f8008c.a(file2, this.f8005b);
                builder.b("post_failure_data.txt", fromFile.toString());
            } catch (Throwable e) {
                BLog.a(PostFailureDialogController.f8006a, "Exception saving report data file", e);
            }
            return builder.b();
        }

        public void prepareDataForWriting() {
        }
    }

    @Inject
    public PostFailureDialogController(Context context, FbObjectMapper fbObjectMapper, BugReporter bugReporter, PendingStoryStore pendingStoryStore, Handler handler, @Assisted String str, XConfigReader xConfigReader) {
        this.f8007b = context;
        this.f8008c = fbObjectMapper;
        this.f8009d = bugReporter;
        this.f8010e = pendingStoryStore;
        this.f8011f = handler;
        this.f8012g = str;
        this.f8013h = xConfigReader;
    }

    public final void m11574a() {
        Object obj;
        Context context = this.f8007b;
        while (context != null && !(context instanceof Activity)) {
            if (!(context instanceof ContextThemeWrapper)) {
                if (!(context instanceof DialogContext)) {
                    obj = null;
                    break;
                }
                context = ((DialogContext) context).getBaseContext();
            } else {
                context = ((ContextThemeWrapper) context).getBaseContext();
            }
        }
        obj = context != null ? 1 : null;
        if (obj != null) {
            Optional d = this.f8010e.d(this.f8012g);
            if (d.isPresent()) {
                PostParamsWrapper b = ((PendingStory) d.get()).b();
                ErrorDetails b2 = b.b();
                final String string = (b2 == null || Strings.isNullOrEmpty(b2.userMessage)) ? this.f8007b.getString(2131233518) : b2.userMessage;
                final PostFailedBugReportData postFailedBugReportData = new PostFailedBugReportData(b2, b);
                HandlerDetour.a(this.f8011f, new Runnable(this) {
                    final /* synthetic */ PostFailureDialogController f8003c;

                    /* compiled from: picture_count */
                    class C04771 implements OnClickListener {
                        final /* synthetic */ C04791 f7999a;

                        C04771(C04791 c04791) {
                            this.f7999a = c04791;
                        }

                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    }

                    /* compiled from: picture_count */
                    class C04782 implements OnClickListener {
                        final /* synthetic */ C04791 f8000a;

                        C04782(C04791 c04791) {
                            this.f8000a = c04791;
                        }

                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            this.f8000a.f8003c.f8009d.a(BugReportFlowStartParams.newBuilder().a(this.f8000a.f8003c.f8007b).a(BugReportSource.POST_FAILURE).a(ImmutableSet.of(new PostFailedDataFileProvider(this.f8000a.f8003c, postFailedBugReportData))).a(Long.valueOf(286835824752176L)).a());
                        }
                    }

                    public void run() {
                        new FbAlertDialogBuilder(this.f8003c.f8007b).b(string).c(2131233521, new C04782(this)).a(2131233520, new C04771(this)).b();
                    }
                }, 1305681411);
            }
        }
    }
}

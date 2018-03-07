package com.facebook.feedback.reactions.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import com.facebook.debug.log.BLog;
import com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionSettingsQueryModel.FeedbackReactionSettingsModel.ReactionInfosModel;
import com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionsVectorDataQueryModel.FeedbackReactionSettingsModel.ReactionInfosModel.AnimationModel;
import com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.ReactionImageFragmentModel;
import com.facebook.feedback.reactions.data.FeedbackReaction;
import com.facebook.feedback.reactions.prefs.FeedbackReactionsPrefKeys;
import com.facebook.feedback.reactions.ui.FeedbackReactionsController.ImageFormat;
import com.facebook.feedback.reactions.ui.ReactionsClientInfo.ReactionsClientInfoAsset;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: second_language */
public class FeedbackReactionsDownloader$PersistanceRunnable implements Runnable {
    public final /* synthetic */ FeedbackReactionsDownloader f7303a;
    public List<ReactionInfosModel> f7304b;

    /* compiled from: second_language */
    class C01343 implements Function<Iterable<Boolean>, Boolean> {
        final /* synthetic */ FeedbackReactionsDownloader$PersistanceRunnable f2941a;

        C01343(FeedbackReactionsDownloader$PersistanceRunnable feedbackReactionsDownloader$PersistanceRunnable) {
            this.f2941a = feedbackReactionsDownloader$PersistanceRunnable;
        }

        public Object apply(Object obj) {
            for (Boolean booleanValue : (Iterable) obj) {
                if (!booleanValue.booleanValue()) {
                    return Boolean.valueOf(false);
                }
            }
            return Boolean.valueOf(true);
        }
    }

    /* compiled from: second_language */
    class C01542 implements FutureCallback<List<Boolean>> {
        final /* synthetic */ FeedbackReactionsDownloader$PersistanceRunnable f3425a;

        C01542(FeedbackReactionsDownloader$PersistanceRunnable feedbackReactionsDownloader$PersistanceRunnable) {
            this.f3425a = feedbackReactionsDownloader$PersistanceRunnable;
        }

        public void onSuccess(@Nullable Object obj) {
            this.f3425a.f7303a.j.b();
            this.f3425a.f7303a.d.e();
        }

        public void onFailure(Throwable th) {
            BLog.b(FeedbackReactionsDownloader.a, "Failed to fetch reactions from the server - ", th);
        }
    }

    public FeedbackReactionsDownloader$PersistanceRunnable(FeedbackReactionsDownloader feedbackReactionsDownloader, List<ReactionInfosModel> list) {
        this.f7303a = feedbackReactionsDownloader;
        this.f7304b = list;
    }

    public static void m7635a(FeedbackReactionsDownloader$PersistanceRunnable feedbackReactionsDownloader$PersistanceRunnable, ReactionInfosModel reactionInfosModel, int[] iArr) {
        int[] a = feedbackReactionsDownloader$PersistanceRunnable.f7303a.e.a();
        Editor edit = feedbackReactionsDownloader$PersistanceRunnable.f7303a.h.edit();
        edit.a(FeedbackReactionsPrefKeys.a(reactionInfosModel.l()), reactionInfosModel.n());
        edit.putBoolean(FeedbackReactionsPrefKeys.b(reactionInfosModel.l()), reactionInfosModel.k());
        edit.a(FeedbackReactionsPrefKeys.c(reactionInfosModel.l()), Color.parseColor("#" + reactionInfosModel.j()));
        for (ImageFormat imageFormat : FeedbackReactionsDownloader.b) {
            edit.a(FeedbackReactionsPrefKeys.a(reactionInfosModel.l(), imageFormat.name()), feedbackReactionsDownloader$PersistanceRunnable.f7303a.f.c(reactionInfosModel, imageFormat));
        }
        feedbackReactionsDownloader$PersistanceRunnable.m7639a(iArr, a, reactionInfosModel.l(), edit);
        edit.commit();
    }

    public void run() {
        int[] iArr = new int[this.f7304b.size()];
        int i = 0;
        for (ReactionInfosModel l : this.f7304b) {
            int i2 = i + 1;
            iArr[i] = l.l();
            i = i2;
        }
        final int[] iArr2 = iArr;
        Iterable arrayList = new ArrayList();
        for (final ReactionInfosModel reactionInfosModel : this.f7304b) {
            FeedbackReaction a = this.f7303a.d.a(reactionInfosModel.l());
            if (a == null || m7640a(reactionInfosModel, a)) {
                this.f7303a.j.a(reactionInfosModel.l());
                ListenableFuture a2 = m7633a(reactionInfosModel);
                arrayList.add(a2);
                Futures.a(a2, new FutureCallback<Boolean>(this) {
                    final /* synthetic */ FeedbackReactionsDownloader$PersistanceRunnable f2944c;

                    public void onSuccess(Object obj) {
                        Boolean bool = (Boolean) obj;
                        if (bool.booleanValue()) {
                            FeedbackReactionsDownloader$PersistanceRunnable.m7635a(this.f2944c, reactionInfosModel, iArr2);
                        }
                        this.f2944c.f7303a.j.a(reactionInfosModel.l(), bool.booleanValue());
                    }

                    public void onFailure(Throwable th) {
                        BLog.b(FeedbackReactionsDownloader.a, "Failed to fetch reaction assets from the server - ", th);
                    }
                }, this.f7303a.k);
            }
        }
        if (arrayList.isEmpty()) {
            this.f7303a.j.b();
        } else {
            Futures.a(Futures.b(arrayList), new C01542(this), this.f7303a.k);
        }
    }

    private boolean m7640a(ReactionInfosModel reactionInfosModel, FeedbackReaction feedbackReaction) {
        if (feedbackReaction == null || !feedbackReaction.f.equals(reactionInfosModel.n()) || feedbackReaction.g != Color.parseColor("#" + reactionInfosModel.j()) || feedbackReaction.h != reactionInfosModel.k()) {
            return true;
        }
        for (ImageFormat a : FeedbackReactionsDownloader.b) {
            if (m7641a(reactionInfosModel, a)) {
                return true;
            }
        }
        return false;
    }

    private boolean m7641a(ReactionInfosModel reactionInfosModel, ImageFormat imageFormat) {
        ReactionsClientInfo a = ReactionsClientInfo.a(reactionInfosModel.l());
        if (a == null) {
            return true;
        }
        String c = this.f7303a.f.c(reactionInfosModel, imageFormat);
        String a2 = this.f7303a.h.a(FeedbackReactionsPrefKeys.a(reactionInfosModel.l(), imageFormat.name()), null);
        ReactionsClientInfoAsset a3 = FeedbackReactionHelper.a(a, imageFormat);
        String b = FeedbackReactionHelper.b(reactionInfosModel, imageFormat);
        boolean z = !Strings.isNullOrEmpty(a2) && c.equals(a2);
        boolean equals = a3.d.equals(b);
        if (z || equals) {
            return false;
        }
        return true;
    }

    private ListenableFuture<Boolean> m7633a(ReactionInfosModel reactionInfosModel) {
        Iterable arrayList = new ArrayList();
        for (ImageFormat b : FeedbackReactionsDownloader.b) {
            arrayList.add(m7642b(reactionInfosModel, b));
        }
        return Futures.a(Futures.b(arrayList), new C01343(this), this.f7303a.k);
    }

    private ListenableFuture<Boolean> m7642b(ReactionInfosModel reactionInfosModel, ImageFormat imageFormat) {
        final String c = this.f7303a.f.c(reactionInfosModel, imageFormat);
        if (new File(c).exists()) {
            return Futures.a(Boolean.valueOf(true));
        }
        switch (FeedbackReactionsDownloader$2.f2933a[imageFormat.ordinal()]) {
            case 1:
            case 2:
            case 3:
                return m7634a(FeedbackReactionHelper.a(reactionInfosModel, imageFormat), c);
            case 4:
                return Futures.a(this.f7303a.l.a(reactionInfosModel.l()), new Function<AnimationModel, Boolean>(this) {
                    final /* synthetic */ FeedbackReactionsDownloader$PersistanceRunnable f2940b;

                    public Object apply(Object obj) {
                        try {
                            FeedbackReactionsDownloader$PersistanceRunnable.m7638a(c, ((AnimationModel) obj).m3199a());
                            return Boolean.valueOf(true);
                        } catch (Throwable e) {
                            BLog.b(FeedbackReactionsDownloader.a, "Failed to save vector - ", e);
                            return Boolean.valueOf(false);
                        }
                    }
                }, this.f7303a.k);
            default:
                throw new IllegalArgumentException("Reaction Asset for image type " + imageFormat.name() + " not supported.");
        }
    }

    private ListenableFuture<Boolean> m7634a(ReactionImageFragmentModel reactionImageFragmentModel, String str) {
        boolean z = false;
        Bitmap bitmap = null;
        try {
            bitmap = BitmapFactory.decodeStream(new URL(reactionImageFragmentModel.j()).openConnection().getInputStream());
            if (bitmap != null) {
                m7637a(str, bitmap);
                z = true;
            }
            if (!(bitmap == null || bitmap.isRecycled())) {
                bitmap.recycle();
            }
        } catch (Throwable e) {
            BLog.b(FeedbackReactionsDownloader.a, "Failed to save image - ", e);
            if (!(bitmap == null || bitmap.isRecycled())) {
                bitmap.recycle();
            }
        } catch (Throwable e2) {
            BLog.b(FeedbackReactionsDownloader.a, "Failed to download image - ", e2);
            if (!(bitmap == null || bitmap.isRecycled())) {
                bitmap.recycle();
            }
        } catch (Throwable th) {
            if (!(bitmap == null || bitmap.isRecycled())) {
                bitmap.recycle();
            }
        }
        return Futures.a(Boolean.valueOf(z));
    }

    private static void m7637a(String str, Bitmap bitmap) {
        File file = new File(str);
        file.getParentFile().mkdirs();
        OutputStream fileOutputStream = new FileOutputStream(file);
        bitmap.compress(CompressFormat.PNG, 100, fileOutputStream);
        fileOutputStream.flush();
        fileOutputStream.close();
    }

    private static void m7638a(String str, String str2) {
        FileWriter fileWriter;
        Throwable e;
        File file = new File(str);
        file.getParentFile().mkdirs();
        try {
            fileWriter = new FileWriter(file);
            try {
                fileWriter.write(str2);
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e2) {
                e = e2;
                try {
                    BLog.b(FeedbackReactionsDownloader.a, "Failed to save vector - ", e);
                    if (fileWriter != null) {
                        fileWriter.close();
                    }
                } catch (Throwable th) {
                    e = th;
                    if (fileWriter != null) {
                        fileWriter.close();
                    }
                    throw e;
                }
            }
        } catch (IOException e3) {
            e = e3;
            fileWriter = null;
            BLog.b(FeedbackReactionsDownloader.a, "Failed to save vector - ", e);
            if (fileWriter != null) {
                fileWriter.close();
            }
        } catch (Throwable th2) {
            e = th2;
            fileWriter = null;
            if (fileWriter != null) {
                fileWriter.close();
            }
            throw e;
        }
    }

    private void m7639a(int[] iArr, int[] iArr2, int i, Editor editor) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 : iArr) {
            if (i2 != i) {
                Object obj = null;
                for (int i3 : iArr2) {
                    if (i3 == i2) {
                        obj = 1;
                        break;
                    }
                }
                if (obj == null) {
                }
            }
            if (stringBuilder.length() != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(i2);
        }
        editor.a(FeedbackReactionsPrefKeys.b, stringBuilder.toString());
    }
}

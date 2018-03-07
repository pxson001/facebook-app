package com.facebook.facecast;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.StatFs;
import com.facebook.common.executors.FbAsyncTask;
import com.facebook.debug.log.BLog;
import com.facebook.facecast.plugin.FacecastEndScreenV2Plugin;
import com.facebook.facecast.plugin.FacecastEndScreenV2Plugin.AnonymousClass11;
import com.facebook.facecast.view.FacecastPreviewSaveButton.SaveButtonState;
import com.facebook.inject.Assisted;
import com.facebook.mediastorage.MediaStorage;
import com.google.common.base.Preconditions;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.inject.Inject;

/* compiled from: bundle */
public class FacecastLocalVideoSaveController {
    public static final String f18027a = FacecastLocalVideoSaveController.class.getSimpleName();
    public static final SimpleDateFormat f18028b = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US);
    public final File f18029c;
    public final File f18030d;
    public final AnonymousClass11 f18031e;
    private final MediaStorage f18032f;

    /* compiled from: bundle */
    public class FacecastLocalVideoSaveWorker extends FbAsyncTask<Void, Float, File> {
        private final WeakReference<FileSaveListener> f18023a;
        private final File f18024b;
        private final File f18025c;
        private File f18026d;

        protected final Object m21870a(Object[] objArr) {
            Throwable e;
            InputStream inputStream;
            OutputStream outputStream = null;
            if (((AnonymousClass11) this.f18023a.get()) == null) {
                return null;
            }
            try {
                long length = this.f18025c.length();
                InputStream fileInputStream = new FileInputStream(this.f18025c);
                try {
                    OutputStream fileOutputStream = new FileOutputStream(this.f18026d);
                    try {
                        byte[] bArr = new byte[1024];
                        long j = 0;
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                            j += (long) read;
                            publishProgress(new Float[]{Float.valueOf((float) (((double) j) / ((double) length)))});
                        }
                        fileInputStream.close();
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (Exception e2) {
                        e = e2;
                        outputStream = fileOutputStream;
                        inputStream = fileInputStream;
                        BLog.b(FacecastLocalVideoSaveController.f18027a, "Error while saving local file ", e);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable e3) {
                                BLog.b(FacecastLocalVideoSaveController.f18027a, "Error while closing the stream ", e3);
                            }
                        }
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        return this.f18026d;
                    }
                } catch (Exception e4) {
                    e3 = e4;
                    inputStream = fileInputStream;
                    BLog.b(FacecastLocalVideoSaveController.f18027a, "Error while saving local file ", e3);
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    return this.f18026d;
                }
            } catch (Exception e5) {
                e3 = e5;
                inputStream = null;
                BLog.b(FacecastLocalVideoSaveController.f18027a, "Error while saving local file ", e3);
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                return this.f18026d;
            }
            return this.f18026d;
        }

        protected void onPostExecute(Object obj) {
            File file = (File) obj;
            AnonymousClass11 anonymousClass11 = (AnonymousClass11) this.f18023a.get();
            if (anonymousClass11 != null) {
                FacecastEndScreenV2Plugin facecastEndScreenV2Plugin = anonymousClass11.f18342a;
                Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                intent.setData(Uri.fromFile(file));
                facecastEndScreenV2Plugin.getContext().sendBroadcast(intent);
                FacecastEndScreenV2Plugin.m22054c(anonymousClass11.f18342a, 2131238264);
                if (anonymousClass11.f18342a.f18392w != null) {
                    anonymousClass11.f18342a.f18392w.m22429a(SaveButtonState.SAVING_COMPLETED);
                }
            }
        }

        protected void onProgressUpdate(Object[] objArr) {
            Float[] fArr = (Float[]) objArr;
            AnonymousClass11 anonymousClass11 = (AnonymousClass11) this.f18023a.get();
            if (anonymousClass11 != null) {
                float floatValue = fArr[0].floatValue();
                if (anonymousClass11.f18342a.f18392w != null) {
                    anonymousClass11.f18342a.f18392w.setProgress(floatValue);
                }
            }
        }

        public FacecastLocalVideoSaveWorker(AnonymousClass11 anonymousClass11, File file, File file2) {
            this.f18023a = new WeakReference(anonymousClass11);
            this.f18025c = file;
            this.f18024b = file2;
        }

        protected void onPreExecute() {
            AnonymousClass11 anonymousClass11 = (AnonymousClass11) this.f18023a.get();
            if (anonymousClass11 != null) {
                if (!this.f18024b.exists()) {
                    this.f18024b.mkdirs();
                }
                this.f18026d = new File(this.f18024b, "FB_" + FacecastLocalVideoSaveController.f18028b.format(new Date()) + ".mp4");
                if (anonymousClass11.f18342a.f18392w != null) {
                    anonymousClass11.f18342a.f18392w.m22429a(SaveButtonState.SAVING_IN_PROGRESS);
                }
            }
        }
    }

    @Inject
    public FacecastLocalVideoSaveController(@Assisted File file, @Assisted AnonymousClass11 anonymousClass11, String str, MediaStorage mediaStorage) {
        this.f18029c = (File) Preconditions.checkNotNull(file);
        this.f18031e = (AnonymousClass11) Preconditions.checkNotNull(anonymousClass11);
        this.f18030d = new File(Environment.getExternalStorageDirectory(), str);
        this.f18032f = mediaStorage;
    }

    public final boolean m21871a() {
        if (MediaStorage.b()) {
            long length = this.f18029c.length();
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            if ((length < ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks()) ? 1 : null) != null) {
                return true;
            }
        }
        return false;
    }
}

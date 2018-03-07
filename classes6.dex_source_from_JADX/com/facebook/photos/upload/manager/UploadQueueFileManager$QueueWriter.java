package com.facebook.photos.upload.manager;

import com.facebook.debug.log.BLog;
import com.facebook.photos.upload.operation.UploadOperation;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: graph_search/ */
public abstract class UploadQueueFileManager$QueueWriter implements Runnable {
    protected final UploadOperation f13681b;
    final /* synthetic */ UploadQueueFileManager f13682c;

    abstract void mo1141a(DataOutputStream dataOutputStream);

    UploadQueueFileManager$QueueWriter(UploadQueueFileManager uploadQueueFileManager, UploadOperation uploadOperation) {
        this.f13682c = uploadQueueFileManager;
        this.f13681b = uploadOperation;
    }

    public void run() {
        FileOutputStream fileOutputStream;
        IOException e;
        FileOutputStream fileOutputStream2;
        Throwable th;
        long length = this.f13682c.d.isFile() ? this.f13682c.d.length() : 0;
        try {
            fileOutputStream = new FileOutputStream(this.f13682c.d, true);
            try {
                DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
                if (length == 0) {
                    dataOutputStream.writeInt(this.f13682c.e);
                    dataOutputStream.writeUTF(this.f13682c.f);
                    dataOutputStream.writeUTF(UploadQueueFileManager.a(this.f13682c, (String) this.f13682c.b.get()));
                }
                mo1141a(dataOutputStream);
                try {
                    fileOutputStream.flush();
                } catch (IOException e2) {
                }
                try {
                    fileOutputStream.close();
                } catch (IOException e3) {
                }
            } catch (IOException e4) {
                e = e4;
                fileOutputStream2 = fileOutputStream;
                try {
                    BLog.a(UploadQueueFileManager.a, "QueueWriter failed to append to queue: %s, %s", new Object[]{e.getClass().getSimpleName(), e.getMessage()});
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.flush();
                        } catch (IOException e5) {
                        }
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e6) {
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.flush();
                        } catch (IOException e7) {
                        }
                        try {
                            fileOutputStream.close();
                        } catch (IOException e8) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (fileOutputStream != null) {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                }
                throw th;
            }
        } catch (IOException e9) {
            e = e9;
            fileOutputStream2 = null;
            BLog.a(UploadQueueFileManager.a, "QueueWriter failed to append to queue: %s, %s", new Object[]{e.getClass().getSimpleName(), e.getMessage()});
            if (fileOutputStream2 != null) {
                fileOutputStream2.flush();
                fileOutputStream2.close();
            }
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.flush();
                fileOutputStream.close();
            }
            throw th;
        }
    }
}

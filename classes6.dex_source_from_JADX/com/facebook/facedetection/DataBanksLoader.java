package com.facebook.facedetection;

import com.facebook.androidcompat.AndroidCompat;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.proguard.annotations.DoNotStrip;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.zip.GZIPInputStream;

@DoNotStrip
/* compiled from: num_extra_profiles_added_to_bootstrap */
public class DataBanksLoader {

    /* compiled from: num_extra_profiles_added_to_bootstrap */
    enum ModelType {
        LEFT_FULL_PROFILE(1, 13),
        LEFT_HALF_PROFILE(4, 10),
        FRONTAL_TILT_LEFT(6, 8),
        FRONTAL_MODEL(7, 7),
        FRONTAL_TILT_RIGHT(8, 6),
        RIGHT_HALF_PROFILE(10, 4),
        RIGHT_FULL_PROFILE(13, 1);
        
        private int mClassId;
        private int mRefClassId;

        private ModelType(int i, int i2) {
            this.mClassId = i;
            this.mRefClassId = i2;
        }

        public final int id() {
            return this.mClassId;
        }

        public final int reflectedId() {
            return this.mRefClassId;
        }
    }

    private native void dealloc();

    private native boolean finalizeWfsTree();

    private native boolean init(int i);

    private native boolean initStageIIData(int i);

    private native boolean loadPointsClassifier(ByteBuffer byteBuffer, int i);

    private native boolean loadStageIIClass(ByteBuffer byteBuffer, int i, int i2);

    private native boolean loadWfsClass(ByteBuffer byteBuffer, int i, int i2, int i3, int i4);

    private native void loadWfsMeta(ByteBuffer byteBuffer, int i);

    public DataBanksLoader(FaceDetectionAssetDownloader faceDetectionAssetDownloader) {
        m15523a(faceDetectionAssetDownloader);
    }

    protected void finalize() {
    }

    private void m15523a(FaceDetectionAssetDownloader faceDetectionAssetDownloader) {
        try {
            ModelType[] modelTypeArr = new ModelType[]{ModelType.LEFT_FULL_PROFILE, ModelType.LEFT_HALF_PROFILE, ModelType.FRONTAL_TILT_LEFT, ModelType.FRONTAL_MODEL};
            if (init(7)) {
                ByteBuffer allocateDirect = ByteBuffer.allocateDirect(393216);
                m15524a(faceDetectionAssetDownloader, StringFormatUtil.formatStrLocaleSafe("%s.%s", "sImeta", "bin.gz.jet"), allocateDirect);
                loadWfsMeta(allocateDirect, allocateDirect.position());
                int i = 0;
                while (i < 4) {
                    ModelType modelType = modelTypeArr[i];
                    m15524a(faceDetectionAssetDownloader, StringFormatUtil.formatStrLocaleSafe("%s%d.%s", "sIcls", Integer.valueOf(modelType.id()), "bin.gz.jet"), allocateDirect);
                    if (loadWfsClass(allocateDirect, allocateDirect.position(), i, modelType.id(), modelType.reflectedId())) {
                        i++;
                    } else {
                        throw new OutOfMemoryError("StageI allocation");
                    }
                }
                if (!finalizeWfsTree()) {
                    throw new OutOfMemoryError("finalizeWfsTree");
                } else if (initStageIIData(4)) {
                    int i2 = 0;
                    while (i2 < 4) {
                        m15524a(faceDetectionAssetDownloader, StringFormatUtil.formatStrLocaleSafe("%s%d.%s", "sIIcls", Integer.valueOf(modelTypeArr[i2].id()), "bin.gz.jet"), allocateDirect);
                        if (loadStageIIClass(allocateDirect, allocateDirect.position(), i2)) {
                            i2++;
                        } else {
                            throw new OutOfMemoryError("loadStageIIClass " + i2);
                        }
                    }
                } else {
                    throw new OutOfMemoryError("initStageII");
                }
            }
        } catch (IOException e) {
            dealloc();
            throw e;
        } catch (OutOfMemoryError e2) {
            dealloc();
            throw e2;
        }
    }

    private static void m15524a(FaceDetectionAssetDownloader faceDetectionAssetDownloader, String str, ByteBuffer byteBuffer) {
        Throwable th;
        Throwable th2;
        BufferedInputStream bufferedInputStream = null;
        byteBuffer.rewind();
        try {
            InputStream bufferedInputStream2 = new BufferedInputStream(faceDetectionAssetDownloader.m15538a(str));
            try {
                GZIPInputStream gZIPInputStream = new GZIPInputStream(bufferedInputStream2);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = gZIPInputStream.read(bArr, 0, 1024);
                        if (read != -1) {
                            byteBuffer.put(bArr, 0, read);
                        } else {
                            gZIPInputStream.close();
                            bufferedInputStream2.close();
                            return;
                        }
                    }
                } catch (Throwable th22) {
                    Throwable th3 = th22;
                    th22 = th;
                    th = th3;
                }
                throw th;
                if (th22 != null) {
                    try {
                        gZIPInputStream.close();
                    } catch (Throwable th4) {
                        AndroidCompat.addSuppressed(th22, th4);
                    }
                } else {
                    gZIPInputStream.close();
                }
                throw th;
            } catch (Throwable th5) {
                th = th5;
                bufferedInputStream = bufferedInputStream2;
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            throw th;
        }
    }
}

package android_src.mmsv2.util;

import android.content.Context;
import android.drm.DrmConvertedStatus;
import android.drm.DrmManagerClient;
import com.facebook.debug.log.BLog;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: serializeCommerceOrder */
public class DrmConvertSession {
    private DrmManagerClient f3887a;
    private int f3888b;

    private DrmConvertSession(DrmManagerClient drmManagerClient, int i) {
        this.f3887a = drmManagerClient;
        this.f3888b = i;
    }

    public static DrmConvertSession m3741a(Context context, String str) {
        int i;
        DrmManagerClient drmManagerClient;
        DrmManagerClient drmManagerClient2;
        int i2;
        int i3 = -1;
        if (context == null || str == null || str.equals("")) {
            i = i3;
            drmManagerClient = null;
        } else {
            try {
                drmManagerClient2 = new DrmManagerClient(context);
                try {
                    drmManagerClient = drmManagerClient2;
                    i = drmManagerClient2.openConvertSession(str);
                } catch (Throwable e) {
                    try {
                        BLog.a("DrmConvertSession", "Conversion of Mimetype: " + str + " is not supported.", e);
                        i2 = i3;
                        drmManagerClient = drmManagerClient2;
                        i = i2;
                    } catch (IllegalArgumentException e2) {
                        BLog.a("DrmConvertSession", "DrmManagerClient instance could not be created, context is Illegal.");
                        i2 = i3;
                        drmManagerClient = drmManagerClient2;
                        i = i2;
                        return drmManagerClient != null ? null : null;
                    } catch (IllegalStateException e3) {
                        BLog.a("DrmConvertSession", "DrmManagerClient didn't initialize properly.");
                        i2 = i3;
                        drmManagerClient = drmManagerClient2;
                        i = i2;
                        if (drmManagerClient != null) {
                        }
                    }
                } catch (Throwable e4) {
                    BLog.a("DrmConvertSession", "Could not access Open DrmFramework.", e4);
                    i2 = i3;
                    drmManagerClient = drmManagerClient2;
                    i = i2;
                }
            } catch (IllegalArgumentException e5) {
                drmManagerClient2 = null;
                BLog.a("DrmConvertSession", "DrmManagerClient instance could not be created, context is Illegal.");
                i2 = i3;
                drmManagerClient = drmManagerClient2;
                i = i2;
                if (drmManagerClient != null) {
                }
            } catch (IllegalStateException e6) {
                drmManagerClient2 = null;
                BLog.a("DrmConvertSession", "DrmManagerClient didn't initialize properly.");
                i2 = i3;
                drmManagerClient = drmManagerClient2;
                i = i2;
                if (drmManagerClient != null) {
                }
            }
        }
        if (drmManagerClient != null && i >= 0) {
            return new DrmConvertSession(drmManagerClient, i);
        }
    }

    public final byte[] m3743a(byte[] bArr, int i) {
        if (bArr != null) {
            try {
                DrmConvertedStatus convertData;
                if (i != bArr.length) {
                    Object obj = new byte[i];
                    System.arraycopy(bArr, 0, obj, 0, i);
                    convertData = this.f3887a.convertData(this.f3888b, obj);
                } else {
                    convertData = this.f3887a.convertData(this.f3888b, bArr);
                }
                if (convertData == null || convertData.statusCode != 1 || convertData.convertedData == null) {
                    return null;
                }
                return convertData.convertedData;
            } catch (Throwable e) {
                BLog.a("DrmConvertSession", "Buffer with data to convert is illegal. Convertsession: " + this.f3888b, e);
                return null;
            } catch (Throwable e2) {
                BLog.a("DrmConvertSession", "Could not convert data. Convertsession: " + this.f3888b, e2);
                return null;
            }
        }
        throw new IllegalArgumentException("Parameter inBuffer is null");
    }

    public final int m3742a(String str) {
        RandomAccessFile randomAccessFile;
        Throwable e;
        Throwable th;
        Throwable th2;
        int i = 492;
        if (this.f3887a != null && this.f3888b >= 0) {
            try {
                DrmConvertedStatus closeConvertSession = this.f3887a.closeConvertSession(this.f3888b);
                if (closeConvertSession == null || closeConvertSession.statusCode != 1 || closeConvertSession.convertedData == null) {
                    return 406;
                }
                RandomAccessFile randomAccessFile2 = null;
                try {
                    randomAccessFile = new RandomAccessFile(str, "rw");
                    try {
                        randomAccessFile.seek((long) closeConvertSession.offset);
                        randomAccessFile.write(closeConvertSession.convertedData);
                        try {
                            randomAccessFile.close();
                            return 200;
                        } catch (Throwable e2) {
                            try {
                                BLog.a("DrmConvertSession", "Failed to close File:" + str + ".", e2);
                                return 492;
                            } catch (IllegalStateException e3) {
                                e2 = e3;
                                BLog.a("DrmConvertSession", "Could not close convertsession. Convertsession: " + this.f3888b, e2);
                                return i;
                            }
                        }
                    } catch (FileNotFoundException e4) {
                        e2 = e4;
                        try {
                            BLog.a("DrmConvertSession", "File: " + str + " could not be found.", e2);
                            if (randomAccessFile != null) {
                                return 492;
                            }
                            try {
                                randomAccessFile.close();
                                return 492;
                            } catch (Throwable e22) {
                                BLog.a("DrmConvertSession", "Failed to close File:" + str + ".", e22);
                                return 492;
                            }
                        } catch (Throwable e222) {
                            randomAccessFile2 = randomAccessFile;
                            th = e222;
                            int i2 = 492;
                            if (randomAccessFile2 != null) {
                                try {
                                    randomAccessFile2.close();
                                } catch (Throwable e2222) {
                                    BLog.a("DrmConvertSession", "Failed to close File:" + str + ".", e2222);
                                    i2 = 492;
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e5) {
                        e2222 = e5;
                        BLog.a("DrmConvertSession", "Could not access File: " + str + " .", e2222);
                        if (randomAccessFile != null) {
                            return 492;
                        }
                        try {
                            randomAccessFile.close();
                            return 492;
                        } catch (Throwable e22222) {
                            BLog.a("DrmConvertSession", "Failed to close File:" + str + ".", e22222);
                            return 492;
                        }
                    } catch (IllegalArgumentException e6) {
                        e22222 = e6;
                        BLog.a("DrmConvertSession", "Could not open file in mode: rw", e22222);
                        if (randomAccessFile != null) {
                            return 492;
                        }
                        try {
                            randomAccessFile.close();
                            return 492;
                        } catch (Throwable e222222) {
                            BLog.a("DrmConvertSession", "Failed to close File:" + str + ".", e222222);
                            return 492;
                        }
                    } catch (Throwable e7) {
                        th2 = e7;
                        randomAccessFile2 = randomAccessFile;
                        th = th2;
                        try {
                            BLog.a("DrmConvertSession", "Access to File: " + str + " was denied denied by SecurityManager.", th);
                            if (randomAccessFile2 != null) {
                                try {
                                    randomAccessFile2.close();
                                    return 491;
                                } catch (Throwable e2222222) {
                                    BLog.a("DrmConvertSession", "Failed to close File:" + str + ".", e2222222);
                                    return 492;
                                }
                            }
                            return 491;
                        } catch (Throwable th3) {
                            th = th3;
                            if (randomAccessFile2 != null) {
                                randomAccessFile2.close();
                            }
                            throw th;
                        }
                    } catch (Throwable e72) {
                        th2 = e72;
                        randomAccessFile2 = randomAccessFile;
                        th = th2;
                        if (randomAccessFile2 != null) {
                            randomAccessFile2.close();
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e8) {
                    e2222222 = e8;
                    randomAccessFile = null;
                    BLog.a("DrmConvertSession", "File: " + str + " could not be found.", e2222222);
                    if (randomAccessFile != null) {
                        return 492;
                    }
                    randomAccessFile.close();
                    return 492;
                } catch (IOException e9) {
                    e2222222 = e9;
                    randomAccessFile = null;
                    BLog.a("DrmConvertSession", "Could not access File: " + str + " .", e2222222);
                    if (randomAccessFile != null) {
                        return 492;
                    }
                    randomAccessFile.close();
                    return 492;
                } catch (IllegalArgumentException e10) {
                    e2222222 = e10;
                    randomAccessFile = null;
                    BLog.a("DrmConvertSession", "Could not open file in mode: rw", e2222222);
                    if (randomAccessFile != null) {
                        return 492;
                    }
                    randomAccessFile.close();
                    return 492;
                } catch (SecurityException e11) {
                    th = e11;
                    BLog.a("DrmConvertSession", "Access to File: " + str + " was denied denied by SecurityManager.", th);
                    if (randomAccessFile2 != null) {
                        randomAccessFile2.close();
                        return 491;
                    }
                    return 491;
                }
            } catch (Throwable e12) {
                th2 = e12;
                i = 491;
                e2222222 = th2;
                BLog.a("DrmConvertSession", "Could not close convertsession. Convertsession: " + this.f3888b, e2222222);
                return i;
            }
        }
        return 491;
    }
}

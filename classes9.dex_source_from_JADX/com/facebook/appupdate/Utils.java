package com.facebook.appupdate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import org.json.JSONObject;

/* compiled from: setPermissions */
public class Utils {
    public static void m25832a(File file, File file2) {
        Throwable th;
        FileChannel fileChannel = null;
        FileChannel channel;
        try {
            FileChannel channel2;
            channel = new FileInputStream(file).getChannel();
            try {
                channel2 = new FileOutputStream(file2).getChannel();
            } catch (Throwable th2) {
                th = th2;
                fileChannel = channel;
                channel = null;
                if (fileChannel != null) {
                    fileChannel.close();
                }
                if (channel != null) {
                    channel.close();
                }
                throw th;
            }
            try {
                channel2.transferFrom(channel, 0, channel.size());
                if (channel != null) {
                    channel.close();
                }
                if (channel2 != null) {
                    channel2.close();
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                fileChannel = channel;
                channel = channel2;
                th = th4;
                if (fileChannel != null) {
                    fileChannel.close();
                }
                if (channel != null) {
                    channel.close();
                }
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            channel = null;
            if (fileChannel != null) {
                fileChannel.close();
            }
            if (channel != null) {
                channel.close();
            }
            throw th;
        }
    }

    public static String m25831a(int i) {
        switch (i) {
            case 1:
                return "PAUSED_WAITING_TO_RETRY";
            case 2:
                return "PAUSED_WAITING_FOR_NETWORK";
            case 3:
                return "PAUSED_QUEUED_FOR_WIFI";
            case 4:
                return "PAUSED_UNKNOWN";
            case 1000:
                return "ERROR_UNKNOWN";
            case 1001:
                return "ERROR_FILE_ERROR";
            case 1002:
                return "ERROR_UNHANDLED_HTTP_CODE";
            case 1004:
                return "ERROR_HTTP_DATA_ERROR";
            case 1005:
                return "ERROR_TOO_MANY_REDIRECTS";
            case 1006:
                return "ERROR_INSUFFICIENT_SPACE";
            case 1007:
                return "ERROR_DEVICE_NOT_FOUND";
            case 1008:
                return "ERROR_CANNOT_RESUME";
            case 1009:
                return "ERROR_FILE_ALREADY_EXISTS";
            default:
                return "UNKNOWN(" + i + ")";
        }
    }

    public static void m25835a(JSONObject jSONObject, String str, String str2) {
        try {
            jSONObject.put(str, str2);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static void m25833a(JSONObject jSONObject, String str, int i) {
        try {
            jSONObject.put(str, i);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static void m25834a(JSONObject jSONObject, String str, long j) {
        try {
            jSONObject.put(str, j);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static void m25836a(JSONObject jSONObject, String str, JSONObject jSONObject2) {
        try {
            jSONObject.put(str, jSONObject2);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static void m25837a(JSONObject jSONObject, String str, boolean z) {
        try {
            jSONObject.put(str, z);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}

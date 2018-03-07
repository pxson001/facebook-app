package com.facebook.crudolib.prefs;

import android.util.Base64OutputStream;
import com.facebook.debug.log.BLog;
import com.facebook.proxygen.HTTPTransportCallback;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: using_spdy */
class LightSharedPreferencesStorage {
    private final File f1390a;
    private final Object f1391b = new Object();

    LightSharedPreferencesStorage(File file) {
        this.f1390a = file;
    }

    public final void m2655a(Map<String, Object> map) {
        if (this.f1390a.exists()) {
            DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(this.f1390a), 512));
            try {
                m2650a(dataInputStream, (Map) map);
            } finally {
                dataInputStream.close();
            }
        }
    }

    private void m2650a(DataInputStream dataInputStream, Map<String, Object> map) {
        int readUnsignedByte = dataInputStream.readUnsignedByte();
        if (readUnsignedByte != 1) {
            try {
                BLog.c(LightSharedPreferencesStorage.class, "Unknown Version : %d; Raw file: %s", new Object[]{Integer.valueOf(readUnsignedByte), m2654a()});
            } catch (Throwable e) {
                BLog.a(LightSharedPreferencesStorage.class, e, "Failed to load the file for soft report!", new Object[0]);
            }
            throw new UnknownVersionException("Expected version 1; got " + readUnsignedByte);
        }
        int readInt = dataInputStream.readInt();
        while (true) {
            readUnsignedByte = readInt - 1;
            if (readInt > 0) {
                readInt = dataInputStream.readUnsignedByte();
                String readUTF = dataInputStream.readUTF();
                switch (readInt) {
                    case 0:
                        map.put(readUTF, Boolean.valueOf(dataInputStream.readBoolean()));
                        readInt = readUnsignedByte;
                        break;
                    case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                        map.put(readUTF, Integer.valueOf(dataInputStream.readInt()));
                        readInt = readUnsignedByte;
                        break;
                    case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                        map.put(readUTF, Long.valueOf(dataInputStream.readLong()));
                        readInt = readUnsignedByte;
                        break;
                    case 3:
                        map.put(readUTF, Float.valueOf(dataInputStream.readFloat()));
                        readInt = readUnsignedByte;
                        break;
                    case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                        map.put(readUTF, Double.valueOf(dataInputStream.readDouble()));
                        readInt = readUnsignedByte;
                        break;
                    case 5:
                        map.put(readUTF, dataInputStream.readUTF());
                        readInt = readUnsignedByte;
                        break;
                    case 6:
                        map.put(readUTF, m2649a(dataInputStream));
                        readInt = readUnsignedByte;
                        break;
                    default:
                        throw new IllegalArgumentException("Unsupported type with ordinal: " + readInt);
                }
            }
            return;
        }
    }

    private static Set<String> m2649a(DataInputStream dataInputStream) {
        int readInt = dataInputStream.readInt();
        Set<String> hashSet = new HashSet(readInt);
        while (true) {
            int i = readInt - 1;
            if (readInt <= 0) {
                return hashSet;
            }
            hashSet.add(dataInputStream.readUTF());
            readInt = i;
        }
    }

    public final void m2656b(Map<String, Object> map) {
        File createTempFile = File.createTempFile(this.f1390a.getName() + ".", ".tmp", this.f1390a.getParentFile());
        m2652a(createTempFile, (Map) map);
        synchronized (this.f1391b) {
            if (createTempFile.renameTo(this.f1390a)) {
            } else {
                createTempFile.delete();
                throw new IOException("Failed to replace the current preference file!");
            }
        }
    }

    private static void m2652a(File file, Map<String, Object> map) {
        DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file), 512));
        try {
            dataOutputStream.write(1);
            dataOutputStream.writeInt(map.size());
            for (Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                int a = ValueType.m30386a(value);
                dataOutputStream.write(a);
                dataOutputStream.writeUTF(str);
                switch (a) {
                    case 0:
                        dataOutputStream.writeBoolean(((Boolean) value).booleanValue());
                        break;
                    case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                        dataOutputStream.writeInt(((Integer) value).intValue());
                        break;
                    case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                        dataOutputStream.writeLong(((Long) value).longValue());
                        break;
                    case 3:
                        dataOutputStream.writeFloat(((Float) value).floatValue());
                        break;
                    case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                        dataOutputStream.writeDouble(((Double) value).doubleValue());
                        break;
                    case 5:
                        dataOutputStream.writeUTF((String) value);
                        break;
                    case 6:
                        m2651a(dataOutputStream, (Set) value);
                        break;
                    default:
                        throw new IllegalArgumentException("Unsupported type with ordinal: " + a);
                }
            }
        } finally {
            dataOutputStream.close();
        }
    }

    private static void m2651a(DataOutputStream dataOutputStream, Set<String> set) {
        dataOutputStream.writeInt(set.size());
        for (String writeUTF : set) {
            dataOutputStream.writeUTF(writeUTF);
        }
    }

    public final String m2654a() {
        InputStream fileInputStream = new FileInputStream(this.f1390a);
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream((int) this.f1390a.length());
        OutputStream base64OutputStream = new Base64OutputStream(byteArrayOutputStream, 0);
        try {
            m2653a(fileInputStream, base64OutputStream, new byte[1024]);
            String byteArrayOutputStream2 = byteArrayOutputStream.toString();
            return byteArrayOutputStream2;
        } finally {
            fileInputStream.close();
            base64OutputStream.close();
        }
    }

    private static void m2653a(InputStream inputStream, OutputStream outputStream, byte[] bArr) {
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }
}

package com.facebook.tools.flatbuffer;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: android_new_account_wizard */
public class FlatBufferBatchResponsesVisualizer {
    public static JSONArray m19973a(DataInputStream dataInputStream, String str) {
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < 51; i++) {
            int a;
            if (dataInputStream.available() > 0) {
                a = m19972a(dataInputStream);
            } else {
                a = 0;
            }
            if (a == 0) {
                JSONObject jSONObject;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = dataInputStream.read(bArr);
                    if (read < 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                String byteArrayOutputStream2 = byteArrayOutputStream.toString("UTF-8");
                if (byteArrayOutputStream2.length() > 0) {
                    jSONObject = new JSONObject(byteArrayOutputStream2);
                } else {
                    jSONObject = new JSONObject();
                }
                JSONObject jSONObject2 = jSONObject;
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("results", jSONObject2);
                jSONArray.put(jSONObject3);
                return jSONArray;
            }
            jSONArray.put(m19974a(dataInputStream, a, str));
        }
        return jSONArray;
    }

    private static int m19972a(DataInputStream dataInputStream) {
        byte[] bArr = new byte[4];
        dataInputStream.readFully(bArr);
        return ((bArr[3] & 255) << 24) | (((bArr[0] & 255) | ((bArr[1] & 255) << 8)) | ((bArr[2] & 255) << 16));
    }

    private static JSONObject m19974a(DataInputStream dataInputStream, int i, String str) {
        JSONObject jSONObject = new JSONObject();
        int a = m19972a(dataInputStream);
        byte[] bArr = new byte[a];
        dataInputStream.readFully(bArr);
        JSONObject jSONObject2 = new JSONObject(new String(bArr, "UTF-8"));
        String obj = jSONObject2.has("root_type") ? jSONObject2.get("root_type").toString() : null;
        jSONObject.put("meta_data", jSONObject2);
        if (obj == null) {
            throw new IOException("Failed to parse root type for flatbuffer. This informationis needed to prettify flatbuffer responses");
        }
        a = (i - a) - 4;
        if (a > 0) {
            byte[] bArr2 = new byte[a];
            dataInputStream.readFully(bArr2);
            jSONObject.put(obj, new FlatBufferVisualizer(str, obj, ByteBuffer.wrap(bArr2)).m19992a());
        }
        return jSONObject;
    }
}

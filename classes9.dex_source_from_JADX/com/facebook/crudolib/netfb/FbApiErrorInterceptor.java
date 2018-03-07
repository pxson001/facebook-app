package com.facebook.crudolib.netfb;

import com.facebook.crudolib.net.AppRequest;
import com.facebook.crudolib.net.ResponseInterceptor;
import com.facebook.crudolib.netengine.fbhttp.FbHttpEngineResponse;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: TimelineServiceHandler.handleSingleMethod */
class FbApiErrorInterceptor implements ResponseInterceptor {
    FbApiErrorInterceptor() {
    }

    public final void mo1107a(AppRequest appRequest, FbHttpEngineResponse fbHttpEngineResponse) {
        int a = fbHttpEngineResponse.m26017a();
        if (a >= 400) {
            String a2 = m26029a(fbHttpEngineResponse.m26019c());
            if (a >= 400 && a < 500) {
                FbApiErrorParser.m26034a(a2);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(fbHttpEngineResponse.m26018b());
            if (a2 != null) {
                stringBuilder.append('\n');
                stringBuilder.append(a2);
            }
            throw new HttpResponseException(a, stringBuilder.toString());
        }
    }

    private static String m26029a(InputStream inputStream) {
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                m26030a(inputStream, byteArrayOutputStream);
                String byteArrayOutputStream2 = byteArrayOutputStream.toString();
                return byteArrayOutputStream2;
            } finally {
                byteArrayOutputStream.close();
            }
        } finally {
            inputStream.close();
        }
    }

    private static void m26030a(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[1024];
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

package com.facebook.crudolib.netfb;

import com.facebook.crudolib.net.Releasable;
import com.facebook.crudolib.netengine.HttpEngineRequestBody;
import com.facebook.crudolib.params.ParamsCollection;
import com.facebook.crudolib.params.ParamsFormEncoder;
import com.facebook.crudolib.urlencode.AsciiOutputStreamWriter;
import java.io.OutputStream;

/* compiled from: ThreadsDbSchemaPart */
class ParamsFormEncodedBody implements Releasable, HttpEngineRequestBody {
    private final ParamsCollection f24115a;

    public ParamsFormEncodedBody(ParamsCollection paramsCollection) {
        this.f24115a = paramsCollection;
    }

    public final String mo1124b() {
        return "application/x-www-form-urlencoded";
    }

    public final long mo1123a() {
        return -1;
    }

    public final void mo1126a(OutputStream outputStream) {
        AsciiOutputStreamWriter asciiOutputStreamWriter = new AsciiOutputStreamWriter(outputStream);
        this.f24115a.a(ParamsFormEncoder.a());
        this.f24115a.a(asciiOutputStreamWriter);
    }

    public final void mo1125c() {
        this.f24115a.a();
    }
}

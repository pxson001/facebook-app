package com.facebook.http.entity.mime;

import com.facebook.crudolib.params.ParamsCollection;
import com.facebook.http.entity.mime.apache.content.AbstractContentBody;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;

/* compiled from: disconnect managed GoogleApiClient */
class ParamsCollectionBody extends AbstractContentBody {
    private final ParamsCollection f5021b;
    private final Charset f5022c;

    public ParamsCollectionBody(ParamsCollection paramsCollection, String str, Charset charset) {
        super(str);
        this.f5021b = paramsCollection;
        this.f5022c = charset;
    }

    public final void mo616a(OutputStream outputStream) {
        Writer outputStreamWriter = new OutputStreamWriter(outputStream);
        this.f5021b.a(outputStreamWriter);
        outputStreamWriter.flush();
    }

    public final String mo615a() {
        return null;
    }

    public final String mo617b() {
        return this.f5022c.name();
    }

    public final String mo618c() {
        return "8bit";
    }

    public final long mo619d() {
        return -1;
    }
}

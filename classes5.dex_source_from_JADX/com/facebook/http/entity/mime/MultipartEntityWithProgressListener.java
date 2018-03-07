package com.facebook.http.entity.mime;

import com.facebook.crudolib.params.ParamsCollection;
import com.facebook.crudolib.params.ParamsCollectionMap;
import com.facebook.http.entity.mime.apache.MultipartEntity;
import com.facebook.http.entity.mime.apache.content.StringBody;
import com.google.common.base.Charsets;
import java.io.OutputStream;
import java.util.ArrayList;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: discover_groups */
public class MultipartEntityWithProgressListener extends MultipartEntity implements Releasable {
    public ContentSerializationListener f5014a = null;
    @GuardedBy("this")
    private final ArrayList<ParamsCollection> f5015b = new ArrayList();

    public final void m9942a(ParamsCollectionMap paramsCollectionMap) {
        int j = paramsCollectionMap.j();
        for (int i = 0; i < j; i++) {
            String b = paramsCollectionMap.b(i);
            Object c = paramsCollectionMap.c(i);
            if (c == null) {
                throw new IllegalArgumentException("null values are not allowed");
            }
            if ((c instanceof String) || (c instanceof Number) || (c instanceof Boolean)) {
                m9940a(b, new StringBody(c.toString(), Charsets.UTF_8));
            } else if (c instanceof ParamsCollection) {
                m9940a(b, new ParamsCollectionBody((ParamsCollection) c, "text/plain", Charsets.UTF_8));
            } else {
                throw new IllegalArgumentException("Unsupported params type " + c.getClass().getName() + " at key " + b);
            }
        }
        synchronized (this) {
            this.f5015b.add(paramsCollectionMap);
        }
    }

    public void writeTo(OutputStream outputStream) {
        if (this.f5014a != null) {
            outputStream = new OutputStreamWithProgressListener(outputStream, this.f5014a);
        }
        super.writeTo(outputStream);
    }

    public final synchronized void m9941a() {
        for (int i = 0; i < this.f5015b.size(); i++) {
            ((ParamsCollection) this.f5015b.get(i)).a();
        }
    }
}

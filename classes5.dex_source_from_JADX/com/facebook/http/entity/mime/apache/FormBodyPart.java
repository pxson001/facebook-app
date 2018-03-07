package com.facebook.http.entity.mime.apache;

import com.facebook.http.entity.mime.apache.content.AbstractContentBody;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

/* compiled from: disclaimer_continue_button_text */
public class FormBodyPart {
    public final String f5024a;
    public final Header f5025b;
    public final AbstractContentBody f5026c;

    public FormBodyPart(String str, AbstractContentBody abstractContentBody) {
        if (str == null) {
            throw new IllegalArgumentException("Name may not be null");
        } else if (abstractContentBody == null) {
            throw new IllegalArgumentException("Body may not be null");
        } else {
            this.f5024a = str;
            this.f5026c = abstractContentBody;
            this.f5025b = new Header();
            m9955a(abstractContentBody);
            m9957b(abstractContentBody);
            m9958c(abstractContentBody);
        }
    }

    public final AbstractContentBody m9959b() {
        return this.f5026c;
    }

    private void m9956a(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Field name may not be null");
        }
        Header header = this.f5025b;
        MinimalField minimalField = new MinimalField(str, str2);
        if (minimalField != null) {
            String toLowerCase = minimalField.f5040a.toLowerCase(Locale.US);
            List list = (List) header.f5028b.get(toLowerCase);
            if (list == null) {
                list = new LinkedList();
                header.f5028b.put(toLowerCase, list);
            }
            list.add(minimalField);
            header.f5027a.add(minimalField);
        }
    }

    private void m9955a(AbstractContentBody abstractContentBody) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("form-data; name=\"");
        stringBuilder.append(this.f5024a);
        stringBuilder.append("\"");
        if (abstractContentBody.mo615a() != null) {
            stringBuilder.append("; filename=\"");
            stringBuilder.append(abstractContentBody.mo615a());
            stringBuilder.append("\"");
        }
        m9956a("Content-Disposition", stringBuilder.toString());
    }

    private void m9957b(AbstractContentBody abstractContentBody) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(abstractContentBody.f5018a);
        if (abstractContentBody.mo617b() != null) {
            stringBuilder.append("; charset=");
            stringBuilder.append(abstractContentBody.mo617b());
        }
        m9956a("Content-Type", stringBuilder.toString());
    }

    private void m9958c(AbstractContentBody abstractContentBody) {
        m9956a("Content-Transfer-Encoding", abstractContentBody.mo618c());
    }
}

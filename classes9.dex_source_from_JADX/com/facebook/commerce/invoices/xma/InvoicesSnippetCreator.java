package com.facebook.commerce.invoices.xma;

import android.content.Context;
import com.facebook.messaging.xma.SimpleSnippetCreator;
import javax.inject.Inject;

/* compiled from: quick_response_message */
public class InvoicesSnippetCreator extends SimpleSnippetCreator {
    @Inject
    public InvoicesSnippetCreator(Context context) {
        super(context);
    }

    protected final int m6283a() {
        return 2131240989;
    }

    protected final int m6284b() {
        return 2131240990;
    }
}

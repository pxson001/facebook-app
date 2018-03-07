package com.facebook.composer.shareintent.util;

import com.facebook.ipc.composer.intent.ComposerConfiguration;

/* compiled from: contacts_upload */
class AbstractShareIntentHandler$4 implements Runnable {
    final /* synthetic */ ComposerConfiguration f16875a;
    final /* synthetic */ int f16876b;
    final /* synthetic */ AbstractShareIntentHandler f16877c;

    AbstractShareIntentHandler$4(AbstractShareIntentHandler abstractShareIntentHandler, ComposerConfiguration composerConfiguration, int i) {
        this.f16877c = abstractShareIntentHandler;
        this.f16875a = composerConfiguration;
        this.f16876b = i;
    }

    public void run() {
        this.f16877c.y.a(null, this.f16875a, this.f16876b, this.f16877c);
    }
}

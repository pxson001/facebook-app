package org.whispersystems.curve25519;

/* compiled from: admin_text_thread_rtc_is_video_call */
public class JavaCurve25519Provider extends BaseJavaCurve25519Provider {
    protected JavaCurve25519Provider() {
        super(new JCESha512Provider(), new JCESecureRandomProvider());
    }
}

package com.facebook.imagepipeline.nativecode;

/* compiled from: TOPIC_VOTE_DIALOG */
public class WebpTranscoderFactory {
    public static boolean f13743a;
    public static WebpTranscoderImpl f13744b;

    static {
        f13743a = false;
        try {
            f13744b = (WebpTranscoderImpl) Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
            f13743a = true;
        } catch (Throwable th) {
            f13743a = false;
        }
    }
}

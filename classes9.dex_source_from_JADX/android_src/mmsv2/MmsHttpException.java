package android_src.mmsv2;

/* compiled from: setThreadEphemeralMode */
public class MmsHttpException extends Exception {
    private final int mStatusCode;

    public MmsHttpException(int i, String str) {
        super(str);
        this.mStatusCode = i;
    }

    public MmsHttpException(int i, Throwable th) {
        super(th);
        this.mStatusCode = i;
    }

    public MmsHttpException(int i, String str, Throwable th) {
        super(str, th);
        this.mStatusCode = i;
    }

    public final int m3537a() {
        return this.mStatusCode;
    }
}

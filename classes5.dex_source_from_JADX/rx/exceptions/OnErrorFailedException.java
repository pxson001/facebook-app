package rx.exceptions;

/* compiled from: box_left */
public class OnErrorFailedException extends RuntimeException {
    public OnErrorFailedException(String str, Throwable th) {
        super(str, th);
    }

    public OnErrorFailedException(Throwable th) {
        super(th.getMessage(), th);
    }
}

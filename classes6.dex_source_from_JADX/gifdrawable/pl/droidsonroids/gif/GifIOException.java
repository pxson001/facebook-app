package gifdrawable.pl.droidsonroids.gif;

import java.io.IOException;

/* compiled from: qn */
public class GifIOException extends IOException {
    private static final long serialVersionUID = 13038402904505L;
    public final GifError reason;

    GifIOException(GifError gifError) {
        super(gifError.getFormattedDescription());
        this.reason = gifError;
    }

    GifIOException(int i) {
        this(GifError.fromCode(i));
    }
}

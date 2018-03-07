package com.facebook.feed.spannable;

import com.google.common.base.Function;
import com.google.common.util.concurrent.FutureCallback;
import java.io.IOException;

/* compiled from: end_cursor */
class SpannableImageRangeApplicator$1 implements FutureCallback<CharSequence> {
    final /* synthetic */ Function f13030a;
    final /* synthetic */ SpannableImageRangeApplicator f13031b;

    SpannableImageRangeApplicator$1(SpannableImageRangeApplicator spannableImageRangeApplicator, Function function) {
        this.f13031b = spannableImageRangeApplicator;
        this.f13030a = function;
    }

    public void onSuccess(Object obj) {
        this.f13030a.apply(FeedSpannables.a((CharSequence) obj));
    }

    public void onFailure(Throwable th) {
        if (!(th instanceof IOException)) {
            this.f13031b.d.a("minutiae_spannable_replace", "failure while replacing text", th);
        }
    }
}

package com.facebook.messaging.mutators;

import com.facebook.messaging.model.threadkey.ThreadKey;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: rsrgrjrksqsosatwONbcbvuxPacvdzdwwbwsRAepxpfcy1ymylyoyaysALASgbglhyirjxjvjijc29kfkkksldlv49nnnzIN */
public class DeleteThreadDialogParams {
    public final ImmutableList<ThreadKey> f3324a;
    @Nullable
    public final String f3325b;
    @Nullable
    public final String f3326c;
    @Nullable
    public final String f3327d;

    /* compiled from: rsrgrjrksqsosatwONbcbvuxPacvdzdwwbwsRAepxpfcy1ymylyoyaysALASgbglhyirjxjvjijc29kfkkksldlv49nnnzIN */
    public final class Builder {
        public ImmutableList<ThreadKey> f3320a;
        public String f3321b;
        public String f3322c;
        public String f3323d;

        public final DeleteThreadDialogParams m3239a() {
            return new DeleteThreadDialogParams(this);
        }
    }

    public DeleteThreadDialogParams(Builder builder) {
        Preconditions.checkNotNull(builder.f3320a);
        this.f3324a = builder.f3320a;
        this.f3325b = builder.f3321b;
        this.f3326c = builder.f3322c;
        this.f3327d = builder.f3323d;
    }
}

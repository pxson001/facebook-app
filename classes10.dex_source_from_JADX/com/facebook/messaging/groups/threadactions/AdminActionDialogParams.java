package com.facebook.messaging.groups.threadactions;

import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.user.model.UserKey;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import javax.annotation.Nullable;

/* compiled from: sharing */
public class AdminActionDialogParams {
    public final ThreadKey f2552a;
    public final UserKey f2553b;
    @Nullable
    public final String f2554c;
    @Nullable
    public final String f2555d;
    @Nullable
    public final String f2556e;
    @Nullable
    public final String f2557f;
    @Nullable
    public final String f2558g;

    /* compiled from: sharing */
    public final class Builder {
        public ThreadKey f2545a;
        public UserKey f2546b;
        public String f2547c;
        public String f2548d;
        public String f2549e;
        public String f2550f;
        public String f2551g;

        public final AdminActionDialogParams m2563h() {
            return new AdminActionDialogParams(this);
        }
    }

    public AdminActionDialogParams(Builder builder) {
        this.f2552a = builder.f2545a;
        this.f2553b = builder.f2546b;
        this.f2554c = builder.f2547c;
        this.f2555d = builder.f2548d;
        this.f2556e = builder.f2549e;
        this.f2557f = builder.f2550f;
        this.f2558g = builder.f2551g;
        Preconditions.checkArgument(!Strings.isNullOrEmpty(this.f2558g));
    }
}

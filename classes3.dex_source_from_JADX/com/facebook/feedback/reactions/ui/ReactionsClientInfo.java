package com.facebook.feedback.reactions.ui;

import com.google.common.collect.ImmutableList;

/* compiled from: ufi/reactions/v6/24x24/dorothy */
public class ReactionsClientInfo {
    private static final ReactionsClientInfo f33a = new ReactionsClientInfo(-1, 0, 0, ReactionsClientInfoAsset.f53b, ReactionsClientInfoAsset.f53b, ReactionsClientInfoAsset.f53b, ReactionsClientInfoAsset.f53b, -16777216);
    private static final ReactionsClientInfo f34b = new ReactionsClientInfo(1, 0, 2131233267, new ReactionsClientInfoAsset(2130842943, "ufi/reactions/v2/16x16/like"), new ReactionsClientInfoAsset(2130842908, "ufi/reactions/v2/84x84/like"), new ReactionsClientInfoAsset(2130842942, "ufi/reactions/v2/24x24/like"), new ReactionsClientInfoAsset(0, "ufi/reactions/v2/face_models/like"), -10972929);
    private static final ReactionsClientInfo f35c = new ReactionsClientInfo(2, 1, 2131235942, new ReactionsClientInfoAsset(2130842945, "ufi/reactions/v2/16x16/love"), new ReactionsClientInfoAsset(2130842909, "ufi/reactions/v2/84x84/love"), new ReactionsClientInfoAsset(2130842944, "ufi/reactions/v2/24x24/love"), new ReactionsClientInfoAsset(0, "ufi/reactions/v2/face_models/love"), -896408);
    private static final ReactionsClientInfo f36d = new ReactionsClientInfo(3, 2, 2131235943, new ReactionsClientInfoAsset(2130842955, "ufi/reactions/v2/16x16/wow"), new ReactionsClientInfoAsset(2130842928, "ufi/reactions/v2/84x84/wow"), new ReactionsClientInfoAsset(2130842954, "ufi/reactions/v2/24x24/wow"), new ReactionsClientInfoAsset(0, "ufi/reactions/v2/face_models/wow"), -1000939);
    private static final ReactionsClientInfo f37e = new ReactionsClientInfo(4, 3, 2131235944, new ReactionsClientInfoAsset(2130842939, "ufi/reactions/v2/16x16/haha"), new ReactionsClientInfoAsset(2130842905, "ufi/reactions/v2/84x84/haha"), new ReactionsClientInfoAsset(2130842938, "ufi/reactions/v2/24x24/haha"), new ReactionsClientInfoAsset(0, "ufi/reactions/v2/face_models/haha"), -1000939);
    private static final ReactionsClientInfo f38f = new ReactionsClientInfo(5, 4, 0, new ReactionsClientInfoAsset(2130842957, "ufi/reactions/v2/16x16/yay"), ReactionsClientInfoAsset.f52a, new ReactionsClientInfoAsset(2130842956, "ufi/reactions/v2/24x24/yay"), new ReactionsClientInfoAsset(0, ""), -1000939);
    private static final ReactionsClientInfo f39g = new ReactionsClientInfo(7, 6, 2131235945, new ReactionsClientInfoAsset(2130842950, "ufi/reactions/v2/16x16/sad"), new ReactionsClientInfoAsset(2130842923, "ufi/reactions/v2/84x84/sad"), new ReactionsClientInfoAsset(2130842949, "ufi/reactions/v2/24x24/sad"), new ReactionsClientInfoAsset(0, "ufi/reactions/v2/face_models/sad"), -1000939);
    private static final ReactionsClientInfo f40h = new ReactionsClientInfo(8, 5, 2131235946, new ReactionsClientInfoAsset(2130842930, "ufi/reactions/v2/16x16/anger"), new ReactionsClientInfoAsset(2130842885, "ufi/reactions/v2/84x84/anger"), new ReactionsClientInfoAsset(2130842929, "ufi/reactions/v2/24x24/anger"), new ReactionsClientInfoAsset(0, "ufi/reactions/v2/face_models/anger"), -560821);
    private static final ReactionsClientInfo f41i = new ReactionsClientInfo(10, 7, 0, new ReactionsClientInfoAsset(2130842932, "ufi/reactions/v2/16x16/confused"), ReactionsClientInfoAsset.f52a, new ReactionsClientInfoAsset(2130842931, "ufi/reactions/v2/24x24/confused"), new ReactionsClientInfoAsset(0, ""), -1000939);
    private static final ReactionsClientInfo f42j = new ReactionsClientInfo(11, 0, 2131235947, new ReactionsClientInfoAsset(2130842953, "ufi/reactions/v6/16x16/dorothy"), new ReactionsClientInfoAsset(2130842924, "ufi/reactions/v6/84x84/dorothy"), new ReactionsClientInfoAsset(2130842952, "ufi/reactions/v6/24x24/dorothy"), new ReactionsClientInfoAsset(0, "ufi/reactions/v4/face_models/dorothy"), -6518831);
    public static final ImmutableList<ReactionsClientInfo> f43k = ImmutableList.builder().c(f34b).c(f35c).c(f37e).c(f38f).c(f36d).c(f41i).c(f39g).c(f40h).c(f42j).b();
    public final int f44l;
    public final ReactionsClientInfoAsset f45m;
    public final ReactionsClientInfoAsset f46n;
    public final ReactionsClientInfoAsset f47o;
    public final ReactionsClientInfoAsset f48p;
    public final int f49q;
    private final int f50r;
    private final int f51s;

    /* compiled from: ufi/reactions/v6/24x24/dorothy */
    public class ReactionsClientInfoAsset {
        public static ReactionsClientInfoAsset f52a = new ReactionsClientInfoAsset(0, "");
        public static ReactionsClientInfoAsset f53b = new ReactionsClientInfoAsset(2130842947, "");
        public final int f54c;
        public final String f55d;

        public ReactionsClientInfoAsset(int i, String str) {
            this.f54c = i;
            this.f55d = str;
        }

        public final String m36b() {
            return this.f55d;
        }
    }

    private ReactionsClientInfo(int i, int i2, int i3, ReactionsClientInfoAsset reactionsClientInfoAsset, ReactionsClientInfoAsset reactionsClientInfoAsset2, ReactionsClientInfoAsset reactionsClientInfoAsset3, ReactionsClientInfoAsset reactionsClientInfoAsset4, int i4) {
        this.f44l = i;
        this.f49q = i2;
        this.f50r = i3;
        this.f45m = reactionsClientInfoAsset;
        this.f46n = reactionsClientInfoAsset2;
        this.f47o = reactionsClientInfoAsset3;
        this.f48p = reactionsClientInfoAsset4;
        this.f51s = i4;
    }

    public final int m31a() {
        return this.f44l;
    }

    public final int m32b() {
        return this.f49q;
    }

    public final int m33c() {
        return this.f50r;
    }

    public final ReactionsClientInfoAsset m34g() {
        return this.f48p;
    }

    public final int m35h() {
        return this.f51s;
    }

    public static ReactionsClientInfo m30a(int i) {
        ImmutableList immutableList = f43k;
        int size = immutableList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ReactionsClientInfo reactionsClientInfo = (ReactionsClientInfo) immutableList.get(i2);
            if (reactionsClientInfo.f44l == i) {
                return reactionsClientInfo;
            }
        }
        return f33a;
    }
}

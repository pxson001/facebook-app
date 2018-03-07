package com.facebook.photos.upload.protocol;

import com.facebook.composer.publish.protocol.TopicFeedsPublishHelper;
import com.facebook.ipc.composer.model.MinutiaeTag;
import com.facebook.ipc.composer.model.PublishMode;
import com.facebook.ipc.composer.model.RedSpaceValue;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.util.Set;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: getPhoneNumber */
public class AttachPhotoParam {
    public final String f13965a;
    @Nullable
    public final String f13966b;
    @Nullable
    public final String f13967c;
    @Nullable
    public final String f13968d;
    @Nullable
    public final String f13969e;
    @Nullable
    public final String f13970f;
    @Nullable
    public final String f13971g;
    @Nullable
    public final String f13972h;
    @Nullable
    public final String f13973i;
    @Nullable
    public final MinutiaeTag f13974j;
    @Nullable
    public final String f13975k;
    @Nullable
    public final String f13976l;
    @Nullable
    public final boolean f13977m;
    @Nullable
    public final boolean f13978n;
    @Nullable
    public final boolean f13979o;
    public final boolean f13980p;
    public final RedSpaceValue f13981q;
    @Nullable
    public final String f13982r;
    public final boolean f13983s;
    public final long f13984t;
    public final int f13985u;
    public final PublishMode f13986v;
    public final long f13987w;
    public final boolean f13988x;

    public static AttachPhotoParam m21688a(String str, String str2, String str3, String str4, long j, int i, RedSpaceValue redSpaceValue, String str5, String str6, boolean z, boolean z2, boolean z3, PublishMode publishMode, long j2, boolean z4, ImmutableList<String> immutableList, boolean z5) {
        return new AttachPhotoParam(str, null, str2, str3, str4, true, null, null, null, null, MinutiaeTag.a, false, redSpaceValue, immutableList, str5, str6, z, z2, z3, j, i, publishMode, j2, z4, z5);
    }

    public static AttachPhotoParam m21689a(String str, String str2, String str3, String str4, String str5, String str6, @Nullable String str7, Set<Long> set, String str8, MinutiaeTag minutiaeTag, boolean z, RedSpaceValue redSpaceValue, String str9, String str10, boolean z2, boolean z3, boolean z4, long j, int i, boolean z5, boolean z6, ImmutableList<String> immutableList, boolean z7) {
        return new AttachPhotoParam(str, str2, str3, str4, str5, z6, str6, str7, set, str8, minutiaeTag, z, redSpaceValue, immutableList, str9, str10, z2, z3, z4, j, i, PublishMode.NORMAL, 0, z5, z7);
    }

    private AttachPhotoParam(String str, String str2, String str3, String str4, String str5, boolean z, String str6, @Nullable String str7, Set<Long> set, String str8, MinutiaeTag minutiaeTag, boolean z2, RedSpaceValue redSpaceValue, ImmutableList<String> immutableList, String str9, String str10, boolean z3, boolean z4, boolean z5, long j, int i, PublishMode publishMode, long j2, boolean z6, boolean z7) {
        boolean z8 = (Strings.isNullOrEmpty(str2) && Strings.isNullOrEmpty(str3)) ? false : true;
        Preconditions.checkState(z8);
        this.f13965a = str;
        this.f13968d = str4;
        this.f13969e = str5;
        this.f13970f = str6;
        this.f13971g = str7;
        this.f13972h = m21690a(set);
        if (z) {
            this.f13966b = str3;
            this.f13967c = str2;
        } else {
            this.f13966b = null;
            this.f13967c = str2;
        }
        this.f13973i = str8;
        if (minutiaeTag != MinutiaeTag.a) {
            this.f13974j = minutiaeTag;
        } else {
            this.f13974j = null;
        }
        this.f13980p = z2;
        this.f13981q = redSpaceValue;
        this.f13982r = TopicFeedsPublishHelper.m11662a(immutableList);
        this.f13984t = j;
        this.f13985u = i;
        this.f13986v = publishMode;
        this.f13987w = j2;
        this.f13975k = str9;
        this.f13976l = str10;
        this.f13977m = z3;
        this.f13978n = z4;
        this.f13979o = z5;
        this.f13983s = z6;
        this.f13988x = z7;
    }

    @Nullable
    private static String m21690a(Set<Long> set) {
        if (set == null || set.isEmpty()) {
            return null;
        }
        return "[" + Joiner.on(',').skipNulls().join(set) + "]";
    }
}

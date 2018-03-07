package com.facebook.timeline.services.data;

import com.facebook.graphql.enums.GraphQLTimelineContextListTargetType;
import com.facebook.ipc.composer.intent.graphql.FetchComposerTargetDataPrivacyScopeInterfaces.ComposerTargetDataPrivacyScopeFields;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: unable to create chunks from file */
public class ProfileContextItemNavigationData {
    public final int f1143a;
    public final String f1144b;
    public final String f1145c;
    public final String f1146d;
    public final FullscreenGallerySource f1147e;
    public final GraphQLTimelineContextListTargetType f1148f;
    public final String f1149g;
    public final String f1150h;
    public final String f1151i;
    public final ComposerTargetDataPrivacyScopeFields f1152j;
    public final String f1153k;
    public final String f1154l;
    public final String f1155m;
    public final String f1156n;
    public final String f1157o;

    /* compiled from: unable to create chunks from file */
    public class Builder {
        public int f1128a;
        public String f1129b;
        public String f1130c;
        public String f1131d;
        public FullscreenGallerySource f1132e;
        public GraphQLTimelineContextListTargetType f1133f;
        public String f1134g;
        public String f1135h;
        public String f1136i;
        public ComposerTargetDataPrivacyScopeFields f1137j;
        public String f1138k;
        public String f1139l;
        public String f1140m;
        public String f1141n;
        public String f1142o;

        public final ProfileContextItemNavigationData m1203a() {
            Preconditions.checkNotNull(this.f1132e);
            Preconditions.checkNotNull(this.f1138k);
            return new ProfileContextItemNavigationData(this.f1128a, this.f1129b, this.f1130c, this.f1131d, this.f1132e, this.f1133f, this.f1134g, this.f1135h, this.f1136i, this.f1137j, this.f1138k, this.f1139l, this.f1140m, this.f1141n, this.f1142o);
        }
    }

    private ProfileContextItemNavigationData(@Nullable int i, @Nullable String str, @Nullable String str2, @Nullable String str3, FullscreenGallerySource fullscreenGallerySource, @Nullable GraphQLTimelineContextListTargetType graphQLTimelineContextListTargetType, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable ComposerTargetDataPrivacyScopeFields composerTargetDataPrivacyScopeFields, String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable String str11) {
        this.f1143a = i;
        this.f1144b = str;
        this.f1145c = str2;
        this.f1146d = str3;
        this.f1147e = fullscreenGallerySource;
        this.f1148f = graphQLTimelineContextListTargetType;
        this.f1149g = str4;
        this.f1150h = str5;
        this.f1151i = str6;
        this.f1152j = composerTargetDataPrivacyScopeFields;
        this.f1153k = str7;
        this.f1154l = str8;
        this.f1155m = str9;
        this.f1156n = str10;
        this.f1157o = str11;
    }
}

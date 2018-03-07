package com.facebook.timeline.refresher;

import com.facebook.graphql.enums.GraphQLProfileWizardStepType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.ipc.composer.intent.graphql.FetchComposerTargetDataPrivacyScopeInterfaces.ComposerTargetDataPrivacyScopeFields;
import com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.RefresherStepsNodeFieldsModel;
import com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineNuxQueryModel;
import com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineRefresherQueryModel;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: unsuccessful_deeplink */
public class ProfileRefresherModel {
    public final String f1013a;
    public final String f1014b;
    public String f1015c;
    public String f1016d;
    public boolean f1017e;
    public boolean f1018f;
    public ComposerTargetDataPrivacyScopeFields f1019g;
    public int f1020h = 0;
    public int f1021i;
    private ImmutableList<RefresherStepsNodeFieldsModel> f1022j;
    public GraphQLProfileWizardStepType f1023k;
    @Nullable
    public BaseModel f1024l;

    /* compiled from: unsuccessful_deeplink */
    public class Builder {
        public String f1007a;
        public String f1008b;
        public String f1009c;
        public String f1010d;
        public boolean f1011e;
        public ComposerTargetDataPrivacyScopeFields f1012f;
    }

    public ProfileRefresherModel(String str, String str2, String str3, String str4, boolean z, ComposerTargetDataPrivacyScopeFields composerTargetDataPrivacyScopeFields) {
        this.f1013a = str;
        this.f1014b = str2;
        this.f1015c = str3;
        this.f1016d = str4;
        this.f1017e = false;
        this.f1018f = z;
        this.f1019g = composerTargetDataPrivacyScopeFields;
    }

    public final void m1027a(BaseModel baseModel) {
        this.f1024l = baseModel;
        this.f1022j = this.f1018f ? ((TimelineRefresherQueryModel) baseModel).m1148a().m1093j().m1098a() : ((TimelineNuxQueryModel) baseModel).m1143a().m1082j().m1098a();
        ImmutableList immutableList = this.f1022j;
        com.google.common.collect.ImmutableList.Builder builder = new com.google.common.collect.ImmutableList.Builder();
        int a = m1025a(immutableList, GraphQLProfileWizardStepType.PROFILE_PICTURE);
        if (a != -1) {
            builder.c(immutableList.get(a));
        }
        a = m1025a(immutableList, GraphQLProfileWizardStepType.COVER_PHOTO);
        if (a != -1) {
            builder.c(immutableList.get(a));
        }
        a = m1025a(immutableList, GraphQLProfileWizardStepType.CORE_PROFILE_FIELD);
        if (a != -1) {
            builder.c(immutableList.get(a));
        }
        a = m1025a(immutableList, GraphQLProfileWizardStepType.COMPOSER);
        if (a != -1) {
            builder.c(immutableList.get(a));
        }
        this.f1022j = builder.b();
        this.f1021i = this.f1022j.size() + 1;
    }

    public static int m1025a(ImmutableList<RefresherStepsNodeFieldsModel> immutableList, GraphQLProfileWizardStepType graphQLProfileWizardStepType) {
        for (int i = 0; i < immutableList.size(); i++) {
            if (((RefresherStepsNodeFieldsModel) immutableList.get(i)).m1115j() == graphQLProfileWizardStepType) {
                return i;
            }
        }
        return -1;
    }

    public final String m1029c() {
        Preconditions.checkArgument(this.f1024l != null);
        if (m1026u()) {
            return "";
        }
        return ((RefresherStepsNodeFieldsModel) this.f1022j.get(this.f1020h)).m1116k().m1111a();
    }

    public final String m1030d() {
        Preconditions.checkArgument(this.f1024l != null);
        if (m1026u()) {
            return "";
        }
        return ((RefresherStepsNodeFieldsModel) this.f1022j.get(this.f1020h)).m1114a().m1104a();
    }

    @Nullable
    public final GraphQLProfileWizardStepType m1031e() {
        Preconditions.checkArgument(this.f1024l != null);
        if (m1026u()) {
            return null;
        }
        return ((RefresherStepsNodeFieldsModel) this.f1022j.get(this.f1020h)).m1115j();
    }

    public final ImmutableList<GraphQLProfileWizardStepType> m1032f() {
        boolean z;
        int i = 0;
        if (this.f1024l != null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        com.google.common.collect.ImmutableList.Builder builder = new com.google.common.collect.ImmutableList.Builder();
        int size = this.f1022j.size();
        while (i < size) {
            builder.c(((RefresherStepsNodeFieldsModel) this.f1022j.get(i)).m1115j());
            i++;
        }
        return builder.b();
    }

    public final void m1033h() {
        Preconditions.checkState(this.f1020h < this.f1021i);
        this.f1020h++;
    }

    public final boolean m1034q() {
        return this.f1024l != null;
    }

    private boolean m1026u() {
        return this.f1020h >= this.f1021i + -1 || this.f1022j.get(this.f1020h) == null;
    }

    public final boolean m1028b(GraphQLProfileWizardStepType graphQLProfileWizardStepType) {
        Preconditions.checkArgument(this.f1024l != null);
        int size = this.f1022j.size();
        for (int i = 0; i < size; i++) {
            if (((RefresherStepsNodeFieldsModel) this.f1022j.get(i)).m1115j() == graphQLProfileWizardStepType) {
                return true;
            }
        }
        return false;
    }
}

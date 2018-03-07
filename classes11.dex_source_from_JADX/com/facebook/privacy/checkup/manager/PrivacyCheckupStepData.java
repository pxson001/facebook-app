package com.facebook.privacy.checkup.manager;

import android.text.TextUtils;
import com.facebook.graphql.enums.GraphQLEditablePrivacyScopeType;
import com.facebook.graphql.enums.GraphQLPrivacyCheckupActionType;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyIconFields;
import com.facebook.privacy.spinner.AudienceSpinnerData;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.annotation.Nullable;

/* compiled from: SubsequentLoad */
public class PrivacyCheckupStepData {
    public ArrayList<PrivacyCheckupRowType> f10965a = new ArrayList();
    public HashMap<String, PrivacyCheckupItemRow> f10966b = new HashMap();
    public final PrivacyCheckupStepType f10967c;
    public ImmutableList<GraphQLPrivacyCheckupActionType> f10968d = RegularImmutableList.a;
    public String f10969e;
    public String f10970f;
    public String f10971g;
    public String f10972h;
    public boolean f10973i = false;
    public String f10974j;
    public boolean f10975k = true;
    public String f10976l;
    public String f10977m;
    public String f10978n;
    public String f10979o;
    public ImmutableList<String> f10980p;
    public String f10981q;

    /* compiled from: SubsequentLoad */
    public interface PrivacyCheckupRowType {
    }

    /* compiled from: SubsequentLoad */
    public class PrivacyCheckupHeaderRow implements PrivacyCheckupRowType {
        public final String f10945a;

        public PrivacyCheckupHeaderRow(String str) {
            this.f10945a = str;
        }
    }

    /* compiled from: SubsequentLoad */
    public class PrivacyCheckupInfoRow implements PrivacyCheckupRowType {
        public final String f10946a;

        public PrivacyCheckupInfoRow(String str) {
            this.f10946a = str;
        }
    }

    /* compiled from: SubsequentLoad */
    public class PrivacyCheckupItemRow implements PrivacyCheckupRowType {
        public final String f10956a;
        public final GraphQLEditablePrivacyScopeType f10957b;
        public final String f10958c;
        public final String f10959d;
        public final String f10960e;
        public final AudienceSpinnerData f10961f;
        public final String f10962g;
        public final PrivacyIconFields f10963h;
        public final boolean f10964i;

        /* compiled from: SubsequentLoad */
        public final class Builder {
            public final String f10947a;
            public final GraphQLEditablePrivacyScopeType f10948b;
            public final String f10949c;
            public final String f10950d;
            public final String f10951e;
            public AudienceSpinnerData f10952f;
            public String f10953g;
            public PrivacyIconFields f10954h;
            public boolean f10955i;

            public Builder(PrivacyCheckupItemRow privacyCheckupItemRow) {
                this.f10947a = privacyCheckupItemRow.f10956a;
                this.f10948b = privacyCheckupItemRow.f10957b;
                this.f10949c = privacyCheckupItemRow.f10958c;
                this.f10950d = privacyCheckupItemRow.f10959d;
                this.f10951e = privacyCheckupItemRow.f10960e;
                this.f10952f = privacyCheckupItemRow.f10961f;
                this.f10953g = privacyCheckupItemRow.f10962g;
                this.f10954h = privacyCheckupItemRow.f10963h;
                this.f10955i = privacyCheckupItemRow.f10964i;
            }

            public final PrivacyCheckupItemRow m11367a() {
                return new PrivacyCheckupItemRow(this.f10947a, this.f10948b, this.f10949c, this.f10950d, this.f10951e, this.f10952f, this.f10953g, this.f10954h, this.f10955i);
            }
        }

        public PrivacyCheckupItemRow(String str, GraphQLEditablePrivacyScopeType graphQLEditablePrivacyScopeType, String str2, String str3, String str4, AudienceSpinnerData audienceSpinnerData, String str5, PrivacyIconFields privacyIconFields, boolean z) {
            this.f10956a = str;
            this.f10957b = graphQLEditablePrivacyScopeType;
            this.f10958c = str2;
            this.f10959d = str3;
            this.f10960e = str4;
            this.f10961f = audienceSpinnerData;
            this.f10962g = str5;
            this.f10963h = privacyIconFields;
            this.f10964i = z;
        }
    }

    /* compiled from: SubsequentLoad */
    public enum PrivacyCheckupStepType {
        COMPOSER_STEP,
        PROFILE_STEP,
        APPS_STEP,
        GENERIC_STEP,
        ALIGNMENT_ROADBLOCK_STEP
    }

    public PrivacyCheckupStepData(PrivacyCheckupStepType privacyCheckupStepType) {
        this.f10967c = privacyCheckupStepType;
    }

    public final void m11369a(@Nullable ImmutableList<GraphQLPrivacyCheckupActionType> immutableList) {
        if (immutableList == null) {
            this.f10968d = RegularImmutableList.a;
        } else {
            this.f10968d = immutableList;
        }
    }

    public final void m11370a(Collection<PrivacyCheckupRowType> collection) {
        for (PrivacyCheckupRowType privacyCheckupRowType : collection) {
            this.f10965a.add(privacyCheckupRowType);
            if (privacyCheckupRowType instanceof PrivacyCheckupItemRow) {
                PrivacyCheckupItemRow privacyCheckupItemRow = (PrivacyCheckupItemRow) privacyCheckupRowType;
                this.f10966b.put(privacyCheckupItemRow.f10956a, privacyCheckupItemRow);
            }
        }
    }

    public final void m11368a(PrivacyCheckupStepData privacyCheckupStepData) {
        this.f10973i = privacyCheckupStepData.f10973i;
        this.f10968d = privacyCheckupStepData.f10968d;
        this.f10965a.addAll(privacyCheckupStepData.f10965a);
        this.f10966b.putAll(privacyCheckupStepData.f10966b);
        this.f10975k = privacyCheckupStepData.f10975k;
        this.f10974j = privacyCheckupStepData.f10974j;
        this.f10980p = privacyCheckupStepData.f10980p;
        if (!TextUtils.isEmpty(privacyCheckupStepData.f10969e)) {
            this.f10969e = privacyCheckupStepData.f10969e;
        }
        if (!TextUtils.isEmpty(privacyCheckupStepData.f10970f)) {
            this.f10970f = privacyCheckupStepData.f10970f;
        }
        if (!TextUtils.isEmpty(privacyCheckupStepData.f10971g)) {
            this.f10971g = privacyCheckupStepData.f10971g;
        }
        if (!TextUtils.isEmpty(privacyCheckupStepData.f10972h)) {
            this.f10972h = privacyCheckupStepData.f10972h;
        }
        if (!TextUtils.isEmpty(privacyCheckupStepData.f10976l)) {
            this.f10976l = privacyCheckupStepData.f10976l;
        }
        if (!TextUtils.isEmpty(privacyCheckupStepData.f10977m)) {
            this.f10977m = privacyCheckupStepData.f10977m;
        }
        if (!TextUtils.isEmpty(privacyCheckupStepData.f10978n)) {
            this.f10978n = privacyCheckupStepData.f10978n;
        }
        if (!TextUtils.isEmpty(privacyCheckupStepData.f10979o)) {
            this.f10979o = privacyCheckupStepData.f10979o;
        }
        if (!TextUtils.isEmpty(privacyCheckupStepData.f10981q)) {
            this.f10981q = privacyCheckupStepData.f10981q;
        }
    }
}

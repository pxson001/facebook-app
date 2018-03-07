package com.facebook.privacy.model;

import android.content.res.Resources;
import com.facebook.graphql.enums.GraphQLPrivacyOptionTagExpansionType;
import com.facebook.widget.tokenizedtypeahead.model.BaseToken.Type;
import com.google.common.base.Objects;

/* compiled from: fbupload_file_upload_succeeded */
public class TagExpansionToken extends PrivacyToken {
    private final GraphQLPrivacyOptionTagExpansionType f15112k;
    private final boolean f15113l;
    private final Resources f15114m;
    private final boolean f15115n;
    private final boolean f15116o;
    private final int f15117p;

    public final /* synthetic */ Object mo1186d() {
        return mo1196c();
    }

    public TagExpansionToken(GraphQLPrivacyOptionTagExpansionType graphQLPrivacyOptionTagExpansionType, Resources resources, boolean z, boolean z2, boolean z3, int i) {
        super(Type.TAG_EXPANSION);
        this.f15112k = graphQLPrivacyOptionTagExpansionType;
        this.f15113l = z;
        this.f15114m = resources;
        this.f15115n = z2;
        this.f15116o = z3;
        this.f15117p = i;
        if (this.f15112k == GraphQLPrivacyOptionTagExpansionType.FRIENDS_OF_TAGGEES) {
            if (this.f15113l) {
                this.e = 2130837705;
            } else {
                this.e = 2130837704;
            }
        } else if (this.f15112k != GraphQLPrivacyOptionTagExpansionType.TAGGEES) {
            this.e = 0;
        } else if (this.f15113l) {
            this.e = 2130837709;
        } else if (this.f15115n) {
            this.e = 2130837708;
        } else {
            this.e = 2130837712;
        }
    }

    public final Integer mo1196c() {
        return null;
    }

    public final String mo1185b() {
        if (this.f15113l) {
            return "";
        }
        if (this.f15112k == GraphQLPrivacyOptionTagExpansionType.FRIENDS_OF_TAGGEES) {
            return this.f15114m.getString(2131234219);
        }
        if (this.f15112k == GraphQLPrivacyOptionTagExpansionType.TAGGEES) {
            return this.f15114m.getString(2131234220);
        }
        return "";
    }

    public final boolean mo1195a() {
        return this.f15115n;
    }

    public final int mo1190h() {
        if (this.f15112k == GraphQLPrivacyOptionTagExpansionType.FRIENDS_OF_TAGGEES) {
            return 2130837707;
        }
        if (this.f15112k == GraphQLPrivacyOptionTagExpansionType.TAGGEES) {
            return 2130837711;
        }
        return mo1187e();
    }

    public final int mo1188f() {
        if (!this.f15116o) {
            return -1;
        }
        if (this.f15112k == GraphQLPrivacyOptionTagExpansionType.FRIENDS_OF_TAGGEES) {
            return 2130839894;
        }
        return 2130840122;
    }

    public final int mo1189g() {
        return this.f15117p;
    }

    public final String mo1191i() {
        return null;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f15112k});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof TagExpansionToken) {
            return this.f15112k.equals(((TagExpansionToken) obj).f15112k);
        }
        return false;
    }
}

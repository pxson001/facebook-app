package com.facebook.widget.tokenizedtypeahead.model;

import com.facebook.widget.tokenizedtypeahead.model.BaseToken.Type;
import com.google.common.base.Objects;
import java.util.List;

/* compiled from: com.facebook.platform.status.ERROR_JSON */
public class GroupTagToken extends BaseToken<List<SimpleUserToken>> {
    public List<SimpleUserToken> f20115e;
    public String f20116f;

    public GroupTagToken(List<SimpleUserToken> list, String str) {
        super(Type.GROUP_TAG);
        this.f20115e = list;
        this.f20116f = str;
    }

    public final /* synthetic */ Object mo1186d() {
        return this.f20115e;
    }

    public final String mo1185b() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < this.f20115e.size(); i++) {
            SimpleUserToken simpleUserToken = (SimpleUserToken) this.f20115e.get(i);
            if (simpleUserToken.f20123e != null) {
                stringBuilder.append(simpleUserToken.f20123e.g());
            }
            if (i < this.f20115e.size() - 1) {
                stringBuilder.append(", ");
            }
        }
        return stringBuilder.toString();
    }

    public final int mo1187e() {
        return -1;
    }

    public final int mo1188f() {
        return -1;
    }

    public final int mo1189g() {
        return -1;
    }

    public final int mo1190h() {
        return -1;
    }

    public final String mo1191i() {
        return ((SimpleUserToken) this.f20115e.get(0)).mo1191i();
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f20115e});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof GroupTagToken) {
            return Objects.equal(this.f20115e, ((GroupTagToken) obj).f20115e);
        }
        return false;
    }
}

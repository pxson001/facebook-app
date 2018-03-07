package com.facebook.feedback.ui;

import android.content.Context;
import android.net.Uri;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLCommentHelper;
import com.facebook.graphql.model.GraphQLHelper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: row_number */
public class FriendsOnlySocialPillHelper {
    public final List<Uri> f4583a = new ArrayList();
    public final Set<String> f4584b = new HashSet();
    public final Set<String> f4585c = new HashSet();
    public int f4586d = 0;
    public GraphQLComment f4587e;
    public Mode f4588f;

    /* compiled from: row_number */
    public enum Mode {
        ONE_FRIEND_ONLY,
        TWO_FRIENDS_ONLY,
        NO_FRIENDS,
        FRIEND_AND_OTHERS
    }

    public final CharSequence m5138a(Context context) {
        if (this.f4587e == null || this.f4587e.r() == null) {
            Object obj = null;
        } else {
            String b = m5137b(this.f4587e);
        }
        switch (this.f4588f) {
            case NO_FRIENDS:
                return context.getResources().getQuantityString(2131689526, this.f4586d, new Object[]{Integer.valueOf(this.f4586d)});
            case ONE_FRIEND_ONLY:
                return context.getString(2131233319, new Object[]{obj});
            case TWO_FRIENDS_ONLY:
                String[] strArr = (String[]) this.f4584b.toArray(new String[this.f4584b.size()]);
                Object obj2 = strArr[0].equals(obj) ? strArr[1] : strArr[0];
                return context.getString(2131233320, new Object[]{obj, obj2});
            case FRIEND_AND_OTHERS:
                return context.getResources().getQuantityString(2131689527, (this.f4584b.size() + this.f4585c.size()) - 1, new Object[]{obj, Integer.valueOf((this.f4584b.size() + this.f4585c.size()) - 1)});
            default:
                return context.getString(2131233314);
        }
    }

    public final void m5139b() {
        this.f4586d = 0;
        this.f4583a.clear();
        this.f4584b.clear();
        this.f4585c.clear();
        this.f4587e = null;
    }

    public static String m5137b(GraphQLComment graphQLComment) {
        if (graphQLComment == null || graphQLComment.r() == null) {
            return null;
        }
        return graphQLComment.r().as() == null ? GraphQLCommentHelper.a(graphQLComment) : GraphQLHelper.a(graphQLComment.r().as());
    }
}

package com.facebook.fql;

import com.facebook.common.util.StringUtil;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import java.util.List;

/* compiled from: WWW_PAGE_REACTION_SANDBOX */
public class FqlHelper {

    /* compiled from: WWW_PAGE_REACTION_SANDBOX */
    public class Condition {
        private final String f12293a;

        Condition(String str) {
            this.f12293a = str;
        }

        public String toString() {
            return this.f12293a;
        }
    }

    /* compiled from: WWW_PAGE_REACTION_SANDBOX */
    public class CompoundCondition extends Condition {
        CompoundCondition(Condition condition, Condition condition2, String str) {
            super("(" + condition.toString() + " " + str + " " + condition2.toString() + ")");
        }
    }

    /* compiled from: WWW_PAGE_REACTION_SANDBOX */
    public class AndCondition extends CompoundCondition {
        AndCondition(Condition condition, Condition condition2) {
            super(condition, condition2, "AND");
        }

        public final AndCondition m20369a(Condition condition) {
            return new AndCondition(this, condition);
        }
    }

    /* compiled from: WWW_PAGE_REACTION_SANDBOX */
    public class BasicCondition extends Condition {
        public BasicCondition(String str) {
            super(str);
        }

        public final AndCondition m20370a(Condition condition) {
            return new AndCondition(this, condition);
        }
    }

    /* compiled from: WWW_PAGE_REACTION_SANDBOX */
    public abstract class Expression {
        private BasicCondition m20372c(String str) {
            return new BasicCondition(toString() + " = " + str);
        }

        public final BasicCondition m20376a(String str) {
            return m20372c(new StringValue(str).toString());
        }

        private BasicCondition m20371a(Expression expression) {
            return m20372c(expression.toString());
        }

        public final BasicCondition m20374a(long j) {
            return m20371a(new NumericValue(j));
        }

        public final BasicCondition m20373a(double d) {
            return m20371a(new StringValue(String.valueOf(d)));
        }

        public final BasicCondition m20375a(Query query) {
            return new BasicCondition(toString() + " IN (" + query.toString() + ")");
        }

        public final BasicCondition m20377b(String str) {
            return new BasicCondition("strpos(lower(" + toString() + ")," + new StringValue(str) + ") == 0");
        }
    }

    /* compiled from: WWW_PAGE_REACTION_SANDBOX */
    public class Field extends Expression {
        public String f12294a;

        public Field(String str) {
            this.f12294a = str;
        }

        public String toString() {
            return this.f12294a.toString();
        }

        public int hashCode() {
            return Objects.hashCode(new Object[]{this.f12294a});
        }

        public boolean equals(Object obj) {
            if ((obj instanceof Field) && obj.getClass() == getClass()) {
                return Objects.equal(this.f12294a, ((Field) obj).f12294a);
            }
            return false;
        }
    }

    /* compiled from: WWW_PAGE_REACTION_SANDBOX */
    public class Query {
        public final String f12295a;
        private final StringBuilder f12296b = new StringBuilder();

        public Query(String str) {
            this.f12295a = str;
        }

        public Query(Query query) {
            this.f12295a = query.f12295a;
            this.f12296b.append(query.f12296b.toString());
        }

        protected final void m20382a(CharSequence charSequence) {
            this.f12296b.append(charSequence);
        }

        public String toString() {
            return this.f12296b.toString();
        }

        public QueryWithSelect m20380a(Field... fieldArr) {
            Query queryWithSelect = new QueryWithSelect(this);
            queryWithSelect.m20382a((CharSequence) "SELECT");
            int length = fieldArr.length;
            Object obj = 1;
            int i = 0;
            while (i < length) {
                Field field = fieldArr[i];
                if (obj == null) {
                    queryWithSelect.m20382a((CharSequence) ",");
                }
                queryWithSelect.m20382a((CharSequence) " ");
                queryWithSelect.m20382a(field.toString());
                i++;
                obj = null;
            }
            return queryWithSelect;
        }

        public QueryWithFrom m20378a(Table table) {
            Query queryWithFrom = new QueryWithFrom(this);
            queryWithFrom.m20382a((CharSequence) " FROM ");
            queryWithFrom.m20382a(table.toString());
            return queryWithFrom;
        }

        public QueryWithWhere m20381a(Condition condition) {
            Query queryWithWhere = new QueryWithWhere(this);
            queryWithWhere.m20382a((CharSequence) " WHERE ");
            queryWithWhere.m20382a(condition.toString());
            return queryWithWhere;
        }

        public QueryWithLimit m20379a(int i) {
            Query queryWithLimit = new QueryWithLimit(this);
            queryWithLimit.m20382a((CharSequence) " LIMIT ");
            queryWithLimit.m20382a(String.valueOf(i));
            return queryWithLimit;
        }
    }

    /* compiled from: WWW_PAGE_REACTION_SANDBOX */
    public class InitialQuery extends Query {
        public InitialQuery(String str) {
            super(str);
        }
    }

    /* compiled from: WWW_PAGE_REACTION_SANDBOX */
    public class MultiQuery {
        public List<Query> f12297a = Lists.a();

        public String toString() {
            ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
            for (Query query : this.f12297a) {
                objectNode.a(query.f12295a, query.toString());
            }
            return objectNode.toString();
        }
    }

    /* compiled from: WWW_PAGE_REACTION_SANDBOX */
    public class NumericValue extends Expression {
        private final String f12298a;

        public NumericValue(long j) {
            this.f12298a = String.valueOf(j);
        }

        public String toString() {
            return this.f12298a;
        }
    }

    /* compiled from: WWW_PAGE_REACTION_SANDBOX */
    public class OrCondition extends CompoundCondition {
        public OrCondition(Condition condition, Condition condition2) {
            super(condition, condition2, "OR");
        }
    }

    /* compiled from: WWW_PAGE_REACTION_SANDBOX */
    public class QueryWithFrom extends Query {
        public QueryWithFrom(Query query) {
            super(query);
        }
    }

    /* compiled from: WWW_PAGE_REACTION_SANDBOX */
    public class QueryWithLimit extends Query {
        public QueryWithLimit(Query query) {
            super(query);
        }
    }

    /* compiled from: WWW_PAGE_REACTION_SANDBOX */
    public class QueryWithSelect extends Query {
        public QueryWithSelect(Query query) {
            super(query);
        }
    }

    /* compiled from: WWW_PAGE_REACTION_SANDBOX */
    public class QueryWithWhere extends Query {
        public QueryWithWhere(Query query) {
            super(query);
        }
    }

    /* compiled from: WWW_PAGE_REACTION_SANDBOX */
    public class StringValue extends Expression {
        private final String f12299a;

        public StringValue(String str) {
            this.f12299a = str;
        }

        public String toString() {
            String str = this.f12299a;
            StringBuilder stringBuilder = new StringBuilder();
            StringUtil.a(stringBuilder, str);
            return stringBuilder.toString();
        }
    }

    /* compiled from: WWW_PAGE_REACTION_SANDBOX */
    public enum Table {
        APPLICATION_RELEASE("application_release"),
        CONNECTION("connection"),
        EVENT("event"),
        EVENT_MEMBER("event_member"),
        FRIEND("friend"),
        FRIEND_REQUEST("friend_request"),
        GEO_REGION("geo_region"),
        GROUP_MEMBER("group_member"),
        PAGE("page"),
        PLACE("place"),
        PLACE_TO_SUGGESTED_ACTIVITY("place_to_suggested_activity"),
        PROFILE("profile"),
        PROFILE_PIC("profile_pic"),
        SQUARE_PROFILE_PIC("square_profile_pic"),
        UNIFIED_MESSAGE("unified_message"),
        USER("user"),
        USER_SETTINGS("user_settings");
        
        private final String mName;

        private Table(String str) {
            this.mName = str;
        }

        public final String toString() {
            return this.mName;
        }
    }

    public static InitialQuery m20383a() {
        return m20384a(null);
    }

    public static InitialQuery m20384a(String str) {
        return new InitialQuery(str);
    }
}

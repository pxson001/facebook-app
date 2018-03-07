package com.facebook.database.sqlite;

import com.facebook.database.sqlite.SqlExpression.BinaryExpression;

/* compiled from: secondary_action_uri */
class SqlExpression$LikeExpression extends BinaryExpression {
    public SqlExpression$LikeExpression(String str, String str2) {
        super(str, str2, " like ");
    }
}

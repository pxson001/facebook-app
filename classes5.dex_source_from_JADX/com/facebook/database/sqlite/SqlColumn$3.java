package com.facebook.database.sqlite;

import com.facebook.common.stringformat.StringFormatUtil;
import com.google.common.base.Function;

/* compiled from: secondary_button_action */
final class SqlColumn$3 implements Function<SqlColumn, String> {
    final /* synthetic */ String f2870a;

    SqlColumn$3(String str) {
        this.f2870a = str;
    }

    public final Object apply(Object obj) {
        return StringFormatUtil.formatStrLocaleSafe("trim(%s, '%s')", ((SqlColumn) obj).d, this.f2870a);
    }
}

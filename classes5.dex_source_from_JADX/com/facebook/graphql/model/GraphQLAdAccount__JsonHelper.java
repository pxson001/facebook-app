package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLAdAccountStatus;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: lastErrorDetails */
public final class GraphQLAdAccount__JsonHelper {
    public static GraphQLAdAccount m6427a(JsonParser jsonParser) {
        GraphQLAdAccount graphQLAdAccount = new GraphQLAdAccount();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            String o;
            if ("account_info".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLAdAccount.f3274d = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLAdAccount, "account_info", graphQLAdAccount.a_, 0, false);
            } else if ("account_status".equals(i)) {
                graphQLAdAccount.f3275e = GraphQLAdAccountStatus.fromString(jsonParser.o());
                FieldAccessQueryTracker.a(jsonParser, graphQLAdAccount, "account_status", graphQLAdAccount.a_, 1, false);
            } else if ("ads_currency".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLCurrencyQuantity__JsonHelper.m6924a(FieldAccessQueryTracker.a(jsonParser, "ads_currency"));
                }
                graphQLAdAccount.f3276f = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLAdAccount, "ads_currency", graphQLAdAccount.a_, 2, true);
            } else if ("balance".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLCurrencyQuantity__JsonHelper.m6924a(FieldAccessQueryTracker.a(jsonParser, "balance"));
                }
                graphQLAdAccount.f3277g = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLAdAccount, "balance", graphQLAdAccount.a_, 3, true);
            } else if ("can_update_currency".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLAdAccount.f3278h = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLAdAccount, "can_update_currency", graphQLAdAccount.a_, 4, false);
            } else if ("creative_preview_url".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLAdAccount.f3279i = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLAdAccount, "creative_preview_url", graphQLAdAccount.a_, 5, false);
            } else if ("currency".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLAdAccount.f3280j = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLAdAccount, "currency", graphQLAdAccount.a_, 6, false);
            } else if ("feed_unit_preview".equals(i)) {
                FeedUnit feedUnit;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    feedUnit = null;
                } else {
                    feedUnit = FeedUnitDeserializer.m6329a(FieldAccessQueryTracker.a(jsonParser, "feed_unit_preview"));
                }
                graphQLAdAccount.f3281k = feedUnit;
                FieldAccessQueryTracker.a(jsonParser, graphQLAdAccount, "feed_unit_preview", graphQLAdAccount.a_, 7, true);
            } else if ("has_funding_source".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLAdAccount.f3282l = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLAdAccount, "has_funding_source", graphQLAdAccount.a_, 8, false);
            } else if ("id".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLAdAccount.f3283m = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLAdAccount, "id", graphQLAdAccount.a_, 9, false);
            } else if ("legacy_account_id".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLAdAccount.f3284n = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLAdAccount, "legacy_account_id", graphQLAdAccount.a_, 10, false);
            } else if ("max_daily_budget".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLCurrencyQuantity__JsonHelper.m6924a(FieldAccessQueryTracker.a(jsonParser, "max_daily_budget"));
                }
                graphQLAdAccount.f3285o = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLAdAccount, "max_daily_budget", graphQLAdAccount.a_, 11, true);
            } else if ("min_daily_budget".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLCurrencyQuantity__JsonHelper.m6924a(FieldAccessQueryTracker.a(jsonParser, "min_daily_budget"));
                }
                graphQLAdAccount.f3286p = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLAdAccount, "min_daily_budget", graphQLAdAccount.a_, 12, true);
            } else if ("name".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLAdAccount.f3287q = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLAdAccount, "name", graphQLAdAccount.a_, 13, false);
            } else if ("payment_info".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLAdAccount.f3288r = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLAdAccount, "payment_info", graphQLAdAccount.a_, 14, false);
            } else if ("timezone_info".equals(i)) {
                GraphQLTimezoneInfo graphQLTimezoneInfo;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLTimezoneInfo = null;
                } else {
                    graphQLTimezoneInfo = GraphQLTimezoneInfo__JsonHelper.m22238a(FieldAccessQueryTracker.a(jsonParser, "timezone_info"));
                }
                graphQLAdAccount.f3289s = graphQLTimezoneInfo;
                FieldAccessQueryTracker.a(jsonParser, graphQLAdAccount, "timezone_info", graphQLAdAccount.a_, 15, true);
            } else if ("url".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLAdAccount.f3290t = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLAdAccount, "url", graphQLAdAccount.a_, 16, false);
            } else if ("prepay_account_balance".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLCurrencyQuantity__JsonHelper.m6924a(FieldAccessQueryTracker.a(jsonParser, "prepay_account_balance"));
                }
                graphQLAdAccount.f3291u = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLAdAccount, "prepay_account_balance", graphQLAdAccount.a_, 17, true);
            } else if ("stored_balance_status".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLAdAccount.f3292v = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLAdAccount, "stored_balance_status", graphQLAdAccount.a_, 18, false);
            }
            jsonParser.f();
        }
        return graphQLAdAccount;
    }

    public static void m6428a(JsonGenerator jsonGenerator, GraphQLAdAccount graphQLAdAccount, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLAdAccount.m6408j() != null) {
            jsonGenerator.a("account_info", graphQLAdAccount.m6408j());
        }
        if (graphQLAdAccount.m6409k() != null) {
            jsonGenerator.a("account_status", graphQLAdAccount.m6409k().toString());
        }
        if (graphQLAdAccount.m6410l() != null) {
            jsonGenerator.a("ads_currency");
            GraphQLCurrencyQuantity__JsonHelper.m6925a(jsonGenerator, graphQLAdAccount.m6410l(), true);
        }
        if (graphQLAdAccount.m6411m() != null) {
            jsonGenerator.a("balance");
            GraphQLCurrencyQuantity__JsonHelper.m6925a(jsonGenerator, graphQLAdAccount.m6411m(), true);
        }
        jsonGenerator.a("can_update_currency", graphQLAdAccount.m6412n());
        if (graphQLAdAccount.m6413o() != null) {
            jsonGenerator.a("creative_preview_url", graphQLAdAccount.m6413o());
        }
        if (graphQLAdAccount.m6414p() != null) {
            jsonGenerator.a("currency", graphQLAdAccount.m6414p());
        }
        if (graphQLAdAccount.m6415q() != null) {
            jsonGenerator.a("feed_unit_preview");
            FeedUnitSerializer.m6333a(jsonGenerator, graphQLAdAccount.m6415q());
        }
        jsonGenerator.a("has_funding_source", graphQLAdAccount.m6416r());
        if (graphQLAdAccount.m6417s() != null) {
            jsonGenerator.a("id", graphQLAdAccount.m6417s());
        }
        if (graphQLAdAccount.m6418t() != null) {
            jsonGenerator.a("legacy_account_id", graphQLAdAccount.m6418t());
        }
        if (graphQLAdAccount.m6419u() != null) {
            jsonGenerator.a("max_daily_budget");
            GraphQLCurrencyQuantity__JsonHelper.m6925a(jsonGenerator, graphQLAdAccount.m6419u(), true);
        }
        if (graphQLAdAccount.m6420v() != null) {
            jsonGenerator.a("min_daily_budget");
            GraphQLCurrencyQuantity__JsonHelper.m6925a(jsonGenerator, graphQLAdAccount.m6420v(), true);
        }
        if (graphQLAdAccount.m6421w() != null) {
            jsonGenerator.a("name", graphQLAdAccount.m6421w());
        }
        if (graphQLAdAccount.m6422x() != null) {
            jsonGenerator.a("payment_info", graphQLAdAccount.m6422x());
        }
        if (graphQLAdAccount.m6423y() != null) {
            jsonGenerator.a("timezone_info");
            GraphQLTimezoneInfo__JsonHelper.m22239a(jsonGenerator, graphQLAdAccount.m6423y(), true);
        }
        if (graphQLAdAccount.m6424z() != null) {
            jsonGenerator.a("url", graphQLAdAccount.m6424z());
        }
        if (graphQLAdAccount.m6402A() != null) {
            jsonGenerator.a("prepay_account_balance");
            GraphQLCurrencyQuantity__JsonHelper.m6925a(jsonGenerator, graphQLAdAccount.m6402A(), true);
        }
        if (graphQLAdAccount.m6403B() != null) {
            jsonGenerator.a("stored_balance_status", graphQLAdAccount.m6403B());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}

package com.facebook.tigon.flatbuffers;

import android.annotation.SuppressLint;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;

@SuppressLint({"BadArgumentPlacement", "BadClosingBracePlacement", "YodaConditions"})
/* compiled from: num_mutual_friends */
public final class FlatTigonSummary extends Table {
    public final FlatTigonRequestStatsSummaryInfo m6194a(FlatTigonRequestStatsSummaryInfo flatTigonRequestStatsSummaryInfo) {
        int a = a(4);
        if (a == 0) {
            return null;
        }
        a = b(a + this.a);
        ByteBuffer byteBuffer = this.b;
        flatTigonRequestStatsSummaryInfo.a = a;
        flatTigonRequestStatsSummaryInfo.b = byteBuffer;
        return flatTigonRequestStatsSummaryInfo;
    }

    public final FlatTigonSwitcherSummaryInfo m6195a(FlatTigonSwitcherSummaryInfo flatTigonSwitcherSummaryInfo) {
        int a = a(6);
        if (a == 0) {
            return null;
        }
        a = b(a + this.a);
        ByteBuffer byteBuffer = this.b;
        flatTigonSwitcherSummaryInfo.a = a;
        flatTigonSwitcherSummaryInfo.b = byteBuffer;
        return flatTigonSwitcherSummaryInfo;
    }

    public final FlatTigonHttpFlowStatsInfo m6193a(FlatTigonHttpFlowStatsInfo flatTigonHttpFlowStatsInfo) {
        int a = a(8);
        if (a == 0) {
            return null;
        }
        a = b(a + this.a);
        ByteBuffer byteBuffer = this.b;
        flatTigonHttpFlowStatsInfo.a = a;
        flatTigonHttpFlowStatsInfo.b = byteBuffer;
        return flatTigonHttpFlowStatsInfo;
    }

    public final FlatTigonFlowTimeDataInfo m6192a(FlatTigonFlowTimeDataInfo flatTigonFlowTimeDataInfo) {
        int a = a(10);
        if (a == 0) {
            return null;
        }
        a = b(a + this.a);
        ByteBuffer byteBuffer = this.b;
        flatTigonFlowTimeDataInfo.a = a;
        flatTigonFlowTimeDataInfo.b = byteBuffer;
        return flatTigonFlowTimeDataInfo;
    }
}

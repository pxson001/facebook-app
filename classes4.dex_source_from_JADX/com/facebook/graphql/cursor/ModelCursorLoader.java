package com.facebook.graphql.cursor;

import com.facebook.graphql.cursor.abtest.ExperimentsForGraphCursorAbTestModule;
import com.facebook.graphql.cursor.database.GraphCursorDatabase;
import com.facebook.inject.Assisted;
import com.facebook.qe.api.QeAccessor;
import com.facebook.quicklog.QuickPerformanceLogger;
import javax.inject.Inject;

/* compiled from: messenger_update_message_phase_two_start */
public class ModelCursorLoader {
    private final GraphCursorDatabase f7896a;
    private final String f7897b;
    private final CursorModelCache f7898c;
    private final QuickPerformanceLogger f7899d;
    private final QeAccessor f7900e;

    @Inject
    public ModelCursorLoader(@Assisted String str, GraphCursorDatabase graphCursorDatabase, QuickPerformanceLogger quickPerformanceLogger, CursorModelCache cursorModelCache, QeAccessor qeAccessor) {
        this.f7897b = str;
        this.f7896a = graphCursorDatabase;
        this.f7899d = quickPerformanceLogger;
        this.f7898c = cursorModelCache;
        this.f7900e = qeAccessor;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.database.Cursor m8197a() {
        /*
        r6 = this;
        r5 = 8716292; // 0x850004 float:1.2214127E-38 double:4.3064204E-317;
        r4 = 2;
        r0 = r6.f7899d;
        r0.b(r5);
        r0 = r6.f7896a;	 Catch:{ all -> 0x0045 }
        r1 = r6.f7897b;	 Catch:{ all -> 0x0045 }
        r0 = r0.m8158a(r1);	 Catch:{ all -> 0x0045 }
        r0 = com.google.common.base.Preconditions.checkNotNull(r0);	 Catch:{ all -> 0x0045 }
        r0 = (android.database.Cursor) r0;	 Catch:{ all -> 0x0045 }
        r1 = new com.facebook.graphql.cursor.ModelCursor;	 Catch:{ all -> 0x0045 }
        r2 = r6.f7899d;	 Catch:{ all -> 0x0045 }
        r3 = r6.f7898c;	 Catch:{ all -> 0x0045 }
        r1.<init>(r0, r2, r3);	 Catch:{ all -> 0x0045 }
        r0 = r6.f7899d;	 Catch:{ all -> 0x0045 }
        r2 = 8716308; // 0x850014 float:1.2214149E-38 double:4.3064283E-317;
        r0.b(r2);	 Catch:{ all -> 0x0045 }
        r6.m8196a(r1);	 Catch:{ all -> 0x003a }
        r0 = r6.f7899d;	 Catch:{  }
        r2 = 8716308; // 0x850014 float:1.2214149E-38 double:4.3064283E-317;
        r3 = 2;
        r0.b(r2, r3);	 Catch:{  }
        r0 = r6.f7899d;
        r0.b(r5, r4);
        return r1;
    L_0x003a:
        r0 = move-exception;
        r1 = r6.f7899d;	 Catch:{  }
        r2 = 8716308; // 0x850014 float:1.2214149E-38 double:4.3064283E-317;
        r3 = 2;
        r1.b(r2, r3);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0045:
        r0 = move-exception;
        r1 = r6.f7899d;
        r1.b(r5, r4);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.graphql.cursor.ModelCursorLoader.a():android.database.Cursor");
    }

    private void m8196a(ModelCursor modelCursor) {
        String a = this.f7900e.a(ExperimentsForGraphCursorAbTestModule.f8040a, "never");
        this.f7899d.a(8716308, "warm_mapped_files_" + a);
        if ("first_and_last".equals(a)) {
            if (modelCursor.moveToFirst()) {
                modelCursor.m8329e();
                if (modelCursor.moveToLast()) {
                    modelCursor.m8329e();
                }
            }
        } else if ("all".equals(a) && modelCursor.moveToFirst()) {
            do {
                modelCursor.m8329e();
            } while (modelCursor.moveToNext());
        }
    }
}

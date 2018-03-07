package com.facebook.structuredsurvey;

import com.facebook.graphql.enums.GraphQLStructuredSurveyQuestionType;
import com.facebook.structuredsurvey.items.AnswerableItem;
import com.facebook.structuredsurvey.items.SurveyItem;
import com.facebook.survey.graphql.StructuredSurveySessionFragmentsInterfaces.StructuredSurveyNestedControlNodeFragment;
import com.facebook.survey.graphql.StructuredSurveySessionFragmentsModels.StructuredSurveyConfiguredQuestionFragmentModel;
import com.facebook.survey.graphql.StructuredSurveySessionFragmentsModels.StructuredSurveyControlNodeFragmentModel;
import com.facebook.survey.graphql.StructuredSurveySessionFragmentsModels.StructuredSurveyFlowFragmentModel;
import com.facebook.survey.graphql.StructuredSurveySessionFragmentsModels.StructuredSurveyFlowPageFragmentModel;
import com.facebook.survey.graphql.StructuredSurveySessionFragmentsModels.StructuredSurveyFlowPageFragmentModel.BucketsModel;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import javax.annotation.Nullable;

/* compiled from: draft_disabled_for_content_type */
public class StructuredSurveyFlowController {
    public int f17104a = -1;
    public StructuredSurveyFlowFragmentModel f17105b;
    public String f17106c;
    public HashMap<String, StructuredSurveyConfiguredQuestionFragmentModel> f17107d;
    public List<String> f17108e;
    public StructuredSurveyState f17109f;

    /* compiled from: draft_disabled_for_content_type */
    public class C12371 implements Predicate<StructuredSurveyConfiguredQuestionFragmentModel> {
        final /* synthetic */ StructuredSurveyFlowController f17101a;

        public C12371(StructuredSurveyFlowController structuredSurveyFlowController) {
            this.f17101a = structuredSurveyFlowController;
        }

        public boolean apply(@Nullable Object obj) {
            return !this.f17101a.f17107d.containsKey(((StructuredSurveyConfiguredQuestionFragmentModel) obj).m25028n());
        }
    }

    /* compiled from: draft_disabled_for_content_type */
    public class C12382 implements Predicate<StructuredSurveyConfiguredQuestionFragmentModel> {
        final /* synthetic */ StructuredSurveyFlowController f17102a;

        public C12382(StructuredSurveyFlowController structuredSurveyFlowController) {
            this.f17102a = structuredSurveyFlowController;
        }

        public boolean apply(@Nullable Object obj) {
            return ((StructuredSurveyConfiguredQuestionFragmentModel) obj).m25027m() != GraphQLStructuredSurveyQuestionType.MESSAGE;
        }
    }

    /* compiled from: draft_disabled_for_content_type */
    public /* synthetic */ class C12393 {
        public static final /* synthetic */ int[] f17103a = new int[GraphQLStructuredSurveyQuestionType.values().length];

        static {
            try {
                f17103a[GraphQLStructuredSurveyQuestionType.RADIO.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    public StructuredSurveyFlowController(StructuredSurveyFlowFragmentModel structuredSurveyFlowFragmentModel, StructuredSurveyState structuredSurveyState) {
        this.f17105b = structuredSurveyFlowFragmentModel;
        this.f17109f = structuredSurveyState;
        Preconditions.checkNotNull(this.f17105b);
        this.f17106c = this.f17105b.m25047a();
        Preconditions.checkArgument(Arrays.asList(new String[]{"linear", "linear_bucket", "control_node"}).contains(this.f17106c));
        this.f17107d = Maps.c();
    }

    public final List<StructuredSurveyConfiguredQuestionFragmentModel> m24803a() {
        this.f17108e = Lists.a();
        List<StructuredSurveyConfiguredQuestionFragmentModel> a = Lists.a();
        ImmutableList k = this.f17105b.m25049k();
        this.f17104a = m24802h();
        if (!this.f17106c.equals("control_node") && (this.f17104a < 0 || this.f17104a >= m24801g())) {
            return null;
        }
        this.f17109f.f17115c.add(Integer.valueOf(this.f17104a));
        ImmutableList a2 = ((StructuredSurveyFlowPageFragmentModel) k.get(this.f17104a)).m25059a();
        int size = a2.size();
        for (int i = 0; i < size; i++) {
            List a3 = Lists.a(Iterables.c(((BucketsModel) a2.get(i)).m25054a(), new C12371(this)));
            StructuredSurveyConfiguredQuestionFragmentModel structuredSurveyConfiguredQuestionFragmentModel = (StructuredSurveyConfiguredQuestionFragmentModel) a3.get(new Random().nextInt(a3.size()));
            a.add(structuredSurveyConfiguredQuestionFragmentModel);
            this.f17107d.put(structuredSurveyConfiguredQuestionFragmentModel.m25028n(), structuredSurveyConfiguredQuestionFragmentModel);
            this.f17108e.add(structuredSurveyConfiguredQuestionFragmentModel.m25028n());
        }
        StructuredSurveyState structuredSurveyState = this.f17109f;
        ImmutableList copyOf = ImmutableList.copyOf(this.f17108e);
        Preconditions.checkNotNull(copyOf);
        Preconditions.checkArgument(!copyOf.isEmpty());
        structuredSurveyState.f17114b.add(copyOf);
        return a.isEmpty() ? null : a;
    }

    private int m24801g() {
        if (this.f17106c.equals("control_node")) {
            return -1;
        }
        return this.f17105b.m25049k().size();
    }

    public final int m24805b() {
        if (this.f17106c.equals("control_node")) {
            return -1;
        }
        int i = 0;
        for (StructuredSurveyFlowPageFragmentModel a : this.f17105b.m25049k()) {
            ImmutableList a2 = a.m25059a();
            int size = a2.size();
            for (int i2 = 0; i2 < size; i2++) {
                Object obj;
                BucketsModel bucketsModel = (BucketsModel) a2.get(i2);
                ImmutableList a3 = bucketsModel.m25054a();
                int size2 = a3.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    if (((StructuredSurveyConfiguredQuestionFragmentModel) a3.get(i3)).m25027m() != GraphQLStructuredSurveyQuestionType.MESSAGE) {
                        obj = null;
                        break;
                    }
                }
                obj = 1;
                if (obj == null) {
                    if (m24798b(bucketsModel)) {
                        return -1;
                    }
                    i++;
                }
            }
        }
        return i;
    }

    private static boolean m24798b(BucketsModel bucketsModel) {
        ImmutableList a = bucketsModel.m25054a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            if (((StructuredSurveyConfiguredQuestionFragmentModel) a.get(i)).m25027m() == GraphQLStructuredSurveyQuestionType.MESSAGE) {
                return true;
            }
        }
        return false;
    }

    public final boolean m24806c() {
        if (!this.f17106c.equals("control_node") && this.f17104a == m24801g() - 1) {
            return true;
        }
        return false;
    }

    private int m24802h() {
        if (this.f17106c.equals("linear") || this.f17106c.equals("linear_bucket")) {
            return this.f17104a + 1;
        }
        if (!this.f17106c.equals("control_node")) {
            return -1;
        }
        if (this.f17104a < 0) {
            return m24800d(this.f17105b.m25048j());
        }
        return m24800d(((StructuredSurveyFlowPageFragmentModel) this.f17105b.m25049k().get(this.f17104a)).m25060j());
    }

    private int m24799c(StructuredSurveyNestedControlNodeFragment structuredSurveyNestedControlNodeFragment) {
        StructuredSurveyControlNodeFragmentModel structuredSurveyControlNodeFragmentModel = (StructuredSurveyControlNodeFragmentModel) structuredSurveyNestedControlNodeFragment;
        int d = m24800d(structuredSurveyControlNodeFragmentModel.m25036a());
        if (d >= structuredSurveyControlNodeFragmentModel.m25038b().size()) {
            return -1;
        }
        return m24800d((StructuredSurveyNestedControlNodeFragment) structuredSurveyControlNodeFragmentModel.m25038b().get(d));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int m24800d(com.facebook.survey.graphql.StructuredSurveySessionFragmentsInterfaces.StructuredSurveyNestedControlNodeFragment r10) {
        /*
        r9 = this;
        if (r10 != 0) goto L_0x0007;
    L_0x0002:
        r0 = r9.f17104a;
        r0 = r0 + 1;
    L_0x0006:
        return r0;
    L_0x0007:
        r0 = r10.cT_();
        r1 = "direct";
        r1 = r0.equals(r1);
        if (r1 == 0) goto L_0x0018;
    L_0x0013:
        r0 = r10.mo1302g();
        goto L_0x0006;
    L_0x0018:
        r1 = "random";
        r1 = r0.equals(r1);
        if (r1 == 0) goto L_0x002d;
    L_0x0020:
        r2 = r10.mo1303j();
        r3 = r2.size();
        if (r3 != 0) goto L_0x0074;
    L_0x002a:
        r2 = -1;
    L_0x002b:
        r0 = r2;
        goto L_0x0006;
    L_0x002d:
        r1 = "branch";
        r1 = r0.equals(r1);
        if (r1 == 0) goto L_0x0055;
    L_0x0035:
        r3 = 0;
        r2 = r10.mo1301d();
        r4 = r9.f17109f;
        r8 = r4.f17113a;
        r8 = r8.get(r2);
        r8 = (com.google.common.collect.ImmutableList) r8;
        r4 = r8;
        if (r4 == 0) goto L_0x004f;
    L_0x0047:
        r5 = r9.f17107d;
        r5 = r5.get(r2);
        if (r5 != 0) goto L_0x008c;
    L_0x004f:
        r2 = r10.mo1297c();
    L_0x0053:
        r0 = r2;
        goto L_0x0006;
    L_0x0055:
        r1 = "qe";
        r1 = r0.equals(r1);
        if (r1 == 0) goto L_0x0062;
    L_0x005d:
        r0 = r10.cU_();
        goto L_0x0006;
    L_0x0062:
        r1 = "composite";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x006f;
    L_0x006a:
        r0 = r9.m24799c(r10);
        goto L_0x0006;
    L_0x006f:
        r0 = r9.f17104a;
        r0 = r0 + 1;
        goto L_0x0006;
    L_0x0074:
        r3 = new java.util.Random;
        r3.<init>();
        r4 = r2.size();
        r3 = r3.nextInt(r4);
        r2 = r2.get(r3);
        r2 = (java.lang.Integer) r2;
        r2 = r2.intValue();
        goto L_0x002b;
    L_0x008c:
        r5 = com.facebook.structuredsurvey.StructuredSurveyFlowController.C12393.f17103a;
        r6 = r9.f17107d;
        r2 = r6.get(r2);
        r2 = (com.facebook.survey.graphql.StructuredSurveySessionFragmentsModels.StructuredSurveyConfiguredQuestionFragmentModel) r2;
        r2 = r2.m25027m();
        r2 = r2.ordinal();
        r2 = r5[r2];
        switch(r2) {
            case 1: goto L_0x00a8;
            default: goto L_0x00a3;
        };
    L_0x00a3:
        r2 = r10.mo1297c();
        goto L_0x0053;
    L_0x00a8:
        r2 = r4.get(r3);
        r2 = (com.facebook.structuredsurvey.StructuredSurveyState.Answer) r2;
        r8 = r2.f17110a;
        r4 = r8;
        r5 = r10.cS_();
        r6 = r5.size();
    L_0x00b9:
        if (r3 >= r6) goto L_0x00a3;
    L_0x00bb:
        r2 = r5.get(r3);
        r2 = (com.facebook.survey.graphql.StructuredSurveySessionFragmentsModels.StructuredSurveyBranchNodeResponseMapEntryFragmentModel) r2;
        r7 = r2.m25016b();
        if (r7 != r4) goto L_0x00cc;
    L_0x00c7:
        r2 = r2.m25012a();
        goto L_0x0053;
    L_0x00cc:
        r2 = r3 + 1;
        r3 = r2;
        goto L_0x00b9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.StructuredSurveyFlowController.d(com.facebook.survey.graphql.StructuredSurveySessionFragmentsInterfaces$StructuredSurveyNestedControlNodeFragment):int");
    }

    public final void m24804a(List<SurveyItem> list) {
        for (String str : this.f17108e) {
            Collection collection;
            List a = Lists.a();
            for (SurveyItem surveyItem : list) {
                if (surveyItem.f17166b.equals(str) && (surveyItem instanceof AnswerableItem) && ((AnswerableItem) surveyItem).mo1295b()) {
                    a.add(((AnswerableItem) surveyItem).mo1294a());
                }
            }
            if (a.isEmpty()) {
                collection = null;
            } else {
                Object obj = a;
            }
            Collection collection2 = collection;
            if (collection2 != null) {
                ImmutableList copyOf = ImmutableList.copyOf(collection2);
                StructuredSurveyState structuredSurveyState = this.f17109f;
                Preconditions.checkNotNull(str);
                Preconditions.checkNotNull(copyOf);
                Preconditions.checkArgument(!copyOf.isEmpty());
                structuredSurveyState.f17113a.put(str, copyOf);
            }
        }
    }
}

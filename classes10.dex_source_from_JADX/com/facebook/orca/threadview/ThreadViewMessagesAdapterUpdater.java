package com.facebook.orca.threadview;

import android.widget.BaseAdapter;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.inject.Assisted;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.threadview.rows.RowGloballyDeletedMessagePlaceholderItem;
import com.facebook.messaging.threadview.rows.RowItem;
import com.facebook.messaging.threadview.rows.RowMessageItem;
import com.facebook.messaging.threadview.rows.RowReceiptItem;
import com.facebook.messaging.threadview.rows.RowSpacerItem;
import com.facebook.messaging.threadview.rows.RowType;
import com.facebook.messaging.threadview.rows.RowTypingItem;
import com.facebook.orca.threadview.InterRowItemAnimationFactory.MoveUserTileAnimation;
import com.facebook.orca.threadview.abtest.ThreadViewReducedAnimationExperimentController;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.widget.animatablelistview.AnimatingListAdapter;
import com.facebook.widget.animatablelistview.AnimatingListMutation.MutationType;
import com.facebook.widget.animatablelistview.AnimatingListTransactionBuilder;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import difflib.ChangeDelta;
import difflib.Chunk;
import difflib.DeleteDelta;
import difflib.Delta;
import difflib.DiffUtils;
import difflib.InsertDelta;
import difflib.Patch;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: message has flower border */
public class ThreadViewMessagesAdapterUpdater {
    private static final Class<?> f7679a = ThreadViewMessagesAdapterUpdater.class;
    public boolean f7680b;
    private final BaseAdapter f7681c;
    private final ThreadViewReducedAnimationExperimentController f7682d;
    private final InterRowItemAnimationFactory f7683e;
    private final RowItemUiUtil f7684f;
    private final AbstractFbErrorReporter f7685g;
    public final RowItemDifferentiator f7686h;
    private final Calculator f7687i = new Calculator();

    /* compiled from: message has flower border */
    enum AnimationDirection {
        UP,
        DOWN,
        NONE
    }

    /* compiled from: message has flower border */
    class Calculator {
        private static final ImmutableList<RowPatternPart> f7659a = ImmutableList.of(RowPatternPart.m7363b(RowType.TIMESTAMP_DIVIDER), RowPatternPart.m7362a(RowType.MESSAGE), RowPatternPart.m7363b(RowType.RECEIPT), RowPatternPart.m7363b(RowType.SPACER));
        private static final ImmutableList<RowPatternPart> f7660b = ImmutableList.of(RowPatternPart.m7362a(RowType.RECEIPT), RowPatternPart.m7363b(RowType.SPACER));
        private static final ImmutableList<RowPatternPart> f7661c = ImmutableList.of(RowPatternPart.m7362a(RowType.SPACER));
        private static final ImmutableList<RowPatternPart> f7662d = ImmutableList.of(RowPatternPart.m7362a(RowType.BUSINESS_GREETING), RowPatternPart.m7363b(RowType.SPACER));
        private static final ImmutableList<RowPatternPart> f7663e = ImmutableList.of(RowPatternPart.m7363b(RowType.TIMESTAMP_DIVIDER), RowPatternPart.m7362a(RowType.TYPING), RowPatternPart.m7363b(RowType.SPACER));
        private static final ImmutableList<RowPatternPart> f7664f = ImmutableList.of(RowPatternPart.m7363b(RowType.TIMESTAMP_DIVIDER), RowPatternPart.m7362a(RowType.HOT_LIKE_PREVIEW), RowPatternPart.m7363b(RowType.SPACER));
        private static final ImmutableList<RowPatternPart> f7665g = ImmutableList.of(RowPatternPart.m7363b(RowType.TIMESTAMP_DIVIDER), RowPatternPart.m7362a(RowType.GLOBALLY_DELETED_MESSAGE_PLACEHOLDER), RowPatternPart.m7363b(RowType.SPACER));

        /* compiled from: message has flower border */
        class RowPatternPart {
            public final RowType f7657a;
            public final boolean f7658b;

            private RowPatternPart(RowType rowType, boolean z) {
                this.f7657a = rowType;
                this.f7658b = z;
            }

            static RowPatternPart m7362a(RowType rowType) {
                return new RowPatternPart(rowType, false);
            }

            static RowPatternPart m7363b(RowType rowType) {
                return new RowPatternPart(rowType, true);
            }
        }

        Calculator() {
        }

        final List<Transformation> m7372a(Patch<RowSummary> patch) {
            List<Transformation> a = Lists.a();
            for (Delta a2 : patch.m13863a()) {
                Transformation a3 = m7365a(a2);
                if (a3 == null) {
                    return null;
                }
                a.add(a3);
            }
            return a;
        }

        private Transformation m7365a(Delta<RowSummary> delta) {
            RowSummaryIterator a = RowSummaryIterator.m7376a(delta.f13592a.f13596c);
            RowSummaryIterator a2 = RowSummaryIterator.m7376a(delta.f13593b.f13596c);
            List a3 = Lists.a();
            Set set = null;
            Set set2 = null;
            while (true) {
                if (!a.m7378b() && !a2.m7378b()) {
                    return new Transformation(delta, ImmutableList.copyOf(a3));
                }
                RowSummary a4;
                RowSummary a5 = a.m7378b() ? a.m7377a() : null;
                if (a2.m7378b()) {
                    a4 = a2.m7377a();
                } else {
                    a4 = null;
                }
                int a6 = m7364a(RowSummaryIterator.m7375a(a), RowSummaryIterator.m7375a(a2), set2, set);
                if (a6 == -1) {
                    set2 = m7366a(delta.f13592a);
                    set = m7366a(delta.f13593b);
                } else {
                    int size = a3.size();
                    switch (a6) {
                        case 0:
                            a3.add(TransformStep.m7383c(a.f7671b, a2.f7671b));
                            a.m7379c();
                            a2.m7379c();
                            break;
                        case 1:
                            m7370b(a, AnimationDirection.UP, f7660b, a3);
                            m7367a(a2, AnimationDirection.UP, f7663e, a3);
                            break;
                        case 2:
                            m7370b(a, AnimationDirection.UP, f7661c, a3);
                            m7367a(a2, AnimationDirection.UP, f7663e, a3);
                            break;
                        case 3:
                            m7367a(a2, AnimationDirection.DOWN, f7660b, a3);
                            m7370b(a, AnimationDirection.DOWN, f7663e, a3);
                            break;
                        case 4:
                            m7367a(a2, AnimationDirection.DOWN, f7661c, a3);
                            m7370b(a, AnimationDirection.DOWN, f7663e, a3);
                            break;
                        case 5:
                            a3.add(TransformStep.m7383c(a.f7671b, a2.f7671b));
                            a.m7379c();
                            a2.m7379c();
                            a.f7672c = a4;
                            break;
                        case 6:
                            m7370b(a, AnimationDirection.NONE, f7659a, a3);
                            a2.f7672c = a5;
                            break;
                        case 7:
                            m7367a(a2, AnimationDirection.NONE, f7659a, a3);
                            a.f7672c = a4;
                            break;
                        case 8:
                            m7370b(a, AnimationDirection.UP, f7660b, a3);
                            break;
                        case 9:
                            m7370b(a, AnimationDirection.UP, f7661c, a3);
                            break;
                        case 10:
                            m7367a(a2, AnimationDirection.UP, f7660b, a3);
                            break;
                        case 11:
                            m7367a(a2, AnimationDirection.UP, f7659a, a3);
                            break;
                        case 12:
                            m7370b(a, AnimationDirection.NONE, f7661c, a3);
                            m7367a(a2, AnimationDirection.UP, f7664f, a3);
                            break;
                        case 13:
                            m7370b(a, AnimationDirection.DOWN, f7664f, a3);
                            m7367a(a2, AnimationDirection.NONE, f7661c, a3);
                            break;
                        case 14:
                            m7370b(a, AnimationDirection.NONE, f7659a, a3);
                            m7367a(a2, AnimationDirection.NONE, f7665g, a3);
                            a2.f7672c = a5;
                            break;
                        case 15:
                            m7371c(a, AnimationDirection.DOWN, f7665g, a3);
                            m7367a(a2, AnimationDirection.NONE, f7661c, a3);
                            break;
                        case 16:
                            m7371c(a, AnimationDirection.DOWN, f7665g, a3);
                            break;
                        case 17:
                            m7371c(a, AnimationDirection.UP, f7662d, a3);
                            m7367a(a2, AnimationDirection.UP, f7659a, a3);
                            break;
                        default:
                            return null;
                    }
                    if (a3.size() == size) {
                        return null;
                    }
                }
            }
        }

        private static int m7364a(RowSummaryIterator rowSummaryIterator, RowSummaryIterator rowSummaryIterator2, Set<RowSummary> set, Set<RowSummary> set2) {
            RowSummary a;
            RowSummary rowSummary = null;
            RowSummary a2 = rowSummaryIterator.m7378b() ? rowSummaryIterator.m7377a() : null;
            if (rowSummaryIterator2.m7378b()) {
                a = rowSummaryIterator2.m7377a();
            } else {
                a = null;
            }
            if (!Objects.equal(rowSummaryIterator.f7672c, rowSummaryIterator2.f7672c)) {
                return -2;
            }
            if (Objects.equal(a2, a)) {
                return 0;
            }
            if (a2 != null && a2.f7668a == RowType.TIMESTAMP_DIVIDER) {
                rowSummaryIterator.m7379c();
                a2 = rowSummaryIterator.m7378b() ? rowSummaryIterator.m7377a() : null;
            }
            if (a != null && a.f7668a == RowType.TIMESTAMP_DIVIDER) {
                rowSummaryIterator2.m7379c();
                if (rowSummaryIterator2.m7378b()) {
                    rowSummary = rowSummaryIterator2.m7377a();
                }
                a = rowSummary;
            }
            if (a2 == null || a == null) {
                if (a2 != null) {
                    if (a2.f7668a == RowType.RECEIPT) {
                        return 8;
                    }
                    if (a2.f7668a == RowType.MESSAGE) {
                        return 6;
                    }
                    return a2.f7668a == RowType.GLOBALLY_DELETED_MESSAGE_PLACEHOLDER ? 16 : -2;
                } else if (a == null) {
                    return -2;
                } else {
                    if (a.f7668a == RowType.MESSAGE) {
                        return 11;
                    }
                    return a.f7668a == RowType.RECEIPT ? 10 : -2;
                }
            } else if (a.f7668a == RowType.TYPING) {
                if (a2.f7668a == RowType.RECEIPT) {
                    return 1;
                }
                return a2.f7668a == RowType.SPACER ? 2 : -2;
            } else if (a2.f7668a == RowType.TYPING) {
                if (a.f7668a == RowType.RECEIPT) {
                    return 3;
                }
                if (a.f7668a == RowType.SPACER) {
                    return 4;
                }
                return a.f7668a == RowType.MESSAGE ? 5 : -2;
            } else if (a2.f7668a == RowType.BUSINESS_GREETING) {
                return a.f7668a == RowType.MESSAGE ? 17 : -2;
            } else {
                if (a2.f7668a == RowType.MESSAGE && a.f7668a == RowType.MESSAGE) {
                    if (set == null || set2 == null) {
                        return -1;
                    }
                    if (set2.contains(a2)) {
                        return !set.contains(a) ? 7 : -2;
                    } else {
                        return 6;
                    }
                } else if (a.f7668a == RowType.MESSAGE) {
                    if (a2.f7668a == RowType.RECEIPT) {
                        return 8;
                    }
                    if (a2.f7668a == RowType.SPACER) {
                        return 9;
                    }
                    return a2.f7668a == RowType.GLOBALLY_DELETED_MESSAGE_PLACEHOLDER ? 16 : -2;
                } else if (a2.f7668a == RowType.MESSAGE) {
                    if (a.f7668a == RowType.RECEIPT) {
                        return 10;
                    }
                    return a.f7668a == RowType.GLOBALLY_DELETED_MESSAGE_PLACEHOLDER ? 14 : -2;
                } else if (a.f7668a == RowType.HOT_LIKE_PREVIEW) {
                    return a2.f7668a == RowType.SPACER ? 12 : -2;
                } else {
                    if (a2.f7668a == RowType.HOT_LIKE_PREVIEW) {
                        return a.f7668a == RowType.SPACER ? 13 : -2;
                    } else {
                        if (a2.f7668a == RowType.GLOBALLY_DELETED_MESSAGE_PLACEHOLDER) {
                            return a.f7668a == RowType.SPACER ? 15 : -2;
                        } else {
                            if (a2.f7668a == RowType.SPACER && a.f7668a == RowType.RECEIPT) {
                                return 9;
                            }
                            return -2;
                        }
                    }
                }
            }
        }

        private static Set<RowSummary> m7366a(Chunk<RowSummary> chunk) {
            Set<RowSummary> a = Sets.a();
            for (RowSummary add : chunk.f13596c) {
                a.add(add);
            }
            return a;
        }

        private void m7367a(RowSummaryIterator rowSummaryIterator, AnimationDirection animationDirection, List<RowPatternPart> list, List<TransformStep> list2) {
            m7368a(rowSummaryIterator, animationDirection, false, list, true, list2);
        }

        private void m7370b(RowSummaryIterator rowSummaryIterator, AnimationDirection animationDirection, List<RowPatternPart> list, List<TransformStep> list2) {
            m7368a(rowSummaryIterator, animationDirection, false, list, false, list2);
        }

        private void m7371c(RowSummaryIterator rowSummaryIterator, AnimationDirection animationDirection, List<RowPatternPart> list, List<TransformStep> list2) {
            m7368a(rowSummaryIterator, animationDirection, true, list, false, list2);
        }

        private static void m7368a(RowSummaryIterator rowSummaryIterator, AnimationDirection animationDirection, boolean z, List<RowPatternPart> list, boolean z2, List<TransformStep> list2) {
            int i = rowSummaryIterator.f7671b;
            int i2 = 0;
            for (RowPatternPart rowPatternPart : list) {
                if (rowPatternPart.f7658b) {
                    int i3;
                    RowSummary a = rowSummaryIterator.m7378b() ? rowSummaryIterator.m7377a() : null;
                    if (a == null || a.f7668a != rowPatternPart.f7657a) {
                        i3 = i2;
                    } else {
                        rowSummaryIterator.m7379c();
                        i3 = i2 + 1;
                    }
                    i2 = i3;
                } else {
                    boolean z3;
                    if (rowSummaryIterator.m7379c().f7668a == rowPatternPart.f7657a) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    Preconditions.checkArgument(z3);
                    i2++;
                }
            }
            if (z2) {
                list2.add(TransformStep.m7382b(animationDirection, i, i2));
                if (z) {
                    list2.add(new TransformStep(MutationType.FADE_IN, -1, i, i2));
                    return;
                }
                return;
            }
            list2.add(TransformStep.m7381a(animationDirection, i, i2));
            if (z) {
                list2.add(TransformStep.m7380a(i, i2));
            }
        }

        final String m7373b(Patch<RowSummary> patch) {
            StringBuilder stringBuilder = new StringBuilder();
            Object obj = 1;
            for (Delta delta : patch.m13863a()) {
                if (obj == null) {
                    stringBuilder.append("\n");
                }
                m7369a(stringBuilder, delta.f13592a.f13596c);
                stringBuilder.append(" => ");
                m7369a(stringBuilder, delta.f13593b.f13596c);
                obj = null;
            }
            return stringBuilder.toString();
        }

        private static void m7369a(StringBuilder stringBuilder, List<RowSummary> list) {
            Object obj = 1;
            for (RowSummary rowSummary : list) {
                if (obj == null) {
                    stringBuilder.append(" ");
                }
                switch (rowSummary.f7668a) {
                    case MESSAGE:
                        stringBuilder.append("M").append(rowSummary.f7669b);
                        continue;
                    case RECEIPT:
                        stringBuilder.append("R").append(rowSummary.f7669b);
                        continue;
                    case TYPING:
                        stringBuilder.append("T");
                        continue;
                    case SPACER:
                        stringBuilder.append("S");
                        continue;
                    case TIMESTAMP_DIVIDER:
                        stringBuilder.append("D");
                        continue;
                    case HOT_LIKE_PREVIEW:
                        stringBuilder.append("H");
                        continue;
                    case GLOBALLY_DELETED_MESSAGE_PLACEHOLDER:
                        stringBuilder.append("G");
                        break;
                }
                stringBuilder.append("U");
                obj = null;
            }
        }
    }

    /* compiled from: message has flower border */
    class MsgIdMap {
        private Map<String, Integer> f7666a = Maps.c();
        private int f7667b = 0;

        public final int m7374a(Message message) {
            Integer num;
            if (!StringUtil.a(message.a)) {
                num = (Integer) this.f7666a.get(message.a);
                if (num != null) {
                    return num.intValue();
                }
            }
            if (!StringUtil.a(message.n)) {
                num = (Integer) this.f7666a.get(message.n);
                if (num != null) {
                    return num.intValue();
                }
            }
            int i = this.f7667b;
            this.f7667b = i + 1;
            if (!StringUtil.a(message.a)) {
                this.f7666a.put(message.a, Integer.valueOf(i));
            }
            if (StringUtil.a(message.n)) {
                return i;
            }
            this.f7666a.put(message.n, Integer.valueOf(i));
            return i;
        }
    }

    /* compiled from: message has flower border */
    class RowSummary {
        final RowType f7668a;
        final int f7669b;

        RowSummary(RowType rowType, int i) {
            this.f7668a = rowType;
            this.f7669b = i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            RowSummary rowSummary = (RowSummary) obj;
            if (this.f7669b != rowSummary.f7669b) {
                return false;
            }
            if (this.f7668a != rowSummary.f7668a) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return Objects.hashCode(new Object[]{this.f7668a, Integer.valueOf(this.f7669b)});
        }
    }

    /* compiled from: message has flower border */
    public class RowSummaryIterator {
        private final List<RowSummary> f7670a;
        public int f7671b;
        public RowSummary f7672c;

        public static RowSummaryIterator m7376a(List<RowSummary> list) {
            return new RowSummaryIterator(list);
        }

        public static RowSummaryIterator m7375a(RowSummaryIterator rowSummaryIterator) {
            RowSummaryIterator rowSummaryIterator2 = new RowSummaryIterator(rowSummaryIterator.f7670a);
            rowSummaryIterator2.f7671b = rowSummaryIterator.f7671b;
            rowSummaryIterator2.f7672c = rowSummaryIterator.f7672c;
            return rowSummaryIterator2;
        }

        private RowSummaryIterator(List<RowSummary> list) {
            this.f7670a = list;
        }

        public final RowSummary m7377a() {
            if (m7378b()) {
                return (RowSummary) this.f7670a.get(this.f7671b);
            }
            throw new NoSuchElementException();
        }

        public final boolean m7378b() {
            return this.f7671b < this.f7670a.size();
        }

        public final RowSummary m7379c() {
            if (m7378b()) {
                List list = this.f7670a;
                int i = this.f7671b;
                this.f7671b = i + 1;
                RowSummary rowSummary = (RowSummary) list.get(i);
                if (rowSummary.f7668a == RowType.MESSAGE) {
                    this.f7672c = rowSummary;
                }
                return rowSummary;
            }
            throw new NoSuchElementException();
        }
    }

    /* compiled from: message has flower border */
    public class TransformStep {
        final MutationType f7673a;
        final int f7674b;
        final int f7675c;
        final int f7676d;

        public TransformStep(MutationType mutationType, int i, int i2, int i3) {
            this.f7673a = mutationType;
            this.f7674b = i;
            this.f7675c = i2;
            this.f7676d = i3;
        }

        static TransformStep m7381a(AnimationDirection animationDirection, int i, int i2) {
            if (animationDirection == AnimationDirection.UP) {
                return new TransformStep(MutationType.REMOVE_WITH_ANIMATION_UP, i, -1, i2);
            }
            if (animationDirection == AnimationDirection.DOWN) {
                return new TransformStep(MutationType.REMOVE_WITH_ANIMATION_DOWN, i, -1, i2);
            }
            return new TransformStep(MutationType.REMOVE, i, -1, i2);
        }

        static TransformStep m7380a(int i, int i2) {
            return new TransformStep(MutationType.FADE_OUT, i, -1, i2);
        }

        static TransformStep m7382b(AnimationDirection animationDirection, int i, int i2) {
            if (animationDirection == AnimationDirection.UP) {
                return new TransformStep(MutationType.ADD_WITH_ANIMATION_UP, -1, i, i2);
            }
            if (animationDirection == AnimationDirection.DOWN) {
                return new TransformStep(MutationType.ADD_WITH_ANIMATION_DOWN, -1, i, i2);
            }
            return new TransformStep(MutationType.ADD, -1, i, i2);
        }

        static TransformStep m7383c(int i, int i2) {
            return new TransformStep(MutationType.REPLACE, i, i2, 1);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            TransformStep transformStep = (TransformStep) obj;
            if (this.f7676d != transformStep.f7676d) {
                return false;
            }
            if (this.f7674b != transformStep.f7674b) {
                return false;
            }
            if (this.f7675c != transformStep.f7675c) {
                return false;
            }
            if (this.f7673a != transformStep.f7673a) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return Objects.hashCode(new Object[]{this.f7673a, Integer.valueOf(this.f7674b), Integer.valueOf(this.f7675c), Integer.valueOf(this.f7676d)});
        }

        public String toString() {
            return Objects.toStringHelper(this).add("type", this.f7673a).add("origIndex", this.f7674b).add("reviIndex", this.f7675c).add("num", this.f7676d).toString();
        }
    }

    /* compiled from: message has flower border */
    class Transformation {
        final Delta<RowSummary> f7677a;
        final ImmutableList<TransformStep> f7678b;

        public Transformation(Delta<RowSummary> delta, ImmutableList<TransformStep> immutableList) {
            this.f7677a = delta;
            this.f7678b = immutableList;
        }
    }

    @Inject
    public ThreadViewMessagesAdapterUpdater(@Assisted BaseAdapter baseAdapter, @Assisted ThreadViewReducedAnimationExperimentController threadViewReducedAnimationExperimentController, @Assisted InterRowItemAnimationFactory interRowItemAnimationFactory, RowItemUiUtil rowItemUiUtil, AbstractFbErrorReporter abstractFbErrorReporter, RowItemDifferentiator rowItemDifferentiator) {
        this.f7681c = baseAdapter;
        this.f7682d = threadViewReducedAnimationExperimentController;
        this.f7683e = interRowItemAnimationFactory;
        this.f7684f = rowItemUiUtil;
        this.f7685g = abstractFbErrorReporter;
        this.f7686h = rowItemDifferentiator;
    }

    public final void m7399a(List<RowItem> list) {
        TracerDetour.a("TVMAU-update", -1347796508);
        if (this.f7682d.m8073a()) {
            ((MessageListAdapterForListView) this.f7681c).m6899b((List) list);
        } else {
            m7385a((AnimatingListAdapterForMessageList) this.f7681c, (List) list);
        }
    }

    private void m7385a(AnimatingListAdapter<RowItem> animatingListAdapter, List<RowItem> list) {
        boolean z = false;
        try {
            List e = animatingListAdapter.e();
            AnimatingListTransactionBuilder a;
            if (this.f7680b || !e.isEmpty()) {
                Patch a2 = DiffUtils.m13861a(e, list, this.f7686h);
                if (a2.m13863a().isEmpty()) {
                    TracerDetour.a(963784970);
                    return;
                }
                int[] d = m7398d(a2);
                if (d[0] <= 3) {
                    if (d[1] + d[0] <= 8) {
                        m7390a(e, (List) list);
                        if (!this.f7682d.m8074b() || m7391a((BaseAdapter) animatingListAdapter, a2)) {
                            if (!a2.m13863a().isEmpty()) {
                                boolean a3 = m7393a(a2);
                                if (!a3 || DiffUtils.m13861a(animatingListAdapter.e(), list, this.f7686h).m13863a().isEmpty()) {
                                    z = a3;
                                } else {
                                    m7395b(a2);
                                }
                                if (!z) {
                                    animatingListAdapter.b();
                                    a = animatingListAdapter.a();
                                    a.a(list);
                                    a.a();
                                }
                            }
                            TracerDetour.a(-327907518);
                            return;
                        }
                        animatingListAdapter.b();
                        a = animatingListAdapter.a();
                        a.a(list);
                        a.a();
                        TracerDetour.a(-750250235);
                        return;
                    }
                }
                animatingListAdapter.b();
                a = animatingListAdapter.a();
                a.a(list);
                a.a();
                TracerDetour.a(-532400231);
                return;
            }
            a = animatingListAdapter.a();
            a.a(list);
            a.a();
        } finally {
            TracerDetour.a(-610219932);
        }
    }

    private boolean m7391a(BaseAdapter baseAdapter, Patch<RowItem> patch) {
        List a = patch.m13863a();
        if (a.size() != 1) {
            return false;
        }
        Delta delta = (Delta) a.get(0);
        Chunk chunk = delta.f13592a;
        Chunk chunk2 = delta.f13593b;
        switch (delta.mo683a()) {
            case CHANGE:
                if (chunk.f13595b != baseAdapter.getCount() - chunk.f13596c.size()) {
                    return false;
                }
                for (RowItem rowItem : chunk.f13596c) {
                    int i;
                    for (RowItem a2 : chunk2.f13596c) {
                        if (m7392a(rowItem, a2)) {
                            i = 1;
                            continue;
                            if (i == 0) {
                                return false;
                            }
                        }
                    }
                    i = 0;
                    continue;
                    if (i == 0) {
                        return false;
                    }
                }
                return true;
            case INSERT:
                return chunk.f13595b == baseAdapter.getCount();
            default:
                return false;
        }
    }

    private boolean m7392a(RowItem rowItem, RowItem rowItem2) {
        if ((rowItem instanceof RowSpacerItem) && (rowItem2 instanceof RowSpacerItem)) {
            return true;
        }
        if (!(rowItem instanceof RowMessageItem) || !(rowItem2 instanceof RowMessageItem)) {
            return this.f7686h.m7008a(rowItem, rowItem2);
        }
        if (this.f7686h.m7009a((RowMessageItem) rowItem, (RowMessageItem) rowItem2)) {
            return false;
        }
        return true;
    }

    private boolean m7393a(Patch<RowItem> patch) {
        if (patch.m13863a().isEmpty()) {
            return false;
        }
        Patch c = m7397c(patch);
        if (BLog.b(2)) {
            this.f7687i.m7373b(c);
            patch.m13863a().size();
        }
        try {
            List a = this.f7687i.m7372a(c);
            if (a != null) {
                m7388a((Patch) patch, a);
                return true;
            } else if (!BLog.b(3) && !BuildConstants.e()) {
                return false;
            } else {
                String b = this.f7687i.m7373b(c);
                patch.m13863a().size();
                this.f7685g.a("ThreadViewMessagesAdapterUpdater_failed_patch", b);
                return false;
            }
        } catch (Throwable e) {
            this.f7685g.a("ThreadViewMessagesAdapterUpdate_failed_patch", this.f7687i.m7373b(c), e);
            return false;
        }
    }

    private void m7388a(Patch<RowItem> patch, List<Transformation> list) {
        boolean z;
        Preconditions.checkState(!this.f7682d.m8073a());
        if (patch.m13863a().size() == list.size()) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        AnimatingListTransactionBuilder a = ((AnimatingListAdapter) this.f7681c).a();
        for (int i = 0; i < list.size(); i++) {
            Delta delta = (Delta) patch.m13863a().get(i);
            ImmutableList immutableList = ((Transformation) list.get(i)).f7678b;
            int size = immutableList.size();
            for (int i2 = 0; i2 < size; i2++) {
                TransformStep transformStep = (TransformStep) immutableList.get(i2);
                List b = delta.m13854c().m13857b();
                if (transformStep.f7673a == MutationType.REPLACE) {
                    a.b(a.a(delta.m13853b().m13856a() + transformStep.f7674b), b.get(transformStep.f7675c));
                } else if (transformStep.f7673a == MutationType.ADD_WITH_ANIMATION_DOWN) {
                    a.a(a.b(delta.m13854c().m13856a() + transformStep.f7675c), b.subList(transformStep.f7675c, transformStep.f7676d + transformStep.f7675c));
                } else if (transformStep.f7673a == MutationType.ADD_WITH_ANIMATION_UP) {
                    r10 = a.b(delta.m13854c().m13856a() + transformStep.f7675c);
                    a.b(r10, b.subList(transformStep.f7675c, transformStep.f7676d + transformStep.f7675c));
                    m7386a(a, r10);
                    m7387a(a, r10, true);
                } else if (transformStep.f7673a == MutationType.ADD) {
                    a.a(a.b(delta.m13854c().m13856a() + transformStep.f7675c), b.subList(transformStep.f7675c, transformStep.f7676d + transformStep.f7675c));
                } else if (transformStep.f7673a == MutationType.REMOVE_WITH_ANIMATION_DOWN) {
                    r5 = a.a(delta.m13853b().m13856a() + transformStep.f7674b);
                    a.a(r5, transformStep.f7676d);
                    m7387a(a, r5, false);
                    m7394b(a, r5);
                } else if (transformStep.f7673a == MutationType.REMOVE_WITH_ANIMATION_UP) {
                    a.b(a.a(delta.m13853b().m13856a() + transformStep.f7674b), transformStep.f7676d);
                } else if (transformStep.f7673a == MutationType.REMOVE) {
                    r10 = a.a(delta.m13853b().m13856a() + transformStep.f7674b);
                    for (r5 = 0; r5 < transformStep.f7676d; r5++) {
                        a.c(r10);
                    }
                } else if (transformStep.f7673a == MutationType.FADE_IN) {
                    a.c(a.b(delta.m13854c().m13856a() + transformStep.f7675c), b.subList(transformStep.f7675c, transformStep.f7676d + transformStep.f7675c));
                } else if (transformStep.f7673a == MutationType.FADE_OUT) {
                    a.c(a.a(delta.m13853b().m13856a() + transformStep.f7674b), transformStep.f7676d);
                } else {
                    throw new RuntimeException("Unknown step type");
                }
            }
        }
        a.a();
    }

    private void m7395b(Patch<RowItem> patch) {
        Patch c = m7397c(patch);
        Calculator calculator = new Calculator();
        if (BLog.b(2)) {
            this.f7685g.a("ThreadViewMessagesAdapterUpdater_failed_patch", calculator.m7373b(c));
            patch.m13863a().size();
        }
    }

    private void m7390a(List<RowItem> list, List<RowItem> list2) {
        if (BLog.b(2)) {
            StringBuilder stringBuilder = new StringBuilder(100);
            stringBuilder.append("Current and new messages:\n");
            stringBuilder.append("  Current messages:\n");
            m7389a(stringBuilder, (List) list, 6);
            stringBuilder.append("  New Message:\n");
            m7389a(stringBuilder, (List) list2, 6);
            stringBuilder.append("\n");
        }
    }

    private static void m7389a(StringBuilder stringBuilder, List<RowItem> list, int i) {
        if (list == null || list.isEmpty()) {
            stringBuilder.append("    none\n");
            return;
        }
        for (int max = Math.max(0, list.size() - i); max < list.size(); max++) {
            stringBuilder.append("   ").append(((RowItem) list.get(max)).toString()).append("\n");
        }
    }

    private Patch<RowSummary> m7397c(Patch<RowItem> patch) {
        MsgIdMap msgIdMap = new MsgIdMap();
        Patch<RowSummary> patch2 = new Patch();
        for (Delta delta : patch.m13863a()) {
            patch2.m13864a(new ChangeDelta(m7384a(delta.f13592a, msgIdMap), m7384a(delta.f13593b, msgIdMap)));
        }
        return patch2;
    }

    private static Chunk<RowSummary> m7384a(Chunk<RowItem> chunk, MsgIdMap msgIdMap) {
        List a = Lists.a();
        for (RowItem rowItem : chunk.f13596c) {
            Object rowSummary;
            RowSummary rowSummary2;
            switch (rowItem.mo131b()) {
                case MESSAGE:
                    rowSummary2 = new RowSummary(RowType.MESSAGE, msgIdMap.m7374a(((RowMessageItem) rowItem).f4732a));
                    break;
                case RECEIPT:
                    rowSummary2 = new RowSummary(RowType.RECEIPT, msgIdMap.m7374a(((RowReceiptItem) rowItem).f4758a));
                    break;
                default:
                    rowSummary = new RowSummary(rowItem.mo131b(), -1);
                    break;
            }
            a.add(rowSummary);
        }
        return new Chunk(chunk.f13595b, a, null);
    }

    private static int[] m7398d(Patch<RowItem> patch) {
        int[] iArr = new int[2];
        for (Delta delta : patch.m13863a()) {
            if (delta instanceof DeleteDelta) {
                iArr[1] = delta.f13592a.m13858c() + iArr[1];
            } else if (delta instanceof InsertDelta) {
                iArr[0] = delta.f13593b.m13858c() + iArr[0];
            } else if (delta instanceof ChangeDelta) {
                if (delta.f13592a.m13858c() > delta.f13593b.m13858c()) {
                    iArr[1] = delta.f13592a.m13858c() + iArr[1];
                } else if (delta.f13593b.m13858c() > delta.f13592a.m13858c()) {
                    iArr[0] = iArr[0] + (delta.f13593b.m13858c() - delta.f13592a.m13858c());
                    iArr[1] = delta.f13592a.m13858c() + iArr[1];
                }
            }
        }
        return iArr;
    }

    private void m7386a(AnimatingListTransactionBuilder<RowItem> animatingListTransactionBuilder, int i) {
        RowItem rowItem = (RowItem) animatingListTransactionBuilder.d(i);
        if (rowItem instanceof RowMessageItem) {
            RowMessageItem rowMessageItem = (RowMessageItem) rowItem;
            if (rowMessageItem.f4737f.groupWithOlderRow && !rowMessageItem.f4739h) {
                int c = m7396c(animatingListTransactionBuilder, i);
                if (c != -1) {
                    animatingListTransactionBuilder.a(this.f7683e.m6574a(rowMessageItem.f4732a.e, rowMessageItem.f4732a.b, c, i));
                }
            }
        }
    }

    private void m7387a(AnimatingListTransactionBuilder<RowItem> animatingListTransactionBuilder, int i, boolean z) {
        RowItem rowItem = (RowItem) animatingListTransactionBuilder.d(i);
        if (rowItem instanceof RowTypingItem) {
            RowTypingItem rowTypingItem = (RowTypingItem) rowItem;
            if (this.f7684f.m7021a(rowTypingItem.f4775b, rowTypingItem.f4774a)) {
                int c = m7396c(animatingListTransactionBuilder, i);
                if (c != -1) {
                    int i2 = z ? c : i;
                    if (!z) {
                        i = c;
                    }
                    animatingListTransactionBuilder.a(new MoveUserTileAnimation(rowTypingItem.f4775b.e, rowTypingItem.f4775b.b, i2, i, true));
                }
            }
        }
    }

    private void m7394b(AnimatingListTransactionBuilder<RowItem> animatingListTransactionBuilder, int i) {
        RowItem rowItem = (RowItem) animatingListTransactionBuilder.d(i);
        if (rowItem instanceof RowGloballyDeletedMessagePlaceholderItem) {
            RowGloballyDeletedMessagePlaceholderItem rowGloballyDeletedMessagePlaceholderItem = (RowGloballyDeletedMessagePlaceholderItem) rowItem;
            if (rowGloballyDeletedMessagePlaceholderItem.f4729b.groupWithOlderRow && !rowGloballyDeletedMessagePlaceholderItem.f4729b.groupWithNewerRow) {
                int c = m7396c(animatingListTransactionBuilder, i);
                if (c != -1) {
                    animatingListTransactionBuilder.a(this.f7683e.m6574a(rowGloballyDeletedMessagePlaceholderItem.f4728a.e, rowGloballyDeletedMessagePlaceholderItem.f4728a.b, i, c));
                }
            }
        }
    }

    private static int m7396c(AnimatingListTransactionBuilder<RowItem> animatingListTransactionBuilder, int i) {
        int i2 = i - 1;
        while (i >= 0) {
            if (((RowItem) animatingListTransactionBuilder.d(i2)) instanceof RowMessageItem) {
                return i2;
            }
            i2--;
        }
        return -1;
    }
}

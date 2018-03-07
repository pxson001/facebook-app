package com.facebook.richdocument.genesis;

import android.view.ViewGroup;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.richdocument.view.viewholder.BlockViewHolder;
import com.facebook.sequencelogger.AbstractSequenceDefinition;
import com.facebook.sequencelogger.Sequence;
import com.facebook.sequencelogger.SequenceDefinition;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.google.common.collect.ImmutableBiMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: post search */
public final class BlockViewHolderFactory {
    private static final String f5285b = BlockViewHolderFactory.class.getSimpleName();
    protected final Map<Integer, BlockCreator> f5286a = new HashMap();
    private final Lazy<SequenceLogger> f5287c;
    private final AbstractSequenceDefinition f5288d;

    @Inject
    public BlockViewHolderFactory(Lazy<SequenceLogger> lazy, Set<BlockCreator> set, @Assisted SequenceDefinition sequenceDefinition) {
        this.f5287c = lazy;
        this.f5288d = sequenceDefinition;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            BaseBlockCreator baseBlockCreator = (BaseBlockCreator) it.next();
            int i = baseBlockCreator.f5284b;
            if (this.f5286a.containsKey(Integer.valueOf(i))) {
                throw new IllegalArgumentException("Found block type conflict. value:" + i + ", creator:" + baseBlockCreator);
            }
            this.f5286a.put(Integer.valueOf(i), baseBlockCreator);
        }
    }

    public final BlockViewHolder m5227a(int i, ViewGroup viewGroup) {
        if (i == 0 || !this.f5286a.containsKey(Integer.valueOf(i))) {
            return null;
        }
        Sequence e;
        BaseBlockCreator baseBlockCreator = (BaseBlockCreator) this.f5286a.get(Integer.valueOf(i));
        if (this.f5288d != null) {
            e = ((SequenceLogger) this.f5287c.get()).e(this.f5288d);
        } else {
            e = null;
        }
        if (!(e == null || baseBlockCreator == null)) {
            SequenceLoggerDetour.a(e, "rich_document_block_creation", null, ImmutableBiMap.b("rich_document_block_type", baseBlockCreator.getClass().getSimpleName()), 1483865572);
        }
        BlockViewHolder a = baseBlockCreator.mo265a(viewGroup);
        if (e == null) {
            return a;
        }
        SequenceLoggerDetour.b(e, "rich_document_block_creation", -2012103003);
        return a;
    }
}

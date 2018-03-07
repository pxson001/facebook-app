package com.facebook.composer.topics;

import android.net.Uri;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.FindViewUtil;
import com.facebook.composer.topics.analytics.ComposerTopicLogger;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.fbui.widget.contentview.CheckedContentView;
import com.facebook.graphql.model.GraphQLExploreFeed;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.topics.protocol.TopicFavoritesQueryModels.TopicFeedFragmentModel;
import com.facebook.topics.protocol.TopicFavoritesQueryModels.TopicFeedListModel;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: Typeahead Cleaned Up */
public class ComposerTopicListAdapter extends Adapter<ViewHolder> {
    public static final CallerContext f23880a = CallerContext.a(ComposerTopicListAdapter.class, "topic_feeds_favorites");
    public final ComposerTopicLogger f23881b;
    public final int f23882c;
    public TopicFeedListModel f23883d;
    public List<GraphQLExploreFeed> f23884e;
    public Set<String> f23885f;
    public AlertDialog f23886g;

    /* compiled from: Typeahead Cleaned Up */
    public enum RowType {
        HEADER,
        TOPIC
    }

    /* compiled from: Typeahead Cleaned Up */
    public class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
        public final /* synthetic */ ComposerTopicListAdapter f23875l;
        public CheckedContentView f23876m;
        public FbDraweeView f23877n;
        public int f23878o;
        public boolean f23879p;

        public ViewHolder(final ComposerTopicListAdapter composerTopicListAdapter, View view, int i) {
            this.f23875l = composerTopicListAdapter;
            super(view);
            this.f23878o = i;
            if (i == RowType.TOPIC.ordinal()) {
                this.f23876m = (CheckedContentView) view;
                this.f23876m.setThumbnailSize(this.f23876m.getResources().getDimensionPixelSize(2131429383));
                this.f23876m.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ ViewHolder f23872b;

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, 1832285804);
                        ComposerTopicListAdapter composerTopicListAdapter = this.f23872b.f23875l;
                        int e = this.f23872b.e();
                        int i = e - 1;
                        GraphQLExploreFeed a2 = ComposerTopicsModelConversionHelper.m25885a((TopicFeedFragmentModel) composerTopicListAdapter.f23883d.a().get(i));
                        if (ComposerTopicListAdapter.m25862c(composerTopicListAdapter, a2)) {
                            Iterator it = composerTopicListAdapter.f23884e.iterator();
                            while (it.hasNext()) {
                                if (((GraphQLExploreFeed) it.next()).n().equals(a2.n())) {
                                    it.remove();
                                    break;
                                }
                            }
                            composerTopicListAdapter.f23885f.remove(a2.n());
                        } else {
                            composerTopicListAdapter.f23884e.add(a2);
                            composerTopicListAdapter.f23885f.add(a2.n());
                        }
                        composerTopicListAdapter.f23881b.m25907a(a2, i, ComposerTopicListAdapter.m25862c(composerTopicListAdapter, a2), true);
                        composerTopicListAdapter.j_(e);
                        Logger.a(2, EntryType.UI_INPUT_END, -2049881645, a);
                    }
                });
                this.f23876m.setOnTouchListener(new OnTouchListener(this) {
                    final /* synthetic */ ViewHolder f23874b;

                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        switch (motionEvent.getAction()) {
                            case 0:
                                if (!((CheckedContentView) view).isChecked() && this.f23874b.f23875l.f23884e.size() >= this.f23874b.f23875l.f23882c) {
                                    this.f23874b.f23879p = true;
                                    break;
                                }
                            case 1:
                                if (this.f23874b.f23879p) {
                                    ViewHolder viewHolder = this.f23874b;
                                    if (viewHolder.f23875l.f23886g == null) {
                                        Builder a = new Builder(viewHolder.f23876m.getContext()).b(viewHolder.f23876m.getContext().getResources().getString(2131234284, new Object[]{Integer.valueOf(viewHolder.f23875l.f23882c)})).c(true).a(2131230756, null);
                                        viewHolder.f23875l.f23886g = a.a();
                                    }
                                    viewHolder.f23875l.f23886g.show();
                                    this.f23874b.f23879p = false;
                                    break;
                                }
                                break;
                            case 3:
                                this.f23874b.f23879p = false;
                                break;
                        }
                        return this.f23874b.f23879p;
                    }
                });
                this.f23877n = (FbDraweeView) FindViewUtil.b(this.f23876m, 2131560647);
            }
        }
    }

    public final void m25864a(android.support.v7.widget.RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        if (i != 0) {
            TopicFeedFragmentModel topicFeedFragmentModel = (TopicFeedFragmentModel) this.f23883d.a().get(i - 1);
            if (viewHolder2.f23878o == RowType.TOPIC.ordinal()) {
                boolean c = m25862c(viewHolder2.f23875l, ComposerTopicsModelConversionHelper.m25885a(topicFeedFragmentModel));
                viewHolder2.f23876m.setTitleText(topicFeedFragmentModel.k());
                viewHolder2.f23876m.setChecked(c);
                viewHolder2.f23877n.a(Uri.parse(c ? topicFeedFragmentModel.n().a() : topicFeedFragmentModel.m().a()), f23880a);
            }
        }
    }

    public ComposerTopicListAdapter(ImmutableList<GraphQLExploreFeed> immutableList, int i, ComposerTopicLogger composerTopicLogger) {
        this.f23882c = i;
        if (this.f23884e == null) {
            this.f23884e = new ArrayList();
        }
        if (this.f23885f == null) {
            this.f23885f = new HashSet();
        }
        int size = immutableList.size();
        for (int i2 = 0; i2 < size; i2++) {
            GraphQLExploreFeed graphQLExploreFeed = (GraphQLExploreFeed) immutableList.get(i2);
            this.f23884e.add(graphQLExploreFeed);
            this.f23885f.add(graphQLExploreFeed.n());
        }
        this.f23881b = composerTopicLogger;
    }

    public final android.support.v7.widget.RecyclerView.ViewHolder m25863a(ViewGroup viewGroup, int i) {
        return new ViewHolder(this, LayoutInflater.from(viewGroup.getContext()).inflate(i == RowType.TOPIC.ordinal() ? 2130903737 : 2130903736, viewGroup, false), i);
    }

    public final int aZ_() {
        int i;
        if (this.f23883d == null || this.f23883d.a() == null) {
            i = 0;
        } else {
            i = this.f23883d.a().size();
        }
        if (i == 0) {
            return 0;
        }
        return i + 1;
    }

    public int getItemViewType(int i) {
        return i != 0 ? RowType.TOPIC.ordinal() : RowType.HEADER.ordinal();
    }

    public static boolean m25862c(ComposerTopicListAdapter composerTopicListAdapter, GraphQLExploreFeed graphQLExploreFeed) {
        return composerTopicListAdapter.f23885f.contains(graphQLExploreFeed.n());
    }
}

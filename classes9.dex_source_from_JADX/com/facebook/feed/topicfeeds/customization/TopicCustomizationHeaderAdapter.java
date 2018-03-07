package com.facebook.feed.topicfeeds.customization;

import android.app.Activity;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.util.FindViewUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.composer.topics.ComposerTopicsModelConversionHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.feed.topicfeeds.nux.TopicFeedsCustomizationInterstitialController;
import com.facebook.graphql.calls.TopicProjectInputTopicProject;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLExploreFeed;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.interstitial.InterstitialStartHelper;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.topics.data.TopicListFetcher;
import com.facebook.topics.protocol.TopicFavoritesQueryModels.TopicFeedFragmentModel;
import com.facebook.topics.protocol.TopicFavoritesQueryModels.TopicFeedListModel;
import com.facebook.widget.listview.FbBaseAdapter;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: TRANSLATE */
public class TopicCustomizationHeaderAdapter extends FbBaseAdapter {
    private static final CallerContext f24584a = CallerContext.a(TopicCustomizationHeaderAdapter.class);
    public Lazy<InterstitialStartHelper> f24585b;
    public final TopicFeedsIntentFactory f24586c;
    public final SecureContextHelper f24587d;
    private Provider<Boolean> f24588e;
    public TopicFeedFragmentModel f24589f;

    @Inject
    public TopicCustomizationHeaderAdapter(@Assisted GraphQLExploreFeed graphQLExploreFeed, TopicListFetcher topicListFetcher, TopicFeedsIntentFactory topicFeedsIntentFactory, SecureContextHelper secureContextHelper, Provider<Boolean> provider, Lazy<InterstitialStartHelper> lazy) {
        this.f24585b = lazy;
        this.f24586c = topicFeedsIntentFactory;
        this.f24587d = secureContextHelper;
        this.f24588e = provider;
        final String n = graphQLExploreFeed.n();
        topicListFetcher.a(TopicProjectInputTopicProject.TOPIC_FEEDS, GraphQLCachePolicy.a, new AbstractDisposableFutureCallback<GraphQLResult<TopicFeedListModel>>(this) {
            final /* synthetic */ TopicCustomizationHeaderAdapter f24583b;

            protected final void m26504a(Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (graphQLResult != null) {
                    ImmutableList a = ((TopicFeedListModel) graphQLResult.e).a();
                    int size = a.size();
                    for (int i = 0; i < size; i++) {
                        TopicFeedFragmentModel topicFeedFragmentModel = (TopicFeedFragmentModel) a.get(i);
                        if (StringUtil.a(topicFeedFragmentModel.fb_(), n)) {
                            this.f24583b.f24589f = topicFeedFragmentModel;
                            AdapterDetour.a(this.f24583b, -679629041);
                            return;
                        }
                    }
                }
            }

            protected final void m26505a(Throwable th) {
            }
        });
    }

    public final View m26506a(int i, ViewGroup viewGroup) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(2130907524, viewGroup, false);
    }

    public final void m26507a(int i, Object obj, View view, int i2, final ViewGroup viewGroup) {
        if (obj != null) {
            final TopicFeedFragmentModel topicFeedFragmentModel = (TopicFeedFragmentModel) obj;
            TextView textView = (TextView) FindViewUtil.b(view, 2131568068);
            ((FbDraweeView) FindViewUtil.b(view, 2131568067)).a(Uri.parse(topicFeedFragmentModel.o().a()), f24584a);
            textView.setText(topicFeedFragmentModel.k());
            if (((Boolean) this.f24588e.get()).booleanValue() && topicFeedFragmentModel.c()) {
                View b = FindViewUtil.b(view, 2131568069);
                b.setVisibility(0);
                ((InterstitialStartHelper) this.f24585b.get()).a(b.getContext(), new InterstitialTrigger(Action.FEED_STORY_LOADED), TopicFeedsCustomizationInterstitialController.class, b);
                view.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ TopicCustomizationHeaderAdapter f24581c;

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, -1806723104);
                        this.f24581c.f24587d.a(this.f24581c.f24586c.m26509a(ComposerTopicsModelConversionHelper.m25885a(topicFeedFragmentModel)), 2056, (Activity) viewGroup.getContext());
                        Logger.a(2, EntryType.UI_INPUT_END, 1736900638, a);
                    }
                });
            }
        }
    }

    public Object getItem(int i) {
        return this.f24589f;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getCount() {
        return 1;
    }
}

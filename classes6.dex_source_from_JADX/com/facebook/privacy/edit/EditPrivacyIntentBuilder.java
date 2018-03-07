package com.facebook.privacy.edit;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.util.TriState;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLEntityAtRange;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.StoryActorHelper;
import com.facebook.graphql.model.StoryHierarchyHelper;
import com.facebook.inject.ForAppContext;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.privacy.edit.EditPrivacyParams.Type;
import com.facebook.privacy.edit.EditStoryPrivacyParams.Builder;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: fetch-profile-question */
public class EditPrivacyIntentBuilder {
    public final Context f15022a;
    private final Provider<TriState> f15023b;

    public static EditPrivacyIntentBuilder m22605b(InjectorLike injectorLike) {
        return new EditPrivacyIntentBuilder((Context) injectorLike.getInstance(Context.class, ForAppContext.class), IdBasedProvider.a(injectorLike, 740));
    }

    @Inject
    public EditPrivacyIntentBuilder(@ForAppContext Context context, Provider<TriState> provider) {
        this.f15022a = context;
        this.f15023b = provider;
    }

    public final Intent m22606a(GraphQLStory graphQLStory) {
        if (((TriState) this.f15023b.get()).asBoolean(false)) {
            ImmutableList b;
            int size;
            int i;
            boolean z;
            Intent intent = new Intent(this.f15022a, EditStoryPrivacyActivity.class);
            Builder builder = new Builder();
            builder.f15059a = graphQLStory.g();
            builder = builder;
            builder.f15060b = graphQLStory.c();
            builder = builder;
            builder.f15061c = graphQLStory.ai();
            builder = builder;
            Object obj;
            if (StoryActorHelper.b(graphQLStory) == null || StoryActorHelper.b(graphQLStory).b() == null || StoryActorHelper.b(graphQLStory).b().g() != 2645995) {
                obj = null;
            } else {
                obj = StoryActorHelper.b(graphQLStory).H();
            }
            GraphQLTextWithEntities b2 = StoryHierarchyHelper.b(graphQLStory);
            if (!(b2 == null || b2.b() == null)) {
                b = b2.b();
                size = b.size();
                for (i = 0; i < size; i++) {
                    GraphQLEntityAtRange graphQLEntityAtRange = (GraphQLEntityAtRange) b.get(i);
                    if (graphQLEntityAtRange.j() != null && graphQLEntityAtRange.j().b() != null && graphQLEntityAtRange.j().b().g() == 2645995 && !Objects.equal(graphQLEntityAtRange.j().d(), r5)) {
                        z = true;
                        break;
                    }
                }
            }
            if (!(graphQLStory.aR() == null || graphQLStory.aR().a() == null || graphQLStory.aR().a().isEmpty())) {
                b = graphQLStory.aR().a();
                size = b.size();
                for (i = 0; i < size; i++) {
                    GraphQLActor graphQLActor = (GraphQLActor) b.get(i);
                    if (graphQLActor != null && graphQLActor.b() != null && graphQLActor.b().g() == 2645995 && !Objects.equal(graphQLActor.H(), r5)) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            builder.f15062d = z;
            intent.putExtra("params", new EditStoryPrivacyParams(builder));
            return intent;
        }
        intent = new Intent(this.f15022a, EditPrivacyActivity.class);
        EditPrivacyParams.Builder builder2 = new EditPrivacyParams.Builder(Type.STORY);
        builder2.f15026c = graphQLStory.g();
        EditPrivacyParams.Builder builder3 = builder2;
        builder3.f15027d = graphQLStory.c();
        builder3.f15029f = graphQLStory.ai();
        intent.putExtra("params", builder2.m22607a());
        return intent;
    }

    public static EditPrivacyIntentBuilder m22604a(InjectorLike injectorLike) {
        return m22605b(injectorLike);
    }
}

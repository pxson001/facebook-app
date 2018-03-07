package com.facebook.pages.common.constants;

import com.facebook.sequencelogger.AbstractSequenceDefinition;
import com.google.common.collect.ImmutableSet;

/* compiled from: task_key_load_overall_rating */
public final class PagesPerfConstants {

    /* compiled from: task_key_load_overall_rating */
    public class PageSequences {
        public static final PagesManagerPageHeaderInteractionSequence f1715a = new PagesManagerPageHeaderInteractionSequence();
        public static final Fb4aNonAdminedPageHeaderInteractionSequenceDefinition f1716b = new Fb4aNonAdminedPageHeaderInteractionSequenceDefinition();
        public static final Fb4aNonAdminedPagePresenceHeaderInteractionSequenceDefinition f1717c = new Fb4aNonAdminedPagePresenceHeaderInteractionSequenceDefinition();
        public static final Fb4aAdminedPageHeaderInteractionSequenceDefinition f1718d = new Fb4aAdminedPageHeaderInteractionSequenceDefinition();
        public static final Fb4aAdminedPagePresenceHeaderInteractionSequenceDefinition f1719e = new Fb4aAdminedPagePresenceHeaderInteractionSequenceDefinition();
        public static final Fb4aSecondaryCardsSequenceDefinition f1720f = new Fb4aSecondaryCardsSequenceDefinition();
        public static final PageSurfaceFirstCardSequenceeDefinition f1721g = new PageSurfaceFirstCardSequenceeDefinition();
        public static final PageNewLikesInteractionSequenceDefinition f1722h = new PageNewLikesInteractionSequenceDefinition();
        public static final PagesManagerFirstStoriesSequence f1723i = new PagesManagerFirstStoriesSequence();
        public static final Fb4aNonAdminedFirstStoriesSequenceDefinition f1724j = new Fb4aNonAdminedFirstStoriesSequenceDefinition();
        public static final Fb4aAdminedFirstStoriesSequenceDefinition f1725k = new Fb4aAdminedFirstStoriesSequenceDefinition();
        public static final PagesManagerFirstPostsByOthersStoriesSequence f1726l = new PagesManagerFirstPostsByOthersStoriesSequence();
        public static final Fb4aNonAdminedFirstPostsByOthersStoriesSequenceDefinition f1727m = new Fb4aNonAdminedFirstPostsByOthersStoriesSequenceDefinition();
        public static final Fb4aAdminedFirstPostsByOthersStoriesSequenceDefinition f1728n = new Fb4aAdminedFirstPostsByOthersStoriesSequenceDefinition();

        /* compiled from: task_key_load_overall_rating */
        public final class Fb4aAdminedFirstPostsByOthersStoriesSequenceDefinition extends AbstractSequenceDefinition {
            public Fb4aAdminedFirstPostsByOthersStoriesSequenceDefinition() {
                super(1245185, "Fb4aPageFirstPostsByOthersStoriesSequence_IsAdmin", false, ImmutableSet.of("com.facebook.pages.identity.fragments.timeline.PageIdentityPostsByOthersFragment"));
            }
        }

        /* compiled from: task_key_load_overall_rating */
        public final class Fb4aAdminedFirstStoriesSequenceDefinition extends AbstractSequenceDefinition {
            public Fb4aAdminedFirstStoriesSequenceDefinition() {
                super(1245193, "Fb4aPageFirstStoriesSequence_IsAdmin", false, ImmutableSet.of("com.facebook.pages.identity.fragments.identity.PageIdentityFragment", "com.facebook.pages.identity.fragments.about.PageAboutFragment", "com.facebook.pages.fb4a.admin_activity.fragment.PageActivityFragment", "com.facebook.katana.activity.faceweb.FacewebFragment"));
            }
        }

        /* compiled from: task_key_load_overall_rating */
        public final class Fb4aAdminedPageHeaderInteractionSequenceDefinition extends AbstractSequenceDefinition {
            public Fb4aAdminedPageHeaderInteractionSequenceDefinition() {
                super(1245188, "Fb4aPageHeaderInteractionSequence_IsAdmin", false, ImmutableSet.of("com.facebook.pages.identity.fragments.identity.PageIdentityFragment", "com.facebook.pages.identity.fragments.about.PageAboutFragment", "com.facebook.pages.fb4a.admin_activity.fragment.PageActivityFragment", "com.facebook.katana.activity.faceweb.FacewebFragment"));
            }
        }

        /* compiled from: task_key_load_overall_rating */
        public final class Fb4aAdminedPagePresenceHeaderInteractionSequenceDefinition extends AbstractSequenceDefinition {
            public Fb4aAdminedPagePresenceHeaderInteractionSequenceDefinition() {
                super(1245311, "Fb4aPagePresenceHeaderInteractionSequence_IsAdmin", false, ImmutableSet.of("com.facebook.pages.identity.fragments.identity.PageIdentityFragment"));
            }
        }

        /* compiled from: task_key_load_overall_rating */
        public final class Fb4aNonAdminedFirstPostsByOthersStoriesSequenceDefinition extends AbstractSequenceDefinition {
            public Fb4aNonAdminedFirstPostsByOthersStoriesSequenceDefinition() {
                super(1245195, "Fb4aPageFirstPostsByOthersStoriesSequence", false, ImmutableSet.of("com.facebook.pages.identity.fragments.timeline.PageIdentityPostsByOthersFragment"));
            }
        }

        /* compiled from: task_key_load_overall_rating */
        public final class Fb4aNonAdminedFirstStoriesSequenceDefinition extends AbstractSequenceDefinition {
            public Fb4aNonAdminedFirstStoriesSequenceDefinition() {
                super(1245192, "Fb4aPageFirstStoriesSequence", false, ImmutableSet.of("com.facebook.pages.identity.fragments.identity.PageIdentityFragment", "com.facebook.pages.identity.fragments.about.PageAboutFragment"));
            }
        }

        /* compiled from: task_key_load_overall_rating */
        public final class Fb4aNonAdminedPageHeaderInteractionSequenceDefinition extends AbstractSequenceDefinition {
            public Fb4aNonAdminedPageHeaderInteractionSequenceDefinition() {
                super(1245187, "Fb4aPageHeaderInteractionSequence", false, ImmutableSet.of("com.facebook.pages.identity.fragments.identity.PageIdentityFragment", "com.facebook.pages.identity.fragments.about.PageAboutFragment"));
                h();
            }
        }

        /* compiled from: task_key_load_overall_rating */
        public final class Fb4aNonAdminedPagePresenceHeaderInteractionSequenceDefinition extends AbstractSequenceDefinition {
            public Fb4aNonAdminedPagePresenceHeaderInteractionSequenceDefinition() {
                super(1245310, "Fb4aPagePresenceHeaderInteractionSequence", false, ImmutableSet.of("com.facebook.pages.identity.fragments.surface.PagesSurfaceFragment"));
                h();
            }
        }

        /* compiled from: task_key_load_overall_rating */
        public class Fb4aSecondaryCardsSequenceDefinition extends AbstractSequenceDefinition {
            public Fb4aSecondaryCardsSequenceDefinition() {
                super(1245190, "Fb4aPageSecondaryCardsSequence");
            }
        }

        /* compiled from: task_key_load_overall_rating */
        public class PageNewLikesInteractionSequenceDefinition extends AbstractSequenceDefinition {
            public PageNewLikesInteractionSequenceDefinition() {
                super(1245191, "PageNewLikesInteractionSequence", false, ImmutableSet.of("com.facebook.pages.identity.fragments.about.PageAboutFragment"));
            }
        }

        /* compiled from: task_key_load_overall_rating */
        public class PageSurfaceFirstCardSequenceeDefinition extends AbstractSequenceDefinition {
            public PageSurfaceFirstCardSequenceeDefinition() {
                super(1245309, "PageSurfaceFirstCardSequence");
            }
        }

        /* compiled from: task_key_load_overall_rating */
        public final class PagesManagerFirstPostsByOthersStoriesSequence extends AbstractSequenceDefinition {
            public PagesManagerFirstPostsByOthersStoriesSequence() {
                super(1245186, "PmaPageFirstPostsByOthersStoriesSequence", false, ImmutableSet.of("com.facebook.pages.identity.fragments.timeline.PageIdentityPostsByOthersFragment"));
            }
        }

        /* compiled from: task_key_load_overall_rating */
        public final class PagesManagerFirstStoriesSequence extends AbstractSequenceDefinition {
            public PagesManagerFirstStoriesSequence() {
                super(1245194, "PmaPageFirstStoriesSequence", false, ImmutableSet.of("com.facebook.pages.identity.fragments.about.PageAboutFragment"));
            }
        }

        /* compiled from: task_key_load_overall_rating */
        public final class PagesManagerPageHeaderInteractionSequence extends AbstractSequenceDefinition {
            public PagesManagerPageHeaderInteractionSequence() {
                super(1245189, "PmaHeaderInteractionSequence", false, ImmutableSet.of("com.facebook.pages.identity.fragments.about.PageAboutFragment"));
            }
        }
    }
}

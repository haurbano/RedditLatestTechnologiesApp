package com.haur.data.responses

data class PostsRequestResponse(
    val `data`: Data,
    val kind: String
) {
    data class Data(
        val after: String,
        val before: Any,
        val children: List<Children>,
        val dist: Int,
        val modhash: String
    ) {
        data class Children(
            val `data`: Data,
            val kind: String
        ) {
            data class Data(
                val all_awardings: List<AllAwarding>,
                val allow_live_comments: Boolean,
                val approved_at_utc: Any,
                val approved_by: Any,
                val archived: Boolean,
                val author: String,
                val author_flair_background_color: Any,
                val author_flair_css_class: Any,
                val author_flair_richtext: List<Any>,
                val author_flair_template_id: Any,
                val author_flair_text: String,
                val author_flair_text_color: Any,
                val author_flair_type: String,
                val author_fullname: String,
                val author_patreon_flair: Boolean,
                val author_premium: Boolean,
                val awarders: List<Any>,
                val banned_at_utc: Any,
                val banned_by: Any,
                val can_gild: Boolean,
                val can_mod_post: Boolean,
                val category: Any,
                val clicked: Boolean,
                val content_categories: Any,
                val contest_mode: Boolean,
                val created: Long,
                val created_utc: Long,
                val discussion_type: Any,
                val distinguished: Any,
                val domain: String,
                val downs: Int,
                val gilded: Int,
                val gildings: Gildings,
                val hidden: Boolean,
                val hide_score: Boolean,
                val id: String,
                val is_crosspostable: Boolean,
                val is_meta: Boolean,
                val is_original_content: Boolean,
                val is_reddit_media_domain: Boolean,
                val is_robot_indexable: Boolean,
                val is_self: Boolean,
                val is_video: Boolean,
                val likes: Any,
                val link_flair_background_color: String,
                val link_flair_css_class: Any,
                val link_flair_richtext: List<Any>,
                val link_flair_text: Any,
                val link_flair_text_color: String,
                val link_flair_type: String,
                val locked: Boolean,
                val media: Any,
                val media_embed: MediaEmbed,
                val media_only: Boolean,
                val mod_note: Any,
                val mod_reason_by: Any,
                val mod_reason_title: Any,
                val mod_reports: List<Any>,
                val name: String,
                val no_follow: Boolean,
                val num_comments: Int,
                val num_crossposts: Int,
                val num_reports: Any,
                val over_18: Boolean,
                val parent_whitelist_status: String,
                val permalink: String,
                val pinned: Boolean,
                val post_hint: String,
                val preview: Preview?,
                val pwls: Int,
                val quarantine: Boolean,
                val removal_reason: Any,
                val removed_by: Any,
                val removed_by_category: Any,
                val report_reasons: Any,
                val saved: Boolean,
                val score: Int,
                val secure_media: Any,
                val secure_media_embed: SecureMediaEmbed,
                val selftext: String,
                val selftext_html: Any,
                val send_replies: Boolean,
                val spoiler: Boolean,
                val stickied: Boolean,
                val subreddit: String,
                val subreddit_id: String,
                val subreddit_name_prefixed: String,
                val subreddit_subscribers: Int,
                val subreddit_type: String,
                val suggested_sort: Any,
                val thumbnail: String,
                val thumbnail_height: Int,
                val thumbnail_width: Int,
                val title: String,
                val top_awarded_type: Any,
                val total_awards_received: Int,
                val treatment_tags: List<Any>,
                val ups: Int,
                val upvote_ratio: Double,
                val url: String,
                val user_reports: List<Any>,
                val view_count: Any,
                val visited: Boolean,
                val whitelist_status: String,
                val wls: Int
            ) {
                data class AllAwarding(
                    val award_sub_type: String,
                    val award_type: String,
                    val coin_price: Int,
                    val coin_reward: Int,
                    val count: Int,
                    val days_of_drip_extension: Int,
                    val days_of_premium: Int,
                    val description: String,
                    val end_date: Any,
                    val giver_coin_reward: Any,
                    val icon_format: Any,
                    val icon_height: Int,
                    val icon_url: String,
                    val icon_width: Int,
                    val id: String,
                    val is_enabled: Boolean,
                    val is_new: Boolean,
                    val name: String,
                    val penny_donate: Any,
                    val penny_price: Any,
                    val resized_icons: List<ResizedIcon>,
                    val resized_static_icons: List<ResizedStaticIcon>,
                    val start_date: Any,
                    val static_icon_height: Int,
                    val static_icon_url: String,
                    val static_icon_width: Int,
                    val subreddit_coin_reward: Int,
                    val subreddit_id: Any
                ) {
                    data class ResizedIcon(
                        val height: Int,
                        val url: String,
                        val width: Int
                    )

                    data class ResizedStaticIcon(
                        val height: Int,
                        val url: String,
                        val width: Int
                    )
                }

                data class Gildings(
                    val gid_2: Int
                )

                class MediaEmbed(
                )

                data class Preview(
                    val enabled: Boolean,
                    val images: List<Image>,
                    val reddit_video_preview: RedditVideoPreview
                ) {
                    data class Image(
                        val id: String,
                        val resolutions: List<Resolution>,
                        val source: Source,
                        val variants: Variants
                    ) {
                        data class Resolution(
                            val height: Int,
                            val url: String,
                            val width: Int
                        )

                        data class Source(
                            val height: Int,
                            val url: String,
                            val width: Int
                        )

                        data class Variants(
                            val gif: Gif,
                            val mp4: Mp4
                        ) {
                            data class Gif(
                                val resolutions: List<Resolution>,
                                val source: Source
                            ) {
                                data class Resolution(
                                    val height: Int,
                                    val url: String,
                                    val width: Int
                                )

                                data class Source(
                                    val height: Int,
                                    val url: String,
                                    val width: Int
                                )
                            }

                            data class Mp4(
                                val resolutions: List<Resolution>,
                                val source: Source
                            ) {
                                data class Resolution(
                                    val height: Int,
                                    val url: String,
                                    val width: Int
                                )

                                data class Source(
                                    val height: Int,
                                    val url: String,
                                    val width: Int
                                )
                            }
                        }
                    }

                    data class RedditVideoPreview(
                        val dash_url: String,
                        val duration: Int,
                        val fallback_url: String,
                        val height: Int,
                        val hls_url: String,
                        val is_gif: Boolean,
                        val scrubber_media_url: String,
                        val transcoding_status: String,
                        val width: Int
                    )
                }

                class SecureMediaEmbed(
                )
            }
        }
    }
}
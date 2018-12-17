package org.xcolab.service.utils.db.jooq.test.generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
        value = {
                "http://www.jooq.org",
                "jOOQ version:3.9.2"
        },
        comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ContestTable extends TableImpl<ContestRecord> {

    private static final long serialVersionUID = -2087556772;

    /**
     * The reference instance of <code>contest__contest</code>
     */
    public static final ContestTable CONTEST = new ContestTable();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ContestRecord> getRecordType() {
        return ContestRecord.class;
    }

    /**
     * The column <code>contest__contest.id</code>.
     */
    public final TableField<ContestRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>contest__contest.contest_type_id</code>.
     */
    public final TableField<ContestRecord, Long> CONTEST_TYPE_ID = createField("contest_type_id", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>contest__contest.question</code>.
     */
    public final TableField<ContestRecord, String> QUESTION = createField("question", org.jooq.impl.SQLDataType.VARCHAR.length(1024), this, "");

    /**
     * The column <code>contest__contest.title</code>.
     */
    public final TableField<ContestRecord, String> TITLE = createField("title", org.jooq.impl.SQLDataType.VARCHAR.length(512), this, "");

    /**
     * The column <code>contest__contest.contest_url_name</code>.
     */
    public final TableField<ContestRecord, String> CONTEST_URL_NAME = createField("contest_url_name", org.jooq.impl.SQLDataType.VARCHAR.length(75), this, "");

    /**
     * The column <code>contest__contest.contest_year</code>.
     */
    public final TableField<ContestRecord, Long> CONTEST_YEAR = createField("contest_year", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>contest__contest.description</code>.
     */
    public final TableField<ContestRecord, String> DESCRIPTION = createField("description", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>contest__contest.contest_model_description</code>.
     */
    public final TableField<ContestRecord, String> CONTEST_MODEL_DESCRIPTION = createField("contest_model_description", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>contest__contest.contest_positions_description</code>.
     */
    public final TableField<ContestRecord, String> CONTEST_POSITIONS_DESCRIPTION = createField("contest_positions_description", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>contest__contest.created_at</code>.
     */
    public final TableField<ContestRecord, Timestamp> CREATED_AT = createField("created_at", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>contest__contest.updated_at</code>.
     */
    public final TableField<ContestRecord, Timestamp> UPDATED_AT = createField("updated_at", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>contest__contest.author_user_id</code>.
     */
    public final TableField<ContestRecord, Long> AUTHOR_USER_ID = createField("author_user_id", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>contest__contest.contest_active</code>.
     */
    public final TableField<ContestRecord, Boolean> CONTEST_ACTIVE = createField("contest_active", org.jooq.impl.SQLDataType.BOOLEAN, this, "");

    /**
     * The column <code>contest__contest.proposal_template_id</code>.
     */
    public final TableField<ContestRecord, Long> PROPOSAL_TEMPLATE_ID = createField("proposal_template_id", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>contest__contest.contest_schedule_id</code>.
     */
    public final TableField<ContestRecord, Long> CONTEST_SCHEDULE_ID = createField("contest_schedule_id", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>contest__contest.proposal_creation_template_string</code>.
     */
    public final TableField<ContestRecord, String> PROPOSAL_CREATION_TEMPLATE_STRING = createField("proposal_creation_template_string", org.jooq.impl.SQLDataType.VARCHAR.length(75), this, "");

    /**
     * The column <code>contest__contest.vote_template_string</code>.
     */
    public final TableField<ContestRecord, String> VOTE_TEMPLATE_STRING = createField("vote_template_string", org.jooq.impl.SQLDataType.VARCHAR.length(75), this, "");

    /**
     * The column <code>contest__contest.proposal_vote_template_string</code>.
     */
    public final TableField<ContestRecord, String> PROPOSAL_VOTE_TEMPLATE_STRING = createField("proposal_vote_template_string", org.jooq.impl.SQLDataType.VARCHAR.length(75), this, "");

    /**
     * The column <code>contest__contest.proposal_vote_confirmation_template_string</code>.
     */
    public final TableField<ContestRecord, String> PROPOSAL_VOTE_CONFIRMATION_TEMPLATE_STRING = createField("proposal_vote_confirmation_template_string", org.jooq.impl.SQLDataType.VARCHAR.length(75), this, "");

    /**
     * The column <code>contest__contest.vote_question_template_string</code>.
     */
    public final TableField<ContestRecord, String> VOTE_QUESTION_TEMPLATE_STRING = createField("vote_question_template_string", org.jooq.impl.SQLDataType.VARCHAR.length(75), this, "");

    /**
     * The column <code>contest__contest.focus_area_id</code>.
     */
    public final TableField<ContestRecord, Long> FOCUS_AREA_ID = createField("focus_area_id", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>contest__contest.contest_tier</code>.
     */
    public final TableField<ContestRecord, Long> CONTEST_TIER = createField("contest_tier", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>contest__contest.contest_logo_id</code>.
     */
    public final TableField<ContestRecord, Long> CONTEST_LOGO_ID = createField("contest_logo_id", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>contest__contest.featured</code>.
     */
    public final TableField<ContestRecord, Boolean> FEATURED = createField("featured", org.jooq.impl.SQLDataType.BOOLEAN, this, "");

    /**
     * The column <code>contest__contest.plans_open_by_default</code>.
     */
    public final TableField<ContestRecord, Boolean> PLANS_OPEN_BY_DEFAULT = createField("plans_open_by_default", org.jooq.impl.SQLDataType.BOOLEAN, this, "");

    /**
     * The column <code>contest__contest.sponsor_logo_id</code>.
     */
    public final TableField<ContestRecord, Long> SPONSOR_LOGO_ID = createField("sponsor_logo_id", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>contest__contest.default_proposal_logo_id</code>.
     */
    public final TableField<ContestRecord, Long> DEFAULT_PROPOSAL_LOGO_ID = createField("default_proposal_logo_id", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>contest__contest.sponsor_text</code>.
     */
    public final TableField<ContestRecord, String> SPONSOR_TEXT = createField("sponsor_text", org.jooq.impl.SQLDataType.VARCHAR.length(500), this, "");

    /**
     * The column <code>contest__contest.sponsor_link</code>.
     */
    public final TableField<ContestRecord, String> SPONSOR_LINK = createField("sponsor_link", org.jooq.impl.SQLDataType.VARCHAR.length(500), this, "");

    /**
     * The column <code>contest__contest.flag</code>.
     */
    public final TableField<ContestRecord, Integer> FLAG = createField("flag", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>contest__contest.flag_text</code>.
     */
    public final TableField<ContestRecord, String> FLAG_TEXT = createField("flag_text", org.jooq.impl.SQLDataType.VARCHAR.length(256), this, "");

    /**
     * The column <code>contest__contest.flag_tooltip</code>.
     */
    public final TableField<ContestRecord, String> FLAG_TOOLTIP = createField("flag_tooltip", org.jooq.impl.SQLDataType.VARCHAR.length(512), this, "");

    /**
     * The column <code>contest__contest.discussion_group_id</code>.
     */
    public final TableField<ContestRecord, Long> DISCUSSION_GROUP_ID = createField("discussion_group_id", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>contest__contest.weight</code>.
     */
    public final TableField<ContestRecord, Integer> WEIGHT = createField("weight", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>contest__contest.resources_url</code>.
     */
    public final TableField<ContestRecord, String> RESOURCES_URL = createField("resources_url", org.jooq.impl.SQLDataType.VARCHAR.length(1024), this, "");

    /**
     * The column <code>contest__contest.contest_private</code>.
     */
    public final TableField<ContestRecord, Boolean> CONTEST_PRIVATE = createField("contest_private", org.jooq.impl.SQLDataType.BOOLEAN, this, "");

    /**
     * The column <code>contest__contest.use_permissions</code>.
     */
    public final TableField<ContestRecord, Boolean> USE_PERMISSIONS = createField("use_permissions", org.jooq.impl.SQLDataType.BOOLEAN, this, "");

    /**
     * The column <code>contest__contest.contest_creation_status</code>.
     */
    public final TableField<ContestRecord, String> CONTEST_CREATION_STATUS = createField("contest_creation_status", org.jooq.impl.SQLDataType.VARCHAR.length(75), this, "");

    /**
     * The column <code>contest__contest.default_model_id</code>.
     */
    public final TableField<ContestRecord, Long> DEFAULT_MODEL_ID = createField("default_model_id", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>contest__contest.other_models</code>.
     */
    public final TableField<ContestRecord, String> OTHER_MODELS = createField("other_models", org.jooq.impl.SQLDataType.VARCHAR.length(75), this, "");

    /**
     * The column <code>contest__contest.default_model_settings</code>.
     */
    public final TableField<ContestRecord, String> DEFAULT_MODEL_SETTINGS = createField("default_model_settings", org.jooq.impl.SQLDataType.VARCHAR.length(75), this, "");

    /**
     * The column <code>contest__contest.points</code>.
     */
    public final TableField<ContestRecord, Double> POINTS = createField("points", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>contest__contest.default_parent_point_type</code>.
     */
    public final TableField<ContestRecord, Long> DEFAULT_PARENT_POINT_TYPE = createField("default_parent_point_type", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>contest__contest.point_distribution_strategy</code>.
     */
    public final TableField<ContestRecord, String> POINT_DISTRIBUTION_STRATEGY = createField("point_distribution_strategy", org.jooq.impl.SQLDataType.VARCHAR.length(75), this, "");

    /**
     * The column <code>contest__contest.email_template_url</code>.
     */
    public final TableField<ContestRecord, String> EMAIL_TEMPLATE_URL = createField("email_template_url", org.jooq.impl.SQLDataType.VARCHAR.length(500), this, "");

    /**
     * The column <code>contest__contest.show_in_tile_view</code>.
     */
    public final TableField<ContestRecord, Boolean> SHOW_IN_TILE_VIEW = createField("show_in_tile_view", org.jooq.impl.SQLDataType.BOOLEAN, this, "");

    /**
     * The column <code>contest__contest.show_in_list_view</code>.
     */
    public final TableField<ContestRecord, Boolean> SHOW_IN_LIST_VIEW = createField("show_in_list_view", org.jooq.impl.SQLDataType.BOOLEAN, this, "");

    /**
     * The column <code>contest__contest.show_in_outline_view</code>.
     */
    public final TableField<ContestRecord, Boolean> SHOW_IN_OUTLINE_VIEW = createField("show_in_outline_view", org.jooq.impl.SQLDataType.BOOLEAN, this, "");

    /**
     * The column <code>contest__contest.hide_ribbons</code>.
     */
    public final TableField<ContestRecord, Boolean> HIDE_RIBBONS = createField("hide_ribbons", org.jooq.impl.SQLDataType.BOOLEAN, this, "");

    /**
     * The column <code>contest__contest.resource_article_id</code>.
     */
    public final TableField<ContestRecord, Long> RESOURCE_ARTICLE_ID = createField("resource_article_id", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>contest__contest.read_only_comments</code>.
     */
    public final TableField<ContestRecord, Boolean> READ_ONLY_COMMENTS = createField("read_only_comments", org.jooq.impl.SQLDataType.BOOLEAN.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.BOOLEAN)), this, "");

    /**
     * Create a <code>contest__contest</code> table reference
     */
    public ContestTable() {
        this("contest__contest", null);
    }

    /**
     * Create an aliased <code>contest__contest</code> table reference
     */
    public ContestTable(String alias) {
        this(alias, CONTEST);
    }

    private ContestTable(String alias, Table<ContestRecord> aliased) {
        this(alias, aliased, null);
    }

    private ContestTable(String alias, Table<ContestRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<ContestRecord, Long> getIdentity() {
        return Keys.IDENTITY_CONTEST;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ContestRecord> getPrimaryKey() {
        return Keys.CONTEST_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ContestRecord>> getKeys() {
        return Arrays.<UniqueKey<ContestRecord>>asList(Keys.CONTEST_PRIMARY, Keys.CONTEST_UNIQUE_INDEX_CONTEST_NAME_YEAR);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ContestTable as(String alias) {
        return new ContestTable(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public ContestTable rename(String name) {
        return new ContestTable(name, null);
    }
}

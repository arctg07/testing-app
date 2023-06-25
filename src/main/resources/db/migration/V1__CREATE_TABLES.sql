CREATE TABLE users
(
    id                  BIGINT          GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    login               VARCHAR(30)     NOT NULL UNIQUE,
    password            VARCHAR(30)     NOT NULL,

    CONSTRAINT pk_user PRIMARY KEY (id)
);

CREATE TABLE questions
(
    id                  BIGINT          GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    question            VARCHAR(300)    NOT NULL UNIQUE,
    answer_options      VARCHAR(120),
    correct_answer      VARCHAR(30)     NOT NULL,

    CONSTRAINT pk_question PRIMARY KEY (id)
);


CREATE TABLE answers
(
  id                    BIGINT          GENERATED BY DEFAULT AS IDENTITY NOT NULL,
  user_id               BIGINT          NOT NULL,
  question_id           BIGINT          NOT NULL,
  answer                VARCHAR(30)     NOT NULL,
  result                BOOLEAN         NOT NULL,

  CONSTRAINT pk_test_process PRIMARY KEY (id)
);

CREATE OR REPLACE FUNCTION check_question_count()
    RETURNS TRIGGER AS $$
BEGIN
    IF (SELECT COUNT(*) FROM questions) > 5 THEN
        RAISE EXCEPTION 'Maximum question count exceeded';
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trigger_check_question_count
    BEFORE INSERT ON questions
    FOR EACH ROW
EXECUTE FUNCTION check_question_count();
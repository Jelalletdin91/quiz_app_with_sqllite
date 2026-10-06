PRAGMA foreign_keys = ON;

DROP TABLE IF EXISTS answers;
DROP TABLE IF EXISTS session_questions;
DROP TABLE IF EXISTS questions;
DROP TABLE IF EXISTS sessions;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
    id          INTEGER PRIMARY KEY AUTOINCREMENT,
    user_name   TEXT NOT NULL UNIQUE,
    full_name   TEXT NOT NULL,
    created_at  TEXT NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE sessions (
    id              INTEGER PRIMARY KEY AUTOINCREMENT,
    title           TEXT NOT NULL,
    session_status  TEXT NOT NULL DEFAULT 'not_started'
                    CHECK (session_status IN ('not_started','active','finished')),
    started_at      TEXT NULL,
    ended_at        TEXT NULL,
    CONSTRAINT chk_session_time CHECK (
        (session_status = 'not_started' AND started_at IS NULL     AND ended_at IS NULL) OR
        (session_status = 'active'      AND started_at IS NOT NULL AND ended_at IS NULL) OR
        (session_status = 'finished'    AND started_at IS NOT NULL AND ended_at IS NOT NULL
                                        AND ended_at >= started_at)
    )
);

CREATE TABLE questions (
    id              INTEGER PRIMARY KEY AUTOINCREMENT,
    question        TEXT NOT NULL,
    option_a        TEXT NOT NULL,
    option_b        TEXT NOT NULL,
    option_c        TEXT NOT NULL,
    option_d        TEXT NOT NULL,
    correct_option  TEXT NOT NULL CHECK (correct_option IN ('A','B','C','D')),
    points          INTEGER NOT NULL DEFAULT 1 CHECK (points > 0)
);

CREATE TABLE session_questions (
    session_id   INTEGER NOT NULL REFERENCES sessions(id)  ON DELETE CASCADE,
    question_id  INTEGER NOT NULL REFERENCES questions(id) ON DELETE RESTRICT,
    position     INTEGER NOT NULL CHECK (position > 0),
    PRIMARY KEY (session_id, question_id),
    UNIQUE (session_id, position)
);

CREATE TABLE answers (
    id               INTEGER PRIMARY KEY AUTOINCREMENT,
    user_id          INTEGER NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    session_id       INTEGER NOT NULL,
    question_id      INTEGER NOT NULL,
    selected_option  TEXT NULL CHECK (selected_option IN ('A','B','C','D')),
    answered_at      TEXT NOT NULL DEFAULT CURRENT_TIMESTAMP,
    UNIQUE (user_id, session_id, question_id),
    FOREIGN KEY (session_id, question_id)
        REFERENCES session_questions(session_id, question_id) ON DELETE CASCADE
);

CREATE INDEX idx_answers_session_question ON answers(session_id, question_id);
CREATE INDEX idx_sessions_status ON sessions(session_status);
CREATE INDEX idx_session_questions_question ON session_questions(question_id);

CREATE TRIGGER trg_answer_only_active
BEFORE INSERT ON answers
WHEN (SELECT session_status FROM sessions WHERE id = NEW.session_id) <> 'active'
BEGIN
    SELECT RAISE(ABORT, 'Cevap yalnizca aktif oturumda verilebilir');
END;

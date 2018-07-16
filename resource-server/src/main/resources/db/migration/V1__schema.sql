CREATE TABLE IF NOT EXISTS tasks (
  task_id    VARCHAR(36) PRIMARY KEY,
  task       VARCHAR(255),
  username   VARCHAR(32),
  created_at TIMESTAMP
);
CREATE TABLE IF NOT EXISTS resources (
  resource_id VARCHAR(36) PRIMARY KEY,
  msg        VARCHAR(255),
  username   VARCHAR(32),
  created_at TIMESTAMP
);
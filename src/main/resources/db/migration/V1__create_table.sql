CREATE TABLE pets(
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  breed VARCHAR(255) NOT NULL,
  age INTEGER NOT NULL,
  species VARCHAR(255) NOT NULL,
  fixed BOOLEAN NOT NULL
);
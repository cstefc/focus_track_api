INSERT INTO app_user (email, name, uuid, roles) values ('stef.osse@example.com', 'Stef Ossé', 'cstefc', '{0}');

INSERT INTO project (app_user_uuid, name, description, archived) VALUES ('cstefc', 'Focus Tracker', 'A project to track focus sessions for appUser 1', false);
INSERT INTO project (app_user_uuid, name, description, archived) VALUES ('cstefc', 'Workout Logger', 'Logs all workouts and training sessions', false);
INSERT INTO project (app_user_uuid, name, description, archived) VALUES ('cstefc', 'Reading List', 'Tracks books and articles to read', false);

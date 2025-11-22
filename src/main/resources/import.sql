-- ---------------------------------------------------
-- Dev user
-- ---------------------------------------------------
INSERT INTO app_user (uuid, name, email, roles) VALUES ('dev-001', 'Development', 'developer@focustrack.com', '{0, 1}');

-- ---------------------------------------------------
-- Logs for Projects
-- ---------------------------------------------------
INSERT INTO log (id, archived) VALUES (1, FALSE);
INSERT INTO log (id, archived) VALUES (2, FALSE);
INSERT INTO log (id, archived) VALUES (3, FALSE);

-- ---------------------------------------------------
-- Projects
-- ---------------------------------------------------
INSERT INTO project (app_user_uuid, title, description, log_id, archived) VALUES ('dev-001', 'Project Alpha', 'Description of Project Alpha', 1,FALSE);
INSERT INTO project (app_user_uuid, title, description, log_id, archived) VALUES('dev-001','Project Beta', 'Description of Project Beta', 2, FALSE);
INSERT INTO project (app_user_uuid, title, description, log_id, archived) VALUES ('dev-001', 'Project Gamma', 'Description of Project Gamma', 3, FALSE);
SELECT setval('project_id_seq', (SELECT MAX(id) FROM project));

-- ---------------------------------------------------
-- Goals (5 per project)
-- ---------------------------------------------------
-- Project 1
INSERT INTO goal (id, project_id, title, description, priority, estimated) VALUES (1,1,'Title 1 for Alpha', 'Goal 1 for Alpha',0,NULL);
INSERT INTO goal (id, project_id, title, description, priority, estimated) VALUES (2,1,'Title 2 for Alpha', 'Goal 2 for Alpha',1,NULL);
INSERT INTO goal (id, project_id, title, description, priority, estimated) VALUES (3,1,'Title 3 for Alpha', 'Goal 3 for Alpha',2,NULL);
INSERT INTO goal (id, project_id, title, description, priority, estimated) VALUES (4,1,'Title 4 for Alpha', 'Goal 4 for Alpha',1,NULL);
INSERT INTO goal (id, project_id, title, description, priority, estimated) VALUES (5,1,'Title 5 for Alpha', 'Goal 5 for Alpha',0,NULL);
-- Project 2
INSERT INTO goal (id, project_id, title, description, priority, estimated) VALUES (6,2,'Title 1 for Beta', 'Goal 1 for Beta',1,NULL);
INSERT INTO goal (id, project_id, title, description, priority, estimated) VALUES (7,2,'Title 2 for Beta', 'Goal 2 for Beta',2,NULL);
INSERT INTO goal (id, project_id, title, description, priority, estimated) VALUES (8,2,'Title 3 for Beta', 'Goal 3 for Beta',0,NULL);
INSERT INTO goal (id, project_id, title, description, priority, estimated) VALUES (9,2,'Title 4 for Beta', 'Goal 4 for Beta',1,NULL);
INSERT INTO goal (id, project_id, title, description, priority, estimated) VALUES (10,2,'Title 5 for Beta', 'Goal 5 for Beta',2,NULL);
-- Project 3
INSERT INTO goal (id, project_id, title, description, priority, estimated) VALUES (11,3,'Title 1 for Gamma', 'Goal 1 for Gamma',0,NULL);
INSERT INTO goal (id, project_id, title, description, priority, estimated) VALUES (12,3,'Title 2 for Gamma', 'Goal 2 for Gamma',1,NULL);
INSERT INTO goal (id, project_id, title, description, priority, estimated) VALUES (13,3,'Title 3 for Gamma', 'Goal 3 for Gamma',2,NULL);
INSERT INTO goal (id, project_id, title, description, priority, estimated) VALUES (14,3,'Title 4 for Gamma', 'Goal 4 for Gamma',1,NULL);
INSERT INTO goal (id, project_id, title, description, priority, estimated) VALUES (15,3,'Title 5 for Gamma', 'Goal 5 for Gamma',0,NULL);
SELECT setval('goal_id_seq', (SELECT MAX(id) FROM goal));

-- ---------------------------------------------------
-- Steps (10 per goal)
-- ---------------------------------------------------
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES (1,1,1,'Objective 1','Step description 1','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES (2,1,2,'Objective 2','Step description 2','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES (3,1,3,'Objective 3','Step description 3','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES (4,1,4,'Objective 4','Step description 4','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES (5,1,5,'Objective 5','Step description 5','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES (6,1,6,'Objective 6','Step description 6','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES (7,1,7,'Objective 7','Step description 7','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES (8,1,8,'Objective 8','Step description 8','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES (9,1,9,'Objective 9','Step description 9','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES (10,1,10,'Objective 10','Step description 10','None',0,NULL);

-- Goal 2
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES (11,2,1,'Objective 1','Step description 1','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES (12,2,2,'Objective 2','Step description 2','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES (13,2,3,'Objective 3','Step description 3','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES (14,2,4,'Objective 4','Step description 4','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES (15,2,5,'Objective 5','Step description 5','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES (16,2,6,'Objective 6','Step description 6','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES (17,2,7,'Objective 7','Step description 7','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES (18,2,8,'Objective 8','Step description 8','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES (19,2,9,'Objective 9','Step description 9','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES (20,2,10,'Objective 10','Step description 10','None',0,NULL);

-- Goal 3

INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(21,3,1,'Objective 1','Step description 1','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(22,3,2,'Objective 2','Step description 2','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(23,3,3,'Objective 3','Step description 3','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(24,3,4,'Objective 4','Step description 4','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(25,3,5,'Objective 5','Step description 5','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(26,3,6,'Objective 6','Step description 6','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(27,3,7,'Objective 7','Step description 7','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(28,3,8,'Objective 8','Step description 8','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(29,3,9,'Objective 9','Step description 9','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(30,3,10,'Objective 10','Step description 10','None',0,NULL);

-- Goal 4
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(31,4,1,'Objective 1','Step description 1','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(32,4,2,'Objective 2','Step description 2','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(33,4,3,'Objective 3','Step description 3','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(34,4,4,'Objective 4','Step description 4','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(35,4,5,'Objective 5','Step description 5','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(36,4,6,'Objective 6','Step description 6','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(37,4,7,'Objective 7','Step description 7','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(38,4,8,'Objective 8','Step description 8','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(39,4,9,'Objective 9','Step description 9','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(40,4,10,'Objective 10','Step description 10','None',0,NULL);

-- Goal 5
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(41,5,1,'Objective 1','Step description 1','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(42,5,2,'Objective 2','Step description 2','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(43,5,3,'Objective 3','Step description 3','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(44,5,4,'Objective 4','Step description 4','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(45,5,5,'Objective 5','Step description 5','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(46,5,6,'Objective 6','Step description 6','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(47,5,7,'Objective 7','Step description 7','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(48,5,8,'Objective 8','Step description 8','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(49,5,9,'Objective 9','Step description 9','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(50,5,10,'Objective 10','Step description 10','None',0,NULL);

-- Goal 6
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(51,6,1,'Objective 1','Step description 1','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(52,6,2,'Objective 2','Step description 2','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(53,6,3,'Objective 3','Step description 3','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(54,6,4,'Objective 4','Step description 4','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(55,6,5,'Objective 5','Step description 5','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(56,6,6,'Objective 6','Step description 6','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(57,6,7,'Objective 7','Step description 7','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(58,6,8,'Objective 8','Step description 8','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(59,6,9,'Objective 9','Step description 9','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(60,6,10,'Objective 10','Step description 10','None',0,NULL);

-- Goal 7
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(61,7,1,'Objective 1','Step description 1','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(62,7,2,'Objective 2','Step description 2','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(63,7,3,'Objective 3','Step description 3','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(64,7,4,'Objective 4','Step description 4','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(65,7,5,'Objective 5','Step description 5','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(66,7,6,'Objective 6','Step description 6','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(67,7,7,'Objective 7','Step description 7','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(68,7,8,'Objective 8','Step description 8','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(69,7,9,'Objective 9','Step description 9','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(70,7,10,'Objective 10','Step description 10','None',0,NULL);

-- Goal 8
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(71,8,1,'Objective 1','Step description 1','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(72,8,2,'Objective 2','Step description 2','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(73,8,3,'Objective 3','Step description 3','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(74,8,4,'Objective 4','Step description 4','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(75,8,5,'Objective 5','Step description 5','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(76,8,6,'Objective 6','Step description 6','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(77,8,7,'Objective 7','Step description 7','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(78,8,8,'Objective 8','Step description 8','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(79,8,9,'Objective 9','Step description 9','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(80,8,10,'Objective 10','Step description 10','None',0,NULL);

-- Goal 9
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(81,9,1,'Objective 1','Step description 1','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(82,9,2,'Objective 2','Step description 2','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(83,9,3,'Objective 3','Step description 3','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(84,9,4,'Objective 4','Step description 4','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(85,9,5,'Objective 5','Step description 5','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(86,9,6,'Objective 6','Step description 6','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(87,9,7,'Objective 7','Step description 7','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(88,9,8,'Objective 8','Step description 8','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(89,9,9,'Objective 9','Step description 9','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(90,9,10,'Objective 10','Step description 10','None',0,NULL);

-- Goal 10
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(91,10,1,'Objective 1','Step description 1','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(92,10,2,'Objective 2','Step description 2','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(93,10,3,'Objective 3','Step description 3','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(94,10,4,'Objective 4','Step description 4','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(95,10,5,'Objective 5','Step description 5','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(96,10,6,'Objective 6','Step description 6','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(97,10,7,'Objective 7','Step description 7','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(98,10,8,'Objective 8','Step description 8','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(99,10,9,'Objective 9','Step description 9','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(100,10,10,'Objective 10','Step description 10','None',0,NULL);

-- Goal 11
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(101,11,1,'Objective 1','Step description 1','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(102,11,2,'Objective 2','Step description 2','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(103,11,3,'Objective 3','Step description 3','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(104,11,4,'Objective 4','Step description 4','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(105,11,5,'Objective 5','Step description 5','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(106,11,6,'Objective 6','Step description 6','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(107,11,7,'Objective 7','Step description 7','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(108,11,8,'Objective 8','Step description 8','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(109,11,9,'Objective 9','Step description 9','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(110,11,10,'Objective 10','Step description 10','None',0,NULL);

-- Goal 12
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(111,12,1,'Objective 1','Step description 1','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(112,12,2,'Objective 2','Step description 2','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(113,12,3,'Objective 3','Step description 3','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(114,12,4,'Objective 4','Step description 4','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(115,12,5,'Objective 5','Step description 5','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(116,12,6,'Objective 6','Step description 6','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(117,12,7,'Objective 7','Step description 7','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(118,12,8,'Objective 8','Step description 8','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(119,12,9,'Objective 9','Step description 9','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(120,12,10,'Objective 10','Step description 10','None',0,NULL);

-- Goal 13
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(121,13,1,'Objective 1','Step description 1','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(122,13,2,'Objective 2','Step description 2','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(123,13,3,'Objective 3','Step description 3','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(124,13,4,'Objective 4','Step description 4','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(125,13,5,'Objective 5','Step description 5','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(126,13,6,'Objective 6','Step description 6','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(127,13,7,'Objective 7','Step description 7','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(128,13,8,'Objective 8','Step description 8','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(129,13,9,'Objective 9','Step description 9','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(130,13,10,'Objective 10','Step description 10','None',0,NULL);

-- Goal 14
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(131,14,1,'Objective 1','Step description 1','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(132,14,2,'Objective 2','Step description 2','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(133,14,3,'Objective 3','Step description 3','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(134,14,4,'Objective 4','Step description 4','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(135,14,5,'Objective 5','Step description 5','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(136,14,6,'Objective 6','Step description 6','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(137,14,7,'Objective 7','Step description 7','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(138,14,8,'Objective 8','Step description 8','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(139,14,9,'Objective 9','Step description 9','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(140,14,10,'Objective 10','Step description 10','None',0,NULL);

-- Goal 15
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(141,15,1,'Objective 1','Step description 1','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(142,15,2,'Objective 2','Step description 2','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(143,15,3,'Objective 3','Step description 3','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(144,15,4,'Objective 4','Step description 4','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(145,15,5,'Objective 5','Step description 5','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(146,15,6,'Objective 6','Step description 6','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(147,15,7,'Objective 7','Step description 7','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(148,15,8,'Objective 8','Step description 8','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(149,15,9,'Objective 9','Step description 9','None',0,NULL);
INSERT INTO step (id, goal_id, sequence, objective, description, requirements, status, completed_at) VALUES(150,15,10,'Objective 10','Step description 10','None',0,NULL);
SELECT setval('step_id_seq', (SELECT MAX(id) FROM step));

-- ---------------------------------------------------
-- Entries for project logs (2 entries per project)
-- ---------------------------------------------------

INSERT INTO entry (id, log_id, title, description, scoring, entry_type) VALUES (1,1,'Entry 1','Description 1',5,0);
INSERT INTO entry (id, log_id, title, description, scoring, entry_type) VALUES (2,1,'Entry 2','Description 2',3,1);
INSERT INTO entry (id, log_id, title, description, scoring, entry_type) VALUES (3,2,'Entry 1','Description 1',4,0);
INSERT INTO entry (id, log_id, title, description, scoring, entry_type) VALUES (4,2,'Entry 2','Description 2',2,1);
INSERT INTO entry (id, log_id, title, description, scoring, entry_type) VALUES (5,3,'Entry 1','Description 1',5,0);
INSERT INTO entry (id, log_id, title, description, scoring, entry_type) VALUES (6,3,'Entry 2','Description 2',1,1);
SELECT setval('entry_id_seq', (SELECT MAX(id) FROM entry));

-- ---------------------------------------------------
-- Logs for events
-- ---------------------------------------------------

INSERT INTO log (id, archived) VALUES (4,FALSE)  ;
INSERT INTO log (id, archived) VALUES (5,FALSE);
INSERT INTO log (id, archived) VALUES (6,FALSE);
INSERT INTO log (id, archived) VALUES (7,FALSE);
INSERT INTO log (id, archived) VALUES (8,FALSE);
INSERT INTO log (id, archived) VALUES (9,FALSE);
INSERT INTO log (id, archived) VALUES (10,FALSE);
INSERT INTO log (id, archived) VALUES (11,FALSE);
INSERT INTO log (id, archived) VALUES (12,FALSE);
INSERT INTO log (id, archived) VALUES (13,FALSE);
SELECT setval('log_id_seq', (SELECT MAX(id) FROM log));

-- ---------------------------------------------------
-- Events (10 events for dev user)
-- ---------------------------------------------------

INSERT INTO event (id, app_user_uuid, log_id, title, description, start, planned_stop, stop, timed) VALUES  (1,'dev-001',4,'Event 1','Description 1',CURRENT_DATE,CURRENT_DATE + INTERVAL '1 hour',NULL,FALSE);
INSERT INTO event (id, app_user_uuid, log_id, title, description, start, planned_stop, stop, timed) VALUES  (2,'dev-001',5,'Event 2','Description 2',CURRENT_DATE,CURRENT_DATE + INTERVAL '1 hour',NULL,FALSE);
INSERT INTO event (id, app_user_uuid, log_id, title, description, start, planned_stop, stop, timed) VALUES  (3,'dev-001',6,'Event 3','Description 3',CURRENT_DATE,CURRENT_DATE + INTERVAL '1 hour',NULL,FALSE);
INSERT INTO event (id, app_user_uuid, log_id, title, description, start, planned_stop, stop, timed) VALUES  (4,'dev-001',7,'Event 4','Description 4',CURRENT_DATE,CURRENT_DATE + INTERVAL '1 hour',NULL,FALSE);
INSERT INTO event (id, app_user_uuid, log_id, title, description, start, planned_stop, stop, timed) VALUES  (5,'dev-001',8,'Event 5','Description 5',CURRENT_DATE,CURRENT_DATE + INTERVAL '1 hour',NULL,FALSE);
INSERT INTO event (id, app_user_uuid, log_id, title, description, start, planned_stop, stop, timed) VALUES  (6,'dev-001',9,'Event 6','Description 6',CURRENT_DATE,CURRENT_DATE + INTERVAL '1 hour',NULL,FALSE);
INSERT INTO event (id, app_user_uuid, log_id, title, description, start, planned_stop, stop, timed) VALUES  (7,'dev-001',10,'Event 7','Description 7',CURRENT_DATE,CURRENT_DATE + INTERVAL '1 hour',NULL,FALSE);
INSERT INTO event (id, app_user_uuid, log_id, title, description, start, planned_stop, stop, timed) VALUES  (8,'dev-001',11,'Event 8','Description 8',CURRENT_DATE,CURRENT_DATE + INTERVAL '1 hour',NULL,FALSE);
INSERT INTO event (id, app_user_uuid, log_id, title, description, start, planned_stop, stop, timed) VALUES  (9,'dev-001',12,'Event 9','Description 9',CURRENT_DATE,CURRENT_DATE + INTERVAL '1 hour',NULL,FALSE);
INSERT INTO event (id, app_user_uuid, log_id, title, description, start, planned_stop, stop, timed) VALUES  (10,'dev-001',13,'Event 10','Description 10',CURRENT_DATE,CURRENT_DATE + INTERVAL '1 hour',NULL,FALSE);
SELECT setval('event_id_seq', (SELECT MAX(id) FROM event));
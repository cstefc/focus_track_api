-- ========================================
-- Harry Potter Themed Project for dev-001
-- ========================================

DO
$$
    DECLARE
        project_id BIGINT;
        log_id     BIGINT;
        goal_id    BIGINT;
    BEGIN
        -- 1. Create a log
        INSERT INTO log (archived)
        VALUES (FALSE)
        RETURNING id INTO log_id;

        -- 2. Create project
        INSERT INTO project (app_user_uuid, log_id, title, description, archived)
        VALUES ('dev-001',
                log_id,
                'Hogwarts Adventure',
                'A magical Harry Potter themed project with goals and steps.',
                FALSE)
        RETURNING id INTO project_id;

        -- =====================
        -- Goal 1: Prepare for Hogwarts
        -- =====================
        INSERT INTO goal (project_id, title, description, priority, estimated)
        VALUES (project_id,
                'Prepare for Hogwarts',
                'Get ready for your first magical year at Hogwarts.',
                1,
                5)
        RETURNING id INTO goal_id;

        INSERT INTO step (goal_id, sequence, objective, description, requirements, status, completed_at)
        VALUES (goal_id, 1, 'Buy wand', 'Visit Ollivanders to select the perfect wand.', 'Money and ID', 0, NULL),
               (goal_id, 2, 'Get school supplies', 'Buy books, robes, and potions ingredients.', 'Shopping list', 0,
                NULL),
               (goal_id, 3, 'Pack trunk', 'Pack all necessary items in trunk.', 'Trunk and supplies', 0, NULL),
               (goal_id, 4, 'Board Hogwarts Express', 'Catch the train from Platform 9 ¾.', 'Ticket', 0, NULL),
               (goal_id, 5, 'Meet new friends', 'Introduce yourself to classmates.', 'Courage', 0, NULL),
               (goal_id, 6, 'Sort into house', 'Attend sorting ceremony.', 'Patience', 0, NULL),
               (goal_id, 7, 'Attend first class', 'Follow class schedule.', 'Class list', 0, NULL),
               (goal_id, 8, 'Learn basic spells', 'Practice wand movements.', 'Wand', 0, NULL),
               (goal_id, 9, 'Explore castle', 'Familiarize yourself with Hogwarts.', 'Map', 0, NULL),
               (goal_id, 10, 'Meet professors', 'Introduce yourself to teachers.', 'Polite manners', 0, NULL);

        -- =====================
        -- Goal 2: Face Challenges
        -- =====================
        INSERT INTO goal (project_id, title, description, priority, estimated)
        VALUES (project_id,
                'Face Challenges',
                'Overcome magical obstacles during the school year.',
                2,
                7)
        RETURNING id INTO goal_id;

        INSERT INTO step (goal_id, sequence, objective, description, requirements, status, completed_at)
        VALUES (goal_id, 1, 'Defeat troll', 'Help friends during the troll incident.', 'Wand and courage', 0, NULL),
               (goal_id, 2, 'Solve enchanted puzzle', 'Find the Philosopher''s Stone.', 'Logic and bravery', 0, NULL),
               (goal_id, 3, 'Win Quidditch tryouts', 'Prove your flying skills.', 'Broomstick', 0, NULL),
               (goal_id, 4, 'Survive potions class', 'Follow Snape''s instructions carefully.', 'Potion ingredients', 0,
                NULL),
               (goal_id, 5, 'Sneak past Filch', 'Avoid being caught while exploring.', 'Invisibility cloak', 0, NULL),
               (goal_id, 6, 'Attend dueling club', 'Practice dueling with peers.', 'Wand and spell book', 0, NULL),
               (goal_id, 7, 'Help house elf', 'Assist Dobby with chores.', 'Kindness', 0, NULL),
               (goal_id, 8, 'Explore forbidden corridor', 'Investigate mysteries safely.', 'Plan and map', 0, NULL),
               (goal_id, 9, 'Find secret passage', 'Locate hidden paths in castle.', 'Hint from map', 0, NULL),
               (goal_id, 10, 'Retrieve magical artifact', 'Recover item for class project.', 'Teamwork', 0, NULL);

        -- =====================
        -- Goal 3: Defeat Dark Forces
        -- =====================
        INSERT INTO goal (project_id, title, description, priority, estimated)
        VALUES (project_id,
                'Defeat Dark Forces',
                'Face Voldemort and other dark forces safely.',
                3,
                10)
        RETURNING id INTO goal_id;

        INSERT INTO step (goal_id, sequence, objective, description, requirements, status, completed_at)
        VALUES (goal_id, 1, 'Learn advanced spells', 'Master defensive spells.', 'Spell book', 0, NULL),
               (goal_id, 2, 'Form Dumbledore''s Army', 'Train with other students.', 'Willing classmates', 0, NULL),
               (goal_id, 3, 'Practice dueling', 'Prepare for real duels.', 'Dueling arena', 0, NULL),
               (goal_id, 4, 'Investigate Horcruxes', 'Search for dark artifacts.', 'Clues and courage', 0, NULL),
               (goal_id, 5, 'Secure prophecy', 'Protect the prophecy in Department of Mysteries.', 'Teamwork', 0, NULL),
               (goal_id, 6, 'Defend Hogwarts', 'Fight off attackers.', 'Strategy and spells', 0, NULL),
               (goal_id, 7, 'Rescue friends', 'Ensure classmates are safe.', 'Quick thinking', 0, NULL),
               (goal_id, 8, 'Face Voldemort', 'Confront the Dark Lord.', 'Wand and bravery', 0, NULL),
               (goal_id, 9, 'Recover Elder Wand', 'Secure the Elder Wand safely.', 'Knowledge of wand lore', 0, NULL),
               (goal_id, 10, 'Celebrate victory', 'Hogwarts victory celebration.', 'House banners', 0, NULL);

    END
$$;
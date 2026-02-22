-- ========================================
-- Lord of the Rings Themed Project for dev-001
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
                'Fellowship Adventure',
                'A Lord of the Rings themed project with quests and steps.',
                FALSE)
        RETURNING id INTO project_id;

        -- =====================
        -- Goal 1: Form the Fellowship
        -- =====================
        INSERT INTO goal (project_id, title, description, priority, estimated)
        VALUES (project_id,
                'Form the Fellowship',
                'Gather the brave companions needed to destroy the One Ring.',
                1,
                5)
        RETURNING id INTO goal_id;

        INSERT INTO step (goal_id, sequence, objective, description, requirements, status, completed_at)
        VALUES (goal_id, 1, 'Recruit Frodo', 'Ask Frodo to take the Ring to Rivendell.', 'Courage and trust', 0, NULL),
               (goal_id, 2, 'Recruit Sam', 'Ensure Frodo has loyal companion.', 'Persuasion', 0, NULL),
               (goal_id, 3, 'Recruit Gandalf', 'Gain wisdom and guidance.', 'Magic knowledge', 0, NULL),
               (goal_id, 4, 'Recruit Aragorn', 'The ranger who will lead the way.', 'Map knowledge', 0, NULL),
               (goal_id, 5, 'Recruit Legolas', 'Elven archer joins the fellowship.', 'Archery skills', 0, NULL),
               (goal_id, 6, 'Recruit Gimli', 'Dwarf warrior for combat support.', 'Strong armor', 0, NULL),
               (goal_id, 7, 'Recruit Boromir', 'Prince of Gondor adds strategy.', 'Diplomacy skills', 0, NULL),
               (goal_id, 8, 'Recruit Merry', 'Hobbit friend for courage.', 'Friendship', 0, NULL),
               (goal_id, 9, 'Recruit Pippin', 'Another brave hobbit companion.', 'Humor and courage', 0, NULL),
               (goal_id, 10, 'Hold council at Rivendell', 'Plan the journey together.', 'Map and wisdom', 0, NULL);

        -- =====================
        -- Goal 2: Journey Through Middle-Earth
        -- =====================
        INSERT INTO goal (project_id, title, description, priority, estimated)
        VALUES (project_id,
                'Journey Through Middle-Earth',
                'Travel across dangerous lands to reach Mordor.',
                2,
                10)
        RETURNING id INTO goal_id;

        INSERT INTO step (goal_id, sequence, objective, description, requirements, status, completed_at)
        VALUES (goal_id, 1, 'Cross the Misty Mountains', 'Avoid the goblins.', 'Climbing gear', 0, NULL),
               (goal_id, 2, 'Navigate the Mines of Moria', 'Find the secret passages.', 'Torch and map', 0, NULL),
               (goal_id, 3, 'Escape Balrog', 'Survive the dark creature.', 'Courage and Gandalf', 0, NULL),
               (goal_id, 4, 'Reach Lothlórien', 'Seek guidance from Galadriel.', 'Respectful attitude', 0, NULL),
               (goal_id, 5, 'Cross the River Anduin', 'Avoid enemy patrols.', 'Boats and teamwork', 0, NULL),
               (goal_id, 6, 'Traverse Emyn Muil', 'Navigate rocky terrain.', 'Map and stamina', 0, NULL),
               (goal_id, 7, 'Avoid Black Riders', 'Keep the Ring safe.', 'Stealth', 0, NULL),
               (goal_id, 8, 'Reach Dead Marshes', 'Survive the eerie terrain.', 'Caution', 0, NULL),
               (goal_id, 9, 'Enter Mordor', 'Prepare for final confrontation.', 'Plan and bravery', 0, NULL),
               (goal_id, 10, 'Hide from Sauron''s spies', 'Stay undetected.', 'Camouflage', 0, NULL);

        -- =====================
        -- Goal 3: Destroy the One Ring
        -- =====================
        INSERT INTO goal (project_id, title, description, priority, estimated)
        VALUES (project_id,
                'Destroy the One Ring',
                'Complete the ultimate quest and save Middle-Earth.',
                3,
                7)
        RETURNING id INTO goal_id;

        INSERT INTO step (goal_id, sequence, objective, description, requirements, status, completed_at)
        VALUES (goal_id, 1, 'Reach Mount Doom', 'Travel safely to the Cracks of Doom.', 'Map and stamina', 0, NULL),
               (goal_id, 2, 'Avoid Gollum''s traps', 'Do not let Gollum steal the Ring.', 'Vigilance', 0, NULL),
               (goal_id, 3, 'Cross the Lava Fields', 'Survive the volcanic terrain.', 'Protective gear', 0, NULL),
               (goal_id, 4, 'Resist temptation', 'Do not succumb to Ring''s power.', 'Strong will', 0, NULL),
               (goal_id, 5, 'Throw the Ring into the fire', 'Destroy the Ring forever.', 'Precision and courage', 0,
                NULL),
               (goal_id, 6, 'Escape Mount Doom', 'Survive after destruction.', 'Stamina', 0, NULL),
               (goal_id, 7, 'Reunite with the Fellowship', 'Celebrate survival with friends.', 'Team spirit', 0, NULL),
               (goal_id, 8, 'Return to Minas Tirith', 'Report the quest completion.', 'Travel knowledge', 0, NULL),
               (goal_id, 9, 'Celebrate victory', 'Enjoy peace in Middle-Earth.', 'Joy and camaraderie', 0, NULL),
               (goal_id, 10, 'Write chronicles', 'Document the journey for history.', 'Quill and parchment', 0, NULL);

    END
$$;
-- ========================================
-- Rick and Morty Themed Project for dev-001
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
                'Rick and Morty Interdimensional Adventures',
                'A project simulating chaotic experiments and travels with Rick and Morty.',
                FALSE)
        RETURNING id INTO project_id;

        -- =====================
        -- Goal 1: Interdimensional Travel
        -- =====================
        INSERT INTO goal (project_id, title, description, priority, estimated)
        VALUES (project_id,
                'Explore the Multiverse',
                'Travel to different dimensions and cause chaos.',
                1,
                5)
        RETURNING id INTO goal_id;

        INSERT INTO step (goal_id, sequence, objective, description, requirements, status, completed_at)
        VALUES (goal_id, 1, 'Activate portal gun', 'Travel to a random dimension.', 'Portal gun', 0, NULL),
               (goal_id, 2, 'Meet alternate selves', 'Interact with alternate versions of ourselves.', 'Curiosity', 0,
                NULL),
               (goal_id, 3, 'Escape Galactic Federation', 'Evade capture by intergalactic authorities.',
                'Quick thinking', 0, NULL),
               (goal_id, 4, 'Collect alien artifacts', 'Gather weird items across dimensions.', 'Backpack', 0, NULL),
               (goal_id, 5, 'Avoid Cronenberg world', 'Stay alive in a grotesque reality.', 'Luck', 0, NULL),
               (goal_id, 6, 'Attend Blips and Chitz', 'Play bizarre arcade games.', 'Credits and imagination', 0, NULL),
               (goal_id, 7, 'Steal Mega Seeds', 'Follow Rick''s risky heist.', 'Stealth', 0, NULL),
               (goal_id, 8, 'Experiment on Morty', 'Test questionable scientific theories.', 'Consent… maybe', 0, NULL),
               (goal_id, 9, 'Survive Szechuan sauce obsession', 'Navigate obsession-driven chaos.', 'Patience', 0,
                NULL),
               (goal_id, 10, 'Return home safely', 'Close portal and avoid paradoxes.', 'Portal gun', 0, NULL);

        -- =====================
        -- Goal 2: Science Experiments
        -- =====================
        INSERT INTO goal (project_id, title, description, priority, estimated)
        VALUES (project_id,
                'Mad Science Experiments',
                'Conduct dangerous and hilarious experiments in the garage.',
                2,
                7)
        RETURNING id INTO goal_id;

        INSERT INTO step (goal_id, sequence, objective, description, requirements, status, completed_at)
        VALUES (goal_id, 1, 'Clone Rick', 'Attempt to create a backup Rick.', 'Science equipment', 0, NULL),
               (goal_id, 2, 'Miniature universe', 'Build a microcosm and live in it.', 'Creativity and patience', 0,
                NULL),
               (goal_id, 3, 'Meeseeks summoning', 'Create Mr. Meeseeks for small tasks.', 'Meeseeks box', 0, NULL),
               (goal_id, 4, 'Time travel', 'Experiment with temporal mechanics.', 'Watch and calculator', 0, NULL),
               (goal_id, 5, 'Mind swap', 'Switch minds with Morty or others.', 'Mind device', 0, NULL),
               (goal_id, 6, 'Gromflomite detection', 'Identify alien spies on Earth.', 'Scanner', 0, NULL),
               (goal_id, 7, 'Shrink Morty', 'Miniaturize for stealth missions.', 'Shrink ray', 0, NULL),
               (goal_id, 8, 'Clone Jerry', 'Test cloning on less intelligent targets.', 'Cloning machine', 0, NULL),
               (goal_id, 9, 'Test interdimensional cable', 'Watch weird TV shows from other realities.', 'Cable box', 0,
                NULL),
               (goal_id, 10, 'Invent snack foods', 'Create bizarre snacks for science fuel.', 'Ingredients', 0, NULL);

        -- =====================
        -- Goal 3: Social Chaos
        -- =====================
        INSERT INTO goal (project_id, title, description, priority, estimated)
        VALUES (project_id,
                'Chaos & Adventures with Friends',
                'Cause mischief and survive social situations across universes.',
                3,
                10)
        RETURNING id INTO goal_id;

        INSERT INTO step (goal_id, sequence, objective, description, requirements, status, completed_at)
        VALUES (goal_id, 1, 'Argue with Beth', 'Debate parenting and life choices.', 'Courage', 0, NULL),
               (goal_id, 2, 'Protect Summer', 'Keep her safe during adventures.', 'Quick reflexes', 0, NULL),
               (goal_id, 3, 'Avoid Jerry''s blunders', 'Minimize damage caused by Jerry.', 'Patience', 0, NULL),
               (goal_id, 4, 'Escape evil Morty', 'Avoid interdimensional villain.', 'Stealth and cunning', 0, NULL),
               (goal_id, 5, 'Participate in intergalactic games', 'Compete for fun or survival.', 'Skill', 0, NULL),
               (goal_id, 6, 'Negotiate with aliens', 'Avoid galactic conflict.', 'Charm', 0, NULL),
               (goal_id, 7, 'Survive Citadel politics', 'Handle complex interdimensional bureaucracy.', 'Brains', 0,
                NULL),
               (goal_id, 8, 'Deal with Pickle Rick crisis', 'Escape traps and sewers.', 'Ingenuity', 0, NULL),
               (goal_id, 9, 'Attend Plumbus convention', 'Learn about strange devices.', 'Curiosity', 0, NULL),
               (goal_id, 10, 'Celebrate adventures', 'Toast success with interdimensional drinks.', 'Portal gun', 0,
                NULL);

    END
$$;
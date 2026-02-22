-- ========================================
-- Big Bang Theory Themed Project for dev-001
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
                'Big Bang Theory Social Experiments',
                'A project to simulate experiments and misadventures in the style of The Big Bang Theory.',
                FALSE)
        RETURNING id INTO project_id;

        -- =====================
        -- Goal 1: Science Experiments
        -- =====================
        INSERT INTO goal (project_id, title, description, priority, estimated)
        VALUES (project_id,
                'Conduct Science Experiments',
                'Perform hilarious and nerdy experiments like the guys from the show.',
                1,
                5)
        RETURNING id INTO goal_id;

        INSERT INTO step (goal_id, sequence, objective, description, requirements, status, completed_at)
        VALUES (goal_id, 1, 'Build a robot', 'Create a functioning robot at home.', 'Parts and soldering skills', 0,
                NULL),
               (goal_id, 2, 'Test string theory', 'Simulate a mini particle collider experiment.',
                'Whiteboard and chalk', 0, NULL),
               (goal_id, 3, 'Measure gravitational waves', 'Attempt to detect tiny ripples.', 'Precision sensors', 0,
                NULL),
               (goal_id, 4, 'Build comic collection', 'Organize and catalog comic books.', 'Comics and labels', 0,
                NULL),
               (goal_id, 5, 'Run physics simulation', 'Simulate black hole dynamics.', 'Laptop and software', 0, NULL),
               (goal_id, 6, 'Experiment with magnets', 'Observe magnetic interactions.', 'Magnets and iron filings', 0,
                NULL),
               (goal_id, 7, 'Create homemade lightsaber', 'Recreate Star Wars tech.', 'LEDs and wires', 0, NULL),
               (goal_id, 8, 'Test antigravity', 'Conduct zero-G simulations.', 'Objects and imagination', 0, NULL),
               (goal_id, 9, 'Organize lab notebooks', 'Label and archive previous experiments.', 'Notebooks and pens',
                0, NULL),
               (goal_id, 10, 'Predict quantum outcomes', 'Use probability to guess particle positions.',
                'Math formulas', 0, NULL);

        -- =====================
        -- Goal 2: Social Adventures
        -- =====================
        INSERT INTO goal (project_id, title, description, priority, estimated)
        VALUES (project_id,
                'Social Adventures',
                'Navigate friendship, romance, and awkwardness like the characters.',
                2,
                7)
        RETURNING id INTO goal_id;

        INSERT INTO step (goal_id, sequence, objective, description, requirements, status, completed_at)
        VALUES (goal_id, 1, 'Play Dungeons & Dragons', 'Organize a session with friends.', 'Dice and imagination', 0,
                NULL),
               (goal_id, 2, 'Attend Comic-Con', 'Show off cosplay and fandom pride.', 'Tickets and costume', 0, NULL),
               (goal_id, 3, 'Plan Penny date', 'Help Leonard ask Penny out.', 'Confidence and charm', 0, NULL),
               (goal_id, 4, 'Organize roommate event', 'Coordinate apartment party.', 'Food and drinks', 0, NULL),
               (goal_id, 5, 'Host trivia night', 'Test friends on geek knowledge.', 'Questions and buzzers', 0, NULL),
               (goal_id, 6, 'Avoid social awkwardness', 'Survive elevator small talk.', 'Politeness', 0, NULL),
               (goal_id, 7, 'Participate in laser tag', 'Challenge friends in game.', 'Team coordination', 0, NULL),
               (goal_id, 8, 'Help Sheldon with routine', 'Support odd daily rituals.', 'Patience', 0, NULL),
               (goal_id, 9, 'Decorate apartment', 'Prepare themed decorations.', 'Creativity', 0, NULL),
               (goal_id, 10, 'Attend scientific lecture', 'Learn from a visiting physicist.', 'Notebook and curiosity',
                0, NULL);

        -- =====================
        -- Goal 3: Career and Fame
        -- =====================
        INSERT INTO goal (project_id, title, description, priority, estimated)
        VALUES (project_id,
                'Advance Careers & Achieve Fame',
                'Pursue professional goals while navigating nerdy fame.',
                3,
                10)
        RETURNING id INTO goal_id;

        INSERT INTO step (goal_id, sequence, objective, description, requirements, status, completed_at)
        VALUES (goal_id, 1, 'Publish paper', 'Submit research to a physics journal.', 'Writing skills', 0, NULL),
               (goal_id, 2, 'Give lecture', 'Present findings at university.', 'Slides and speech', 0, NULL),
               (goal_id, 3, 'Win award', 'Earn recognition for experiments.', 'Innovative ideas', 0, NULL),
               (goal_id, 4, 'Collaborate with colleagues', 'Work on a joint project.', 'Teamwork', 0, NULL),
               (goal_id, 5, 'Improve lab', 'Upgrade lab with new equipment.', 'Budget and planning', 0, NULL),
               (goal_id, 6, 'Host science fair', 'Show experiments to public.', 'Venue and volunteers', 0, NULL),
               (goal_id, 7, 'Patent invention', 'Protect unique creation legally.', 'Patent application', 0, NULL),
               (goal_id, 8, 'Give TED Talk', 'Share knowledge with the world.', 'Presentation skills', 0, NULL),
               (goal_id, 9, 'Teach students', 'Mentor junior scientists.', 'Patience and guidance', 0, NULL),
               (goal_id, 10, 'Celebrate success', 'Throw a big nerd party with friends.', 'Fun and cake', 0, NULL);

    END
$$;
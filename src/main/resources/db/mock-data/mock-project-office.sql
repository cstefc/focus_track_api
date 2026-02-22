-- ========================================
-- The Office Themed Project for dev-001
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
                'Dunder Mifflin Daily Operations',
                'A project simulating the day-to-day hilarity and chaos at Dunder Mifflin.',
                FALSE)
        RETURNING id INTO project_id;

        -- =====================
        -- Goal 1: Office Productivity
        -- =====================
        INSERT INTO goal (project_id, title, description, priority, estimated)
        VALUES (project_id,
                'Boost Office Productivity',
                'Complete tasks while navigating office quirks.',
                1,
                5)
        RETURNING id INTO goal_id;

        INSERT INTO step (goal_id, sequence, objective, description, requirements, status, completed_at)
        VALUES (goal_id, 1, 'File paper correctly', 'Organize client files.', 'Folders and focus', 0, NULL),
               (goal_id, 2, 'Answer phones', 'Handle calls with professionalism.', 'Patience', 0, NULL),
               (goal_id, 3, 'Schedule meetings', 'Coordinate meetings without chaos.', 'Planner', 0, NULL),
               (goal_id, 4, 'Prepare sales reports', 'Summarize weekly sales.', 'Spreadsheet skills', 0, NULL),
               (goal_id, 5, 'Stock office supplies', 'Ensure pens and paper are available.', 'Inventory check', 0,
                NULL),
               (goal_id, 6, 'Photocopy documents', 'Avoid jamming the copier.', 'Attention to detail', 0, NULL),
               (goal_id, 7, 'Manage emails', 'Reply to client inquiries promptly.', 'Email etiquette', 0, NULL),
               (goal_id, 8, 'Update client records', 'Maintain accurate information.', 'Accuracy', 0, NULL),
               (goal_id, 9, 'Report to Michael', 'Give updates without irritating him.', 'Diplomacy', 0, NULL),
               (goal_id, 10, 'Avoid office drama', 'Survive pranks and gossip.', 'Stealth and patience', 0, NULL);

        -- =====================
        -- Goal 2: Pranks & Fun
        -- =====================
        INSERT INTO goal (project_id, title, description, priority, estimated)
        VALUES (project_id,
                'Office Pranks & Fun',
                'Engage in office hijinks and morale boosters.',
                2,
                6)
        RETURNING id INTO goal_id;

        INSERT INTO step (goal_id, sequence, objective, description, requirements, status, completed_at)
        VALUES (goal_id, 1, 'Prank Dwight', 'Switch his stapler with Jell-O.', 'Stapler and Jell-O', 0, NULL),
               (goal_id, 2, 'Host a Dundie Awards', 'Celebrate employees hilariously.', 'Creativity', 0, NULL),
               (goal_id, 3, 'Dress up for theme day', 'Participate in costume contests.', 'Imagination', 0, NULL),
               (goal_id, 4, 'Set up secret Santa', 'Organize gift exchange.', 'Planning', 0, NULL),
               (goal_id, 5, 'Organize office Olympics', 'Fun games to boost morale.', 'Coordination', 0, NULL),
               (goal_id, 6, 'Bake cookies', 'Make treats for coworkers.', 'Oven and ingredients', 0, NULL),
               (goal_id, 7, 'Send funny emails', 'Lighten up inboxes.', 'Wit and timing', 0, NULL),
               (goal_id, 8, 'Photobomb meetings', 'Add humor subtly during Zoom.', 'Timing', 0, NULL),
               (goal_id, 9, 'Decorate workspace', 'Add flair to your desk.', 'Supplies', 0, NULL),
               (goal_id, 10, 'Avoid HR attention', 'Don’t get caught by Toby.', 'Caution', 0, NULL);

        -- =====================
        -- Goal 3: Personal Achievements
        -- =====================
        INSERT INTO goal (project_id, title, description, priority, estimated)
        VALUES (project_id,
                'Personal Office Goals',
                'Accomplish individual success while surviving the office.',
                3,
                7)
        RETURNING id INTO goal_id;

        INSERT INTO step (goal_id, sequence, objective, description, requirements, status, completed_at)
        VALUES (goal_id, 1, 'Sell the most paper', 'Achieve top sales.', 'Sales skills', 0, NULL),
               (goal_id, 2, 'Win employee of the month', 'Get recognized by Michael.', 'Charm', 0, NULL),
               (goal_id, 3, 'Avoid unnecessary meetings', 'Save time for actual work.', 'Strategy', 0, NULL),
               (goal_id, 4, 'Impress Jan', 'Navigate complicated corporate dynamics.', 'Diplomacy', 0, NULL),
               (goal_id, 5, 'Learn to cook pretzels', 'Snack responsibly.', 'Kitchen skills', 0, NULL),
               (goal_id, 6, 'Survive office parties', 'Handle awkward events gracefully.', 'Patience', 0, NULL),
               (goal_id, 7, 'Keep up pranks', 'Stay ahead in prank wars.', 'Creativity', 0, NULL),
               (goal_id, 8, 'Assist new employees', 'Train interns like Pam.', 'Mentoring', 0, NULL),
               (goal_id, 9, 'Avoid Michael''s meltdowns', 'Stay calm during chaos.', 'Emotional control', 0, NULL),
               (goal_id, 10, 'Have fun', 'Enjoy the absurdity of Scranton.', 'Humor', 0, NULL);

    END
$$;
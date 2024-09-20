-- Insert initial data into the User table
INSERT INTO app_user (username, email, password,role) VALUES
                                                     ('maryem', 'jm_baziz@esi.dz', 'password','ADMIN'),
                                                     ('user2', 'user2@example.com', 'password2','USER');
-- Insert initial data into the Content table
INSERT INTO content (id, user_id, title, description, status, content_type, date_created, date_updated, url) VALUES
                                                                                                                 (1, 1, 'My First Recipe', 'This is the 1st recipe description', 'PUBLISHED', 'ARTICLE', '2024-08-30T11:24:19.469842', NULL, ''),
                                                                                                                 (2, 2, 'My Second Recipe', 'This is the 2nd recipe description', 'IDEA', 'ARTICLE', '2024-08-30T11:24:19.469842', NULL, '');
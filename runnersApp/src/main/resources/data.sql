-- Insert initial data into the User table
INSERT INTO app_user (email, role, password, reset_password_token, is_email_verified, verification_token) VALUES
                                                                                                              ('jm_baziz@esi.dz', 'ADMIN', 'password', 'resetPasswordToken', true, 'verificationToken'),
                                                                                                              ('user2@example.com', 'USER', 'password2', 'resetPasswordToken2', true, 'verificationToken2');

-- Insert initial data into the Content table
INSERT INTO content (user_id, title, description, status, content_type, date_created, date_updated, url) VALUES
                                                                                                             (1, 'My First Recipe', 'This is the 1st recipe description', 'PUBLISHED', 'ARTICLE', '2024-08-30T11:24:19.469842', NULL, ''),
                                                                                                             (2, 'My Second Recipe', 'This is the 2nd recipe description', 'IDEA', 'ARTICLE', '2024-08-30T11:24:19.469842', NULL, '');
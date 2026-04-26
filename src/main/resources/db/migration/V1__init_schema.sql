-- USERS
CREATE TABLE vedlms_users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,

    email VARCHAR(255) NOT NULL UNIQUE,
    name VARCHAR(255),

    provider VARCHAR(50) DEFAULT 'GOOGLE',
    provider_id VARCHAR(255),

    status_id INT NOT NULL,

    is_blocked BOOLEAN DEFAULT FALSE,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- ROLES
CREATE TABLE vedlms_roles (
    id INT PRIMARY KEY AUTO_INCREMENT,
    code VARCHAR(50) UNIQUE,
    name VARCHAR(100),
    description VARCHAR(255)
);

-- USER ROLES
CREATE TABLE vedlms_user_roles (
    user_id BIGINT,
    role_id INT,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES vedlms_users(id),
    FOREIGN KEY (role_id) REFERENCES vedlms_roles(id)
);

-- STATUS
CREATE TABLE vedlms_user_status (
    id INT PRIMARY KEY AUTO_INCREMENT,
    code VARCHAR(50) UNIQUE,
    name VARCHAR(100),
    description VARCHAR(255)
);


-- ROLES
INSERT INTO vedlms_roles (code, name, description) VALUES
('KULGURU', 'Kulguru', 'Full access'),
('ADMIN', 'Administrator', 'Content manager'),
('ACHARYA', 'Acharya', 'Teacher'),
('SADHAKA', 'Sadhaka', 'Student');

-- STATUS
INSERT INTO vedlms_user_status (code, name, description) VALUES
('ANVESHAKA', 'Explorer', 'Browsing user'),
('ICHCHUKA', 'Interested', 'Attempted purchase'),
('SADHAKA', 'Learner', 'Purchased user'),
('NIRODHITA', 'Blocked', 'Restricted user'),
('ACTIVE', 'Active User', 'Fully active user in the system');
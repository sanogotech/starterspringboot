-- Création de la table pour les utilisateurs
CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(255) NOT NULL,
    active BOOLEAN NOT NULL
);

-- Création de la table pour les rôles
CREATE TABLE IF NOT EXISTS roles (
    id INT AUTO_INCREMENT PRIMARY KEY,
    role_name VARCHAR(50) NOT NULL
);

-- Création de la table pour l'association entre utilisateurs et rôles
CREATE TABLE IF NOT EXISTS user_roles (
    user_id INT,
    role_id INT,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (role_id) REFERENCES roles(id)
);

-- Insertion du rôle 'ADMIN' dans la table des rôles
INSERT INTO roles (role_name) VALUES ('ADMIN');

-- Insertion de l'utilisateur admin avec le rôle 'ADMIN'
INSERT INTO users (username, password, active) VALUES ('admin', '$2a$10$1MqSEElctUymoUjFnl/O7u0rToJpP64krZImGde2xmZI52.4EH/Z6', true);

-- Insertion de l'association entre l'utilisateur et le rôle 'ADMIN'
INSERT INTO user_roles (user_id, role_id) VALUES (1, 1);

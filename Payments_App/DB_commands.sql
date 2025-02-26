-- User Details Table
CREATE TABLE user_details (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    phone_number VARCHAR(15),
    email VARCHAR(100),
    address VARCHAR(255),
    password VARCHAR(255)
);

INSERT INTO user_details (first_name, last_name, phone_number, email, address, password)
VALUES 
('rajesh', 'mankala', '7896541230', 'rajesh.@email.com', '789 new Street', 'pass1234'),
('kumar', 'masa', '4567891230', 'masa@email.com', '951 Cedar Avenue', 'masa456');

-- User Account Table 
CREATE TABLE user_account (
    account_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    account_open_date DATE,
    wallet_pin VARCHAR(6),
    current_wallet_balance DECIMAL(10,2),
    linked_bank_accounts_count INT,
    FOREIGN KEY (user_id) REFERENCES user_details(user_id)
);

INSERT INTO user_account (user_id, account_open_date, wallet_pin, current_wallet_balance, linked_bank_accounts_count)
VALUES 
(1, '2023-03-12', '2345', 750.00, 3),
(2, '2023-04-18', '6789', 950.75, 2);

-- Bank Accounts Table 
CREATE TABLE bank_accounts (
    bank_account_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    account_number VARCHAR(20),
    bank_name VARCHAR(100),
    branch_location VARCHAR(100),
    ifsc_code VARCHAR(11),
    is_active VARCHAR(5),
    FOREIGN KEY (user_id) REFERENCES user_details(user_id)
);

INSERT INTO bank_accounts (user_id, account_number, bank_name, branch_location, ifsc_code, is_active)
VALUES 
(1, '999911112222', 'Citibank', 'Chicago', 'CITI0001111', 'YES'),
(1, '888822223333', 'HSBC', 'Houston', 'HSBC0002222', 'YES'),
(2, '777733334444', 'Goldman Sachs', 'Boston', 'GS0003333', 'NO');

-- Source Types Table
CREATE TABLE source_types (
    source_type_id INT PRIMARY KEY AUTO_INCREMENT,
    source_type_code VARCHAR(10),
    source_type_desc VARCHAR(50)
);

INSERT INTO source_types (source_type_code, source_type_desc)
VALUES 
('BA', 'Bank Account'),
('WA', 'Wallet Account'),
('TP', 'Third-Party');

-- Transactions Table 
CREATE TABLE transactions (
    transaction_id INT PRIMARY KEY AUTO_INCREMENT,
    transaction_date_time DATETIME,
    source_id INT,
    target_id INT,
    source_type_id INT,
    destination_type_id INT,
    amount DECIMAL(10,2),
    FOREIGN KEY (source_type_id) REFERENCES source_types(source_type_id),
    FOREIGN KEY (destination_type_id) REFERENCES source_types(source_type_id)
);

INSERT INTO transactions (transaction_date_time, source_id, target_id, source_type_id, destination_type_id, amount)
VALUES 
('2024-03-01 12:30:00', 1, 2, 1, 2, 350.00),
('2024-03-02 16:20:00', 2, 1, 2, 1, 600.00),
('2024-03-03 08:55:00', 1, 3, 1, 3, 400.00);

-- SQL Queries

-- Fetch All Users
SELECT * FROM user_details;

-- Find a User by Email
SELECT * FROM user_details WHERE email = 'rajesh.@email.com';

-- Show Wallet Balance of All Users
SELECT u.first_name, u.last_name, ua.current_wallet_balance 
FROM user_details u
JOIN user_account ua ON u.user_id = ua.user_id;

-- List Active Bank Accounts
SELECT u.first_name, u.last_name, ba.bank_name, ba.bank_account_id
FROM user_details u
JOIN bank_accounts ba ON u.user_id = ba.user_id
WHERE ba.is_active = 'YES';

-- Count Total Linked Bank Accounts per User
SELECT u.first_name, u.last_name, COUNT(b.bank_account_id) AS total_bank_accounts
FROM user_details u
JOIN bank_accounts b ON u.user_id = b.user_id
GROUP BY u.user_id;

-- Get All Users with Wallet Balance < ₹500
SELECT u.first_name, u.last_name, ua.current_wallet_balance
FROM user_details u
JOIN user_account ua ON u.user_id = ua.user_id
WHERE ua.current_wallet_balance < 500;

-- Find users who don’t have any bank accounts linked.
SELECT u.first_name, u.last_name
FROM user_details u
LEFT JOIN bank_accounts ba ON u.user_id = ba.user_id
WHERE ba.bank_account_id IS NULL;


INSERT INTO CUSTOMERS (name, surname, age, phone_number)
VALUES
('Alexey', 'Ivanov', 30, 1234567890),
('Anna', 'Petrova', 25, 9876543210),
('Oleg', 'Sidorov', 40, 5678901234),
('Maria', 'Smirnova', 35, 1230987654),
('Dmitry', 'Kuznetsov', 28, 4321098765);

INSERT INTO ORDERS (customer_id, date, product_name, amount)
VALUES

(1, '2024-11-24', 'Laptop', 1),
(1, '2024-11-24', 'Mouse', 2),
(2, '2024-11-23', 'Keyboard', 1),
(3, '2024-11-22', 'Monitor', 1),
(3, '2024-11-22', 'Desk', 1),
(4, '2024-12-14', 'Notebook', 2),
(5, '2024-10-27', 'Trackball', 1);
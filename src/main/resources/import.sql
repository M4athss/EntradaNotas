INSERT INTO TBITEMS (name, amount) VALUES ('Lápis Preto', 200);
INSERT INTO TBITEMS (name, amount) VALUES ('Caneta Azul', 150);
INSERT INTO TBITEMS (name, amount) VALUES ('Caderno Universitário', 75);
INSERT INTO TBITEMS (name, amount) VALUES ('Borracha Branca', 180);
INSERT INTO TBITEMS (name, amount) VALUES ('Apontador Metálico', 95);


INSERT INTO TBSUPPLIERS (cnpj, name, common_name, cep, country, state) VALUES ('12345678000195', 'Alpha Indústrias Ltda.', 'Alpha', '01001000', 'Brasil', 'SP');
INSERT INTO TBSUPPLIERS (cnpj, name, common_name, cep, country, state) VALUES ('98765432000188', 'Beta Fornecimentos S.A.', 'Beta', '20040020', 'Brasil', 'RJ');
INSERT INTO TBSUPPLIERS (cnpj, name, common_name, cep, country, state) VALUES ('11223344000166', 'Gamma Soluções Industriais', 'Gamma', '30130010', 'Brasil', 'MG');
INSERT INTO TBSUPPLIERS (cnpj, name, common_name, cep, country, state) VALUES ('99887766000177', 'Delta Comércio e Serviços', 'Delta', '80010000', 'Brasil', 'PR');
INSERT INTO TBSUPPLIERS (cnpj, name, common_name, cep, country, state) VALUES ('55443322000122', 'Epsilon Tecnologia Ltda.', 'Epsilon', '90619900', 'Brasil', 'RS');


INSERT INTO TBLOCATIONS (code, name, active) VALUES ('CDC', 'Centro de Distribuição Central', 'T');
INSERT INTO TBLOCATIONS (code, name, active) VALUES ('SP1', 'Setor de Preparação - Zona Sul SP', 'T');
INSERT INTO TBLOCATIONS (code, name, active) VALUES ('RJ1', 'Setor de Expedição - RJ Norte', 'T');
INSERT INTO TBLOCATIONS (code, name, active) VALUES ('EST', 'Estoque Geral - Matriz', 'T');
INSERT INTO TBLOCATIONS (code, name, active) VALUES ('REC', 'Recebimento de Mercadorias - Filial BH', 'T');


INSERT INTO TBINVOICES (note_number, emission_date, id_suppliers, total) VALUES (1001, '2025-05-01', 1, 12500.00);
INSERT INTO TBINVOICES (note_number, emission_date, id_suppliers, total) VALUES (1002, '2025-05-02', 2, 18000.00);
INSERT INTO TBINVOICES (note_number, emission_date, id_suppliers, total) VALUES (1003, '2025-05-03', 3, 18000.00);
INSERT INTO TBINVOICES (note_number, emission_date, id_suppliers, total) VALUES (1004, '2025-05-03', 1, 9800.00);
INSERT INTO TBINVOICES (note_number, emission_date, id_suppliers, total) VALUES (1005, '2025-05-04', 2, 12800.00);


-- Nota 1 (Total: 12500)
INSERT INTO TBENTRYS (id_invoice, id_item, date_entry, quantity, value_item) VALUES (1, 1, '2025-05-01', 10, 250.00);
INSERT INTO TBENTRYS (id_invoice, id_item, date_entry, quantity, value_item) VALUES (1, 2, '2025-05-01', 20, 125.00);
INSERT INTO TBENTRYS (id_invoice, id_item, date_entry, quantity, value_item) VALUES (1, 3, '2025-05-01', 25, 100.00);
INSERT INTO TBENTRYS (id_invoice, id_item, date_entry, quantity, value_item) VALUES (1, 4, '2025-05-01', 5, 500.00);
INSERT INTO TBENTRYS (id_invoice, id_item, date_entry, quantity, value_item) VALUES (1, 5, '2025-05-01', 50, 50.00);

-- Nota 2 (Total: 18000)
INSERT INTO TBENTRYS (id_invoice, id_item, date_entry, quantity, value_item) VALUES (2, 1, '2025-05-02', 20, 180.00);
INSERT INTO TBENTRYS (id_invoice, id_item, date_entry, quantity, value_item) VALUES (2, 2, '2025-05-02', 30, 120.00);
INSERT INTO TBENTRYS (id_invoice, id_item, date_entry, quantity, value_item) VALUES (2, 3, '2025-05-02', 40, 90.00);
INSERT INTO TBENTRYS (id_invoice, id_item, date_entry, quantity, value_item) VALUES (2, 4, '2025-05-02', 50, 72.00);
INSERT INTO TBENTRYS (id_invoice, id_item, date_entry, quantity, value_item) VALUES (2, 5, '2025-05-02', 60, 60.00);

-- Nota 3 (Total: 18000)
INSERT INTO TBENTRYS (id_invoice, id_item, date_entry, quantity, value_item) VALUES (3, 1, '2025-05-03', 36, 100.00);
INSERT INTO TBENTRYS (id_invoice, id_item, date_entry, quantity, value_item) VALUES (3, 2, '2025-05-03', 45, 80.00);
INSERT INTO TBENTRYS (id_invoice, id_item, date_entry, quantity, value_item) VALUES (3, 3, '2025-05-03', 60, 60.00);
INSERT INTO TBENTRYS (id_invoice, id_item, date_entry, quantity, value_item) VALUES (3, 4, '2025-05-03', 90, 40.00);
INSERT INTO TBENTRYS (id_invoice, id_item, date_entry, quantity, value_item) VALUES (3, 5, '2025-05-03', 120, 30.00);

-- Nota 4 (Total: 9800)
INSERT INTO TBENTRYS (id_invoice, id_item, date_entry, quantity, value_item) VALUES (4, 1, '2025-05-03', 10, 200.00);
INSERT INTO TBENTRYS (id_invoice, id_item, date_entry, quantity, value_item) VALUES (4, 2, '2025-05-03', 10, 200.00);
INSERT INTO TBENTRYS (id_invoice, id_item, date_entry, quantity, value_item) VALUES (4, 3, '2025-05-03', 10, 200.00);
INSERT INTO TBENTRYS (id_invoice, id_item, date_entry, quantity, value_item) VALUES (4, 4, '2025-05-03', 10, 190.00);
INSERT INTO TBENTRYS (id_invoice, id_item, date_entry, quantity, value_item) VALUES (4, 5, '2025-05-03', 9, 211.11);

-- Nota 5 (Total: 12800)
INSERT INTO TBENTRYS (id_invoice, id_item, date_entry, quantity, value_item) VALUES (5, 1, '2025-05-04', 16, 200.00);
INSERT INTO TBENTRYS (id_invoice, id_item, date_entry, quantity, value_item) VALUES (5, 2, '2025-05-04', 32, 100.00);
INSERT INTO TBENTRYS (id_invoice, id_item, date_entry, quantity, value_item) VALUES (5, 3, '2025-05-04', 64, 50.00);
INSERT INTO TBENTRYS (id_invoice, id_item, date_entry, quantity, value_item) VALUES (5, 4, '2025-05-04', 80, 40.00);
INSERT INTO TBENTRYS (id_invoice, id_item, date_entry, quantity, value_item) VALUES (5, 5, '2025-05-04', 32, 50.00);



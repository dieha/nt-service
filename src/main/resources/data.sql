INSERT INTO bank_code(code,bank_name) VALUES ('001','中央信託');
INSERT INTO bank_code(code,bank_name) VALUES ('003','交通銀行');
INSERT INTO bank_code(code,bank_name) VALUES ('004','台灣銀行');
INSERT INTO bank_code(code,bank_name) VALUES ('005','土地銀行');
INSERT INTO bank_code(code,bank_name) VALUES ('006','合庫商銀');
INSERT INTO bank_code(code,bank_name) VALUES ('007','第一銀行');
INSERT INTO bank_code(code,bank_name) VALUES ('008','華南銀行');
INSERT INTO bank_code(code,bank_name) VALUES ('009','彰化銀行');
INSERT INTO bank_code(code,bank_name) VALUES ('010','華僑銀行');
INSERT INTO bank_code(code,bank_name) VALUES ('011','上海銀行');
INSERT INTO bank_code(code,bank_name) VALUES ('012','台北富邦');
INSERT INTO bank_code(code,bank_name) VALUES ('013','國泰世華');
INSERT INTO bank_code(code,bank_name) VALUES ('016','高雄銀行');
INSERT INTO bank_code(code,bank_name) VALUES ('017','兆豐商銀');
INSERT INTO bank_code(code,bank_name) VALUES ('018','農業金庫');
INSERT INTO bank_code(code,bank_name) VALUES ('021','花旗銀行');
INSERT INTO bank_code(code,bank_name) VALUES ('024','運通銀行');
INSERT INTO bank_code(code,bank_name) VALUES ('025','首都銀行');
INSERT INTO bank_code(code,bank_name) VALUES ('039','荷蘭銀行');
INSERT INTO bank_code(code,bank_name) VALUES ('040','中華開發');
INSERT INTO bank_code(code,bank_name) VALUES ('050','臺灣企銀');


INSERT INTO deposit(account_no,account_id,currency,amount) VALUES ('000000000000',1,'NT',5000000.00);
INSERT INTO deposit(account_no,account_id,currency,amount) VALUES ('111111111111',2,'NT',1000000.00);

INSERT INTO transfer(form_account_no,to_bank_code,to_account_no,currency,amount,status,transfer_date,create_date ) VALUES ('111111111111','050','000000000000','NT',1000.00,'ok','2022-05-04 12:00:00','2022-05-04 12:00:00');
INSERT INTO transfer(form_account_no,to_bank_code,to_account_no,currency,amount,status,transfer_date,create_date ) VALUES ('000000000000','050','111111111111','NT',2000.00,'ok','2022-05-05 12:00:00','2022-05-05 12:00:00');



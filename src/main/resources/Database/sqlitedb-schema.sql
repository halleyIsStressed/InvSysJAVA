DROP TABLE IF EXISTS InventoryManager;
DROP TABLE IF EXISTS PRODUCT;
DROP TABLE IF EXISTS SUPPLIER;
DROP TABLE IF EXISTS PURCHASE_ORDER;
DROP TABLE IF EXISTS BRANCH;
DROP TABLE IF EXISTS RETURN_ORDER;
DROP TABLE IF EXISTS STOCK_RETURN;
DROP TABLE IF EXISTS STOCK_TRANSFER;
DROP TABLE IF EXISTS STAFF;

CREATE TABLE IF NOT EXISTS InventoryManager (
    ID       TEXT PRIMARY KEY,
    PASSWORD VARCHAR(20) NOT NULL,
    NAME     VARCHAR(30) NOT NULL,
    AGE      INT,
    GENDER   TEXT,
    PHONE    TEXT,
    EMAIL    TEXT
);

CREATE TRIGGER IF NOT EXISTS createInventoryManager
    AFTER INSERT
    ON InventoryManager
BEGIN
    UPDATE InventoryManager
    SET ID = PRINTF('IM%05d', new.ROWID),
    EMAIL = PRINTF('IM%05d@gmail.com', new.ROWID)
    WHERE ROWID = new.ROWID;
END;


CREATE TABLE IF NOT EXISTS STAFF (
    ID       TEXT PRIMARY KEY,
    PASSWORD VARCHAR(20) NOT NULL,
    NAME     VARCHAR(30) NOT NULL,
    AGE      INT,
    GENDER   TEXT,
    PHONE    TEXT,
    EMAIL    TEXT,
    POSITION TEXT
);

CREATE TRIGGER IF NOT EXISTS createSTAFF
    AFTER INSERT
    ON STAFF
BEGIN
    UPDATE STAFF
    SET ID = PRINTF('S%05d', new.oid) ,
    EMAIL = PRINTF('S%05d@gmail.com', new.oid)
    WHERE oid = new.ROWID;
END;


CREATE TABLE IF NOT EXISTS PRODUCT (
    PRODUCT_ID       TEXT PRIMARY KEY,
    PRODUCT_TYPE     VARCHAR(20) NOT NULL,
    PRODUCT_NAME     VARCHAR(20) NOT NULL,
    PRODUCT_PRICE    DOUBLE      NOT NULL,
    PRODUCT_QUANTITY INT         NOT NULL
);

CREATE TRIGGER IF NOT EXISTS createProductId
    AFTER INSERT
    ON PRODUCT
BEGIN
    UPDATE PRODUCT
    SET PRODUCT_ID = PRINTF('P%05d', new.oid)
    WHERE oid = new.ROWID;
END;

CREATE TABLE IF NOT EXISTS SUPPLIER (
    SUPPLIER_ID       TEXT PRIMARY KEY ,
    SUPPLIER_NAME     VARCHAR(50) NOT NULL ,
    CONTACT_NO        TEXT NOT NULL,
    ADDRESS           TEXT         NOT NULL ,
    EMAIL             TEXT         NOT NULL,
    CREATE_DATE       DATETIME NOT NULL ON CONFLICT REPLACE DEFAULT CURRENT_TIMESTAMP
);

CREATE TRIGGER IF NOT EXISTS createSUPPLIER
    AFTER INSERT
    ON SUPPLIER
BEGIN
    UPDATE SUPPLIER
    SET SUPPLIER_ID = PRINTF('SP%05d', new.oid)
    WHERE oid = new.ROWID;
END;

CREATE TABLE IF NOT EXISTS PURCHASE_ORDER (
    PURCHASE_ORDER_NUMBER TEXT    ,
    SUPPLIER_ID           TEXT   ,
    PRODUCT_ID            TEXT   ,
    QUANTITY              INT     NOT NULL,
    ORDER_DATE            DATE    ,
    PRICE                 INT     ,
    STATUS                TEXT    ,
    PRIMARY KEY (PURCHASE_ORDER_NUMBER, SUPPLIER_ID, PRODUCT_ID),
    FOREIGN KEY (SUPPLIER_ID) REFERENCES SUPPLIER (SUPPLIER_ID),
    FOREIGN KEY (PRODUCT_ID) REFERENCES PRODUCT (PRODUCT_ID)
);

CREATE TRIGGER IF NOT EXISTS createPURCHASE_ORDER
    AFTER INSERT
    ON PURCHASE_ORDER
BEGIN
    UPDATE PURCHASE_ORDER
    SET  PURCHASE_ORDER_NUMBER = PRINTF('PO%05d', new.oid)
    WHERE oid = new.ROWID;
END;

CREATE TABLE IF NOT EXISTS BRANCH (
    BRANCH_ID  TEXT PRIMARY KEY ,
    Location   TEXT NOT NULL,
    CONTACT_NO  VARCHAR(50)  NOT NULL,
    MANAGER VARCHAR(50)  NOT NULL,
    DATE   DATETIME NOT NULL DEFAULT (DATE('now'))
);

CREATE TRIGGER IF NOT EXISTS createBRANCH
    AFTER INSERT
    ON BRANCH
BEGIN
    UPDATE BRANCH
    SET  BRANCH_ID = PRINTF('BR%05d', new.oid)
    WHERE oid = new.ROWID;
END;


CREATE TABLE IF NOT EXISTS RETURN_ORDER (
    RETURN_ID     TEXT ,
    SUPPLIER_ID   TEXT NOT NULL,
    PRODUCT_ID    TEXT NOT NULL,
    QUANTITY      INT  NOT NULL,
    RETURN_DATE   DATETIME NOT NULL DEFAULT (DATE('now')),
    RETURN_REASON VARCHAR(200),
    PRIMARY KEY (RETURN_ID, SUPPLIER_ID, PRODUCT_ID),
    FOREIGN KEY (SUPPLIER_ID) REFERENCES SUPPLIER (SUPPLIER_ID),
    FOREIGN KEY (PRODUCT_ID) REFERENCES PRODUCT (PRODUCT_ID)
);

CREATE TRIGGER IF NOT EXISTS createRETURN_ORDER
    AFTER INSERT
    ON RETURN_ORDER
BEGIN
    UPDATE RETURN_ORDER
    SET  RETURN_ID= PRINTF('RO%05d', new.oid)
    WHERE oid = new.ROWID;
END;


CREATE TABLE IF NOT EXISTS STOCK_TRANSFER (
    TRANSFER_ID       TEXT,
    PRODUCT_ID        TEXT  NOT NULL,
    BRANCH_ID       TEXT NOT NULL,
    TRANSFER_QUANTITY INT  NOT NULL,
    REQUEST_DATE     DATE NOT NULL,
    STATUS           TEXT NOT NULL,
    PRIMARY KEY (TRANSFER_ID),
    FOREIGN KEY (PRODUCT_ID) REFERENCES PRODUCT (PRODUCT_ID),
    FOREIGN KEY (BRANCH_ID) REFERENCES BRANCH (BRANCH_ID)
);
CREATE TRIGGER IF NOT EXISTS createRequestID
    AFTER INSERT
    ON STOCK_TRANSFER
BEGIN
    UPDATE STOCK_TRANSFER
    SET  TRANSFER_ID= PRINTF('TR%05d', new.oid)
    WHERE oid = new.ROWID;
END;

/*Product*/
INSERT INTO PRODUCT
(PRODUCT_TYPE, PRODUCT_NAME, PRODUCT_PRICE, PRODUCT_QUANTITY)
VALUES
    ('Rod', 'Spinning Rod', 150.00, 10),
    ('Rod', 'Casting Rod', 120.00, 15),
    ('Reel', 'Spinning Reel', 75.00, 20),
    ('Reel', 'Bait casting Reel', 85.00, 12),
    ('Line', 'Braided Line', 25.00, 50),
    ('Line', 'Mono filament Line', 15.00, 60),
    ('Lure', 'Crank bait', 8.50, 100),
    ('Lure', 'Spinner bait', 7.00, 80),
    ('Accessory', 'Fishing Pliers', 12.00, 25),
    ( 'Accessory', 'Tackle Box', 45.00, 30);


/*Supplier */

INSERT INTO SUPPLIER
(SUPPLIER_NAME, CONTACT_NO, ADDRESS, EMAIL)
VALUES
    ('Global Supplies Inc.', '212-555-1234', '123 Main St, New York, NY 10001', 'contact@globalsupplies.com'),
    ('West Coast Distributors', '323-555-5678', '456 Sunset Blvd, Los Angeles, CA 90001', 'info@westcoastdist.com'),
    ('Midwest Supply Co.', '312-555-8765', '789 Michigan Ave, Chicago, IL 60601', 'sales@midwestsupply.com'),
    ('Lone Star Suppliers', '713-555-2345', '321 Bay Area Blvd, Houston, TX 77001', 'support@lonestarsuppliers.com'),
    ('Desert Wholesale', '602-555-6789', '654 Grand Ave, Phoenix, AZ 85001', 'contact@desertwholesale.com'),
    ('East Coast Supplies', '215-555-3456', '987 Chestnut St, Philadelphia, PA 19101', 'info@eastcoastsupplies.com'),
    ('Alamo Suppliers', '210-555-9876', '543 Alamo Plaza, San Antonio, TX 78201', 'sales@alamosuppliers.com'),
    ('Harbor Distributors', '619-555-6543', '876 Harbor Dr, San Diego, CA 92101', 'support@harbordist.com'),
    ('Metro Supplies', '214-555-7654', '210 Elm St, Dallas, TX 75201', 'contact@metrosupplies.com'),
    ('Silicon Valley Distributors', '408-555-4321', '432 Market St, San Jose, CA 95101', 'info@siliconvalleydist.com');


/*Branch*/
INSERT INTO BRANCH
(Location, CONTACT_NO, MANAGER)
VALUES
    ('New York', '123-456-7890', 'John Doe'),
    ('Los Angeles', '987-654-3210', 'Jane Smith'),
    ('Chicago', '555-123-4567', 'Michael Brown');

/*Purchase Order */
INSERT INTO PURCHASE_ORDER
(SUPPLIER_ID, PRODUCT_ID, QUANTITY, ORDER_DATE, PRICE, STATUS)
VALUES
    ('SP00001', 'P00008', 326, '2024-07-09', 2608, 'Completed'),
    ('SP00003', 'P00004', 174, '2024-07-13', 1740, 'Completed'),
    ('SP00002', 'P00006', 385, '2024-07-26', 2310, 'Completed'),
    ('SP00003', 'P00010', 324, '2024-08-04', 1944, 'Completed'),
    ('SP00002', 'P00001', 185, '2024-08-16', 1480, 'Completed'),
    ('SP00003', 'P00003', 269, '2024-08-29', 1345, 'Pending'),
    ('SP00001', 'P00009', 175, '2024-09-01', 1575, 'Pending'),
    ('SP00003', 'P00002', 130, '2024-09-08', 0, 'Pending'),
    ('SP00001', 'P00008', 301, '2024-09-14', 0, 'Pending'),
    ('SP00002', 'P00001', 136, '2024-09-20', 0, 'Pending');

/*Stock Transfer*/
INSERT INTO STOCK_TRANSFER
(PRODUCT_ID, BRANCH_ID, TRANSFER_QUANTITY, REQUEST_DATE, STATUS)
VALUES
    ('P00001', 'BR00001', 31, '2024-06-13', 'Completed'),
    ('P00003', 'BR00002', 89, '2024-06-21', 'Completed'),
    ('P00006', 'BR00001', 90, '2024-07-03', 'Completed'),
    ('P00002', 'BR00001', 23, '2024-07-20', 'Completed'),
    ('P00002', 'BR00004', 56, '2024-07-29', 'Completed'),
    ('P00005', 'BR00004', 44, '2024-08-02', 'Completed'),
    ('P00008', 'BR00003', 50, '2024-08-15', 'Confirmed'),
    ('P00002', 'BR00002', 20, '2024-08-27', 'Confirmed'),
    ('P00007', 'BR00002', 100, '2024-09-09', 'Pending'),
    ('P00004', 'BR00003', 31, '2024-09-12', 'Pending'),
    ('P00009', 'BR00003', 10, '2024-09-13', 'Pending'),
    ('P00010', 'BR00003', 50, '2024-09-14', 'Pending');

/*RETURN_ORDER*/
INSERT INTO RETURN_ORDER (SUPPLIER_ID, PRODUCT_ID, QUANTITY, RETURN_REASON) VALUES ('SP00002', 'P00003', 28, 'Incorrect shipment');
INSERT INTO RETURN_ORDER (SUPPLIER_ID, PRODUCT_ID, QUANTITY, RETURN_REASON) VALUES ('SP00003', 'P00002', 5, 'Incorrect shipment');
INSERT INTO RETURN_ORDER (SUPPLIER_ID, PRODUCT_ID, QUANTITY, RETURN_REASON) VALUES ('SP00001', 'P00002', 52, 'Expired product');
INSERT INTO RETURN_ORDER (SUPPLIER_ID, PRODUCT_ID, QUANTITY, RETURN_REASON) VALUES ('SP00002', 'P00003', 73, 'Overstock');
INSERT INTO RETURN_ORDER (SUPPLIER_ID, PRODUCT_ID, QUANTITY, RETURN_REASON) VALUES ('SP00001', 'P00001', 75, 'Damaged product');
INSERT INTO RETURN_ORDER (SUPPLIER_ID, PRODUCT_ID, QUANTITY, RETURN_REASON) VALUES ('SP00001', 'P00002', 37, 'Expired product');
INSERT INTO RETURN_ORDER (SUPPLIER_ID, PRODUCT_ID, QUANTITY, RETURN_REASON) VALUES ('SP00001', 'P00005', 95, 'Damaged product');
INSERT INTO RETURN_ORDER (SUPPLIER_ID, PRODUCT_ID, QUANTITY, RETURN_REASON) VALUES ('SP00002', 'P00002', 6, 'Overstock');
INSERT INTO RETURN_ORDER (SUPPLIER_ID, PRODUCT_ID, QUANTITY, RETURN_REASON) VALUES ('SP00002', 'P00002', 29, 'Overstock');
INSERT INTO RETURN_ORDER (SUPPLIER_ID, PRODUCT_ID, QUANTITY, RETURN_REASON) VALUES ('SP00001', 'P00002', 93, 'Expired product');

/*Inventory Manager*/
INSERT INTO InventoryManager (PASSWORD, NAME, AGE, GENDER, PHONE) VALUES ('pass123', 'John Doe', 29, 'Male', '019-4719766');

/*STAFF*/
INSERT INTO STAFF (PASSWORD, NAME, AGE, GENDER, PHONE, POSITION)
VALUES
    ('pass123', 'John Doe', 30, 'Male', '019-1234567', 'Inventory Clerk'),
    ('pass124', 'Jane Smith', 25, 'Female', '019-2345678', 'Warehouse Staff'),
    ('pass125', 'Bob Johnson', 40, 'Male', '019-3456789', 'Logistics Coordinator'),
    ('pass126', 'Alice Brown', 28, 'Female', '019-4567890', 'Inventory Clerk'),
    ('pass127', 'Tom White', 35, 'Male', '019-5678901', 'Warehouse Staff'),
    ('pass128', 'Lucy Black', 32, 'Female', '019-6789012', 'Logistics Coordinator'),
    ('pass129', 'Peter Green', 29, 'Male', '019-7890123', 'Inventory Clerk'),
    ('pass130', 'Emma Blue', 31, 'Female', '019-8901234', 'Warehouse Staff'),
    ('pass131', 'James Yellow', 38, 'Male', '019-9012345', 'Logistics Coordinator'),
    ('pass132', 'Lily Red', 26, 'Female', '019-0123456', 'Inventory Clerk');



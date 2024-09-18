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
    ('Midwest Supply Co.', '312-555-8765', '789 Michigan Ave, Chicago, IL 60601', 'sales@midwestsupply.com');


/*Branch*/
INSERT INTO BRANCH
    (Location, CONTACT_NO, MANAGER)
VALUES
    ('New York', '123-456-7890', 'John Doe'),
    ('Los Angeles', '987-654-3210', 'Jane Smith'),
    ('Chicago', '555-123-4567', 'Michael Brown'),
    ('Houston', '444-555-6666', 'Sarah Lee'),
    ('Phoenix', '777-888-9999', 'David Wilson'),
    ('Philadelphia', '222-333-4444', 'Emily Davis'),
    ('San Antonio', '999-888-7777', 'Chris Johnson'),
    ('San Diego', '666-555-4444', 'Patricia Miller'),
    ('Dallas', '111-222-3333', 'Robert Moore'),
    ('San Jose', '888-777-6666', 'Linda Anderson');

/*Purchase Order */
INSERT INTO PURCHASE_ORDER
    (SUPPLIER_ID, PRODUCT_ID, QUANTITY, ORDER_DATE, PRICE, STATUS)
VALUES
    ('SP00001', 'P00008', 326, DATE('now'), 2608, 'Pending'),
    ('SP00003', 'P00004', 174, DATE('now'), 1740, 'Completed'),
    ('SP00002', 'P00006', 385, DATE('now'), 2310, 'Completed'),
    ('SP00003', 'P00010', 324, DATE('now'), 1944, 'Pending'),
    ('SP00002', 'P00001', 185, DATE('now'), 1480, 'Completed'),
    ('SP00003', 'P00003', 269, DATE('now'), 1345, 'Pending'),
    ('SP00001', 'P00009', 175, DATE('now'), 1575, 'Pending'),
    ('SP00003', 'P00002', 130, DATE('now'), 910, 'Pending'),
    ('SP00001', 'P00008', 301, DATE('now'), 3010, 'Pending'),
    ('SP00002', 'P00001', 136, DATE('now'), 680, 'Pending');

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



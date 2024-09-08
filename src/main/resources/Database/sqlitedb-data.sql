/*Product*/
INSERT INTO PRODUCT
    (PRODUCT_TYPE, PRODUCT_NAME, PRODUCT_PRICE, PRODUCT_QUANTITY)
VALUES
    ('Fishing Rods', 'Carbon Fiber Rod', 199.99, 50),
    ('Fishing Reels', 'Spinning Reel', 79.99, 100),
    ('Fishing Lures', 'Topwater Frog', 12.99, 200),
    ('Fishing Lines', 'Braided Line', 24.99, 150),
    ('Fishing Nets', 'Landing Net', 29.99, 80),
    ('Fishing Apparel', 'Waterproof Jacket', 99.99, 120),
    ('Fishing Accessories', 'Tackle Box', 39.99, 300),
    ('Fishing Baits', 'Live Worms', 8.99, 500),
    ('Fishing Electronics', 'Fish Finder', 249.99, 30),
    ('Fishing Boats', 'Inflatable Kayak', 599.99, 10);

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
    ('SP00005', 'P00008', 326, DATE('now'), 2608, 'Pending'),
    ('SP00004', 'P00004', 174, DATE('now'), 1740, 'Completed'),
    ('SP00002', 'P00006', 385, DATE('now'), 2310, 'Completed'),
    ('SP00009', 'P00010', 324, DATE('now'), 1944, 'Pending'),
    ('SP00002', 'P00001', 185, DATE('now'), 1480, 'Completed'),
    ('SP00010', 'P00003', 269, DATE('now'), 1345, 'Cancelled'),
    ('SP00007', 'P00009', 175, DATE('now'), 1575, 'Pending'),
    ('SP00003', 'P00002', 130, DATE('now'), 910, 'Shipped'),
    ('SP00001', 'P00008', 301, DATE('now'), 3010, 'Pending'),
    ('SP00004', 'P00001', 136, DATE('now'), 680, 'Cancelled');



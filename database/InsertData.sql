use inventory;

-- SET FOREIGN_KEY_CHECKS = 0;
-- TRUNCATE table location; 
-- TRUNCATE table product;
-- TRUNCATE table producspec;
-- TRUNCATE table size;
-- TRUNCATE table store;
-- SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO `inventory`.`location` (`Name`) VALUES ("USA");
INSERT INTO `inventory`.`location` (`Name`) VALUES ("Ireland");
INSERT INTO `inventory`.`location` (`Name`) VALUES ("Netherlands");
INSERT INTO `inventory`.`location` (`Name`) VALUES ("Dubai");
INSERT INTO `inventory`.`location` (`Name`) VALUES ("Australia");
INSERT INTO `inventory`.`location` (`Name`) VALUES ("Italy");
INSERT INTO `inventory`.`location` (`Name`) VALUES ("Pakistan");
INSERT INTO `inventory`.`location` (`Name`) VALUES ("Mexico");

INSERT INTO `inventory`.`size` (`SizeName`) VALUES ("10 ml");
INSERT INTO `inventory`.`size` (`SizeName`) VALUES ("20 ml");
INSERT INTO `inventory`.`size` (`SizeName`) VALUES ("30 ml");
INSERT INTO `inventory`.`size` (`SizeName`) VALUES ("Small");
INSERT INTO `inventory`.`size` (`SizeName`) VALUES ("Large");

INSERT INTO `inventory`.`store` (`StoreType`, `Name`, `Location_LocationId`) VALUES ('W', 'Warehouse1', 1);
INSERT INTO `inventory`.`store` (`StoreType`, `Name`, `Location_LocationId`) VALUES ('W', 'Warehouse2', 1);
INSERT INTO `inventory`.`store` (`StoreType`, `Name`, `Location_LocationId`) VALUES ('W', 'Warehouse3', 1);
INSERT INTO `inventory`.`store` (`StoreType`, `Name`, `Location_LocationId`) VALUES ('W', 'Warehouse4', 2);
INSERT INTO `inventory`.`store` (`StoreType`, `Name`, `Location_LocationId`) VALUES ('W', 'Warehouse5', 2);
INSERT INTO `inventory`.`store` (`StoreType`, `Name`, `Location_LocationId`) VALUES ('O', 'Office1', 7);

INSERT INTO `inventory`.`product`(`Name`, `Size_SizeId`, `Store_StoreId`, `InStock`, `AvailableQuantity`, `InTransit`, `Type`, `MinimumOrderQuantity`, `QuantityPerBox`, 
`ReorderPoint`) VALUES ('ProductA', 1, 1, 10, 8, 5, 'FP', 50, 6, 15);

INSERT INTO `inventory`.`product`(`Name`, `Size_SizeId`, `Store_StoreId`, `InStock`, `AvailableQuantity`, `InTransit`, `Type`, `MinimumOrderQuantity`, `QuantityPerBox`,
`ReorderPoint`) VALUES ('ProductA', 2, 2, 900, 100, 1000, 'FP', 1000, 12, 100);

INSERT INTO `inventory`.`product`(`Name`, `Size_SizeId`, `Store_StoreId`, `InStock`, `AvailableQuantity`, `InTransit`, `Type`, `MinimumOrderQuantity`, `QuantityPerBox`,
`ReorderPoint`) VALUES ('ProductA', 3, 3, 150, 90, 80, 'FP', 50, 36, 45);

INSERT INTO `inventory`.`product`(`Name`, `Size_SizeId`, `Store_StoreId`, `InStock`, `AvailableQuantity`, `InTransit`, `Type`, `MinimumOrderQuantity`, `QuantityPerBox`,
`ReorderPoint`) VALUES ('ProductA', 1, 3, 100, 50, 30, 'FP', 45, 50, 100);

INSERT INTO `inventory`.`product`(`Name`, `Size_SizeId`, `Store_StoreId`, `InStock`, `AvailableQuantity`, `InTransit`, `Type`, `MinimumOrderQuantity`, `QuantityPerBox`,
`ReorderPoint`) VALUES ('ProductA', 3, 2, 40, 32, 12, 'FP', 34, 43, 9);

INSERT INTO `inventory`.`product`(`Name`, `Size_SizeId`, `Store_StoreId`, `InStock`, `AvailableQuantity`, `InTransit`, `Type`, `MinimumOrderQuantity`, `QuantityPerBox`,
`ReorderPoint`) VALUES ('ProductA', 1, 4, 10, 7, 5, 'FP', 1, 4, 6);

INSERT INTO `inventory`.`product`(`Name`, `Size_SizeId`, `Store_StoreId`, `InStock`, `AvailableQuantity`, `InTransit`, `Type`, `MinimumOrderQuantity`, `QuantityPerBox`,
`ReorderPoint`) VALUES ('ProductA', 3, 4, 100, 100, 0, 'FP', 5, 36, 10);

INSERT INTO `inventory`.`product`(`Name`, `Size_SizeId`, `Store_StoreId`, `InStock`, `AvailableQuantity`, `InTransit`, `Type`, `MinimumOrderQuantity`, `QuantityPerBox`,
`ReorderPoint`) VALUES ('ProductA', 1, 5, 10, 0, 100, 'FP', 10, 8, 10);


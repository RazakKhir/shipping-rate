/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping structure for table shipping_rate.txn_shipping_rate_info
DROP TABLE IF EXISTS `txn_shipping_rate_info`;
CREATE TABLE IF NOT EXISTS `txn_shipping_rate_info`
(
    `shipRateId`     BINARY(16)  NOT NULL,
    `shippingTo`     VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
    `shippingType`   VARCHAR(5)  NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
    `senderPostcode` VARCHAR(5)  NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
    PRIMARY KEY (`shipRateId`) USING BTREE
) COLLATE = 'utf8mb4_0900_ai_ci'
  ENGINE = InnoDB;

-- Data exporting was unselected.

/*!40101 SET SQL_MODE = IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS = IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
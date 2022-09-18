tee sql/run-shipping-rate-results.log;

select 'shipping_rate' AS '' , now() as '';

drop database if exists shipping_rate;
CREATE DATABASE IF NOT EXISTS `shipping_rate` CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
use shipping_rate;

source sql/schema/txn_shipping_rate_info.sql;
source sql/schema/txn_shipping_rate_detail.sql;